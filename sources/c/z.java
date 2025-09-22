package c;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class z {

    /* renamed from: c  reason: collision with root package name */
    public static final z f436c = new z() {
        public final z a(long j) {
            return this;
        }

        public final z a(long j, TimeUnit timeUnit) {
            return this;
        }

        public final void f() throws IOException {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f437a;

    /* renamed from: b  reason: collision with root package name */
    private long f438b;
    private long d;

    private z b(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + j);
        } else if (timeUnit != null) {
            return a(System.nanoTime() + timeUnit.toNanos(j));
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public z a(long j) {
        this.f437a = true;
        this.f438b = j;
        return this;
    }

    public z a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public final void a(Object obj) throws InterruptedIOException {
        try {
            boolean m_ = m_();
            long l_ = l_();
            long j = 0;
            if (m_ || l_ != 0) {
                long nanoTime = System.nanoTime();
                if (m_ && l_ != 0) {
                    l_ = Math.min(l_, c() - nanoTime);
                } else if (m_) {
                    l_ = c() - nanoTime;
                }
                if (l_ > 0) {
                    long j2 = l_ / 1000000;
                    obj.wait(j2, (int) (l_ - (1000000 * j2)));
                    j = System.nanoTime() - nanoTime;
                }
                if (j >= l_) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException("interrupted");
        }
    }

    public long c() {
        if (this.f437a) {
            return this.f438b;
        }
        throw new IllegalStateException("No deadline");
    }

    public z d() {
        this.d = 0;
        return this;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f437a && this.f438b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long l_() {
        return this.d;
    }

    public boolean m_() {
        return this.f437a;
    }

    public z n_() {
        this.f437a = false;
        return this;
    }
}
