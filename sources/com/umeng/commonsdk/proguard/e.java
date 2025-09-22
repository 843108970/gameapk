package com.umeng.commonsdk.proguard;

import android.content.Context;

public class e {
    public static void a(final Context context, final Throwable th) {
        new Thread(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|(4:9|10|11|(1:13)))|14|15) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0082 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    monitor-enter(r6)     // Catch:{ Throwable -> 0x0087 }
                    android.content.Context r0 = r2     // Catch:{ all -> 0x0084 }
                    if (r0 == 0) goto L_0x0082
                    java.lang.Throwable r0 = r3     // Catch:{ all -> 0x0084 }
                    if (r0 == 0) goto L_0x0082
                    java.lang.Throwable r0 = r3     // Catch:{ all -> 0x0084 }
                    java.lang.String r0 = com.umeng.commonsdk.proguard.f.a(r0)     // Catch:{ all -> 0x0084 }
                    boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0084 }
                    if (r1 != 0) goto L_0x0082
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
                    r1.<init>()     // Catch:{ all -> 0x0084 }
                    android.content.Context r2 = r2     // Catch:{ all -> 0x0084 }
                    java.io.File r2 = r2.getFilesDir()     // Catch:{ all -> 0x0084 }
                    r1.append(r2)     // Catch:{ all -> 0x0084 }
                    java.lang.String r2 = "/stateless/"
                    r1.append(r2)     // Catch:{ all -> 0x0084 }
                    java.lang.String r2 = "umpx_crash"
                    byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0084 }
                    r3 = 0
                    java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ all -> 0x0084 }
                    r1.append(r2)     // Catch:{ all -> 0x0084 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0084 }
                    android.content.Context r2 = r2     // Catch:{ all -> 0x0084 }
                    r3 = 50
                    com.umeng.commonsdk.stateless.f.a(r2, r1, r3)     // Catch:{ all -> 0x0084 }
                    com.umeng.commonsdk.stateless.UMSLEnvelopeBuild r1 = new com.umeng.commonsdk.stateless.UMSLEnvelopeBuild     // Catch:{ all -> 0x0084 }
                    r1.<init>()     // Catch:{ all -> 0x0084 }
                    android.content.Context r2 = r2     // Catch:{ all -> 0x0084 }
                    org.json.JSONObject r2 = r1.buildSLBaseHeader(r2)     // Catch:{ all -> 0x0084 }
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0082 }
                    r3.<init>()     // Catch:{ JSONException -> 0x0082 }
                    java.lang.String r4 = "content"
                    r3.put(r4, r0)     // Catch:{ JSONException -> 0x0082 }
                    java.lang.String r0 = "ts"
                    long r4 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0082 }
                    r3.put(r0, r4)     // Catch:{ JSONException -> 0x0082 }
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0082 }
                    r0.<init>()     // Catch:{ JSONException -> 0x0082 }
                    java.lang.String r4 = "crash"
                    r0.put(r4, r3)     // Catch:{ JSONException -> 0x0082 }
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0082 }
                    r3.<init>()     // Catch:{ JSONException -> 0x0082 }
                    java.lang.String r4 = "tp"
                    r3.put(r4, r0)     // Catch:{ JSONException -> 0x0082 }
                    android.content.Context r0 = r2     // Catch:{ JSONException -> 0x0082 }
                    java.lang.String r4 = "umpx_internal"
                    org.json.JSONObject r0 = r1.buildSLEnvelope(r0, r2, r3, r4)     // Catch:{ JSONException -> 0x0082 }
                    if (r0 == 0) goto L_0x0082
                    java.lang.String r1 = "exception"
                    r0.has(r1)     // Catch:{ JSONException -> 0x0082 }
                L_0x0082:
                    monitor-exit(r6)     // Catch:{ all -> 0x0084 }
                    return
                L_0x0084:
                    r0 = move-exception
                    monitor-exit(r6)     // Catch:{ all -> 0x0084 }
                    throw r0     // Catch:{ Throwable -> 0x0087 }
                L_0x0087:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.e.AnonymousClass1.run():void");
            }
        }).start();
    }
}
