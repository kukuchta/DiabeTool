package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.AutoBasal;
import com.kukuchta.diabetool.domain.repository.AutoBasalRepository;

public class LogAutoBasalUseCase {
    private final AutoBasalRepository autoBasalRepository;

    public LogAutoBasalUseCase(@NonNull AutoBasalRepository autoBasalRepository) {
        this.autoBasalRepository = autoBasalRepository;
    }

    public void execute(@NonNull AutoBasal autoBasal) {
        autoBasalRepository.insertAutoBasal(autoBasal);
    }
}