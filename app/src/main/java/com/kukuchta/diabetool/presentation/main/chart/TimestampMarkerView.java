package com.kukuchta.diabetool.presentation.main.chart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.kukuchta.diabetool.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Custom MarkerView to display the timestamp in HH:mm format when a chart entry is highlighted.
 */
@SuppressLint("ViewConstructor")
public class TimestampMarkerView extends MarkerView {

    private final TextView tvContent;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

    public TimestampMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        // Find the TextView in the custom layout
        tvContent = findViewById(R.id.tvContent);
    }

    // This method is called every time the MarkerView is redrawn
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        // The x-value of the entry is the timestamp in milliseconds
        long timestamp = (long) e.getX();
        // Format the timestamp and the glucose value
        tvContent.setText(String.format(Locale.getDefault(), "%s: %d", dateFormat.format(new Date(timestamp)), (int)e.getY()));
        super.refreshContent(e, highlight);
    }

    // This controls the offset of the marker view, so it appears above the highlighted point
    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2f), -getHeight());
    }
}
