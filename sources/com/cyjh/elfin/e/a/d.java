package com.cyjh.elfin.e.a;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1886a = "MiuiUtils";

    public static int a() {
        String a2 = g.a("ro.miui.ui.version.name");
        if (a2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(a2.substring(1));
        } catch (Exception e) {
            Log.e(f1886a, "get miui version code error, version : " + a2);
            Log.e(f1886a, Log.getStackTraceString(e));
            return -1;
        }
    }

    @TargetApi(19)
    static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue() == 0;
            } catch (Exception e) {
                Log.e(f1886a, Log.getStackTraceString(e));
                return false;
            }
        } else {
            Log.e(f1886a, "Below API 19 cannot invoke!");
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
        String str;
        String str2;
        int a2 = a();
        if (a2 == 5) {
            String packageName = context.getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, (String) null));
            intent.setFlags(268435456);
            if (a(intent, context)) {
                context.startActivity(intent);
                return;
            } else {
                str = f1886a;
                str2 = "intent is not available!";
            }
        } else {
            if (a2 == 6) {
                Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent2.putExtra("extra_pkgname", context.getPackageName());
                intent2.setFlags(268435456);
                if (a(intent2, context)) {
                    context.startActivity(intent2);
                    return;
                }
            } else if (a2 == 7) {
                Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent3.putExtra("extra_pkgname", context.getPackageName());
                intent3.setFlags(268435456);
                if (a(intent3, context)) {
                    context.startActivity(intent3);
                    return;
                }
            } else if (a2 == 8) {
                Intent intent4 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent4.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent4.putExtra("extra_pkgname", context.getPackageName());
                intent4.setFlags(268435456);
                if (a(intent4, context)) {
                    context.startActivity(intent4);
                    return;
                }
                Intent intent5 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                intent5.setPackage("com.miui.securitycenter");
                intent5.putExtra("extra_pkgname", context.getPackageName());
                intent5.setFlags(268435456);
                if (a(intent5, context)) {
                    context.startActivity(intent5);
                    return;
                }
            } else {
                str = f1886a;
                str2 = "this is a special MIUI rom version, its version code " + a2;
            }
            str = f1886a;
            str2 = "Intent is not available!";
        }
        Log.e(str, str2);
    }

    private static void d(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, (String) null));
        intent.setFlags(268435456);
        if (a(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f1886a, "intent is not available!");
        }
    }

    private static void e(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f1886a, "Intent is not available!");
        }
    }

    private static void f(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, context)) {
            context.startActivity(intent);
        } else {
            Log.e(f1886a, "Intent is not available!");
        }
    }

    private static void g(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        intent.setFlags(268435456);
        if (a(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        intent2.setFlags(268435456);
        if (a(intent2, context)) {
            context.startActivity(intent2);
        } else {
            Log.e(f1886a, "Intent is not available!");
        }
    }
}
