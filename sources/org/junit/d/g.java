package org.junit.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.e.a.j;
import org.junit.runner.c;

public final class g implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final g f4541a = new g(Collections.emptyList());

    /* renamed from: b  reason: collision with root package name */
    private List<l> f4542b;

    private g(List<l> list) {
        this.f4542b = list;
    }

    private static g a() {
        return f4541a;
    }

    private static g a(l lVar) {
        g gVar = f4541a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.addAll(gVar.f4542b);
        return new g(arrayList);
    }

    private g b(l lVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.addAll(this.f4542b);
        return new g(arrayList);
    }

    public final j a(j jVar, c cVar) {
        for (l a2 : this.f4542b) {
            jVar = a2.a(jVar, cVar);
        }
        return jVar;
    }
}
