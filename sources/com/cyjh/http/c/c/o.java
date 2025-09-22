package com.cyjh.http.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.elfin.a.b;
import com.cyjh.http.R;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.response.TemplateResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.h;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public final class o extends a {

    /* renamed from: b  reason: collision with root package name */
    private h f2507b;

    /* renamed from: c  reason: collision with root package name */
    private long f2508c;

    private o(h hVar) {
        this.f2507b = hVar;
    }

    private void a() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    private void a(Context context) {
        try {
            BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(context);
            String uri = com.cyjh.common.a.a.b(com.cyjh.common.b.a.g).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, b2);
            this.f2508c = com.cyjh.http.b.a.f2475b;
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            Log.e("zzz", "TemplateVerifyPresenter--loadAd:" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
                int i = jSONObject.getInt("Code");
                jSONObject.getString(b.d);
                if (i == 200) {
                    TemplateResponse templateResponse = (TemplateResponse) r.a(jSONObject2.toString(), TemplateResponse.class);
                    if (templateResponse == null || this.f2508c != templateResponse.ClientTimestamp) {
                        com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.timestamp_diff_except);
                        return;
                    }
                    return;
                }
                return;
            }
            com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.json_data_null);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            Log.e("zzz", "com.cyjh.share.TemplateVerifyPresenter--uiDataSuccess:Exception--" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
    }
}
