package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.AutoBasal;

import java.util.Date;
import java.util.List;

public interface AutoBasalRepository {
    // Write operations
    void insertAutoBasal(@NonNull AutoBasal autoBasal);
    void insertAutoBasals(@NonNull List<AutoBasal> autoBasals);
    void deleteAutoBasalsBefore(@NonNull Date date);

    // Read operations - observable
    @NonNull
    LiveData<List<AutoBasal>> getAutoBasals(@NonNull Date startTime, @NonNull Date endTime);
}