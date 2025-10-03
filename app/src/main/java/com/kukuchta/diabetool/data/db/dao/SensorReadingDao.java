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

    @Insert(onConflict = OnConflictStrategy.FAIL) //TODO check strategies
    void insert(SensorReadingEntity sensorReading);

    @Query("SELECT * FROM sensor_readings WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<SensorReadingEntity>> getSensorReadings(Date startTime, Date endTime);

    @Query("SELECT * FROM sensor_readings ORDER BY timestamp DESC LIMIT 1")
    LiveData<SensorReadingEntity> getLatestSensorReading();

    @Query("DELETE FROM sensor_readings")
    void deleteAll();
}
