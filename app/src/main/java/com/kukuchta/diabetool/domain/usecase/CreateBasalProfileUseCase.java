package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.BasalProfile;
import com.kukuchta.diabetool.domain.repository.BasalProfileRepository;

import javax.inject.Inject;

public class CreateBasalProfileUseCase {

    private final BasalProfileRepository repository;

    @Inject
    public CreateBasalProfileUseCase(BasalProfileRepository repository) {
        this.repository = repository;
    }

    public void execute(@NonNull String profileName, @NonNull BasalProfile profile) {
        // Here you could add validation logic, e.g., ensure rates cover 24 hours.
        repository.saveBasalProfile(profileName, profile);
    }
}
