package com.b.a.a.c;

import com.b.a.a;
import com.b.a.a.b.g;
import com.b.a.ac;
import com.b.a.af;
import com.b.a.ai;
import com.b.a.ao;
import com.b.a.as;
import com.b.a.i;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class k implements af {

    /* renamed from: a  reason: collision with root package name */
    private final ai f617a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f618b;

    /* renamed from: c  reason: collision with root package name */
    private g f619c;
    private Object d;
    private volatile boolean e;

    public k(ai aiVar, boolean z) {
        this.f617a = aiVar;
        this.f618b = z;
    }

    private a a(ac acVar) {
        i iVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (acVar.c()) {
            SSLSocketFactory i = this.f617a.i();
            hostnameVerifier = this.f617a.j();
            sSLSocketFactory = i;
            iVar = this.f617a.k();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            iVar = null;
        }
        return new a(acVar.f(), acVar.g(), this.f617a.g(), this.f617a.h(), sSLSocketFactory, hostnameVerifier, iVar, this.f617a.m(), this.f617a.d(), this.f617a.r(), this.f617a.s(), this.f617a.e());
    }

    private static boolean a(as asVar, ac acVar) {
        ac a2 = asVar.a().a();
        return a2.f().equals(acVar.f()) && a2.g() == acVar.g() && a2.b().equals(acVar.b());
    }

    private boolean a(IOException iOException, boolean z, ao aoVar) {
        this.f619c.a(iOException);
        if (!this.f617a.q()) {
            return false;
        }
        if (z && (aoVar.d() instanceof m)) {
            return false;
        }
        return (!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z)) && this.f619c.e();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        r0 = r0.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ce, code lost:
        if (r7.equals("HEAD") == false) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0163, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0164, code lost:
        if (r0 != null) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0168, code lost:
        if (r10.f618b != false) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016a, code lost:
        r10.f619c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0170, code lost:
        com.b.a.a.c.a((java.io.Closeable) r3.e());
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
        if (r4 <= 20) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017d, code lost:
        r10.f619c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0195, code lost:
        throw new java.net.ProtocolException("Too many follow-up requests: " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x019c, code lost:
        if ((r0.d() instanceof com.b.a.a.c.m) == false) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019e, code lost:
        r10.f619c.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ae, code lost:
        throw new java.net.HttpRetryException("Cannot retry streamed HTTP body", r3.b());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b7, code lost:
        if (a(r3, r0.a()) != false) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b9, code lost:
        r10.f619c.c();
        r10.f619c = new com.b.a.a.b.g(r10.f617a.n(), a(r0.a()), r10.d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01dd, code lost:
        if (r10.f619c.a() == null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f7, code lost:
        throw new java.lang.IllegalStateException("Closing the body of " + r3 + " didn't close its backing stream. Bad interceptor?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.b.a.as a(com.b.a.ag r11) {
        /*
            r10 = this;
            com.b.a.ao r0 = r11.a()
            com.b.a.a.b.g r1 = new com.b.a.a.b.g
            com.b.a.ai r2 = r10.f617a
            com.b.a.n r2 = r2.n()
            com.b.a.ac r3 = r0.a()
            com.b.a.a r3 = r10.a((com.b.a.ac) r3)
            java.lang.Object r4 = r10.d
            r1.<init>(r2, r3, r4)
            r10.f619c = r1
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = 0
        L_0x001f:
            boolean r5 = r10.e
            if (r5 == 0) goto L_0x0030
            com.b.a.a.b.g r11 = r10.f619c
            r11.c()
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)
            throw r11
        L_0x0030:
            r5 = 1
            r6 = r11
            com.b.a.a.c.h r6 = (com.b.a.a.c.h) r6     // Catch:{ e -> 0x0208, IOException -> 0x01fa }
            com.b.a.a.b.g r7 = r10.f619c     // Catch:{ e -> 0x0208, IOException -> 0x01fa }
            com.b.a.as r6 = r6.a(r0, r7, r2, r2)     // Catch:{ e -> 0x0208, IOException -> 0x01fa }
            if (r3 == 0) goto L_0x0056
            com.b.a.at r0 = r6.f()
            com.b.a.at r3 = r3.f()
            com.b.a.at r3 = r3.a((com.b.a.au) r2)
            com.b.a.as r3 = r3.a()
            com.b.a.at r0 = r0.c(r3)
            com.b.a.as r0 = r0.a()
            r3 = r0
            goto L_0x0057
        L_0x0056:
            r3 = r6
        L_0x0057:
            if (r3 != 0) goto L_0x005f
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            r11.<init>()
            throw r11
        L_0x005f:
            com.b.a.a.b.g r0 = r10.f619c
            com.b.a.a.b.c r0 = r0.b()
            if (r0 == 0) goto L_0x006c
            com.b.a.aw r0 = r0.a()
            goto L_0x006d
        L_0x006c:
            r0 = r2
        L_0x006d:
            int r6 = r3.b()
            com.b.a.ao r7 = r3.a()
            java.lang.String r7 = r7.b()
            switch(r6) {
                case 300: goto L_0x00d0;
                case 301: goto L_0x00d0;
                case 302: goto L_0x00d0;
                case 303: goto L_0x00d0;
                case 307: goto L_0x00c0;
                case 308: goto L_0x00c0;
                case 401: goto L_0x00b4;
                case 407: goto L_0x0090;
                case 408: goto L_0x007e;
                default: goto L_0x007c;
            }
        L_0x007c:
            goto L_0x0163
        L_0x007e:
            com.b.a.ao r0 = r3.a()
            com.b.a.aq r0 = r0.d()
            boolean r0 = r0 instanceof com.b.a.a.c.m
            if (r0 != 0) goto L_0x0163
            com.b.a.ao r0 = r3.a()
            goto L_0x0164
        L_0x0090:
            if (r0 == 0) goto L_0x0097
            java.net.Proxy r0 = r0.b()
            goto L_0x009d
        L_0x0097:
            com.b.a.ai r0 = r10.f617a
            java.net.Proxy r0 = r0.d()
        L_0x009d:
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r5 = java.net.Proxy.Type.HTTP
            if (r0 == r5) goto L_0x00ad
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.String r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r11.<init>(r0)
            throw r11
        L_0x00ad:
            com.b.a.ai r0 = r10.f617a
            com.b.a.b r0 = r0.m()
            goto L_0x00ba
        L_0x00b4:
            com.b.a.ai r0 = r10.f617a
            com.b.a.b r0 = r0.l()
        L_0x00ba:
            com.b.a.ao r0 = r0.a()
            goto L_0x0164
        L_0x00c0:
            java.lang.String r0 = "GET"
            boolean r0 = r7.equals(r0)
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "HEAD"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x0163
        L_0x00d0:
            com.b.a.ai r0 = r10.f617a
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = "Location"
            java.lang.String r0 = r3.a(r0)
            if (r0 == 0) goto L_0x0163
            com.b.a.ao r6 = r3.a()
            com.b.a.ac r6 = r6.a()
            com.b.a.ac r0 = r6.c(r0)
            if (r0 == 0) goto L_0x0163
            java.lang.String r6 = r0.b()
            com.b.a.ao r8 = r3.a()
            com.b.a.ac r8 = r8.a()
            java.lang.String r8 = r8.b()
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x010c
            com.b.a.ai r6 = r10.f617a
            boolean r6 = r6.o()
            if (r6 == 0) goto L_0x0163
        L_0x010c:
            com.b.a.ao r6 = r3.a()
            com.b.a.ap r6 = r6.e()
            boolean r8 = com.b.a.a.c.g.b(r7)
            if (r8 == 0) goto L_0x014f
            java.lang.String r8 = "PROPFIND"
            boolean r8 = r7.equals(r8)
            java.lang.String r9 = "PROPFIND"
            boolean r9 = r7.equals(r9)
            r5 = r5 ^ r9
            if (r5 == 0) goto L_0x012f
            java.lang.String r5 = "GET"
            r6.a((java.lang.String) r5, (com.b.a.aq) r2)
            goto L_0x013e
        L_0x012f:
            if (r8 == 0) goto L_0x013a
            com.b.a.ao r5 = r3.a()
            com.b.a.aq r5 = r5.d()
            goto L_0x013b
        L_0x013a:
            r5 = r2
        L_0x013b:
            r6.a((java.lang.String) r7, (com.b.a.aq) r5)
        L_0x013e:
            if (r8 != 0) goto L_0x014f
            java.lang.String r5 = "Transfer-Encoding"
            r6.b(r5)
            java.lang.String r5 = "Content-Length"
            r6.b(r5)
            java.lang.String r5 = "Content-Type"
            r6.b(r5)
        L_0x014f:
            boolean r5 = a(r3, r0)
            if (r5 != 0) goto L_0x015a
            java.lang.String r5 = "Authorization"
            r6.b(r5)
        L_0x015a:
            com.b.a.ap r0 = r6.a((com.b.a.ac) r0)
            com.b.a.ao r0 = r0.a()
            goto L_0x0164
        L_0x0163:
            r0 = r2
        L_0x0164:
            if (r0 != 0) goto L_0x0170
            boolean r11 = r10.f618b
            if (r11 != 0) goto L_0x016f
            com.b.a.a.b.g r11 = r10.f619c
            r11.c()
        L_0x016f:
            return r3
        L_0x0170:
            com.b.a.au r5 = r3.e()
            com.b.a.a.c.a((java.io.Closeable) r5)
            int r4 = r4 + 1
            r5 = 20
            if (r4 <= r5) goto L_0x0196
            com.b.a.a.b.g r11 = r10.f619c
            r11.c()
            java.net.ProtocolException r11 = new java.net.ProtocolException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Too many follow-up requests: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x0196:
            com.b.a.aq r5 = r0.d()
            boolean r5 = r5 instanceof com.b.a.a.c.m
            if (r5 == 0) goto L_0x01af
            com.b.a.a.b.g r11 = r10.f619c
            r11.c()
            java.net.HttpRetryException r11 = new java.net.HttpRetryException
            java.lang.String r0 = "Cannot retry streamed HTTP body"
            int r1 = r3.b()
            r11.<init>(r0, r1)
            throw r11
        L_0x01af:
            com.b.a.ac r5 = r0.a()
            boolean r5 = a(r3, r5)
            if (r5 != 0) goto L_0x01d7
            com.b.a.a.b.g r5 = r10.f619c
            r5.c()
            com.b.a.a.b.g r5 = new com.b.a.a.b.g
            com.b.a.ai r6 = r10.f617a
            com.b.a.n r6 = r6.n()
            com.b.a.ac r7 = r0.a()
            com.b.a.a r7 = r10.a((com.b.a.ac) r7)
            java.lang.Object r8 = r10.d
            r5.<init>(r6, r7, r8)
            r10.f619c = r5
            goto L_0x001f
        L_0x01d7:
            com.b.a.a.b.g r5 = r10.f619c
            com.b.a.a.c.c r5 = r5.a()
            if (r5 == 0) goto L_0x001f
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
        L_0x01f8:
            r11 = move-exception
            goto L_0x0218
        L_0x01fa:
            r6 = move-exception
            boolean r7 = r6 instanceof com.b.a.a.e.a     // Catch:{ all -> 0x01f8 }
            if (r7 != 0) goto L_0x0200
            goto L_0x0201
        L_0x0200:
            r5 = 0
        L_0x0201:
            boolean r5 = r10.a(r6, r5, r0)     // Catch:{ all -> 0x01f8 }
            if (r5 != 0) goto L_0x001f
            throw r6     // Catch:{ all -> 0x01f8 }
        L_0x0208:
            r5 = move-exception
            java.io.IOException r6 = r5.a()     // Catch:{ all -> 0x01f8 }
            boolean r6 = r10.a(r6, r1, r0)     // Catch:{ all -> 0x01f8 }
            if (r6 != 0) goto L_0x001f
            java.io.IOException r11 = r5.a()     // Catch:{ all -> 0x01f8 }
            throw r11     // Catch:{ all -> 0x01f8 }
        L_0x0218:
            com.b.a.a.b.g r0 = r10.f619c
            r0.a((java.io.IOException) r2)
            com.b.a.a.b.g r0 = r10.f619c
            r0.c()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.c.k.a(com.b.a.ag):com.b.a.as");
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final boolean a() {
        return this.e;
    }
}
