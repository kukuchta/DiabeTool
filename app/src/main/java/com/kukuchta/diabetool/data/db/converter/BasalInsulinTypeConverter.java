package com.kukuchta.diabetool.data.db.converter;

import androidx.room.TypeConverter;
import com.kukuchta.diabetool.domain.model.BasalInsulinType;

public class BasalInsulinTypeConverter {
    @TypeConverter
    public static String fromBasalInsulinType(BasalInsulinType type) {
        return type == null ? null : type.name();
    }

    @TypeConverter
    public static BasalInsulinType toBasalInsulinType(String name) {
        return name == null ? null : BasalInsulinType.valueOf(name);
    }
}
