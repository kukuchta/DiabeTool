package com.kukuchta.diabetool.di;

import android.content.Context;
import androidx.room.Room;
import com.kukuchta.diabetool.data.db.AppDatabase;
import com.kukuchta.diabetool.data.db.dao.*;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class) // Dependencies live as long as the application
public class DatabaseModule {

    @Provides
    @Singleton // Ensures only one instance of the database is created
    public AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "diabetool-db"
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @Singleton
    public BasalDao provideBasalDao(AppDatabase db) {
        return db.basalDao();
    }

    @Provides
    @Singleton
    public BasalProfileDao provideBasalProfileDao(AppDatabase db) {
        return db.basalProfileDao();
    }

    @Provides
    @Singleton
    public BloodMeasurementDao provideBloodMeasurementDao(AppDatabase db) {
        return db.bloodMeasurementDao();
    }

    @Provides
    @Singleton
    public BolusDao provideBolusDao(AppDatabase db) {
        return db.bolusDao();
    }

    @Provides
    @Singleton
    public InsulinActivityDao provideInsulinActivityDao(AppDatabase db) {
        return db.insulinActivityDao();
    }

    @Provides
    @Singleton
    public IoBDao provideIoBDao(AppDatabase db) {
        return db.iobDao();
    }

    @Provides
    @Singleton
    public MealDao provideMealDao(AppDatabase db) {
        return db.mealDao();
    }

    @Provides
    @Singleton
    public NotificationDao provideNotificationDao(AppDatabase db) {
        return db.notificationDao();
    }

    @Provides
    @Singleton
    public SensorReadingDao provideSensorReadingDao(AppDatabase db) {
        return db.sensorReadingDao();
    }
}
