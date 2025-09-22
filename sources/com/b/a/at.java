package com.b.a;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    ao f787a;

    /* renamed from: b  reason: collision with root package name */
    al f788b;

    /* renamed from: c  reason: collision with root package name */
    int f789c;
    String d;
    z e;
    ab f;
    au g;
    as h;
    as i;
    as j;
    long k;
    long l;

    public at() {
        this.f789c = -1;
        this.f = new ab();
    }

    at(as asVar) {
        this.f789c = -1;
        this.f787a = asVar.f784a;
        this.f788b = asVar.f785b;
        this.f789c = asVar.f786c;
        this.d = asVar.d;
        this.e = asVar.e;
        this.f = asVar.f.b();
        this.g = asVar.g;
        this.h = asVar.h;
        this.i = asVar.i;
        this.j = asVar.j;
        this.k = asVar.k;
        this.l = asVar.l;
    }

    private static void a(String str, as asVar) {
        if (asVar.g != null) {
            throw new IllegalArgumentException(str + ".body != null");
        } else if (asVar.h != null) {
            throw new IllegalArgumentException(str + ".networkResponse != null");
        } else if (asVar.i != null) {
            throw new IllegalArgumentException(str + ".cacheResponse != null");
        } else if (asVar.j != null) {
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }
    }

    public final as a() {
        if (this.f787a == null) {
            throw new IllegalStateException("request == null");
        } else if (this.f788b == null) {
            throw new IllegalStateException("protocol == null");
        } else if (this.f789c >= 0) {
            return new as(this);
        } else {
            throw new IllegalStateException("code < 0: " + this.f789c);
        }
    }

    public final at a(int i2) {
        this.f789c = i2;
        return this;
    }

    public final at a(long j2) {
        this.k = j2;
        return this;
    }

    public final at a(aa aaVar) {
        this.f = aaVar.b();
        return this;
    }

    public final at a(al alVar) {
        this.f788b = alVar;
        return this;
    }

    public final at a(ao aoVar) {
        this.f787a = aoVar;
        return this;
    }

    public final at a(as asVar) {
        if (asVar != null) {
            a("networkResponse", asVar);
        }
        this.h = asVar;
        return this;
    }

    public final at a(au auVar) {
        this.g = auVar;
        return this;
    }

    public final at a(z zVar) {
        this.e = zVar;
        return this;
    }

    public final at a(String str) {
        this.d = str;
        return this;
    }

    public final at a(String str, String str2) {
        this.f.a(str, str2);
        return this;
    }

    public final at b(long j2) {
        this.l = j2;
        return this;
    }

    public final at b(as asVar) {
        if (asVar != null) {
            a("cacheResponse", asVar);
        }
        this.i = asVar;
        return this;
    }

    public final at c(as asVar) {
        if (asVar == null || asVar.g == null) {
            this.j = asVar;
            return this;
        }
        throw new IllegalArgumentException("priorResponse.body != null");
    }
}
