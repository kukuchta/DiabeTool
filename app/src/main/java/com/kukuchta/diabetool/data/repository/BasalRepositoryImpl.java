package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.kukuchta.diabetool.data.db.dao.BasalDao;
import com.kukuchta.diabetool.data.db.entity.BasalEntity;
import com.kukuchta.diabetool.domain.model.BasalInsulin;
import com.kukuchta.diabetool.domain.model.BasalInsulinType;
import com.kukuchta.diabetool.domain.repository.BasalRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasalRepositoryImpl implements BasalRepository {

    private final BasalDao basalDao;
    private final ExecutorService executorService;

    public BasalRepositoryImpl(BasalDao basalDao) {
        this.basalDao = basalDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertAutoBasal(@NonNull BasalInsulin basalInsulin) {
        // Ensure the type is correct before inserting
        if (basalInsulin.getType() == BasalInsulinType.AUTO) {
            executorService.execute(() -> basalDao.insert(mapToEntity(basalInsulin)));
        }
    }

    @Override
    public void insertManualBasal(@NonNull BasalInsulin basalInsulin) {
        // Ensure the type is correct before inserting
        if (basalInsulin.getType() == BasalInsulinType.MANUAL) {
            executorService.execute(() -> basalDao.insert(mapToEntity(basalInsulin)));
        }
    }

    @Override
    public void insertAutoBasals(@NonNull List<BasalInsulin> basalInsulinList) {
        executorService.execute(() -> {
            List<BasalEntity> entities = new ArrayList<>();
            for (BasalInsulin insulin : basalInsulinList) {
                // Ensure we only insert AUTO types
                if (insulin.getType() == BasalInsulinType.AUTO) {
                    entities.add(mapToEntity(insulin));
                }
            }
            if (!entities.isEmpty()) {
                basalDao.insertAll(entities);
            }
        });
    }

    @Override
    public void deleteBasalsBefore(@NonNull Date date) {
        executorService.execute(() -> basalDao.deleteBasalsBefore(date));
    }

    @NonNull
    @Override
    public LiveData<List<BasalInsulin>> getAutoBasals(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(basalDao.getAutoBasals(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<List<BasalInsulin>> getManualBasals(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(basalDao.getManualBasals(startTime, endTime), this::mapEntityListToModelList);
    }

    // --- Mappers ---

    private List<BasalInsulin> mapEntityListToModelList(List<BasalEntity> entities) {
        List<BasalInsulin> models = new ArrayList<>();
        if (entities != null) {
            for (BasalEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }

    private BasalEntity mapToEntity(BasalInsulin model) {
        BasalEntity entity = new BasalEntity();
        entity.timestamp = model.getTimestamp();
        entity.value = model.getValue();
        entity.type = model.getType(); // Use the enum directly
        return entity;
    }


    private BasalInsulin mapToModel(BasalEntity entity) {
        return new BasalInsulin(entity.timestamp, entity.type, entity.value);
    }
}
