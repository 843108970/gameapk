package com.goldcoast.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    private String f2918a;

    /* renamed from: b  reason: collision with root package name */
    private String f2919b;

    /* renamed from: c  reason: collision with root package name */
    private a f2920c;
    private e d;
    private String e;
    private String f;
    private String g;
    private f h;
    private String i;
    private String j;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpuinfo", this.f2920c.a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("prop", this.d.a());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("propInfo", this.h.b());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("MemTotal", this.f2918a);
            jSONObject.put("linuxversion", this.f2919b);
            jSONObject.put("imei", this.e);
            jSONObject.put("macAddr", this.f);
            jSONObject.put("androidId", this.g);
            jSONObject.put("currentTime", this.i);
            jSONObject.put("cpuType", this.j);
            return jSONObject;
        } catch (JSONException e5) {
            e5.printStackTrace();
            return jSONObject;
        }
    }

    public final void a(a aVar) {
        this.f2920c = aVar;
    }

    public final void a(e eVar) {
        this.d = eVar;
    }

    public final void a(f fVar) {
        this.h = fVar;
    }

    public final void a(String str) {
        this.f2918a = str;
    }

    public final e b() {
        return this.d;
    }

    public final void b(String str) {
        this.f2919b = str;
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
        this.i = str;
    }

    public final void g(String str) {
        this.j = str;
    }
}
