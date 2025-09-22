package b;

import b.a.c;
import c.d;
import c.f;
import com.umeng.commonsdk.proguard.bg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

public final class y extends ad {

    /* renamed from: a  reason: collision with root package name */
    public static final x f362a = x.a("multipart/mixed");

    /* renamed from: b  reason: collision with root package name */
    public static final x f363b = x.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final x f364c = x.a("multipart/digest");
    public static final x d = x.a("multipart/parallel");
    public static final x e = x.a("multipart/form-data");
    private static final byte[] f = {58, 32};
    private static final byte[] g = {bg.k, 10};
    private static final byte[] h = {45, 45};
    private final f i;
    private final x j;
    private final x k;
    private final List<b> l;
    private long m = -1;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final f f365a;

        /* renamed from: b  reason: collision with root package name */
        private x f366b;

        /* renamed from: c  reason: collision with root package name */
        private final List<b> f367c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        private a(String str) {
            this.f366b = y.f362a;
            this.f367c = new ArrayList();
            this.f365a = f.encodeUtf8(str);
        }

        private a a(ad adVar) {
            return a(b.a((u) null, adVar));
        }

        private a a(@Nullable u uVar, ad adVar) {
            return a(b.a(uVar, adVar));
        }

        private a a(x xVar) {
            if (xVar == null) {
                throw new NullPointerException("type == null");
            } else if (!xVar.f361a.equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + xVar);
            } else {
                this.f366b = xVar;
                return this;
            }
        }

        private a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f367c.add(bVar);
            return this;
        }

        private a a(String str, String str2) {
            return a(b.a(str, (String) null, ad.create((x) null, str2)));
        }

        private a a(String str, @Nullable String str2, ad adVar) {
            return a(b.a(str, str2, adVar));
        }

        private y a() {
            if (!this.f367c.isEmpty()) {
                return new y(this.f365a, this.f366b, this.f367c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    public static final class b {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        final u f368a;

        /* renamed from: b  reason: collision with root package name */
        final ad f369b;

        private b(@Nullable u uVar, ad adVar) {
            this.f368a = uVar;
            this.f369b = adVar;
        }

        @Nullable
        private u a() {
            return this.f368a;
        }

        private static b a(ad adVar) {
            return a((u) null, adVar);
        }

        public static b a(@Nullable u uVar, ad adVar) {
            if (adVar == null) {
                throw new NullPointerException("body == null");
            } else if (uVar != null && uVar.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (uVar == null || uVar.a("Content-Length") == null) {
                return new b(uVar, adVar);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }

        private static b a(String str, String str2) {
            return a(str, (String) null, ad.create((x) null, str2));
        }

        public static b a(String str, @Nullable String str2, ad adVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            y.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                y.a(sb, str2);
            }
            return a(u.a("Content-Disposition", sb.toString()), adVar);
        }

        private ad b() {
            return this.f369b;
        }
    }

    y(f fVar, x xVar, List<b> list) {
        this.i = fVar;
        this.j = xVar;
        this.k = x.a(xVar + "; boundary=" + fVar.utf8());
        this.l = c.a(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: c.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: c.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: c.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: c.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: c.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(@javax.annotation.Nullable c.d r13, boolean r14) throws java.io.IOException {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x0009
            c.c r13 = new c.c
            r13.<init>()
            r0 = r13
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            java.util.List<b.y$b> r1 = r12.l
            int r1 = r1.size()
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x0015:
            if (r3 >= r1) goto L_0x00aa
            java.util.List<b.y$b> r6 = r12.l
            java.lang.Object r6 = r6.get(r3)
            b.y$b r6 = (b.y.b) r6
            b.u r7 = r6.f368a
            b.ad r6 = r6.f369b
            byte[] r8 = h
            r13.d(r8)
            c.f r8 = r12.i
            r13.e(r8)
            byte[] r8 = g
            r13.d(r8)
            if (r7 == 0) goto L_0x005a
            java.lang.String[] r8 = r7.f350a
            int r8 = r8.length
            int r8 = r8 / 2
            r9 = 0
        L_0x003a:
            if (r9 >= r8) goto L_0x005a
            java.lang.String r10 = r7.a((int) r9)
            c.d r10 = r13.b(r10)
            byte[] r11 = f
            c.d r10 = r10.d(r11)
            java.lang.String r11 = r7.b((int) r9)
            c.d r10 = r10.b(r11)
            byte[] r11 = g
            r10.d(r11)
            int r9 = r9 + 1
            goto L_0x003a
        L_0x005a:
            b.x r7 = r6.contentType()
            if (r7 == 0) goto L_0x0073
            java.lang.String r8 = "Content-Type: "
            c.d r8 = r13.b(r8)
            java.lang.String r7 = r7.toString()
            c.d r7 = r8.b(r7)
            byte[] r8 = g
            r7.d(r8)
        L_0x0073:
            long r7 = r6.contentLength()
            r9 = -1
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x008d
            java.lang.String r9 = "Content-Length: "
            c.d r9 = r13.b(r9)
            c.d r9 = r9.n(r7)
            byte[] r10 = g
            r9.d(r10)
            goto L_0x0093
        L_0x008d:
            if (r14 == 0) goto L_0x0093
            r0.w()
            return r9
        L_0x0093:
            byte[] r9 = g
            r13.d(r9)
            if (r14 == 0) goto L_0x009e
            long r9 = r4 + r7
            r4 = r9
            goto L_0x00a1
        L_0x009e:
            r6.writeTo(r13)
        L_0x00a1:
            byte[] r6 = g
            r13.d(r6)
            int r3 = r3 + 1
            goto L_0x0015
        L_0x00aa:
            byte[] r1 = h
            r13.d(r1)
            c.f r1 = r12.i
            r13.e(r1)
            byte[] r1 = h
            r13.d(r1)
            byte[] r1 = g
            r13.d(r1)
            if (r14 == 0) goto L_0x00c8
            long r13 = r0.f387c
            long r1 = r4 + r13
            r0.w()
            return r1
        L_0x00c8:
            r1 = r4
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.y.a(c.d, boolean):long");
    }

    private x a() {
        return this.j;
    }

    private b a(int i2) {
        return this.l.get(i2);
    }

    static StringBuilder a(StringBuilder sb, String str) {
        String str2;
        sb.append('\"');
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 10) {
                str2 = "%0A";
            } else if (charAt == 13) {
                str2 = "%0D";
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                str2 = "%22";
            }
            sb.append(str2);
        }
        sb.append('\"');
        return sb;
    }

    private String b() {
        return this.i.utf8();
    }

    private int c() {
        return this.l.size();
    }

    private List<b> d() {
        return this.l;
    }

    public final long contentLength() throws IOException {
        long j2 = this.m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((d) null, true);
        this.m = a2;
        return a2;
    }

    public final x contentType() {
        return this.k;
    }

    public final void writeTo(d dVar) throws IOException {
        a(dVar, false);
    }
}
