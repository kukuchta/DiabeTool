package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;import androidx.room.Query;
import com.kukuchta.diabetool.data.db.entity.NotificationEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface NotificationDao {

    /**
     * Inserts a notification into the database. If a notification with the same primary key already exists,
     * it will be replaced.
     * @param notification The notification to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(NotificationEntity notification);

    /**
     * Retrieves all notifications within a specific time range, ordered from newest to oldest.
     * @param startTime The start of the time range.
     * @param endTime The end of the time range.
     * @return A LiveData list of notifications.
     */
    @Query("SELECT * FROM notifications WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<NotificationEntity>> getNotifications(Date startTime, Date endTime);

    /**
     * Retrieves all notifications currently in the database, ordered from newest to oldest.
     * @return A LiveData list of all notifications.
     */
    @Query("SELECT * FROM notifications ORDER BY timestamp DESC")
    LiveData<List<NotificationEntity>> getAllNotifications();

    /**
     * Deletes all notifications from the database. Use with caution.
     */
    @Query("DELETE FROM notifications")
    void deleteAll();
}
