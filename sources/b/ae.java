package b;

import b.u;
import c.c;
import c.e;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class ae implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final ac f260a;

    /* renamed from: b  reason: collision with root package name */
    public final aa f261b;

    /* renamed from: c  reason: collision with root package name */
    public final int f262c;
    public final String d;
    @Nullable
    public final t e;
    public final u f;
    @Nullable
    public final af g;
    @Nullable
    public final ae h;
    @Nullable
    final ae i;
    @Nullable
    final ae j;
    public final long k;
    public final long l;
    private volatile d m;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ac f263a;

        /* renamed from: b  reason: collision with root package name */
        public aa f264b;

        /* renamed from: c  reason: collision with root package name */
        public int f265c;
        public String d;
        @Nullable
        public t e;
        u.a f;
        public af g;
        ae h;
        ae i;
        public ae j;
        public long k;
        public long l;

        public a() {
            this.f265c = -1;
            this.f = new u.a();
        }

        a(ae aeVar) {
            this.f265c = -1;
            this.f263a = aeVar.f260a;
            this.f264b = aeVar.f261b;
            this.f265c = aeVar.f262c;
            this.d = aeVar.d;
            this.e = aeVar.e;
            this.f = aeVar.f.b();
            this.g = aeVar.g;
            this.h = aeVar.h;
            this.i = aeVar.i;
            this.j = aeVar.j;
            this.k = aeVar.k;
            this.l = aeVar.l;
        }

        private a a(int i2) {
            this.f265c = i2;
            return this;
        }

        private a a(long j2) {
            this.k = j2;
            return this;
        }

        private a a(aa aaVar) {
            this.f264b = aaVar;
            return this;
        }

        private a a(ac acVar) {
            this.f263a = acVar;
            return this;
        }

        private a a(@Nullable t tVar) {
            this.e = tVar;
            return this;
        }

        private a a(String str) {
            this.d = str;
            return this;
        }

        private static void a(String str, ae aeVar) {
            if (aeVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (aeVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (aeVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (aeVar.j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private a b(long j2) {
            this.l = j2;
            return this;
        }

        private a b(String str) {
            this.f.b(str);
            return this;
        }

        private a b(String str, String str2) {
            this.f.c(str, str2);
            return this;
        }

        private a c(@Nullable ae aeVar) {
            if (aeVar == null || aeVar.g == null) {
                this.j = aeVar;
                return this;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }

        private static void d(ae aeVar) {
            if (aeVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public final a a(@Nullable ae aeVar) {
            if (aeVar != null) {
                a("networkResponse", aeVar);
            }
            this.h = aeVar;
            return this;
        }

        public final a a(@Nullable af afVar) {
            this.g = afVar;
            return this;
        }

        public final a a(u uVar) {
            this.f = uVar.b();
            return this;
        }

        public final a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public final ae a() {
            if (this.f263a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f264b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f265c < 0) {
                throw new IllegalStateException("code < 0: " + this.f265c);
            } else if (this.d != null) {
                return new ae(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public final a b(@Nullable ae aeVar) {
            if (aeVar != null) {
                a("cacheResponse", aeVar);
            }
            this.i = aeVar;
            return this;
        }
    }

    ae(a aVar) {
        this.f260a = aVar.f263a;
        this.f261b = aVar.f264b;
        this.f262c = aVar.f265c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    private af a(long j2) throws IOException {
        e source = this.g.source();
        source.b(j2);
        c x = source.a().clone();
        if (x.f387c > j2) {
            c cVar = new c();
            cVar.a(x, j2);
            x.w();
            x = cVar;
        }
        return af.create(this.g.contentType(), x.f387c, x);
    }

    private List<String> b(String str) {
        return this.f.b(str);
    }

    @Nullable
    private String c(String str) {
        String a2 = this.f.a(str);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    private ac g() {
        return this.f260a;
    }

    private aa h() {
        return this.f261b;
    }

    private boolean i() {
        return this.f262c >= 200 && this.f262c < 300;
    }

    private t j() {
        return this.e;
    }

    private boolean k() {
        switch (this.f262c) {
            case 300:
            case SET_ENABLED_VALUE:
            case SET_VISIBLE_VALUE:
            case SET_TITLE_TEXT_VALUE:
            case 307:
            case 308:
                return true;
            default:
                return false;
        }
    }

    @Nullable
    private ae l() {
        return this.h;
    }

    @Nullable
    private ae m() {
        return this.i;
    }

    @Nullable
    private ae n() {
        return this.j;
    }

    private List<h> o() {
        String str;
        if (this.f262c == 401) {
            str = "WWW-Authenticate";
        } else if (this.f262c != 407) {
            return Collections.emptyList();
        } else {
            str = "Proxy-Authenticate";
        }
        return b.a.d.e.a(this.f, str);
    }

    private long p() {
        return this.k;
    }

    private long q() {
        return this.l;
    }

    public final int a() {
        return this.f262c;
    }

    @Nullable
    public final String a(String str) {
        String a2 = this.f.a(str);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public final String b() {
        return this.d;
    }

    public final u c() {
        return this.f;
    }

    public final void close() {
        this.g.close();
    }

    @Nullable
    public final af d() {
        return this.g;
    }

    public final a e() {
        return new a(this);
    }

    public final d f() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f);
        this.m = a2;
        return a2;
    }

    public final String toString() {
        return "Response{protocol=" + this.f261b + ", code=" + this.f262c + ", message=" + this.d + ", url=" + this.f260a.f247a + '}';
    }
}
