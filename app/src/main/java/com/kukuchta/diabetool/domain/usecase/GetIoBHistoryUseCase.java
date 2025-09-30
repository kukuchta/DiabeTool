package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.IoB;
import com.kukuchta.diabetool.domain.repository.IoBRepository;
import java.util.Date;
import java.util.List;

public class GetIoBHistoryUseCase {
    private final IoBRepository iobRepository;

    public GetIoBHistoryUseCase(@NonNull IoBRepository iobRepository) {
        this.iobRepository = iobRepository;
    }

    @NonNull
    public LiveData<List<IoB>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return iobRepository.getIoBHistory(startTime, endTime);
    }

    @NonNull
    public LiveData<IoB> executeForLatest() {
        return iobRepository.getLatestIoB();
    }
}