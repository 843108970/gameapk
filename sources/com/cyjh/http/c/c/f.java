package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.request.DdyStatisticsData;
import com.cyjh.http.bean.request.DdyStatisticsRequestParamsInfo;
import com.cyjh.http.d.b.c;
import java.net.URLEncoder;

public class f extends com.cyjh.http.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2492b = "f";

    /* renamed from: c  reason: collision with root package name */
    private static f f2493c;
    private a d;

    public interface a {
        void a();

        void b();
    }

    private f() {
    }

    public static f a() {
        if (f2493c == null) {
            synchronized (f.class) {
                if (f2493c == null) {
                    f2493c = new f();
                }
            }
        }
        return f2493c;
    }

    private f a(a aVar) {
        this.d = aVar;
        return this;
    }

    private void b() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
        }
    }

    private void c() {
        if (this.f2478a != null) {
            c.a().a((Object) getClass().getCanonicalName());
            c.a().a((Object) getClass().getSimpleName());
            c.a().a((Object) getClass().getName());
        }
    }

    private static void c(String str) {
        String str2 = f2492b;
        ad.c(str2, "onRequestFailureOperate --> code=-1,message=" + str);
    }

    public final void a(Context context) {
        try {
            DdyStatisticsRequestParamsInfo ddyStatisticsRequestParamsInfo = new DdyStatisticsRequestParamsInfo(com.cyjh.http.b.a.a().b(context));
            ddyStatisticsRequestParamsInfo.IsDDYun = 1;
            ddyStatisticsRequestParamsInfo.IsChargeStatistics = 1;
            String a2 = r.a((Object) new DdyStatisticsData(DdyStatisticsData.DAILY_STATISTICS, ddyStatisticsRequestParamsInfo));
            String str = com.cyjh.common.b.a.f + URLEncoder.encode(a2, "UTF-8");
            ad.c(f2492b, "report --> jsonResultStr=" + a2 + "url=" + str);
            this.f2478a.a(context, (Object) getClass().getCanonicalName(), str);
        } catch (Exception e) {
            ad.c(f2492b, "report --> ex=" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        String str = f2492b;
        ad.c(str, "uiDataSuccess --> object=" + obj);
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        String str2 = f2492b;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        String str3 = f2492b;
        ad.c(str3, "onRequestFailureOperate --> code=-1,message=" + str);
    }
}
