package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.kukuchta.diabetool.data.db.entity.BloodMeasurementEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface BloodMeasurementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BloodMeasurementEntity measurement);

    @Update
    void update(BloodMeasurementEntity measurement);

    @Delete
    void delete(BloodMeasurementEntity measurement);

    @Query("SELECT * FROM blood_measurements WHERE id = :id")
    LiveData<BloodMeasurementEntity> getBloodMeasurementById(long id);

    @Query("SELECT * FROM blood_measurements WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<BloodMeasurementEntity>> getBloodMeasurements(Date startTime, Date endTime);

    @Query("SELECT * FROM blood_measurements ORDER BY timestamp DESC LIMIT 1")
    LiveData<BloodMeasurementEntity> getLatestBloodMeasurement();

    @Query("DELETE FROM blood_measurements")
    void deleteAll();
}
