package com.google.a.h;

import com.google.a.c.b;
import com.google.a.h.c.a;
import com.google.a.h.c.c;
import com.google.a.h.c.e;
import com.google.a.h.c.f;
import com.google.a.h.c.g;
import com.google.a.v;
import com.google.a.w;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class d implements v {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3290a = 30;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3291b = 2;

    private static b a(e eVar, String str, int i, int i2, int i3, int i4) throws w {
        int i5;
        boolean z;
        int a2;
        e eVar2 = eVar;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int a3 = f.a(i);
        String a4 = g.a(str, eVar2.f3284c, eVar2.d);
        int length = a4.length();
        int i9 = eVar2.e;
        float f = 0.0f;
        int[] iArr = null;
        while (i9 <= eVar2.f && (a2 = e.a(length, a3, i9)) >= eVar2.h) {
            if (a2 <= eVar2.g) {
                float f2 = (((float) ((i9 * 17) + 69)) * 0.357f) / (((float) a2) * 2.0f);
                if (iArr == null || Math.abs(f2 - 3.0f) <= Math.abs(f - 3.0f)) {
                    iArr = new int[]{i9, a2};
                    f = f2;
                }
            }
            i9++;
        }
        if (iArr != null || e.a(length, a3, eVar2.e) >= eVar2.h) {
            i5 = 1;
        } else {
            i5 = 1;
            iArr = new int[]{eVar2.e, eVar2.h};
        }
        if (iArr == null) {
            throw new w("Unable to fit message in columns");
        }
        int i10 = iArr[0];
        int i11 = iArr[i5];
        int a5 = e.a(length, a3, i10, i11);
        if (a3 + length + i5 > 929) {
            throw new w("Encoded message contains too many code words, message too big (" + str.length() + " bytes)");
        }
        int i12 = length + a5 + 1;
        StringBuilder sb = new StringBuilder(i12);
        sb.append((char) i12);
        sb.append(a4);
        for (int i13 = 0; i13 < a5; i13++) {
            sb.append(900);
        }
        String sb2 = sb.toString();
        int i14 = i;
        String a6 = f.a(sb2, i14);
        eVar2.f3282a = new a(i11, i10);
        eVar2.a(sb2 + a6, i10, i11, i14, eVar2.f3282a);
        byte[][] a7 = eVar2.f3282a.a(1, 4);
        if ((i7 > i6) != (a7[0].length < a7.length)) {
            a7 = a(a7);
            z = true;
        } else {
            z = false;
        }
        int length2 = i6 / a7[0].length;
        int length3 = i7 / a7.length;
        if (length2 >= length3) {
            length2 = length3;
        }
        if (length2 <= 1) {
            return a(a7, i8);
        }
        byte[][] a8 = eVar2.f3282a.a(length2, length2 << 2);
        if (z) {
            a8 = a(a8);
        }
        return a(a8, i8);
    }

    private static b a(byte[][] bArr, int i) {
        int i2 = i * 2;
        b bVar = new b(bArr[0].length + i2, bArr.length + i2);
        bVar.a();
        int i3 = (bVar.f3062b - i) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            byte[] bArr2 = bArr[i4];
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr2[i5] == 1) {
                    bVar.b(i5 + i, i3);
                }
            }
            i4++;
            i3--;
        }
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    public final b a(String str, com.google.a.a aVar, int i, int i2) throws w {
        return a(str, aVar, i, i2, (Map<com.google.a.g, ?>) null);
    }

    public final b a(String str, com.google.a.a aVar, int i, int i2, Map<com.google.a.g, ?> map) throws w {
        boolean z;
        if (aVar != com.google.a.a.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(aVar)));
        }
        e eVar = new e();
        int i3 = 30;
        int i4 = 2;
        if (map != null) {
            if (map.containsKey(com.google.a.g.PDF417_COMPACT)) {
                eVar.f3283b = Boolean.valueOf(map.get(com.google.a.g.PDF417_COMPACT).toString()).booleanValue();
            }
            if (map.containsKey(com.google.a.g.PDF417_COMPACTION)) {
                eVar.f3284c = c.valueOf(map.get(com.google.a.g.PDF417_COMPACTION).toString());
            }
            if (map.containsKey(com.google.a.g.PDF417_DIMENSIONS)) {
                com.google.a.h.c.d dVar = (com.google.a.h.c.d) map.get(com.google.a.g.PDF417_DIMENSIONS);
                int i5 = dVar.f3280b;
                int i6 = dVar.f3279a;
                int i7 = dVar.d;
                int i8 = dVar.f3281c;
                eVar.f = i5;
                eVar.e = i6;
                eVar.g = i7;
                eVar.h = i8;
            }
            if (map.containsKey(com.google.a.g.MARGIN)) {
                i3 = Integer.parseInt(map.get(com.google.a.g.MARGIN).toString());
            }
            if (map.containsKey(com.google.a.g.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(com.google.a.g.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(com.google.a.g.CHARACTER_SET)) {
                eVar.d = Charset.forName(map.get(com.google.a.g.CHARACTER_SET).toString());
            }
        }
        eVar.a(str, i4);
        byte[][] a2 = eVar.f3282a.a(1, 4);
        if ((i2 > i) != (a2[0].length < a2.length)) {
            a2 = a(a2);
            z = true;
        } else {
            z = false;
        }
        int length = i / a2[0].length;
        int length2 = i2 / a2.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return a(a2, i3);
        }
        byte[][] a3 = eVar.f3282a.a(length, length << 2);
        if (z) {
            a3 = a(a3);
        }
        return a(a3, i3);
    }
}
