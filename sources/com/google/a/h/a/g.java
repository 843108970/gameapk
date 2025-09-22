package com.google.a.h.a;

class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int f3258c = 5;

    /* renamed from: a  reason: collision with root package name */
    final c f3259a;

    /* renamed from: b  reason: collision with root package name */
    final d[] f3260b;

    g(c cVar) {
        this.f3259a = new c(cVar);
        this.f3260b = new d[((cVar.i - cVar.h) + 1)];
    }

    private c a() {
        return this.f3259a;
    }

    private d[] b() {
        return this.f3260b;
    }

    /* access modifiers changed from: package-private */
    public final d a(int i) {
        d dVar;
        d dVar2;
        d c2 = c(i);
        if (c2 != null) {
            return c2;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int b2 = b(i) - i2;
            if (b2 >= 0 && (dVar2 = this.f3260b[b2]) != null) {
                return dVar2;
            }
            int b3 = b(i) + i2;
            if (b3 < this.f3260b.length && (dVar = this.f3260b[b3]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, d dVar) {
        this.f3260b[b(i)] = dVar;
    }

    /* access modifiers changed from: package-private */
    public final int b(int i) {
        return i - this.f3259a.h;
    }

    /* access modifiers changed from: package-private */
    public final d c(int i) {
        return this.f3260b[b(i)];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r12 = this;
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            com.google.a.h.a.d[] r2 = r12.f3260b     // Catch:{ Throwable -> 0x0053 }
            int r3 = r2.length     // Catch:{ Throwable -> 0x0053 }
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000c:
            if (r5 >= r3) goto L_0x0049
            r7 = r2[r5]     // Catch:{ Throwable -> 0x0053 }
            r8 = 1
            if (r7 != 0) goto L_0x0024
            java.lang.String r7 = "%3d:    |   %n"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Throwable -> 0x0053 }
            int r9 = r6 + 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0053 }
            r8[r4] = r6     // Catch:{ Throwable -> 0x0053 }
            r0.format(r7, r8)     // Catch:{ Throwable -> 0x0053 }
            r6 = r9
            goto L_0x0046
        L_0x0024:
            java.lang.String r9 = "%3d: %3d|%3d%n"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ Throwable -> 0x0053 }
            int r11 = r6 + 1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0053 }
            r10[r4] = r6     // Catch:{ Throwable -> 0x0053 }
            int r6 = r7.e     // Catch:{ Throwable -> 0x0053 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Throwable -> 0x0053 }
            r10[r8] = r6     // Catch:{ Throwable -> 0x0053 }
            r6 = 2
            int r7 = r7.d     // Catch:{ Throwable -> 0x0053 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Throwable -> 0x0053 }
            r10[r6] = r7     // Catch:{ Throwable -> 0x0053 }
            r0.format(r9, r10)     // Catch:{ Throwable -> 0x0053 }
            r6 = r11
        L_0x0046:
            int r5 = r5 + 1
            goto L_0x000c
        L_0x0049:
            java.lang.String r2 = r0.toString()     // Catch:{ Throwable -> 0x0053 }
            r0.close()
            return r2
        L_0x0051:
            r2 = move-exception
            goto L_0x0055
        L_0x0053:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x0055:
            if (r1 == 0) goto L_0x0060
            r0.close()     // Catch:{ Throwable -> 0x005b }
            goto L_0x0063
        L_0x005b:
            r0 = move-exception
            r1.addSuppressed(r0)
            goto L_0x0063
        L_0x0060:
            r0.close()
        L_0x0063:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.h.a.g.toString():java.lang.String");
    }
}
