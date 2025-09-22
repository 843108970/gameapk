package org.a.a;

import java.lang.reflect.Array;
import org.a.b;
import org.a.g;
import org.a.k;

public final class i<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4253a;

    private i(T t) {
        this.f4253a = t;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.Object r5, java.lang.Object r6) {
        /*
            r0 = 0
            r1 = 1
            if (r5 != 0) goto L_0x0008
            if (r6 != 0) goto L_0x0007
            return r1
        L_0x0007:
            return r0
        L_0x0008:
            if (r6 == 0) goto L_0x0051
            java.lang.Class r2 = r5.getClass()
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L_0x0051
            java.lang.Class r2 = r6.getClass()
            boolean r2 = r2.isArray()
            if (r2 == 0) goto L_0x0050
            int r2 = java.lang.reflect.Array.getLength(r5)
            int r3 = java.lang.reflect.Array.getLength(r6)
            if (r2 != r3) goto L_0x002a
            r2 = 1
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x004c
            r2 = 0
        L_0x002e:
            int r3 = java.lang.reflect.Array.getLength(r5)
            if (r2 >= r3) goto L_0x0047
            java.lang.Object r3 = java.lang.reflect.Array.get(r5, r2)
            java.lang.Object r4 = java.lang.reflect.Array.get(r6, r2)
            boolean r3 = a(r3, r4)
            if (r3 != 0) goto L_0x0044
            r5 = 0
            goto L_0x0048
        L_0x0044:
            int r2 = r2 + 1
            goto L_0x002e
        L_0x0047:
            r5 = 1
        L_0x0048:
            if (r5 == 0) goto L_0x004c
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            if (r5 == 0) goto L_0x0050
            return r1
        L_0x0050:
            return r0
        L_0x0051:
            boolean r5 = r5.equals(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.a.a.i.a(java.lang.Object, java.lang.Object):boolean");
    }

    @org.a.i
    public static <T> k<T> b(T t) {
        return new i(t);
    }

    private static boolean b(Object obj, Object obj2) {
        boolean z;
        if (Array.getLength(obj) == Array.getLength(obj2)) {
            int i = 0;
            while (true) {
                if (i >= Array.getLength(obj)) {
                    z = true;
                    break;
                } else if (!a(Array.get(obj, i), Array.get(obj2, i))) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(Object obj) {
        return obj.getClass().isArray();
    }

    private static boolean c(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    private static boolean d(Object obj, Object obj2) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            if (!a(Array.get(obj, i), Array.get(obj2, i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(Object obj) {
        return a(obj, this.f4253a);
    }

    public final void describeTo(g gVar) {
        gVar.a(this.f4253a);
    }
}
