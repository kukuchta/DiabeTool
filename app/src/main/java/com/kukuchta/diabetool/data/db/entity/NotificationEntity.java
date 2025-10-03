package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "notifications")
@TypeConverters(DateConverter.class)
public class NotificationEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;
    public String message;
    public String type;    // e.g., "Alert", "Info", "Reminder"
    public boolean isManualEntry;

    public NotificationEntity() {}
}