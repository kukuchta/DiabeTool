package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;

import com.kukuchta.diabetool.domain.model.BasalInsulin;
import com.kukuchta.diabetool.domain.repository.BasalRepository;

public class LogBasalUseCase {
    private final BasalRepository basalRepository;

    public LogBasalUseCase(@NonNull BasalRepository basalRepository) {
        this.basalRepository = basalRepository;
    }

    public void execute(@NonNull BasalInsulin basalInsulin) {
        basalRepository.insertManualBasal(basalInsulin);
    }
}