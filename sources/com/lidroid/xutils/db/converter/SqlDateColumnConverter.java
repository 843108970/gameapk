package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.sql.Date;

public class SqlDateColumnConverter implements ColumnConverter<Date> {
    public Object fieldValue2ColumnValue(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Date getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return new Date(cursor.getLong(i));
    }

    public Date getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Date(Long.valueOf(str).longValue());
    }
}
