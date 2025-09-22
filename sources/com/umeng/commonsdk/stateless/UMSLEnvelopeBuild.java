package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.b;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.e;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

public class UMSLEnvelopeBuild {
    private static final String TAG = "UMSLEnvelopeBuild";
    private static String cacheSystemheader;
    private static boolean isEncryptEnabled;
    public static Context mContext;
    public static String module;

    private synchronized c constructEnvelope(Context context, byte[] bArr) {
        c cVar;
        String appkey;
        String appkey2;
        int i = -1;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "slcodex", (String) null);
        e.a("walle", "[stateless] build envelope, codexStr is " + imprintProperty);
        try {
            if (!TextUtils.isEmpty(imprintProperty)) {
                i = Integer.valueOf(imprintProperty).intValue();
            }
        } catch (NumberFormatException e) {
            com.umeng.commonsdk.proguard.e.a(context, e);
        }
        if (i == 0) {
            e.a("walle", "[stateless] build envelope, codexValue is 0");
            appkey = UMUtils.getAppkey(context);
        } else {
            if (i == 1) {
                e.a("walle", "[stateless] build envelope, codexValue is 1");
                appkey2 = UMUtils.getAppkey(context);
            } else if (isEncryptEnabled) {
                e.a("walle", "[stateless] build envelope, isEncryptEnabled is true");
                appkey2 = UMUtils.getAppkey(context);
            } else {
                e.a("walle", "[stateless] build envelope, isEncryptEnabled is false");
                appkey = UMUtils.getAppkey(context);
            }
            cVar = c.b(context, appkey2, bArr);
        }
        cVar = c.a(context, appkey, bArr);
        return cVar;
    }

    private synchronized JSONObject makeErrorResult(int i, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                jSONObject.put(b.ao, i);
            } catch (Exception unused) {
            }
        } else {
            jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(b.ao, i);
            } catch (Exception unused2) {
            }
        }
        return jSONObject2;
        return jSONObject;
    }

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:52|53|54|(3:55|56|(1:58))|59|61|62|(1:64)|65|66|(3:68|69|70)|74|75|76) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x020e */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0214 A[Catch:{ Throwable -> 0x0248 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.json.JSONObject buildSLBaseHeader(android.content.Context r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "walle"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0269 }
            java.lang.String r4 = "[stateless] begin build hader, thread is "
            r3.<init>(r4)     // Catch:{ all -> 0x0269 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0269 }
            r3.append(r4)     // Catch:{ all -> 0x0269 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0269 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0269 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0269 }
            r0 = 0
            if (r10 != 0) goto L_0x0023
            monitor-exit(r9)
            return r0
        L_0x0023:
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x0269 }
            java.lang.String r2 = cacheSystemheader     // Catch:{ Throwable -> 0x0248 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0248 }
            if (r2 != 0) goto L_0x003b
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0038 }
            java.lang.String r3 = cacheSystemheader     // Catch:{ Exception -> 0x0038 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0038 }
            goto L_0x01cf
        L_0x0038:
            r2 = r0
            goto L_0x01cf
        L_0x003b:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0248 }
            r2.<init>()     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "app_signature"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppMD5Signature(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "app_sig_sha1"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppSHA1Key(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "app_sig_sha"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppHashKey(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "app_version"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "version_code"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionCode(r10)     // Catch:{ Throwable -> 0x0248 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "idmd5"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceIdUmengMD5(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "cpu"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU()     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMCCMNC(r10)     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0248 }
            if (r5 != 0) goto L_0x0093
            java.lang.String r5 = "mccmnc"
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
            goto L_0x009a
        L_0x0093:
            java.lang.String r3 = "mccmnc"
            java.lang.String r5 = ""
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
        L_0x009a:
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSName(r10)     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0248 }
            if (r5 != 0) goto L_0x00a9
            java.lang.String r5 = "sub_os_name"
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
        L_0x00a9:
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getSubOSVersion(r10)     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0248 }
            if (r5 != 0) goto L_0x00b8
            java.lang.String r5 = "sub_os_version"
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
        L_0x00b8:
            java.lang.String r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceType(r10)     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0248 }
            if (r5 != 0) goto L_0x00c7
            java.lang.String r5 = "device_type"
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
        L_0x00c7:
            java.lang.String r3 = "package_name"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "sdk_type"
            java.lang.String r5 = "Android"
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_id"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_model"
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_board"
            java.lang.String r5 = android.os.Build.BOARD     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_brand"
            java.lang.String r5 = android.os.Build.BRAND     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_manutime"
            long r5 = android.os.Build.TIME     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_manufacturer"
            java.lang.String r5 = android.os.Build.MANUFACTURER     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_manuid"
            java.lang.String r5 = android.os.Build.ID     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "device_name"
            java.lang.String r5 = android.os.Build.DEVICE     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "os"
            java.lang.String r5 = "Android"
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "os_version"
            java.lang.String r5 = android.os.Build.VERSION.RELEASE     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            int[] r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(r10)     // Catch:{ Throwable -> 0x0248 }
            if (r3 == 0) goto L_0x0142
            java.lang.String r5 = "resolution"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0248 }
            r6.<init>()     // Catch:{ Throwable -> 0x0248 }
            r7 = r3[r1]     // Catch:{ Throwable -> 0x0248 }
            r6.append(r7)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r7 = "*"
            r6.append(r7)     // Catch:{ Throwable -> 0x0248 }
            r3 = r3[r4]     // Catch:{ Throwable -> 0x0248 }
            r6.append(r3)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = r6.toString()     // Catch:{ Throwable -> 0x0248 }
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
        L_0x0142:
            java.lang.String r3 = "mc"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "timezone"
            int r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String[] r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(r10)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r5 = "country"
            r6 = r3[r4]     // Catch:{ Throwable -> 0x0248 }
            r2.put(r5, r6)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r5 = "language"
            r3 = r3[r1]     // Catch:{ Throwable -> 0x0248 }
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "carrier"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "display_name"
            java.lang.String r5 = com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String[] r3 = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(r10)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r5 = "Wi-Fi"
            r6 = r3[r4]     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = r5.equals(r6)     // Catch:{ Throwable -> 0x0248 }
            if (r5 == 0) goto L_0x018e
            java.lang.String r5 = "access"
            java.lang.String r6 = "wifi"
        L_0x018a:
            r2.put(r5, r6)     // Catch:{ Throwable -> 0x0248 }
            goto L_0x01a2
        L_0x018e:
            java.lang.String r5 = "2G/3G"
            r6 = r3[r4]     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = r5.equals(r6)     // Catch:{ Throwable -> 0x0248 }
            if (r5 == 0) goto L_0x019d
            java.lang.String r5 = "access"
            java.lang.String r6 = "2G/3G"
            goto L_0x018a
        L_0x019d:
            java.lang.String r5 = "access"
            java.lang.String r6 = "unknow"
            goto L_0x018a
        L_0x01a2:
            java.lang.String r5 = ""
            r6 = r3[r1]     // Catch:{ Throwable -> 0x0248 }
            boolean r5 = r5.equals(r6)     // Catch:{ Throwable -> 0x0248 }
            if (r5 != 0) goto L_0x01b3
            java.lang.String r5 = "access_subtype"
            r3 = r3[r1]     // Catch:{ Throwable -> 0x0248 }
            r2.put(r5, r3)     // Catch:{ Throwable -> 0x0248 }
        L_0x01b3:
            java.lang.String r3 = "com_ver"
            java.lang.String r5 = "1.3.2"
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = module     // Catch:{ Throwable -> 0x0248 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0248 }
            if (r3 != 0) goto L_0x01c9
            java.lang.String r3 = "module"
            java.lang.String r5 = module     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
        L_0x01c9:
            java.lang.String r3 = r2.toString()     // Catch:{ Throwable -> 0x0248 }
            cacheSystemheader = r3     // Catch:{ Throwable -> 0x0248 }
        L_0x01cf:
            if (r2 != 0) goto L_0x01d3
            monitor-exit(r9)
            return r0
        L_0x01d3:
            java.lang.String r3 = "channel"
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getChannel(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r3 = "appkey"
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getAppkey(r10)     // Catch:{ Throwable -> 0x0248 }
            r2.put(r3, r5)     // Catch:{ Throwable -> 0x0248 }
            com.umeng.commonsdk.proguard.q r3 = new com.umeng.commonsdk.proguard.q     // Catch:{ Exception -> 0x01fd }
            r3.<init>(r10)     // Catch:{ Exception -> 0x01fd }
            java.lang.String r5 = r3.a()     // Catch:{ Exception -> 0x01fd }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x01fd }
            if (r5 != 0) goto L_0x01fd
            java.lang.String r5 = "umtt"
            java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x01fd }
            r2.put(r5, r3)     // Catch:{ Exception -> 0x01fd }
        L_0x01fd:
            java.lang.String r3 = "umid"
            java.lang.String r3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r10, r3, r0)     // Catch:{ Exception -> 0x020e }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x020e }
            if (r5 != 0) goto L_0x020e
            java.lang.String r5 = "umid"
            r2.put(r5, r3)     // Catch:{ Exception -> 0x020e }
        L_0x020e:
            int r3 = r2.length()     // Catch:{ Throwable -> 0x0248 }
            if (r3 <= 0) goto L_0x024c
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0248 }
            r3.<init>()     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r5 = "walle"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0248 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r8 = "[stateless] build header end , header is "
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r8 = r2.toString()     // Catch:{ Throwable -> 0x0248 }
            r7.append(r8)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r8 = ", thread is "
            r7.append(r8)     // Catch:{ Throwable -> 0x0248 }
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x0248 }
            r7.append(r8)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r7 = r7.toString()     // Catch:{ Throwable -> 0x0248 }
            r6[r4] = r7     // Catch:{ Throwable -> 0x0248 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ Throwable -> 0x0248 }
            java.lang.String r5 = "header"
            org.json.JSONObject r2 = r3.put(r5, r2)     // Catch:{ Throwable -> 0x0248 }
            monitor-exit(r9)
            return r2
        L_0x0248:
            r2 = move-exception
            com.umeng.commonsdk.proguard.e.a(r10, r2)     // Catch:{ all -> 0x0269 }
        L_0x024c:
            java.lang.String r10 = "walle"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0269 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0269 }
            java.lang.String r3 = "[stateless] build header end , header is null !!! thread is "
            r2.<init>(r3)     // Catch:{ all -> 0x0269 }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0269 }
            r2.append(r3)     // Catch:{ all -> 0x0269 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0269 }
            r1[r4] = r2     // Catch:{ all -> 0x0269 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0269 }
            monitor-exit(r9)
            return r0
        L_0x0269:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.buildSLBaseHeader(android.content.Context):org.json.JSONObject");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x007d: MOVE  (r5v23 java.lang.String) = (r5v22 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public synchronized org.json.JSONObject buildSLEnvelope(android.content.Context r10, org.json.JSONObject r11, org.json.JSONObject r12, java.lang.String r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "walle"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            java.lang.String r4 = "[stateless] build envelope, heade is "
            r3.<init>(r4)     // Catch:{ all -> 0x0247 }
            java.lang.String r4 = r11.toString()     // Catch:{ all -> 0x0247 }
            r3.append(r4)     // Catch:{ all -> 0x0247 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0247 }
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x0247 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0247 }
            java.lang.String r0 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = "[stateless] build envelope, body is "
            r3.<init>(r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = r12.toString()     // Catch:{ all -> 0x0247 }
            r3.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0247 }
            r2[r4] = r3     // Catch:{ all -> 0x0247 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0247 }
            java.lang.String r0 = "walle"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = "[stateless] build envelope, thread is "
            r3.<init>(r5)     // Catch:{ all -> 0x0247 }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0247 }
            r3.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0247 }
            r2[r4] = r3     // Catch:{ all -> 0x0247 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0247 }
            r0 = 110(0x6e, float:1.54E-43)
            r2 = 0
            if (r10 == 0) goto L_0x0236
            if (r11 == 0) goto L_0x0236
            if (r12 == 0) goto L_0x0236
            if (r13 != 0) goto L_0x0061
            goto L_0x0236
        L_0x0061:
            android.content.Context r3 = r10.getApplicationContext()     // Catch:{ Throwable -> 0x020f }
            if (r11 == 0) goto L_0x0092
            if (r12 == 0) goto L_0x0092
            java.util.Iterator r10 = r12.keys()     // Catch:{ Throwable -> 0x008f }
        L_0x006d:
            boolean r5 = r10.hasNext()     // Catch:{ Throwable -> 0x008f }
            if (r5 == 0) goto L_0x0092
            java.lang.Object r5 = r10.next()     // Catch:{ Throwable -> 0x008f }
            if (r5 == 0) goto L_0x006d
            boolean r6 = r5 instanceof java.lang.String     // Catch:{ Throwable -> 0x008f }
            if (r6 == 0) goto L_0x006d
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x008f }
            if (r5 == 0) goto L_0x006d
            java.lang.Object r6 = r12.opt(r5)     // Catch:{ Throwable -> 0x008f }
            if (r6 == 0) goto L_0x006d
            java.lang.Object r6 = r12.opt(r5)     // Catch:{ Exception -> 0x006d }
            r11.put(r5, r6)     // Catch:{ Exception -> 0x006d }
            goto L_0x006d
        L_0x008f:
            r10 = move-exception
            goto L_0x0212
        L_0x0092:
            if (r11 == 0) goto L_0x00c4
            com.umeng.commonsdk.statistics.idtracking.e r10 = com.umeng.commonsdk.statistics.idtracking.e.a((android.content.Context) r3)     // Catch:{ Exception -> 0x00c4 }
            if (r10 == 0) goto L_0x00c4
            r10.a()     // Catch:{ Exception -> 0x00c4 }
            com.umeng.commonsdk.statistics.proto.c r10 = r10.b()     // Catch:{ Exception -> 0x00c4 }
            com.umeng.commonsdk.proguard.aj r12 = new com.umeng.commonsdk.proguard.aj     // Catch:{ Exception -> 0x00c4 }
            r12.<init>()     // Catch:{ Exception -> 0x00c4 }
            byte[] r10 = r12.a(r10)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r10 = android.util.Base64.encodeToString(r10, r4)     // Catch:{ Exception -> 0x00c4 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00c4 }
            if (r12 != 0) goto L_0x00c4
            java.lang.String r12 = "header"
            org.json.JSONObject r12 = r11.getJSONObject(r12)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r5 = "id_tracking"
            r12.put(r5, r10)     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r10 = "header"
            r11.put(r10, r12)     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            if (r11 == 0) goto L_0x0100
            java.lang.String r10 = r11.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r10 = r10.getBytes()     // Catch:{ Throwable -> 0x008f }
            int r10 = r10.length     // Catch:{ Throwable -> 0x008f }
            long r5 = (long) r10     // Catch:{ Throwable -> 0x008f }
            long r7 = com.umeng.commonsdk.stateless.a.f3841a     // Catch:{ Throwable -> 0x008f }
            boolean r10 = com.umeng.commonsdk.stateless.f.a((long) r5, (long) r7)     // Catch:{ Throwable -> 0x008f }
            if (r10 == 0) goto L_0x0100
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = "[stateless] build envelope, json overstep!!!! size is "
            r13.<init>(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = r11.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r5 = r5.getBytes()     // Catch:{ Throwable -> 0x008f }
            int r5 = r5.length     // Catch:{ Throwable -> 0x008f }
            r13.append(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = r13.toString()     // Catch:{ Throwable -> 0x008f }
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            r10 = 113(0x71, float:1.58E-43)
            org.json.JSONObject r10 = r9.makeErrorResult(r10, r11)     // Catch:{ Throwable -> 0x008f }
            monitor-exit(r9)
            return r10
        L_0x0100:
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            java.lang.String r6 = "[stateless] build envelope, json size is "
            r5.<init>(r6)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r6 = r11.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r6 = r6.getBytes()     // Catch:{ Throwable -> 0x008f }
            int r6 = r6.length     // Catch:{ Throwable -> 0x008f }
            r5.append(r6)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x008f }
            r12[r4] = r5     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            if (r11 == 0) goto L_0x0143
            java.lang.String r10 = r11.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r10 = r10.getBytes()     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.stateless.c r10 = r9.constructEnvelope(r3, r10)     // Catch:{ Throwable -> 0x008f }
            if (r10 != 0) goto L_0x0144
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = "[stateless] build envelope, envelope is null !!!!"
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            r10 = 111(0x6f, float:1.56E-43)
            org.json.JSONObject r10 = r9.makeErrorResult(r10, r11)     // Catch:{ Throwable -> 0x008f }
            monitor-exit(r9)
            return r10
        L_0x0143:
            r10 = r2
        L_0x0144:
            if (r10 == 0) goto L_0x0178
            byte[] r12 = r10.b()     // Catch:{ Throwable -> 0x008f }
            int r12 = r12.length     // Catch:{ Throwable -> 0x008f }
            long r5 = (long) r12     // Catch:{ Throwable -> 0x008f }
            long r7 = com.umeng.commonsdk.stateless.a.f3842b     // Catch:{ Throwable -> 0x008f }
            boolean r12 = com.umeng.commonsdk.stateless.f.a((long) r5, (long) r7)     // Catch:{ Throwable -> 0x008f }
            if (r12 == 0) goto L_0x0178
            java.lang.String r12 = "walle"
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            java.lang.String r6 = "[stateless] build envelope, envelope overstep!!!! size is "
            r5.<init>(r6)     // Catch:{ Throwable -> 0x008f }
            byte[] r10 = r10.b()     // Catch:{ Throwable -> 0x008f }
            int r10 = r10.length     // Catch:{ Throwable -> 0x008f }
            r5.append(r10)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r10 = r5.toString()     // Catch:{ Throwable -> 0x008f }
            r13[r4] = r10     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r12, (java.lang.Object[]) r13)     // Catch:{ Throwable -> 0x008f }
            r10 = 114(0x72, float:1.6E-43)
            org.json.JSONObject r10 = r9.makeErrorResult(r10, r11)     // Catch:{ Throwable -> 0x008f }
            monitor-exit(r9)
            return r10
        L_0x0178:
            byte[] r12 = r13.getBytes()     // Catch:{ Throwable -> 0x008f }
            java.lang.String r12 = android.util.Base64.encodeToString(r12, r4)     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            r5.<init>()     // Catch:{ Throwable -> 0x008f }
            r5.append(r13)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = "_"
            r5.append(r13)     // Catch:{ Throwable -> 0x008f }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x008f }
            r5.append(r6)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = r5.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r13 = r13.getBytes()     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = android.util.Base64.encodeToString(r13, r4)     // Catch:{ Throwable -> 0x008f }
            byte[] r10 = r10.b()     // Catch:{ Throwable -> 0x008f }
            boolean r10 = com.umeng.commonsdk.stateless.f.a(r3, r12, r13, r10)     // Catch:{ Throwable -> 0x008f }
            if (r10 != 0) goto L_0x01bd
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = "[stateless] build envelope, save fail ----->>>>>"
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            r10 = 101(0x65, float:1.42E-43)
            org.json.JSONObject r10 = r9.makeErrorResult(r10, r11)     // Catch:{ Throwable -> 0x008f }
            monitor-exit(r9)
            return r10
        L_0x01bd:
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = "[stateless] build envelope, save ok ----->>>>>"
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = "[stateless] envelope file size is "
            r13.<init>(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = r11.toString()     // Catch:{ Throwable -> 0x008f }
            byte[] r5 = r5.getBytes()     // Catch:{ Throwable -> 0x008f }
            int r5 = r5.length     // Catch:{ Throwable -> 0x008f }
            r13.append(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = r13.toString()     // Catch:{ Throwable -> 0x008f }
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.stateless.d r10 = new com.umeng.commonsdk.stateless.d     // Catch:{ Throwable -> 0x008f }
            r10.<init>(r3)     // Catch:{ Throwable -> 0x008f }
            r10 = 273(0x111, float:3.83E-43)
            com.umeng.commonsdk.stateless.d.b(r10)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r10 = "walle"
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x008f }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x008f }
            java.lang.String r5 = "[stateless] build envelope end, thread is "
            r13.<init>(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ Throwable -> 0x008f }
            r13.append(r5)     // Catch:{ Throwable -> 0x008f }
            java.lang.String r13 = r13.toString()     // Catch:{ Throwable -> 0x008f }
            r12[r4] = r13     // Catch:{ Throwable -> 0x008f }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r12)     // Catch:{ Throwable -> 0x008f }
            monitor-exit(r9)
            return r11
        L_0x020f:
            r11 = move-exception
            r3 = r10
            r10 = r11
        L_0x0212:
            com.umeng.commonsdk.proguard.e.a(r3, r10)     // Catch:{ all -> 0x0247 }
            java.lang.String r10 = "walle"
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            java.lang.String r13 = "build envelope end, thread is "
            r12.<init>(r13)     // Catch:{ all -> 0x0247 }
            java.lang.Thread r13 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0247 }
            r12.append(r13)     // Catch:{ all -> 0x0247 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0247 }
            r11[r4] = r12     // Catch:{ all -> 0x0247 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r11)     // Catch:{ all -> 0x0247 }
            org.json.JSONObject r10 = r9.makeErrorResult(r0, r2)     // Catch:{ all -> 0x0247 }
            monitor-exit(r9)
            return r10
        L_0x0236:
            java.lang.String r10 = "walle"
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ all -> 0x0247 }
            java.lang.String r12 = "[stateless] build envelope, context is null or header is null or body is null"
            r11[r4] = r12     // Catch:{ all -> 0x0247 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r10, (java.lang.Object[]) r11)     // Catch:{ all -> 0x0247 }
            org.json.JSONObject r10 = r9.makeErrorResult(r0, r2)     // Catch:{ all -> 0x0247 }
            monitor-exit(r9)
            return r10
        L_0x0247:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.UMSLEnvelopeBuild.buildSLEnvelope(android.content.Context, org.json.JSONObject, org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }
}
