package com.cyjh.elfin.e.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1884a = "HuaweiUtils";

    @TargetApi(19)
    static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception e) {
                Log.e(f1884a, Log.getStackTraceString(e));
                return false;
            }
        } else {
            Log.e(f1884a, "Below API 19 cannot invoke!");
            return false;
        }
    }

    private static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context);
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.ActivityNotFoundException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.SecurityException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.content.Context r7) {
        /*
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r1 = new android.content.Intent     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r1.<init>()     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r1.setFlags(r0)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            java.lang.String r3 = "com.huawei.systemmanager"
            java.lang.String r4 = "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r1.setComponent(r2)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            double r2 = com.cyjh.elfin.e.a.g.a()     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r4 = 4614162998222441677(0x4008cccccccccccd, double:3.1)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0027
            r7.startActivity(r1)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            return
        L_0x0027:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            java.lang.String r3 = "com.huawei.systemmanager"
            java.lang.String r4 = "com.huawei.notificationmanager.ui.NotificationManagmentActivity"
            r2.<init>(r3, r4)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r1.setComponent(r2)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            r7.startActivity(r1)     // Catch:{ SecurityException -> 0x006e, ActivityNotFoundException -> 0x004c, Exception -> 0x0037 }
            return
        L_0x0037:
            r0 = move-exception
            java.lang.String r1 = "进入设置页面失败，请手动设置"
            r2 = 1
            android.widget.Toast r7 = android.widget.Toast.makeText(r7, r1, r2)
            r7.show()
            java.lang.String r7 = "HuaweiUtils"
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)
        L_0x0048:
            android.util.Log.e(r7, r0)
            return
        L_0x004c:
            r1 = move-exception
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            r2.setFlags(r0)
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r3 = "com.Android.settings"
            java.lang.String r4 = "com.android.settings.permission.TabItem"
            r0.<init>(r3, r4)
            r2.setComponent(r0)
            r7.startActivity(r2)
            r1.printStackTrace()
        L_0x0067:
            java.lang.String r7 = "HuaweiUtils"
            java.lang.String r0 = android.util.Log.getStackTraceString(r1)
            goto L_0x0048
        L_0x006e:
            r1 = move-exception
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            r2.setFlags(r0)
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r3 = "com.huawei.systemmanager"
            java.lang.String r4 = "com.huawei.permissionmanager.ui.MainActivity"
            r0.<init>(r3, r4)
            r2.setComponent(r0)
            r7.startActivity(r2)
            goto L_0x0067
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.elfin.e.a.b.c(android.content.Context):void");
    }
}
