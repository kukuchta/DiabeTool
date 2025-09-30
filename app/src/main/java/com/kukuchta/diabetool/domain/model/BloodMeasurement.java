package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class BloodMeasurement {
    private final Date timestamp; // The time the measurement was taken
    private final int glucoseLevel; // in mg/dl
    private final boolean isManualEntry;

    public BloodMeasurement(Date timestamp, int glucoseLevel, boolean isManualEntry) {
        this.timestamp = timestamp;
        this.glucoseLevel = glucoseLevel;
        this.isManualEntry = isManualEntry;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getGlucoseLevel() {
        return glucoseLevel;
    }

    public boolean isManualEntry() {
        return isManualEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodMeasurement that = (BloodMeasurement) o;
        return glucoseLevel == that.glucoseLevel &&
                isManualEntry == that.isManualEntry &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, glucoseLevel, isManualEntry);
    }

    @NonNull
    @Override
    public String toString() {
        return "BloodMeasurement{" +
                "timestamp=" + timestamp +
                ", glucoseLevel=" + glucoseLevel +
                ", isManualEntry=" + isManualEntry +
                '}';
    }
}

