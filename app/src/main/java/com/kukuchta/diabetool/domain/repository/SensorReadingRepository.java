package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.SensorReading;

import java.util.Date;
import java.util.List;

public interface SensorReadingRepository {
    // Write operations - should be called from a background thread
    void insertSensorReading(@NonNull SensorReading reading); // Assuming Room generates ID or it's not needed back immediately
    void insertSensorReadings(@NonNull List<SensorReading> readings);
    void deleteSensorReadingsBefore(@NonNull Date date);
    void deleteAllSensorReadings();

    // Read operations - observable
    @NonNull
    LiveData<List<SensorReading>> getSensorReadings(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<SensorReading> getLatestSensorReading(); // Assuming you always want to observe the latest

    // For one-off, non-observable reads (if needed, also run on background thread)
    // @NonNull
    // List<SensorReading> getSensorReadingsSync(@NonNull Date startTime, @NonNull Date endTime);
    // @Nullable
    // SensorReading getLatestSensorReadingSync();
}
