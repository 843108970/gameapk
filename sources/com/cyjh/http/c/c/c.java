package com.cyjh.http.c.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.k;
import com.cyjh.common.util.r;
import com.cyjh.http.R;
import com.cyjh.http.bean.request.ScriptStartRunParams;
import com.cyjh.http.bean.request.ScriptStopRunParams;
import com.cyjh.http.bean.request.StatisticsRequestParamsInfo;
import com.cyjh.http.bean.response.ScriptStartRunResponse;
import java.io.File;
import java.util.Map;

public class c extends com.cyjh.http.c.a.a {
    private static c d;

    /* renamed from: b  reason: collision with root package name */
    public a f2486b;

    /* renamed from: c  reason: collision with root package name */
    public b f2487c;

    public interface a {
        void a();
    }

    public interface b {
        void a();

        void a(Object obj);
    }

    private c() {
    }

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private c a(a aVar) {
        this.f2486b = aVar;
        return this;
    }

    private c a(b bVar) {
        this.f2487c = bVar;
        return this;
    }

    private void e() {
        if (this.f2487c != null) {
            this.f2487c.a();
        }
    }

    public final void a(Context context, int i, int i2, long j) {
        try {
            StatisticsRequestParamsInfo statisticsRequestParamsInfo = new StatisticsRequestParamsInfo(com.cyjh.http.b.a.a().b(context));
            statisticsRequestParamsInfo.Action = i2;
            statisticsRequestParamsInfo.BussinessId = i;
            statisticsRequestParamsInfo.RelationId = j;
            statisticsRequestParamsInfo.CloudPhoneType = com.cyjh.http.a.c.a().e;
            Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--loadAd:");
            String uri = com.cyjh.common.a.a.b(com.cyjh.common.b.a.h).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, statisticsRequestParamsInfo);
            Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--parasMap:" + a2);
            Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--loadAd:" + uri);
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--loadAd:" + e.getMessage());
        }
    }

    public final void a(Context context, String str) {
        try {
            ScriptStopRunParams scriptStopRunParams = new ScriptStopRunParams(com.cyjh.http.b.a.a().b(context));
            scriptStopRunParams.RunGuid = str;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Q, com.cyjh.common.b.a.T).build().toString();
            this.f2478a.a(context, getClass().getName(), uri, com.cyjh.http.b.a.a().a(uri, scriptStopRunParams));
        } catch (Exception e) {
            Log.e("zzz", "AppStatisticsPresenter--loadScriptStopRunStatistics:" + e.getMessage());
            e();
        }
    }

    public final void a(Context context, String str, String str2, String str3) {
        try {
            ScriptStartRunParams scriptStartRunParams = new ScriptStartRunParams(com.cyjh.http.b.a.a().b(context));
            scriptStartRunParams.RegCode = str;
            scriptStartRunParams.ScriptId = str2;
            ScriptStartRunResponse.sClientTime = scriptStartRunParams.ClientTimestamp;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.b.a.Q, str3).build().toString();
            Log.d("loadScriptStar", "scriptStartRunParams:" + scriptStartRunParams.toString());
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, scriptStartRunParams);
            if (k.f1675a) {
                File a3 = k.a(context);
                k.a(a3, "loadScriptStartRunStatistics --> data=" + a2.get("Data") + ",r=" + a2.get("R"), true);
            }
            this.f2478a.a(context, getClass().getSimpleName(), uri, a2);
        } catch (Exception unused) {
        }
    }

    public final void a(Object obj) {
        Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--uiDataSuccess:" + obj);
        try {
            if (this.f2486b != null) {
                this.f2486b.a();
            }
            if (this.f2487c != null) {
                ScriptStartRunResponse scriptStartRunResponse = (ScriptStartRunResponse) r.a((String) obj, ScriptStartRunResponse.class);
                if (!(ScriptStartRunResponse.sClientTime == 0 || ScriptStartRunResponse.sClientTime == scriptStartRunResponse.Data.ClientTimestamp)) {
                    scriptStartRunResponse.Code = 602;
                    scriptStartRunResponse.Message = com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.check_sign_fail);
                    obj = r.a((Object) scriptStartRunResponse);
                    ScriptStartRunResponse.sClientTime = 0;
                }
                this.f2487c.a(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("zzz", "com.cyjh.share.AppStatisticsPresenter--uiDataSuccess:" + e.getMessage());
            e();
        }
    }

    public final void b() {
        if (this.f2478a != null) {
            com.cyjh.http.d.b.c.a().a((Object) getClass().getCanonicalName());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        e();
    }

    public final void c() {
        if (this.f2478a != null) {
            com.cyjh.http.d.b.c.a().a((Object) getClass().getCanonicalName());
            com.cyjh.http.d.b.c.a().a((Object) getClass().getSimpleName());
            com.cyjh.http.d.b.c.a().a((Object) getClass().getName());
        }
    }

    public final void d() {
        this.f2486b = null;
        this.f2487c = null;
    }
}
