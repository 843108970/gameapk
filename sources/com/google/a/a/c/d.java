package com.google.a.a.c;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f2992a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: b  reason: collision with root package name */
    static final int f2993b = 0;

    /* renamed from: c  reason: collision with root package name */
    static final int f2994c = 1;
    static final int d = 2;
    static final int e = 3;
    static final int f = 4;
    static final int[][] g = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    static final int[][] h;
    private static final int[][] j;
    final byte[] i;

    static {
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{5, 256});
        j = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            j[0][i2] = (i2 - 65) + 2;
        }
        j[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            j[1][i3] = (i3 - 97) + 2;
        }
        j[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            j[2][i4] = (i4 - 48) + 2;
        }
        j[2][44] = 12;
        j[2][46] = 13;
        int[] iArr2 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            j[3][iArr2[i5]] = i5;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr3[i6] > 0) {
                j[4][iArr3[i6]] = i6;
            }
        }
        int[][] iArr4 = (int[][]) Array.newInstance(int.class, new int[]{6, 6});
        h = iArr4;
        for (int[] fill : iArr4) {
            Arrays.fill(fill, -1);
        }
        h[0][4] = 0;
        h[1][4] = 0;
        h[1][0] = 28;
        h[3][4] = 0;
        h[2][4] = 0;
        h[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.i = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.c.a a() {
        /*
            r13 = this;
            com.google.a.a.c.f r0 = com.google.a.a.c.f.f2997a
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r0
            r0 = 0
        L_0x0009:
            byte[] r3 = r13.i
            int r3 = r3.length
            if (r0 >= r3) goto L_0x00a4
            int r3 = r0 + 1
            byte[] r4 = r13.i
            int r4 = r4.length
            if (r3 >= r4) goto L_0x001a
            byte[] r4 = r13.i
            byte r4 = r4[r3]
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            byte[] r5 = r13.i
            byte r5 = r5[r0]
            r6 = 13
            r7 = 3
            r8 = 2
            r9 = 4
            if (r5 == r6) goto L_0x0042
            r6 = 44
            r10 = 32
            if (r5 == r6) goto L_0x003e
            r6 = 46
            if (r5 == r6) goto L_0x003a
            r6 = 58
            if (r5 == r6) goto L_0x0036
        L_0x0034:
            r4 = 0
            goto L_0x0047
        L_0x0036:
            if (r4 != r10) goto L_0x0034
            r4 = 5
            goto L_0x0047
        L_0x003a:
            if (r4 != r10) goto L_0x0034
            r4 = 3
            goto L_0x0047
        L_0x003e:
            if (r4 != r10) goto L_0x0034
            r4 = 4
            goto L_0x0047
        L_0x0042:
            r5 = 10
            if (r4 != r5) goto L_0x0034
            r4 = 2
        L_0x0047:
            r5 = 1
            if (r4 <= 0) goto L_0x009d
            java.util.LinkedList r6 = new java.util.LinkedList
            r6.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0053:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x0096
            java.lang.Object r10 = r2.next()
            com.google.a.a.c.f r10 = (com.google.a.a.c.f) r10
            com.google.a.a.c.f r11 = r10.b(r0)
            com.google.a.a.c.f r12 = r11.a(r9, r4)
            r6.add(r12)
            int r12 = r10.f2998b
            if (r12 == r9) goto L_0x0075
            com.google.a.a.c.f r12 = r11.b(r9, r4)
            r6.add(r12)
        L_0x0075:
            if (r4 == r7) goto L_0x0079
            if (r4 != r9) goto L_0x0086
        L_0x0079:
            int r12 = 16 - r4
            com.google.a.a.c.f r11 = r11.a(r8, r12)
            com.google.a.a.c.f r11 = r11.a(r8, r5)
            r6.add(r11)
        L_0x0086:
            int r11 = r10.f2999c
            if (r11 <= 0) goto L_0x0053
            com.google.a.a.c.f r10 = r10.a((int) r0)
            com.google.a.a.c.f r10 = r10.a((int) r3)
            r6.add(r10)
            goto L_0x0053
        L_0x0096:
            java.util.Collection r0 = a(r6)
            r2 = r0
            r0 = r3
            goto L_0x00a1
        L_0x009d:
            java.util.Collection r2 = r13.a(r2, r0)
        L_0x00a1:
            int r0 = r0 + r5
            goto L_0x0009
        L_0x00a4:
            com.google.a.a.c.d$1 r0 = new com.google.a.a.c.d$1
            r0.<init>()
            java.lang.Object r0 = java.util.Collections.min(r2, r0)
            com.google.a.a.c.f r0 = (com.google.a.a.c.f) r0
            byte[] r1 = r13.i
            com.google.a.c.a r0 = r0.a((byte[]) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.a.c.d.a():com.google.a.c.a");
    }

    static Collection<f> a(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f next : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.a(next)) {
                    z = false;
                    break;
                } else if (next.a(fVar)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(next);
            }
        }
        return linkedList;
    }

    private Collection<f> a(Iterable<f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        for (f a2 : iterable) {
            a(a2, i2, (Collection<f>) linkedList);
        }
        return a(linkedList);
    }

    static Collection<f> a(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        for (f next : iterable) {
            f b2 = next.b(i2);
            linkedList.add(b2.a(4, i3));
            if (next.f2998b != 4) {
                linkedList.add(b2.b(4, i3));
            }
            if (i3 == 3 || i3 == 4) {
                linkedList.add(b2.a(2, 16 - i3).a(2, 1));
            }
            if (next.f2999c > 0) {
                linkedList.add(next.a(i2).a(i2 + 1));
            }
        }
        return a(linkedList);
    }

    private static void a(f fVar, int i2, int i3, Collection<f> collection) {
        f b2 = fVar.b(i2);
        collection.add(b2.a(4, i3));
        if (fVar.f2998b != 4) {
            collection.add(b2.b(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(b2.a(2, 16 - i3).a(2, 1));
        }
        if (fVar.f2999c > 0) {
            collection.add(fVar.a(i2).a(i2 + 1));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.i[i2] & 255);
        boolean z = j[fVar.f2998b][c2] > 0;
        f fVar2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = j[i3][c2];
            if (i4 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i2);
                }
                if (!z || i3 == fVar.f2998b || i3 == 2) {
                    collection.add(fVar2.a(i3, i4));
                }
                if (!z && h[fVar.f2998b][i3] >= 0) {
                    collection.add(fVar2.b(i3, i4));
                }
            }
        }
        if (fVar.f2999c > 0 || j[fVar.f2998b][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }
}
