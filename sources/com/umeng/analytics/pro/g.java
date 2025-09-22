package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3609a = 2049;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3610b = 2050;

    /* renamed from: c  reason: collision with root package name */
    private static Context f3611c = null;
    private static String d = null;
    private static final String e = "umeng+";
    private static final String f = "ek__id";
    private static final String g = "ek_key";
    private List<String> h;
    private List<Integer> i;
    private String j;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION
    }

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final g f3615a = new g();

        private b() {
        }
    }

    private g() {
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = null;
    }

    public static g a(Context context) {
        g a2 = b.f3615a;
        if (f3611c == null && context != null) {
            f3611c = context.getApplicationContext();
            a2.h();
        }
        return a2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v49, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v52, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v55, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v58, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v56, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v57, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v62, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v68, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v69, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v71, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r3v41, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v46, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARNING: type inference failed for: r3v47, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v48, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARNING: type inference failed for: r4v43, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARNING: type inference failed for: r3v50 */
    /* JADX WARNING: type inference failed for: r2v44 */
    /* JADX WARNING: type inference failed for: r3v51 */
    /* JADX WARNING: type inference failed for: r2v47 */
    /* JADX WARNING: type inference failed for: r2v49 */
    /* JADX WARNING: type inference failed for: r2v51 */
    /* JADX WARNING: type inference failed for: r2v52 */
    /* JADX WARNING: type inference failed for: r2v54 */
    /* JADX WARNING: type inference failed for: r2v55 */
    /* JADX WARNING: type inference failed for: r2v56 */
    /* JADX WARNING: type inference failed for: r2v57 */
    /* JADX WARNING: type inference failed for: r2v59 */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c2, code lost:
        if (r4 != null) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r4.endTransaction();
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01f2, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:?, code lost:
        r4.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0139, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x013a, code lost:
        r17 = r3;
        r18 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0186, code lost:
        r19 = r4;
        r4 = r3;
        r3 = r19;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0193, code lost:
        r19 = r4;
        r4 = r3;
        r3 = r19;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a8, code lost:
        if (r4 != null) goto L_0x01c4;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01df A[SYNTHETIC, Splitter:B:119:0x01df] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01f7 A[SYNTHETIC, Splitter:B:129:0x01f7] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0139 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[ExcHandler: Throwable (unused java.lang.Throwable), PHI: r2 r3 r4 
      PHI: (r2v17 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v50 android.database.Cursor) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v24 android.database.sqlite.SQLiteDatabase) = (r3v13 android.database.sqlite.SQLiteDatabase), (r3v26 android.database.sqlite.SQLiteDatabase) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v23 android.database.Cursor) = (r4v13 android.database.Cursor), (r4v51 android.database.Cursor) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:6:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[ExcHandler: SQLiteDatabaseCorruptException (unused android.database.sqlite.SQLiteDatabaseCorruptException), PHI: r2 r3 r4 
      PHI: (r2v16 ?) = (r2v0 android.database.Cursor), (r2v49 ?) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v21 android.database.sqlite.SQLiteDatabase) = (r3v13 android.database.sqlite.SQLiteDatabase), (r3v26 android.database.sqlite.SQLiteDatabase) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v20 android.database.Cursor) = (r4v13 android.database.Cursor), (r4v50 android.database.Cursor) binds: [B:6:0x0018, B:10:0x0023] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:6:0x0018] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(org.json.JSONObject r21, boolean r22) {
        /*
            r20 = this;
            r1 = r20
            r2 = 0
            android.content.Context r3 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d1, Throwable -> 0x01bb, all -> 0x01b6 }
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d1, Throwable -> 0x01bb, all -> 0x01b6 }
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x01d1, Throwable -> 0x01bb, all -> 0x01b6 }
            r3.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x01b3, Throwable -> 0x01b0, all -> 0x01ad }
            java.lang.String r4 = "select *  from __sd"
            android.database.Cursor r4 = r3.rawQuery(r4, r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x01b3, Throwable -> 0x01b0, all -> 0x01ad }
            if (r4 == 0) goto L_0x019b
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x018c }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x018c }
        L_0x001d:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x018c }
            if (r6 == 0) goto L_0x0145
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            r6.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r7 = "__f"
            int r7 = r4.getColumnIndex(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r7 = r4.getString(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r8 = "__e"
            int r8 = r4.getColumnIndex(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r8 = r4.getString(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r9 = "__ii"
            int r9 = r4.getColumnIndex(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0193, Throwable -> 0x0186, all -> 0x0139 }
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            if (r2 != 0) goto L_0x0119
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            if (r2 != 0) goto L_0x0119
            long r10 = java.lang.Long.parseLong(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            long r12 = java.lang.Long.parseLong(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            r2 = 0
            long r14 = r10 - r12
            r10 = 0
            int r2 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0110
            java.lang.String r2 = "__a"
            int r2 = r4.getColumnIndex(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r10 = "__b"
            int r10 = r4.getColumnIndex(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r10 = r4.getString(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r11 = "__c"
            int r11 = r4.getColumnIndex(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r11 = r4.getString(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r12 = "__d"
            int r12 = r4.getColumnIndex(r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r12 = r4.getString(r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.util.List<java.lang.String> r13 = r1.h     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            r13.add(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r13 = "id"
            r6.put(r13, r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r13 = "start_time"
            r6.put(r13, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r13 = "end_time"
            r6.put(r13, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            java.lang.String r13 = "duration"
            long r14 = java.lang.Long.parseLong(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            long r7 = java.lang.Long.parseLong(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x012f, Throwable -> 0x0124, all -> 0x0139 }
            r16 = 0
            r17 = r3
            r18 = r4
            long r3 = r14 - r7
            r6.put(r13, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            if (r3 != 0) goto L_0x00c8
            java.lang.String r3 = "pages"
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            java.lang.String r2 = r1.b((java.lang.String) r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r4.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r6.put(r3, r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
        L_0x00c8:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            if (r2 != 0) goto L_0x00dc
            java.lang.String r2 = "autopages"
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            java.lang.String r4 = r1.b((java.lang.String) r10)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r3.<init>(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r6.put(r2, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
        L_0x00dc:
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            if (r2 != 0) goto L_0x00f0
            java.lang.String r2 = "traffic"
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            java.lang.String r4 = r1.b((java.lang.String) r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r3.<init>(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r6.put(r2, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
        L_0x00f0:
            boolean r2 = android.text.TextUtils.isEmpty(r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            if (r2 != 0) goto L_0x0104
            java.lang.String r2 = "locations"
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            java.lang.String r4 = r1.b((java.lang.String) r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r3.<init>(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            r6.put(r2, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
        L_0x0104:
            int r2 = r6.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            if (r2 <= 0) goto L_0x0114
            r5.put(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0133, Throwable -> 0x0128, all -> 0x010e }
            goto L_0x0114
        L_0x010e:
            r0 = move-exception
            goto L_0x013e
        L_0x0110:
            r17 = r3
            r18 = r4
        L_0x0114:
            if (r22 != 0) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            r2 = r9
            goto L_0x0149
        L_0x0119:
            r17 = r3
            r18 = r4
        L_0x011d:
            r2 = r9
            r3 = r17
            r4 = r18
            goto L_0x001d
        L_0x0124:
            r17 = r3
            r18 = r4
        L_0x0128:
            r2 = r9
        L_0x0129:
            r4 = r17
            r3 = r18
            goto L_0x01bd
        L_0x012f:
            r17 = r3
            r18 = r4
        L_0x0133:
            r4 = r17
            r2 = r18
            goto L_0x01d3
        L_0x0139:
            r0 = move-exception
            r17 = r3
            r18 = r4
        L_0x013e:
            r2 = r0
            r4 = r17
            r3 = r18
            goto L_0x01f0
        L_0x0145:
            r17 = r3
            r18 = r4
        L_0x0149:
            java.util.List<java.lang.String> r3 = r1.h     // Catch:{ SQLiteDatabaseCorruptException -> 0x0181, Throwable -> 0x0129, all -> 0x017b }
            int r3 = r3.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0181, Throwable -> 0x0129, all -> 0x017b }
            if (r3 > 0) goto L_0x0169
            if (r18 == 0) goto L_0x0158
            r3 = r18
            r3.close()
        L_0x0158:
            if (r17 == 0) goto L_0x015f
            r4 = r17
            r4.endTransaction()     // Catch:{ Throwable -> 0x015f }
        L_0x015f:
            android.content.Context r3 = f3611c
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            return r2
        L_0x0169:
            r4 = r17
            r3 = r18
            int r6 = r5.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0198, Throwable -> 0x01bd, all -> 0x01ab }
            if (r6 <= 0) goto L_0x01a0
            java.lang.String r6 = "sessions"
            r7 = r21
            r7.put(r6, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0198, Throwable -> 0x01bd, all -> 0x01ab }
            goto L_0x01a0
        L_0x017b:
            r0 = move-exception
            r4 = r17
            r3 = r18
            goto L_0x01b9
        L_0x0181:
            r4 = r17
            r3 = r18
            goto L_0x0198
        L_0x0186:
            r19 = r4
            r4 = r3
            r3 = r19
            goto L_0x01bd
        L_0x018c:
            r0 = move-exception
            r19 = r4
            r4 = r3
            r3 = r19
            goto L_0x01b9
        L_0x0193:
            r19 = r4
            r4 = r3
            r3 = r19
        L_0x0198:
            r9 = r2
            r2 = r3
            goto L_0x01d3
        L_0x019b:
            r19 = r4
            r4 = r3
            r3 = r19
        L_0x01a0:
            r4.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0198, Throwable -> 0x01bd, all -> 0x01ab }
            if (r3 == 0) goto L_0x01a8
            r3.close()
        L_0x01a8:
            if (r4 == 0) goto L_0x01c7
            goto L_0x01c4
        L_0x01ab:
            r0 = move-exception
            goto L_0x01b9
        L_0x01ad:
            r0 = move-exception
            r4 = r3
            goto L_0x01ee
        L_0x01b0:
            r4 = r3
            r3 = r2
            goto L_0x01bd
        L_0x01b3:
            r4 = r3
            r9 = r2
            goto L_0x01d3
        L_0x01b6:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x01b9:
            r2 = r0
            goto L_0x01f0
        L_0x01bb:
            r3 = r2
            r4 = r3
        L_0x01bd:
            if (r3 == 0) goto L_0x01c2
            r3.close()
        L_0x01c2:
            if (r4 == 0) goto L_0x01c7
        L_0x01c4:
            r4.endTransaction()     // Catch:{ Throwable -> 0x01c7 }
        L_0x01c7:
            android.content.Context r3 = f3611c
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            return r2
        L_0x01d1:
            r4 = r2
            r9 = r4
        L_0x01d3:
            android.content.Context r3 = f3611c     // Catch:{ all -> 0x01ed }
            com.umeng.analytics.pro.f.a((android.content.Context) r3)     // Catch:{ all -> 0x01ed }
            if (r2 == 0) goto L_0x01dd
            r2.close()
        L_0x01dd:
            if (r4 == 0) goto L_0x01e2
            r4.endTransaction()     // Catch:{ Throwable -> 0x01e2 }
        L_0x01e2:
            android.content.Context r2 = f3611c
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)
            r2.b()
            r2 = r9
            return r2
        L_0x01ed:
            r0 = move-exception
        L_0x01ee:
            r3 = r2
            goto L_0x01b9
        L_0x01f0:
            if (r3 == 0) goto L_0x01f5
            r3.close()
        L_0x01f5:
            if (r4 == 0) goto L_0x01fa
            r4.endTransaction()     // Catch:{ Throwable -> 0x01fa }
        L_0x01fa:
            android.content.Context r3 = f3611c
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6, org.json.JSONObject r7, android.database.sqlite.SQLiteDatabase r8) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "__d"
            org.json.JSONObject r1 = r7.getJSONObject(r1)     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            if (r1 == 0) goto L_0x0037
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            java.lang.String r3 = "select __d from __sd where __ii=\""
            r2.<init>(r3)     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            r2.append(r6)     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            android.database.Cursor r2 = r8.rawQuery(r2, r0)     // Catch:{ Throwable -> 0x00e6, all -> 0x00de }
            if (r2 == 0) goto L_0x0038
        L_0x0022:
            boolean r3 = r2.moveToNext()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r3 == 0) goto L_0x0038
            java.lang.String r0 = "__d"
            int r0 = r2.getColumnIndex(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r5.b((java.lang.String) r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            goto L_0x0022
        L_0x0037:
            r2 = r0
        L_0x0038:
            if (r1 == 0) goto L_0x007c
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r3.<init>()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r4 != 0) goto L_0x004a
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
        L_0x004a:
            r3.put(r1)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r3.toString()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r5.a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r1 != 0) goto L_0x007c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r3 = "update  __sd set __d=\""
            r1.<init>(r3)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = "\" where __ii=\""
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r1.append(r6)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = "\""
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r8.execSQL(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r6 = move-exception
            goto L_0x00e0
        L_0x007c:
            java.lang.String r0 = "__c"
            org.json.JSONObject r0 = r7.getJSONObject(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r5.a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r1 != 0) goto L_0x00b0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r3 = "update  __sd set __c=\""
            r1.<init>(r3)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = "\" where __ii=\""
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r1.append(r6)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = "\""
            r1.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = r1.toString()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r8.execSQL(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
        L_0x00b0:
            java.lang.String r0 = "__f"
            long r0 = r7.getLong(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r3 = "update  __sd set __f=\""
            r7.<init>(r3)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r7.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r0 = "\" where __ii=\""
            r7.append(r0)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r7.append(r6)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r6 = "\""
            r7.append(r6)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            java.lang.String r6 = r7.toString()     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            r8.execSQL(r6)     // Catch:{ Throwable -> 0x00e7, all -> 0x007a }
            if (r2 == 0) goto L_0x00ec
            r2.close()
            return
        L_0x00de:
            r6 = move-exception
            r2 = r0
        L_0x00e0:
            if (r2 == 0) goto L_0x00e5
            r2.close()
        L_0x00e5:
            throw r6
        L_0x00e6:
            r2 = r0
        L_0x00e7:
            if (r2 == 0) goto L_0x00ec
            r2.close()
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r5, org.json.JSONObject r6, android.database.sqlite.SQLiteDatabase r7, java.lang.String r8) throws org.json.JSONException {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            java.lang.String r2 = "select "
            r1.<init>(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            r1.append(r8)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            java.lang.String r2 = " from __sd where __ii=\""
            r1.append(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            r1.append(r5)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            java.lang.String r2 = "\""
            r1.append(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            android.database.Cursor r1 = r7.rawQuery(r1, r0)     // Catch:{ Throwable -> 0x008e, all -> 0x0086 }
            if (r1 == 0) goto L_0x0037
        L_0x0022:
            boolean r2 = r1.moveToNext()     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            if (r2 == 0) goto L_0x0037
            int r0 = r1.getColumnIndex(r8)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r0 = r4.b((java.lang.String) r0)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            goto L_0x0022
        L_0x0035:
            r5 = move-exception
            goto L_0x0088
        L_0x0037:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r2.<init>()     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            if (r3 != 0) goto L_0x0047
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r2.<init>(r0)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
        L_0x0047:
            r2.put(r6)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r6 = r2.toString()     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r6 = r4.a((java.lang.String) r6)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            if (r0 != 0) goto L_0x007e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r2 = "update __sd set "
            r0.<init>(r2)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r0.append(r8)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r8 = "=\""
            r0.append(r8)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r0.append(r6)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r6 = "\" where __ii=\""
            r0.append(r6)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r0.append(r5)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r5 = "\""
            r0.append(r5)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            java.lang.String r5 = r0.toString()     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
            r7.execSQL(r5)     // Catch:{ Throwable -> 0x0084, all -> 0x0035 }
        L_0x007e:
            if (r1 == 0) goto L_0x0093
            r1.close()
            return
        L_0x0084:
            r0 = r1
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            r1 = r0
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()
        L_0x008d:
            throw r5
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            r0.close()
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0166, code lost:
        if (r1 != null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0183, code lost:
        if (r1 != null) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0191, code lost:
        if (r1 == null) goto L_0x016b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0187 */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x019d A[SYNTHETIC, Splitter:B:94:0x019d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r10, java.lang.String r11) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0186, Throwable -> 0x017d, all -> 0x0179 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0186, Throwable -> 0x017d, all -> 0x0179 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0186, Throwable -> 0x017d, all -> 0x0179 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            java.lang.String r2 = "select *  from __et"
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            if (r3 != 0) goto L_0x0029
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            java.lang.String r3 = "select *  from __et where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            r2.append(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            java.lang.String r11 = "\""
            r2.append(r11)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
        L_0x0029:
            android.database.Cursor r11 = r1.rawQuery(r2, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0187, Throwable -> 0x017e }
            if (r11 == 0) goto L_0x015e
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r0.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            com.umeng.analytics.pro.o r3 = com.umeng.analytics.pro.o.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r3 = r3.c()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x0041:
            boolean r4 = r11.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r4 == 0) goto L_0x00d9
            java.lang.String r4 = "__t"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            int r4 = r11.getInt(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r5 = "__i"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r5 = r11.getString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = "__s"
            int r6 = r11.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = r11.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r7 != 0) goto L_0x0073
            java.lang.String r7 = "-1"
            boolean r7 = r7.equals(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r7 == 0) goto L_0x007a
        L_0x0073:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r5 != 0) goto L_0x0041
            r5 = r3
        L_0x007a:
            r7 = 0
            int r7 = r11.getInt(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.util.List<java.lang.Integer> r8 = r9.i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r8.add(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            switch(r4) {
                case 2049: goto L_0x00b2;
                case 2050: goto L_0x008c;
                default: goto L_0x008b;
            }     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x008b:
            goto L_0x0041
        L_0x008c:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r4 != 0) goto L_0x0041
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = r9.b((java.lang.String) r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r4.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            boolean r6 = r2.has(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r6 == 0) goto L_0x00a6
            org.json.JSONArray r6 = r2.optJSONArray(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x00ab
        L_0x00a6:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r6.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x00ab:
            r6.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x0041
        L_0x00b2:
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r4 != 0) goto L_0x0041
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = r9.b((java.lang.String) r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r4.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            boolean r6 = r0.has(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r6 == 0) goto L_0x00cc
            org.json.JSONArray r6 = r0.optJSONArray(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x00d1
        L_0x00cc:
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r6.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x00d1:
            r6.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r0.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x0041
        L_0x00d9:
            int r3 = r0.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r3 <= 0) goto L_0x011a
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.util.Iterator r4 = r0.keys()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x00e8:
            boolean r5 = r4.hasNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r5 == 0) goto L_0x010f
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.Object r6 = r4.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r7 = r0.optString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r8.<init>(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r5.put(r6, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            int r6 = r5.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r6 <= 0) goto L_0x00e8
            r3.put(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x00e8
        L_0x010f:
            int r0 = r3.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r0 <= 0) goto L_0x011a
            java.lang.String r0 = "ekv"
            r10.put(r0, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x011a:
            int r0 = r2.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r0 <= 0) goto L_0x015e
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r0.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.util.Iterator r3 = r2.keys()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
        L_0x0129:
            boolean r4 = r3.hasNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r4 == 0) goto L_0x0150
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.Object r5 = r3.next()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            java.lang.String r6 = r2.optString(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r7.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            r4.put(r5, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            int r5 = r4.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r5 <= 0) goto L_0x0129
            r0.put(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x0129
        L_0x0150:
            int r2 = r0.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r2 <= 0) goto L_0x015e
            java.lang.String r2 = "gkv"
            r10.put(r2, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            goto L_0x015e
        L_0x015c:
            r10 = move-exception
            goto L_0x0196
        L_0x015e:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0177, Throwable -> 0x0175, all -> 0x015c }
            if (r11 == 0) goto L_0x0166
            r11.close()
        L_0x0166:
            if (r1 == 0) goto L_0x016b
        L_0x0168:
            r1.endTransaction()     // Catch:{ Throwable -> 0x016b }
        L_0x016b:
            android.content.Context r10 = f3611c
            com.umeng.analytics.pro.e r10 = com.umeng.analytics.pro.e.a(r10)
            r10.b()
            return
        L_0x0175:
            r0 = r11
            goto L_0x017e
        L_0x0177:
            r0 = r11
            goto L_0x0187
        L_0x0179:
            r10 = move-exception
            r11 = r0
            r1 = r11
            goto L_0x0196
        L_0x017d:
            r1 = r0
        L_0x017e:
            if (r0 == 0) goto L_0x0183
            r0.close()
        L_0x0183:
            if (r1 == 0) goto L_0x016b
            goto L_0x0168
        L_0x0186:
            r1 = r0
        L_0x0187:
            android.content.Context r10 = f3611c     // Catch:{ all -> 0x0194 }
            com.umeng.analytics.pro.f.a((android.content.Context) r10)     // Catch:{ all -> 0x0194 }
            if (r0 == 0) goto L_0x0191
            r0.close()
        L_0x0191:
            if (r1 == 0) goto L_0x016b
            goto L_0x0168
        L_0x0194:
            r10 = move-exception
            r11 = r0
        L_0x0196:
            if (r11 == 0) goto L_0x019b
            r11.close()
        L_0x019b:
            if (r1 == 0) goto L_0x01a0
            r1.endTransaction()     // Catch:{ Throwable -> 0x01a0 }
        L_0x01a0:
            android.content.Context r11 = f3611c
            com.umeng.analytics.pro.e r11 = com.umeng.analytics.pro.e.a(r11)
            r11.b()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006e, code lost:
        if (r1 != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008a, code lost:
        if (r1 != null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0098, code lost:
        if (r1 == null) goto L_0x0073;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3 A[SYNTHETIC, Splitter:B:53:0x00a3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(org.json.JSONObject r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x0084, all -> 0x0081 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x0084, all -> 0x0081 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008d, Throwable -> 0x0084, all -> 0x0081 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            java.lang.String r2 = "select *  from __er"
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            if (r3 != 0) goto L_0x0029
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            java.lang.String r3 = "select *  from __er where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            r2.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            java.lang.String r6 = "\""
            r2.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
        L_0x0029:
            android.database.Cursor r6 = r1.rawQuery(r2, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008e, Throwable -> 0x0085 }
            if (r6 == 0) goto L_0x0066
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            r0.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
        L_0x0034:
            boolean r2 = r6.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            if (r2 == 0) goto L_0x0057
            java.lang.String r2 = "__a"
            int r2 = r6.getColumnIndex(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            java.lang.String r2 = r6.getString(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            if (r3 != 0) goto L_0x0034
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            java.lang.String r2 = r4.b((java.lang.String) r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            r3.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            r0.put(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            goto L_0x0034
        L_0x0057:
            int r2 = r0.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            if (r2 <= 0) goto L_0x0066
            java.lang.String r2 = "error"
            r5.put(r2, r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            goto L_0x0066
        L_0x0063:
            r5 = move-exception
            r0 = r6
            goto L_0x009c
        L_0x0066:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x007f, Throwable -> 0x007d, all -> 0x0063 }
            if (r6 == 0) goto L_0x006e
            r6.close()
        L_0x006e:
            if (r1 == 0) goto L_0x0073
        L_0x0070:
            r1.endTransaction()     // Catch:{ Throwable -> 0x0073 }
        L_0x0073:
            android.content.Context r5 = f3611c
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            return
        L_0x007d:
            r0 = r6
            goto L_0x0085
        L_0x007f:
            r0 = r6
            goto L_0x008e
        L_0x0081:
            r5 = move-exception
            r1 = r0
            goto L_0x009c
        L_0x0084:
            r1 = r0
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            if (r1 == 0) goto L_0x0073
            goto L_0x0070
        L_0x008d:
            r1 = r0
        L_0x008e:
            android.content.Context r5 = f3611c     // Catch:{ all -> 0x009b }
            com.umeng.analytics.pro.f.a((android.content.Context) r5)     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x0098
            r0.close()
        L_0x0098:
            if (r1 == 0) goto L_0x0073
            goto L_0x0070
        L_0x009b:
            r5 = move-exception
        L_0x009c:
            if (r0 == 0) goto L_0x00a1
            r0.close()
        L_0x00a1:
            if (r1 == 0) goto L_0x00a6
            r1.endTransaction()     // Catch:{ Throwable -> 0x00a6 }
        L_0x00a6:
            android.content.Context r6 = f3611c
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(org.json.JSONObject, java.lang.String):void");
    }

    private void h() {
        synchronized (this) {
            i();
            this.h.clear();
        }
    }

    private void i() {
        try {
            if (TextUtils.isEmpty(d)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3611c);
                String string = sharedPreferences.getString(f, (String) null);
                if (TextUtils.isEmpty(string)) {
                    string = DeviceConfig.getDBencryptID(f3611c);
                    if (!TextUtils.isEmpty(string)) {
                        sharedPreferences.edit().putString(f, string).commit();
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    String substring = string.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < substring.length(); i2++) {
                        char charAt = substring.charAt(i2);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    d = sb.toString();
                }
                if (!TextUtils.isEmpty(d)) {
                    d += new StringBuilder(d).reverse().toString();
                    String string2 = sharedPreferences.getString(g, (String) null);
                    if (TextUtils.isEmpty(string2)) {
                        sharedPreferences.edit().putString(g, a(e)).commit();
                    } else if (!e.equals(b(string2))) {
                        a(true, false);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(d) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), d.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(boolean z) {
        String a2;
        a();
        this.i.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            a2 = null;
        } else {
            a2 = a(jSONObject, z);
            if (TextUtils.isEmpty(a2)) {
                return jSONObject;
            }
        }
        b(jSONObject, a2);
        a(jSONObject, a2);
        return jSONObject;
    }

    public void a() {
        this.h.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004d, code lost:
        if (r0 != null) goto L_0x0044;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c A[SYNTHETIC, Splitter:B:16:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[SYNTHETIC, Splitter:B:36:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r3) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0048, Throwable -> 0x0042 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0048, Throwable -> 0x0042 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0048, Throwable -> 0x0042 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x003d, Throwable -> 0x003b, all -> 0x0039 }
            if (r3 != 0) goto L_0x0016
            java.lang.String r3 = "delete from __dp where __ty=0"
        L_0x0012:
            r1.execSQL(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x003d, Throwable -> 0x003b, all -> 0x0039 }
            goto L_0x0027
        L_0x0016:
            r0 = 4
            if (r3 != r0) goto L_0x0021
            java.lang.String r3 = "delete from __dp where __ty=3"
            r1.execSQL(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x003d, Throwable -> 0x003b, all -> 0x0039 }
            java.lang.String r3 = "delete from __dp where __ty=2"
            goto L_0x0012
        L_0x0021:
            r0 = 1
            if (r3 != r0) goto L_0x0027
            java.lang.String r3 = "delete from __dp where __ty=1"
            goto L_0x0012
        L_0x0027:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x003d, Throwable -> 0x003b, all -> 0x0039 }
            if (r1 == 0) goto L_0x002f
            r1.endTransaction()     // Catch:{ Throwable -> 0x002f }
        L_0x002f:
            android.content.Context r3 = f3611c
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            return
        L_0x0039:
            r3 = move-exception
            goto L_0x0050
        L_0x003b:
            r0 = r1
            goto L_0x0042
        L_0x003d:
            r0 = r1
            goto L_0x0048
        L_0x003f:
            r3 = move-exception
            r1 = r0
            goto L_0x0050
        L_0x0042:
            if (r0 == 0) goto L_0x002f
        L_0x0044:
            r0.endTransaction()     // Catch:{ Throwable -> 0x002f }
            goto L_0x002f
        L_0x0048:
            android.content.Context r3 = f3611c     // Catch:{ all -> 0x003f }
            com.umeng.analytics.pro.f.a((android.content.Context) r3)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x002f
            goto L_0x0044
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.endTransaction()     // Catch:{ Throwable -> 0x0055 }
        L_0x0055:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        if (r0 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        if (r0 != null) goto L_0x009d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a1 */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[SYNTHETIC, Splitter:B:41:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONArray r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r2 = 0
        L_0x000f:
            int r3 = r8.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            if (r2 >= r3) goto L_0x0080
            org.json.JSONObject r3 = r8.getJSONObject(r2)     // Catch:{ Exception -> 0x007d }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x007d }
            r4.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__i"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x007d }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x007d }
            if (r6 != 0) goto L_0x0032
            java.lang.String r6 = "-1"
            boolean r6 = r6.equals(r5)     // Catch:{ Exception -> 0x007d }
            if (r6 == 0) goto L_0x0042
        L_0x0032:
            com.umeng.analytics.pro.o r5 = com.umeng.analytics.pro.o.a()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r5.c()     // Catch:{ Exception -> 0x007d }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x007d }
            if (r6 == 0) goto L_0x0042
            java.lang.String r5 = "-1"
        L_0x0042:
            java.lang.String r6 = "__i"
            r4.put(r6, r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__e"
            java.lang.String r6 = "id"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x007d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__t"
            java.lang.String r6 = "__t"
            int r6 = r3.optInt(r6)     // Catch:{ Exception -> 0x007d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x007d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__i"
            r3.remove(r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__t"
            r3.remove(r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "__s"
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = r7.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007d }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = "__et"
            r1.insert(r3, r0, r4)     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0080:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            if (r1 == 0) goto L_0x0088
            r1.endTransaction()     // Catch:{ Throwable -> 0x0088 }
        L_0x0088:
            android.content.Context r8 = f3611c
            com.umeng.analytics.pro.e r8 = com.umeng.analytics.pro.e.a(r8)
            r8.b()
            return
        L_0x0092:
            r8 = move-exception
            goto L_0x00a9
        L_0x0094:
            r0 = r1
            goto L_0x009b
        L_0x0096:
            r0 = r1
            goto L_0x00a1
        L_0x0098:
            r8 = move-exception
            r1 = r0
            goto L_0x00a9
        L_0x009b:
            if (r0 == 0) goto L_0x0088
        L_0x009d:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0088 }
            goto L_0x0088
        L_0x00a1:
            android.content.Context r8 = f3611c     // Catch:{ all -> 0x0098 }
            com.umeng.analytics.pro.f.a((android.content.Context) r8)     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0088
            goto L_0x009d
        L_0x00a9:
            if (r1 == 0) goto L_0x00ae
            r1.endTransaction()     // Catch:{ Throwable -> 0x00ae }
        L_0x00ae:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONArray):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007d, code lost:
        if (r0 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
        if (r0 != null) goto L_0x007f;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d A[SYNTHETIC, Splitter:B:29:0x008d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.json.JSONObject r12, int r13) {
        /*
            r11 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, Throwable -> 0x007d }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, Throwable -> 0x007d }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0083, Throwable -> 0x007d }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r3 = "__ii"
            java.lang.String r3 = r12.optString(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r4 = "__id"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r7 = 10000(0x2710, double:4.9407E-320)
            long r9 = r5 - r7
            java.lang.Long r5 = java.lang.Long.valueOf(r9)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r2.put(r4, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r4 = "__ii"
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            if (r5 == 0) goto L_0x0034
            java.lang.String r3 = "-1"
        L_0x0034:
            r2.put(r4, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r3 = "__ii"
            r12.remove(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r3 = "__io"
            java.lang.String r12 = r12.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r12 = r11.a((java.lang.String) r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r2.put(r3, r12)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r12 = "__ty"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r2.put(r12, r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r12 = "__ve"
            android.content.Context r13 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r13 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r2.put(r12, r13)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            java.lang.String r12 = "__dp"
            r1.insert(r12, r0, r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0078, Throwable -> 0x0076, all -> 0x0074 }
            if (r1 == 0) goto L_0x006a
            r1.endTransaction()     // Catch:{ Throwable -> 0x006a }
        L_0x006a:
            android.content.Context r12 = f3611c
            com.umeng.analytics.pro.e r12 = com.umeng.analytics.pro.e.a(r12)
            r12.b()
            return
        L_0x0074:
            r12 = move-exception
            goto L_0x008b
        L_0x0076:
            r0 = r1
            goto L_0x007d
        L_0x0078:
            r0 = r1
            goto L_0x0083
        L_0x007a:
            r12 = move-exception
            r1 = r0
            goto L_0x008b
        L_0x007d:
            if (r0 == 0) goto L_0x006a
        L_0x007f:
            r0.endTransaction()     // Catch:{ Throwable -> 0x006a }
            goto L_0x006a
        L_0x0083:
            android.content.Context r12 = f3611c     // Catch:{ all -> 0x007a }
            com.umeng.analytics.pro.f.a((android.content.Context) r12)     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x006a
            goto L_0x007f
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            r1.endTransaction()     // Catch:{ Throwable -> 0x0090 }
        L_0x0090:
            android.content.Context r13 = f3611c
            com.umeng.analytics.pro.e r13 = com.umeng.analytics.pro.e.a(r13)
            r13.b()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(org.json.JSONObject, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (r0 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a6, code lost:
        if (r0 != null) goto L_0x009d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a1 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab A[SYNTHETIC, Splitter:B:31:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r4.j = r6     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009b }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            if (r2 != 0) goto L_0x0080
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r3 = "delete from __er where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r2.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r1.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r3 = "delete from __et where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r2.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r1.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            if (r5 == 0) goto L_0x0080
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = "update __sd set __b=\""
            r5.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r5.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = "\" where __ii=\""
            r5.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r5.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = "\""
            r5.append(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r1.execSQL(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r2 = "update __sd set __a=\""
            r5.<init>(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r5.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r0 = "\" where __ii=\""
            r5.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r5.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            r1.execSQL(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
        L_0x0080:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0096, Throwable -> 0x0094, all -> 0x0092 }
            if (r1 == 0) goto L_0x0088
            r1.endTransaction()     // Catch:{ Throwable -> 0x0088 }
        L_0x0088:
            android.content.Context r5 = f3611c
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            return
        L_0x0092:
            r5 = move-exception
            goto L_0x00a9
        L_0x0094:
            r0 = r1
            goto L_0x009b
        L_0x0096:
            r0 = r1
            goto L_0x00a1
        L_0x0098:
            r5 = move-exception
            r1 = r0
            goto L_0x00a9
        L_0x009b:
            if (r0 == 0) goto L_0x0088
        L_0x009d:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0088 }
            goto L_0x0088
        L_0x00a1:
            android.content.Context r5 = f3611c     // Catch:{ all -> 0x0098 }
            com.umeng.analytics.pro.f.a((android.content.Context) r5)     // Catch:{ all -> 0x0098 }
            if (r0 == 0) goto L_0x0088
            goto L_0x009d
        L_0x00a9:
            if (r1 == 0) goto L_0x00ae
            r1.endTransaction()     // Catch:{ Throwable -> 0x00ae }
        L_0x00ae:
            android.content.Context r6 = f3611c
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0070, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075 A[SYNTHETIC, Splitter:B:36:0x0075] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x006b, Throwable -> 0x0065 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x006b, Throwable -> 0x0065 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x006b, Throwable -> 0x0065 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            if (r4 == 0) goto L_0x0018
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = "delete from __sd"
            r1.execSQL(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            goto L_0x004a
        L_0x0018:
            java.util.List<java.lang.String> r3 = r2.h     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            int r3 = r3.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            if (r3 <= 0) goto L_0x004a
            r3 = 0
        L_0x0021:
            java.util.List<java.lang.String> r4 = r2.h     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            int r4 = r4.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            if (r3 >= r4) goto L_0x004a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.lang.String r0 = "delete from __sd where __ii=\""
            r4.<init>(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.util.List<java.lang.String> r0 = r2.h     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            r4.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.lang.String r0 = "\""
            r4.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            r1.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            int r3 = r3 + 1
            goto L_0x0021
        L_0x004a:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0060, Throwable -> 0x005e, all -> 0x005c }
            if (r1 == 0) goto L_0x0052
            r1.endTransaction()     // Catch:{ Throwable -> 0x0052 }
        L_0x0052:
            android.content.Context r3 = f3611c
            com.umeng.analytics.pro.e r3 = com.umeng.analytics.pro.e.a(r3)
            r3.b()
            return
        L_0x005c:
            r3 = move-exception
            goto L_0x0073
        L_0x005e:
            r0 = r1
            goto L_0x0065
        L_0x0060:
            r0 = r1
            goto L_0x006b
        L_0x0062:
            r3 = move-exception
            r1 = r0
            goto L_0x0073
        L_0x0065:
            if (r0 == 0) goto L_0x0052
        L_0x0067:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0052 }
            goto L_0x0052
        L_0x006b:
            android.content.Context r3 = f3611c     // Catch:{ all -> 0x0062 }
            com.umeng.analytics.pro.f.a((android.content.Context) r3)     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0052
            goto L_0x0067
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            r1.endTransaction()     // Catch:{ Throwable -> 0x0078 }
        L_0x0078:
            android.content.Context r4 = f3611c
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r0 != null) goto L_0x0049;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0056 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[SYNTHETIC, Splitter:B:29:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0056, Throwable -> 0x0047 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0056, Throwable -> 0x0047 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0056, Throwable -> 0x0047 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            r2.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            java.lang.String r5 = r4.a((java.lang.String) r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            if (r6 != 0) goto L_0x0035
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            r2.put(r5, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
        L_0x0035:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0042, Throwable -> 0x0040, all -> 0x003e }
            if (r1 == 0) goto L_0x004c
            r1.endTransaction()     // Catch:{ Throwable -> 0x004c }
            goto L_0x004c
        L_0x003e:
            r5 = move-exception
            goto L_0x0060
        L_0x0040:
            r0 = r1
            goto L_0x0047
        L_0x0042:
            r0 = r1
            goto L_0x0056
        L_0x0044:
            r5 = move-exception
            r1 = r0
            goto L_0x0060
        L_0x0047:
            if (r0 == 0) goto L_0x004c
        L_0x0049:
            r0.endTransaction()     // Catch:{ Throwable -> 0x004c }
        L_0x004c:
            android.content.Context r5 = f3611c
            com.umeng.analytics.pro.e r5 = com.umeng.analytics.pro.e.a(r5)
            r5.b()
            goto L_0x005e
        L_0x0056:
            android.content.Context r5 = f3611c     // Catch:{ all -> 0x0044 }
            com.umeng.analytics.pro.f.a((android.content.Context) r5)     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x004c
            goto L_0x0049
        L_0x005e:
            r5 = 0
            return r5
        L_0x0060:
            if (r1 == 0) goto L_0x0065
            r1.endTransaction()     // Catch:{ Throwable -> 0x0065 }
        L_0x0065:
            android.content.Context r6 = f3611c
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0094, code lost:
        if (r1 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0096, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a8, code lost:
        if (r1 != null) goto L_0x0096;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[SYNTHETIC, Splitter:B:45:0x00ae] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, org.json.JSONObject r7, com.umeng.analytics.pro.g.a r8) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            android.content.Context r2 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a3, Throwable -> 0x0094 }
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a3, Throwable -> 0x0094 }
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a3, Throwable -> 0x0094 }
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            com.umeng.analytics.pro.g$a r3 = com.umeng.analytics.pro.g.a.BEGIN     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r8 != r3) goto L_0x003b
            java.lang.String r8 = "__e"
            java.lang.Object r7 = r7.get(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            long r7 = r7.longValue()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            r3.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r4 = "__ii"
            r3.put(r4, r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r6 = "__e"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            r3.put(r6, r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r6 = "__sd"
            r2.insert(r6, r1, r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            goto L_0x0082
        L_0x003b:
            com.umeng.analytics.pro.g$a r1 = com.umeng.analytics.pro.g.a.END     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r8 != r1) goto L_0x006a
            java.lang.String r8 = "__f"
            java.lang.Object r7 = r7.get(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            long r7 = r7.longValue()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r3 = "update __sd set __f=\""
            r1.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            r1.append(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r7 = "\" where __ii=\""
            r1.append(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            r1.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r6 = "\""
            r1.append(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            java.lang.String r6 = r1.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            r2.execSQL(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            goto L_0x0082
        L_0x006a:
            com.umeng.analytics.pro.g$a r1 = com.umeng.analytics.pro.g.a.PAGE     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r8 != r1) goto L_0x0074
            java.lang.String r8 = "__a"
        L_0x0070:
            r5.a(r6, r7, r2, r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            goto L_0x0082
        L_0x0074:
            com.umeng.analytics.pro.g$a r1 = com.umeng.analytics.pro.g.a.AUTOPAGE     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r8 != r1) goto L_0x007b
            java.lang.String r8 = "__b"
            goto L_0x0070
        L_0x007b:
            com.umeng.analytics.pro.g$a r1 = com.umeng.analytics.pro.g.a.NEWSESSION     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r8 != r1) goto L_0x0082
            r5.a((java.lang.String) r6, (org.json.JSONObject) r7, (android.database.sqlite.SQLiteDatabase) r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
        L_0x0082:
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x008f, Throwable -> 0x008d, all -> 0x008b }
            if (r2 == 0) goto L_0x0099
            r2.endTransaction()     // Catch:{ Throwable -> 0x0099 }
            goto L_0x0099
        L_0x008b:
            r6 = move-exception
            goto L_0x00ac
        L_0x008d:
            r1 = r2
            goto L_0x0094
        L_0x008f:
            r1 = r2
            goto L_0x00a3
        L_0x0091:
            r6 = move-exception
            r2 = r1
            goto L_0x00ac
        L_0x0094:
            if (r1 == 0) goto L_0x0099
        L_0x0096:
            r1.endTransaction()     // Catch:{ Throwable -> 0x0099 }
        L_0x0099:
            android.content.Context r6 = f3611c
            com.umeng.analytics.pro.e r6 = com.umeng.analytics.pro.e.a(r6)
            r6.b()
            return r0
        L_0x00a3:
            android.content.Context r6 = f3611c     // Catch:{ all -> 0x0091 }
            com.umeng.analytics.pro.f.a((android.content.Context) r6)     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0099
            goto L_0x0096
            return r0
        L_0x00ac:
            if (r2 == 0) goto L_0x00b1
            r2.endTransaction()     // Catch:{ Throwable -> 0x00b1 }
        L_0x00b1:
            android.content.Context r7 = f3611c
            com.umeng.analytics.pro.e r7 = com.umeng.analytics.pro.e.a(r7)
            r7.b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.g$a):boolean");
    }

    public String b(String str) {
        try {
            return TextUtils.isEmpty(d) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), d.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        if (r0 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0076, code lost:
        if (r0 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[SYNTHETIC, Splitter:B:35:0x007b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x006d=Splitter:B:29:0x006d, B:7:0x001e=Splitter:B:7:0x001e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006b }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006b }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0071, Throwable -> 0x006b }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            com.umeng.analytics.pro.o r0 = com.umeng.analytics.pro.o.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r0 = r0.d()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            if (r2 == 0) goto L_0x002b
            if (r1 == 0) goto L_0x0021
        L_0x001e:
            r1.endTransaction()     // Catch:{ Throwable -> 0x0021 }
        L_0x0021:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            return
        L_0x002b:
            java.lang.String r2 = ""
            java.lang.String r3 = "-1"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            r3 = 0
        L_0x0034:
            r4 = 2
            if (r3 >= r4) goto L_0x005a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r5 = "update __et set __i=\""
            r4.<init>(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            r4.append(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r5 = "\" where __i=\""
            r4.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            r5 = r2[r3]     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            r4.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r5 = "\""
            r4.append(r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            r1.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            int r3 = r3 + 1
            goto L_0x0034
        L_0x005a:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0064, Throwable -> 0x0062, all -> 0x0060 }
            if (r1 == 0) goto L_0x0021
            goto L_0x001e
        L_0x0060:
            r0 = move-exception
            goto L_0x0079
        L_0x0062:
            r0 = r1
            goto L_0x006b
        L_0x0064:
            r0 = r1
            goto L_0x0071
        L_0x0066:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0079
        L_0x006b:
            if (r0 == 0) goto L_0x0021
        L_0x006d:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0021 }
            goto L_0x0021
        L_0x0071:
            android.content.Context r1 = f3611c     // Catch:{ all -> 0x0066 }
            com.umeng.analytics.pro.f.a((android.content.Context) r1)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0021
            goto L_0x006d
        L_0x0079:
            if (r1 == 0) goto L_0x007e
            r1.endTransaction()     // Catch:{ Throwable -> 0x007e }
        L_0x007e:
            android.content.Context r1 = f3611c
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        if (r0 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0062, code lost:
        if (r0 != null) goto L_0x0059;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x005d */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0067 A[SYNTHETIC, Splitter:B:44:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x005d, Throwable -> 0x0057 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x005d, Throwable -> 0x0057 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x005d, Throwable -> 0x0057 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0052, Throwable -> 0x0050, all -> 0x004e }
            java.lang.String r0 = "delete from __dp"
            r2 = -1
            if (r4 != r2) goto L_0x0017
            r1.execSQL(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0052, Throwable -> 0x0050, all -> 0x004e }
            goto L_0x003c
        L_0x0017:
            r0 = 1
            if (r4 != r0) goto L_0x0020
            java.lang.String r4 = "delete from __dp where __ty=1"
        L_0x001c:
            r1.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0052, Throwable -> 0x0050, all -> 0x004e }
            goto L_0x003c
        L_0x0020:
            r0 = 4
            if (r4 != r0) goto L_0x002b
            java.lang.String r4 = "delete from __dp where __ty=3"
            r1.execSQL(r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0052, Throwable -> 0x0050, all -> 0x004e }
            java.lang.String r4 = "delete from __dp where __ty=2"
            goto L_0x001c
        L_0x002b:
            r0 = 3
            if (r4 != r0) goto L_0x0031
            java.lang.String r4 = "delete from __dp where __ty=3"
            goto L_0x001c
        L_0x0031:
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = "delete from __dp where __ty=0"
            goto L_0x001c
        L_0x0036:
            r0 = 2
            if (r4 != r0) goto L_0x003c
            java.lang.String r4 = "delete from __dp where __ty=2"
            goto L_0x001c
        L_0x003c:
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0052, Throwable -> 0x0050, all -> 0x004e }
            if (r1 == 0) goto L_0x0044
            r1.endTransaction()     // Catch:{ Throwable -> 0x0044 }
        L_0x0044:
            android.content.Context r4 = f3611c
            com.umeng.analytics.pro.e r4 = com.umeng.analytics.pro.e.a(r4)
            r4.b()
            return
        L_0x004e:
            r4 = move-exception
            goto L_0x0065
        L_0x0050:
            r0 = r1
            goto L_0x0057
        L_0x0052:
            r0 = r1
            goto L_0x005d
        L_0x0054:
            r4 = move-exception
            r1 = r0
            goto L_0x0065
        L_0x0057:
            if (r0 == 0) goto L_0x0044
        L_0x0059:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x0044
        L_0x005d:
            android.content.Context r4 = f3611c     // Catch:{ all -> 0x0054 }
            com.umeng.analytics.pro.f.a((android.content.Context) r4)     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0044
            goto L_0x0059
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r1.endTransaction()     // Catch:{ Throwable -> 0x006a }
        L_0x006a:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.b(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        if (r2 != null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ad, code lost:
        if (r2 != null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c7, code lost:
        if (r2 == null) goto L_0x00b2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00bd */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4 A[SYNTHETIC, Splitter:B:69:0x00d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject c() {
        /*
            r9 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 0
            android.content.Context r2 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x00bc, Throwable -> 0x00a7, all -> 0x00a3 }
            com.umeng.analytics.pro.e r2 = com.umeng.analytics.pro.e.a(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00bc, Throwable -> 0x00a7, all -> 0x00a3 }
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00bc, Throwable -> 0x00a7, all -> 0x00a3 }
            r2.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00bd, Throwable -> 0x00a8 }
            java.lang.String r3 = "select *  from __dp"
            android.database.Cursor r3 = r2.rawQuery(r3, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00bd, Throwable -> 0x00a8 }
            if (r3 == 0) goto L_0x0094
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            r1.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            r4.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            r5.<init>()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
        L_0x002a:
            boolean r6 = r3.moveToNext()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r6 == 0) goto L_0x0094
            java.lang.String r6 = "__io"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            java.lang.String r7 = "__ty"
            int r7 = r3.getColumnIndex(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            int r7 = r3.getInt(r7)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r8 != 0) goto L_0x0070
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            java.lang.String r6 = r9.b((java.lang.String) r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            r8.<init>(r6)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            int r6 = r8.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r6 <= 0) goto L_0x0070
            r6 = 2
            if (r7 != r6) goto L_0x0060
        L_0x005c:
            r4.put(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            goto L_0x0070
        L_0x0060:
            r6 = 3
            if (r7 != r6) goto L_0x0064
            goto L_0x005c
        L_0x0064:
            if (r7 != 0) goto L_0x006a
            r1.put(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            goto L_0x0070
        L_0x006a:
            r6 = 1
            if (r7 != r6) goto L_0x0070
            r5.put(r8)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
        L_0x0070:
            int r6 = r1.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r6 <= 0) goto L_0x007b
            java.lang.String r6 = "events"
            r0.put(r6, r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
        L_0x007b:
            int r6 = r4.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r6 <= 0) goto L_0x0086
            java.lang.String r6 = "session"
            r0.put(r6, r4)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
        L_0x0086:
            int r6 = r5.length()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r6 <= 0) goto L_0x002a
            java.lang.String r6 = "pageview"
            r0.put(r6, r5)     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            goto L_0x002a
        L_0x0092:
            r0 = move-exception
            goto L_0x00cd
        L_0x0094:
            r2.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x00a1, Throwable -> 0x009f, all -> 0x0092 }
            if (r3 == 0) goto L_0x009c
            r3.close()
        L_0x009c:
            if (r2 == 0) goto L_0x00b2
            goto L_0x00af
        L_0x009f:
            r1 = r3
            goto L_0x00a8
        L_0x00a1:
            r1 = r3
            goto L_0x00bd
        L_0x00a3:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x00cd
        L_0x00a7:
            r2 = r1
        L_0x00a8:
            if (r1 == 0) goto L_0x00ad
            r1.close()
        L_0x00ad:
            if (r2 == 0) goto L_0x00b2
        L_0x00af:
            r2.endTransaction()     // Catch:{ Throwable -> 0x00b2 }
        L_0x00b2:
            android.content.Context r1 = f3611c
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            return r0
        L_0x00bc:
            r2 = r1
        L_0x00bd:
            android.content.Context r3 = f3611c     // Catch:{ all -> 0x00cb }
            com.umeng.analytics.pro.f.a((android.content.Context) r3)     // Catch:{ all -> 0x00cb }
            if (r1 == 0) goto L_0x00c7
            r1.close()
        L_0x00c7:
            if (r2 == 0) goto L_0x00b2
            goto L_0x00af
            return r0
        L_0x00cb:
            r0 = move-exception
            r3 = r1
        L_0x00cd:
            if (r3 == 0) goto L_0x00d2
            r3.close()
        L_0x00d2:
            if (r2 == 0) goto L_0x00d7
            r2.endTransaction()     // Catch:{ Throwable -> 0x00d7 }
        L_0x00d7:
            android.content.Context r1 = f3611c
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.c():org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r0 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0066, code lost:
        if (r0 != null) goto L_0x005d;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0061 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC, Splitter:B:32:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x005b }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x005b }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x005b }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            java.util.List<java.lang.Integer> r0 = r5.i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            int r0 = r0.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            if (r0 <= 0) goto L_0x0039
            r0 = 0
        L_0x0017:
            java.util.List<java.lang.Integer> r2 = r5.i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            int r2 = r2.size()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            if (r0 >= r2) goto L_0x0039
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            java.lang.String r3 = "delete from __et where rowid="
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            java.util.List<java.lang.Integer> r3 = r5.i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            r1.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0039:
            java.util.List<java.lang.Integer> r0 = r5.i     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            r0.clear()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0054, Throwable -> 0x0052, all -> 0x0050 }
            if (r1 == 0) goto L_0x0046
            r1.endTransaction()     // Catch:{ Throwable -> 0x0046 }
        L_0x0046:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            return
        L_0x0050:
            r0 = move-exception
            goto L_0x0069
        L_0x0052:
            r0 = r1
            goto L_0x005b
        L_0x0054:
            r0 = r1
            goto L_0x0061
        L_0x0056:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0069
        L_0x005b:
            if (r0 == 0) goto L_0x0046
        L_0x005d:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0046 }
            goto L_0x0046
        L_0x0061:
            android.content.Context r1 = f3611c     // Catch:{ all -> 0x0056 }
            com.umeng.analytics.pro.f.a((android.content.Context) r1)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0046
            goto L_0x005d
        L_0x0069:
            if (r1 == 0) goto L_0x006e
            r1.endTransaction()     // Catch:{ Throwable -> 0x006e }
        L_0x006e:
            android.content.Context r1 = f3611c
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.d():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0036, Throwable -> 0x0030 }
            com.umeng.analytics.pro.e r1 = com.umeng.analytics.pro.e.a(r1)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0036, Throwable -> 0x0030 }
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0036, Throwable -> 0x0030 }
            r1.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x002c, Throwable -> 0x002a, all -> 0x0025 }
            java.lang.String r0 = "delete from __er"
            r1.execSQL(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x002c, Throwable -> 0x002a, all -> 0x0025 }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x002c, Throwable -> 0x002a, all -> 0x0025 }
            if (r1 == 0) goto L_0x001b
            r1.endTransaction()     // Catch:{ Throwable -> 0x001b }
        L_0x001b:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            return
        L_0x0025:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x003e
        L_0x002a:
            r0 = r1
            goto L_0x0030
        L_0x002c:
            r0 = r1
            goto L_0x0036
        L_0x002e:
            r1 = move-exception
            goto L_0x003e
        L_0x0030:
            if (r0 == 0) goto L_0x001b
        L_0x0032:
            r0.endTransaction()     // Catch:{ Throwable -> 0x001b }
            goto L_0x001b
        L_0x0036:
            android.content.Context r1 = f3611c     // Catch:{ all -> 0x002e }
            com.umeng.analytics.pro.f.a((android.content.Context) r1)     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x001b
            goto L_0x0032
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.endTransaction()     // Catch:{ Throwable -> 0x0043 }
        L_0x0043:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.e():void");
    }

    public void f() {
        b(-1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (r0 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        if (r0 == null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        if (r0 != null) goto L_0x0054;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A[SYNTHETIC, Splitter:B:24:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r5 = this;
            java.lang.String r0 = r5.j
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x007a
            android.content.Context r0 = f3611c     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x0051, all -> 0x004c }
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x0051, all -> 0x004c }
            android.database.sqlite.SQLiteDatabase r0 = r0.a()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0061, Throwable -> 0x0051, all -> 0x004c }
            r0.beginTransaction()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = "delete from __er where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = r5.j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            r0.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = "delete from __et where __i=\""
            r2.<init>(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = r5.j     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r3 = "\""
            r2.append(r3)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            r0.execSQL(r2)     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteDatabaseCorruptException -> 0x0062, Throwable -> 0x0052 }
            if (r0 == 0) goto L_0x0057
            goto L_0x0054
        L_0x004c:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006b
        L_0x0051:
            r0 = r1
        L_0x0052:
            if (r0 == 0) goto L_0x0057
        L_0x0054:
            r0.endTransaction()     // Catch:{ Throwable -> 0x0057 }
        L_0x0057:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            goto L_0x007a
        L_0x0061:
            r0 = r1
        L_0x0062:
            android.content.Context r2 = f3611c     // Catch:{ all -> 0x006a }
            com.umeng.analytics.pro.f.a((android.content.Context) r2)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0057
            goto L_0x0054
        L_0x006a:
            r1 = move-exception
        L_0x006b:
            if (r0 == 0) goto L_0x0070
            r0.endTransaction()     // Catch:{ Throwable -> 0x0070 }
        L_0x0070:
            android.content.Context r0 = f3611c
            com.umeng.analytics.pro.e r0 = com.umeng.analytics.pro.e.a(r0)
            r0.b()
            throw r1
        L_0x007a:
            r5.j = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.g.g():void");
    }
}
