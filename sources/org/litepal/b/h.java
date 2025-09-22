package org.litepal.b;

import java.lang.reflect.InvocationTargetException;
import org.litepal.b.c.a;
import org.litepal.g.c;

public final class h extends a {
    private static void b(e eVar, e eVar2) {
        if (eVar2.isSaved()) {
            eVar.addAssociatedModelWithFK(eVar2.getTableName(), eVar2.getBaseObjId());
            eVar.addAssociatedModelWithoutFK(eVar2.getTableName(), eVar2.getBaseObjId());
        }
    }

    private static void b(e eVar, e eVar2, a aVar) {
        if (aVar.e == null) {
            a(eVar, eVar2);
        } else if (eVar2.isSaved()) {
            eVar.addAssociatedModelWithFK(eVar2.getTableName(), eVar2.getBaseObjId());
            eVar.addAssociatedModelWithoutFK(eVar2.getTableName(), eVar2.getBaseObjId());
        }
    }

    private static void c(e eVar, e eVar2) {
        a(eVar, eVar2);
    }

    static void e(e eVar, a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        e c2 = c(eVar, aVar);
        if (c2 != null) {
            a(eVar, c2, aVar);
            if (aVar.e == null) {
                a(eVar, c2);
            } else if (c2.isSaved()) {
                eVar.addAssociatedModelWithFK(c2.getTableName(), c2.getBaseObjId());
                eVar.addAssociatedModelWithoutFK(c2.getTableName(), c2.getBaseObjId());
            }
        } else {
            eVar.addAssociatedTableNameToClearFK(c.a(aVar.f4696b));
        }
    }
}
