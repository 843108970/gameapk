package com.google.a.d.c;

class c implements g {
    c() {
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        hVar.f--;
        int a2 = a(hVar.a(), sb2);
        hVar.h = null;
        return a2;
    }

    private static String a(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    static void a(h hVar, StringBuilder sb) {
        int charAt = (sb.charAt(0) * 1600) + (sb.charAt(1) * '(') + sb.charAt(2) + 1;
        hVar.a(new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)}));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public int a(char c2, StringBuilder sb) {
        int i;
        int i2;
        char c3;
        if (c2 == ' ') {
            c3 = 3;
        } else {
            if (c2 >= '0' && c2 <= '9') {
                i2 = (c2 - '0') + 4;
            } else if (c2 < 'A' || c2 > 'Z') {
                if (c2 < ' ') {
                    sb.append(0);
                } else {
                    char c4 = '!';
                    if (c2 >= '!' && c2 <= '/') {
                        sb.append(1);
                    } else if (c2 >= ':' && c2 <= '@') {
                        sb.append(1);
                        i = (c2 - ':') + 15;
                        c2 = (char) i;
                    } else if (c2 < '[' || c2 > '_') {
                        c4 = '`';
                        if (c2 < '`' || c2 > 127) {
                            sb.append("\u0001\u001e");
                            return a((char) (c2 - 128), sb) + 2;
                        }
                        sb.append(2);
                    } else {
                        sb.append(1);
                        i = (c2 - '[') + 22;
                        c2 = (char) i;
                    }
                    i = c2 - c4;
                    c2 = (char) i;
                }
                sb.append(c2);
                return 2;
            } else {
                i2 = (c2 - 'A') + 14;
            }
            c3 = (char) i2;
        }
        sb.append(c3);
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        if (r2 != 1) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (r1 > 3) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0044, code lost:
        if (r2 > 2) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.a.d.c.h r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            boolean r1 = r9.b()
            if (r1 == 0) goto L_0x0074
            char r1 = r9.a()
            int r2 = r9.f
            r3 = 1
            int r2 = r2 + r3
            r9.f = r2
            int r1 = r8.a((char) r1, (java.lang.StringBuilder) r0)
            int r2 = r0.length()
            r4 = 3
            int r2 = r2 / r4
            int r2 = r2 << r3
            java.lang.StringBuilder r5 = r9.e
            int r5 = r5.length()
            int r5 = r5 + r2
            r9.a((int) r5)
            com.google.a.d.c.k r2 = r9.h
            int r2 = r2.f3126b
            int r2 = r2 - r5
            boolean r5 = r9.b()
            if (r5 != 0) goto L_0x0058
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r0.length()
            int r6 = r6 % r4
            r7 = 2
            if (r6 != r7) goto L_0x004a
            if (r2 < r7) goto L_0x0046
            if (r2 <= r7) goto L_0x004a
        L_0x0046:
            int r1 = r8.a(r9, r0, r5, r1)
        L_0x004a:
            int r6 = r0.length()
            int r6 = r6 % r4
            if (r6 != r3) goto L_0x0074
            if (r1 > r4) goto L_0x0055
            if (r2 != r3) goto L_0x0046
        L_0x0055:
            if (r1 <= r4) goto L_0x0074
            goto L_0x0046
        L_0x0058:
            int r1 = r0.length()
            int r1 = r1 % r4
            if (r1 != 0) goto L_0x0005
            java.lang.String r1 = r9.f3116a
            int r2 = r9.f
            int r3 = r8.a()
            int r1 = com.google.a.d.c.j.a(r1, r2, r3)
            int r2 = r8.a()
            if (r1 == r2) goto L_0x0005
            r1 = 0
            r9.g = r1
        L_0x0074:
            r8.b(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.c.c.a(com.google.a.d.c.h):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r8.b() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        if (r8.b() != false) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.google.a.d.c.h r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 3
            int r0 = r0 / r1
            r2 = 1
            int r0 = r0 << r2
            int r3 = r9.length()
            int r3 = r3 % r1
            java.lang.StringBuilder r4 = r8.e
            int r4 = r4.length()
            int r4 = r4 + r0
            r8.a((int) r4)
            com.google.a.d.c.k r0 = r8.h
            int r0 = r0.f3126b
            int r0 = r0 - r4
            r4 = 0
            r5 = 254(0xfe, float:3.56E-43)
            r6 = 2
            if (r3 != r6) goto L_0x0039
            r9.append(r4)
        L_0x0025:
            int r0 = r9.length()
            if (r0 < r1) goto L_0x002f
            a((com.google.a.d.c.h) r8, (java.lang.StringBuilder) r9)
            goto L_0x0025
        L_0x002f:
            boolean r9 = r8.b()
            if (r9 == 0) goto L_0x006b
        L_0x0035:
            r8.a((char) r5)
            goto L_0x006b
        L_0x0039:
            if (r0 != r2) goto L_0x0056
            if (r3 != r2) goto L_0x0056
        L_0x003d:
            int r0 = r9.length()
            if (r0 < r1) goto L_0x0047
            a((com.google.a.d.c.h) r8, (java.lang.StringBuilder) r9)
            goto L_0x003d
        L_0x0047:
            boolean r9 = r8.b()
            if (r9 == 0) goto L_0x0050
            r8.a((char) r5)
        L_0x0050:
            int r9 = r8.f
            int r9 = r9 - r2
            r8.f = r9
            goto L_0x006b
        L_0x0056:
            if (r3 != 0) goto L_0x006e
        L_0x0058:
            int r2 = r9.length()
            if (r2 < r1) goto L_0x0062
            a((com.google.a.d.c.h) r8, (java.lang.StringBuilder) r9)
            goto L_0x0058
        L_0x0062:
            if (r0 > 0) goto L_0x0035
            boolean r9 = r8.b()
            if (r9 == 0) goto L_0x006b
            goto L_0x0035
        L_0x006b:
            r8.g = r4
            return
        L_0x006e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Unexpected case. Please report!"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.c.c.b(com.google.a.d.c.h, java.lang.StringBuilder):void");
    }
}
