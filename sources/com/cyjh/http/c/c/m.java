package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.NotifyMsgBean;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.response.NoticeBean;
import com.cyjh.http.bean.response.NoticeListBean;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.f;
import com.cyjh.http.d.b.c;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public final class m extends a {

    /* renamed from: b  reason: collision with root package name */
    private f f2504b;

    /* renamed from: c  reason: collision with root package name */
    private long f2505c;

    public m(f fVar) {
        this.f2504b = fVar;
    }

    public final void a() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    public final void a(Context context) {
        try {
            BaseRequestValueInfo b2 = com.cyjh.http.b.a.a().b(context);
            Log.e("zzz", "com.cyjh.share.NoticeListPresenter--loadAd:");
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.I, "List").build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, b2);
            this.f2505c = com.cyjh.http.b.a.f2475b;
            Log.e("zzz", "com.cyjh.share.NoticeListPresenter--loadAd:" + uri);
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            Log.e("zzz", "com.cyjh.share.NoticeListPresenter--loadAd:" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        NoticeListBean noticeListBean;
        try {
            String str = (String) obj;
            Log.e("zzz", "com.cyjh.share.NoticeListPresenter--uiDataSuccess1:" + str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            if (jSONObject.getInt("Code") == 200 && (noticeListBean = (NoticeListBean) r.a(jSONObject2.toString(), NoticeListBean.class)) != null && noticeListBean.NoticeList != null && noticeListBean.NoticeList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (NoticeBean next : noticeListBean.NoticeList) {
                    NotifyMsgBean notifyMsgBean = new NotifyMsgBean();
                    notifyMsgBean.ID = String.valueOf(next.NoticeId);
                    notifyMsgBean.NoticeTitle = next.NoticeTitle;
                    notifyMsgBean.NoticeContent = next.NoticeContent;
                    notifyMsgBean.NoticeTime = com.cyjh.http.e.a.a(next.NoticeTime, "yyyy-MM-dd HH:mm:ss");
                    notifyMsgBean.DescriptionType = String.valueOf(next.DescriptionType);
                    notifyMsgBean.NoticeDescription = next.NoticeDescription;
                    boolean z = true;
                    if (next.IsShowNoticeBar != 1) {
                        z = false;
                    }
                    notifyMsgBean.IsSendMessage = z;
                    arrayList.add(notifyMsgBean);
                }
                this.f2504b.a(arrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("zzz", "com.cyjh.share.NoticeListPresenter--uiDataSuccess2:" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "com.cyjh.share.NoticeListPresenter--onErrorResponse:" + str);
    }
}
