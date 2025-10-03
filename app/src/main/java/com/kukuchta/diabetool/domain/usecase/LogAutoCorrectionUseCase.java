package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;

import com.kukuchta.diabetool.domain.model.Bolus;
import com.kukuchta.diabetool.domain.repository.BolusRepository;

public class LogAutoCorrectionUseCase {
    private final BolusRepository bolusRepository;

    public LogAutoCorrectionUseCase(@NonNull BolusRepository bolusRepository) {
        this.bolusRepository = bolusRepository;
    }

    public void execute(@NonNull Bolus autoCorrection) {
        bolusRepository.insertAutoBolus(autoCorrection);
    }
}
