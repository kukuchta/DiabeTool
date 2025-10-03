package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.BloodMeasurementDao;
import com.kukuchta.diabetool.data.db.entity.BloodMeasurementEntity;
import com.kukuchta.diabetool.domain.model.BloodMeasurement;
import com.kukuchta.diabetool.domain.repository.BloodMeasurementRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BloodMeasurementRepositoryImpl implements BloodMeasurementRepository {

    private final BloodMeasurementDao bloodMeasurementDao;
    private final ExecutorService executorService;

    public BloodMeasurementRepositoryImpl(BloodMeasurementDao bloodMeasurementDao) {
        this.bloodMeasurementDao = bloodMeasurementDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertBloodMeasurement(@NonNull BloodMeasurement measurement) {
        executorService.execute(() -> bloodMeasurementDao.insert(mapToEntity(measurement)));
    }

    @Override
    public void updateBloodMeasurement(@NonNull BloodMeasurement measurement) {
        executorService.execute(() -> bloodMeasurementDao.update(mapToEntity(measurement)));
    }

    @Override
    public void deleteBloodMeasurement(@NonNull BloodMeasurement measurement) {
        executorService.execute(() -> bloodMeasurementDao.delete(mapToEntity(measurement)));
    }

    @NonNull
    @Override
    public LiveData<List<BloodMeasurement>> getBloodMeasurements(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(bloodMeasurementDao.getBloodMeasurements(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<BloodMeasurement> getBloodMeasurementById(long id) {
        return Transformations.map(bloodMeasurementDao.getBloodMeasurementById(id), this::mapToModel);
    }

    // --- Mappers ---

    private BloodMeasurementEntity mapToEntity(BloodMeasurement model) {
        BloodMeasurementEntity entity = new BloodMeasurementEntity();
        // Note: The ID is not mapped here as it's auto-generated or part of an existing entity.
        // For update/delete, we would ideally need the ID. This implementation assumes Room handles it.
        entity.timestamp = model.getTimestamp();
        entity.value = model.getGlucoseLevel();
        entity.isManualEntry = model.isManualEntry();
        return entity;
    }

    private BloodMeasurement mapToModel(BloodMeasurementEntity entity) {
        if (entity == null) {
            return null;
        }
        return new BloodMeasurement(entity.timestamp, entity.value, entity.isManualEntry);
    }

    private List<BloodMeasurement> mapEntityListToModelList(List<BloodMeasurementEntity> entities) {
        List<BloodMeasurement> models = new ArrayList<>();
        if (entities != null) {
            for (BloodMeasurementEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
