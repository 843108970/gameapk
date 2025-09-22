package com.cyjh.elfin.e.c;

import android.util.Log;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1928a = true;

    private m() {
    }

    private static int a(String str, String str2) {
        if (!f1928a) {
            return 0;
        }
        return Log.v(str, str2);
    }

    private static int a(String str, String str2, Throwable th) {
        if (!f1928a) {
            return 0;
        }
        return Log.v(str, str2, th);
    }

    private static void a(boolean z) {
        f1928a = z;
    }

    private static int b(String str, String str2) {
        if (!f1928a) {
            return 0;
        }
        return Log.d(str, str2);
    }

    private static int b(String str, String str2, Throwable th) {
        if (!f1928a) {
            return 0;
        }
        return Log.d(str, str2, th);
    }

    private static int c(String str, String str2) {
        if (!f1928a) {
            return 0;
        }
        return Log.i(str, str2);
    }

    private static int c(String str, String str2, Throwable th) {
        if (!f1928a) {
            return 0;
        }
        return Log.i(str, str2, th);
    }

    private static int d(String str, String str2) {
        if (!f1928a) {
            return 0;
        }
        return Log.w(str, str2);
    }

    private static int d(String str, String str2, Throwable th) {
        if (!f1928a) {
            return 0;
        }
        return Log.w(str, str2, th);
    }

    private static int e(String str, String str2) {
        if (!f1928a) {
            return 0;
        }
        return Log.e(str, str2);
    }

    private static int e(String str, String str2, Throwable th) {
        if (!f1928a) {
            return 0;
        }
        return Log.e(str, str2, th);
    }
}
