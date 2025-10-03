package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.BloodMeasurementEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface BloodMeasurementDao {

    /**
     * Inserts a blood measurement into the database. If a record with the same key exists,
     * the insert will fail.
     * @param measurement The blood measurement to insert.
     */
    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insert(BloodMeasurementEntity measurement);

    /**
     * Retrieves all blood measurements within a specific time range, ordered from newest to oldest.
     * @param startTime The start of the time range.
     * @param endTime The end of the time range.
     * @return A LiveData list of blood measurements.
     */
    @Query("SELECT * FROM blood_measurements WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BloodMeasurementEntity>> getBloodMeasurements(Date startTime, Date endTime);

    /**
     * Retrieves the most recent blood measurement recorded.
     * @return A LiveData object holding the latest blood measurement.
     */
    @Query("SELECT * FROM blood_measurements ORDER BY timestamp DESC LIMIT 1")
    LiveData<BloodMeasurementEntity> getLatestBloodMeasurement();

    /**
     * Deletes all records from the blood_measurements table.
     */
    @Query("DELETE FROM blood_measurements")
    void deleteAll();
}
