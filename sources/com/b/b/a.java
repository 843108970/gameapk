package com.b.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class a extends y {

    /* renamed from: a  reason: collision with root package name */
    private static final long f844a = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: c  reason: collision with root package name */
    private static final long f845c = TimeUnit.MILLISECONDS.toNanos(f844a);
    /* access modifiers changed from: private */
    public static a d;
    private boolean e;
    private a f;
    private long g;

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (d == null) {
                d = new a();
                new d().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = nanoTime + Math.min(j, aVar.d() - nanoTime);
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.d();
            } else {
                throw new AssertionError();
            }
            long j2 = aVar.g - nanoTime;
            a aVar2 = d;
            while (true) {
                if (aVar2.f == null) {
                    break;
                } else if (j2 < aVar2.f.g - nanoTime) {
                    break;
                } else {
                    aVar2 = aVar2.f;
                }
            }
            aVar.f = aVar2.f;
            aVar2.f = aVar;
            if (aVar2 == d) {
                a.class.notify();
            }
        }
    }

    private static synchronized boolean a(a aVar) {
        boolean z;
        synchronized (a.class) {
            a aVar2 = d;
            while (true) {
                if (aVar2 == null) {
                    z = true;
                    break;
                } else if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    z = false;
                    break;
                } else {
                    aVar2 = aVar2.f;
                }
            }
        }
        return z;
    }

    static a e() {
        a aVar = d.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f844a);
            if (d.f != null || System.nanoTime() - nanoTime < f845c) {
                return null;
            }
            return d;
        }
        long nanoTime2 = aVar.g - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            a.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        d.f = aVar.f;
        aVar.f = null;
        return aVar;
    }

    public IOException a(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void a() {
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (a_() && z) {
            throw a((IOException) null);
        }
    }

    public final boolean a_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    /* access modifiers changed from: package-private */
    public final IOException b(IOException iOException) {
        return !a_() ? iOException : a(iOException);
    }

    public final void c() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long b_ = b_();
        boolean c_ = c_();
        if (b_ != 0 || c_) {
            this.e = true;
            a(this, b_, c_);
        }
    }
}
