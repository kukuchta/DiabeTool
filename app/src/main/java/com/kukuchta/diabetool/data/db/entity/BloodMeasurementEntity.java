package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "blood_measurements")
@TypeConverters(DateConverter.class)
public class BloodMeasurementEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;  // When the measurement was actually taken
    public int value; // In mg/dl
    public boolean isManualEntry;

    public BloodMeasurementEntity() {}
}