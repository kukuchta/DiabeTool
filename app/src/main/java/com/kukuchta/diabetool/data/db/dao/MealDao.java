package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.kukuchta.diabetool.data.db.entity.MealEntity;
import java.util.Date;
import java.util.List;

@Dao
public interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MealEntity meal);

    @Update
    void update(MealEntity meal);

    @Delete
    void delete(MealEntity meal);

    @Query("SELECT * FROM meals WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    LiveData<List<MealEntity>> getMeals(Date startTime, Date endTime);

    @Query("SELECT * FROM meals WHERE id = :id")
    LiveData<MealEntity> getMealById(long id);
}
