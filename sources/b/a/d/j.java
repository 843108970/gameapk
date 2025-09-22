package b.a.d;

import b.a;
import b.a.c.c;
import b.a.c.g;
import b.ac;
import b.ad;
import b.ae;
import b.ag;
import b.v;
import b.w;
import b.z;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j implements w {
    private static final int d = 20;

    /* renamed from: a  reason: collision with root package name */
    public g f87a;

    /* renamed from: b  reason: collision with root package name */
    public Object f88b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f89c;
    private final z e;
    private final boolean f;

    public j(z zVar, boolean z) {
        this.e = zVar;
        this.f = z;
    }

    private a a(v vVar) {
        b.g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        v vVar2 = vVar;
        if (vVar.b()) {
            SSLSocketFactory sSLSocketFactory2 = this.e.o;
            hostnameVerifier = this.e.q;
            sSLSocketFactory = sSLSocketFactory2;
            gVar = this.e.r;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new a(vVar2.l, vVar2.m, this.e.v, this.e.n, sSLSocketFactory, hostnameVerifier, gVar, this.e.s, this.e.d, this.e.e, this.e.f, this.e.j);
    }

    private ac a(ae aeVar) throws IOException {
        String a2;
        if (aeVar == null) {
            throw new IllegalStateException();
        }
        c b2 = this.f87a.b();
        ad adVar = null;
        ag a3 = b2 != null ? b2.a() : null;
        int i = aeVar.f262c;
        String str = aeVar.f260a.f248b;
        switch (i) {
            case 300:
            case SET_ENABLED_VALUE:
            case SET_VISIBLE_VALUE:
            case SET_TITLE_TEXT_VALUE:
                break;
            case 307:
            case 308:
                if (!str.equals(HttpRequest.METHOD_GET) && !str.equals("HEAD")) {
                    return null;
                }
            case GET_ENABLED_VALUE:
                return this.e.t.a();
            case GET_TEXTCOLOR_VALUE:
                if ((a3 != null ? a3.f273b : this.e.d).type() == Proxy.Type.HTTP) {
                    return this.e.s.a();
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case GET_VALUE_VALUE:
                if (aeVar.f260a.d instanceof l) {
                    return null;
                }
                return aeVar.f260a;
            default:
                return null;
        }
        if (!this.e.x || (a2 = aeVar.a("Location")) == null) {
            return null;
        }
        v.a c2 = aeVar.f260a.f247a.c(a2);
        v b3 = c2 != null ? c2.b() : null;
        if (b3 == null) {
            return null;
        }
        if (!b3.k.equals(aeVar.f260a.f247a.k) && !this.e.w) {
            return null;
        }
        ac.a c3 = aeVar.f260a.c();
        if (f.c(str)) {
            boolean equals = str.equals("PROPFIND");
            if (!str.equals("PROPFIND")) {
                str = HttpRequest.METHOD_GET;
            } else if (equals) {
                adVar = aeVar.f260a.d;
            }
            c3.a(str, adVar);
            if (!equals) {
                c3.b("Transfer-Encoding");
                c3.b("Content-Length");
                c3.b("Content-Type");
            }
        }
        if (!a(aeVar, b3)) {
            c3.b("Authorization");
        }
        return c3.a(b3).d();
    }

    private void a() {
        c cVar;
        c cVar2;
        this.f89c = true;
        g gVar = this.f87a;
        if (gVar != null) {
            synchronized (gVar.f71c) {
                gVar.f = true;
                cVar = gVar.g;
                cVar2 = gVar.e;
            }
            if (cVar != null) {
                cVar.c();
            } else if (cVar2 != null) {
                b.a.c.a(cVar2.f61b);
            }
        }
    }

    private void a(Object obj) {
        this.f88b = obj;
    }

    private static boolean a(ae aeVar, v vVar) {
        v vVar2 = aeVar.f260a.f247a;
        return vVar2.l.equals(vVar.l) && vVar2.m == vVar.m && vVar2.k.equals(vVar.k);
    }

    private static boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0064 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0065 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.IOException r3, boolean r4, b.ac r5) {
        /*
            r2 = this;
            b.a.c.g r0 = r2.f87a
            r0.a((java.io.IOException) r3)
            b.z r0 = r2.e
            boolean r0 = r0.y
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            if (r4 == 0) goto L_0x0016
            b.ad r5 = r5.d
            boolean r5 = r5 instanceof b.a.d.l
            if (r5 == 0) goto L_0x0016
            return r1
        L_0x0016:
            boolean r5 = r3 instanceof java.net.ProtocolException
            r0 = 1
            if (r5 == 0) goto L_0x001d
        L_0x001b:
            r3 = 0
            goto L_0x003b
        L_0x001d:
            boolean r5 = r3 instanceof java.io.InterruptedIOException
            if (r5 == 0) goto L_0x0028
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L_0x001b
            if (r4 == 0) goto L_0x003a
            goto L_0x001b
        L_0x0028:
            boolean r4 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r4 == 0) goto L_0x0035
            java.lang.Throwable r4 = r3.getCause()
            boolean r4 = r4 instanceof java.security.cert.CertificateException
            if (r4 == 0) goto L_0x0035
            goto L_0x001b
        L_0x0035:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L_0x003a
            goto L_0x001b
        L_0x003a:
            r3 = 1
        L_0x003b:
            if (r3 != 0) goto L_0x003e
            return r1
        L_0x003e:
            b.a.c.g r3 = r2.f87a
            b.ag r4 = r3.f70b
            if (r4 != 0) goto L_0x0061
            b.a.c.f r3 = r3.d
            boolean r4 = r3.c()
            if (r4 != 0) goto L_0x005b
            boolean r4 = r3.b()
            if (r4 != 0) goto L_0x005b
            boolean r3 = r3.d()
            if (r3 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r3 = 0
            goto L_0x005c
        L_0x005b:
            r3 = 1
        L_0x005c:
            if (r3 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r3 = 0
            goto L_0x0062
        L_0x0061:
            r3 = 1
        L_0x0062:
            if (r3 != 0) goto L_0x0065
            return r1
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.d.j.a(java.io.IOException, boolean, b.ac):boolean");
    }

    private boolean b() {
        return this.f89c;
    }

    private g c() {
        return this.f87a;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        r0 = r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
        if (r7.equals("HEAD") == false) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0145, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0146, code lost:
        if (r0 != null) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014a, code lost:
        if (r10.f != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014c, code lost:
        r10.f87a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0151, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0152, code lost:
        b.a.c.a((java.io.Closeable) r3.g);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015b, code lost:
        if (r4 <= 20) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015d, code lost:
        r10.f87a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0175, code lost:
        throw new java.net.ProtocolException("Too many follow-up requests: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017a, code lost:
        if ((r0.d instanceof b.a.d.l) == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x017c, code lost:
        r10.f87a.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        throw new java.net.HttpRetryException("Cannot retry streamed HTTP body", r3.f262c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0191, code lost:
        if (a(r3, r0.f247a) != false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0193, code lost:
        r10.f87a.c();
        r10.f87a = new b.a.c.g(r10.e.u, a(r0.f247a), r10.f88b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b3, code lost:
        if (r10.f87a.a() == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01cd, code lost:
        throw new java.lang.IllegalStateException("Closing the body of " + r3 + " didn't close its backing stream. Bad interceptor?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final b.ae intercept(b.w.a r11) throws java.io.IOException {
        /*
            r10 = this;
            b.ac r0 = r11.a()
            b.a.c.g r1 = new b.a.c.g
            b.z r2 = r10.e
            b.k r2 = r2.u
            b.v r3 = r0.f247a
            b.a r3 = r10.a((b.v) r3)
            java.lang.Object r4 = r10.f88b
            r1.<init>(r2, r3, r4)
            r10.f87a = r1
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L_0x001b:
            boolean r5 = r10.f89c
            if (r5 == 0) goto L_0x002c
            b.a.c.g r11 = r10.f87a
            r11.c()
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)
            throw r11
        L_0x002c:
            r5 = 1
            r6 = r11
            b.a.d.g r6 = (b.a.d.g) r6     // Catch:{ e -> 0x01de, IOException -> 0x01d0 }
            b.a.c.g r7 = r10.f87a     // Catch:{ e -> 0x01de, IOException -> 0x01d0 }
            b.ae r6 = r6.a(r0, r7, r2, r2)     // Catch:{ e -> 0x01de, IOException -> 0x01d0 }
            if (r3 == 0) goto L_0x005a
            b.ae$a r0 = r6.e()
            b.ae$a r3 = r3.e()
            r3.g = r2
            b.ae r3 = r3.a()
            b.af r6 = r3.g
            if (r6 == 0) goto L_0x0052
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "priorResponse.body != null"
            r11.<init>(r0)
            throw r11
        L_0x0052:
            r0.j = r3
            b.ae r0 = r0.a()
            r3 = r0
            goto L_0x005b
        L_0x005a:
            r3 = r6
        L_0x005b:
            if (r3 != 0) goto L_0x0063
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>()
            throw r11
        L_0x0063:
            b.a.c.g r0 = r10.f87a
            b.a.c.c r0 = r0.b()
            if (r0 == 0) goto L_0x0070
            b.ag r0 = r0.a()
            goto L_0x0071
        L_0x0070:
            r0 = r2
        L_0x0071:
            int r6 = r3.f262c
            b.ac r7 = r3.f260a
            java.lang.String r7 = r7.f248b
            switch(r6) {
                case 300: goto L_0x00c0;
                case 301: goto L_0x00c0;
                case 302: goto L_0x00c0;
                case 303: goto L_0x00c0;
                case 307: goto L_0x00b0;
                case 308: goto L_0x00b0;
                case 401: goto L_0x00a6;
                case 407: goto L_0x0088;
                case 408: goto L_0x007c;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x0145
        L_0x007c:
            b.ac r0 = r3.f260a
            b.ad r0 = r0.d
            boolean r0 = r0 instanceof b.a.d.l
            if (r0 != 0) goto L_0x0145
            b.ac r0 = r3.f260a
            goto L_0x0146
        L_0x0088:
            if (r0 == 0) goto L_0x008d
            java.net.Proxy r0 = r0.f273b
            goto L_0x0091
        L_0x008d:
            b.z r0 = r10.e
            java.net.Proxy r0 = r0.d
        L_0x0091:
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r5 = java.net.Proxy.Type.HTTP
            if (r0 == r5) goto L_0x00a1
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r11.<init>(r0)
            throw r11
        L_0x00a1:
            b.z r0 = r10.e
            b.b r0 = r0.s
            goto L_0x00aa
        L_0x00a6:
            b.z r0 = r10.e
            b.b r0 = r0.t
        L_0x00aa:
            b.ac r0 = r0.a()
            goto L_0x0146
        L_0x00b0:
            java.lang.String r0 = "GET"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00c0
            java.lang.String r0 = "HEAD"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0145
        L_0x00c0:
            b.z r0 = r10.e
            boolean r0 = r0.x
            if (r0 == 0) goto L_0x0145
            java.lang.String r0 = "Location"
            java.lang.String r0 = r3.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x0145
            b.ac r6 = r3.f260a
            b.v r6 = r6.f247a
            b.v$a r0 = r6.c(r0)
            if (r0 == 0) goto L_0x00dd
            b.v r0 = r0.b()
            goto L_0x00de
        L_0x00dd:
            r0 = r2
        L_0x00de:
            if (r0 == 0) goto L_0x0145
            java.lang.String r6 = r0.k
            b.ac r8 = r3.f260a
            b.v r8 = r8.f247a
            java.lang.String r8 = r8.k
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x00f4
            b.z r6 = r10.e
            boolean r6 = r6.w
            if (r6 == 0) goto L_0x0145
        L_0x00f4:
            b.ac r6 = r3.f260a
            b.ac$a r6 = r6.c()
            boolean r8 = b.a.d.f.c(r7)
            if (r8 == 0) goto L_0x0131
            java.lang.String r8 = "PROPFIND"
            boolean r8 = r7.equals(r8)
            java.lang.String r9 = "PROPFIND"
            boolean r9 = r7.equals(r9)
            r5 = r5 ^ r9
            if (r5 == 0) goto L_0x0115
            java.lang.String r5 = "GET"
            r6.a((java.lang.String) r5, (b.ad) r2)
            goto L_0x0120
        L_0x0115:
            if (r8 == 0) goto L_0x011c
            b.ac r5 = r3.f260a
            b.ad r5 = r5.d
            goto L_0x011d
        L_0x011c:
            r5 = r2
        L_0x011d:
            r6.a((java.lang.String) r7, (b.ad) r5)
        L_0x0120:
            if (r8 != 0) goto L_0x0131
            java.lang.String r5 = "Transfer-Encoding"
            r6.b((java.lang.String) r5)
            java.lang.String r5 = "Content-Length"
            r6.b((java.lang.String) r5)
            java.lang.String r5 = "Content-Type"
            r6.b((java.lang.String) r5)
        L_0x0131:
            boolean r5 = a((b.ae) r3, (b.v) r0)
            if (r5 != 0) goto L_0x013c
            java.lang.String r5 = "Authorization"
            r6.b((java.lang.String) r5)
        L_0x013c:
            b.ac$a r0 = r6.a((b.v) r0)
            b.ac r0 = r0.d()
            goto L_0x0146
        L_0x0145:
            r0 = r2
        L_0x0146:
            if (r0 != 0) goto L_0x0152
            boolean r11 = r10.f
            if (r11 != 0) goto L_0x0151
            b.a.c.g r11 = r10.f87a
            r11.c()
        L_0x0151:
            return r3
        L_0x0152:
            b.af r5 = r3.g
            b.a.c.a((java.io.Closeable) r5)
            int r4 = r4 + 1
            r5 = 20
            if (r4 <= r5) goto L_0x0176
            b.a.c.g r11 = r10.f87a
            r11.c()
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Too many follow-up requests: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0176:
            b.ad r5 = r0.d
            boolean r5 = r5 instanceof b.a.d.l
            if (r5 == 0) goto L_0x018b
            b.a.c.g r11 = r10.f87a
            r11.c()
            java.net.HttpRetryException r11 = new java.net.HttpRetryException
            java.lang.String r0 = "Cannot retry streamed HTTP body"
            int r1 = r3.f262c
            r11.<init>(r0, r1)
            throw r11
        L_0x018b:
            b.v r5 = r0.f247a
            boolean r5 = a((b.ae) r3, (b.v) r5)
            if (r5 != 0) goto L_0x01ad
            b.a.c.g r5 = r10.f87a
            r5.c()
            b.a.c.g r5 = new b.a.c.g
            b.z r6 = r10.e
            b.k r6 = r6.u
            b.v r7 = r0.f247a
            b.a r7 = r10.a((b.v) r7)
            java.lang.Object r8 = r10.f88b
            r5.<init>(r6, r7, r8)
            r10.f87a = r5
            goto L_0x001b
        L_0x01ad:
            b.a.c.g r5 = r10.f87a
            b.a.d.c r5 = r5.a()
            if (r5 == 0) goto L_0x001b
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Closing the body of "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = " didn't close its backing stream. Bad interceptor?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x01ce:
            r11 = move-exception
            goto L_0x01ee
        L_0x01d0:
            r6 = move-exception
            boolean r7 = r6 instanceof b.a.f.a     // Catch:{ all -> 0x01ce }
            if (r7 != 0) goto L_0x01d6
            goto L_0x01d7
        L_0x01d6:
            r5 = 0
        L_0x01d7:
            boolean r5 = r10.a(r6, r5, r0)     // Catch:{ all -> 0x01ce }
            if (r5 != 0) goto L_0x001b
            throw r6     // Catch:{ all -> 0x01ce }
        L_0x01de:
            r5 = move-exception
            java.io.IOException r6 = r5.getLastConnectException()     // Catch:{ all -> 0x01ce }
            boolean r6 = r10.a(r6, r1, r0)     // Catch:{ all -> 0x01ce }
            if (r6 != 0) goto L_0x001b
            java.io.IOException r11 = r5.getLastConnectException()     // Catch:{ all -> 0x01ce }
            throw r11     // Catch:{ all -> 0x01ce }
        L_0x01ee:
            b.a.c.g r0 = r10.f87a
            r0.a((java.io.IOException) r2)
            b.a.c.g r0 = r10.f87a
            r0.c()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.d.j.intercept(b.w$a):b.ae");
    }
}
