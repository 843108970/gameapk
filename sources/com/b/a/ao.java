package com.b.a;

public final class ao {

    /* renamed from: a  reason: collision with root package name */
    final ac f775a;

    /* renamed from: b  reason: collision with root package name */
    final String f776b;

    /* renamed from: c  reason: collision with root package name */
    final aa f777c;
    final aq d;
    final Object e;
    private volatile e f;

    ao(ap apVar) {
        this.f775a = apVar.f778a;
        this.f776b = apVar.f779b;
        this.f777c = apVar.f780c.a();
        this.d = apVar.d;
        this.e = apVar.e != null ? apVar.e : this;
    }

    public final ac a() {
        return this.f775a;
    }

    public final String a(String str) {
        return this.f777c.a(str);
    }

    public final String b() {
        return this.f776b;
    }

    public final aa c() {
        return this.f777c;
    }

    public final aq d() {
        return this.d;
    }

    public final ap e() {
        return new ap(this);
    }

    public final e f() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e a2 = e.a(this.f777c);
        this.f = a2;
        return a2;
    }

    public final boolean g() {
        return this.f775a.c();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f776b);
        sb.append(", url=");
        sb.append(this.f775a);
        sb.append(", tag=");
        sb.append(this.e != this ? this.e : null);
        sb.append('}');
        return sb.toString();
    }
}
