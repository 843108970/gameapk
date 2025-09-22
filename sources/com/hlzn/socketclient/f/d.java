package com.hlzn.socketclient.f;

import android.util.Log;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3450a = false;

    public static void a(String str, String str2) {
        if (str2 != null && f3450a) {
            Log.e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (str2 != null && f3450a) {
            Log.i(str, str2);
        }
    }

    private static void c(String str, String str2) {
        if (str2 != null && f3450a) {
            Log.d(str, str2);
        }
    }

    private static void d(String str, String str2) {
        if (str2 != null && f3450a) {
            Log.v(str, str2);
        }
    }

    private static void e(String str, String str2) {
        if (str2 != null && f3450a) {
            Log.w(str, str2);
        }
    }
}
