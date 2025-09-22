package org.junit.a.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f4116b;

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f4117a;

    /* renamed from: c  reason: collision with root package name */
    private final Annotation[] f4118c;

    static {
        HashMap hashMap = new HashMap();
        a(hashMap, Boolean.TYPE, Boolean.class);
        a(hashMap, Byte.TYPE, Byte.class);
        a(hashMap, Short.TYPE, Short.class);
        a(hashMap, Character.TYPE, Character.class);
        a(hashMap, Integer.TYPE, Integer.class);
        a(hashMap, Long.TYPE, Long.class);
        a(hashMap, Float.TYPE, Float.class);
        a(hashMap, Double.TYPE, Double.class);
        f4116b = Collections.unmodifiableMap(hashMap);
    }

    private d(Class<?> cls, Annotation[] annotationArr) {
        this.f4117a = cls;
        this.f4118c = annotationArr;
    }

    private <T extends Annotation> T a(Annotation[] annotationArr, Class<T> cls, int i) {
        if (i == 0) {
            return null;
        }
        int length = annotationArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            T t = annotationArr[i2];
            if (cls.isInstance(t) || (t = a(t.annotationType().getAnnotations(), cls, i - 1)) != null) {
                return (Annotation) cls.cast(t);
            }
        }
        return null;
    }

    public static ArrayList<d> a(Method method) {
        return a((Class<?>[]) method.getParameterTypes(), method.getParameterAnnotations());
    }

    private static ArrayList<d> a(Class<?>[] clsArr, Annotation[][] annotationArr) {
        ArrayList<d> arrayList = new ArrayList<>();
        for (int i = 0; i < clsArr.length; i++) {
            arrayList.add(new d(clsArr[i], annotationArr[i]));
        }
        return arrayList;
    }

    public static List<d> a(Constructor<?> constructor) {
        return a((Class<?>[]) constructor.getParameterTypes(), constructor.getParameterAnnotations());
    }

    private static Map<Class<?>, Class<?>> a() {
        HashMap hashMap = new HashMap();
        a(hashMap, Boolean.TYPE, Boolean.class);
        a(hashMap, Byte.TYPE, Byte.class);
        a(hashMap, Short.TYPE, Short.class);
        a(hashMap, Character.TYPE, Character.class);
        a(hashMap, Integer.TYPE, Integer.class);
        a(hashMap, Long.TYPE, Long.class);
        a(hashMap, Float.TYPE, Float.class);
        a(hashMap, Double.TYPE, Double.class);
        return Collections.unmodifiableMap(hashMap);
    }

    private static <T> void a(Map<T, T> map, T t, T t2) {
        map.put(t, t2);
        map.put(t2, t);
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        if (f4116b.containsKey(cls2)) {
            return cls.isAssignableFrom(f4116b.get(cls2));
        }
        return false;
    }

    private Class<?> b() {
        return this.f4117a;
    }

    private List<Annotation> c() {
        return Arrays.asList(this.f4118c);
    }

    private boolean d(Class<?> cls) {
        return cls.isAssignableFrom(this.f4117a) || a(cls, this.f4117a) || a(cls);
    }

    private boolean e(Class<? extends Annotation> cls) {
        return c(cls) != null;
    }

    public final boolean a(Class<?> cls) {
        return this.f4117a.isAssignableFrom(cls) || a(this.f4117a, cls);
    }

    public final boolean a(Object obj) {
        return obj == null ? !this.f4117a.isPrimitive() : a(obj.getClass());
    }

    public final <T extends Annotation> T b(Class<T> cls) {
        return a(this.f4118c, cls, 3);
    }

    public final <T extends Annotation> T c(Class<T> cls) {
        for (Annotation annotation : Arrays.asList(this.f4118c)) {
            if (cls.isInstance(annotation)) {
                return (Annotation) cls.cast(annotation);
            }
        }
        return null;
    }
}
