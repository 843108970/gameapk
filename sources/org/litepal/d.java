package org.litepal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.grandcentrix.tray.provider.TrayContract;
import org.litepal.f.b.a;
import org.litepal.f.b.c;
import org.litepal.f.c.b;
import org.litepal.f.c.e;
import org.litepal.f.c.f;
import org.litepal.f.c.g;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4721a = "LitePalBase";
    private static final int d = 1;
    private static final int e = 2;

    /* renamed from: b  reason: collision with root package name */
    protected Collection<a> f4722b;

    /* renamed from: c  reason: collision with root package name */
    protected Collection<c> f4723c;
    private f[] f = {new e(), new g(), new b(), new org.litepal.f.c.d(), new org.litepal.f.c.c(), new org.litepal.f.c.a()};
    private Map<String, List<Field>> g = new HashMap();
    private Map<String, List<Field>> h = new HashMap();
    private Collection<org.litepal.b.c.a> i;

    protected static Class<?> a(Field field) {
        Type genericType = field.getGenericType();
        if (genericType == null || !(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    private Collection<c> a() {
        return this.f4723c;
    }

    private Collection<a> a(List<String> list) {
        if (this.f4722b == null) {
            this.f4722b = new HashSet();
        }
        if (this.f4723c == null) {
            this.f4723c = new HashSet();
        }
        this.f4722b.clear();
        this.f4723c.clear();
        for (String a2 : list) {
            a(a2, 1);
        }
        return this.f4722b;
    }

    private static void a(Class<?> cls, List<Field> list) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 != org.litepal.b.e.class && cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        org.litepal.a.a aVar = (org.litepal.a.a) field.getAnnotation(org.litepal.a.a.class);
                        if ((aVar == null || !aVar.d()) && !Modifier.isStatic(field.getModifiers())) {
                            String name = field.getType().getName();
                            boolean z = true;
                            if (!"boolean".equals(name) && !"java.lang.Boolean".equals(name) && !"float".equals(name) && !"java.lang.Float".equals(name) && !"double".equals(name) && !"java.lang.Double".equals(name) && !"int".equals(name) && !"java.lang.Integer".equals(name) && !"long".equals(name) && !"java.lang.Long".equals(name) && !"short".equals(name) && !"java.lang.Short".equals(name) && !"char".equals(name) && !"java.lang.Character".equals(name) && !"[B".equals(name) && !"[Ljava.lang.Byte;".equals(name) && !"java.lang.String".equals(name) && !"java.util.Date".equals(name)) {
                                z = false;
                            }
                            if (z) {
                                list.add(field);
                            }
                        }
                    }
                }
                cls2 = cls2.getSuperclass();
            } else {
                return;
            }
        }
    }

    private void a(String str, String str2, String str3, int i2) {
        a aVar = new a();
        aVar.f4812a = org.litepal.g.c.a(str);
        aVar.f4813b = org.litepal.g.c.a(str2);
        aVar.f4814c = org.litepal.g.c.a(str3);
        aVar.d = i2;
        this.f4722b.add(aVar);
    }

    private void a(String str, String str2, String str3, Field field, Field field2, int i2) {
        org.litepal.b.c.a aVar = new org.litepal.b.c.a();
        aVar.f4695a = str;
        aVar.f4696b = str2;
        aVar.f4697c = str3;
        aVar.d = field;
        aVar.e = field2;
        aVar.f = i2;
        this.i.add(aVar);
    }

    private void a(String str, Field field, int i2) throws ClassNotFoundException {
        String name;
        int i3;
        d dVar;
        String str2;
        String str3;
        String str4 = str;
        int i4 = i2;
        Class<?> type = field.getType();
        if (org.litepal.e.a.a().d().contains(type.getName())) {
            boolean z = false;
            for (Field field2 : Class.forName(type.getName()).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type2 = field2.getType();
                    if (str4.equals(type2.getName())) {
                        if (i4 == 1) {
                            a(str4, type.getName(), type.getName(), 1);
                        } else if (i4 == 2) {
                            name = type.getName();
                            str3 = type.getName();
                            i3 = 1;
                            dVar = this;
                            str2 = str4;
                        }
                        z = true;
                    } else if (a(type2) && str4.equals(b(field2))) {
                        if (i4 == 1) {
                            a(str4, type.getName(), str4, 2);
                        } else if (i4 == 2) {
                            name = type.getName();
                            i3 = 2;
                            dVar = this;
                            str2 = str4;
                            str3 = str4;
                        }
                        z = true;
                    }
                    dVar.a(str2, name, str3, field, field2, i3);
                    z = true;
                }
            }
            if (z) {
                return;
            }
            if (i4 == 1) {
                a(str4, type.getName(), type.getName(), 1);
            } else if (i4 == 2) {
                a(str4, type.getName(), type.getName(), field, (Field) null, 1);
            }
        }
    }

    protected static boolean a(Class<?> cls) {
        return List.class.isAssignableFrom(cls) || Set.class.isAssignableFrom(cls);
    }

    protected static String b(Field field) {
        Class<?> a2 = a(field);
        if (a2 != null) {
            return a2.getName();
        }
        return null;
    }

    private static void b(Class<?> cls, List<Field> list) {
        while (true) {
            Class<? super Object> cls2 = cls;
            if (cls2 != org.litepal.b.e.class && cls2 != Object.class) {
                Field[] declaredFields = cls2.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        org.litepal.a.a aVar = (org.litepal.a.a) field.getAnnotation(org.litepal.a.a.class);
                        if ((aVar == null || !aVar.d()) && !Modifier.isStatic(field.getModifiers()) && a(field.getType())) {
                            String b2 = b(field);
                            if (org.litepal.g.a.c(b2) || cls2.getName().equalsIgnoreCase(b2)) {
                                list.add(field);
                            }
                        }
                    }
                }
                cls2 = cls2.getSuperclass();
            } else {
                return;
            }
        }
    }

    private void b(String str, Field field, int i2) throws ClassNotFoundException {
        String str2;
        int i3;
        d dVar;
        String str3;
        String str4;
        if (a(field.getType())) {
            String b2 = b(field);
            if (org.litepal.e.a.a().d().contains(b2)) {
                boolean z = false;
                for (Field field2 : Class.forName(b2).getDeclaredFields()) {
                    if (!Modifier.isStatic(field2.getModifiers())) {
                        Class<?> type = field2.getType();
                        if (str.equals(type.getName())) {
                            if (i2 == 1) {
                                a(str, b2, b2, 2);
                            } else if (i2 == 2) {
                                i3 = 2;
                                dVar = this;
                                str3 = str;
                                str4 = b2;
                                str2 = b2;
                            }
                            z = true;
                        } else if (a(type) && str.equals(b(field2))) {
                            if (i2 == 1) {
                                if (str.equalsIgnoreCase(b2)) {
                                    c cVar = new c();
                                    cVar.f4818a = org.litepal.g.c.b(str, field.getName());
                                    cVar.f4819b = org.litepal.g.c.a(field);
                                    cVar.f4820c = "integer";
                                    cVar.d = org.litepal.g.c.b(str);
                                    this.f4723c.add(cVar);
                                } else {
                                    a(str, b2, (String) null, 3);
                                }
                            } else if (i2 == 2 && !str.equalsIgnoreCase(b2)) {
                                str2 = null;
                                i3 = 3;
                                dVar = this;
                                str3 = str;
                                str4 = b2;
                            }
                            z = true;
                        }
                        dVar.a(str3, str4, str2, field, field2, i3);
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                if (i2 == 1) {
                    a(str, b2, b2, 2);
                } else if (i2 == 2) {
                    a(str, b2, b2, field, (Field) null, 2);
                }
            } else if (org.litepal.g.a.c(b2) && i2 == 1) {
                c cVar2 = new c();
                cVar2.f4818a = org.litepal.g.c.b(str, field.getName());
                cVar2.f4819b = org.litepal.g.c.d(field.getName());
                cVar2.f4820c = g(b2);
                cVar2.d = org.litepal.g.c.b(str);
                this.f4723c.add(cVar2);
            }
        }
    }

    private static boolean b(Class<?> cls) {
        return List.class.isAssignableFrom(cls);
    }

    private static boolean c(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }

    private static boolean c(Field field) {
        return !field.getType().isPrimitive();
    }

    private static boolean d(Field field) {
        return Modifier.isPrivate(field.getModifiers());
    }

    private org.litepal.f.b.b e(Field field) {
        boolean z;
        String str;
        boolean z2;
        String g2 = g(field.getType().getName());
        org.litepal.a.a aVar = (org.litepal.a.a) field.getAnnotation(org.litepal.a.a.class);
        if (aVar != null) {
            z2 = aVar.a();
            z = aVar.b();
            str = aVar.c();
        } else {
            z = false;
            str = "";
            z2 = true;
        }
        org.litepal.f.b.b bVar = new org.litepal.f.b.b();
        bVar.f4815a = org.litepal.g.c.d(field.getName());
        bVar.f4816b = g2;
        bVar.f4817c = z2;
        bVar.d = z;
        bVar.a(str);
        return bVar;
    }

    protected static boolean e(String str) {
        return TrayContract.Preferences.Columns.ID.equalsIgnoreCase(str) || "id".equalsIgnoreCase(str);
    }

    protected static String f(String str) {
        return org.litepal.g.a.a(str + TrayContract.Preferences.Columns.ID);
    }

    private String g(String str) {
        for (f a2 : this.f) {
            String a3 = a2.a(str);
            if (a3 != null) {
                return a3;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final org.litepal.f.b.d a(String str) {
        String a2 = org.litepal.g.c.a(str);
        org.litepal.f.b.d dVar = new org.litepal.f.b.d();
        dVar.f4821a = a2;
        dVar.f4823c = str;
        for (Field next : c(str)) {
            String g2 = g(next.getType().getName());
            boolean z = true;
            boolean z2 = false;
            String str2 = "";
            org.litepal.a.a aVar = (org.litepal.a.a) next.getAnnotation(org.litepal.a.a.class);
            if (aVar != null) {
                z = aVar.a();
                z2 = aVar.b();
                str2 = aVar.c();
            }
            org.litepal.f.b.b bVar = new org.litepal.f.b.b();
            bVar.f4815a = org.litepal.g.c.d(next.getName());
            bVar.f4816b = g2;
            bVar.f4817c = z;
            bVar.d = z2;
            bVar.a(str2);
            dVar.a(bVar);
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public final void a(String str, int i2) {
        int i3;
        Field[] fieldArr;
        org.litepal.a.a aVar;
        int i4;
        int i5;
        Field[] fieldArr2;
        int i6;
        int i7;
        int i8;
        Field[] fieldArr3;
        int i9;
        int i10;
        Field[] fieldArr4;
        Class<?> cls;
        String str2 = str;
        int i11 = i2;
        try {
            Field[] declaredFields = Class.forName(str).getDeclaredFields();
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                if (!(!field.getType().isPrimitive()) || ((aVar = (org.litepal.a.a) field.getAnnotation(org.litepal.a.a.class)) != null && aVar.d())) {
                    fieldArr = declaredFields;
                    i3 = length;
                } else {
                    Class<?> type = field.getType();
                    if (org.litepal.e.a.a().d().contains(type.getName())) {
                        Field[] declaredFields2 = Class.forName(type.getName()).getDeclaredFields();
                        int length2 = declaredFields2.length;
                        boolean z = false;
                        int i13 = 0;
                        while (i13 < length2) {
                            Field field2 = declaredFields2[i13];
                            if (!Modifier.isStatic(field2.getModifiers())) {
                                Class<?> type2 = field2.getType();
                                if (str2.equals(type2.getName())) {
                                    if (i11 == 1) {
                                        a(str2, type.getName(), type.getName(), 1);
                                    } else if (i11 == 2) {
                                        i10 = i13;
                                        i9 = length2;
                                        String name = type.getName();
                                        fieldArr4 = declaredFields2;
                                        fieldArr3 = declaredFields;
                                        cls = type;
                                        a(str2, name, type.getName(), field, field2, 1);
                                        i8 = length;
                                        z = true;
                                    }
                                    i10 = i13;
                                    i9 = length2;
                                    fieldArr4 = declaredFields2;
                                    fieldArr3 = declaredFields;
                                    cls = type;
                                    i8 = length;
                                    z = true;
                                } else {
                                    i10 = i13;
                                    i9 = length2;
                                    fieldArr4 = declaredFields2;
                                    fieldArr3 = declaredFields;
                                    cls = type;
                                    if (!a(type2) || !str2.equals(b(field2))) {
                                        i8 = length;
                                    } else {
                                        if (i11 == 1) {
                                            a(str2, cls.getName(), str2, 2);
                                        } else if (i11 == 2) {
                                            i8 = length;
                                            a(str2, cls.getName(), str2, field, field2, 2);
                                            z = true;
                                        }
                                        i8 = length;
                                        z = true;
                                    }
                                }
                            } else {
                                i10 = i13;
                                i9 = length2;
                                fieldArr4 = declaredFields2;
                                fieldArr3 = declaredFields;
                                i8 = length;
                                cls = type;
                            }
                            i13 = i10 + 1;
                            type = cls;
                            declaredFields2 = fieldArr4;
                            length2 = i9;
                            declaredFields = fieldArr3;
                            length = i8;
                        }
                        fieldArr = declaredFields;
                        i3 = length;
                        i5 = 2;
                        i4 = 1;
                        Class<?> cls2 = type;
                        if (!z) {
                            if (i11 == 1) {
                                a(str2, cls2.getName(), cls2.getName(), 1);
                            } else if (i11 == 2) {
                                a(str2, cls2.getName(), cls2.getName(), field, (Field) null, 1);
                            }
                        }
                    } else {
                        fieldArr = declaredFields;
                        i3 = length;
                        i5 = 2;
                        i4 = 1;
                    }
                    if (a(field.getType())) {
                        String b2 = b(field);
                        if (org.litepal.e.a.a().d().contains(b2)) {
                            Field[] declaredFields3 = Class.forName(b2).getDeclaredFields();
                            int length3 = declaredFields3.length;
                            boolean z2 = false;
                            int i14 = 0;
                            while (i14 < length3) {
                                Field field3 = declaredFields3[i14];
                                if (!Modifier.isStatic(field3.getModifiers())) {
                                    Class<?> type3 = field3.getType();
                                    if (str2.equals(type3.getName())) {
                                        if (i11 == i4) {
                                            a(str2, b2, b2, i5);
                                        } else if (i11 == i5) {
                                            i7 = i14;
                                            i6 = length3;
                                            fieldArr2 = declaredFields3;
                                            a(str2, b2, b2, field, field3, 2);
                                        }
                                        i7 = i14;
                                        i6 = length3;
                                        fieldArr2 = declaredFields3;
                                    } else {
                                        Field field4 = field3;
                                        i7 = i14;
                                        i6 = length3;
                                        fieldArr2 = declaredFields3;
                                        if (a(type3)) {
                                            Field field5 = field4;
                                            if (str2.equals(b(field5))) {
                                                if (i11 == i4) {
                                                    if (str2.equalsIgnoreCase(b2)) {
                                                        c cVar = new c();
                                                        cVar.f4818a = org.litepal.g.c.b(str2, field.getName());
                                                        cVar.f4819b = org.litepal.g.c.a(field);
                                                        cVar.f4820c = "integer";
                                                        cVar.d = org.litepal.g.c.b(str);
                                                        this.f4723c.add(cVar);
                                                    } else {
                                                        a(str2, b2, (String) null, 3);
                                                    }
                                                } else if (i11 == i5 && !str2.equalsIgnoreCase(b2)) {
                                                    a(str2, b2, (String) null, field, field5, 3);
                                                }
                                            }
                                        }
                                    }
                                    z2 = true;
                                } else {
                                    i7 = i14;
                                    i6 = length3;
                                    fieldArr2 = declaredFields3;
                                }
                                i14 = i7 + 1;
                                length3 = i6;
                                declaredFields3 = fieldArr2;
                            }
                            if (!z2) {
                                if (i11 == i4) {
                                    a(str2, b2, b2, i5);
                                } else if (i11 == i5) {
                                    a(str2, b2, b2, field, (Field) null, 2);
                                }
                            }
                        } else if (org.litepal.g.a.c(b2) && i11 == i4) {
                            c cVar2 = new c();
                            cVar2.f4818a = org.litepal.g.c.b(str2, field.getName());
                            cVar2.f4819b = org.litepal.g.c.d(field.getName());
                            cVar2.f4820c = g(b2);
                            cVar2.d = org.litepal.g.c.b(str);
                            this.f4723c.add(cVar2);
                        }
                    }
                }
                i12++;
                declaredFields = fieldArr;
                length = i3;
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new org.litepal.c.b(org.litepal.c.b.CLASS_NOT_FOUND + str2);
        }
    }

    /* access modifiers changed from: protected */
    public final Collection<org.litepal.b.c.a> b(String str) {
        if (this.i == null) {
            this.i = new HashSet();
        }
        this.i.clear();
        a(str, 2);
        return this.i;
    }

    /* access modifiers changed from: protected */
    public final List<Field> c(String str) {
        List<Field> list = this.g.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            a(Class.forName(str), (List<Field>) arrayList);
            this.g.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new org.litepal.c.b(org.litepal.c.b.CLASS_NOT_FOUND + str);
        }
    }

    /* access modifiers changed from: protected */
    public final List<Field> d(String str) {
        List<Field> list = this.h.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            b(Class.forName(str), arrayList);
            this.h.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new org.litepal.c.b(org.litepal.c.b.CLASS_NOT_FOUND + str);
        }
    }
}
