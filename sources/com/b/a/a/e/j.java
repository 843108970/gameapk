package com.b.a.a.e;

import android.support.v7.widget.ActivityChooserView;
import com.b.a.a.c;
import com.b.b.f;
import com.b.b.h;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class j implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final ExecutorService f684a = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean s = true;

    /* renamed from: b  reason: collision with root package name */
    final boolean f685b;

    /* renamed from: c  reason: collision with root package name */
    final s f686c;
    final Map<Integer, ab> d = new LinkedHashMap();
    final String e;
    int f;
    int g;
    boolean h;
    final aj i;
    long j = 0;
    long k;
    al l = new al();
    final al m = new al();
    boolean n = false;
    final Socket o;
    final af p;
    final u q;
    final Set<Integer> r = new LinkedHashSet();
    private final ExecutorService t;
    private Map<Integer, ai> u;
    private int v;

    j(r rVar) {
        this.i = rVar.f;
        this.f685b = rVar.g;
        this.f686c = rVar.e;
        int i2 = 2;
        this.g = rVar.g ? 1 : 2;
        if (rVar.g) {
            this.g += 2;
        }
        this.v = rVar.g ? 1 : i2;
        if (rVar.g) {
            this.l.a(7, 16777216);
        }
        this.e = rVar.f702b;
        this.t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.a(c.a("OkHttp %s Push Observer", this.e), true));
        this.m.a(7, 65535);
        this.m.a(5, 16384);
        this.k = (long) this.m.d();
        this.o = rVar.f701a;
        this.p = new af(rVar.d, this.f685b);
        this.q = new u(this, new y(rVar.f703c, this.f685b));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.b.a.a.e.ab b(java.util.List<com.b.a.a.e.c> r11, boolean r12) {
        /*
            r10 = this;
            r6 = r12 ^ 1
            com.b.a.a.e.af r7 = r10.p
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0058 }
            boolean r0 = r10.h     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0010
            com.b.a.a.e.a r11 = new com.b.a.a.e.a     // Catch:{ all -> 0x0055 }
            r11.<init>()     // Catch:{ all -> 0x0055 }
            throw r11     // Catch:{ all -> 0x0055 }
        L_0x0010:
            int r8 = r10.g     // Catch:{ all -> 0x0055 }
            int r0 = r10.g     // Catch:{ all -> 0x0055 }
            int r0 = r0 + 2
            r10.g = r0     // Catch:{ all -> 0x0055 }
            com.b.a.a.e.ab r9 = new com.b.a.a.e.ab     // Catch:{ all -> 0x0055 }
            r4 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0055 }
            if (r12 == 0) goto L_0x0036
            long r0 = r10.k     // Catch:{ all -> 0x0055 }
            r2 = 0
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0036
            long r0 = r9.f638b     // Catch:{ all -> 0x0055 }
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r12 = 0
            goto L_0x0037
        L_0x0036:
            r12 = 1
        L_0x0037:
            boolean r0 = r9.a()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0046
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r0 = r10.d     // Catch:{ all -> 0x0055 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0055 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0055 }
        L_0x0046:
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            com.b.a.a.e.af r0 = r10.p     // Catch:{ all -> 0x0058 }
            r0.a((boolean) r6, (int) r8, (java.util.List<com.b.a.a.e.c>) r11)     // Catch:{ all -> 0x0058 }
            monitor-exit(r7)     // Catch:{ all -> 0x0058 }
            if (r12 == 0) goto L_0x0054
            com.b.a.a.e.af r11 = r10.p
            r11.b()
        L_0x0054:
            return r9
        L_0x0055:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0055 }
            throw r11     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0058 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.j.b(java.util.List, boolean):com.b.a.a.e.ab");
    }

    static boolean d(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public final synchronized int a() {
        return this.m.c();
    }

    /* access modifiers changed from: package-private */
    public final synchronized ab a(int i2) {
        return this.d.get(Integer.valueOf(i2));
    }

    public final ab a(List<c> list, boolean z) {
        return b(list, z);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, long j2) {
        f684a.execute(new l(this, "OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}, i2, j2));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, b bVar) {
        f684a.execute(new k(this, "OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i2)}, i2, bVar));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, h hVar, int i3, boolean z) {
        f fVar = new f();
        long j2 = (long) i3;
        hVar.a(j2);
        hVar.a(fVar, j2);
        if (fVar.b() != j2) {
            throw new IOException(fVar.b() + " != " + i3);
        }
        this.t.execute(new p(this, "OkHttp %s Push Data[%s]", new Object[]{this.e, Integer.valueOf(i2)}, i2, fVar, i3, z));
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, List<c> list) {
        synchronized (this) {
            if (this.r.contains(Integer.valueOf(i2))) {
                a(i2, b.PROTOCOL_ERROR);
                return;
            }
            this.r.add(Integer.valueOf(i2));
            this.t.execute(new n(this, "OkHttp %s Push Request[%s]", new Object[]{this.e, Integer.valueOf(i2)}, i2, list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, List<c> list, boolean z) {
        this.t.execute(new o(this, "OkHttp %s Push Headers[%s]", new Object[]{this.e, Integer.valueOf(i2)}, i2, list, z));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r14, r10.k), r10.p.c());
        r6 = (long) r2;
        r10.k -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, boolean r12, com.b.b.f r13, long r14) {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            com.b.a.a.e.af r14 = r10.p
            r14.a((boolean) r12, (int) r11, (com.b.b.f) r13, (int) r3)
            return
        L_0x000d:
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0066
            monitor-enter(r10)
        L_0x0012:
            long r4 = r10.k     // Catch:{ InterruptedException -> 0x005e }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r2 = r10.d     // Catch:{ InterruptedException -> 0x005e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)     // Catch:{ InterruptedException -> 0x005e }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x005e }
            if (r2 != 0) goto L_0x002c
            java.io.IOException r11 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005e }
            java.lang.String r12 = "stream closed"
            r11.<init>(r12)     // Catch:{ InterruptedException -> 0x005e }
            throw r11     // Catch:{ InterruptedException -> 0x005e }
        L_0x002c:
            r10.wait()     // Catch:{ InterruptedException -> 0x005e }
            goto L_0x0012
        L_0x0030:
            long r4 = r10.k     // Catch:{ all -> 0x005c }
            long r4 = java.lang.Math.min(r14, r4)     // Catch:{ all -> 0x005c }
            int r2 = (int) r4     // Catch:{ all -> 0x005c }
            com.b.a.a.e.af r4 = r10.p     // Catch:{ all -> 0x005c }
            int r4 = r4.c()     // Catch:{ all -> 0x005c }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x005c }
            long r4 = r10.k     // Catch:{ all -> 0x005c }
            long r6 = (long) r2     // Catch:{ all -> 0x005c }
            long r8 = r4 - r6
            r10.k = r8     // Catch:{ all -> 0x005c }
            monitor-exit(r10)     // Catch:{ all -> 0x005c }
            r4 = 0
            long r4 = r14 - r6
            com.b.a.a.e.af r14 = r10.p
            if (r12 == 0) goto L_0x0056
            int r15 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r15 != 0) goto L_0x0056
            r15 = 1
            goto L_0x0057
        L_0x0056:
            r15 = 0
        L_0x0057:
            r14.a((boolean) r15, (int) r11, (com.b.b.f) r13, (int) r2)
            r14 = r4
            goto L_0x000d
        L_0x005c:
            r11 = move-exception
            goto L_0x0064
        L_0x005e:
            java.io.InterruptedIOException r11 = new java.io.InterruptedIOException     // Catch:{ all -> 0x005c }
            r11.<init>()     // Catch:{ all -> 0x005c }
            throw r11     // Catch:{ all -> 0x005c }
        L_0x0064:
            monitor-exit(r10)     // Catch:{ all -> 0x005c }
            throw r11
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.j.a(int, boolean, com.b.b.f, long):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    final void a(com.b.a.a.e.b r7, com.b.a.a.e.b r8) {
        /*
            r6 = this;
            boolean r0 = s
            if (r0 != 0) goto L_0x0010
            boolean r0 = java.lang.Thread.holdsLock(r6)
            if (r0 == 0) goto L_0x0010
            java.lang.AssertionError r7 = new java.lang.AssertionError
            r7.<init>()
            throw r7
        L_0x0010:
            r0 = 0
            com.b.a.a.e.af r1 = r6.p     // Catch:{ IOException -> 0x0032 }
            monitor-enter(r1)     // Catch:{ IOException -> 0x0032 }
            monitor-enter(r6)     // Catch:{ all -> 0x002f }
            boolean r2 = r6.h     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x001c
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
        L_0x001a:
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            goto L_0x002a
        L_0x001c:
            r2 = 1
            r6.h = r2     // Catch:{ all -> 0x002c }
            int r2 = r6.f     // Catch:{ all -> 0x002c }
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
            com.b.a.a.e.af r3 = r6.p     // Catch:{ all -> 0x002f }
            byte[] r4 = com.b.a.a.c.f603a     // Catch:{ all -> 0x002f }
            r3.a((int) r2, (com.b.a.a.e.b) r7, (byte[]) r4)     // Catch:{ all -> 0x002f }
            goto L_0x001a
        L_0x002a:
            r7 = r0
            goto L_0x0033
        L_0x002c:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x002c }
            throw r7     // Catch:{ all -> 0x002f }
        L_0x002f:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002f }
            throw r7     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            r7 = move-exception
        L_0x0033:
            monitor-enter(r6)
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r1 = r6.d     // Catch:{ all -> 0x00ab }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00ab }
            if (r1 != 0) goto L_0x0056
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r1 = r6.d     // Catch:{ all -> 0x00ab }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x00ab }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r2 = r6.d     // Catch:{ all -> 0x00ab }
            int r2 = r2.size()     // Catch:{ all -> 0x00ab }
            com.b.a.a.e.ab[] r2 = new com.b.a.a.e.ab[r2]     // Catch:{ all -> 0x00ab }
            java.lang.Object[] r1 = r1.toArray(r2)     // Catch:{ all -> 0x00ab }
            com.b.a.a.e.ab[] r1 = (com.b.a.a.e.ab[]) r1     // Catch:{ all -> 0x00ab }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r2 = r6.d     // Catch:{ all -> 0x00ab }
            r2.clear()     // Catch:{ all -> 0x00ab }
            goto L_0x0057
        L_0x0056:
            r1 = r0
        L_0x0057:
            java.util.Map<java.lang.Integer, com.b.a.a.e.ai> r2 = r6.u     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x0072
            java.util.Map<java.lang.Integer, com.b.a.a.e.ai> r2 = r6.u     // Catch:{ all -> 0x00ab }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00ab }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ai> r3 = r6.u     // Catch:{ all -> 0x00ab }
            int r3 = r3.size()     // Catch:{ all -> 0x00ab }
            com.b.a.a.e.ai[] r3 = new com.b.a.a.e.ai[r3]     // Catch:{ all -> 0x00ab }
            java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x00ab }
            com.b.a.a.e.ai[] r2 = (com.b.a.a.e.ai[]) r2     // Catch:{ all -> 0x00ab }
            r6.u = r0     // Catch:{ all -> 0x00ab }
            r0 = r2
        L_0x0072:
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            r2 = 0
            if (r1 == 0) goto L_0x0089
            int r3 = r1.length
            r4 = r7
            r7 = 0
        L_0x0079:
            if (r7 >= r3) goto L_0x0088
            r5 = r1[r7]
            r5.a((com.b.a.a.e.b) r8)     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r5 = move-exception
            if (r4 == 0) goto L_0x0085
            r4 = r5
        L_0x0085:
            int r7 = r7 + 1
            goto L_0x0079
        L_0x0088:
            r7 = r4
        L_0x0089:
            if (r0 == 0) goto L_0x0096
            int r8 = r0.length
        L_0x008c:
            if (r2 >= r8) goto L_0x0096
            r1 = r0[r2]
            r1.c()
            int r2 = r2 + 1
            goto L_0x008c
        L_0x0096:
            com.b.a.a.e.af r8 = r6.p     // Catch:{ IOException -> 0x009c }
            r8.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r8 = move-exception
            if (r7 != 0) goto L_0x00a0
            r7 = r8
        L_0x00a0:
            java.net.Socket r8 = r6.o     // Catch:{ IOException -> 0x00a6 }
            r8.close()     // Catch:{ IOException -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
            r7 = move-exception
        L_0x00a7:
            if (r7 == 0) goto L_0x00aa
            throw r7
        L_0x00aa:
            return
        L_0x00ab:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ab }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.j.a(com.b.a.a.e.b, com.b.a.a.e.b):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized ab b(int i2) {
        ab remove;
        remove = this.d.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public final void b() {
        this.p.a();
        this.p.b(this.l);
        int d2 = this.l.d();
        if (d2 != 65535) {
            this.p.a(0, (long) (d2 - 65535));
        }
        new Thread(this.q).start();
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, b bVar) {
        this.p.a(i2, bVar);
    }

    /* access modifiers changed from: package-private */
    public final synchronized ai c(int i2) {
        if (this.u == null) {
            return null;
        }
        return this.u.remove(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2, b bVar) {
        this.t.execute(new q(this, "OkHttp %s Push Reset[%s]", new Object[]{this.e, Integer.valueOf(i2)}, i2, bVar));
    }

    public final synchronized boolean c() {
        return this.h;
    }

    public final void close() {
        a(b.NO_ERROR, b.CANCEL);
    }
}
