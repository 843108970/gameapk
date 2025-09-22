package com.google.a.b.a;

import java.util.regex.Pattern;

public final class ac extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3005a = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* renamed from: b  reason: collision with root package name */
    private final String f3006b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3007c;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (com.google.a.b.a.u.a(r3, r0, (r1 < 0 ? r3.length() : r1) - r0) != false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ac(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            int r0 = com.google.a.b.a.r.URI$3fc7421e
            r2.<init>(r0)
            java.lang.String r3 = r3.trim()
            r0 = 58
            int r0 = r3.indexOf(r0)
            if (r0 < 0) goto L_0x0026
            int r0 = r0 + 1
            r1 = 47
            int r1 = r3.indexOf(r1, r0)
            if (r1 >= 0) goto L_0x001f
            int r1 = r3.length()
        L_0x001f:
            int r1 = r1 - r0
            boolean r0 = com.google.a.b.a.u.a(r3, r0, r1)
            if (r0 == 0) goto L_0x0030
        L_0x0026:
            java.lang.String r0 = "http://"
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r0.concat(r3)
        L_0x0030:
            r2.f3006b = r3
            r2.f3007c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.ac.<init>(java.lang.String, java.lang.String):void");
    }

    private static String a(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        if (indexOf >= 0) {
            int i = indexOf + 1;
            int indexOf2 = trim.indexOf(47, i);
            if (indexOf2 < 0) {
                indexOf2 = trim.length();
            }
            if (!u.a(trim, i, indexOf2 - i)) {
                return trim;
            }
        }
        return "http://".concat(String.valueOf(trim));
    }

    private static boolean a(String str, int i) {
        int i2 = i + 1;
        int indexOf = str.indexOf(47, i2);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return u.a(str, i2, indexOf - i2);
    }

    private String b() {
        return this.f3006b;
    }

    private String c() {
        return this.f3007c;
    }

    private boolean d() {
        return f3005a.matcher(this.f3006b).find();
    }

    public final String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f3007c, sb);
        a(this.f3006b, sb);
        return sb.toString();
    }
}
