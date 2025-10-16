package com.kukuchta.diabetool.presentation.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.Random;

/**
 * MainViewModel — adapted to expose LiveData<Entry> used by MainFragment for new data.
 * I left the structure minimal so it will integrate with your existing CollectorManager / DI.
 *
 * If your original ViewModel already exposes sensorReadings flows, merge these helpers into it:
 *  - getLiveEntry()
 *  - trimOldEntries(LineDataSet)
 *  - isAutoScrollEnabled() / setAutoScrollEnabled(boolean)
 *
 * The demo generator is optional; remove or replace with your real data feed.
 */
public class MainViewModel extends ViewModel {

    private final MutableLiveData<Entry> liveEntry = new MutableLiveData<>();
    private float nextX = 24f;
    private final Random rnd = new Random();

    private final float dataWindowHours = 24f;
    private final float visibleHours = 3f;
    private boolean autoScrollEnabled = true;

    public LiveData<Entry> getLiveEntry() {
        return liveEntry;
    }

    /**
     * Demo helper — create the next point (call from fragment or scheduler).
     * Replace with your real sensor reading push.
     */
    public void generateNextPoint() {
        nextX += 0.5f; // e.g., a 30-minute step example
        float y = rnd.nextFloat() * 10f;
        Entry e = new Entry(nextX, y);
        liveEntry.postValue(e);
    }

    /**
     * Trim entries older than dataWindowHours from the provided dataset.
     * If your real data storage differs, implement trimming where suitable.
     */
    public void trimOldEntries(LineDataSet set) {
        float cutoff = nextX - dataWindowHours;
        while (set.getEntryCount() > 0 && set.getEntryForIndex(0).getX() < cutoff) {
            set.removeFirst();
        }
    }

    public float getVisibleHours() {
        return visibleHours;
    }

    public boolean isAutoScrollEnabled() {
        return autoScrollEnabled;
    }

    public void setAutoScrollEnabled(boolean enabled) {
        this.autoScrollEnabled = enabled;
    }
}
