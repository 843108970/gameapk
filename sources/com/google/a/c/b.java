package com.google.a.c;

import java.util.Arrays;

public final class b implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final int f3061a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3062b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3063c;
    public final int[] d;

    public b(int i) {
        this(i, i);
    }

    public b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f3061a = i;
        this.f3062b = i2;
        this.f3063c = (i + 31) / 32;
        this.d = new int[(this.f3063c * i2)];
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f3061a = i;
        this.f3062b = i2;
        this.f3063c = i3;
        this.d = iArr;
    }

    private static b a(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == 10 || str.charAt(i) == 13) {
                if (i2 > i3) {
                    if (i4 == -1) {
                        i4 = i2 - i3;
                    } else if (i2 - i3 != i4) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i5++;
                    i3 = i2;
                }
                i++;
            } else {
                if (str.substring(i, str2.length() + i).equals(str2)) {
                    i += str2.length();
                    zArr[i2] = true;
                } else if (str.substring(i, str3.length() + i).equals(str3)) {
                    i += str3.length();
                    zArr[i2] = false;
                } else {
                    throw new IllegalArgumentException("illegal character encountered: " + str.substring(i));
                }
                i2++;
            }
        }
        if (i2 > i3) {
            if (i4 == -1) {
                i4 = i2 - i3;
            } else if (i2 - i3 != i4) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i5++;
        }
        b bVar = new b(i4, i5);
        for (int i6 = 0; i6 < i2; i6++) {
            if (zArr[i6]) {
                bVar.b(i6 % i4, i6 / i4);
            }
        }
        return bVar;
    }

    public static b a(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        b bVar = new b(length2, length);
        for (int i = 0; i < length; i++) {
            boolean[] zArr2 = zArr[i];
            for (int i2 = 0; i2 < length2; i2++) {
                if (zArr2[i2]) {
                    bVar.b(i2, i);
                }
            }
        }
        return bVar;
    }

    private String a(String str, String str2) {
        return c(str, str2, "\n");
    }

    private void a(b bVar) {
        if (this.f3061a == bVar.f3061a && this.f3062b == bVar.f3062b && this.f3063c == bVar.f3063c) {
            a aVar = new a(this.f3061a);
            for (int i = 0; i < this.f3062b; i++) {
                int i2 = this.f3063c * i;
                int[] iArr = bVar.a(i, aVar).f3054a;
                for (int i3 = 0; i3 < this.f3063c; i3++) {
                    int[] iArr2 = this.d;
                    int i4 = i2 + i3;
                    iArr2[i4] = iArr2[i4] ^ iArr[i3];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    @Deprecated
    private String b(String str, String str2, String str3) {
        return c(str, str2, str3);
    }

    private String c(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f3062b * (this.f3061a + 1));
        for (int i = 0; i < this.f3062b; i++) {
            for (int i2 = 0; i2 < this.f3061a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    private void d(int i, int i2) {
        int i3 = (i2 * this.f3063c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = ((1 << (i & 31)) ^ -1) & iArr[i3];
    }

    private void e() {
        int i = this.f3061a;
        int i2 = this.f3062b;
        a aVar = new a(i);
        a aVar2 = new a(i);
        for (int i3 = 0; i3 < (i2 + 1) / 2; i3++) {
            aVar = a(i3, aVar);
            int i4 = (i2 - 1) - i3;
            aVar2 = a(i4, aVar2);
            aVar.c();
            aVar2.c();
            b(i3, aVar2);
            b(i4, aVar);
        }
    }

    private int[] f() {
        int i = this.f3061a;
        int i2 = -1;
        int i3 = this.f3062b;
        int i4 = -1;
        int i5 = i;
        int i6 = 0;
        while (i6 < this.f3062b) {
            int i7 = i4;
            int i8 = i2;
            int i9 = i5;
            for (int i10 = 0; i10 < this.f3063c; i10++) {
                int i11 = this.d[(this.f3063c * i6) + i10];
                if (i11 != 0) {
                    if (i6 < i3) {
                        i3 = i6;
                    }
                    if (i6 > i7) {
                        i7 = i6;
                    }
                    int i12 = i10 << 5;
                    int i13 = 31;
                    if (i12 < i9) {
                        int i14 = 0;
                        while ((i11 << (31 - i14)) == 0) {
                            i14++;
                        }
                        int i15 = i14 + i12;
                        if (i15 < i9) {
                            i9 = i15;
                        }
                    }
                    if (i12 + 31 > i8) {
                        while ((i11 >>> i13) == 0) {
                            i13--;
                        }
                        int i16 = i12 + i13;
                        if (i16 > i8) {
                            i8 = i16;
                        }
                    }
                }
            }
            i6++;
            i5 = i9;
            i2 = i8;
            i4 = i7;
        }
        if (i2 < i5 || i4 < i3) {
            return null;
        }
        return new int[]{i5, i3, (i2 - i5) + 1, (i4 - i3) + 1};
    }

    private int g() {
        return this.f3061a;
    }

    private int h() {
        return this.f3062b;
    }

    private int i() {
        return this.f3063c;
    }

    public final a a(int i, a aVar) {
        if (aVar == null || aVar.f3055b < this.f3061a) {
            aVar = new a(this.f3061a);
        } else {
            aVar.b();
        }
        int i2 = i * this.f3063c;
        for (int i3 = 0; i3 < this.f3063c; i3++) {
            aVar.f3054a[(i3 << 5) / 32] = this.d[i2 + i3];
        }
        return aVar;
    }

    public final void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f3062b || i5 > this.f3061a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f3063c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public final boolean a(int i, int i2) {
        return ((this.d[(i2 * this.f3063c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public final void b(int i, int i2) {
        int i3 = (i2 * this.f3063c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void b(int i, a aVar) {
        System.arraycopy(aVar.f3054a, 0, this.d, i * this.f3063c, this.f3063c);
    }

    public final int[] b() {
        int i = 0;
        while (i < this.d.length && this.d[i] == 0) {
            i++;
        }
        if (i == this.d.length) {
            return null;
        }
        int i2 = i / this.f3063c;
        int i3 = (i % this.f3063c) << 5;
        int i4 = 0;
        while ((this.d[i] << (31 - i4)) == 0) {
            i4++;
        }
        return new int[]{i3 + i4, i2};
    }

    public final void c(int i, int i2) {
        int i3 = (i2 * this.f3063c) + (i / 32);
        int[] iArr = this.d;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public final int[] c() {
        int length = this.d.length - 1;
        while (length >= 0 && this.d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f3063c;
        int i2 = (length % this.f3063c) << 5;
        int i3 = 31;
        while ((this.d[length] >>> i3) == 0) {
            i3--;
        }
        return new int[]{i2 + i3, i};
    }

    /* renamed from: d */
    public final b clone() {
        return new b(this.f3061a, this.f3062b, this.f3063c, (int[]) this.d.clone());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3061a == bVar.f3061a && this.f3062b == bVar.f3062b && this.f3063c == bVar.f3063c && Arrays.equals(this.d, bVar.d);
    }

    public final int hashCode() {
        return (((((((this.f3061a * 31) + this.f3061a) * 31) + this.f3062b) * 31) + this.f3063c) * 31) + Arrays.hashCode(this.d);
    }

    public final String toString() {
        return c("X ", "  ", "\n");
    }
}
