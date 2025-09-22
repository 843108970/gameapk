package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.UnbindRegCodeRequestInfo;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.i;
import com.cyjh.http.d.b.c;

public final class p extends a {

    /* renamed from: b  reason: collision with root package name */
    private i f2509b;

    public p(i iVar) {
        this.f2509b = iVar;
    }

    private void a() {
        c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Object obj) {
        Log.e("zzz", "UnbindRegisterCodePresenter--uiDataSuccess--" + obj);
        try {
            RegCodeInfoResponse regCodeInfoResponse = (RegCodeInfoResponse) r.a((String) obj, RegCodeInfoResponse.class);
            if (regCodeInfoResponse != null) {
                this.f2509b.a(regCodeInfoResponse);
            } else {
                this.f2509b.a("解绑注册码解析Json异常");
            }
        } catch (Exception e) {
            e.printStackTrace();
            i iVar = this.f2509b;
            iVar.a("解绑注册码解析异常:" + e.getMessage());
        }
    }

    public final void a(String str, Context context) {
        try {
            UnbindRegCodeRequestInfo unbindRegCodeRequestInfo = new UnbindRegCodeRequestInfo(com.cyjh.http.b.a.a().b(context));
            unbindRegCodeRequestInfo.RegCode = str;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Q, com.cyjh.common.b.a.V).build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, unbindRegCodeRequestInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "UnbindRegisterCodePresenter--onErrorResponse--" + str);
        this.f2509b.a(str);
    }
}
