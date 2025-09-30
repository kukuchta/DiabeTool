package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.domain.model.Meal;
import com.kukuchta.diabetool.domain.repository.MealRepository;

public class LogMealUseCase {
    private final MealRepository mealRepository;

    public LogMealUseCase(@NonNull MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void execute(@NonNull Meal meal) {
        // Future: Add validation logic for the meal if needed
        mealRepository.insertMeal(meal);
    }
}