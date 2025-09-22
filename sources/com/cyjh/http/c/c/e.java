package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.BindRegCodeRequestInfo;
import com.cyjh.http.bean.response.BaseResponseInfo;
import com.cyjh.http.bean.response.BindRegCodeResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.b;
import com.cyjh.http.d.b.c;

public class e extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2490b = "e";

    /* renamed from: c  reason: collision with root package name */
    private b f2491c;

    public e(b bVar) {
        this.f2491c = bVar;
    }

    private void a() {
        c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            String str2 = f2490b;
            ad.c(str2, "uiDataSuccess --> json=" + str);
            BindRegCodeResponse bindRegCodeResponse = (BindRegCodeResponse) r.a(str, BindRegCodeResponse.class);
            if (bindRegCodeResponse == null) {
                this.f2491c.a(new BaseResponseInfo(-1, "getData下发json数据为null"));
            } else {
                this.f2491c.a(bindRegCodeResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f2491c.a(new BaseResponseInfo(-1, e.getMessage()));
        }
    }

    public final void a(String str, Context context, int i, String str2) {
        try {
            BindRegCodeRequestInfo bindRegCodeRequestInfo = new BindRegCodeRequestInfo(com.cyjh.http.b.a.a().b(context));
            bindRegCodeRequestInfo.RegCode = str;
            bindRegCodeRequestInfo.OldRegCode = str2;
            bindRegCodeRequestInfo.IsSuperpose = i;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Q, com.cyjh.common.b.a.U).build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, bindRegCodeRequestInfo));
            Log.e("zzz", "BindRegisterCodePresenter--bindRegCode--" + uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        this.f2491c.a(new BaseResponseInfo(-1, str));
    }
}
