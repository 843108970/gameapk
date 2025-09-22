package org.litepal.f;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.litepal.c.b;
import org.litepal.d;
import org.litepal.f.b.a;

public abstract class f extends d {
    public static final String g = "Generator";
    private Collection<org.litepal.f.b.d> d;
    private Collection<a> e;

    static void a(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase, true);
        c(sQLiteDatabase, true);
    }

    static void b(SQLiteDatabase sQLiteDatabase) {
        new e().a(sQLiteDatabase, false);
        d(sQLiteDatabase, false);
        new h().b(sQLiteDatabase, false);
        new h().a(sQLiteDatabase, false);
        c(sQLiteDatabase, false);
    }

    protected static void b(List<String> list, SQLiteDatabase sQLiteDatabase) {
        String str = "";
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (String next : list) {
                        if (!TextUtils.isEmpty(next)) {
                            String a2 = org.litepal.g.a.a(next);
                            try {
                                sQLiteDatabase.execSQL(a2);
                                String str2 = a2;
                            } catch (SQLException unused) {
                                str = a2;
                                throw new b(b.SQL_ERROR + str);
                            }
                        }
                    }
                }
            } catch (SQLException unused2) {
                throw new b(b.SQL_ERROR + str);
            }
        }
    }

    private static void c(SQLiteDatabase sQLiteDatabase) {
        new h().b(sQLiteDatabase, false);
    }

    private static void c(SQLiteDatabase sQLiteDatabase, boolean z) {
        new d().b(sQLiteDatabase, z);
    }

    private boolean c() {
        return this.d != null && this.d.size() == org.litepal.e.a.a().d().size();
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        new h().a(sQLiteDatabase, false);
    }

    private static void d(SQLiteDatabase sQLiteDatabase, boolean z) {
        new d().a(sQLiteDatabase, z);
    }

    private static void e(SQLiteDatabase sQLiteDatabase) {
        new e().a(sQLiteDatabase, false);
    }

    /* access modifiers changed from: protected */
    public final Collection<org.litepal.f.b.d> a() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (!(this.d != null && this.d.size() == org.litepal.e.a.a().d().size())) {
            this.d.clear();
            for (String a2 : org.litepal.e.a.a().d()) {
                this.d.add(a(a2));
            }
        }
        return this.d;
    }

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, boolean z);

    /* access modifiers changed from: protected */
    public final Collection<a> b() {
        if (this.e == null || this.e.isEmpty()) {
            List<String> d2 = org.litepal.e.a.a().d();
            if (this.f4722b == null) {
                this.f4722b = new HashSet();
            }
            if (this.f4723c == null) {
                this.f4723c = new HashSet();
            }
            this.f4722b.clear();
            this.f4723c.clear();
            for (String a2 : d2) {
                super.a(a2, 1);
            }
            this.e = this.f4722b;
        }
        return this.e;
    }

    /* access modifiers changed from: protected */
    public abstract void b(SQLiteDatabase sQLiteDatabase, boolean z);
}
