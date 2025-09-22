package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;
import android.os.SystemClock;
import com.cyjh.mobileanjian.ipc.stuff.a;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2707a = "http://logapi4.mobileanjian.com/api/SetLog";

    /* renamed from: b  reason: collision with root package name */
    private static final int f2708b = 4;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2709c = "RunScriptDurationApi";
    private static String d;

    private static String a(Context context, long... jArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("AppID", a.c());
            jSONObject2.put("MachineCode", r.a(context));
            jSONObject2.put("AppVersion", a.b());
            jSONObject2.put("IsFree", a.a() ? "1" : "0");
            jSONObject2.put("UsedTime", String.valueOf((SystemClock.uptimeMillis() - jArr[0]) / 1000));
            jSONObject.put("LogType", "4");
            jSONObject.put("Data", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static void a(Context context, long j) {
        d = f2707a;
        new StringBuilder("log uri: ").append(d);
        HttpUtils httpUtils = new HttpUtils();
        RequestParams requestParams = new RequestParams();
        requestParams.addQueryStringParameter("Data", a(context, j));
        httpUtils.send(HttpRequest.HttpMethod.GET, d, requestParams, (RequestCallBack) null);
    }
}
