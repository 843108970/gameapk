package org.junit.e.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.junit.b.h;
import org.junit.c;
import org.junit.f;
import org.junit.g;

public class k implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f4121a = new b((byte) 0);
    private static final a e = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f4122b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends Annotation>, List<d>> f4123c;
    public final Map<Class<? extends Annotation>, List<b>> d;

    private static class a implements Comparator<Field> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private static int a(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((Field) obj).getName().compareTo(((Field) obj2).getName());
        }
    }

    private static class b implements Comparator<d> {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        private static int a(d dVar, d dVar2) {
            return h.f4526b.compare(dVar.f4120a, dVar2.f4120a);
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return h.f4526b.compare(((d) obj).f4120a, ((d) obj2).f4120a);
        }
    }

    public k(Class<?> cls) {
        this.f4122b = cls;
        if (cls == null || cls.getConstructors().length <= 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            a((Map<Class<? extends Annotation>, List<d>>) linkedHashMap, (Map<Class<? extends Annotation>, List<b>>) linkedHashMap2);
            this.f4123c = b(linkedHashMap);
            this.d = b(linkedHashMap2);
            return;
        }
        throw new IllegalArgumentException("Test class can only have one constructor");
    }

    public static <T> List<T> a(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (List<T> addAll : map.values()) {
            linkedHashSet.addAll(addAll);
        }
        return new ArrayList(linkedHashSet);
    }

    private static <T> List<T> a(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z) {
        if (!map.containsKey(cls) && z) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    private void a(Map<Class<? extends Annotation>, List<d>> map, Map<Class<? extends Annotation>, List<b>> map2) {
        ArrayList<Class> arrayList = new ArrayList<>();
        for (Class cls = this.f4122b; cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        for (Class cls2 : arrayList) {
            for (Method dVar : h.a((Class<?>) cls2)) {
                a(new d(dVar), map);
            }
            Field[] declaredFields = cls2.getDeclaredFields();
            Arrays.sort(declaredFields, e);
            for (Field bVar : declaredFields) {
                a(new b(bVar), map2);
            }
        }
    }

    private static <T extends c<T>> void a(T t, Map<Class<? extends Annotation>, List<T>> map) {
        boolean z;
        Annotation[] a2 = t.a();
        int length = a2.length;
        int i = 0;
        while (i < length) {
            Class annotationType = a2[i].annotationType();
            boolean z2 = true;
            List<T> a3 = a(map, (Class<? extends Annotation>) annotationType, true);
            Iterator<T> it = a3.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (t.a((c) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                if (!annotationType.equals(f.class) && !annotationType.equals(g.class)) {
                    z2 = false;
                }
                if (z2) {
                    a3.add(0, t);
                } else {
                    a3.add(t);
                }
                i++;
            } else {
                return;
            }
        }
    }

    private static <T extends c<T>> Map<Class<? extends Annotation>, List<T>> b(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static Field[] d(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, e);
        return declaredFields;
    }

    private List<d> e() {
        List<d> a2 = a(this.f4123c);
        Collections.sort(a2, f4121a);
        return a2;
    }

    private static boolean e(Class<? extends Annotation> cls) {
        return cls.equals(f.class) || cls.equals(g.class);
    }

    private List<b> f() {
        return a(this.d);
    }

    private static List<Class<?>> f(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            arrayList.add(cls2);
        }
        return arrayList;
    }

    private Class<?> g() {
        return this.f4122b;
    }

    private boolean h() {
        return Modifier.isPublic(this.f4122b.getModifiers());
    }

    public final <T extends Annotation> T a(Class<T> cls) {
        if (this.f4122b == null) {
            return null;
        }
        return this.f4122b.getAnnotation(cls);
    }

    public final <T> List<T> a(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : c(cls)) {
            try {
                Object obj2 = bVar.f4119a.get(obj);
                if (cls2.isInstance(obj2)) {
                    arrayList.add(cls2.cast(obj2));
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e2);
            }
        }
        return arrayList;
    }

    public final Annotation[] a() {
        return this.f4122b == null ? new Annotation[0] : this.f4122b.getAnnotations();
    }

    public final String b() {
        return this.f4122b == null ? "null" : this.f4122b.getName();
    }

    public final List<d> b(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(a(this.f4123c, cls, false));
    }

    public final <T> List<T> b(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (d next : b(cls)) {
            try {
                if (cls2.isAssignableFrom(next.f4120a.getReturnType())) {
                    arrayList.add(cls2.cast(next.a(obj, new Object[0])));
                }
            } catch (Throwable th) {
                throw new RuntimeException("Exception in " + next.f4120a.getName(), th);
            }
        }
        return arrayList;
    }

    public final Constructor<?> c() {
        Constructor<?>[] constructors = this.f4122b.getConstructors();
        long length = (long) constructors.length;
        if (1 != length) {
            c.b((Object) 1L, (Object) Long.valueOf(length));
        }
        return constructors[0];
    }

    public final List<b> c(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(a(this.d, cls, false));
    }

    public final boolean d() {
        return this.f4122b.isMemberClass() && !Modifier.isStatic(this.f4122b.getModifiers());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f4122b == ((k) obj).f4122b;
    }

    public int hashCode() {
        if (this.f4122b == null) {
            return 0;
        }
        return this.f4122b.hashCode();
    }
}
