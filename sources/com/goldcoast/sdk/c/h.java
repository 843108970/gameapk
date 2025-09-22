package com.goldcoast.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f2946a;

    /* renamed from: b  reason: collision with root package name */
    private static h f2947b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f2948c;

    private h() {
    }

    public static h a() {
        if (f2947b == null) {
            f2947b = new h();
        }
        return f2947b;
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : f2946a.getString(str, "");
    }

    public static void a(Context context) {
        f2948c = context;
        if (f2946a == null) {
            f2946a = f2948c.getSharedPreferences("dispatch_log", 0);
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = f2946a.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
