package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.framework.c;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("f", j.c());
            jSONObject.put("t", j.d());
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void a(Context context) {
        e.a("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            try {
                if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                    UMWorkDispatch.sendEvent(context, a.e, b.a(context).a(), (Object) null);
                }
            } catch (Throwable th) {
                e.a(context, th);
            }
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getApplicationContext().getPackageManager()) != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
            a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
            a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
            a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
            a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
        }
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    jSONObject.put(str, 1);
                } catch (Exception unused) {
                }
            } else {
                jSONObject.put(str, 0);
            }
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (Build.VERSION.SDK_INT >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray = new JSONArray();
                for (String put : Build.SUPPORTED_32_BIT_ABIS) {
                    jSONArray.put(put);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                for (String put2 : Build.SUPPORTED_64_BIT_ABIS) {
                    jSONArray2.put(put2);
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                for (String put3 : Build.SUPPORTED_ABIS) {
                    jSONArray3.put(put3);
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", EnvironmentCompat.MEDIA_UNKNOWN);
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void b(Context context) {
        Throwable th;
        Context context2;
        if (context != null) {
            try {
                e.a("walle", "[internal] begin by not stateful--->>>");
                context2 = context.getApplicationContext();
                try {
                    UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
                    JSONObject buildSLBaseHeader = uMSLEnvelopeBuild.buildSLBaseHeader(context2);
                    if (buildSLBaseHeader != null && buildSLBaseHeader.has("header")) {
                        try {
                            JSONObject jSONObject = (JSONObject) buildSLBaseHeader.opt("header");
                            if (jSONObject != null) {
                                jSONObject.put(v.aq, a.d);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    e.a("walle", "[internal] header is " + buildSLBaseHeader.toString());
                    JSONObject c2 = c(context2);
                    e.a("walle", "[internal] body is " + c2.toString());
                    e.a("walle", uMSLEnvelopeBuild.buildSLEnvelope(context2, buildSLBaseHeader, c2, a.f3683a).toString());
                } catch (Throwable th2) {
                    th = th2;
                    e.a(context2, th);
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                context2 = context;
                th = th4;
                e.a(context2, th);
            }
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a2 = t.a(context);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2.has(t.d)) {
                        jSONObject.put(t.d, jSONObject2.opt(t.d));
                    }
                    if (jSONObject2.has(t.f3821c)) {
                        jSONObject.put(t.f3821c, jSONObject2.opt(t.f3821c));
                    }
                    if (jSONObject2.has(t.f3820b)) {
                        jSONObject.put(t.f3820b, jSONObject2.opt(t.f3820b));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static JSONObject c(Context context) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                JSONArray o = o(applicationContext);
                if (o != null && o.length() > 0) {
                    jSONObject2.put("run_server", o);
                }
            } catch (Exception e) {
                try {
                    e.a(applicationContext, e);
                } catch (Exception unused) {
                }
            }
            try {
                String k = j.k(applicationContext);
                if (!TextUtils.isEmpty(k)) {
                    jSONObject2.put("imsi", k);
                }
            } catch (Exception e2) {
                e.a(applicationContext, e2);
            }
            try {
                String l = j.l(applicationContext);
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("meid", l);
                }
            } catch (Exception e3) {
                e.a(applicationContext, e3);
            }
            try {
                jSONObject.put(c.d, jSONObject2);
                return jSONObject;
            } catch (JSONException e4) {
                e.a(applicationContext, e4);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00a4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x0101 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject d(android.content.Context r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            if (r5 == 0) goto L_0x01aa
            android.content.Context r5 = r5.getApplicationContext()
            org.json.JSONArray r2 = o(r5)     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x0026
            int r3 = r2.length()     // Catch:{ Exception -> 0x0022 }
            if (r3 <= 0) goto L_0x0026
            java.lang.String r3 = "rs"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0026
        L_0x0022:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0026:
            org.json.JSONArray r2 = p(r5)     // Catch:{ Exception -> 0x0038 }
            if (r2 == 0) goto L_0x003c
            int r3 = r2.length()     // Catch:{ Exception -> 0x0038 }
            if (r3 <= 0) goto L_0x003c
            java.lang.String r3 = "bstn"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x003c:
            org.json.JSONArray r2 = q(r5)     // Catch:{ Exception -> 0x004e }
            if (r2 == 0) goto L_0x0052
            int r3 = r2.length()     // Catch:{ Exception -> 0x004e }
            if (r3 <= 0) goto L_0x0052
            java.lang.String r3 = "by"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0052:
            a(r5, r1)     // Catch:{ Exception -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x005a:
            b(r5, r1)     // Catch:{ Exception -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0062:
            org.json.JSONObject r2 = a()     // Catch:{ Exception -> 0x0074 }
            if (r2 == 0) goto L_0x0078
            int r3 = r2.length()     // Catch:{ Exception -> 0x0074 }
            if (r3 <= 0) goto L_0x0078
            java.lang.String r3 = "sd"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0078:
            org.json.JSONObject r2 = b()     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x008e
            int r3 = r2.length()     // Catch:{ Exception -> 0x008a }
            if (r3 <= 0) goto L_0x008e
            java.lang.String r3 = "build"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x008e:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00bb }
            r2.<init>()     // Catch:{ Exception -> 0x00bb }
            org.json.JSONArray r3 = f(r5)     // Catch:{ Exception -> 0x00bb }
            if (r3 == 0) goto L_0x00a4
            int r4 = r3.length()     // Catch:{ Exception -> 0x00bb }
            if (r4 <= 0) goto L_0x00a4
            java.lang.String r4 = "a_sr"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x00a4 }
        L_0x00a4:
            org.json.JSONArray r3 = com.umeng.commonsdk.proguard.r.c(r5)     // Catch:{ Exception -> 0x00bb }
            if (r3 == 0) goto L_0x00b5
            int r4 = r3.length()     // Catch:{ Exception -> 0x00bb }
            if (r4 <= 0) goto L_0x00b5
            java.lang.String r4 = "stat"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x00b5 }
        L_0x00b5:
            java.lang.String r3 = "sr"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x00bf:
            org.json.JSONObject r2 = g(r5)     // Catch:{ Exception -> 0x00d1 }
            if (r2 == 0) goto L_0x00d5
            int r3 = r2.length()     // Catch:{ Exception -> 0x00d1 }
            if (r3 <= 0) goto L_0x00d5
            java.lang.String r3 = "scr"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x00d5:
            org.json.JSONObject r2 = h(r5)     // Catch:{ Exception -> 0x00e7 }
            if (r2 == 0) goto L_0x00eb
            int r3 = r2.length()     // Catch:{ Exception -> 0x00e7 }
            if (r3 <= 0) goto L_0x00eb
            java.lang.String r3 = "sinfo"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x00eb:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0118 }
            r2.<init>()     // Catch:{ Exception -> 0x0118 }
            org.json.JSONArray r3 = com.umeng.commonsdk.proguard.j.e(r5)     // Catch:{ Exception -> 0x0118 }
            if (r3 == 0) goto L_0x0101
            int r4 = r3.length()     // Catch:{ Exception -> 0x0118 }
            if (r4 <= 0) goto L_0x0101
            java.lang.String r4 = "wl"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x0101 }
        L_0x0101:
            org.json.JSONArray r3 = i(r5)     // Catch:{ Exception -> 0x0118 }
            if (r3 == 0) goto L_0x0112
            int r4 = r3.length()     // Catch:{ Exception -> 0x0118 }
            if (r4 <= 0) goto L_0x0112
            java.lang.String r4 = "a_wls"
            r2.put(r4, r3)     // Catch:{ JSONException -> 0x0112 }
        L_0x0112:
            java.lang.String r3 = "winfo"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x011c:
            org.json.JSONArray r2 = j(r5)     // Catch:{ Exception -> 0x012e }
            if (r2 == 0) goto L_0x0132
            int r3 = r2.length()     // Catch:{ Exception -> 0x012e }
            if (r3 <= 0) goto L_0x0132
            java.lang.String r3 = "input"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x012e:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0132:
            org.json.JSONObject r2 = com.umeng.commonsdk.proguard.j.o(r5)     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x0148
            int r3 = r2.length()     // Catch:{ Exception -> 0x0144 }
            if (r3 <= 0) goto L_0x0148
            java.lang.String r3 = "bt"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0148
        L_0x0144:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0148:
            org.json.JSONArray r2 = k(r5)     // Catch:{ Exception -> 0x015a }
            if (r2 == 0) goto L_0x015e
            int r3 = r2.length()     // Catch:{ Exception -> 0x015a }
            if (r3 <= 0) goto L_0x015e
            java.lang.String r3 = "cam"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x015a }
            goto L_0x015e
        L_0x015a:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x015e:
            org.json.JSONArray r2 = l(r5)     // Catch:{ Exception -> 0x0170 }
            if (r2 == 0) goto L_0x0174
            int r3 = r2.length()     // Catch:{ Exception -> 0x0170 }
            if (r3 <= 0) goto L_0x0174
            java.lang.String r3 = "appls"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0170 }
            goto L_0x0174
        L_0x0170:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x0174:
            org.json.JSONObject r2 = m(r5)     // Catch:{ Exception -> 0x0186 }
            if (r2 == 0) goto L_0x018a
            int r3 = r2.length()     // Catch:{ Exception -> 0x0186 }
            if (r3 <= 0) goto L_0x018a
            java.lang.String r3 = "mem"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x0186 }
            goto L_0x018a
        L_0x0186:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x018a:
            org.json.JSONObject r2 = n(r5)     // Catch:{ Exception -> 0x019c }
            if (r2 == 0) goto L_0x01a0
            int r3 = r2.length()     // Catch:{ Exception -> 0x019c }
            if (r3 <= 0) goto L_0x01a0
            java.lang.String r3 = "lbs"
            r1.put(r3, r2)     // Catch:{ Exception -> 0x019c }
            goto L_0x01a0
        L_0x019c:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r2)
        L_0x01a0:
            java.lang.String r2 = "inner"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x01a6 }
            return r0
        L_0x01a6:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r1)
        L_0x01aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.d(android.content.Context):org.json.JSONObject");
    }

    public static String e(Context context) {
        try {
            com.umeng.commonsdk.statistics.idtracking.e a2 = com.umeng.commonsdk.statistics.idtracking.e.a(context);
            if (a2 != null) {
                a2.a();
                String encodeToString = Base64.encodeToString(new aj().a(a2.b()), 0);
                if (!TextUtils.isEmpty(encodeToString)) {
                    return encodeToString;
                }
            }
        } catch (Exception e) {
            e.a(context, e);
        }
        return null;
    }

    public static JSONArray f(Context context) {
        if (context != null) {
            return s.g(context.getApplicationContext());
        }
        return null;
    }

    public static JSONObject g(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", j.h(context));
                jSONObject.put("a_nav_h", j.i(context));
                if (!(context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null)) {
                    jSONObject.put("a_den", (double) displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                    return jSONObject;
                }
            } catch (Exception e) {
                e.a(context, e);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:2|3|4|(1:6)(1:7)|8|(3:10|11|12)|13|14|(3:16|17|18)|19|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x008c */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject h(android.content.Context r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r5 == 0) goto L_0x00b2
            android.content.Context r5 = r5.getApplicationContext()
            java.lang.String r1 = r5.getPackageName()
            java.lang.String r2 = "a_fit"
            long r3 = com.umeng.commonsdk.proguard.j.a(r5, r1)     // Catch:{ Exception -> 0x00ae }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "a_alut"
            long r3 = com.umeng.commonsdk.proguard.j.b(r5, r1)     // Catch:{ Exception -> 0x00ae }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "a_c"
            java.lang.String r3 = com.umeng.commonsdk.proguard.j.c(r5, r1)     // Catch:{ Exception -> 0x00ae }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r2 = "a_uid"
            int r1 = com.umeng.commonsdk.proguard.j.d(r5, r1)     // Catch:{ Exception -> 0x00ae }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x00ae }
            boolean r1 = com.umeng.commonsdk.proguard.j.a()     // Catch:{ Exception -> 0x00ae }
            if (r1 == 0) goto L_0x0040
            java.lang.String r1 = "a_root"
            r2 = 1
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0046
        L_0x0040:
            java.lang.String r1 = "a_root"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
        L_0x0046:
            java.lang.String r1 = "a_ua"
            java.lang.String r2 = com.umeng.commonsdk.proguard.j.s(r5)     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "tf"
            java.lang.String r2 = com.umeng.commonsdk.proguard.j.b()     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "s_fs"
            float r2 = com.umeng.commonsdk.proguard.j.a((android.content.Context) r5)     // Catch:{ Exception -> 0x00ae }
            double r2 = (double) r2     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "a_meid"
            java.lang.String r2 = com.umeng.commonsdk.proguard.j.l(r5)     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "a_imsi"
            java.lang.String r2 = com.umeng.commonsdk.proguard.j.k(r5)     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "st"
            long r2 = com.umeng.commonsdk.proguard.j.f()     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = com.umeng.commonsdk.proguard.s.b(r5)     // Catch:{ Exception -> 0x00ae }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00ae }
            if (r2 != 0) goto L_0x008c
            java.lang.String r2 = "a_iccid"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            java.lang.String r1 = com.umeng.commonsdk.proguard.s.c(r5)     // Catch:{ Exception -> 0x00ae }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x00ae }
            if (r2 != 0) goto L_0x009b
            java.lang.String r2 = "a_simei"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            java.lang.String r1 = "hn"
            java.lang.String r2 = com.umeng.commonsdk.proguard.j.g()     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r1 = "ts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ae }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x00ae }
            return r0
        L_0x00ae:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r1)
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.h(android.content.Context):org.json.JSONObject");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r7 = r7.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray i(android.content.Context r7) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            if (r7 == 0) goto L_0x00b2
            android.content.Context r7 = r7.getApplicationContext()
            java.util.List r1 = com.umeng.commonsdk.proguard.j.b(r7)
            if (r1 == 0) goto L_0x00b2
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x00b2
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00b2
            java.lang.Object r2 = r1.next()
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ac }
            r3.<init>()     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_bssid"
            java.lang.String r5 = r2.BSSID     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_ssid"
            java.lang.String r5 = r2.BSSID     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_cap"
            java.lang.String r5 = r2.capabilities     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_fcy"
            int r5 = r2.frequency     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "ts"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00ac }
            r5 = 23
            if (r4 < r5) goto L_0x009e
            java.lang.String r4 = "a_c0"
            int r5 = r2.centerFreq0     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_c1"
            int r5 = r2.centerFreq1     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_cw"
            int r5 = r2.channelWidth     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            boolean r4 = r2.is80211mcResponder()     // Catch:{ Exception -> 0x00ac }
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = "a_is80211"
            r3.put(r4, r6)     // Catch:{ Exception -> 0x00ac }
            goto L_0x007f
        L_0x007a:
            java.lang.String r4 = "a_is80211"
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
        L_0x007f:
            boolean r4 = r2.isPasspointNetwork()     // Catch:{ Exception -> 0x00ac }
            if (r4 == 0) goto L_0x008b
            java.lang.String r4 = "a_isppn"
            r3.put(r4, r6)     // Catch:{ Exception -> 0x00ac }
            goto L_0x0090
        L_0x008b:
            java.lang.String r4 = "a_isppn"
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
        L_0x0090:
            java.lang.String r4 = "a_ofn"
            java.lang.CharSequence r5 = r2.operatorFriendlyName     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.String r4 = "a_vn"
            java.lang.CharSequence r5 = r2.venueName     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00ac }
        L_0x009e:
            java.lang.String r4 = "a_dc"
            int r2 = r2.describeContents()     // Catch:{ Exception -> 0x00ac }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x00ac }
            r0.put(r3)     // Catch:{ Exception -> 0x00ac }
            goto L_0x001b
        L_0x00ac:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r7, r2)
            goto L_0x001b
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.i(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r7 = r7.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray j(android.content.Context r7) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            if (r7 == 0) goto L_0x004e
            android.content.Context r7 = r7.getApplicationContext()
            java.util.List r1 = com.umeng.commonsdk.proguard.j.m(r7)
            if (r1 == 0) goto L_0x004e
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r1.next()
            android.view.inputmethod.InputMethodInfo r2 = (android.view.inputmethod.InputMethodInfo) r2
            android.content.pm.PackageManager r3 = r7.getPackageManager()     // Catch:{ Exception -> 0x0049 }
            java.lang.CharSequence r3 = r2.loadLabel(r3)     // Catch:{ Exception -> 0x0049 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            r4.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = "a_la"
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r3 = "a_pn"
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0049 }
            r4.put(r3, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "ts"
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0049 }
            r4.put(r2, r5)     // Catch:{ Exception -> 0x0049 }
            r0.put(r4)     // Catch:{ Exception -> 0x0049 }
            goto L_0x0015
        L_0x0049:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r7, r2)
            goto L_0x0015
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.j(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r6 = r6.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray k(android.content.Context r6) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            if (r6 == 0) goto L_0x004e
            android.content.Context r6 = r6.getApplicationContext()
            java.util.List r1 = com.umeng.commonsdk.proguard.r.e(r6)
            if (r1 == 0) goto L_0x004e
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x004e
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r1.next()
            com.umeng.commonsdk.proguard.r$a r2 = (com.umeng.commonsdk.proguard.r.a) r2
            if (r2 == 0) goto L_0x001b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            r3.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_w"
            int r5 = r2.f3813a     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_h"
            int r2 = r2.f3814b     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "ts"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0049 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0049 }
            r0.put(r3)     // Catch:{ Exception -> 0x0049 }
            goto L_0x001b
        L_0x0049:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r6, r2)
            goto L_0x001b
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.k(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r6 = r6.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray l(android.content.Context r6) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            if (r6 == 0) goto L_0x004e
            android.content.Context r6 = r6.getApplicationContext()
            java.util.List r1 = com.umeng.commonsdk.proguard.j.p(r6)
            if (r1 == 0) goto L_0x004e
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x004e
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r1.next()
            com.umeng.commonsdk.proguard.j$a r2 = (com.umeng.commonsdk.proguard.j.a) r2
            if (r2 == 0) goto L_0x001b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0049 }
            r3.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_pn"
            java.lang.String r5 = r2.f3778a     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r4 = "a_la"
            java.lang.String r2 = r2.f3779b     // Catch:{ Exception -> 0x0049 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "ts"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0049 }
            r3.put(r2, r4)     // Catch:{ Exception -> 0x0049 }
            r0.put(r3)     // Catch:{ Exception -> 0x0049 }
            goto L_0x001b
        L_0x0049:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r6, r2)
            goto L_0x001b
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.l(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r5 = r5.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject m(android.content.Context r5) {
        /*
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r5 == 0) goto L_0x0033
            android.content.Context r5 = r5.getApplicationContext()
            android.app.ActivityManager$MemoryInfo r1 = com.umeng.commonsdk.proguard.j.q(r5)
            if (r1 == 0) goto L_0x0033
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x002f }
            r3 = 16
            if (r2 < r3) goto L_0x001e
            java.lang.String r2 = "t"
            long r3 = r1.totalMem     // Catch:{ Exception -> 0x002f }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x002f }
        L_0x001e:
            java.lang.String r2 = "f"
            long r3 = r1.availMem     // Catch:{ Exception -> 0x002f }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x002f }
            java.lang.String r1 = "ts"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002f }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x002f }
            return r0
        L_0x002f:
            r1 = move-exception
            com.umeng.commonsdk.proguard.e.a(r5, r1)
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.m(android.content.Context):org.json.JSONObject");
    }

    private static JSONObject n(Context context) {
        if (context != null) {
            return h.b(context.getApplicationContext());
        }
        return null;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00af */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONArray o(android.content.Context r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x00c2
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ Throwable -> 0x00be }
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Throwable -> 0x00be }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ Throwable -> 0x00be }
            if (r1 == 0) goto L_0x00c2
            r2 = 2147483647(0x7fffffff, float:NaN)
            java.util.List r1 = r1.getRunningServices(r2)     // Catch:{ Throwable -> 0x00be }
            if (r1 == 0) goto L_0x00c2
            boolean r2 = r1.isEmpty()     // Catch:{ Throwable -> 0x00be }
            if (r2 != 0) goto L_0x00c2
            r2 = 0
        L_0x0021:
            int r3 = r1.size()     // Catch:{ Throwable -> 0x00be }
            if (r2 >= r3) goto L_0x0090
            java.lang.Object r3 = r1.get(r2)     // Catch:{ Throwable -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ Throwable -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ Throwable -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ Throwable -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ Throwable -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ Throwable -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ Throwable -> 0x00be }
            java.lang.String r3 = r3.getClassName()     // Catch:{ Throwable -> 0x00be }
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r1.get(r2)     // Catch:{ Throwable -> 0x00be }
            android.app.ActivityManager$RunningServiceInfo r3 = (android.app.ActivityManager.RunningServiceInfo) r3     // Catch:{ Throwable -> 0x00be }
            android.content.ComponentName r3 = r3.service     // Catch:{ Throwable -> 0x00be }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Throwable -> 0x00be }
            if (r3 == 0) goto L_0x008d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008d }
            r3.<init>()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = "sn"
            java.lang.Object r5 = r1.get(r2)     // Catch:{ JSONException -> 0x008d }
            android.app.ActivityManager$RunningServiceInfo r5 = (android.app.ActivityManager.RunningServiceInfo) r5     // Catch:{ JSONException -> 0x008d }
            android.content.ComponentName r5 = r5.service     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.getClassName()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x008d }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = "pn"
            java.lang.Object r5 = r1.get(r2)     // Catch:{ JSONException -> 0x008d }
            android.app.ActivityManager$RunningServiceInfo r5 = (android.app.ActivityManager.RunningServiceInfo) r5     // Catch:{ JSONException -> 0x008d }
            android.content.ComponentName r5 = r5.service     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x008d }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x008d }
            if (r0 != 0) goto L_0x008a
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008d }
            r4.<init>()     // Catch:{ JSONException -> 0x008d }
            r0 = r4
        L_0x008a:
            r0.put(r3)     // Catch:{ JSONException -> 0x008d }
        L_0x008d:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0090:
            if (r0 == 0) goto L_0x00c2
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00be }
            r1.<init>()     // Catch:{ Throwable -> 0x00be }
            java.lang.String r2 = "ts"
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x00a5 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00a5 }
            java.lang.String r2 = "ls"
            r1.put(r2, r0)     // Catch:{ JSONException -> 0x00a5 }
        L_0x00a5:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00be }
            r2.<init>()     // Catch:{ Throwable -> 0x00be }
            java.lang.String r3 = "sers"
            r2.put(r3, r1)     // Catch:{ JSONException -> 0x00af }
        L_0x00af:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Throwable -> 0x00be }
            r1.<init>()     // Catch:{ Throwable -> 0x00be }
            r1.put(r2)     // Catch:{ Throwable -> 0x00b9 }
            r0 = r1
            return r0
        L_0x00b9:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00bf
        L_0x00be:
            r1 = move-exception
        L_0x00bf:
            com.umeng.commonsdk.proguard.e.a(r7, r1)
        L_0x00c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.d.o(android.content.Context):org.json.JSONArray");
    }

    private static JSONArray p(Context context) {
        JSONArray jSONArray = new JSONArray();
        JSONObject d = s.d(context);
        if (d != null) {
            try {
                String e = s.e(context);
                if (!TextUtils.isEmpty(e)) {
                    d.put("sig", e);
                }
                jSONArray.put(d);
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray q(Context context) {
        JSONArray jSONArray = new JSONArray();
        String f = s.f(context);
        if (!TextUtils.isEmpty(f)) {
            try {
                jSONArray.put(new JSONObject(f));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONArray r(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String a2 = s.a(applicationContext);
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(v.T, a2);
                    } catch (Exception unused) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused2) {
                }
            }
            String b2 = s.b(applicationContext);
            if (!TextUtils.isEmpty(b2)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused3) {
                    }
                }
                jSONObject.put(v.U, b2);
            }
            String c2 = s.c(applicationContext);
            if (!TextUtils.isEmpty(c2)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused4) {
                    }
                }
                jSONObject.put(v.V, c2);
            }
            JSONObject d = s.d(applicationContext);
            if (d != null) {
                try {
                    String e = s.e(applicationContext);
                    if (!TextUtils.isEmpty(e)) {
                        d.put("signalscale", e);
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put(v.X, d);
                } catch (Exception unused5) {
                }
            }
            String f = s.f(applicationContext);
            if (!TextUtils.isEmpty(f)) {
                if (jSONObject == null) {
                    try {
                        jSONObject = new JSONObject();
                    } catch (Exception unused6) {
                    }
                }
                jSONObject.put(v.S, new JSONObject(f));
            }
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
