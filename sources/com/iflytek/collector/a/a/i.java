package com.iflytek.collector.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iflytek.collector.a.a.g;
import com.iflytek.voiceads.config.SDKLogger;
import org.json.JSONObject;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f3503a;

    /* renamed from: b  reason: collision with root package name */
    private g.a f3504b = new j(this);

    i(Context context) {
        this.f3503a = context;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("rsp");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("des");
                if (!TextUtils.isEmpty(optString)) {
                    SharedPreferences b2 = k.b(this.f3503a);
                    String string = b2.getString("ifly_dynamic_business_conf", "");
                    SharedPreferences.Editor edit = b2.edit();
                    if ("no".equals(optString)) {
                        if (!TextUtils.isEmpty(string)) {
                            edit.putString("ifly_dynamic_business_conf", "");
                            edit.apply();
                        }
                    } else if (!optString.equals(string)) {
                        edit.putString("ifly_dynamic_business_conf", optString);
                        edit.apply();
                    }
                }
            }
        } catch (Throwable th) {
            SDKLogger.e("Collector", "parse result error:" + th.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = com.iflytek.collector.a.a.b.a(r6.f3503a);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3503a     // Catch:{ Throwable -> 0x0090 }
            boolean r0 = com.iflytek.collector.a.a.k.a(r0)     // Catch:{ Throwable -> 0x0090 }
            if (r0 == 0) goto L_0x008f
            android.content.Context r0 = r6.f3503a     // Catch:{ Throwable -> 0x0090 }
            com.iflytek.collector.a.a.b r0 = com.iflytek.collector.a.a.b.a((android.content.Context) r0)     // Catch:{ Throwable -> 0x0090 }
            org.json.JSONObject r1 = r0.a()     // Catch:{ Throwable -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            com.iflytek.collector.a.a.g r2 = new com.iflytek.collector.a.a.g     // Catch:{ Throwable -> 0x0090 }
            r2.<init>()     // Catch:{ Throwable -> 0x0090 }
            r3 = 20000(0x4e20, float:2.8026E-41)
            r2.b((int) r3)     // Catch:{ Throwable -> 0x0090 }
            r3 = 1
            r2.a((int) r3)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r3 = "utf-8"
            byte[] r1 = r1.getBytes(r3)     // Catch:{ Throwable -> 0x0090 }
            byte[] r1 = com.iflytek.collector.a.a.f.a((byte[]) r1)     // Catch:{ Throwable -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0090 }
            r3.<init>()     // Catch:{ Throwable -> 0x0090 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r5 = "product=freelog&appid="
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r5 = r0.e()     // Catch:{ Throwable -> 0x0090 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0090 }
            r3.append(r4)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r0 = r0.f()     // Catch:{ Throwable -> 0x0090 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0090 }
            if (r4 != 0) goto L_0x0067
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r5 = "&subid="
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0090 }
            r4.append(r0)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r0 = r4.toString()     // Catch:{ Throwable -> 0x0090 }
            r3.append(r0)     // Catch:{ Throwable -> 0x0090 }
        L_0x0067:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r4 = "&size="
            r0.<init>(r4)     // Catch:{ Throwable -> 0x0090 }
            int r4 = r1.length     // Catch:{ Throwable -> 0x0090 }
            r0.append(r4)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r4 = "&platform=android&source=daas&pv=1.1"
            r0.append(r4)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0090 }
            r3.append(r0)     // Catch:{ Throwable -> 0x0090 }
            java.lang.String r0 = "https://log.iflytek.com/log"
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x0090 }
            r2.a(r0, r3, r1)     // Catch:{ Throwable -> 0x0090 }
            com.iflytek.collector.a.a.g$a r0 = r6.f3504b     // Catch:{ Throwable -> 0x0090 }
            r2.a((com.iflytek.collector.a.a.g.a) r0)     // Catch:{ Throwable -> 0x0090 }
            r2.a()     // Catch:{ Throwable -> 0x0090 }
        L_0x008f:
            return
        L_0x0090:
            r0 = move-exception
            java.lang.String r1 = "Collector"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "exception occur while upload:"
            r2.<init>(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.iflytek.voiceads.config.SDKLogger.e(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.collector.a.a.i.run():void");
    }
}
