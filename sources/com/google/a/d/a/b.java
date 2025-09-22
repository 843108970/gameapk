package com.google.a.d.a;

import com.google.a.d.a.e;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final int f3094a;

    /* renamed from: b  reason: collision with root package name */
    final byte[] f3095b;

    b(int i, byte[] bArr) {
        this.f3094a = i;
        this.f3095b = bArr;
    }

    private int a() {
        return this.f3094a;
    }

    private static b[] a(byte[] bArr, e eVar) {
        e.b bVar = eVar.f;
        e.a[] aVarArr = bVar.f3107b;
        int i = 0;
        for (e.a aVar : aVarArr) {
            i += aVar.f3104a;
        }
        b[] bVarArr = new b[i];
        int length = aVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.a aVar2 = aVarArr[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < aVar2.f3104a) {
                int i6 = aVar2.f3105b;
                bVarArr[i4] = new b(i6, new byte[(bVar.f3106a + i6)]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f3095b.length - bVar.f3106a;
        int i7 = length2 - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i3) {
                bVarArr[i11].f3095b[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        boolean z = eVar.f3101a == 24;
        int i12 = z ? 8 : i3;
        int i13 = i9;
        int i14 = 0;
        while (i14 < i12) {
            bVarArr[i14].f3095b[i7] = bArr[i13];
            i14++;
            i13++;
        }
        int length3 = bVarArr[0].f3095b.length;
        while (length2 < length3) {
            int i15 = 0;
            while (i15 < i3) {
                int i16 = z ? (i15 + 8) % i3 : i15;
                bVarArr[i16].f3095b[(!z || i16 <= 7) ? length2 : length2 - 1] = bArr[i13];
                i15++;
                i13++;
            }
            length2++;
        }
        if (i13 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    private byte[] b() {
        return this.f3095b;
    }
}
