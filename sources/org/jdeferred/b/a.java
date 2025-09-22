package org.jdeferred.b;

import java.util.concurrent.atomic.AtomicInteger;
import org.jdeferred.a.d;
import org.jdeferred.g;
import org.jdeferred.j;
import org.jdeferred.m;
import org.jdeferred.p;

public final class a extends d<c, e, b> implements p<c, e, b> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f4396a;
    /* access modifiers changed from: private */
    public final AtomicInteger j = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger k = new AtomicInteger();
    /* access modifiers changed from: private */
    public final c l;

    public a(p... pVarArr) {
        if (pVarArr == null || pVarArr.length == 0) {
            throw new IllegalArgumentException("Promises is null or empty");
        }
        this.f4396a = pVarArr.length;
        this.l = new c(this.f4396a);
        int length = pVarArr.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            final p pVar = pVarArr[i];
            pVar.a(new j<Object>() {
                public final void a(Object obj) {
                    synchronized (a.this) {
                        if (a.this.c()) {
                            a.this.c(new b(a.this.j.get(), a.this.k.incrementAndGet(), a.this.f4396a));
                            a.this.b(new e(i2, pVar, obj));
                        }
                    }
                }
            }).a(new m() {
                public final void a(Object obj) {
                    synchronized (a.this) {
                        if (a.this.c()) {
                            a.this.c(new d(a.this.j.get(), a.this.k.get(), a.this.f4396a, i2, pVar, obj));
                        }
                    }
                }
            }).b(new g() {
                /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(java.lang.Object r7) {
                    /*
                        r6 = this;
                        org.jdeferred.b.a r0 = org.jdeferred.b.a.this
                        monitor-enter(r0)
                        org.jdeferred.b.a r1 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        boolean r1 = r1.c()     // Catch:{ all -> 0x005c }
                        if (r1 != 0) goto L_0x000d
                        monitor-exit(r0)     // Catch:{ all -> 0x005c }
                        return
                    L_0x000d:
                        org.jdeferred.b.a r1 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.c r1 = r1.l     // Catch:{ all -> 0x005c }
                        int r2 = r2     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.f r3 = new org.jdeferred.b.f     // Catch:{ all -> 0x005c }
                        int r4 = r2     // Catch:{ all -> 0x005c }
                        org.jdeferred.p r5 = r3     // Catch:{ all -> 0x005c }
                        r3.<init>(r4, r5, r7)     // Catch:{ all -> 0x005c }
                        java.util.List<org.jdeferred.b.f> r7 = r1.f4409a     // Catch:{ all -> 0x005c }
                        r7.set(r2, r3)     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r7 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        java.util.concurrent.atomic.AtomicInteger r7 = r7.j     // Catch:{ all -> 0x005c }
                        int r7 = r7.incrementAndGet()     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r1 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.b r2 = new org.jdeferred.b.b     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r3 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        java.util.concurrent.atomic.AtomicInteger r3 = r3.k     // Catch:{ all -> 0x005c }
                        int r3 = r3.get()     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r4 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        int r4 = r4.f4396a     // Catch:{ all -> 0x005c }
                        r2.<init>(r7, r3, r4)     // Catch:{ all -> 0x005c }
                        r1.c(r2)     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r1 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        int r1 = r1.f4396a     // Catch:{ all -> 0x005c }
                        if (r7 != r1) goto L_0x005a
                        org.jdeferred.b.a r7 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.a r1 = org.jdeferred.b.a.this     // Catch:{ all -> 0x005c }
                        org.jdeferred.b.c r1 = r1.l     // Catch:{ all -> 0x005c }
                        r7.a(r1)     // Catch:{ all -> 0x005c }
                    L_0x005a:
                        monitor-exit(r0)     // Catch:{ all -> 0x005c }
                        return
                    L_0x005c:
                        r7 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x005c }
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jdeferred.b.a.AnonymousClass1.a(java.lang.Object):void");
                }
            });
            i++;
            i2++;
        }
    }
}
