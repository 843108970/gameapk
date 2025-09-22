package com.google.a.a.c;

import com.google.a.c.a;

final class b extends g {

    /* renamed from: c  reason: collision with root package name */
    private final short f2988c;
    private final short d;

    b(g gVar, int i, int i2) {
        super(gVar);
        this.f2988c = (short) i;
        this.d = (short) i2;
    }

    public final void a(a aVar, byte[] bArr) {
        int i = 0;
        while (i < this.d) {
            if (i == 0 || (i == 31 && this.d <= 62)) {
                aVar.b(31, 5);
                if (this.d > 62) {
                    aVar.b(this.d - 31, 16);
                } else {
                    aVar.b(i == 0 ? Math.min(this.d, 31) : this.d - 31, 5);
                }
            }
            aVar.b(bArr[this.f2988c + i], 8);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.f2988c);
        sb.append("::");
        sb.append((this.f2988c + this.d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
