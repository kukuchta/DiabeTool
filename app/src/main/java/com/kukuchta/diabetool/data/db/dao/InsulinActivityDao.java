package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.InsulinActivityEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface InsulinActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(InsulinActivityEntity insulinActivity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InsulinActivityEntity> activities);

    @Query("SELECT * FROM insulin_activity WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<InsulinActivityEntity>> getInsulinActivity(Date startTime, Date endTime);

    @Query("SELECT * FROM insulin_activity ORDER BY timestamp DESC LIMIT 1")
    LiveData<InsulinActivityEntity> getLatestInsulinActivity();

    @Query("DELETE FROM insulin_activity WHERE timestamp < :date")
    void deleteInsulinActivityBefore(Date date);

    @Query("DELETE FROM insulin_activity")
    void deleteAll();
}
