package com.hlzn.socketclient.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static Object f3447a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static long f3448b;

    public static long a() {
        synchronized (f3447a) {
            f3448b++;
        }
        return f3448b;
    }
}
