package com.google.a.b.a;

import com.google.a.a;
import com.google.a.g.aa;
import com.google.a.r;

public final class t extends u {
    private static s c(r rVar) {
        a aVar = rVar.e;
        if (aVar != a.UPC_A && aVar != a.UPC_E && aVar != a.EAN_8 && aVar != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (!a((CharSequence) b2, b2.length())) {
            return null;
        }
        return new s(b2, (aVar == a.UPC_E && b2.length() == 8) ? aa.b(b2) : b2);
    }

    public final /* synthetic */ q a(r rVar) {
        a aVar = rVar.e;
        if (aVar != a.UPC_A && aVar != a.UPC_E && aVar != a.EAN_8 && aVar != a.EAN_13) {
            return null;
        }
        String b2 = b(rVar);
        if (!a((CharSequence) b2, b2.length())) {
            return null;
        }
        return new s(b2, (aVar == a.UPC_E && b2.length() == 8) ? aa.b(b2) : b2);
    }
}
