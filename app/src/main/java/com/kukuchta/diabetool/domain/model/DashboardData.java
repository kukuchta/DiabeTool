package com.kukuchta.diabetool.domain.model;

import java.util.Collections;
import java.util.List;

// Define a simple wrapper class for dashboard data
public class DashboardData {
    public final SensorReading latestSensorReading;
    public final IoB currentIoB;
    public final List<Meal> recentMeals;
    // Add other relevant data fields

    public DashboardData(SensorReading latestSensorReading, IoB currentIoB, List<Meal> recentMeals) {
        this.latestSensorReading = latestSensorReading;
        this.currentIoB = currentIoB;
        this.recentMeals = recentMeals != null ? recentMeals : Collections.emptyList();
    }
}