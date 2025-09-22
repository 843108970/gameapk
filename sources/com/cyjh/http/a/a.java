package com.cyjh.http.a;

import com.cyjh.common.util.ac;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2455a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static a f2456b;

    private a() {
    }

    public static a a() {
        if (f2456b == null) {
            synchronized (a.class) {
                if (f2456b == null) {
                    f2456b = new a();
                }
            }
        }
        return f2456b;
    }

    public static boolean b() {
        ac.a a2 = ac.a("getprop phone.id", false, 100);
        return a2.f1653b != null && a2.f1653b.length() > 0;
    }
}
