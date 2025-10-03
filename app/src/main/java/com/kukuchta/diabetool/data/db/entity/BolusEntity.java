package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.kukuchta.diabetool.data.db.converter.BolusTypeConverter;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import com.kukuchta.diabetool.domain.model.BolusType;

import java.util.Date;

@Entity(tableName = "boluses")
@TypeConverters({DateConverter.class, BolusTypeConverter.class})
public class BolusEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;
    public BolusType type;
    public double value; // In units
    public boolean isManualEntry;

    public BolusEntity() {}
}
