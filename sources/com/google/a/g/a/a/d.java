package com.google.a.g.a.a;

import com.cyjh.mobileanjian.ipc.share.proto.UiMessage;
import com.google.a.g.a.a;
import com.google.a.g.a.a.a.e;
import com.google.a.g.a.a.a.g;
import com.google.a.g.a.a.a.j;
import com.google.a.g.a.a.a.k;
import com.google.a.g.a.a.a.s;
import com.google.a.g.a.b;
import com.google.a.g.a.c;
import com.google.a.h;
import com.google.a.m;
import com.google.a.r;
import com.google.a.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d extends a {
    private static final int[] g = {7, 5, 4, 3, 1};
    private static final int[] h = {4, 20, 52, 104, UiMessage.CommandToUi.Command_Type.SET_RADIO_GROUP_VALUE};
    private static final int[] i = {0, 348, 1388, 2948, 3988};
    private static final int[][] j = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] k = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, UiMessage.CommandToUi.Command_Type.SET_WEB_VIEW_VALUE, UiMessage.CommandToUi.Command_Type.SET_CHECK_BOX_VALUE}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, UiMessage.CommandToUi.Command_Type.SET_BOTTON_VALUE, 187, 139, UiMessage.CommandToUi.Command_Type.SET_IMAGE_VIEW_VALUE, 196, 166}, new int[]{76, 17, 51, com.cyjh.elfin.e.b.a.r, 37, 111, 122, 155}, new int[]{43, com.cyjh.mobileanjian.ipc.share.proto.a.aG, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, UiMessage.CommandToUi.Command_Type.SET_LINE_VALUE, UiMessage.CommandToUi.Command_Type.SET_TAB_VALUE, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, UiMessage.CommandToUi.Command_Type.SET_RADIO_GROUP_VALUE, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, UiMessage.CommandToUi.Command_Type.SET_SPINNER_VALUE, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    private static final int l = 0;
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int[][] r = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int s = 11;
    private final List<b> t = new ArrayList(11);
    private final List<c> u = new ArrayList();
    private final int[] v = new int[2];
    private boolean w;

    private static int a(com.google.a.c.a aVar, int i2) {
        return aVar.a(i2) ? aVar.c(aVar.d(i2)) : aVar.d(aVar.c(i2));
    }

    private b a(com.google.a.c.a aVar, List<b> list, int i2) throws m {
        b bVar;
        com.google.a.c.a aVar2 = aVar;
        List<b> list2 = list;
        int i3 = 2;
        boolean z = true;
        boolean z2 = list.size() % 2 == 0;
        if (this.w) {
            z2 = !z2;
        }
        int i4 = -1;
        boolean z3 = true;
        while (true) {
            int[] iArr = this.f3151a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[i3] = 0;
            iArr[3] = 0;
            int i5 = aVar2.f3055b;
            int i6 = i4 < 0 ? list.isEmpty() ? 0 : list2.get(list.size() - 1).f3178c.f3185b[1] : i4;
            boolean z4 = list.size() % i3 != 0;
            if (this.w) {
                z4 = !z4;
            }
            boolean z5 = false;
            while (i6 < i5) {
                z5 = !aVar2.a(i6);
                if (!z5) {
                    break;
                }
                i6++;
            }
            int i7 = i6;
            int i8 = 0;
            while (i6 < i5) {
                if (aVar2.a(i6) != z5) {
                    iArr[i8] = iArr[i8] + 1;
                    int i9 = i2;
                } else {
                    if (i8 == 3) {
                        if (z4) {
                            b(iArr);
                        }
                        if (a(iArr)) {
                            this.v[0] = i7;
                            this.v[1] = i6;
                            c a2 = a(aVar2, i2, z2);
                            if (a2 == null) {
                                int i10 = this.v[0];
                                i4 = aVar2.a(i10) ? aVar2.c(aVar2.d(i10)) : aVar2.d(aVar2.c(i10));
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                b a3 = a(aVar2, a2, z2, true);
                                if (!list.isEmpty()) {
                                    if (list2.get(list.size() - 1).f3177b != null) {
                                        z = false;
                                    }
                                    if (z) {
                                        throw m.getNotFoundInstance();
                                    }
                                }
                                try {
                                    bVar = a(aVar2, a2, z2, false);
                                } catch (m unused) {
                                    bVar = null;
                                }
                                return new b(a3, bVar, a2);
                            }
                            i3 = 2;
                        } else {
                            int i11 = i2;
                            if (z4) {
                                b(iArr);
                            }
                            i7 += iArr[0] + iArr[1];
                            iArr[0] = iArr[2];
                            iArr[1] = iArr[3];
                            iArr[2] = 0;
                            iArr[3] = 0;
                            i8--;
                        }
                    } else {
                        int i12 = i2;
                        i8++;
                    }
                    iArr[i8] = 1;
                    z5 = !z5;
                }
                i6++;
            }
            throw m.getNotFoundInstance();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.g.a.b a(com.google.a.c.a r19, com.google.a.g.a.c r20, boolean r21, boolean r22) throws com.google.a.m {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int[] r4 = r0.f3152b
            r5 = 0
            r6 = 0
        L_0x000a:
            int r7 = r4.length
            if (r6 >= r7) goto L_0x0012
            r4[r6] = r5
            int r6 = r6 + 1
            goto L_0x000a
        L_0x0012:
            r6 = 1
            if (r22 == 0) goto L_0x001d
            int[] r7 = r2.f3185b
            r7 = r7[r5]
            b(r1, r7, r4)
            goto L_0x0037
        L_0x001d:
            int[] r7 = r2.f3185b
            r7 = r7[r6]
            a((com.google.a.c.a) r1, (int) r7, (int[]) r4)
            int r1 = r4.length
            int r1 = r1 - r6
            r7 = r1
            r1 = 0
        L_0x0028:
            if (r1 >= r7) goto L_0x0037
            r8 = r4[r1]
            r9 = r4[r7]
            r4[r1] = r9
            r4[r7] = r8
            int r1 = r1 + 1
            int r7 = r7 + -1
            goto L_0x0028
        L_0x0037:
            int r1 = com.google.a.c.a.a.a((int[]) r4)
            float r1 = (float) r1
            r7 = 1099431936(0x41880000, float:17.0)
            float r1 = r1 / r7
            int[] r7 = r2.f3185b
            r7 = r7[r6]
            int[] r8 = r2.f3185b
            r8 = r8[r5]
            int r7 = r7 - r8
            float r7 = (float) r7
            r8 = 1097859072(0x41700000, float:15.0)
            float r7 = r7 / r8
            float r8 = r1 - r7
            float r8 = java.lang.Math.abs(r8)
            float r8 = r8 / r7
            r7 = 1050253722(0x3e99999a, float:0.3)
            int r8 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x005f
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x005f:
            int[] r8 = r0.e
            int[] r9 = r0.f
            float[] r10 = r0.f3153c
            float[] r11 = r0.d
            r12 = 0
        L_0x0068:
            int r13 = r4.length
            if (r12 >= r13) goto L_0x00ac
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = r4[r12]
            float r14 = (float) r14
            float r14 = r14 * r13
            float r14 = r14 / r1
            r13 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 + r14
            int r13 = (int) r13
            r15 = 8
            if (r13 > 0) goto L_0x0086
            int r13 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x0084
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0084:
            r13 = 1
            goto L_0x0096
        L_0x0086:
            if (r13 <= r15) goto L_0x0096
            r13 = 1091253043(0x410b3333, float:8.7)
            int r13 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
            if (r13 <= 0) goto L_0x0094
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0094:
            r13 = 8
        L_0x0096:
            int r15 = r12 / 2
            r16 = r12 & 1
            if (r16 != 0) goto L_0x00a3
            r8[r15] = r13
            float r13 = (float) r13
            float r14 = r14 - r13
            r10[r15] = r14
            goto L_0x00a9
        L_0x00a3:
            r9[r15] = r13
            float r13 = (float) r13
            float r14 = r14 - r13
            r11[r15] = r14
        L_0x00a9:
            int r12 = r12 + 1
            goto L_0x0068
        L_0x00ac:
            int[] r1 = r0.e
            int r1 = com.google.a.c.a.a.a((int[]) r1)
            int[] r4 = r0.f
            int r4 = com.google.a.c.a.a.a((int[]) r4)
            r7 = 4
            r10 = 13
            if (r1 <= r10) goto L_0x00c0
            r11 = 0
            r12 = 1
            goto L_0x00c6
        L_0x00c0:
            if (r1 >= r7) goto L_0x00c4
            r11 = 1
            goto L_0x00c5
        L_0x00c4:
            r11 = 0
        L_0x00c5:
            r12 = 0
        L_0x00c6:
            if (r4 <= r10) goto L_0x00cb
            r13 = 0
            r14 = 1
            goto L_0x00d1
        L_0x00cb:
            if (r4 >= r7) goto L_0x00cf
            r13 = 1
            goto L_0x00d0
        L_0x00cf:
            r13 = 0
        L_0x00d0:
            r14 = 0
        L_0x00d1:
            int r15 = r1 + r4
            int r15 = r15 + -17
            r5 = r1 & 1
            if (r5 != r6) goto L_0x00db
            r5 = 1
            goto L_0x00dc
        L_0x00db:
            r5 = 0
        L_0x00dc:
            r16 = r4 & 1
            if (r16 != 0) goto L_0x00e3
            r16 = 1
            goto L_0x00e5
        L_0x00e3:
            r16 = 0
        L_0x00e5:
            if (r15 != r6) goto L_0x00fb
            if (r5 == 0) goto L_0x00f2
            if (r16 == 0) goto L_0x00f0
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00f0:
            r12 = 1
            goto L_0x012a
        L_0x00f2:
            if (r16 != 0) goto L_0x00f9
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00f9:
            r14 = 1
            goto L_0x012a
        L_0x00fb:
            r10 = -1
            if (r15 != r10) goto L_0x0112
            if (r5 == 0) goto L_0x0109
            if (r16 == 0) goto L_0x0107
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0107:
            r11 = 1
            goto L_0x012a
        L_0x0109:
            if (r16 != 0) goto L_0x0110
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0110:
            r13 = 1
            goto L_0x012a
        L_0x0112:
            if (r15 != 0) goto L_0x01db
            if (r5 == 0) goto L_0x0123
            if (r16 != 0) goto L_0x011d
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x011d:
            if (r1 >= r4) goto L_0x0121
            r11 = 1
            goto L_0x00f9
        L_0x0121:
            r12 = 1
            goto L_0x0110
        L_0x0123:
            if (r16 == 0) goto L_0x012a
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x012a:
            if (r11 == 0) goto L_0x013a
            if (r12 == 0) goto L_0x0133
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0133:
            int[] r1 = r0.e
            float[] r4 = r0.f3153c
            a((int[]) r1, (float[]) r4)
        L_0x013a:
            if (r12 == 0) goto L_0x0143
            int[] r1 = r0.e
            float[] r4 = r0.f3153c
            b(r1, r4)
        L_0x0143:
            if (r13 == 0) goto L_0x0153
            if (r14 == 0) goto L_0x014c
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x014c:
            int[] r1 = r0.f
            float[] r4 = r0.f3153c
            a((int[]) r1, (float[]) r4)
        L_0x0153:
            if (r14 == 0) goto L_0x015c
            int[] r1 = r0.f
            float[] r4 = r0.d
            b(r1, r4)
        L_0x015c:
            int r1 = r2.f3184a
            int r1 = r1 * 4
            r5 = 2
            if (r21 == 0) goto L_0x0165
            r10 = 0
            goto L_0x0166
        L_0x0165:
            r10 = 2
        L_0x0166:
            int r1 = r1 + r10
            r10 = r22 ^ 1
            int r1 = r1 + r10
            int r1 = r1 - r6
            int r10 = r8.length
            int r10 = r10 - r6
            r11 = 0
            r12 = 0
        L_0x016f:
            if (r10 < 0) goto L_0x018a
            boolean r13 = a((com.google.a.g.a.c) r20, (boolean) r21, (boolean) r22)
            if (r13 == 0) goto L_0x0184
            int[][] r13 = k
            r13 = r13[r1]
            int r14 = r10 * 2
            r13 = r13[r14]
            r14 = r8[r10]
            int r14 = r14 * r13
            int r11 = r11 + r14
        L_0x0184:
            r13 = r8[r10]
            int r12 = r12 + r13
            int r10 = r10 + -1
            goto L_0x016f
        L_0x018a:
            int r10 = r9.length
            int r10 = r10 - r6
            r13 = 0
        L_0x018d:
            if (r10 < 0) goto L_0x01a6
            boolean r14 = a((com.google.a.g.a.c) r20, (boolean) r21, (boolean) r22)
            if (r14 == 0) goto L_0x01a3
            int[][] r14 = k
            r14 = r14[r1]
            int r15 = r10 * 2
            int r15 = r15 + r6
            r14 = r14[r15]
            r15 = r9[r10]
            int r15 = r15 * r14
            int r13 = r13 + r15
        L_0x01a3:
            int r10 = r10 + -1
            goto L_0x018d
        L_0x01a6:
            int r11 = r11 + r13
            r1 = r12 & 1
            if (r1 != 0) goto L_0x01d6
            r1 = 13
            if (r12 > r1) goto L_0x01d6
            if (r12 >= r7) goto L_0x01b2
            goto L_0x01d6
        L_0x01b2:
            int r10 = 13 - r12
            int r10 = r10 / r5
            int[] r1 = g
            r1 = r1[r10]
            int r2 = 9 - r1
            int r1 = com.google.a.g.a.f.a(r8, r1, r6)
            r3 = 0
            int r2 = com.google.a.g.a.f.a(r9, r2, r3)
            int[] r3 = h
            r3 = r3[r10]
            int[] r4 = i
            r4 = r4[r10]
            int r1 = r1 * r3
            int r1 = r1 + r2
            int r1 = r1 + r4
            com.google.a.g.a.b r2 = new com.google.a.g.a.b
            r2.<init>(r1, r11)
            return r2
        L_0x01d6:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x01db:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.d.a(com.google.a.c.a, com.google.a.g.a.c, boolean, boolean):com.google.a.g.a.b");
    }

    private c a(com.google.a.c.a aVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (z) {
            int i6 = this.v[0] - 1;
            while (i6 >= 0 && !aVar.a(i6)) {
                i6--;
            }
            i3 = i6 + 1;
            i4 = this.v[0] - i3;
            i5 = this.v[1];
        } else {
            i3 = this.v[0];
            i5 = aVar.d(this.v[1] + 1);
            i4 = i5 - this.v[1];
        }
        int i7 = i3;
        int i8 = i5;
        int[] iArr = this.f3151a;
        System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
        iArr[0] = i4;
        try {
            return new c(a(iArr, j), new int[]{i7, i8}, i7, i8, i2);
        } catch (m unused) {
            return null;
        }
    }

    private List<b> a(int i2, com.google.a.c.a aVar) throws m {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        while (!z7) {
            try {
                this.t.add(a(aVar, this.t, i2));
            } catch (m e) {
                if (this.t.isEmpty()) {
                    throw e;
                }
                z7 = true;
            }
        }
        if (c()) {
            return this.t;
        }
        boolean z8 = !this.u.isEmpty();
        int i3 = 0;
        boolean z9 = false;
        while (true) {
            if (i3 >= this.u.size()) {
                z = false;
                break;
            }
            c cVar = this.u.get(i3);
            if (cVar.f3180b > i2) {
                z = cVar.a(this.t);
                break;
            }
            z9 = cVar.a(this.t);
            i3++;
        }
        if (!z && !z9) {
            List<b> list = this.t;
            Iterator<T> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                c cVar2 = (c) it.next();
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        continue;
                        break;
                    }
                    b bVar = (b) it2.next();
                    Iterator<b> it3 = cVar2.f3179a.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (bVar.equals(it3.next())) {
                                z6 = true;
                                continue;
                                break;
                            }
                        } else {
                            z6 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z6) {
                        z5 = false;
                        continue;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.u.add(i3, new c(this.t, i2));
                List<b> list2 = this.t;
                Iterator<c> it4 = this.u.iterator();
                while (it4.hasNext()) {
                    c next = it4.next();
                    if (next.f3179a.size() != list2.size()) {
                        Iterator<b> it5 = next.f3179a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            b next2 = it5.next();
                            Iterator<b> it6 = list2.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (next2.equals(it6.next())) {
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it4.remove();
                        }
                    }
                }
            }
        }
        if (z8) {
            List<b> a2 = a(false);
            if (a2 != null) {
                return a2;
            }
            List<b> a3 = a(true);
            if (a3 != null) {
                return a3;
            }
        }
        throw m.getNotFoundInstance();
    }

    private List<b> a(List<c> list, int i2) throws m {
        boolean z;
        while (i2 < this.u.size()) {
            c cVar = this.u.get(i2);
            this.t.clear();
            for (c cVar2 : list) {
                this.t.addAll(cVar2.f3179a);
            }
            this.t.addAll(cVar.f3179a);
            List<b> list2 = this.t;
            int[][] iArr = r;
            int length = iArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int[] iArr2 = iArr[i3];
                if (list2.size() <= iArr2.length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= list2.size()) {
                            z = true;
                            break;
                        } else if (list2.get(i4).f3178c.f3184a != iArr2[i4]) {
                            z = false;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (z) {
                        z2 = true;
                        break;
                    }
                }
                i3++;
            }
            if (!z2) {
                i2++;
            } else if (c()) {
                return this.t;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return a((List<c>) arrayList, i2 + 1);
                } catch (m unused) {
                }
            }
        }
        throw m.getNotFoundInstance();
    }

    private List<b> a(boolean z) {
        List<b> list;
        if (this.u.size() > 25) {
            this.u.clear();
            return null;
        }
        this.t.clear();
        if (z) {
            Collections.reverse(this.u);
        }
        try {
            list = a((List<c>) new ArrayList(), 0);
        } catch (m unused) {
            list = null;
        }
        if (z) {
            Collections.reverse(this.u);
        }
        return list;
    }

    private void a(int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3 = 0;
        boolean z7 = false;
        while (true) {
            if (i3 >= this.u.size()) {
                z = false;
                break;
            }
            c cVar = this.u.get(i3);
            if (cVar.f3180b > i2) {
                z = cVar.a(this.t);
                break;
            } else {
                z7 = cVar.a(this.t);
                i3++;
            }
        }
        if (!z && !z7) {
            List<b> list = this.t;
            Iterator<T> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                c cVar2 = (c) it.next();
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z5 = true;
                        continue;
                        break;
                    }
                    b bVar = (b) it2.next();
                    Iterator<b> it3 = cVar2.f3179a.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (bVar.equals(it3.next())) {
                                z6 = true;
                                continue;
                                break;
                            }
                        } else {
                            z6 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z6) {
                        z5 = false;
                        continue;
                        break;
                    }
                }
                if (z5) {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                this.u.add(i3, new c(this.t, i2));
                List<b> list2 = this.t;
                Iterator<c> it4 = this.u.iterator();
                while (it4.hasNext()) {
                    c next = it4.next();
                    if (next.f3179a.size() != list2.size()) {
                        Iterator<b> it5 = next.f3179a.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = true;
                                break;
                            }
                            b next2 = it5.next();
                            Iterator<b> it6 = list2.iterator();
                            while (true) {
                                if (it6.hasNext()) {
                                    if (next2.equals(it6.next())) {
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                } else {
                                    z4 = false;
                                    continue;
                                    break;
                                }
                            }
                            if (!z4) {
                                z3 = false;
                                break;
                            }
                        }
                        if (z3) {
                            it4.remove();
                        }
                    }
                }
            }
        }
    }

    private static void a(List<b> list, List<c> list2) {
        boolean z;
        Iterator<c> it = list2.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.f3179a.size() != list.size()) {
                Iterator<b> it2 = next.f3179a.iterator();
                while (true) {
                    z = false;
                    boolean z2 = true;
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    private static boolean a(c cVar, boolean z, boolean z2) {
        return cVar.f3184a != 0 || !z || !z2;
    }

    private static boolean a(Iterable<b> iterable, Iterable<c> iterable2) {
        boolean z;
        boolean z2;
        Iterator<c> it = iterable2.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                c next = it.next();
                Iterator<b> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        continue;
                        break;
                    }
                    b next2 = it2.next();
                    Iterator<b> it3 = next.f3179a.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z2 = true;
                                continue;
                                break;
                            }
                        } else {
                            z2 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z2) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z);
        return true;
    }

    private static boolean a(List<b> list) {
        boolean z;
        for (int[] iArr : r) {
            if (list.size() <= iArr.length) {
                int i2 = 0;
                while (true) {
                    if (i2 >= list.size()) {
                        z = true;
                        break;
                    } else if (list.get(i2).f3178c.f3184a != iArr[i2]) {
                        z = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static r b(List<b> list) throws m, h {
        j jVar;
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).f3177b == null) {
            size--;
        }
        com.google.a.c.a aVar = new com.google.a.c.a(size * 12);
        int i2 = list.get(0).f3177b.f3182a;
        int i3 = 0;
        for (int i4 = 11; i4 >= 0; i4--) {
            if (((1 << i4) & i2) != 0) {
                aVar.b(i3);
            }
            i3++;
        }
        for (int i5 = 1; i5 < list.size(); i5++) {
            b bVar = list.get(i5);
            int i6 = bVar.f3176a.f3182a;
            int i7 = i3;
            for (int i8 = 11; i8 >= 0; i8--) {
                if (((1 << i8) & i6) != 0) {
                    aVar.b(i7);
                }
                i7++;
            }
            if (bVar.f3177b != null) {
                int i9 = bVar.f3177b.f3182a;
                for (int i10 = 11; i10 >= 0; i10--) {
                    if (((1 << i10) & i9) != 0) {
                        aVar.b(i7);
                    }
                    i7++;
                }
            }
            i3 = i7;
        }
        if (aVar.a(1)) {
            jVar = new g(aVar);
        } else if (!aVar.a(2)) {
            jVar = new k(aVar);
        } else {
            switch (s.a(aVar, 1, 4)) {
                case 4:
                    jVar = new com.google.a.g.a.a.a.a(aVar);
                    break;
                case 5:
                    jVar = new com.google.a.g.a.a.a.b(aVar);
                    break;
                default:
                    switch (s.a(aVar, 1, 5)) {
                        case 12:
                            jVar = new com.google.a.g.a.a.a.c(aVar);
                            break;
                        case 13:
                            jVar = new com.google.a.g.a.a.a.d(aVar);
                            break;
                        default:
                            switch (s.a(aVar, 1, 7)) {
                                case 56:
                                    jVar = new e(aVar, "310", "11");
                                    break;
                                case 57:
                                    jVar = new e(aVar, "320", "11");
                                    break;
                                case 58:
                                    jVar = new e(aVar, "310", "13");
                                    break;
                                case 59:
                                    jVar = new e(aVar, "320", "13");
                                    break;
                                case 60:
                                    jVar = new e(aVar, "310", "15");
                                    break;
                                case 61:
                                    jVar = new e(aVar, "320", "15");
                                    break;
                                case 62:
                                    jVar = new e(aVar, "310", "17");
                                    break;
                                case 63:
                                    jVar = new e(aVar, "320", "17");
                                    break;
                                default:
                                    throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
                            }
                    }
            }
        }
        String a2 = jVar.a();
        t[] tVarArr = list.get(0).f3178c.f3186c;
        t[] tVarArr2 = list.get(list.size() - 1).f3178c.f3186c;
        return new r(a2, (byte[]) null, new t[]{tVarArr[0], tVarArr[1], tVarArr2[0], tVarArr2[1]}, com.google.a.a.RSS_EXPANDED);
    }

    private List<c> b() {
        return this.u;
    }

    private void b(com.google.a.c.a aVar, List<b> list, int i2) throws m {
        int[] iArr = this.f3151a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i3 = aVar.f3055b;
        if (i2 < 0) {
            i2 = list.isEmpty() ? 0 : list.get(list.size() - 1).f3178c.f3185b[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.w) {
            z = !z;
        }
        boolean z2 = false;
        while (i2 < i3) {
            z2 = !aVar.a(i2);
            if (!z2) {
                break;
            }
            i2++;
        }
        int i4 = i2;
        int i5 = 0;
        while (i2 < i3) {
            if (aVar.a(i2) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 == 3) {
                    if (z) {
                        b(iArr);
                    }
                    if (a(iArr)) {
                        this.v[0] = i4;
                        this.v[1] = i2;
                        return;
                    }
                    if (z) {
                        b(iArr);
                    }
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                } else {
                    i5++;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    private static void b(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length / 2; i2++) {
            int i3 = iArr[i2];
            int i4 = (length - i2) - 1;
            iArr[i2] = iArr[i4];
            iArr[i4] = i3;
        }
    }

    private boolean c() {
        b bVar = this.t.get(0);
        b bVar2 = bVar.f3176a;
        b bVar3 = bVar.f3177b;
        if (bVar3 == null) {
            return false;
        }
        int i2 = bVar3.f3183b;
        int i3 = 2;
        for (int i4 = 1; i4 < this.t.size(); i4++) {
            b bVar4 = this.t.get(i4);
            i2 += bVar4.f3176a.f3183b;
            i3++;
            b bVar5 = bVar4.f3177b;
            if (bVar5 != null) {
                i2 += bVar5.f3183b;
                i3++;
            }
        }
        return ((i3 + -4) * UiMessage.CommandToUi.Command_Type.SET_EDIT_INPUT_TYPE_VALUE) + (i2 % UiMessage.CommandToUi.Command_Type.SET_EDIT_INPUT_TYPE_VALUE) == bVar2.f3182a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() throws com.google.a.m {
        /*
            r11 = this;
            int[] r0 = r11.e
            int r0 = com.google.a.c.a.a.a((int[]) r0)
            int[] r1 = r11.f
            int r1 = com.google.a.c.a.a.a((int[]) r1)
            r2 = 4
            r3 = 13
            r4 = 0
            r5 = 1
            if (r0 <= r3) goto L_0x0016
            r6 = 0
            r7 = 1
            goto L_0x001c
        L_0x0016:
            if (r0 >= r2) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            r7 = 0
        L_0x001c:
            if (r1 <= r3) goto L_0x0021
            r2 = 0
            r3 = 1
            goto L_0x0027
        L_0x0021:
            if (r1 >= r2) goto L_0x0025
            r2 = 1
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r3 = 0
        L_0x0027:
            int r8 = r0 + r1
            int r8 = r8 + -17
            r9 = r0 & 1
            if (r9 != r5) goto L_0x0031
            r9 = 1
            goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            r10 = r1 & 1
            if (r10 != 0) goto L_0x0037
            r4 = 1
        L_0x0037:
            if (r8 != r5) goto L_0x004d
            if (r9 == 0) goto L_0x0044
            if (r4 == 0) goto L_0x0042
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0042:
            r7 = 1
            goto L_0x007c
        L_0x0044:
            if (r4 != 0) goto L_0x004b
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x004b:
            r3 = 1
            goto L_0x007c
        L_0x004d:
            r10 = -1
            if (r8 != r10) goto L_0x0064
            if (r9 == 0) goto L_0x005b
            if (r4 == 0) goto L_0x0059
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0059:
            r6 = 1
            goto L_0x007c
        L_0x005b:
            if (r4 != 0) goto L_0x0062
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0062:
            r2 = 1
            goto L_0x007c
        L_0x0064:
            if (r8 != 0) goto L_0x00af
            if (r9 == 0) goto L_0x0075
            if (r4 != 0) goto L_0x006f
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x006f:
            if (r0 >= r1) goto L_0x0073
            r3 = 1
            goto L_0x0059
        L_0x0073:
            r2 = 1
            goto L_0x0042
        L_0x0075:
            if (r4 == 0) goto L_0x007c
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x007c:
            if (r6 == 0) goto L_0x008c
            if (r7 == 0) goto L_0x0085
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x0085:
            int[] r0 = r11.e
            float[] r1 = r11.f3153c
            a((int[]) r0, (float[]) r1)
        L_0x008c:
            if (r7 == 0) goto L_0x0095
            int[] r0 = r11.e
            float[] r1 = r11.f3153c
            b(r0, r1)
        L_0x0095:
            if (r2 == 0) goto L_0x00a5
            if (r3 == 0) goto L_0x009e
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        L_0x009e:
            int[] r0 = r11.f
            float[] r1 = r11.f3153c
            a((int[]) r0, (float[]) r1)
        L_0x00a5:
            if (r3 == 0) goto L_0x00ae
            int[] r0 = r11.f
            float[] r1 = r11.d
            b(r0, r1)
        L_0x00ae:
            return
        L_0x00af:
            com.google.a.m r0 = com.google.a.m.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.a.d.d():void");
    }

    public final r a(int i2, com.google.a.c.a aVar, Map<com.google.a.e, ?> map) throws m, h {
        this.t.clear();
        this.w = false;
        try {
            return b(a(i2, aVar));
        } catch (m unused) {
            this.t.clear();
            this.w = true;
            return b(a(i2, aVar));
        }
    }

    public final void a() {
        this.t.clear();
        this.u.clear();
    }
}
