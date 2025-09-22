package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.e;

public class k {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3786b = "BaseStationUtils";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3787c = false;
    /* access modifiers changed from: private */
    public static Context d;

    /* renamed from: a  reason: collision with root package name */
    PhoneStateListener f3788a;
    /* access modifiers changed from: private */
    public TelephonyManager e;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f3790a = new k(k.d);

        private a() {
        }
    }

    private k(Context context) {
        this.f3788a = new PhoneStateListener() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00e9 A[SYNTHETIC, Splitter:B:34:0x00e9] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSignalStrengthsChanged(android.telephony.SignalStrength r8) {
                /*
                    r7 = this;
                    super.onSignalStrengthsChanged(r8)
                    java.lang.String r0 = "BaseStationUtils"
                    r1 = 1
                    java.lang.Object[] r2 = new java.lang.Object[r1]
                    java.lang.String r3 = "base station onSignalStrengthsChanged"
                    r4 = 0
                    r2[r4] = r3
                    com.umeng.commonsdk.statistics.common.e.c((java.lang.String) r0, (java.lang.Object[]) r2)
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.content.Context r2 = com.umeng.commonsdk.proguard.k.d     // Catch:{ Exception -> 0x010e }
                    java.lang.String r3 = "phone"
                    java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager unused = r0.e = r2     // Catch:{ Exception -> 0x010e }
                    java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x010e }
                    java.lang.String r2 = " "
                    java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x010e }
                    r2 = 0
                    com.umeng.commonsdk.proguard.k r3 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r3 = r3.e     // Catch:{ Exception -> 0x010e }
                    int r3 = r3.getNetworkType()     // Catch:{ Exception -> 0x010e }
                    r5 = 13
                    r6 = 9
                    if (r3 != r5) goto L_0x0048
                    r8 = r0[r6]     // Catch:{ Exception -> 0x010e }
                    int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x010e }
                L_0x0042:
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x010e }
                    goto L_0x00cc
                L_0x0048:
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r0 = r0.e     // Catch:{ Exception -> 0x010e }
                    int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x010e }
                    r3 = 8
                    if (r0 == r3) goto L_0x008b
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r0 = r0.e     // Catch:{ Exception -> 0x010e }
                    int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x010e }
                    r3 = 10
                    if (r0 == r3) goto L_0x008b
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r0 = r0.e     // Catch:{ Exception -> 0x010e }
                    int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x010e }
                    if (r0 == r6) goto L_0x008b
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    android.telephony.TelephonyManager r0 = r0.e     // Catch:{ Exception -> 0x010e }
                    int r0 = r0.getNetworkType()     // Catch:{ Exception -> 0x010e }
                    r3 = 3
                    if (r0 != r3) goto L_0x007e
                    goto L_0x008b
                L_0x007e:
                    int r8 = r8.getGsmSignalStrength()     // Catch:{ Exception -> 0x010e }
                    int r8 = r8 * 2
                    int r8 = r8 + -113
                    java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x010e }
                    goto L_0x00cc
                L_0x008b:
                    com.umeng.commonsdk.proguard.k r0 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    java.lang.String r0 = r0.e()     // Catch:{ Exception -> 0x010e }
                    boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010e }
                    if (r3 != 0) goto L_0x00a2
                    java.lang.String r3 = "中国移动"
                    boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x010e }
                    if (r3 == 0) goto L_0x00a2
                    java.lang.String r8 = "0"
                    goto L_0x00cc
                L_0x00a2:
                    boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010e }
                    if (r3 != 0) goto L_0x00b5
                    java.lang.String r3 = "中国联通"
                    boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x010e }
                    if (r3 == 0) goto L_0x00b5
                    int r8 = r8.getCdmaDbm()     // Catch:{ Exception -> 0x010e }
                    goto L_0x0042
                L_0x00b5:
                    boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x010e }
                    if (r3 != 0) goto L_0x00cb
                    java.lang.String r3 = "中国电信"
                    boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x010e }
                    if (r0 == 0) goto L_0x00cb
                    int r8 = r8.getEvdoDbm()     // Catch:{ Exception -> 0x010e }
                    java.lang.String r2 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x010e }
                L_0x00cb:
                    r8 = r2
                L_0x00cc:
                    java.lang.String r0 = "BaseStationUtils"
                    java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x010e }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010e }
                    java.lang.String r3 = "stationStrength is "
                    r2.<init>(r3)     // Catch:{ Exception -> 0x010e }
                    r2.append(r8)     // Catch:{ Exception -> 0x010e }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x010e }
                    r1[r4] = r2     // Catch:{ Exception -> 0x010e }
                    com.umeng.commonsdk.statistics.common.e.c((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x010e }
                    boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x010e }
                    if (r0 != 0) goto L_0x0108
                    android.content.Context r0 = com.umeng.commonsdk.proguard.k.d     // Catch:{ Throwable -> 0x0100 }
                    r1 = 32772(0x8004, float:4.5923E-41)
                    android.content.Context r2 = com.umeng.commonsdk.proguard.k.d     // Catch:{ Throwable -> 0x0100 }
                    com.umeng.commonsdk.proguard.b r2 = com.umeng.commonsdk.proguard.b.a(r2)     // Catch:{ Throwable -> 0x0100 }
                    com.umeng.commonsdk.proguard.c r2 = r2.a()     // Catch:{ Throwable -> 0x0100 }
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r0, r1, r2, r8)     // Catch:{ Throwable -> 0x0100 }
                    goto L_0x0108
                L_0x0100:
                    r8 = move-exception
                    android.content.Context r0 = com.umeng.commonsdk.proguard.k.d     // Catch:{ Exception -> 0x010e }
                    com.umeng.commonsdk.proguard.e.a(r0, r8)     // Catch:{ Exception -> 0x010e }
                L_0x0108:
                    com.umeng.commonsdk.proguard.k r8 = com.umeng.commonsdk.proguard.k.this     // Catch:{ Exception -> 0x010e }
                    r8.c()     // Catch:{ Exception -> 0x010e }
                    return
                L_0x010e:
                    r8 = move-exception
                    android.content.Context r0 = com.umeng.commonsdk.proguard.k.d
                    com.umeng.commonsdk.proguard.e.a(r0, r8)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.k.AnonymousClass1.onSignalStrengthsChanged(android.telephony.SignalStrength):void");
            }
        };
        if (context != null) {
            try {
                this.e = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
        }
    }

    public static k a(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
        }
        return a.f3790a;
    }

    /* access modifiers changed from: private */
    public String e() {
        String str;
        try {
            String simOperator = ((TelephonyManager) d.getSystemService("phone")).getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                if (!simOperator.equals("46000")) {
                    if (!simOperator.equals("46002")) {
                        if (simOperator.equals("46001")) {
                            str = "中国联通";
                        } else if (simOperator.equals("46003")) {
                            str = "中国电信";
                        }
                        return str;
                    }
                }
                str = "中国移动";
                return str;
            }
        } catch (Throwable th) {
            e.a(d, th);
        }
        return null;
    }

    public synchronized boolean a() {
        return f3787c;
    }

    public synchronized void b() {
        e.c(f3786b, "base station registerListener");
        try {
            if (this.e != null) {
                this.e.listen(this.f3788a, 256);
            }
            f3787c = true;
        } catch (Throwable th) {
            e.a(d, th);
        }
    }

    public synchronized void c() {
        e.c(f3786b, "base station unRegisterListener");
        try {
            if (this.e != null) {
                this.e.listen(this.f3788a, 0);
            }
            f3787c = false;
        } catch (Throwable th) {
            e.a(d, th);
        }
    }
}
