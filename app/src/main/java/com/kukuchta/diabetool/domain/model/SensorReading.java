package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class SensorReading {
    private final Date timestamp;
    private final int glucoseLevel; // in mg/dl

    public SensorReading(Date timestamp, int glucoseLevel) {
        this.timestamp = timestamp;
        this.glucoseLevel = glucoseLevel;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getGlucoseLevel() {
        return glucoseLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorReading that = (SensorReading) o;
        return glucoseLevel == that.glucoseLevel && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, glucoseLevel);
    }

    @NonNull
    @Override
    public String toString() {
        return "SensorReading{" +
                "timestamp=" + timestamp +
                ", glucoseLevel=" + glucoseLevel +
                '}';
    }
}
