package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static JSONObject f3647a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f3648b = new HashMap();

    public static void a(Context context) {
        if (context != null) {
            try {
                synchronized (f3647a) {
                    if (f3647a.length() > 0) {
                        g.a(context).a(o.a().d(), f3647a, g.a.PAGE);
                        f3647a = new JSONObject();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a() {
        String str;
        synchronized (this.f3648b) {
            str = null;
            long j = 0;
            for (Map.Entry next : this.f3648b.entrySet()) {
                if (((Long) next.getValue()).longValue() > j) {
                    long longValue = ((Long) next.getValue()).longValue();
                    str = (String) next.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3648b) {
                this.f3648b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0047
            java.util.Map<java.lang.String, java.lang.Long> r0 = r6.f3648b
            boolean r0 = r0.containsKey(r7)
            if (r0 == 0) goto L_0x0047
            java.util.Map<java.lang.String, java.lang.Long> r0 = r6.f3648b
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Long> r1 = r6.f3648b     // Catch:{ all -> 0x0044 }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x0044 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r2 = java.lang.System.currentTimeMillis()
            long r0 = r1.longValue()
            long r4 = r2 - r0
            org.json.JSONObject r1 = f3647a
            monitor-enter(r1)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0040 }
            r0.<init>()     // Catch:{ Throwable -> 0x0040 }
            f3647a = r0     // Catch:{ Throwable -> 0x0040 }
            java.lang.String r2 = "page_name"
            r0.put(r2, r7)     // Catch:{ Throwable -> 0x0040 }
            org.json.JSONObject r7 = f3647a     // Catch:{ Throwable -> 0x0040 }
            java.lang.String r0 = "duration"
            r7.put(r0, r4)     // Catch:{ Throwable -> 0x0040 }
            goto L_0x0040
        L_0x003e:
            r7 = move-exception
            goto L_0x0042
        L_0x0040:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            return
        L_0x0042:
            monitor-exit(r1)     // Catch:{ all -> 0x003e }
            throw r7
        L_0x0044:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r7
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.p.b(java.lang.String):void");
    }
}
