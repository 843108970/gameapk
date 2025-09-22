package com.b.a.a.e;

import com.b.b.h;
import com.b.b.w;
import com.b.b.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

public final class ab {
    static final /* synthetic */ boolean i = true;

    /* renamed from: a  reason: collision with root package name */
    long f637a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f638b;

    /* renamed from: c  reason: collision with root package name */
    final int f639c;
    final j d;
    final ac e;
    final ae f = new ae(this);
    final ae g = new ae(this);
    b h = null;
    private final List<c> j;
    private List<c> k;
    private boolean l;
    private final ad m;

    ab(int i2, j jVar, boolean z, boolean z2, List<c> list) {
        if (jVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f639c = i2;
            this.d = jVar;
            this.f638b = (long) jVar.m.d();
            this.m = new ad(this, (long) jVar.l.d());
            this.e = new ac(this);
            this.m.f645b = z2;
            this.e.f642b = z;
            this.j = list;
        }
    }

    private boolean d(b bVar) {
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.h != null) {
                    return false;
                }
                if (this.m.f645b && this.e.f642b) {
                    return false;
                }
                this.h = bVar;
                notifyAll();
                this.d.b(this.f639c);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.f638b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public final void a(b bVar) {
        if (d(bVar)) {
            this.d.b(this.f639c, bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, int i2) {
        if (i || !Thread.holdsLock(this)) {
            this.m.a(hVar, (long) i2);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void a(List<c> list) {
        boolean z;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = true;
                this.l = true;
                if (this.k == null) {
                    this.k = list;
                    z = a();
                    notifyAll();
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.k);
                    arrayList.add((Object) null);
                    arrayList.addAll(list);
                    this.k = arrayList;
                }
            }
            if (!z) {
                this.d.b(this.f639c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public final synchronized boolean a() {
        if (this.h != null) {
            return false;
        }
        return (!this.m.f645b && !this.m.f644a) || (!this.e.f642b && !this.e.f641a) || !this.l;
    }

    public final void b(b bVar) {
        if (d(bVar)) {
            this.d.a(this.f639c, bVar);
        }
    }

    public final boolean b() {
        return this.d.f685b == ((this.f639c & 1) == 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        r2.f.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.util.List<com.b.a.a.e.c> c() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.b()     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x000f
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "servers cannot read response headers"
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x000f:
            com.b.a.a.e.ae r0 = r2.f     // Catch:{ all -> 0x003d }
            r0.c()     // Catch:{ all -> 0x003d }
        L_0x0014:
            java.util.List<com.b.a.a.e.c> r0 = r2.k     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0020
            com.b.a.a.e.b r0 = r2.h     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0020
            r2.i()     // Catch:{ all -> 0x0036 }
            goto L_0x0014
        L_0x0020:
            com.b.a.a.e.ae r0 = r2.f     // Catch:{ all -> 0x003d }
            r0.b()     // Catch:{ all -> 0x003d }
            java.util.List<com.b.a.a.e.c> r0 = r2.k     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x002e
            r1 = 0
            r2.k = r1     // Catch:{ all -> 0x003d }
            monitor-exit(r2)
            return r0
        L_0x002e:
            com.b.a.a.e.am r0 = new com.b.a.a.e.am     // Catch:{ all -> 0x003d }
            com.b.a.a.e.b r1 = r2.h     // Catch:{ all -> 0x003d }
            r0.<init>(r1)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x0036:
            r0 = move-exception
            com.b.a.a.e.ae r1 = r2.f     // Catch:{ all -> 0x003d }
            r1.b()     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.ab.c():java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c(b bVar) {
        if (this.h == null) {
            this.h = bVar;
            notifyAll();
        }
    }

    public final x d() {
        return this.m;
    }

    public final w e() {
        synchronized (this) {
            if (!this.l && !b()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        boolean a2;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                this.m.f645b = true;
                a2 = a();
                notifyAll();
            }
            if (!a2) {
                this.d.b(this.f639c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        boolean z;
        boolean a2;
        if (i || !Thread.holdsLock(this)) {
            synchronized (this) {
                z = !this.m.f645b && this.m.f644a && (this.e.f642b || this.e.f641a);
                a2 = a();
            }
            if (z) {
                a(b.CANCEL);
            } else if (!a2) {
                this.d.b(this.f639c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        if (this.e.f641a) {
            throw new IOException("stream closed");
        } else if (this.e.f642b) {
            throw new IOException("stream finished");
        } else if (this.h != null) {
            throw new am(this.h);
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }
}
