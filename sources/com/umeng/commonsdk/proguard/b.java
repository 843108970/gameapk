package com.umeng.commonsdk.proguard;

import android.content.Context;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f3738b;

    /* renamed from: a  reason: collision with root package name */
    private Context f3739a;

    /* renamed from: c  reason: collision with root package name */
    private c f3740c;

    private b(Context context) {
        this.f3739a = context;
        this.f3740c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f3738b == null) {
                f3738b = new b(context.getApplicationContext());
            }
            bVar = f3738b;
        }
        return bVar;
    }

    public c a() {
        return this.f3740c;
    }
}
