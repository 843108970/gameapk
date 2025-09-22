package com.google.a.f.a.a;

import com.google.a.c.b;
import com.google.a.c.g;
import com.google.a.i.b.c;
import com.google.a.i.b.f;
import com.google.a.m;
import com.google.a.q;
import java.util.ArrayList;

public final class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private static final g[] f3144b = new g[0];

    public a(b bVar) {
        super(bVar);
    }

    public final g[] a() throws m {
        f[] a2 = new b(this.f3320a, (byte) 0).a();
        if (a2.length == 0) {
            throw m.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (f a3 : a2) {
            try {
                arrayList.add(a(a3));
            } catch (q unused) {
            }
        }
        return arrayList.isEmpty() ? f3144b : (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}
