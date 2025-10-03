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

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(BolusEntity bolus);

    @Query("SELECT * FROM boluses WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BolusEntity>> getBoluses(Date startTime, Date endTime);
}
