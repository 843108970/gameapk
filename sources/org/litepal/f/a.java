package org.litepal.f;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.cyjh.common.util.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import net.grandcentrix.tray.provider.TrayContract;
import org.litepal.f.b.b;
import org.litepal.g.b;
import org.litepal.g.c;
import org.litepal.g.d;

public abstract class a extends f {
    protected static String a(String str, List<b> list, boolean z) {
        StringBuilder sb = new StringBuilder("create table ");
        sb.append(str);
        sb.append(" (");
        if (z) {
            sb.append("id integer primary key autoincrement,");
        }
        if (list.size() == 0 || (list.size() == 1 && e(list.get(0).f4815a)) || (list.size() == 2 && e(list.get(0).f4815a) && e(list.get(1).f4815a))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        boolean z2 = false;
        for (b next : list) {
            if (!(TrayContract.Preferences.Columns.ID.equalsIgnoreCase(next.f4815a) || "id".equalsIgnoreCase(next.f4815a))) {
                if (z2) {
                    sb.append(", ");
                }
                sb.append(next.f4815a);
                sb.append(s.a.f1696a);
                sb.append(next.f4816b);
                if (!next.f4817c) {
                    sb.append(" not null");
                }
                if (next.d) {
                    sb.append(" unique");
                }
                String str2 = next.e;
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(" default ");
                    sb.append(str2);
                }
                z2 = true;
            }
        }
        sb.append(")");
        d.a(f.g, "create table sql is >> " + sb);
        return sb.toString();
    }

    protected static String a(String str, b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("alter table ");
        sb.append(str);
        sb.append(" add column ");
        sb.append(bVar.f4815a);
        sb.append(s.a.f1696a);
        sb.append(bVar.f4816b);
        if (!bVar.f4817c) {
            sb.append(" not null");
        }
        if (bVar.d) {
            sb.append(" unique");
        }
        String str2 = bVar.e;
        if (TextUtils.isEmpty(str2)) {
            if (!bVar.f4817c) {
                if ("integer".equalsIgnoreCase(bVar.f4816b)) {
                    str2 = "0";
                } else if ("text".equalsIgnoreCase(bVar.f4816b)) {
                    str2 = "''";
                } else if ("real".equalsIgnoreCase(bVar.f4816b)) {
                    str2 = "0.0";
                }
            }
            d.a(f.g, "add column sql is >> " + sb);
            return sb.toString();
        }
        sb.append(" default ");
        sb.append(str2);
        d.a(f.g, "add column sql is >> " + sb);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void a(java.lang.String r4, int r5, android.database.sqlite.SQLiteDatabase r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "select * from "
            r0.<init>(r1)
            java.lang.String r1 = "table_schema"
            r0.append(r1)
            java.lang.String r1 = "Generator"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "giveTableSchemaACopy SQL is >> "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            org.litepal.g.d.a((java.lang.String) r1, (java.lang.String) r2)
            r1 = 0
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0065 }
            android.database.Cursor r0 = r6.rawQuery(r0, r1)     // Catch:{ Exception -> 0x0065 }
            boolean r2 = b((android.database.Cursor) r0, (java.lang.String) r4)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            if (r2 != 0) goto L_0x0038
            java.lang.String r2 = "table_schema"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            if (r2 != 0) goto L_0x0038
            r2 = 1
            goto L_0x0039
        L_0x0038:
            r2 = 0
        L_0x0039:
            if (r2 == 0) goto L_0x0057
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            r2.<init>()     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            java.lang.String r3 = "name"
            java.lang.String r4 = org.litepal.g.a.a((java.lang.String) r4)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            r2.put(r3, r4)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            java.lang.String r4 = "type"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
            java.lang.String r4 = "table_schema"
            r6.insert(r4, r1, r2)     // Catch:{ Exception -> 0x005f, all -> 0x005d }
        L_0x0057:
            if (r0 == 0) goto L_0x006e
            r0.close()
            return
        L_0x005d:
            r4 = move-exception
            goto L_0x006f
        L_0x005f:
            r4 = move-exception
            r1 = r0
            goto L_0x0066
        L_0x0062:
            r4 = move-exception
            r0 = r1
            goto L_0x006f
        L_0x0065:
            r4 = move-exception
        L_0x0066:
            r4.printStackTrace()     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            return
        L_0x006f:
            if (r0 == 0) goto L_0x0074
            r0.close()
        L_0x0074:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.f.a.a(java.lang.String, int, android.database.sqlite.SQLiteDatabase):void");
    }

