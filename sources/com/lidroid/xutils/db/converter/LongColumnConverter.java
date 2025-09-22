package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class LongColumnConverter implements ColumnConverter<Long> {
    public Object fieldValue2ColumnValue(Long l) {
        return l;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Long getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i));
    }

    public Long getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Long.valueOf(str);
    }
}
