package org.a.a;

import org.a.g;
import org.a.h;
import org.a.i;
import org.a.k;

public final class j extends h<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f4254a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f4255b;

    public j(Class<?> cls) {
        Class<Boolean> cls2;
        this.f4254a = cls;
        if (Boolean.TYPE.equals(cls)) {
            cls2 = Boolean.class;
        } else if (Byte.TYPE.equals(cls)) {
            cls2 = Byte.class;
        } else if (Character.TYPE.equals(cls)) {
            cls2 = Character.class;
        } else if (Double.TYPE.equals(cls)) {
            cls2 = Double.class;
        } else if (Float.TYPE.equals(cls)) {
            cls2 = Float.class;
        } else if (Integer.TYPE.equals(cls)) {
            cls2 = Integer.class;
        } else if (Long.TYPE.equals(cls)) {
            cls2 = Long.class;
        } else {
            boolean equals = Short.TYPE.equals(cls);
            cls2 = cls;
            if (equals) {
                cls2 = Short.class;
            }
        }
        this.f4255b = cls2;
    }

    @i
    public static <T> k<T> a(Class<?> cls) {
        return new j(cls);
    }

    private static Class<?> b(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @i
    private static <T> k<T> c(Class<T> cls) {
        return new j(cls);
    }

    /* access modifiers changed from: protected */
    public final boolean b(Object obj, g gVar) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (this.f4255b.isInstance(obj)) {
            return true;
        } else {
            gVar = gVar.a(obj);
            str = " is a " + obj.getClass().getName();
        }
        gVar.a(str);
        return false;
    }

    public final void describeTo(g gVar) {
        gVar.a("an instance of ").a(this.f4254a.getName());
    }
}
