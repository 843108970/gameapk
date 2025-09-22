package com.umeng.commonsdk.amap;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.e;
import java.util.Vector;
import org.json.JSONObject;

public class b extends Thread {
    private static final String e = "info";
    private static final String f = "ts";
    private static final String g = "amap_lbs";
    private static final String h = "tp";

    /* renamed from: a  reason: collision with root package name */
    private Context f3661a;

    /* renamed from: b  reason: collision with root package name */
    private int f3662b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f3663c;
    private Vector<JSONObject> d;
    private int i = 1;
    private int j = 1;

    public b(Context context, int i2, long j2) {
        e.a("AmapLBS", "new UMAmapTimer");
        if (context != null) {
            this.f3661a = context.getApplicationContext();
            this.f3662b = i2;
            this.f3663c = j2;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00b9 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c3 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[Catch:{ Exception -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A[Catch:{ Exception -> 0x0152 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[Catch:{ Exception -> 0x0152 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
            android.content.Context r0 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = r6.f3662b     // Catch:{ Exception -> 0x0152 }
            r1 = 1
            if (r0 != r1) goto L_0x013d
            boolean r0 = com.umeng.commonsdk.statistics.common.e.f3885a     // Catch:{ Exception -> 0x0152 }
            r2 = 0
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = "AmapLBS"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0152 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
            java.lang.String r5 = "[lbs-build] timer begin : index is "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0152 }
            int r5 = r6.i     // Catch:{ Exception -> 0x0152 }
            r4.append(r5)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0152 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0152 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0152 }
            int r0 = r6.i     // Catch:{ Exception -> 0x0152 }
            int r0 = r0 + r1
            r6.i = r0     // Catch:{ Exception -> 0x0152 }
        L_0x002d:
            com.umeng.commonsdk.amap.a r0 = new com.umeng.commonsdk.amap.a     // Catch:{ Exception -> 0x0152 }
            android.content.Context r3 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0152 }
            byte[] r0 = r0.b()     // Catch:{ Exception -> 0x0152 }
            if (r0 == 0) goto L_0x0134
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0152 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0152 }
            if (r3 != 0) goto L_0x0128
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0152 }
            r3.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "info"
            r3.put(r4, r0)     // Catch:{ Exception -> 0x005b }
            java.lang.String r0 = "ts"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005b }
            r3.put(r0, r4)     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            java.util.Vector<org.json.JSONObject> r0 = r6.d     // Catch:{ Exception -> 0x0152 }
            if (r0 != 0) goto L_0x0066
            java.util.Vector r0 = new java.util.Vector     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            r6.d = r0     // Catch:{ Exception -> 0x0152 }
        L_0x0066:
            java.util.Vector<org.json.JSONObject> r0 = r6.d     // Catch:{ Exception -> 0x0152 }
            r0.add(r3)     // Catch:{ Exception -> 0x0152 }
            java.util.Vector<org.json.JSONObject> r0 = r6.d     // Catch:{ Exception -> 0x0152 }
            int r0 = r0.size()     // Catch:{ Exception -> 0x0152 }
            r3 = 30
            if (r0 != r3) goto L_0x0143
            java.lang.String r0 = "AmapLBS"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0152 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
            java.lang.String r5 = "[lbs-build] begin build envelope , cache size is "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0152 }
            java.util.Vector<org.json.JSONObject> r5 = r6.d     // Catch:{ Exception -> 0x0152 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x0152 }
            r4.append(r5)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0152 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0152 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0152 }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.util.Vector<org.json.JSONObject> r3 = r6.d     // Catch:{ Exception -> 0x0152 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0152 }
        L_0x009d:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0152 }
            if (r4 == 0) goto L_0x00af
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0152 }
            org.json.JSONObject r4 = (org.json.JSONObject) r4     // Catch:{ Exception -> 0x0152 }
            if (r4 == 0) goto L_0x009d
            r0.put(r4)     // Catch:{ Exception -> 0x009d }
            goto L_0x009d
        L_0x00af:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0152 }
            r3.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "amap_lbs"
            r3.put(r4, r0)     // Catch:{ Exception -> 0x00b9 }
        L_0x00b9:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "tp"
            r0.put(r4, r3)     // Catch:{ Exception -> 0x00c3 }
        L_0x00c3:
            java.util.Vector<org.json.JSONObject> r3 = r6.d     // Catch:{ Exception -> 0x0152 }
            if (r3 == 0) goto L_0x00cf
            java.util.Vector<org.json.JSONObject> r3 = r6.d     // Catch:{ Exception -> 0x0152 }
            r3.clear()     // Catch:{ Exception -> 0x0152 }
            r3 = 0
            r6.d = r3     // Catch:{ Exception -> 0x0152 }
        L_0x00cf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
            r3.<init>()     // Catch:{ Exception -> 0x0152 }
            android.content.Context r4 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x0152 }
            r3.append(r4)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "/stateless/"
            r3.append(r4)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "umpx_oplus_lbs"
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ Exception -> 0x0152 }
            r3.append(r4)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0152 }
            android.content.Context r4 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            r5 = 50
            com.umeng.commonsdk.stateless.f.a(r4, r3, r5)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = "AmapLBS"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0152 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0152 }
            java.lang.String r5 = "[lbs-build] begin build envelope is "
            r4.<init>(r5)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0152 }
            r4.append(r5)     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0152 }
            r1[r2] = r4     // Catch:{ Exception -> 0x0152 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r3, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x0152 }
            com.umeng.commonsdk.stateless.UMSLEnvelopeBuild r1 = new com.umeng.commonsdk.stateless.UMSLEnvelopeBuild     // Catch:{ Exception -> 0x0152 }
            r1.<init>()     // Catch:{ Exception -> 0x0152 }
            android.content.Context r2 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            org.json.JSONObject r2 = r1.buildSLBaseHeader(r2)     // Catch:{ Exception -> 0x0152 }
            android.content.Context r3 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            java.lang.String r4 = "umpx_oplus_lbs"
            r1.buildSLEnvelope(r3, r2, r0, r4)     // Catch:{ Exception -> 0x0152 }
            goto L_0x0143
        L_0x0128:
            java.lang.String r0 = "AmapLBS"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = "[lbs-build] amap result is empty"
            r1[r2] = r3     // Catch:{ Exception -> 0x0152 }
        L_0x0130:
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x0152 }
            goto L_0x0143
        L_0x0134:
            java.lang.String r0 = "AmapLBS"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = "[lbs-build] amap result is null"
            r1[r2] = r3     // Catch:{ Exception -> 0x0152 }
            goto L_0x0130
        L_0x013d:
            int r0 = r6.f3662b     // Catch:{ Exception -> 0x0152 }
            r1 = 2
            if (r0 == r1) goto L_0x0143
            return
        L_0x0143:
            long r0 = r6.f3663c     // Catch:{ Exception -> 0x014a }
            sleep(r0)     // Catch:{ Exception -> 0x014a }
            goto L_0x0005
        L_0x014a:
            r0 = move-exception
            android.content.Context r1 = r6.f3661a     // Catch:{ Exception -> 0x0152 }
            com.umeng.commonsdk.proguard.e.a(r1, r0)     // Catch:{ Exception -> 0x0152 }
            goto L_0x0005
        L_0x0152:
            r0 = move-exception
            android.content.Context r1 = r6.f3661a
            com.umeng.commonsdk.proguard.e.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.amap.b.run():void");
    }
}
