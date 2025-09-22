package mobi.oneway.export.e;

import java.io.IOException;
import mobi.oneway.export.a.a;
import mobi.oneway.export.d.f;
import mobi.oneway.export.enums.PluginErrorType;
import mobi.oneway.export.g.o;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.g.b;

public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f4173a;

    public c(JSONObject jSONObject) {
        this.f4173a = jSONObject;
    }

    public static void a(PluginErrorType pluginErrorType, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b.c.f4839c, pluginErrorType);
            jSONObject.put(b.c.f4838b, "Error");
            jSONObject.put("stack", str);
            jSONObject.put("zc", o.a());
            jSONObject.put("zm", o.b());
            new c(jSONObject).start();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        super.run();
        try {
            new f(a.f, a.f4100b).a(this.f4173a).c("POST").n();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
