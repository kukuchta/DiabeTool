package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.InsulinActivity;
import com.kukuchta.diabetool.domain.repository.InsulinActivityRepository;
import java.util.Date;
import java.util.List;

public class GetInsulinActivityForPeriodUseCase {
    private final InsulinActivityRepository insulinActivityRepository;

    public GetInsulinActivityForPeriodUseCase(@NonNull InsulinActivityRepository insulinActivityRepository) {
        this.insulinActivityRepository = insulinActivityRepository;
    }

    @NonNull
    public LiveData<List<InsulinActivity>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return insulinActivityRepository.getInsulinActivity(startTime, endTime);
    }
}