    private static void a(String str, String str2, SQLiteDatabase sQLiteDatabase, boolean z) {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.f4815a = str + TrayContract.Preferences.Columns.ID;
        bVar.f4816b = "integer";
        b bVar2 = new b();
        bVar2.f4815a = str2 + TrayContract.Preferences.Columns.ID;
        bVar2.f4816b = "integer";
        arrayList.add(bVar);
        arrayList.add(bVar2);
        String a2 = c.a(str, str2);
        ArrayList arrayList2 = new ArrayList();
        if (c.c(a2, sQLiteDatabase)) {
            if (z) {
                arrayList2.add(g(a2));
            }
            b((List<String>) arrayList2, sQLiteDatabase);
            a(a2, 1, sQLiteDatabase);
        }
        arrayList2.add(a(a2, (List<b>) arrayList, false));
        b((List<String>) arrayList2, sQLiteDatabase);
        a(a2, 1, sQLiteDatabase);
    }

    protected static void a(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        if (!c.c(str, sQLiteDatabase)) {
            throw new org.litepal.c.b(org.litepal.c.b.TABLE_DOES_NOT_EXIST + str);
        } else if (c.c(str2, sQLiteDatabase)) {
            String str4 = null;
            if (str.equals(str3)) {
                str4 = f(str2);
            } else if (str2.equals(str3)) {
                str4 = f(str);
            }
            if (!c.a(str4, str3, sQLiteDatabase)) {
                b bVar = new b();
                bVar.f4815a = str4;
                bVar.f4816b = "integer";
                ArrayList arrayList = new ArrayList();
                arrayList.add(a(str3, bVar));
                b((List<String>) arrayList, sQLiteDatabase);
                return;
            }
            d.a(f.g, "column " + str4 + " is already exist, no need to add one");
        } else {
            throw new org.litepal.c.b(org.litepal.c.b.TABLE_DOES_NOT_EXIST + str2);
        }
    }

    private void a(Collection<org.litepal.f.b.a> collection, SQLiteDatabase sQLiteDatabase, boolean z) {
        for (org.litepal.f.b.a next : collection) {
            if (2 == next.d || 1 == next.d) {
                a(next.f4812a, next.f4813b, next.f4814c, sQLiteDatabase);
            } else if (3 == next.d) {
                String str = next.f4812a;
                String str2 = next.f4813b;
                ArrayList arrayList = new ArrayList();
                b bVar = new b();
                bVar.f4815a = str + TrayContract.Preferences.Columns.ID;
                bVar.f4816b = "integer";
                b bVar2 = new b();
                bVar2.f4815a = str2 + TrayContract.Preferences.Columns.ID;
                bVar2.f4816b = "integer";
                arrayList.add(bVar);
                arrayList.add(bVar2);
                String a2 = c.a(str, str2);
                ArrayList arrayList2 = new ArrayList();
                if (c.c(a2, sQLiteDatabase)) {
                    if (z) {
                        arrayList2.add(g(a2));
                    }
                    b((List<String>) arrayList2, sQLiteDatabase);
                    a(a2, 1, sQLiteDatabase);
                }
                arrayList2.add(a(a2, (List<b>) arrayList, false));
                b((List<String>) arrayList2, sQLiteDatabase);
                a(a2, 1, sQLiteDatabase);
            }
        }
        for (org.litepal.f.b.c next2 : this.f4723c) {
            String str3 = next2.f4818a;
            String str4 = next2.f4819b;
            String str5 = next2.f4820c;
            String str6 = next2.d;
            ArrayList arrayList3 = new ArrayList();
            b bVar3 = new b();
            bVar3.f4815a = str4;
            bVar3.f4816b = str5;
            b bVar4 = new b();
            bVar4.f4815a = str6;
            bVar4.f4816b = "integer";
            arrayList3.add(bVar3);
            arrayList3.add(bVar4);
            ArrayList arrayList4 = new ArrayList();
            if (c.c(str3, sQLiteDatabase)) {
                if (z) {
                    arrayList4.add(g(str3));
                } else {
                    b((List<String>) arrayList4, sQLiteDatabase);
                    a(str3, 2, sQLiteDatabase);
                }
            }
            arrayList4.add(a(str3, (List<b>) arrayList3, false));
            b((List<String>) arrayList4, sQLiteDatabase);
            a(str3, 2, sQLiteDatabase);
        }
    }

