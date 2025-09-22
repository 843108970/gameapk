package com.lidroid.xutils.db.converter;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;

public class ByteArrayColumnConverter implements ColumnConverter<byte[]> {
    public Object fieldValue2ColumnValue(byte[] bArr) {
        return bArr;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.BLOB;
    }

    public byte[] getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        return cursor.getBlob(i);
    }

    public byte[] getFieldValue(String str) {
        return null;
    }
}
