package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.BasalProfile;
import com.kukuchta.diabetool.domain.repository.BasalProfileRepository;

import javax.inject.Inject;

public class GetBasalProfileUseCase {

    private final BasalProfileRepository repository;

    @Inject
    public GetBasalProfileUseCase(BasalProfileRepository repository) {
        this.repository = repository;
    }

    @NonNull
    public LiveData<BasalProfile> execute(@NonNull String profileName) {
        return repository.getBasalProfile(profileName);
    }
}
