package mobi.oneway.export.g;

import android.os.Build;
import mobi.oneway.export.a;
import mobi.oneway.export.a.b;
import org.json.JSONObject;

public class o {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publishId", b.b());
            jSONObject.put("bundleId", f.b());
            jSONObject.put("bundleVersion", f.c());
            jSONObject.put("sdkVersion", a.f);
            jSONObject.put("platform", com.cyjh.elfin.a.b.f1842b);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apiLevel", Build.VERSION.SDK_INT);
            jSONObject.put("imei", f.a());
            jSONObject.put("androidId", f.e());
            jSONObject.put("deviceMake", Build.BRAND);
            jSONObject.put("deviceModel", Build.MODEL);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
