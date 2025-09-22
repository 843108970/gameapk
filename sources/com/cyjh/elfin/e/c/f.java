package com.cyjh.elfin.e.c;

import android.content.Context;
import com.cyjh.common.util.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f1915a;

    private f() {
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f1915a == null) {
                f1915a = new f();
            }
            fVar = f1915a;
        }
        return fVar;
    }

    public static void a(Context context, String str) {
        if (k.f1675a) {
            if (k.a(k.a(context))) {
                k.a(k.a(context), "", false);
            }
            k.a(k.a(context), str, true);
        }
    }
}
