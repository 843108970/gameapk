package com.b.a.a.e;

import com.b.a.a.b;
import com.b.b.h;
import com.b.b.i;
import java.util.List;

final class u extends b implements aa {

    /* renamed from: a  reason: collision with root package name */
    final y f704a;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ j f705c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(j jVar, y yVar) {
        super("OkHttp %s", jVar.e);
        this.f705c = jVar;
        this.f704a = yVar;
    }

    public final void a(int i, long j) {
        if (i == 0) {
            synchronized (this.f705c) {
                this.f705c.k += j;
                this.f705c.notifyAll();
            }
            return;
        }
        ab a2 = this.f705c.a(i);
        if (a2 != null) {
            synchronized (a2) {
                a2.a(j);
            }
        }
    }

    public final void a(int i, b bVar) {
        if (j.d(i)) {
            this.f705c.c(i, bVar);
            return;
        }
        ab b2 = this.f705c.b(i);
        if (b2 != null) {
            b2.c(bVar);
        }
    }

    public final void a(int i, i iVar) {
        ab[] abVarArr;
        iVar.g();
        synchronized (this.f705c) {
            abVarArr = (ab[]) this.f705c.d.values().toArray(new ab[this.f705c.d.size()]);
            this.f705c.h = true;
        }
        for (ab abVar : abVarArr) {
            if (abVar.f639c > i && abVar.b()) {
                abVar.c(b.REFUSED_STREAM);
                this.f705c.b(abVar.f639c);
            }
        }
    }

    public final void a(int i, List<c> list) {
        this.f705c.a(i, list);
    }

