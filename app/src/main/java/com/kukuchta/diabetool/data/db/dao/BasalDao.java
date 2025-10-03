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

    @Query("SELECT * FROM basal WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BasalEntity>> getBasalHistory(Date startTime, Date endTime);
}
