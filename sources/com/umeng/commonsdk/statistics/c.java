package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.b;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.e;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.g;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ImLatent;
import com.umeng.commonsdk.statistics.proto.d;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;
import org.slf4j.Marker;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f3869a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final String f3870b = "EnvelopeManager";

    /* renamed from: c  reason: collision with root package name */
    private static StatTracer f3871c;
    private static ImLatent d;
    private static String e;
    private static boolean g;
    private int f = 0;

    private int a(Context context, Envelope envelope, String str, String str2) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        return b.a(context, str + "&&" + str2 + "_" + System.currentTimeMillis() + "_envelope.log", envelope.toBinary());
    }

    public static long a(Context context) {
        long j;
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        JSONObject b2 = b(context);
        if (b2 == null || b2.toString() == null || b2.toString().getBytes() == null) {
            j = j2;
        } else {
            long length = (long) b2.toString().getBytes().length;
            if (e.f3885a) {
                Log.i(f3870b, "headerLen size is " + length);
            }
            j = j2 - length;
        }
        if (e.f3885a) {
            Log.i(f3870b, "free size is " + j);
        }
        return j;
    }

    private Envelope a(Context context, byte[] bArr) {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", (String) null);
        int i = -1;
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            com.umeng.commonsdk.proguard.e.a(context, e2);
        }
        return (i == 0 || (i != 1 && !g)) ? Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr) : Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private JSONObject a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put(com.umeng.analytics.pro.b.ao, i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(com.umeng.analytics.pro.b.ao, i);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0032: MOVE  (r2v2 java.lang.String) = (r2v1 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    private org.json.JSONObject a(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0060
            if (r6 == 0) goto L_0x0060
            java.lang.String r0 = "header"
            java.lang.Object r0 = r5.opt(r0)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "header"
            java.lang.Object r0 = r5.opt(r0)
            boolean r0 = r0 instanceof org.json.JSONObject
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "header"
            java.lang.Object r0 = r5.opt(r0)
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.util.Iterator r1 = r6.keys()
        L_0x0022:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0060
            java.lang.Object r2 = r1.next()
            if (r2 == 0) goto L_0x0022
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0022
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0022
            java.lang.Object r3 = r6.opt(r2)
            if (r3 == 0) goto L_0x0022
            java.lang.Object r3 = r6.opt(r2)     // Catch:{ Exception -> 0x0022 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0022 }
            java.lang.String r3 = "vertical_type"
            boolean r3 = r2.equals(r3)     // Catch:{ Exception -> 0x0022 }
            if (r3 == 0) goto L_0x0022
            java.lang.Object r3 = r6.opt(r2)     // Catch:{ Exception -> 0x0022 }
            boolean r3 = r3 instanceof java.lang.Integer     // Catch:{ Exception -> 0x0022 }
            if (r3 == 0) goto L_0x0022
            java.lang.Object r2 = r6.opt(r2)     // Catch:{ Exception -> 0x0022 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0022 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0022 }
            r4.f = r2     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0060:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.c.a(org.json.JSONObject, org.json.JSONObject):org.json.JSONObject");
    }

    public static void a(boolean z) {
        g = z;
    }

    private static JSONObject b(Context context) {
        JSONObject jSONObject;
        String str;
        String str2;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(e)) {
                try {
                    jSONObject = new JSONObject(e);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                jSONObject = new JSONObject();
                jSONObject.put(v.k, DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(v.l, DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(v.m, DeviceConfig.getAppHashKey(context));
                jSONObject.put("app_version", DeviceConfig.getAppVersionName(context));
                jSONObject.put("version_code", Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put(v.q, DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(v.r, DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(v.w, mccmnc);
                } else {
                    jSONObject.put(v.w, "");
                }
                String subOSName = DeviceConfig.getSubOSName(context);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject.put(v.F, subOSName);
                }
                String subOSVersion = DeviceConfig.getSubOSVersion(context);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject.put(v.G, subOSVersion);
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(v.ab, deviceType);
                }
                jSONObject.put(v.j, DeviceConfig.getPackageName(context));
                jSONObject.put(v.p, "Android");
                jSONObject.put("device_id", DeviceConfig.getDeviceId(context));
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put(v.z, Build.BOARD);
                jSONObject.put(v.A, Build.BRAND);
                jSONObject.put(v.B, Build.TIME);
                jSONObject.put(v.C, Build.MANUFACTURER);
                jSONObject.put(v.D, Build.ID);
                jSONObject.put("device_name", Build.DEVICE);
                jSONObject.put(v.s, "Android");
                jSONObject.put(v.t, Build.VERSION.RELEASE);
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject.put(v.u, resolutionArray[1] + Marker.ANY_MARKER + resolutionArray[0]);
                }
                jSONObject.put(v.v, DeviceConfig.getMac(context));
                jSONObject.put(v.H, DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(v.J, localeInfo[0]);
                jSONObject.put(v.I, localeInfo[1]);
                jSONObject.put(v.K, DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(v.n, DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    str = v.L;
                    str2 = "wifi";
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    str = v.L;
                    str2 = "2G/3G";
                } else {
                    str = v.L;
                    str2 = "unknow";
                }
                jSONObject.put(str, str2);
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(v.M, networkAccessMode[1]);
                }
                jSONObject.put(v.f3828b, e.f3892a);
                if (!TextUtils.isEmpty(f3869a)) {
                    jSONObject.put(v.f3829c, f3869a);
                }
                e = jSONObject.toString();
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(v.N, sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(v.O, sharedPreferences.getInt(v.O, 0));
                jSONObject.put(v.P, sharedPreferences.getInt("last_request_spent_ms", 0));
            } catch (Exception unused2) {
            }
            jSONObject.put("channel", UMUtils.getChannel(context));
            jSONObject.put("appkey", UMUtils.getAppkey(context));
            String deviceToken = UMUtils.getDeviceToken(context);
            if (!TextUtils.isEmpty(deviceToken)) {
                jSONObject.put(v.f3827a, deviceToken);
            }
            try {
                q qVar = new q(context);
                if (!TextUtils.isEmpty(qVar.a())) {
                    jSONObject.put(v.d, qVar.a());
                }
            } catch (Exception e2) {
                com.umeng.commonsdk.proguard.e.a(context, e2);
            }
            try {
                String imprintProperty = UMEnvelopeBuild.imprintProperty(context, v.e, (String) null);
                if (!TextUtils.isEmpty(imprintProperty)) {
                    jSONObject.put(v.e, imprintProperty);
                }
            } catch (Exception e3) {
                com.umeng.commonsdk.proguard.e.a(context, e3);
            }
            try {
                d a2 = g.a(context).a();
                if (a2 != null) {
                    jSONObject.put(v.Q, Base64.encodeToString(new aj().a(a2), 0));
                }
            } catch (Exception e4) {
                com.umeng.commonsdk.proguard.e.a(context, e4);
            }
            if (jSONObject.length() > 0) {
                return new JSONObject().put("header", jSONObject);
            }
            return null;
        } catch (Exception e5) {
            com.umeng.commonsdk.proguard.e.a(context, e5);
        } catch (Throwable th) {
            com.umeng.commonsdk.proguard.e.a(context, th);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0075: MOVE  (r9v12 java.lang.String) = (r9v11 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:8|9|(1:12)|(3:15|(4:19|(3:27|28|186)|180|16)|181)|29|(5:31|32|(10:34|(2:36|(1:40))|41|(2:43|(1:47))|48|(4:50|(1:52)(1:53)|54|(1:58))|59|(3:61|(2:63|(1:69))(2:71|(1:75))|70)|76|(2:78|(1:82)))|83|(2:85|86)(2:87|(1:89)))(1:90)|(3:92|93|(2:95|(1:97)))|98|99|(1:101)|102|(2:106|(2:108|109))|(3:112|113|(4:115|(1:117)|118|119))|(2:121|(2:123|124))(1:125)|(3:(1:132)(1:133)|134|(2:136|137)(3:138|(1:140)|141))(2:129|130)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:98:0x0222 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0226 A[Catch:{ Throwable -> 0x031c }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x024e A[SYNTHETIC, Splitter:B:108:0x024e] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x027d A[SYNTHETIC, Splitter:B:112:0x027d] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02b3 A[Catch:{ Throwable -> 0x031c }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02c8 A[Catch:{ Throwable -> 0x031c }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02d9 A[Catch:{ Throwable -> 0x031c }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e0 A[Catch:{ Throwable -> 0x031c }] */
    public org.json.JSONObject a(android.content.Context r19, org.json.JSONObject r20, org.json.JSONObject r21) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            boolean r5 = com.umeng.commonsdk.statistics.common.e.f3885a
            if (r5 == 0) goto L_0x0048
            if (r3 == 0) goto L_0x0048
            if (r4 == 0) goto L_0x0048
            java.lang.String r5 = "EnvelopeManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "headerJSONObject size is "
            r6.<init>(r7)
            java.lang.String r7 = r20.toString()
            byte[] r7 = r7.getBytes()
            int r7 = r7.length
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r5, r6)
            java.lang.String r5 = "EnvelopeManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "bodyJSONObject size is "
            r6.<init>(r7)
            java.lang.String r7 = r21.toString()
            byte[] r7 = r7.getBytes()
            int r7 = r7.length
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r5, r6)
        L_0x0048:
            r5 = 110(0x6e, float:1.54E-43)
            r6 = 0
            if (r2 == 0) goto L_0x0371
            if (r4 != 0) goto L_0x0051
            goto L_0x0371
        L_0x0051:
            org.json.JSONObject r7 = b(r19)     // Catch:{ Throwable -> 0x031c }
            if (r7 == 0) goto L_0x005d
            if (r3 == 0) goto L_0x005d
            org.json.JSONObject r7 = r1.a((org.json.JSONObject) r7, (org.json.JSONObject) r3)     // Catch:{ Throwable -> 0x031c }
        L_0x005d:
            if (r7 == 0) goto L_0x0087
            if (r4 == 0) goto L_0x0087
            java.util.Iterator r8 = r21.keys()     // Catch:{ Throwable -> 0x031c }
        L_0x0065:
            boolean r9 = r8.hasNext()     // Catch:{ Throwable -> 0x031c }
            if (r9 == 0) goto L_0x0087
            java.lang.Object r9 = r8.next()     // Catch:{ Throwable -> 0x031c }
            if (r9 == 0) goto L_0x0065
            boolean r10 = r9 instanceof java.lang.String     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x0065
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Throwable -> 0x031c }
            if (r9 == 0) goto L_0x0065
            java.lang.Object r10 = r4.opt(r9)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x0065
            java.lang.Object r10 = r4.opt(r9)     // Catch:{ Exception -> 0x0065 }
            r7.put(r9, r10)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0065
        L_0x0087:
            r8 = 0
            if (r7 == 0) goto L_0x01ef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x031c }
            r9.<init>()     // Catch:{ Throwable -> 0x031c }
            int r10 = r7.length()     // Catch:{ Throwable -> 0x031c }
            if (r10 <= 0) goto L_0x01cb
            java.lang.String r10 = "push"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x00c7
            java.lang.String r10 = "p"
            java.lang.String r11 = "header"
            org.json.JSONObject r11 = r7.optJSONObject(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r12 = "p_sdk_v"
            java.lang.String r11 = r11.optString(r12)     // Catch:{ Throwable -> 0x031c }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x00c7
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x00c7
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "=="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
        L_0x00c7:
            java.lang.String r10 = "share"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x00f9
            java.lang.String r10 = "s"
            java.lang.String r11 = "header"
            org.json.JSONObject r11 = r7.optJSONObject(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r12 = "s_sdk_v"
            java.lang.String r11 = r11.optString(r12)     // Catch:{ Throwable -> 0x031c }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x00f9
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x00f9
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "=="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
        L_0x00f9:
            java.lang.String r10 = "analytics"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x0136
            java.lang.String r10 = "dplus"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x010c
            java.lang.String r10 = "ad"
            goto L_0x010e
        L_0x010c:
            java.lang.String r10 = "a"
        L_0x010e:
            java.lang.String r11 = "header"
            org.json.JSONObject r11 = r7.optJSONObject(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r12 = "sdk_version"
            java.lang.String r11 = r11.optString(r12)     // Catch:{ Throwable -> 0x031c }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0136
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0136
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "=="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
        L_0x0136:
            java.lang.String r10 = "dplus"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x0199
            java.lang.String r10 = "header"
            org.json.JSONObject r10 = r7.optJSONObject(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "sdk_version"
            java.lang.String r10 = r10.optString(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "analytics"
            boolean r11 = r7.has(r11)     // Catch:{ Throwable -> 0x031c }
            if (r11 == 0) goto L_0x017d
            java.lang.String r11 = "ad"
            java.lang.String r12 = r9.toString()     // Catch:{ Throwable -> 0x031c }
            java.lang.String r13 = "ad"
            boolean r12 = r12.contains(r13)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0199
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0199
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0199
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "=="
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
        L_0x0179:
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            goto L_0x0199
        L_0x017d:
            java.lang.String r11 = "d"
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0199
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x0199
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "=="
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
            goto L_0x0179
        L_0x0199:
            java.lang.String r10 = "inner"
            boolean r10 = r7.has(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x01cb
            java.lang.String r10 = "i"
            java.lang.String r11 = "header"
            org.json.JSONObject r11 = r7.optJSONObject(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r12 = "i_sdk_v"
            java.lang.String r11 = r11.optString(r12)     // Catch:{ Throwable -> 0x031c }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x01cb
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x031c }
            if (r12 != 0) goto L_0x01cb
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "=="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            r9.append(r11)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "&="
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
        L_0x01cb:
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x031c }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x01dc
            r8 = 101(0x65, float:1.42E-43)
            org.json.JSONObject r7 = r1.a((int) r8, (org.json.JSONObject) r7)     // Catch:{ Throwable -> 0x031c }
            return r7
        L_0x01dc:
            java.lang.String r10 = "&="
            boolean r10 = r9.endsWith(r10)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x01f0
            int r10 = r9.length()     // Catch:{ Throwable -> 0x031c }
            int r10 = r10 + -2
            java.lang.String r9 = r9.substring(r8, r10)     // Catch:{ Throwable -> 0x031c }
            goto L_0x01f0
        L_0x01ef:
            r9 = r6
        L_0x01f0:
            if (r7 == 0) goto L_0x0222
            com.umeng.commonsdk.statistics.idtracking.e r10 = com.umeng.commonsdk.statistics.idtracking.e.a((android.content.Context) r19)     // Catch:{ Exception -> 0x0222 }
            if (r10 == 0) goto L_0x0222
            r10.a()     // Catch:{ Exception -> 0x0222 }
            com.umeng.commonsdk.statistics.proto.c r10 = r10.b()     // Catch:{ Exception -> 0x0222 }
            com.umeng.commonsdk.proguard.aj r11 = new com.umeng.commonsdk.proguard.aj     // Catch:{ Exception -> 0x0222 }
            r11.<init>()     // Catch:{ Exception -> 0x0222 }
            byte[] r10 = r11.a(r10)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r8 = android.util.Base64.encodeToString(r10, r8)     // Catch:{ Exception -> 0x0222 }
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0222 }
            if (r10 != 0) goto L_0x0222
            java.lang.String r10 = "header"
            org.json.JSONObject r10 = r7.getJSONObject(r10)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r11 = "id_tracking"
            r10.put(r11, r8)     // Catch:{ Exception -> 0x0222 }
            java.lang.String r8 = "header"
            r7.put(r8, r10)     // Catch:{ Exception -> 0x0222 }
        L_0x0222:
            com.umeng.commonsdk.statistics.internal.StatTracer r8 = f3871c     // Catch:{ Throwable -> 0x031c }
            if (r8 != 0) goto L_0x0234
            com.umeng.commonsdk.statistics.internal.StatTracer r8 = com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(r19)     // Catch:{ Throwable -> 0x031c }
            f3871c = r8     // Catch:{ Throwable -> 0x031c }
            com.umeng.commonsdk.statistics.internal.StatTracer r8 = f3871c     // Catch:{ Throwable -> 0x031c }
            com.umeng.commonsdk.statistics.noise.ImLatent r8 = com.umeng.commonsdk.statistics.noise.ImLatent.getService(r2, r8)     // Catch:{ Throwable -> 0x031c }
            d = r8     // Catch:{ Throwable -> 0x031c }
        L_0x0234:
            com.umeng.commonsdk.statistics.noise.ImLatent r8 = d     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x027b
            com.umeng.commonsdk.statistics.noise.ImLatent r8 = d     // Catch:{ Throwable -> 0x031c }
            boolean r8 = r8.shouldStartLatency()     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x027b
            com.umeng.commonsdk.statistics.noise.ImLatent r8 = d     // Catch:{ Throwable -> 0x031c }
            long r10 = r8.getDelayTime()     // Catch:{ Throwable -> 0x031c }
            com.umeng.commonsdk.statistics.noise.ImLatent r8 = d     // Catch:{ Throwable -> 0x031c }
            long r12 = r8.getElapsedTime()     // Catch:{ Throwable -> 0x031c }
            if (r7 == 0) goto L_0x027b
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x027b }
            r8.<init>()     // Catch:{ Exception -> 0x027b }
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x027b }
            r14.<init>()     // Catch:{ Exception -> 0x027b }
            java.lang.String r15 = "interval"
            r16 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 / r16
            r14.put(r15, r12)     // Catch:{ Exception -> 0x027b }
            java.lang.String r12 = "latency"
            r14.put(r12, r10)     // Catch:{ Exception -> 0x027b }
            java.lang.String r10 = "latent"
            r8.put(r10, r14)     // Catch:{ Exception -> 0x027b }
            java.lang.String r10 = "header"
            org.json.JSONObject r10 = r7.getJSONObject(r10)     // Catch:{ Exception -> 0x027b }
            java.lang.String r11 = "control_policy"
            r10.put(r11, r8)     // Catch:{ Exception -> 0x027b }
            java.lang.String r8 = "header"
            r7.put(r8, r10)     // Catch:{ Exception -> 0x027b }
        L_0x027b:
            if (r7 == 0) goto L_0x02b1
            java.lang.String r8 = r7.toString()     // Catch:{ Throwable -> 0x031c }
            byte[] r8 = r8.getBytes()     // Catch:{ Throwable -> 0x031c }
            int r8 = r8.length     // Catch:{ Throwable -> 0x031c }
            long r10 = (long) r8     // Catch:{ Throwable -> 0x031c }
            long r12 = com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX     // Catch:{ Throwable -> 0x031c }
            boolean r8 = com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(r10, r12)     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x02b1
            android.content.SharedPreferences r8 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r19)     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x02aa
            java.lang.String r9 = "serial"
            r10 = 1
            int r9 = r8.getInt(r9, r10)     // Catch:{ Throwable -> 0x031c }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "serial"
            int r9 = r9 + r10
            android.content.SharedPreferences$Editor r8 = r8.putInt(r11, r9)     // Catch:{ Throwable -> 0x031c }
            r8.commit()     // Catch:{ Throwable -> 0x031c }
        L_0x02aa:
            r8 = 113(0x71, float:1.58E-43)
            org.json.JSONObject r7 = r1.a((int) r8, (org.json.JSONObject) r7)     // Catch:{ Throwable -> 0x031c }
            return r7
        L_0x02b1:
            if (r7 == 0) goto L_0x02c8
            java.lang.String r8 = r7.toString()     // Catch:{ Throwable -> 0x031c }
            byte[] r8 = r8.getBytes()     // Catch:{ Throwable -> 0x031c }
            com.umeng.commonsdk.statistics.idtracking.Envelope r8 = r1.a((android.content.Context) r2, (byte[]) r8)     // Catch:{ Throwable -> 0x031c }
            if (r8 != 0) goto L_0x02c9
            r8 = 111(0x6f, float:1.56E-43)
            org.json.JSONObject r7 = r1.a((int) r8, (org.json.JSONObject) r7)     // Catch:{ Throwable -> 0x031c }
            return r7
        L_0x02c8:
            r8 = r6
        L_0x02c9:
            if (r8 == 0) goto L_0x02e0
            byte[] r10 = r8.toBinary()     // Catch:{ Throwable -> 0x031c }
            int r10 = r10.length     // Catch:{ Throwable -> 0x031c }
            long r10 = (long) r10     // Catch:{ Throwable -> 0x031c }
            long r12 = com.umeng.commonsdk.statistics.common.DataHelper.ENVELOPE_LENGTH_MAX     // Catch:{ Throwable -> 0x031c }
            boolean r10 = com.umeng.commonsdk.statistics.common.DataHelper.largeThanMaxSize(r10, r12)     // Catch:{ Throwable -> 0x031c }
            if (r10 == 0) goto L_0x02e0
            r8 = 114(0x72, float:1.6E-43)
            org.json.JSONObject r7 = r1.a((int) r8, (org.json.JSONObject) r7)     // Catch:{ Throwable -> 0x031c }
            return r7
        L_0x02e0:
            if (r7 == 0) goto L_0x02ef
            java.lang.String r10 = "header"
            org.json.JSONObject r10 = r7.optJSONObject(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r11 = "app_version"
            java.lang.String r10 = r10.optString(r11)     // Catch:{ Throwable -> 0x031c }
            goto L_0x02f0
        L_0x02ef:
            r10 = r6
        L_0x02f0:
            int r8 = r1.a(r2, r8, r9, r10)     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x02fb
            org.json.JSONObject r7 = r1.a((int) r8, (org.json.JSONObject) r7)     // Catch:{ Throwable -> 0x031c }
            return r7
        L_0x02fb:
            boolean r8 = com.umeng.commonsdk.statistics.common.e.f3885a     // Catch:{ Throwable -> 0x031c }
            if (r8 == 0) goto L_0x031b
            java.lang.String r8 = "EnvelopeManager"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = "constructHeader size is "
            r9.<init>(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r10 = r7.toString()     // Catch:{ Throwable -> 0x031c }
            byte[] r10 = r10.getBytes()     // Catch:{ Throwable -> 0x031c }
            int r10 = r10.length     // Catch:{ Throwable -> 0x031c }
            r9.append(r10)     // Catch:{ Throwable -> 0x031c }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x031c }
            android.util.Log.i(r8, r9)     // Catch:{ Throwable -> 0x031c }
        L_0x031b:
            return r7
        L_0x031c:
            r0 = move-exception
            r7 = r0
            com.umeng.commonsdk.proguard.e.a(r2, r7)
            if (r3 == 0) goto L_0x0337
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0334 }
            r7.<init>()     // Catch:{ Exception -> 0x0334 }
            java.lang.String r6 = "header"
            r7.put(r6, r3)     // Catch:{ JSONException -> 0x0332, Exception -> 0x032e }
            goto L_0x0332
        L_0x032e:
            r0 = move-exception
            r3 = r0
            r6 = r7
            goto L_0x0369
        L_0x0332:
            r6 = r7
            goto L_0x0337
        L_0x0334:
            r0 = move-exception
            r3 = r0
            goto L_0x0369
        L_0x0337:
            if (r4 == 0) goto L_0x036c
            if (r6 != 0) goto L_0x0341
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0334 }
            r3.<init>()     // Catch:{ Exception -> 0x0334 }
            r6 = r3
        L_0x0341:
            if (r4 == 0) goto L_0x036c
            java.util.Iterator r3 = r21.keys()     // Catch:{ Exception -> 0x0334 }
        L_0x0347:
            boolean r7 = r3.hasNext()     // Catch:{ Exception -> 0x0334 }
            if (r7 == 0) goto L_0x036c
            java.lang.Object r7 = r3.next()     // Catch:{ Exception -> 0x0334 }
            if (r7 == 0) goto L_0x0347
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ Exception -> 0x0334 }
            if (r8 == 0) goto L_0x0347
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0334 }
            if (r7 == 0) goto L_0x0347
            java.lang.Object r8 = r4.opt(r7)     // Catch:{ Exception -> 0x0334 }
            if (r8 == 0) goto L_0x0347
            java.lang.Object r8 = r4.opt(r7)     // Catch:{ Exception -> 0x0347 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0347 }
            goto L_0x0347
        L_0x0369:
            com.umeng.commonsdk.proguard.e.a(r2, r3)
        L_0x036c:
            org.json.JSONObject r2 = r1.a((int) r5, (org.json.JSONObject) r6)
            return r2
        L_0x0371:
            org.json.JSONObject r2 = r1.a((int) r5, (org.json.JSONObject) r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.c.a(android.content.Context, org.json.JSONObject, org.json.JSONObject):org.json.JSONObject");
    }
}
