package com.cyjh.elfin.e.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.aa;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1889a = "RomUtils";

    public static double a() {
        try {
            String a2 = a("ro.build.version.emui");
            return Double.parseDouble(a2.substring(a2.indexOf("_") + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return 4.0d;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[SYNTHETIC, Splitter:B:19:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067 A[SYNTHETIC, Splitter:B:28:0x0067] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.String r3 = "getprop "
            r2.<init>(r3)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r2.append(r6)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r3.<init>(r1)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003b }
            r2.close()     // Catch:{ IOException -> 0x003b }
            r2.close()     // Catch:{ IOException -> 0x0032 }
            return r1
        L_0x0032:
            r6 = move-exception
            java.lang.String r0 = "RomUtils"
            java.lang.String r2 = "Exception while closing InputStream"
            android.util.Log.e(r0, r2, r6)
            return r1
        L_0x003b:
            r1 = move-exception
            goto L_0x0041
        L_0x003d:
            r6 = move-exception
            goto L_0x0065
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            java.lang.String r3 = "RomUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            java.lang.String r5 = "Unable to read sysprop "
            r4.<init>(r5)     // Catch:{ all -> 0x0063 }
            r4.append(r6)     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0063 }
            android.util.Log.e(r3, r6, r1)     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ IOException -> 0x005a }
            return r0
        L_0x005a:
            r6 = move-exception
            java.lang.String r1 = "RomUtils"
            java.lang.String r2 = "Exception while closing InputStream"
            android.util.Log.e(r1, r2, r6)
        L_0x0062:
            return r0
        L_0x0063:
            r6 = move-exception
            r0 = r2
        L_0x0065:
            if (r0 == 0) goto L_0x0073
            r0.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r0 = move-exception
            java.lang.String r1 = "RomUtils"
            java.lang.String r2 = "Exception while closing InputStream"
            android.util.Log.e(r1, r2, r0)
        L_0x0073:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.a.g.a(java.lang.String):java.lang.String");
    }

    public static boolean b() {
        return Build.MANUFACTURER.contains("HUAWEI");
    }

    public static boolean c() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name"));
    }

    public static boolean d() {
        String a2 = a("ro.build.display.id");
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        return a2.contains("flyme") || a2.toLowerCase().contains("flyme");
    }

    public static boolean e() {
        return Build.MANUFACTURER.contains("QiKU") || Build.MANUFACTURER.contains("360");
    }

    public static boolean f() {
        return Build.MANUFACTURER.contains(aa.d) || Build.MANUFACTURER.contains("oppo");
    }

    private static int g() {
        String a2 = a("ro.miui.ui.version.name");
        if (a2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(a2.substring(1));
        } catch (Exception unused) {
            Log.e(f1889a, "get miui version code error, version : " + a2);
            return -1;
        }
    }
}
