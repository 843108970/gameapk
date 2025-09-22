package com.google.a.b.a;

import com.google.a.r;

public final class ae extends u {
    private static ac c(r rVar) {
        int indexOf;
        String b2 = b(rVar);
        String str = null;
        if ((!b2.startsWith("urlto:") && !b2.startsWith("URLTO:")) || (indexOf = b2.indexOf(58, 6)) < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = b2.substring(6, indexOf);
        }
        return new ac(b2.substring(indexOf + 1), str);
    }

    public final /* synthetic */ q a(r rVar) {
        int indexOf;
        String b2 = b(rVar);
        String str = null;
        if ((!b2.startsWith("urlto:") && !b2.startsWith("URLTO:")) || (indexOf = b2.indexOf(58, 6)) < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = b2.substring(6, indexOf);
        }
        return new ac(b2.substring(indexOf + 1), str);
    }
}
