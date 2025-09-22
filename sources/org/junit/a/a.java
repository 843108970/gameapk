package org.junit.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.e.a.e;
import org.junit.e.a.h;
import org.junit.e.a.i;
import org.junit.e.f;
import org.junit.runner.k;

public final class a extends org.junit.runner.a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f4422a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4423b;

    private a(boolean z, boolean z2) {
        this.f4422a = z;
        this.f4423b = z2;
    }

    private static org.junit.runner.a a() {
        return new a(true, false);
    }

    private static k a(k kVar) {
        if (kVar instanceof f) {
            ((f) kVar).d = new i() {

                /* renamed from: a  reason: collision with root package name */
                private final ExecutorService f4424a = Executors.newCachedThreadPool();

                public final void a() {
                    try {
                        this.f4424a.shutdown();
                        this.f4424a.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                }

                public final void a(Runnable runnable) {
                    this.f4424a.submit(runnable);
                }
            };
        }
        return kVar;
    }

    private static org.junit.runner.a b() {
        return new a(false, true);
    }

    /* access modifiers changed from: protected */
    public final k a(h hVar, Class<?> cls) throws Throwable {
        k a2 = super.a(hVar, cls);
        return this.f4423b ? a(a2) : a2;
    }

    public final k a(h hVar, Class<?>[] clsArr) throws e {
        k a2 = super.a(hVar, clsArr);
        return this.f4422a ? a(a2) : a2;
    }
}
