package com.cyjh.feedback.lib.d;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static a f2409a;

    public static a a() {
        if (f2409a == null) {
            synchronized (b.class) {
                if (f2409a == null) {
                    f2409a = new a();
                }
            }
        }
        return f2409a;
    }
}
