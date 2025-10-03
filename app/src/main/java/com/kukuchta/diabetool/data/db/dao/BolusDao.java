package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kukuchta.diabetool.data.db.entity.BolusEntity;

import java.util.Date;
import java.util.List;

@Dao
public interface BolusDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BolusEntity bolus);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<BolusEntity> boluses);

    @Query("SELECT * FROM boluses WHERE `type` = 'MANUAL' AND timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BolusEntity>> getManualBoluses(Date startTime, Date endTime);

    @Query("SELECT * FROM boluses WHERE `type` = 'AUTO' AND timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BolusEntity>> getAutoBoluses(Date startTime, Date endTime);

    @Query("SELECT * FROM boluses ORDER BY timestamp DESC LIMIT 1")
    LiveData<BolusEntity> getLatestBolus();

    @Query("DELETE FROM boluses WHERE timestamp < :date")
    void deleteBolusesBefore(Date date);
}
