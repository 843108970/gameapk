package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class FloatColumnConverter implements ColumnConverter<Float> {
    public Object fieldValue2ColumnValue(Float f) {
        return f;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }

    public Float getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    public Float getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Float.valueOf(str);
    }
}
