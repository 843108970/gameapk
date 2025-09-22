package com.google.a.a.c;

import com.google.a.c.a;

final class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f2996c;
    private final short d;

    e(g gVar, int i, int i2) {
        super(gVar);
        this.f2996c = (short) i;
        this.d = (short) i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar, byte[] bArr) {
        aVar.b(this.f2996c, this.d);
    }

    public final String toString() {
        short s = (this.f2996c & ((1 << this.d) - 1)) | (1 << this.d);
        return "<" + Integer.toBinaryString(s | (1 << this.d)).substring(1) + '>';
    }
}
