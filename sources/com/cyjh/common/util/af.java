package com.cyjh.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.cyjh.common.a.a;

public class af {

    /* renamed from: b  reason: collision with root package name */
    public static final String f1659b = "app_version";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1660c = "last_app_version";
    private static final String d = "af";
    private static af e;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f1661a;

    public static af a() {
        if (e == null) {
            synchronized (af.class) {
                if (e == null) {
                    e = new af();
                }
            }
        }
        return e;
    }

    private void a(Context context, String str) {
        this.f1661a = context.getSharedPreferences(str, 0);
    }

    private void a(SharedPreferences sharedPreferences) {
        this.f1661a = sharedPreferences;
    }

    private static void d() {
    }

    public final void a(String str) {
        ad.b("saveVersion ", "appVersion:" + str);
        if (this.f1661a != null) {
            try {
                this.f1661a.edit().putString("app_version", str).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String b() {
        return this.f1661a != null ? this.f1661a.getString("app_version", a.a()) : a.a();
    }

    public final void b(String str) {
        ad.b("setLastAppVersion", "appVersion:" + str);
        if (this.f1661a != null) {
            try {
                this.f1661a.edit().putString(f1660c, str).apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final String c() {
        return this.f1661a != null ? this.f1661a.getString(f1660c, a.a()) : a.a();
    }
}