    private static void a(org.litepal.f.b.c cVar, SQLiteDatabase sQLiteDatabase, boolean z) {
        String str = cVar.f4818a;
        String str2 = cVar.f4819b;
        String str3 = cVar.f4820c;
        String str4 = cVar.d;
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.f4815a = str2;
        bVar.f4816b = str3;
        b bVar2 = new b();
        bVar2.f4815a = str4;
        bVar2.f4816b = "integer";
        arrayList.add(bVar);
        arrayList.add(bVar2);
        ArrayList arrayList2 = new ArrayList();
        if (c.c(str, sQLiteDatabase)) {
            if (z) {
                arrayList2.add(g(str));
            }
            b((List<String>) arrayList2, sQLiteDatabase);
            a(str, 2, sQLiteDatabase);
        }
        arrayList2.add(a(str, (List<b>) arrayList, false));
        b((List<String>) arrayList2, sQLiteDatabase);
        a(str, 2, sQLiteDatabase);
    }

    private static boolean a(Cursor cursor, String str) {
        boolean z;
        if (cursor.moveToFirst()) {
            while (true) {
                if (!cursor.getString(cursor.getColumnIndexOrThrow(b.c.f4838b)).equalsIgnoreCase(str)) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        return !z && !b.c.f4837a.equalsIgnoreCase(str);
    }

    private static boolean a(List<org.litepal.f.b.b> list) {
        if (list.size() == 0 || (list.size() == 1 && e(list.get(0).f4815a))) {
            return true;
        }
        return list.size() == 2 && e(list.get(0).f4815a) && e(list.get(1).f4815a);
    }

    private static boolean b(Cursor cursor, String str) {
        if (!cursor.moveToFirst()) {
            return false;
        }
        while (!cursor.getString(cursor.getColumnIndexOrThrow(b.c.f4838b)).equalsIgnoreCase(str)) {
            if (!cursor.moveToNext()) {
                return false;
            }
        }
        return true;
    }

    protected static String g(String str) {
        return "drop table if exists " + str;
    }

    private static boolean h(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.US).endsWith(TrayContract.Preferences.Columns.ID) && !str.equalsIgnoreCase(TrayContract.Preferences.Columns.ID);
    }

    private static boolean i(String str) {
        return b.c.f4837a.equalsIgnoreCase(str);
    }

    /* access modifiers changed from: protected */
    public abstract void a(SQLiteDatabase sQLiteDatabase, boolean z);

    /* access modifiers changed from: protected */
    public void b(SQLiteDatabase sQLiteDatabase, boolean z) {
        for (org.litepal.f.b.a next : b()) {
            if (2 == next.d || 1 == next.d) {
                a(next.f4812a, next.f4813b, next.f4814c, sQLiteDatabase);
            } else if (3 == next.d) {
                String str = next.f4812a;
                String str2 = next.f4813b;
                ArrayList arrayList = new ArrayList();
                org.litepal.f.b.b bVar = new org.litepal.f.b.b();
                bVar.f4815a = str + TrayContract.Preferences.Columns.ID;
                bVar.f4816b = "integer";
                org.litepal.f.b.b bVar2 = new org.litepal.f.b.b();
                bVar2.f4815a = str2 + TrayContract.Preferences.Columns.ID;
                bVar2.f4816b = "integer";
                arrayList.add(bVar);
                arrayList.add(bVar2);
                String a2 = c.a(str, str2);
                ArrayList arrayList2 = new ArrayList();
                if (c.c(a2, sQLiteDatabase)) {
                    if (z) {
                        arrayList2.add(g(a2));
                    }
                    b((List<String>) arrayList2, sQLiteDatabase);
                    a(a2, 1, sQLiteDatabase);
                }
                arrayList2.add(a(a2, (List<org.litepal.f.b.b>) arrayList, false));
                b((List<String>) arrayList2, sQLiteDatabase);
                a(a2, 1, sQLiteDatabase);
            }
        }
        for (org.litepal.f.b.c next2 : this.f4723c) {
            String str3 = next2.f4818a;
            String str4 = next2.f4819b;
            String str5 = next2.f4820c;
            String str6 = next2.d;
            ArrayList arrayList3 = new ArrayList();
            org.litepal.f.b.b bVar3 = new org.litepal.f.b.b();
            bVar3.f4815a = str4;
            bVar3.f4816b = str5;
            org.litepal.f.b.b bVar4 = new org.litepal.f.b.b();
            bVar4.f4815a = str6;
            bVar4.f4816b = "integer";
            arrayList3.add(bVar3);
            arrayList3.add(bVar4);
            ArrayList arrayList4 = new ArrayList();
            if (c.c(str3, sQLiteDatabase)) {
                if (z) {
                    arrayList4.add(g(str3));
                } else {
                    b((List<String>) arrayList4, sQLiteDatabase);
                    a(str3, 2, sQLiteDatabase);
                }
            }
            arrayList4.add(a(str3, (List<org.litepal.f.b.b>) arrayList3, false));
            b((List<String>) arrayList4, sQLiteDatabase);
            a(str3, 2, sQLiteDatabase);
        }
    }
}
