package com.b.b;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class y {

    /* renamed from: b  reason: collision with root package name */
    public static final y f884b = new z();

    /* renamed from: a  reason: collision with root package name */
    private boolean f885a;

    /* renamed from: c  reason: collision with root package name */
    private long f886c;
    private long d;

    public y a(long j) {
        this.f885a = true;
        this.f886c = j;
        return this;
    }

    public y a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long b_() {
        return this.d;
    }

    public boolean c_() {
        return this.f885a;
    }

    public long d() {
        if (this.f885a) {
            return this.f886c;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d_() {
        this.d = 0;
        return this;
    }

    public y e_() {
        this.f885a = false;
        return this;
    }

    public void f_() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f885a && this.f886c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
