package com.google.a.i.b;

import com.google.a.c.a.a;
import com.google.a.c.b;
import com.google.a.c.g;
import com.google.a.c.i;
import com.google.a.c.k;
import com.google.a.e;
import com.google.a.h;
import com.google.a.i.a.j;
import com.google.a.m;
import com.google.a.t;
import com.google.a.u;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected final b f3320a;

    /* renamed from: b  reason: collision with root package name */
    private u f3321b;

    public c(b bVar) {
        this.f3320a = bVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float b2 = b(i, i2, i3, i4);
        int i6 = i - (i3 - i);
        int i7 = 0;
        if (i6 < 0) {
            f = ((float) i) / ((float) (i - i6));
            i5 = 0;
        } else if (i6 >= this.f3320a.f3061a) {
            f = ((float) ((this.f3320a.f3061a - 1) - i)) / ((float) (i6 - i));
            i5 = this.f3320a.f3061a - 1;
        } else {
            i5 = i6;
            f = 1.0f;
        }
        float f3 = (float) i2;
        int i8 = (int) (f3 - (((float) (i4 - i2)) * f));
        if (i8 < 0) {
            f2 = f3 / ((float) (i2 - i8));
        } else if (i8 >= this.f3320a.f3062b) {
            f2 = ((float) ((this.f3320a.f3062b - 1) - i2)) / ((float) (i8 - i2));
            i7 = this.f3320a.f3062b - 1;
        } else {
            i7 = i8;
            f2 = 1.0f;
        }
        return (b2 + b(i, i2, (int) (((float) i) + (((float) (i5 - i)) * f2)), i7)) - 1.0f;
    }

    private float a(t tVar, t tVar2) {
        float a2 = a((int) tVar.f3356a, (int) tVar.f3357b, (int) tVar2.f3356a, (int) tVar2.f3357b);
        float a3 = a((int) tVar2.f3356a, (int) tVar2.f3357b, (int) tVar.f3356a, (int) tVar.f3357b);
        return Float.isNaN(a2) ? a3 / 7.0f : Float.isNaN(a3) ? a2 / 7.0f : (a2 + a3) / 14.0f;
    }

    private float a(t tVar, t tVar2, t tVar3) {
        return (a(tVar, tVar2) + a(tVar, tVar3)) / 2.0f;
    }

    private static int a(t tVar, t tVar2, t tVar3, float f) throws m {
        int a2 = ((a.a(t.a(tVar, tVar2) / f) + a.a(t.a(tVar, tVar3) / f)) / 2) + 7;
        int i = a2 & 3;
        if (i == 0) {
            return a2 + 1;
        }
        switch (i) {
            case 2:
                return a2 - 1;
            case 3:
                throw m.getNotFoundInstance();
            default:
                return a2;
        }
    }

    private b a() {
        return this.f3320a;
    }

    private static b a(b bVar, k kVar, int i) throws m {
        return i.a().a(bVar, i, i, kVar);
    }

    private static k a(t tVar, t tVar2, t tVar3, t tVar4, int i) {
        float f;
        float f2;
        float f3;
        t tVar5 = tVar;
        t tVar6 = tVar2;
        t tVar7 = tVar3;
        t tVar8 = tVar4;
        float f4 = ((float) i) - 3.5f;
        if (tVar8 != null) {
            float f5 = tVar8.f3356a;
            f = tVar8.f3357b;
            f2 = f5;
            f3 = f4 - 3.0f;
        } else {
            f2 = (tVar6.f3356a - tVar5.f3356a) + tVar7.f3356a;
            f = (tVar6.f3357b - tVar5.f3357b) + tVar7.f3357b;
            f3 = f4;
        }
        return k.a(3.5f, 3.5f, f4, 3.5f, f3, f3, 3.5f, f4, tVar5.f3356a, tVar5.f3357b, tVar6.f3356a, tVar6.f3357b, f2, f, tVar7.f3356a, tVar7.f3357b);
    }

    private a a(float f, int i, int i2, float f2) throws m {
        a a2;
        a a3;
        int i3 = (int) (f2 * f);
        int max = Math.max(0, i - i3);
        int min = Math.min(this.f3320a.f3061a - 1, i + i3) - max;
        float f3 = 3.0f * f;
        if (((float) min) < f3) {
            throw m.getNotFoundInstance();
        }
        int max2 = Math.max(0, i2 - i3);
        int min2 = Math.min(this.f3320a.f3062b - 1, i2 + i3) - max2;
        if (((float) min2) < f3) {
            throw m.getNotFoundInstance();
        }
        b bVar = new b(this.f3320a, max, max2, min, min2, f, this.f3321b);
        int i4 = bVar.f3319c;
        int i5 = bVar.f;
        int i6 = bVar.e + i4;
        int i7 = bVar.d + (i5 / 2);
        int[] iArr = new int[3];
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = ((i8 & 1) == 0 ? (i8 + 1) / 2 : -((i8 + 1) / 2)) + i7;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i10 = i4;
            while (i10 < i6 && !bVar.f3317a.a(i10, i9)) {
                i10++;
            }
            int i11 = 0;
            while (i10 < i6) {
                if (!bVar.f3317a.a(i10, i9)) {
                    if (i11 == 1) {
                        i11++;
                    }
                    iArr[i11] = iArr[i11] + 1;
                } else if (i11 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i11 != 2) {
                    i11++;
                    iArr[i11] = iArr[i11] + 1;
                } else if (bVar.a(iArr) && (a3 = bVar.a(iArr, i9, i10)) != null) {
                    return a3;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i11 = 1;
                }
                i10++;
            }
            if (bVar.a(iArr) && (a2 = bVar.a(iArr, i9, i6)) != null) {
                return a2;
            }
        }
        if (!bVar.f3318b.isEmpty()) {
            return bVar.f3318b.get(0);
        }
        throw m.getNotFoundInstance();
    }

    private float b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        c cVar;
        boolean z2;
        int i10 = 1;
        boolean z3 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z3) {
            i6 = i;
            i8 = i2;
            i5 = i3;
            i7 = i4;
        } else {
            i8 = i;
            i6 = i2;
            i7 = i3;
            i5 = i4;
        }
        int abs = Math.abs(i7 - i8);
        int abs2 = Math.abs(i5 - i6);
        int i11 = (-abs) / 2;
        int i12 = -1;
        int i13 = i8 < i7 ? 1 : -1;
        if (i6 < i5) {
            i12 = 1;
        }
        int i14 = i7 + i13;
        int i15 = i6;
        int i16 = i11;
        int i17 = 0;
        int i18 = i8;
        while (true) {
            if (i18 == i14) {
                i9 = i14;
                break;
            }
            int i19 = z3 ? i15 : i18;
            int i20 = z3 ? i18 : i15;
            if (i17 == i10) {
                cVar = this;
                i9 = i14;
                z = z3;
                z2 = true;
            } else {
                cVar = this;
                i9 = i14;
                z = z3;
                z2 = false;
            }
            if (z2 == cVar.f3320a.a(i19, i20)) {
                if (i17 == 2) {
                    return a.a(i18, i15, i8, i6);
                }
                i17++;
            }
            i16 += abs2;
            if (i16 > 0) {
                if (i15 == i5) {
                    break;
                }
                i15 += i12;
                i16 -= abs;
            }
            i18 += i13;
            z3 = z;
            i14 = i9;
            i10 = 1;
        }
        if (i17 == 2) {
            return a.a(i9, i5, i8, i6);
        }
        return Float.NaN;
    }

    private u b() {
        return this.f3321b;
    }

    private g c() throws m, h {
        return a((Map<e, ?>) null);
    }

    /* access modifiers changed from: protected */
    public final g a(f fVar) throws m, h {
        float f;
        float f2;
        float f3;
        t[] tVarArr;
        int i;
        float f4;
        int i2;
        int i3;
        a aVar;
        char c2;
        int i4;
        int i5;
        f fVar2 = fVar;
        d dVar = fVar2.f3327b;
        d dVar2 = fVar2.f3328c;
        d dVar3 = fVar2.f3326a;
        float a2 = (a(dVar, dVar2) + a(dVar, dVar3)) / 2.0f;
        if (a2 < 1.0f) {
            throw m.getNotFoundInstance();
        }
        int a3 = ((a.a(t.a(dVar, dVar2) / a2) + a.a(t.a(dVar, dVar3) / a2)) / 2) + 7;
        int i6 = a3 & 3;
        if (i6 != 0) {
            switch (i6) {
                case 2:
                    a3--;
                    break;
                case 3:
                    throw m.getNotFoundInstance();
            }
        } else {
            a3++;
        }
        int i7 = a3;
        j a4 = j.a(i7);
        int a5 = a4.a() - 7;
        a aVar2 = null;
        int i8 = 0;
        int i9 = 1;
        if (a4.f3309b.length > 0) {
            float f5 = (dVar2.f3356a - dVar.f3356a) + dVar3.f3356a;
            float f6 = (dVar2.f3357b - dVar.f3357b) + dVar3.f3357b;
            float f7 = 1.0f - (3.0f / ((float) a5));
            int i10 = (int) (dVar.f3356a + ((f5 - dVar.f3356a) * f7));
            int i11 = (int) (dVar.f3357b + (f7 * (f6 - dVar.f3357b)));
            int i12 = 4;
            while (true) {
                if (i12 <= 16) {
                    int i13 = (int) (((float) i12) * a2);
                    try {
                        int max = Math.max(i8, i10 - i13);
                        int min = Math.min(this.f3320a.f3061a - i9, i10 + i13) - max;
                        float f8 = a2 * 3.0f;
                        if (((float) min) < f8) {
                            throw m.getNotFoundInstance();
                        }
                        int max2 = Math.max(i8, i11 - i13);
                        int min2 = Math.min(this.f3320a.f3062b - i9, i13 + i11) - max2;
                        if (((float) min2) < f8) {
                            throw m.getNotFoundInstance();
                        }
                        i2 = i12;
                        int i14 = max;
                        i3 = i10;
                        try {
                            b bVar = new b(this.f3320a, i14, max2, min, min2, a2, this.f3321b);
                            int i15 = bVar.f3319c;
                            int i16 = bVar.f;
                            int i17 = bVar.e + i15;
                            int i18 = bVar.d + (i16 / 2);
                            int[] iArr = new int[3];
                            int i19 = 0;
                            while (true) {
                                if (i19 < i16) {
                                    if ((i19 & 1) == 0) {
                                        c2 = 2;
                                        i4 = (i19 + 1) / 2;
                                    } else {
                                        c2 = 2;
                                        i4 = -((i19 + 1) / 2);
                                    }
                                    int i20 = i4 + i18;
                                    iArr[0] = 0;
                                    f4 = a2;
                                    try {
                                        iArr[1] = 0;
                                        iArr[c2] = 0;
                                        int i21 = i15;
                                        while (i21 < i17 && !bVar.f3317a.a(i21, i20)) {
                                            i21++;
                                        }
                                        int i22 = 0;
                                        while (true) {
                                            if (i21 < i17) {
                                                i = i11;
                                                try {
                                                    if (!bVar.f3317a.a(i21, i20)) {
                                                        i5 = i15;
                                                        if (i22 == 1) {
                                                            i22++;
                                                        }
                                                        iArr[i22] = iArr[i22] + 1;
                                                    } else if (i22 == 1) {
                                                        iArr[1] = iArr[1] + 1;
                                                        i5 = i15;
                                                    } else if (i22 != 2) {
                                                        i22++;
                                                        i5 = i15;
                                                        iArr[i22] = iArr[i22] + 1;
                                                    } else if (!bVar.a(iArr) || (aVar = bVar.a(iArr, i20, i21)) == null) {
                                                        iArr[0] = iArr[2];
                                                        iArr[1] = 1;
                                                        iArr[2] = 0;
                                                        i5 = i15;
                                                        i22 = 1;
                                                    }
                                                    i21++;
                                                    i11 = i;
                                                    i15 = i5;
                                                } catch (m unused) {
                                                    continue;
                                                }
                                            } else {
                                                int i23 = i11;
                                                int i24 = i15;
                                                if (!bVar.a(iArr) || (aVar = bVar.a(iArr, i20, i17)) == null) {
                                                    i19++;
                                                    a2 = f4;
                                                    i11 = i23;
                                                    i15 = i24;
                                                }
                                            }
                                        }
                                    } catch (m unused2) {
                                        i = i11;
                                        i12 = i2 << 1;
                                        i10 = i3;
                                        a2 = f4;
                                        i11 = i;
                                        i9 = 1;
                                        i8 = 0;
                                    }
                                } else {
                                    float f9 = a2;
                                    int i25 = i11;
                                    if (!bVar.f3318b.isEmpty()) {
                                        aVar = bVar.f3318b.get(0);
                                    } else {
                                        throw m.getNotFoundInstance();
                                    }
                                }
                            }
                        } catch (m unused3) {
                            f4 = a2;
                            i = i11;
                            i12 = i2 << 1;
                            i10 = i3;
                            a2 = f4;
                            i11 = i;
                            i9 = 1;
                            i8 = 0;
                        }
                    } catch (m unused4) {
                        f4 = a2;
                        i = i11;
                        i2 = i12;
                        i3 = i10;
                    }
                }
                i12 = i2 << 1;
                i10 = i3;
                a2 = f4;
                i11 = i;
                i9 = 1;
                i8 = 0;
            }
            aVar2 = aVar;
        }
        a aVar3 = aVar2;
        float f10 = ((float) i7) - 3.5f;
        if (aVar3 != null) {
            f2 = aVar3.f3356a;
            f = aVar3.f3357b;
            f3 = f10 - 3.0f;
        } else {
            f2 = (dVar2.f3356a - dVar.f3356a) + dVar3.f3356a;
            f = (dVar2.f3357b - dVar.f3357b) + dVar3.f3357b;
            f3 = f10;
        }
        b a6 = i.a().a(this.f3320a, i7, i7, k.a(3.5f, 3.5f, f10, 3.5f, f3, f3, 3.5f, f10, dVar.f3356a, dVar.f3357b, dVar2.f3356a, dVar2.f3357b, f2, f, dVar3.f3356a, dVar3.f3357b));
        if (aVar3 == null) {
            tVarArr = new t[]{dVar3, dVar, dVar2};
        } else {
            tVarArr = new t[]{dVar3, dVar, dVar2, aVar3};
        }
        return new g(a6, tVarArr);
    }

    public final g a(Map<e, ?> map) throws m, h {
        this.f3321b = map == null ? null : (u) map.get(e.NEED_RESULT_POINT_CALLBACK);
        return a(new e(this.f3320a, this.f3321b).a(map));
    }
}
