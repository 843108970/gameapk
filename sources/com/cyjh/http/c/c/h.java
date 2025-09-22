package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.EditProjectNumberRequestInfo;
import com.cyjh.http.bean.response.ProjectNumberInfo;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public class h extends com.cyjh.http.c.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2496c = "h";
    private static h d;

    /* renamed from: b  reason: collision with root package name */
    public a f2497b;

    public interface a {
        void a(ProjectNumberInfo projectNumberInfo);

        void a(String str);
    }

    private h() {
    }

    public static h a() {
        if (d == null) {
            synchronized (h.class) {
                if (d == null) {
                    d = new h();
                }
            }
        }
        return d;
    }

    private void a(int i, String str) {
        String str2 = f2496c;
        ad.c(str2, "onRequestFailureOperate --> code=" + i + ",message=" + str);
        if (this.f2497b != null) {
            this.f2497b.a(str);
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

    private h d() {
        this.f2497b = null;
        return this;
    }

    public final void a(Context context, String str, a aVar) {
        try {
            this.f2497b = aVar;
            EditProjectNumberRequestInfo editProjectNumberRequestInfo = new EditProjectNumberRequestInfo(com.cyjh.http.b.a.a().b(context));
            editProjectNumberRequestInfo.ScriptId = str;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.aL).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, editProjectNumberRequestInfo);
            String str2 = f2496c;
            ad.c(str2, "unbindStudioProject --> url=" + uri + ",editProjectNumberRequestInfo=" + editProjectNumberRequestInfo.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            e.printStackTrace();
            String str3 = f2496c;
            ad.c(str3, "unbindStudioProject --> exception=" + e.getMessage());
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, a aVar) {
        try {
            this.f2497b = aVar;
            EditProjectNumberRequestInfo editProjectNumberRequestInfo = new EditProjectNumberRequestInfo(com.cyjh.http.b.a.a().b(context));
            editProjectNumberRequestInfo.StudioProjectKey = str;
            editProjectNumberRequestInfo.ScriptId = str2;
            editProjectNumberRequestInfo.ScriptVersion = str3;
            editProjectNumberRequestInfo.ScriptUI = str4;
            editProjectNumberRequestInfo.ScriptSettings = str5;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.aK).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, editProjectNumberRequestInfo);
            String str6 = f2496c;
            ad.c(str6, "bindProjectNumber --> url=" + uri + ",editProjectNumberRequestInfo=" + editProjectNumberRequestInfo.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            e.printStackTrace();
            String str7 = f2496c;
            ad.c(str7, "bindStudioProject --> exception=" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        String str;
        String str2 = f2496c;
        ad.c(str2, "uiDataSuccess --> object=" + obj);
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int i = jSONObject.getInt("Code");
                String string = jSONObject.getString(b.d);
                if (i == 200) {
                    ProjectNumberInfo projectNumberInfo = (ProjectNumberInfo) r.a(jSONObject.getString("Data"), ProjectNumberInfo.class);
                    if (this.f2497b != null) {
                        this.f2497b.a(projectNumberInfo);
                        return;
                    }
                    return;
                }
                a(i, string);
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = f2496c;
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
        String str2 = f2496c;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        a(-1, str);
    }
}
