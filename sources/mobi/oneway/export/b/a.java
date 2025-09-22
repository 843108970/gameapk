package mobi.oneway.export.b;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import mobi.oneway.export.g.m;
import mobi.oneway.export.g.r;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static a i;

    /* renamed from: a  reason: collision with root package name */
    private final String f4107a = "sp_ad_c_info";

    /* renamed from: b  reason: collision with root package name */
    private final String f4108b = "ld";

    /* renamed from: c  reason: collision with root package name */
    private final String f4109c = "rc";
    private final String d = "sc";
    private final String e = "msc";
    private final String f = "mrc";
    private boolean g;
    private long h;

    /* renamed from: mobi.oneway.export.b.a$a  reason: collision with other inner class name */
    public enum C0064a {
        TYPE_REQUEST,
        TYPE_SHOW
    }

    private a() {
    }

    public static a a() {
        if (i == null) {
            i = new a();
        }
        return i;
    }

    private void a(JSONObject jSONObject) {
        r.a().a("sp_ad_c_info", jSONObject.toString());
    }

    private void a(JSONObject jSONObject, String str) {
        try {
            m.a((Object) "resume ad control count");
            jSONObject.put("ld", str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                Object obj = jSONObject.get(keys.next());
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    jSONObject2.put("rc", 0);
                    jSONObject2.put("sc", 0);
                }
            }
            a(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private String b(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str.equals(str2)) {
            return str;
        }
        return str + "-" + str2;
    }

    private JSONObject d() {
        String str = (String) r.a().b("sp_ad_c_info", "");
        return TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
    }

    private String e() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public void a(long j) {
        this.h = j;
    }

    public void a(String str, String str2, int i2, int i3) {
        JSONObject jSONObject;
        String b2 = b(str, str2);
        try {
            JSONObject d2 = d();
            if (d2.has(b2)) {
                jSONObject = d2.getJSONObject(b2);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                d2.put(b2, jSONObject2);
                jSONObject = jSONObject2;
            }
            jSONObject.put("mrc", i2);
            jSONObject.put("msc", i3);
            a(d2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(C0064a aVar, String str, String str2) {
        JSONObject jSONObject;
        try {
            String b2 = b(str, str2);
            JSONObject d2 = d();
            if (d2.has(b2)) {
                jSONObject = d2.getJSONObject(b2);
            } else {
                JSONObject jSONObject2 = new JSONObject();
                d2.put(b2, jSONObject2);
                jSONObject = jSONObject2;
            }
            if (aVar == C0064a.TYPE_REQUEST) {
                jSONObject.put("rc", jSONObject.optInt("rc") + 1);
            }
            if (aVar == C0064a.TYPE_SHOW) {
                jSONObject.put("sc", jSONObject.optInt("sc") + 1);
            }
            a(d2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean a(String str, String str2) {
        String e2 = e();
        String b2 = b(str, str2);
        try {
            JSONObject d2 = d();
            if (!e2.equals(d2.optString("ld"))) {
                a(d2, e2);
                return false;
            }
            if (d2.has(b2)) {
                JSONObject jSONObject = d2.getJSONObject(b2);
                int optInt = jSONObject.optInt("rc");
                int optInt2 = jSONObject.optInt("sc");
                int optInt3 = jSONObject.optInt("mrc");
                int optInt4 = jSONObject.optInt("msc");
                m.a((Object) String.format("adtype=%s,maxRequest=%d,curRequest=%d;maxShow=%d,curShow=%d", new Object[]{b2, Integer.valueOf(optInt3), Integer.valueOf(optInt), Integer.valueOf(optInt4), Integer.valueOf(optInt2)}));
                return (optInt3 != 0 && optInt >= optInt3) || (optInt4 != 0 && optInt2 >= optInt4);
            }
            return false;
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public boolean b() {
        return this.g;
    }

    public long c() {
        return this.h;
    }
}
