package com.b.b;

final class t {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f879a;

    /* renamed from: b  reason: collision with root package name */
    int f880b;

    /* renamed from: c  reason: collision with root package name */
    int f881c;
    boolean d;
    boolean e;
    t f;
    t g;

    t() {
        this.f879a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    t(t tVar) {
        this(tVar.f879a, tVar.f880b, tVar.f881c);
        tVar.d = true;
    }

    t(byte[] bArr, int i, int i2) {
        this.f879a = bArr;
        this.f880b = i;
        this.f881c = i2;
        this.e = false;
        this.d = true;
    }

    public final t a() {
        t tVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return tVar;
    }

    public final t a(t tVar) {
        tVar.g = this;
        tVar.f = this.f;
        this.f.g = tVar;
        this.f = tVar;
        return tVar;
    }

    public final void a(t tVar, int i) {
        if (!tVar.e) {
            throw new IllegalArgumentException();
        }
        if (tVar.f881c + i > 8192) {
            if (tVar.d) {
                throw new IllegalArgumentException();
            } else if ((tVar.f881c + i) - tVar.f880b > 8192) {
                throw new IllegalArgumentException();
            } else {
                System.arraycopy(tVar.f879a, tVar.f880b, tVar.f879a, 0, tVar.f881c - tVar.f880b);
                tVar.f881c -= tVar.f880b;
                tVar.f880b = 0;
            }
        }
        System.arraycopy(this.f879a, this.f880b, tVar.f879a, tVar.f881c, i);
        tVar.f881c += i;
        this.f880b += i;
    }
}
