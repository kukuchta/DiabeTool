package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.Notification;
import com.kukuchta.diabetool.domain.repository.NotificationRepository;
import java.util.Date; // Assuming you might want to filter by date too
import java.util.List;

public class GetNotificationsUseCase {
    private final NotificationRepository notificationRepository;

    public GetNotificationsUseCase(@NonNull NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Example: Get all notifications within a period
    @NonNull
    public LiveData<List<Notification>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return notificationRepository.getNotifications(startTime, endTime);
    }

    // Example: Get only unread notifications
    @NonNull
    public LiveData<List<Notification>> executeForUnread() {
        return notificationRepository.getUnreadNotifications();
    }
}