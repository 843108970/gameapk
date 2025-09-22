package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.b;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int f3635a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f3636b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3637c = 2;
    private static final int d = 3;
    private final long e;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final l f3638a = new l();

        private a() {
        }
    }

    private l() {
        this.e = 60000;
    }

    public static l a() {
        return a.f3638a;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            JSONObject i = b.a().i();
            if (i.length() > 0) {
                jSONObject.put(b.ab, i);
            }
            jSONObject.put(b.ad, o.a().d());
            jSONObject.put(b.ae, currentTimeMillis);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(b.af, o.a().d());
            jSONObject2.put(b.ag, currentTimeMillis + 60000);
            if (i.length() > 0) {
                jSONObject2.put(b.ab, i);
            }
            jSONArray.put(jSONObject).put(jSONObject2);
            return jSONArray;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONArray;
        }
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", "0")).intValue();
    }

    public void a(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            jSONObject.remove(b.Y);
        } else if (a2 == 2) {
            jSONObject.remove(b.Y);
            jSONObject.remove(b.ac);
            jSONObject.remove(b.ah);
            try {
                jSONObject.put(b.ac, c());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if (a2 == 3) {
            jSONObject.remove(b.Y);
            jSONObject.remove(b.ac);
            jSONObject.remove(b.ah);
            g.a(context).f();
            return;
        } else {
            return;
        }
        g.a(context).f();
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", o.a().d());
            jSONObject.put(b.p, currentTimeMillis);
            jSONObject.put(b.q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void b(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 != 1) {
            if (a2 == 2) {
                jSONObject.remove(b.n);
                try {
                    jSONObject.put(b.n, b());
                } catch (Exception unused) {
                }
            } else if (a2 == 3) {
                jSONObject.remove(b.n);
                jSONObject.remove(b.J);
                jSONObject.remove(b.N);
                jSONObject.remove(b.O);
                g.a(context).a(false, true);
                return;
            } else {
                return;
            }
        }
        jSONObject.remove(b.J);
        jSONObject.remove(b.N);
        jSONObject.remove(b.O);
        g.a(context).a(false, true);
    }
}
