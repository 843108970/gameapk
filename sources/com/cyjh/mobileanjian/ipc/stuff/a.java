package com.cyjh.mobileanjian.ipc.stuff;

import android.content.Context;
import android.content.pm.PackageManager;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2586a = "com.cyjh.mobileanjian";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2587b = true;

    /* renamed from: c  reason: collision with root package name */
    private static String f2588c = "12345678-0000-0000-0000-BA9876543210";
    private static String d = "2015-06-24";
    private static String e = "";

    private static String a(Context context) {
        return context.getApplicationContext().getPackageName();
    }

    private static void a(String str) {
        d = str;
    }

    private static void a(boolean z) {
        f2587b = z;
    }

    public static boolean a() {
        return f2587b;
    }

    public static String b() {
        return d;
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "NOT_FOUND";
        }
    }

    private static void b(String str) {
        f2588c = str;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -2000;
        }
    }

    public static String c() {
        return f2588c;
    }

    private static void c(String str) {
        e = str;
    }

    private static String d() {
        return e;
    }

    private static boolean d(Context context) {
        return context.getApplicationContext().getPackageName().equals("com.cyjh.mobileanjian");
    }
}
