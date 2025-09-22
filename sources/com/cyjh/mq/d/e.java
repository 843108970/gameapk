package com.cyjh.mq.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class e {
    public static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return applicationInfo != null ? (String) packageManager.getApplicationLabel(applicationInfo) : "NULL";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "NULL";
        }
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            return packageInfo != null ? packageInfo.versionName : "NULL";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "NULL";
        }
    }

    private static int c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static String d(Context context) {
        return context.getPackageName();
    }
}
