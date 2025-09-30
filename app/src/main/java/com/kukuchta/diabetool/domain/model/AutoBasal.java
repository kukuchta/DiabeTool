package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class AutoBasal {
    private final Date timestamp; // Corresponds to a glucose reading time
    private final double basalValue; // The actual, unscaled auto basal value

    public AutoBasal(Date timestamp, double basalValue) {
        this.timestamp = timestamp;
        this.basalValue = basalValue;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getBasalValue() {
        return basalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoBasal autoBasal = (AutoBasal) o;
        return Math.abs(autoBasal.basalValue - basalValue) < INSULIN_EPSILON &&
                Objects.equals(timestamp, autoBasal.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, basalValue);
    }

    @NonNull
    @Override
    public String toString() {
        return "AutoBasal{" +
                "timestamp=" + timestamp +
                ", basalValue=" + basalValue +
                '}';
    }
}
