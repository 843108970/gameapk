package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.statistics.common.MLog;

public class UMGameAgent extends MobclickAgent {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3552a = "Input string is null or empty";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3553b = "Input string must be less than 64 chars";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3554c = "Input value type is negative";
    private static final String d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";
    private static final b e = new b();
    private static Context f;

    private static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static void bonus(double d2, int i) {
        if (d2 < 0.0d) {
            MLog.e(f3554c);
        } else if (i <= 0 || i >= 100) {
            MLog.e(d);
        } else {
            e.a(d2, i);
        }
    }

    public static void bonus(String str, int i, double d2, int i2) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (i < 0 || d2 < 0.0d) {
            MLog.e(f3554c);
        } else if (i2 <= 0 || i2 >= 100) {
            MLog.e(d);
        } else {
            e.a(str, i, d2, i2);
        }
    }

    public static void buy(String str, int i, double d2) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (i < 0 || d2 < 0.0d) {
            MLog.e(f3554c);
        } else {
            e.a(str, i, d2);
        }
    }

    public static void exchange(double d2, String str, double d3, int i, String str2) {
        if (d2 < 0.0d || d3 < 0.0d) {
            MLog.e(f3554c);
        } else if (i <= 0 || i >= 100) {
            MLog.e(d);
        } else {
            e.a(d2, str, d3, i, str2);
        }
    }

    public static void failLevel(String str) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (str.length() > 64) {
            MLog.e(f3553b);
        } else {
            e.d(str);
        }
    }

    public static void finishLevel(String str) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (str.length() > 64) {
            MLog.e(f3553b);
        } else {
            e.c(str);
        }
    }

    public static void init(Context context) {
        try {
            if (f == null && context != null) {
                f = context.getApplicationContext();
            }
            e.a(f);
        } catch (Throwable unused) {
            MLog.e("please check Context!");
        }
    }

    public static void pay(double d2, double d3, int i) {
        if (i <= 0 || i >= 100) {
            MLog.e(d);
        } else if (d2 < 0.0d || d3 < 0.0d) {
            MLog.e(f3554c);
        } else {
            e.a(d2, d3, i);
        }
    }

    public static void pay(double d2, String str, int i, double d3, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            MLog.e(d);
        } else if (d2 < 0.0d || i < 0 || d3 < 0.0d) {
            MLog.e(f3554c);
        } else if (a(str)) {
            MLog.e(f3552a);
        } else {
            e.a(d2, str, i, d3, i2);
        }
    }

    public static void setPlayerLevel(int i) {
        e.a(String.valueOf(i));
    }

    public static void setTraceSleepTime(boolean z) {
        e.a(z);
    }

    public static void startLevel(String str) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (str.length() > 64) {
            MLog.e(f3553b);
        } else {
            e.b(str);
        }
    }

    public static void use(String str, int i, double d2) {
        if (a(str)) {
            MLog.e(f3552a);
        } else if (i < 0 || d2 < 0.0d) {
            MLog.e(f3554c);
        } else {
            e.b(str, i, d2);
        }
    }
}
