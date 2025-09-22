package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.t;
import com.umeng.commonsdk.utils.UMUtils;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN = true;
    public static boolean CATCH_EXCEPTION = true;
    public static boolean FLAG_DPLUS = false;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";

    /* renamed from: a  reason: collision with root package name */
    static double[] f3534a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f3535b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f3536c = null;
    private static String d = null;
    private static int e = 0;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    static void a(Context context, int i) {
        e = i;
        t.a(context).a(e);
    }

    static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            d = str;
            t.a(context).a(d);
        }
    }

    static void a(String str) {
        f3536c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static double[] getLocation() {
        return f3534a;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(d)) {
            d = t.a(context).c();
        }
        return d;
    }

    public static int getVerticalType(Context context) {
        if (e == 0) {
            e = t.a(context).d();
        }
        return e;
    }
}
