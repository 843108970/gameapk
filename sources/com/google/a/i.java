package com.google.a;

public final class i extends j {

    /* renamed from: c  reason: collision with root package name */
    private final j f3292c;

    public i(j jVar) {
        super(jVar.f3346a, jVar.f3347b);
        this.f3292c = jVar;
    }

    public final j a(int i, int i2, int i3, int i4) {
        return new i(this.f3292c.a(i, i2, i3, i4));
    }

    public final byte[] a() {
        byte[] a2 = this.f3292c.a();
        int i = this.f3346a * this.f3347b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (a2[i2] & 255));
        }
        return bArr;
    }

    public final byte[] a(int i, byte[] bArr) {
        byte[] a2 = this.f3292c.a(i, bArr);
        int i2 = this.f3346a;
        for (int i3 = 0; i3 < i2; i3++) {
            a2[i3] = (byte) (255 - (a2[i3] & 255));
        }
        return a2;
    }

    public final boolean b() {
        return this.f3292c.b();
    }

    public final boolean c() {
        return this.f3292c.c();
    }

    public final j d() {
        return this.f3292c;
    }

    public final j e() {
        return new i(this.f3292c.e());
    }

    public final j f() {
        return new i(this.f3292c.f());
    }
}
