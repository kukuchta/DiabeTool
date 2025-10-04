package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;

import com.kukuchta.diabetool.domain.model.IoB;
import com.kukuchta.diabetool.domain.repository.IoBRepository;

public class LogIoBSnapshotUseCase {
    private final IoBRepository iobRepository;

    public LogIoBSnapshotUseCase(@NonNull IoBRepository iobRepository) {
        this.iobRepository = iobRepository;
    }

    public void execute(@NonNull IoB iob) {
        iobRepository.insertIoB(iob);
    }
}