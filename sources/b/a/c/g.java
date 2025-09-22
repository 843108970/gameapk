package b.a.c;

import b.a.d.c;
import b.a.f.b;
import b.a.f.f;
import b.a.f.o;
import b.ag;
import b.k;
import b.z;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Proxy;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public final class g {
    public static final /* synthetic */ boolean h = true;

    /* renamed from: a  reason: collision with root package name */
    public final b.a f69a;

    /* renamed from: b  reason: collision with root package name */
    public ag f70b;

    /* renamed from: c  reason: collision with root package name */
    public final k f71c;
    public final f d;
    public c e;
    public boolean f;
    public c g;
    private final Object i;
    private int j;
    private boolean k;

    public static final class a extends WeakReference<g> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f72a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f72a = obj;
        }
    }

    public g(k kVar, b.a aVar, Object obj) {
        this.f71c = kVar;
        this.f69a = aVar;
        this.d = new f(aVar, e());
        this.i = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r1 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0048, code lost:
        r1 = r6.d.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        r2 = r6.f71c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        if (r6.f == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005c, code lost:
        throw new java.io.IOException("Canceled");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005d, code lost:
        b.a.a.f11a.a(r6.f71c, r6.f69a, r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0068, code lost:
        if (r6.e == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x006a, code lost:
        r7 = r6.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006c, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006e, code lost:
        r6.f70b = r1;
        r6.j = 0;
        r0 = new b.a.c.c(r6.f71c, r1);
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007d, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
        r0.a(r7, r8, r9, r10);
        e().b(r0.f60a);
        r7 = r6.f71c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008c, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        b.a.a.f11a.b(r6.f71c, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0098, code lost:
        if (r0.e() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009a, code lost:
        r4 = b.a.a.f11a.a(r6.f71c, r6.f69a, r6);
        r0 = r6.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a6, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a7, code lost:
        b.a.c.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00aa, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b.a.c.c a(int r7, int r8, int r9, boolean r10) throws java.io.IOException {
        /*
            r6 = this;
            b.k r0 = r6.f71c
            monitor-enter(r0)
            boolean r1 = r6.k     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x000f
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "released"
            r7.<init>(r8)     // Catch:{ all -> 0x00b1 }
            throw r7     // Catch:{ all -> 0x00b1 }
        L_0x000f:
            b.a.d.c r1 = r6.g     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x001b
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "codec != null"
            r7.<init>(r8)     // Catch:{ all -> 0x00b1 }
            throw r7     // Catch:{ all -> 0x00b1 }
        L_0x001b:
            boolean r1 = r6.f     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0027
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "Canceled"
            r7.<init>(r8)     // Catch:{ all -> 0x00b1 }
            throw r7     // Catch:{ all -> 0x00b1 }
        L_0x0027:
            b.a.c.c r1 = r6.e     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0031
            boolean r2 = r1.h     // Catch:{ all -> 0x00b1 }
            if (r2 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return r1
        L_0x0031:
            b.a.a r1 = b.a.a.f11a     // Catch:{ all -> 0x00b1 }
            b.k r2 = r6.f71c     // Catch:{ all -> 0x00b1 }
            b.a r3 = r6.f69a     // Catch:{ all -> 0x00b1 }
            r4 = 0
            r1.a(r2, r3, r6, r4)     // Catch:{ all -> 0x00b1 }
            b.a.c.c r1 = r6.e     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0043
            b.a.c.c r7 = r6.e     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return r7
        L_0x0043:
            b.ag r1 = r6.f70b     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x004e
            b.a.c.f r0 = r6.d
            b.ag r1 = r0.a()
        L_0x004e:
            b.k r2 = r6.f71c
            monitor-enter(r2)
            boolean r0 = r6.f     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x005d
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = "Canceled"
            r7.<init>(r8)     // Catch:{ all -> 0x00ae }
            throw r7     // Catch:{ all -> 0x00ae }
        L_0x005d:
            b.a.a r0 = b.a.a.f11a     // Catch:{ all -> 0x00ae }
            b.k r3 = r6.f71c     // Catch:{ all -> 0x00ae }
            b.a r5 = r6.f69a     // Catch:{ all -> 0x00ae }
            r0.a(r3, r5, r6, r1)     // Catch:{ all -> 0x00ae }
            b.a.c.c r0 = r6.e     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x006e
            b.a.c.c r7 = r6.e     // Catch:{ all -> 0x00ae }
            monitor-exit(r2)     // Catch:{ all -> 0x00ae }
            return r7
        L_0x006e:
            r6.f70b = r1     // Catch:{ all -> 0x00ae }
            r0 = 0
            r6.j = r0     // Catch:{ all -> 0x00ae }
            b.a.c.c r0 = new b.a.c.c     // Catch:{ all -> 0x00ae }
            b.k r3 = r6.f71c     // Catch:{ all -> 0x00ae }
            r0.<init>(r3, r1)     // Catch:{ all -> 0x00ae }
            r6.a((b.a.c.c) r0)     // Catch:{ all -> 0x00ae }
            monitor-exit(r2)     // Catch:{ all -> 0x00ae }
            r0.a((int) r7, (int) r8, (int) r9, (boolean) r10)
            b.a.c.d r7 = r6.e()
            b.ag r8 = r0.f60a
            r7.b(r8)
            b.k r7 = r6.f71c
            monitor-enter(r7)
            b.a.a r8 = b.a.a.f11a     // Catch:{ all -> 0x00ab }
            b.k r9 = r6.f71c     // Catch:{ all -> 0x00ab }
            r8.b(r9, r0)     // Catch:{ all -> 0x00ab }
            boolean r8 = r0.e()     // Catch:{ all -> 0x00ab }
            if (r8 == 0) goto L_0x00a6
            b.a.a r8 = b.a.a.f11a     // Catch:{ all -> 0x00ab }
            b.k r9 = r6.f71c     // Catch:{ all -> 0x00ab }
            b.a r10 = r6.f69a     // Catch:{ all -> 0x00ab }
            java.net.Socket r4 = r8.a((b.k) r9, (b.a) r10, (b.a.c.g) r6)     // Catch:{ all -> 0x00ab }
            b.a.c.c r0 = r6.e     // Catch:{ all -> 0x00ab }
        L_0x00a6:
            monitor-exit(r7)     // Catch:{ all -> 0x00ab }
            b.a.c.a((java.net.Socket) r4)
            return r0
        L_0x00ab:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ab }
            throw r8
        L_0x00ae:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ae }
            throw r7
        L_0x00b1:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.g.a(int, int, int, boolean):b.a.c.c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.a(r8) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private b.a.c.c a(int r4, int r5, int r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            b.a.c.c r0 = r3.a(r4, r5, r6, r7)
            b.k r1 = r3.f71c
            monitor-enter(r1)
            int r2 = r0.i     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.a((boolean) r8)
            if (r1 != 0) goto L_0x0018
            r3.d()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.c.g.a(int, int, int, boolean, boolean):b.a.c.c");
    }

    private void b(c cVar) {
        int size = cVar.k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.k.get(i2).get() == this) {
                cVar.k.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket c(c cVar) {
        if (!h && !Thread.holdsLock(this.f71c)) {
            throw new AssertionError();
        } else if (this.g == null && this.e.k.size() == 1) {
            Socket a2 = a(true, false, false);
            this.e = cVar;
            cVar.k.add(this.e.k.get(0));
            return a2;
        } else {
            throw new IllegalStateException();
        }
    }

    private d e() {
        return b.a.a.f11a.a(this.f71c);
    }

    private void f() {
        c cVar;
        c cVar2;
        synchronized (this.f71c) {
            this.f = true;
            cVar = this.g;
            cVar2 = this.e;
        }
        if (cVar != null) {
            cVar.c();
        } else if (cVar2 != null) {
            b.a.c.a(cVar2.f61b);
        }
    }

    private boolean g() {
        if (this.f70b != null) {
            return true;
        }
        f fVar = this.d;
        return fVar.c() || fVar.b() || fVar.d();
    }

    public final c a() {
        c cVar;
        synchronized (this.f71c) {
            cVar = this.g;
        }
        return cVar;
    }

    public final c a(z zVar, boolean z) {
        c cVar;
        try {
            c a2 = a(zVar.z, zVar.A, zVar.B, zVar.y, z);
            if (a2.e != null) {
                cVar = new f(zVar, this, a2.e);
            } else {
                a2.f62c.setSoTimeout(zVar.A);
                a2.f.timeout().a((long) zVar.A, TimeUnit.MILLISECONDS);
                a2.g.timeout().a((long) zVar.B, TimeUnit.MILLISECONDS);
                cVar = new b.a.e.a(zVar, this, a2.f, a2.g);
            }
            synchronized (this.f71c) {
                this.g = cVar;
            }
            return cVar;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public final Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (h || Thread.holdsLock(this.f71c)) {
            if (z3) {
                this.g = null;
            }
            if (z2) {
                this.k = true;
            }
            if (this.e != null) {
                if (z) {
                    this.e.h = true;
                }
                if (this.g == null && (this.k || this.e.h)) {
                    b(this.e);
                    if (this.e.k.isEmpty()) {
                        this.e.l = System.nanoTime();
                        if (b.a.a.f11a.a(this.f71c, this.e)) {
                            socket = this.e.f62c;
                            this.e = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.e = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public final void a(c cVar) {
        if (!h && !Thread.holdsLock(this.f71c)) {
            throw new AssertionError();
        } else if (this.e != null) {
            throw new IllegalStateException();
        } else {
            this.e = cVar;
            cVar.k.add(new a(this, this.i));
        }
    }

    public final void a(IOException iOException) {
        boolean z;
        Socket a2;
        synchronized (this.f71c) {
            if (iOException instanceof o) {
                o oVar = (o) iOException;
                if (oVar.errorCode == b.REFUSED_STREAM) {
                    this.j++;
                }
                if (oVar.errorCode == b.REFUSED_STREAM) {
                    if (this.j > 1) {
                    }
                    z = false;
                    a2 = a(z, false, true);
                }
            } else {
                if (this.e != null && (!this.e.e() || (iOException instanceof b.a.f.a))) {
                    if (this.e.i == 0) {
                        if (!(this.f70b == null || iOException == null)) {
                            f fVar = this.d;
                            ag agVar = this.f70b;
                            if (!(agVar.f273b.type() == Proxy.Type.DIRECT || fVar.f66a.g == null)) {
                                fVar.f66a.g.connectFailed(fVar.f66a.f8a.a(), agVar.f273b.address(), iOException);
                            }
                            fVar.f67b.a(agVar);
                        }
                    }
                    z = true;
                    a2 = a(z, false, true);
                }
                z = false;
                a2 = a(z, false, true);
            }
            this.f70b = null;
            z = true;
            a2 = a(z, false, true);
        }
        b.a.c.a(a2);
    }

    public final void a(boolean z, c cVar) {
        Socket a2;
        synchronized (this.f71c) {
            if (cVar != null) {
                if (cVar == this.g) {
                    if (!z) {
                        this.e.i++;
                    }
                    a2 = a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.g + " but was " + cVar);
        }
        b.a.c.a(a2);
    }

    public final synchronized c b() {
        return this.e;
    }

    public final void c() {
        Socket a2;
        synchronized (this.f71c) {
            a2 = a(false, true, false);
        }
        b.a.c.a(a2);
    }

    public final void d() {
        Socket a2;
        synchronized (this.f71c) {
            a2 = a(true, false, false);
        }
        b.a.c.a(a2);
    }

    public final String toString() {
        c b2 = b();
        return b2 != null ? b2.toString() : this.f69a.toString();
    }
}
