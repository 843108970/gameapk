package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ByteColumnConverter implements ColumnConverter<Byte> {
    public Object fieldValue2ColumnValue(Byte b2) {
        return b2;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Byte getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Byte.valueOf((byte) cursor.getInt(i));
    }

    public Byte getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Byte.valueOf(str);
    }
}
