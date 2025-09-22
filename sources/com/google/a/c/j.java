package com.google.a.c;

import com.google.a.b;
import com.google.a.m;
import java.lang.reflect.Array;

public final class j extends h {

    /* renamed from: b  reason: collision with root package name */
    private static final int f3081b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3082c = 8;
    private static final int d = 7;
    private static final int e = 40;
    private static final int f = 24;
    private b g;

    public j(com.google.a.j jVar) {
        super(jVar);
    }

    private static int a(int i, int i2) {
        if (i < 2) {
            return 2;
        }
        return i > i2 ? i2 : i;
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, b bVar) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bVar.b(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static void a(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, b bVar) {
        int i5 = i;
        int i6 = i2;
        int i7 = 8;
        int i8 = i4 - 8;
        int i9 = i3 - 8;
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 << 3;
            if (i11 > i8) {
                i11 = i8;
            }
            int a2 = a(i10, i6 - 3);
            int i12 = 0;
            while (i12 < i5) {
                int i13 = i12 << 3;
                if (i13 > i9) {
                    i13 = i9;
                }
                int a3 = a(i12, i5 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[a2 + i15];
                    i14 += iArr2[a3 - 2] + iArr2[a3 - 1] + iArr2[a3] + iArr2[a3 + 1] + iArr2[2 + a3];
                }
                int i16 = i14 / 25;
                int i17 = (i11 * i3) + i13;
                int i18 = 0;
                while (i18 < i7) {
                    int i19 = 0;
                    while (i19 < i7) {
                        if ((bArr[i17 + i19] & 255) <= i16) {
                            bVar.b(i13 + i19, i11 + i18);
                        } else {
                            b bVar2 = bVar;
                        }
                        i19++;
                        int i20 = i;
                        i7 = 8;
                    }
                    b bVar3 = bVar;
                    i18++;
                    i17 += i3;
                    int i21 = i;
                    i7 = 8;
                }
                b bVar4 = bVar;
                i12++;
                i5 = i;
                i7 = 8;
            }
            b bVar5 = bVar;
            i10++;
            i5 = i;
            i7 = 8;
        }
    }

