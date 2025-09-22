package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class CharColumnConverter implements ColumnConverter<Character> {
    public Object fieldValue2ColumnValue(Character ch) {
        if (ch == null) {
            return null;
        }
        return Integer.valueOf(ch.charValue());
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Character getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return Character.valueOf((char) cursor.getInt(i));
    }

    public Character getFieldValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }
}
