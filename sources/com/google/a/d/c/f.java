package com.google.a.d.c;

final class f implements g {
    f() {
    }

    private static String a(CharSequence charSequence) {
        char c2 = 0;
        int length = charSequence.length() - 0;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        char charAt = charSequence.charAt(0);
        char charAt2 = length >= 2 ? charSequence.charAt(1) : 0;
        char charAt3 = length >= 3 ? charSequence.charAt(2) : 0;
        if (length >= 4) {
            c2 = charSequence.charAt(3);
        }
        int i = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c2;
        char c3 = (char) ((i >> 8) & 255);
        char c4 = (char) (i & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) ((i >> 16) & 255));
        if (length >= 2) {
            sb.append(c3);
        }
        if (length >= 3) {
            sb.append(c4);
        }
        return sb.toString();
    }

    private static void a(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 < '@' || c2 > '^') {
            j.c(c2);
        } else {
            sb.append((char) (c2 - '@'));
        }
    }

    private static void a(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    hVar.d();
                    int length2 = hVar.h.f3126b - hVar.e.length();
                    int c2 = hVar.c();
                    if (c2 > length2) {
                        hVar.a(hVar.e.length() + 1);
                        length2 = hVar.h.f3126b - hVar.e.length();
                    }
                    if (c2 <= length2 && length2 <= 2) {
                        hVar.g = 0;
                        return;
                    }
                }
                if (length > 4) {
                    throw new IllegalStateException("Count must not exceed 4");
                }
                int i = length - 1;
                String a2 = a(charSequence);
                if (!(!hVar.b()) || i > 2) {
                    z = false;
                }
                if (i <= 2) {
                    hVar.a(hVar.e.length() + i);
                    if (hVar.h.f3126b - hVar.e.length() >= 3) {
                        hVar.a(hVar.e.length() + a2.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.h = null;
                    hVar.f -= i;
                } else {
                    hVar.a(a2);
                }
                hVar.g = 0;
            }
        } finally {
            hVar.g = 0;
        }
    }

    public final int a() {
        return 4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.a.d.c.h r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r10.b()
            r2 = 4
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x004e
            char r1 = r10.a()
            r5 = 32
            if (r1 < r5) goto L_0x001e
            r5 = 63
            if (r1 > r5) goto L_0x001e
        L_0x001a:
            r0.append(r1)
            goto L_0x002d
        L_0x001e:
            r5 = 64
            if (r1 < r5) goto L_0x002a
            r5 = 94
            if (r1 > r5) goto L_0x002a
            int r1 = r1 + -64
            char r1 = (char) r1
            goto L_0x001a
        L_0x002a:
            com.google.a.d.c.j.c(r1)
        L_0x002d:
            int r1 = r10.f
            int r1 = r1 + r3
            r10.f = r1
            int r1 = r0.length()
            if (r1 < r2) goto L_0x0005
            java.lang.String r1 = a((java.lang.CharSequence) r0)
            r10.a((java.lang.String) r1)
            r0.delete(r4, r2)
            java.lang.String r1 = r10.f3116a
            int r5 = r10.f
            int r1 = com.google.a.d.c.j.a(r1, r5, r2)
            if (r1 == r2) goto L_0x0005
            r10.g = r4
        L_0x004e:
            r1 = 31
            r0.append(r1)
            int r1 = r0.length()     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x005c
            r10.g = r4
            return
        L_0x005c:
            r5 = 2
            if (r1 != r3) goto L_0x008f
            r10.d()     // Catch:{ all -> 0x00e3 }
            com.google.a.d.c.k r6 = r10.h     // Catch:{ all -> 0x00e3 }
            int r6 = r6.f3126b     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r7 = r10.e     // Catch:{ all -> 0x00e3 }
            int r7 = r7.length()     // Catch:{ all -> 0x00e3 }
            int r6 = r6 - r7
            int r7 = r10.c()     // Catch:{ all -> 0x00e3 }
            if (r7 <= r6) goto L_0x0088
            java.lang.StringBuilder r6 = r10.e     // Catch:{ all -> 0x00e3 }
            int r6 = r6.length()     // Catch:{ all -> 0x00e3 }
            int r6 = r6 + r3
            r10.a((int) r6)     // Catch:{ all -> 0x00e3 }
            com.google.a.d.c.k r6 = r10.h     // Catch:{ all -> 0x00e3 }
            int r6 = r6.f3126b     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r8 = r10.e     // Catch:{ all -> 0x00e3 }
            int r8 = r8.length()     // Catch:{ all -> 0x00e3 }
            int r6 = r6 - r8
        L_0x0088:
            if (r7 > r6) goto L_0x008f
            if (r6 > r5) goto L_0x008f
            r10.g = r4
            return
        L_0x008f:
            if (r1 <= r2) goto L_0x0099
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = "Count must not exceed 4"
            r0.<init>(r1)     // Catch:{ all -> 0x00e3 }
            throw r0     // Catch:{ all -> 0x00e3 }
        L_0x0099:
            int r1 = r1 - r3
            java.lang.String r0 = a((java.lang.CharSequence) r0)     // Catch:{ all -> 0x00e3 }
            boolean r2 = r10.b()     // Catch:{ all -> 0x00e3 }
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x00a8
            if (r1 > r5) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r3 = 0
        L_0x00a9:
            if (r1 > r5) goto L_0x00d2
            java.lang.StringBuilder r2 = r10.e     // Catch:{ all -> 0x00e3 }
            int r2 = r2.length()     // Catch:{ all -> 0x00e3 }
            int r2 = r2 + r1
            r10.a((int) r2)     // Catch:{ all -> 0x00e3 }
            com.google.a.d.c.k r2 = r10.h     // Catch:{ all -> 0x00e3 }
            int r2 = r2.f3126b     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = r10.e     // Catch:{ all -> 0x00e3 }
            int r5 = r5.length()     // Catch:{ all -> 0x00e3 }
            int r2 = r2 - r5
            r5 = 3
            if (r2 < r5) goto L_0x00d2
            java.lang.StringBuilder r2 = r10.e     // Catch:{ all -> 0x00e3 }
            int r2 = r2.length()     // Catch:{ all -> 0x00e3 }
            int r3 = r0.length()     // Catch:{ all -> 0x00e3 }
            int r2 = r2 + r3
            r10.a((int) r2)     // Catch:{ all -> 0x00e3 }
            r3 = 0
        L_0x00d2:
            if (r3 == 0) goto L_0x00dd
            r0 = 0
            r10.h = r0     // Catch:{ all -> 0x00e3 }
            int r0 = r10.f     // Catch:{ all -> 0x00e3 }
            int r0 = r0 - r1
            r10.f = r0     // Catch:{ all -> 0x00e3 }
            goto L_0x00e0
        L_0x00dd:
            r10.a((java.lang.String) r0)     // Catch:{ all -> 0x00e3 }
        L_0x00e0:
            r10.g = r4
            return
        L_0x00e3:
            r0 = move-exception
            r10.g = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.c.f.a(com.google.a.d.c.h):void");
    }
}
