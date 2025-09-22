package com.b.a.a.b;

import com.b.a.a;
import com.b.a.a.c.c;
import com.b.a.a.e.am;
import com.b.a.a.e.b;
import com.b.a.ai;
import com.b.a.aw;
import com.b.a.n;
import java.io.IOException;
import java.net.Socket;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f599b = true;

    /* renamed from: a  reason: collision with root package name */
    public final a f600a;

    /* renamed from: c  reason: collision with root package name */
    private aw f601c;
    private final n d;
    private final Object e;
    private final f f;
    private int g;
    private c h;
    private boolean i;
    private boolean j;
    private c k;

    public g(n nVar, a aVar, Object obj) {
        this.d = nVar;
        this.f600a = aVar;
        this.f = new f(aVar, f());
        this.e = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        if (r1 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r1 = r4.f.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        r2 = r4.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r4.f601c = r1;
        r4.g = 0;
        r0 = new com.b.a.a.b.c(r4.d, r1);
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
        if (r4.j == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        throw new java.io.IOException("Canceled");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006b, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006c, code lost:
        r0.a(r5, r6, r7, r8);
        f().b(r0.a());
        r5 = null;
        r6 = r4.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007d, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.b.a.a.a.f566a.b(r4.d, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0089, code lost:
        if (r0.d() == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x008b, code lost:
        r5 = com.b.a.a.a.f566a.b(r4.d, r4.f600a, r4);
        r0 = r4.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0098, code lost:
        com.b.a.a.c.a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009b, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.b.a.a.b.c a(int r5, int r6, int r7, boolean r8) {
        /*
            r4 = this;
            com.b.a.n r0 = r4.d
            monitor-enter(r0)
            boolean r1 = r4.i     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x000f
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "released"
            r5.<init>(r6)     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x000f:
            com.b.a.a.c.c r1 = r4.k     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x001b
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "codec != null"
            r5.<init>(r6)     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x001b:
            boolean r1 = r4.j     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x0027
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x00a2 }
            java.lang.String r6 = "Canceled"
            r5.<init>(r6)     // Catch:{ all -> 0x00a2 }
            throw r5     // Catch:{ all -> 0x00a2 }
        L_0x0027:
            com.b.a.a.b.c r1 = r4.h     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x0031
            boolean r2 = r1.f590a     // Catch:{ all -> 0x00a2 }
            if (r2 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            return r1
        L_0x0031:
            com.b.a.a.a r1 = com.b.a.a.a.f566a     // Catch:{ all -> 0x00a2 }
            com.b.a.n r2 = r4.d     // Catch:{ all -> 0x00a2 }
            com.b.a.a r3 = r4.f600a     // Catch:{ all -> 0x00a2 }
            r1.a((com.b.a.n) r2, (com.b.a.a) r3, (com.b.a.a.b.g) r4)     // Catch:{ all -> 0x00a2 }
            com.b.a.a.b.c r1 = r4.h     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x0042
            com.b.a.a.b.c r5 = r4.h     // Catch:{ all -> 0x00a2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            return r5
        L_0x0042:
            com.b.a.aw r1 = r4.f601c     // Catch:{ all -> 0x00a2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            if (r1 != 0) goto L_0x004d
            com.b.a.a.b.f r0 = r4.f
            com.b.a.aw r1 = r0.b()
        L_0x004d:
            com.b.a.n r2 = r4.d
            monitor-enter(r2)
            r4.f601c = r1     // Catch:{ all -> 0x009f }
            r0 = 0
            r4.g = r0     // Catch:{ all -> 0x009f }
            com.b.a.a.b.c r0 = new com.b.a.a.b.c     // Catch:{ all -> 0x009f }
            com.b.a.n r3 = r4.d     // Catch:{ all -> 0x009f }
            r0.<init>(r3, r1)     // Catch:{ all -> 0x009f }
            r4.a((com.b.a.a.b.c) r0)     // Catch:{ all -> 0x009f }
            boolean r1 = r4.j     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x006b
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x009f }
            java.lang.String r6 = "Canceled"
            r5.<init>(r6)     // Catch:{ all -> 0x009f }
            throw r5     // Catch:{ all -> 0x009f }
        L_0x006b:
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            r0.a(r5, r6, r7, r8)
            com.b.a.a.b.d r5 = r4.f()
            com.b.a.aw r6 = r0.a()
            r5.b(r6)
            r5 = 0
            com.b.a.n r6 = r4.d
            monitor-enter(r6)
            com.b.a.a.a r7 = com.b.a.a.a.f566a     // Catch:{ all -> 0x009c }
            com.b.a.n r8 = r4.d     // Catch:{ all -> 0x009c }
            r7.b(r8, r0)     // Catch:{ all -> 0x009c }
            boolean r7 = r0.d()     // Catch:{ all -> 0x009c }
            if (r7 == 0) goto L_0x0097
            com.b.a.a.a r5 = com.b.a.a.a.f566a     // Catch:{ all -> 0x009c }
            com.b.a.n r7 = r4.d     // Catch:{ all -> 0x009c }
            com.b.a.a r8 = r4.f600a     // Catch:{ all -> 0x009c }
            java.net.Socket r5 = r5.b(r7, r8, r4)     // Catch:{ all -> 0x009c }
            com.b.a.a.b.c r0 = r4.h     // Catch:{ all -> 0x009c }
        L_0x0097:
            monitor-exit(r6)     // Catch:{ all -> 0x009c }
            com.b.a.a.c.a((java.net.Socket) r5)
            return r0
        L_0x009c:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x009c }
            throw r5
        L_0x009f:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x009f }
            throw r5
        L_0x00a2:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a2 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.b.g.a(int, int, int, boolean):com.b.a.a.b.c");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.a(r8) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.b.a.a.b.c a(int r4, int r5, int r6, boolean r7, boolean r8) {
        /*
            r3 = this;
        L_0x0000:
            com.b.a.a.b.c r0 = r3.a(r4, r5, r6, r7)
            com.b.a.n r1 = r3.d
            monitor-enter(r1)
            int r2 = r0.f591b     // Catch:{ all -> 0x0019 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.b.g.a(int, int, int, boolean, boolean):com.b.a.a.b.c");
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f599b || Thread.holdsLock(this.d)) {
            if (z3) {
                this.k = null;
            }
            if (z2) {
                this.i = true;
            }
            if (this.h != null) {
                if (z) {
                    this.h.f590a = true;
                }
                if (this.k == null && (this.i || this.h.f590a)) {
                    c(this.h);
                    if (this.h.d.isEmpty()) {
                        this.h.e = System.nanoTime();
                        if (com.b.a.a.a.f566a.a(this.d, this.h)) {
                            socket = this.h.b();
                            this.h = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.h = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    private void c(c cVar) {
        int size = cVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.d.get(i2).get() == this) {
                cVar.d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private d f() {
        return com.b.a.a.a.f566a.a(this.d);
    }

    public final c a() {
        c cVar;
        synchronized (this.d) {
            cVar = this.k;
        }
        return cVar;
    }

    public final c a(ai aiVar, boolean z) {
        try {
            c a2 = a(aiVar.a(), aiVar.b(), aiVar.c(), aiVar.q(), z).a(aiVar, this);
            synchronized (this.d) {
                this.k = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public final void a(c cVar) {
        if (!f599b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        } else if (this.h != null) {
            throw new IllegalStateException();
        } else {
            this.h = cVar;
            cVar.d.add(new h(this, this.e));
        }
    }

    public final void a(IOException iOException) {
        boolean z;
        Socket a2;
        synchronized (this.d) {
            if (iOException instanceof am) {
                am amVar = (am) iOException;
                if (amVar.f662a == b.REFUSED_STREAM) {
                    this.g++;
                }
                if (amVar.f662a == b.REFUSED_STREAM) {
                    if (this.g > 1) {
                    }
                    z = false;
                    a2 = a(z, false, true);
                }
            } else {
                if (this.h != null && (!this.h.d() || (iOException instanceof com.b.a.a.e.a))) {
                    if (this.h.f591b == 0) {
                        if (!(this.f601c == null || iOException == null)) {
                            this.f.a(this.f601c, iOException);
                        }
                    }
                    z = true;
                    a2 = a(z, false, true);
                }
                z = false;
                a2 = a(z, false, true);
            }
            this.f601c = null;
            z = true;
            a2 = a(z, false, true);
        }
        com.b.a.a.c.a(a2);
    }

    public final void a(boolean z, c cVar) {
        Socket a2;
        synchronized (this.d) {
            if (cVar != null) {
                if (cVar == this.k) {
                    if (!z) {
                        this.h.f591b++;
                    }
                    a2 = a(z, false, true);
                }
            }
            throw new IllegalStateException("expected " + this.k + " but was " + cVar);
        }
        com.b.a.a.c.a(a2);
    }

    public final synchronized c b() {
        return this.h;
    }

    public final Socket b(c cVar) {
        if (!f599b && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        } else if (this.k == null && this.h.d.size() == 1) {
            Socket a2 = a(true, false, false);
            this.h = cVar;
            cVar.d.add(this.h.d.get(0));
            return a2;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void c() {
        Socket a2;
        synchronized (this.d) {
            a2 = a(false, true, false);
        }
        com.b.a.a.c.a(a2);
    }

    public final void d() {
        Socket a2;
        synchronized (this.d) {
            a2 = a(true, false, false);
        }
        com.b.a.a.c.a(a2);
    }

    public final boolean e() {
        return this.f601c != null || this.f.a();
    }

    public final String toString() {
        c b2 = b();
        return b2 != null ? b2.toString() : this.f600a.toString();
    }
}
