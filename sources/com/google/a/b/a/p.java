package com.google.a.b.a;

import com.google.a.a;
import com.google.a.r;

public final class p extends u {
    private static o c(r rVar) {
        if (rVar.e != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (b2.length() != 13) {
            return null;
        }
        if (b2.startsWith("978") || b2.startsWith("979")) {
            return new o(b2);
        }
        return null;
    }

    public final /* synthetic */ q a(r rVar) {
        if (rVar.e != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (b2.length() != 13) {
            return null;
        }
        if (b2.startsWith("978") || b2.startsWith("979")) {
            return new o(b2);
        }
        return null;
    }
}
