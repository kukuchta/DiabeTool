package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.BasalInsulin;
import com.kukuchta.diabetool.domain.repository.BasalRepository;

import javax.inject.Inject;

public class LogAutoBasalUseCase {
    private final BasalRepository basalRepository;

    @Inject
    public LogAutoBasalUseCase(@NonNull BasalRepository basalRepository) {
        this.basalRepository = basalRepository;
    }

    public void execute(@NonNull BasalInsulin basalInsulin) {
        basalRepository.insertAutoBasal(basalInsulin);
    }
}