package com.cyjh.elfin.e.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1888a = "QikuUtils";

    @TargetApi(19)
    static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception e) {
                Log.e(f1888a, Log.getStackTraceString(e));
                return false;
            }
        } else {
            Log.e("", "Below API 19 cannot invoke!");
            return false;
        }
    }

    static boolean a(Intent intent, Context context) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context);
        }
        return true;
    }

    private static void c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(268435456);
        if (a(intent, context)) {
            context.startActivity(intent);
            return;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (a(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f1888a, "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
        }
    }
}
