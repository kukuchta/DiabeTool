package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.IoB;

import java.util.Date;
import java.util.List;

public interface IoBRepository {
    // Write operations
    void insertIoBSnapshot(@NonNull IoB iob);

    // Read operations - observable
    @NonNull
    LiveData<List<IoB>> getIoBHistory(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<IoB> getLatestIoB();
}