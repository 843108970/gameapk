package com.google.a.b.a;

import com.google.a.r;

public final class f extends a {
    private static ac c(r rVar) {
        String str = rVar.f3353a;
        if (!str.startsWith("MEBKM:")) {
            return null;
        }
        String a2 = a("TITLE:", str, true);
        String[] a3 = a("URL:", str);
        if (a3 == null) {
            return null;
        }
        String str2 = a3[0];
        if (ad.a(str2)) {
            return new ac(str2, a2);
        }
        return null;
    }

    public final /* synthetic */ q a(r rVar) {
        String str = rVar.f3353a;
        if (!str.startsWith("MEBKM:")) {
            return null;
        }
        String a2 = a("TITLE:", str, true);
        String[] a3 = a("URL:", str);
        if (a3 == null) {
            return null;
        }
        String str2 = a3[0];
        if (ad.a(str2)) {
            return new ac(str2, a2);
        }
        return null;
    }
}
