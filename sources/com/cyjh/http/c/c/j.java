package com.cyjh.http.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.ChannelRequestInfo;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.d;
import com.cyjh.http.d.b.c;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2499b = "j";

    /* renamed from: c  reason: collision with root package name */
    private long f2500c;
    private d d;

    private j(d dVar) {
        this.d = dVar;
    }

    private void a() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    private void a(Context context, String str, String str2) {
        try {
            ChannelRequestInfo channelRequestInfo = new ChannelRequestInfo(com.cyjh.http.b.a.a().b(context));
            channelRequestInfo.PackageName = str;
            channelRequestInfo.Version = str2;
            this.f2500c = com.cyjh.http.b.a.f2475b;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.p, "List").build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, channelRequestInfo);
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
            String str3 = f2499b;
            ad.c(str3, "getChannelList --> url=" + uri + "\n paramsMap=" + a2.toString());
        } catch (Exception e) {
            String str4 = f2499b;
            ad.c(str4, "getChannelList --> exception=" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        JSONArray jSONArray;
        String str = f2499b;
        ad.c(str, "uiDataSuccess --> data=" + obj);
        if (obj != null) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
                    int i = jSONObject.getInt("Code");
                    jSONObject.getString(b.d);
                    if (i == 200) {
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has("ChannelList") && (jSONArray = jSONObject2.getJSONArray("ChannelList")) != null && jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                arrayList.add((String) jSONArray.get(i2));
                            }
                        }
                        String str3 = f2499b;
                        ad.c(str3, "onSuccess --> before mView=" + this.d);
                        ad.c(f2499b, "onSuccess --> after");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        String str2 = f2499b;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
    }
}
