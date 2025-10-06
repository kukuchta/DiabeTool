package com.kukuchta.diabetool.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kukuchta.diabetool.data.db.converter.BasalInsulinTypeConverter;
import com.kukuchta.diabetool.data.db.converter.BolusTypeConverter;
import com.kukuchta.diabetool.data.db.converter.DateConverter;
import com.kukuchta.diabetool.data.db.converter.NotificationTypeConverter;
import com.kukuchta.diabetool.data.db.dao.BasalDao;
import com.kukuchta.diabetool.data.db.dao.BasalProfileDao;
import com.kukuchta.diabetool.data.db.dao.BloodMeasurementDao;
import com.kukuchta.diabetool.data.db.dao.BolusDao;
import com.kukuchta.diabetool.data.db.dao.InsulinActivityDao;
import com.kukuchta.diabetool.data.db.dao.IoBDao;
import com.kukuchta.diabetool.data.db.dao.MealDao;
import com.kukuchta.diabetool.data.db.dao.NotificationDao;
import com.kukuchta.diabetool.data.db.dao.SensorReadingDao;
import com.kukuchta.diabetool.data.db.entity.BasalEntity;
import com.kukuchta.diabetool.data.db.entity.BasalProfileEntity;
import com.kukuchta.diabetool.data.db.entity.BasalRateEntity;
import com.kukuchta.diabetool.data.db.entity.BloodMeasurementEntity;
import com.kukuchta.diabetool.data.db.entity.BolusEntity;
import com.kukuchta.diabetool.data.db.entity.InsulinActivityEntity;
import com.kukuchta.diabetool.data.db.entity.IoBEntity;
import com.kukuchta.diabetool.data.db.entity.MealEntity;
import com.kukuchta.diabetool.data.db.entity.NotificationEntity;
import com.kukuchta.diabetool.data.db.entity.SensorReadingEntity;

@Database(
        entities = {
                BasalEntity.class,
                BasalProfileEntity.class,
                BasalRateEntity.class,
                BloodMeasurementEntity.class,
                BolusEntity.class,
                InsulinActivityEntity.class,
                IoBEntity.class,
                MealEntity.class,
                NotificationEntity.class,
                SensorReadingEntity.class
        },
        version = 1 // Start at version 1. Increment this when you change the schema.
)
@TypeConverters(
        {
                BasalInsulinTypeConverter.class,
                BolusTypeConverter.class,
                DateConverter.class,
                NotificationTypeConverter.class
        })
public abstract class AppDatabase extends RoomDatabase {

    // Define all your DAOs as abstract methods
    public abstract BasalDao basalDao();
    public abstract BasalProfileDao basalProfileDao();
    public abstract BloodMeasurementDao bloodMeasurementDao();
    public abstract BolusDao bolusDao();
    public abstract InsulinActivityDao insulinActivityDao();
    public abstract IoBDao iobDao();
    public abstract MealDao mealDao();
    public abstract NotificationDao notificationDao();
    public abstract SensorReadingDao sensorReadingDao();


    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "diabetool-db";

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DATABASE_NAME)
                            // In a real app, you would need to implement a proper migration strategy
                            // for when you update the 'version'.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
