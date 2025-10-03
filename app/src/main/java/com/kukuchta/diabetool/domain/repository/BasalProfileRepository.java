package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.BasalProfile;
import java.util.List;

public interface BasalProfileRepository {

    void saveBasalProfile(@NonNull String profileName, @NonNull BasalProfile profile);

    @NonNull
    LiveData<BasalProfile> getBasalProfile(@NonNull String profileName);

    @NonNull
    LiveData<List<String>> getAllProfileNames();
}
