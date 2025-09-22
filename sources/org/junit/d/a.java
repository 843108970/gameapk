package org.junit.d;

import java.lang.management.ManagementFactory;
import java.util.List;
import org.junit.e.a.j;
import org.junit.runner.c;

public final class a implements l {

    /* renamed from: a  reason: collision with root package name */
    private final l f4528a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f4529b;

    private a(l lVar) {
        this(lVar, ManagementFactory.getRuntimeMXBean().getInputArguments());
    }

    private a(l lVar, List<String> list) {
        this.f4528a = lVar;
        this.f4529b = a(list);
    }

    private boolean a() {
        return this.f4529b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.util.List<java.lang.String> r3) {
        /*
            java.util.Iterator r3 = r3.iterator()
        L_0x0004:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "-Xdebug"
            boolean r1 = r1.equals(r0)
            r2 = 1
            if (r1 == 0) goto L_0x001a
            return r2
        L_0x001a:
            java.lang.String r1 = "-agentlib:jdwp"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0004
            return r2
        L_0x0023:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.d.a.a(java.util.List):boolean");
    }

    public final j a(j jVar, c cVar) {
        return this.f4529b ? jVar : this.f4528a.a(jVar, cVar);
    }
}
