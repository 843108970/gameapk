package com.google.a.h.a;

import com.google.a.c.b;
import com.google.a.m;
import com.google.a.t;

final class c {

    /* renamed from: a  reason: collision with root package name */
    final b f3245a;

    /* renamed from: b  reason: collision with root package name */
    final t f3246b;

    /* renamed from: c  reason: collision with root package name */
    final t f3247c;
    final t d;
    final t e;
    final int f;
    final int g;
    final int h;
    final int i;

    c(b bVar, t tVar, t tVar2, t tVar3, t tVar4) throws m {
        boolean z = false;
        boolean z2 = tVar == null || tVar2 == null;
        z = (tVar3 == null || tVar4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                tVar = new t(0.0f, tVar3.f3357b);
                tVar2 = new t(0.0f, tVar4.f3357b);
            } else if (z) {
                tVar3 = new t((float) (bVar.f3061a - 1), tVar.f3357b);
                tVar4 = new t((float) (bVar.f3061a - 1), tVar2.f3357b);
            }
            this.f3245a = bVar;
            this.f3246b = tVar;
            this.f3247c = tVar2;
            this.d = tVar3;
            this.e = tVar4;
            this.f = (int) Math.min(tVar.f3356a, tVar2.f3356a);
            this.g = (int) Math.max(tVar3.f3356a, tVar4.f3356a);
            this.h = (int) Math.min(tVar.f3357b, tVar3.f3357b);
            this.i = (int) Math.max(tVar2.f3357b, tVar4.f3357b);
            return;
        }
        throw m.getNotFoundInstance();
    }

    c(c cVar) {
        this.f3245a = cVar.f3245a;
        this.f3246b = cVar.f3246b;
        this.f3247c = cVar.f3247c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
    }

    private int a() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.a.h.a.c a(int r13, int r14, boolean r15) throws com.google.a.m {
        /*
            r12 = this;
            com.google.a.t r0 = r12.f3246b
            com.google.a.t r1 = r12.f3247c
            com.google.a.t r2 = r12.d
            com.google.a.t r3 = r12.e
            if (r13 <= 0) goto L_0x0027
            if (r15 == 0) goto L_0x000f
            com.google.a.t r4 = r12.f3246b
            goto L_0x0011
        L_0x000f:
            com.google.a.t r4 = r12.d
        L_0x0011:
            float r5 = r4.f3357b
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L_0x0018
            r5 = 0
        L_0x0018:
            com.google.a.t r13 = new com.google.a.t
            float r4 = r4.f3356a
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L_0x0024
            r8 = r13
            goto L_0x0028
        L_0x0024:
            r10 = r13
            r8 = r0
            goto L_0x0029
        L_0x0027:
            r8 = r0
        L_0x0028:
            r10 = r2
        L_0x0029:
            if (r14 <= 0) goto L_0x0051
            if (r15 == 0) goto L_0x0030
            com.google.a.t r13 = r12.f3247c
            goto L_0x0032
        L_0x0030:
            com.google.a.t r13 = r12.e
        L_0x0032:
            float r0 = r13.f3357b
            int r0 = (int) r0
            int r0 = r0 + r14
            com.google.a.c.b r14 = r12.f3245a
            int r14 = r14.f3062b
            if (r0 < r14) goto L_0x0042
            com.google.a.c.b r14 = r12.f3245a
            int r14 = r14.f3062b
            int r0 = r14 + -1
        L_0x0042:
            com.google.a.t r14 = new com.google.a.t
            float r13 = r13.f3356a
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L_0x004e
            r9 = r14
            goto L_0x0052
        L_0x004e:
            r11 = r14
            r9 = r1
            goto L_0x0053
        L_0x0051:
            r9 = r1
        L_0x0052:
            r11 = r3
        L_0x0053:
            com.google.a.h.a.c r13 = new com.google.a.h.a.c
            com.google.a.c.b r7 = r12.f3245a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.c.a(int, int, boolean):com.google.a.h.a.c");
    }

    private static c a(c cVar, c cVar2) throws m {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f3245a, cVar.f3246b, cVar.f3247c, cVar2.d, cVar2.e);
    }

    private int b() {
        return this.g;
    }

    private int c() {
        return this.h;
    }

    private int d() {
        return this.i;
    }

    private t e() {
        return this.f3246b;
    }

    private t f() {
        return this.d;
    }

    private t g() {
        return this.f3247c;
    }

    private t h() {
        return this.e;
    }
}
