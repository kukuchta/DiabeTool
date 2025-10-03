package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.BasalInsulin;
import com.kukuchta.diabetool.domain.repository.BasalRepository;
import java.util.Date;
import java.util.List;

public class GetAutoBasalsForPeriodUseCase {
    private final BasalRepository basalRepository;

    public GetAutoBasalsForPeriodUseCase(@NonNull BasalRepository basalRepository) {
        this.basalRepository = basalRepository;
    }

    @NonNull
    public LiveData<List<BasalInsulin>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return basalRepository.getAutoBasals(startTime, endTime);
    }
}