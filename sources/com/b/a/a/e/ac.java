package com.b.a.a.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.b.b.f;
import com.b.b.w;
import com.b.b.y;

final class ac implements w {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f640c = true;

    /* renamed from: a  reason: collision with root package name */
    boolean f641a;

    /* renamed from: b  reason: collision with root package name */
    boolean f642b;
    final /* synthetic */ ab d;
    private final f e = new f();

    static {
        Class<ab> cls = ab.class;
    }

    ac(ab abVar) {
        this.d = abVar;
    }

    /* JADX INFO: finally extract failed */
    private void a(boolean z) {
        long min;
        synchronized (this.d) {
            this.d.g.c();
            while (this.d.f638b <= 0 && !this.f642b && !this.f641a && this.d.h == null) {
                try {
                    this.d.i();
                } catch (Throwable th) {
                    this.d.g.b();
                    throw th;
                }
            }
            this.d.g.b();
            this.d.h();
            min = Math.min(this.d.f638b, this.e.b());
            this.d.f638b -= min;
        }
        this.d.g.c();
        try {
            this.d.d.a(this.d.f639c, z && min == this.e.b(), this.e, min);
        } finally {
            this.d.g.b();
        }
    }

    public final y a() {
        return this.d.g;
    }

    public final void a_(f fVar, long j) {
        if (f640c || !Thread.holdsLock(this.d)) {
            this.e.a_(fVar, j);
            while (this.e.b() >= PlaybackStateCompat.ACTION_PREPARE) {
                a(false);
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        if (r8.d.e.f642b != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r8.e.b() <= 0) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        if (r8.e.b() <= 0) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
        a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        r8.d.d.a(r8.d.f639c, true, (com.b.b.f) null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2 = r8.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r8.f641a = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0053, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r8.d.d.p.b();
        r8.d.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r8 = this;
            boolean r0 = f640c
            if (r0 != 0) goto L_0x0012
            com.b.a.a.e.ab r0 = r8.d
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 == 0) goto L_0x0012
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0012:
            com.b.a.a.e.ab r0 = r8.d
            monitor-enter(r0)
            boolean r1 = r8.f641a     // Catch:{ all -> 0x0066 }
            if (r1 == 0) goto L_0x001b
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            return
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            com.b.a.a.e.ab r0 = r8.d
            com.b.a.a.e.ac r0 = r0.e
            boolean r0 = r0.f642b
            r1 = 1
            if (r0 != 0) goto L_0x004e
            com.b.b.f r0 = r8.e
            long r2 = r0.b()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003f
        L_0x0031:
            com.b.b.f r0 = r8.e
            long r2 = r0.b()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x004e
            r8.a(r1)
            goto L_0x0031
        L_0x003f:
            com.b.a.a.e.ab r0 = r8.d
            com.b.a.a.e.j r2 = r0.d
            com.b.a.a.e.ab r0 = r8.d
            int r3 = r0.f639c
            r4 = 1
            r5 = 0
            r6 = 0
            r2.a((int) r3, (boolean) r4, (com.b.b.f) r5, (long) r6)
        L_0x004e:
            com.b.a.a.e.ab r2 = r8.d
            monitor-enter(r2)
            r8.f641a = r1     // Catch:{ all -> 0x0063 }
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            com.b.a.a.e.ab r0 = r8.d
            com.b.a.a.e.j r0 = r0.d
            com.b.a.a.e.af r0 = r0.p
            r0.b()
            com.b.a.a.e.ab r0 = r8.d
            r0.g()
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            throw r0
        L_0x0066:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0066 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.ac.close():void");
    }

    public final void flush() {
        if (f640c || !Thread.holdsLock(this.d)) {
            synchronized (this.d) {
                this.d.h();
            }
            while (this.e.b() > 0) {
                a(false);
                this.d.d.p.b();
            }
            return;
        }
        throw new AssertionError();
    }
}
