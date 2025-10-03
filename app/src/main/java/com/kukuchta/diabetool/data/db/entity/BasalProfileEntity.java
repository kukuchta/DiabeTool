package com.kukuchta.diabetool.data.db.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "basal_profiles",
        indices = {@Index(value = "profileName", unique = true)}) // Ensures profile names are unique.
public class BasalProfileEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String profileName;

    public BasalProfileEntity() {}
}
