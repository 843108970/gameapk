package com.core.util.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class c implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, c> f1604a;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicInteger f1605b = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f1606c;
    /* access modifiers changed from: private */
    public String d;

    public class a implements SharedPreferences.Editor {

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f1608b = new ArrayList<>();

        public a() {
        }

        private SharedPreferences.Editor a(a aVar) {
            synchronized (this) {
                this.f1608b.add(aVar);
            }
            return this;
        }

        private ArrayList<Bundle> a() {
            ArrayList<Bundle> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f1608b.size());
                Iterator<a> it = this.f1608b.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().q);
                }
            }
            return arrayList;
        }

        public final void apply() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(b.g, a());
            bundle.putInt("key_op_type", 6);
            try {
                c.this.f1606c.getContentResolver().call(b.f1603c, b.e, c.this.d, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final SharedPreferences.Editor clear() {
            return a(new a().a(3));
        }

        public final boolean commit() {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelableArrayList(b.g, a());
            bundle2.putInt("key_op_type", 5);
            try {
                bundle = c.this.f1606c.getContentResolver().call(b.f1603c, b.e, c.this.d, bundle2);
            } catch (Exception e) {
                e.printStackTrace();
                bundle = null;
            }
            if (bundle == null) {
                return false;
            }
            return bundle.getBoolean(b.g, false);
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            return a(a.d(str).a(z));
        }

        public final SharedPreferences.Editor putFloat(String str, float f) {
            return a(a.d(str).a(f));
        }

        public final SharedPreferences.Editor putInt(String str, int i) {
            return a(a.d(str).b(i));
        }

        public final SharedPreferences.Editor putLong(String str, long j) {
            return a(a.d(str).a(j));
        }

        public final SharedPreferences.Editor putString(String str, @Nullable String str2) {
            return a(a.d(str).b(str2));
        }

        public final SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            return a(a.d(str).a(set));
        }

        public final SharedPreferences.Editor remove(String str) {
            return a(new a().a(str).a(4));
        }
    }

    private c(Context context, String str) {
        this.f1606c = context.getApplicationContext();
        this.d = str;
    }

    public static SharedPreferences a(@NonNull Context context, String str) {
        while (f1605b.get() == 0) {
            Bundle call = context.getContentResolver().call(b.f1603c, b.f, "", (Bundle) null);
            int i = call != null ? call.getInt(b.g) : 0;
            if (i == 0) {
                return context.getSharedPreferences(str, 0);
            }
            f1605b.set(Process.myPid() == i ? 1 : -1);
        }
        return f1605b.get() > 0 ? context.getSharedPreferences(str, 0) : b(context, str);
    }

    private a a(@NonNull a aVar) {
        try {
            return new a(this.f1606c.getContentResolver().call(b.f1603c, b.d, this.d, aVar.q));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SharedPreferences b(@NonNull Context context, String str) {
        c cVar;
        synchronized (c.class) {
            if (f1604a == null) {
                f1604a = new ArrayMap();
            }
            cVar = f1604a.get(str);
            if (cVar == null) {
                cVar = new c(context.getApplicationContext(), str);
                f1604a.put(str, cVar);
            }
        }
        return cVar;
    }

    private static SharedPreferences c(@NonNull Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public boolean contains(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("key_key", str);
        try {
            return this.f1606c.getContentResolver().call(b.f1603c, b.f1601a, this.d, bundle).getBoolean(b.g);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SharedPreferences.Editor edit() {
        return new a();
    }

    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Not support method getAll");
    }

    public boolean getBoolean(String str, boolean z) {
        a a2 = a(a.c(str).a(z));
        return a2 == null ? z : a2.q.getBoolean("key_value", z);
    }

    public float getFloat(String str, float f) {
        a a2 = a(a.c(str).a(f));
        return a2 == null ? f : a2.q.getFloat("key_value");
    }

    public int getInt(String str, int i) {
        a a2 = a(a.c(str).b(i));
        return a2 == null ? i : a2.q.getInt("key_value", i);
    }

    public long getLong(String str, long j) {
        a a2 = a(a.c(str).a(j));
        return a2 == null ? j : a2.q.getLong("key_value", j);
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        a a2 = a(a.c(str).b(str2));
        return a2 == null ? str2 : a2.q.getString("key_value", str2);
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        a a2 = a(a.c(str).a(set));
        if (a2 == null) {
            return set;
        }
        ArrayList<String> stringArrayList = a2.q.getStringArrayList("key_value");
        HashSet hashSet = stringArrayList == null ? null : new HashSet(stringArrayList);
        return hashSet == null ? set : hashSet;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException();
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException();
    }
}
