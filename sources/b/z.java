package b;

import b.a.a.f;
import b.a.c;
import b.a.c.g;
import b.a.j.b;
import b.a.j.d;
import b.ae;
import b.ai;
import b.e;
import b.l;
import b.r;
import b.u;
import com.umeng.commonsdk.proguard.v;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class z implements ai.a, e.a, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    static final List<aa> f370a = c.a((T[]) new aa[]{aa.HTTP_2, aa.HTTP_1_1});

    /* renamed from: b  reason: collision with root package name */
    static final List<l> f371b = c.a((T[]) new l[]{l.f323a, l.f325c});
    public final int A;
    public final int B;
    public final int C;

    /* renamed from: c  reason: collision with root package name */
    final p f372c;
    @Nullable
    public final Proxy d;
    public final List<aa> e;
    public final List<l> f;
    final List<w> g;
    final List<w> h;
    final r.a i;
    public final ProxySelector j;
    public final n k;
    @Nullable
    final c l;
    @Nullable
    final f m;
    public final SocketFactory n;
    @Nullable
    public final SSLSocketFactory o;
    @Nullable
    final b p;
    public final HostnameVerifier q;
    public final g r;
    public final b s;
    public final b t;
    public final k u;
    public final q v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final int z;

    public static final class a {
        int A;

        /* renamed from: a  reason: collision with root package name */
        p f373a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        Proxy f374b;

        /* renamed from: c  reason: collision with root package name */
        public List<aa> f375c;
        List<l> d;
        final List<w> e;
        final List<w> f;
        r.a g;
        ProxySelector h;
        n i;
        @Nullable
        c j;
        @Nullable
        f k;
        SocketFactory l;
        @Nullable
        SSLSocketFactory m;
        @Nullable
        b n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        k s;
        q t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f373a = new p();
            this.f375c = z.f370a;
            this.d = z.f371b;
            this.g = r.a(r.f340a);
            this.h = ProxySelector.getDefault();
            this.i = n.f335a;
            this.l = SocketFactory.getDefault();
            this.o = d.f209a;
            this.p = g.f307a;
            this.q = b.f275a;
            this.r = b.f275a;
            this.s = new k();
            this.t = q.f339a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = com.cyjh.elfin.a.b.ak;
            this.y = com.cyjh.elfin.a.b.ak;
            this.z = com.cyjh.elfin.a.b.ak;
            this.A = 0;
        }

        a(z zVar) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.f373a = zVar.f372c;
            this.f374b = zVar.d;
            this.f375c = zVar.e;
            this.d = zVar.f;
            this.e.addAll(zVar.g);
            this.f.addAll(zVar.h);
            this.g = zVar.i;
            this.h = zVar.j;
            this.i = zVar.k;
            this.k = zVar.m;
            this.j = zVar.l;
            this.l = zVar.n;
            this.m = zVar.o;
            this.n = zVar.p;
            this.o = zVar.q;
            this.p = zVar.r;
            this.q = zVar.s;
            this.r = zVar.t;
            this.s = zVar.u;
            this.t = zVar.v;
            this.u = zVar.w;
            this.v = zVar.x;
            this.w = zVar.y;
            this.x = zVar.z;
            this.y = zVar.A;
            this.z = zVar.B;
            this.A = zVar.C;
        }

        private static int a(String str, long j2, TimeUnit timeUnit) {
            if (j2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || j2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            }
        }

        private a a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.r = bVar;
            return this;
        }

        private a a(g gVar) {
            if (gVar == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.p = gVar;
            return this;
        }

        private a a(k kVar) {
            if (kVar == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.s = kVar;
            return this;
        }

        private a a(n nVar) {
            if (nVar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.i = nVar;
            return this;
        }

        private a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("dns == null");
            }
            this.t = qVar;
            return this;
        }

        private a a(r.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.g = aVar;
            return this;
        }

        private a a(r rVar) {
            if (rVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.g = r.a(rVar);
            return this;
        }

        private a a(ProxySelector proxySelector) {
            this.h = proxySelector;
            return this;
        }

        private a a(List<aa> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(aa.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
            } else if (arrayList.contains(aa.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (arrayList.contains((Object) null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                arrayList.remove(aa.SPDY_3);
                this.f375c = Collections.unmodifiableList(arrayList);
                return this;
            }
        }

        private a a(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.l = socketFactory;
            return this;
        }

        private a a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            X509TrustManager a2 = b.a.h.e.b().a(sSLSocketFactory);
            if (a2 == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + b.a.h.e.b() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
            }
            this.m = sSLSocketFactory;
            this.n = b.a.h.e.b().a(a2);
            return this;
        }

        private a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            } else {
                this.m = sSLSocketFactory;
                this.n = b.a.h.e.b().a(x509TrustManager);
                return this;
            }
        }

        private void a(@Nullable f fVar) {
            this.k = fVar;
            this.j = null;
        }

        private a b(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.q = bVar;
            return this;
        }

        private a b(w wVar) {
            this.e.add(wVar);
            return this;
        }

        private a b(List<l> list) {
            this.d = c.a(list);
            return this;
        }

        private a d(long j2, TimeUnit timeUnit) {
            this.A = a(v.av, j2, timeUnit);
            return this;
        }

        private List<w> f() {
            return this.e;
        }

        private List<w> g() {
            return this.f;
        }

        public final a a() {
            this.j = null;
            this.k = null;
            return this;
        }

        public final a a(long j2, TimeUnit timeUnit) {
            this.x = a("timeout", j2, timeUnit);
            return this;
        }

        public final a a(p pVar) {
            this.f373a = pVar;
            return this;
        }

        public final a a(w wVar) {
            this.f.add(wVar);
            return this;
        }

        public final a a(@Nullable Proxy proxy) {
            this.f374b = proxy;
            return this;
        }

        public final a a(HostnameVerifier hostnameVerifier) {
            this.o = hostnameVerifier;
            return this;
        }

        public final a b() {
            this.u = false;
            return this;
        }

        public final a b(long j2, TimeUnit timeUnit) {
            this.y = a("timeout", j2, timeUnit);
            return this;
        }

        public final a c() {
            this.v = false;
            return this;
        }

        public final a c(long j2, TimeUnit timeUnit) {
            this.z = a("timeout", j2, timeUnit);
            return this;
        }

        public final a d() {
            this.w = false;
            return this;
        }

        public final z e() {
            return new z(this);
        }
    }

    static {
        b.a.a.f11a = new b.a.a() {
            public final int a(ae.a aVar) {
                return aVar.f265c;
            }

            public final b.a.c.c a(k kVar, a aVar, g gVar, ag agVar) {
                if (k.g || Thread.holdsLock(kVar)) {
                    for (b.a.c.c next : kVar.d) {
                        if (next.a(aVar, agVar)) {
                            gVar.a(next);
                            return next;
                        }
                    }
                    return null;
                }
                throw new AssertionError();
            }

            public final b.a.c.d a(k kVar) {
                return kVar.e;
            }

            public final g a(e eVar) {
                return ((ab) eVar).f243b.f87a;
            }

            public final e a(z zVar, ac acVar) {
                return new ab(zVar, acVar, true);
            }

            public final v a(String str) throws MalformedURLException, UnknownHostException {
                return v.e(str);
            }

            public final Socket a(k kVar, a aVar, g gVar) {
                if (k.g || Thread.holdsLock(kVar)) {
                    for (b.a.c.c next : kVar.d) {
                        if (next.a(aVar, (ag) null) && next.e() && next != gVar.b()) {
                            if (!g.h && !Thread.holdsLock(gVar.f71c)) {
                                throw new AssertionError();
                            } else if (gVar.g == null && gVar.e.k.size() == 1) {
                                Socket a2 = gVar.a(true, false, false);
                                gVar.e = next;
                                next.k.add(gVar.e.k.get(0));
                                return a2;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                    }
                    return null;
                }
                throw new AssertionError();
            }

            public final void a(l lVar, SSLSocket sSLSocket, boolean z) {
                String[] a2 = lVar.f != null ? c.a((Comparator<? super String>) i.f316a, sSLSocket.getEnabledCipherSuites(), lVar.f) : sSLSocket.getEnabledCipherSuites();
                String[] a3 = lVar.g != null ? c.a((Comparator<? super String>) c.g, sSLSocket.getEnabledProtocols(), lVar.g) : sSLSocket.getEnabledProtocols();
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                int a4 = c.a(i.f316a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
                if (z && a4 != -1) {
                    a2 = c.a(a2, supportedCipherSuites[a4]);
                }
                l b2 = new l.a(lVar).a(a2).b(a3).b();
                if (b2.g != null) {
                    sSLSocket.setEnabledProtocols(b2.g);
                }
                if (b2.f != null) {
                    sSLSocket.setEnabledCipherSuites(b2.f);
                }
            }

            public final void a(u.a aVar, String str) {
                aVar.a(str);
            }

            public final void a(u.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            public final void a(a aVar, f fVar) {
                aVar.k = fVar;
                aVar.j = null;
            }

            public final boolean a(a aVar, a aVar2) {
                return aVar.a(aVar2);
            }

            public final boolean a(k kVar, b.a.c.c cVar) {
                if (!k.g && !Thread.holdsLock(kVar)) {
                    throw new AssertionError();
                } else if (cVar.h || kVar.f320b == 0) {
                    kVar.d.remove(cVar);
                    return true;
                } else {
                    kVar.notifyAll();
                    return false;
                }
            }

            public final void b(k kVar, b.a.c.c cVar) {
                if (k.g || Thread.holdsLock(kVar)) {
                    if (!kVar.f) {
                        kVar.f = true;
                        k.f319a.execute(kVar.f321c);
                    }
                    kVar.d.add(cVar);
                    return;
                }
                throw new AssertionError();
            }
        };
    }

    public z() {
        this(new a());
    }

    z(a aVar) {
        boolean z2;
        b bVar;
        this.f372c = aVar.f373a;
        this.d = aVar.f374b;
        this.e = aVar.f375c;
        this.f = aVar.d;
        this.g = c.a(aVar.e);
        this.h = c.a(aVar.f);
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        Iterator<l> it = this.f.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                l next = it.next();
                if (z2 || next.d) {
                    z2 = true;
                }
            }
        }
        if (aVar.m != null || !z2) {
            this.o = aVar.m;
            bVar = aVar.n;
        } else {
            X509TrustManager b2 = b();
            this.o = a(b2);
            bVar = b.a.h.e.b().a(b2);
        }
        this.p = bVar;
        this.q = aVar.o;
        g gVar = aVar.p;
        b bVar2 = this.p;
        this.r = !c.a((Object) gVar.f309c, (Object) bVar2) ? new g(gVar.f308b, bVar2) : gVar;
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
    }

    private List<w> A() {
        return this.h;
    }

    private r.a B() {
        return this.i;
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    private static X509TrustManager b() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                if (trustManagers[0] instanceof X509TrustManager) {
                    return (X509TrustManager) trustManagers[0];
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    private int c() {
        return this.z;
    }

    private int d() {
        return this.A;
    }

    private int e() {
        return this.B;
    }

    private int f() {
        return this.C;
    }

    private Proxy g() {
        return this.d;
    }

    private ProxySelector h() {
        return this.j;
    }

    private n i() {
        return this.k;
    }

    private c j() {
        return this.l;
    }

    private f k() {
        return this.l != null ? this.l.f280a : this.m;
    }

    private q l() {
        return this.v;
    }

    private SocketFactory m() {
        return this.n;
    }

    private SSLSocketFactory n() {
        return this.o;
    }

    private HostnameVerifier o() {
        return this.q;
    }

    private g p() {
        return this.r;
    }

    private b q() {
        return this.t;
    }

    private b r() {
        return this.s;
    }

    private k s() {
        return this.u;
    }

    private boolean t() {
        return this.w;
    }

    private boolean u() {
        return this.x;
    }

    private boolean v() {
        return this.y;
    }

    private p w() {
        return this.f372c;
    }

    private List<aa> x() {
        return this.e;
    }

    private List<l> y() {
        return this.f;
    }

    private List<w> z() {
        return this.g;
    }

    public final ai a(ac acVar, aj ajVar) {
        b.a.k.a aVar = new b.a.k.a(acVar, ajVar, new Random());
        a a2 = a();
        ArrayList arrayList = new ArrayList(b.a.k.a.f215a);
        if (!arrayList.contains(aa.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
        } else if (arrayList.contains(aa.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
        } else if (arrayList.contains((Object) null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        } else {
            arrayList.remove(aa.SPDY_3);
            a2.f375c = Collections.unmodifiableList(arrayList);
            z e2 = a2.e();
            int i2 = e2.C;
            ac d2 = aVar.f216b.c().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", aVar.e).a("Sec-WebSocket-Version", "13").d();
            aVar.f = b.a.a.f11a.a(e2, d2);
            aVar.f.a(new f(d2, i2) {
                public final void a(
/*
Method generation error in method: b.a.k.a.2.a(b.e, b.ae):void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: b.a.k.a.2.a(b.e, b.ae):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/

                public final void a(
/*
Method generation error in method: b.a.k.a.2.a(java.io.IOException):void, dex: classes.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: b.a.k.a.2.a(java.io.IOException):void, class status: UNLOADED
                	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            return aVar;
        }
    }

    public final e a(ac acVar) {
        return new ab(this, acVar, false);
    }

    public final a a() {
        return new a(this);
    }
}
