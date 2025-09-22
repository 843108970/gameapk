package com.cyjh.common.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ab {

    /* renamed from: b  reason: collision with root package name */
    private static ab f1646b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f1647c = "com.cyjh.elfin.base.AppContext";

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f1648a;

    public static ab a() {
        if (f1646b == null) {
            synchronized (ab.class) {
                if (f1646b == null) {
                    f1646b = new ab();
                }
            }
        }
        return f1646b;
    }

    private void a(Context context) {
        this.f1648a = new ah(context);
    }

    private void a(String str) {
        if (this.f1648a != null) {
            this.f1648a.edit().remove(str).apply();
        }
    }

    private void a(String str, int i) {
        if (this.f1648a != null) {
            this.f1648a.edit().putInt(str, i).apply();
        }
    }

    private int b(String str, int i) {
        if (this.f1648a == null) {
            return 0;
        }
        return this.f1648a.getInt(str, i);
    }

    private String b(String str, String str2) {
        if (this.f1648a == null) {
            return null;
        }
        return this.f1648a.getString(str, str2);
    }

    public final void a(String str, Boolean bool) {
        if (this.f1648a != null) {
            this.f1648a.edit().putBoolean(str, bool.booleanValue()).apply();
        }
    }

    public final void a(String str, String str2) {
        if (this.f1648a != null) {
            this.f1648a.edit().putString(str, str2).apply();
        }
    }

    public final boolean b(String str, Boolean bool) {
        if (this.f1648a == null) {
            return false;
        }
        return this.f1648a.getBoolean(str, bool.booleanValue());
    }
}
