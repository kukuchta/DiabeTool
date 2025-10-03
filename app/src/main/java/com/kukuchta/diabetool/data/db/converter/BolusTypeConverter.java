package com.kukuchta.diabetool.data.db.converter;

import androidx.room.TypeConverter;
import com.kukuchta.diabetool.domain.model.BolusType;

public class BolusTypeConverter {
    @TypeConverter
    public static String fromBolusType(BolusType type) {
        return type == null ? null : type.name();
    }

    @TypeConverter
    public static BolusType toBolusType(String name) {
        return name == null ? null : BolusType.valueOf(name);
    }
}

