package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.Bolus;

import java.util.Date;
import java.util.List;

public interface BolusRepository {
    // Write operations
    void insertBolus(@NonNull Bolus bolus);

    // Read operations - observable
    @NonNull
    LiveData<List<Bolus>> getBoluses(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<Bolus> getLatestBolus();
}