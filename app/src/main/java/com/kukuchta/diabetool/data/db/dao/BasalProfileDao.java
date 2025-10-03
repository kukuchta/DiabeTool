package com.kukuchta.diabetool.data.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import com.kukuchta.diabetool.data.db.entity.BasalProfileEntity;
import com.kukuchta.diabetool.data.db.entity.BasalRateEntity;
import com.kukuchta.diabetool.data.db.relation.BasalProfileWithRates;
import java.util.List;

@Dao
public interface BasalProfileDao {

    /**
     * Inserts a new profile and its associated rates in a single transaction.
     */
    @Transaction
    default void insertProfileWithRates(BasalProfileEntity profile, List<BasalRateEntity> rates) {
        long profileId = insertProfile(profile);
        for (BasalRateEntity rate : rates) {
            rate.profileId = profileId;
        }
        insertRates(rates);
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertProfile(BasalProfileEntity profile);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRates(List<BasalRateEntity> rates);

    @Transaction
    @Query("SELECT * FROM basal_profiles WHERE profileName = :profileName")
    LiveData<BasalProfileWithRates> getProfileWithRates(String profileName);

    @Query("SELECT profileName FROM basal_profiles ORDER BY profileName ASC")
    LiveData<List<String>> getAllProfileNames();

    @Transaction
    @Query("SELECT * FROM basal_profiles")
    LiveData<List<BasalProfileWithRates>> getAllProfilesWithRates();
}
