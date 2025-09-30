package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.ACTIVITY_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class InsulinActivity {
    private final Date timestamp;
    private final double activityLevel; // A measure of insulin effectiveness

    public InsulinActivity(Date timestamp, double activityLevel) {
        this.timestamp = timestamp;
        this.activityLevel = activityLevel;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getActivityLevel() {
        return activityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsulinActivity that = (InsulinActivity) o;
        return Math.abs(that.activityLevel - activityLevel) < ACTIVITY_EPSILON
                && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, activityLevel);
    }

    @NonNull
    @Override
    public String toString() {
        return "InsulinActivity{" +
                "timestamp=" + timestamp +
                ", activityLevel=" + activityLevel +
                '}';
    }
}
