package b;

import b.a.a.d;
import b.a.a.f;
import b.a.d.k;
import b.ac;
import b.ae;
import b.u;
import c.e;
import c.h;
import c.i;
import c.p;
import c.x;
import c.y;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

public final class c implements Closeable, Flushable {
    private static final int e = 201105;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;

    /* renamed from: a  reason: collision with root package name */
    final f f280a;

    /* renamed from: b  reason: collision with root package name */
    final d f281b;

    /* renamed from: c  reason: collision with root package name */
    int f282c;
    int d;
    private int i;
    private int j;
    private int k;

    private final class a implements b.a.a.b {

        /* renamed from: a  reason: collision with root package name */
        boolean f287a;

        /* renamed from: c  reason: collision with root package name */
        private final d.a f289c;
        private x d;
        private x e;

        a(final d.a aVar) {
            this.f289c = aVar;
            this.d = aVar.a(1);
            this.e = new h(this.d, c.this) {
                public final void close() throws IOException {
                    synchronized (c.this) {
                        if (!a.this.f287a) {
                            a.this.f287a = true;
                            c.this.f282c++;
                            super.close();
                            aVar.b();
                        }
                    }
                }
            };
        }

        public final void a() {
            synchronized (c.this) {
                if (!this.f287a) {
                    this.f287a = true;
                    c.this.d++;
                    b.a.c.a((Closeable) this.d);
                    try {
                        this.f289c.c();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public final x b() {
            return this.e;
        }
    }

    private static class b extends af {

        /* renamed from: a  reason: collision with root package name */
        final d.c f293a;

        /* renamed from: b  reason: collision with root package name */
        private final e f294b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f295c;
        @Nullable
        private final String d;

        b(final d.c cVar, String str, String str2) {
            this.f293a = cVar;
            this.f295c = str;
            this.d = str2;
            this.f294b = p.a((y) new i(cVar.f39c[1]) {
                public final void close() throws IOException {
                    cVar.close();
                    super.close();
                }
            });
        }

        public final long contentLength() {
            try {
                if (this.d != null) {
                    return Long.parseLong(this.d);
                }
            } catch (NumberFormatException unused) {
            }
            return -1;
        }

        public final x contentType() {
            if (this.f295c != null) {
                return x.a(this.f295c);
            }
            return null;
        }

        public final e source() {
            return this.f294b;
        }
    }

    /* renamed from: b.c$c  reason: collision with other inner class name */
    private static final class C0004c {
        private static final String k;
        private static final String l;

        /* renamed from: a  reason: collision with root package name */
        final String f298a;

        /* renamed from: b  reason: collision with root package name */
        final u f299b;

        /* renamed from: c  reason: collision with root package name */
        final String f300c;
        final aa d;
        final int e;
        final String f;
        final u g;
        @Nullable
        final t h;
        final long i;
        final long j;

        static {
            StringBuilder sb = new StringBuilder();
            b.a.h.e.b();
            sb.append(b.a.h.e.c());
            sb.append("-Sent-Millis");
            k = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            b.a.h.e.b();
            sb2.append(b.a.h.e.c());
            sb2.append("-Received-Millis");
            l = sb2.toString();
        }

        C0004c(ae aeVar) {
            this.f298a = aeVar.f260a.f247a.toString();
            this.f299b = b.a.d.e.c(aeVar);
            this.f300c = aeVar.f260a.f248b;
            this.d = aeVar.f261b;
            this.e = aeVar.f262c;
            this.f = aeVar.d;
            this.g = aeVar.f;
            this.h = aeVar.e;
            this.i = aeVar.k;
            this.j = aeVar.l;
        }

        C0004c(y yVar) throws IOException {
            try {
                e a2 = p.a(yVar);
                this.f298a = a2.s();
                this.f300c = a2.s();
                u.a aVar = new u.a();
                int a3 = c.a(a2);
                for (int i2 = 0; i2 < a3; i2++) {
                    aVar.a(a2.s());
                }
                this.f299b = aVar.a();
                k a4 = k.a(a2.s());
                this.d = a4.d;
                this.e = a4.e;
                this.f = a4.f;
                u.a aVar2 = new u.a();
                int a5 = c.a(a2);
                for (int i3 = 0; i3 < a5; i3++) {
                    aVar2.a(a2.s());
                }
                String c2 = aVar2.c(k);
                String c3 = aVar2.c(l);
                aVar2.b(k);
                aVar2.b(l);
                long j2 = 0;
                this.i = c2 != null ? Long.parseLong(c2) : 0;
                this.j = c3 != null ? Long.parseLong(c3) : j2;
                this.g = aVar2.a();
                if (a()) {
                    String s = a2.s();
                    if (s.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + s + "\"");
                    }
                    i a6 = i.a(a2.s());
                    List<Certificate> a7 = a(a2);
                    List<Certificate> a8 = a(a2);
                    ah forJavaName = !a2.d() ? ah.forJavaName(a2.s()) : ah.SSL_3_0;
                    if (forJavaName == null) {
                        throw new NullPointerException("tlsVersion == null");
                    } else if (a6 == null) {
                        throw new NullPointerException("cipherSuite == null");
                    } else {
                        this.h = new t(forJavaName, a6, b.a.c.a(a7), b.a.c.a(a8));
                    }
                } else {
                    this.h = null;
                }
            } finally {
                yVar.close();
            }
        }

        private ae a(d.c cVar) {
            String a2 = this.g.a("Content-Type");
            String a3 = this.g.a("Content-Length");
            ac d2 = new ac.a().a(this.f298a).a(this.f300c, (ad) null).a(this.f299b).d();
            ae.a aVar = new ae.a();
            aVar.f263a = d2;
            aVar.f264b = this.d;
            aVar.f265c = this.e;
            aVar.d = this.f;
            ae.a a4 = aVar.a(this.g);
            a4.g = new b(cVar, a2, a3);
            a4.e = this.h;
            a4.k = this.i;
            a4.l = this.j;
            return a4.a();
        }

        private static List<Certificate> a(e eVar) throws IOException {
            int a2 = c.a(eVar);
            if (a2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a2);
                for (int i2 = 0; i2 < a2; i2++) {
                    String s = eVar.s();
                    c.c cVar = new c.c();
                    cVar.e(c.f.decodeBase64(s));
                    arrayList.add(instance.generateCertificate(cVar.e()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private static void a(c.d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.n((long) list.size()).l(10);
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    dVar.b(c.f.of(list.get(i2).getEncoded()).base64()).l(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private boolean a() {
            return this.f298a.startsWith("https://");
        }

        private boolean a(ac acVar, ae aeVar) {
            return this.f298a.equals(acVar.f247a.toString()) && this.f300c.equals(acVar.f248b) && b.a.d.e.a(aeVar, this.f299b, acVar);
        }

        public final void a(d.a aVar) throws IOException {
            c.d a2 = p.a(aVar.a(0));
            a2.b(this.f298a).l(10);
            a2.b(this.f300c).l(10);
            a2.n((long) (this.f299b.f350a.length / 2)).l(10);
            int length = this.f299b.f350a.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                a2.b(this.f299b.a(i2)).b(": ").b(this.f299b.b(i2)).l(10);
            }
            a2.b(new k(this.d, this.e, this.f).toString()).l(10);
            a2.n((long) ((this.g.f350a.length / 2) + 2)).l(10);
            int length2 = this.g.f350a.length / 2;
            for (int i3 = 0; i3 < length2; i3++) {
                a2.b(this.g.a(i3)).b(": ").b(this.g.b(i3)).l(10);
            }
            a2.b(k).b(": ").n(this.i).l(10);
            a2.b(l).b(": ").n(this.j).l(10);
            if (a()) {
                a2.l(10);
                a2.b(this.h.f348b.bj).l(10);
                a(a2, this.h.f349c);
                a(a2, this.h.d);
                a2.b(this.h.f347a.javaName()).l(10);
            }
            a2.close();
        }
    }

    private c(File file, long j2) {
        this(file, j2, b.a.g.a.f181a);
    }

    private c(File file, long j2, b.a.g.a aVar) {
        this.f280a = new f() {
            public final b.a.a.b a(ae aeVar) throws IOException {
                return c.this.a(aeVar);
            }

            public final ae a(ac acVar) throws IOException {
                return c.this.a(acVar);
            }

            public final void a() {
                c.this.a();
            }

            public final void a(b.a.a.c cVar) {
                c.this.a(cVar);
            }

            public final void a(ae aeVar, ae aeVar2) {
                d.a aVar;
                C0004c cVar = new C0004c(aeVar2);
                d.c cVar2 = ((b) aeVar.g).f293a;
                try {
                    aVar = d.this.a(cVar2.f37a, cVar2.f38b);
                    if (aVar != null) {
                        try {
                            cVar.a(aVar);
                            aVar.b();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException unused2) {
                    aVar = null;
                    c.a(aVar);
                }
            }

            public final void b(ac acVar) throws IOException {
                c.this.b(acVar);
            }
        };
        this.f281b = d.a(aVar, file, j2);
    }

    static int a(e eVar) throws IOException {
        try {
            long n = eVar.n();
            String s = eVar.s();
            if (n >= 0 && n <= 2147483647L) {
                if (s.isEmpty()) {
                    return (int) n;
                }
            }
            throw new IOException("expected an int but was \"" + n + s + "\"");
        } catch (NumberFormatException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private static String a(v vVar) {
        return c.f.encodeUtf8(vVar.toString()).md5().hex();
    }

    static void a(@Nullable d.a aVar) {
        if (aVar != null) {
            try {
                aVar.c();
            } catch (IOException unused) {
            }
        }
    }

    private static void a(ae aeVar, ae aeVar2) {
        d.a aVar;
        C0004c cVar = new C0004c(aeVar2);
        d.c cVar2 = ((b) aeVar.g).f293a;
        try {
            aVar = d.this.a(cVar2.f37a, cVar2.f38b);
            if (aVar != null) {
                try {
                    cVar.a(aVar);
                    aVar.b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            aVar = null;
            a(aVar);
        }
    }

    private void b() throws IOException {
        this.f281b.a();
    }

    private void c() throws IOException {
        this.f281b.h();
    }

    private void d() throws IOException {
        this.f281b.i();
    }

    private Iterator<String> e() throws IOException {
        return new Iterator<String>() {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<d.c> f284a = c.this.f281b.j();
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            String f285b;

            /* renamed from: c  reason: collision with root package name */
            boolean f286c;

            private String a() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.f285b;
                this.f285b = null;
                this.f286c = true;
                return str;
            }

            public final boolean hasNext() {
                if (this.f285b != null) {
                    return true;
                }
                this.f286c = false;
                while (this.f284a.hasNext()) {
                    d.c next = this.f284a.next();
                    try {
                        this.f285b = p.a(next.f39c[0]).s();
                        return true;
                    } catch (IOException unused) {
                    } finally {
                        next.close();
                    }
                }
                return false;
            }

            public final /* synthetic */ Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String str = this.f285b;
                this.f285b = null;
                this.f286c = true;
                return str;
            }

            public final void remove() {
                if (!this.f286c) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.f284a.remove();
            }
        };
    }

    private synchronized int f() {
        return this.d;
    }

    private synchronized int g() {
        return this.f282c;
    }

    private long h() throws IOException {
        return this.f281b.d();
    }

    private long i() {
        return this.f281b.c();
    }

    private File j() {
        return this.f281b.i;
    }

    private boolean k() {
        return this.f281b.f();
    }

    private synchronized int l() {
        return this.i;
    }

    private synchronized int m() {
        return this.j;
    }

    private synchronized int n() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final b.a.a.b a(ae aeVar) {
        d.a aVar;
        String str = aeVar.f260a.f248b;
        if (b.a.d.f.a(aeVar.f260a.f248b)) {
            try {
                b(aeVar.f260a);
            } catch (IOException unused) {
            }
            return null;
        } else if (!str.equals(HttpRequest.METHOD_GET) || b.a.d.e.b(aeVar)) {
            return null;
        } else {
            C0004c cVar = new C0004c(aeVar);
            try {
                aVar = this.f281b.a(a(aeVar.f260a.f247a), -1);
                if (aVar == null) {
                    return null;
                }
                try {
                    cVar.a(aVar);
                    return new a(aVar);
                } catch (IOException unused2) {
                    a(aVar);
                    return null;
                }
            } catch (IOException unused3) {
                aVar = null;
                a(aVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final ae a(ac acVar) {
        try {
            d.c a2 = this.f281b.a(a(acVar.f247a));
            if (a2 == null) {
                return null;
            }
            try {
                boolean z = false;
                C0004c cVar = new C0004c(a2.f39c[0]);
                String a3 = cVar.g.a("Content-Type");
                String a4 = cVar.g.a("Content-Length");
                ac d2 = new ac.a().a(cVar.f298a).a(cVar.f300c, (ad) null).a(cVar.f299b).d();
                ae.a aVar = new ae.a();
                aVar.f263a = d2;
                aVar.f264b = cVar.d;
                aVar.f265c = cVar.e;
                aVar.d = cVar.f;
                ae.a a5 = aVar.a(cVar.g);
                a5.g = new b(a2, a3, a4);
                a5.e = cVar.h;
                a5.k = cVar.i;
                a5.l = cVar.j;
                ae a6 = a5.a();
                if (cVar.f298a.equals(acVar.f247a.toString()) && cVar.f300c.equals(acVar.f248b) && b.a.d.e.a(a6, cVar.f299b, acVar)) {
                    z = true;
                }
                if (z) {
                    return a6;
                }
                b.a.c.a((Closeable) a6.g);
                return null;
            } catch (IOException unused) {
                b.a.c.a((Closeable) a2);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        this.j++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(b.a.a.c r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            int r0 = r1.k     // Catch:{ all -> 0x001f }
            int r0 = r0 + 1
            r1.k = r0     // Catch:{ all -> 0x001f }
            b.ac r0 = r2.f16a     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0013
            int r2 = r1.i     // Catch:{ all -> 0x001f }
            int r2 = r2 + 1
            r1.i = r2     // Catch:{ all -> 0x001f }
            monitor-exit(r1)
            return
        L_0x0013:
            b.ae r2 = r2.f17b     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            int r2 = r1.j     // Catch:{ all -> 0x001f }
            int r2 = r2 + 1
            r1.j = r2     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a(b.a.a.c):void");
    }

    /* access modifiers changed from: package-private */
    public final void b(ac acVar) throws IOException {
        this.f281b.b(a(acVar.f247a));
    }

    public final void close() throws IOException {
        this.f281b.close();
    }

    public final void flush() throws IOException {
        this.f281b.flush();
    }
}
