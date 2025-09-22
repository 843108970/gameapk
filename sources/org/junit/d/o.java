package org.junit.d;

import java.util.concurrent.TimeUnit;
import org.junit.b.d.c.c;
import org.junit.e.a.j;

public final class o implements l {

    /* renamed from: a  reason: collision with root package name */
    private final long f4557a;

    /* renamed from: b  reason: collision with root package name */
    private final TimeUnit f4558b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4559c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f4562a = false;

        /* renamed from: b  reason: collision with root package name */
        long f4563b = 0;

        /* renamed from: c  reason: collision with root package name */
        TimeUnit f4564c = TimeUnit.SECONDS;

        protected a() {
        }

        private long a() {
            return this.f4563b;
        }

        private a a(long j, TimeUnit timeUnit) {
            this.f4563b = j;
            this.f4564c = timeUnit;
            return this;
        }

        private a a(boolean z) {
            this.f4562a = z;
            return this;
        }

        private TimeUnit b() {
            return this.f4564c;
        }

        private boolean c() {
            return this.f4562a;
        }

        private o d() {
            return new o(this);
        }
    }

    @Deprecated
    private o(int i) {
        this((long) i, TimeUnit.MILLISECONDS);
    }

    private o(long j, TimeUnit timeUnit) {
        this.f4557a = j;
        this.f4558b = timeUnit;
        this.f4559c = false;
    }

    protected o(a aVar) {
        this.f4557a = aVar.f4563b;
        this.f4558b = aVar.f4564c;
        this.f4559c = aVar.f4562a;
    }

    private long a(TimeUnit timeUnit) {
        return timeUnit.convert(this.f4557a, this.f4558b);
    }

    private static a a() {
        return new a();
    }

    private static o a(long j) {
        return new o(j, TimeUnit.MILLISECONDS);
    }

    private j a(j jVar) throws Exception {
        c.a a2 = c.b().a(this.f4557a, this.f4558b);
        a2.f4491a = this.f4559c;
        return a2.a(jVar);
    }

    private static o b(long j) {
        return new o(j, TimeUnit.SECONDS);
    }

    private boolean b() {
        return this.f4559c;
    }

    public final j a(j jVar, org.junit.runner.c cVar) {
        try {
            c.a a2 = c.b().a(this.f4557a, this.f4558b);
            a2.f4491a = this.f4559c;
            return a2.a(jVar);
        } catch (Exception e) {
            return new j() {
                public final void a() throws Throwable {
                    throw new RuntimeException("Invalid parameters for Timeout", e);
                }
            };
        }
    }
}
