package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.Notification;
import com.kukuchta.diabetool.domain.repository.NotificationRepository;

public class LogNotificationUseCase {
    private final NotificationRepository notificationRepository;

    public LogNotificationUseCase(@NonNull NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void execute(@NonNull Notification notification) {
        notificationRepository.insertNotification(notification);
    }
}
