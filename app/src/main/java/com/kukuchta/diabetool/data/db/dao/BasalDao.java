package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.BasalEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface BasalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BasalEntity basal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<BasalEntity> basals);

    // Query for AUTO type
    @Query("SELECT * FROM basal WHERE `type` = 'AUTO' AND timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BasalEntity>> getAutoBasals(Date startTime, Date endTime);

    // Query for MANUAL type
    @Query("SELECT * FROM basal WHERE `type` = 'MANUAL' AND timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BasalEntity>> getManualBasals(Date startTime, Date endTime);

    @Query("DELETE FROM basal WHERE timestamp < :date")
    void deleteBasalsBefore(Date date);
}
