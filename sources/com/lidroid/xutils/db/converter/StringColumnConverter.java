package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class StringColumnConverter implements ColumnConverter<String> {
    public Object fieldValue2ColumnValue(String str) {
        return str;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.TEXT;
    }

    public String getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getString(i);
    }

    public String getFieldValue(String str) {
        return str;
    }
}
