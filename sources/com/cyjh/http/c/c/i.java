package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.http.bean.request.FeedbackRequestInfo;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.c;

public final class i extends a {

    /* renamed from: b  reason: collision with root package name */
    private c f2498b;

    public i(c cVar) {
        this.f2498b = cVar;
    }

    private void a() {
        com.cyjh.http.d.b.c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Context context, FeedbackRequestInfo feedbackRequestInfo) {
        try {
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.ad, com.cyjh.common.b.a.ae).build().toString();
            this.f2478a.a(context, getClass().getCanonicalName(), uri, com.cyjh.http.b.a.a().a(uri, feedbackRequestInfo));
        } catch (Exception e) {
            Log.e("zzz", "FeedbackCommitDataPresenter --异常：" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        try {
            this.f2498b.a();
        } catch (Exception e) {
            Log.e("zzz", "FeedbackCommitDataPresenter--uiDataSuccess:" + e.getMessage());
            c cVar = this.f2498b;
            e.getMessage();
            cVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "FeedbackCommitDataPresenter--onErrorResponse:" + str);
        this.f2498b.b();
    }
}
