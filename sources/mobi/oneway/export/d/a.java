package mobi.oneway.export.d;

import mobi.oneway.export.d.f;
import org.json.JSONObject;

public abstract class a<Data> implements f.b {
    public abstract void a(int i, String str);

    public abstract void a(Data data);

    public void a(Throwable th, b bVar) {
        a(-1, "请求失败，请稍后再试");
    }

    public void a(b bVar) {
        try {
            JSONObject e = bVar.e();
            int optInt = e.optInt("code", -1);
            String optString = e.optString("message", "请求失败");
            Object obj = e.get("data");
            if (optInt == 0) {
                a(obj);
            } else {
                a(optInt, optString);
            }
        } catch (Throwable unused) {
            a(-1, "请求失败，请稍后再试");
        }
    }
}
