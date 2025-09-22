package com.google.a.b.a;

import com.google.a.r;

public final class aa extends u {
    private static z c(r rVar) {
        String str;
        String b2 = b(rVar);
        if (!b2.startsWith("tel:") && !b2.startsWith("TEL:")) {
            return null;
        }
        if (b2.startsWith("TEL:")) {
            str = "tel:" + b2.substring(4);
        } else {
            str = b2;
        }
        int indexOf = b2.indexOf(63, 4);
        return new z(indexOf < 0 ? b2.substring(4) : b2.substring(4, indexOf), str);
    }

    public final /* synthetic */ q a(r rVar) {
        String str;
        String b2 = b(rVar);
        if (!b2.startsWith("tel:") && !b2.startsWith("TEL:")) {
            return null;
        }
        if (b2.startsWith("TEL:")) {
            str = "tel:" + b2.substring(4);
        } else {
            str = b2;
        }
        int indexOf = b2.indexOf(63, 4);
        return new z(indexOf < 0 ? b2.substring(4) : b2.substring(4, indexOf), str);
    }
}
