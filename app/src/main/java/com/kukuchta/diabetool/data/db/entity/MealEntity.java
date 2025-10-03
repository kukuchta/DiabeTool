package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import java.util.Date;

@Entity(tableName = "meals")
@TypeConverters(DateConverter.class)
public class MealEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public Date timestamp;
    public int carbs; // in grams
    public boolean isManualEntry;

    public MealEntity() {}
}