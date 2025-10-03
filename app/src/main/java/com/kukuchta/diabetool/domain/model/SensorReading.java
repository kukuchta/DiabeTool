package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class SensorReading {
    private final Date timestamp;
    private final int value; // in mg/dl

    public SensorReading(Date timestamp, int value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorReading that = (SensorReading) o;
        return value == that.value && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, value);
    }

    @NonNull
    @Override
    public String toString() {
        return "SensorReading{" +
                "timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}
