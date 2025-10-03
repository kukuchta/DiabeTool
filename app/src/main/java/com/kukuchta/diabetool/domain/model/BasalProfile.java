package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

// Represents the overall basal insulin profile for 24 hours
public class BasalProfile {
    private final List<BasalRate> rates; // List of 30-minute slots

    public BasalProfile(List<BasalRate> rates) {
        this.rates = rates;
    }

    public List<BasalRate> getRates() {
        return rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasalProfile that = (BasalProfile) o;
        return Objects.equals(rates, that.rates);
        // TODO Better basal rates equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(rates);
    }

    @NonNull
    @Override
    public String toString() {
        return "BasalProfile{" +
                "rates=" + rates +
                '}';
    }
}
