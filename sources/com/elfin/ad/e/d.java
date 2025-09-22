package com.elfin.ad.e;

import com.elfin.ad.b.a;
import java.util.List;
import org.litepal.f;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f2877a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2878b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static d f2879c;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f2879c == null) {
                f2879c = new d();
            }
            dVar = f2879c;
        }
        return dVar;
    }

    public static List<a> a(String str) {
        try {
            return f.b("adPid =" + str).a(a.class, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int b(String str) {
        try {
            return f.a((Class<?>) a.class, "adPid =?", str);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
