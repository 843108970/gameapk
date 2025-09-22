package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.DomainNameRequestParamsInfo;
import com.cyjh.http.bean.response.DomainResult;
import com.cyjh.http.d.b.c;
import org.json.JSONObject;

public class a extends com.cyjh.http.c.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2482c = "a";
    private static a d;

    /* renamed from: b  reason: collision with root package name */
    public C0040a f2483b;

    /* renamed from: com.cyjh.http.c.c.a$a  reason: collision with other inner class name */
    public interface C0040a {
        void a(int i, String str);

        void a(DomainResult domainResult);
    }

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    private void a(int i, String str) {
        String str2 = f2482c;
        ad.c(str2, "onRequestFailureOperate --> code=" + i + ",message=" + str);
        if (this.f2483b != null) {
            this.f2483b.a(i, str);
        }
    }

    private void a(Context context, C0040a aVar) {
        try {
            this.f2483b = aVar;
            DomainNameRequestParamsInfo domainNameRequestParamsInfo = new DomainNameRequestParamsInfo(com.cyjh.http.b.a.a().b(context));
            String str = f2482c;
            ad.c(str, "getDomainNameSecond --> domainNameRequestParams=" + domainNameRequestParamsInfo.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), com.cyjh.common.b.a.f1623c, com.cyjh.http.b.a.a().a(com.cyjh.common.b.a.f1623c, domainNameRequestParamsInfo));
        } catch (Exception e) {
            String str2 = f2482c;
            ad.c(str2, "getDomainNameSecond --> exception=" + e.getMessage());
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

    private a d() {
        this.f2483b = null;
        return this;
    }

    public final void a(Context context, int i, C0040a aVar) {
        try {
            this.f2483b = aVar;
            DomainNameRequestParamsInfo domainNameRequestParamsInfo = new DomainNameRequestParamsInfo(com.cyjh.http.b.a.a().b(context));
            String str = f2482c;
            ad.c(str, "getDomainNameFirst --> domainNameRequestParams=" + domainNameRequestParamsInfo.toString());
            String str2 = i % 2 == 1 ? com.cyjh.common.b.a.d : com.cyjh.common.b.a.f1622b;
            this.f2478a.a(context, getClass().getCanonicalName(), str2, com.cyjh.http.b.a.a().a(str2, domainNameRequestParamsInfo));
        } catch (Exception e) {
            String str3 = f2482c;
            ad.c(str3, "getDomainNameFirst --> exception=" + e.getMessage());
        }
    }

    public final void a(Object obj) {
        String str;
        String str2 = f2482c;
        ad.c(str2, "uiDataSuccess --> object=" + obj);
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int i = jSONObject.getInt("Code");
                String string = jSONObject.getString(b.d);
                if (i == 200) {
                    DomainResult domainResult = (DomainResult) r.a(jSONObject.getJSONObject("Data").toString(), DomainResult.class);
                    if (this.f2483b != null) {
                        this.f2483b.a(domainResult);
                        return;
                    }
                    return;
                }
                a(i, string);
            } catch (Exception e) {
                e.printStackTrace();
                String str3 = f2482c;
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
        String str2 = f2482c;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        a(-1, str);
    }
}
