package com.cyjh.http.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.http.R;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.response.AppStartupResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.d.b.c;
import org.json.JSONObject;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private long f2484b;

    /* renamed from: c  reason: collision with root package name */
    private com.cyjh.http.c.d.a f2485c;

    private b(com.cyjh.http.c.d.a aVar) {
        this.f2485c = aVar;
    }

    private void a() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    private void a(Context context) {
        try {
            BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(context);
            this.f2484b = com.cyjh.http.b.a.f2475b;
            String uri = com.cyjh.common.a.a.b(com.cyjh.common.b.a.x).build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, b2));
        } catch (Exception e) {
            Log.e("zzz", "AppStartupPresenter--loadAd:" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
                int i = jSONObject.getInt("Code");
                jSONObject.getString(com.cyjh.elfin.a.b.d);
                if (i == 200) {
                    AppStartupResponse appStartupResponse = (AppStartupResponse) r.a(jSONObject2.toString(), AppStartupResponse.class);
                    if (appStartupResponse == null || this.f2484b != appStartupResponse.ClientTimestamp) {
                        com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.timestamp_diff_except);
                        return;
                    }
                    return;
                }
                return;
            }
            com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.json_data_null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "com.cyjh.share.AppStartupPresenter--onErrorResponse:" + str);
    }
}
