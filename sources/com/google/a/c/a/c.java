package com.google.a.c.a;

import com.google.a.c.b;
import com.google.a.m;
import com.google.a.t;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3058a = 10;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3059b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final b f3060c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public c(b bVar) throws m {
        this(bVar, 10, bVar.f3061a / 2, bVar.f3062b / 2);
    }

    public c(b bVar, int i2, int i3, int i4) throws m {
        this.f3060c = bVar;
        this.d = bVar.f3062b;
        this.e = bVar.f3061a;
        int i5 = i2 / 2;
        this.f = i3 - i5;
        this.g = i3 + i5;
        this.i = i4 - i5;
        this.h = i4 + i5;
        if (this.i < 0 || this.f < 0 || this.h >= this.d || this.g >= this.e) {
            throw m.getNotFoundInstance();
        }
    }

    private t a(float f2, float f3, float f4, float f5) {
        int a2 = a.a(a.a(f2, f3, f4, f5));
        float f6 = (float) a2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < a2; i2++) {
            float f9 = (float) i2;
            int a3 = a.a((f9 * f7) + f2);
            int a4 = a.a((f9 * f8) + f3);
            if (this.f3060c.a(a3, a4)) {
                return new t((float) a3, (float) a4);
            }
        }
        return null;
    }

    private boolean a(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.f3060c.a(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.f3060c.a(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private t[] a(t tVar, t tVar2, t tVar3, t tVar4) {
        float f2 = tVar.f3356a;
        float f3 = tVar.f3357b;
        float f4 = tVar2.f3356a;
        float f5 = tVar2.f3357b;
        float f6 = tVar3.f3356a;
        float f7 = tVar3.f3357b;
        float f8 = tVar4.f3356a;
        float f9 = tVar4.f3357b;
        if (f2 < ((float) this.e) / 2.0f) {
            return new t[]{new t(f8 - 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 + 1.0f), new t(f6 - 1.0f, f7 - 1.0f), new t(f2 + 1.0f, f3 - 1.0f)};
        }
        return new t[]{new t(f8 + 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 - 1.0f), new t(f6 - 1.0f, f7 + 1.0f), new t(f2 - 1.0f, f3 - 1.0f)};
    }

    public final t[] a() throws m {
        boolean z;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.i;
        int i5 = this.h;
        int i6 = i2;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (true) {
            if (!z2) {
                z = false;
                break;
            }
            boolean z8 = true;
            boolean z9 = false;
            while (true) {
                if ((z8 || !z3) && i3 < this.e) {
                    z8 = a(i4, i5, i3, false);
                    if (z8) {
                        i3++;
                        z3 = true;
                        z9 = true;
                    } else if (!z3) {
                        i3++;
                    }
                }
            }
            if (i3 >= this.e) {
                break;
            }
            boolean z10 = true;
            while (true) {
                if ((z10 || !z4) && i5 < this.d) {
                    z10 = a(i6, i3, i5, true);
                    if (z10) {
                        i5++;
                        z4 = true;
                        z9 = true;
                    } else if (!z4) {
                        i5++;
                    }
                }
            }
            if (i5 >= this.d) {
                break;
            }
            boolean z11 = true;
            while (true) {
                if ((z11 || !z5) && i6 >= 0) {
                    z11 = a(i4, i5, i6, false);
                    if (z11) {
                        i6--;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i6--;
                    }
                }
            }
            if (i6 < 0) {
                break;
            }
            boolean z12 = true;
            while (true) {
                if ((z12 || !z7) && i4 >= 0) {
                    z12 = a(i6, i3, i4, true);
                    if (z12) {
                        i4--;
                        z7 = true;
                        z9 = true;
                    } else if (!z7) {
                        i4--;
                    }
                }
            }
            if (i4 < 0) {
                break;
            }
            if (z9) {
                z6 = true;
            }
            z2 = z9;
        }
        z = true;
        if (z || !z6) {
            throw m.getNotFoundInstance();
        }
        int i7 = i3 - i6;
        t tVar = null;
        t tVar2 = null;
        int i8 = 1;
        while (tVar2 == null && i8 < i7) {
            tVar2 = a((float) i6, (float) (i5 - i8), (float) (i6 + i8), (float) i5);
            i8++;
        }
        if (tVar2 == null) {
            throw m.getNotFoundInstance();
        }
        t tVar3 = null;
        int i9 = 1;
        while (tVar3 == null && i9 < i7) {
            tVar3 = a((float) i6, (float) (i4 + i9), (float) (i6 + i9), (float) i4);
            i9++;
        }
        if (tVar3 == null) {
            throw m.getNotFoundInstance();
        }
        t tVar4 = null;
        int i10 = 1;
        while (tVar4 == null && i10 < i7) {
            tVar4 = a((float) i3, (float) (i4 + i10), (float) (i3 - i10), (float) i4);
            i10++;
        }
        if (tVar4 == null) {
            throw m.getNotFoundInstance();
        }
        int i11 = 1;
        while (tVar == null && i11 < i7) {
            tVar = a((float) i3, (float) (i5 - i11), (float) (i3 - i11), (float) i5);
            i11++;
        }
        if (tVar == null) {
            throw m.getNotFoundInstance();
        }
        float f2 = tVar.f3356a;
        float f3 = tVar.f3357b;
        float f4 = tVar2.f3356a;
        float f5 = tVar2.f3357b;
        float f6 = tVar4.f3356a;
        float f7 = tVar4.f3357b;
        float f8 = tVar3.f3356a;
        float f9 = tVar3.f3357b;
        if (f2 < ((float) this.e) / 2.0f) {
            return new t[]{new t(f8 - 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 + 1.0f), new t(f6 - 1.0f, f7 - 1.0f), new t(f2 + 1.0f, f3 - 1.0f)};
        }
        return new t[]{new t(f8 + 1.0f, f9 + 1.0f), new t(f4 + 1.0f, f5 - 1.0f), new t(f6 - 1.0f, f7 + 1.0f), new t(f2 - 1.0f, f3 - 1.0f)};
    }
}
