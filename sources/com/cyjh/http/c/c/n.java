package com.cyjh.http.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.QueryRegCodeRequestInfo;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.g;
import com.cyjh.http.d.b.c;

public final class n extends a {

    /* renamed from: b  reason: collision with root package name */
    private g f2506b;

    public n(g gVar) {
        this.f2506b = gVar;
    }

    private void a() {
        c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                this.f2506b.a((RegCodeInfoResponse) r.a(str, RegCodeInfoResponse.class));
                return;
            }
            this.f2506b.b("bind getData下发json数据为null");
        } catch (Exception e) {
            e.printStackTrace();
            g gVar = this.f2506b;
            gVar.b("json解析抛异常：" + e.getMessage());
        }
    }

    public final void a(String str, String str2, Context context) {
        try {
            QueryRegCodeRequestInfo queryRegCodeRequestInfo = new QueryRegCodeRequestInfo(com.cyjh.http.b.a.a().b(context));
            queryRegCodeRequestInfo.RegCode = str;
            queryRegCodeRequestInfo.OldRegCode = str2;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Q, com.cyjh.common.b.a.W).build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, queryRegCodeRequestInfo));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("zzz", "QueryRegCodeInfoPresenter--queryRegCodeInfo--" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        this.f2506b.b(str);
    }
}
