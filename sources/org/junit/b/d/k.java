package org.junit.b.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.a;
import org.junit.f;
import org.junit.m;

@Deprecated
public final class k {

    /* renamed from: a  reason: collision with root package name */
    final Method f4522a;

    /* renamed from: b  reason: collision with root package name */
    j f4523b;

    public k(Method method, j jVar) {
        this.f4522a = method;
        this.f4523b = jVar;
    }

    private void a(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        this.f4522a.invoke(obj, new Object[0]);
    }

    private boolean c() {
        return this.f4522a.getAnnotation(org.junit.k.class) != null;
    }

    private long d() {
        m mVar = (m) this.f4522a.getAnnotation(m.class);
        if (mVar == null) {
            return 0;
        }
        return mVar.b();
    }

    private List<Method> e() {
        return this.f4523b.a(f.class);
    }

    private List<Method> f() {
        return this.f4523b.a(a.class);
    }

    /* access modifiers changed from: protected */
    public final Class<? extends Throwable> a() {
        m mVar = (m) this.f4522a.getAnnotation(m.class);
        if (mVar == null || mVar.a() == m.a.class) {
            return null;
        }
        return mVar.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Throwable th) {
        return !a().isAssignableFrom(th.getClass());
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return a() != null;
    }
}
