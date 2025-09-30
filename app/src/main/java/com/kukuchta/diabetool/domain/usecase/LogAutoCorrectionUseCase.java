package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.AutoCorrection;
import com.kukuchta.diabetool.domain.repository.AutoCorrectionRepository;

public class LogAutoCorrectionUseCase {
    private final AutoCorrectionRepository autoCorrectionRepository;

    public LogAutoCorrectionUseCase(@NonNull AutoCorrectionRepository autoCorrectionRepository) {
        this.autoCorrectionRepository = autoCorrectionRepository;
    }

    public void execute(@NonNull AutoCorrection autoCorrection) {
        autoCorrectionRepository.insertAutoCorrection(autoCorrection);
    }
}
