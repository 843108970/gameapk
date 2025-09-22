package com.google.a.e.a;

import com.google.a.c.b;
import com.google.a.c.b.a;
import com.google.a.c.b.e;
import com.google.a.d;
import com.google.a.h;
import com.umeng.commonsdk.proguard.bg;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3136a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3137b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3138c = 2;
    private final com.google.a.c.b.c d = new com.google.a.c.b.c(a.h);

    private void a(byte[] bArr, int i, int i2, int i3, int i4) throws d {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[(i5 / i6)];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.d.a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (e unused) {
            throw d.getChecksumInstance();
        }
    }

    private com.google.a.c.e b(b bVar) throws d, h {
        return a(bVar);
    }

    public final com.google.a.c.e a(b bVar) throws h, d {
        int i;
        a aVar = new a(bVar);
        byte[] bArr = new byte[144];
        int i2 = aVar.f3132b.f3062b;
        int i3 = aVar.f3132b.f3061a;
        for (int i4 = 0; i4 < i2; i4++) {
            int[] iArr = a.f3131a[i4];
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = iArr[i5];
                if (i6 >= 0 && aVar.f3132b.a(i5, i4)) {
                    int i7 = i6 / 6;
                    bArr[i7] = (byte) (((byte) (1 << (5 - (i6 % 6)))) | bArr[i7]);
                }
            }
        }
        a(bArr, 0, 10, 10, 0);
        byte b2 = bArr[0] & bg.m;
        switch (b2) {
            case 2:
            case 3:
            case 4:
                byte[] bArr2 = bArr;
                a(bArr2, 20, 84, 40, 1);
                a(bArr2, 20, 84, 40, 2);
                i = 94;
                break;
            case 5:
                byte[] bArr3 = bArr;
                a(bArr3, 20, 68, 56, 1);
                a(bArr3, 20, 68, 56, 2);
                i = 78;
                break;
            default:
                throw h.getFormatInstance();
        }
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, 0, bArr4, 0, 10);
        System.arraycopy(bArr, 20, bArr4, 10, bArr4.length - 10);
        return b.a(bArr4, (int) b2);
    }
}
