package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.e;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3772a = "umeng_common_config";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3773b = "location_json";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3774c = "lng";
    public static final String d = "lat";
    public static final String e = "ts";
    private static final String f = "UMSysLocationCache";

    public static void a(final Context context) {
        e.a(f, "begin location");
        if (context != null) {
            try {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            Looper.prepare();
                            final g gVar = new g(context);
                            gVar.a((i) new i() {
                                public void a(Location location) {
                                    if (location != null) {
                                        double longitude = location.getLongitude();
                                        double latitude = location.getLatitude();
                                        e.a(h.f, "lon is " + longitude + ", lat is " + latitude);
                                        if (!(longitude == 0.0d || latitude == 0.0d)) {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("lng", longitude);
                                                jSONObject.put("lat", latitude);
                                                jSONObject.put("ts", currentTimeMillis);
                                            } catch (JSONException e) {
                                                e.a(h.f, "e is " + e);
                                            }
                                            e.a(h.f, "locationJSONObject is " + jSONObject.toString());
                                            UMWorkDispatch.sendEvent(context, a.f, b.a(context).a(), jSONObject.toString());
                                        }
                                    }
                                    gVar.a();
                                }
                            });
                            Looper.loop();
                        } catch (Throwable th) {
                            e.a(context, th);
                        }
                    }
                }).start();
            } catch (Exception e2) {
                e.a(f, "e is " + e2);
                e.a(context, e2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject b(android.content.Context r8) {
        /*
            java.lang.String r0 = "umeng_common_config"
            r1 = 0
            android.content.SharedPreferences r0 = r8.getSharedPreferences(r0, r1)
            r2 = 0
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            r3 = 1
            java.lang.String r4 = "location_json"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.getString(r4, r5)     // Catch:{ JSONException -> 0x0037, Throwable -> 0x0021 }
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0037, Throwable -> 0x0021 }
            if (r4 != 0) goto L_0x0052
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0037, Throwable -> 0x0021 }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0037, Throwable -> 0x0021 }
            r2 = r4
            goto L_0x0052
        L_0x0021:
            r0 = move-exception
            java.lang.String r4 = "UMSysLocationCache"
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "e is "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5[r1] = r6
            goto L_0x004c
        L_0x0037:
            r0 = move-exception
            java.lang.String r4 = "UMSysLocationCache"
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "e is "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5[r1] = r6
        L_0x004c:
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r4, (java.lang.Object[]) r5)
            com.umeng.commonsdk.proguard.e.a(r8, r0)
        L_0x0052:
            if (r2 == 0) goto L_0x006f
            java.lang.String r0 = "UMSysLocationCache"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "json str is "
            r4.<init>(r5)
            java.lang.String r5 = r2.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3[r1] = r4
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r3)
        L_0x006f:
            a(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.h.b(android.content.Context):org.json.JSONObject");
    }
}
