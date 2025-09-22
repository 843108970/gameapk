package com.google.a.c;

import java.util.Arrays;
import org.apache.commons.io.FilenameUtils;

public final class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int[] f3054a;

    /* renamed from: b  reason: collision with root package name */
    public int f3055b;

    public a() {
        this.f3055b = 0;
        this.f3054a = new int[1];
    }

    public a(int i) {
        this.f3055b = i;
        this.f3054a = g(i);
    }

    private a(int[] iArr, int i) {
        this.f3054a = iArr;
        this.f3055b = i;
    }

    private void b(a aVar) {
        if (this.f3055b != aVar.f3055b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < this.f3054a.length; i++) {
            int[] iArr = this.f3054a;
            iArr[i] = iArr[i] ^ aVar.f3054a[i];
        }
    }

    private void c(int i, int i2) {
        this.f3054a[i / 32] = i2;
    }

    private int d() {
        return this.f3055b;
    }

    private void d(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.f3055b) {
            throw new IllegalArgumentException();
        } else if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                int i9 = (2 << i7) - (1 << i8);
                int[] iArr = this.f3054a;
                iArr[i6] = i9 | iArr[i6];
                i6++;
            }
        }
    }

    private void e(int i) {
        if (i > (this.f3054a.length << 5)) {
            int[] g = g(i);
            System.arraycopy(this.f3054a, 0, g, 0, this.f3054a.length);
            this.f3054a = g;
        }
    }

    private int[] e() {
        return this.f3054a;
    }

    private a f() {
        return new a((int[]) this.f3054a.clone(), this.f3055b);
    }

    private void f(int i) {
        int[] iArr = this.f3054a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    private static int[] g(int i) {
        return new int[((i + 31) / 32)];
    }

    public final int a() {
        return (this.f3055b + 7) / 8;
    }

    public final void a(int i, byte[] bArr, int i2) {
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i3;
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (a(i5)) {
                    i6 |= 1 << (7 - i7);
                }
                i5++;
            }
            bArr[i4 + 0] = (byte) i6;
            i4++;
            i3 = i5;
        }
    }

    public final void a(a aVar) {
        int i = aVar.f3055b;
        e(this.f3055b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    public final void a(boolean z) {
        e(this.f3055b + 1);
        if (z) {
            int[] iArr = this.f3054a;
            int i = this.f3055b / 32;
            iArr[i] = iArr[i] | (1 << (this.f3055b & 31));
        }
        this.f3055b++;
    }

    public final boolean a(int i) {
        return ((1 << (i & 31)) & this.f3054a[i / 32]) != 0;
    }

    public final boolean a(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.f3055b) {
            throw new IllegalArgumentException();
        } else if (i2 == i) {
            return true;
        } else {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                int i7 = 31;
                int i8 = i6 > i4 ? 0 : i & 31;
                if (i6 >= i5) {
                    i7 = 31 & i3;
                }
                if ((((2 << i7) - (1 << i8)) & this.f3054a[i6]) != 0) {
                    return false;
                }
                i6++;
            }
            return true;
        }
    }

    public final void b() {
        int length = this.f3054a.length;
        for (int i = 0; i < length; i++) {
            this.f3054a[i] = 0;
        }
    }

    public final void b(int i) {
        int[] iArr = this.f3054a;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public final void b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f3055b + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            a(z);
            i2--;
        }
    }

    public final int c(int i) {
        if (i >= this.f3055b) {
            return this.f3055b;
        }
        int i2 = i / 32;
        int i3 = (((1 << (i & 31)) - 1) ^ -1) & this.f3054a[i2];
        while (i3 == 0) {
            i2++;
            if (i2 == this.f3054a.length) {
                return this.f3055b;
            }
            i3 = this.f3054a[i2];
        }
        int numberOfTrailingZeros = (i2 << 5) + Integer.numberOfTrailingZeros(i3);
        return numberOfTrailingZeros > this.f3055b ? this.f3055b : numberOfTrailingZeros;
    }

    public final void c() {
        int[] iArr = new int[this.f3054a.length];
        int i = (this.f3055b - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = (long) this.f3054a[i3];
            long j2 = ((j >> 1) & 1431655765) | ((j & 1431655765) << 1);
            long j3 = ((j2 >> 2) & 858993459) | ((j2 & 858993459) << 2);
            long j4 = ((j3 >> 4) & 252645135) | ((j3 & 252645135) << 4);
            long j5 = ((j4 >> 8) & 16711935) | ((j4 & 16711935) << 8);
            iArr[i - i3] = (int) (((j5 >> 16) & 65535) | ((j5 & 65535) << 16));
        }
        int i4 = i2 << 5;
        if (this.f3055b != i4) {
            int i5 = i4 - this.f3055b;
            int i6 = iArr[0] >>> i5;
            for (int i7 = 1; i7 < i2; i7++) {
                int i8 = iArr[i7];
                iArr[i7 - 1] = i6 | (i8 << (32 - i5));
                i6 = i8 >>> i5;
            }
            iArr[i2 - 1] = i6;
        }
        this.f3054a = iArr;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new a((int[]) this.f3054a.clone(), this.f3055b);
    }

    public final int d(int i) {
        if (i >= this.f3055b) {
            return this.f3055b;
        }
        int i2 = i / 32;
        int i3 = (((1 << (i & 31)) - 1) ^ -1) & (this.f3054a[i2] ^ -1);
        while (i3 == 0) {
            i2++;
            if (i2 == this.f3054a.length) {
                return this.f3055b;
            }
            i3 = this.f3054a[i2] ^ -1;
        }
        int numberOfTrailingZeros = (i2 << 5) + Integer.numberOfTrailingZeros(i3);
        return numberOfTrailingZeros > this.f3055b ? this.f3055b : numberOfTrailingZeros;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3055b == aVar.f3055b && Arrays.equals(this.f3054a, aVar.f3054a);
    }

    public final int hashCode() {
        return (this.f3055b * 31) + Arrays.hashCode(this.f3054a);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(this.f3055b + (this.f3055b / 8) + 1);
        for (int i = 0; i < this.f3055b; i++) {
            if ((i & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i) ? 'X' : FilenameUtils.EXTENSION_SEPARATOR);
        }
        return sb.toString();
    }
}
