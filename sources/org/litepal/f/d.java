package org.litepal.f;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.litepal.g.c;

class d extends a {
    public static final String f = "Creator";

    d() {
    }

    private static String a(org.litepal.f.b.d dVar) {
        return g(dVar.f4821a);
    }

    protected static void a(org.litepal.f.b.d dVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(g(dVar.f4821a));
        } else if (c.c(dVar.f4821a, sQLiteDatabase)) {
            arrayList = null;
            b((List<String>) arrayList, sQLiteDatabase);
            a(dVar.f4821a, 0, sQLiteDatabase);
        }
        arrayList.add(c(dVar));
        b((List<String>) arrayList, sQLiteDatabase);
        a(dVar.f4821a, 0, sQLiteDatabase);
    }

    private static List<String> b(org.litepal.f.b.d dVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(g(dVar.f4821a));
        } else if (c.c(dVar.f4821a, sQLiteDatabase)) {
            return null;
        }
        arrayList.add(c(dVar));
        return arrayList;
    }

    static String c(org.litepal.f.b.d dVar) {
        return a(dVar.f4821a, dVar.f4822b, true);
    }

    /* access modifiers changed from: protected */
    public void a(SQLiteDatabase sQLiteDatabase, boolean z) {
        for (org.litepal.f.b.d a2 : a()) {
            a(a2, sQLiteDatabase, z);
        }
    }
}
