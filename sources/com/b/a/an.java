package com.b.a;

import com.b.a.a.b;

final class an extends b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f773a;

    /* renamed from: c  reason: collision with root package name */
    private final h f774c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(am amVar, h hVar) {
        super("OkHttp %s", amVar.b());
        this.f773a = amVar;
        this.f774c = hVar;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f773a.f772c.f775a.f750b;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037 A[SYNTHETIC, Splitter:B:15:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A[Catch:{ all -> 0x0030 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            com.b.a.am r2 = r7.f773a     // Catch:{ IOException -> 0x0032 }
            com.b.a.as r2 = r2.c()     // Catch:{ IOException -> 0x0032 }
            com.b.a.am r3 = r7.f773a     // Catch:{ IOException -> 0x0032 }
            com.b.a.a.c.k r3 = r3.f771b     // Catch:{ IOException -> 0x0032 }
            boolean r3 = r3.a()     // Catch:{ IOException -> 0x0032 }
            if (r3 == 0) goto L_0x0021
            com.b.a.h r1 = r7.f774c     // Catch:{ IOException -> 0x001f }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x001f }
            r1.a((java.io.IOException) r2)     // Catch:{ IOException -> 0x001f }
            goto L_0x0026
        L_0x001f:
            r1 = move-exception
            goto L_0x0035
        L_0x0021:
            com.b.a.h r1 = r7.f774c     // Catch:{ IOException -> 0x001f }
            r1.a((com.b.a.as) r2)     // Catch:{ IOException -> 0x001f }
        L_0x0026:
            com.b.a.am r0 = r7.f773a
            com.b.a.ai r0 = r0.f770a
            com.b.a.u r0 = r0.f763c
            r0.b((com.b.a.an) r7)
            return
        L_0x0030:
            r0 = move-exception
            goto L_0x0087
        L_0x0032:
            r0 = move-exception
            r1 = r0
            r0 = 0
        L_0x0035:
            if (r0 == 0) goto L_0x0081
            com.b.a.a.g.h r0 = com.b.a.a.g.h.b()     // Catch:{ all -> 0x0030 }
            r2 = 4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "Callback failure for "
            r3.<init>(r4)     // Catch:{ all -> 0x0030 }
            com.b.a.am r4 = r7.f773a     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r5.<init>()     // Catch:{ all -> 0x0030 }
            com.b.a.a.c.k r6 = r4.f771b     // Catch:{ all -> 0x0030 }
            boolean r6 = r6.a()     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x0055
            java.lang.String r6 = "canceled "
            goto L_0x0057
        L_0x0055:
            java.lang.String r6 = ""
        L_0x0057:
            r5.append(r6)     // Catch:{ all -> 0x0030 }
            boolean r6 = r4.d     // Catch:{ all -> 0x0030 }
            if (r6 == 0) goto L_0x0061
            java.lang.String r6 = "web socket"
            goto L_0x0063
        L_0x0061:
            java.lang.String r6 = "call"
        L_0x0063:
            r5.append(r6)     // Catch:{ all -> 0x0030 }
            java.lang.String r6 = " to "
            r5.append(r6)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0030 }
            r5.append(r4)     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0030 }
            r3.append(r4)     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0030 }
            r0.a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0030 }
            goto L_0x0026
        L_0x0081:
            com.b.a.h r0 = r7.f774c     // Catch:{ all -> 0x0030 }
            r0.a((java.io.IOException) r1)     // Catch:{ all -> 0x0030 }
            goto L_0x0026
        L_0x0087:
            com.b.a.am r1 = r7.f773a
            com.b.a.ai r1 = r1.f770a
            com.b.a.u r1 = r1.f763c
            r1.b((com.b.a.an) r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.an.b():void");
    }
}
