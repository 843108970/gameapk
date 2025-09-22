package com.cyjh.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import java.util.Map;
import java.util.Set;
import net.grandcentrix.tray.AppPreferences;

public final class ah implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    protected final AppPreferences f1662a;

    /* renamed from: b  reason: collision with root package name */
    protected final a f1663b = new a(this, (byte) 0);

    private class a implements SharedPreferences.Editor {
        private a() {
        }

        /* synthetic */ a(ah ahVar, byte b2) {
            this();
        }

        public final void apply() {
        }

        public final SharedPreferences.Editor clear() {
            ah.this.f1662a.clear();
            return this;
        }

        public final boolean commit() {
            return true;
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            ah.this.f1662a.put(str, z);
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f) {
            ah.this.f1662a.put(str, f);
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i) {
            ah.this.f1662a.put(str, i);
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j) {
            ah.this.f1662a.put(str, j);
            return this;
        }

        public final SharedPreferences.Editor putString(String str, @Nullable String str2) {
            ah.this.f1662a.put(str, str2);
            return this;
        }

        public final SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            return this;
        }

        public final SharedPreferences.Editor remove(String str) {
            ah.this.f1662a.remove(str);
            return this;
        }
    }

    public ah(Context context) {
        this.f1662a = new AppPreferences(context);
    }

    private AppPreferences a() {
        return this.f1662a;
    }

    public final boolean contains(String str) {
        return this.f1662a.contains(str);
    }

    public final SharedPreferences.Editor edit() {
        return this.f1663b;
    }

    public final Map<String, ?> getAll() {
        return null;
    }

    public final boolean getBoolean(String str, boolean z) {
        return this.f1662a.getBoolean(str, z);
    }

    public final float getFloat(String str, float f) {
        return this.f1662a.getFloat(str, f);
    }

    public final int getInt(String str, int i) {
        return this.f1662a.getInt(str, i);
    }

    public final long getLong(String str, long j) {
        return this.f1662a.getLong(str, j);
    }

    @Nullable
    public final String getString(String str, @Nullable String str2) {
        return this.f1662a.getString(str, str2);
    }

    @Nullable
    public final Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return null;
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
