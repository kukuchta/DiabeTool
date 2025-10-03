package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.Bolus;

import java.util.Date;
import java.util.List;

public interface BolusRepository {
    // Write operations
    void insertManualBolus(@NonNull Bolus bolus);
    void insertAutoBolus(@NonNull Bolus bolus);
    void insertAutoBoluses(@NonNull List<Bolus> bolusList);
    void deleteBolusesBefore(@NonNull Date date);

    // Read operations - observable
    @NonNull
    LiveData<List<Bolus>> getManualBoluses(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<List<Bolus>> getAutoBoluses(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<Bolus> getLatestBolus();
}