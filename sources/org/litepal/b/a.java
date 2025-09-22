package org.litepal.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.litepal.c.e;
import org.litepal.g.c;

abstract class a extends b {
    a() {
    }

    private static String a(org.litepal.b.c.a aVar) {
        return f(c.a(aVar.f4696b));
    }

    protected static Collection<e> a(Collection<e> collection, Field field) {
        Collection<e> collection2;
        if (List.class.isAssignableFrom(field.getType())) {
            collection2 = new ArrayList<>();
        } else {
            if (Set.class.isAssignableFrom(field.getType())) {
                collection2 = new HashSet<>();
            } else {
                throw new e(e.WRONG_FIELD_TYPE_FOR_ASSOCIATIONS);
            }
        }
        if (collection != null) {
            collection2.addAll(collection);
        }
        return collection2;
    }

    protected static Collection<e> a(e eVar, org.litepal.b.c.a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (Collection) a(eVar, aVar.e);
    }

    protected static void a(e eVar, org.litepal.b.c.a aVar, Collection<e> collection) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        a(eVar, aVar.e, (Object) collection);
    }

    protected static void a(e eVar, e eVar2) {
        if (eVar2 == null) {
            return;
        }
        if (eVar2.isSaved()) {
            eVar.addAssociatedModelWithFK(eVar2.getTableName(), eVar2.getBaseObjId());
        } else if (eVar.isSaved()) {
            eVar2.addAssociatedModelWithoutFK(eVar.getTableName(), eVar.getBaseObjId());
        }
    }

    protected static void a(e eVar, e eVar2, org.litepal.b.c.a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        a(eVar2, aVar.e, (Object) eVar);
    }

    protected static void b(e eVar, org.litepal.b.c.a aVar) {
        eVar.addFKNameToClearSelf(f(c.a(aVar.f4696b)));
    }
}
