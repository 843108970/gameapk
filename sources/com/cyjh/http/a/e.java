package com.cyjh.http.a;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.http.e.a;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static String f2472b = "e";

    /* renamed from: c  reason: collision with root package name */
    private static e f2473c;

    /* renamed from: a  reason: collision with root package name */
    public int f2474a;

    private e() {
    }

    public static e a() {
        if (f2473c == null) {
            synchronized (e.class) {
                if (f2473c == null) {
                    f2473c = new e();
                }
            }
        }
        return f2473c;
    }

    private e a(int i) {
        String str = f2472b;
        ad.c(str, "init --> redFingerSwitch=" + i);
        this.f2474a = i;
        return this;
    }

    private boolean a(Context context) {
        return a.a(context, com.cyjh.common.b.a.aw) && this.f2474a == 1;
    }
}
