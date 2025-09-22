package com.b.a.a.b;

import com.b.a.a.d.a;
import com.b.a.a.e.ab;
import com.b.a.a.e.b;
import com.b.a.a.e.j;
import com.b.a.a.e.s;
import com.b.a.ai;
import com.b.a.al;
import com.b.a.aw;
import com.b.a.m;
import com.b.a.n;
import com.b.a.z;
import com.b.b.g;
import com.b.b.h;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class c extends s implements m {

    /* renamed from: a  reason: collision with root package name */
    public boolean f590a;

    /* renamed from: b  reason: collision with root package name */
    public int f591b;

    /* renamed from: c  reason: collision with root package name */
    public int f592c = 1;
    public final List<Reference<g>> d = new ArrayList();
    public long e = Long.MAX_VALUE;
    private final n g;
    private final aw h;
    private Socket i;
    private Socket j;
    private z k;
    private al l;
    private j m;
    private h n;
    private g o;

    public c(n nVar, aw awVar) {
        this.g = nVar;
        this.h = awVar;
    }

    private void a(int i2, int i3) {
        Proxy b2 = this.h.b();
        this.i = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.h.a().c().createSocket() : new Socket(b2);
        this.i.setSoTimeout(i3);
        try {
            com.b.a.a.g.h.b().a(this.i, this.h.c(), i2);
            this.n = com.b.b.n.a(com.b.b.n.b(this.i));
            this.o = com.b.b.n.a(com.b.b.n.a(this.i));
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.h.c());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final com.b.a.a.c.c a(ai aiVar, g gVar) {
        if (this.m != null) {
            return new com.b.a.a.e.h(aiVar, gVar, this.m);
        }
        this.j.setSoTimeout(aiVar.b());
        this.n.a().a((long) aiVar.b(), TimeUnit.MILLISECONDS);
        this.o.a().a((long) aiVar.c(), TimeUnit.MILLISECONDS);
        return new a(aiVar, gVar, this.n, this.o);
    }

    public final aw a() {
        return this.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02ad, code lost:
        if (r1.l != com.b.a.al.HTTP_2) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02af, code lost:
        r1.j.setSoTimeout(0);
        r1.m = new com.b.a.a.e.r().a(r1.j, r1.h.a().a().f(), r1.n, r1.o).a(r1).a();
        r1.m.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02e2, code lost:
        if (r1.m == null) goto L_0x02f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02e4, code lost:
        r2 = r1.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02e6, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r1.f592c = r1.m.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02ef, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02f0, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02f1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02f4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02f5, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0311 A[SYNTHETIC, Splitter:B:101:0x0311] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0352 A[LOOP:0: B:15:0x0076->B:117:0x0352, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0355 A[EDGE_INSN: B:124:0x0355->B:118:0x0355 ?: BREAK  
    EDGE_INSN: B:125:0x0355->B:118:0x0355 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0318 A[EDGE_INSN: B:120:0x0318->B:103:0x0318 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0306 A[Catch:{ all -> 0x030d }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x030c A[Catch:{ all -> 0x030d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r18, int r19, int r20, boolean r21) {
        /*
            r17 = this;
            r1 = r17
            com.b.a.al r2 = r1.l
            if (r2 == 0) goto L_0x000e
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "already connected"
            r2.<init>(r3)
            throw r2
        L_0x000e:
            com.b.a.aw r2 = r1.h
            com.b.a.a r2 = r2.a()
            java.util.List r2 = r2.f()
            com.b.a.a.b.b r3 = new com.b.a.a.b.b
            r3.<init>(r2)
            com.b.a.aw r4 = r1.h
            com.b.a.a r4 = r4.a()
            javax.net.ssl.SSLSocketFactory r4 = r4.i()
            if (r4 != 0) goto L_0x0074
            com.b.a.p r4 = com.b.a.p.f824c
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x003e
            com.b.a.a.b.e r2 = new com.b.a.a.b.e
            java.net.UnknownServiceException r3 = new java.net.UnknownServiceException
            java.lang.String r4 = "CLEARTEXT communication not enabled for client"
            r3.<init>(r4)
            r2.<init>(r3)
            throw r2
        L_0x003e:
            com.b.a.aw r2 = r1.h
            com.b.a.a r2 = r2.a()
            com.b.a.ac r2 = r2.a()
            java.lang.String r2 = r2.f()
            com.b.a.a.g.h r4 = com.b.a.a.g.h.b()
            boolean r4 = r4.b((java.lang.String) r2)
            if (r4 != 0) goto L_0x0074
            com.b.a.a.b.e r3 = new com.b.a.a.b.e
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
        L_0x0074:
            r2 = 0
            r4 = r2
        L_0x0076:
            com.b.a.aw r5 = r1.h     // Catch:{ IOException -> 0x031e }
            boolean r5 = r5.d()     // Catch:{ IOException -> 0x031e }
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x018b
            com.b.a.ap r5 = new com.b.a.ap     // Catch:{ IOException -> 0x031e }
            r5.<init>()     // Catch:{ IOException -> 0x031e }
            com.b.a.aw r8 = r1.h     // Catch:{ IOException -> 0x031e }
            com.b.a.a r8 = r8.a()     // Catch:{ IOException -> 0x031e }
            com.b.a.ac r8 = r8.a()     // Catch:{ IOException -> 0x031e }
            com.b.a.ap r5 = r5.a((com.b.a.ac) r8)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = "Host"
            com.b.a.aw r9 = r1.h     // Catch:{ IOException -> 0x031e }
            com.b.a.a r9 = r9.a()     // Catch:{ IOException -> 0x031e }
            com.b.a.ac r9 = r9.a()     // Catch:{ IOException -> 0x031e }
            java.lang.String r9 = com.b.a.a.c.a((com.b.a.ac) r9, (boolean) r7)     // Catch:{ IOException -> 0x031e }
            com.b.a.ap r5 = r5.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = "Proxy-Connection"
            java.lang.String r9 = "Keep-Alive"
            com.b.a.ap r5 = r5.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = "User-Agent"
            java.lang.String r9 = "okhttp/3.6.0"
            com.b.a.ap r5 = r5.a((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x031e }
            com.b.a.ao r5 = r5.a()     // Catch:{ IOException -> 0x031e }
            com.b.a.ac r8 = r5.a()     // Catch:{ IOException -> 0x031e }
            r17.a((int) r18, (int) r19)     // Catch:{ IOException -> 0x031e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x031e }
            java.lang.String r10 = "CONNECT "
            r9.<init>(r10)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = com.b.a.a.c.a((com.b.a.ac) r8, (boolean) r7)     // Catch:{ IOException -> 0x031e }
            r9.append(r8)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = " HTTP/1.1"
            r9.append(r8)     // Catch:{ IOException -> 0x031e }
            java.lang.String r8 = r9.toString()     // Catch:{ IOException -> 0x031e }
            com.b.a.a.d.a r9 = new com.b.a.a.d.a     // Catch:{ IOException -> 0x031e }
            com.b.b.h r10 = r1.n     // Catch:{ IOException -> 0x031e }
            com.b.b.g r11 = r1.o     // Catch:{ IOException -> 0x031e }
            r9.<init>(r2, r2, r10, r11)     // Catch:{ IOException -> 0x031e }
            com.b.b.h r10 = r1.n     // Catch:{ IOException -> 0x031e }
            com.b.b.y r10 = r10.a()     // Catch:{ IOException -> 0x031e }
            r11 = r19
            long r12 = (long) r11
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x0188 }
            r10.a(r12, r14)     // Catch:{ IOException -> 0x0188 }
            com.b.b.g r10 = r1.o     // Catch:{ IOException -> 0x0188 }
            com.b.b.y r10 = r10.a()     // Catch:{ IOException -> 0x0188 }
            r12 = r20
            long r13 = (long) r12
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x031c }
            r10.a(r13, r15)     // Catch:{ IOException -> 0x031c }
            com.b.a.aa r10 = r5.c()     // Catch:{ IOException -> 0x031c }
            r9.a((com.b.a.aa) r10, (java.lang.String) r8)     // Catch:{ IOException -> 0x031c }
            r9.b()     // Catch:{ IOException -> 0x031c }
            com.b.a.at r8 = r9.a((boolean) r6)     // Catch:{ IOException -> 0x031c }
            com.b.a.at r5 = r8.a((com.b.a.ao) r5)     // Catch:{ IOException -> 0x031c }
            com.b.a.as r5 = r5.a()     // Catch:{ IOException -> 0x031c }
            long r13 = com.b.a.a.c.f.a((com.b.a.as) r5)     // Catch:{ IOException -> 0x031c }
            r15 = -1
            int r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r8 != 0) goto L_0x0120
            r13 = 0
        L_0x0120:
            com.b.b.x r8 = r9.a((long) r13)     // Catch:{ IOException -> 0x031c }
            r9 = 2147483647(0x7fffffff, float:NaN)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ IOException -> 0x031c }
            com.b.a.a.c.a((com.b.b.x) r8, (int) r9, (java.util.concurrent.TimeUnit) r10)     // Catch:{ IOException -> 0x031c }
            r8.close()     // Catch:{ IOException -> 0x031c }
            int r8 = r5.b()     // Catch:{ IOException -> 0x031c }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 == r9) goto L_0x0168
            r6 = 407(0x197, float:5.7E-43)
            if (r8 == r6) goto L_0x0153
            java.io.IOException r6 = new java.io.IOException     // Catch:{ IOException -> 0x031c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x031c }
            java.lang.String r8 = "Unexpected response code for CONNECT: "
            r7.<init>(r8)     // Catch:{ IOException -> 0x031c }
            int r5 = r5.b()     // Catch:{ IOException -> 0x031c }
            r7.append(r5)     // Catch:{ IOException -> 0x031c }
            java.lang.String r5 = r7.toString()     // Catch:{ IOException -> 0x031c }
            r6.<init>(r5)     // Catch:{ IOException -> 0x031c }
            throw r6     // Catch:{ IOException -> 0x031c }
        L_0x0153:
            com.b.a.aw r5 = r1.h     // Catch:{ IOException -> 0x031c }
            com.b.a.a r5 = r5.a()     // Catch:{ IOException -> 0x031c }
            com.b.a.b r5 = r5.d()     // Catch:{ IOException -> 0x031c }
            r5.a()     // Catch:{ IOException -> 0x031c }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x031c }
            java.lang.String r6 = "Failed to authenticate with proxy"
            r5.<init>(r6)     // Catch:{ IOException -> 0x031c }
            throw r5     // Catch:{ IOException -> 0x031c }
        L_0x0168:
            com.b.b.h r5 = r1.n     // Catch:{ IOException -> 0x031c }
            com.b.b.f r5 = r5.c()     // Catch:{ IOException -> 0x031c }
            boolean r5 = r5.d()     // Catch:{ IOException -> 0x031c }
            if (r5 == 0) goto L_0x0180
            com.b.b.g r5 = r1.o     // Catch:{ IOException -> 0x031c }
            com.b.b.f r5 = r5.c()     // Catch:{ IOException -> 0x031c }
            boolean r5 = r5.d()     // Catch:{ IOException -> 0x031c }
            if (r5 != 0) goto L_0x0192
        L_0x0180:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x031c }
            java.lang.String r6 = "TLS tunnel buffered too many bytes!"
            r5.<init>(r6)     // Catch:{ IOException -> 0x031c }
            throw r5     // Catch:{ IOException -> 0x031c }
        L_0x0188:
            r0 = move-exception
            goto L_0x0321
        L_0x018b:
            r11 = r19
            r12 = r20
            r17.a((int) r18, (int) r19)     // Catch:{ IOException -> 0x031c }
        L_0x0192:
            com.b.a.aw r5 = r1.h     // Catch:{ IOException -> 0x031c }
            com.b.a.a r5 = r5.a()     // Catch:{ IOException -> 0x031c }
            javax.net.ssl.SSLSocketFactory r5 = r5.i()     // Catch:{ IOException -> 0x031c }
            if (r5 != 0) goto L_0x01a8
            com.b.a.al r5 = com.b.a.al.HTTP_1_1     // Catch:{ IOException -> 0x031c }
            r1.l = r5     // Catch:{ IOException -> 0x031c }
            java.net.Socket r5 = r1.i     // Catch:{ IOException -> 0x031c }
            r1.j = r5     // Catch:{ IOException -> 0x031c }
            goto L_0x02e0
        L_0x01a8:
            com.b.a.aw r5 = r1.h     // Catch:{ IOException -> 0x031c }
            com.b.a.a r5 = r5.a()     // Catch:{ IOException -> 0x031c }
            javax.net.ssl.SSLSocketFactory r8 = r5.i()     // Catch:{ IOException -> 0x031c }
            java.net.Socket r9 = r1.i     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            com.b.a.ac r10 = r5.a()     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            java.lang.String r10 = r10.f()     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            com.b.a.ac r13 = r5.a()     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            int r13 = r13.g()     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            java.net.Socket r7 = r8.createSocket(r9, r10, r13, r7)     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            javax.net.ssl.SSLSocket r7 = (javax.net.ssl.SSLSocket) r7     // Catch:{ AssertionError -> 0x02fd, all -> 0x02f9 }
            com.b.a.p r8 = r3.a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x02f6 }
            boolean r9 = r8.a()     // Catch:{ AssertionError -> 0x02f6 }
            if (r9 == 0) goto L_0x01e7
            com.b.a.a.g.h r9 = com.b.a.a.g.h.b()     // Catch:{ AssertionError -> 0x02f6 }
            com.b.a.ac r10 = r5.a()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r10 = r10.f()     // Catch:{ AssertionError -> 0x02f6 }
            java.util.List r13 = r5.e()     // Catch:{ AssertionError -> 0x02f6 }
            r9.a((javax.net.ssl.SSLSocket) r7, (java.lang.String) r10, (java.util.List<com.b.a.al>) r13)     // Catch:{ AssertionError -> 0x02f6 }
        L_0x01e7:
            r7.startHandshake()     // Catch:{ AssertionError -> 0x02f6 }
            javax.net.ssl.SSLSession r9 = r7.getSession()     // Catch:{ AssertionError -> 0x02f6 }
            com.b.a.z r9 = com.b.a.z.a(r9)     // Catch:{ AssertionError -> 0x02f6 }
            javax.net.ssl.HostnameVerifier r10 = r5.j()     // Catch:{ AssertionError -> 0x02f6 }
            com.b.a.ac r13 = r5.a()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r13 = r13.f()     // Catch:{ AssertionError -> 0x02f6 }
            javax.net.ssl.SSLSession r14 = r7.getSession()     // Catch:{ AssertionError -> 0x02f6 }
            boolean r10 = r10.verify(r13, r14)     // Catch:{ AssertionError -> 0x02f6 }
            if (r10 != 0) goto L_0x0256
            java.util.List r8 = r9.b()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.Object r6 = r8.get(r6)     // Catch:{ AssertionError -> 0x02f6 }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ AssertionError -> 0x02f6 }
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r10 = "Hostname "
            r9.<init>(r10)     // Catch:{ AssertionError -> 0x02f6 }
            com.b.a.ac r5 = r5.a()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = r5.f()     // Catch:{ AssertionError -> 0x02f6 }
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = " not verified:\n    certificate: "
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = com.b.a.i.a((java.security.cert.Certificate) r6)     // Catch:{ AssertionError -> 0x02f6 }
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = "\n    DN: "
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.security.Principal r5 = r6.getSubjectDN()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = r5.getName()     // Catch:{ AssertionError -> 0x02f6 }
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = "\n    subjectAltNames: "
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.util.List r5 = com.b.a.a.h.d.a(r6)     // Catch:{ AssertionError -> 0x02f6 }
            r9.append(r5)     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = r9.toString()     // Catch:{ AssertionError -> 0x02f6 }
            r8.<init>(r5)     // Catch:{ AssertionError -> 0x02f6 }
            throw r8     // Catch:{ AssertionError -> 0x02f6 }
        L_0x0256:
            com.b.a.i r10 = r5.k()     // Catch:{ AssertionError -> 0x02f6 }
            com.b.a.ac r5 = r5.a()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = r5.f()     // Catch:{ AssertionError -> 0x02f6 }
            java.util.List r13 = r9.b()     // Catch:{ AssertionError -> 0x02f6 }
            r10.a(r5, r13)     // Catch:{ AssertionError -> 0x02f6 }
            boolean r5 = r8.a()     // Catch:{ AssertionError -> 0x02f6 }
            if (r5 == 0) goto L_0x0278
            com.b.a.a.g.h r5 = com.b.a.a.g.h.b()     // Catch:{ AssertionError -> 0x02f6 }
            java.lang.String r5 = r5.a((javax.net.ssl.SSLSocket) r7)     // Catch:{ AssertionError -> 0x02f6 }
            goto L_0x0279
        L_0x0278:
            r5 = r2
        L_0x0279:
            r1.j = r7     // Catch:{ AssertionError -> 0x02f6 }
            java.net.Socket r8 = r1.j     // Catch:{ AssertionError -> 0x02f6 }
            com.b.b.x r8 = com.b.b.n.b(r8)     // Catch:{ AssertionError -> 0x02f6 }
            com.b.b.h r8 = com.b.b.n.a((com.b.b.x) r8)     // Catch:{ AssertionError -> 0x02f6 }
            r1.n = r8     // Catch:{ AssertionError -> 0x02f6 }
            java.net.Socket r8 = r1.j     // Catch:{ AssertionError -> 0x02f6 }
            com.b.b.w r8 = com.b.b.n.a((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x02f6 }
            com.b.b.g r8 = com.b.b.n.a((com.b.b.w) r8)     // Catch:{ AssertionError -> 0x02f6 }
            r1.o = r8     // Catch:{ AssertionError -> 0x02f6 }
            r1.k = r9     // Catch:{ AssertionError -> 0x02f6 }
            if (r5 == 0) goto L_0x029c
            com.b.a.al r5 = com.b.a.al.a(r5)     // Catch:{ AssertionError -> 0x02f6 }
            goto L_0x029e
        L_0x029c:
            com.b.a.al r5 = com.b.a.al.HTTP_1_1     // Catch:{ AssertionError -> 0x02f6 }
        L_0x029e:
            r1.l = r5     // Catch:{ AssertionError -> 0x02f6 }
            if (r7 == 0) goto L_0x02a9
            com.b.a.a.g.h r5 = com.b.a.a.g.h.b()     // Catch:{ IOException -> 0x031c }
            r5.b((javax.net.ssl.SSLSocket) r7)     // Catch:{ IOException -> 0x031c }
        L_0x02a9:
            com.b.a.al r5 = r1.l     // Catch:{ IOException -> 0x031c }
            com.b.a.al r7 = com.b.a.al.HTTP_2     // Catch:{ IOException -> 0x031c }
            if (r5 != r7) goto L_0x02e0
            java.net.Socket r5 = r1.j     // Catch:{ IOException -> 0x031c }
            r5.setSoTimeout(r6)     // Catch:{ IOException -> 0x031c }
            com.b.a.a.e.r r5 = new com.b.a.a.e.r     // Catch:{ IOException -> 0x031c }
            r5.<init>()     // Catch:{ IOException -> 0x031c }
            java.net.Socket r6 = r1.j     // Catch:{ IOException -> 0x031c }
            com.b.a.aw r7 = r1.h     // Catch:{ IOException -> 0x031c }
            com.b.a.a r7 = r7.a()     // Catch:{ IOException -> 0x031c }
            com.b.a.ac r7 = r7.a()     // Catch:{ IOException -> 0x031c }
            java.lang.String r7 = r7.f()     // Catch:{ IOException -> 0x031c }
            com.b.b.h r8 = r1.n     // Catch:{ IOException -> 0x031c }
            com.b.b.g r9 = r1.o     // Catch:{ IOException -> 0x031c }
            com.b.a.a.e.r r5 = r5.a(r6, r7, r8, r9)     // Catch:{ IOException -> 0x031c }
            com.b.a.a.e.r r5 = r5.a(r1)     // Catch:{ IOException -> 0x031c }
            com.b.a.a.e.j r5 = r5.a()     // Catch:{ IOException -> 0x031c }
            r1.m = r5     // Catch:{ IOException -> 0x031c }
            com.b.a.a.e.j r5 = r1.m     // Catch:{ IOException -> 0x031c }
            r5.b()     // Catch:{ IOException -> 0x031c }
        L_0x02e0:
            com.b.a.a.e.j r2 = r1.m
            if (r2 == 0) goto L_0x02f5
            com.b.a.n r2 = r1.g
            monitor-enter(r2)
            com.b.a.a.e.j r3 = r1.m     // Catch:{ all -> 0x02f1 }
            int r3 = r3.a()     // Catch:{ all -> 0x02f1 }
            r1.f592c = r3     // Catch:{ all -> 0x02f1 }
            monitor-exit(r2)     // Catch:{ all -> 0x02f1 }
            return
        L_0x02f1:
            r0 = move-exception
            r3 = r0
            monitor-exit(r2)     // Catch:{ all -> 0x02f1 }
            throw r3
        L_0x02f5:
            return
        L_0x02f6:
            r0 = move-exception
            r5 = r0
            goto L_0x0300
        L_0x02f9:
            r0 = move-exception
            r5 = r0
            r7 = r2
            goto L_0x030f
        L_0x02fd:
            r0 = move-exception
            r5 = r0
            r7 = r2
        L_0x0300:
            boolean r6 = com.b.a.a.c.a((java.lang.AssertionError) r5)     // Catch:{ all -> 0x030d }
            if (r6 == 0) goto L_0x030c
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x030d }
            r6.<init>(r5)     // Catch:{ all -> 0x030d }
            throw r6     // Catch:{ all -> 0x030d }
        L_0x030c:
            throw r5     // Catch:{ all -> 0x030d }
        L_0x030d:
            r0 = move-exception
            r5 = r0
        L_0x030f:
            if (r7 == 0) goto L_0x0318
            com.b.a.a.g.h r6 = com.b.a.a.g.h.b()     // Catch:{ IOException -> 0x031c }
            r6.b((javax.net.ssl.SSLSocket) r7)     // Catch:{ IOException -> 0x031c }
        L_0x0318:
            com.b.a.a.c.a((java.net.Socket) r7)     // Catch:{ IOException -> 0x031c }
            throw r5     // Catch:{ IOException -> 0x031c }
        L_0x031c:
            r0 = move-exception
            goto L_0x0323
        L_0x031e:
            r0 = move-exception
            r11 = r19
        L_0x0321:
            r12 = r20
        L_0x0323:
            r5 = r0
            java.net.Socket r6 = r1.j
            com.b.a.a.c.a((java.net.Socket) r6)
            java.net.Socket r6 = r1.i
            com.b.a.a.c.a((java.net.Socket) r6)
            r1.j = r2
            r1.i = r2
            r1.n = r2
            r1.o = r2
            r1.k = r2
            r1.l = r2
            r1.m = r2
            if (r4 != 0) goto L_0x0345
            com.b.a.a.b.e r4 = new com.b.a.a.b.e
            r4.<init>(r5)
        L_0x0343:
            r6 = r4
            goto L_0x0349
        L_0x0345:
            r4.a(r5)
            goto L_0x0343
        L_0x0349:
            if (r21 == 0) goto L_0x0355
            boolean r5 = r3.a((java.io.IOException) r5)
            if (r5 != 0) goto L_0x0352
            goto L_0x0355
        L_0x0352:
            r4 = r6
            goto L_0x0076
        L_0x0355:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.b.c.a(int, int, int, boolean):void");
    }

    public final void a(ab abVar) {
        abVar.a(b.REFUSED_STREAM);
    }

    public final void a(j jVar) {
        synchronized (this.g) {
            this.f592c = jVar.a();
        }
    }

    public final boolean a(com.b.a.a aVar) {
        return this.d.size() < this.f592c && aVar.equals(this.h.a()) && !this.f590a;
    }

    public final boolean a(boolean z) {
        int soTimeout;
        if (this.j.isClosed() || this.j.isInputShutdown() || this.j.isOutputShutdown()) {
            return false;
        }
        if (this.m != null) {
            return !this.m.c();
        }
        if (z) {
            try {
                soTimeout = this.j.getSoTimeout();
                this.j.setSoTimeout(1);
                if (this.n.d()) {
                    this.j.setSoTimeout(soTimeout);
                    return false;
                }
                this.j.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.j.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public final Socket b() {
        return this.j;
    }

    public final z c() {
        return this.k;
    }

    public final boolean d() {
        return this.m != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.h.a().a().f());
        sb.append(":");
        sb.append(this.h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.h.b());
        sb.append(" hostAddress=");
        sb.append(this.h.c());
        sb.append(" cipherSuite=");
        sb.append(this.k != null ? this.k.a() : "none");
        sb.append(" protocol=");
        sb.append(this.l);
        sb.append('}');
        return sb.toString();
    }
}
