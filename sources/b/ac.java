package b;

import b.a.c;
import b.a.d.f;
import b.u;
import com.android.volley.toolbox.g;
import com.github.kevinsawicki.http.HttpRequest;
import java.net.URL;
import java.util.List;
import javax.annotation.Nullable;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final v f247a;

    /* renamed from: b  reason: collision with root package name */
    public final String f248b;

    /* renamed from: c  reason: collision with root package name */
    public final u f249c;
    @Nullable
    public final ad d;
    final Object e;
    private volatile d f;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        v f250a;

        /* renamed from: b  reason: collision with root package name */
        String f251b;

        /* renamed from: c  reason: collision with root package name */
        u.a f252c;
        ad d;
        Object e;

        public a() {
            this.f251b = HttpRequest.METHOD_GET;
            this.f252c = new u.a();
        }

        a(ac acVar) {
            this.f250a = acVar.f247a;
            this.f251b = acVar.f248b;
            this.d = acVar.d;
            this.e = acVar.e;
            this.f252c = acVar.f249c.b();
        }

        private a a(ad adVar) {
            return a("POST", adVar);
        }

        private a a(d dVar) {
            String dVar2 = dVar.toString();
            return dVar2.isEmpty() ? b("Cache-Control") : a("Cache-Control", dVar2);
        }

        private a a(Object obj) {
            this.e = obj;
            return this;
        }

        private a a(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            v a2 = v.a(url);
            if (a2 != null) {
                return a(a2);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        private a b(@Nullable ad adVar) {
            return a(HttpRequest.METHOD_DELETE, adVar);
        }

        private a c(ad adVar) {
            return a(HttpRequest.METHOD_PUT, adVar);
        }

        private a d(ad adVar) {
            return a(g.a.f536a, adVar);
        }

        public final a a() {
            return a(HttpRequest.METHOD_GET, (ad) null);
        }

        public final a a(u uVar) {
            this.f252c = uVar.b();
            return this;
        }

        public final a a(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f250a = vVar;
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final b.ac.a a(java.lang.String r8) {
            /*
                r7 = this;
                if (r8 != 0) goto L_0x000a
                java.lang.NullPointerException r8 = new java.lang.NullPointerException
                java.lang.String r0 = "url == null"
                r8.<init>(r0)
                throw r8
            L_0x000a:
                r2 = 1
                r3 = 0
                java.lang.String r4 = "ws:"
                r5 = 0
                r6 = 3
                r1 = r8
                boolean r0 = r1.regionMatches(r2, r3, r4, r5, r6)
                if (r0 == 0) goto L_0x002b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "http:"
                r0.<init>(r1)
                r1 = 3
            L_0x001f:
                java.lang.String r8 = r8.substring(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                goto L_0x0041
            L_0x002b:
                r1 = 1
                r2 = 0
                java.lang.String r3 = "wss:"
                r4 = 0
                r5 = 4
                r0 = r8
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L_0x0041
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "https:"
                r0.<init>(r1)
                r1 = 4
                goto L_0x001f
            L_0x0041:
                b.v r0 = b.v.d(r8)
                if (r0 != 0) goto L_0x005b
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "unexpected url: "
                r1.<init>(r2)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                r0.<init>(r8)
                throw r0
            L_0x005b:
                b.ac$a r8 = r7.a((b.v) r0)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b.ac.a.a(java.lang.String):b.ac$a");
        }

        public final a a(String str, @Nullable ad adVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (adVar != null && !f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (adVar != null || !f.b(str)) {
                this.f251b = str;
                this.d = adVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public final a a(String str, String str2) {
            this.f252c.c(str, str2);
            return this;
        }

        public final a b() {
            return a("HEAD", (ad) null);
        }

        public final a b(String str) {
            this.f252c.b(str);
            return this;
        }

        public final a b(String str, String str2) {
            this.f252c.a(str, str2);
            return this;
        }

        public final a c() {
            return a(HttpRequest.METHOD_DELETE, c.d);
        }

        public final ac d() {
            if (this.f250a != null) {
                return new ac(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    ac(a aVar) {
        this.f247a = aVar.f250a;
        this.f248b = aVar.f251b;
        this.f249c = aVar.f252c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    private List<String> b(String str) {
        return this.f249c.b(str);
    }

    private u e() {
        return this.f249c;
    }

    @Nullable
    private ad f() {
        return this.d;
    }

    private Object g() {
        return this.e;
    }

    private boolean h() {
        return this.f247a.b();
    }

    public final v a() {
        return this.f247a;
    }

    public final String a(String str) {
        return this.f249c.a(str);
    }

    public final String b() {
        return this.f248b;
    }

    public final a c() {
        return new a(this);
    }

    public final d d() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f249c);
        this.f = a2;
        return a2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f248b);
        sb.append(", url=");
        sb.append(this.f247a);
        sb.append(", tag=");
        sb.append(this.e != this ? this.e : null);
        sb.append('}');
        return sb.toString();
    }
}
