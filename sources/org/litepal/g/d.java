package org.litepal.g;

import android.util.Log;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4843a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4844b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f4845c = 5;

    private static void a(String str, Exception exc) {
        if (f4845c <= 5) {
            Log.e(str, exc.getMessage(), exc);
        }
    }

    public static void a(String str, String str2) {
        if (f4845c <= 2) {
            Log.d(str, str2);
        }
    }
}
