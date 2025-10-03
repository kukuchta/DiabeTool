package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.ACTIVITY_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class InsulinActivity {
    private final Date timestamp;
    private final double value; // A measure of insulin effectiveness

    public InsulinActivity(Date timestamp, double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsulinActivity that = (InsulinActivity) o;
        return Math.abs(that.value - value) < ACTIVITY_EPSILON
                && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, value);
    }

    @NonNull
    @Override
    public String toString() {
        return "InsulinActivity{" +
                "timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
