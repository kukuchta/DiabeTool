package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.InsulinActivityDao;
import com.kukuchta.diabetool.data.db.entity.InsulinActivityEntity;
import com.kukuchta.diabetool.domain.model.InsulinActivity;
import com.kukuchta.diabetool.domain.repository.InsulinActivityRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InsulinActivityRepositoryImpl implements InsulinActivityRepository {

    private final InsulinActivityDao insulinActivityDao;
    private final ExecutorService executorService;

    public InsulinActivityRepositoryImpl(InsulinActivityDao insulinActivityDao) {
        this.insulinActivityDao = insulinActivityDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertInsulinActivity(@NonNull InsulinActivity activity) {
        executorService.execute(() -> insulinActivityDao.insert(mapToEntity(activity)));
    }

    @Override
    public void insertInsulinActivities(@NonNull List<InsulinActivity> activities) {
        executorService.execute(() -> {
            List<InsulinActivityEntity> entities = new ArrayList<>();
            for (InsulinActivity activity : activities) {
                entities.add(mapToEntity(activity));
            }
            insulinActivityDao.insertAll(entities);
        });
    }

    @Override
    public void deleteInsulinActivityBefore(@NonNull Date date) {
        executorService.execute(() -> insulinActivityDao.deleteInsulinActivityBefore(date));
    }

    @NonNull
    @Override
    public LiveData<List<InsulinActivity>> getInsulinActivity(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(insulinActivityDao.getInsulinActivity(startTime, endTime), this::mapEntityListToModelList);
    }

    // --- Mappers ---

    private InsulinActivityEntity mapToEntity(InsulinActivity model) {
        InsulinActivityEntity entity = new InsulinActivityEntity();
        entity.timestamp = model.getTimestamp();
        entity.value = model.getValue();
        return entity;
    }

    private InsulinActivity mapToModel(InsulinActivityEntity entity) {
        if (entity == null) {
            return null;
        }
        return new InsulinActivity(entity.timestamp, entity.value);
    }

    private List<InsulinActivity> mapEntityListToModelList(List<InsulinActivityEntity> entities) {
        List<InsulinActivity> models = new ArrayList<>();
        if (entities != null) {
            for (InsulinActivityEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
