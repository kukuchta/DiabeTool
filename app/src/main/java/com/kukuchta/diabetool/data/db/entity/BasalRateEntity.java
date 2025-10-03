package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "basal_profile_rates",
        foreignKeys = @ForeignKey(entity = BasalProfileEntity.class,
                parentColumns = "id",
                childColumns = "profileId",
                onDelete = ForeignKey.CASCADE), // If a profile is deleted, its rates are also deleted.
        indices = {@Index("profileId")}) // Indexing the foreign key improves query performance.
public class BasalRateEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public long profileId;
    public int endTime;
    public double rate;

    public BasalRateEntity() {}
}
