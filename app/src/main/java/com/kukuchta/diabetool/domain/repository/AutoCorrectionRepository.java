package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.AutoCorrection;

import java.util.Date;
import java.util.List;

public interface AutoCorrectionRepository {
    // Write operations
    void insertAutoCorrection(@NonNull AutoCorrection autoCorrection);
    void insertAutoCorrections(@NonNull List<AutoCorrection> autoCorrections);
    void deleteAutoCorrectionsBefore(@NonNull Date date);

    // Read operations - observable
    @NonNull
    LiveData<List<AutoCorrection>> getAutoCorrections(@NonNull Date startTime, @NonNull Date endTime);
}