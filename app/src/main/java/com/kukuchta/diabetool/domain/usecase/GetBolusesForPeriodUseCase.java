package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.Bolus;
import com.kukuchta.diabetool.domain.repository.BolusRepository;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class GetBolusesForPeriodUseCase {
    private final BolusRepository bolusRepository;

    @Inject
    public GetBolusesForPeriodUseCase(@NonNull BolusRepository bolusRepository) {
        this.bolusRepository = bolusRepository;
    }

    @NonNull
    public LiveData<List<Bolus>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return bolusRepository.getManualBoluses(startTime, endTime);
    }
}
