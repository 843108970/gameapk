package com.google.a.h.c;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f3277a;

    /* renamed from: b  reason: collision with root package name */
    private int f3278b = 0;

    b(int i) {
        this.f3277a = new byte[i];
    }

    private void a(int i, byte b2) {
        this.f3277a[i] = b2;
    }

    private void a(int i, boolean z) {
        this.f3277a[i] = z ? (byte) 1 : 0;
    }

    private byte[] a(int i) {
        byte[] bArr = new byte[(this.f3277a.length * i)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f3277a[i2 / i];
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f3278b;
            this.f3278b = i3 + 1;
            this.f3277a[i3] = z ? (byte) 1 : 0;
        }
    }
}
