package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.Bolus;
import com.kukuchta.diabetool.domain.repository.BolusRepository;

public class LogBolusUseCase {
    private final BolusRepository bolusRepository;

    public LogBolusUseCase(@NonNull BolusRepository bolusRepository) {
        this.bolusRepository = bolusRepository;
    }

    public void execute(@NonNull Bolus bolus) {
        // Future: Add validation logic for the bolus if needed
        bolusRepository.insertManualBolus(bolus);
    }
}