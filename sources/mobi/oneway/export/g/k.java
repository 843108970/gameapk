package mobi.oneway.export.g;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
