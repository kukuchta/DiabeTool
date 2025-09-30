package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class Meal {
    private final Date timestamp;
    private final int carbs; // in grams
    private final boolean isManualEntry;

    public Meal(Date timestamp, int carbs, boolean isManualEntry) {
        this.timestamp = timestamp;
        this.carbs = carbs;
        this.isManualEntry = isManualEntry;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getCarbs() {
        return carbs;
    }

    public boolean isManualEntry() {
        return isManualEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return carbs == meal.carbs &&
                isManualEntry == meal.isManualEntry &&
                Objects.equals(timestamp, meal.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, carbs, isManualEntry);
    }

    @NonNull
    @Override
    public String toString() {
        return "Meal{" +
                "timestamp=" + timestamp +
                ", carbs=" + carbs +
                ", isManualEntry=" + isManualEntry +
                '}';
    }
}
