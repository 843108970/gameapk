package com.b.b;

import java.util.Arrays;

final class v extends i {
    final transient byte[][] f;
    final transient int[] g;

    v(f fVar, int i) {
        super((byte[]) null);
        aa.a(fVar.f855b, 0, (long) i);
        int i2 = 0;
        t tVar = fVar.f854a;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (tVar.f881c == tVar.f880b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += tVar.f881c - tVar.f880b;
            i4++;
            tVar = tVar.f;
        }
        this.f = new byte[i4][];
        this.g = new int[(i4 * 2)];
        t tVar2 = fVar.f854a;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = tVar2.f879a;
            i2 += tVar2.f881c - tVar2.f880b;
            if (i2 > i) {
                i2 = i;
            }
            this.g[i5] = i2;
            this.g[this.f.length + i5] = tVar2.f880b;
            tVar2.d = true;
            i5++;
            tVar2 = tVar2.f;
        }
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private i i() {
        return new i(h());
    }

    public final byte a(int i) {
        aa.a((long) this.g[this.f.length - 1], (long) i, 1);
        int b2 = b(i);
        return this.f[b2][(i - (b2 == 0 ? 0 : this.g[b2 - 1])) + this.g[this.f.length + b2]];
    }

    public final i a(int i, int i2) {
        return i().a(i, i2);
    }

    public final String a() {
        return i().a();
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            t tVar = new t(this.f[i], i3, (i3 + i4) - i2);
            if (fVar.f854a == null) {
                tVar.g = tVar;
                tVar.f = tVar;
                fVar.f854a = tVar;
            } else {
                fVar.f854a.g.a(tVar);
            }
            i++;
            i2 = i4;
        }
        fVar.f855b += (long) i2;
    }

    public final boolean a(int i, i iVar, int i2, int i3) {
        if (g() - i3 < 0) {
            return false;
        }
        int b2 = b(0);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            if (!iVar.a(i2, this.f[b2], (i - i4) + this.g[this.f.length + b2], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    public final boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b2 = b(i);
        while (i3 > 0) {
            int i4 = b2 == 0 ? 0 : this.g[b2 - 1];
            int min = Math.min(i3, ((this.g[b2] - i4) + i4) - i);
            if (!aa.a(this.f[b2], (i - i4) + this.g[this.f.length + b2], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b2++;
        }
        return true;
    }

    public final String b() {
        return i().b();
    }

    public final i c() {
        return i().c();
    }

    public final i d() {
        return i().d();
    }

    public final String e() {
        return i().e();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return iVar.g() == g() && a(0, iVar, 0, g());
        }
    }

    public final i f() {
        return i().f();
    }

    public final int g() {
        return this.g[this.f.length - 1];
    }

    public final byte[] h() {
        byte[] bArr = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    public final int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int i5 = this.g[length + i2];
            int i6 = this.g[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    public final String toString() {
        return i().toString();
    }
}
