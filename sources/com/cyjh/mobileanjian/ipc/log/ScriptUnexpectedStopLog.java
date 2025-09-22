package com.cyjh.mobileanjian.ipc.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cyjh.mobileanjian.ipc.stuff.MqmCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ScriptUnexpectedStopLog extends a {
    private static final String d = "SetErrorLog";
    private int e;
    private String f;

    public ScriptUnexpectedStopLog(Context context) {
        super(context);
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "No Network";
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return "MOBILE";
            case 1:
                return "WIFI";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.f2565c = "http://api4.mobileanjian.com/api" + File.separator + d;
    }

    /* access modifiers changed from: protected */
    public final String b() {
        String str;
        b a2 = b.a();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PhoneModel", a2.f2566a);
            jSONObject2.put("MACMD5", a2.f2568c);
            jSONObject2.put("AndroidVersion", a2.f2567b);
            jSONObject2.put("ROM", a2.d);
            jSONObject2.put("PackageName", a2.f);
            jSONObject2.put("AppID", a2.h);
            jSONObject2.put("AppVersion", a2.j);
            jSONObject2.put("Version", a2.k);
            jSONObject2.put("IsFree", a2.i ? "1" : "0");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2564b.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    switch (activeNetworkInfo.getType()) {
                        case 0:
                            str = "MOBILE";
                            break;
                        case 1:
                            str = "WIFI";
                            break;
                        default:
                            str = "UNKNOWN";
                            break;
                    }
                    jSONObject2.put("NetworkType", str);
                    jSONObject2.put("MqmCode", String.valueOf(this.e));
                    jSONObject2.put("MqmMessage", MqmCode.getMessageFromCode(this.e));
                    jSONObject2.put("ExtraMessage", this.f);
                    jSONObject.put("Data", jSONObject2);
                    return jSONObject.toString();
                }
            }
            str = "No Network";
            jSONObject2.put("NetworkType", str);
            jSONObject2.put("MqmCode", String.valueOf(this.e));
            jSONObject2.put("MqmMessage", MqmCode.getMessageFromCode(this.e));
            jSONObject2.put("ExtraMessage", this.f);
            jSONObject.put("Data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public ScriptUnexpectedStopLog setExtraLog(String str) {
        this.f = str;
        return this;
    }

    public ScriptUnexpectedStopLog setMqmCode(int i) {
        this.e = i;
        return this;
    }
}
