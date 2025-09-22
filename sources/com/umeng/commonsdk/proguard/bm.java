package com.umeng.commonsdk.proguard;

public final class bm extends bn {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3753a;

    /* renamed from: b  reason: collision with root package name */
    private int f3754b;

    /* renamed from: c  reason: collision with root package name */
    private int f3755c;

    public bm() {
    }

    public bm(byte[] bArr) {
        a(bArr);
    }

    public bm(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public final int a(byte[] bArr, int i, int i2) throws bo {
        int h = h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f3753a, this.f3754b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public final void a(int i) {
        this.f3754b += i;
    }

    public final void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public final boolean a() {
        return true;
    }

    public final void b() throws bo {
    }

    public final void b(byte[] bArr, int i, int i2) throws bo {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public final void c() {
    }

    public final void c(byte[] bArr, int i, int i2) {
        this.f3753a = bArr;
        this.f3754b = i;
        this.f3755c = i + i2;
    }

    public final void e() {
        this.f3753a = null;
    }

    public final byte[] f() {
        return this.f3753a;
    }

    public final int g() {
        return this.f3754b;
    }

    public final int h() {
        return this.f3755c - this.f3754b;
    }
}
