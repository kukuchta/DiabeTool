package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.BloodMeasurement;

import java.util.Date;
import java.util.List;

public interface BloodMeasurementRepository {
    // Write operations
    void insertBloodMeasurement(@NonNull BloodMeasurement measurement);
    void updateBloodMeasurement(@NonNull BloodMeasurement measurement);
    void deleteBloodMeasurement(@NonNull BloodMeasurement measurement); // or by ID

    // Read operations - observable
    @NonNull
    LiveData<List<BloodMeasurement>> getBloodMeasurements(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<BloodMeasurement> getBloodMeasurementById(long id);
}
