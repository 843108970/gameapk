package org.junit.b.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.a;
import org.junit.b;
import org.junit.f;
import org.junit.g;
import org.junit.m;

@Deprecated
public final class h {

    /* renamed from: a  reason: collision with root package name */
    final List<Throwable> f4519a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    j f4520b;

    public h(j jVar) {
        this.f4520b = jVar;
    }

    private void b() {
        a(a.class, false);
        a(f.class, false);
        a(m.class, false);
        if (this.f4520b.a(m.class).size() == 0) {
            this.f4519a.add(new Exception("No runnable methods"));
        }
    }

    private void c() {
        a(g.class, true);
        a(b.class, true);
    }

    private List<Throwable> d() {
        try {
            this.f4520b.a();
        } catch (Exception e) {
            this.f4519a.add(new Exception("Test class should have public zero-argument constructor", e));
        }
        c();
        b();
        return this.f4519a;
    }

    private void e() throws d {
        if (!this.f4519a.isEmpty()) {
            throw new d(this.f4519a);
        }
    }

    public final void a() {
        try {
            this.f4520b.a();
        } catch (Exception e) {
            this.f4519a.add(new Exception("Test class should have public zero-argument constructor", e));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Class<? extends Annotation> cls, boolean z) {
        for (Method next : this.f4520b.a(cls)) {
            if (Modifier.isStatic(next.getModifiers()) != z) {
                String str = z ? "should" : "should not";
                List<Throwable> list = this.f4519a;
                list.add(new Exception("Method " + next.getName() + "() " + str + " be static"));
            }
            if (!Modifier.isPublic(next.getDeclaringClass().getModifiers())) {
                List<Throwable> list2 = this.f4519a;
                list2.add(new Exception("Class " + next.getDeclaringClass().getName() + " should be public"));
            }
            if (!Modifier.isPublic(next.getModifiers())) {
                List<Throwable> list3 = this.f4519a;
                list3.add(new Exception("Method " + next.getName() + " should be public"));
            }
            if (next.getReturnType() != Void.TYPE) {
                List<Throwable> list4 = this.f4519a;
                list4.add(new Exception("Method " + next.getName() + " should be void"));
            }
            if (next.getParameterTypes().length != 0) {
                List<Throwable> list5 = this.f4519a;
                list5.add(new Exception("Method " + next.getName() + " should have no parameters"));
            }
        }
    }
}
