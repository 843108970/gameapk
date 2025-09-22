package com.elf.studio.c;

import android.content.Context;
import android.util.Log;
import com.cyjh.common.util.r;
import com.cyjh.elfin.a.b;
import com.cyjh.http.d.b.c;
import com.elf.studio.enity.IMRequestInfo;
import com.elf.studio.enity.IMResultInfo;
import com.hlzn.socketclient.f.d;
import java.util.Map;
import org.json.JSONObject;

public class a extends com.cyjh.http.c.a.a {

    /* renamed from: b  reason: collision with root package name */
    public static final String f2828b = "a";

    /* renamed from: c  reason: collision with root package name */
    private static a f2829c;
    private C0047a d;

    /* renamed from: com.elf.studio.c.a$a  reason: collision with other inner class name */
    public interface C0047a {
        void a();

        void b();
    }

    private a() {
    }

    private static a a() {
        if (f2829c == null) {
            synchronized (a.class) {
                if (f2829c == null) {
                    f2829c = new a();
                }
            }
        }
        return f2829c;
    }

    private void a(Context context, IMRequestInfo iMRequestInfo, C0047a aVar) {
        try {
            this.d = aVar;
            IMRequestInfo iMRequestInfo2 = new IMRequestInfo(com.cyjh.http.b.a.a().b(context));
            if (iMRequestInfo != null) {
                iMRequestInfo2.ScriptId = iMRequestInfo.ScriptId;
            }
            String uri = com.cyjh.common.a.a.a(com.cyjh.common.a.a.f, com.cyjh.common.b.a.aJ, com.cyjh.common.b.a.aW).build().toString();
            Map<String, String> a2 = com.cyjh.http.b.a.a().a(uri, iMRequestInfo2);
            String str = f2828b;
            d.b(str, "cloudIMInit --> 1 paramsMap=" + iMRequestInfo2.toString());
            String str2 = f2828b;
            d.b(str2, "cloudIMInit --> 2 url=" + uri + ",paramsMap=" + a2.toString());
            this.f2478a.a(context, getClass().getCanonicalName(), uri, a2);
        } catch (Exception e) {
            e.printStackTrace();
            String str3 = f2828b;
            Log.e(str3, "cloudIMInit --> exception=" + e.getMessage());
        }
    }

    private void b() {
        c.a().a((Object) getClass().getCanonicalName());
    }

    public final void a(Object obj) {
        try {
            String str = (String) obj;
            String str2 = f2828b;
            d.b(str2, "uiDataSuccess --> data=" + str);
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("Data");
            int i = jSONObject.getInt("Code");
            String string = jSONObject.getString(b.d);
            if (i == 200) {
                r.a(jSONObject2.toString(), IMResultInfo.class);
                return;
            }
            String str3 = f2828b;
            d.b(str3, "onUpdateFailure --> message=" + string);
        } catch (Exception e) {
            String str4 = f2828b;
            Log.e(str4, "uiDataSuccess --> exception message=" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        String str2 = f2828b;
        Log.e(str2, "onErrorResponse --> exception message=" + str);
    }
}
