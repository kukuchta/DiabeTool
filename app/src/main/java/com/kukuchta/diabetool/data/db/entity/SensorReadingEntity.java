package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "sensor_readings")
@TypeConverters(DateConverter.class)
public class SensorReadingEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;
    public int value; // In mg/dl

    public SensorReadingEntity() {}

    @Ignore
    public SensorReadingEntity(long id, Date timestamp, int value) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }
}