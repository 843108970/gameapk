package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static t f3650a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3651b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f3652c = null;
    private static final String d = "mobclick_agent_user_";

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final t f3653a = new t();

        private a() {
        }
    }

    public static synchronized t a(Context context) {
        t a2;
        synchronized (t.class) {
            if (f3651b == null && context != null) {
                f3651b = context.getApplicationContext();
            }
            if (f3651b != null) {
                f3652c = context.getPackageName();
            }
            a2 = a.f3653a;
        }
        return a2;
    }

    private SharedPreferences e() {
        if (f3651b == null) {
            return null;
        }
        Context context = f3651b;
        return context.getSharedPreferences(d + f3652c, 0);
    }

    public final void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3651b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public final void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3651b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = e().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public final String[] a() {
        SharedPreferences e = e();
        if (e == null) {
            return null;
        }
        String string = e.getString("au_p", (String) null);
        String string2 = e.getString("au_u", (String) null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new String[]{string, string2};
    }

    public final void b() {
        SharedPreferences e = e();
        if (e != null) {
            e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public final String c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3651b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", (String) null);
        }
        return null;
    }

    public final int d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f3651b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }
}
