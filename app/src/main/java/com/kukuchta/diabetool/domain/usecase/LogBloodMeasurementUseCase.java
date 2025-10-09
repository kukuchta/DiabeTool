package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.BloodMeasurement;
import com.kukuchta.diabetool.domain.repository.BloodMeasurementRepository;

import javax.inject.Inject;

public class LogBloodMeasurementUseCase {
    private final BloodMeasurementRepository bloodMeasurementRepository;

    @Inject
    public LogBloodMeasurementUseCase(@NonNull BloodMeasurementRepository bloodMeasurementRepository) {
        this.bloodMeasurementRepository = bloodMeasurementRepository;
    }

    public void execute(@NonNull BloodMeasurement measurement) {
        bloodMeasurementRepository.insertBloodMeasurement(measurement);
    }
}