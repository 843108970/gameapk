package org.junit.a.e.a;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.a.e.a;
import org.junit.a.e.b;
import org.junit.a.e.c;
import org.junit.e.a.d;
import org.junit.e.a.k;

public final class f extends a {
    private f(k kVar) {
        super(kVar);
    }

    /* access modifiers changed from: protected */
    public final Collection<d> b(org.junit.a.e.d dVar) {
        Collection<d> b2 = super.b(dVar);
        String a2 = ((c) dVar.c(c.class)).a();
        ArrayList arrayList = new ArrayList();
        for (d next : b2) {
            if (Arrays.asList(((b) next.a(b.class)).a()).contains(a2)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final Collection<Field> c(org.junit.a.e.d dVar) {
        Collection<Field> c2 = super.c(dVar);
        String a2 = ((c) dVar.c(c.class)).a();
        ArrayList arrayList = new ArrayList();
        for (Field next : c2) {
            if (Arrays.asList(((a) next.getAnnotation(a.class)).a()).contains(a2)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final Collection<Field> d(org.junit.a.e.d dVar) {
        Collection<Field> d = super.d(dVar);
        String a2 = ((c) dVar.c(c.class)).a();
        ArrayList arrayList = new ArrayList();
        for (Field next : d) {
            if (Arrays.asList(((b) next.getAnnotation(b.class)).a()).contains(a2)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final Collection<d> e(org.junit.a.e.d dVar) {
        Collection<d> e = super.e(dVar);
        String a2 = ((c) dVar.c(c.class)).a();
        ArrayList arrayList = new ArrayList();
        for (d next : e) {
            if (Arrays.asList(((a) next.a(a.class)).a()).contains(a2)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
