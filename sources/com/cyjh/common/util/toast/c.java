package com.cyjh.common.util.toast;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import com.cyjh.common.util.toast.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1708a;

        /* renamed from: b  reason: collision with root package name */
        private String f1709b;

        /* renamed from: c  reason: collision with root package name */
        private Drawable f1710c;
        private String d;
        private String e;
        private int f;
        private boolean g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            this.f1709b = str2;
            this.f1710c = drawable;
            this.f1708a = str;
            this.d = str3;
            this.e = str4;
            this.f = i;
            this.g = z;
        }

        private Drawable a() {
            return this.f1710c;
        }

        private void a(int i) {
            this.f = i;
        }

        private void a(Drawable drawable) {
            this.f1710c = drawable;
        }

        private void a(String str) {
            this.f1708a = str;
        }

        private void a(boolean z) {
            this.g = z;
        }

        private void b(String str) {
            this.f1709b = str;
        }

        private boolean b() {
            return this.g;
        }

        private String c() {
            return this.f1708a;
        }

        private void c(String str) {
            this.d = str;
        }

        private String d() {
            return this.f1709b;
        }

        private void d(String str) {
            this.e = str;
        }

        private String e() {
            return this.d;
        }

        private int f() {
            return this.f;
        }

        private String g() {
            return this.e;
        }

        @NonNull
        public final String toString() {
            return "{\n    pkg name: " + this.f1708a + "\n    app icon: " + this.f1710c + "\n    app name: " + this.f1709b + "\n    app path: " + this.d + "\n    app v name: " + this.e + "\n    app v code: " + this.f + "\n    is system: " + this.g + "\n}";
        }
    }

    private c() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i = packageInfo.versionCode;
        String str2 = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return new a(str2, "", (Drawable) null, "", str, i, false);
        }
        return new a(str2, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, str, i, (applicationInfo.flags & 1) != 0);
    }

    @Nullable
    private static a a(File file) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (file == null || !file.isFile() || !file.exists()) {
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (s.b(absolutePath) || (packageManager = q.a().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(absolutePath, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = absolutePath;
        applicationInfo.publicSourceDir = absolutePath;
        return a(packageManager, packageArchiveInfo);
    }

    private static void a(Activity activity, int i) {
        String packageName = q.a().getPackageName();
        if (activity != null && !s.b(packageName)) {
            Intent a2 = s.a(packageName, false);
            if (s.a(a2)) {
                activity.startActivityForResult(a2, i);
            }
        }
    }

    private static void a(Activity activity, int i, String str) {
        if (activity != null && !s.b(str)) {
            Intent a2 = s.a(str, false);
            if (s.a(a2)) {
                activity.startActivityForResult(a2, i);
            }
        }
    }

    private static void a(@NonNull q.d dVar) {
        r.f1768a.f1770c.add(dVar);
    }

    private static boolean a() {
        return b(q.a().getPackageName());
    }

    private static boolean a(String str) {
        if (s.b(str)) {
            return false;
        }
        try {
            return q.a().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static void b(@NonNull q.d dVar) {
        r.f1768a.f1770c.remove(dVar);
    }

    private static boolean b() {
        return c(q.a().getPackageName());
    }

    private static boolean b(String str) {
        if (s.b(str)) {
            return false;
        }
        try {
            return (q.a().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean c() {
        return s.a();
    }

    private static boolean c(String str) {
        if (s.b(str)) {
            return false;
        }
        try {
            return (q.a().getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void d() {
        Intent a2 = s.a(q.a().getPackageName());
        if (a2 == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        a2.addFlags(335577088);
        q.a().startActivity(a2);
    }

    private static boolean d(@NonNull String str) {
        return !s.b(str) && str.equals(j.a());
    }

    private static void e() {
        Intent a2 = s.a(q.a().getPackageName());
        if (a2 == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        a2.addFlags(335577088);
        q.a().startActivity(a2);
    }

    private static boolean e(String str) {
        ActivityManager activityManager;
        if (!s.b(str) && (activityManager = (ActivityManager) q.a().getSystemService("activity")) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningTasks != null && runningTasks.size() > 0) {
                for (ActivityManager.RunningTaskInfo next : runningTasks) {
                    if (next.baseActivity != null && str.equals(next.baseActivity.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (runningServices != null && runningServices.size() > 0) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (str.equals(runningServiceInfo.service.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void f() {
        String packageName = q.a().getPackageName();
        if (!s.b(packageName)) {
            Intent a2 = s.a(packageName, true);
            if (s.a(a2)) {
                q.a().startActivity(a2);
            }
        }
    }

    private static void f(String str) {
        if (!s.b(str)) {
            Intent a2 = s.a(str);
            if (a2 == null) {
                Log.e("AppUtils", "Didn't exist launcher activity.");
            } else {
                q.a().startActivity(a2);
            }
        }
    }

    private static void g() {
        for (Activity next : r.f1768a.a()) {
            next.finish();
            next.overridePendingTransition(0, 0);
        }
        System.exit(0);
    }

    private static void g(String str) {
        if (!s.b(str)) {
            Intent a2 = s.a(str, true);
            if (s.a(a2)) {
                q.a().startActivity(a2);
            }
        }
    }

    @Nullable
    private static Drawable h() {
        return h(q.a().getPackageName());
    }

    @Nullable
    private static Drawable h(String str) {
        if (s.b(str)) {
            return null;
        }
        try {
            PackageManager packageManager = q.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int i() {
        return i(q.a().getPackageName());
    }

    private static int i(String str) {
        if (s.b(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = q.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @NonNull
    private static String j() {
        return q.a().getPackageName();
    }

    @NonNull
    private static String j(String str) {
        if (s.b(str)) {
            return "";
        }
        try {
            PackageManager packageManager = q.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @NonNull
    private static String k() {
        return j(q.a().getPackageName());
    }

    @NonNull
    private static String k(String str) {
        if (s.b(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = q.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @NonNull
    private static String l() {
        return k(q.a().getPackageName());
    }

    @NonNull
    private static String l(String str) {
        if (s.b(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = q.a().getPackageManager().getPackageInfo(str, 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static int m(String str) {
        if (s.b(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = q.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @NonNull
    private static String m() {
        return l(q.a().getPackageName());
    }

    private static int n() {
        return m(q.a().getPackageName());
    }

    private static int n(String str) {
        try {
            return q.a().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static int o() {
        return n(q.a().getPackageName());
    }

    @Nullable
    private static a o(String str) {
        try {
            PackageManager packageManager = q.a().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    private static a p() {
        return o(q.a().getPackageName());
    }

    @Nullable
    private static a p(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (s.b(str) || (packageManager = q.a().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return a(packageManager, packageArchiveInfo);
    }

    @NonNull
    private static List<a> q() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = q.a().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        for (PackageInfo a2 : packageManager.getInstalledPackages(0)) {
            a a3 = a(packageManager, a2);
            if (a3 != null) {
                arrayList.add(a3);
            }
        }
        return arrayList;
    }

    private static boolean r() {
        try {
            PackageInfo packageInfo = q.a().getPackageManager().getPackageInfo(q.a().getPackageName(), 0);
            return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }
}
