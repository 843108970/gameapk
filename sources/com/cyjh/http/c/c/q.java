package com.cyjh.http.c.c;

import android.content.Context;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.a.b;
import com.cyjh.http.bean.request.UploadDeviceScreenshotRequestInfo;
import com.cyjh.http.d.b.c;
import java.util.Map;
import org.json.JSONObject;

public class q extends com.cyjh.http.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f2510b = "q";

    /* renamed from: c  reason: collision with root package name */
    private static final long f2511c = 1;
    private static q d;
    private a e;

    public interface a {
        void a();

        void b();
    }

    private q() {
    }

    public static q a() {
        if (d == null) {
            synchronized (q.class) {
                if (d == null) {
                    d = new q();
                }
            }
        }
        return d;
    }

    private q a(a aVar) {
        this.e = aVar;
        return this;
    }

    private static void a(int i, String str) {
        String str2 = f2510b;
        ad.c(str2, "onRequestFailureOperate --> code=" + i + ",message=" + str);
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
            UploadDeviceScreenshotRequestInfo uploadDeviceScreenshotRequestInfo = new UploadDeviceScreenshotRequestInfo(com.cyjh.http.b.a.a().b(context));
            uploadDeviceScreenshotRequestInfo.ScriptId = str;
            uploadDeviceScreenshotRequestInfo.ImageOssPath = str2;
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.aX).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, uploadDeviceScreenshotRequestInfo);
            String str3 = f2510b;
            ad.c(str3, "uploadDeviceScreenshot --> url=" + uri + "scriptId=" + str + ",imageOssPath=" + str2);
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e2) {
            e2.printStackTrace();
            String str4 = f2510b;
            ad.c(str4, "uploadDeviceScreenshot --> exception=" + e2.getMessage());
        }
    }

    public final void a(Object obj) {
        String str;
        String str2 = f2510b;
        ad.c(str2, "uiDataSuccess --> object=" + obj);
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                int i = jSONObject.getInt("Code");
                String string = jSONObject.getString(b.d);
                if (i != 200) {
                    a(i, string);
                } else if (this.e == null) {
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str3 = f2510b;
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
        String str2 = f2510b;
        ad.c(str2, "onErrorResponse --> errorMsg=" + str);
        a(-1, str);
    }
}
