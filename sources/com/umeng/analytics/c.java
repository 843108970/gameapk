package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.t;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f3551a = new String[2];

    public static void a(Context context, String str, String str2) {
        f3551a[0] = str;
        f3551a[1] = str2;
        if (context != null) {
            t.a(context).a(str, str2);
        }
    }

    public static String[] a(Context context) {
        String[] a2;
        if (!TextUtils.isEmpty(f3551a[0]) && !TextUtils.isEmpty(f3551a[1])) {
            return f3551a;
        }
        if (context == null || (a2 = t.a(context).a()) == null) {
            return null;
        }
        f3551a[0] = a2[0];
        f3551a[1] = a2[1];
        return f3551a;
    }

    public static void b(Context context) {
        f3551a[0] = null;
        f3551a[1] = null;
        if (context != null) {
            t.a(context).b();
        }
    }
}
