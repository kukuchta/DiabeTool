package com.kukuchta.diabetool.domain.model;

import static com.kukuchta.diabetool.utils.Constants.IOB_EPSILON;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class IoB {
    private final Date timestamp;
    private final double amount; // in units (IoB)

    public IoB(Date timestamp, double amount) {
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IoB that = (IoB) o;
        return Math.abs(that.amount - amount) < IOB_EPSILON &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, amount);
    }

    @NonNull
    @Override
    public String toString() {
        return "IoB{" +
                "timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}
