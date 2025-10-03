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

    /**
     * Inserts an insulin activity record. If a record with the same key exists,
     * the insert will fail.
     * @param insulinActivity The insulin activity record to insert.
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(InsulinActivityEntity insulinActivity);

    /**
     * Retrieves all insulin activity records within a specific time range, ordered from newest to oldest.
     * @param startTime The start of the time range.
     * @param endTime The end of the time range.
     * @return A LiveData list of insulin activity records.
     */
    @Query("SELECT * FROM insulin_activity WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<InsulinActivityEntity>> getInsulinActivity(Date startTime, Date endTime);

    /**
     * Retrieves the most recent insulin activity record.
     * @return A LiveData object holding the latest insulin activity record.
     */
    @Query("SELECT * FROM insulin_activity ORDER BY timestamp DESC LIMIT 1")
    LiveData<InsulinActivityEntity> getLatestInsulinActivity();

    /**
     * Deletes all records from the insulin_activity table.
     */
    @Query("DELETE FROM insulin_activity")
    void deleteAll();
}
