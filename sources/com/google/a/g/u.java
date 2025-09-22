package com.google.a.g;

import com.google.a.a;
import com.google.a.c.b;
import com.google.a.g;
import com.google.a.v;
import com.google.a.w;
import java.util.Map;

public final class u implements v {

    /* renamed from: a  reason: collision with root package name */
    private final j f3220a = new j();

    public final b a(String str, a aVar, int i, int i2) throws w {
        return a(str, aVar, i, i2, (Map<g, ?>) null);
    }

    public final b a(String str, a aVar, int i, int i2, Map<g, ?> map) throws w {
        if (aVar == a.UPC_A) {
            return this.f3220a.a("0".concat(String.valueOf(str)), a.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
