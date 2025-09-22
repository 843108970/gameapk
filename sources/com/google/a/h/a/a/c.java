package com.google.a.h.a.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f3242a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f3243b;

    public c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f3242a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f3243b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f3243b = new int[]{0};
            return;
        }
        this.f3243b = new int[(length - i)];
        System.arraycopy(iArr, i, this.f3243b, 0, this.f3243b.length);
    }

    private c a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.f3242a.d;
        } else {
            int length = this.f3243b.length;
            int[] iArr = new int[(i + length)];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = this.f3242a.d(this.f3243b[i3], i2);
            }
            return new c(this.f3242a, iArr);
        }
    }

    private int[] c() {
        return this.f3243b;
    }

    private int d() {
        return this.f3243b.length - 1;
    }

    public final int a(int i) {
        return this.f3243b[(this.f3243b.length - 1) - i];
    }

    public final c a(c cVar) {
        if (!this.f3242a.equals(cVar.f3242a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (a()) {
            return cVar;
        } else {
            if (cVar.a()) {
                return this;
            }
            int[] iArr = this.f3243b;
            int[] iArr2 = cVar.f3243b;
            if (iArr.length > iArr2.length) {
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            int[] iArr4 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr4[i] = this.f3242a.b(iArr[i - length], iArr2[i]);
            }
            return new c(this.f3242a, iArr4);
        }
    }

    public final boolean a() {
        return this.f3243b[0] == 0;
    }

    public final int b(int i) {
        if (i == 0) {
            return a(0);
        }
        if (i == 1) {
            int i2 = 0;
            for (int b2 : this.f3243b) {
                i2 = this.f3242a.b(i2, b2);
            }
            return i2;
        }
        int i3 = this.f3243b[0];
        int length = this.f3243b.length;
        for (int i4 = 1; i4 < length; i4++) {
            i3 = this.f3242a.b(this.f3242a.d(i, i3), this.f3243b[i4]);
        }
        return i3;
    }

    public final c b() {
        int length = this.f3243b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f3242a.c(0, this.f3243b[i]);
        }
        return new c(this.f3242a, iArr);
    }

    public final c b(c cVar) {
        if (this.f3242a.equals(cVar.f3242a)) {
            return cVar.a() ? this : a(cVar.b());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public final c c(int i) {
        if (i == 0) {
            return this.f3242a.d;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f3243b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f3242a.d(this.f3243b[i2], i);
        }
        return new c(this.f3242a, iArr);
    }

    public final c c(c cVar) {
        if (!this.f3242a.equals(cVar.f3242a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        } else if (a() || cVar.a()) {
            return this.f3242a.d;
        } else {
            int[] iArr = this.f3243b;
            int length = iArr.length;
            int[] iArr2 = cVar.f3243b;
            int length2 = iArr2.length;
            int[] iArr3 = new int[((length + length2) - 1)];
            for (int i = 0; i < length; i++) {
                int i2 = iArr[i];
                for (int i3 = 0; i3 < length2; i3++) {
                    int i4 = i + i3;
                    iArr3[i4] = this.f3242a.b(iArr3[i4], this.f3242a.d(i2, iArr2[i3]));
                }
            }
            return new c(this.f3242a, iArr3);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f3243b.length - 1) * 8);
        for (int length = this.f3243b.length - 1; length >= 0; length--) {
            int a2 = a(length);
            if (a2 != 0) {
                if (a2 < 0) {
                    sb.append(" - ");
                    a2 = -a2;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || a2 != 1) {
                    sb.append(a2);
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
