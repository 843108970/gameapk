package com.goldcoast.sdk.a;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends c<e> {

    /* renamed from: a  reason: collision with root package name */
    private String f2924a;

    /* renamed from: b  reason: collision with root package name */
    private String f2925b;

    /* renamed from: c  reason: collision with root package name */
    private String f2926c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;

    public e() {
    }

    public e(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        if (it != null && it.hasNext()) {
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals("ro.product.brand")) {
                    this.f2924a = map.get(next);
                } else if (next.equals("ro.product.name")) {
                    this.f2925b = map.get(next);
                } else if (next.equals("ro.product.model")) {
                    this.f2926c = map.get(next);
                } else if (next.equals("ro.build.fingerprint")) {
                    this.d = map.get(next);
                } else if (next.equals("ro.build.version.sdk")) {
                    this.e = map.get(next);
                } else if (next.equals("ro.build.version.release")) {
                    this.f = map.get(next);
                } else if (next.equals("ro.build.date")) {
                    this.g = map.get(next);
                } else if (next.equals("ro.build.date.utc")) {
                    this.h = map.get(next);
                } else if (next.equals("ro.boot.cpuid")) {
                    this.i = map.get(next);
                } else if (next.equals("ro.btconfig.vendor")) {
                    this.j = map.get(next);
                } else if (next.equals("persist.sys.timezone")) {
                    this.k = map.get(next);
                } else if (next.equals("persist.sys.country")) {
                    this.l = map.get(next);
                } else if (next.equals("persist.sys.language")) {
                    this.m = map.get(next);
                } else if (next.equals("persist.sys.dalvik.vm.lib")) {
                    this.n = map.get(next);
                } else if (next.equals("ro.build.description")) {
                    this.o = map.get(next);
                } else if (next.equals("ro.runtime.firstboot")) {
                    this.p = map.get(next);
                } else if (next.equals("ro.serialno")) {
                    this.q = map.get(next);
                } else if (next.equals("ro.hardware")) {
                    this.r = map.get(next);
                } else if (next.equals("ro.product.board")) {
                    this.s = map.get(next);
                } else if (next.equals("ro.product.locale.language")) {
                    this.t = map.get(next);
                } else if (next.equals("ro.product.locale.region")) {
                    this.u = map.get(next);
                } else if (next.equals("ro.product.cpu.abi")) {
                    this.v = map.get(next);
                } else if (next.equals("ro.board.platform")) {
                    this.w = map.get(next);
                } else if (next.equals("ro.build.selinux")) {
                    this.x = map.get(next);
                } else if (next.equals("ro.build.selinux.enforce")) {
                    this.y = map.get(next);
                }
            }
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ro.product.brand", this.f2924a);
            jSONObject.put("ro.product.name", this.f2925b);
            jSONObject.put("ro.product.model", this.f2926c);
            jSONObject.put("ro.build.fingerprint", this.d);
            jSONObject.put("ro.build.version.sdk", this.e);
            jSONObject.put("ro.build.version.release", this.f);
            jSONObject.put("ro.build.date", this.g);
            jSONObject.put("ro.build.date.utc", this.h);
            jSONObject.put("ro.boot.cpuid", this.i);
            jSONObject.put("ro.btconfig.vendor", this.j);
            jSONObject.put("persist.sys.timezone", this.k);
            jSONObject.put("persist.sys.country", this.l);
            jSONObject.put("persist.sys.language", this.m);
            jSONObject.put("persist.sys.dalvik.vm.lib", this.n);
            jSONObject.put("ro.build.description", this.o);
            jSONObject.put("ro.runtime.firstboot", this.p);
            jSONObject.put("ro.serialno", this.q);
            jSONObject.put("ro.hardware", this.r);
            jSONObject.put("ro.product.board", this.s);
            jSONObject.put("ro.product.locale.language", this.t);
            jSONObject.put("ro.product.locale.region", this.u);
            jSONObject.put("ro.product.cpu.abi", this.v);
            jSONObject.put("ro.board.platform", this.w);
            jSONObject.put("ro.build.selinux", this.x);
            jSONObject.put("ro.build.selinux.enforce", this.y);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public final String b() {
        return this.h;
    }
}
