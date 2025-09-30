package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class Bolus {
    private final Date timestamp;
    private final double units; // e.g., 12.5j
    private final boolean isManualEntry;

    public Bolus(Date timestamp, double units, boolean isManualEntry) {
        this.timestamp = timestamp;
        this.units = units;
        this.isManualEntry = isManualEntry;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getUnits() {
        return units;
    }

    public boolean isManualEntry() {
        return isManualEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bolus bolus = (Bolus) o;
        return Math.abs(bolus.units - units) < INSULIN_EPSILON &&
                isManualEntry == bolus.isManualEntry &&
                Objects.equals(timestamp, bolus.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, units, isManualEntry);
    }

    @NonNull
    @Override
    public String toString() {
        return "Bolus{" +
                "timestamp=" + timestamp +
                ", units=" + units +
                ", isManualEntry=" + isManualEntry +
                '}';
    }
}
