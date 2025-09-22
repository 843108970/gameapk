package com.b.b;

import java.util.concurrent.TimeUnit;

public final class k extends y {

    /* renamed from: a  reason: collision with root package name */
    private y f860a;

    public k(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f860a = yVar;
    }

    public final k a(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f860a = yVar;
        return this;
    }

    public final y a() {
        return this.f860a;
    }

    public final y a(long j) {
        return this.f860a.a(j);
    }

    public final y a(long j, TimeUnit timeUnit) {
        return this.f860a.a(j, timeUnit);
    }

    public final long b_() {
        return this.f860a.b_();
    }

    public final boolean c_() {
        return this.f860a.c_();
    }

    public final long d() {
        return this.f860a.d();
    }

    public final y d_() {
        return this.f860a.d_();
    }

    public final y e_() {
        return this.f860a.e_();
    }

    public final void f_() {
        this.f860a.f_();
    }
}
