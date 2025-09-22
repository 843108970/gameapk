package com.cyjh.common.util.toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public final class l {
    private l() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static int a() {
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    private static int a(View view) {
        int i;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            i = -1;
        } else {
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            i = point.x;
        }
        return i - iArr[0];
    }

    @RequiresPermission("android.permission.WRITE_SETTINGS")
    private static void a(int i) {
        Settings.System.putInt(q.a().getContentResolver(), "screen_off_timeout", i);
    }

    private static void a(@NonNull Activity activity) {
        activity.getWindow().addFlags(1024);
    }

    private static int b() {
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    private static int b(View view) {
        int i;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            i = -1;
        } else {
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            i = point.y;
        }
        return i - iArr[1];
    }

    private static void b(@NonNull Activity activity) {
        activity.getWindow().clearFlags(1024);
    }

    private static int c() {
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    private static int c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[0];
    }

    private static void c(@NonNull Activity activity) {
        boolean z = (activity.getWindow().getAttributes().flags & 1024) == 1024;
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(1024);
        } else {
            window.addFlags(1024);
        }
    }

    private static int d() {
        WindowManager windowManager = (WindowManager) q.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    private static int d(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    private static boolean d(@NonNull Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    private static float e() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private static void e(@NonNull Activity activity) {
        activity.setRequestedOrientation(0);
    }

    private static int f() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private static void f(@NonNull Activity activity) {
        activity.setRequestedOrientation(1);
    }

    private static float g() {
        return Resources.getSystem().getDisplayMetrics().xdpi;
    }

    private static int g(@NonNull Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                return 0;
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    private static float h() {
        return Resources.getSystem().getDisplayMetrics().ydpi;
    }

    private static Bitmap h(@NonNull Activity activity) {
        Bitmap a2 = s.a(activity.getWindow().getDecorView());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return Bitmap.createBitmap(a2, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private static Bitmap i(@NonNull Activity activity) {
        Bitmap a2 = s.a(activity.getWindow().getDecorView());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return Bitmap.createBitmap(a2, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    private static boolean i() {
        return q.a().getResources().getConfiguration().orientation == 2;
    }

    private static boolean j() {
        return q.a().getResources().getConfiguration().orientation == 1;
    }

    private static boolean k() {
        KeyguardManager keyguardManager = (KeyguardManager) q.a().getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    private static int l() {
        try {
            return Settings.System.getInt(q.a().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return -123;
        }
    }
}
