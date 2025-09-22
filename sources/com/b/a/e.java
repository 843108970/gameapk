package com.b.a;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f802a;

    /* renamed from: b  reason: collision with root package name */
    public static final e f803b;

    /* renamed from: c  reason: collision with root package name */
    String f804c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;

    static {
        f fVar = new f();
        fVar.f805a = true;
        f802a = fVar.a();
        f fVar2 = new f();
        fVar2.f = true;
        long seconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        fVar2.d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
        f803b = fVar2.a();
    }

    e(f fVar) {
        this.d = fVar.f805a;
        this.e = fVar.f806b;
        this.f = fVar.f807c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = fVar.d;
        this.l = fVar.e;
        this.m = fVar.f;
        this.n = fVar.g;
    }

    private e(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, String str) {
        this.d = z;
        this.e = z2;
        this.f = i2;
        this.g = i3;
        this.h = z3;
        this.i = z4;
        this.j = z5;
        this.k = i4;
        this.l = i5;
        this.m = z6;
        this.n = z7;
        this.f804c = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.b.a.e a(com.b.a.aa r23) {
        /*
            r0 = r23
            int r1 = r23.a()
            r6 = 0
            r7 = 1
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = -1
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -1
            r18 = -1
            r19 = 0
            r20 = 0
        L_0x0019:
            if (r6 >= r1) goto L_0x0139
            java.lang.String r9 = r0.a((int) r6)
            java.lang.String r2 = r0.b(r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0031
            if (r8 == 0) goto L_0x002f
        L_0x002d:
            r7 = 0
            goto L_0x003a
        L_0x002f:
            r8 = r2
            goto L_0x003a
        L_0x0031:
            java.lang.String r4 = "Pragma"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0132
            goto L_0x002d
        L_0x003a:
            r4 = 0
        L_0x003b:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x0132
            java.lang.String r9 = "=,;"
            int r9 = com.b.a.a.c.f.a((java.lang.String) r2, (int) r4, (java.lang.String) r9)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r4 = r4.trim()
            int r3 = r2.length()
            if (r9 == r3) goto L_0x009c
            char r3 = r2.charAt(r9)
            r5 = 44
            if (r3 == r5) goto L_0x009c
            char r3 = r2.charAt(r9)
            r5 = 59
            if (r3 != r5) goto L_0x0066
            goto L_0x009c
        L_0x0066:
            int r9 = r9 + 1
            int r3 = com.b.a.a.c.f.a(r2, r9)
            int r5 = r2.length()
            if (r3 >= r5) goto L_0x008b
            char r5 = r2.charAt(r3)
            r9 = 34
            if (r5 != r9) goto L_0x008b
            int r3 = r3 + 1
            java.lang.String r5 = "\""
            int r5 = com.b.a.a.c.f.a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            r21 = 1
            int r5 = r5 + 1
            goto L_0x00a2
        L_0x008b:
            r21 = 1
            java.lang.String r5 = ",;"
            int r5 = com.b.a.a.c.f.a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            java.lang.String r3 = r3.trim()
            goto L_0x00a2
        L_0x009c:
            r21 = 1
            int r9 = r9 + 1
            r5 = r9
            r3 = 0
        L_0x00a2:
            java.lang.String r9 = "no-cache"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ad
            r4 = r5
            r10 = 1
            goto L_0x003b
        L_0x00ad:
            java.lang.String r9 = "no-store"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00b8
            r4 = r5
            r11 = 1
            goto L_0x003b
        L_0x00b8:
            java.lang.String r9 = "max-age"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00c8
            r9 = -1
            int r12 = com.b.a.a.c.f.b(r3, r9)
        L_0x00c5:
            r4 = r5
            goto L_0x003b
        L_0x00c8:
            java.lang.String r9 = "s-maxage"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00d6
            r9 = -1
            int r13 = com.b.a.a.c.f.b(r3, r9)
            goto L_0x00c5
        L_0x00d6:
            java.lang.String r9 = "private"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00e2
            r4 = r5
            r14 = 1
            goto L_0x003b
        L_0x00e2:
            java.lang.String r9 = "public"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00ee
            r4 = r5
            r15 = 1
            goto L_0x003b
        L_0x00ee:
            java.lang.String r9 = "must-revalidate"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00fb
            r4 = r5
            r16 = 1
            goto L_0x003b
        L_0x00fb:
            java.lang.String r9 = "max-stale"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x010b
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r17 = com.b.a.a.c.f.b(r3, r4)
            goto L_0x00c5
        L_0x010b:
            java.lang.String r9 = "min-fresh"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x0119
            r9 = -1
            int r18 = com.b.a.a.c.f.b(r3, r9)
            goto L_0x00c5
        L_0x0119:
            r9 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0127
            r4 = r5
            r19 = 1
            goto L_0x003b
        L_0x0127:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00c5
            r20 = 1
            goto L_0x00c5
        L_0x0132:
            r9 = -1
            r21 = 1
            int r6 = r6 + 1
            goto L_0x0019
        L_0x0139:
            if (r7 != 0) goto L_0x013e
            r21 = 0
            goto L_0x0140
        L_0x013e:
            r21 = r8
        L_0x0140:
            com.b.a.e r0 = new com.b.a.e
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.e.a(com.b.a.aa):com.b.a.e");
    }

    public final boolean a() {
        return this.d;
    }

    public final boolean b() {
        return this.e;
    }

    public final int c() {
        return this.f;
    }

    public final boolean d() {
        return this.h;
    }

    public final boolean e() {
        return this.i;
    }

    public final boolean f() {
        return this.j;
    }

    public final int g() {
        return this.k;
    }

    public final int h() {
        return this.l;
    }

    public final boolean i() {
        return this.m;
    }

    public final String toString() {
        String str;
        String str2 = this.f804c;
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (this.d) {
            sb.append("no-cache, ");
        }
        if (this.e) {
            sb.append("no-store, ");
        }
        if (this.f != -1) {
            sb.append("max-age=");
            sb.append(this.f);
            sb.append(", ");
        }
        if (this.g != -1) {
            sb.append("s-maxage=");
            sb.append(this.g);
            sb.append(", ");
        }
        if (this.h) {
            sb.append("private, ");
        }
        if (this.i) {
            sb.append("public, ");
        }
        if (this.j) {
            sb.append("must-revalidate, ");
        }
        if (this.k != -1) {
            sb.append("max-stale=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l != -1) {
            sb.append("min-fresh=");
            sb.append(this.l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            str = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            str = sb.toString();
        }
        this.f804c = str;
        return str;
    }
}
