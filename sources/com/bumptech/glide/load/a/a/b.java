package com.bumptech.glide.load.a.a;

import android.net.Uri;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f969a = 512;

    /* renamed from: b  reason: collision with root package name */
    private static final int f970b = 384;

    private b() {
    }

    public static boolean a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= f970b;
    }

    public static boolean a(Uri uri) {
        return uri != null && com.umeng.analytics.pro.b.W.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    private static boolean c(Uri uri) {
        return a(uri) && b(uri);
    }

    private static boolean d(Uri uri) {
        return a(uri) && !b(uri);
    }
}
