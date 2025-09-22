package com.iflytek.collector.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

public class k {
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r2 = (r2 = (android.net.ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r2) {
        /*
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r0 = a(r2, r0)
            r1 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 == 0) goto L_0x0021
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 == 0) goto L_0x0021
            boolean r2 = r2.isAvailable()
            if (r2 == 0) goto L_0x0021
            r2 = 1
            return r2
        L_0x0021:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.collector.a.a.k.a(android.content.Context):boolean");
    }

    private static boolean a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager != null && packageManager.checkPermission(str, context.getPackageName()) == 0;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("iflytek_collect_state", 0);
    }
}
