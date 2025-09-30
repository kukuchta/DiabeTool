package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.SensorReading;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;

public class LogSensorReadingUseCase {
    private final SensorReadingRepository sensorReadingRepository;

    public LogSensorReadingUseCase(@NonNull SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    public void execute(@NonNull SensorReading reading) {
        // Future: Add validation logic for the reading if needed
        sensorReadingRepository.insertSensorReading(reading);
    }
}
