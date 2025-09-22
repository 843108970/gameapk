package com.cyjh.common.util.toast;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressLint({"ApplySharedPref"})
public final class k {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, k> f1722b = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    SharedPreferences f1723a;

    private k(String str) {
        this.f1723a = q.a().getSharedPreferences(str, 0);
    }

    private k(String str, int i) {
        this.f1723a = q.a().getSharedPreferences(str, i);
    }

    private static k a() {
        return a("", 0);
    }

    private static k a(int i) {
        return a("", i);
    }

    public static k a(String str) {
        return a(str, 0);
    }

    private static k a(String str, int i) {
        k kVar;
        boolean z = false;
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (!Character.isWhitespace(str.charAt(i2))) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = true;
        if (z) {
            str = "spUtils";
        }
        k kVar2 = f1722b.get(str);
        if (kVar2 != null) {
            return kVar2;
        }
        synchronized (k.class) {
            kVar = f1722b.get(str);
            if (kVar == null) {
                kVar = new k(str, i);
                f1722b.put(str, kVar);
            }
        }
        return kVar;
    }

    private void a(@NonNull String str, float f) {
        this.f1723a.edit().putFloat(str, f).apply();
    }

    private void a(@NonNull String str, long j) {
        this.f1723a.edit().putLong(str, j).apply();
    }

    private void a(@NonNull String str, String str2) {
        this.f1723a.edit().putString(str, str2).apply();
    }

    private void a(@NonNull String str, Set<String> set) {
        this.f1723a.edit().putStringSet(str, set).apply();
    }

    private void a(@NonNull String str, boolean z) {
        this.f1723a.edit().putBoolean(str, z).apply();
    }

    private String b(@NonNull String str) {
        return this.f1723a.getString(str, "");
    }

    private Map<String, ?> b() {
        return this.f1723a.getAll();
    }

    private void b(@NonNull String str, float f) {
        this.f1723a.edit().putFloat(str, f).apply();
    }

    private void b(@NonNull String str, int i) {
        this.f1723a.edit().putInt(str, i).apply();
    }

    private void b(@NonNull String str, long j) {
        this.f1723a.edit().putLong(str, j).apply();
    }

    private void b(@NonNull String str, String str2) {
        this.f1723a.edit().putString(str, str2).apply();
    }

    private void b(@NonNull String str, Set<String> set) {
        this.f1723a.edit().putStringSet(str, set).apply();
    }

    private void b(@NonNull String str, boolean z) {
        this.f1723a.edit().putBoolean(str, z).apply();
    }

    private int c(@NonNull String str) {
        return this.f1723a.getInt(str, -1);
    }

    private String c(@NonNull String str, String str2) {
        return this.f1723a.getString(str, str2);
    }

    private Set<String> c(@NonNull String str, Set<String> set) {
        return this.f1723a.getStringSet(str, set);
    }

    private void c() {
        this.f1723a.edit().clear().apply();
    }

    private void c(@NonNull String str, int i) {
        this.f1723a.edit().putInt(str, i).apply();
    }

    private int d(@NonNull String str) {
        return this.f1723a.getInt(str, -1);
    }

    private void d() {
        this.f1723a.edit().clear().apply();
    }

    private long e(@NonNull String str) {
        return this.f1723a.getLong(str, -1);
    }

    private long f(@NonNull String str) {
        return this.f1723a.getLong(str, -1);
    }

    private float g(@NonNull String str) {
        return this.f1723a.getFloat(str, -1.0f);
    }

    private float h(@NonNull String str) {
        return this.f1723a.getFloat(str, -1.0f);
    }

    private boolean i(@NonNull String str) {
        return this.f1723a.getBoolean(str, false);
    }

    private boolean j(@NonNull String str) {
        return this.f1723a.getBoolean(str, false);
    }

    private Set<String> k(@NonNull String str) {
        return this.f1723a.getStringSet(str, Collections.emptySet());
    }

    private boolean l(@NonNull String str) {
        return this.f1723a.contains(str);
    }

    private void m(@NonNull String str) {
        this.f1723a.edit().remove(str).apply();
    }

    private void n(@NonNull String str) {
        this.f1723a.edit().remove(str).apply();
    }

    private static boolean o(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
