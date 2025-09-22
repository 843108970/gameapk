package com.google.a.i.b;

import com.google.a.m;
import com.google.a.t;
import com.google.a.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f3323a = 3;

    /* renamed from: b  reason: collision with root package name */
    protected static final int f3324b = 97;
    private static final int e = 2;

    /* renamed from: c  reason: collision with root package name */
    protected final com.google.a.c.b f3325c;
    protected final List<d> d;
    private boolean f;
    private final int[] g;
    private final u h;

    private static final class a implements Serializable, Comparator<d> {
        private final float average;

        private a(float f) {
            this.average = f;
        }

        public final int compare(d dVar, d dVar2) {
            int compare = Integer.compare(dVar2.d, dVar.d);
            return compare == 0 ? Float.compare(Math.abs(dVar.f3322c - this.average), Math.abs(dVar2.f3322c - this.average)) : compare;
        }
    }

    private static final class b implements Serializable, Comparator<d> {
        private final float average;

        private b(float f) {
            this.average = f;
        }

        public final int compare(d dVar, d dVar2) {
            return Float.compare(Math.abs(dVar2.f3322c - this.average), Math.abs(dVar.f3322c - this.average));
        }
    }

    public e(com.google.a.c.b bVar) {
        this(bVar, (u) null);
    }

    public e(com.google.a.c.b bVar, u uVar) {
        this.f3325c = bVar;
        this.d = new ArrayList();
        this.g = new int[5];
        this.h = uVar;
    }

    private float a(int i, int i2, int i3, int i4) {
        com.google.a.c.b bVar = this.f3325c;
        int i5 = bVar.f3062b;
        int[] c2 = c();
        int i6 = i;
        while (i6 >= 0 && bVar.a(i2, i6)) {
            c2[2] = c2[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.a(i2, i6) && c2[1] <= i3) {
            c2[1] = c2[1] + 1;
            i6--;
        }
        if (i6 < 0 || c2[1] > i3) {
            return Float.NaN;
        }
        while (i6 >= 0 && bVar.a(i2, i6) && c2[0] <= i3) {
            c2[0] = c2[0] + 1;
            i6--;
        }
        if (c2[0] > i3) {
            return Float.NaN;
        }
        int i7 = i + 1;
        while (i7 < i5 && bVar.a(i2, i7)) {
            c2[2] = c2[2] + 1;
            i7++;
        }
        if (i7 == i5) {
            return Float.NaN;
        }
        while (i7 < i5 && !bVar.a(i2, i7) && c2[3] < i3) {
            c2[3] = c2[3] + 1;
            i7++;
        }
        if (i7 == i5 || c2[3] >= i3) {
            return Float.NaN;
        }
        while (i7 < i5 && bVar.a(i2, i7) && c2[4] < i3) {
            c2[4] = c2[4] + 1;
            i7++;
        }
        if (c2[4] < i3 && Math.abs(((((c2[0] + c2[1]) + c2[2]) + c2[3]) + c2[4]) - i4) * 5 < i4 * 2 && a(c2)) {
            return a(c2, i7);
        }
        return Float.NaN;
    }

    private static float a(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    private com.google.a.c.b a() {
        return this.f3325c;
    }

    private boolean a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] c2 = c();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.f3325c.a(i2 - i6, i - i6)) {
            c2[2] = c2[2] + 1;
            i6++;
        }
        if (c2[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.f3325c.a(i2 - i6, i - i6)) {
            c2[1] = c2[1] + 1;
            i6++;
        }
        if (c2[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.f3325c.a(i2 - i6, i - i6)) {
            c2[0] = c2[0] + 1;
            i6++;
        }
        if (c2[0] == 0) {
            return false;
        }
        int i7 = this.f3325c.f3062b;
        int i8 = this.f3325c.f3061a;
        int i9 = 1;
        while (true) {
            int i10 = i + i9;
            if (i10 < i7 && (i5 = i2 + i9) < i8 && this.f3325c.a(i5, i10)) {
                c2[2] = c2[2] + 1;
                i9++;
            }
        }
        while (true) {
            int i11 = i + i9;
            if (i11 < i7 && (i4 = i2 + i9) < i8 && !this.f3325c.a(i4, i11)) {
                c2[3] = c2[3] + 1;
                i9++;
            }
        }
        if (c2[3] == 0) {
            return false;
        }
        while (true) {
            int i12 = i + i9;
            if (i12 < i7 && (i3 = i2 + i9) < i8 && this.f3325c.a(i3, i12)) {
                c2[4] = c2[4] + 1;
                i9++;
            }
        }
        if (c2[4] == 0) {
            return false;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 < 5) {
                int i15 = c2[i13];
                if (i15 == 0) {
                    break;
                }
                i14 += i15;
                i13++;
            } else if (i14 >= 7) {
                float f2 = ((float) i14) / 7.0f;
                float f3 = f2 / 1.333f;
                return Math.abs(f2 - ((float) c2[0])) < f3 && Math.abs(f2 - ((float) c2[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) c2[2])) < 3.0f * f3 && Math.abs(f2 - ((float) c2[3])) < f3 && Math.abs(f2 - ((float) c2[4])) < f3;
            }
        }
    }

    protected static boolean a(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = ((float) i) / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private float b(int i, int i2, int i3, int i4) {
        com.google.a.c.b bVar = this.f3325c;
        int i5 = bVar.f3061a;
        int[] c2 = c();
        int i6 = i;
        while (i6 >= 0 && bVar.a(i6, i2)) {
            c2[2] = c2[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bVar.a(i6, i2) && c2[1] <= i3) {
            c2[1] = c2[1] + 1;
            i6--;
        }
        if (i6 < 0 || c2[1] > i3) {
            return Float.NaN;
        }
        while (i6 >= 0 && bVar.a(i6, i2) && c2[0] <= i3) {
            c2[0] = c2[0] + 1;
            i6--;
        }
        if (c2[0] > i3) {
            return Float.NaN;
        }
        int i7 = i + 1;
        while (i7 < i5 && bVar.a(i7, i2)) {
            c2[2] = c2[2] + 1;
            i7++;
        }
        if (i7 == i5) {
            return Float.NaN;
        }
        while (i7 < i5 && !bVar.a(i7, i2) && c2[3] < i3) {
            c2[3] = c2[3] + 1;
            i7++;
        }
        if (i7 == i5 || c2[3] >= i3) {
            return Float.NaN;
        }
        while (i7 < i5 && bVar.a(i7, i2) && c2[4] < i3) {
            c2[4] = c2[4] + 1;
            i7++;
        }
        if (c2[4] < i3 && Math.abs(((((c2[0] + c2[1]) + c2[2]) + c2[3]) + c2[4]) - i4) * 5 < i4 && a(c2)) {
            return a(c2, i7);
        }
        return Float.NaN;
    }

    private List<d> b() {
        return this.d;
    }

    protected static void b(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
    }

    @Deprecated
    private boolean b(int[] iArr, int i, int i2) {
        return a(iArr, i, i2);
    }

    protected static void c(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private int[] c() {
        b(this.g);
        return this.g;
    }

    private int d() {
        if (this.d.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d next : this.d) {
            if (next.d >= 2) {
                if (dVar == null) {
                    dVar = next;
                } else {
                    this.f = true;
                    return ((int) (Math.abs(dVar.f3356a - next.f3356a) - Math.abs(dVar.f3357b - next.f3357b))) / 2;
                }
            }
        }
        return 0;
    }

    private static boolean d(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = ((float) i) / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private boolean e() {
        int size = this.d.size();
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        for (d next : this.d) {
            if (next.d >= 2) {
                i++;
                f3 += next.f3322c;
            }
        }
        if (i < 3) {
            return false;
        }
        float f4 = f3 / ((float) size);
        for (d dVar : this.d) {
            f2 += Math.abs(dVar.f3322c - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    private d[] f() throws m {
        int size = this.d.size();
        if (size < 3) {
            throw m.getNotFoundInstance();
        }
        float f2 = 0.0f;
        if (size > 3) {
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (d dVar : this.d) {
                float f5 = dVar.f3322c;
                f3 += f5;
                f4 += f5 * f5;
            }
            float f6 = (float) size;
            float f7 = f3 / f6;
            float sqrt = (float) Math.sqrt((double) ((f4 / f6) - (f7 * f7)));
            Collections.sort(this.d, new b(f7));
            float max = Math.max(0.2f * f7, sqrt);
            int i = 0;
            while (i < this.d.size() && this.d.size() > 3) {
                if (Math.abs(this.d.get(i).f3322c - f7) > max) {
                    this.d.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.d.size() > 3) {
            for (d dVar2 : this.d) {
                f2 += dVar2.f3322c;
            }
            Collections.sort(this.d, new a(f2 / ((float) this.d.size())));
            this.d.subList(3, this.d.size()).clear();
        }
        return new d[]{this.d.get(0), this.d.get(1), this.d.get(2)};
    }

    /* access modifiers changed from: package-private */
    public final f a(Map<com.google.a.e, ?> map) throws m {
        int i;
        Map<com.google.a.e, ?> map2 = map;
        boolean z = map2 != null && map2.containsKey(com.google.a.e.TRY_HARDER);
        int i2 = this.f3325c.f3062b;
        int i3 = this.f3325c.f3061a;
        int i4 = (i2 * 3) / 388;
        if (i4 < 3 || z) {
            i4 = 3;
        }
        int[] iArr = new int[5];
        int i5 = i4 - 1;
        int i6 = i4;
        boolean z2 = false;
        while (i5 < i2 && !z2) {
            b(iArr);
            boolean z3 = z2;
            int i7 = i6;
            int i8 = 0;
            int i9 = 0;
            while (i8 < i3) {
                if (this.f3325c.a(i8, i5)) {
                    if ((i9 & 1) == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if ((i9 & 1) != 0) {
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 != 4) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else if (!a(iArr) || !a(iArr, i5, i8)) {
                    c(iArr);
                    i9 = 3;
                } else {
                    if (this.f) {
                        z3 = e();
                    } else {
                        if (this.d.size() > 1) {
                            Iterator<d> it = this.d.iterator();
                            d dVar = null;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                d next = it.next();
                                if (next.d >= 2) {
                                    if (dVar != null) {
                                        this.f = true;
                                        i = ((int) (Math.abs(dVar.f3356a - next.f3356a) - Math.abs(dVar.f3357b - next.f3357b))) / 2;
                                        break;
                                    }
                                    dVar = next;
                                }
                            }
                        }
                        i = 0;
                        if (i > iArr[2]) {
                            i5 += (i - iArr[2]) - 2;
                            i8 = i3 - 1;
                        }
                    }
                    b(iArr);
                    i9 = 0;
                    i7 = 2;
                }
                i8++;
            }
            if (!a(iArr) || !a(iArr, i5, i3)) {
                i6 = i7;
            } else {
                int i10 = iArr[0];
                if (this.f) {
                    i6 = i10;
                    z2 = e();
                    i5 += i6;
                } else {
                    i6 = i10;
                }
            }
            z2 = z3;
            i5 += i6;
        }
        int size = this.d.size();
        if (size < 3) {
            throw m.getNotFoundInstance();
        }
        float f2 = 0.0f;
        if (size > 3) {
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (d dVar2 : this.d) {
                float f5 = dVar2.f3322c;
                f3 += f5;
                f4 += f5 * f5;
            }
            float f6 = (float) size;
            float f7 = f3 / f6;
            float sqrt = (float) Math.sqrt((double) ((f4 / f6) - (f7 * f7)));
            Collections.sort(this.d, new b(f7));
            float max = Math.max(0.2f * f7, sqrt);
            int i11 = 0;
            while (i11 < this.d.size() && this.d.size() > 3) {
                if (Math.abs(this.d.get(i11).f3322c - f7) > max) {
                    this.d.remove(i11);
                    i11--;
                }
                i11++;
            }
        }
        if (this.d.size() > 3) {
            for (d dVar3 : this.d) {
                f2 += dVar3.f3322c;
            }
            Collections.sort(this.d, new a(f2 / ((float) this.d.size())));
            this.d.subList(3, this.d.size()).clear();
        }
        d[] dVarArr = {this.d.get(0), this.d.get(1), this.d.get(2)};
        t.a(dVarArr);
        return new f(dVarArr);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0343 A[LOOP:19: B:178:0x02d6->B:192:0x0343, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0317 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:252:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int[] r20, int r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 0
            r3 = r1[r2]
            r4 = 1
            r5 = r1[r4]
            int r3 = r3 + r5
            r5 = 2
            r6 = r1[r5]
            int r3 = r3 + r6
            r6 = 3
            r7 = r1[r6]
            int r3 = r3 + r7
            r7 = 4
            r8 = r1[r7]
            int r3 = r3 + r8
            r8 = r22
            float r8 = a((int[]) r1, (int) r8)
            int r8 = (int) r8
            r9 = r1[r5]
            com.google.a.c.b r10 = r0.f3325c
            int r11 = r10.f3062b
            int[] r12 = r19.c()
            r13 = r21
        L_0x002a:
            if (r13 < 0) goto L_0x003a
            boolean r14 = r10.a((int) r8, (int) r13)
            if (r14 == 0) goto L_0x003a
            r14 = r12[r5]
            int r14 = r14 + r4
            r12[r5] = r14
            int r13 = r13 + -1
            goto L_0x002a
        L_0x003a:
            r14 = 5
            if (r13 >= 0) goto L_0x0041
        L_0x003d:
            r15 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x00e4
        L_0x0041:
            if (r13 < 0) goto L_0x0055
            boolean r16 = r10.a((int) r8, (int) r13)
            if (r16 != 0) goto L_0x0055
            r15 = r12[r4]
            if (r15 > r9) goto L_0x0055
            r15 = r12[r4]
            int r15 = r15 + r4
            r12[r4] = r15
            int r13 = r13 + -1
            goto L_0x0041
        L_0x0055:
            if (r13 < 0) goto L_0x003d
            r15 = r12[r4]
            if (r15 <= r9) goto L_0x005c
            goto L_0x003d
        L_0x005c:
            if (r13 < 0) goto L_0x0070
            boolean r15 = r10.a((int) r8, (int) r13)
            if (r15 == 0) goto L_0x0070
            r15 = r12[r2]
            if (r15 > r9) goto L_0x0070
            r15 = r12[r2]
            int r15 = r15 + r4
            r12[r2] = r15
            int r13 = r13 + -1
            goto L_0x005c
        L_0x0070:
            r13 = r12[r2]
            if (r13 <= r9) goto L_0x0075
            goto L_0x003d
        L_0x0075:
            int r13 = r21 + 1
        L_0x0077:
            if (r13 >= r11) goto L_0x0087
            boolean r15 = r10.a((int) r8, (int) r13)
            if (r15 == 0) goto L_0x0087
            r15 = r12[r5]
            int r15 = r15 + r4
            r12[r5] = r15
            int r13 = r13 + 1
            goto L_0x0077
        L_0x0087:
            if (r13 != r11) goto L_0x008a
            goto L_0x003d
        L_0x008a:
            if (r13 >= r11) goto L_0x009e
            boolean r15 = r10.a((int) r8, (int) r13)
            if (r15 != 0) goto L_0x009e
            r15 = r12[r6]
            if (r15 >= r9) goto L_0x009e
            r15 = r12[r6]
            int r15 = r15 + r4
            r12[r6] = r15
            int r13 = r13 + 1
            goto L_0x008a
        L_0x009e:
            if (r13 == r11) goto L_0x003d
            r15 = r12[r6]
            if (r15 < r9) goto L_0x00a5
            goto L_0x003d
        L_0x00a5:
            if (r13 >= r11) goto L_0x00b9
            boolean r15 = r10.a((int) r8, (int) r13)
            if (r15 == 0) goto L_0x00b9
            r15 = r12[r7]
            if (r15 >= r9) goto L_0x00b9
            r15 = r12[r7]
            int r15 = r15 + r4
            r12[r7] = r15
            int r13 = r13 + 1
            goto L_0x00a5
        L_0x00b9:
            r10 = r12[r7]
            if (r10 < r9) goto L_0x00bf
            goto L_0x003d
        L_0x00bf:
            r9 = r12[r2]
            r10 = r12[r4]
            int r9 = r9 + r10
            r10 = r12[r5]
            int r9 = r9 + r10
            r10 = r12[r6]
            int r9 = r9 + r10
            r10 = r12[r7]
            int r9 = r9 + r10
            int r9 = r9 - r3
            int r9 = java.lang.Math.abs(r9)
            int r9 = r9 * 5
            int r10 = r3 * 2
            if (r9 < r10) goto L_0x00da
            goto L_0x003d
        L_0x00da:
            boolean r9 = a((int[]) r12)
            if (r9 == 0) goto L_0x003d
            float r15 = a((int[]) r12, (int) r13)
        L_0x00e4:
            boolean r9 = java.lang.Float.isNaN(r15)
            if (r9 != 0) goto L_0x0355
            int r9 = (int) r15
            r1 = r1[r5]
            com.google.a.c.b r10 = r0.f3325c
            int r11 = r10.f3061a
            int[] r12 = r19.c()
            r13 = r8
        L_0x00f6:
            if (r13 < 0) goto L_0x0107
            boolean r16 = r10.a((int) r13, (int) r9)
            if (r16 == 0) goto L_0x0107
            r16 = r12[r5]
            int r16 = r16 + 1
            r12[r5] = r16
            int r13 = r13 + -1
            goto L_0x00f6
        L_0x0107:
            if (r13 >= 0) goto L_0x010d
        L_0x0109:
            r1 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x01af
        L_0x010d:
            if (r13 < 0) goto L_0x0122
            boolean r16 = r10.a((int) r13, (int) r9)
            if (r16 != 0) goto L_0x0122
            r14 = r12[r4]
            if (r14 > r1) goto L_0x0122
            r14 = r12[r4]
            int r14 = r14 + r4
            r12[r4] = r14
            int r13 = r13 + -1
            r14 = 5
            goto L_0x010d
        L_0x0122:
            if (r13 < 0) goto L_0x0109
            r14 = r12[r4]
            if (r14 <= r1) goto L_0x0129
            goto L_0x0109
        L_0x0129:
            if (r13 < 0) goto L_0x013d
            boolean r14 = r10.a((int) r13, (int) r9)
            if (r14 == 0) goto L_0x013d
            r14 = r12[r2]
            if (r14 > r1) goto L_0x013d
            r14 = r12[r2]
            int r14 = r14 + r4
            r12[r2] = r14
            int r13 = r13 + -1
            goto L_0x0129
        L_0x013d:
            r13 = r12[r2]
            if (r13 <= r1) goto L_0x0142
            goto L_0x0109
        L_0x0142:
            int r8 = r8 + r4
        L_0x0143:
            if (r8 >= r11) goto L_0x0153
            boolean r13 = r10.a((int) r8, (int) r9)
            if (r13 == 0) goto L_0x0153
            r13 = r12[r5]
            int r13 = r13 + r4
            r12[r5] = r13
            int r8 = r8 + 1
            goto L_0x0143
        L_0x0153:
            if (r8 != r11) goto L_0x0156
            goto L_0x0109
        L_0x0156:
            if (r8 >= r11) goto L_0x016a
            boolean r13 = r10.a((int) r8, (int) r9)
            if (r13 != 0) goto L_0x016a
            r13 = r12[r6]
            if (r13 >= r1) goto L_0x016a
            r13 = r12[r6]
            int r13 = r13 + r4
            r12[r6] = r13
            int r8 = r8 + 1
            goto L_0x0156
        L_0x016a:
            if (r8 == r11) goto L_0x0109
            r13 = r12[r6]
            if (r13 < r1) goto L_0x0171
            goto L_0x0109
        L_0x0171:
            if (r8 >= r11) goto L_0x0185
            boolean r13 = r10.a((int) r8, (int) r9)
            if (r13 == 0) goto L_0x0185
            r13 = r12[r7]
            if (r13 >= r1) goto L_0x0185
            r13 = r12[r7]
            int r13 = r13 + r4
            r12[r7] = r13
            int r8 = r8 + 1
            goto L_0x0171
        L_0x0185:
            r10 = r12[r7]
            if (r10 < r1) goto L_0x018b
            goto L_0x0109
        L_0x018b:
            r1 = r12[r2]
            r10 = r12[r4]
            int r1 = r1 + r10
            r10 = r12[r5]
            int r1 = r1 + r10
            r10 = r12[r6]
            int r1 = r1 + r10
            r10 = r12[r7]
            int r1 = r1 + r10
            int r1 = r1 - r3
            int r1 = java.lang.Math.abs(r1)
            r10 = 5
            int r1 = r1 * 5
            if (r1 < r3) goto L_0x01a5
            goto L_0x0109
        L_0x01a5:
            boolean r1 = a((int[]) r12)
            if (r1 == 0) goto L_0x0109
            float r1 = a((int[]) r12, (int) r8)
        L_0x01af:
            boolean r8 = java.lang.Float.isNaN(r1)
            if (r8 != 0) goto L_0x0355
            int r8 = (int) r1
            int[] r10 = r19.c()
            r11 = 0
        L_0x01bb:
            if (r9 < r11) goto L_0x01d3
            if (r8 < r11) goto L_0x01d3
            com.google.a.c.b r12 = r0.f3325c
            int r13 = r8 - r11
            int r14 = r9 - r11
            boolean r12 = r12.a((int) r13, (int) r14)
            if (r12 == 0) goto L_0x01d3
            r12 = r10[r5]
            int r12 = r12 + r4
            r10[r5] = r12
            int r11 = r11 + 1
            goto L_0x01bb
        L_0x01d3:
            r12 = r10[r5]
            if (r12 == 0) goto L_0x02ce
        L_0x01d7:
            if (r9 < r11) goto L_0x01ef
            if (r8 < r11) goto L_0x01ef
            com.google.a.c.b r12 = r0.f3325c
            int r14 = r8 - r11
            int r13 = r9 - r11
            boolean r12 = r12.a((int) r14, (int) r13)
            if (r12 != 0) goto L_0x01ef
            r12 = r10[r4]
            int r12 = r12 + r4
            r10[r4] = r12
            int r11 = r11 + 1
            goto L_0x01d7
        L_0x01ef:
            r12 = r10[r4]
            if (r12 == 0) goto L_0x02ce
        L_0x01f3:
            if (r9 < r11) goto L_0x020b
            if (r8 < r11) goto L_0x020b
            com.google.a.c.b r12 = r0.f3325c
            int r13 = r8 - r11
            int r14 = r9 - r11
            boolean r12 = r12.a((int) r13, (int) r14)
            if (r12 == 0) goto L_0x020b
            r12 = r10[r2]
            int r12 = r12 + r4
            r10[r2] = r12
            int r11 = r11 + 1
            goto L_0x01f3
        L_0x020b:
            r11 = r10[r2]
            if (r11 == 0) goto L_0x02ce
            com.google.a.c.b r11 = r0.f3325c
            int r11 = r11.f3062b
            com.google.a.c.b r12 = r0.f3325c
            int r12 = r12.f3061a
            r13 = 1
        L_0x0218:
            int r14 = r9 + r13
            if (r14 >= r11) goto L_0x0232
            int r2 = r8 + r13
            if (r2 >= r12) goto L_0x0232
            com.google.a.c.b r7 = r0.f3325c
            boolean r2 = r7.a((int) r2, (int) r14)
            if (r2 == 0) goto L_0x0232
            r2 = r10[r5]
            int r2 = r2 + r4
            r10[r5] = r2
            int r13 = r13 + 1
            r2 = 0
            r7 = 4
            goto L_0x0218
        L_0x0232:
            int r2 = r9 + r13
            if (r2 >= r11) goto L_0x024a
            int r7 = r8 + r13
            if (r7 >= r12) goto L_0x024a
            com.google.a.c.b r14 = r0.f3325c
            boolean r2 = r14.a((int) r7, (int) r2)
            if (r2 != 0) goto L_0x024a
            r2 = r10[r6]
            int r2 = r2 + r4
            r10[r6] = r2
            int r13 = r13 + 1
            goto L_0x0232
        L_0x024a:
            r2 = r10[r6]
            if (r2 == 0) goto L_0x02ce
        L_0x024e:
            int r2 = r9 + r13
            if (r2 >= r11) goto L_0x0267
            int r7 = r8 + r13
            if (r7 >= r12) goto L_0x0267
            com.google.a.c.b r14 = r0.f3325c
            boolean r2 = r14.a((int) r7, (int) r2)
            if (r2 == 0) goto L_0x0267
            r2 = 4
            r7 = r10[r2]
            int r7 = r7 + r4
            r10[r2] = r7
            int r13 = r13 + 1
            goto L_0x024e
        L_0x0267:
            r2 = 4
            r7 = r10[r2]
            if (r7 == 0) goto L_0x02ce
            r2 = 0
            r7 = 0
            r8 = 5
        L_0x026f:
            if (r2 >= r8) goto L_0x0279
            r9 = r10[r2]
            if (r9 == 0) goto L_0x02ce
            int r7 = r7 + r9
            int r2 = r2 + 1
            goto L_0x026f
        L_0x0279:
            r2 = 7
            if (r7 < r2) goto L_0x02ce
            float r2 = (float) r7
            r7 = 1088421888(0x40e00000, float:7.0)
            float r2 = r2 / r7
            r7 = 1068146622(0x3faa9fbe, float:1.333)
            float r7 = r2 / r7
            r8 = 0
            r9 = r10[r8]
            float r8 = (float) r9
            float r8 = r2 - r8
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x02ce
            r8 = r10[r4]
            float r8 = (float) r8
            float r8 = r2 - r8
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x02ce
            r8 = 1077936128(0x40400000, float:3.0)
            float r9 = r2 * r8
            r5 = r10[r5]
            float r5 = (float) r5
            float r9 = r9 - r5
            float r5 = java.lang.Math.abs(r9)
            float r8 = r8 * r7
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x02ce
            r5 = r10[r6]
            float r5 = (float) r5
            float r5 = r2 - r5
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x02ce
            r5 = 4
            r5 = r10[r5]
            float r5 = (float) r5
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x02ce
            r2 = 1
            goto L_0x02cf
        L_0x02ce:
            r2 = 0
        L_0x02cf:
            if (r2 == 0) goto L_0x0355
            float r2 = (float) r3
            r3 = 1088421888(0x40e00000, float:7.0)
            float r2 = r2 / r3
            r3 = 0
        L_0x02d6:
            java.util.List<com.google.a.i.b.d> r5 = r0.d
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x0346
            java.util.List<com.google.a.i.b.d> r5 = r0.d
            java.lang.Object r5 = r5.get(r3)
            com.google.a.i.b.d r5 = (com.google.a.i.b.d) r5
            float r6 = r5.f3357b
            float r6 = r15 - r6
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0314
            float r6 = r5.f3356a
            float r6 = r1 - r6
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0314
            float r6 = r5.f3322c
            float r6 = r2 - r6
            float r6 = java.lang.Math.abs(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0312
            float r7 = r5.f3322c
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x0314
        L_0x0312:
            r6 = 1
            goto L_0x0315
        L_0x0314:
            r6 = 0
        L_0x0315:
            if (r6 == 0) goto L_0x0343
            java.util.List<com.google.a.i.b.d> r6 = r0.d
            int r7 = r5.d
            int r7 = r7 + r4
            int r8 = r5.d
            float r8 = (float) r8
            float r9 = r5.f3356a
            float r8 = r8 * r9
            float r8 = r8 + r1
            float r9 = (float) r7
            float r8 = r8 / r9
            int r10 = r5.d
            float r10 = (float) r10
            float r11 = r5.f3357b
            float r10 = r10 * r11
            float r10 = r10 + r15
            float r10 = r10 / r9
            int r11 = r5.d
            float r11 = (float) r11
            float r5 = r5.f3322c
            float r11 = r11 * r5
            float r11 = r11 + r2
            float r11 = r11 / r9
            com.google.a.i.b.d r5 = new com.google.a.i.b.d
            r5.<init>(r8, r10, r11, r7)
            r6.set(r3, r5)
            r17 = 1
            goto L_0x0348
        L_0x0343:
            int r3 = r3 + 1
            goto L_0x02d6
        L_0x0346:
            r17 = 0
        L_0x0348:
            if (r17 != 0) goto L_0x0354
            com.google.a.i.b.d r3 = new com.google.a.i.b.d
            r3.<init>(r1, r15, r2)
            java.util.List<com.google.a.i.b.d> r1 = r0.d
            r1.add(r3)
        L_0x0354:
            return r4
        L_0x0355:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.i.b.e.a(int[], int, int):boolean");
    }
}
