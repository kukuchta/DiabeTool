package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.kukuchta.diabetool.data.db.dao.BasalProfileDao;
import com.kukuchta.diabetool.data.db.entity.BasalProfileEntity;
import com.kukuchta.diabetool.data.db.entity.BasalRateEntity;
import com.kukuchta.diabetool.data.db.relation.BasalProfileWithRates;
import com.kukuchta.diabetool.domain.model.BasalProfile;
import com.kukuchta.diabetool.domain.model.BasalRate;
import com.kukuchta.diabetool.domain.repository.BasalProfileRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasalProfileRepositoryImpl implements BasalProfileRepository {

    private final BasalProfileDao basalProfileDao;
    private final ExecutorService executorService;

    public BasalProfileRepositoryImpl(BasalProfileDao basalProfileDao) {
        this.basalProfileDao = basalProfileDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void saveBasalProfile(@NonNull String profileName, @NonNull BasalProfile profile) {
        executorService.execute(() -> {
            BasalProfileEntity profileEntity = new BasalProfileEntity();
            profileEntity.profileName = profileName;

            List<BasalRateEntity> rateEntities = new ArrayList<>();
            for (BasalRate rate : profile.getRates()) {
                rateEntities.add(mapToRateEntity(rate));
            }

            // The DAO handles the transaction to insert both profile and rates
            basalProfileDao.insertProfileWithRates(profileEntity, rateEntities);
        });
    }

    @NonNull
    @Override
    public LiveData<BasalProfile> getBasalProfile(@NonNull String profileName) {
        return Transformations.map(basalProfileDao.getProfileWithRates(profileName), this::mapToProfileModel);
    }

    @NonNull
    @Override
    public LiveData<List<String>> getAllProfileNames() {
        return basalProfileDao.getAllProfileNames();
    }

    // --- Mappers ---

    private BasalRateEntity mapToRateEntity(BasalRate rateModel) {
        BasalRateEntity entity = new BasalRateEntity();
        entity.endTime = rateModel.getEndTime();
        entity.rate = rateModel.getRate();
        return entity;
    }

    private BasalProfile mapToProfileModel(BasalProfileWithRates profileWithRates) {
        if (profileWithRates == null || profileWithRates.rates == null) {
            return null; // Or return a default/empty profile
        }

        List<BasalRate> rates = new ArrayList<>();
        for (BasalRateEntity rateEntity : profileWithRates.rates) {
            rates.add(new BasalRate(rateEntity.endTime, rateEntity.rate));
        }

        return new BasalProfile(rates);
    }
}
