package com.kukuchta.diabetool.presentation.main.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PreviewOverlay extends View {

    private final Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final RectF rect = new RectF();

    // public pixel coordinates of the rectangle (0 .. previewWidth)
    private volatile float rectLeftPx = 0f;
    private volatile float rectRightPx = 0f;

    // Drag callbacks
    public interface DragListener {
        void onDragStart();
        void onDrag(float dxPx);
        void onDragEnd();
    }
    private DragListener dragListener;

    private float lastX;
    private boolean dragging = false;
    private final float TOUCH_MARGIN_PX;

    public PreviewOverlay(Context context) {
        this(context, null);
    }

    public PreviewOverlay(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PreviewOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        rectPaint.setStyle(Paint.Style.STROKE);
        rectPaint.setStrokeWidth(4f * getResources().getDisplayMetrics().density);

        fillPaint.setStyle(Paint.Style.FILL);
        fillPaint.setAlpha(40);

        TOUCH_MARGIN_PX = 40f * getResources().getDisplayMetrics().density;
    }

    // Setters from controller
    public void setRectLeftPx(float left) {
        rectLeftPx = left;
        postInvalidateOnAnimation();
    }

    public void setRectRightPx(float right) {
        rectRightPx = right;
        postInvalidateOnAnimation();
    }

    public float getRectLeftPx() { return rectLeftPx; }
    public float getRectRightPx() { return rectRightPx; }

    public void setDragListener(DragListener l) {
        this.dragListener = l;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float left = Math.max(0f, Math.min(rectLeftPx, width));
        float right = Math.max(0f, Math.min(rectRightPx, width));
        // ensure not inverted
        if (right < left) {
            float t = left; left = right; right = t;
        }
        rect.set(left, 0f, right, getHeight());
        canvas.drawRect(rect, fillPaint);
        canvas.drawRect(rect, rectPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                // Only start dragging if touch is inside (or near) the rectangle.
                if (x < rectLeftPx - TOUCH_MARGIN_PX || x > rectRightPx + TOUCH_MARGIN_PX) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                lastX = x;
                dragging = true;
                if (dragListener != null) dragListener.onDragStart();
                return true;

            case MotionEvent.ACTION_MOVE:
                if (!dragging) return false;
                float dx = x - lastX;
                lastX = x;

                if (dragListener != null) dragListener.onDrag(dx);
                return true;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (!dragging) return false;
                dragging = false;
                getParent().requestDisallowInterceptTouchEvent(false);
                if (dragListener != null) dragListener.onDragEnd();
                return true;
        }
        return super.onTouchEvent(ev);
    }
}