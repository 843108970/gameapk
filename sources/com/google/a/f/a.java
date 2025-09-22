package com.google.a.f;

import com.google.a.c;
import com.google.a.d;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.p;
import com.google.a.r;
import com.google.a.t;
import java.util.Map;

public final class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private final p f3141a;

    private a(p pVar) {
        this.f3141a = pVar;
    }

    private static void a(t[] tVarArr, int i, int i2) {
        if (tVarArr != null) {
            for (int i3 = 0; i3 < tVarArr.length; i3++) {
                t tVar = tVarArr[i3];
                tVarArr[i3] = new t(tVar.f3356a + ((float) i), tVar.f3357b + ((float) i2));
            }
        }
    }

    public final r a(c cVar) throws m, d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = r5.f3141a.a(r6.a(r0, r1, r0, r1), r7);
        a(r2.d, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        r2 = r0 / 2;
        r3 = r1 / 2;
        r6 = r5.f3141a.a(r6.a(r2, r3, r0, r1), r7);
        a(r6.d, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r3 = r5.f3141a.a(r6.a(r0, 0, r0, r1), r7);
        a(r3.d, r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3 = r5.f3141a.a(r6.a(0, r1, r0, r1), r7);
        a(r3.d, 0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        return r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0018 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.r a(com.google.a.c r6, java.util.Map<com.google.a.e, ?> r7) throws com.google.a.m, com.google.a.d, com.google.a.h {
        /*
            r5 = this;
            int r0 = r6.a()
            int r1 = r6.b()
            int r0 = r0 / 2
            int r1 = r1 / 2
            r2 = 0
            com.google.a.p r3 = r5.f3141a     // Catch:{ m -> 0x0018 }
            com.google.a.c r4 = r6.a(r2, r2, r0, r1)     // Catch:{ m -> 0x0018 }
            com.google.a.r r3 = r3.a(r4, r7)     // Catch:{ m -> 0x0018 }
            return r3
        L_0x0018:
            com.google.a.p r3 = r5.f3141a     // Catch:{ m -> 0x0028 }
            com.google.a.c r4 = r6.a(r0, r2, r0, r1)     // Catch:{ m -> 0x0028 }
            com.google.a.r r3 = r3.a(r4, r7)     // Catch:{ m -> 0x0028 }
            com.google.a.t[] r4 = r3.d     // Catch:{ m -> 0x0028 }
            a(r4, r0, r2)     // Catch:{ m -> 0x0028 }
            return r3
        L_0x0028:
            com.google.a.p r3 = r5.f3141a     // Catch:{ m -> 0x0038 }
            com.google.a.c r4 = r6.a(r2, r1, r0, r1)     // Catch:{ m -> 0x0038 }
            com.google.a.r r3 = r3.a(r4, r7)     // Catch:{ m -> 0x0038 }
            com.google.a.t[] r4 = r3.d     // Catch:{ m -> 0x0038 }
            a(r4, r2, r1)     // Catch:{ m -> 0x0038 }
            return r3
        L_0x0038:
            com.google.a.p r2 = r5.f3141a     // Catch:{ m -> 0x0048 }
            com.google.a.c r3 = r6.a(r0, r1, r0, r1)     // Catch:{ m -> 0x0048 }
            com.google.a.r r2 = r2.a(r3, r7)     // Catch:{ m -> 0x0048 }
            com.google.a.t[] r3 = r2.d     // Catch:{ m -> 0x0048 }
            a(r3, r0, r1)     // Catch:{ m -> 0x0048 }
            return r2
        L_0x0048:
            int r2 = r0 / 2
            int r3 = r1 / 2
            com.google.a.c r6 = r6.a(r2, r3, r0, r1)
            com.google.a.p r0 = r5.f3141a
            com.google.a.r r6 = r0.a(r6, r7)
            com.google.a.t[] r7 = r6.d
            a(r7, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.f.a.a(com.google.a.c, java.util.Map):com.google.a.r");
    }

    public final void a() {
        this.f3141a.a();
    }
}
