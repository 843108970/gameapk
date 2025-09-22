package com.goldcoast.sdk.a;

import com.cyjh.common.util.s;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends c<a> {

    /* renamed from: a  reason: collision with root package name */
    private String f2915a = "0";

    /* renamed from: b  reason: collision with root package name */
    private String f2916b;

    /* renamed from: c  reason: collision with root package name */
    private String f2917c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public a() {
    }

    public a(Map map) {
        a(map);
    }

    private a a(Map<String, String> map) {
        Iterator<String> it = map.keySet().iterator();
        if (it == null || !it.hasNext()) {
            return null;
        }
        while (it.hasNext()) {
            String next = it.next();
            if (next.replace(s.a.f1696a, "").toLowerCase().contains("processorcnt")) {
                this.f2915a = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("modelname")) {
                this.f2916b = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("features")) {
                this.f2917c = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("cpuimplementer")) {
                this.d = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("cpuarchitecture")) {
                this.e = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("cpuvariant")) {
                this.f = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("cpupart")) {
                this.g = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("cpurevision")) {
                this.h = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("hardware")) {
                this.i = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("revision")) {
                this.j = map.get(next);
            } else if (next.replace(s.a.f1696a, "").toLowerCase().contains("serial")) {
                this.k = map.get(next);
            }
        }
        try {
            this.f2915a = String.valueOf(Integer.valueOf(this.f2915a).intValue() + 1);
            return this;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return this;
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("processorcnt", this.f2915a == null ? "" : this.f2915a);
            jSONObject.put("modelname", this.f2916b == null ? "" : this.f2916b);
            jSONObject.put("features", this.f2917c == null ? "" : this.f2917c);
            jSONObject.put("cpuimplementer", this.d == null ? "" : this.d);
            jSONObject.put("cpuarchitecture", this.e == null ? "" : this.e);
            jSONObject.put("cpuvariant", this.f == null ? "" : this.f);
            jSONObject.put("cpupart", this.g == null ? "" : this.g);
            jSONObject.put("cpurevision", this.h == null ? "" : this.h);
            jSONObject.put("hardware", this.i == null ? "" : this.i);
            jSONObject.put("revision", this.j == null ? "" : this.j);
            jSONObject.put("serial", this.k == null ? "" : this.k);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }
}
