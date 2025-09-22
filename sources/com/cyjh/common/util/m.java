package com.cyjh.common.util;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static long f1679a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f1680b = 500;

    /* renamed from: c  reason: collision with root package name */
    private static m f1681c;

    public static m a() {
        if (f1681c == null) {
            f1681c = new m();
        }
        return f1681c;
    }

    public static boolean b() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f1679a;
        if (j > 0 && j < ((long) f1680b)) {
            return true;
        }
        f1679a = currentTimeMillis;
        return false;
    }
}
