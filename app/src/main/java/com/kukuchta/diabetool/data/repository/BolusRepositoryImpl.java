package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.BolusDao;
import com.kukuchta.diabetool.data.db.entity.BolusEntity;
import com.kukuchta.diabetool.domain.model.Bolus;
import com.kukuchta.diabetool.domain.model.BolusType;
import com.kukuchta.diabetool.domain.repository.BolusRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BolusRepositoryImpl implements BolusRepository {

    private final BolusDao bolusDao;
    private final ExecutorService executorService;

    public BolusRepositoryImpl(BolusDao bolusDao) {
        this.bolusDao = bolusDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertManualBolus(@NonNull Bolus bolus) {
        if (bolus.getType() == BolusType.MANUAL) {
            executorService.execute(() -> bolusDao.insert(mapToEntity(bolus)));
        }
    }

    @Override
    public void insertAutoBolus(@NonNull Bolus bolus) {
        if (bolus.getType() == BolusType.AUTOMATIC) {
            executorService.execute(() -> bolusDao.insert(mapToEntity(bolus)));
        }
    }

    @Override
    public void insertAutoBoluses(@NonNull List<Bolus> bolusList) {
        executorService.execute(() -> {
            List<BolusEntity> entities = new ArrayList<>();
            for (Bolus bolus : bolusList) {
                if (bolus.getType() == BolusType.AUTOMATIC) {
                    entities.add(mapToEntity(bolus));
                }
            }
            if (!entities.isEmpty()) {
                bolusDao.insertAll(entities);
            }
        });
    }

    @Override
    public void deleteBolusesBefore(@NonNull Date date) {
        executorService.execute(() -> bolusDao.deleteBolusesBefore(date));
    }

    @NonNull
    @Override
    public LiveData<List<Bolus>> getManualBoluses(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(bolusDao.getManualBoluses(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<List<Bolus>> getAutoBoluses(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(bolusDao.getAutoBoluses(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<Bolus> getLatestBolus() {
        return Transformations.map(bolusDao.getLatestBolus(), this::mapToModel);
    }

    // --- Mappers ---

    private BolusEntity mapToEntity(Bolus model) {
        BolusEntity entity = new BolusEntity();
        entity.timestamp = model.getTimestamp();
        entity.type = model.getType();
        entity.value = model.getValue();
        entity.isManualEntry = model.isManualEntry();
        return entity;
    }

    private Bolus mapToModel(BolusEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Bolus(entity.timestamp, entity.type, entity.value, entity.isManualEntry);
    }

    private List<Bolus> mapEntityListToModelList(List<BolusEntity> entities) {
        List<Bolus> models = new ArrayList<>();
        if (entities != null) {
            for (BolusEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
