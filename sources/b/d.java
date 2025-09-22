package b;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f301a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f302b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f303c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    @Nullable
    String l;
    private final int m;
    private final boolean n;
    private final boolean o;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f304a;

        /* renamed from: b  reason: collision with root package name */
        boolean f305b;

        /* renamed from: c  reason: collision with root package name */
        int f306c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;
        boolean h;

        private a a(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + i);
            }
            long seconds = timeUnit.toSeconds((long) i);
            this.f306c = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
            return this;
        }

        private a a(TimeUnit timeUnit) {
            long seconds = timeUnit.toSeconds(2147483647L);
            this.d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
            return this;
        }

        private a b() {
            this.f304a = true;
            return this;
        }

        private a b(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + i);
            }
            long seconds = timeUnit.toSeconds((long) i);
            this.e = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
            return this;
        }

        private a c() {
            this.f305b = true;
            return this;
        }

        private a d() {
            this.f = true;
            return this;
        }

        private a e() {
            this.g = true;
            return this;
        }

        private a f() {
            this.h = true;
            return this;
        }

        public final d a() {
            return new d(this);
        }
    }

    static {
        a aVar = new a();
        aVar.f304a = true;
        f301a = aVar.a();
        a aVar2 = new a();
        aVar2.f = true;
        long seconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        aVar2.d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
        f302b = aVar2.a();
    }

    d(a aVar) {
        this.f303c = aVar.f304a;
        this.d = aVar.f305b;
        this.e = aVar.f306c;
        this.m = -1;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = aVar.d;
        this.j = aVar.e;
        this.k = aVar.f;
        this.n = aVar.g;
        this.o = aVar.h;
    }

    private d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f303c = z;
        this.d = z2;
        this.e = i2;
        this.m = i3;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = i4;
        this.j = i5;
        this.k = z6;
        this.n = z7;
        this.o = z8;
        this.l = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b.d a(b.u r24) {
        /*
            r0 = r24
            java.lang.String[] r1 = r0.f350a
            int r1 = r1.length
            int r1 = r1 / 2
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
            r21 = 0
        L_0x001c:
            if (r6 >= r1) goto L_0x0149
            java.lang.String r9 = r0.a((int) r6)
            java.lang.String r2 = r0.b((int) r6)
            java.lang.String r4 = "Cache-Control"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0034
            if (r8 == 0) goto L_0x0032
        L_0x0030:
            r7 = 0
            goto L_0x003d
        L_0x0032:
            r8 = r2
            goto L_0x003d
        L_0x0034:
            java.lang.String r4 = "Pragma"
            boolean r4 = r9.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0142
            goto L_0x0030
        L_0x003d:
            r4 = 0
        L_0x003e:
            int r9 = r2.length()
            if (r4 >= r9) goto L_0x0142
            java.lang.String r9 = "=,;"
            int r9 = b.a.d.e.a((java.lang.String) r2, (int) r4, (java.lang.String) r9)
            java.lang.String r4 = r2.substring(r4, r9)
            java.lang.String r4 = r4.trim()
            int r3 = r2.length()
            if (r9 == r3) goto L_0x009f
            char r3 = r2.charAt(r9)
            r5 = 44
            if (r3 == r5) goto L_0x009f
            char r3 = r2.charAt(r9)
            r5 = 59
            if (r3 != r5) goto L_0x0069
            goto L_0x009f
        L_0x0069:
            int r9 = r9 + 1
            int r3 = b.a.d.e.a((java.lang.String) r2, (int) r9)
            int r5 = r2.length()
            if (r3 >= r5) goto L_0x008e
            char r5 = r2.charAt(r3)
            r9 = 34
            if (r5 != r9) goto L_0x008e
            int r3 = r3 + 1
            java.lang.String r5 = "\""
            int r5 = b.a.d.e.a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            r22 = 1
            int r5 = r5 + 1
            goto L_0x00a5
        L_0x008e:
            r22 = 1
            java.lang.String r5 = ",;"
            int r5 = b.a.d.e.a((java.lang.String) r2, (int) r3, (java.lang.String) r5)
            java.lang.String r3 = r2.substring(r3, r5)
            java.lang.String r3 = r3.trim()
            goto L_0x00a5
        L_0x009f:
            r22 = 1
            int r9 = r9 + 1
            r5 = r9
            r3 = 0
        L_0x00a5:
            java.lang.String r9 = "no-cache"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00b0
            r4 = r5
            r10 = 1
            goto L_0x003e
        L_0x00b0:
            java.lang.String r9 = "no-store"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00bb
            r4 = r5
            r11 = 1
            goto L_0x003e
        L_0x00bb:
            java.lang.String r9 = "max-age"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00cb
            r9 = -1
            int r12 = b.a.d.e.b(r3, r9)
        L_0x00c8:
            r4 = r5
            goto L_0x003e
        L_0x00cb:
            java.lang.String r9 = "s-maxage"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00d9
            r9 = -1
            int r13 = b.a.d.e.b(r3, r9)
            goto L_0x00c8
        L_0x00d9:
            java.lang.String r9 = "private"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00e5
            r4 = r5
            r14 = 1
            goto L_0x003e
        L_0x00e5:
            java.lang.String r9 = "public"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00f1
            r4 = r5
            r15 = 1
            goto L_0x003e
        L_0x00f1:
            java.lang.String r9 = "must-revalidate"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x00fe
            r4 = r5
            r16 = 1
            goto L_0x003e
        L_0x00fe:
            java.lang.String r9 = "max-stale"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x010e
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r17 = b.a.d.e.b(r3, r4)
            goto L_0x00c8
        L_0x010e:
            java.lang.String r9 = "min-fresh"
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x011c
            r9 = -1
            int r18 = b.a.d.e.b(r3, r9)
            goto L_0x00c8
        L_0x011c:
            r9 = -1
            java.lang.String r3 = "only-if-cached"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x012a
            r4 = r5
            r19 = 1
            goto L_0x003e
        L_0x012a:
            java.lang.String r3 = "no-transform"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0137
            r4 = r5
            r20 = 1
            goto L_0x003e
        L_0x0137:
            java.lang.String r3 = "immutable"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x00c8
            r21 = 1
            goto L_0x00c8
        L_0x0142:
            r9 = -1
            r22 = 1
            int r6 = r6 + 1
            goto L_0x001c
        L_0x0149:
            if (r7 != 0) goto L_0x014e
            r22 = 0
            goto L_0x0150
        L_0x014e:
            r22 = r8
        L_0x0150:
            b.d r0 = new b.d
            r9 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.a(b.u):b.d");
    }

    private boolean a() {
        return this.f303c;
    }

    private boolean b() {
        return this.d;
    }

    private int c() {
        return this.e;
    }

    private int d() {
        return this.m;
    }

    private boolean e() {
        return this.f;
    }

    private boolean f() {
        return this.g;
    }

    private boolean g() {
        return this.h;
    }

    private int h() {
        return this.i;
    }

    private int i() {
        return this.j;
    }

    private boolean j() {
        return this.k;
    }

    private boolean k() {
        return this.n;
    }

    private boolean l() {
        return this.o;
    }

    private String m() {
        StringBuilder sb = new StringBuilder();
        if (this.f303c) {
            sb.append("no-cache, ");
        }
        if (this.d) {
            sb.append("no-store, ");
        }
        if (this.e != -1) {
            sb.append("max-age=");
            sb.append(this.e);
            sb.append(", ");
        }
        if (this.m != -1) {
            sb.append("s-maxage=");
            sb.append(this.m);
            sb.append(", ");
        }
        if (this.f) {
            sb.append("private, ");
        }
        if (this.g) {
            sb.append("public, ");
        }
        if (this.h) {
            sb.append("must-revalidate, ");
        }
        if (this.i != -1) {
            sb.append("max-stale=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j != -1) {
            sb.append("min-fresh=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public final String toString() {
        String str;
        String str2 = this.l;
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f303c) {
            sb.append("no-cache, ");
        }
        if (this.d) {
            sb.append("no-store, ");
        }
        if (this.e != -1) {
            sb.append("max-age=");
            sb.append(this.e);
            sb.append(", ");
        }
        if (this.m != -1) {
            sb.append("s-maxage=");
            sb.append(this.m);
            sb.append(", ");
        }
        if (this.f) {
            sb.append("private, ");
        }
        if (this.g) {
            sb.append("public, ");
        }
        if (this.h) {
            sb.append("must-revalidate, ");
        }
        if (this.i != -1) {
            sb.append("max-stale=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j != -1) {
            sb.append("min-fresh=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            str = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            str = sb.toString();
        }
        this.l = str;
        return str;
    }
}
