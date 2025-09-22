package org.litepal.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cyjh.common.util.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import net.grandcentrix.tray.provider.TrayContract;
import org.litepal.f.b.a;
import org.litepal.f.b.d;
import org.litepal.g.c;

public abstract class b extends d {
    public static final String d = "AssociationUpdater";
    protected SQLiteDatabase e;
    private Collection<a> h;

    private static String a(Collection<String> collection, d dVar) {
        for (String a2 : collection) {
            dVar.a(a2);
        }
        return c(dVar);
    }

    protected static void a(List<String> list, SQLiteDatabase sQLiteDatabase) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(g(list.get(i)));
            }
            b((List<String>) arrayList, sQLiteDatabase);
        }
    }

    private boolean a(String str, String str2) {
        for (a next : this.h) {
            if (next.d == 1) {
                if (!str.equalsIgnoreCase(next.f4814c)) {
                    continue;
                } else if (next.f4812a.equalsIgnoreCase(str)) {
                    if (a(next, str, str2)) {
                        return false;
                    }
                } else if (next.f4813b.equalsIgnoreCase(str) && a(next, str2, str)) {
                    return false;
                }
            } else if (next.d == 2 && a(next, str2, str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(a aVar, String str, String str2) {
        return aVar.f4812a.equalsIgnoreCase(str) && aVar.f4813b.equalsIgnoreCase(str2);
    }

    protected static String b(d dVar) {
        String str = dVar.f4821a;
        List<org.litepal.f.b.b> list = dVar.f4822b;
        if (list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ");
        sb.append(str);
        sb.append("(");
        boolean z = false;
        boolean z2 = false;
        for (org.litepal.f.b.b next : list) {
            if (z2) {
                sb.append(", ");
            }
            sb.append(next.f4815a);
            z2 = true;
        }
        sb.append(") ");
        sb.append("select ");
        for (org.litepal.f.b.b next2 : list) {
            if (z) {
                sb.append(", ");
            }
            sb.append(next2.f4815a);
            z = true;
        }
        sb.append(" from ");
        sb.append(k(str));
        return sb.toString();
    }

    private List<String> b(Collection<String> collection, String str) {
        d h2 = h(str);
        String i = i(str);
        org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + i);
        String a2 = a(collection, h2);
        org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + a2);
        String b2 = b(h2);
        org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + b2);
        String g = g(k(str));
        org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + g);
        ArrayList arrayList = new ArrayList();
        arrayList.add(i);
        arrayList.add(a2);
        arrayList.add(b2);
        arrayList.add(g);
        return arrayList;
    }

    private void c() {
        for (String a2 : org.litepal.e.a.a().d()) {
            d a3 = a(a2);
            ArrayList arrayList = new ArrayList();
            List<String> a4 = a(a3);
            String str = a3.f4821a;
            for (String next : a4) {
                String str2 = null;
                if (!TextUtils.isEmpty(next) && next.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID)) {
                    str2 = next.substring(0, next.length() - 3);
                }
                if (a(str, str2)) {
                    arrayList.add(next);
                }
            }
            org.litepal.g.d.a(d, "findForeignKeyToRemove >> " + a3.f4821a + s.a.f1696a + arrayList);
            a((Collection<String>) arrayList, a3.f4821a);
        }
        List<String> g = g();
        a(g, this.e);
        a(g);
        List<String> h2 = h();
        a(h2, this.e);
        a(h2);
    }

    private List<String> d(d dVar) {
        ArrayList arrayList = new ArrayList();
        List<String> a2 = a(dVar);
        String str = dVar.f4821a;
        for (String next : a2) {
            String str2 = null;
            if (!TextUtils.isEmpty(next) && next.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID)) {
                str2 = next.substring(0, next.length() - 3);
            }
            if (a(str, str2)) {
                arrayList.add(next);
            }
        }
        org.litepal.g.d.a(d, "findForeignKeyToRemove >> " + dVar.f4821a + s.a.f1696a + arrayList);
        return arrayList;
    }

    private void d() {
        for (String a2 : org.litepal.e.a.a().d()) {
            d a3 = a(a2);
            ArrayList arrayList = new ArrayList();
            List<String> a4 = a(a3);
            String str = a3.f4821a;
            for (String next : a4) {
                String str2 = null;
                if (!TextUtils.isEmpty(next) && next.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID)) {
                    str2 = next.substring(0, next.length() - 3);
                }
                if (a(str, str2)) {
                    arrayList.add(next);
                }
            }
            org.litepal.g.d.a(d, "findForeignKeyToRemove >> " + a3.f4821a + s.a.f1696a + arrayList);
            a((Collection<String>) arrayList, a3.f4821a);
        }
    }

    private void e() {
        ArrayList arrayList = new ArrayList();
        for (String next : c.a(this.e)) {
            if (c.a(next, this.e)) {
                boolean z = true;
                for (a next2 : this.h) {
                    if (next2.d == 3 && next.equalsIgnoreCase(c.a(next2.f4812a, next2.f4813b))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
            }
        }
        org.litepal.g.d.a(d, "findIntermediateTablesToDrop >> " + arrayList);
        a((List<String>) arrayList, this.e);
        a((List<String>) arrayList);
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        for (String next : c.a(this.e)) {
            if (c.b(next, this.e)) {
                boolean z = true;
                for (org.litepal.f.b.c cVar : this.f4723c) {
                    if (next.equalsIgnoreCase(cVar.f4818a)) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
            }
        }
        a((List<String>) arrayList, this.e);
        a((List<String>) arrayList);
    }

    private List<String> g() {
        ArrayList arrayList = new ArrayList();
        for (String next : c.a(this.e)) {
            if (c.a(next, this.e)) {
                boolean z = true;
                for (a next2 : this.h) {
                    if (next2.d == 3 && next.equalsIgnoreCase(c.a(next2.f4812a, next2.f4813b))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
            }
        }
        org.litepal.g.d.a(d, "findIntermediateTablesToDrop >> " + arrayList);
        return arrayList;
    }

    private List<String> h() {
        ArrayList arrayList = new ArrayList();
        for (String next : c.a(this.e)) {
            if (c.b(next, this.e)) {
                boolean z = true;
                for (org.litepal.f.b.c cVar : this.f4723c) {
                    if (next.equalsIgnoreCase(cVar.f4818a)) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    protected static String i(String str) {
        return "alter table " + str + " rename to " + k(str);
    }

    protected static String j(String str) {
        return g(k(str));
    }

    private static String k(String str) {
        return str + "_temp";
    }

    /* access modifiers changed from: protected */
    public final List<String> a(d dVar) {
        ArrayList arrayList = new ArrayList();
        for (org.litepal.f.b.b next : h(dVar.f4821a).f4822b) {
            String str = next.f4815a;
            String str2 = next.f4815a;
            boolean z = false;
            if (!TextUtils.isEmpty(str2) && str2.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID) && !str2.equalsIgnoreCase(TrayContract.Preferences.Columns.ID)) {
                z = true;
            }
            if (z && !dVar.b(str)) {
                org.litepal.g.d.a(d, "getForeignKeyColumnNames >> foreign key column is " + str);
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, boolean z);

    /* access modifiers changed from: protected */
    public final void a(Collection<String> collection, String str) {
        if (collection != null && !collection.isEmpty()) {
            d h2 = h(str);
            String i = i(str);
            org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + i);
            String a2 = a(collection, h2);
            org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + a2);
            String b2 = b(h2);
            org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + b2);
            String g = g(k(str));
            org.litepal.g.d.a(d, "generateRemoveColumnSQL >> " + g);
            ArrayList arrayList = new ArrayList();
            arrayList.add(i);
            arrayList.add(a2);
            arrayList.add(b2);
            arrayList.add(g);
            b((List<String>) arrayList, this.e);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder("delete from ");
            sb.append("table_schema where");
            boolean z = false;
            for (String next : list) {
                if (z) {
                    sb.append(" or ");
                }
                z = true;
                sb.append(" lower(name) ");
                sb.append("= lower('");
                sb.append(next);
                sb.append("')");
            }
            org.litepal.g.d.a(d, "clear table schema value sql is " + sb);
            ArrayList arrayList = new ArrayList();
            arrayList.add(sb.toString());
            b((List<String>) arrayList, this.e);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(d dVar, String str) {
        return org.litepal.g.a.a((Collection<String>) a(dVar), str);
    }

    /* access modifiers changed from: protected */
    public final void b(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.h = b();
        this.e = sQLiteDatabase;
        for (String a2 : org.litepal.e.a.a().d()) {
            d a3 = a(a2);
            ArrayList arrayList = new ArrayList();
            List<String> a4 = a(a3);
            String str = a3.f4821a;
            for (String next : a4) {
                String str2 = null;
                if (!TextUtils.isEmpty(next) && next.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID)) {
                    str2 = next.substring(0, next.length() - 3);
                }
                if (a(str, str2)) {
                    arrayList.add(next);
                }
            }
            org.litepal.g.d.a(d, "findForeignKeyToRemove >> " + a3.f4821a + s.a.f1696a + arrayList);
            a((Collection<String>) arrayList, a3.f4821a);
        }
        List<String> g = g();
        a(g, this.e);
        a(g);
        List<String> h2 = h();
        a(h2, this.e);
        a(h2);
    }

    /* access modifiers changed from: protected */
    public final d h(String str) {
        return c.d(str, this.e);
    }
}
