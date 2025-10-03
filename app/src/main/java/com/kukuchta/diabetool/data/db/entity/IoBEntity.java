package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "iob")
@TypeConverters(DateConverter.class)
public class IoBEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;

    public double value; // In units

    public IoBEntity() {}
}