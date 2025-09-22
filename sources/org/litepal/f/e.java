package org.litepal.f;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.f.b.d;
import org.litepal.g.a;

public final class e extends b {
    private Collection<d> h;

    private boolean b(String str, int i) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.h) {
            arrayList.add(dVar.f4821a);
        }
        return !a.a((Collection<String>) arrayList, str) && i == 0;
    }

    private void c() {
        List<String> d = d();
        a(d, this.e);
        a(d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r2 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (r2 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> d() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.e     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            java.lang.String r3 = "table_schema"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0063, all -> 0x0060 }
            boolean r1 = r2.moveToFirst()     // Catch:{ Exception -> 0x005e }
            if (r1 == 0) goto L_0x005b
        L_0x001a:
            java.lang.String r1 = "name"
            int r1 = r2.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x005e }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Exception -> 0x005e }
            java.lang.String r3 = "type"
            int r3 = r2.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x005e }
            int r3 = r2.getInt(r3)     // Catch:{ Exception -> 0x005e }
            java.util.List r4 = r11.e()     // Catch:{ Exception -> 0x005e }
            boolean r4 = org.litepal.g.a.a((java.util.Collection<java.lang.String>) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x005e }
            if (r4 != 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            r3 = 1
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            if (r3 == 0) goto L_0x0055
            java.lang.String r3 = "AssociationUpdater"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005e }
            java.lang.String r5 = "need to drop "
            r4.<init>(r5)     // Catch:{ Exception -> 0x005e }
            r4.append(r1)     // Catch:{ Exception -> 0x005e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x005e }
            org.litepal.g.d.a((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x005e }
            r0.add(r1)     // Catch:{ Exception -> 0x005e }
        L_0x0055:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x005e }
            if (r1 != 0) goto L_0x001a
        L_0x005b:
            if (r2 == 0) goto L_0x006f
            goto L_0x006c
        L_0x005e:
            r1 = move-exception
            goto L_0x0067
        L_0x0060:
            r0 = move-exception
            r2 = r1
            goto L_0x0071
        L_0x0063:
            r2 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x0067:
            r1.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x006f
        L_0x006c:
            r2.close()
        L_0x006f:
            return r0
        L_0x0070:
            r0 = move-exception
        L_0x0071:
            if (r2 == 0) goto L_0x0076
            r2.close()
        L_0x0076:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.f.e.d():java.util.List");
    }

    private List<String> e() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.h) {
            arrayList.add(dVar.f4821a);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final void a(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.h = a();
        this.e = sQLiteDatabase;
        List<String> d = d();
        a(d, this.e);
        a(d);
    }
}
