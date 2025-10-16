package com.kukuchta.diabetool.presentation.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.kukuchta.diabetool.R; // make sure R resolves to your app's R
import com.kukuchta.diabetool.presentation.main.chart.ChartSyncController;
import com.kukuchta.diabetool.presentation.main.chart.PreviewOverlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * MainFragment — updated to use a main LineChart + PreviewChart beneath.
 * Wiring:
 *  - mainChart: interactive (zoom/pan)
 *  - previewChart: full 24h overview with draggable overlay box
 *  - ChartGestureSyncListener keeps preview updated from main gestures
 *  - PreviewChart drag moves the main chart viewport
 *
 * Note: adapt styling or dataset filling to your SensorReading -> Entry mapping.
 */
public class MainFragment extends Fragment {

    private LineChart mainChart;
    private LineChart previewChart;
    private PreviewOverlay overlay;
    private ChartSyncController controller;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainChart = view.findViewById(R.id.mainChart);
        previewChart = view.findViewById(R.id.previewChart);
        overlay = view.findViewById(R.id.previewOverlay);

        setupCharts();
        controller = new ChartSyncController(mainChart, previewChart, overlay);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up references to avoid leaks
        controller = null;
        mainChart = null;
        previewChart = null;
        overlay = null;
    }

    private void setupCharts() {
        // initial demo dataset: if you have SensorReading -> Entry mapping, replace this
        List<Entry> initialEntries = generateDemoInitialEntries();

        LineDataSet mainSet = new LineDataSet(initialEntries, "data");
        mainSet.setDrawValues(false);
        mainSet.setDrawCircles(false);

        // For preview we reuse the same logical dataset — preview drawing is lightweight.
        LineDataSet previewSet = new LineDataSet(new ArrayList<>(initialEntries), "preview");
        previewSet.setDrawValues(false);
        previewSet.setDrawCircles(false);

        mainChart.setData(new LineData(mainSet));
        previewChart.setData(new LineData(previewSet));

        // Styling for preview chart (optional)
        previewChart.getAxisLeft().setEnabled(false);
        previewChart.getAxisRight().setEnabled(false);
        previewChart.getXAxis().setDrawLabels(false);
        previewChart.getXAxis().setDrawGridLines(false);
        previewChart.getLegend().setEnabled(false);
        previewChart.getDescription().setEnabled(false);
    }

    private List<Entry> generateDemoInitialEntries() {
        // This generates sample points at integer hours from 0..24
        Random rnd = new Random();
        List<Entry> list = new ArrayList<>();
        for (int h = 0; h <= 24; h++) {
            list.add(new Entry(h, rnd.nextFloat() * 10f));
        }
        return list;
    }
}
