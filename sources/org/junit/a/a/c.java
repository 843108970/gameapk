package org.junit.a.a;

import java.util.ArrayList;
import java.util.List;
import org.junit.runner.a.a;
import org.junit.runner.e;
import org.junit.runner.f;

abstract class c implements e {
    c() {
    }

    private static List<Class<?>> a(String str) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String a2 : str.split(",")) {
            arrayList.add(org.junit.b.c.a(a2));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public abstract a a(List<Class<?>> list);

    public final a a(f fVar) throws e.a {
        try {
            String str = fVar.f4632a;
            ArrayList arrayList = new ArrayList();
            for (String a2 : str.split(",")) {
                arrayList.add(org.junit.b.c.a(a2));
            }
            return a((List<Class<?>>) arrayList);
        } catch (ClassNotFoundException e) {
            throw new e.a(e);
        }
    }
}
