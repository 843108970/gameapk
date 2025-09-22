package com.goldcoast.sdk.domain;

import android.os.ConditionVariable;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ConditionVariable f2956a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ EntryPoint f2957b;

    b(EntryPoint entryPoint, ConditionVariable conditionVariable) {
        this.f2957b = entryPoint;
        this.f2956a = conditionVariable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            com.goldcoast.sdk.domain.EntryPoint r0 = r5.f2957b
            boolean unused = r0.C = false
            java.lang.String r0 = "timeout"
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = com.goldcoast.sdk.domain.EntryPoint.j
            if (r2 >= r3) goto L_0x003a
            com.goldcoast.sdk.domain.EntryPoint r3 = r5.f2957b
            boolean r3 = r3.getStatus()
            if (r3 == 0) goto L_0x001a
            java.lang.String r0 = "ok"
            goto L_0x003a
        L_0x001a:
            com.goldcoast.sdk.domain.EntryPoint r3 = r5.f2957b
            boolean r3 = r3.D
            if (r3 != 0) goto L_0x0025
            java.lang.String r0 = "failed"
            goto L_0x003a
        L_0x0025:
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002f:
            com.goldcoast.sdk.c.g.a()
            java.lang.String r3 = "timer: loop"
            com.goldcoast.sdk.c.g.a((java.lang.String) r3)
            int r2 = r2 + 1
            goto L_0x0009
        L_0x003a:
            r2 = -1
            int r3 = r0.hashCode()
            r4 = -1281977283(0xffffffffb396943d, float:-7.011884E-8)
            if (r3 == r4) goto L_0x0053
            r4 = 3548(0xddc, float:4.972E-42)
            if (r3 == r4) goto L_0x0049
            goto L_0x005d
        L_0x0049:
            java.lang.String r3 = "ok"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 0
            goto L_0x005e
        L_0x0053:
            java.lang.String r3 = "failed"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x005d
            r0 = 1
            goto L_0x005e
        L_0x005d:
            r0 = -1
        L_0x005e:
            switch(r0) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006a;
                default: goto L_0x0061;
            }
        L_0x0061:
            com.goldcoast.sdk.c.g.a()
            java.lang.String r0 = "timer: $$$ timeout"
        L_0x0066:
            com.goldcoast.sdk.c.g.a((java.lang.String) r0)
            goto L_0x0077
        L_0x006a:
            com.goldcoast.sdk.c.g.a()
            java.lang.String r0 = "timer: $$$ failed"
            goto L_0x0066
        L_0x0070:
            com.goldcoast.sdk.domain.EntryPoint r0 = r5.f2957b
            java.lang.String r2 = "$$$ success"
            r0.b(r2, r1)
        L_0x0077:
            android.os.ConditionVariable r0 = r5.f2956a
            r0.open()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goldcoast.sdk.domain.b.run():void");
    }
}
