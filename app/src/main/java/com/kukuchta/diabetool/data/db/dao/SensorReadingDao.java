package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.SensorReadingEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface SensorReadingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SensorReadingEntity sensorReading);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SensorReadingEntity> readings);

    @Query("SELECT * FROM sensor_readings WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<SensorReadingEntity>> getLiveSensorReadings(Date startTime, Date endTime);

    @Query("SELECT * FROM sensor_readings ORDER BY timestamp DESC LIMIT 1")
    LiveData<SensorReadingEntity> getLiveLatestSensorReading();

    @Query("SELECT * FROM sensor_readings ORDER BY timestamp DESC LIMIT 1")
    SensorReadingEntity getLatestSensorReading();

    @Query("DELETE FROM sensor_readings WHERE timestamp < :date")
    void deleteSensorReadingsBefore(Date date);

    @Query("DELETE FROM sensor_readings")
    void deleteAll();
}
