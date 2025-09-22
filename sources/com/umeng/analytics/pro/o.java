package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.b;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3643a = "session_start_time";

    /* renamed from: b  reason: collision with root package name */
    private static final String f3644b = "session_end_time";

    /* renamed from: c  reason: collision with root package name */
    private static final String f3645c = "session_id";
    private static String f;
    private static Context g;
    private final String d;
    private final String e;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final o f3646a = new o();

        private a() {
        }
    }

    private o() {
        this.d = "a_start_time";
        this.e = "a_end_time";
    }

    public static o a() {
        return a.f3646a;
    }

    private String a(Context context, SharedPreferences sharedPreferences, long j) {
        if (g == null && context != null) {
            g = context.getApplicationContext();
        }
        String b2 = b(g);
        try {
            d(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j);
            g.a(g).a(b2, jSONObject, g.a.BEGIN);
            a(g);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(f3645c, b2);
            edit.putLong(f3643a, j);
            edit.putLong(f3644b, 0);
            edit.putLong("a_start_time", j);
            edit.putLong("a_end_time", 0);
            edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
            edit.putString(b.al, UMUtils.getAppVersionName(context));
            edit.commit();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject i = b.a().i();
            if (i.length() > 0) {
                jSONObject2.put(b.ab, i);
            }
            jSONObject2.put(b.ad, b2);
            jSONObject2.put("__ii", b2);
            jSONObject2.put(b.ae, j);
            i.a(g).c((Object) jSONObject2);
        } catch (Throwable unused) {
        }
        return b2;
    }

    private void a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(f3643a);
        edit.remove(f3644b);
        edit.remove("a_start_time");
        edit.remove("a_end_time");
        edit.commit();
    }

    private boolean a(SharedPreferences sharedPreferences, long j) {
        long j2 = sharedPreferences.getLong("a_start_time", 0);
        long j3 = sharedPreferences.getLong("a_end_time", 0);
        if (j2 != 0 && j - j2 < AnalyticsConfig.kContinueSessionMillis) {
            MLog.e("onResume called before onPause");
            return false;
        } else if (j - j3 <= AnalyticsConfig.kContinueSessionMillis) {
            return false;
        } else {
            try {
                String string = sharedPreferences.getString(f3645c, "-1");
                long j4 = sharedPreferences.getLong(f3644b, 0);
                if ("-1".equals(string)) {
                    return true;
                }
                if (j4 == 0) {
                    j4 = System.currentTimeMillis();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(c.e.a.g, j4);
                g.a(g).a(string, jSONObject, g.a.END);
                if (!AnalyticsConfig.FLAG_DPLUS) {
                    return true;
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject i = b.a().i();
                if (i.length() > 0) {
                    jSONObject2.put(b.ab, i);
                }
                jSONObject2.put(b.af, string);
                jSONObject2.put("__ii", string);
                jSONObject2.put(b.ag, j4);
                i.a(g).a(jSONObject2, 3, false);
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    private void d(Context context) {
        i.a(context).b(context);
        i.a(context).a();
    }

    public void a(Context context, Object obj) {
        try {
            if (g == null && context != null) {
                g = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(g);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String string = sharedPreferences.getString(b.al, "");
                String appVersionName = UMUtils.getAppVersionName(g);
                if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                    int i = sharedPreferences.getInt("versioncode", 0);
                    String string2 = sharedPreferences.getString("pre_date", "");
                    String string3 = sharedPreferences.getString("pre_version", "");
                    String string4 = sharedPreferences.getString(b.al, "");
                    edit.putString("vers_date", string2);
                    edit.putString("vers_pre_version", string3);
                    edit.putString("cur_version", string4);
                    edit.putString("dp_vers_date", string2);
                    edit.putString("dp_vers_pre_version", string3);
                    edit.putString("dp_cur_version", string4);
                    edit.putInt("vers_code", i);
                    edit.putString("vers_name", string);
                    edit.putInt("dp_vers_code", i);
                    edit.putString("dp_vers_name", string);
                    edit.putLong("a_end_time", 0);
                    edit.commit();
                    if (c(context) == null) {
                        f = a(context, sharedPreferences, longValue);
                    }
                    a(g, longValue);
                    b(g, longValue);
                } else if (a(sharedPreferences, longValue)) {
                    f = a(context, sharedPreferences, longValue);
                    MLog.i("Start new session: " + f);
                } else {
                    f = sharedPreferences.getString(f3645c, (String) null);
                    edit.putLong("a_start_time", longValue);
                    edit.putLong("a_end_time", 0);
                    edit.commit();
                    MLog.i("Extend current session: " + f);
                    d(context);
                    i.a(g).a(false);
                    i.a(g).d();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        String string = sharedPreferences.getString(f3645c, (String) null);
        if (string == null) {
            return false;
        }
        long j = sharedPreferences.getLong(f3643a, 0);
        long j2 = sharedPreferences.getLong(f3644b, 0);
        if (j2 != 0) {
            Math.abs(j2 - j);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", string);
            jSONObject.put("__e", j);
            jSONObject.put(c.e.a.g, j2);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(c.e.a.e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", new Class[]{Integer.TYPE});
            Method method2 = cls.getMethod("getUidTxBytes", new Class[]{Integer.TYPE});
            int i = context.getApplicationInfo().uid;
            if (i == -1) {
                return false;
            }
            long longValue = ((Long) method.invoke((Object) null, new Object[]{Integer.valueOf(i)})).longValue();
            long longValue2 = ((Long) method2.invoke((Object) null, new Object[]{Integer.valueOf(i)})).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(b.C, longValue);
                jSONObject3.put(b.B, longValue2);
                jSONObject.put(c.e.a.d, jSONObject3);
            }
            g.a(context).a(string, jSONObject, g.a.NEWSESSION);
            p.a(g);
            h.b(g);
            a(sharedPreferences);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|(1:27)(5:13|14|15|16|(5:18|(1:22)|23|(1:25)|26))|28|29|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r12, long r13) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            android.content.SharedPreferences r2 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r12)     // Catch:{ Throwable -> 0x0099 }
            if (r2 != 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r3 = "session_id"
            r4 = 0
            java.lang.String r3 = r2.getString(r3, r4)     // Catch:{ Throwable -> 0x0099 }
            if (r3 != 0) goto L_0x0013
            return r1
        L_0x0013:
            java.lang.String r4 = "a_start_time"
            r5 = 0
            long r7 = r2.getLong(r4, r5)     // Catch:{ Throwable -> 0x0099 }
            java.lang.String r4 = "a_end_time"
            long r9 = r2.getLong(r4, r5)     // Catch:{ Throwable -> 0x0099 }
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x0094
            int r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0094
            android.content.Context r1 = g     // Catch:{ Throwable -> 0x009a }
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ Throwable -> 0x009a }
            r11.b((android.content.Context) r1, (java.lang.Object) r2)     // Catch:{ Throwable -> 0x009a }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0095 }
            r1.<init>()     // Catch:{ Throwable -> 0x0095 }
            java.lang.String r2 = "__f"
            r1.put(r2, r13)     // Catch:{ Throwable -> 0x0095 }
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a((android.content.Context) r12)     // Catch:{ Throwable -> 0x0095 }
            com.umeng.analytics.pro.g$a r4 = com.umeng.analytics.pro.g.a.END     // Catch:{ Throwable -> 0x0095 }
            r2.a((java.lang.String) r3, (org.json.JSONObject) r1, (com.umeng.analytics.pro.g.a) r4)     // Catch:{ Throwable -> 0x0095 }
            android.content.Context r1 = g     // Catch:{ Throwable -> 0x0095 }
            com.umeng.analytics.pro.i r1 = com.umeng.analytics.pro.i.a((android.content.Context) r1)     // Catch:{ Throwable -> 0x0095 }
            r1.b()     // Catch:{ Throwable -> 0x0095 }
            boolean r1 = com.umeng.analytics.AnalyticsConfig.FLAG_DPLUS     // Catch:{ Throwable -> 0x0095 }
            if (r1 == 0) goto L_0x0095
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0095 }
            r1.<init>()     // Catch:{ Throwable -> 0x0095 }
            com.umeng.analytics.b r2 = com.umeng.analytics.b.a()     // Catch:{ Throwable -> 0x0095 }
            org.json.JSONObject r2 = r2.c()     // Catch:{ Throwable -> 0x0095 }
            if (r2 == 0) goto L_0x0067
            int r4 = r2.length()     // Catch:{ Throwable -> 0x0095 }
            if (r4 > 0) goto L_0x006f
        L_0x0067:
            com.umeng.analytics.b r2 = com.umeng.analytics.b.a()     // Catch:{ Throwable -> 0x0095 }
            org.json.JSONObject r2 = r2.i()     // Catch:{ Throwable -> 0x0095 }
        L_0x006f:
            int r4 = r2.length()     // Catch:{ Throwable -> 0x0095 }
            if (r4 <= 0) goto L_0x007a
            java.lang.String r4 = "_$!sp"
            r1.put(r4, r2)     // Catch:{ Throwable -> 0x0095 }
        L_0x007a:
            java.lang.String r2 = "_$!s_e"
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x0095 }
            java.lang.String r2 = "__ii"
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x0095 }
            java.lang.String r2 = "_$!ts_e"
            r1.put(r2, r13)     // Catch:{ Throwable -> 0x0095 }
            android.content.Context r13 = g     // Catch:{ Throwable -> 0x0095 }
            com.umeng.analytics.pro.i r13 = com.umeng.analytics.pro.i.a((android.content.Context) r13)     // Catch:{ Throwable -> 0x0095 }
            r14 = 3
            r13.a(r1, r14, r0)     // Catch:{ Throwable -> 0x0095 }
            goto L_0x0095
        L_0x0094:
            r0 = 0
        L_0x0095:
            r11.a((android.content.Context) r12)     // Catch:{ Throwable -> 0x009a }
            return r0
        L_0x0099:
            r0 = 0
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.o.a(android.content.Context, long):boolean");
    }

    public String b(Context context) {
        String deviceId = DeviceConfig.getDeviceId(context);
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check!");
        }
        String MD5 = UMUtils.MD5(currentTimeMillis + appkey + deviceId);
        f = MD5;
        return MD5;
    }

    public void b(Context context, long j) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        if (sharedPreferences != null) {
            f = b(context);
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(f3645c, f);
                edit.putLong(f3643a, j);
                edit.putLong(f3644b, 0);
                edit.putLong("a_start_time", j);
                edit.putLong("a_end_time", 0);
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(g)));
                edit.putString(b.al, UMUtils.getAppVersionName(g));
                edit.commit();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__e", j);
                g.a(g).a(f, jSONObject, g.a.BEGIN);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject i = b.a().i();
                if (i.length() > 0) {
                    jSONObject2.put(b.ab, i);
                }
                jSONObject2.put(b.ad, f);
                jSONObject2.put("__ii", f);
                jSONObject2.put(b.ae, j);
                i.a(g).b((Object) jSONObject2);
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context, Object obj) {
        try {
            if (g == null && context != null) {
                g = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null) {
                if (sharedPreferences.getLong("a_start_time", 0) != 0 || !AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong("a_end_time", longValue);
                    edit.putLong(f3644b, longValue);
                    edit.commit();
                    return;
                }
                MLog.e("onPause called before onResume");
            }
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(g);
        if (sharedPreferences == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("a_start_time", 0);
        return (j == 0 || currentTimeMillis - j >= AnalyticsConfig.kContinueSessionMillis) && currentTimeMillis - sharedPreferences.getLong("a_end_time", 0) > AnalyticsConfig.kContinueSessionMillis;
    }

    public String c() {
        return f;
    }

    public String c(Context context) {
        try {
            if (f == null) {
                return PreferenceWrapper.getDefault(context).getString(f3645c, (String) null);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public String d() {
        return c(g);
    }
}
