package com.google.a.c.a;

import com.google.a.m;
import com.google.a.t;

@Deprecated
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3056a = 32;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.a.c.b f3057b;

    private b(com.google.a.c.b bVar) {
        this.f3057b = bVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0010: MOVE  (r14v0 int) = (r20v0 int)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private com.google.a.t a(int r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25) throws com.google.a.m {
        /*
            r16 = this;
            r0 = r17
            r2 = r21
            r3 = 0
            r11 = r0
            r10 = r2
            r12 = r3
            r3 = r24
        L_0x000a:
            if (r10 >= r3) goto L_0x009b
            r13 = r23
            if (r10 < r13) goto L_0x009b
            r14 = r20
            if (r11 >= r14) goto L_0x009b
            r9 = r19
            if (r11 < r9) goto L_0x009b
            if (r18 != 0) goto L_0x0028
            r15 = 1
            r4 = r16
            r5 = r10
            r6 = r25
            r7 = r9
            r8 = r14
            r9 = r15
        L_0x0023:
            int[] r4 = r4.a(r5, r6, r7, r8, r9)
            goto L_0x0031
        L_0x0028:
            r9 = 0
            r4 = r16
            r5 = r11
            r6 = r25
            r7 = r13
            r8 = r3
            goto L_0x0023
        L_0x0031:
            if (r4 != 0) goto L_0x0094
            if (r12 != 0) goto L_0x003a
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x003a:
            r3 = 1
            r4 = 0
            if (r18 != 0) goto L_0x0069
            int r10 = r10 - r22
            r1 = r12[r4]
            if (r1 >= r0) goto L_0x005f
            r1 = r12[r3]
            if (r1 <= r0) goto L_0x0055
            com.google.a.t r0 = new com.google.a.t
            if (r22 <= 0) goto L_0x004d
            r3 = 0
        L_0x004d:
            r1 = r12[r3]
            float r1 = (float) r1
            float r2 = (float) r10
            r0.<init>(r1, r2)
            return r0
        L_0x0055:
            com.google.a.t r0 = new com.google.a.t
            r1 = r12[r4]
            float r1 = (float) r1
            float r2 = (float) r10
            r0.<init>(r1, r2)
            return r0
        L_0x005f:
            com.google.a.t r0 = new com.google.a.t
            r1 = r12[r3]
            float r1 = (float) r1
            float r2 = (float) r10
            r0.<init>(r1, r2)
            return r0
        L_0x0069:
            int r11 = r11 - r18
            r0 = r12[r4]
            if (r0 >= r2) goto L_0x008a
            r0 = r12[r3]
            if (r0 <= r2) goto L_0x0080
            com.google.a.t r0 = new com.google.a.t
            float r2 = (float) r11
            if (r18 >= 0) goto L_0x0079
            r3 = 0
        L_0x0079:
            r1 = r12[r3]
            float r1 = (float) r1
            r0.<init>(r2, r1)
            return r0
        L_0x0080:
            com.google.a.t r0 = new com.google.a.t
            float r1 = (float) r11
            r2 = r12[r4]
            float r2 = (float) r2
            r0.<init>(r1, r2)
            return r0
        L_0x008a:
            com.google.a.t r0 = new com.google.a.t
            float r1 = (float) r11
            r2 = r12[r3]
            float r2 = (float) r2
            r0.<init>(r1, r2)
            return r0
        L_0x0094:
            int r10 = r10 + r22
            int r11 = r11 + r18
            r12 = r4
            goto L_0x000a
        L_0x009b:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.c.a.b.a(int, int, int, int, int, int, int, int, int):com.google.a.t");
    }

    private int[] a(int i, int i2, int i3, int i4, boolean z) {
        int i5 = (i3 + i4) / 2;
        int i6 = i5;
        while (i6 >= i3) {
            if (!z ? !this.f3057b.a(i, i6) : !this.f3057b.a(i6, i)) {
                int i7 = i6;
                while (true) {
                    i7--;
                    if (i7 < i3) {
                        break;
                    } else if (z) {
                        if (this.f3057b.a(i7, i)) {
                            break;
                        }
                    } else if (this.f3057b.a(i, i7)) {
                        break;
                    }
                }
                int i8 = i6 - i7;
                if (i7 < i3 || i8 > i2) {
                    break;
                }
                i6 = i7;
            } else {
                i6--;
            }
        }
        int i9 = i6 + 1;
        while (i5 < i4) {
            if (!z ? !this.f3057b.a(i, i5) : !this.f3057b.a(i5, i)) {
                int i10 = i5;
                while (true) {
                    i10++;
                    if (i10 >= i4) {
                        break;
                    } else if (z) {
                        if (this.f3057b.a(i10, i)) {
                            break;
                        }
                    } else if (this.f3057b.a(i, i10)) {
                        break;
                    }
                }
                int i11 = i10 - i5;
                if (i10 >= i4 || i11 > i2) {
                    break;
                }
                i5 = i10;
            } else {
                i5++;
            }
        }
        int i12 = i5 - 1;
        if (i12 <= i9) {
            return null;
        }
        return new int[]{i9, i12};
    }

    private t[] a() throws m {
        int i = this.f3057b.f3062b;
        int i2 = this.f3057b.f3061a;
        int i3 = i / 2;
        int i4 = i2 / 2;
        int max = Math.max(1, i / 256);
        int i5 = -max;
        int i6 = i4 / 2;
        int i7 = i4;
        int i8 = i2;
        int i9 = i3;
        int i10 = i5;
        int i11 = i;
        int i12 = max;
        int max2 = Math.max(1, i2 / 256);
        int i13 = i3 / 2;
        int i14 = ((int) a(i7, 0, 0, i8, i9, i5, 0, i11, i6).f3357b) - 1;
        int i15 = max2;
        t a2 = a(i7, -max2, 0, i8, i9, 0, i14, i11, i13);
        int i16 = ((int) a2.f3356a) - 1;
        t tVar = a2;
        t a3 = a(i7, i15, i16, i8, i9, 0, i14, i11, i13);
        int i17 = ((int) a3.f3356a) + 1;
        t tVar2 = a3;
        t a4 = a(i7, 0, i16, i17, i9, i12, i14, i11, i6);
        return new t[]{a(i7, 0, i16, i17, i9, i10, i14, ((int) a4.f3357b) + 1, i4 / 4), tVar, tVar2, a4};
    }
}
