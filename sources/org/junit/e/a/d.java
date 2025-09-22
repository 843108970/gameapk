package org.junit.e.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.b.d.a.c;

public class d extends c<d> {

    /* renamed from: a  reason: collision with root package name */
    public final Method f4120a;

    public d(Method method) {
        if (method == null) {
            throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
        }
        this.f4120a = method;
    }

    private void a(List<Throwable> list) {
        g gVar = new g(this.f4120a);
        for (Type a2 : gVar.f4570a.getGenericParameterTypes()) {
            gVar.a(a2, list);
        }
    }

    @Deprecated
    private boolean a(Type type) {
        return this.f4120a.getParameterTypes().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.f4120a.getReturnType());
    }

    private boolean b(d dVar) {
        if (!dVar.f4120a.getName().equals(this.f4120a.getName()) || dVar.f4120a.getParameterTypes().length != this.f4120a.getParameterTypes().length) {
            return false;
        }
        for (int i = 0; i < dVar.f4120a.getParameterTypes().length; i++) {
            if (!dVar.f4120a.getParameterTypes()[i].equals(this.f4120a.getParameterTypes()[i])) {
                return false;
            }
        }
        return true;
    }

    private Method h() {
        return this.f4120a;
    }

    private Class<?> i() {
        return this.f4120a.getReturnType();
    }

    private Class<?>[] j() {
        return this.f4120a.getParameterTypes();
    }

    public final Object a(final Object obj, final Object... objArr) throws Throwable {
        return new c() {
            /* access modifiers changed from: protected */
            public final Object b() throws Throwable {
                return d.this.f4120a.invoke(obj, objArr);
            }
        }.a();
    }

    public final <T extends Annotation> T a(Class<T> cls) {
        return this.f4120a.getAnnotation(cls);
    }

    public final void a(boolean z, List<Throwable> list) {
        b(z, list);
        if (this.f4120a.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.f4120a.getName() + " should have no parameters"));
        }
    }

    public final /* synthetic */ boolean a(c cVar) {
        d dVar = (d) cVar;
        if (!dVar.f4120a.getName().equals(this.f4120a.getName()) || dVar.f4120a.getParameterTypes().length != this.f4120a.getParameterTypes().length) {
            return false;
        }
        for (int i = 0; i < dVar.f4120a.getParameterTypes().length; i++) {
            if (!dVar.f4120a.getParameterTypes()[i].equals(this.f4120a.getParameterTypes()[i])) {
                return false;
            }
        }
        return true;
    }

    public final Annotation[] a() {
        return this.f4120a.getAnnotations();
    }

    public final String b() {
        return this.f4120a.getName();
    }

    public final void b(boolean z, List<Throwable> list) {
        if (f() != z) {
            String str = z ? "should" : "should not";
            list.add(new Exception("Method " + this.f4120a.getName() + "() " + str + " be static"));
        }
        if (!g()) {
            list.add(new Exception("Method " + this.f4120a.getName() + "() should be public"));
        }
        if (this.f4120a.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.f4120a.getName() + "() should be void"));
        }
    }

    /* access modifiers changed from: protected */
    public final int c() {
        return this.f4120a.getModifiers();
    }

    public final Class<?> d() {
        return this.f4120a.getReturnType();
    }

    public final Class<?> e() {
        return this.f4120a.getDeclaringClass();
    }

    public boolean equals(Object obj) {
        if (!d.class.isInstance(obj)) {
            return false;
        }
        return ((d) obj).f4120a.equals(this.f4120a);
    }

    public int hashCode() {
        return this.f4120a.hashCode();
    }

    public String toString() {
        return this.f4120a.toString();
    }
}
