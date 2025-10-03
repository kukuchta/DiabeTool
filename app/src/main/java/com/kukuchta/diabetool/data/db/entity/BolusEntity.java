package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "boluses")
@TypeConverters(DateConverter.class)
public class BolusEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;
    public String type; // e.g., "Manual", "Auto"
    public double value; // In units
    public boolean isManualEntry;

    public BolusEntity() {}
}