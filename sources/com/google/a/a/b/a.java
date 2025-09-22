package com.google.a.a.b;

import com.google.a.c.b;
import com.google.a.c.b.c;
import com.google.a.c.b.e;
import com.google.a.c.i;
import com.google.a.m;
import com.google.a.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f2980a = {3808, 476, 2107, 1799};

    /* renamed from: b  reason: collision with root package name */
    private final b f2981b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2982c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* renamed from: com.google.a.a.b.a$a  reason: collision with other inner class name */
    static final class C0049a {

        /* renamed from: a  reason: collision with root package name */
        final int f2983a;

        /* renamed from: b  reason: collision with root package name */
        final int f2984b;

        C0049a(int i, int i2) {
            this.f2983a = i;
            this.f2984b = i2;
        }

        private int b() {
            return this.f2983a;
        }

        private int c() {
            return this.f2984b;
        }

        /* access modifiers changed from: package-private */
        public final t a() {
            return new t((float) this.f2983a, (float) this.f2984b);
        }

        public final String toString() {
            return "<" + this.f2983a + ' ' + this.f2984b + '>';
        }
    }

    public a(b bVar) {
        this.f2981b = bVar;
    }

    private static float a(t tVar, t tVar2) {
        return com.google.a.c.a.a.a(tVar.f3356a, tVar.f3357b, tVar2.f3356a, tVar2.f3357b);
    }

    private static int a(long j, boolean z) throws m {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new c(com.google.a.c.b.a.d).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (e unused) {
            throw m.getNotFoundInstance();
        }
    }

    private int a(C0049a aVar, C0049a aVar2) {
        float b2 = b(aVar, aVar2);
        float f2 = ((float) (aVar2.f2983a - aVar.f2983a)) / b2;
        float f3 = ((float) (aVar2.f2984b - aVar.f2984b)) / b2;
        boolean a2 = this.f2981b.a(aVar.f2983a, aVar.f2984b);
        int ceil = (int) Math.ceil((double) b2);
        boolean z = false;
        float f4 = (float) aVar.f2984b;
        int i = 0;
        float f5 = (float) aVar.f2983a;
        for (int i2 = 0; i2 < ceil; i2++) {
            f5 += f2;
            f4 += f3;
            if (this.f2981b.a(com.google.a.c.a.a.a(f5), com.google.a.c.a.a.a(f4)) != a2) {
                i++;
            }
        }
        float f6 = ((float) i) / b2;
        if (f6 > 0.1f && f6 < 0.9f) {
            return 0;
        }
        if (f6 <= 0.1f) {
            z = true;
        }
        return z == a2 ? 1 : -1;
    }

    private int a(t tVar, t tVar2, int i) {
        float a2 = com.google.a.c.a.a.a(tVar.f3356a, tVar.f3357b, tVar2.f3356a, tVar2.f3357b);
        float f2 = a2 / ((float) i);
        float f3 = tVar.f3356a;
        float f4 = tVar.f3357b;
        float f5 = ((tVar2.f3356a - tVar.f3356a) * f2) / a2;
        float f6 = (f2 * (tVar2.f3357b - tVar.f3357b)) / a2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f7 = (float) i3;
            if (this.f2981b.a(com.google.a.c.a.a.a((f7 * f5) + f3), com.google.a.c.a.a.a((f7 * f6) + f4))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private static int a(int[] iArr, int i) throws m {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[i3];
            i2 = (i2 << 3) + ((i4 >> (i - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f2980a[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw m.getNotFoundInstance();
    }

    private com.google.a.a.a a() throws m {
        return a(false);
    }

    private C0049a a(C0049a aVar, boolean z, int i, int i2) {
        int i3 = aVar.f2983a + i;
        int i4 = aVar.f2984b;
        while (true) {
            i4 += i2;
            if (!a(i3, i4) || this.f2981b.a(i3, i4) != z) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
            } else {
                i3 += i;
            }
        }
        int i52 = i3 - i;
        int i62 = i4 - i2;
        while (a(i52, i62) && this.f2981b.a(i52, i62) == z) {
            i52 += i;
        }
        int i7 = i52 - i;
        while (a(i7, i62) && this.f2981b.a(i7, i62) == z) {
            i62 += i2;
        }
        return new C0049a(i7, i62 - i2);
    }

    private b a(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        t tVar5 = tVar;
        t tVar6 = tVar2;
        t tVar7 = tVar3;
        t tVar8 = tVar4;
        i a2 = i.a();
        int c2 = c();
        float f2 = ((float) c2) / 2.0f;
        float f3 = f2 - ((float) this.f);
        float f4 = f2 + ((float) this.f);
        float f5 = tVar5.f3356a;
        float f6 = tVar5.f3357b;
        float f7 = tVar6.f3356a;
        float f8 = tVar6.f3357b;
        float f9 = tVar7.f3356a;
        float f10 = tVar7.f3357b;
        float f11 = tVar8.f3356a;
        return a2.a(bVar, c2, c2, f3, f3, f4, f3, f4, f4, f3, f4, f5, f6, f7, f8, f9, f10, f11, tVar8.f3357b);
    }

    private void a(t[] tVarArr) throws m {
        int i;
        long j;
        long j2;
        if (!a(tVarArr[0]) || !a(tVarArr[1]) || !a(tVarArr[2]) || !a(tVarArr[3])) {
            throw m.getNotFoundInstance();
        }
        int i2 = this.f * 2;
        int[] iArr = {a(tVarArr[0], tVarArr[1], i2), a(tVarArr[1], tVarArr[2], i2), a(tVarArr[2], tVarArr[3], i2), a(tVarArr[3], tVarArr[0], i2)};
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = iArr[i4];
            i3 = (i3 << 3) + ((i5 >> (i2 - 2)) << 1) + (i5 & 1);
        }
        int i6 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i7 = 0; i7 < 4; i7++) {
            if (Integer.bitCount(f2980a[i7] ^ i6) <= 2) {
                this.g = i7;
                long j3 = 0;
                for (int i8 = 0; i8 < 4; i8++) {
                    int i9 = iArr[(this.g + i8) % 4];
                    if (this.f2982c) {
                        j = j3 << 7;
                        j2 = (long) ((i9 >> 1) & 127);
                    } else {
                        j = j3 << 10;
                        j2 = (long) (((i9 >> 2) & 992) + ((i9 >> 1) & 31));
                    }
                    j3 = j + j2;
                }
                int a2 = a(j3, this.f2982c);
                if (this.f2982c) {
                    this.d = (a2 >> 6) + 1;
                    i = a2 & 63;
                } else {
                    this.d = (a2 >> 11) + 1;
                    i = a2 & 2047;
                }
                this.e = i + 1;
                return;
            }
        }
        throw m.getNotFoundInstance();
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.f2981b.f3061a && i2 > 0 && i2 < this.f2981b.f3062b;
    }

    private boolean a(C0049a aVar, C0049a aVar2, C0049a aVar3, C0049a aVar4) {
        C0049a aVar5 = new C0049a(aVar.f2983a - 3, aVar.f2984b + 3);
        C0049a aVar6 = new C0049a(aVar2.f2983a - 3, aVar2.f2984b - 3);
        C0049a aVar7 = new C0049a(aVar3.f2983a + 3, aVar3.f2984b - 3);
        C0049a aVar8 = new C0049a(aVar4.f2983a + 3, aVar4.f2984b + 3);
        int a2 = a(aVar8, aVar5);
        return a2 != 0 && a(aVar5, aVar6) == a2 && a(aVar6, aVar7) == a2 && a(aVar7, aVar8) == a2;
    }

    private boolean a(t tVar) {
        return a(com.google.a.c.a.a.a(tVar.f3356a), com.google.a.c.a.a.a(tVar.f3357b));
    }

    private t[] a(C0049a aVar) throws m {
        C0049a aVar2;
        int i = 1;
        this.f = 1;
        C0049a aVar3 = aVar;
        C0049a aVar4 = aVar3;
        C0049a aVar5 = aVar4;
        C0049a aVar6 = aVar5;
        boolean z = true;
        while (this.f < 9) {
            C0049a a2 = a(aVar3, z, i, -1);
            C0049a a3 = a(aVar4, z, i, i);
            C0049a a4 = a(aVar5, z, -1, i);
            C0049a a5 = a(aVar6, z, -1, -1);
            if (this.f > 2) {
                double b2 = (double) ((b(a5, a2) * ((float) this.f)) / (b(aVar6, aVar3) * ((float) (this.f + 2))));
                if (b2 < 0.75d || b2 > 1.25d) {
                    break;
                }
                C0049a aVar7 = new C0049a(a2.f2983a - 3, a2.f2984b + 3);
                C0049a aVar8 = new C0049a(a3.f2983a - 3, a3.f2984b - 3);
                C0049a aVar9 = new C0049a(a4.f2983a + 3, a4.f2984b - 3);
                aVar2 = a2;
                C0049a aVar10 = new C0049a(a5.f2983a + 3, a5.f2984b + 3);
                int a6 = a(aVar10, aVar7);
                if (!(a6 != 0 && a(aVar7, aVar8) == a6 && a(aVar8, aVar9) == a6 && a(aVar9, aVar10) == a6)) {
                    break;
                }
            } else {
                aVar2 = a2;
            }
            z = !z;
            this.f++;
            aVar6 = a5;
            aVar4 = a3;
            aVar5 = a4;
            aVar3 = aVar2;
            i = 1;
        }
        if (this.f == 5 || this.f == 7) {
            this.f2982c = this.f == 5;
            return a(new t[]{new t(((float) aVar3.f2983a) + 0.5f, ((float) aVar3.f2984b) - 0.5f), new t(((float) aVar4.f2983a) + 0.5f, ((float) aVar4.f2984b) + 0.5f), new t(((float) aVar5.f2983a) - 0.5f, ((float) aVar5.f2984b) + 0.5f), new t(((float) aVar6.f2983a) - 0.5f, ((float) aVar6.f2984b) - 0.5f)}, (this.f * 2) - 3, this.f * 2);
        }
        throw m.getNotFoundInstance();
    }

    private static t[] a(t[] tVarArr, int i, int i2) {
        float f2 = ((float) i2) / (((float) i) * 2.0f);
        float f3 = tVarArr[0].f3356a - tVarArr[2].f3356a;
        float f4 = tVarArr[0].f3357b - tVarArr[2].f3357b;
        float f5 = (tVarArr[0].f3356a + tVarArr[2].f3356a) / 2.0f;
        float f6 = (tVarArr[0].f3357b + tVarArr[2].f3357b) / 2.0f;
        float f7 = f3 * f2;
        float f8 = f4 * f2;
        t tVar = new t(f5 + f7, f6 + f8);
        t tVar2 = new t(f5 - f7, f6 - f8);
        float f9 = tVarArr[1].f3356a - tVarArr[3].f3356a;
        float f10 = tVarArr[1].f3357b - tVarArr[3].f3357b;
        float f11 = (tVarArr[1].f3356a + tVarArr[3].f3356a) / 2.0f;
        float f12 = (tVarArr[1].f3357b + tVarArr[3].f3357b) / 2.0f;
        float f13 = f9 * f2;
        float f14 = f2 * f10;
        return new t[]{tVar, new t(f11 + f13, f12 + f14), tVar2, new t(f11 - f13, f12 - f14)};
    }

    private static float b(C0049a aVar, C0049a aVar2) {
        return com.google.a.c.a.a.a(aVar.f2983a, aVar.f2984b, aVar2.f2983a, aVar2.f2984b);
    }

    private C0049a b() {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        t tVar6;
        t tVar7;
        t tVar8;
        try {
            t[] a2 = new com.google.a.c.a.c(this.f2981b).a();
            tVar3 = a2[0];
            tVar2 = a2[1];
            tVar = a2[2];
            tVar4 = a2[3];
        } catch (m unused) {
            int i = this.f2981b.f3061a / 2;
            int i2 = this.f2981b.f3062b / 2;
            int i3 = i + 7;
            int i4 = i2 - 7;
            t a3 = a(new C0049a(i3, i4), false, 1, -1).a();
            int i5 = i2 + 7;
            t a4 = a(new C0049a(i3, i5), false, 1, 1).a();
            int i6 = i - 7;
            t a5 = a(new C0049a(i6, i5), false, -1, 1).a();
            tVar4 = a(new C0049a(i6, i4), false, -1, -1).a();
            t tVar9 = a4;
            tVar = a5;
            tVar3 = a3;
            tVar2 = tVar9;
        }
        int a6 = com.google.a.c.a.a.a((((tVar3.f3356a + tVar4.f3356a) + tVar2.f3356a) + tVar.f3356a) / 4.0f);
        int a7 = com.google.a.c.a.a.a((((tVar3.f3357b + tVar4.f3357b) + tVar2.f3357b) + tVar.f3357b) / 4.0f);
        try {
            t[] a8 = new com.google.a.c.a.c(this.f2981b, 15, a6, a7).a();
            tVar6 = a8[0];
            tVar5 = a8[1];
            tVar7 = a8[2];
            tVar8 = a8[3];
        } catch (m unused2) {
            int i7 = a6 + 7;
            int i8 = a7 - 7;
            tVar6 = a(new C0049a(i7, i8), false, 1, -1).a();
            int i9 = a7 + 7;
            tVar5 = a(new C0049a(i7, i9), false, 1, 1).a();
            int i10 = a6 - 7;
            tVar7 = a(new C0049a(i10, i9), false, -1, 1).a();
            tVar8 = a(new C0049a(i10, i8), false, -1, -1).a();
        }
        return new C0049a(com.google.a.c.a.a.a((((tVar6.f3356a + tVar8.f3356a) + tVar5.f3356a) + tVar7.f3356a) / 4.0f), com.google.a.c.a.a.a((((tVar6.f3357b + tVar8.f3357b) + tVar5.f3357b) + tVar7.f3357b) / 4.0f));
    }

    private t[] b(t[] tVarArr) {
        return a(tVarArr, this.f * 2, c());
    }

    private int c() {
        return this.f2982c ? (this.d * 4) + 11 : this.d <= 4 ? (this.d * 4) + 15 : (this.d * 4) + ((((this.d - 4) / 8) + 1) * 2) + 15;
    }

    public final com.google.a.a.a a(boolean z) throws m {
        int i;
        int i2;
        long j;
        long j2;
        C0049a aVar;
        C0049a b2 = b();
        int i3 = 1;
        this.f = 1;
        C0049a aVar2 = b2;
        C0049a aVar3 = aVar2;
        C0049a aVar4 = aVar3;
        boolean z2 = true;
        while (this.f < 9) {
            C0049a a2 = a(b2, z2, i3, -1);
            C0049a a3 = a(aVar2, z2, i3, i3);
            C0049a a4 = a(aVar3, z2, -1, i3);
            C0049a a5 = a(aVar4, z2, -1, -1);
            if (this.f > 2) {
                double b3 = (double) ((b(a5, a2) * ((float) this.f)) / (b(aVar4, b2) * ((float) (this.f + 2))));
                if (b3 < 0.75d || b3 > 1.25d) {
                    break;
                }
                C0049a aVar5 = new C0049a(a2.f2983a - 3, a2.f2984b + 3);
                C0049a aVar6 = new C0049a(a3.f2983a - 3, a3.f2984b - 3);
                C0049a aVar7 = new C0049a(a4.f2983a + 3, a4.f2984b - 3);
                aVar = a2;
                C0049a aVar8 = new C0049a(a5.f2983a + 3, a5.f2984b + 3);
                int a6 = a(aVar8, aVar5);
                if (!(a6 != 0 && a(aVar5, aVar6) == a6 && a(aVar6, aVar7) == a6 && a(aVar7, aVar8) == a6)) {
                    break;
                }
            } else {
                aVar = a2;
            }
            z2 = !z2;
            this.f++;
            aVar4 = a5;
            aVar2 = a3;
            aVar3 = a4;
            b2 = aVar;
            i3 = 1;
        }
        if (this.f == 5 || this.f == 7) {
            this.f2982c = this.f == 5;
            t[] a7 = a(new t[]{new t(((float) b2.f2983a) + 0.5f, ((float) b2.f2984b) - 0.5f), new t(((float) aVar2.f2983a) + 0.5f, ((float) aVar2.f2984b) + 0.5f), new t(((float) aVar3.f2983a) - 0.5f, ((float) aVar3.f2984b) + 0.5f), new t(((float) aVar4.f2983a) - 0.5f, ((float) aVar4.f2984b) - 0.5f)}, (this.f * 2) - 3, this.f * 2);
            if (z) {
                t tVar = a7[0];
                a7[0] = a7[2];
                a7[2] = tVar;
            }
            if (!a(a7[0]) || !a(a7[1]) || !a(a7[2]) || !a(a7[3])) {
                throw m.getNotFoundInstance();
            }
            int i4 = this.f * 2;
            int[] iArr = {a(a7[0], a7[1], i4), a(a7[1], a7[2], i4), a(a7[2], a7[3], i4), a(a7[3], a7[0], i4)};
            int i5 = 0;
            for (int i6 = 0; i6 < 4; i6++) {
                int i7 = iArr[i6];
                i5 = (i5 << 3) + ((i7 >> (i4 - 2)) << 1) + (i7 & 1);
            }
            int i8 = ((i5 & 1) << 11) + (i5 >> 1);
            for (int i9 = 0; i9 < 4; i9++) {
                if (Integer.bitCount(f2980a[i9] ^ i8) <= 2) {
                    this.g = i9;
                    long j3 = 0;
                    for (int i10 = 0; i10 < 4; i10++) {
                        int i11 = iArr[(this.g + i10) % 4];
                        if (this.f2982c) {
                            j = j3 << 7;
                            j2 = (long) ((i11 >> 1) & 127);
                        } else {
                            j = j3 << 10;
                            j2 = (long) (((i11 >> 2) & 992) + ((i11 >> 1) & 31));
                        }
                        j3 = j + j2;
                    }
                    int a8 = a(j3, this.f2982c);
                    if (this.f2982c) {
                        i = 1;
                        this.d = (a8 >> 6) + 1;
                        i2 = a8 & 63;
                    } else {
                        i = 1;
                        this.d = (a8 >> 11) + 1;
                        i2 = a8 & 2047;
                    }
                    this.e = i2 + i;
                    b bVar = this.f2981b;
                    t tVar2 = a7[this.g % 4];
                    t tVar3 = a7[(this.g + i) % 4];
                    t tVar4 = a7[(this.g + 2) % 4];
                    t tVar5 = a7[(this.g + 3) % 4];
                    i a9 = i.a();
                    int c2 = c();
                    float f2 = ((float) c2) / 2.0f;
                    float f3 = f2 - ((float) this.f);
                    float f4 = f2 + ((float) this.f);
                    return new com.google.a.a.a(a9.a(bVar, c2, c2, f3, f3, f4, f3, f4, f4, f3, f4, tVar2.f3356a, tVar2.f3357b, tVar3.f3356a, tVar3.f3357b, tVar4.f3356a, tVar4.f3357b, tVar5.f3356a, tVar5.f3357b), a(a7, this.f * 2, c()), this.f2982c, this.e, this.d);
                }
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
