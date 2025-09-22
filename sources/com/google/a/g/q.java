package com.google.a.g;

import com.google.a.c.a;
import com.google.a.e;
import com.google.a.m;
import com.google.a.r;
import java.util.Collection;
import java.util.Map;

public final class q extends r {

    /* renamed from: a  reason: collision with root package name */
    private final y[] f3218a;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public q(java.util.Map<com.google.a.e, ?> r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 != 0) goto L_0x0007
            r3 = 0
            goto L_0x000f
        L_0x0007:
            com.google.a.e r0 = com.google.a.e.POSSIBLE_FORMATS
            java.lang.Object r3 = r3.get(r0)
            java.util.Collection r3 = (java.util.Collection) r3
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x0055
            com.google.a.a r1 = com.google.a.a.EAN_13
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0027
            com.google.a.g.i r1 = new com.google.a.g.i
            r1.<init>()
        L_0x0023:
            r0.add(r1)
            goto L_0x0035
        L_0x0027:
            com.google.a.a r1 = com.google.a.a.UPC_A
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0035
            com.google.a.g.t r1 = new com.google.a.g.t
            r1.<init>()
            goto L_0x0023
        L_0x0035:
            com.google.a.a r1 = com.google.a.a.EAN_8
            boolean r1 = r3.contains(r1)
            if (r1 == 0) goto L_0x0045
            com.google.a.g.k r1 = new com.google.a.g.k
            r1.<init>()
            r0.add(r1)
        L_0x0045:
            com.google.a.a r1 = com.google.a.a.UPC_E
            boolean r3 = r3.contains(r1)
            if (r3 == 0) goto L_0x0055
            com.google.a.g.aa r3 = new com.google.a.g.aa
            r3.<init>()
            r0.add(r3)
        L_0x0055:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0073
            com.google.a.g.i r3 = new com.google.a.g.i
            r3.<init>()
            r0.add(r3)
            com.google.a.g.k r3 = new com.google.a.g.k
            r3.<init>()
            r0.add(r3)
            com.google.a.g.aa r3 = new com.google.a.g.aa
            r3.<init>()
            r0.add(r3)
        L_0x0073:
            int r3 = r0.size()
            com.google.a.g.y[] r3 = new com.google.a.g.y[r3]
            java.lang.Object[] r3 = r0.toArray(r3)
            com.google.a.g.y[] r3 = (com.google.a.g.y[]) r3
            r2.f3218a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.g.q.<init>(java.util.Map):void");
    }

    public final r a(int i, a aVar, Map<e, ?> map) throws m {
        boolean z;
        int[] a2 = y.a(aVar);
        y[] yVarArr = this.f3218a;
        int i2 = 0;
        while (i2 < yVarArr.length) {
            try {
                r a3 = yVarArr[i2].a(i, aVar, a2, map);
                boolean z2 = a3.e == com.google.a.a.EAN_13 && a3.f3353a.charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(e.POSSIBLE_FORMATS);
                if (collection != null) {
                    if (!collection.contains(com.google.a.a.UPC_A)) {
                        z = false;
                        if (z2 || !z) {
                            return a3;
                        }
                        r rVar = new r(a3.f3353a.substring(1), a3.f3354b, a3.d, com.google.a.a.UPC_A);
                        rVar.a(a3.f);
                        return rVar;
                    }
                }
                z = true;
                if (z2) {
                }
                return a3;
            } catch (com.google.a.q unused) {
                i2++;
            }
        }
        throw m.getNotFoundInstance();
    }

    public final void a() {
        for (y a2 : this.f3218a) {
            a2.a();
        }
    }
}
