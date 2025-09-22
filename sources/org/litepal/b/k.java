package org.litepal.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.a.b;
import org.litepal.c.e;
import org.litepal.f;
import org.litepal.g.a;
import org.litepal.g.c;

public class k extends b {
    public k(SQLiteDatabase sQLiteDatabase) {
        this.e = sQLiteDatabase;
    }

    private int a(e eVar, long j, ContentValues contentValues) {
        int i;
        try {
            a(eVar, b(eVar.getClassName()));
            Map<String, Long> associatedModelsMapWithoutFK = eVar.getAssociatedModelsMapWithoutFK();
            for (String next : associatedModelsMapWithoutFK.keySet()) {
                contentValues.put(f(next), associatedModelsMapWithoutFK.get(next));
            }
            Map<String, Set<Long>> associatedModelsMapWithFK = eVar.getAssociatedModelsMapWithFK();
            ContentValues contentValues2 = new ContentValues();
            Iterator<String> it = associatedModelsMapWithFK.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = 0;
                    break;
                }
                String next2 = it.next();
                contentValues2.clear();
                contentValues2.put(f(eVar.getTableName()), Long.valueOf(j));
                Set set = associatedModelsMapWithFK.get(next2);
                if (set != null && !set.isEmpty()) {
                    i = this.e.update(next2, contentValues2, a((Collection<Long>) set), (String[]) null);
                    break;
                }
            }
            return 0 + i;
        } catch (Exception e) {
            throw new e(e.getMessage(), e);
        }
    }

    public static void a(ContentValues contentValues) {
        if (Build.VERSION.SDK_INT >= 11) {
            HashMap hashMap = new HashMap();
            for (String next : contentValues.keySet()) {
                if (c.c(next)) {
                    hashMap.put(next, contentValues.get(next));
                }
            }
            for (String str : hashMap.keySet()) {
                String d = c.d(str);
                Object obj = contentValues.get(str);
                contentValues.remove(str);
                if (obj == null) {
                    contentValues.putNull(d);
                } else {
                    String name = obj.getClass().getName();
                    if ("java.lang.Byte".equals(name)) {
                        contentValues.put(d, (Byte) obj);
                    } else if ("[B".equals(name)) {
                        contentValues.put(d, (byte[]) obj);
                    } else if ("java.lang.Boolean".equals(name)) {
                        contentValues.put(d, (Boolean) obj);
                    } else if ("java.lang.String".equals(name)) {
                        contentValues.put(d, (String) obj);
                    } else if ("java.lang.Float".equals(name)) {
                        contentValues.put(d, (Float) obj);
                    } else if ("java.lang.Long".equals(name)) {
                        contentValues.put(d, (Long) obj);
                    } else if ("java.lang.Integer".equals(name)) {
                        contentValues.put(d, (Integer) obj);
                    } else if ("java.lang.Short".equals(name)) {
                        contentValues.put(d, (Short) obj);
                    } else if ("java.lang.Double".equals(name)) {
                        contentValues.put(d, (Double) obj);
                    }
                }
            }
        }
    }

    private static void a(e eVar, ContentValues contentValues) {
        Map<String, Long> associatedModelsMapWithoutFK = eVar.getAssociatedModelsMapWithoutFK();
        for (String next : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(f(next), associatedModelsMapWithoutFK.get(next));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0096, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a7, code lost:
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        r8 = r15;
        r1 = r0;
        r7 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a6 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.litepal.b.e r16, android.content.ContentValues r17, long... r18) {
        /*
            r15 = this;
            r1 = r18
            r2 = 0
            org.litepal.b.e r3 = r15.a((org.litepal.b.e) r16)     // Catch:{ NoSuchFieldException -> 0x00b3, Exception -> 0x00a6 }
            java.lang.Class r4 = r3.getClass()     // Catch:{ NoSuchFieldException -> 0x00b3, Exception -> 0x00a6 }
            java.util.List r5 = r16.getFieldsToSetToDefault()     // Catch:{ NoSuchFieldException -> 0x00b3, Exception -> 0x00a6 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ NoSuchFieldException -> 0x00b3, Exception -> 0x00a6 }
            r6 = r2
        L_0x0014:
            boolean r7 = r5.hasNext()     // Catch:{ NoSuchFieldException -> 0x00a1, Exception -> 0x00a6 }
            if (r7 == 0) goto L_0x009f
            java.lang.Object r7 = r5.next()     // Catch:{ NoSuchFieldException -> 0x00a1, Exception -> 0x00a6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NoSuchFieldException -> 0x00a1, Exception -> 0x00a6 }
            boolean r8 = e((java.lang.String) r7)     // Catch:{ NoSuchFieldException -> 0x00a1, Exception -> 0x00a6 }
            if (r8 != 0) goto L_0x009a
            java.lang.reflect.Field r6 = r4.getDeclaredField(r7)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.Class r8 = r6.getType()     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            boolean r8 = a((java.lang.Class<?>) r8)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            if (r8 == 0) goto L_0x008b
            if (r1 == 0) goto L_0x0087
            int r8 = r1.length     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            if (r8 <= 0) goto L_0x0087
            java.lang.String r8 = b((java.lang.reflect.Field) r6)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            boolean r8 = org.litepal.g.a.c(r8)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            if (r8 == 0) goto L_0x0084
            java.lang.String r8 = r16.getClassName()     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.String r6 = r6.getName()     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.String r6 = org.litepal.g.c.b((java.lang.String) r8, (java.lang.String) r6)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.String r8 = r16.getClassName()     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.String r8 = org.litepal.g.c.b(r8)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            r9.<init>()     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            int r10 = r1.length     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            r11 = 0
            r12 = 0
        L_0x005f:
            if (r11 >= r10) goto L_0x0079
            r13 = r1[r11]     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            if (r12 == 0) goto L_0x006a
            java.lang.String r12 = " or "
            r9.append(r12)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
        L_0x006a:
            r9.append(r8)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            java.lang.String r12 = " = "
            r9.append(r12)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            r9.append(r13)     // Catch:{ NoSuchFieldException -> 0x0096, Exception -> 0x00a6 }
            int r11 = r11 + 1
            r12 = 1
            goto L_0x005f
        L_0x0079:
            r8 = r15
            android.database.sqlite.SQLiteDatabase r10 = r8.e     // Catch:{ NoSuchFieldException -> 0x0094, Exception -> 0x0092 }
            java.lang.String r9 = r9.toString()     // Catch:{ NoSuchFieldException -> 0x0094, Exception -> 0x0092 }
            r10.delete(r6, r9, r2)     // Catch:{ NoSuchFieldException -> 0x0094, Exception -> 0x0092 }
            goto L_0x0085
        L_0x0084:
            r8 = r15
        L_0x0085:
            r6 = r7
            goto L_0x0014
        L_0x0087:
            r8 = r15
            r9 = r17
            goto L_0x0085
        L_0x008b:
            r8 = r15
            r9 = r17
            a((org.litepal.b.e) r3, (java.lang.reflect.Field) r6, (android.content.ContentValues) r9)     // Catch:{ NoSuchFieldException -> 0x0094, Exception -> 0x0092 }
            goto L_0x0085
        L_0x0092:
            r0 = move-exception
            goto L_0x00a8
        L_0x0094:
            r0 = move-exception
            goto L_0x0098
        L_0x0096:
            r0 = move-exception
            r8 = r15
        L_0x0098:
            r1 = r0
            goto L_0x00b7
        L_0x009a:
            r8 = r15
            r9 = r17
            goto L_0x0014
        L_0x009f:
            r8 = r15
            return
        L_0x00a1:
            r0 = move-exception
            r8 = r15
            r1 = r0
            r7 = r6
            goto L_0x00b7
        L_0x00a6:
            r0 = move-exception
            r8 = r15
        L_0x00a8:
            r1 = r0
            org.litepal.c.e r2 = new org.litepal.c.e
            java.lang.String r3 = r1.getMessage()
            r2.<init>(r3, r1)
            throw r2
        L_0x00b3:
            r0 = move-exception
            r8 = r15
            r1 = r0
            r7 = r2
        L_0x00b7:
            org.litepal.c.e r2 = new org.litepal.c.e
            java.lang.String r3 = r16.getClassName()
            java.lang.String r3 = org.litepal.c.e.noSuchFieldExceptioin(r3, r7)
            r2.<init>(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.k.a(org.litepal.b.e, android.content.ContentValues, long[]):void");
    }

    private void a(e eVar, List<Field> list, long... jArr) throws IllegalAccessException, InvocationTargetException {
        Field field;
        Iterator it;
        long[] jArr2 = jArr;
        if (jArr2.length > 0) {
            Iterator<Field> it2 = list.iterator();
            while (it2.hasNext()) {
                Field next = it2.next();
                b bVar = (b) next.getAnnotation(b.class);
                String b2 = b(next);
                String a2 = (bVar == null || !"java.lang.String".equals(b2)) ? null : bVar.a();
                next.setAccessible(true);
                Collection collection = (Collection) next.get(eVar);
                if (collection != null && !collection.isEmpty()) {
                    String b3 = c.b(eVar.getClassName(), next.getName());
                    String b4 = c.b(eVar.getClassName());
                    int length = jArr2.length;
                    int i = 0;
                    while (i < length) {
                        long j = jArr2[i];
                        SQLiteDatabase sQLiteDatabase = this.e;
                        Iterator<Field> it3 = it2;
                        sQLiteDatabase.delete(b3, b4 + " = ?", new String[]{String.valueOf(j)});
                        Iterator it4 = collection.iterator();
                        while (it4.hasNext()) {
                            Object next2 = it4.next();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(b4, Long.valueOf(j));
                            Object a3 = a(a2, next2);
                            if (eVar.getClassName().equals(b2)) {
                                e eVar2 = (e) a3;
                                if (eVar2 != null) {
                                    it = it4;
                                    long baseObjId = eVar2.getBaseObjId();
                                    if (baseObjId > 0) {
                                        contentValues.put(c.a(next), Long.valueOf(baseObjId));
                                        field = next;
                                    } else {
                                        it4 = it;
                                    }
                                }
                            } else {
                                it = it4;
                                field = next;
                                d.a(contentValues, "put", new Object[]{c.d(a.a(next.getName())), a3}, contentValues.getClass(), new Class[]{String.class, a(next)});
                            }
                            this.e.insert(b3, (String) null, contentValues);
                            it4 = it;
                            next = field;
                        }
                        Field field2 = next;
                        i++;
                        it2 = it3;
                        jArr2 = jArr;
                    }
                }
                it2 = it2;
                jArr2 = jArr;
            }
        }
    }

    private int b(String str, ContentValues contentValues, String... strArr) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        a(contentValues);
        return a(str, contentValues, strArr);
    }

    private void b(e eVar) {
        try {
            a(eVar, b(eVar.getClassName()));
        } catch (Exception e) {
            throw new e(e.getMessage(), e);
        }
    }

    private int c(e eVar, long j) {
        Map<String, Set<Long>> associatedModelsMapWithFK = eVar.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String next : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(f(eVar.getTableName()), Long.valueOf(j));
            Set set = associatedModelsMapWithFK.get(next);
            if (set != null && !set.isEmpty()) {
                return this.e.update(next, contentValues, a((Collection<Long>) set), (String[]) null);
            }
        }
        return 0;
    }

    public final int a(Class<?> cls, long j, ContentValues contentValues) {
        if (contentValues.size() <= 0) {
            return 0;
        }
        a(contentValues);
        SQLiteDatabase sQLiteDatabase = this.e;
        String b2 = b(cls);
        return sQLiteDatabase.update(b2, contentValues, "id = " + j, (String[]) null);
    }

    public final int a(String str, ContentValues contentValues, String... strArr) {
        a.a(strArr);
        if (contentValues.size() > 0) {
            return this.e.update(str, contentValues, a(strArr), b(strArr));
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int a(e eVar, String... strArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = c.e(strArr[0]);
        }
        List<Field> c2 = c(eVar.getClassName());
        List<Field> d = d(eVar.getClassName());
        long[] jArr = null;
        if (!d.isEmpty()) {
            org.litepal.b a2 = f.a("id");
            a2.f4643b = strArr;
            List<?> a3 = a2.a(eVar.getClass(), false);
            if (a3.size() > 0) {
                jArr = new long[a3.size()];
                for (int i = 0; i < jArr.length; i++) {
                    jArr[i] = ((e) a3.get(i)).getBaseObjId();
                }
                a(eVar, d, jArr);
            }
        }
        ContentValues contentValues = new ContentValues();
        a(eVar, c2, contentValues);
        a(eVar, contentValues, jArr);
        return a(eVar.getTableName(), contentValues, strArr);
    }

    /* access modifiers changed from: package-private */
    public final int b(e eVar, long j) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<Field> c2 = c(eVar.getClassName());
        a(eVar, d(eVar.getClassName()), j);
        ContentValues contentValues = new ContentValues();
        a(eVar, c2, contentValues);
        a(eVar, contentValues, j);
        if (contentValues.size() <= 0) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.e;
        String tableName = eVar.getTableName();
        return sQLiteDatabase.update(tableName, contentValues, "id = " + j, (String[]) null);
    }
}
