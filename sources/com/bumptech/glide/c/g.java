package com.bumptech.glide.c;

import android.graphics.Bitmap;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.c.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class g implements b {
    private static final String f = "g";
    private static final int g = 4096;
    private static final int h = -1;
    private static final int i = -1;
    private static final int j = 4;
    private static final int k = 255;
    @ColorInt
    private static final int l = 0;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    @Nullable
    private Boolean F;
    @NonNull
    private Bitmap.Config G;
    @ColorInt
    private int[] m;
    @ColorInt
    private final int[] n;
    private final b.a o;
    private ByteBuffer p;
    private byte[] q;
    private e r;
    private short[] s;
    private byte[] t;
    private byte[] u;
    private byte[] v;
    @ColorInt
    private int[] w;
    private int x;
    private d y;
    private Bitmap z;

    private g(@NonNull b.a aVar) {
        this.n = new int[256];
        this.G = Bitmap.Config.ARGB_8888;
        this.o = aVar;
        this.y = new d();
    }

    private g(@NonNull b.a aVar, d dVar, ByteBuffer byteBuffer) {
        this(aVar, dVar, byteBuffer, 1);
    }

    public g(@NonNull b.a aVar, d dVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(dVar, byteBuffer, i2);
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i5 < this.C + i2 && i5 < this.v.length && i5 < i3) {
            int i11 = this.m[this.v[i5] & 255];
            if (i11 != 0) {
                i6 += (i11 >> 24) & 255;
                i7 += (i11 >> 16) & 255;
                i8 += (i11 >> 8) & 255;
                i9 += i11 & 255;
                i10++;
            }
            i5++;
        }
        int i12 = i2 + i4;
        int i13 = i12;
        while (i13 < this.C + i12 && i13 < this.v.length && i13 < i3) {
            int i14 = this.m[this.v[i13] & 255];
            if (i14 != 0) {
                i6 += (i14 >> 24) & 255;
                i7 += (i14 >> 16) & 255;
                i8 += (i14 >> 8) & 255;
                i9 += i14 & 255;
                i10++;
            }
            i13++;
        }
        if (i10 == 0) {
            return 0;
        }
        return ((i6 / i10) << 24) | ((i7 / i10) << 16) | ((i8 / i10) << 8) | (i9 / i10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v10, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r0.y.l == r1.l) goto L_0x0055;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r5v33, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(com.bumptech.glide.c.c r51, com.bumptech.glide.c.c r52) {
        /*
            r50 = this;
            r0 = r50
            r1 = r51
            r2 = r52
            int[] r10 = r0.w
            r11 = 0
            if (r2 != 0) goto L_0x001c
            android.graphics.Bitmap r3 = r0.z
            if (r3 == 0) goto L_0x0016
            com.bumptech.glide.c.b$a r3 = r0.o
            android.graphics.Bitmap r4 = r0.z
            r3.a((android.graphics.Bitmap) r4)
        L_0x0016:
            r3 = 0
            r0.z = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001c:
            r12 = 3
            if (r2 == 0) goto L_0x002a
            int r3 = r2.k
            if (r3 != r12) goto L_0x002a
            android.graphics.Bitmap r3 = r0.z
            if (r3 != 0) goto L_0x002a
            java.util.Arrays.fill(r10, r11)
        L_0x002a:
            r13 = 2
            r14 = 1
            if (r2 == 0) goto L_0x009b
            int r3 = r2.k
            if (r3 <= 0) goto L_0x009b
            int r3 = r2.k
            if (r3 != r13) goto L_0x0084
            boolean r3 = r1.j
            if (r3 != 0) goto L_0x004b
            com.bumptech.glide.c.d r3 = r0.y
            int r3 = r3.n
            int[] r4 = r1.o
            if (r4 == 0) goto L_0x0056
            com.bumptech.glide.c.d r4 = r0.y
            int r4 = r4.l
            int r5 = r1.l
            if (r4 != r5) goto L_0x0056
            goto L_0x0055
        L_0x004b:
            int r3 = r0.x
            if (r3 != 0) goto L_0x0055
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r14)
            r0.F = r3
        L_0x0055:
            r3 = 0
        L_0x0056:
            int r4 = r2.h
            int r5 = r0.C
            int r4 = r4 / r5
            int r5 = r2.f
            int r6 = r0.C
            int r5 = r5 / r6
            int r6 = r2.g
            int r7 = r0.C
            int r6 = r6 / r7
            int r2 = r2.e
            int r7 = r0.C
            int r2 = r2 / r7
            int r7 = r0.E
            int r5 = r5 * r7
            int r5 = r5 + r2
            int r2 = r0.E
            int r4 = r4 * r2
            int r4 = r4 + r5
        L_0x0074:
            if (r5 >= r4) goto L_0x009b
            int r2 = r5 + r6
            r7 = r5
        L_0x0079:
            if (r7 >= r2) goto L_0x0080
            r10[r7] = r3
            int r7 = r7 + 1
            goto L_0x0079
        L_0x0080:
            int r2 = r0.E
            int r5 = r5 + r2
            goto L_0x0074
        L_0x0084:
            int r2 = r2.k
            if (r2 != r12) goto L_0x009b
            android.graphics.Bitmap r2 = r0.z
            if (r2 == 0) goto L_0x009b
            android.graphics.Bitmap r2 = r0.z
            r4 = 0
            int r5 = r0.E
            r6 = 0
            r7 = 0
            int r8 = r0.E
            int r9 = r0.D
            r3 = r10
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x009b:
            if (r1 == 0) goto L_0x00a4
            java.nio.ByteBuffer r2 = r0.p
            int r3 = r1.n
            r2.position(r3)
        L_0x00a4:
            if (r1 != 0) goto L_0x00b1
            com.bumptech.glide.c.d r2 = r0.y
            int r2 = r2.h
            com.bumptech.glide.c.d r3 = r0.y
            int r3 = r3.i
        L_0x00ae:
            int r2 = r2 * r3
            goto L_0x00b6
        L_0x00b1:
            int r2 = r1.g
            int r3 = r1.h
            goto L_0x00ae
        L_0x00b6:
            byte[] r3 = r0.v
            if (r3 == 0) goto L_0x00bf
            byte[] r3 = r0.v
            int r3 = r3.length
            if (r3 >= r2) goto L_0x00c7
        L_0x00bf:
            com.bumptech.glide.c.b$a r3 = r0.o
            byte[] r3 = r3.a((int) r2)
            r0.v = r3
        L_0x00c7:
            byte[] r3 = r0.v
            short[] r4 = r0.s
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x00d3
            short[] r4 = new short[r5]
            r0.s = r4
        L_0x00d3:
            short[] r4 = r0.s
            byte[] r6 = r0.t
            if (r6 != 0) goto L_0x00dd
            byte[] r6 = new byte[r5]
            r0.t = r6
        L_0x00dd:
            byte[] r6 = r0.t
            byte[] r7 = r0.u
            if (r7 != 0) goto L_0x00e9
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.u = r7
        L_0x00e9:
            byte[] r7 = r0.u
            int r8 = r50.q()
            int r9 = r14 << r8
            int r15 = r9 + 1
            int r16 = r9 + 2
            int r8 = r8 + r14
            int r17 = r14 << r8
            int r17 = r17 + -1
            r13 = 0
        L_0x00fb:
            if (r13 >= r9) goto L_0x0107
            r4[r13] = r11
            byte r5 = (byte) r13
            r6[r13] = r5
            int r13 = r13 + 1
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x00fb
        L_0x0107:
            byte[] r5 = r0.q
            r27 = r8
            r25 = r16
            r26 = r17
            r13 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r28 = -1
            r29 = 0
            r30 = 0
        L_0x0120:
            r31 = 8
            if (r13 >= r2) goto L_0x01fc
            if (r20 != 0) goto L_0x0152
            int r14 = r50.q()
            if (r14 > 0) goto L_0x0131
            r32 = r8
            r33 = r13
            goto L_0x0147
        L_0x0131:
            java.nio.ByteBuffer r12 = r0.p
            byte[] r11 = r0.q
            r32 = r8
            java.nio.ByteBuffer r8 = r0.p
            int r8 = r8.remaining()
            int r8 = java.lang.Math.min(r14, r8)
            r33 = r13
            r13 = 0
            r12.get(r11, r13, r8)
        L_0x0147:
            if (r14 > 0) goto L_0x014e
            r8 = 3
            r0.B = r8
            goto L_0x01fc
        L_0x014e:
            r8 = 3
            r24 = 0
            goto L_0x0159
        L_0x0152:
            r32 = r8
            r33 = r13
            r8 = 3
            r14 = r20
        L_0x0159:
            byte r11 = r5[r24]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << r22
            int r23 = r23 + r11
            int r22 = r22 + 8
            r11 = 1
            int r24 = r24 + 1
            r11 = -1
            int r20 = r14 + -1
            r12 = r22
            r8 = r25
            r13 = r27
            r14 = r28
            r34 = r29
        L_0x0173:
            if (r12 < r13) goto L_0x01e7
            r11 = r23 & r26
            int r23 = r23 >> r13
            int r12 = r12 - r13
            if (r11 != r9) goto L_0x0185
            r8 = r16
            r26 = r17
            r13 = r32
            r11 = -1
            r14 = -1
            goto L_0x0173
        L_0x0185:
            if (r11 == r15) goto L_0x01e7
            r35 = r5
            r5 = -1
            if (r14 != r5) goto L_0x019b
            byte r5 = r6[r11]
            r3[r21] = r5
            int r21 = r21 + 1
            int r33 = r33 + 1
            r14 = r11
            r34 = r14
            r5 = r35
        L_0x0199:
            r11 = -1
            goto L_0x0173
        L_0x019b:
            if (r11 < r8) goto L_0x01a6
            r5 = r34
            byte r5 = (byte) r5
            r7[r30] = r5
            int r30 = r30 + 1
            r5 = r14
            goto L_0x01a7
        L_0x01a6:
            r5 = r11
        L_0x01a7:
            if (r5 < r9) goto L_0x01b2
            byte r22 = r6[r5]
            r7[r30] = r22
            int r30 = r30 + 1
            short r5 = r4[r5]
            goto L_0x01a7
        L_0x01b2:
            byte r5 = r6[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r36 = r9
            byte r9 = (byte) r5
            r3[r21] = r9
        L_0x01bb:
            int r21 = r21 + 1
            int r33 = r33 + 1
            if (r30 <= 0) goto L_0x01c8
            int r30 = r30 + -1
            byte r22 = r7[r30]
            r3[r21] = r22
            goto L_0x01bb
        L_0x01c8:
            r37 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r5) goto L_0x01df
            short r14 = (short) r14
            r4[r8] = r14
            r6[r8] = r9
            int r8 = r8 + 1
            r9 = r8 & r26
            if (r9 != 0) goto L_0x01df
            if (r8 >= r5) goto L_0x01df
            int r13 = r13 + 1
            int r26 = r26 + r8
        L_0x01df:
            r14 = r11
            r5 = r35
            r9 = r36
            r34 = r37
            goto L_0x0199
        L_0x01e7:
            r11 = r34
            r25 = r8
            r29 = r11
            r22 = r12
            r27 = r13
            r28 = r14
            r8 = r32
            r13 = r33
            r11 = 0
            r12 = 3
            r14 = 1
            goto L_0x0120
        L_0x01fc:
            r11 = r21
            r13 = 0
            java.util.Arrays.fill(r3, r11, r2, r13)
            boolean r2 = r1.i
            if (r2 != 0) goto L_0x027b
            int r2 = r0.C
            r3 = 1
            if (r2 == r3) goto L_0x020d
            goto L_0x027b
        L_0x020d:
            int[] r2 = r0.w
            int r3 = r1.h
            int r4 = r1.f
            int r5 = r1.g
            int r6 = r1.e
            int r7 = r0.x
            if (r7 != 0) goto L_0x021d
            r7 = 1
            goto L_0x021e
        L_0x021d:
            r7 = 0
        L_0x021e:
            int r8 = r0.E
            byte[] r9 = r0.v
            int[] r11 = r0.m
            r12 = 0
            r14 = -1
        L_0x0226:
            if (r12 >= r3) goto L_0x0265
            int r15 = r12 + r4
            int r15 = r15 * r8
            int r16 = r15 + r6
            int r13 = r16 + r5
            int r15 = r15 + r8
            if (r15 >= r13) goto L_0x0234
            r13 = r15
        L_0x0234:
            int r15 = r1.g
            int r15 = r15 * r12
            r38 = r3
            r3 = r14
            r14 = r16
        L_0x023d:
            if (r14 >= r13) goto L_0x025a
            r39 = r4
            byte r4 = r9[r15]
            r40 = r5
            r5 = r4 & 255(0xff, float:3.57E-43)
            if (r5 == r3) goto L_0x0251
            r5 = r11[r5]
            if (r5 == 0) goto L_0x0250
            r2[r14] = r5
            goto L_0x0251
        L_0x0250:
            r3 = r4
        L_0x0251:
            int r15 = r15 + 1
            int r14 = r14 + 1
            r4 = r39
            r5 = r40
            goto L_0x023d
        L_0x025a:
            r39 = r4
            r40 = r5
            int r12 = r12 + 1
            r14 = r3
            r3 = r38
            r13 = 0
            goto L_0x0226
        L_0x0265:
            java.lang.Boolean r2 = r0.F
            if (r2 != 0) goto L_0x0270
            if (r7 == 0) goto L_0x0270
            r2 = -1
            if (r14 == r2) goto L_0x0270
            r2 = 1
            goto L_0x0271
        L_0x0270:
            r2 = 0
        L_0x0271:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.F = r2
            r41 = r10
            goto L_0x0400
        L_0x027b:
            int[] r2 = r0.w
            int r3 = r1.h
            int r4 = r0.C
            int r3 = r3 / r4
            int r4 = r1.f
            int r5 = r0.C
            int r4 = r4 / r5
            int r5 = r1.g
            int r6 = r0.C
            int r5 = r5 / r6
            int r6 = r1.e
            int r7 = r0.C
            int r6 = r6 / r7
            int r7 = r0.x
            if (r7 != 0) goto L_0x0297
            r7 = 1
            goto L_0x0298
        L_0x0297:
            r7 = 0
        L_0x0298:
            int r8 = r0.C
            int r9 = r0.E
            int r11 = r0.D
            byte[] r12 = r0.v
            int[] r13 = r0.m
            java.lang.Boolean r14 = r0.F
            r41 = r10
            r10 = r14
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 8
        L_0x02ad:
            if (r14 >= r3) goto L_0x03ea
            r42 = r10
            boolean r10 = r1.i
            if (r10 == 0) goto L_0x02ca
            r10 = 4
            if (r15 < r3) goto L_0x02c7
            int r16 = r16 + 1
            switch(r16) {
                case 2: goto L_0x02c6;
                case 3: goto L_0x02c2;
                case 4: goto L_0x02be;
                default: goto L_0x02bd;
            }
        L_0x02bd:
            goto L_0x02c7
        L_0x02be:
            r15 = 1
            r17 = 2
            goto L_0x02c7
        L_0x02c2:
            r15 = 2
            r17 = 4
            goto L_0x02c7
        L_0x02c6:
            r15 = 4
        L_0x02c7:
            int r10 = r15 + r17
            goto L_0x02cc
        L_0x02ca:
            r10 = r15
            r15 = r14
        L_0x02cc:
            int r15 = r15 + r4
            r43 = r3
            r3 = 1
            if (r8 != r3) goto L_0x02d4
            r3 = 1
            goto L_0x02d5
        L_0x02d4:
            r3 = 0
        L_0x02d5:
            if (r15 >= r11) goto L_0x03ca
            int r15 = r15 * r9
            int r18 = r15 + r6
            r44 = r4
            int r4 = r18 + r5
            int r15 = r15 + r9
            if (r15 >= r4) goto L_0x02e3
            goto L_0x02e4
        L_0x02e3:
            r15 = r4
        L_0x02e4:
            int r4 = r14 * r8
            r45 = r5
            int r5 = r1.g
            int r4 = r4 * r5
            if (r3 == 0) goto L_0x030c
            r3 = r18
        L_0x02f0:
            if (r3 >= r15) goto L_0x03ce
            byte r5 = r12[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r13[r5]
            if (r5 == 0) goto L_0x02fd
            r2[r3] = r5
            goto L_0x0308
        L_0x02fd:
            if (r7 == 0) goto L_0x0308
            if (r42 != 0) goto L_0x0308
            r5 = 1
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r5)
            r42 = r18
        L_0x0308:
            int r4 = r4 + r8
            int r3 = r3 + 1
            goto L_0x02f0
        L_0x030c:
            int r3 = r15 - r18
            int r3 = r3 * r8
            int r3 = r3 + r4
            r5 = r4
            r4 = r18
        L_0x0314:
            if (r4 >= r15) goto L_0x03ce
            r46 = r6
            int r6 = r1.g
            r47 = r9
            r48 = r10
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r9 = r5
        L_0x0329:
            int r10 = r0.C
            int r10 = r10 + r5
            if (r9 >= r10) goto L_0x0360
            byte[] r10 = r0.v
            int r10 = r10.length
            if (r9 >= r10) goto L_0x0360
            if (r9 >= r3) goto L_0x0360
            byte[] r10 = r0.v
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r49 = r11
            int[] r11 = r0.m
            r10 = r11[r10]
            if (r10 == 0) goto L_0x035b
            int r11 = r10 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r18 = r18 + r11
            int r11 = r10 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r11
            int r11 = r10 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r11
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r10
            int r22 = r22 + 1
        L_0x035b:
            int r9 = r9 + 1
            r11 = r49
            goto L_0x0329
        L_0x0360:
            r49 = r11
            int r6 = r6 + r5
            r9 = r6
        L_0x0364:
            int r10 = r0.C
            int r10 = r10 + r6
            if (r9 >= r10) goto L_0x0397
            byte[] r10 = r0.v
            int r10 = r10.length
            if (r9 >= r10) goto L_0x0397
            if (r9 >= r3) goto L_0x0397
            byte[] r10 = r0.v
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int[] r11 = r0.m
            r10 = r11[r10]
            if (r10 == 0) goto L_0x0394
            int r11 = r10 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r18 = r18 + r11
            int r11 = r10 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r19 = r19 + r11
            int r11 = r10 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r20 = r20 + r11
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r21 = r21 + r10
            int r22 = r22 + 1
        L_0x0394:
            int r9 = r9 + 1
            goto L_0x0364
        L_0x0397:
            if (r22 != 0) goto L_0x039b
            r11 = 0
            goto L_0x03ad
        L_0x039b:
            int r18 = r18 / r22
            int r6 = r18 << 24
            int r19 = r19 / r22
            int r9 = r19 << 16
            r6 = r6 | r9
            int r20 = r20 / r22
            int r9 = r20 << 8
            r6 = r6 | r9
            int r21 = r21 / r22
            r11 = r6 | r21
        L_0x03ad:
            if (r11 == 0) goto L_0x03b2
            r2[r4] = r11
            goto L_0x03bd
        L_0x03b2:
            if (r7 == 0) goto L_0x03bd
            if (r42 != 0) goto L_0x03bd
            r6 = 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r6)
            r42 = r9
        L_0x03bd:
            int r5 = r5 + r8
            int r4 = r4 + 1
            r6 = r46
            r9 = r47
            r10 = r48
            r11 = r49
            goto L_0x0314
        L_0x03ca:
            r44 = r4
            r45 = r5
        L_0x03ce:
            r46 = r6
            r47 = r9
            r48 = r10
            r49 = r11
            r10 = r42
            int r14 = r14 + 1
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r9 = r47
            r15 = r48
            r11 = r49
            goto L_0x02ad
        L_0x03ea:
            r42 = r10
            java.lang.Boolean r2 = r0.F
            if (r2 != 0) goto L_0x0400
            if (r42 != 0) goto L_0x03f4
            r11 = 0
            goto L_0x03fa
        L_0x03f4:
            r14 = r42
            boolean r11 = r14.booleanValue()
        L_0x03fa:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
            r0.F = r2
        L_0x0400:
            boolean r2 = r0.A
            if (r2 == 0) goto L_0x0427
            int r2 = r1.k
            if (r2 == 0) goto L_0x040d
            int r1 = r1.k
            r2 = 1
            if (r1 != r2) goto L_0x0427
        L_0x040d:
            android.graphics.Bitmap r1 = r0.z
            if (r1 != 0) goto L_0x0417
            android.graphics.Bitmap r1 = r50.s()
            r0.z = r1
        L_0x0417:
            android.graphics.Bitmap r1 = r0.z
            r3 = 0
            int r4 = r0.E
            r5 = 0
            r6 = 0
            int r7 = r0.E
            int r8 = r0.D
            r2 = r41
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0427:
            android.graphics.Bitmap r9 = r50.s()
            r3 = 0
            int r4 = r0.E
            r5 = 0
            r6 = 0
            int r7 = r0.E
            int r8 = r0.D
            r1 = r9
            r2 = r41
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.g.a(com.bumptech.glide.c.c, com.bumptech.glide.c.c):android.graphics.Bitmap");
    }

    private void a(c cVar) {
        c cVar2 = cVar;
        int[] iArr = this.w;
        int i2 = cVar2.h;
        int i3 = cVar2.f;
        int i4 = cVar2.g;
        int i5 = cVar2.e;
        boolean z2 = this.x == 0;
        int i6 = this.E;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            byte b3 = b2;
            int i12 = cVar2.g * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b4 = bArr[i12];
                int i14 = i2;
                byte b5 = b4 & 255;
                if (b5 != b3) {
                    int i15 = iArr2[b5];
                    if (i15 != 0) {
                        iArr[i13] = i15;
                    } else {
                        b3 = b4;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
                c cVar3 = cVar;
            }
            int i16 = i2;
            i7++;
            b2 = b3;
            cVar2 = cVar;
        }
        this.F = Boolean.valueOf(this.F == null && z2 && b2 != -1);
    }

    private void b(c cVar) {
        int i2;
        int i3;
        int i4;
        c cVar2 = cVar;
        int[] iArr = this.w;
        int i5 = cVar2.h / this.C;
        int i6 = cVar2.f / this.C;
        int i7 = cVar2.g / this.C;
        int i8 = cVar2.e / this.C;
        boolean z2 = this.x == 0;
        int i9 = this.C;
        int i10 = this.E;
        int i11 = this.D;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        boolean z3 = this.F;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        int i15 = 8;
        while (i13 < i5) {
            if (cVar2.i) {
                if (i12 >= i5) {
                    i14++;
                    switch (i14) {
                        case 2:
                            i12 = 4;
                            break;
                        case 3:
                            i12 = 2;
                            i15 = 4;
                            break;
                        case 4:
                            i12 = 1;
                            i15 = 2;
                            break;
                    }
                }
                i2 = i12 + i15;
            } else {
                i2 = i12;
                i12 = i13;
            }
            int i16 = i12 + i6;
            int i17 = i5;
            boolean z4 = i9 == 1;
            if (i16 < i11) {
                int i18 = i16 * i10;
                int i19 = i18 + i8;
                i4 = i6;
                int i20 = i19 + i7;
                int i21 = i18 + i10;
                if (i21 < i20) {
                    i20 = i21;
                }
                i3 = i7;
                int i22 = i13 * i9 * cVar2.g;
                if (z4) {
                    for (int i23 = i19; i23 < i20; i23++) {
                        int i24 = iArr2[bArr[i22] & 255];
                        if (i24 != 0) {
                            iArr[i23] = i24;
                        } else if (z2 && z3 == null) {
                            z3 = true;
                        }
                        i22 += i9;
                    }
                } else {
                    int i25 = ((i20 - i19) * i9) + i22;
                    int i26 = i19;
                    while (i26 < i20) {
                        int i27 = i20;
                        int i28 = cVar2.g;
                        int i29 = i8;
                        int i30 = i22;
                        int i31 = 0;
                        int i32 = 0;
                        int i33 = 0;
                        int i34 = 0;
                        int i35 = 0;
                        while (i30 < this.C + i22 && i30 < this.v.length && i30 < i25) {
                            int i36 = i2;
                            int i37 = this.m[this.v[i30] & 255];
                            if (i37 != 0) {
                                i31 += (i37 >> 24) & 255;
                                i32 += (i37 >> 16) & 255;
                                i33 += (i37 >> 8) & 255;
                                i34 += i37 & 255;
                                i35++;
                            }
                            i30++;
                            i2 = i36;
                        }
                        int i38 = i2;
                        int i39 = i28 + i22;
                        int i40 = i39;
                        while (i40 < this.C + i39 && i40 < this.v.length && i40 < i25) {
                            int i41 = this.m[this.v[i40] & 255];
                            if (i41 != 0) {
                                i31 += (i41 >> 24) & 255;
                                i32 += (i41 >> 16) & 255;
                                i33 += (i41 >> 8) & 255;
                                i34 += i41 & 255;
                                i35++;
                            }
                            i40++;
                        }
                        int i42 = i35 == 0 ? 0 : ((i31 / i35) << 24) | ((i32 / i35) << 16) | ((i33 / i35) << 8) | (i34 / i35);
                        if (i42 != 0) {
                            iArr[i26] = i42;
                        } else if (z2 && z3 == null) {
                            z3 = true;
                            i22 += i9;
                            i26++;
                            i20 = i27;
                            i8 = i29;
                            i2 = i38;
                            cVar2 = cVar;
                        }
                        i22 += i9;
                        i26++;
                        i20 = i27;
                        i8 = i29;
                        i2 = i38;
                        cVar2 = cVar;
                    }
                }
            } else {
                i4 = i6;
                i3 = i7;
            }
            i13++;
            i5 = i17;
            i6 = i4;
            i7 = i3;
            i8 = i8;
            i12 = i2;
            cVar2 = cVar;
        }
        if (this.F == null) {
            Boolean bool = z3;
            this.F = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r0v10, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.bumptech.glide.c.c r33) {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.p
            int r3 = r1.n
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x001a
            com.bumptech.glide.c.d r1 = r0.y
            int r1 = r1.h
            com.bumptech.glide.c.d r2 = r0.y
            int r2 = r2.i
            int r1 = r1 * r2
            goto L_0x0020
        L_0x001a:
            int r2 = r1.g
            int r1 = r1.h
            int r1 = r1 * r2
        L_0x0020:
            byte[] r2 = r0.v
            if (r2 == 0) goto L_0x0029
            byte[] r2 = r0.v
            int r2 = r2.length
            if (r2 >= r1) goto L_0x0031
        L_0x0029:
            com.bumptech.glide.c.b$a r2 = r0.o
            byte[] r2 = r2.a((int) r1)
            r0.v = r2
        L_0x0031:
            byte[] r2 = r0.v
            short[] r3 = r0.s
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x003d
            short[] r3 = new short[r4]
            r0.s = r3
        L_0x003d:
            short[] r3 = r0.s
            byte[] r5 = r0.t
            if (r5 != 0) goto L_0x0047
            byte[] r5 = new byte[r4]
            r0.t = r5
        L_0x0047:
            byte[] r5 = r0.t
            byte[] r6 = r0.u
            if (r6 != 0) goto L_0x0053
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.u = r6
        L_0x0053:
            byte[] r6 = r0.u
            int r7 = r32.q()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = 0
        L_0x0066:
            if (r14 >= r9) goto L_0x0070
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x0066
        L_0x0070:
            byte[] r14 = r0.q
            r26 = r7
            r24 = r11
            r25 = r12
            r4 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = -1
            r22 = 0
            r23 = 0
        L_0x0089:
            if (r4 >= r1) goto L_0x015a
            if (r16 != 0) goto L_0x00b8
            int r15 = r32.q()
            if (r15 > 0) goto L_0x0098
            r27 = r4
            r28 = r7
            goto L_0x00ae
        L_0x0098:
            java.nio.ByteBuffer r8 = r0.p
            byte[] r13 = r0.q
            r27 = r4
            java.nio.ByteBuffer r4 = r0.p
            int r4 = r4.remaining()
            int r4 = java.lang.Math.min(r15, r4)
            r28 = r7
            r7 = 0
            r8.get(r13, r7, r4)
        L_0x00ae:
            if (r15 > 0) goto L_0x00b5
            r3 = 3
            r0.B = r3
            goto L_0x015a
        L_0x00b5:
            r20 = 0
            goto L_0x00be
        L_0x00b8:
            r27 = r4
            r28 = r7
            r15 = r16
        L_0x00be:
            byte r4 = r14[r20]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            r4 = 1
            int r20 = r20 + 1
            r7 = -1
            int r16 = r15 + -1
            r8 = r18
            r15 = r21
            r29 = r22
            r4 = r24
            r13 = r26
        L_0x00d8:
            if (r8 < r13) goto L_0x0146
            r7 = r19 & r25
            int r19 = r19 >> r13
            int r8 = r8 - r13
            if (r7 != r9) goto L_0x00e9
            r4 = r11
            r25 = r12
            r13 = r28
            r7 = -1
            r15 = -1
            goto L_0x00d8
        L_0x00e9:
            if (r7 == r10) goto L_0x0146
            r0 = -1
            if (r15 != r0) goto L_0x00fd
            byte r15 = r5[r7]
            r2[r17] = r15
            int r17 = r17 + 1
            int r27 = r27 + 1
            r15 = r7
            r29 = r15
        L_0x00f9:
            r0 = r32
            r7 = -1
            goto L_0x00d8
        L_0x00fd:
            if (r7 < r4) goto L_0x0108
            r0 = r29
            byte r0 = (byte) r0
            r6[r23] = r0
            int r23 = r23 + 1
            r0 = r15
            goto L_0x0109
        L_0x0108:
            r0 = r7
        L_0x0109:
            if (r0 < r9) goto L_0x0114
            byte r18 = r5[r0]
            r6[r23] = r18
            int r23 = r23 + 1
            short r0 = r3[r0]
            goto L_0x0109
        L_0x0114:
            byte r0 = r5[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r30 = r7
            byte r7 = (byte) r0
            r2[r17] = r7
        L_0x011d:
            int r17 = r17 + 1
            int r27 = r27 + 1
            if (r23 <= 0) goto L_0x012a
            int r23 = r23 + -1
            byte r18 = r6[r23]
            r2[r17] = r18
            goto L_0x011d
        L_0x012a:
            r31 = r0
            r0 = 4096(0x1000, float:5.74E-42)
            if (r4 >= r0) goto L_0x0141
            short r15 = (short) r15
            r3[r4] = r15
            r5[r4] = r7
            int r4 = r4 + 1
            r7 = r4 & r25
            if (r7 != 0) goto L_0x0141
            if (r4 >= r0) goto L_0x0141
            int r13 = r13 + 1
            int r25 = r25 + r4
        L_0x0141:
            r15 = r30
            r29 = r31
            goto L_0x00f9
        L_0x0146:
            r24 = r4
            r18 = r8
            r26 = r13
            r21 = r15
            r4 = r27
            r7 = r28
            r22 = r29
            r0 = r32
            r8 = 1
            r13 = 0
            goto L_0x0089
        L_0x015a:
            r13 = r17
            r0 = 0
            java.util.Arrays.fill(r2, r13, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.g.c(com.bumptech.glide.c.c):void");
    }

    @NonNull
    private e p() {
        if (this.r == null) {
            this.r = new e();
        }
        return this.r;
    }

    private int q() {
        return this.p.get() & 255;
    }

    private int r() {
        int q2 = q();
        if (q2 <= 0) {
            return q2;
        }
        this.p.get(this.q, 0, Math.min(q2, this.p.remaining()));
        return q2;
    }

    private Bitmap s() {
        Bitmap a2 = this.o.a(this.E, this.D, (this.F == null || this.F.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.G);
        a2.setHasAlpha(true);
        return a2;
    }

    public final int a() {
        return this.y.h;
    }

    public final int a(int i2) {
        if (i2 < 0 || i2 >= this.y.e) {
            return -1;
        }
        return this.y.g.get(i2).m;
    }

    public final int a(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(f, "Error reading data from stream", e);
            }
        } else {
            this.B = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(f, "Error closing stream", e2);
            }
        }
        return this.B;
    }

    public final synchronized int a(@Nullable byte[] bArr) {
        if (this.r == null) {
            this.r = new e();
        }
        e eVar = this.r;
        if (bArr != null) {
            eVar.a(ByteBuffer.wrap(bArr));
        } else {
            eVar.f927c = null;
            eVar.d.d = 2;
        }
        this.y = eVar.a();
        if (bArr != null) {
            a(this.y, bArr);
        }
        return this.B;
    }

    public final void a(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.G = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public final synchronized void a(@NonNull d dVar, @NonNull ByteBuffer byteBuffer) {
        a(dVar, byteBuffer, 1);
    }

    public final synchronized void a(@NonNull d dVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            try {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            int highestOneBit = Integer.highestOneBit(i2);
            this.B = 0;
            this.y = dVar;
            this.x = -1;
            this.p = byteBuffer.asReadOnlyBuffer();
            this.p.position(0);
            this.p.order(ByteOrder.LITTLE_ENDIAN);
            this.A = false;
            Iterator<c> it = dVar.g.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().k == 3) {
                        this.A = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.C = highestOneBit;
            this.E = dVar.h / highestOneBit;
            this.D = dVar.i / highestOneBit;
            this.v = this.o.a(dVar.h * dVar.i);
            this.w = this.o.b(this.E * this.D);
        }
    }

    public final synchronized void a(@NonNull d dVar, @NonNull byte[] bArr) {
        a(dVar, ByteBuffer.wrap(bArr));
    }

    public final int b() {
        return this.y.i;
    }

    @NonNull
    public final ByteBuffer c() {
        return this.p;
    }

    public final int d() {
        return this.B;
    }

    public final void e() {
        this.x = (this.x + 1) % this.y.e;
    }

    public final int f() {
        if (this.y.e <= 0 || this.x < 0) {
            return 0;
        }
        int i2 = this.x;
        if (i2 < 0 || i2 >= this.y.e) {
            return -1;
        }
        return this.y.g.get(i2).m;
    }

    public final int g() {
        return this.y.e;
    }

    public final int h() {
        return this.x;
    }

    public final void i() {
        this.x = -1;
    }

    @Deprecated
    public final int j() {
        if (this.y.o == -1) {
            return 1;
        }
        return this.y.o;
    }

    public final int k() {
        return this.y.o;
    }

    public final int l() {
        if (this.y.o == -1) {
            return 1;
        }
        if (this.y.o == 0) {
            return 0;
        }
        return this.y.o + 1;
    }

    public final int m() {
        return this.p.limit() + this.v.length + (this.w.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e0, code lost:
        return null;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap n() {
        /*
            r7 = this;
            monitor-enter(r7)
            com.bumptech.glide.c.d r0 = r7.y     // Catch:{ all -> 0x00e1 }
            int r0 = r0.e     // Catch:{ all -> 0x00e1 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r7.x     // Catch:{ all -> 0x00e1 }
            if (r0 >= 0) goto L_0x0038
        L_0x000d:
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.<init>(r4)     // Catch:{ all -> 0x00e1 }
            com.bumptech.glide.c.d r4 = r7.y     // Catch:{ all -> 0x00e1 }
            int r4 = r4.e     // Catch:{ all -> 0x00e1 }
            r3.append(r4)     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00e1 }
            int r4 = r7.x     // Catch:{ all -> 0x00e1 }
            r3.append(r4)     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e1 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00e1 }
        L_0x0036:
            r7.B = r2     // Catch:{ all -> 0x00e1 }
        L_0x0038:
            int r0 = r7.B     // Catch:{ all -> 0x00e1 }
            r3 = 0
            if (r0 == r2) goto L_0x00c2
            int r0 = r7.B     // Catch:{ all -> 0x00e1 }
            r4 = 2
            if (r0 != r4) goto L_0x0044
            goto L_0x00c2
        L_0x0044:
            r0 = 0
            r7.B = r0     // Catch:{ all -> 0x00e1 }
            byte[] r4 = r7.q     // Catch:{ all -> 0x00e1 }
            if (r4 != 0) goto L_0x0055
            com.bumptech.glide.c.b$a r4 = r7.o     // Catch:{ all -> 0x00e1 }
            r5 = 255(0xff, float:3.57E-43)
            byte[] r4 = r4.a((int) r5)     // Catch:{ all -> 0x00e1 }
            r7.q = r4     // Catch:{ all -> 0x00e1 }
        L_0x0055:
            com.bumptech.glide.c.d r4 = r7.y     // Catch:{ all -> 0x00e1 }
            java.util.List<com.bumptech.glide.c.c> r4 = r4.g     // Catch:{ all -> 0x00e1 }
            int r5 = r7.x     // Catch:{ all -> 0x00e1 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00e1 }
            com.bumptech.glide.c.c r4 = (com.bumptech.glide.c.c) r4     // Catch:{ all -> 0x00e1 }
            int r5 = r7.x     // Catch:{ all -> 0x00e1 }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x0071
            com.bumptech.glide.c.d r6 = r7.y     // Catch:{ all -> 0x00e1 }
            java.util.List<com.bumptech.glide.c.c> r6 = r6.g     // Catch:{ all -> 0x00e1 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00e1 }
            com.bumptech.glide.c.c r5 = (com.bumptech.glide.c.c) r5     // Catch:{ all -> 0x00e1 }
            goto L_0x0072
        L_0x0071:
            r5 = r3
        L_0x0072:
            int[] r6 = r4.o     // Catch:{ all -> 0x00e1 }
            if (r6 == 0) goto L_0x0079
            int[] r6 = r4.o     // Catch:{ all -> 0x00e1 }
            goto L_0x007d
        L_0x0079:
            com.bumptech.glide.c.d r6 = r7.y     // Catch:{ all -> 0x00e1 }
            int[] r6 = r6.f924c     // Catch:{ all -> 0x00e1 }
        L_0x007d:
            r7.m = r6     // Catch:{ all -> 0x00e1 }
            int[] r6 = r7.m     // Catch:{ all -> 0x00e1 }
            if (r6 != 0) goto L_0x00a4
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x00a0
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.<init>(r4)     // Catch:{ all -> 0x00e1 }
            int r4 = r7.x     // Catch:{ all -> 0x00e1 }
            r1.append(r4)     // Catch:{ all -> 0x00e1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e1 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e1 }
        L_0x00a0:
            r7.B = r2     // Catch:{ all -> 0x00e1 }
            monitor-exit(r7)
            return r3
        L_0x00a4:
            boolean r1 = r4.j     // Catch:{ all -> 0x00e1 }
            if (r1 == 0) goto L_0x00bc
            int[] r1 = r7.m     // Catch:{ all -> 0x00e1 }
            int[] r2 = r7.n     // Catch:{ all -> 0x00e1 }
            int[] r3 = r7.m     // Catch:{ all -> 0x00e1 }
            int r3 = r3.length     // Catch:{ all -> 0x00e1 }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00e1 }
            int[] r1 = r7.n     // Catch:{ all -> 0x00e1 }
            r7.m = r1     // Catch:{ all -> 0x00e1 }
            int[] r1 = r7.m     // Catch:{ all -> 0x00e1 }
            int r2 = r4.l     // Catch:{ all -> 0x00e1 }
            r1[r2] = r0     // Catch:{ all -> 0x00e1 }
        L_0x00bc:
            android.graphics.Bitmap r0 = r7.a((com.bumptech.glide.c.c) r4, (com.bumptech.glide.c.c) r5)     // Catch:{ all -> 0x00e1 }
            monitor-exit(r7)
            return r0
        L_0x00c2:
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = f     // Catch:{ all -> 0x00e1 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.<init>(r2)     // Catch:{ all -> 0x00e1 }
            int r2 = r7.B     // Catch:{ all -> 0x00e1 }
            r1.append(r2)     // Catch:{ all -> 0x00e1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e1 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e1 }
        L_0x00df:
            monitor-exit(r7)
            return r3
        L_0x00e1:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.g.n():android.graphics.Bitmap");
    }

    public final void o() {
        this.y = null;
        if (this.v != null) {
            this.o.a(this.v);
        }
        if (this.w != null) {
            this.o.a(this.w);
        }
        if (this.z != null) {
            this.o.a(this.z);
        }
        this.z = null;
        this.p = null;
        this.F = null;
        if (this.q != null) {
            this.o.a(this.q);
        }
    }
}
