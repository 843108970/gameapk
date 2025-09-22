package org.litepal.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.ActivityChooserView;
import android.util.SparseArray;
import com.umeng.commonsdk.proguard.v;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import net.grandcentrix.tray.provider.TrayContract;
import org.litepal.c.e;
import org.litepal.d;
import org.litepal.f;
import org.litepal.g.c;

abstract class b extends d {
    public static final String d = "DataHandler";
    SQLiteDatabase e;
    private e f;
    private List<org.litepal.b.c.a> g;
    private List<org.litepal.b.c.a> h;

    class a {

        /* renamed from: a  reason: collision with root package name */
        String f4692a;

        /* renamed from: b  reason: collision with root package name */
        Field f4693b;

        a() {
        }
    }

    b() {
    }

    private Object a(Class<?> cls, Class<?> cls2) {
        String name = cls2.getName();
        if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
            return false;
        }
        if ("float".equals(name) || "java.lang.Float".equals(name)) {
            return Float.valueOf(0.0f);
        }
        if ("double".equals(name) || "java.lang.Double".equals(name)) {
            return Double.valueOf(0.0d);
        }
        if ("int".equals(name) || "java.lang.Integer".equals(name)) {
            return 0;
        }
        if ("long".equals(name) || "java.lang.Long".equals(name)) {
            return 0L;
        }
        if ("short".equals(name) || "java.lang.Short".equals(name)) {
            return 0;
        }
        if ("char".equals(name) || "java.lang.Character".equals(name)) {
            return ' ';
        }
        if ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) {
            return new byte[0];
        }
        if ("java.lang.String".equals(name)) {
            return "";
        }
        if (cls == cls2) {
            return null;
        }
        return c(cls2);
    }

    protected static Object a(String str, Object obj) {
        return (str == null || obj == null) ? obj : "AES".equalsIgnoreCase(str) ? org.litepal.g.a.b.a((String) obj) : "MD5".equalsIgnoreCase(str) ? org.litepal.g.a.b.c((String) obj) : obj;
    }

    protected static Object a(e eVar, Field field) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (b(eVar, field)) {
            return d.a(eVar, field.getName(), eVar.getClass());
        }
        return null;
    }

    protected static String a(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Long longValue : collection) {
            long longValue2 = longValue.longValue();
            if (z) {
                sb.append(" or ");
            }
            z = true;
            sb.append("id = ");
            sb.append(longValue2);
        }
        return org.litepal.g.a.a(sb.toString());
    }

    protected static String a(e eVar, String str) {
        return org.litepal.g.a.a(c.a(eVar.getTableName(), str));
    }

    private static String a(long... jArr) {
        StringBuilder sb = new StringBuilder();
        int length = jArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            long j = jArr[i];
            if (z) {
                sb.append(" or ");
            }
            sb.append("id = ");
            sb.append(j);
            i++;
            z = true;
        }
        return org.litepal.g.a.a(sb.toString());
    }

    protected static String a(String... strArr) {
        new Object[1][0] = strArr;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return strArr[0];
    }

    private static void a(Object obj, Field field, int i, String str, Cursor cursor) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean invoke = cursor.getClass().getMethod(str, new Class[]{Integer.TYPE}).invoke(cursor, new Object[]{Integer.valueOf(i)});
        if (field.getType() == Boolean.TYPE || field.getType() == Boolean.class) {
            if ("0".equals(String.valueOf(invoke))) {
                invoke = false;
            } else if ("1".equals(String.valueOf(invoke))) {
                invoke = true;
            }
        } else if (field.getType() == Character.TYPE || field.getType() == Character.class) {
            invoke = Character.valueOf(((String) invoke).charAt(0));
        } else if (field.getType() == Date.class) {
            long longValue = ((Long) invoke).longValue();
            invoke = longValue <= 0 ? null : new Date(longValue);
        }
        if (a(field.getType())) {
            Collection collection = (Collection) d.a(obj, field.getName(), obj.getClass());
            if (collection == null) {
                collection = List.class.isAssignableFrom(field.getType()) ? new ArrayList() : new HashSet();
                d.b(obj, field.getName(), collection, obj.getClass());
            }
            String b2 = b(field);
            if ("java.lang.String".equals(b2)) {
                org.litepal.a.b bVar = (org.litepal.a.b) field.getAnnotation(org.litepal.a.b.class);
                if (bVar != null) {
                    invoke = b(bVar.a(), (Object) invoke);
                }
            } else if (obj.getClass().getName().equals(b2) && ((invoke instanceof Long) || (invoke instanceof Integer))) {
                invoke = f.a(obj.getClass(), ((Long) invoke).longValue());
            }
            collection.add(invoke);
            return;
        }
        org.litepal.a.b bVar2 = (org.litepal.a.b) field.getAnnotation(org.litepal.a.b.class);
        if (bVar2 != null && "java.lang.String".equals(field.getType().getName())) {
            invoke = b(bVar2.a(), (Object) invoke);
        }
        d.b(obj, field.getName(), invoke, obj.getClass());
    }

    private void a(Object obj, List<Field> list, List<org.litepal.b.c.a> list2, Cursor cursor, SparseArray<a> sparseArray) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        int size = sparseArray.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                a aVar = sparseArray.get(keyAt);
                a(obj, aVar.f4693b, keyAt, aVar.f4692a, cursor);
            }
        } else {
            for (Field next : list) {
                String g2 = g(next);
                int columnIndex = cursor.getColumnIndex(org.litepal.g.a.a(e(next.getName()) ? "id" : c.d(next.getName())));
                if (columnIndex != -1) {
                    a(obj, next, columnIndex, g2, cursor);
                    a aVar2 = new a();
                    aVar2.f4692a = g2;
                    aVar2.f4693b = next;
                    sparseArray.put(columnIndex, aVar2);
                }
            }
        }
        if (list2 != null) {
            for (org.litepal.b.c.a next2 : list2) {
                int columnIndex2 = cursor.getColumnIndex(f(c.a(next2.f4696b)));
                if (columnIndex2 != -1) {
                    try {
                        e eVar = (e) f.a(Class.forName(next2.f4696b), cursor.getLong(columnIndex2));
                        if (eVar != null) {
                            a((e) obj, next2.d, (Object) eVar);
                        }
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    protected static void a(e eVar, long j) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (j > 0) {
            d.a(eVar, "baseObjId", Long.valueOf(j), e.class);
        }
    }

    protected static void a(e eVar, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object a2 = a(eVar, field);
        if ("java.util.Date".equals(field.getType().getName()) && a2 != null) {
            a2 = Long.valueOf(((Date) a2).getTime());
        }
        org.litepal.a.b bVar = (org.litepal.a.b) field.getAnnotation(org.litepal.a.b.class);
        if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
            a2 = a(bVar.a(), a2);
        }
        Object[] objArr = {org.litepal.g.a.a(c.d(field.getName())), a2};
        d.a(contentValues, "put", objArr, contentValues.getClass(), a(field, a2, objArr));
    }

    protected static void a(e eVar, Field field, Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        if (b(eVar, field)) {
            d.b(eVar, field.getName(), obj, eVar.getClass());
        }
    }

    protected static void a(e eVar, Collection<org.litepal.b.c.a> collection) {
        try {
            for (org.litepal.b.c.a next : collection) {
                if (next.f == 2) {
                    new g();
                    g.e(eVar, next);
                } else if (next.f == 1) {
                    new h();
                    h.e(eVar, next);
                } else if (next.f == 3) {
                    new f();
                    f.e(eVar, next);
                }
            }
        } catch (Exception e2) {
            throw new e(e2.getMessage(), e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.litepal.b.e r18, java.util.List<java.lang.reflect.Field> r19, java.util.Map<java.lang.reflect.Field, org.litepal.f.b.c> r20) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r17 = this;
            r1 = r20
            java.util.Iterator r2 = r19.iterator()
        L_0x0006:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00d5
            java.lang.Object r3 = r2.next()
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            r4 = 0
            java.lang.Object r5 = r1.get(r3)
            org.litepal.f.b.c r5 = (org.litepal.f.b.c) r5
            if (r5 != 0) goto L_0x0063
            java.lang.String r5 = b((java.lang.reflect.Field) r3)
            java.lang.String r6 = r18.getClassName()
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0030
            java.lang.String r5 = org.litepal.g.c.a((java.lang.reflect.Field) r3)
            java.lang.String r6 = "getLong"
            goto L_0x003c
        L_0x0030:
            java.lang.String r5 = r3.getName()
            java.lang.String r5 = org.litepal.g.c.d(r5)
            java.lang.String r6 = g((java.lang.reflect.Field) r3)
        L_0x003c:
            java.lang.String r7 = r18.getClassName()
            java.lang.String r8 = r3.getName()
            java.lang.String r7 = org.litepal.g.c.b((java.lang.String) r7, (java.lang.String) r8)
            java.lang.String r8 = r18.getClassName()
            java.lang.String r8 = org.litepal.g.c.b(r8)
            org.litepal.f.b.c r9 = new org.litepal.f.b.c
            r9.<init>()
            r9.f4818a = r7
            r9.f4819b = r5
            r9.d = r8
            r9.e = r6
            r1.put(r3, r9)
            r14 = r5
            r15 = r6
            goto L_0x006d
        L_0x0063:
            java.lang.String r7 = r5.f4818a
            java.lang.String r6 = r5.f4819b
            java.lang.String r8 = r5.d
            java.lang.String r5 = r5.e
            r15 = r5
            r14 = r6
        L_0x006d:
            r5 = r17
            android.database.sqlite.SQLiteDatabase r6 = r5.e     // Catch:{ all -> 0x00cd }
            r9 = 0
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r10.<init>()     // Catch:{ all -> 0x00cd }
            r10.append(r8)     // Catch:{ all -> 0x00cd }
            java.lang.String r8 = " = ?"
            r10.append(r8)     // Catch:{ all -> 0x00cd }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00cd }
            r8 = 1
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ all -> 0x00cd }
            r8 = 0
            long r12 = r18.getBaseObjId()     // Catch:{ all -> 0x00cd }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00cd }
            r11[r8] = r12     // Catch:{ all -> 0x00cd }
            r12 = 0
            r13 = 0
            r16 = 0
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r16
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00cd }
            boolean r4 = r6.moveToFirst()     // Catch:{ all -> 0x00c9 }
            if (r4 == 0) goto L_0x00c0
        L_0x00a6:
            java.lang.String r4 = org.litepal.g.a.a((java.lang.String) r14)     // Catch:{ all -> 0x00c9 }
            int r4 = r6.getColumnIndex(r4)     // Catch:{ all -> 0x00c9 }
            r7 = -1
            if (r4 == r7) goto L_0x00b7
            r7 = r18
            a((java.lang.Object) r7, (java.lang.reflect.Field) r3, (int) r4, (java.lang.String) r15, (android.database.Cursor) r6)     // Catch:{ all -> 0x00c9 }
            goto L_0x00b9
        L_0x00b7:
            r7 = r18
        L_0x00b9:
            boolean r4 = r6.moveToNext()     // Catch:{ all -> 0x00c9 }
            if (r4 != 0) goto L_0x00a6
            goto L_0x00c2
        L_0x00c0:
            r7 = r18
        L_0x00c2:
            if (r6 == 0) goto L_0x0006
            r6.close()
            goto L_0x0006
        L_0x00c9:
            r0 = move-exception
            r1 = r0
            r4 = r6
            goto L_0x00cf
        L_0x00cd:
            r0 = move-exception
            r1 = r0
        L_0x00cf:
            if (r4 == 0) goto L_0x00d4
            r4.close()
        L_0x00d4:
            throw r1
        L_0x00d5:
            r5 = r17
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.a(org.litepal.b.e, java.util.List, java.util.Map):void");
    }

    private static boolean a() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.Class<?>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Class<?>[] a(java.lang.reflect.Field r4, java.lang.Object r5, java.lang.Object[] r6) {
        /*
            java.lang.Class r0 = r4.getType()
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "char"
            boolean r1 = r0.equals(r1)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x001d
            java.lang.String r1 = "Character"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r0 = 0
            goto L_0x001e
        L_0x001d:
            r0 = 1
        L_0x001e:
            r1 = 2
            if (r0 == 0) goto L_0x0032
            java.lang.String r4 = java.lang.String.valueOf(r5)
            r6[r3] = r4
            java.lang.Class[] r4 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r3] = r5
            return r4
        L_0x0032:
            java.lang.Class r5 = r4.getType()
            boolean r5 = r5.isPrimitive()
            if (r5 == 0) goto L_0x00a3
            java.lang.Class[] r5 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r2] = r6
            java.lang.Class r4 = r4.getType()
            if (r4 == 0) goto L_0x009f
            boolean r6 = r4.isPrimitive()
            if (r6 == 0) goto L_0x009f
            java.lang.String r4 = r4.getName()
            java.lang.String r6 = "int"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x005d
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            goto L_0x00a0
        L_0x005d:
            java.lang.String r6 = "short"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0068
            java.lang.Class<java.lang.Short> r4 = java.lang.Short.class
            goto L_0x00a0
        L_0x0068:
            java.lang.String r6 = "long"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0073
            java.lang.Class<java.lang.Long> r4 = java.lang.Long.class
            goto L_0x00a0
        L_0x0073:
            java.lang.String r6 = "float"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x007e
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            goto L_0x00a0
        L_0x007e:
            java.lang.String r6 = "double"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0089
            java.lang.Class<java.lang.Double> r4 = java.lang.Double.class
            goto L_0x00a0
        L_0x0089:
            java.lang.String r6 = "boolean"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0094
            java.lang.Class<java.lang.Boolean> r4 = java.lang.Boolean.class
            goto L_0x00a0
        L_0x0094:
            java.lang.String r6 = "char"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x009f
            java.lang.Class<java.lang.Character> r4 = java.lang.Character.class
            goto L_0x00a0
        L_0x009f:
            r4 = 0
        L_0x00a0:
            r5[r3] = r4
            goto L_0x00ca
        L_0x00a3:
            java.lang.String r5 = "java.util.Date"
            java.lang.Class r6 = r4.getType()
            java.lang.String r6 = r6.getName()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00be
            java.lang.Class[] r4 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5
            java.lang.Class<java.lang.Long> r5 = java.lang.Long.class
            r4[r3] = r5
            return r4
        L_0x00be:
            java.lang.Class[] r5 = new java.lang.Class[r1]
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r2] = r6
            java.lang.Class r4 = r4.getType()
            r5[r3] = r4
        L_0x00ca:
            r4 = r5
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.a(java.lang.reflect.Field, java.lang.Object, java.lang.Object[]):java.lang.Class[]");
    }

    private Object[] a(Class<?> cls, Constructor<?> constructor) {
        String str;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> cls2 = parameterTypes[i];
            String name = cls2.getName();
            if ("boolean".equals(name) || "java.lang.Boolean".equals(name)) {
                str = false;
            } else if ("float".equals(name) || "java.lang.Float".equals(name)) {
                str = Float.valueOf(0.0f);
            } else if ("double".equals(name) || "java.lang.Double".equals(name)) {
                str = Double.valueOf(0.0d);
            } else {
                if (!"int".equals(name) && !"java.lang.Integer".equals(name)) {
                    if ("long".equals(name) || "java.lang.Long".equals(name)) {
                        str = 0L;
                    } else if (!"short".equals(name) && !"java.lang.Short".equals(name)) {
                        str = ("char".equals(name) || "java.lang.Character".equals(name)) ? ' ' : ("[B".equals(name) || "[Ljava.lang.Byte;".equals(name)) ? new byte[0] : "java.lang.String".equals(name) ? "" : cls == cls2 ? null : c(cls2);
                    }
                }
                str = 0;
            }
            objArr[i] = str;
        }
        return objArr;
    }

    private static String[] a(String[] strArr, List<Field> list, List<org.litepal.b.c.a> list2) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Field name : list) {
            arrayList2.add(name.getName());
        }
        boolean z = false;
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (org.litepal.g.a.a((Collection<String>) arrayList2, str)) {
                arrayList3.add(Integer.valueOf(i));
            } else if (e(str)) {
                if (TrayContract.Preferences.Columns.ID.equalsIgnoreCase(str)) {
                    arrayList.set(i, org.litepal.g.a.a("id"));
                }
                z = true;
            }
        }
        for (int size = arrayList3.size() - 1; size >= 0; size--) {
            arrayList4.add((String) arrayList.remove(((Integer) arrayList3.get(size)).intValue()));
        }
        for (Field next : list) {
            if (org.litepal.g.a.a((Collection<String>) arrayList4, next.getName())) {
                arrayList5.add(next);
            }
        }
        list.clear();
        list.addAll(arrayList5);
        if (list2 != null && list2.size() > 0) {
            for (int i2 = 0; i2 < list2.size(); i2++) {
                arrayList.add(f(c.a(list2.get(i2).f4696b)));
            }
        }
        if (!z) {
            arrayList.add(org.litepal.g.a.a("id"));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static Object b(String str, Object obj) {
        return (str == null || obj == null || !"AES".equalsIgnoreCase(str)) ? obj : org.litepal.g.a.b.b((String) obj);
    }

    protected static String b(Class<?> cls) {
        return org.litepal.g.a.a(c.a(cls.getName()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0179 A[LOOP:1: B:30:0x00f6->B:57:0x0179, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0172 A[EDGE_INSN: B:99:0x0172->B:56:0x0172 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(org.litepal.b.e r30) {
        /*
            r29 = this;
            r7 = r29
            r8 = r30
            java.util.List<org.litepal.b.c.a> r1 = r7.h
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.List<org.litepal.b.c.a> r1 = r7.h
            java.util.Iterator r9 = r1.iterator()
        L_0x000f:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x01cc
            java.lang.Object r1 = r9.next()
            r10 = r1
            org.litepal.b.c.a r10 = (org.litepal.b.c.a) r10
            java.lang.String r11 = r10.f4696b
            int r2 = r10.f
            r3 = 3
            r4 = 0
            if (r2 != r3) goto L_0x0026
            r13 = 1
            goto L_0x0027
        L_0x0026:
            r13 = 0
        L_0x0027:
            java.util.List r14 = r7.c((java.lang.String) r11)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.util.List r15 = r7.d((java.lang.String) r11)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            r6 = 2
            if (r13 == 0) goto L_0x009f
            java.lang.String r2 = r30.getTableName()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r3 = org.litepal.g.c.a((java.lang.String) r11)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = org.litepal.g.c.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r12 = "select * from "
            r1.append(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r12 = " a inner join "
            r1.append(r12)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.append(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = " b on a.id = b."
            r1.append(r5)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r5.<init>()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r5.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r3 = "_id"
            r5.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r3 = " where b."
            r1.append(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.append(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r2 = "_id = ?"
            r1.append(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String[] r2 = new java.lang.String[r6]     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r1 = org.litepal.g.a.a((java.lang.String) r1)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r2[r4] = r1     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            long r3 = r30.getBaseObjId()     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r3 = 1
            r2[r3] = r1     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            android.database.Cursor r1 = org.litepal.f.c((java.lang.String[]) r2)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            goto L_0x00e3
        L_0x0095:
            r0 = move-exception
            r2 = r0
            r1 = r7
            goto L_0x01b1
        L_0x009a:
            r0 = move-exception
            r2 = r0
            r1 = r7
            goto L_0x01b6
        L_0x009f:
            java.lang.String r1 = r10.f4695a     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r1 = org.litepal.g.c.a((java.lang.String) r1)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r1 = f(r1)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r2 = org.litepal.g.c.a((java.lang.String) r11)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            android.database.sqlite.SQLiteDatabase r3 = r7.e     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r18 = org.litepal.g.a.a((java.lang.String) r2)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            r19 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            r2.<init>()     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            r2.append(r1)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r1 = "=?"
            r2.append(r1)     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            java.lang.String r20 = r2.toString()     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch:{ Exception -> 0x01b3, all -> 0x01ae }
            long r6 = r30.getBaseObjId()     // Catch:{ Exception -> 0x01aa, all -> 0x01a6 }
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x01aa, all -> 0x01a6 }
            r2[r4] = r1     // Catch:{ Exception -> 0x01aa, all -> 0x01a6 }
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r17 = r3
            r21 = r2
            android.database.Cursor r1 = r17.query(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x01aa, all -> 0x01a6 }
        L_0x00e3:
            r7 = r1
            if (r7 == 0) goto L_0x0198
            boolean r1 = r7.moveToFirst()     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            if (r1 == 0) goto L_0x0198
            android.util.SparseArray r12 = new android.util.SparseArray     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            r12.<init>()     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            r6.<init>()     // Catch:{ Exception -> 0x0191, all -> 0x018c }
        L_0x00f6:
            java.lang.Class r1 = java.lang.Class.forName(r11)     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            r5 = r29
            java.lang.Object r1 = r5.c((java.lang.Class<?>) r1)     // Catch:{ Exception -> 0x0189, all -> 0x0186 }
            r4 = r1
            org.litepal.b.e r4 = (org.litepal.b.e) r4     // Catch:{ Exception -> 0x0189, all -> 0x0186 }
            java.lang.String r1 = "id"
            int r1 = r7.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x0189, all -> 0x0186 }
            long r1 = r7.getLong(r1)     // Catch:{ Exception -> 0x0189, all -> 0x0186 }
            a((org.litepal.b.e) r4, (long) r1)     // Catch:{ Exception -> 0x0189, all -> 0x0186 }
            r16 = 0
            r1 = r5
            r2 = r4
            r3 = r14
            r26 = r9
            r9 = r4
            r4 = r16
            r5 = r7
            r27 = r11
            r28 = r14
            r14 = 2
            r11 = r6
            r6 = r12
            r1.a((java.lang.Object) r2, (java.util.List<java.lang.reflect.Field>) r3, (java.util.List<org.litepal.b.c.a>) r4, (android.database.Cursor) r5, (android.util.SparseArray<org.litepal.b.b.a>) r6)     // Catch:{ Exception -> 0x0191, all -> 0x018c }
            r1 = r29
            r1.a((org.litepal.b.e) r9, (java.util.List<java.lang.reflect.Field>) r15, (java.util.Map<java.lang.reflect.Field, org.litepal.f.b.c>) r11)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            int r2 = r10.f     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            if (r2 == r14) goto L_0x013c
            if (r13 == 0) goto L_0x0131
            goto L_0x013c
        L_0x0131:
            int r2 = r10.f     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            r3 = 1
            if (r2 != r3) goto L_0x016c
            java.lang.reflect.Field r2 = r10.d     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            a((org.litepal.b.e) r8, (java.lang.reflect.Field) r2, (java.lang.Object) r9)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            goto L_0x016c
        L_0x013c:
            r3 = 1
            java.lang.reflect.Field r2 = r10.d     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            java.lang.Object r4 = a((org.litepal.b.e) r8, (java.lang.reflect.Field) r2)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            if (r4 != 0) goto L_0x0169
            java.lang.Class r4 = r2.getType()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            java.lang.Class<java.util.List> r5 = java.util.List.class
            boolean r4 = r5.isAssignableFrom(r4)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            if (r4 == 0) goto L_0x0159
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            r4.<init>()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            goto L_0x015e
        L_0x0159:
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            r4.<init>()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
        L_0x015e:
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            java.lang.Class r5 = r30.getClass()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            org.litepal.b.d.b(r8, r2, r4, r5)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
        L_0x0169:
            r4.add(r9)     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
        L_0x016c:
            boolean r2 = r7.moveToNext()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            if (r2 != 0) goto L_0x0179
            r12.clear()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            r11.clear()     // Catch:{ Exception -> 0x0184, all -> 0x0182 }
            goto L_0x019c
        L_0x0179:
            r6 = r11
            r9 = r26
            r11 = r27
            r14 = r28
            goto L_0x00f6
        L_0x0182:
            r0 = move-exception
            goto L_0x018f
        L_0x0184:
            r0 = move-exception
            goto L_0x0194
        L_0x0186:
            r0 = move-exception
            r1 = r5
            goto L_0x018f
        L_0x0189:
            r0 = move-exception
            r1 = r5
            goto L_0x0194
        L_0x018c:
            r0 = move-exception
            r1 = r29
        L_0x018f:
            r2 = r0
            goto L_0x01c6
        L_0x0191:
            r0 = move-exception
            r1 = r29
        L_0x0194:
            r2 = r0
            r16 = r7
            goto L_0x01b8
        L_0x0198:
            r26 = r9
            r1 = r29
        L_0x019c:
            if (r7 == 0) goto L_0x01a1
            r7.close()
        L_0x01a1:
            r7 = r1
            r9 = r26
            goto L_0x000f
        L_0x01a6:
            r0 = move-exception
            r1 = r29
            goto L_0x01b0
        L_0x01aa:
            r0 = move-exception
            r1 = r29
            goto L_0x01b5
        L_0x01ae:
            r0 = move-exception
            r1 = r7
        L_0x01b0:
            r2 = r0
        L_0x01b1:
            r7 = 0
            goto L_0x01c6
        L_0x01b3:
            r0 = move-exception
            r1 = r7
        L_0x01b5:
            r2 = r0
        L_0x01b6:
            r16 = 0
        L_0x01b8:
            org.litepal.c.e r3 = new org.litepal.c.e     // Catch:{ all -> 0x01c2 }
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x01c2 }
            r3.<init>(r4, r2)     // Catch:{ all -> 0x01c2 }
            throw r3     // Catch:{ all -> 0x01c2 }
        L_0x01c2:
            r0 = move-exception
            r2 = r0
            r7 = r16
        L_0x01c6:
            if (r7 == 0) goto L_0x01cb
            r7.close()
        L_0x01cb:
            throw r2
        L_0x01cc:
            r1 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.b(org.litepal.b.e):void");
    }

    private static void b(e eVar, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object a2 = d.a(eVar, field.getName(), eVar.getClass());
        if (a2 != null) {
            if ("java.util.Date".equals(field.getType().getName())) {
                a2 = Long.valueOf(((Date) a2).getTime());
            }
            org.litepal.a.b bVar = (org.litepal.a.b) field.getAnnotation(org.litepal.a.b.class);
            if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
                a2 = a(bVar.a(), a2);
            }
            Object[] objArr = {org.litepal.g.a.a(c.d(field.getName())), a2};
            d.a(contentValues, "put", objArr, contentValues.getClass(), a(field, a2, objArr));
        }
    }

    private boolean b() {
        return k.class.getName().equals(getClass().getName());
    }

    private static boolean b(e eVar, Field field) {
        return (eVar == null || field == null) ? false : true;
    }

    protected static String[] b(String... strArr) {
        new Object[1][0] = strArr;
        if (strArr == null || strArr.length <= 1) {
            return null;
        }
        String[] strArr2 = new String[(strArr.length - 1)];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        return strArr2;
    }

    private Object c(Class<?> cls) {
        try {
            Constructor[] declaredConstructors = cls.getDeclaredConstructors();
            SparseArray sparseArray = new SparseArray();
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (Constructor constructor : declaredConstructors) {
                int length = constructor.getParameterTypes().length;
                int i2 = length;
                for (Class<?> cls2 : constructor.getParameterTypes()) {
                    if (cls2 != cls) {
                        if (cls2.getName().startsWith("com.android") && cls2.getName().endsWith("InstantReloadException")) {
                        }
                    }
                    i2 += com.cyjh.elfin.a.b.ak;
                }
                if (sparseArray.get(i2) == null) {
                    sparseArray.put(i2, constructor);
                }
                if (i2 < i) {
                    i = i2;
                }
            }
            Constructor constructor2 = (Constructor) sparseArray.get(i);
            if (constructor2 != null) {
                constructor2.setAccessible(true);
            }
            return constructor2.newInstance(a(cls, (Constructor<?>) constructor2));
        } catch (Exception e2) {
            throw new e(e2.getMessage(), e2);
        }
    }

    protected static e c(e eVar, org.litepal.b.c.a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (e) a(eVar, aVar.d);
    }

    private void c(e eVar, Field field, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object a2;
        boolean z = false;
        if (k.class.getName().equals(getClass().getName())) {
            e a3 = a(eVar);
            Object a4 = a(eVar, field);
            Object a5 = a(a3, field);
            if (a4 != null && a5 != null) {
                z = a4.toString().equals(a5.toString());
            } else if (a4 == a5) {
                z = true;
            }
            if (!z) {
                a(eVar, field, contentValues);
            }
        } else if (j.class.getName().equals(getClass().getName()) && (a2 = d.a(eVar, field.getName(), eVar.getClass())) != null) {
            if ("java.util.Date".equals(field.getType().getName())) {
                a2 = Long.valueOf(((Date) a2).getTime());
            }
            org.litepal.a.b bVar = (org.litepal.a.b) field.getAnnotation(org.litepal.a.b.class);
            if (bVar != null && "java.lang.String".equals(field.getType().getName())) {
                a2 = a(bVar.a(), a2);
            }
            Object[] objArr = {org.litepal.g.a.a(c.d(field.getName())), a2};
            d.a(contentValues, "put", objArr, contentValues.getClass(), a(field, a2, objArr));
        }
    }

    private boolean c() {
        return j.class.getName().equals(getClass().getName());
    }

    private static boolean c(Field field) {
        String name = field.getType().getName();
        return name.equals("char") || name.endsWith("Character");
    }

    private boolean c(e eVar, Field field) throws IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        e a2 = a(eVar);
        Object a3 = a(eVar, field);
        Object a4 = a(a2, field);
        return (a3 == null || a4 == null) ? a3 == a4 : a3.toString().equals(a4.toString());
    }

    private static Constructor<?> d(Class<?> cls) {
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        SparseArray sparseArray = new SparseArray();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (Constructor constructor : declaredConstructors) {
            int length = constructor.getParameterTypes().length;
            int i2 = length;
            for (Class<?> cls2 : constructor.getParameterTypes()) {
                if (cls2 == cls || (cls2.getName().startsWith("com.android") && cls2.getName().endsWith("InstantReloadException"))) {
                    i2 += com.cyjh.elfin.a.b.ak;
                }
            }
            if (sparseArray.get(i2) == null) {
                sparseArray.put(i2, constructor);
            }
            if (i2 < i) {
                i = i2;
            }
        }
        Constructor<?> constructor2 = (Constructor) sparseArray.get(i);
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
        return constructor2;
    }

    protected static Collection<e> d(e eVar, org.litepal.b.c.a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (Collection) a(eVar, aVar.d);
    }

    private static boolean d(Field field) {
        return "boolean".equals(field.getType().getName());
    }

    private static Class<?> e(Class<?> cls) {
        if (cls == null || !cls.isPrimitive()) {
            return null;
        }
        String name = cls.getName();
        if ("int".equals(name)) {
            return Integer.class;
        }
        if ("short".equals(name)) {
            return Short.class;
        }
        if ("long".equals(name)) {
            return Long.class;
        }
        if ("float".equals(name)) {
            return Float.class;
        }
        if ("double".equals(name)) {
            return Double.class;
        }
        if ("boolean".equals(name)) {
            return Boolean.class;
        }
        if ("char".equals(name)) {
            return Character.class;
        }
        return null;
    }

    private static String e(Field field) {
        String str;
        StringBuilder sb;
        String name = field.getName();
        if (d(field)) {
            if (name.matches("^is[A-Z]{1}.*$")) {
                name = name.substring(2);
            }
            str = v.Y;
        } else {
            str = "get";
        }
        if (name.matches("^[a-z]{1}[A-Z]{1}.*")) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(name);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(org.litepal.g.a.b(name));
        }
        return sb.toString();
    }

    private static String f(Class<?> cls) {
        String str = "get" + (cls.isPrimitive() ? org.litepal.g.a.b(cls.getName()) : cls.getSimpleName());
        return "getBoolean".equals(str) ? "getInt" : ("getChar".equals(str) || "getCharacter".equals(str)) ? "getString" : "getDate".equals(str) ? "getLong" : "getInteger".equals(str) ? "getInt" : "getbyte[]".equalsIgnoreCase(str) ? "getBlob" : str;
    }

    private static String f(Field field) {
        StringBuilder sb;
        String b2;
        if (d(field) && field.getName().matches("^is[A-Z]{1}.*$")) {
            sb = new StringBuilder();
            sb.append("set");
            b2 = field.getName().substring(2);
        } else if (field.getName().matches("^[a-z]{1}[A-Z]{1}.*")) {
            sb = new StringBuilder();
            sb.append("set");
            b2 = field.getName();
        } else {
            sb = new StringBuilder();
            sb.append("set");
            b2 = org.litepal.g.a.b(field.getName());
        }
        sb.append(b2);
        return sb.toString();
    }

    private static String g(Field field) {
        return f(a(field.getType()) ? a(field) : field.getType());
    }

    private void g(String str) {
        List<org.litepal.b.c.a> list;
        Collection<org.litepal.b.c.a> b2 = b(str);
        if (this.g == null) {
            this.g = new ArrayList();
        } else {
            this.g.clear();
        }
        if (this.h == null) {
            this.h = new ArrayList();
        } else {
            this.h.clear();
        }
        for (org.litepal.b.c.a next : b2) {
            if (next.f == 2 || next.f == 1) {
                if (next.f4697c.equals(str)) {
                    list = this.g;
                }
                list = this.h;
            } else {
                if (next.f != 3) {
                }
                list = this.h;
            }
            list.add(next);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(java.lang.String r10, java.lang.String[] r11, java.lang.String[] r12, java.lang.Class<T> r13) {
        /*
            r9 = this;
            org.litepal.g.a.a((java.lang.String[]) r12)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.e     // Catch:{ Exception -> 0x004b }
            java.lang.String r4 = a((java.lang.String[]) r12)     // Catch:{ Exception -> 0x004b }
            java.lang.String[] r5 = b((java.lang.String[]) r12)     // Catch:{ Exception -> 0x004b }
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r10
            r3 = r11
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x004b }
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            if (r11 == 0) goto L_0x003d
            java.lang.Class r11 = r10.getClass()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.String r12 = f((java.lang.Class<?>) r13)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r13 = 1
            java.lang.Class[] r0 = new java.lang.Class[r13]     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r2 = 0
            r0[r2] = r1     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.reflect.Method r11 = r11.getMethod(r12, r0)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.Object[] r12 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r12[r2] = r13     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.Object r0 = r11.invoke(r10, r12)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
        L_0x003d:
            if (r10 == 0) goto L_0x0042
            r10.close()
        L_0x0042:
            return r0
        L_0x0043:
            r11 = move-exception
            goto L_0x0056
        L_0x0045:
            r11 = move-exception
            r0 = r10
            goto L_0x004c
        L_0x0048:
            r11 = move-exception
            r10 = r0
            goto L_0x0056
        L_0x004b:
            r11 = move-exception
        L_0x004c:
            org.litepal.c.e r10 = new org.litepal.c.e     // Catch:{ all -> 0x0048 }
            java.lang.String r12 = r11.getMessage()     // Catch:{ all -> 0x0048 }
            r10.<init>(r12, r11)     // Catch:{ all -> 0x0048 }
            throw r10     // Catch:{ all -> 0x0048 }
        L_0x0056:
            if (r10 == 0) goto L_0x005b
            r10.close()
        L_0x005b:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.Class):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> a(java.lang.Class<T> r22, java.lang.String[] r23, java.lang.String r24, java.lang.String[] r25, java.lang.String r26, java.lang.String r27, java.util.List<org.litepal.b.c.a> r28) {
        /*
            r21 = this;
            r7 = r21
            r8 = r28
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r1 = 0
            java.lang.String r2 = r22.getName()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.util.List r10 = r7.c((java.lang.String) r2)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r2 = r22.getName()     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.util.List r11 = r7.d((java.lang.String) r2)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r2 = r23
            java.lang.String[] r2 = a((java.lang.String[]) r2, (java.util.List<java.lang.reflect.Field>) r11, (java.util.List<org.litepal.b.c.a>) r8)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String[] r14 = org.litepal.g.c.a((java.lang.String[]) r2)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            java.lang.String r13 = b((java.lang.Class<?>) r22)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            android.database.sqlite.SQLiteDatabase r12 = r7.e     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            r17 = 0
            r18 = 0
            r15 = r24
            r16 = r25
            r19 = r26
            r20 = r27
            android.database.Cursor r12 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0090, all -> 0x008c }
            boolean r1 = r12.moveToFirst()     // Catch:{ Exception -> 0x008a }
            if (r1 == 0) goto L_0x0084
            android.util.SparseArray r13 = new android.util.SparseArray     // Catch:{ Exception -> 0x008a }
            r13.<init>()     // Catch:{ Exception -> 0x008a }
            java.util.HashMap r14 = new java.util.HashMap     // Catch:{ Exception -> 0x008a }
            r14.<init>()     // Catch:{ Exception -> 0x008a }
        L_0x004a:
            java.lang.Object r15 = r21.c((java.lang.Class<?>) r22)     // Catch:{ Exception -> 0x008a }
            r1 = r15
            org.litepal.b.e r1 = (org.litepal.b.e) r1     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = "id"
            int r2 = r12.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x008a }
            long r2 = r12.getLong(r2)     // Catch:{ Exception -> 0x008a }
            a((org.litepal.b.e) r1, (long) r2)     // Catch:{ Exception -> 0x008a }
            r1 = r7
            r2 = r15
            r3 = r10
            r4 = r8
            r5 = r12
            r6 = r13
            r1.a((java.lang.Object) r2, (java.util.List<java.lang.reflect.Field>) r3, (java.util.List<org.litepal.b.c.a>) r4, (android.database.Cursor) r5, (android.util.SparseArray<org.litepal.b.b.a>) r6)     // Catch:{ Exception -> 0x008a }
            r1 = r15
            org.litepal.b.e r1 = (org.litepal.b.e) r1     // Catch:{ Exception -> 0x008a }
            r7.a((org.litepal.b.e) r1, (java.util.List<java.lang.reflect.Field>) r11, (java.util.Map<java.lang.reflect.Field, org.litepal.f.b.c>) r14)     // Catch:{ Exception -> 0x008a }
            if (r8 == 0) goto L_0x0075
            r1 = r15
            org.litepal.b.e r1 = (org.litepal.b.e) r1     // Catch:{ Exception -> 0x008a }
            r7.b((org.litepal.b.e) r1)     // Catch:{ Exception -> 0x008a }
        L_0x0075:
            r9.add(r15)     // Catch:{ Exception -> 0x008a }
            boolean r1 = r12.moveToNext()     // Catch:{ Exception -> 0x008a }
            if (r1 != 0) goto L_0x004a
            r13.clear()     // Catch:{ Exception -> 0x008a }
            r14.clear()     // Catch:{ Exception -> 0x008a }
        L_0x0084:
            if (r12 == 0) goto L_0x0089
            r12.close()
        L_0x0089:
            return r9
        L_0x008a:
            r0 = move-exception
            goto L_0x0092
        L_0x008c:
            r0 = move-exception
            r12 = r1
        L_0x008e:
            r1 = r0
            goto L_0x009f
        L_0x0090:
            r0 = move-exception
            r12 = r1
        L_0x0092:
            r1 = r0
            org.litepal.c.e r2 = new org.litepal.c.e     // Catch:{ all -> 0x009d }
            java.lang.String r3 = r1.getMessage()     // Catch:{ all -> 0x009d }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x009d }
            throw r2     // Catch:{ all -> 0x009d }
        L_0x009d:
            r0 = move-exception
            goto L_0x008e
        L_0x009f:
            if (r12 == 0) goto L_0x00a4
            r12.close()
        L_0x00a4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.a(java.lang.Class, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final List<org.litepal.b.c.a> a(String str, boolean z) {
        List<org.litepal.b.c.a> list;
        if (!z) {
            return null;
        }
        Collection<org.litepal.b.c.a> b2 = b(str);
        if (this.g == null) {
            this.g = new ArrayList();
        } else {
            this.g.clear();
        }
        if (this.h == null) {
            this.h = new ArrayList();
        } else {
            this.h.clear();
        }
        for (org.litepal.b.c.a next : b2) {
            if (next.f == 2 || next.f == 1) {
                if (next.f4697c.equals(str)) {
                    list = this.g;
                }
                list = this.h;
            } else {
                if (next.f != 3) {
                }
                list = this.h;
            }
            list.add(next);
        }
        return this.g;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        throw new org.litepal.c.e(r5.getMessage(), r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[ExcHandler: Exception (r5v9 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:5:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.litepal.b.e a(org.litepal.b.e r5) {
        /*
            r4 = this;
            org.litepal.b.e r0 = r4.f
            if (r0 == 0) goto L_0x0007
            org.litepal.b.e r5 = r4.f
            return r5
        L_0x0007:
            r0 = 0
            java.lang.String r5 = r5.getClassName()     // Catch:{ ClassNotFoundException -> 0x0043, InstantiationException -> 0x0028, Exception -> 0x001d }
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x001b, Exception -> 0x001d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x001b, Exception -> 0x001d }
            org.litepal.b.e r0 = (org.litepal.b.e) r0     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x001b, Exception -> 0x001d }
            r4.f = r0     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x001b, Exception -> 0x001d }
            org.litepal.b.e r0 = r4.f     // Catch:{ ClassNotFoundException -> 0x0044, InstantiationException -> 0x001b, Exception -> 0x001d }
            return r0
        L_0x001b:
            r0 = move-exception
            goto L_0x002c
        L_0x001d:
            r5 = move-exception
            org.litepal.c.e r0 = new org.litepal.c.e
            java.lang.String r1 = r5.getMessage()
            r0.<init>(r1, r5)
            throw r0
        L_0x0028:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L_0x002c:
            org.litepal.c.e r1 = new org.litepal.c.e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r5 = " needs a default constructor."
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        L_0x0043:
            r5 = r0
        L_0x0044:
            org.litepal.c.b r0 = new org.litepal.c.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "can not find a class named "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.b.b.a(org.litepal.b.e):org.litepal.b.e");
    }

    /* access modifiers changed from: protected */
    public final void a(e eVar, List<Field> list, ContentValues contentValues) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object a2;
        for (Field next : list) {
            if (!e(next.getName())) {
                boolean z = false;
                if (k.class.getName().equals(getClass().getName())) {
                    e a3 = a(eVar);
                    Object a4 = a(eVar, next);
                    Object a5 = a(a3, next);
                    if (a4 != null && a5 != null) {
                        z = a4.toString().equals(a5.toString());
                    } else if (a4 == a5) {
                        z = true;
                    }
                    if (!z) {
                        a(eVar, next, contentValues);
                    }
                } else if (j.class.getName().equals(getClass().getName()) && (a2 = d.a(eVar, next.getName(), eVar.getClass())) != null) {
                    if ("java.util.Date".equals(next.getType().getName())) {
                        a2 = Long.valueOf(((Date) a2).getTime());
                    }
                    org.litepal.a.b bVar = (org.litepal.a.b) next.getAnnotation(org.litepal.a.b.class);
                    if (bVar != null && "java.lang.String".equals(next.getType().getName())) {
                        a2 = a(bVar.a(), a2);
                    }
                    Object[] objArr = {org.litepal.g.a.a(c.d(next.getName())), a2};
                    d.a(contentValues, "put", objArr, contentValues.getClass(), a(next, a2, objArr));
                }
            }
        }
    }
}
