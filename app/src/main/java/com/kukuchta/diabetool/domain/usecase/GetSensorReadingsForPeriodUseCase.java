package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.SensorReading;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;
import java.util.Date;
import java.util.List;

public class GetSensorReadingsForPeriodUseCase {
    private final SensorReadingRepository sensorReadingRepository;

    public GetSensorReadingsForPeriodUseCase(@NonNull SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @NonNull
    public LiveData<List<SensorReading>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return sensorReadingRepository.getSensorReadings(startTime, endTime);
    }
}
