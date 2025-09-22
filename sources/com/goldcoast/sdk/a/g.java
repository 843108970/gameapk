package com.goldcoast.sdk.a;

import android.support.v4.app.NotificationCompat;
import com.umeng.commonsdk.proguard.v;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends c<g> {

    /* renamed from: a  reason: collision with root package name */
    private String f2930a;

    /* renamed from: b  reason: collision with root package name */
    private int f2931b;

    /* renamed from: c  reason: collision with root package name */
    private String f2932c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private f l;
    private String m;
    private String n;
    private String o;

    public final JSONObject a() {
        JSONObject b2 = this.l != null ? this.l.b() : new JSONObject();
        try {
            b2.put("rf_md5", this.f2930a);
            b2.put(NotificationCompat.CATEGORY_STATUS, this.f2931b);
            b2.put(NotificationCompat.CATEGORY_MESSAGE, this.f2932c);
            b2.put("runTime", this.d);
            b2.put("androidId", this.e);
            b2.put("netOperator", this.f);
            b2.put("simOperatorName", this.g);
            b2.put("displayLanguage", this.h);
            b2.put("displayCountry", this.i);
            b2.put("token", this.j);
            b2.put("category", this.k);
            b2.put("sdkV", this.m);
            b2.put(v.j, this.n);
            b2.put("signature", this.o);
        } catch (JSONException unused) {
        }
        return b2;
    }

    public final void a(int i2) {
        this.f2931b = i2;
    }

    public final void a(long j2) {
        this.d = j2;
    }

    public final void a(f fVar) {
        this.l = fVar;
    }

    public final void a(String str) {
        this.f2930a = str;
    }

    public final void b(int i2) {
        this.k = i2;
    }

    public final void b(String str) {
        this.f2932c = str;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final void g(String str) {
        this.i = str;
    }

    public final void h(String str) {
        this.j = str;
    }

    public final void i(String str) {
        this.m = str;
    }

    public final void j(String str) {
        this.n = str;
    }

    public final void k(String str) {
        this.o = str;
    }
}
