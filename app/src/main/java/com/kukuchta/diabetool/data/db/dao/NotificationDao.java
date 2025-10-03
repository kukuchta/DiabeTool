package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.NotificationEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface NotificationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotificationEntity notification);

    @Query("SELECT * FROM notifications WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<NotificationEntity>> getNotifications(Date startTime, Date endTime);

    @Query("DELETE FROM notifications WHERE id = :notificationId")
    void deleteById(long notificationId);

    @Query("DELETE FROM notifications WHERE timestamp < :date")
    void deleteBefore(Date date);

    @Query("DELETE FROM notifications")
    void deleteAll();
}
