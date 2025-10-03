package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.SensorReadingDao;
import com.kukuchta.diabetool.data.db.entity.SensorReadingEntity;
import com.kukuchta.diabetool.domain.model.SensorReading;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorReadingRepositoryImpl implements SensorReadingRepository {

    private final SensorReadingDao sensorReadingDao;
    private final ExecutorService executorService;

    public SensorReadingRepositoryImpl(SensorReadingDao sensorReadingDao) {
        this.sensorReadingDao = sensorReadingDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertSensorReading(@NonNull SensorReading reading) {
        executorService.execute(() -> sensorReadingDao.insert(mapToEntity(reading)));
    }

    @Override
    public void insertSensorReadings(@NonNull List<SensorReading> readings) {
        executorService.execute(() -> {
            List<SensorReadingEntity> entities = new ArrayList<>();
            for (SensorReading reading : readings) {
                entities.add(mapToEntity(reading));
            }
            if (!entities.isEmpty()) {
                sensorReadingDao.insertAll(entities);
            }
        });
    }

    @Override
    public void deleteSensorReadingsBefore(@NonNull Date date) {
        executorService.execute(() -> sensorReadingDao.deleteSensorReadingsBefore(date));
    }

    @Override
    public void deleteAllSensorReadings() {
        executorService.execute(sensorReadingDao::deleteAll);
    }

    @NonNull
    @Override
    public LiveData<List<SensorReading>> getSensorReadings(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(sensorReadingDao.getSensorReadings(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<SensorReading> getLatestSensorReading() {
        return Transformations.map(sensorReadingDao.getLatestSensorReading(), this::mapToModel);
    }

    // --- Mappers ---

    private SensorReadingEntity mapToEntity(SensorReading model) {
        SensorReadingEntity entity = new SensorReadingEntity();
        entity.timestamp = model.getTimestamp();
        entity.value = model.getValue(); // Map glucoseLevel to value
        return entity;
    }

    private SensorReading mapToModel(SensorReadingEntity entity) {
        if (entity == null) {
            return null;
        }
        return new SensorReading(entity.timestamp, entity.value); // Map value to glucoseLevel
    }

    private List<SensorReading> mapEntityListToModelList(List<SensorReadingEntity> entities) {
        List<SensorReading> models = new ArrayList<>();
        if (entities != null) {
            for (SensorReadingEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
