package com.kukuchta.diabetool.data.db.converter;

import androidx.room.TypeConverter;
import com.kukuchta.diabetool.domain.model.NotificationType;

public class NotificationTypeConverter {
    @TypeConverter
    public static String fromNotificationType(NotificationType type) {
        return type == null ? null : type.name();
    }

    @TypeConverter
    public static NotificationType toNotificationType(String name) {
        return name == null ? null : NotificationType.valueOf(name);
    }
}
