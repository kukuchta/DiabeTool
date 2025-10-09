package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.BloodMeasurement;
import com.kukuchta.diabetool.domain.repository.BloodMeasurementRepository;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class GetBloodMeasurementsForPeriodUseCase {
    private final BloodMeasurementRepository bloodMeasurementRepository;

    @Inject
    public GetBloodMeasurementsForPeriodUseCase(@NonNull BloodMeasurementRepository bloodMeasurementRepository) {
        this.bloodMeasurementRepository = bloodMeasurementRepository;
    }

    @NonNull
    public LiveData<List<BloodMeasurement>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return bloodMeasurementRepository.getBloodMeasurements(startTime, endTime);
    }
}