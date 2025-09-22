package com.cyjh.http.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.ag;
import com.cyjh.common.util.r;
import com.cyjh.elfin.a.b;
import com.cyjh.http.R;
import com.cyjh.http.bean.request.UpdateRequestInfo;
import com.cyjh.http.bean.response.VersionUpdateInfo;
import com.cyjh.http.c.a.a;
import com.cyjh.http.c.d.j;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2488b = "d";

    /* renamed from: c  reason: collision with root package name */
    private Context f2489c;
    private j d;
    private long e;
    private boolean f = false;
    private String g;
    private String h;
    private UpdateRequestInfo i;

    public d(Context context, j jVar, boolean z) {
        this.f2489c = context;
        this.d = jVar;
        this.f = z;
    }

    public d(Context context, j jVar, boolean z, UpdateRequestInfo updateRequestInfo) {
        this.f2489c = context;
        this.d = jVar;
        this.f = z;
        this.i = updateRequestInfo;
    }

    private void a() {
        c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Context context) {
        try {
            UpdateRequestInfo updateRequestInfo = new UpdateRequestInfo(com.cyjh.http.b.a.a().b(context));
            if (this.i != null) {
                updateRequestInfo.ScriptId = this.i.getScriptId();
                updateRequestInfo.DeviceName = this.i.getDeviceName();
                updateRequestInfo.ScriptVersion = this.i.getScriptVersion();
                updateRequestInfo.IsScriptHotUpgrade = this.i.getIsScriptHotUpgrade();
                if (!TextUtils.isEmpty(this.i.AppVersion)) {
                    updateRequestInfo.AppVersion = this.i.AppVersion;
                }
            }
            String str = f2488b;
            ad.c(str, "updateVersion --> 1 paramsMap=" + updateRequestInfo.toString());
            String uri = com.cyjh.common.a.a.b(com.cyjh.common.b.a.H).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, updateRequestInfo);
            this.e = com.cyjh.http.b.a.f2475b;
            String str2 = f2488b;
            ad.c(str2, "updateVersion --> 2 url=" + uri + ",paramsMap=" + a2.toString());
            this.f2478a.a(this.f2489c, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("zzz", "com.cyjh.share.AppVersionUpdatePresenter--updateVersion:" + e2.getMessage());
        }
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            String str2 = f2488b;
            ad.c(str2, "uiDataSuccess --> data=" + str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            int i2 = jSONObject.getInt("Code");
            String string = jSONObject.getString(b.d);
            if (i2 == 200) {
                VersionUpdateInfo versionUpdateInfo = (VersionUpdateInfo) r.a(jSONObject2.toString(), VersionUpdateInfo.class);
                if (versionUpdateInfo != null) {
                    this.d.c(versionUpdateInfo);
                    if (!TextUtils.isEmpty(versionUpdateInfo.StudioProjectKey)) {
                        this.d.b(versionUpdateInfo);
                    }
                    if (this.e != versionUpdateInfo.ClientTimestamp) {
                        j jVar = this.d;
                        com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.json_parse_exception);
                        jVar.b();
                    } else if (versionUpdateInfo.UpdateType == 0) {
                        this.d.c();
                        if (this.f) {
                            ag.b(com.cyjh.http.b.a.a().f2476a, R.string.version_newest);
                        }
                    } else {
                        this.d.a(versionUpdateInfo);
                    }
                } else {
                    j jVar2 = this.d;
                    com.cyjh.http.b.a.a().f2476a.getResources().getString(R.string.json_parse_exception);
                    jVar2.b();
                }
            } else {
                String str3 = f2488b;
                ad.c(str3, "onUpdateFailure --> message=" + string);
                this.d.b();
            }
        } catch (Exception e2) {
            Log.e("zzz", "com.cyjh.share.AppVersionUpdatePresenter--onErrorResponse:" + e2.getMessage());
            j jVar3 = this.d;
            e2.getMessage();
            jVar3.b();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        Log.e("zzz", "com.cyjh.share.AppVersionUpdatePresenter--onErrorResponse:" + str);
        this.d.b();
    }
}
