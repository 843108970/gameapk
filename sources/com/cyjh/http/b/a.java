package com.cyjh.http.b;

import android.content.Context;
import android.text.TextUtils;
import com.cyjh.common.util.e;
import com.cyjh.common.util.h;
import com.cyjh.common.util.r;
import com.cyjh.http.bean.SignaClass;
import com.cyjh.http.bean.request.BaseRequestValueInfo;
import com.cyjh.http.bean.request.DeviceInfo;
import com.cyjh.http.bean.response.AliCloudServerResponse;
import com.cyjh.http.e.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class a {

    /* renamed from: b  reason: collision with root package name */
    public static long f2475b;
    private static a f;

    /* renamed from: a  reason: collision with root package name */
    public Context f2476a;

    /* renamed from: c  reason: collision with root package name */
    public DeviceInfo f2477c = new DeviceInfo();
    public AliCloudServerResponse d;
    public int e;

    private a() {
    }

    public static a a() {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a();
                }
            }
        }
        return f;
    }

    private static String a(String str, Object obj, int i) throws Exception {
        String a2 = r.a(obj);
        return TextUtils.isEmpty(a2) ? "" : h.a(a2, c.a(str, i).getBytes());
    }

    private Context b() {
        return this.f2476a;
    }

    private static int c() {
        return new Random().nextInt(8);
    }

    private boolean d() {
        return this.e == 1;
    }

    public final Map<String, String> a(String str, BaseRequestValueInfo baseRequestValueInfo) throws Exception {
        HashMap hashMap;
        synchronized (this) {
            SignaClass signaClass = new SignaClass();
            signaClass.SignContent = r.a((Object) baseRequestValueInfo);
            signaClass.Signature = c.a(signaClass.SignContent);
            int nextInt = new Random().nextInt(8);
            String a2 = r.a((Object) signaClass);
            String a3 = TextUtils.isEmpty(a2) ? "" : h.a(a2, c.a(str, nextInt).getBytes());
            hashMap = new HashMap();
            hashMap.put("Data", a3);
            hashMap.put("R", String.valueOf(nextInt));
            if (!TextUtils.isEmpty(com.cyjh.common.a.a.f1619b)) {
                hashMap.put("V", com.cyjh.common.a.a.f1619b);
            }
        }
        return hashMap;
    }

    public final void a(Context context) {
        this.f2476a = context.getApplicationContext();
    }

    public final BaseRequestValueInfo b(Context context) {
        BaseRequestValueInfo baseRequestValueInfo = new BaseRequestValueInfo();
        if (TextUtils.isEmpty(this.f2477c.DeviceCode) || TextUtils.isEmpty(this.f2477c.DeviceId)) {
            DeviceInfo c2 = com.cyjh.http.e.a.c(context);
            this.f2477c.DeviceId = c2.DeviceId;
            this.f2477c.DeviceCode = c2.DeviceCode;
        }
        baseRequestValueInfo.DeviceId = this.f2477c.DeviceId;
        baseRequestValueInfo.DeviceCode = this.f2477c.DeviceCode;
        baseRequestValueInfo.TemplateVersion = com.cyjh.common.a.a.d();
        baseRequestValueInfo.AppId = com.cyjh.common.a.a.c();
        baseRequestValueInfo.TemplateFileId = com.cyjh.common.a.a.b();
        baseRequestValueInfo.AppVersion = e.b();
        baseRequestValueInfo.AppInfo = com.cyjh.common.a.a.g();
        f2475b = System.currentTimeMillis() / 1000;
        baseRequestValueInfo.ClientTimestamp = f2475b;
        if (!TextUtils.isEmpty(com.cyjh.common.a.a.f1619b)) {
            baseRequestValueInfo.V = com.cyjh.common.a.a.f1619b;
        }
        return baseRequestValueInfo;
    }

    public final String b(String str, BaseRequestValueInfo baseRequestValueInfo) {
        String stringBuffer;
        synchronized (this) {
            StringBuffer stringBuffer2 = new StringBuffer(str);
            try {
                stringBuffer2.append("?AppId=");
                stringBuffer2.append(baseRequestValueInfo.AppId);
                stringBuffer2.append("&AppVersion=");
                stringBuffer2.append(baseRequestValueInfo.AppVersion);
                stringBuffer2.append("&PlatformId=");
                stringBuffer2.append(com.cyjh.http.a.c.a().e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }
}
