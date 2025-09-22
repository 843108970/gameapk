package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.UploadInstanceDataRequestInfo;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public class r extends com.cyjh.http.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2512b = "r";

    /* renamed from: c  reason: collision with root package name */
    private static final long f2513c = 1;
    private static r d;
    private a e;

    public interface a {
        void a();

        void a(String str);
    }

    private r() {
    }

    public static r a() {
        if (d == null) {
            synchronized (r.class) {
                if (d == null) {
                    d = new r();
                }
            }
        }
        return d;
    }

    private r a(a aVar) {
        this.e = aVar;
        return this;
    }

    private void a(int i, String str) {
        String str2 = f2512b;
        ad.c(str2, "onRequestFailureOperate --> code=" + i + ",message=" + str);
        if (this.e != null) {
            this.e.a(str);
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

    public final void a(Context context, String str, String str2, a aVar) {
        try {
            this.e = aVar;
            UploadInstanceDataRequestInfo uploadInstanceDataRequestInfo = new UploadInstanceDataRequestInfo(com.cyjh.http.b.a.a().b(context));
            uploadInstanceDataRequestInfo.ScriptId = str;
            uploadInstanceDataRequestInfo.InstanceData = str2;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.ba).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, uploadInstanceDataRequestInfo);
            String str3 = f2512b;
            ad.c(str3, "uploadInstanceData --> url=" + uri + ",uploadInstanceDataRequestInfo=" + uploadInstanceDataRequestInfo.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str4 = f2512b;
            ad.c(str4, "bindStudioProject --> exception=" + e2.getMessage());
        }
    }

    public final void a(Object obj) {
        String str;
        String str2 = f2512b;
        ad.c(str2, "uiDataSuccess --> object=" + obj);
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int i = jSONObject.getInt("Code");
                String string = jSONObject.getString(b.d);
                if (i != 200) {
                    a(i, string);
                } else if (this.e != null) {
                    this.e.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = f2512b;
                ad.c(str3, "uiDataSuccess --> exception=" + e2.getMessage());
                str = e2.getMessage();
            }
        } else {
            str = "后台返回数据为空！";
            a(-1, str);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        String str2 = f2512b;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        a(-1, str);
    }
}
