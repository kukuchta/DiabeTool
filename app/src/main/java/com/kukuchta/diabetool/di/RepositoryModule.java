package com.kukuchta.diabetool.di;

import com.kukuchta.diabetool.data.db.dao.BasalDao;
import com.kukuchta.diabetool.data.db.dao.BasalProfileDao;
import com.kukuchta.diabetool.data.db.dao.BloodMeasurementDao;
import com.kukuchta.diabetool.data.db.dao.BolusDao;
import com.kukuchta.diabetool.data.db.dao.InsulinActivityDao;
import com.kukuchta.diabetool.data.db.dao.IoBDao;
import com.kukuchta.diabetool.data.db.dao.MealDao;
import com.kukuchta.diabetool.data.db.dao.NotificationDao;
import com.kukuchta.diabetool.data.db.dao.SensorReadingDao;
import com.kukuchta.diabetool.data.repository.BasalProfileRepositoryImpl;
import com.kukuchta.diabetool.data.repository.BasalRepositoryImpl;
import com.kukuchta.diabetool.data.repository.BloodMeasurementRepositoryImpl;
import com.kukuchta.diabetool.data.repository.BolusRepositoryImpl;
import com.kukuchta.diabetool.data.repository.InsulinActivityRepositoryImpl;
import com.kukuchta.diabetool.data.repository.IoBRepositoryImpl;
import com.kukuchta.diabetool.data.repository.MealRepositoryImpl;
import com.kukuchta.diabetool.data.repository.NotificationRepositoryImpl;
import com.kukuchta.diabetool.data.repository.SensorReadingRepositoryImpl;
import com.kukuchta.diabetool.domain.repository.BasalProfileRepository;
import com.kukuchta.diabetool.domain.repository.BasalRepository;
import com.kukuchta.diabetool.domain.repository.BloodMeasurementRepository;
import com.kukuchta.diabetool.domain.repository.BolusRepository;
import com.kukuchta.diabetool.domain.repository.InsulinActivityRepository;
import com.kukuchta.diabetool.domain.repository.IoBRepository;
import com.kukuchta.diabetool.domain.repository.MealRepository;
import com.kukuchta.diabetool.domain.repository.NotificationRepository;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {


    @Provides
    @Singleton
    public BasalProfileRepository provideBasalProfileRepository(BasalProfileDao basalProfileDao) {
        return new BasalProfileRepositoryImpl(basalProfileDao);
    }

    @Provides
    @Singleton
    public BasalRepository provideBasalRepository(BasalDao basalDao) {
        return new BasalRepositoryImpl(basalDao);
    }

    @Provides
    @Singleton
    public BloodMeasurementRepository provideBloodMeasurementRepository(BloodMeasurementDao bloodMeasurementDao) {
        return new BloodMeasurementRepositoryImpl(bloodMeasurementDao);
    }

    @Provides
    @Singleton
    public BolusRepository provideBolusRepository(BolusDao bolusDao) {
        return new BolusRepositoryImpl(bolusDao);
    }

    @Provides
    @Singleton
    public InsulinActivityRepository provideInsulinActivityRepository(InsulinActivityDao insulinActivityDao) {
        return new InsulinActivityRepositoryImpl(insulinActivityDao);
    }

    @Provides
    @Singleton
    public IoBRepository provideIoBRepository(IoBDao iobDao) {
        return new IoBRepositoryImpl(iobDao);
    }

    @Provides
    @Singleton
    public MealRepository provideMealRepository(MealDao mealDao) {
        return new MealRepositoryImpl(mealDao);
    }

    @Provides
    @Singleton
    public NotificationRepository provideNotificationRepository(NotificationDao notificationDao) {
        return new NotificationRepositoryImpl(notificationDao);
    }

    @Provides
    @Singleton
    public SensorReadingRepository provideSensorReadingRepository(SensorReadingDao sensorReadingDao) {
        return new SensorReadingRepositoryImpl(sensorReadingDao);
    }
}
