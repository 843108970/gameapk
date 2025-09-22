package org.litepal.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.List;
import org.litepal.LitePalApplication;
import org.litepal.c.d;
import org.litepal.g.b;

public final class a {
    private static a g;

    /* renamed from: a  reason: collision with root package name */
    public int f4729a;

    /* renamed from: b  reason: collision with root package name */
    public String f4730b;

    /* renamed from: c  reason: collision with root package name */
    public String f4731c;
    public String d;
    public List<String> e;
    public String f;

    private a() {
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                    b();
                }
            }
        }
        return g;
    }

    private void a(int i) {
        this.f4729a = i;
    }

    private void a(String str) {
        this.f4730b = str;
    }

    private void a(List<String> list) {
        this.e = list;
    }

    public static void b() {
        if (org.litepal.g.a.a()) {
            b a2 = d.a();
            g.f4730b = a2.f4733b;
            g.f4729a = a2.f4732a;
            g.e = a2.a();
            g.f4731c = a2.f4734c;
            g.d = a2.d;
        }
    }

    private void b(String str) {
        this.d = str;
    }

    public static void c() {
        g = null;
    }

    private void c(String str) {
        this.f = str;
    }

    private void d(String str) {
        d().add(str);
    }

    private int e() {
        return this.f4729a;
    }

    private void e(String str) {
        this.f4731c = str;
    }

    private String f() {
        return this.f4730b;
    }

    private String g() {
        return this.d;
    }

    private String h() {
        return this.f;
    }

    private String i() {
        return this.f4731c;
    }

    private void j() {
        String str;
        if (TextUtils.isEmpty(this.f4730b)) {
            b();
            if (TextUtils.isEmpty(this.f4730b)) {
                throw new d(d.DBNAME_IS_EMPTY_OR_NOT_DEFINED);
            }
        }
        if (!this.f4730b.endsWith(b.a.f4831a)) {
            this.f4730b += b.a.f4831a;
        }
        if (this.f4729a <= 0) {
            throw new d(d.VERSION_OF_DATABASE_LESS_THAN_ONE);
        }
        int i = this.f4729a;
        String str2 = this.f;
        SharedPreferences sharedPreferences = LitePalApplication.a().getSharedPreferences("litepal_prefs", 0);
        if (TextUtils.isEmpty(str2)) {
            str = "litepal_version";
        } else {
            if (str2.endsWith(b.a.f4831a)) {
                str2 = str2.replace(b.a.f4831a, "");
            }
            str = "litepal_version_" + str2;
        }
        if (i < sharedPreferences.getInt(str, 0)) {
            throw new d(d.VERSION_IS_EARLIER_THAN_CURRENT);
        } else if (TextUtils.isEmpty(this.f4731c)) {
            this.f4731c = b.a.f4833c;
        } else if (!this.f4731c.equals(b.a.f4832b) && !this.f4731c.equals(b.a.f4833c) && !this.f4731c.equals(b.a.d)) {
            throw new d(this.f4731c + d.CASES_VALUE_IS_INVALID);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if (r2.e.isEmpty() != false) goto L_0x000b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> d() {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.e
            if (r0 != 0) goto L_0x0013
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.e = r0
        L_0x000b:
            java.util.List<java.lang.String> r0 = r2.e
            java.lang.String r1 = "org.litepal.model.Table_Schema"
            r0.add(r1)
            goto L_0x001c
        L_0x0013:
            java.util.List<java.lang.String> r0 = r2.e
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            goto L_0x000b
        L_0x001c:
            java.util.List<java.lang.String> r0 = r2.e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.e.a.d():java.util.List");
    }
}
