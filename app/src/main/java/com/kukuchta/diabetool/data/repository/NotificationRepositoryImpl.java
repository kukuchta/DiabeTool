package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.kukuchta.diabetool.data.db.dao.NotificationDao;
import com.kukuchta.diabetool.data.db.entity.NotificationEntity;
import com.kukuchta.diabetool.domain.model.Notification;
import com.kukuchta.diabetool.domain.repository.NotificationRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationDao notificationDao;
    private final ExecutorService executorService;

    public NotificationRepositoryImpl(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertNotification(@NonNull Notification notification) {
        executorService.execute(() -> notificationDao.insert(mapToEntity(notification)));
    }

    @Override
    public void deleteNotification(long notificationId) {
        executorService.execute(() -> notificationDao.deleteById(notificationId));
    }

    @Override
    public void deleteNotificationsBefore(@NonNull Date date) {
        executorService.execute(() -> notificationDao.deleteBefore(date));
    }

    @NonNull
    @Override
    public LiveData<List<Notification>> getNotifications(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(notificationDao.getNotifications(startTime, endTime), this::mapEntityListToModelList);
    }

    // --- Mappers ---

    private NotificationEntity mapToEntity(Notification model) {
        NotificationEntity entity = new NotificationEntity();
        // The ID is not mapped from the model. It's only relevant for the entity.
        entity.timestamp = model.getTimestamp();
        entity.type = model.getType();
        entity.message = model.getMessage();
        entity.isManualEntry = model.isManualEntry();
        return entity;
    }

    private Notification mapToModel(NotificationEntity entity) {
        if (entity == null) {
            return null;
        }
        // The model can be extended to include the ID if needed by the UI for delete operations.
        return new Notification(entity.timestamp, entity.type, entity.message, entity.isManualEntry);
    }

    private List<Notification> mapEntityListToModelList(List<NotificationEntity> entities) {
        List<Notification> models = new ArrayList<>();
        if (entities != null) {
            for (NotificationEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
