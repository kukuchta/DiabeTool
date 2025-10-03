package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Objects;

// Represents a single timeslot for basal insulin with given rate in basal profile
public class BasalRate {
    private final int endTime;    // in minutes after midnight
    private final double rate;    // in units per hour, e.g., 0.300j/h

    public BasalRate(int endTime, double rate) {
        this.endTime = endTime;
        this.rate = rate;
    }

    public int getEndTime() {
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
                endTime == basalRate.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endTime, rate);
    }

    @NonNull
    @Override
    public String toString() {
        return "BasalRate{" +
                "endTime=" + endTime +
                ", rate=" + rate +
                '}';
    }
}