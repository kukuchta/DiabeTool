package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.InsulinActivity;

import java.util.Date;
import java.util.List;

public interface InsulinActivityRepository {
    // Write operations
    void insertInsulinActivity(@NonNull InsulinActivity activity);
    void insertInsulinActivities(@NonNull List<InsulinActivity> activities);
    void deleteInsulinActivityBefore(@NonNull Date date);

    // Read operations - observable
    @NonNull
    LiveData<List<InsulinActivity>> getInsulinActivity(@NonNull Date startTime, @NonNull Date endTime);
}
