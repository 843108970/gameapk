package com.google.a.g;

import com.google.a.a;
import com.google.a.c;
import com.google.a.d;
import com.google.a.e;
import com.google.a.h;
import com.google.a.m;
import com.google.a.r;
import java.util.Map;

public final class t extends y {

    /* renamed from: a  reason: collision with root package name */
    private final y f3219a = new i();

    private static r a(r rVar) throws h {
        String str = rVar.f3353a;
        if (str.charAt(0) == '0') {
            r rVar2 = new r(str.substring(1), (byte[]) null, rVar.d, a.UPC_A);
            if (rVar.f != null) {
                rVar2.a(rVar.f);
            }
            return rVar2;
        }
        throw h.getFormatInstance();
    }

    /* access modifiers changed from: protected */
    public final int a(com.google.a.c.a aVar, int[] iArr, StringBuilder sb) throws m {
        return this.f3219a.a(aVar, iArr, sb);
    }

    public final r a(int i, com.google.a.c.a aVar, Map<e, ?> map) throws m, h, d {
        return a(this.f3219a.a(i, aVar, map));
    }

    public final r a(int i, com.google.a.c.a aVar, int[] iArr, Map<e, ?> map) throws m, h, d {
        return a(this.f3219a.a(i, aVar, iArr, map));
    }

    public final r a(c cVar) throws m, h {
        return a(this.f3219a.a(cVar));
    }

    public final r a(c cVar, Map<e, ?> map) throws m, h {
        return a(this.f3219a.a(cVar, map));
    }

    /* access modifiers changed from: package-private */
    public final a b() {
        return a.UPC_A;
    }
}
