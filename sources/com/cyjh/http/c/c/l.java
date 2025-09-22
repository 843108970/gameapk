package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.request.NoticeDetailsRequestParams;
import com.cyjh.http.bean.response.NoticeBean;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.e;
import com.cyjh.http.d.b.c;
import org.json.JSONObject;

public final class l extends a {

    /* renamed from: b  reason: collision with root package name */
    private e f2502b;

    /* renamed from: c  reason: collision with root package name */
    private long f2503c;

    public l(e eVar) {
        this.f2502b = eVar;
    }

    public final void a() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    public final void a(Context context, long j) {
        try {
            BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(context);
            this.f2503c = com.cyjh.http.b.a.f2475b;
            NoticeDetailsRequestParams noticeDetailsRequestParams = new NoticeDetailsRequestParams(b2);
            noticeDetailsRequestParams.NoticeId = j;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.I, "Detail").build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, noticeDetailsRequestParams));
        } catch (Exception e) {
            Log.e("zzz", "com.cyjh.share.NoticeDetailsPresenter--loadAd:" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        NoticeBean noticeBean;
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            if (jSONObject.getInt("Code") == 200 && (noticeBean = (NoticeBean) r.a(jSONObject2.toString(), NoticeBean.class)) != null && noticeBean.ClientTimestamp == this.f2503c) {
                this.f2502b.a(noticeBean);
            }
        } catch (Exception e) {
            Log.e("zzz", "com.cyjh.share.NoticeDetailsPresenter--uiDataSuccess:" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "com.cyjh.share.NoticeDetailsPresenter--onErrorResponse:" + str);
    }
}
