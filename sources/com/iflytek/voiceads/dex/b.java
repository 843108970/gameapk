package com.iflytek.voiceads.dex;

import com.iflytek.voiceads.config.SDKLogger;
import net.grandcentrix.tray.provider.ContentProviderStorage;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3512a;

    /* renamed from: b  reason: collision with root package name */
    private String f3513b;

    /* renamed from: c  reason: collision with root package name */
    private String f3514c;
    private String d;

    public b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3512a = jSONObject.getBoolean("re");
            if (this.f3512a) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                this.f3513b = jSONObject2.getString(ContentProviderStorage.VERSION);
                this.f3514c = jSONObject2.getString("url");
                this.d = "AdDex." + jSONObject2.getString("sub_version") + ".dex";
            }
        } catch (JSONException e) {
            SDKLogger.e(e.getMessage());
        }
    }

    public String a() {
        return this.f3514c;
    }

    public String b() {
        return this.d;
    }
}
