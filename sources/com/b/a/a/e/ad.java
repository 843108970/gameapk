package com.b.a.a.e;

import com.b.b.f;
import com.b.b.h;
import com.b.b.x;
import com.b.b.y;
import java.io.EOFException;

final class ad implements x {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f643c = true;

    /* renamed from: a  reason: collision with root package name */
    boolean f644a;

    /* renamed from: b  reason: collision with root package name */
    boolean f645b;
    final /* synthetic */ ab d;
    private final f e = new f();
    private final f f = new f();
    private final long g;

    static {
        Class<ab> cls = ab.class;
    }

    ad(ab abVar, long j) {
        this.d = abVar;
        this.g = j;
    }

    private void b() {
        this.d.f.c();
        while (this.f.b() == 0 && !this.f645b && !this.f644a && this.d.h == null) {
            try {
                this.d.i();
            } finally {
                this.d.f.b();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        r10 = r7.d.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        monitor-enter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r7.d.d.j += r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
        if (r7.d.d.j < ((long) (r7.d.d.l.d() / 2))) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b3, code lost:
        r7.d.d.a(0, r7.d.d.j);
        r7.d.d.j = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        monitor-exit(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c8, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.b.b.f r8, long r9) {
        /*
            r7 = this;
            r0 = 0
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x001a
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "byteCount < 0: "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L_0x001a:
            com.b.a.a.e.ab r2 = r7.d
            monitor-enter(r2)
            r7.b()     // Catch:{ all -> 0x00cc }
            boolean r3 = r7.f644a     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x002c
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00cc }
            java.lang.String r9 = "stream closed"
            r8.<init>(r9)     // Catch:{ all -> 0x00cc }
            throw r8     // Catch:{ all -> 0x00cc }
        L_0x002c:
            com.b.a.a.e.ab r3 = r7.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.b r3 = r3.h     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x003c
            com.b.a.a.e.am r8 = new com.b.a.a.e.am     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r9 = r7.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.b r9 = r9.h     // Catch:{ all -> 0x00cc }
            r8.<init>(r9)     // Catch:{ all -> 0x00cc }
            throw r8     // Catch:{ all -> 0x00cc }
        L_0x003c:
            com.b.b.f r3 = r7.f     // Catch:{ all -> 0x00cc }
            long r3 = r3.b()     // Catch:{ all -> 0x00cc }
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x004a
            r8 = -1
            monitor-exit(r2)     // Catch:{ all -> 0x00cc }
            return r8
        L_0x004a:
            com.b.b.f r3 = r7.f     // Catch:{ all -> 0x00cc }
            com.b.b.f r4 = r7.f     // Catch:{ all -> 0x00cc }
            long r4 = r4.b()     // Catch:{ all -> 0x00cc }
            long r9 = java.lang.Math.min(r9, r4)     // Catch:{ all -> 0x00cc }
            long r8 = r3.a((com.b.b.f) r8, (long) r9)     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r10 = r7.d     // Catch:{ all -> 0x00cc }
            long r3 = r10.f637a     // Catch:{ all -> 0x00cc }
            r5 = 0
            long r5 = r3 + r8
            r10.f637a = r5     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r10 = r7.d     // Catch:{ all -> 0x00cc }
            long r3 = r10.f637a     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r10 = r7.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.j r10 = r10.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.al r10 = r10.l     // Catch:{ all -> 0x00cc }
            int r10 = r10.d()     // Catch:{ all -> 0x00cc }
            int r10 = r10 / 2
            long r5 = (long) r10     // Catch:{ all -> 0x00cc }
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 < 0) goto L_0x008b
            com.b.a.a.e.ab r10 = r7.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.j r10 = r10.d     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r3 = r7.d     // Catch:{ all -> 0x00cc }
            int r3 = r3.f639c     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r4 = r7.d     // Catch:{ all -> 0x00cc }
            long r4 = r4.f637a     // Catch:{ all -> 0x00cc }
            r10.a((int) r3, (long) r4)     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r10 = r7.d     // Catch:{ all -> 0x00cc }
            r10.f637a = r0     // Catch:{ all -> 0x00cc }
        L_0x008b:
            monitor-exit(r2)     // Catch:{ all -> 0x00cc }
            com.b.a.a.e.ab r10 = r7.d
            com.b.a.a.e.j r10 = r10.d
            monitor-enter(r10)
            com.b.a.a.e.ab r2 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r2 = r2.d     // Catch:{ all -> 0x00c9 }
            long r3 = r2.j     // Catch:{ all -> 0x00c9 }
            r5 = 0
            long r5 = r3 + r8
            r2.j = r5     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.ab r2 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r2 = r2.d     // Catch:{ all -> 0x00c9 }
            long r2 = r2.j     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.ab r4 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r4 = r4.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.al r4 = r4.l     // Catch:{ all -> 0x00c9 }
            int r4 = r4.d()     // Catch:{ all -> 0x00c9 }
            int r4 = r4 / 2
            long r4 = (long) r4     // Catch:{ all -> 0x00c9 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x00c7
            com.b.a.a.e.ab r2 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r2 = r2.d     // Catch:{ all -> 0x00c9 }
            r3 = 0
            com.b.a.a.e.ab r4 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r4 = r4.d     // Catch:{ all -> 0x00c9 }
            long r4 = r4.j     // Catch:{ all -> 0x00c9 }
            r2.a((int) r3, (long) r4)     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.ab r2 = r7.d     // Catch:{ all -> 0x00c9 }
            com.b.a.a.e.j r2 = r2.d     // Catch:{ all -> 0x00c9 }
            r2.j = r0     // Catch:{ all -> 0x00c9 }
        L_0x00c7:
            monitor-exit(r10)     // Catch:{ all -> 0x00c9 }
            return r8
        L_0x00c9:
            r8 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00c9 }
            throw r8
        L_0x00cc:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00cc }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.ad.a(com.b.b.f, long):long");
    }

    public final y a() {
        return this.d.f;
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, long j) {
        boolean z;
        boolean z2;
        boolean z3;
        if (f643c || !Thread.holdsLock(this.d)) {
            while (j > 0) {
                synchronized (this.d) {
                    z = this.f645b;
                    z2 = false;
                    z3 = j + this.f.b() > this.g;
                }
                if (z3) {
                    hVar.f(j);
                    this.d.b(b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    hVar.f(j);
                    return;
                } else {
                    long a2 = hVar.a(this.e, j);
                    if (a2 == -1) {
                        throw new EOFException();
                    }
                    long j2 = j - a2;
                    synchronized (this.d) {
                        if (this.f.b() == 0) {
                            z2 = true;
                        }
                        this.f.a((x) this.e);
                        if (z2) {
                            this.d.notifyAll();
                        }
                    }
                    j = j2;
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public final void close() {
        synchronized (this.d) {
            this.f644a = true;
            this.f.o();
            this.d.notifyAll();
        }
        this.d.g();
    }
}
