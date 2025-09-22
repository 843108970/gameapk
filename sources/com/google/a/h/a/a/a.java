package com.google.a.h.a.a;

import com.google.a.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f3238a = b.f3239a;

    private int a(int[] iArr, int i, int[] iArr2) throws d {
        int i2;
        c cVar;
        int[] iArr3 = iArr;
        int i3 = i;
        int[] iArr4 = iArr2;
        c cVar2 = new c(this.f3238a, iArr3);
        int[] iArr5 = new int[i3];
        int i4 = i3;
        boolean z = false;
        while (true) {
            i2 = 1;
            if (i4 <= 0) {
                break;
            }
            int b2 = cVar2.b(this.f3238a.f3240b[i4]);
            iArr5[i3 - i4] = b2;
            if (b2 != 0) {
                z = true;
            }
            i4--;
        }
        if (!z) {
            return 0;
        }
        c cVar3 = this.f3238a.e;
        if (iArr4 != null) {
            c cVar4 = cVar3;
            for (int length : iArr4) {
                cVar4 = cVar4.c(new c(this.f3238a, new int[]{this.f3238a.c(0, this.f3238a.f3240b[(iArr3.length - 1) - length]), 1}));
            }
        }
        c cVar5 = new c(this.f3238a, iArr5);
        c a2 = this.f3238a.a(i3, 1);
        if (a2.f3243b.length - 1 >= cVar5.f3243b.length - 1) {
            c cVar6 = a2;
            a2 = cVar5;
            cVar5 = cVar6;
        }
        c cVar7 = this.f3238a.d;
        c cVar8 = this.f3238a.e;
        c cVar9 = a2;
        c cVar10 = cVar5;
        c cVar11 = cVar9;
        while (cVar11.f3243b.length - i2 >= i3 / 2) {
            if (cVar11.a()) {
                throw d.getChecksumInstance();
            }
            c cVar12 = this.f3238a.d;
            int a3 = this.f3238a.a(cVar11.a(cVar11.f3243b.length - i2));
            while (cVar10.f3243b.length - i2 >= cVar11.f3243b.length - i2 && !cVar10.a()) {
                int length2 = (cVar10.f3243b.length - i2) - (cVar11.f3243b.length - i2);
                int d = this.f3238a.d(cVar10.a(cVar10.f3243b.length - i2), a3);
                cVar12 = cVar12.a(this.f3238a.a(length2, d));
                if (length2 < 0) {
                    throw new IllegalArgumentException();
                }
                if (d == 0) {
                    cVar = cVar11.f3242a.d;
                } else {
                    int length3 = cVar11.f3243b.length;
                    int[] iArr6 = new int[(length2 + length3)];
                    for (int i5 = 0; i5 < length3; i5++) {
                        iArr6[i5] = cVar11.f3242a.d(cVar11.f3243b[i5], d);
                    }
                    cVar = new c(cVar11.f3242a, iArr6);
                }
                cVar10 = cVar10.b(cVar);
                i2 = 1;
            }
            i2 = 1;
            c cVar13 = cVar10;
            cVar10 = cVar11;
            cVar11 = cVar13;
            c cVar14 = cVar8;
            cVar8 = cVar12.c(cVar8).b(cVar7).b();
            cVar7 = cVar14;
        }
        int a4 = cVar8.a(0);
        if (a4 == 0) {
            throw d.getChecksumInstance();
        }
        int a5 = this.f3238a.a(a4);
        c[] cVarArr = {cVar8.c(a5), cVar11.c(a5)};
        c cVar15 = cVarArr[0];
        c cVar16 = cVarArr[1];
        int[] a6 = a(cVar15);
        int[] a7 = a(cVar16, cVar15, a6);
        for (int i6 = 0; i6 < a6.length; i6++) {
            int length4 = iArr3.length - 1;
            b bVar = this.f3238a;
            int i7 = a6[i6];
            if (i7 == 0) {
                throw new IllegalArgumentException();
            }
            int i8 = length4 - bVar.f3241c[i7];
            if (i8 < 0) {
                throw d.getChecksumInstance();
            }
            iArr3[i8] = this.f3238a.c(iArr3[i8], a7[i6]);
        }
        return a6.length;
    }

    private c[] a(c cVar, c cVar2, int i) throws d {
        c cVar3;
        c cVar4 = cVar;
        c cVar5 = cVar2;
        if (cVar4.f3243b.length - 1 < cVar5.f3243b.length - 1) {
            c cVar6 = cVar5;
            cVar5 = cVar4;
            cVar4 = cVar6;
        }
        c cVar7 = this.f3238a.d;
        c cVar8 = this.f3238a.e;
        c cVar9 = cVar7;
        c cVar10 = cVar4;
        c cVar11 = cVar5;
        c cVar12 = cVar9;
        while (cVar11.f3243b.length - 1 >= i / 2) {
            if (cVar11.a()) {
                throw d.getChecksumInstance();
            }
            c cVar13 = this.f3238a.d;
            int a2 = this.f3238a.a(cVar11.a(cVar11.f3243b.length - 1));
            while (cVar10.f3243b.length - 1 >= cVar11.f3243b.length - 1 && !cVar10.a()) {
                int length = (cVar10.f3243b.length - 1) - (cVar11.f3243b.length - 1);
                int d = this.f3238a.d(cVar10.a(cVar10.f3243b.length - 1), a2);
                cVar13 = cVar13.a(this.f3238a.a(length, d));
                if (length < 0) {
                    throw new IllegalArgumentException();
                }
                if (d == 0) {
                    cVar3 = cVar11.f3242a.d;
                } else {
                    int length2 = cVar11.f3243b.length;
                    int[] iArr = new int[(length + length2)];
                    for (int i2 = 0; i2 < length2; i2++) {
                        iArr[i2] = cVar11.f3242a.d(cVar11.f3243b[i2], d);
                    }
                    cVar3 = new c(cVar11.f3242a, iArr);
                }
                cVar10 = cVar10.b(cVar3);
            }
            c cVar14 = cVar10;
            cVar10 = cVar11;
            cVar11 = cVar14;
            c cVar15 = cVar8;
            cVar8 = cVar13.c(cVar8).b(cVar12).b();
            cVar12 = cVar15;
        }
        int a3 = cVar8.a(0);
        if (a3 == 0) {
            throw d.getChecksumInstance();
        }
        int a4 = this.f3238a.a(a3);
        return new c[]{cVar8.c(a4), cVar11.c(a4)};
    }

    public final int[] a(c cVar) throws d {
        int length = cVar.f3243b.length - 1;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 1; i2 < this.f3238a.f && i < length; i2++) {
            if (cVar.b(i2) == 0) {
                iArr[i] = this.f3238a.a(i2);
                i++;
            }
        }
        if (i == length) {
            return iArr;
        }
        throw d.getChecksumInstance();
    }

    public final int[] a(c cVar, c cVar2, int[] iArr) {
        int length = cVar2.f3243b.length - 1;
        int[] iArr2 = new int[length];
        for (int i = 1; i <= length; i++) {
            iArr2[length - i] = this.f3238a.d(i, cVar2.a(i));
        }
        c cVar3 = new c(this.f3238a, iArr2);
        int length2 = iArr.length;
        int[] iArr3 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            int a2 = this.f3238a.a(iArr[i2]);
            iArr3[i2] = this.f3238a.d(this.f3238a.c(0, cVar.b(a2)), this.f3238a.a(cVar3.b(a2)));
        }
        return iArr3;
    }
}
