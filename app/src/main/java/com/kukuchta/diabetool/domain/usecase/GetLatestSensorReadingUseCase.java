package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.SensorReading;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;

import javax.inject.Inject;

public class GetLatestSensorReadingUseCase {
    private final SensorReadingRepository sensorReadingRepository;

    @Inject
    public GetLatestSensorReadingUseCase(@NonNull SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @NonNull
    public LiveData<SensorReading> execute() {
        return sensorReadingRepository.getLatestSensorReading();
    }
}