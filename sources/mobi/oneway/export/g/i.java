package mobi.oneway.export.g;

import java.io.IOException;
import java.net.URL;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    static final String f4219a = "POST";

    /* renamed from: b  reason: collision with root package name */
    static final String f4220b = "GET";

    /* renamed from: c  reason: collision with root package name */
    static final String f4221c = "HEAD";
    static final String d = "Content-Type";
    static final String e = "application/json";
    static final long f = 15000;
    private String g;
    private String h;
    private long i;

    public i a(long j) {
        this.i = j;
        return this;
    }

    public i a(String str) {
        this.g = str;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        b("GET");
        try {
            new URL(this.g).openConnection();
            return jSONObject;
        } catch (IOException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public i b(String str) {
        this.h = str;
        return this;
    }
}
