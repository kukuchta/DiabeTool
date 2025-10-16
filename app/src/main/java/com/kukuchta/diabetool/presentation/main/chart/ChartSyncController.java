package com.kukuchta.diabetool.presentation.main.chart;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Synchronizes a zoomable, pannable main LineChart with a full-range preview chart
 * and an overlay rectangle showing the visible range.
 */
public class ChartSyncController {

    private final LineChart mainChart;
    private final LineChart previewChart;
    private final PreviewOverlay overlay;

    private enum UpdateSource { NONE, MAIN, PREVIEW }
    private volatile UpdateSource updateSource = UpdateSource.NONE;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private boolean frameScheduled = false;

    public ChartSyncController(LineChart mainChart, LineChart previewChart, PreviewOverlay overlay) {
        this.mainChart = mainChart;
        this.previewChart = previewChart;
        this.overlay = overlay;

        configureCharts();
        attachListeners();

        // Initial synchronization
        updatePreviewRectFromMain();
    }

    // -------------------------------------------------------------------------
    // Chart configuration
    // -------------------------------------------------------------------------
    private void configureCharts() {
        // Preview chart: fixed overview, no gestures
        previewChart.setScaleEnabled(false);
        previewChart.setDragEnabled(false);
        previewChart.setTouchEnabled(false);
        previewChart.setDoubleTapToZoomEnabled(false);

        // Main chart: allow horizontal pan and zoom only
        mainChart.setDragEnabled(true);
        mainChart.setScaleXEnabled(true);
        mainChart.setScaleYEnabled(false);
        mainChart.setDoubleTapToZoomEnabled(false);
    }

    // -------------------------------------------------------------------------
    // Edge detection helpers
    // -------------------------------------------------------------------------
    private boolean isMainChartAtRightEdge() {
        ViewPortHandler vp = mainChart.getViewPortHandler();
        float contentWidth = vp.contentWidth() * vp.getScaleX();
        float chartWidth = vp.getChartWidth();
        float transX = vp.getTransX();
        float rightLimit = chartWidth - contentWidth;
        return transX <= rightLimit + 1f; // 1px tolerance
    }

    private boolean isMainChartAtLeftEdge() {
        ViewPortHandler vp = mainChart.getViewPortHandler();
        float transX = vp.getTransX();
        return transX >= -1f; // 1px tolerance
    }

    // -------------------------------------------------------------------------
    // Gesture listeners
    // -------------------------------------------------------------------------
    private void attachListeners() {
        // Main chart gestures
        mainChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture gesture) { }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture gesture) {
                if (updateSource == UpdateSource.MAIN) {
                    updateSource = UpdateSource.NONE;
                }
                updatePreviewRectFromMain(); // ensure sync after clamping
            }

            @Override public void onChartLongPressed(MotionEvent me) { }
            @Override public void onChartDoubleTapped(MotionEvent me) { }
            @Override public void onChartSingleTapped(MotionEvent me) { }
            @Override public void onChartFling(MotionEvent me1, MotionEvent me2, float vX, float vY) { }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
                if (updateSource == UpdateSource.PREVIEW) return;
                updateSource = UpdateSource.MAIN;
                updatePreviewRectFromMain();
            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                if (updateSource == UpdateSource.PREVIEW) return;
                updateSource = UpdateSource.MAIN;

                boolean atRight = isMainChartAtRightEdge();
                boolean atLeft = isMainChartAtLeftEdge();

                // Prevent overscroll update
                if ((atRight && dX < 0) || (atLeft && dX > 0)) return;

                updatePreviewRectFromMain();
            }
        });

        // Overlay drag → pan main chart
        overlay.setDragListener(new PreviewOverlay.DragListener() {
            @Override
            public void onDragStart() {
                // Disable chart's drag deceleration so it won't continue flinging
                mainChart.setDragDecelerationEnabled(false);

                // Dispatch a synthetic touch event to interrupt any ongoing fling / deceleration.
                // ACTION_DOWN works well to interrupt internal velocity handling.
                long now = SystemClock.uptimeMillis();
                MotionEvent ev = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN, 0f, 0f, 0);
                mainChart.dispatchTouchEvent(ev);
                ev.recycle();

                // mark preview as origin so main->preview updates are ignored while we drag
                updateSource = UpdateSource.PREVIEW;
            }

            @Override
            public void onDrag(float dxPx) {
                handleOverlayDrag(dxPx);
            }

            @Override
            public void onDragEnd() {
                // Clear preview origin
                updateSource = UpdateSource.NONE;

                // Sync final precise rectangle from real viewport
                updatePreviewRectFromMain();

                // Re-enable deceleration after a short delay so the moveViewToX() operations settle.
                // Adjust the delay to match your device / feel (50..200 ms).
                mainHandler.postDelayed(() -> mainChart.setDragDecelerationEnabled(true), 80L);
            }
        });
    }

    // -------------------------------------------------------------------------
    // Overlay drag logic
    // -------------------------------------------------------------------------
    private void handleOverlayDrag(float dxPx) {
        float dataMin = previewChart.getXChartMin();
        float dataMax = previewChart.getXChartMax();
        float totalRange = dataMax - dataMin;
        if (totalRange <= 0f) return;

        float previewW = Math.max(1f, overlay.getWidth());
        float dataDx = dxPx / previewW * totalRange;

        float visibleStart = mainChart.getLowestVisibleX();
        float visibleEnd = mainChart.getHighestVisibleX();
        float visibleSpan = visibleEnd - visibleStart;
        if (visibleSpan <= 0f) return;

        // Compute the new start of the main chart range
        float newStart = visibleStart + dataDx;
        newStart = Math.max(dataMin, Math.min(newStart, dataMax - visibleSpan));

        // --- Immediate overlay update (predictive) ---
        float leftPx = ((newStart - dataMin) / totalRange) * previewW;
        float rightPx = ((newStart + visibleSpan - dataMin) / totalRange) * previewW;
        overlay.setRectLeftPx(leftPx);
        overlay.setRectRightPx(rightPx);
        overlay.invalidate();

        // --- Move the main chart asynchronously ---
        mainChart.moveViewToX(newStart);
    }

    // -------------------------------------------------------------------------
    // Core synchronization logic
    // -------------------------------------------------------------------------
    private void updatePreviewRectFromMain() {
        if (updateSource == UpdateSource.PREVIEW) return;

        float dataMin = previewChart.getXChartMin();
        float dataMax = previewChart.getXChartMax();
        float totalRange = dataMax - dataMin;
        int previewPixelW = Math.max(1, overlay.getWidth());

        if (totalRange <= 0f) {
            overlay.setRectLeftPx(0f);
            overlay.setRectRightPx(previewPixelW);
            return;
        }

        float visibleStart = mainChart.getLowestVisibleX();
        float visibleEnd = mainChart.getHighestVisibleX();

        float leftPx = ((visibleStart - dataMin) / totalRange) * previewPixelW;
        float rightPx = ((visibleEnd - dataMin) / totalRange) * previewPixelW;

        float clampedLeft = Math.max(0f, Math.min(leftPx, previewPixelW));
        float clampedRight = Math.max(0f, Math.min(rightPx, previewPixelW));
        if (clampedRight < clampedLeft) {
            float t = clampedLeft;
            clampedLeft = clampedRight;
            clampedRight = t;
        }

        if (!frameScheduled) {
            frameScheduled = true;
            float finalLeft = clampedLeft;
            float finalRight = clampedRight;
            overlay.postOnAnimation(() -> {
                overlay.setRectLeftPx(finalLeft);
                overlay.setRectRightPx(finalRight);
                frameScheduled = false;
            });
        }
    }
}
