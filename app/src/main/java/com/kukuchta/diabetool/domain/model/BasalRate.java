package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

// Represents a single 30-minute slot for basal insulin
public class BasalRate {
    private final Date startTime; // Start of the 30-minute slot
    private final Date endTime;   // End of the 30-minute slot
    private final double rate;    // in units, e.g., 0.300j

    public BasalRate(Date startTime, Date endTime, double rate) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.rate = rate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasalRate basalRate = (BasalRate) o;
        return Math.abs(basalRate.rate - rate) < INSULIN_EPSILON &&
                Objects.equals(startTime, basalRate.startTime) &&
                Objects.equals(endTime, basalRate.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime, rate);
    }

    @NonNull
    @Override
    public String toString() {
        return "BasalRate{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", rate=" + rate +
                '}';
    }
}