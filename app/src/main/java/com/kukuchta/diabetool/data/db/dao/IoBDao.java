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

    /**
     * Inserts an Insulin on Board (IoB) record. If a record with the same key exists,
     * the insert will fail.
     * @param iob The IoB record to insert.
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(IoBEntity iob);

    /**
     * Retrieves all IoB records within a specific time range, ordered from newest to oldest.
     * @param startTime The start of the time range.
     * @param endTime The end of the time range.
     * @return A LiveData list of IoB records.
     */
    @Query("SELECT * FROM iob WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<IoBEntity>> getIoBHistory(Date startTime, Date endTime);

    /**
     * Retrieves the most recent Insulin on Board (IoB) record.
     * @return A LiveData object holding the latest IoB record.
     */
    @Query("SELECT * FROM iob ORDER BY timestamp DESC LIMIT 1")
    LiveData<IoBEntity> getLatestIoB();

    /**
     * Deletes all records from the iob table.
     */
    @Query("DELETE FROM iob")
    void deleteAll();
}
