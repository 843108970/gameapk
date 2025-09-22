package org.junit.d;

import java.util.concurrent.TimeUnit;
import org.junit.e.a.j;
import org.junit.runner.c;

public abstract class i implements l {

    /* renamed from: a  reason: collision with root package name */
    volatile long f4544a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public volatile long f4545b;

    /* renamed from: c  reason: collision with root package name */
    private final a f4546c;

    static class a {
        a() {
        }

        private static long a() {
            return System.nanoTime();
        }
    }

    private class b extends m {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void a() {
            i.this.a();
        }

        /* access modifiers changed from: protected */
        public final void a(c cVar) {
            i iVar = i.this;
            iVar.f4544a = System.nanoTime();
            iVar.f4545b = 0;
        }

        /* access modifiers changed from: protected */
        public final void b() {
            i.this.f4545b = System.nanoTime();
            i.this.a();
        }

        /* access modifiers changed from: protected */
        public final void c() {
            i.this.f4545b = System.nanoTime();
            i.this.a();
        }

        /* access modifiers changed from: protected */
        public final void d() {
            i.this.f4545b = System.nanoTime();
            i.this.a();
        }
    }

    public i() {
        this(new a());
    }

    private i(a aVar) {
        this.f4546c = aVar;
    }

    private long a(TimeUnit timeUnit) {
        return timeUnit.convert(a(), TimeUnit.NANOSECONDS);
    }

    private static /* synthetic */ void a(i iVar) {
        iVar.f4544a = System.nanoTime();
        iVar.f4545b = 0;
    }

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    private static void e() {
    }

    private void f() {
        this.f4544a = System.nanoTime();
        this.f4545b = 0;
    }

    private void g() {
        this.f4545b = System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    public final long a() {
        if (this.f4544a == 0) {
            throw new IllegalStateException("Test has not started");
        }
        long j = this.f4545b;
        if (j == 0) {
            j = System.nanoTime();
        }
        return j - this.f4544a;
    }

    public final j a(j jVar, c cVar) {
        return new b(this, (byte) 0).a(jVar, cVar);
    }
}
