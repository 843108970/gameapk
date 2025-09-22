package com.cyjh.common.util;

import android.util.Log;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1657a = false;

    public static void a(String str, String str2) {
        if (str2 != null && f1657a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 != null && f1657a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (str2 != null && f1657a) {
            Log.i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f1657a) {
            Log.w(str, str2);
        }
    }

    private static void e(String str, String str2) {
        if (str2 != null && f1657a) {
            Log.v(str, str2);
        }
    }
}
