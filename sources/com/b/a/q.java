package com.b.a;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    boolean f825a;

    /* renamed from: b  reason: collision with root package name */
    String[] f826b;

    /* renamed from: c  reason: collision with root package name */
    String[] f827c;
    boolean d;

    public q(p pVar) {
        this.f825a = pVar.d;
        this.f826b = pVar.f;
        this.f827c = pVar.g;
        this.d = pVar.e;
    }

    q(boolean z) {
        this.f825a = z;
    }

    public final q a() {
        if (!this.f825a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        this.d = true;
        return this;
    }

    public final q a(ax... axVarArr) {
        if (!this.f825a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[axVarArr.length];
        for (int i = 0; i < axVarArr.length; i++) {
            strArr[i] = axVarArr[i].f;
        }
        return b(strArr);
    }

    public final q a(String... strArr) {
        if (!this.f825a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one cipher suite is required");
        } else {
            this.f826b = (String[]) strArr.clone();
            return this;
        }
    }

    public final p b() {
        return new p(this);
    }

    public final q b(String... strArr) {
        if (!this.f825a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        } else if (strArr.length == 0) {
            throw new IllegalArgumentException("At least one TLS version is required");
        } else {
            this.f827c = (String[]) strArr.clone();
            return this;
        }
    }
}
