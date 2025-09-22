package com.lidroid.xutils.db.table;

import com.lidroid.xutils.db.converter.ColumnConverter;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import com.lidroid.xutils.db.sqlite.ForeignLazyLoader;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.util.List;

public class Foreign extends Column {
    private final ColumnConverter foreignColumnConverter = ColumnConverterFactory.getColumnConverter(TableUtils.getColumnOrId(getForeignEntityType(), this.foreignColumnName).columnField.getType());
    private final String foreignColumnName;

    Foreign(Class<?> cls, Field field) {
        super(cls, field);
        this.foreignColumnName = ColumnUtils.getForeignColumnNameByField(field);
    }

    public ColumnDbType getColumnDbType() {
        return this.foreignColumnConverter.getColumnDbType();
    }

    public Object getColumnValue(Object obj) {
        Object fieldValue = getFieldValue(obj);
        Object obj2 = null;
        if (fieldValue != null) {
            Class<?> type = this.columnField.getType();
            if (type.equals(ForeignLazyLoader.class)) {
                return ((ForeignLazyLoader) fieldValue).getColumnValue();
            }
            if (type.equals(List.class)) {
                try {
                    List list = (List) fieldValue;
                    if (list.size() > 0) {
                        Column columnOrId = TableUtils.getColumnOrId(ColumnUtils.getForeignEntityType(this), this.foreignColumnName);
                        Object columnValue = columnOrId.getColumnValue(list.get(0));
                        try {
                            Table table = getTable();
                            if (table != null && (columnOrId instanceof Id)) {
                                for (Object next : list) {
                                    if (columnOrId.getColumnValue(next) == null) {
                                        table.db.saveOrUpdate(next);
                                    }
                                }
                            }
                            return columnOrId.getColumnValue(list.get(0));
                        } catch (Throwable th) {
                            th = th;
                            obj2 = columnValue;
                            LogUtils.e(th.getMessage(), th);
                            return obj2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    LogUtils.e(th.getMessage(), th);
                    return obj2;
                }
            } else {
                Column columnOrId2 = TableUtils.getColumnOrId(type, this.foreignColumnName);
                Object columnValue2 = columnOrId2.getColumnValue(fieldValue);
                try {
                    Table table2 = getTable();
                    if (table2 != null && columnValue2 == null && (columnOrId2 instanceof Id)) {
                        table2.db.saveOrUpdate(fieldValue);
                    }
                    return columnOrId2.getColumnValue(fieldValue);
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = columnValue2;
                    LogUtils.e(th.getMessage(), th);
                    return obj2;
                }
            }
        }
        return null;
    }

    public Object getDefaultValue() {
        return null;
    }

    public String getForeignColumnName() {
        return this.foreignColumnName;
    }

    public Class<?> getForeignEntityType() {
        return ColumnUtils.getForeignEntityType(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[SYNTHETIC, Splitter:B:17:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[SYNTHETIC, Splitter:B:23:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue2Entity(java.lang.Object r3, android.database.Cursor r4, int r5) {
        /*
            r2 = this;
            com.lidroid.xutils.db.converter.ColumnConverter r0 = r2.foreignColumnConverter
            java.lang.Object r4 = r0.getFieldValue(r4, r5)
            if (r4 != 0) goto L_0x0009
            return
        L_0x0009:
            r5 = 0
            java.lang.reflect.Field r0 = r2.columnField
            java.lang.Class r0 = r0.getType()
            java.lang.Class<com.lidroid.xutils.db.sqlite.ForeignLazyLoader> r1 = com.lidroid.xutils.db.sqlite.ForeignLazyLoader.class
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x001f
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r5 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader
            r5.<init>(r2, r4)
        L_0x001d:
            r4 = r5
            goto L_0x0043
        L_0x001f:
            java.lang.Class<java.util.List> r1 = java.util.List.class
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003a
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r0 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader     // Catch:{ DbException -> 0x0031 }
            r0.<init>(r2, r4)     // Catch:{ DbException -> 0x0031 }
            java.util.List r4 = r0.getAllFromDb()     // Catch:{ DbException -> 0x0031 }
            goto L_0x0043
        L_0x0031:
            r4 = move-exception
            java.lang.String r0 = r4.getMessage()
            com.lidroid.xutils.util.LogUtils.e(r0, r4)
            goto L_0x001d
        L_0x003a:
            com.lidroid.xutils.db.sqlite.ForeignLazyLoader r0 = new com.lidroid.xutils.db.sqlite.ForeignLazyLoader     // Catch:{ DbException -> 0x0031 }
            r0.<init>(r2, r4)     // Catch:{ DbException -> 0x0031 }
            java.lang.Object r4 = r0.getFirstFromDb()     // Catch:{ DbException -> 0x0031 }
        L_0x0043:
            java.lang.reflect.Method r5 = r2.setMethod
            r0 = 1
            if (r5 == 0) goto L_0x005c
            java.lang.reflect.Method r5 = r2.setMethod     // Catch:{ Throwable -> 0x0053 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0053 }
            r1 = 0
            r0[r1] = r4     // Catch:{ Throwable -> 0x0053 }
            r5.invoke(r3, r0)     // Catch:{ Throwable -> 0x0053 }
            return
        L_0x0053:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.lidroid.xutils.util.LogUtils.e(r4, r3)
            return
        L_0x005c:
            java.lang.reflect.Field r5 = r2.columnField     // Catch:{ Throwable -> 0x0053 }
            r5.setAccessible(r0)     // Catch:{ Throwable -> 0x0053 }
            java.lang.reflect.Field r5 = r2.columnField     // Catch:{ Throwable -> 0x0053 }
            r5.set(r3, r4)     // Catch:{ Throwable -> 0x0053 }
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.db.table.Foreign.setValue2Entity(java.lang.Object, android.database.Cursor, int):void");
    }
}
