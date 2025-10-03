package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.Notification;
import java.util.Date;
import java.util.List;

public interface NotificationRepository {
    // Write operations
    void insertNotification(@NonNull Notification notification);
    void deleteNotification(long notificationId);
    void deleteNotificationsBefore(@NonNull Date date);

    // Read operations
    @NonNull
    LiveData<List<Notification>> getNotifications(@NonNull Date startTime, @NonNull Date endTime);
}
