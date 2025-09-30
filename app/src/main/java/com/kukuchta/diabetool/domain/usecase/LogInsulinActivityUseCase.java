package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.InsulinActivity;
import com.kukuchta.diabetool.domain.repository.InsulinActivityRepository;

public class LogInsulinActivityUseCase {
    private final InsulinActivityRepository insulinActivityRepository;

    public LogInsulinActivityUseCase(@NonNull InsulinActivityRepository insulinActivityRepository) {
        this.insulinActivityRepository = insulinActivityRepository;
    }

    public void execute(@NonNull InsulinActivity insulinActivity) {
        insulinActivityRepository.insertInsulinActivity(insulinActivity);
    }
}