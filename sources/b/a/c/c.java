package b.a.c;

import android.support.v7.widget.ActivityChooserView;
import b.a.e.a;
import b.a.f.b;
import b.a.f.f;
import b.a.f.g;
import b.a.f.i;
import b.a.k.a;
import b.aa;
import b.ac;
import b.ae;
import b.ag;
import b.j;
import b.k;
import b.t;
import b.v;
import b.z;
import c.d;
import c.e;
import c.p;
import c.y;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class c extends g.b implements j {
    private static final String n = "throw with null exception";

    /* renamed from: a  reason: collision with root package name */
    public final ag f60a;

    /* renamed from: b  reason: collision with root package name */
    public Socket f61b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f62c;
    public t d;
    g e;
    public e f;
    public d g;
    public boolean h;
    public int i;
    public int j = 1;
    public final List<Reference<g>> k = new ArrayList();
    public long l = Long.MAX_VALUE;
    private final k o;
    private aa p;

    public c(k kVar, ag agVar) {
        this.o = kVar;
        this.f60a = agVar;
    }

    private static c a(k kVar, ag agVar, Socket socket, long j2) {
        c cVar = new c(kVar, agVar);
        cVar.f62c = socket;
        cVar.l = j2;
        return cVar;
    }

    private b.a.d.c a(z zVar, g gVar) throws SocketException {
        if (this.e != null) {
            return new f(zVar, gVar, this.e);
        }
        this.f62c.setSoTimeout(zVar.A);
        this.f.timeout().a((long) zVar.A, TimeUnit.MILLISECONDS);
        this.g.timeout().a((long) zVar.B, TimeUnit.MILLISECONDS);
        return new a(zVar, gVar, this.f, this.g);
    }

    private a.e a(final g gVar) {
        return new a.e(this.f, this.g) {
            public final void close() throws IOException {
                gVar.a(true, gVar.a());
            }
        };
    }

    private ac a(int i2, int i3, ac acVar, v vVar) throws IOException {
        b.a.e.a aVar = new b.a.e.a((z) null, (g) null, this.f, this.g);
        this.f.timeout().a((long) i2, TimeUnit.MILLISECONDS);
        this.g.timeout().a((long) i3, TimeUnit.MILLISECONDS);
        aVar.a(acVar.f249c, "CONNECT " + b.a.c.a(vVar, true) + " HTTP/1.1");
        aVar.b();
        ae.a a2 = aVar.a(false);
        a2.f263a = acVar;
        ae a3 = a2.a();
        long a4 = b.a.d.e.a(a3);
        if (a4 == -1) {
            a4 = 0;
        }
        y a5 = aVar.a(a4);
        b.a.c.a(a5, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
        a5.close();
        int i4 = a3.f262c;
        if (i4 != 200) {
            if (i4 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a3.f262c);
            }
            this.f60a.f272a.d.a();
            throw new IOException("Failed to authenticate with proxy");
        } else if (this.f.a().d() && this.g.a().d()) {
            return null;
        } else {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    private void a(int i2, int i3) throws IOException {
        Proxy proxy = this.f60a.f273b;
        this.f61b = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.f60a.f272a.f10c.createSocket() : new Socket(proxy);
        this.f61b.setSoTimeout(i3);
        try {
            b.a.h.e.b().a(this.f61b, this.f60a.f274c, i2);
            try {
                this.f = p.a(p.b(this.f61b));
                this.g = p.a(p.a(this.f61b));
            } catch (NullPointerException e2) {
                if (n.equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f60a.f274c);
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(int i2, int i3, int i4) throws IOException {
        ac d2 = new ac.a().a(this.f60a.f272a.f8a).a(HttpHeaders.HOST, b.a.c.a(this.f60a.f272a.f8a, true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", "okhttp/3.8.0").d();
        v vVar = d2.f247a;
        a(i2, i3);
        String str = "CONNECT " + b.a.c.a(vVar, true) + " HTTP/1.1";
        b.a.e.a aVar = new b.a.e.a((z) null, (g) null, this.f, this.g);
        this.f.timeout().a((long) i3, TimeUnit.MILLISECONDS);
        this.g.timeout().a((long) i4, TimeUnit.MILLISECONDS);
        aVar.a(d2.f249c, str);
        aVar.b();
        ae.a a2 = aVar.a(false);
        a2.f263a = d2;
        ae a3 = a2.a();
        long a4 = b.a.d.e.a(a3);
        if (a4 == -1) {
            a4 = 0;
        }
        y a5 = aVar.a(a4);
        b.a.c.a(a5, (int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.MILLISECONDS);
        a5.close();
        int i5 = a3.f262c;
        if (i5 != 200) {
            if (i5 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a3.f262c);
            }
            this.f60a.f272a.d.a();
            throw new IOException("Failed to authenticate with proxy");
        } else if (!this.f.a().d() || !this.g.a().d()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01a9 A[Catch:{ all -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01af A[Catch:{ all -> 0x019f }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b2  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(b.a.c.b r9) throws java.io.IOException {
        /*
            r8 = this;
            b.ag r0 = r8.f60a
            b.a r0 = r0.f272a
            javax.net.ssl.SSLSocketFactory r0 = r0.i
            if (r0 != 0) goto L_0x0011
            b.aa r9 = b.aa.HTTP_1_1
            r8.p = r9
            java.net.Socket r9 = r8.f61b
            r8.f62c = r9
            return
        L_0x0011:
            b.ag r0 = r8.f60a
            b.a r0 = r0.f272a
            javax.net.ssl.SSLSocketFactory r1 = r0.i
            r2 = 0
            java.net.Socket r3 = r8.f61b     // Catch:{ AssertionError -> 0x01a2 }
            b.v r4 = r0.f8a     // Catch:{ AssertionError -> 0x01a2 }
            java.lang.String r4 = r4.l     // Catch:{ AssertionError -> 0x01a2 }
            b.v r5 = r0.f8a     // Catch:{ AssertionError -> 0x01a2 }
            int r5 = r5.m     // Catch:{ AssertionError -> 0x01a2 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x01a2 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x01a2 }
            int r3 = r9.f58b     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.util.List<b.l> r4 = r9.f57a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            int r4 = r4.size()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x0031:
            if (r3 >= r4) goto L_0x0048
            java.util.List<b.l> r5 = r9.f57a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.l r5 = (b.l) r5     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r7 = r5.a(r1)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            if (r7 == 0) goto L_0x0045
            int r3 = r3 + r6
            r9.f58b = r3     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            goto L_0x0049
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x0031
        L_0x0048:
            r5 = r2
        L_0x0049:
            if (r5 != 0) goto L_0x007b
            java.net.UnknownServiceException r0 = new java.net.UnknownServiceException     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "Unable to find acceptable protocols. isFallback="
            r2.<init>(r3)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r3 = r9.d     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r2.append(r3)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r3 = ", modes="
            r2.append(r3)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.util.List<b.l> r9 = r9.f57a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r2.append(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r9 = ", supported protocols="
            r2.append(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String[] r9 = r1.getEnabledProtocols()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r9 = java.util.Arrays.toString(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r2.append(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r9 = r2.toString()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r0.<init>(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            throw r0     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x007b:
            boolean r3 = r9.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r9.f59c = r3     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.a.a r3 = b.a.a.f11a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r9 = r9.d     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.a((b.l) r5, (javax.net.ssl.SSLSocket) r1, (boolean) r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r9 = r5.e     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            if (r9 == 0) goto L_0x0099
            b.a.h.e r9 = b.a.h.e.b()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.v r3 = r0.f8a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r3 = r3.l     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.util.List<b.aa> r4 = r0.e     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r9.a((javax.net.ssl.SSLSocket) r1, (java.lang.String) r3, (java.util.List<b.aa>) r4)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x0099:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            javax.net.ssl.SSLSession r9 = r1.getSession()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.t r9 = b.t.a(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            javax.net.ssl.HostnameVerifier r3 = r0.j     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.v r4 = r0.f8a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r4 = r4.l     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            javax.net.ssl.SSLSession r6 = r1.getSession()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r3 = r3.verify(r4, r6)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r4 = 0
            if (r3 != 0) goto L_0x00fd
            java.util.List<java.security.cert.Certificate> r9 = r9.f349c     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.Object r9 = r9.get(r4)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r4 = "Hostname "
            r3.<init>(r4)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.v r0 = r0.f8a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = r0.l     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = b.g.a((java.security.cert.Certificate) r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.security.Principal r0 = r9.getSubjectDN()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.util.List r9 = b.a.j.d.a(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.append(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r9 = r3.toString()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r2.<init>(r9)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            throw r2     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x00fd:
            b.g r3 = r0.k     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            b.v r0 = r0.f8a     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r0 = r0.l     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.util.List<java.security.cert.Certificate> r6 = r9.f349c     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r3.a((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r6)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            boolean r0 = r5.e     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            if (r0 == 0) goto L_0x0114
            b.a.h.e r0 = b.a.h.e.b()     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.lang.String r2 = r0.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x0114:
            r8.f62c = r1     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.net.Socket r0 = r8.f62c     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            c.y r0 = c.p.b((java.net.Socket) r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            c.e r0 = c.p.a((c.y) r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r8.f = r0     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            java.net.Socket r0 = r8.f62c     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            c.x r0 = c.p.a((java.net.Socket) r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            c.d r0 = c.p.a((c.x) r0)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r8.g = r0     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            r8.d = r9     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            if (r2 == 0) goto L_0x0137
            b.aa r9 = b.aa.get(r2)     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            goto L_0x0139
        L_0x0137:
            b.aa r9 = b.aa.HTTP_1_1     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
        L_0x0139:
            r8.p = r9     // Catch:{ AssertionError -> 0x019c, all -> 0x019a }
            if (r1 == 0) goto L_0x0144
            b.a.h.e r9 = b.a.h.e.b()
            r9.b((javax.net.ssl.SSLSocket) r1)
        L_0x0144:
            b.aa r9 = r8.p
            b.aa r0 = b.aa.HTTP_2
            if (r9 != r0) goto L_0x0199
            java.net.Socket r9 = r8.f62c
            r9.setSoTimeout(r4)
            b.a.f.g$a r9 = new b.a.f.g$a
            r9.<init>()
            java.net.Socket r0 = r8.f62c
            b.ag r1 = r8.f60a
            b.a r1 = r1.f272a
            b.v r1 = r1.f8a
            java.lang.String r1 = r1.l
            c.e r2 = r8.f
            c.d r3 = r8.g
            b.a.f.g$a r9 = r9.a(r0, r1, r2, r3)
            r9.e = r8
            b.a.f.g r0 = new b.a.f.g
            r0.<init>(r9)
            r8.e = r0
            b.a.f.g r9 = r8.e
            b.a.f.j r0 = r9.q
            r0.a()
            b.a.f.j r0 = r9.q
            b.a.f.n r1 = r9.m
            r0.b(r1)
            b.a.f.n r0 = r9.m
            int r0 = r0.b()
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 == r1) goto L_0x018f
            b.a.f.j r2 = r9.q
            int r0 = r0 - r1
            long r0 = (long) r0
            r2.a((int) r4, (long) r0)
        L_0x018f:
            java.lang.Thread r0 = new java.lang.Thread
            b.a.f.g$c r9 = r9.r
            r0.<init>(r9)
            r0.start()
        L_0x0199:
            return
        L_0x019a:
            r9 = move-exception
            goto L_0x01b0
        L_0x019c:
            r9 = move-exception
            r2 = r1
            goto L_0x01a3
        L_0x019f:
            r9 = move-exception
            r1 = r2
            goto L_0x01b0
        L_0x01a2:
            r9 = move-exception
        L_0x01a3:
            boolean r0 = b.a.c.a((java.lang.AssertionError) r9)     // Catch:{ all -> 0x019f }
            if (r0 == 0) goto L_0x01af
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x019f }
            r0.<init>(r9)     // Catch:{ all -> 0x019f }
            throw r0     // Catch:{ all -> 0x019f }
        L_0x01af:
            throw r9     // Catch:{ all -> 0x019f }
        L_0x01b0:
            if (r1 == 0) goto L_0x01b9
            b.a.h.e r0 = b.a.h.e.b()
            r0.b((javax.net.ssl.SSLSocket) r1)
        L_0x01b9:
            b.a.c.a((java.net.Socket) r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.c.a(b.a.c.b):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0143 A[Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0149 A[Catch:{ all -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014c  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(b.a.c.b r9) throws java.io.IOException {
        /*
            r8 = this;
            b.ag r0 = r8.f60a
            b.a r0 = r0.f272a
            javax.net.ssl.SSLSocketFactory r1 = r0.i
            r2 = 0
            java.net.Socket r3 = r8.f61b     // Catch:{ AssertionError -> 0x013c }
            b.v r4 = r0.f8a     // Catch:{ AssertionError -> 0x013c }
            java.lang.String r4 = r4.l     // Catch:{ AssertionError -> 0x013c }
            b.v r5 = r0.f8a     // Catch:{ AssertionError -> 0x013c }
            int r5 = r5.m     // Catch:{ AssertionError -> 0x013c }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x013c }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x013c }
            int r3 = r9.f58b     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.util.List<b.l> r4 = r9.f57a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            int r4 = r4.size()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x0020:
            if (r3 >= r4) goto L_0x0037
            java.util.List<b.l> r5 = r9.f57a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.l r5 = (b.l) r5     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r7 = r5.a(r1)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r7 == 0) goto L_0x0034
            int r3 = r3 + r6
            r9.f58b = r3     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            goto L_0x0038
        L_0x0034:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0037:
            r5 = r2
        L_0x0038:
            if (r5 != 0) goto L_0x006a
            java.net.UnknownServiceException r0 = new java.net.UnknownServiceException     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r3 = "Unable to find acceptable protocols. isFallback="
            r2.<init>(r3)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r3 = r9.d     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r3 = ", modes="
            r2.append(r3)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.util.List<b.l> r9 = r9.f57a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r2.append(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r9 = ", supported protocols="
            r2.append(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String[] r9 = r1.getEnabledProtocols()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r9 = java.util.Arrays.toString(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r2.append(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r9 = r2.toString()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r0.<init>(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            throw r0     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x006a:
            boolean r3 = r9.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r9.f59c = r3     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.a.a r3 = b.a.a.f11a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r9 = r9.d     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.a((b.l) r5, (javax.net.ssl.SSLSocket) r1, (boolean) r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r9 = r5.e     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r9 == 0) goto L_0x0088
            b.a.h.e r9 = b.a.h.e.b()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.v r3 = r0.f8a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r3 = r3.l     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.util.List<b.aa> r4 = r0.e     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r9.a((javax.net.ssl.SSLSocket) r1, (java.lang.String) r3, (java.util.List<b.aa>) r4)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x0088:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            javax.net.ssl.SSLSession r9 = r1.getSession()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.t r9 = b.t.a(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            javax.net.ssl.HostnameVerifier r3 = r0.j     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.v r4 = r0.f8a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r4 = r4.l     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            javax.net.ssl.SSLSession r6 = r1.getSession()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r3 = r3.verify(r4, r6)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r3 != 0) goto L_0x00ec
            java.util.List<java.security.cert.Certificate> r9 = r9.f349c     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r2 = 0
            java.lang.Object r9 = r9.get(r2)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r4 = "Hostname "
            r3.<init>(r4)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.v r0 = r0.f8a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = r0.l     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = b.g.a((java.security.cert.Certificate) r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.security.Principal r0 = r9.getSubjectDN()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.util.List r9 = b.a.j.d.a(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.append(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r9 = r3.toString()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r2.<init>(r9)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            throw r2     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x00ec:
            b.g r3 = r0.k     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            b.v r0 = r0.f8a     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r0 = r0.l     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.util.List<java.security.cert.Certificate> r4 = r9.f349c     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r3.a((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r4)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            boolean r0 = r5.e     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r0 == 0) goto L_0x0103
            b.a.h.e r0 = b.a.h.e.b()     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.lang.String r2 = r0.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x0103:
            r8.f62c = r1     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.net.Socket r0 = r8.f62c     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            c.y r0 = c.p.b((java.net.Socket) r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            c.e r0 = c.p.a((c.y) r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r8.f = r0     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            java.net.Socket r0 = r8.f62c     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            c.x r0 = c.p.a((java.net.Socket) r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            c.d r0 = c.p.a((c.x) r0)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r8.g = r0     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            r8.d = r9     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r2 == 0) goto L_0x0126
            b.aa r9 = b.aa.get(r2)     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            goto L_0x0128
        L_0x0126:
            b.aa r9 = b.aa.HTTP_1_1     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
        L_0x0128:
            r8.p = r9     // Catch:{ AssertionError -> 0x0136, all -> 0x0134 }
            if (r1 == 0) goto L_0x0133
            b.a.h.e r9 = b.a.h.e.b()
            r9.b((javax.net.ssl.SSLSocket) r1)
        L_0x0133:
            return
        L_0x0134:
            r9 = move-exception
            goto L_0x014a
        L_0x0136:
            r9 = move-exception
            r2 = r1
            goto L_0x013d
        L_0x0139:
            r9 = move-exception
            r1 = r2
            goto L_0x014a
        L_0x013c:
            r9 = move-exception
        L_0x013d:
            boolean r0 = b.a.c.a((java.lang.AssertionError) r9)     // Catch:{ all -> 0x0139 }
            if (r0 == 0) goto L_0x0149
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0139 }
            r0.<init>(r9)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x0149:
            throw r9     // Catch:{ all -> 0x0139 }
        L_0x014a:
            if (r1 == 0) goto L_0x0153
            b.a.h.e r0 = b.a.h.e.b()
            r0.b((javax.net.ssl.SSLSocket) r1)
        L_0x0153:
            b.a.c.a((java.net.Socket) r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.c.b(b.a.c.b):void");
    }

    private ac f() {
        return new ac.a().a(this.f60a.f272a.f8a).a(HttpHeaders.HOST, b.a.c.a(this.f60a.f272a.f8a, true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", "okhttp/3.8.0").d();
    }

    private void g() {
        b.a.c.a(this.f61b);
    }

    public final ag a() {
        return this.f60a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0256 A[EDGE_INSN: B:102:0x0256->B:100:0x0256 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x022b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r18, int r19, int r20, boolean r21) {
        /*
            r17 = this;
            r1 = r17
            b.aa r2 = r1.p
            if (r2 == 0) goto L_0x000e
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "already connected"
            r2.<init>(r3)
            throw r2
        L_0x000e:
            b.ag r2 = r1.f60a
            b.a r2 = r2.f272a
            java.util.List<b.l> r2 = r2.f
            b.a.c.b r3 = new b.a.c.b
            r3.<init>(r2)
            b.ag r4 = r1.f60a
            b.a r4 = r4.f272a
            javax.net.ssl.SSLSocketFactory r4 = r4.i
            if (r4 != 0) goto L_0x0066
            b.l r4 = b.l.f325c
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x0036
            b.a.c.e r2 = new b.a.c.e
            java.net.UnknownServiceException r3 = new java.net.UnknownServiceException
            java.lang.String r4 = "CLEARTEXT communication not enabled for client"
            r3.<init>(r4)
            r2.<init>(r3)
            throw r2
        L_0x0036:
            b.ag r2 = r1.f60a
            b.a r2 = r2.f272a
            b.v r2 = r2.f8a
            java.lang.String r2 = r2.l
            b.a.h.e r4 = b.a.h.e.b()
            boolean r4 = r4.b((java.lang.String) r2)
            if (r4 != 0) goto L_0x0066
            b.a.c.e r3 = new b.a.c.e
            java.net.UnknownServiceException r4 = new java.net.UnknownServiceException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "CLEARTEXT communication to "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = " not permitted by network security policy"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.<init>(r2)
            r3.<init>(r4)
            throw r3
        L_0x0066:
            r2 = 0
            r4 = r2
        L_0x0068:
            r5 = 0
            r6 = 1
            b.ag r7 = r1.f60a     // Catch:{ IOException -> 0x01fe }
            b.a r8 = r7.f272a     // Catch:{ IOException -> 0x01fe }
            javax.net.ssl.SSLSocketFactory r8 = r8.i     // Catch:{ IOException -> 0x01fe }
            if (r8 == 0) goto L_0x007e
            java.net.Proxy r7 = r7.f273b     // Catch:{ IOException -> 0x01fe }
            java.net.Proxy$Type r7 = r7.type()     // Catch:{ IOException -> 0x01fe }
            java.net.Proxy$Type r8 = java.net.Proxy.Type.HTTP     // Catch:{ IOException -> 0x01fe }
            if (r7 != r8) goto L_0x007e
            r7 = 1
            goto L_0x007f
        L_0x007e:
            r7 = 0
        L_0x007f:
            if (r7 == 0) goto L_0x0176
            b.ac$a r7 = new b.ac$a     // Catch:{ IOException -> 0x01fe }
            r7.<init>()     // Catch:{ IOException -> 0x01fe }
            b.ag r8 = r1.f60a     // Catch:{ IOException -> 0x01fe }
            b.a r8 = r8.f272a     // Catch:{ IOException -> 0x01fe }
            b.v r8 = r8.f8a     // Catch:{ IOException -> 0x01fe }
            b.ac$a r7 = r7.a((b.v) r8)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = "Host"
            b.ag r9 = r1.f60a     // Catch:{ IOException -> 0x01fe }
            b.a r9 = r9.f272a     // Catch:{ IOException -> 0x01fe }
            b.v r9 = r9.f8a     // Catch:{ IOException -> 0x01fe }
            java.lang.String r9 = b.a.c.a((b.v) r9, (boolean) r6)     // Catch:{ IOException -> 0x01fe }
            b.ac$a r7 = r7.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = "Proxy-Connection"
            java.lang.String r9 = "Keep-Alive"
            b.ac$a r7 = r7.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = "User-Agent"
            java.lang.String r9 = "okhttp/3.8.0"
            b.ac$a r7 = r7.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x01fe }
            b.ac r7 = r7.d()     // Catch:{ IOException -> 0x01fe }
            b.v r8 = r7.f247a     // Catch:{ IOException -> 0x01fe }
            r17.a((int) r18, (int) r19)     // Catch:{ IOException -> 0x01fe }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01fe }
            java.lang.String r10 = "CONNECT "
            r9.<init>(r10)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = b.a.c.a((b.v) r8, (boolean) r6)     // Catch:{ IOException -> 0x01fe }
            r9.append(r8)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = " HTTP/1.1"
            r9.append(r8)     // Catch:{ IOException -> 0x01fe }
            java.lang.String r8 = r9.toString()     // Catch:{ IOException -> 0x01fe }
            b.a.e.a r9 = new b.a.e.a     // Catch:{ IOException -> 0x01fe }
            c.e r10 = r1.f     // Catch:{ IOException -> 0x01fe }
            c.d r11 = r1.g     // Catch:{ IOException -> 0x01fe }
            r9.<init>(r2, r2, r10, r11)     // Catch:{ IOException -> 0x01fe }
            c.e r10 = r1.f     // Catch:{ IOException -> 0x01fe }
            c.z r10 = r10.timeout()     // Catch:{ IOException -> 0x01fe }
            r11 = r19
            long r12 = (long) r11
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x0173 }
            r10.a(r12, r14)     // Catch:{ IOException -> 0x0173 }
            c.d r10 = r1.g     // Catch:{ IOException -> 0x0173 }
            c.z r10 = r10.timeout()     // Catch:{ IOException -> 0x0173 }
            r12 = r20
            long r13 = (long) r12
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x01fc }
            r10.a(r13, r15)     // Catch:{ IOException -> 0x01fc }
            b.u r10 = r7.f249c     // Catch:{ IOException -> 0x01fc }
            r9.a((b.u) r10, (java.lang.String) r8)     // Catch:{ IOException -> 0x01fc }
            r9.b()     // Catch:{ IOException -> 0x01fc }
            b.ae$a r8 = r9.a((boolean) r5)     // Catch:{ IOException -> 0x01fc }
            r8.f263a = r7     // Catch:{ IOException -> 0x01fc }
            b.ae r7 = r8.a()     // Catch:{ IOException -> 0x01fc }
            long r13 = b.a.d.e.a((b.ae) r7)     // Catch:{ IOException -> 0x01fc }
            r15 = -1
            int r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r8 != 0) goto L_0x0113
            r13 = 0
        L_0x0113:
            c.y r8 = r9.a((long) r13)     // Catch:{ IOException -> 0x01fc }
            r9 = 2147483647(0x7fffffff, float:NaN)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x01fc }
            b.a.c.a((c.y) r8, (int) r9, (java.util.concurrent.TimeUnit) r10)     // Catch:{ IOException -> 0x01fc }
            r8.close()     // Catch:{ IOException -> 0x01fc }
            int r8 = r7.f262c     // Catch:{ IOException -> 0x01fc }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 == r9) goto L_0x0153
            r9 = 407(0x197, float:5.7E-43)
            if (r8 == r9) goto L_0x0142
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x01fc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01fc }
            java.lang.String r10 = "Unexpected response code for CONNECT: "
            r9.<init>(r10)     // Catch:{ IOException -> 0x01fc }
            int r7 = r7.f262c     // Catch:{ IOException -> 0x01fc }
            r9.append(r7)     // Catch:{ IOException -> 0x01fc }
            java.lang.String r7 = r9.toString()     // Catch:{ IOException -> 0x01fc }
            r8.<init>(r7)     // Catch:{ IOException -> 0x01fc }
            throw r8     // Catch:{ IOException -> 0x01fc }
        L_0x0142:
            b.ag r7 = r1.f60a     // Catch:{ IOException -> 0x01fc }
            b.a r7 = r7.f272a     // Catch:{ IOException -> 0x01fc }
            b.b r7 = r7.d     // Catch:{ IOException -> 0x01fc }
            r7.a()     // Catch:{ IOException -> 0x01fc }
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x01fc }
            java.lang.String r8 = "Failed to authenticate with proxy"
            r7.<init>(r8)     // Catch:{ IOException -> 0x01fc }
            throw r7     // Catch:{ IOException -> 0x01fc }
        L_0x0153:
            c.e r7 = r1.f     // Catch:{ IOException -> 0x01fc }
            c.c r7 = r7.a()     // Catch:{ IOException -> 0x01fc }
            boolean r7 = r7.d()     // Catch:{ IOException -> 0x01fc }
            if (r7 == 0) goto L_0x016b
            c.d r7 = r1.g     // Catch:{ IOException -> 0x01fc }
            c.c r7 = r7.a()     // Catch:{ IOException -> 0x01fc }
            boolean r7 = r7.d()     // Catch:{ IOException -> 0x01fc }
            if (r7 != 0) goto L_0x017d
        L_0x016b:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ IOException -> 0x01fc }
            java.lang.String r8 = "TLS tunnel buffered too many bytes!"
            r7.<init>(r8)     // Catch:{ IOException -> 0x01fc }
            throw r7     // Catch:{ IOException -> 0x01fc }
        L_0x0173:
            r0 = move-exception
            goto L_0x0201
        L_0x0176:
            r11 = r19
            r12 = r20
            r17.a((int) r18, (int) r19)     // Catch:{ IOException -> 0x01fc }
        L_0x017d:
            b.ag r7 = r1.f60a     // Catch:{ IOException -> 0x01fc }
            b.a r7 = r7.f272a     // Catch:{ IOException -> 0x01fc }
            javax.net.ssl.SSLSocketFactory r7 = r7.i     // Catch:{ IOException -> 0x01fc }
            if (r7 != 0) goto L_0x018e
            b.aa r7 = b.aa.HTTP_1_1     // Catch:{ IOException -> 0x01fc }
            r1.p = r7     // Catch:{ IOException -> 0x01fc }
            java.net.Socket r7 = r1.f61b     // Catch:{ IOException -> 0x01fc }
            r1.f62c = r7     // Catch:{ IOException -> 0x01fc }
            goto L_0x01e6
        L_0x018e:
            r1.b(r3)     // Catch:{ IOException -> 0x01fc }
            b.aa r7 = r1.p     // Catch:{ IOException -> 0x01fc }
            b.aa r8 = b.aa.HTTP_2     // Catch:{ IOException -> 0x01fc }
            if (r7 != r8) goto L_0x01e6
            java.net.Socket r7 = r1.f62c     // Catch:{ IOException -> 0x01fc }
            r7.setSoTimeout(r5)     // Catch:{ IOException -> 0x01fc }
            b.a.f.g$a r7 = new b.a.f.g$a     // Catch:{ IOException -> 0x01fc }
            r7.<init>()     // Catch:{ IOException -> 0x01fc }
            java.net.Socket r8 = r1.f62c     // Catch:{ IOException -> 0x01fc }
            b.ag r9 = r1.f60a     // Catch:{ IOException -> 0x01fc }
            b.a r9 = r9.f272a     // Catch:{ IOException -> 0x01fc }
            b.v r9 = r9.f8a     // Catch:{ IOException -> 0x01fc }
            java.lang.String r9 = r9.l     // Catch:{ IOException -> 0x01fc }
            c.e r10 = r1.f     // Catch:{ IOException -> 0x01fc }
            c.d r13 = r1.g     // Catch:{ IOException -> 0x01fc }
            b.a.f.g$a r7 = r7.a(r8, r9, r10, r13)     // Catch:{ IOException -> 0x01fc }
            r7.e = r1     // Catch:{ IOException -> 0x01fc }
            b.a.f.g r8 = new b.a.f.g     // Catch:{ IOException -> 0x01fc }
            r8.<init>(r7)     // Catch:{ IOException -> 0x01fc }
            r1.e = r8     // Catch:{ IOException -> 0x01fc }
            b.a.f.g r7 = r1.e     // Catch:{ IOException -> 0x01fc }
            b.a.f.j r8 = r7.q     // Catch:{ IOException -> 0x01fc }
            r8.a()     // Catch:{ IOException -> 0x01fc }
            b.a.f.j r8 = r7.q     // Catch:{ IOException -> 0x01fc }
            b.a.f.n r9 = r7.m     // Catch:{ IOException -> 0x01fc }
            r8.b(r9)     // Catch:{ IOException -> 0x01fc }
            b.a.f.n r8 = r7.m     // Catch:{ IOException -> 0x01fc }
            int r8 = r8.b()     // Catch:{ IOException -> 0x01fc }
            r9 = 65535(0xffff, float:9.1834E-41)
            if (r8 == r9) goto L_0x01dc
            b.a.f.j r10 = r7.q     // Catch:{ IOException -> 0x01fc }
            int r8 = r8 - r9
            long r8 = (long) r8     // Catch:{ IOException -> 0x01fc }
            r10.a((int) r5, (long) r8)     // Catch:{ IOException -> 0x01fc }
        L_0x01dc:
            java.lang.Thread r8 = new java.lang.Thread     // Catch:{ IOException -> 0x01fc }
            b.a.f.g$c r7 = r7.r     // Catch:{ IOException -> 0x01fc }
            r8.<init>(r7)     // Catch:{ IOException -> 0x01fc }
            r8.start()     // Catch:{ IOException -> 0x01fc }
        L_0x01e6:
            b.a.f.g r2 = r1.e
            if (r2 == 0) goto L_0x01fb
            b.k r2 = r1.o
            monitor-enter(r2)
            b.a.f.g r3 = r1.e     // Catch:{ all -> 0x01f7 }
            int r3 = r3.a()     // Catch:{ all -> 0x01f7 }
            r1.j = r3     // Catch:{ all -> 0x01f7 }
            monitor-exit(r2)     // Catch:{ all -> 0x01f7 }
            return
        L_0x01f7:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x01f7 }
            throw r3
        L_0x01fb:
            return
        L_0x01fc:
            r0 = move-exception
            goto L_0x0203
        L_0x01fe:
            r0 = move-exception
            r11 = r19
        L_0x0201:
            r12 = r20
        L_0x0203:
            r7 = r0
            java.net.Socket r8 = r1.f62c
            b.a.c.a((java.net.Socket) r8)
            java.net.Socket r8 = r1.f61b
            b.a.c.a((java.net.Socket) r8)
            r1.f62c = r2
            r1.f61b = r2
            r1.f = r2
            r1.g = r2
            r1.d = r2
            r1.p = r2
            r1.e = r2
            if (r4 != 0) goto L_0x0225
            b.a.c.e r4 = new b.a.c.e
            r4.<init>(r7)
        L_0x0223:
            r8 = r4
            goto L_0x0229
        L_0x0225:
            r4.addConnectException(r7)
            goto L_0x0223
        L_0x0229:
            if (r21 == 0) goto L_0x0256
            r3.d = r6
            boolean r9 = r3.f59c
            if (r9 == 0) goto L_0x0250
            boolean r9 = r7 instanceof java.net.ProtocolException
            if (r9 != 0) goto L_0x0250
            boolean r9 = r7 instanceof java.io.InterruptedIOException
            if (r9 != 0) goto L_0x0250
            boolean r9 = r7 instanceof javax.net.ssl.SSLHandshakeException
            if (r9 == 0) goto L_0x0245
            java.lang.Throwable r10 = r7.getCause()
            boolean r10 = r10 instanceof java.security.cert.CertificateException
            if (r10 != 0) goto L_0x0250
        L_0x0245:
            boolean r10 = r7 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r10 != 0) goto L_0x0250
            if (r9 != 0) goto L_0x024f
            boolean r7 = r7 instanceof javax.net.ssl.SSLProtocolException
            if (r7 == 0) goto L_0x0250
        L_0x024f:
            r5 = 1
        L_0x0250:
            if (r5 != 0) goto L_0x0253
            goto L_0x0256
        L_0x0253:
            r4 = r8
            goto L_0x0068
        L_0x0256:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.c.a(int, int, int, boolean):void");
    }

    public final void a(g gVar) {
        synchronized (this.o) {
            this.j = gVar.a();
        }
    }

    public final void a(i iVar) throws IOException {
        iVar.a(b.REFUSED_STREAM);
    }

    public final boolean a(b.a aVar, @Nullable ag agVar) {
        if (this.k.size() >= this.j || this.h || !b.a.a.f11a.a(this.f60a.f272a, aVar)) {
            return false;
        }
        if (aVar.f8a.l.equals(this.f60a.f272a.f8a.l)) {
            return true;
        }
        if (this.e == null || agVar == null || agVar.f273b.type() != Proxy.Type.DIRECT || this.f60a.f273b.type() != Proxy.Type.DIRECT || !this.f60a.f274c.equals(agVar.f274c) || agVar.f272a.j != b.a.j.d.f209a || !a(aVar.f8a)) {
            return false;
        }
        try {
            aVar.k.a(aVar.f8a.l, this.d.f349c);
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean a(v vVar) {
        if (vVar.m != this.f60a.f272a.f8a.m) {
            return false;
        }
        if (vVar.l.equals(this.f60a.f272a.f8a.l)) {
            return true;
        }
        if (this.d != null) {
            b.a.j.d dVar = b.a.j.d.f209a;
            if (b.a.j.d.a(vVar.l, (X509Certificate) this.d.f349c.get(0))) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(boolean z) {
        int soTimeout;
        if (this.f62c.isClosed() || this.f62c.isInputShutdown() || this.f62c.isOutputShutdown()) {
            return false;
        }
        if (this.e != null) {
            return !this.e.b();
        }
        if (z) {
            try {
                soTimeout = this.f62c.getSoTimeout();
                this.f62c.setSoTimeout(1);
                if (this.f.d()) {
                    this.f62c.setSoTimeout(soTimeout);
                    return false;
                }
                this.f62c.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f62c.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public final Socket b() {
        return this.f62c;
    }

    public final t c() {
        return this.d;
    }

    public final aa d() {
        return this.p;
    }

    public final boolean e() {
        return this.e != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.f60a.f272a.f8a.l);
        sb.append(":");
        sb.append(this.f60a.f272a.f8a.m);
        sb.append(", proxy=");
        sb.append(this.f60a.f273b);
        sb.append(" hostAddress=");
        sb.append(this.f60a.f274c);
        sb.append(" cipherSuite=");
        sb.append(this.d != null ? this.d.f348b : "none");
        sb.append(" protocol=");
        sb.append(this.p);
        sb.append('}');
        return sb.toString();
    }
}
