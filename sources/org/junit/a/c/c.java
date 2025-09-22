package org.junit.a.c;

import org.a.b;
import org.a.g;
import org.a.k;
import org.a.p;

public final class c {
    private static k<b> a() {
        return a(0);
    }

    public static k<b> a(final int i) {
        return new p<b>() {
            private boolean a(b bVar) {
                return bVar.f4437a.getFailures().size() == i;
            }

            public final /* synthetic */ boolean b(Object obj) {
                return ((b) obj).f4437a.getFailures().size() == i;
            }

            public final void describeTo(g gVar) {
                gVar.a("has " + i + " failures");
            }
        };
    }

    private static k<Object> a(final String str) {
        return new b<Object>() {
            public final boolean a(Object obj) {
                return obj.toString().contains(str) && c.a(1).a(obj);
            }

            public final void describeTo(g gVar) {
                gVar.a("has single failure containing " + str);
            }
        };
    }

    private static k<b> b(final String str) {
        return new b<b>() {
            public final boolean a(Object obj) {
                return obj.toString().contains(str);
            }

            public final void describeTo(g gVar) {
                gVar.a("has failure containing " + str);
            }
        };
    }
}
