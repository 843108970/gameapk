package com.google.a.h.a;

import com.google.a.h.a;
import com.google.a.t;
import java.util.Formatter;

final class f {
    private static final int e = 2;

    /* renamed from: a  reason: collision with root package name */
    final a f3255a;

    /* renamed from: b  reason: collision with root package name */
    final g[] f3256b = new g[(this.d + 2)];

    /* renamed from: c  reason: collision with root package name */
    c f3257c;
    final int d;

    f(a aVar, c cVar) {
        this.f3255a = aVar;
        this.d = aVar.f3235a;
        this.f3257c = cVar;
    }

    static int a(int i, int i2, d dVar) {
        if (dVar == null || dVar.a()) {
            return i2;
        }
        if (!dVar.a(i)) {
            return i2 + 1;
        }
        dVar.e = i;
        return 0;
    }

    private g a(int i) {
        return this.f3256b[i];
    }

    private void a(int i, int i2, d[] dVarArr) {
        boolean z;
        d dVar = dVarArr[i2];
        d[] dVarArr2 = this.f3256b[i - 1].f3260b;
        int i3 = i + 1;
        d[] dVarArr3 = this.f3256b[i3] != null ? this.f3256b[i3].f3260b : dVarArr2;
        d[] dVarArr4 = new d[14];
        dVarArr4[2] = dVarArr2[i2];
        dVarArr4[3] = dVarArr3[i2];
        if (i2 > 0) {
            int i4 = i2 - 1;
            dVarArr4[0] = dVarArr[i4];
            dVarArr4[4] = dVarArr2[i4];
            dVarArr4[5] = dVarArr3[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            dVarArr4[8] = dVarArr[i5];
            dVarArr4[10] = dVarArr2[i5];
            dVarArr4[11] = dVarArr3[i5];
        }
        if (i2 < dVarArr.length - 1) {
            int i6 = i2 + 1;
            dVarArr4[1] = dVarArr[i6];
            dVarArr4[6] = dVarArr2[i6];
            dVarArr4[7] = dVarArr3[i6];
        }
        if (i2 < dVarArr.length - 2) {
            int i7 = i2 + 2;
            dVarArr4[9] = dVarArr[i7];
            dVarArr4[12] = dVarArr2[i7];
            dVarArr4[13] = dVarArr3[i7];
        }
        int i8 = 0;
        while (i8 < 14) {
            d dVar2 = dVarArr4[i8];
            if (dVar2 == null || !dVar2.a() || dVar2.f3250c != dVar.f3250c) {
                z = false;
            } else {
                dVar.e = dVar2.e;
                z = true;
            }
            if (!z) {
                i8++;
            } else {
                return;
            }
        }
    }

    private void a(int i, g gVar) {
        this.f3256b[i] = gVar;
    }

    private void a(c cVar) {
        this.f3257c = cVar;
    }

    private static boolean a(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.a() || dVar2.f3250c != dVar.f3250c) {
            return false;
        }
        dVar.e = dVar2.e;
        return true;
    }

