package com.cyjh.elfin.e.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1885a = "MeizuUtils";

    @TargetApi(19)
    static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception e) {
                Log.e(f1885a, Log.getStackTraceString(e));
                return false;
            }
        } else {
            Log.e(f1885a, "Below API 19 cannot invoke!");
            return false;
        }
    }

    private static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context);
        }
        return true;
    }

    private static void c(Context context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            try {
                Log.e(f1885a, "获取悬浮窗权限, 打开AppSecActivity失败, " + Log.getStackTraceString(e));
                a.c(context);
            } catch (Exception e2) {
                Log.e(f1885a, "获取悬浮窗权限失败, 通用获取方法失败, " + Log.getStackTraceString(e2));
            }
        }
    }
}
