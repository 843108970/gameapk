package org.junit.a.e.b;

import java.util.ArrayList;
import java.util.List;
import org.junit.a.e.d;
import org.junit.a.e.e;
import org.junit.a.e.g;

public final class b extends e {
    public final List<g> a(d dVar) {
        ArrayList arrayList = new ArrayList();
        for (int valueOf : ((a) dVar.c(a.class)).a()) {
            arrayList.add(g.a("ints", Integer.valueOf(valueOf)));
        }
        return arrayList;
    }
}
