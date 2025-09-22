package org.junit.e.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class b extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    public final Field f4119a;

    b(Field field) {
        if (field == null) {
            throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
        }
        this.f4119a = field;
    }

    private Object a(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.f4119a.get(obj);
    }

    private boolean a(b bVar) {
        return bVar.f4119a.getName().equals(this.f4119a.getName());
    }

    private Field h() {
        return this.f4119a;
    }

    public final <T extends Annotation> T a(Class<T> cls) {
        return this.f4119a.getAnnotation(cls);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return ((b) cVar).f4119a.getName().equals(this.f4119a.getName());
    }

    public final Annotation[] a() {
        return this.f4119a.getAnnotations();
    }

    public final String b() {
        return this.f4119a.getName();
    }

    /* access modifiers changed from: protected */
    public final int c() {
        return this.f4119a.getModifiers();
    }

    public final Class<?> d() {
        return this.f4119a.getType();
    }

    public final Class<?> e() {
        return this.f4119a.getDeclaringClass();
    }

    public final String toString() {
        return this.f4119a.toString();
    }
}
