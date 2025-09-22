package com.cyjh.common.util.toast;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class j {
    private j() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a() {
        List<UsageStats> list;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) q.a().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.importance == 100) {
                    return next.processName;
                }
            }
        }
        if (Build.VERSION.SDK_INT <= 21) {
            return "";
        }
        PackageManager packageManager = q.a().getPackageManager();
        Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        Log.i("ProcessUtils", queryIntentActivities.toString());
        if (queryIntentActivities.size() <= 0) {
            Log.i("ProcessUtils", "getForegroundProcessName: noun of access to usage information.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(q.a().getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) q.a().getSystemService("appops");
            if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                intent.addFlags(268435456);
                q.a().startActivity(intent);
            }
            if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                Log.i("ProcessUtils", "getForegroundProcessName: refuse to device usage stats.");
                return "";
            }
            UsageStatsManager usageStatsManager = (UsageStatsManager) q.a().getSystemService("usagestats");
            if (usageStatsManager != null) {
                long currentTimeMillis = System.currentTimeMillis();
                list = usageStatsManager.queryUsageStats(4, currentTimeMillis - 604800000, currentTimeMillis);
            } else {
                list = null;
            }
            if (list == null) {
                return "";
            }
            if (list.isEmpty()) {
                return "";
            }
            UsageStats usageStats = null;
            for (UsageStats next2 : list) {
                if (usageStats == null || next2.getLastTimeUsed() > usageStats.getLastTimeUsed()) {
                    usageStats = next2;
                }
            }
            if (usageStats == null) {
                return null;
            }
            return usageStats.getPackageName();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    private static boolean a(@NonNull String str) {
        ActivityManager activityManager = (ActivityManager) q.a().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                activityManager.killBackgroundProcesses(str);
            }
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
        if (runningAppProcesses2 == null || runningAppProcesses2.size() == 0) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses2) {
            if (Arrays.asList(runningAppProcessInfo2.pkgList).contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static String b() {
        String f = f();
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String g = g();
        return !TextUtils.isEmpty(g) ? g : h();
    }

    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    private static Set<String> c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) q.a().getSystemService("activity")).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                Collections.addAll(hashSet, runningAppProcessInfo.pkgList);
            }
        }
        return hashSet;
    }

    @RequiresPermission("android.permission.KILL_BACKGROUND_PROCESSES")
    private static Set<String> d() {
        ActivityManager activityManager = (ActivityManager) q.a().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses == null) {
            return hashSet;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            for (String str : it.next().pkgList) {
                activityManager.killBackgroundProcesses(str);
                hashSet.add(str);
            }
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            for (String remove : runningAppProcessInfo.pkgList) {
                hashSet.remove(remove);
            }
        }
        return hashSet;
    }

    private static boolean e() {
        return q.a().getPackageName().equals(b());
    }

    private static String f() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String g() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) q.a().getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return "";
            }
            if (runningAppProcesses.size() == 0) {
                return "";
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid && next.processName != null) {
                    return next.processName;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String h() {
        try {
            Application a2 = q.a();
            Field field = a2.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(a2);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
