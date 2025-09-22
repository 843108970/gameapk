package com.cyjh.mobileanjian.ipc.log;

import android.content.Context;
import android.os.SystemClock;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ScriptRunDurationLog extends a {
    private static final String d = "SetOperationLog";
    private static final int e = 4;
    private long f;

    public ScriptRunDurationLog(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.f2565c = "http://api4.mobileanjian.com/api" + File.separator + d;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        b a2 = b.a();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PhoneModel", a2.f2566a);
            jSONObject2.put("MACMD5", a2.f2568c);
            jSONObject2.put("AndroidVersion", a2.f2567b);
            jSONObject2.put("ROM", a2.d);
            jSONObject2.put("PackageName", a2.f);
            jSONObject2.put("IsNew", a2.l ? "1" : "0");
            jSONObject2.put("AppID", a2.h);
            jSONObject2.put("AppVersion", a2.j);
            jSONObject2.put("Version", a2.k);
            jSONObject2.put("IsFree", a2.i ? "1" : "0");
            jSONObject2.put("UsedTime", String.valueOf((SystemClock.uptimeMillis() - this.f) / 1000));
            jSONObject.put("LogType", "4");
            jSONObject.put("Data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public ScriptRunDurationLog setScriptStartTime(long j) {
        this.f = j;
        return this;
    }
}
