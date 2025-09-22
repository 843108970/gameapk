package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.s;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.Serializable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f3555a;

    /* renamed from: b  reason: collision with root package name */
    public String f3556b;

    /* renamed from: c  reason: collision with root package name */
    private Context f3557c;
    private final String d = "um_g_cache";
    private final String e = "single_level";
    private final String f = "stat_player_level";
    private final String g = "stat_game_level";
    private C0052a h = null;

    /* renamed from: com.umeng.analytics.game.a$a  reason: collision with other inner class name */
    static class C0052a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private static final long f3558a = 20140327;

        /* renamed from: b  reason: collision with root package name */
        private String f3559b;

        /* renamed from: c  reason: collision with root package name */
        private long f3560c;
        private long d;

        public C0052a(String str) {
            this.f3559b = str;
        }

        public void a() {
            this.d = System.currentTimeMillis();
        }

        public boolean a(String str) {
            return this.f3559b.equals(str);
        }

        public void b() {
            this.f3560c += System.currentTimeMillis() - this.d;
            this.d = 0;
        }

        public void c() {
            a();
        }

        public void d() {
            b();
        }

        public long e() {
            return this.f3560c;
        }

        public String f() {
            return this.f3559b;
        }
    }

    public a(Context context) {
        this.f3557c = context;
    }

    public C0052a a(String str) {
        this.h = new C0052a(str);
        this.h.a();
        return this.h;
    }

    public void a() {
        try {
            if (this.h != null) {
                this.h.b();
                SharedPreferences.Editor edit = this.f3557c.getSharedPreferences("um_g_cache", 0).edit();
                edit.putString("single_level", s.a((Serializable) this.h));
                edit.putString("stat_player_level", this.f3556b);
                edit.putString("stat_game_level", this.f3555a);
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public C0052a b(String str) {
        if (this.h != null) {
            this.h.d();
            if (this.h.a(str)) {
                C0052a aVar = this.h;
                this.h = null;
                return aVar;
            }
        }
        return null;
    }

    public void b() {
        SharedPreferences sharedPreferences;
        try {
            SharedPreferences instance = PreferenceWrapper.getInstance(this.f3557c, "um_g_cache");
            String string = instance.getString("single_level", (String) null);
            if (!TextUtils.isEmpty(string)) {
                this.h = (C0052a) s.a(string);
                if (this.h != null) {
                    this.h.c();
                }
            }
            if (TextUtils.isEmpty(this.f3556b)) {
                this.f3556b = instance.getString("stat_player_level", (String) null);
                if (this.f3556b == null && (sharedPreferences = PreferenceWrapper.getDefault(this.f3557c)) != null) {
                    this.f3556b = sharedPreferences.getString("userlevel", (String) null);
                }
            }
            if (this.f3555a == null) {
                this.f3555a = instance.getString("stat_game_level", (String) null);
            }
        } catch (Throwable unused) {
        }
    }
}
