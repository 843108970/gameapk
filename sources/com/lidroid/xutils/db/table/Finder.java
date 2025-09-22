package com.lidroid.xutils.db.table;

import android.database.Cursor;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import com.lidroid.xutils.db.sqlite.FinderLazyLoader;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.util.List;

public class Finder extends Column {
    private final String targetColumnName;
    private final String valueColumnName;

    Finder(Class<?> cls, Field field) {
        super(cls, field);
        com.lidroid.xutils.db.annotation.Finder finder = (com.lidroid.xutils.db.annotation.Finder) field.getAnnotation(com.lidroid.xutils.db.annotation.Finder.class);
        this.valueColumnName = finder.valueColumn();
        this.targetColumnName = finder.targetColumn();
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.TEXT;
    }

    public Object getColumnValue(Object obj) {
        return null;
    }

    public Object getDefaultValue() {
        return null;
    }

    public String getTargetColumnName() {
        return this.targetColumnName;
    }

    public Class<?> getTargetEntityType() {
        return ColumnUtils.getFinderTargetEntityType(this);
    }

    public void setValue2Entity(Object obj, Cursor cursor, int i) {
        Object obj2;
        Class<?> type = this.columnField.getType();
        Object columnValue = TableUtils.getColumnOrId(obj.getClass(), this.valueColumnName).getColumnValue(obj);
        if (type.equals(FinderLazyLoader.class)) {
            obj2 = new FinderLazyLoader(this, columnValue);
        } else if (type.equals(List.class)) {
            try {
                obj2 = new FinderLazyLoader(this, columnValue).getAllFromDb();
            } catch (DbException e) {
                LogUtils.e(e.getMessage(), e);
                obj2 = null;
            }
        } else {
            obj2 = new FinderLazyLoader(this, columnValue).getFirstFromDb();
        }
        if (this.setMethod != null) {
            try {
                this.setMethod.invoke(obj, new Object[]{obj2});
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
            }
        } else {
            this.columnField.setAccessible(true);
            this.columnField.set(obj, obj2);
        }
    }
}
