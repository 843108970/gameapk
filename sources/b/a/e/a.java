package b.a.e;

import b.a.c.g;
import b.a.d.h;
import b.a.d.i;
import b.a.d.k;
import b.ac;
import b.ae;
import b.af;
import b.u;
import b.v;
import b.z;
import c.j;
import c.p;
import c.x;
import c.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

public final class a implements b.a.d.c {
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 4;
    private static final int l = 5;
    private static final int m = 6;

    /* renamed from: b  reason: collision with root package name */
    final z f93b;

    /* renamed from: c  reason: collision with root package name */
    final g f94c;
    final c.e d;
    final c.d e;
    int f = 0;

    /* renamed from: b.a.e.a$a  reason: collision with other inner class name */
    private abstract class C0000a implements y {

        /* renamed from: a  reason: collision with root package name */
        protected final j f95a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f96b;

        private C0000a() {
            this.f95a = new j(a.this.d.timeout());
        }

        /* synthetic */ C0000a(a aVar, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z) throws IOException {
            if (a.this.f != 6) {
                if (a.this.f != 5) {
                    throw new IllegalStateException("state: " + a.this.f);
                }
                a.a(this.f95a);
                a.this.f = 6;
                if (a.this.f94c != null) {
                    a.this.f94c.a(!z, (b.a.d.c) a.this);
                }
            }
        }

        public c.z timeout() {
            return this.f95a;
        }
    }

    private final class b implements x {

        /* renamed from: b  reason: collision with root package name */
        private final j f99b = new j(a.this.e.timeout());

        /* renamed from: c  reason: collision with root package name */
        private boolean f100c;

        b() {
        }

        public final void a(c.c cVar, long j) throws IOException {
            if (this.f100c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                a.this.e.m(j);
                a.this.e.b(IOUtils.LINE_SEPARATOR_WINDOWS);
                a.this.e.a(cVar, j);
                a.this.e.b(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.f100c) {
                this.f100c = true;
                a.this.e.b("0\r\n\r\n");
                a.a(this.f99b);
                a.this.f = 3;
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.f100c) {
                a.this.e.flush();
            }
        }

        public final c.z timeout() {
            return this.f99b;
        }
    }

    private class c extends C0000a {
        private static final long e = -1;
        private final v f;
        private long g = -1;
        private boolean h = true;

        c(v vVar) {
            super(a.this, (byte) 0);
            this.f = vVar;
        }

        private void a() throws IOException {
            if (this.g != -1) {
                a.this.d.s();
            }
            try {
                this.g = a.this.d.o();
                String trim = a.this.d.s().trim();
                if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                } else if (this.g == 0) {
                    this.h = false;
                    b.a.d.e.a(a.this.f93b.k, this.f, a.this.d());
                    a(true);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public final void close() throws IOException {
            if (!this.f96b) {
                if (this.h && !b.a.c.a((y) this, TimeUnit.MILLISECONDS)) {
                    a(false);
                }
                this.f96b = true;
            }
        }

        public final long read(c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f96b) {
                throw new IllegalStateException("closed");
            } else if (!this.h) {
                return -1;
            } else {
                if (this.g == 0 || this.g == -1) {
                    if (this.g != -1) {
                        a.this.d.s();
                    }
                    try {
                        this.g = a.this.d.o();
                        String trim = a.this.d.s().trim();
                        if (this.g < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + trim + "\"");
                        }
                        if (this.g == 0) {
                            this.h = false;
                            b.a.d.e.a(a.this.f93b.k, this.f, a.this.d());
                            a(true);
                        }
                        if (!this.h) {
                            return -1;
                        }
                    } catch (NumberFormatException e2) {
                        throw new ProtocolException(e2.getMessage());
                    }
                }
                long read = a.this.d.read(cVar, Math.min(j, this.g));
                if (read == -1) {
                    a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.g -= read;
                return read;
            }
        }
    }

    private final class d implements x {

        /* renamed from: b  reason: collision with root package name */
        private final j f102b = new j(a.this.e.timeout());

        /* renamed from: c  reason: collision with root package name */
        private boolean f103c;
        private long d;

        d(long j) {
            this.d = j;
        }

        public final void a(c.c cVar, long j) throws IOException {
            if (this.f103c) {
                throw new IllegalStateException("closed");
            }
            b.a.c.a(cVar.f387c, 0, j);
            if (j > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            a.this.e.a(cVar, j);
            this.d -= j;
        }

        public final void close() throws IOException {
            if (!this.f103c) {
                this.f103c = true;
                if (this.d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                a.a(this.f102b);
                a.this.f = 3;
            }
        }

        public final void flush() throws IOException {
            if (!this.f103c) {
                a.this.e.flush();
            }
        }

        public final c.z timeout() {
            return this.f102b;
        }
    }

    private class e extends C0000a {
        private long e;

        e(long j) throws IOException {
            super(a.this, (byte) 0);
            this.e = j;
            if (this.e == 0) {
                a(true);
            }
        }

        public final void close() throws IOException {
            if (!this.f96b) {
                if (this.e != 0 && !b.a.c.a((y) this, TimeUnit.MILLISECONDS)) {
                    a(false);
                }
                this.f96b = true;
            }
        }

        public final long read(c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f96b) {
                throw new IllegalStateException("closed");
            } else if (this.e == 0) {
                return -1;
            } else {
                long read = a.this.d.read(cVar, Math.min(this.e, j));
                if (read == -1) {
                    a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.e -= read;
                if (this.e == 0) {
                    a(true);
                }
                return read;
            }
        }
    }

    private class f extends C0000a {
        private boolean e;

        f() {
            super(a.this, (byte) 0);
        }

        public final void close() throws IOException {
            if (!this.f96b) {
                if (!this.e) {
                    a(false);
                }
                this.f96b = true;
            }
        }

        public final long read(c.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f96b) {
                throw new IllegalStateException("closed");
            } else if (this.e) {
                return -1;
            } else {
                long read = a.this.d.read(cVar, j);
                if (read != -1) {
                    return read;
                }
                this.e = true;
                a(true);
                return -1;
            }
        }
    }

