package org.junit.a.e.a;

import java.util.ArrayList;
import java.util.List;
import org.junit.a.e.e;
import org.junit.a.e.g;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f4444a;

    public d(Class<?> cls) {
        this.f4444a = cls;
    }

    public final List<g> a(org.junit.a.e.d dVar) {
        Object[] enumConstants = this.f4444a.getEnumConstants();
        ArrayList arrayList = new ArrayList();
        for (Object obj : enumConstants) {
            arrayList.add(g.a(obj.toString(), obj));
        }
        return arrayList;
    }
}
