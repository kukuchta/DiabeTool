package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;

import com.kukuchta.diabetool.domain.model.Bolus;
import com.kukuchta.diabetool.domain.repository.BolusRepository;

import javax.inject.Inject;

public class LogAutoCorrectionUseCase {
    private final BolusRepository bolusRepository;

    @Inject
    public LogAutoCorrectionUseCase(@NonNull BolusRepository bolusRepository) {
        this.bolusRepository = bolusRepository;
    }

    public void execute(@NonNull Bolus autoCorrection) {
        bolusRepository.insertAutoBolus(autoCorrection);
    }
}
