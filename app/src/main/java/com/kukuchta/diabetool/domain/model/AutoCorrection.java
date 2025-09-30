package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class AutoCorrection {
    private final Date timestamp; // Corresponds to a glucose reading time
    private final double correctionValue; // The actual, unscaled correction value

    public AutoCorrection(Date timestamp, double correctionValue) {
        this.timestamp = timestamp;
        this.correctionValue = correctionValue;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getCorrectionValue() {
        return correctionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoCorrection that = (AutoCorrection) o;
        return Math.abs(that.correctionValue - correctionValue) < INSULIN_EPSILON &&
                Objects.equals(timestamp, that.timestamp);}

    @Override
    public int hashCode() {        return Objects.hash(timestamp, correctionValue);
    }

    @NonNull
    @Override
    public String toString() {
        return "AutoCorrection{" +
                "timestamp=" + timestamp +
                ", correctionValue=" + correctionValue +
                '}';
    }
}