    /* JADX WARNING: type inference failed for: r13v18, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.b.a.a.e.al r13) {
        /*
            r12 = this;
            com.b.a.a.e.j r0 = r12.f705c
            monitor-enter(r0)
            com.b.a.a.e.j r1 = r12.f705c     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.al r1 = r1.m     // Catch:{ all -> 0x00b7 }
            int r1 = r1.d()     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r2 = r12.f705c     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.al r2 = r2.m     // Catch:{ all -> 0x00b7 }
            r3 = 0
            r4 = 0
        L_0x0011:
            r5 = 10
            if (r4 >= r5) goto L_0x0025
            boolean r5 = r13.a(r4)     // Catch:{ all -> 0x00b7 }
            if (r5 == 0) goto L_0x0022
            int r5 = r13.b(r4)     // Catch:{ all -> 0x00b7 }
            r2.a(r4, r5)     // Catch:{ all -> 0x00b7 }
        L_0x0022:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0025:
            java.util.concurrent.ExecutorService r2 = com.b.a.a.e.j.f684a     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.x r4 = new com.b.a.a.e.x     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = "OkHttp %s ACK Settings"
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r8 = r12.f705c     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = r8.e     // Catch:{ all -> 0x00b7 }
            r7[r3] = r8     // Catch:{ all -> 0x00b7 }
            r4.<init>(r12, r5, r7, r13)     // Catch:{ all -> 0x00b7 }
            r2.execute(r4)     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.al r13 = r13.m     // Catch:{ all -> 0x00b7 }
            int r13 = r13.d()     // Catch:{ all -> 0x00b7 }
            r2 = -1
            r4 = 0
            r7 = 0
            if (r13 == r2) goto L_0x008a
            if (r13 == r1) goto L_0x008a
            int r13 = r13 - r1
            long r1 = (long) r13     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            boolean r13 = r13.n     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x0066
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            long r8 = r13.k     // Catch:{ all -> 0x00b7 }
            r10 = 0
            long r10 = r8 + r1
            r13.k = r10     // Catch:{ all -> 0x00b7 }
            int r8 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0062
            r13.notifyAll()     // Catch:{ all -> 0x00b7 }
        L_0x0062:
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            r13.n = r6     // Catch:{ all -> 0x00b7 }
        L_0x0066:
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r13 = r13.d     // Catch:{ all -> 0x00b7 }
            boolean r13 = r13.isEmpty()     // Catch:{ all -> 0x00b7 }
            if (r13 != 0) goto L_0x008b
            com.b.a.a.e.j r13 = r12.f705c     // Catch:{ all -> 0x00b7 }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r13 = r13.d     // Catch:{ all -> 0x00b7 }
            java.util.Collection r13 = r13.values()     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r7 = r12.f705c     // Catch:{ all -> 0x00b7 }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r7 = r7.d     // Catch:{ all -> 0x00b7 }
            int r7 = r7.size()     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.ab[] r7 = new com.b.a.a.e.ab[r7]     // Catch:{ all -> 0x00b7 }
            java.lang.Object[] r13 = r13.toArray(r7)     // Catch:{ all -> 0x00b7 }
            r7 = r13
            com.b.a.a.e.ab[] r7 = (com.b.a.a.e.ab[]) r7     // Catch:{ all -> 0x00b7 }
            goto L_0x008b
        L_0x008a:
            r1 = r4
        L_0x008b:
            java.util.concurrent.ExecutorService r13 = com.b.a.a.e.j.f684a     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.w r8 = new com.b.a.a.e.w     // Catch:{ all -> 0x00b7 }
            java.lang.String r9 = "OkHttp %s settings"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b7 }
            com.b.a.a.e.j r10 = r12.f705c     // Catch:{ all -> 0x00b7 }
            java.lang.String r10 = r10.e     // Catch:{ all -> 0x00b7 }
            r6[r3] = r10     // Catch:{ all -> 0x00b7 }
            r8.<init>(r12, r9, r6)     // Catch:{ all -> 0x00b7 }
            r13.execute(r8)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x00b6
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00b6
            int r13 = r7.length
        L_0x00a7:
            if (r3 >= r13) goto L_0x00b6
            r0 = r7[r3]
            monitor-enter(r0)
            r0.a((long) r1)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            int r3 = r3 + 1
            goto L_0x00a7
        L_0x00b3:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            throw r13
        L_0x00b6:
            return
        L_0x00b7:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.u.a(com.b.a.a.e.al):void");
    }

    public final void a(boolean z, int i, int i2) {
        if (z) {
            ai c2 = this.f705c.c(i);
            if (c2 != null) {
                c2.b();
                return;
            }
            return;
        }
        j jVar = this.f705c;
        j.f684a.execute(new m(jVar, "OkHttp %s ping %08x%08x", new Object[]{jVar.e, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2));
    }

    public final void a(boolean z, int i, h hVar, int i2) {
        if (j.d(i)) {
            this.f705c.a(i, hVar, i2, z);
            return;
        }
        ab a2 = this.f705c.a(i);
        if (a2 == null) {
            this.f705c.a(i, b.PROTOCOL_ERROR);
            hVar.f((long) i2);
            return;
        }
        a2.a(hVar, i2);
        if (z) {
            a2.f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        r1.a(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0070, code lost:
        if (r11 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        r1.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r11, int r12, java.util.List<com.b.a.a.e.c> r13) {
        /*
            r10 = this;
            boolean r0 = com.b.a.a.e.j.d(r12)
            if (r0 == 0) goto L_0x000c
            com.b.a.a.e.j r0 = r10.f705c
            r0.a(r12, r13, r11)
            return
        L_0x000c:
            com.b.a.a.e.j r0 = r10.f705c
            monitor-enter(r0)
            com.b.a.a.e.j r1 = r10.f705c     // Catch:{ all -> 0x0076 }
            boolean r1 = r1.h     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0017:
            com.b.a.a.e.j r1 = r10.f705c     // Catch:{ all -> 0x0076 }
            com.b.a.a.e.ab r1 = r1.a(r12)     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x006c
            com.b.a.a.e.j r1 = r10.f705c     // Catch:{ all -> 0x0076 }
            int r1 = r1.f     // Catch:{ all -> 0x0076 }
            if (r12 > r1) goto L_0x0027
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0027:
            int r1 = r12 % 2
            com.b.a.a.e.j r2 = r10.f705c     // Catch:{ all -> 0x0076 }
            int r2 = r2.g     // Catch:{ all -> 0x0076 }
            r3 = 2
            int r2 = r2 % r3
            if (r1 != r2) goto L_0x0033
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0033:
            com.b.a.a.e.ab r1 = new com.b.a.a.e.ab     // Catch:{ all -> 0x0076 }
            com.b.a.a.e.j r6 = r10.f705c     // Catch:{ all -> 0x0076 }
            r7 = 0
            r4 = r1
            r5 = r12
            r8 = r11
            r9 = r13
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0076 }
            com.b.a.a.e.j r11 = r10.f705c     // Catch:{ all -> 0x0076 }
            r11.f = r12     // Catch:{ all -> 0x0076 }
            com.b.a.a.e.j r11 = r10.f705c     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.Integer, com.b.a.a.e.ab> r11 = r11.d     // Catch:{ all -> 0x0076 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0076 }
            r11.put(r13, r1)     // Catch:{ all -> 0x0076 }
            java.util.concurrent.ExecutorService r11 = com.b.a.a.e.j.f684a     // Catch:{ all -> 0x0076 }
            com.b.a.a.e.v r13 = new com.b.a.a.e.v     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "OkHttp %s stream %d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0076 }
            r4 = 0
            com.b.a.a.e.j r5 = r10.f705c     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = r5.e     // Catch:{ all -> 0x0076 }
            r3[r4] = r5     // Catch:{ all -> 0x0076 }
            r4 = 1
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0076 }
            r3[r4] = r12     // Catch:{ all -> 0x0076 }
            r13.<init>(r10, r2, r3, r1)     // Catch:{ all -> 0x0076 }
            r11.execute(r13)     // Catch:{ all -> 0x0076 }
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x006c:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            r1.a((java.util.List<com.b.a.a.e.c>) r13)
            if (r11 == 0) goto L_0x0075
            r1.f()
        L_0x0075:
            return
        L_0x0076:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.u.a(boolean, int, java.util.List):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:15|14|17|18|19|20|21|22|10|11|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        r2 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r5 = this;
            com.b.a.a.e.b r0 = com.b.a.a.e.b.INTERNAL_ERROR
            com.b.a.a.e.b r1 = com.b.a.a.e.b.INTERNAL_ERROR
            com.b.a.a.e.y r2 = r5.f704a     // Catch:{ IOException -> 0x0025 }
            r2.a((com.b.a.a.e.aa) r5)     // Catch:{ IOException -> 0x0025 }
        L_0x0009:
            com.b.a.a.e.y r2 = r5.f704a     // Catch:{ IOException -> 0x0025 }
            r3 = 0
            boolean r2 = r2.a(r3, r5)     // Catch:{ IOException -> 0x0025 }
            if (r2 != 0) goto L_0x0009
            com.b.a.a.e.b r2 = com.b.a.a.e.b.NO_ERROR     // Catch:{ IOException -> 0x0025 }
            com.b.a.a.e.b r0 = com.b.a.a.e.b.CANCEL     // Catch:{ IOException -> 0x0021 }
            com.b.a.a.e.j r1 = r5.f705c     // Catch:{ IOException -> 0x001b }
        L_0x0018:
            r1.a((com.b.a.a.e.b) r2, (com.b.a.a.e.b) r0)     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            com.b.a.a.e.y r0 = r5.f704a
            com.b.a.a.c.a((java.io.Closeable) r0)
            return
        L_0x0021:
            r0 = r2
            goto L_0x0025
        L_0x0023:
            r2 = move-exception
            goto L_0x0030
        L_0x0025:
            com.b.a.a.e.b r2 = com.b.a.a.e.b.PROTOCOL_ERROR     // Catch:{ all -> 0x0023 }
            com.b.a.a.e.b r0 = com.b.a.a.e.b.PROTOCOL_ERROR     // Catch:{ all -> 0x002c }
            com.b.a.a.e.j r1 = r5.f705c     // Catch:{ IOException -> 0x001b }
            goto L_0x0018
        L_0x002c:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x0030:
            com.b.a.a.e.j r3 = r5.f705c     // Catch:{ IOException -> 0x0035 }
            r3.a((com.b.a.a.e.b) r0, (com.b.a.a.e.b) r1)     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            com.b.a.a.e.y r0 = r5.f704a
            com.b.a.a.c.a((java.io.Closeable) r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.a.e.u.b():void");
    }
}