    public a(z zVar, g gVar, c.e eVar, c.d dVar) {
        this.f93b = zVar;
        this.f94c = gVar;
        this.d = eVar;
        this.e = dVar;
    }

    private y a(v vVar) throws IOException {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 5;
        return new c(vVar);
    }

    static void a(j jVar) {
        c.z zVar = jVar.f394a;
        c.z zVar2 = c.z.f436c;
        if (zVar2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        jVar.f394a = zVar2;
        zVar.n_();
        zVar.d();
    }

    private x b(long j2) {
        if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 2;
        return new d(j2);
    }

    private y b(ae aeVar) throws IOException {
        if (!b.a.d.e.d(aeVar)) {
            return a(0);
        }
        if ("chunked".equalsIgnoreCase(aeVar.a("Transfer-Encoding"))) {
            v vVar = aeVar.f260a.f247a;
            if (this.f != 4) {
                throw new IllegalStateException("state: " + this.f);
            }
            this.f = 5;
            return new c(vVar);
        }
        long a2 = b.a.d.e.a(aeVar);
        if (a2 != -1) {
            return a(a2);
        }
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        } else if (this.f94c == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.f = 5;
            this.f94c.d();
            return new f();
        }
    }

    private boolean e() {
        return this.f == 6;
    }

    private x f() {
        if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 2;
        return new b();
    }

    private y g() throws IOException {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        } else if (this.f94c == null) {
            throw new IllegalStateException("streamAllocation == null");
        } else {
            this.f = 5;
            this.f94c.d();
            return new f();
        }
    }

    public final ae.a a(boolean z) throws IOException {
        if (this.f == 1 || this.f == 3) {
            try {
                k a2 = k.a(this.d.s());
                ae.a aVar = new ae.a();
                aVar.f264b = a2.d;
                aVar.f265c = a2.e;
                aVar.d = a2.f;
                ae.a a3 = aVar.a(d());
                if (z && a2.e == 100) {
                    return null;
                }
                this.f = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f94c);
                iOException.initCause(e2);
                throw iOException;
            }
        } else {
            throw new IllegalStateException("state: " + this.f);
        }
    }

    public final af a(ae aeVar) throws IOException {
        y yVar;
        if (!b.a.d.e.d(aeVar)) {
            yVar = a(0);
        } else if ("chunked".equalsIgnoreCase(aeVar.a("Transfer-Encoding"))) {
            v vVar = aeVar.f260a.f247a;
            if (this.f != 4) {
                throw new IllegalStateException("state: " + this.f);
            }
            this.f = 5;
            yVar = new c(vVar);
        } else {
            long a2 = b.a.d.e.a(aeVar);
            if (a2 != -1) {
                yVar = a(a2);
            } else if (this.f != 4) {
                throw new IllegalStateException("state: " + this.f);
            } else if (this.f94c == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.f = 5;
                this.f94c.d();
                yVar = new f();
            }
        }
        return new h(aeVar.f, p.a(yVar));
    }

    public final x a(ac acVar, long j2) {
        if ("chunked".equalsIgnoreCase(acVar.a("Transfer-Encoding"))) {
            if (this.f != 1) {
                throw new IllegalStateException("state: " + this.f);
            }
            this.f = 2;
            return new b();
        } else if (j2 == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f != 1) {
            throw new IllegalStateException("state: " + this.f);
        } else {
            this.f = 2;
            return new d(j2);
        }
    }

    public final y a(long j2) throws IOException {
        if (this.f != 4) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.f = 5;
        return new e(j2);
    }

    public final void a() throws IOException {
        this.e.flush();
    }

    public final void a(ac acVar) throws IOException {
        Proxy.Type type = this.f94c.b().f60a.f273b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(acVar.f248b);
        sb.append(' ');
        if (!acVar.f247a.b() && type == Proxy.Type.HTTP) {
            sb.append(acVar.f247a);
        } else {
            sb.append(i.a(acVar.f247a));
        }
        sb.append(" HTTP/1.1");
        a(acVar.f249c, sb.toString());
    }

    public final void a(u uVar, String str) throws IOException {
        if (this.f != 0) {
            throw new IllegalStateException("state: " + this.f);
        }
        this.e.b(str).b(IOUtils.LINE_SEPARATOR_WINDOWS);
        int length = uVar.f350a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            this.e.b(uVar.a(i2)).b(": ").b(uVar.b(i2)).b(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        this.e.b(IOUtils.LINE_SEPARATOR_WINDOWS);
        this.f = 1;
    }

    public final void b() throws IOException {
        this.e.flush();
    }

    public final void c() {
        b.a.c.c b2 = this.f94c.b();
        if (b2 != null) {
            b.a.c.a(b2.f61b);
        }
    }

    public final u d() throws IOException {
        u.a aVar = new u.a();
        while (true) {
            String s = this.d.s();
            if (s.length() == 0) {
                return aVar.a();
            }
            b.a.a.f11a.a(aVar, s);
        }
    }
}
