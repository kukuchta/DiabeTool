package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.INSULIN_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class BasalInsulin {
    private final Date timestamp;
    private final BasalInsulinType type;
    private final double value;

    public BasalInsulin(Date timestamp, BasalInsulinType type, double value) {
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public BasalInsulinType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasalInsulin basalInsulin = (BasalInsulin) o;
        return Math.abs(basalInsulin.value - value) < INSULIN_EPSILON &&
                type == basalInsulin.type &&
                Objects.equals(timestamp, basalInsulin.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, type, value);
    }

    @NonNull
    @Override
    public String toString() {
        return "BasalInsulin{" +
                "timestamp=" + timestamp +
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}
