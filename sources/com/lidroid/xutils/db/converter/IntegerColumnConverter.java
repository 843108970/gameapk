package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class IntegerColumnConverter implements ColumnConverter<Integer> {
    public Object fieldValue2ColumnValue(Integer num) {
        return num;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Integer getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public Integer getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Integer.valueOf(str);
    }
}
