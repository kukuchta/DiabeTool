package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;

import com.kukuchta.diabetool.domain.model.BasalInsulin;
import com.kukuchta.diabetool.domain.repository.BasalRepository;

import javax.inject.Inject;

public class LogBasalUseCase {
    private final BasalRepository basalRepository;

    @Inject
    public LogBasalUseCase(@NonNull BasalRepository basalRepository) {
        this.basalRepository = basalRepository;
    }

    public void execute(@NonNull BasalInsulin basalInsulin) {
        basalRepository.insertManualBasal(basalInsulin);
    }
}