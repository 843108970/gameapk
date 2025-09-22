package org.litepal.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.litepal.b.c.a;
import org.litepal.g.c;

public final class f extends a {
    private static String a(a aVar) {
        return org.litepal.g.a.a(c.a(aVar.f4696b));
    }

    private static void a(Collection<e> collection, e eVar) {
        if (!collection.contains(eVar)) {
            collection.add(eVar);
        }
    }

    private static void b(e eVar, e eVar2) {
        if (eVar2.isSaved()) {
            eVar.addAssociatedModelForJoinTable(eVar2.getTableName(), eVar2.getBaseObjId());
        }
    }

    @Deprecated
    private static boolean c(e eVar, e eVar2) {
        SQLiteDatabase a2 = org.litepal.f.c.a();
        boolean z = true;
        Cursor cursor = null;
        try {
            String a3 = a(eVar, eVar2.getTableName());
            Cursor query = a2.query(a3, (String[]) null, f(eVar.getTableName()) + " = ? and " + f(eVar2.getTableName()) + " = ?", new String[]{String.valueOf(eVar.getBaseObjId()), String.valueOf(eVar2.getBaseObjId())}, (String) null, (String) null, (String) null);
            try {
                if (query.getCount() <= 0) {
                    z = false;
                }
                query.close();
                return z;
            } catch (Exception e) {
                e = e;
                cursor = query;
                try {
                    e.printStackTrace();
                    cursor.close();
                    return true;
                } catch (Throwable th) {
                    th = th;
                    cursor.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                cursor.close();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            cursor.close();
            return true;
        }
    }

    private static String d(e eVar, e eVar2) {
        return f(eVar.getTableName()) + " = ? and " + f(eVar2.getTableName()) + " = ?";
    }

    static void e(e eVar, a aVar) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Collection<e> d = d(eVar, aVar);
        eVar.addEmptyModelForJoinTable(org.litepal.g.a.a(c.a(aVar.f4696b)));
        if (d != null) {
            for (e next : d) {
                Collection<e> a2 = a(a(next, aVar), aVar.e);
                if (!a2.contains(eVar)) {
                    a2.add(eVar);
                }
                a(next, aVar, a2);
                if (next.isSaved()) {
                    eVar.addAssociatedModelForJoinTable(next.getTableName(), next.getBaseObjId());
                }
            }
        }
    }

    private static String[] e(e eVar, e eVar2) {
        return new String[]{String.valueOf(eVar.getBaseObjId()), String.valueOf(eVar2.getBaseObjId())};
    }

    private static String f(e eVar, e eVar2) {
        return a(eVar, eVar2.getTableName());
    }

    private static void f(e eVar, a aVar) {
        eVar.addEmptyModelForJoinTable(org.litepal.g.a.a(c.a(aVar.f4696b)));
    }
}
