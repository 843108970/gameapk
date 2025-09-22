package com.lidroid.xutils.db.table;

import android.database.Cursor;
import com.lidroid.xutils.db.converter.ColumnConverter;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Column {
    protected final ColumnConverter columnConverter;
    protected final Field columnField;
    protected final String columnName;
    private final Object defaultValue;
    protected final Method getMethod;
    private int index = -1;
    protected final Method setMethod;
    private Table table;

    Column(Class<?> cls, Field field) {
        this.columnField = field;
        this.columnConverter = ColumnConverterFactory.getColumnConverter(field.getType());
        this.columnName = ColumnUtils.getColumnNameByField(field);
        this.defaultValue = this.columnConverter != null ? this.columnConverter.getFieldValue(ColumnUtils.getColumnDefaultValue(field)) : null;
        this.getMethod = ColumnUtils.getColumnGetMethod(cls, field);
        this.setMethod = ColumnUtils.getColumnSetMethod(cls, field);
    }

    public ColumnConverter getColumnConverter() {
        return this.columnConverter;
    }

    public ColumnDbType getColumnDbType() {
        return this.columnConverter.getColumnDbType();
    }

    public Field getColumnField() {
        return this.columnField;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public Object getColumnValue(Object obj) {
        return this.columnConverter.fieldValue2ColumnValue(getFieldValue(obj));
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public Object getFieldValue(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.getMethod != null) {
            try {
                return this.getMethod.invoke(obj, new Object[0]);
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
                return null;
            }
        } else {
            this.columnField.setAccessible(true);
            return this.columnField.get(obj);
        }
    }

    public int getIndex() {
        return this.index;
    }

    public Table getTable() {
        return this.table;
    }

    /* access modifiers changed from: package-private */
    public void setTable(Table table2) {
        this.table = table2;
    }

    public void setValue2Entity(Object obj, Cursor cursor, int i) {
        this.index = i;
        Object fieldValue = this.columnConverter.getFieldValue(cursor, i);
        if (fieldValue != null || this.defaultValue != null) {
            if (this.setMethod != null) {
                try {
                    Method method = this.setMethod;
                    Object[] objArr = new Object[1];
                    if (fieldValue == null) {
                        fieldValue = this.defaultValue;
                    }
                    objArr[0] = fieldValue;
                    method.invoke(obj, objArr);
                } catch (Throwable th) {
                    LogUtils.e(th.getMessage(), th);
                }
            } else {
                this.columnField.setAccessible(true);
                Field field = this.columnField;
                if (fieldValue == null) {
                    fieldValue = this.defaultValue;
                }
                field.set(obj, fieldValue);
            }
        }
    }
}
