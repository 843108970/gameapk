package mobi.oneway.export.f;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f4189a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f4190b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f4191a;

        /* renamed from: b  reason: collision with root package name */
        private String f4192b;

        /* renamed from: c  reason: collision with root package name */
        private int f4193c;
        private int d;
        private int e;
        private int f;
        private int g;

        public a(String str, JSONObject jSONObject) {
            this.f4191a = jSONObject.optInt("adp");
            this.f4192b = jSONObject.optString("pid");
            this.f4193c = jSONObject.optInt("dayReqLimit");
            this.d = jSONObject.optInt("dayShowLimit");
            this.e = jSONObject.optInt("fsc");
            this.f = jSONObject.optInt("hvcb");
            this.g = jSONObject.optInt("ocb");
            mobi.oneway.export.b.a.a().a(str, this.f4192b, this.f4193c, this.d);
        }

        public int a() {
            return this.f4191a;
        }

        public void a(int i) {
            this.f4191a = i;
        }

        public void a(String str) {
            this.f4192b = str;
        }

        public String b() {
            return this.f4192b;
        }

        public void b(int i) {
            this.f4193c = i;
        }

        public int c() {
            return this.f4193c;
        }

        public void c(int i) {
            this.d = i;
        }

        public int d() {
            return this.d;
        }

        public void d(int i) {
            this.e = i;
        }

        public int e() {
            return this.e;
        }

        public void e(int i) {
            this.f = i;
        }

        public int f() {
            return this.f;
        }

        public void f(int i) {
            this.g = i;
        }

        public int g() {
            return this.g;
        }
    }

    public c(JSONObject jSONObject) {
        this.f4189a = jSONObject.optString("pid");
        JSONArray optJSONArray = jSONObject.optJSONArray("pidConfigs");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.f4190b = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.f4190b.add(new a(this.f4189a, optJSONArray.optJSONObject(i)));
            }
        }
    }

    public String a() {
        return this.f4189a;
    }

    public void a(String str) {
        this.f4189a = str;
    }

    public void a(List<a> list) {
        this.f4190b = list;
    }

    public List<a> b() {
        return this.f4190b;
    }
}
