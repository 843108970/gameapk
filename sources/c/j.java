package c;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class j extends z {

    /* renamed from: a  reason: collision with root package name */
    public z f394a;

    public j(z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f394a = zVar;
    }

    private j a(z zVar) {
        if (zVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f394a = zVar;
        return this;
    }

    private z g() {
        return this.f394a;
    }

    public final z a(long j) {
        return this.f394a.a(j);
    }

    public final z a(long j, TimeUnit timeUnit) {
        return this.f394a.a(j, timeUnit);
    }

    public final long c() {
        return this.f394a.c();
    }

    public final z d() {
        return this.f394a.d();
    }

    public final void f() throws IOException {
        this.f394a.f();
    }

    public final long l_() {
        return this.f394a.l_();
    }

    public final boolean m_() {
        return this.f394a.m_();
    }

    public final z n_() {
        return this.f394a.n_();
    }
}
