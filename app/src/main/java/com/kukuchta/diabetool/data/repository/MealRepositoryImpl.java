package com.kukuchta.diabetool.data.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.kukuchta.diabetool.data.db.dao.MealDao;
import com.kukuchta.diabetool.data.db.entity.MealEntity;
import com.kukuchta.diabetool.domain.model.Meal;
import com.kukuchta.diabetool.domain.repository.MealRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MealRepositoryImpl implements MealRepository {

    private final MealDao mealDao;
    private final ExecutorService executorService;

    public MealRepositoryImpl(MealDao mealDao) {
        this.mealDao = mealDao;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @Override
    public void insertMeal(@NonNull Meal meal) {
        executorService.execute(() -> mealDao.insert(mapToEntity(meal)));
    }

    @Override
    public void updateMeal(@NonNull Meal meal) {
        // To properly update, the Meal model should contain an 'id'.
        // This relies on OnConflictStrategy.REPLACE to function.
        executorService.execute(() -> mealDao.update(mapToEntity(meal)));
    }

    @Override
    public void deleteMeal(@NonNull Meal meal) {
        // To properly delete, the Meal model should contain an 'id'.
        executorService.execute(() -> mealDao.delete(mapToEntity(meal)));
    }

    @NonNull
    @Override
    public LiveData<List<Meal>> getMeals(@NonNull Date startTime, @NonNull Date endTime) {
        return Transformations.map(mealDao.getMeals(startTime, endTime), this::mapEntityListToModelList);
    }

    @NonNull
    @Override
    public LiveData<Meal> getMealById(long mealId) {
        return Transformations.map(mealDao.getMealById(mealId), this::mapToModel);
    }

    // --- Mappers ---

    private MealEntity mapToEntity(Meal model) {
        MealEntity entity = new MealEntity();
        // Note: The 'id' from the model is not mapped, as it doesn't exist.
        // For update/delete to work reliably, the Meal model should be extended to include the id.
        entity.timestamp = model.getTimestamp();
        entity.carbs = model.getCarbs(); // Now a direct mapping
        entity.isManualEntry = model.isManualEntry();
        return entity;
    }

    private Meal mapToModel(MealEntity entity) {
        if (entity == null) {
            return null;
        }
        // It's recommended to add the 'id' to the Meal constructor in the future.
        return new Meal(entity.timestamp, entity.carbs, entity.isManualEntry);
    }

    private List<Meal> mapEntityListToModelList(List<MealEntity> entities) {
        List<Meal> models = new ArrayList<>();
        if (entities != null) {
            for (MealEntity entity : entities) {
                models.add(mapToModel(entity));
            }
        }
        return models;
    }
}
