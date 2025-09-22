package com.google.a.g.a;

import com.google.a.c.a;
import com.google.a.m;
import com.google.a.r;
import com.google.a.t;
import com.google.a.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e extends a {
    private static final int[] g = {1, 10, 34, 70, 126};
    private static final int[] h = {4, 20, 48, 81};
    private static final int[] i = {0, 161, 961, 2015, 2715};
    private static final int[] j = {0, 336, 1036, 1516};
    private static final int[] k = {8, 6, 4, 3, 1};
    private static final int[] l = {2, 4, 6, 8};
    private static final int[][] m = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<d> n = new ArrayList();
    private final List<d> o = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        if (r4 < 4) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a1, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a4, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b7, code lost:
        if (r4 < 4) goto L_0x00a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149 A[LOOP:3: B:105:0x0147->B:106:0x0149, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x015a A[LOOP:4: B:108:0x0158->B:109:0x015a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.g.a.b a(com.google.a.c.a r19, com.google.a.g.a.c r20, boolean r21) throws com.google.a.m {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            int[] r4 = r0.f3152b
            r5 = 0
            r6 = 0
        L_0x000c:
            int r7 = r4.length
            if (r6 >= r7) goto L_0x0014
            r4[r6] = r5
            int r6 = r6 + 1
            goto L_0x000c
        L_0x0014:
            r6 = 1
            if (r3 == 0) goto L_0x001f
            int[] r2 = r2.f3185b
            r2 = r2[r5]
            b(r1, r2, r4)
            goto L_0x003a
        L_0x001f:
            int[] r2 = r2.f3185b
            r2 = r2[r6]
            int r2 = r2 + r6
            a((com.google.a.c.a) r1, (int) r2, (int[]) r4)
            int r1 = r4.length
            int r1 = r1 - r6
            r2 = r1
            r1 = 0
        L_0x002b:
            if (r1 >= r2) goto L_0x003a
            r7 = r4[r1]
            r8 = r4[r2]
            r4[r1] = r8
            r4[r2] = r7
            int r1 = r1 + 1
            int r2 = r2 + -1
            goto L_0x002b
        L_0x003a:
            if (r3 == 0) goto L_0x003f
            r1 = 16
            goto L_0x0041
        L_0x003f:
            r1 = 15
        L_0x0041:
            int r2 = com.google.a.c.a.a.a((int[]) r4)
            float r2 = (float) r2
            float r7 = (float) r1
            float r2 = r2 / r7
            int[] r7 = r0.e
            int[] r8 = r0.f
            float[] r9 = r0.f3153c
            float[] r10 = r0.d
            r11 = 0
        L_0x0051:
            int r12 = r4.length
            if (r11 >= r12) goto L_0x007c
            r12 = r4[r11]
            float r12 = (float) r12
            float r12 = r12 / r2
            r13 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 + r12
            int r13 = (int) r13
            r14 = 8
            if (r13 > 0) goto L_0x0062
            r13 = 1
            goto L_0x0066
        L_0x0062:
            if (r13 <= r14) goto L_0x0066
            r13 = 8
        L_0x0066:
            int r14 = r11 / 2
            r15 = r11 & 1
            if (r15 != 0) goto L_0x0073
            r7[r14] = r13
            float r13 = (float) r13
            float r12 = r12 - r13
            r9[r14] = r12
            goto L_0x0079
        L_0x0073:
            r8[r14] = r13
            float r13 = (float) r13
            float r12 = r12 - r13
            r10[r14] = r12
        L_0x0079:
            int r11 = r11 + 1
            goto L_0x0051
        L_0x007c:
            int[] r2 = r0.e
            int r2 = com.google.a.c.a.a.a((int[]) r2)
            int[] r4 = r0.f
            int r4 = com.google.a.c.a.a.a((int[]) r4)
            r9 = 10
            r10 = 12
            r11 = 4
            if (r3 == 0) goto L_0x00a6
            if (r2 <= r10) goto L_0x0094
            r12 = 0
            r13 = 1
            goto L_0x009a
        L_0x0094:
            if (r2 >= r11) goto L_0x0098
            r12 = 1
            goto L_0x0099
        L_0x0098:
            r12 = 0
        L_0x0099:
            r13 = 0
        L_0x009a:
            if (r4 <= r10) goto L_0x009f
        L_0x009c:
            r14 = 0
            r15 = 1
            goto L_0x00ba
        L_0x009f:
            if (r4 >= r11) goto L_0x00a3
        L_0x00a1:
            r14 = 1
            goto L_0x00a4
        L_0x00a3:
            r14 = 0
        L_0x00a4:
            r15 = 0
            goto L_0x00ba
        L_0x00a6:
            r12 = 11
            if (r2 <= r12) goto L_0x00ad
            r12 = 0
            r13 = 1
            goto L_0x00b4
        L_0x00ad:
            r12 = 5
            if (r2 >= r12) goto L_0x00b2
            r12 = 1
            goto L_0x00b3
        L_0x00b2:
            r12 = 0
        L_0x00b3:
            r13 = 0
        L_0x00b4:
            if (r4 <= r9) goto L_0x00b7
            goto L_0x009c
        L_0x00b7:
            if (r4 >= r11) goto L_0x00a3
            goto L_0x00a1
        L_0x00ba:
            int r16 = r2 + r4
            int r1 = r16 - r1
            r9 = r2 & 1
            if (r9 != r3) goto L_0x00c4
            r9 = 1
            goto L_0x00c5
        L_0x00c4:
            r9 = 0
        L_0x00c5:
            r5 = r4 & 1
            if (r5 != r6) goto L_0x00cb
            r5 = 1
            goto L_0x00cc
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            if (r1 != r6) goto L_0x00e2
            if (r9 == 0) goto L_0x00d9
            if (r5 == 0) goto L_0x00d7
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00d7:
            r13 = 1
            goto L_0x0111
        L_0x00d9:
            if (r5 != 0) goto L_0x00e0
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00e0:
            r15 = 1
            goto L_0x0111
        L_0x00e2:
            r11 = -1
            if (r1 != r11) goto L_0x00f9
            if (r9 == 0) goto L_0x00f0
            if (r5 == 0) goto L_0x00ee
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00ee:
            r12 = 1
            goto L_0x0111
        L_0x00f0:
            if (r5 != 0) goto L_0x00f7
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x00f7:
            r14 = 1
            goto L_0x0111
        L_0x00f9:
            if (r1 != 0) goto L_0x01d3
            if (r9 == 0) goto L_0x010a
            if (r5 != 0) goto L_0x0104
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0104:
            if (r2 >= r4) goto L_0x0108
            r12 = 1
            goto L_0x00e0
        L_0x0108:
            r13 = 1
            goto L_0x00f7
        L_0x010a:
            if (r5 == 0) goto L_0x0111
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0111:
            if (r12 == 0) goto L_0x0121
            if (r13 == 0) goto L_0x011a
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x011a:
            int[] r1 = r0.e
            float[] r2 = r0.f3153c
            a((int[]) r1, (float[]) r2)
        L_0x0121:
            if (r13 == 0) goto L_0x012a
            int[] r1 = r0.e
            float[] r2 = r0.f3153c
            b(r1, r2)
        L_0x012a:
            if (r14 == 0) goto L_0x013a
            if (r15 == 0) goto L_0x0133
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x0133:
            int[] r1 = r0.f
            float[] r2 = r0.f3153c
            a((int[]) r1, (float[]) r2)
        L_0x013a:
            if (r15 == 0) goto L_0x0143
            int[] r1 = r0.f
            float[] r2 = r0.d
            b(r1, r2)
        L_0x0143:
            int r1 = r7.length
            int r1 = r1 - r6
            r2 = 0
            r4 = 0
        L_0x0147:
            if (r1 < 0) goto L_0x0154
            int r2 = r2 * 9
            r5 = r7[r1]
            int r2 = r2 + r5
            r5 = r7[r1]
            int r4 = r4 + r5
            int r1 = r1 + -1
            goto L_0x0147
        L_0x0154:
            int r1 = r8.length
            int r1 = r1 - r6
            r5 = 0
            r9 = 0
        L_0x0158:
            if (r1 < 0) goto L_0x0165
            int r5 = r5 * 9
            r11 = r8[r1]
            int r5 = r5 + r11
            r11 = r8[r1]
            int r9 = r9 + r11
            int r1 = r1 + -1
            goto L_0x0158
        L_0x0165:
            int r5 = r5 * 3
            int r2 = r2 + r5
            if (r3 == 0) goto L_0x019d
            r1 = r4 & 1
            if (r1 != 0) goto L_0x0198
            if (r4 > r10) goto L_0x0198
            r1 = 4
            if (r4 >= r1) goto L_0x0174
            goto L_0x0198
        L_0x0174:
            int r10 = r10 - r4
            int r10 = r10 / 2
            int[] r1 = k
            r1 = r1[r10]
            int r3 = 9 - r1
            r4 = 0
            int r1 = com.google.a.g.a.f.a(r7, r1, r4)
            int r3 = com.google.a.g.a.f.a(r8, r3, r6)
            int[] r4 = g
            r4 = r4[r10]
            int[] r5 = i
            r5 = r5[r10]
            com.google.a.g.a.b r6 = new com.google.a.g.a.b
            int r1 = r1 * r4
            int r1 = r1 + r3
            int r1 = r1 + r5
            r6.<init>(r1, r2)
            return r6
        L_0x0198:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x019d:
            r1 = r9 & 1
            if (r1 != 0) goto L_0x01ce
            r1 = 10
            if (r9 > r1) goto L_0x01ce
            r3 = 4
            if (r9 >= r3) goto L_0x01a9
            goto L_0x01ce
        L_0x01a9:
            int r9 = 10 - r9
            int r9 = r9 / 2
            int[] r1 = l
            r1 = r1[r9]
            int r3 = 9 - r1
            int r1 = com.google.a.g.a.f.a(r7, r1, r6)
            r4 = 0
            int r3 = com.google.a.g.a.f.a(r8, r3, r4)
            int[] r4 = h
            r4 = r4[r9]
            int[] r5 = j
            r5 = r5[r9]
            com.google.a.g.a.b r6 = new com.google.a.g.a.b
            int r3 = r3 * r4
            int r3 = r3 + r1
            int r3 = r3 + r5
            r6.<init>(r3, r2)
            return r6
        L_0x01ce:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        L_0x01d3:
            com.google.a.m r1 = com.google.a.m.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.e.a(com.google.a.c.a, com.google.a.g.a.c, boolean):com.google.a.g.a.b");
    }

    private c a(a aVar, int i2, boolean z, int[] iArr) throws m {
        int i3;
        int i4;
        boolean a2 = aVar.a(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && a2 != aVar.a(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int[] iArr2 = this.f3151a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = iArr[0] - i6;
        int a3 = a(iArr2, m);
        int i7 = iArr[1];
        if (z) {
            i3 = (aVar.f3055b - 1) - i7;
            i4 = (aVar.f3055b - 1) - i6;
        } else {
            i3 = i7;
            i4 = i6;
        }
        return new c(a3, new int[]{i6, iArr[1]}, i4, i3, i2);
    }

    private d a(a aVar, boolean z, int i2, Map<com.google.a.e, ?> map) {
        int i3;
        int i4;
        a aVar2 = aVar;
        boolean z2 = z;
        Map<com.google.a.e, ?> map2 = map;
        try {
            int[] iArr = this.f3151a;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            int i5 = aVar2.f3055b;
            int i6 = 0;
            boolean z3 = false;
            while (i6 < i5) {
                z3 = !aVar2.a(i6);
                if (z2 == z3) {
                    break;
                }
                i6++;
            }
            int i7 = i6;
            int i8 = 0;
            while (i6 < i5) {
                if (aVar2.a(i6) != z3) {
                    iArr[i8] = iArr[i8] + 1;
                    int i9 = i2;
                } else {
                    if (i8 != 3) {
                        int i10 = i2;
                        i8++;
                    } else if (a(iArr)) {
                        int[] iArr2 = {i7, i6};
                        boolean a2 = aVar2.a(iArr2[0]);
                        int i11 = iArr2[0] - 1;
                        while (i11 >= 0 && a2 != aVar2.a(i11)) {
                            i11--;
                        }
                        int i12 = i11 + 1;
                        int[] iArr3 = this.f3151a;
                        System.arraycopy(iArr3, 0, iArr3, 1, iArr3.length - 1);
                        iArr3[0] = iArr2[0] - i12;
                        int a3 = a(iArr3, m);
                        int i13 = iArr2[1];
                        if (z2) {
                            i4 = (aVar2.f3055b - 1) - i12;
                            i3 = (aVar2.f3055b - 1) - i13;
                        } else {
                            i3 = i13;
                            i4 = i12;
                        }
                        c cVar = new c(a3, new int[]{i12, iArr2[1]}, i4, i3, i2);
                        if ((map2 == null ? null : (u) map2.get(com.google.a.e.NEED_RESULT_POINT_CALLBACK)) != null) {
                            float f = ((float) (iArr2[0] + iArr2[1])) / 2.0f;
                            if (z2) {
                                f = ((float) (aVar2.f3055b - 1)) - f;
                            }
                            new t(f, (float) i2);
                        }
                        b a4 = a(aVar2, cVar, true);
                        b a5 = a(aVar2, cVar, false);
                        return new d((a4.f3182a * 1597) + a5.f3182a, a4.f3183b + (a5.f3183b * 4), cVar);
                    } else {
                        int i14 = i2;
                        i7 += iArr[0] + iArr[1];
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = 0;
                        iArr[3] = 0;
                        i8--;
                    }
                    iArr[i8] = 1;
                    z3 = !z3;
                }
                i6++;
            }
            throw m.getNotFoundInstance();
        } catch (m unused) {
            return null;
        }
    }

    private static r a(d dVar, d dVar2) {
        String valueOf = String.valueOf((((long) dVar.f3182a) * 4537077) + ((long) dVar2.f3182a));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        t[] tVarArr = dVar.f3187c.f3186c;
        t[] tVarArr2 = dVar2.f3187c.f3186c;
        return new r(sb.toString(), (byte[]) null, new t[]{tVarArr[0], tVarArr[1], tVarArr2[0], tVarArr2[1]}, com.google.a.a.RSS_14);
    }

    private static void a(Collection<d> collection, d dVar) {
        if (dVar != null) {
            boolean z = false;
            Iterator<d> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                if (next.f3182a == dVar.f3182a) {
                    next.d++;
                    z = true;
                    break;
                }
            }
            if (!z) {
                collection.add(dVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        if (r1 < 4) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(boolean r10, int r11) throws com.google.a.m {
        /*
            r9 = this;
            int[] r0 = r9.e
            int r0 = com.google.a.c.a.a.a((int[]) r0)
            int[] r1 = r9.f
            int r1 = com.google.a.c.a.a.a((int[]) r1)
            r2 = 4
            r3 = 0
            r4 = 1
            if (r10 == 0) goto L_0x0031
            r5 = 12
            if (r0 <= r5) goto L_0x0018
            r6 = 1
        L_0x0016:
            r7 = 0
            goto L_0x001f
        L_0x0018:
            if (r0 >= r2) goto L_0x001d
            r6 = 0
            r7 = 1
            goto L_0x001f
        L_0x001d:
            r6 = 0
            goto L_0x0016
        L_0x001f:
            if (r1 <= r5) goto L_0x0026
            r5 = r6
            r6 = r7
        L_0x0023:
            r2 = 0
            r7 = 1
            goto L_0x0048
        L_0x0026:
            if (r1 >= r2) goto L_0x002c
            r5 = r6
            r6 = r7
        L_0x002a:
            r2 = 1
            goto L_0x002f
        L_0x002c:
            r5 = r6
            r6 = r7
        L_0x002e:
            r2 = 0
        L_0x002f:
            r7 = 0
            goto L_0x0048
        L_0x0031:
            r5 = 11
            if (r0 <= r5) goto L_0x0038
            r5 = 1
        L_0x0036:
            r6 = 0
            goto L_0x0040
        L_0x0038:
            r5 = 5
            if (r0 >= r5) goto L_0x003e
            r5 = 0
            r6 = 1
            goto L_0x0040
        L_0x003e:
            r5 = 0
            goto L_0x0036
        L_0x0040:
            r7 = 10
            if (r1 <= r7) goto L_0x0045
            goto L_0x0023
        L_0x0045:
            if (r1 >= r2) goto L_0x002e
            goto L_0x002a
        L_0x0048:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r10) goto L_0x0051
            r10 = 1
            goto L_0x0052
        L_0x0051:
            r10 = 0
        L_0x0052:
            r11 = r1 & 1
            if (r11 != r4) goto L_0x0057
            r3 = 1
        L_0x0057:
            if (r8 != r4) goto L_0x006d
            if (r10 == 0) goto L_0x0064
            if (r3 == 0) goto L_0x0062
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x0062:
            r5 = 1
            goto L_0x009c
        L_0x0064:
            if (r3 != 0) goto L_0x006b
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x006b:
            r7 = 1
            goto L_0x009c
        L_0x006d:
            r11 = -1
            if (r8 != r11) goto L_0x0084
            if (r10 == 0) goto L_0x007b
            if (r3 == 0) goto L_0x0079
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x0079:
            r6 = 1
            goto L_0x009c
        L_0x007b:
            if (r3 != 0) goto L_0x0082
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x0082:
            r2 = 1
            goto L_0x009c
        L_0x0084:
            if (r8 != 0) goto L_0x00cf
            if (r10 == 0) goto L_0x0095
            if (r3 != 0) goto L_0x008f
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x008f:
            if (r0 >= r1) goto L_0x0093
            r6 = 1
            goto L_0x006b
        L_0x0093:
            r2 = 1
            goto L_0x0062
        L_0x0095:
            if (r3 == 0) goto L_0x009c
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x009c:
            if (r6 == 0) goto L_0x00ac
            if (r5 == 0) goto L_0x00a5
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x00a5:
            int[] r10 = r9.e
            float[] r11 = r9.f3153c
            a((int[]) r10, (float[]) r11)
        L_0x00ac:
            if (r5 == 0) goto L_0x00b5
            int[] r10 = r9.e
            float[] r11 = r9.f3153c
            b(r10, r11)
        L_0x00b5:
            if (r2 == 0) goto L_0x00c5
            if (r7 == 0) goto L_0x00be
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        L_0x00be:
            int[] r10 = r9.f
            float[] r11 = r9.f3153c
            a((int[]) r10, (float[]) r11)
        L_0x00c5:
            if (r7 == 0) goto L_0x00ce
            int[] r10 = r9.f
            float[] r11 = r9.d
            b(r10, r11)
        L_0x00ce:
            return
        L_0x00cf:
            com.google.a.m r10 = com.google.a.m.getNotFoundInstance()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.a.e.a(boolean, int):void");
    }

    private int[] a(a aVar, boolean z) throws m {
        int[] iArr = this.f3151a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = aVar.f3055b;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            z2 = !aVar.a(i3);
            if (z == z2) {
                break;
            }
            i3++;
        }
        int i4 = i3;
        int i5 = 0;
        while (i3 < i2) {
            if (aVar.a(i3) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != 3) {
                    i5++;
                } else if (a(iArr)) {
                    return new int[]{i4, i3};
                } else {
                    i4 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i5--;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            i3++;
        }
        throw m.getNotFoundInstance();
    }

    private static boolean b(d dVar, d dVar2) {
        int i2 = (dVar.f3183b + (dVar2.f3183b * 16)) % 79;
        int i3 = (dVar.f3187c.f3184a * 9) + dVar2.f3187c.f3184a;
        if (i3 > 72) {
            i3--;
        }
        if (i3 > 8) {
            i3--;
        }
        return i2 == i3;
    }

    public final r a(int i2, a aVar, Map<com.google.a.e, ?> map) throws m {
        a((Collection<d>) this.n, a(aVar, false, i2, map));
        aVar.c();
        a((Collection<d>) this.o, a(aVar, true, i2, map));
        aVar.c();
        for (d next : this.n) {
            if (next.d > 1) {
                for (d next2 : this.o) {
                    if (next2.d > 1) {
                        int i3 = (next.f3183b + (next2.f3183b * 16)) % 79;
                        int i4 = (next.f3187c.f3184a * 9) + next2.f3187c.f3184a;
                        if (i4 > 72) {
                            i4--;
                        }
                        if (i4 > 8) {
                            i4--;
                        }
                        if (i3 == i4) {
                            String valueOf = String.valueOf((((long) next.f3182a) * 4537077) + ((long) next2.f3182a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - valueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(valueOf);
                            int i5 = 0;
                            for (int i6 = 0; i6 < 13; i6++) {
                                int charAt = sb.charAt(i6) - '0';
                                if ((i6 & 1) == 0) {
                                    charAt *= 3;
                                }
                                i5 += charAt;
                            }
                            int i7 = 10 - (i5 % 10);
                            if (i7 == 10) {
                                i7 = 0;
                            }
                            sb.append(i7);
                            t[] tVarArr = next.f3187c.f3186c;
                            t[] tVarArr2 = next2.f3187c.f3186c;
                            return new r(sb.toString(), (byte[]) null, new t[]{tVarArr[0], tVarArr[1], tVarArr2[0], tVarArr2[1]}, com.google.a.a.RSS_14);
                        }
                    }
                }
                continue;
            }
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
        this.n.clear();
        this.o.clear();
    }
}