    private g[] a() {
        int i;
        int i2;
        boolean z;
        a(this.f3256b[0]);
        a(this.f3256b[this.d + 1]);
        int i3 = a.f3233b;
        while (true) {
            if (!(this.f3256b[0] == null || this.f3256b[this.d + 1] == null)) {
                d[] dVarArr = this.f3256b[0].f3260b;
                d[] dVarArr2 = this.f3256b[this.d + 1].f3260b;
                for (int i4 = 0; i4 < dVarArr.length; i4++) {
                    if (!(dVarArr[i4] == null || dVarArr2[i4] == null || dVarArr[i4].e != dVarArr2[i4].e)) {
                        for (int i5 = 1; i5 <= this.d; i5++) {
                            d dVar = this.f3256b[i5].f3260b[i4];
                            if (dVar != null) {
                                dVar.e = dVarArr[i4].e;
                                if (!dVar.a()) {
                                    this.f3256b[i5].f3260b[i4] = null;
                                }
                            }
                        }
                    }
                }
            }
            if (this.f3256b[0] == null) {
                i = 0;
            } else {
                d[] dVarArr3 = this.f3256b[0].f3260b;
                i = 0;
                for (int i6 = 0; i6 < dVarArr3.length; i6++) {
                    if (dVarArr3[i6] != null) {
                        int i7 = dVarArr3[i6].e;
                        int i8 = i;
                        int i9 = 0;
                        for (int i10 = 1; i10 < this.d + 1 && i9 < 2; i10++) {
                            d dVar2 = this.f3256b[i10].f3260b[i6];
                            if (dVar2 != null) {
                                i9 = a(i7, i9, dVar2);
                                if (!dVar2.a()) {
                                    i8++;
                                }
                            }
                        }
                        i = i8;
                    }
                }
            }
            if (this.f3256b[this.d + 1] == null) {
                i2 = 0;
            } else {
                d[] dVarArr4 = this.f3256b[this.d + 1].f3260b;
                i2 = 0;
                for (int i11 = 0; i11 < dVarArr4.length; i11++) {
                    if (dVarArr4[i11] != null) {
                        int i12 = dVarArr4[i11].e;
                        int i13 = i2;
                        int i14 = 0;
                        for (int i15 = this.d + 1; i15 > 0 && i14 < 2; i15--) {
                            d dVar3 = this.f3256b[i15].f3260b[i11];
                            if (dVar3 != null) {
                                i14 = a(i12, i14, dVar3);
                                if (!dVar3.a()) {
                                    i13++;
                                }
                            }
                        }
                        i2 = i13;
                    }
                }
            }
            int i16 = i + i2;
            if (i16 == 0) {
                i16 = 0;
            } else {
                for (int i17 = 1; i17 < this.d + 1; i17++) {
                    d[] dVarArr5 = this.f3256b[i17].f3260b;
                    for (int i18 = 0; i18 < dVarArr5.length; i18++) {
                        if (dVarArr5[i18] != null && !dVarArr5[i18].a()) {
                            d dVar4 = dVarArr5[i18];
                            d[] dVarArr6 = this.f3256b[i17 - 1].f3260b;
                            int i19 = i17 + 1;
                            d[] dVarArr7 = this.f3256b[i19] != null ? this.f3256b[i19].f3260b : dVarArr6;
                            d[] dVarArr8 = new d[14];
                            dVarArr8[2] = dVarArr6[i18];
                            dVarArr8[3] = dVarArr7[i18];
                            if (i18 > 0) {
                                int i20 = i18 - 1;
                                dVarArr8[0] = dVarArr5[i20];
                                dVarArr8[4] = dVarArr6[i20];
                                dVarArr8[5] = dVarArr7[i20];
                            }
                            if (i18 > 1) {
                                int i21 = i18 - 2;
                                dVarArr8[8] = dVarArr5[i21];
                                dVarArr8[10] = dVarArr6[i21];
                                dVarArr8[11] = dVarArr7[i21];
                            }
                            if (i18 < dVarArr5.length - 1) {
                                int i22 = i18 + 1;
                                dVarArr8[1] = dVarArr5[i22];
                                dVarArr8[6] = dVarArr6[i22];
                                dVarArr8[7] = dVarArr7[i22];
                            }
                            if (i18 < dVarArr5.length - 2) {
                                int i23 = i18 + 2;
                                dVarArr8[9] = dVarArr5[i23];
                                dVarArr8[12] = dVarArr6[i23];
                                dVarArr8[13] = dVarArr7[i23];
                            }
                            for (int i24 = 0; i24 < 14; i24++) {
                                d dVar5 = dVarArr8[i24];
                                if (dVar5 == null || !dVar5.a() || dVar5.f3250c != dVar4.f3250c) {
                                    z = false;
                                } else {
                                    dVar4.e = dVar5.e;
                                    z = true;
                                }
                                if (z) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (i16 > 0 && i16 < i3) {
                i3 = i16;
            }
        }
        return this.f3256b;
    }

    private int b() {
        int i;
        int i2;
        boolean z;
        if (!(this.f3256b[0] == null || this.f3256b[this.d + 1] == null)) {
            d[] dVarArr = this.f3256b[0].f3260b;
            d[] dVarArr2 = this.f3256b[this.d + 1].f3260b;
            for (int i3 = 0; i3 < dVarArr.length; i3++) {
                if (!(dVarArr[i3] == null || dVarArr2[i3] == null || dVarArr[i3].e != dVarArr2[i3].e)) {
                    for (int i4 = 1; i4 <= this.d; i4++) {
                        d dVar = this.f3256b[i4].f3260b[i3];
                        if (dVar != null) {
                            dVar.e = dVarArr[i3].e;
                            if (!dVar.a()) {
                                this.f3256b[i4].f3260b[i3] = null;
                            }
                        }
                    }
                }
            }
        }
        if (this.f3256b[0] == null) {
            i = 0;
        } else {
            d[] dVarArr3 = this.f3256b[0].f3260b;
            i = 0;
            for (int i5 = 0; i5 < dVarArr3.length; i5++) {
                if (dVarArr3[i5] != null) {
                    int i6 = dVarArr3[i5].e;
                    int i7 = i;
                    int i8 = 0;
                    for (int i9 = 1; i9 < this.d + 1 && i8 < 2; i9++) {
                        d dVar2 = this.f3256b[i9].f3260b[i5];
                        if (dVar2 != null) {
                            i8 = a(i6, i8, dVar2);
                            if (!dVar2.a()) {
                                i7++;
                            }
                        }
                    }
                    i = i7;
                }
            }
        }
        if (this.f3256b[this.d + 1] == null) {
            i2 = 0;
        } else {
            d[] dVarArr4 = this.f3256b[this.d + 1].f3260b;
            i2 = 0;
            for (int i10 = 0; i10 < dVarArr4.length; i10++) {
                if (dVarArr4[i10] != null) {
                    int i11 = dVarArr4[i10].e;
                    int i12 = i2;
                    int i13 = 0;
                    for (int i14 = this.d + 1; i14 > 0 && i13 < 2; i14--) {
                        d dVar3 = this.f3256b[i14].f3260b[i10];
                        if (dVar3 != null) {
                            i13 = a(i11, i13, dVar3);
                            if (!dVar3.a()) {
                                i12++;
                            }
                        }
                    }
                    i2 = i12;
                }
            }
        }
        int i15 = i + i2;
        if (i15 == 0) {
            return 0;
        }
        for (int i16 = 1; i16 < this.d + 1; i16++) {
            d[] dVarArr5 = this.f3256b[i16].f3260b;
            for (int i17 = 0; i17 < dVarArr5.length; i17++) {
                if (dVarArr5[i17] != null && !dVarArr5[i17].a()) {
                    d dVar4 = dVarArr5[i17];
                    d[] dVarArr6 = this.f3256b[i16 - 1].f3260b;
                    int i18 = i16 + 1;
                    d[] dVarArr7 = this.f3256b[i18] != null ? this.f3256b[i18].f3260b : dVarArr6;
                    d[] dVarArr8 = new d[14];
                    dVarArr8[2] = dVarArr6[i17];
                    dVarArr8[3] = dVarArr7[i17];
                    if (i17 > 0) {
                        int i19 = i17 - 1;
                        dVarArr8[0] = dVarArr5[i19];
                        dVarArr8[4] = dVarArr6[i19];
                        dVarArr8[5] = dVarArr7[i19];
                    }
                    if (i17 > 1) {
                        int i20 = i17 - 2;
                        dVarArr8[8] = dVarArr5[i20];
                        dVarArr8[10] = dVarArr6[i20];
                        dVarArr8[11] = dVarArr7[i20];
                    }
                    if (i17 < dVarArr5.length - 1) {
                        int i21 = i17 + 1;
                        dVarArr8[1] = dVarArr5[i21];
                        dVarArr8[6] = dVarArr6[i21];
                        dVarArr8[7] = dVarArr7[i21];
                    }
                    if (i17 < dVarArr5.length - 2) {
                        int i22 = i17 + 2;
                        dVarArr8[9] = dVarArr5[i22];
                        dVarArr8[12] = dVarArr6[i22];
                        dVarArr8[13] = dVarArr7[i22];
                    }
                    for (int i23 = 0; i23 < 14; i23++) {
                        d dVar5 = dVarArr8[i23];
                        if (dVar5 == null || !dVar5.a() || dVar5.f3250c != dVar4.f3250c) {
                            z = false;
                        } else {
                            dVar4.e = dVar5.e;
                            z = true;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            }
        }
        return i15;
    }

    private int c() {
        int i;
        int i2 = 0;
        if (!(this.f3256b[0] == null || this.f3256b[this.d + 1] == null)) {
            d[] dVarArr = this.f3256b[0].f3260b;
            d[] dVarArr2 = this.f3256b[this.d + 1].f3260b;
            for (int i3 = 0; i3 < dVarArr.length; i3++) {
                if (!(dVarArr[i3] == null || dVarArr2[i3] == null || dVarArr[i3].e != dVarArr2[i3].e)) {
                    for (int i4 = 1; i4 <= this.d; i4++) {
                        d dVar = this.f3256b[i4].f3260b[i3];
                        if (dVar != null) {
                            dVar.e = dVarArr[i3].e;
                            if (!dVar.a()) {
                                this.f3256b[i4].f3260b[i3] = null;
                            }
                        }
                    }
                }
            }
        }
        if (this.f3256b[0] == null) {
            i = 0;
        } else {
            d[] dVarArr3 = this.f3256b[0].f3260b;
            i = 0;
            for (int i5 = 0; i5 < dVarArr3.length; i5++) {
                if (dVarArr3[i5] != null) {
                    int i6 = dVarArr3[i5].e;
                    int i7 = i;
                    int i8 = 0;
                    for (int i9 = 1; i9 < this.d + 1 && i8 < 2; i9++) {
                        d dVar2 = this.f3256b[i9].f3260b[i5];
                        if (dVar2 != null) {
                            i8 = a(i6, i8, dVar2);
                            if (!dVar2.a()) {
                                i7++;
                            }
                        }
                    }
                    i = i7;
                }
            }
        }
        if (this.f3256b[this.d + 1] != null) {
            d[] dVarArr4 = this.f3256b[this.d + 1].f3260b;
            int i10 = 0;
            for (int i11 = 0; i11 < dVarArr4.length; i11++) {
                if (dVarArr4[i11] != null) {
                    int i12 = dVarArr4[i11].e;
                    int i13 = i10;
                    int i14 = 0;
                    for (int i15 = this.d + 1; i15 > 0 && i14 < 2; i15--) {
                        d dVar3 = this.f3256b[i15].f3260b[i11];
                        if (dVar3 != null) {
                            i14 = a(i12, i14, dVar3);
                            if (!dVar3.a()) {
                                i13++;
                            }
                        }
                    }
                    i10 = i13;
                }
            }
            i2 = i10;
        }
        return i + i2;
    }

    private void d() {
        if (this.f3256b[0] != null && this.f3256b[this.d + 1] != null) {
            d[] dVarArr = this.f3256b[0].f3260b;
            d[] dVarArr2 = this.f3256b[this.d + 1].f3260b;
            for (int i = 0; i < dVarArr.length; i++) {
                if (!(dVarArr[i] == null || dVarArr2[i] == null || dVarArr[i].e != dVarArr2[i].e)) {
                    for (int i2 = 1; i2 <= this.d; i2++) {
                        d dVar = this.f3256b[i2].f3260b[i];
                        if (dVar != null) {
                            dVar.e = dVarArr[i].e;
                            if (!dVar.a()) {
                                this.f3256b[i2].f3260b[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int e() {
        if (this.f3256b[this.d + 1] == null) {
            return 0;
        }
        d[] dVarArr = this.f3256b[this.d + 1].f3260b;
        int i = 0;
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            if (dVarArr[i2] != null) {
                int i3 = dVarArr[i2].e;
                int i4 = i;
                int i5 = 0;
                for (int i6 = this.d + 1; i6 > 0 && i5 < 2; i6--) {
                    d dVar = this.f3256b[i6].f3260b[i2];
                    if (dVar != null) {
                        i5 = a(i3, i5, dVar);
                        if (!dVar.a()) {
                            i4++;
                        }
                    }
                }
                i = i4;
            }
        }
        return i;
    }

    private int f() {
        if (this.f3256b[0] == null) {
            return 0;
        }
        d[] dVarArr = this.f3256b[0].f3260b;
        int i = 0;
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            if (dVarArr[i2] != null) {
                int i3 = dVarArr[i2].e;
                int i4 = i;
                int i5 = 0;
                for (int i6 = 1; i6 < this.d + 1 && i5 < 2; i6++) {
                    d dVar = this.f3256b[i6].f3260b[i2];
                    if (dVar != null) {
                        i5 = a(i3, i5, dVar);
                        if (!dVar.a()) {
                            i4++;
                        }
                    }
                }
                i = i4;
            }
        }
        return i;
    }

    private int g() {
        return this.d;
    }

    private int h() {
        return this.f3255a.e;
    }

    private int i() {
        return this.f3255a.f3236b;
    }

    private c j() {
        return this.f3257c;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar) {
        if (gVar != null) {
            h hVar = (h) gVar;
            a aVar = this.f3255a;
            d[] dVarArr = hVar.f3260b;
            for (d dVar : hVar.f3260b) {
                if (dVar != null) {
                    dVar.b();
                }
            }
            hVar.a(dVarArr, aVar);
            c cVar = hVar.f3259a;
            t tVar = hVar.f3261c ? cVar.f3246b : cVar.d;
            t tVar2 = hVar.f3261c ? cVar.f3247c : cVar.e;
            int b2 = hVar.b((int) tVar.f3357b);
            int b3 = hVar.b((int) tVar2.f3357b);
            int i = -1;
            int i2 = 0;
            int i3 = 1;
            while (b2 < b3) {
                if (dVarArr[b2] != null) {
                    d dVar2 = dVarArr[b2];
                    int i4 = dVar2.e - i;
                    if (i4 == 0) {
                        i2++;
                    } else {
                        if (i4 == 1) {
                            i3 = Math.max(i3, i2);
                            i = dVar2.e;
                        } else if (i4 < 0 || dVar2.e >= aVar.e || i4 > b2) {
                            dVarArr[b2] = null;
                        } else {
                            if (i3 > 2) {
                                i4 *= i3 - 2;
                            }
                            boolean z = i4 >= b2;
                            for (int i5 = 1; i5 <= i4 && !z; i5++) {
                                z = dVarArr[b2 - i5] != null;
                            }
                            if (z) {
                                dVarArr[b2] = null;
                            } else {
                                i = dVar2.e;
                            }
                        }
                        i2 = 1;
                    }
                }
                b2++;
            }
        }
    }

    public final String toString() {
        Throwable th;
        String str;
        Object[] objArr;
        g gVar = this.f3256b[0];
        if (gVar == null) {
            gVar = this.f3256b[this.d + 1];
        }
        Formatter formatter = new Formatter();
        int i = 0;
        while (i < gVar.f3260b.length) {
            try {
                formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    if (this.f3256b[i2] == null) {
                        str = "    |   ";
                        objArr = new Object[0];
                    } else {
                        d dVar = this.f3256b[i2].f3260b[i];
                        if (dVar == null) {
                            str = "    |   ";
                            objArr = new Object[0];
                        } else {
                            formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(dVar.e), Integer.valueOf(dVar.d)});
                        }
                    }
                    formatter.format(str, objArr);
                }
                formatter.format("%n", new Object[0]);
                i++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
        throw th;
    }
}
