package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class f {
    f() {
    }

    public static String a(List<String> list) {
        return TextUtils.join("!", list);
    }

    public static List<String> a(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.io.File r0 = new java.io.File     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            java.lang.String r2 = "/data/data/"
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            java.lang.String r2 = r3.getPackageName()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            r1.append(r2)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            java.lang.String r2 = "/databases/ua.db"
            r1.append(r2)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            boolean r1 = r0.exists()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            if (r1 == 0) goto L_0x0028
            r0.delete()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
        L_0x0028:
            com.umeng.analytics.pro.d r3 = com.umeng.analytics.pro.d.a((android.content.Context) r3)     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            r3.a()     // Catch:{ Throwable -> 0x0032, all -> 0x0030 }
            return
        L_0x0030:
            r3 = move-exception
            throw r3
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.f.a(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r4 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r4 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4, android.database.sqlite.SQLiteDatabase r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r3 = "select count(*) as c from sqlite_master where type ='table' and name ='"
            r2.<init>(r3)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            r2.append(r4)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r4 = "' "
            r2.append(r4)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            java.lang.String r4 = r2.toString()     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            android.database.Cursor r4 = r5.rawQuery(r4, r1)     // Catch:{ Exception -> 0x003e, all -> 0x0037 }
            boolean r5 = r4.moveToNext()     // Catch:{ Exception -> 0x003f, all -> 0x0034 }
            if (r5 == 0) goto L_0x002e
            int r5 = r4.getInt(r0)     // Catch:{ Exception -> 0x003f, all -> 0x0034 }
            if (r5 <= 0) goto L_0x002e
            r5 = 1
            r0 = 1
        L_0x002e:
            if (r4 == 0) goto L_0x0042
        L_0x0030:
            r4.close()
            return r0
        L_0x0034:
            r5 = move-exception
            r1 = r4
            goto L_0x0038
        L_0x0037:
            r5 = move-exception
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()
        L_0x003d:
            throw r5
        L_0x003e:
            r4 = r1
        L_0x003f:
            if (r4 == 0) goto L_0x0042
            goto L_0x0030
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.f.a(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static String b(Context context) {
        return c.f3568a + context.getPackageName() + c.f3569b;
    }

    public static List<String> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String next : list) {
                if (Collections.frequency(arrayList, next) <= 0) {
                    arrayList.add(next);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
