package com.cyjh.common.a;

import android.net.Uri;
import android.text.TextUtils;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f1618a = {"a6cd931d", "1dcf44bf", "650e59d7", "3460d8da", "21fbt87f", "317e5900", "ed1139f0", "c99f6f94"};

    /* renamed from: b  reason: collision with root package name */
    public static String f1619b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String[] f1620c = {"c6bd901f", "0ddf44be", "950e5927", "6460d8df", "11fb887f", "117e4900", "bd113950", "a99f6f97"};
    public static String[] d = {"a6cd931d", "1dcf44bf", "650e59d7", "3460d8da", "21fbt87f", "317e5900", "ed1139f0", "c99f6f94"};
    public static boolean e = false;
    public static String f = null;
    private static final String g = "http";
    private static String h = null;
    private static long i = 0;
    private static long j = 0;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static int o = 0;
    private static String p = null;
    private static String q = "http://auth2.mobileanjian.com/";

    public static Uri.Builder a(String str, String str2) {
        return new Uri.Builder().scheme("http").encodedAuthority(h).appendPath(str).appendPath(str2);
    }

    public static Uri.Builder a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http://")) {
            str = str.substring(7);
        }
        return new Uri.Builder().scheme("http").encodedAuthority(str).appendPath(str2).appendPath(str3);
    }

    public static String a() {
        return k;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http://")) {
                str = str.substring(7);
            }
            h = str;
        }
    }

    public static void a(String str, long j2, String str2, String str3, String str4, String str5, String str6) {
        h = str;
        e = false;
        j = j2;
        i = 559;
        k = str2;
        o = 2;
        l = str3;
        m = str4;
        n = str5;
        p = str6;
    }

    public static long b() {
        return i;
    }

    public static Uri.Builder b(String str) {
        return new Uri.Builder().scheme("http").encodedAuthority(h).appendPath(str);
    }

    public static long c() {
        return j;
    }

    public static void c(String str) {
        f = str;
    }

    public static String d() {
        return l;
    }

    public static void d(String str) {
        q = str;
    }

    public static String e() {
        return m;
    }

    public static String f() {
        return n;
    }

    public static String g() {
        return p;
    }

    public static String h() {
        return f;
    }

    public static String i() {
        return q;
    }

    private static boolean j() {
        return e;
    }

    private static int k() {
        return o;
    }
}
