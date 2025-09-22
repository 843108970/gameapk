package org.junit.d;

import org.junit.e.a.d;
import org.junit.e.a.j;

@Deprecated
public final class n implements f {
    private static void a() {
    }

    private static void b() {
    }

    private static void c() {
    }

    private static void d() {
    }

    public final j a(final j jVar, final d dVar) {
        return new j() {
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x000a, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
                throw r0;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a() throws java.lang.Throwable {
                /*
                    r1 = this;
                    org.junit.e.a.j r0 = r2     // Catch:{ b -> 0x000a, Throwable -> 0x0008 }
                    r0.a()     // Catch:{ b -> 0x000a, Throwable -> 0x0008 }
                    return
                L_0x0006:
                    r0 = move-exception
                    goto L_0x000c
                L_0x0008:
                    r0 = move-exception
                    throw r0     // Catch:{ all -> 0x0006 }
                L_0x000a:
                    r0 = move-exception
                    throw r0     // Catch:{ all -> 0x0006 }
                L_0x000c:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.junit.d.n.AnonymousClass1.a():void");
            }
        };
    }
}
