package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.kukuchta.diabetool.domain.model.DashboardData;
import com.kukuchta.diabetool.domain.model.IoB;
import com.kukuchta.diabetool.domain.model.Meal;
import com.kukuchta.diabetool.domain.model.SensorReading;
// Import other models as needed

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

public class GetDashboardDataUseCase {
    private final GetLatestSensorReadingUseCase getLatestSensorReadingUseCase;
    private final GetIoBHistoryUseCase getIoBHistoryUseCase; // Or CalculateActiveInsulinUseCase
    private final GetMealsForPeriodUseCase getMealsForPeriodUseCase;
    // Add other use cases as dependencies

    @Inject
    public GetDashboardDataUseCase(
            @NonNull GetLatestSensorReadingUseCase getLatestSensorReadingUseCase,
            @NonNull GetIoBHistoryUseCase getIoBHistoryUseCase,
            @NonNull GetMealsForPeriodUseCase getMealsForPeriodUseCase) {
        this.getLatestSensorReadingUseCase = getLatestSensorReadingUseCase;
        this.getIoBHistoryUseCase = getIoBHistoryUseCase;
        this.getMealsForPeriodUseCase = getMealsForPeriodUseCase;
    }

    @NonNull
    public LiveData<DashboardData> execute() {
        MediatorLiveData<DashboardData> dashboardLiveData = new MediatorLiveData<>();

        LiveData<SensorReading> latestSensorReading = getLatestSensorReadingUseCase.execute();
        LiveData<IoB> currentIoB = getIoBHistoryUseCase.executeForLatest(); // Or from Calculate IoB use case

        // Example: Get meals from the last 6 hours
        Date now = new Date();
        Date mealStartTime = new Date(now.getTime() - TimeUnit.HOURS.toMillis(6));
        LiveData<List<Meal>> recentMeals = getMealsForPeriodUseCase.execute(mealStartTime, now);

        // Helper to update dashboardLiveData when any source changes
        Runnable updateDashboard = () -> {
            SensorReading sensor = latestSensorReading.getValue();
            IoB iob = currentIoB.getValue();
            List<Meal> meals = recentMeals.getValue();

            // Only update if all essential data is available, or handle partial data
            // For simplicity, we'll update even if some parts are null initially
            dashboardLiveData.setValue(new DashboardData(sensor, iob, meals));
        };

        dashboardLiveData.addSource(latestSensorReading, sensorReading -> updateDashboard.run());
        dashboardLiveData.addSource(currentIoB, iob -> updateDashboard.run());
        dashboardLiveData.addSource(recentMeals, meals -> updateDashboard.run());

        return dashboardLiveData;
    }
}
