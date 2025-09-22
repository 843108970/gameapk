package com.bumptech.glide.request;

import android.support.annotation.Nullable;

public final class a implements c, d {

    /* renamed from: a  reason: collision with root package name */
    public c f1435a;

    /* renamed from: b  reason: collision with root package name */
    public c f1436b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final d f1437c;

    public a(@Nullable d dVar) {
        this.f1437c = dVar;
    }

    private void a(c cVar, c cVar2) {
        this.f1435a = cVar;
        this.f1436b = cVar2;
    }

    private boolean g(c cVar) {
        if (!cVar.equals(this.f1435a)) {
            return this.f1435a.g() && cVar.equals(this.f1436b);
        }
        return true;
    }

    private boolean j() {
        return this.f1437c == null || this.f1437c.b(this);
    }

    private boolean k() {
        return this.f1437c == null || this.f1437c.d(this);
    }

    private boolean l() {
        return this.f1437c == null || this.f1437c.c(this);
    }

    private boolean m() {
        return this.f1437c != null && this.f1437c.i();
    }

    public final void a() {
        if (!this.f1435a.c()) {
            this.f1435a.a();
        }
    }

    public final boolean a(c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            return this.f1435a.a(aVar.f1435a) && this.f1436b.a(aVar.f1436b);
        }
    }

    public final void b() {
        this.f1435a.b();
        if (this.f1436b.c()) {
            this.f1436b.b();
        }
    }

    public final boolean b(c cVar) {
        return (this.f1437c == null || this.f1437c.b(this)) && g(cVar);
    }

    public final boolean c() {
        return (this.f1435a.g() ? this.f1436b : this.f1435a).c();
    }

    public final boolean c(c cVar) {
        return (this.f1437c == null || this.f1437c.c(this)) && g(cVar);
    }

    public final boolean d() {
        return (this.f1435a.g() ? this.f1436b : this.f1435a).d();
    }

    public final boolean d(c cVar) {
        return (this.f1437c == null || this.f1437c.d(this)) && g(cVar);
    }

    public final void e(c cVar) {
        if (this.f1437c != null) {
            this.f1437c.e(this);
        }
    }

    public final boolean e() {
        return (this.f1435a.g() ? this.f1436b : this.f1435a).e();
    }

    public final void f(c cVar) {
        if (!cVar.equals(this.f1436b)) {
            if (!this.f1436b.c()) {
                this.f1436b.a();
            }
        } else if (this.f1437c != null) {
            this.f1437c.f(this);
        }
    }

    public final boolean f() {
        return (this.f1435a.g() ? this.f1436b : this.f1435a).f();
    }

    public final boolean g() {
        return this.f1435a.g() && this.f1436b.g();
    }

    public final void h() {
        this.f1435a.h();
        this.f1436b.h();
    }

    public final boolean i() {
        return (this.f1437c != null && this.f1437c.i()) || e();
    }
}
