package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.UploadScriptSettingRequestInfo;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public class s extends com.cyjh.http.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2514b = "s";

    /* renamed from: c  reason: collision with root package name */
    private static s f2515c;
    private a d;

    public interface a {
        void a(String str);

        void b(String str);
    }

    private s() {
    }

    public static s a() {
        if (f2515c == null) {
            synchronized (s.class) {
                if (f2515c == null) {
                    f2515c = new s();
                }
            }
        }
        return f2515c;
    }

    private s a(a aVar) {
        this.d = aVar;
        return this;
    }

    private void a(int i, String str) {
        String str2 = f2514b;
        ad.c(str2, "onRequestFailureOperate --> code=" + i + ",message=" + str);
        if (this.d != null) {
            this.d.b(str);
        }
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

    public final void a(Context context, String str, String str2, String str3, a aVar) {
        try {
            this.d = aVar;
            UploadScriptSettingRequestInfo uploadScriptSettingRequestInfo = new UploadScriptSettingRequestInfo(com.cyjh.http.b.a.a().b(context));
            uploadScriptSettingRequestInfo.ScriptId = str;
            uploadScriptSettingRequestInfo.ScriptUI = str2;
            uploadScriptSettingRequestInfo.ScriptSettings = str3;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.aZ).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, uploadScriptSettingRequestInfo);
            String str4 = f2514b;
            ad.c(str4, "uploadScriptSetting --> url=" + uri + ",uploadScriptSettingRequestInfo=" + uploadScriptSettingRequestInfo.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            e.printStackTrace();
            String str5 = f2514b;
            ad.c(str5, "uploadScriptSetting --> exception=" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        String str;
        String str2 = f2514b;
        ad.c(str2, "uiDataSuccess --> object=" + obj);
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int i = jSONObject.getInt("Code");
                String string = jSONObject.getString(b.d);
                if (i != 200) {
                    a(i, string);
                } else if (this.d != null) {
                    this.d.a(string);
                }
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = f2514b;
                ad.c(str3, "uiDataSuccess --> exception=" + e.getMessage());
                str = e.getMessage();
            }
        } else {
            str = "后台返回数据为空！";
            a(-1, str);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        String str2 = f2514b;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        a(-1, str);
    }
}
