package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.kukuchta.diabetool.data.db.entity.IoBEntity;

import java.util.Date;
import java.util.List;

@Dao
public interface IoBDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(IoBEntity iob);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<IoBEntity> iobs);

    @Query("SELECT * FROM iob WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<IoBEntity>> getIoBHistory(Date startTime, Date endTime);

    @Query("SELECT * FROM iob ORDER BY timestamp DESC LIMIT 1")
    LiveData<IoBEntity> getLatestIoB();

    @Query("DELETE FROM iob WHERE timestamp < :date")
    void deleteIoBBefore(Date date);
}