    private static int[][] a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = 8;
        int i8 = i4 - 8;
        int i9 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 << 3;
            if (i11 > i8) {
                i11 = i8;
            }
            int i12 = 0;
            while (i12 < i5) {
                int i13 = i12 << 3;
                if (i13 > i9) {
                    i13 = i9;
                }
                int i14 = (i11 * i3) + i13;
                byte b2 = 255;
                int i15 = 0;
                int i16 = 0;
                byte b3 = 0;
                while (i15 < i7) {
                    byte b4 = b3;
                    byte b5 = b2;
                    int i17 = 0;
                    while (i17 < i7) {
                        byte b6 = bArr[i14 + i17] & 255;
                        i16 += b6;
                        if (b6 < b5) {
                            b5 = b6;
                        }
                        if (b6 > b4) {
                            b4 = b6;
                        }
                        i17++;
                        int i18 = i;
                        i7 = 8;
                    }
                    if (b4 - b5 > 24) {
                        while (true) {
                            i15++;
                            i14 += i3;
                            if (i15 >= 8) {
                                break;
                            }
                            int i19 = 0;
                            for (int i20 = 8; i19 < i20; i20 = 8) {
                                i16 += bArr[i14 + i19] & 255;
                                i19++;
                            }
                        }
                    }
                    i15++;
                    i14 += i3;
                    b2 = b5;
                    int i21 = i;
                    i7 = 8;
                    b3 = b4;
                }
                int i22 = i16 >> 6;
                if (b3 - b2 <= 24) {
                    i22 = b2 / 2;
                    if (i10 > 0 && i12 > 0) {
                        int i23 = i10 - 1;
                        int i24 = i12 - 1;
                        int i25 = ((iArr[i23][i12] + (iArr[i10][i24] * 2)) + iArr[i23][i24]) / 4;
                        if (b2 < i25) {
                            i22 = i25;
                        }
                    }
                }
                iArr[i10][i12] = i22;
                i12++;
                i5 = i;
                i7 = 8;
            }
            i10++;
            i5 = i;
            i7 = 8;
        }
        return iArr;
    }

    public final b a(com.google.a.j jVar) {
        return new j(jVar);
    }

    public final b a() throws m {
        j jVar;
        b bVar;
        if (this.g != null) {
            return this.g;
        }
        com.google.a.j jVar2 = this.f3002a;
        int i = jVar2.f3346a;
        int i2 = jVar2.f3347b;
        if (i < 40 || i2 < 40) {
            jVar = this;
            bVar = super.a();
        } else {
            byte[] a2 = jVar2.a();
            int i3 = i >> 3;
            if ((i & 7) != 0) {
                i3++;
            }
            int i4 = i2 >> 3;
            if ((i2 & 7) != 0) {
                i4++;
            }
            int i5 = i2 - 8;
            int i6 = i - 8;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i4, i3});
            int i7 = 0;
            while (true) {
                int i8 = 8;
                if (i7 >= i4) {
                    break;
                }
                int i9 = i7 << 3;
                if (i9 > i5) {
                    i9 = i5;
                }
                int i10 = 0;
                while (i10 < i3) {
                    int i11 = i10 << 3;
                    if (i11 > i6) {
                        i11 = i6;
                    }
                    int i12 = (i9 * i) + i11;
                    int i13 = 0;
                    byte b2 = 255;
                    int i14 = 0;
                    byte b3 = 0;
                    while (i13 < i8) {
                        byte b4 = b2;
                        int i15 = i9;
                        byte b5 = b3;
                        int i16 = 0;
                        while (i16 < i8) {
                            byte b6 = a2[i12 + i16] & 255;
                            i14 += b6;
                            if (b6 < b4) {
                                b4 = b6;
                            }
                            if (b6 > b5) {
                                b5 = b6;
                            }
                            i16++;
                            i8 = 8;
                        }
                        if (b5 - b4 <= 24) {
                            i13++;
                            i12 += i;
                            b2 = b4;
                            b3 = b5;
                            i9 = i15;
                            i8 = 8;
                        }
                        while (true) {
                            i13++;
                            i12 += i;
                            if (i13 >= 8) {
                                break;
                            }
                            int i17 = 0;
                            for (int i18 = 8; i17 < i18; i18 = 8) {
                                i14 += a2[i12 + i17] & 255;
                                i17++;
                            }
                        }
                        i13++;
                        i12 += i;
                        b2 = b4;
                        b3 = b5;
                        i9 = i15;
                        i8 = 8;
                    }
                    int i19 = i9;
                    int i20 = i14 >> 6;
                    if (b3 - b2 <= 24) {
                        i20 = b2 / 2;
                        if (i7 > 0 && i10 > 0) {
                            int i21 = i7 - 1;
                            int i22 = i10 - 1;
                            int i23 = ((iArr[i21][i10] + (iArr[i7][i22] * 2)) + iArr[i21][i22]) / 4;
                            if (b2 < i23) {
                                i20 = i23;
                            }
                        }
                    }
                    iArr[i7][i10] = i20;
                    i10++;
                    i9 = i19;
                    i8 = 8;
                }
                i7++;
            }
            bVar = new b(i, i2);
            for (int i24 = 0; i24 < i4; i24++) {
                int i25 = i24 << 3;
                if (i25 > i5) {
                    i25 = i5;
                }
                int a3 = a(i24, i4 - 3);
                int i26 = 0;
                while (i26 < i3) {
                    int i27 = i26 << 3;
                    if (i27 > i6) {
                        i27 = i6;
                    }
                    int a4 = a(i26, i3 - 3);
                    int i28 = -2;
                    int i29 = i3;
                    int i30 = 0;
                    for (int i31 = 2; i28 <= i31; i31 = 2) {
                        int[] iArr2 = iArr[a3 + i28];
                        i30 += iArr2[a4 - 2] + iArr2[a4 - 1] + iArr2[a4] + iArr2[a4 + 1] + iArr2[a4 + 2];
                        i28++;
                    }
                    int i32 = i30 / 25;
                    int i33 = (i25 * i) + i27;
                    int i34 = 0;
                    while (true) {
                        if (i34 >= 8) {
                            break;
                        }
                        int i35 = i4;
                        int i36 = 0;
                        for (int i37 = 8; i36 < i37; i37 = 8) {
                            byte[] bArr = a2;
                            if ((a2[i33 + i36] & 255) <= i32) {
                                bVar.b(i27 + i36, i25 + i34);
                            }
                            i36++;
                            a2 = bArr;
                        }
                        byte[] bArr2 = a2;
                        i34++;
                        i33 += i;
                        i4 = i35;
                    }
                    byte[] bArr3 = a2;
                    int i38 = i4;
                    i26++;
                    i3 = i29;
                }
                byte[] bArr4 = a2;
                int i39 = i3;
                int i40 = i4;
            }
            jVar = this;
        }
        jVar.g = bVar;
        return jVar.g;
    }
}
