package com.zbar.a.c;

public final class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private final b f4011c;

    public a(b bVar) {
        super(bVar.f4012a, bVar.f4013b);
        this.f4011c = bVar;
    }

    public final b a(int i, int i2, int i3, int i4) {
        return new a(this.f4011c.a(i, i2, i3, i4));
    }

    public final byte[] a() {
        byte[] a2 = this.f4011c.a();
        int i = this.f4012a * this.f4013b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (a2[i2] & 255));
        }
        return bArr;
    }

    public final byte[] a(int i, byte[] bArr) {
        byte[] a2 = this.f4011c.a(i, bArr);
        int i2 = this.f4012a;
        for (int i3 = 0; i3 < i2; i3++) {
            a2[i3] = (byte) (255 - (a2[i3] & 255));
        }
        return a2;
    }

    public final boolean b() {
        return this.f4011c.b();
    }

    public final boolean c() {
        return this.f4011c.c();
    }

    public final b d() {
        return this.f4011c;
    }

    public final b e() {
        return new a(this.f4011c.e());
    }

    public final b f() {
        return new a(this.f4011c.f());
    }
}
