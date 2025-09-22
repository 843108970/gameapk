package org.junit.b.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.b.b;
import org.junit.g;
import org.junit.runner.b.c;

@Deprecated
public final class a {

    /* renamed from: a  reason: collision with root package name */
    j f4472a;

    /* renamed from: b  reason: collision with root package name */
    final Runnable f4473b;

    /* renamed from: c  reason: collision with root package name */
    private c f4474c;
    private org.junit.runner.c d;

    public a(c cVar, j jVar, org.junit.runner.c cVar2, Runnable runnable) {
        this.f4474c = cVar;
        this.f4472a = jVar;
        this.d = cVar2;
        this.f4473b = runnable;
    }

    private void b() {
        this.f4473b.run();
    }

    private void c() {
        try {
            for (Method invoke : this.f4472a.a(g.class)) {
                invoke.invoke((Object) null, new Object[0]);
            }
            this.f4473b.run();
            a();
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (b unused) {
            throw new c();
        } catch (c unused2) {
            a();
        } catch (Throwable th) {
            a();
            throw th;
        }
    }

    private void d() throws c {
        try {
            for (Method invoke : this.f4472a.a(g.class)) {
                invoke.invoke((Object) null, new Object[0]);
            }
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (b unused) {
            throw new c();
        } catch (Throwable th) {
            a(th);
            throw new c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Throwable th;
        for (Method invoke : this.f4472a.a(org.junit.b.class)) {
            try {
                invoke.invoke((Object) null, new Object[0]);
            } catch (InvocationTargetException e) {
                th = e.getTargetException();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return;
        a(th);
    }

    /* access modifiers changed from: package-private */
    public final void a(Throwable th) {
        this.f4474c.a(new org.junit.runner.b.a(this.d, th));
    }
}
