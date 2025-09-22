package com.google.a.c.b;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int[] f3067a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3068b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f3068b = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f3067a = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f3067a = new int[]{0};
            return;
        }
        this.f3067a = new int[(length - i)];
        System.arraycopy(iArr, i, this.f3067a, 0, this.f3067a.length);
    }

    private int[] b() {
        return this.f3067a;
    }

    private int c() {
        return this.f3067a.length - 1;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i) {
        return this.f3067a[(this.f3067a.length - 1) - i];
    }

    /* access modifiers changed from: package-private */
    public final b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f3068b.j;
        } else {
            int length = this.f3067a.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f3068b.c(this.f3067a[i3], i2);
            }
            return new b(this.f3068b, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final b a(b bVar) {
        if (!this.f3068b.equals(bVar.f3068b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (a()) {
            return bVar;
        } else {
            if (bVar.a()) {
                return this;
            }
            int[] iArr = this.f3067a;
            int[] iArr2 = bVar.f3067a;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = a.b(iArr[i - length], iArr2[i]);
            }
            return new b(this.f3068b, iArr4);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return this.f3067a[0] == 0;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i) {
        if (i == 0) {
            return a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b2 : this.f3067a) {
                i2 = a.b(i2, b2);
            }
            return i2;
        }
        int i3 = this.f3067a[0];
        int length = this.f3067a.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = a.b(this.f3068b.c(i, i3), this.f3067a[i4]);
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final b b(b bVar) {
        if (!this.f3068b.equals(bVar.f3068b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (a() || bVar.a()) {
            return this.f3068b.j;
        } else {
            int[] iArr = this.f3067a;
            int length = iArr.length;
            int[] iArr2 = bVar.f3067a;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = a.b(iArr3[i4], this.f3068b.c(i2, iArr2[i3]));
                }
            }
            return new b(this.f3068b, iArr3);
        }
    }

    /* access modifiers changed from: package-private */
    public final b c(int i) {
        if (i == 0) {
            return this.f3068b.j;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f3067a.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f3068b.c(this.f3067a[i2], i);
        }
        return new b(this.f3068b, iArr);
    }

    /* access modifiers changed from: package-private */
    public final b[] c(b bVar) {
        if (!this.f3068b.equals(bVar.f3068b)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        } else if (bVar.a()) {
            throw new IllegalArgumentException("Divide by 0");
        } else {
            b bVar2 = this.f3068b.j;
            int b2 = this.f3068b.b(bVar.a(bVar.f3067a.length - 1));
            b bVar3 = bVar2;
            b bVar4 = this;
            while (bVar4.f3067a.length - 1 >= bVar.f3067a.length - 1 && !bVar4.a()) {
                int length = (bVar4.f3067a.length - 1) - (bVar.f3067a.length - 1);
                int c2 = this.f3068b.c(bVar4.a(bVar4.f3067a.length - 1), b2);
                b a2 = bVar.a(length, c2);
                bVar3 = bVar3.a(this.f3068b.a(length, c2));
                bVar4 = bVar4.a(a2);
            }
            return new b[]{bVar3, bVar4};
        }
    }

    public final String toString() {
        char c2;
        StringBuilder sb = new StringBuilder((this.f3067a.length - 1) * 8);
        for (int length = this.f3067a.length - 1; length >= 0; length--) {
            int a2 = a(length);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || a2 != 1) {
                    int a3 = this.f3068b.a(a2);
                    if (a3 == 0) {
                        c2 = '1';
                    } else if (a3 == 1) {
                        c2 = 'a';
                    } else {
                        sb.append("a^");
                        sb.append(a3);
                    }
                    sb.append(c2);
                }
                if (length != 0) {
                    if (length == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(length);
                    }
                }
            }
        }
        return sb.toString();
    }
}
