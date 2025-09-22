package com.b.a;

final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f821a;

    o(n nVar) {
        this.f821a = nVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
        L_0x0000:
            com.b.a.n r0 = r8.f821a
            long r1 = java.lang.System.nanoTime()
            long r0 = r0.a((long) r1)
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0011
            return
        L_0x0011:
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0000
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r0 / r2
            long r2 = r2 * r4
            long r6 = r0 - r2
            com.b.a.n r0 = r8.f821a
            monitor-enter(r0)
            com.b.a.n r1 = r8.f821a     // Catch:{ InterruptedException -> 0x002c }
            int r2 = (int) r6     // Catch:{ InterruptedException -> 0x002c }
            r1.wait(r4, r2)     // Catch:{ InterruptedException -> 0x002c }
            goto L_0x002c
        L_0x002a:
            r1 = move-exception
            goto L_0x002e
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            goto L_0x0000
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.o.run():void");
    }
}
