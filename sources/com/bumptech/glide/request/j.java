package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

public final class j implements c, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final d f1468a;

    /* renamed from: b  reason: collision with root package name */
    private c f1469b;

    /* renamed from: c  reason: collision with root package name */
    private c f1470c;
    private boolean d;

    @VisibleForTesting
    j() {
        this((d) null);
    }

    public j(@Nullable d dVar) {
        this.f1468a = dVar;
    }

    private boolean j() {
        return this.f1468a == null || this.f1468a.b(this);
    }

    private boolean k() {
        return this.f1468a == null || this.f1468a.d(this);
    }

    private boolean l() {
        return this.f1468a == null || this.f1468a.c(this);
    }

    private boolean m() {
        return this.f1468a != null && this.f1468a.i();
    }

    public final void a() {
        this.d = true;
        if (!this.f1469b.d() && !this.f1470c.c()) {
            this.f1470c.a();
        }
        if (this.d && !this.f1469b.c()) {
            this.f1469b.a();
        }
    }

    public final void a(c cVar, c cVar2) {
        this.f1469b = cVar;
        this.f1470c = cVar2;
    }

    public final boolean a(c cVar) {
        if (cVar instanceof j) {
            j jVar = (j) cVar;
            if (this.f1469b != null ? this.f1469b.a(jVar.f1469b) : jVar.f1469b == null) {
                if (this.f1470c == null) {
                    if (jVar.f1470c == null) {
                        return true;
                    }
                } else if (this.f1470c.a(jVar.f1470c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b() {
        this.d = false;
        this.f1470c.b();
        this.f1469b.b();
    }

    public final boolean b(c cVar) {
        return (this.f1468a == null || this.f1468a.b(this)) && (cVar.equals(this.f1469b) || !this.f1469b.e());
    }

    public final boolean c() {
        return this.f1469b.c();
    }

    public final boolean c(c cVar) {
        return (this.f1468a == null || this.f1468a.c(this)) && cVar.equals(this.f1469b) && !i();
    }

    public final boolean d() {
        return this.f1469b.d() || this.f1470c.d();
    }

    public final boolean d(c cVar) {
        return (this.f1468a == null || this.f1468a.d(this)) && cVar.equals(this.f1469b);
    }

    public final void e(c cVar) {
        if (!cVar.equals(this.f1470c)) {
            if (this.f1468a != null) {
                this.f1468a.e(this);
            }
            if (!this.f1470c.d()) {
                this.f1470c.b();
            }
        }
    }

    public final boolean e() {
        return this.f1469b.e() || this.f1470c.e();
    }

    public final void f(c cVar) {
        if (cVar.equals(this.f1469b) && this.f1468a != null) {
            this.f1468a.f(this);
        }
    }

    public final boolean f() {
        return this.f1469b.f();
    }

    public final boolean g() {
        return this.f1469b.g();
    }

    public final void h() {
        this.f1469b.h();
        this.f1470c.h();
    }

    public final boolean i() {
        return (this.f1468a != null && this.f1468a.i()) || e();
    }
}
