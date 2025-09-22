package org.litepal.b;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.b;
import org.litepal.c.e;
import org.litepal.f;
import org.litepal.g.a;

public final class c extends b {
    private List<String> f;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.e = sQLiteDatabase;
    }

    private List<String> a() {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        return this.f;
    }

    private void a(Class<?> cls, List<Field> list, long... jArr) {
        int i;
        for (Field name : list) {
            String b2 = org.litepal.g.c.b(cls.getName(), name.getName());
            String b3 = org.litepal.g.c.b(cls.getName());
            int length = jArr.length;
            int i2 = (length - 1) / 500;
            int i3 = 0;
            while (i3 <= i2) {
                StringBuilder sb = new StringBuilder();
                int i4 = i3 * 500;
                boolean z = false;
                while (true) {
                    i = i3 + 1;
                    if (i4 < i * 500 && i4 < length) {
                        long j = jArr[i4];
                        if (z) {
                            sb.append(" or ");
                        }
                        sb.append(b3);
                        sb.append(" = ");
                        sb.append(j);
                        i4++;
                        z = true;
                    }
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    this.e.delete(b2, sb.toString(), (String[]) null);
                }
                i3 = i;
            }
        }
    }

    private int b(Class<?> cls, long j) {
        int i = 0;
        for (String delete : a()) {
            String f2 = f(b(cls));
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(delete, f2 + " = " + j, (String[]) null);
        }
        return i;
    }

    private int b(Class<?> cls, String... strArr) {
        int i = 0;
        for (String next : a()) {
            String b2 = b(cls);
            String f2 = f(b2);
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(" in (select id from ");
            sb.append(b2);
            if (strArr != null && strArr.length > 0) {
                sb.append(" where ");
                sb.append(c(strArr));
            }
            sb.append(")");
            i += this.e.delete(next, a.a(sb.toString()), (String[]) null);
        }
        return i;
    }

    private static void b(e eVar, Collection<org.litepal.b.c.a> collection) {
        e c2;
        try {
            for (org.litepal.b.c.a next : collection) {
                if (next.f == 2 && !eVar.getClassName().equals(next.f4697c)) {
                    Collection<e> d = d(eVar, next);
                    if (d != null && !d.isEmpty()) {
                        for (e next2 : d) {
                            if (next2 != null) {
                                next2.clearSavedState();
                            }
                        }
                    }
                } else if (next.f == 1 && (c2 = c(eVar, next)) != null) {
                    c2.clearSavedState();
                }
            }
        } catch (Exception e) {
            throw new e(e.getMessage(), e);
        }
    }

    private static String c(String... strArr) {
        int length = strArr.length - 1;
        int i = 0;
        String str = strArr[0];
        while (i < length) {
            StringBuilder sb = new StringBuilder("'");
            i++;
            sb.append(strArr[i]);
            sb.append("'");
            str = str.replaceFirst("\\?", sb.toString());
        }
        return str;
    }

    private Collection<org.litepal.b.c.a> c(e eVar) {
        try {
            Collection<org.litepal.b.c.a> b2 = b(eVar.getClassName());
            a(eVar, b2);
            return b2;
        } catch (Exception e) {
            throw new e(e.getMessage(), e);
        }
    }

    private void c(Class<?> cls) {
        for (org.litepal.b.c.a next : b(cls.getName())) {
            String a2 = org.litepal.g.c.a(next.f4696b);
            if (next.f == 2 || next.f == 1) {
                if (!cls.getName().equals(next.f4697c)) {
                    a().add(a2);
                }
            } else if (next.f == 3) {
                a().add(a.a(org.litepal.g.c.a(b(cls), a2)));
            }
        }
    }

    private int d(e eVar) {
        int i = 0;
        for (String delete : eVar.getAssociatedModelsMapWithFK().keySet()) {
            String f2 = f(eVar.getTableName());
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(delete, f2 + " = " + eVar.getBaseObjId(), (String[]) null);
        }
        return i + f(eVar);
    }

    private int e(e eVar) {
        int i = 0;
        for (String delete : eVar.getAssociatedModelsMapWithFK().keySet()) {
            String f2 = f(eVar.getTableName());
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(delete, f2 + " = " + eVar.getBaseObjId(), (String[]) null);
        }
        return i;
    }

    private int f(e eVar) {
        int i = 0;
        for (String a2 : eVar.getAssociatedModelsMapForJoinTable().keySet()) {
            String a3 = org.litepal.g.c.a(eVar.getTableName(), a2);
            String f2 = f(eVar.getTableName());
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(a3, f2 + " = " + eVar.getBaseObjId(), (String[]) null);
        }
        return i;
    }

    public final int a(Class<?> cls, long j) {
        int i = 0;
        a(cls, d(cls.getName()), j);
        c(cls);
        for (String delete : a()) {
            String f2 = f(b(cls));
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(delete, f2 + " = " + j, (String[]) null);
        }
        SQLiteDatabase sQLiteDatabase2 = this.e;
        String b2 = b(cls);
        int delete2 = i + sQLiteDatabase2.delete(b2, "id = " + j, (String[]) null);
        a().clear();
        return delete2;
    }

    public final int a(Class<?> cls, String... strArr) {
        a.a(strArr);
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            strArr[0] = org.litepal.g.c.e(strArr[0]);
        }
        List<Field> d = d(cls.getName());
        if (!d.isEmpty()) {
            b a2 = f.a("id");
            a2.f4643b = strArr;
            List<?> a3 = a2.a(cls, false);
            if (a3.size() > 0) {
                long[] jArr = new long[a3.size()];
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    jArr[i2] = ((e) a3.get(i2)).getBaseObjId();
                }
                a(cls, d, jArr);
            }
        }
        c(cls);
        for (String next : a()) {
            String b2 = b(cls);
            String f2 = f(b2);
            StringBuilder sb = new StringBuilder();
            sb.append(f2);
            sb.append(" in (select id from ");
            sb.append(b2);
            if (strArr != null && strArr.length > 0) {
                sb.append(" where ");
                sb.append(c(strArr));
            }
            sb.append(")");
            i += this.e.delete(next, a.a(sb.toString()), (String[]) null);
        }
        int delete = i + this.e.delete(b(cls), a(strArr), b(strArr));
        a().clear();
        return delete;
    }

    public final int a(String str, String... strArr) {
        a.a(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = org.litepal.g.c.e(strArr[0]);
        }
        return this.e.delete(str, a(strArr), b(strArr));
    }

    /* access modifiers changed from: package-private */
    public final int b(e eVar) {
        int i = 0;
        if (!eVar.isSaved()) {
            return 0;
        }
        List<Field> d = d(eVar.getClassName());
        a(eVar.getClass(), d, eVar.getBaseObjId());
        Collection<org.litepal.b.c.a> c2 = c(eVar);
        for (String delete : eVar.getAssociatedModelsMapWithFK().keySet()) {
            String f2 = f(eVar.getTableName());
            SQLiteDatabase sQLiteDatabase = this.e;
            i += sQLiteDatabase.delete(delete, f2 + " = " + eVar.getBaseObjId(), (String[]) null);
        }
        int f3 = i + f(eVar);
        SQLiteDatabase sQLiteDatabase2 = this.e;
        String tableName = eVar.getTableName();
        int delete2 = f3 + sQLiteDatabase2.delete(tableName, "id = " + eVar.getBaseObjId(), (String[]) null);
        b(eVar, c2);
        return delete2;
    }
}
