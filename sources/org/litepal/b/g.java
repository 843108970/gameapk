package org.litepal.b;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.litepal.b.c.a;
import org.litepal.g.c;

final class g extends a {
    g() {
    }

    private static void a(Collection<e> collection, e eVar, e eVar2) {
        if (!collection.contains(eVar)) {
            collection.add(eVar);
        }
        if (eVar2.isSaved()) {
            eVar.addAssociatedModelWithoutFK(eVar2.getTableName(), eVar2.getBaseObjId());
        }
    }

    private static void b(e eVar, e eVar2) {
        a(eVar, eVar2);
    }

    static void e(e eVar, a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (eVar.getClassName().equals(aVar.f4697c)) {
            e c2 = c(eVar, aVar);
            if (c2 != null) {
                Collection<e> a2 = a(a(c2, aVar), aVar.e);
                a(c2, aVar, a2);
                if (!a2.contains(eVar)) {
                    a2.add(eVar);
                }
                if (c2.isSaved()) {
                    eVar.addAssociatedModelWithoutFK(c2.getTableName(), c2.getBaseObjId());
                    return;
                }
                return;
            }
            b(eVar, aVar);
            return;
        }
        Collection<e> d = d(eVar, aVar);
        if (d == null || d.isEmpty()) {
            eVar.addAssociatedTableNameToClearFK(c.a(aVar.f4696b));
            return;
        }
        for (e next : d) {
            a(eVar, next, aVar);
            a(eVar, next);
        }
    }

    private static void f(e eVar, a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        e c2 = c(eVar, aVar);
        if (c2 != null) {
            Collection<e> a2 = a(a(c2, aVar), aVar.e);
            a(c2, aVar, a2);
            if (!a2.contains(eVar)) {
                a2.add(eVar);
            }
            if (c2.isSaved()) {
                eVar.addAssociatedModelWithoutFK(c2.getTableName(), c2.getBaseObjId());
                return;
            }
            return;
        }
        b(eVar, aVar);
    }

    private static void g(e eVar, a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Collection<e> d = d(eVar, aVar);
        if (d == null || d.isEmpty()) {
            eVar.addAssociatedTableNameToClearFK(c.a(aVar.f4696b));
            return;
        }
        for (e next : d) {
            a(eVar, next, aVar);
            a(eVar, next);
        }
    }
}
