package com.kukuchta.diabetool.data.db.relation;

import androidx.room.Embedded;
import androidx.room.Relation;
import com.kukuchta.diabetool.data.db.entity.BasalProfileEntity;
import com.kukuchta.diabetool.data.db.entity.BasalRateEntity;
import java.util.List;

public class BasalProfileWithRates {

    @Embedded
    public BasalProfileEntity profile;

    @Relation(
            parentColumn = "id",
            entityColumn = "profileId"
    )
    public List<BasalRateEntity> rates;
}
