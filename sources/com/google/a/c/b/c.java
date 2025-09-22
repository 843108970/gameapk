package com.google.a.c.b;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a f3069a;

    public c(a aVar) {
        this.f3069a = aVar;
    }

    private int[] a(b bVar) throws e {
        int length = bVar.f3067a.length - 1;
        int i = 0;
        if (length == 1) {
            return new int[]{bVar.a(1)};
        }
        int[] iArr = new int[length];
        for (int i2 = 1; i2 < this.f3069a.l && i < length; i2++) {
            if (bVar.b(i2) == 0) {
                iArr[i] = this.f3069a.b(i2);
                i++;
            }
        }
        if (i == length) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int b2 = this.f3069a.b(iArr[i]);
            int i2 = 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (i != i3) {
                    int c2 = this.f3069a.c(iArr[i3], b2);
                    i2 = this.f3069a.c(i2, (c2 & 1) == 0 ? c2 | 1 : c2 & -2);
                }
            }
            iArr2[i] = this.f3069a.c(bVar.b(b2), this.f3069a.b(i2));
            if (this.f3069a.m != 0) {
                iArr2[i] = this.f3069a.c(iArr2[i], b2);
            }
        }
        return iArr2;
    }

    private b[] a(b bVar, b bVar2, int i) throws e {
        if (bVar.f3067a.length - 1 < bVar2.f3067a.length - 1) {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
        }
        b bVar4 = this.f3069a.j;
        b bVar5 = this.f3069a.k;
        b bVar6 = bVar2;
        b bVar7 = bVar;
        b bVar8 = bVar6;
        while (bVar8.f3067a.length - 1 >= i / 2) {
            if (bVar8.a()) {
                throw new e("r_{i-1} was zero");
            }
            b bVar9 = this.f3069a.j;
            int b2 = this.f3069a.b(bVar8.a(bVar8.f3067a.length - 1));
            while (bVar7.f3067a.length - 1 >= bVar8.f3067a.length - 1 && !bVar7.a()) {
                int length = (bVar7.f3067a.length - 1) - (bVar8.f3067a.length - 1);
                int c2 = this.f3069a.c(bVar7.a(bVar7.f3067a.length - 1), b2);
                bVar9 = bVar9.a(this.f3069a.a(length, c2));
                bVar7 = bVar7.a(bVar8.a(length, c2));
            }
            b a2 = bVar9.b(bVar5).a(bVar4);
            if (bVar7.f3067a.length - 1 >= bVar8.f3067a.length - 1) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            b bVar10 = bVar7;
            bVar7 = bVar8;
            bVar8 = bVar10;
            b bVar11 = bVar5;
            bVar5 = a2;
            bVar4 = bVar11;
        }
        int a3 = bVar5.a(0);
        if (a3 == 0) {
            throw new e("sigmaTilde(0) was zero");
        }
        int b3 = this.f3069a.b(a3);
        return new b[]{bVar5.c(b3), bVar8.c(b3)};
    }

    public final void a(int[] iArr, int i) throws e {
        b bVar = new b(this.f3069a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = this.f3069a;
            int b2 = bVar.b(aVar.i[aVar.m + i2]);
            iArr2[(i - 1) - i2] = b2;
            if (b2 != 0) {
                z = false;
            }
        }
        if (!z) {
            b bVar2 = new b(this.f3069a, iArr2);
            b a2 = this.f3069a.a(i, 1);
            if (a2.f3067a.length - 1 >= bVar2.f3067a.length - 1) {
                b bVar3 = a2;
                a2 = bVar2;
                bVar2 = bVar3;
            }
            b bVar4 = this.f3069a.j;
            b bVar5 = this.f3069a.k;
            b bVar6 = a2;
            b bVar7 = bVar2;
            b bVar8 = bVar6;
            while (bVar8.f3067a.length - 1 >= i / 2) {
                if (bVar8.a()) {
                    throw new e("r_{i-1} was zero");
                }
                b bVar9 = this.f3069a.j;
                int b3 = this.f3069a.b(bVar8.a(bVar8.f3067a.length - 1));
                while (bVar7.f3067a.length - 1 >= bVar8.f3067a.length - 1 && !bVar7.a()) {
                    int length = (bVar7.f3067a.length - 1) - (bVar8.f3067a.length - 1);
                    int c2 = this.f3069a.c(bVar7.a(bVar7.f3067a.length - 1), b3);
                    bVar9 = bVar9.a(this.f3069a.a(length, c2));
                    bVar7 = bVar7.a(bVar8.a(length, c2));
                }
                b a3 = bVar9.b(bVar5).a(bVar4);
                if (bVar7.f3067a.length - 1 >= bVar8.f3067a.length - 1) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
                b bVar10 = bVar7;
                bVar7 = bVar8;
                bVar8 = bVar10;
                b bVar11 = bVar5;
                bVar5 = a3;
                bVar4 = bVar11;
            }
            int a4 = bVar5.a(0);
            if (a4 == 0) {
                throw new e("sigmaTilde(0) was zero");
            }
            int b4 = this.f3069a.b(a4);
            b[] bVarArr = {bVar5.c(b4), bVar8.c(b4)};
            b bVar12 = bVarArr[0];
            b bVar13 = bVarArr[1];
            int[] a5 = a(bVar12);
            int[] a6 = a(bVar13, a5);
            for (int i3 = 0; i3 < a5.length; i3++) {
                int length2 = (iArr.length - 1) - this.f3069a.a(a5[i3]);
                if (length2 < 0) {
                    throw new e("Bad error location");
                }
                iArr[length2] = a.b(iArr[length2], a6[i3]);
            }
        }
    }
}
