package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.IoBDao;
import com.kukuchta.diabetool.data.db.entity.IoBEntity;
import com.kukuchta.diabetool.domain.model.IoB;
import com.kukuchta.diabetool.domain.repository.IoBRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoBRepositoryImpl implements IoBRepository {

    private final IoBDao iobDao;
    private final ExecutorService executorService;

    public IoBRepositoryImpl(IoBDao iobDao) {
        this.iobDao = iobDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertIoB(@NonNull IoB iob) {
        executorService.execute(() -> iobDao.insert(mapToEntity(iob)));
    }

    @NonNull
    @Override
    public LiveData<List<IoB>> getIoBHistory(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(iobDao.getIoBHistory(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<IoB> getLatestIoB() {
        return Transformations.map(iobDao.getLatestIoB(), this::mapToModel);
    }

    // --- Mappers ---

    private IoBEntity mapToEntity(IoB model) {
        IoBEntity entity = new IoBEntity();
        entity.timestamp = model.getTimestamp();
        entity.value = model.getValue();
        return entity;
    }

    private IoB mapToModel(IoBEntity entity) {
        if (entity == null) {
            return null;
        }
        return new IoB(entity.timestamp, entity.value);
    }

    private List<IoB> mapEntityListToModelList(List<IoBEntity> entities) {
        List<IoB> models = new ArrayList<>();
        if (entities != null) {
            for (IoBEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
