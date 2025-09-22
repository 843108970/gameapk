package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.response.AliCloudServerResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.d.b.c;
import org.json.JSONObject;

public class k extends a {

    /* renamed from: b  reason: collision with root package name */
    private long f2501b;

    public static void a() {
        c.a().a((Object) k.class.getCanonicalName());
    }

    public final void a(Context context) {
        try {
            BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(context);
            this.f2501b = com.cyjh.http.b.a.f2475b;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Z, com.cyjh.common.b.a.aa).build().toString();
            this.f2478a.a(context, k.class.getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, b2));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("zzz", "GetTokenAliCloudPresenter--load--" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            int i = jSONObject.getInt("Code");
            ad.c("GetTokenAliCloudPresenter", "uiDataSuccess data:" + str);
            if (i == 200 && com.cyjh.http.b.a.f2475b == this.f2501b) {
                com.cyjh.http.b.a.a().d = (AliCloudServerResponse) r.a(jSONObject2.toString(), AliCloudServerResponse.class);
            }
        } catch (Exception e) {
            Log.e("zzz", "GetTokenAliCloudPresenter--uiDataSuccess exception-" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "GetTokenAliCloudPresenter--onErrorResponse--" + str);
    }
}
