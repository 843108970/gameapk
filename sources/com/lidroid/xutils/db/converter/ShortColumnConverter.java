package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ShortColumnConverter implements ColumnConverter<Short> {
    public Object fieldValue2ColumnValue(Short sh) {
        return sh;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Short getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }

    public Short getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Short.valueOf(str);
    }
}
