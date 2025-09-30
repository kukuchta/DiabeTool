package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.kukuchta.diabetool.domain.model.Meal;
import com.kukuchta.diabetool.domain.repository.MealRepository;
import java.util.Date;
import java.util.List;

public class GetMealsForPeriodUseCase {
    private final MealRepository mealRepository;

    public GetMealsForPeriodUseCase(@NonNull MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @NonNull
    public LiveData<List<Meal>> execute(@NonNull Date startTime, @NonNull Date endTime) {
        return mealRepository.getMeals(startTime, endTime);
    }
}
