package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class DoubleColumnConverter implements ColumnConverter<Double> {
    public Object fieldValue2ColumnValue(Double d) {
        return d;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }

    public Double getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public Double getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Double.valueOf(str);
    }
}
