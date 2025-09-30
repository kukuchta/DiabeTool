package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.AutoCorrection;
import com.kukuchta.diabetool.domain.repository.AutoCorrectionRepository;
import java.util.Date;
import java.util.List;

public class GetAutoCorrectionsForPeriodUseCase {
    private final AutoCorrectionRepository autoCorrectionRepository;

    public GetAutoCorrectionsForPeriodUseCase(@NonNull AutoCorrectionRepository autoCorrectionRepository) {
        this.autoCorrectionRepository = autoCorrectionRepository;
    }

    @NonNull
    public LiveData<List<AutoCorrection>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return autoCorrectionRepository.getAutoCorrections(startTime, endTime);
    }
}