package com.b.b;

final class d extends Thread {
    public d() {
        super("Okio Watchdog");
        setDaemon(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Class<com.b.b.a> r0 = com.b.b.a.class
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
            com.b.b.a r1 = com.b.b.a.e()     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            goto L_0x0000
        L_0x000b:
            com.b.b.a r2 = com.b.b.a.d     // Catch:{ all -> 0x001b }
            if (r1 != r2) goto L_0x0016
            com.b.b.a unused = com.b.b.a.d = null     // Catch:{ all -> 0x001b }
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            return
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            r1.a()     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0000
        L_0x001b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001b }
            throw r1     // Catch:{ InterruptedException -> 0x0000 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.b.d.run():void");
    }
}
