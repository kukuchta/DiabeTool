package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.AutoBasal;
import com.kukuchta.diabetool.domain.repository.AutoBasalRepository;
import java.util.Date;
import java.util.List;

public class GetAutoBasalsForPeriodUseCase {
    private final AutoBasalRepository autoBasalRepository;

    public GetAutoBasalsForPeriodUseCase(@NonNull AutoBasalRepository autoBasalRepository) {
        this.autoBasalRepository = autoBasalRepository;
    }

    @NonNull
    public LiveData<List<AutoBasal>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return autoBasalRepository.getAutoBasals(startTime, endTime);
    }
}