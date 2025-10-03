package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.BasalInsulin;

import java.util.Date;
import java.util.List;

public interface BasalRepository {
    // Write operations
    void insertAutoBasal(@NonNull BasalInsulin basalInsulin);
    void insertManualBasal(@NonNull BasalInsulin basalInsulin);
    void insertAutoBasals(@NonNull List<BasalInsulin> basalInsulinList);
    void deleteBasalsBefore(@NonNull Date date);

    // Read operations - observable
    @NonNull
    LiveData<List<BasalInsulin>> getAutoBasals(@NonNull Date startTime, @NonNull Date endTime);
    @NonNull
    LiveData<List<BasalInsulin>> getManualBasals(@NonNull Date startTime, @NonNull Date endTime);
}