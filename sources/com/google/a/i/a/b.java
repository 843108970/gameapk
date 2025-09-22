package com.google.a.i.a;

import com.google.a.i.a.j;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int f3298a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f3299b;

    b(int i, byte[] bArr) {
        this.f3298a = i;
        this.f3299b = bArr;
    }

    private int a() {
        return this.f3298a;
    }

    private static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.f3310c) {
            throw new IllegalArgumentException();
        }
        j.b a2 = jVar.a(fVar);
        j.a[] aVarArr = a2.f3314b;
        int i = 0;
        for (j.a aVar : aVarArr) {
            i += aVar.f3311a;
        }
        b[] bVarArr = new b[i];
        int length = aVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            j.a aVar2 = aVarArr[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < aVar2.f3311a) {
                int i6 = aVar2.f3312b;
                bVarArr[i4] = new b(i6, new byte[(a2.f3313a + i6)]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f3299b.length;
        int length3 = bVarArr.length - 1;
        while (length3 >= 0 && bVarArr[length3].f3299b.length != length2) {
            length3--;
        }
        int i7 = length3 + 1;
        int i8 = length2 - a2.f3313a;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i8) {
            int i11 = i10;
            int i12 = 0;
            while (i12 < i3) {
                bVarArr[i12].f3299b[i9] = bArr[i11];
                i12++;
                i11++;
            }
            i9++;
            i10 = i11;
        }
        int i13 = i7;
        while (i13 < i3) {
            bVarArr[i13].f3299b[i8] = bArr[i10];
            i13++;
            i10++;
        }
        int length4 = bVarArr[0].f3299b.length;
        while (i8 < length4) {
            int i14 = i10;
            int i15 = 0;
            while (i15 < i3) {
                bVarArr[i15].f3299b[i15 < i7 ? i8 : i8 + 1] = bArr[i14];
                i15++;
                i14++;
            }
            i8++;
            i10 = i14;
        }
        return bVarArr;
    }

    private byte[] b() {
        return this.f3299b;
    }
}
