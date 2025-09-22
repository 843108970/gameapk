package com.lidroid.xutils.db.table;

import android.text.TextUtils;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.db.converter.ColumnConverterFactory;
import com.lidroid.xutils.util.LogUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.io.FilenameUtils;

public class TableUtils {
    private static ConcurrentHashMap<String, HashMap<String, Column>> entityColumnsMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Id> entityIdMap = new ConcurrentHashMap<>();

    private TableUtils() {
    }

    private static void addColumns2Map(Class<?> cls, String str, HashMap<String, Column> hashMap) {
        String columnName;
        Column column;
        if (!Object.class.equals(cls)) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (!ColumnUtils.isTransient(field) && !Modifier.isStatic(field.getModifiers())) {
                        if (ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                            if (!field.getName().equals(str)) {
                                Column column2 = new Column(cls, field);
                                if (!hashMap.containsKey(column2.getColumnName())) {
                                    columnName = column2.getColumnName();
                                    column = column2;
                                }
                            }
                        } else if (ColumnUtils.isForeign(field)) {
                            Foreign foreign = new Foreign(cls, field);
                            if (!hashMap.containsKey(foreign.getColumnName())) {
                                columnName = foreign.getColumnName();
                                column = foreign;
                            }
                        } else if (ColumnUtils.isFinder(field)) {
                            Finder finder = new Finder(cls, field);
                            if (!hashMap.containsKey(finder.getColumnName())) {
                                columnName = finder.getColumnName();
                                column = finder;
                            }
                        }
                        hashMap.put(columnName, column);
                    }
                }
                if (!Object.class.equals(cls.getSuperclass())) {
                    addColumns2Map(cls.getSuperclass(), str, hashMap);
                }
            } catch (Throwable th) {
                LogUtils.e(th.getMessage(), th);
            }
        }
    }

    static synchronized HashMap<String, Column> getColumnMap(Class<?> cls) {
        synchronized (TableUtils.class) {
            if (entityColumnsMap.containsKey(cls.getName())) {
                HashMap<String, Column> hashMap = entityColumnsMap.get(cls.getName());
                return hashMap;
            }
            HashMap<String, Column> hashMap2 = new HashMap<>();
            addColumns2Map(cls, getPrimaryKeyFieldName(cls), hashMap2);
            entityColumnsMap.put(cls.getName(), hashMap2);
            return hashMap2;
        }
    }

    static Column getColumnOrId(Class<?> cls, String str) {
        return getPrimaryKeyColumnName(cls).equals(str) ? getId(cls) : getColumnMap(cls).get(str);
    }

    public static String getExecAfterTableCreated(Class<?> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        if (table != null) {
            return table.execAfterTableCreated();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        r1 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized com.lidroid.xutils.db.table.Id getId(java.lang.Class<?> r8) {
        /*
            java.lang.Class<com.lidroid.xutils.db.table.TableUtils> r0 = com.lidroid.xutils.db.table.TableUtils.class
            monitor-enter(r0)
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = r1.equals(r8)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0013
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "field 'id' not found"
            r8.<init>(r1)     // Catch:{ all -> 0x008a }
            throw r8     // Catch:{ all -> 0x008a }
        L_0x0013:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.lidroid.xutils.db.table.Id> r1 = entityIdMap     // Catch:{ all -> 0x008a }
            java.lang.String r2 = r8.getName()     // Catch:{ all -> 0x008a }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x002d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.lidroid.xutils.db.table.Id> r1 = entityIdMap     // Catch:{ all -> 0x008a }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x008a }
            java.lang.Object r8 = r1.get(r8)     // Catch:{ all -> 0x008a }
            com.lidroid.xutils.db.table.Id r8 = (com.lidroid.xutils.db.table.Id) r8     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
            return r8
        L_0x002d:
            r1 = 0
            java.lang.reflect.Field[] r2 = r8.getDeclaredFields()     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x006e
            int r3 = r2.length     // Catch:{ all -> 0x008a }
            r4 = 0
            r5 = 0
        L_0x0037:
            if (r5 < r3) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            r6 = r2[r5]     // Catch:{ all -> 0x008a }
            java.lang.Class<com.lidroid.xutils.db.annotation.Id> r7 = com.lidroid.xutils.db.annotation.Id.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x006b
            r1 = r6
        L_0x0045:
            if (r1 != 0) goto L_0x006e
            int r3 = r2.length     // Catch:{ all -> 0x008a }
        L_0x0048:
            if (r4 < r3) goto L_0x004b
            goto L_0x006e
        L_0x004b:
            r5 = r2[r4]     // Catch:{ all -> 0x008a }
            java.lang.String r6 = "id"
            java.lang.String r7 = r5.getName()     // Catch:{ all -> 0x008a }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x008a }
            if (r6 != 0) goto L_0x0069
            java.lang.String r6 = "_id"
            java.lang.String r7 = r5.getName()     // Catch:{ all -> 0x008a }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            int r4 = r4 + 1
            goto L_0x0048
        L_0x0069:
            r1 = r5
            goto L_0x006e
        L_0x006b:
            int r5 = r5 + 1
            goto L_0x0037
        L_0x006e:
            if (r1 != 0) goto L_0x007a
            java.lang.Class r8 = r8.getSuperclass()     // Catch:{ all -> 0x008a }
            com.lidroid.xutils.db.table.Id r8 = getId(r8)     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
            return r8
        L_0x007a:
            com.lidroid.xutils.db.table.Id r2 = new com.lidroid.xutils.db.table.Id     // Catch:{ all -> 0x008a }
            r2.<init>(r8, r1)     // Catch:{ all -> 0x008a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.lidroid.xutils.db.table.Id> r1 = entityIdMap     // Catch:{ all -> 0x008a }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x008a }
            r1.put(r8, r2)     // Catch:{ all -> 0x008a }
            monitor-exit(r0)
            return r2
        L_0x008a:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.db.table.TableUtils.getId(java.lang.Class):com.lidroid.xutils.db.table.Id");
    }

    private static String getPrimaryKeyColumnName(Class<?> cls) {
        Id id = getId(cls);
        if (id == null) {
            return null;
        }
        return id.getColumnName();
    }

    private static String getPrimaryKeyFieldName(Class<?> cls) {
        Id id = getId(cls);
        if (id == null) {
            return null;
        }
        return id.getColumnField().getName();
    }

    public static String getTableName(Class<?> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        return (table == null || TextUtils.isEmpty(table.name())) ? cls.getName().replace(FilenameUtils.EXTENSION_SEPARATOR, '_') : table.name();
    }
}
