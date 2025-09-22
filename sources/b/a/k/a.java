package b.a.k;

import b.a.c.c;
import b.a.c.g;
import b.a.k.c;
import b.aa;
import b.ac;
import b.ae;
import b.ai;
import b.aj;
import b.z;
import c.f;
import com.cyjh.common.util.s;
import com.github.kevinsawicki.http.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements c.a, ai {

    /* renamed from: a  reason: collision with root package name */
    public static final List<aa> f215a = Collections.singletonList(aa.HTTP_1_1);
    static final /* synthetic */ boolean o = true;
    private static final long p = 16777216;
    private static final long q = 60000;

    /* renamed from: b  reason: collision with root package name */
    public final ac f216b;

    /* renamed from: c  reason: collision with root package name */
    final aj f217c;
    final Random d;
    public final String e;
    public b.e f;
    c g;
    d h;
    ScheduledExecutorService i;
    e j;
    final ArrayDeque<Object> k = new ArrayDeque<>();
    boolean l;
    int m;
    int n;
    private final Runnable r;
    private final ArrayDeque<f> s = new ArrayDeque<>();
    private long t;
    private boolean u;
    private ScheduledFuture<?> v;
    private int w = -1;
    private String x;

    /* renamed from: b.a.k.a$a  reason: collision with other inner class name */
    final class C0002a implements Runnable {
        C0002a() {
        }

        public final void run() {
            a.this.f.c();
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f223a = 1001;

        /* renamed from: b  reason: collision with root package name */
        final f f224b = null;

        /* renamed from: c  reason: collision with root package name */
        final long f225c = a.q;

        b() {
        }
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        final int f226a;

        /* renamed from: b  reason: collision with root package name */
        final f f227b;

        c(int i, f fVar) {
            this.f226a = i;
            this.f227b = fVar;
        }
    }

    private final class d implements Runnable {
        d() {
        }

        public final void run() {
            a aVar = a.this;
            synchronized (aVar) {
                if (!aVar.l) {
                    d dVar = aVar.h;
                    try {
                        f fVar = f.EMPTY;
                        synchronized (dVar) {
                            dVar.a(9, fVar);
                        }
                    } catch (IOException unused) {
                        aVar.k();
                    }
                }
            }
        }
    }

    public static abstract class e implements Closeable {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f229c = true;
        public final c.e d;
        public final c.d e;

        public e(c.e eVar, c.d dVar) {
            this.d = eVar;
            this.e = dVar;
        }
    }

    public a(ac acVar, aj ajVar, Random random) {
        if (!HttpRequest.METHOD_GET.equals(acVar.f248b)) {
            throw new IllegalArgumentException("Request must be GET: " + acVar.f248b);
        }
        this.f216b = acVar;
        this.f217c = ajVar;
        this.d = random;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.e = f.of(bArr).base64();
        this.r = new Runnable() {
            public final void run() {
                do {
                    try {
                    } catch (IOException unused) {
                        a.this.k();
                        return;
                    }
                } while (a.this.j());
            }
        };
    }

    private void a(int i2, TimeUnit timeUnit) throws InterruptedException {
        this.i.awaitTermination((long) i2, timeUnit);
    }

    private void a(ae aeVar) throws ProtocolException {
        if (aeVar.f262c != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + aeVar.f262c + s.a.f1696a + aeVar.d + "'");
        }
        String a2 = aeVar.a("Connection");
        if (!"Upgrade".equalsIgnoreCase(a2)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + a2 + "'");
        }
        String a3 = aeVar.a("Upgrade");
        if (!"websocket".equalsIgnoreCase(a3)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + a3 + "'");
        }
        String a4 = aeVar.a("Sec-WebSocket-Accept");
        String base64 = f.encodeUtf8(this.e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (!base64.equals(a4)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + a4 + "'");
        }
    }

    private void a(z zVar) {
        z.a a2 = zVar.a();
        ArrayList arrayList = new ArrayList(f215a);
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
            final int i2 = e2.C;
            final ac d2 = this.f216b.c().a("Upgrade", "websocket").a("Connection", "Upgrade").a("Sec-WebSocket-Key", this.e).a("Sec-WebSocket-Version", "13").d();
            this.f = b.a.a.f11a.a(e2, d2);
            this.f.a(new b.f() {
                public final void a(b.e eVar, ae aeVar) {
                    try {
                        a aVar = a.this;
                        if (aeVar.f262c != 101) {
                            throw new ProtocolException("Expected HTTP 101 response but was '" + aeVar.f262c + s.a.f1696a + aeVar.d + "'");
                        }
                        String a2 = aeVar.a("Connection");
                        if (!"Upgrade".equalsIgnoreCase(a2)) {
                            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + a2 + "'");
                        }
                        String a3 = aeVar.a("Upgrade");
                        if (!"websocket".equalsIgnoreCase(a3)) {
                            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + a3 + "'");
                        }
                        String a4 = aeVar.a("Sec-WebSocket-Accept");
                        String base64 = f.encodeUtf8(aVar.e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                        if (!base64.equals(a4)) {
                            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + a4 + "'");
                        }
                        g a5 = b.a.a.f11a.a(eVar);
                        a5.d();
                        b.a.c.c b2 = a5.b();
                        c.AnonymousClass1 r0 = new e(b2.f, b2.g, a5) {
                            public final void close() throws IOException {
                                gVar.a(true, gVar.a());
                            }
                        };
                        try {
                            aj ajVar = a.this.f217c;
                            String str = "OkHttp WebSocket " + d2.f247a.h();
                            a aVar2 = a.this;
                            long j = (long) i2;
                            synchronized (aVar2) {
                                aVar2.j = r0;
                                aVar2.h = new d(r0.f229c, r0.e, aVar2.d);
                                aVar2.i = new ScheduledThreadPoolExecutor(1, b.a.c.a(str, false));
                                if (j != 0) {
                                    aVar2.i.scheduleAtFixedRate(new d(), j, j, TimeUnit.MILLISECONDS);
                                }
                                if (!aVar2.k.isEmpty()) {
                                    aVar2.i();
                                }
                            }
                            aVar2.g = new c(r0.f229c, r0.d, aVar2);
                            a5.b().f62c.setSoTimeout(0);
                            a.this.e();
                        } catch (Exception unused) {
                            a.this.k();
                        }
                    } catch (ProtocolException unused2) {
                        a.this.k();
                        b.a.c.a((Closeable) aeVar);
                    }
                }

                public final void a(IOException iOException) {
                    a.this.k();
                }
            });
        }
    }

    private void a(String str, long j2, e eVar) throws IOException {
        synchronized (this) {
            this.j = eVar;
            this.h = new d(eVar.f229c, eVar.e, this.d);
            this.i = new ScheduledThreadPoolExecutor(1, b.a.c.a(str, false));
            if (j2 != 0) {
                this.i.scheduleAtFixedRate(new d(), j2, j2, TimeUnit.MILLISECONDS);
            }
            if (!this.k.isEmpty()) {
                i();
            }
        }
        this.g = new c(eVar.f229c, eVar.d, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean a(c.f r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.l     // Catch:{ all -> 0x003d }
            r1 = 0
            if (r0 != 0) goto L_0x003b
            boolean r0 = r8.u     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x000b
            goto L_0x003b
        L_0x000b:
            long r2 = r8.t     // Catch:{ all -> 0x003d }
            int r0 = r9.size()     // Catch:{ all -> 0x003d }
            long r4 = (long) r0     // Catch:{ all -> 0x003d }
            long r6 = r2 + r4
            r2 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0020
            r8.p()     // Catch:{ all -> 0x003d }
            monitor-exit(r8)
            return r1
        L_0x0020:
            long r0 = r8.t     // Catch:{ all -> 0x003d }
            int r2 = r9.size()     // Catch:{ all -> 0x003d }
            long r2 = (long) r2     // Catch:{ all -> 0x003d }
            long r4 = r0 + r2
            r8.t = r4     // Catch:{ all -> 0x003d }
            java.util.ArrayDeque<java.lang.Object> r0 = r8.k     // Catch:{ all -> 0x003d }
            b.a.k.a$c r1 = new b.a.k.a$c     // Catch:{ all -> 0x003d }
            r1.<init>(r10, r9)     // Catch:{ all -> 0x003d }
            r0.add(r1)     // Catch:{ all -> 0x003d }
            r8.i()     // Catch:{ all -> 0x003d }
            r9 = 1
            monitor-exit(r8)
            return r9
        L_0x003b:
            monitor-exit(r8)
            return r1
        L_0x003d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.k.a.a(c.f, int):boolean");
    }

    private synchronized boolean c(f fVar) {
        boolean z;
        if (!this.l) {
            if (!this.u || !this.k.isEmpty()) {
                this.s.add(fVar);
                i();
                z = true;
            }
        }
        z = false;
        return z;
    }

    private boolean l() throws IOException {
        try {
            this.g.a();
            return this.w == -1;
        } catch (Exception unused) {
            k();
            return false;
        }
    }

    private void m() throws InterruptedException {
        if (this.v != null) {
            this.v.cancel(false);
        }
        this.i.shutdown();
        this.i.awaitTermination(10, TimeUnit.SECONDS);
    }

    private synchronized int n() {
        return this.m;
    }

    private synchronized int o() {
        return this.n;
    }

    private synchronized boolean p() {
        b.b(1001);
        if (!this.l) {
            if (!this.u) {
                this.u = true;
                this.k.add(new b());
                i();
                return true;
            }
        }
        return false;
    }

    private void q() {
        synchronized (this) {
            if (!this.l) {
                d dVar = this.h;
                try {
                    f fVar = f.EMPTY;
                    synchronized (dVar) {
                        dVar.a(9, fVar);
                    }
                } catch (IOException unused) {
                    k();
                }
            }
        }
    }

    public final ac a() {
        return this.f216b;
    }

    public final void a(int i2, String str) {
        e eVar;
        if (i2 == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.w != -1) {
                throw new IllegalStateException("already closed");
            }
            this.w = i2;
            this.x = str;
            if (!this.u || !this.k.isEmpty()) {
                eVar = null;
            } else {
                eVar = this.j;
                this.j = null;
                if (this.v != null) {
                    this.v.cancel(false);
                }
                this.i.shutdown();
            }
        }
        b.a.c.a((Closeable) eVar);
    }

    public final boolean a(f fVar) {
        if (fVar != null) {
            return a(fVar, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    public final boolean a(String str) {
        if (str != null) {
            return a(f.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public final synchronized long b() {
        return this.t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(c.f r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.l     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.u     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.k     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<c.f> r0 = r1.s     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.i()     // Catch:{ all -> 0x0024 }
            int r2 = r1.m     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.m = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.k.a.b(c.f):void");
    }

    public final boolean c() {
        return p();
    }

    public final void d() {
        this.f.c();
    }

    public final void e() throws IOException {
        while (this.w == -1) {
            this.g.a();
        }
    }

    public final void f() throws IOException {
    }

    public final void g() throws IOException {
    }

    public final synchronized void h() {
        this.n++;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        if (!o && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.i != null) {
            this.i.execute(this.r);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.a(10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005e, code lost:
        if ((r4 instanceof b.a.k.a.c) == false) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0060, code lost:
        r2 = ((b.a.k.a.c) r4).f227b;
        r4 = ((b.a.k.a.c) r4).f226a;
        r6 = (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0070, code lost:
        if (r0.g == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
        throw new java.lang.IllegalStateException("Another message writer is active. Did you call close()?");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
        r0.g = true;
        r0.f.f239a = r4;
        r0.f.f240b = r6;
        r0.f.f241c = true;
        r0.f.d = false;
        r0 = c.p.a((c.x) r0.f);
        r0.e(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r10.t -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a4, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ab, code lost:
        if ((r4 instanceof b.a.k.a.b) == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ad, code lost:
        r4 = (b.a.k.a.b) r4;
        r1 = r4.f223a;
        r2 = r4.f224b;
        r4 = c.f.EMPTY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b5, code lost:
        if (r1 != 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b7, code lost:
        if (r2 == null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b9, code lost:
        if (r1 == 0) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00bb, code lost:
        b.a.k.b.b(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00be, code lost:
        r4 = new c.c();
        r4.k(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00c6, code lost:
        if (r2 == null) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c8, code lost:
        r4.e(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00cb, code lost:
        r4 = r4.p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00cf, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r0.a(8, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r0.d = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d7, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d8, code lost:
        b.a.c.a((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00db, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00de, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r0.d = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00e1, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00e9, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00ea, code lost:
        b.a.c.a((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00ed, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:21:0x004d, B:63:0x00d2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j() throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.l     // Catch:{ all -> 0x00ee }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r10)     // Catch:{ all -> 0x00ee }
            return r1
        L_0x0008:
            b.a.k.d r0 = r10.h     // Catch:{ all -> 0x00ee }
            java.util.ArrayDeque<c.f> r2 = r10.s     // Catch:{ all -> 0x00ee }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00ee }
            c.f r2 = (c.f) r2     // Catch:{ all -> 0x00ee }
            r3 = 0
            if (r2 != 0) goto L_0x0048
            java.util.ArrayDeque<java.lang.Object> r4 = r10.k     // Catch:{ all -> 0x00ee }
            java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x00ee }
            boolean r5 = r4 instanceof b.a.k.a.b     // Catch:{ all -> 0x00ee }
            if (r5 == 0) goto L_0x0044
            int r5 = r10.w     // Catch:{ all -> 0x00ee }
            r6 = -1
            if (r5 == r6) goto L_0x002f
            b.a.k.a$e r5 = r10.j     // Catch:{ all -> 0x00ee }
            r10.j = r3     // Catch:{ all -> 0x00ee }
            java.util.concurrent.ScheduledExecutorService r3 = r10.i     // Catch:{ all -> 0x00ee }
            r3.shutdown()     // Catch:{ all -> 0x00ee }
            r3 = r5
            goto L_0x0049
        L_0x002f:
            java.util.concurrent.ScheduledExecutorService r5 = r10.i     // Catch:{ all -> 0x00ee }
            b.a.k.a$a r6 = new b.a.k.a$a     // Catch:{ all -> 0x00ee }
            r6.<init>()     // Catch:{ all -> 0x00ee }
            r7 = r4
            b.a.k.a$b r7 = (b.a.k.a.b) r7     // Catch:{ all -> 0x00ee }
            long r7 = r7.f225c     // Catch:{ all -> 0x00ee }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00ee }
            java.util.concurrent.ScheduledFuture r5 = r5.schedule(r6, r7, r9)     // Catch:{ all -> 0x00ee }
            r10.v = r5     // Catch:{ all -> 0x00ee }
            goto L_0x0049
        L_0x0044:
            if (r4 != 0) goto L_0x0049
            monitor-exit(r10)     // Catch:{ all -> 0x00ee }
            return r1
        L_0x0048:
            r4 = r3
        L_0x0049:
            monitor-exit(r10)     // Catch:{ all -> 0x00ee }
            r5 = 1
            if (r2 == 0) goto L_0x005c
            monitor-enter(r0)     // Catch:{ all -> 0x0059 }
            r1 = 10
            r0.a((int) r1, (c.f) r2)     // Catch:{ all -> 0x0056 }
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x00d8
        L_0x0056:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            goto L_0x00ea
        L_0x005c:
            boolean r2 = r4 instanceof b.a.k.a.c     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00a9
            r2 = r4
            b.a.k.a$c r2 = (b.a.k.a.c) r2     // Catch:{ all -> 0x0059 }
            c.f r2 = r2.f227b     // Catch:{ all -> 0x0059 }
            b.a.k.a$c r4 = (b.a.k.a.c) r4     // Catch:{ all -> 0x0059 }
            int r4 = r4.f226a     // Catch:{ all -> 0x0059 }
            int r6 = r2.size()     // Catch:{ all -> 0x0059 }
            long r6 = (long) r6     // Catch:{ all -> 0x0059 }
            boolean r8 = r0.g     // Catch:{ all -> 0x0059 }
            if (r8 == 0) goto L_0x007a
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = "Another message writer is active. Did you call close()?"
            r0.<init>(r1)     // Catch:{ all -> 0x0059 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x007a:
            r0.g = r5     // Catch:{ all -> 0x0059 }
            b.a.k.d$a r8 = r0.f     // Catch:{ all -> 0x0059 }
            r8.f239a = r4     // Catch:{ all -> 0x0059 }
            b.a.k.d$a r4 = r0.f     // Catch:{ all -> 0x0059 }
            r4.f240b = r6     // Catch:{ all -> 0x0059 }
            b.a.k.d$a r4 = r0.f     // Catch:{ all -> 0x0059 }
            r4.f241c = r5     // Catch:{ all -> 0x0059 }
            b.a.k.d$a r4 = r0.f     // Catch:{ all -> 0x0059 }
            r4.d = r1     // Catch:{ all -> 0x0059 }
            b.a.k.d$a r0 = r0.f     // Catch:{ all -> 0x0059 }
            c.d r0 = c.p.a((c.x) r0)     // Catch:{ all -> 0x0059 }
            r0.e(r2)     // Catch:{ all -> 0x0059 }
            r0.close()     // Catch:{ all -> 0x0059 }
            monitor-enter(r10)     // Catch:{ all -> 0x0059 }
            long r0 = r10.t     // Catch:{ all -> 0x00a6 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a6 }
            long r6 = (long) r2     // Catch:{ all -> 0x00a6 }
            long r8 = r0 - r6
            r10.t = r8     // Catch:{ all -> 0x00a6 }
            monitor-exit(r10)     // Catch:{ all -> 0x00a6 }
            goto L_0x00d8
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00a6 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x00a9:
            boolean r1 = r4 instanceof b.a.k.a.b     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x00e4
            b.a.k.a$b r4 = (b.a.k.a.b) r4     // Catch:{ all -> 0x0059 }
            int r1 = r4.f223a     // Catch:{ all -> 0x0059 }
            c.f r2 = r4.f224b     // Catch:{ all -> 0x0059 }
            c.f r4 = c.f.EMPTY     // Catch:{ all -> 0x0059 }
            if (r1 != 0) goto L_0x00b9
            if (r2 == 0) goto L_0x00cf
        L_0x00b9:
            if (r1 == 0) goto L_0x00be
            b.a.k.b.b(r1)     // Catch:{ all -> 0x0059 }
        L_0x00be:
            c.c r4 = new c.c     // Catch:{ all -> 0x0059 }
            r4.<init>()     // Catch:{ all -> 0x0059 }
            r4.k((int) r1)     // Catch:{ all -> 0x0059 }
            if (r2 == 0) goto L_0x00cb
            r4.e((c.f) r2)     // Catch:{ all -> 0x0059 }
        L_0x00cb:
            c.f r4 = r4.p()     // Catch:{ all -> 0x0059 }
        L_0x00cf:
            monitor-enter(r0)     // Catch:{ all -> 0x0059 }
            r1 = 8
            r0.a((int) r1, (c.f) r4)     // Catch:{ all -> 0x00de }
            r0.d = r5     // Catch:{ all -> 0x00dc }
            monitor-exit(r0)     // Catch:{ all -> 0x00dc }
        L_0x00d8:
            b.a.c.a((java.io.Closeable) r3)
            return r5
        L_0x00dc:
            r1 = move-exception
            goto L_0x00e2
        L_0x00de:
            r1 = move-exception
            r0.d = r5     // Catch:{ all -> 0x00dc }
            throw r1     // Catch:{ all -> 0x00dc }
        L_0x00e2:
            monitor-exit(r0)     // Catch:{ all -> 0x00dc }
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x00e4:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x0059 }
            r0.<init>()     // Catch:{ all -> 0x0059 }
            throw r0     // Catch:{ all -> 0x0059 }
        L_0x00ea:
            b.a.c.a((java.io.Closeable) r3)
            throw r0
        L_0x00ee:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00ee }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.k.a.j():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        b.a.c.a((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.l     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            return
        L_0x0007:
            r0 = 1
            r3.l = r0     // Catch:{ all -> 0x0027 }
            b.a.k.a$e r0 = r3.j     // Catch:{ all -> 0x0027 }
            r1 = 0
            r3.j = r1     // Catch:{ all -> 0x0027 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.v     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0019
            java.util.concurrent.ScheduledFuture<?> r1 = r3.v     // Catch:{ all -> 0x0027 }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0027 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.i     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0022
            java.util.concurrent.ScheduledExecutorService r1 = r3.i     // Catch:{ all -> 0x0027 }
            r1.shutdown()     // Catch:{ all -> 0x0027 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            b.a.c.a((java.io.Closeable) r0)
            return
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.k.a.k():void");
    }
}
