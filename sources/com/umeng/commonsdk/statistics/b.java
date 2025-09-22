package com.umeng.commonsdk.statistics;

import com.umeng.commonsdk.statistics.common.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3866a = "Android";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3867b = "Android";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3868c = "MobclickAgent";
    public static boolean d = true;
    public static String[] e = {UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    public static final boolean f = e.f3885a;
    private static int g = 1;

    public static synchronized int a() {
        int i;
        synchronized (b.class) {
            i = g;
        }
        return i;
    }

    public static void a(int i) {
        g = i;
    }
}
