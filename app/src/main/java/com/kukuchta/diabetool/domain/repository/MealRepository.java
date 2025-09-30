package com.kukuchta.diabetool.domain.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kukuchta.diabetool.domain.model.Meal;

import java.util.Date;
import java.util.List;

public interface MealRepository {
    // Write operations
    void insertMeal(@NonNull Meal meal);
    void updateMeal(@NonNull Meal meal);
    void deleteMeal(@NonNull Meal meal); // or by ID: deleteMeal(long mealId)

    // Read operations - observable
    @NonNull
    LiveData<List<Meal>> getMeals(@NonNull Date startTime, @NonNull Date endTime);

    @NonNull
    LiveData<Meal> getMealById(long mealId); // Use LiveData<Meal> to observe a single meal
}
