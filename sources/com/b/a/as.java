package com.b.a;

import java.io.Closeable;

public final class as implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final ao f784a;

    /* renamed from: b  reason: collision with root package name */
    final al f785b;

    /* renamed from: c  reason: collision with root package name */
    final int f786c;
    final String d;
    final z e;
    final aa f;
    final au g;
    final as h;
    final as i;
    final as j;
    final long k;
    final long l;
    private volatile e m;

    as(at atVar) {
        this.f784a = atVar.f787a;
        this.f785b = atVar.f788b;
        this.f786c = atVar.f789c;
        this.d = atVar.d;
        this.e = atVar.e;
        this.f = atVar.f.a();
        this.g = atVar.g;
        this.h = atVar.h;
        this.i = atVar.i;
        this.j = atVar.j;
        this.k = atVar.k;
        this.l = atVar.l;
    }

    public final ao a() {
        return this.f784a;
    }

    public final String a(String str) {
        String a2 = this.f.a(str);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public final int b() {
        return this.f786c;
    }

    public final z c() {
        return this.e;
    }

    public final void close() {
        this.g.close();
    }

    public final aa d() {
        return this.f;
    }

    public final au e() {
        return this.g;
    }

    public final at f() {
        return new at(this);
    }

    public final e g() {
        e eVar = this.m;
        if (eVar != null) {
            return eVar;
        }
        e a2 = e.a(this.f);
        this.m = a2;
        return a2;
    }

    public final long h() {
        return this.k;
    }

    public final long i() {
        return this.l;
    }

    public final String toString() {
        return "Response{protocol=" + this.f785b + ", code=" + this.f786c + ", message=" + this.d + ", url=" + this.f784a.f775a + '}';
    }
}
