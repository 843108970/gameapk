package com.umeng.commonsdk.proguard;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3764a = "UMSysLocation";

    /* renamed from: c  reason: collision with root package name */
    private static final int f3765c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LocationManager f3766b;
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public Context e;
    /* access modifiers changed from: private */
    public LocationListener f = new LocationListener() {
        public void onLocationChanged(Location location) {
            e.a(g.f3764a, "onLocationChanged");
            try {
                boolean unused = g.this.d = false;
                if (g.this.g != null) {
                    g.this.g.a(location);
                }
            } catch (Throwable th) {
                e.a(g.this.e, th);
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    /* access modifiers changed from: private */
    public i g;

    private g() {
    }

    public g(Context context) {
        if (context == null) {
            MLog.e("Context参数不能为null");
            return;
        }
        this.e = context.getApplicationContext();
        this.f3766b = (LocationManager) context.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "UMSysLocation"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0041 }
            r2 = 0
            java.lang.String r3 = "destroy"
            r1[r2] = r3     // Catch:{ all -> 0x0041 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0041 }
            android.content.Context r0 = r4.e     // Catch:{ Throwable -> 0x0039 }
            java.lang.String r1 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r0, r1)     // Catch:{ Throwable -> 0x0039 }
            if (r0 == 0) goto L_0x0037
            android.content.Context r0 = r4.e     // Catch:{ Throwable -> 0x0039 }
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r0, r1)     // Catch:{ Throwable -> 0x0039 }
            if (r0 != 0) goto L_0x0023
            goto L_0x0037
        L_0x0023:
            android.location.LocationManager r0 = r4.f3766b     // Catch:{ Throwable -> 0x0039 }
            if (r0 == 0) goto L_0x0035
            android.location.LocationListener r0 = r4.f     // Catch:{ Throwable -> 0x0039 }
            if (r0 == 0) goto L_0x0032
            android.location.LocationManager r0 = r4.f3766b     // Catch:{ RuntimeException | Throwable -> 0x0032 }
            android.location.LocationListener r1 = r4.f     // Catch:{ RuntimeException | Throwable -> 0x0032 }
            r0.removeUpdates(r1)     // Catch:{ RuntimeException | Throwable -> 0x0032 }
        L_0x0032:
            r0 = 0
            r4.f3766b = r0     // Catch:{ Throwable -> 0x0039 }
        L_0x0035:
            monitor-exit(r4)
            return
        L_0x0037:
            monitor-exit(r4)
            return
        L_0x0039:
            r0 = move-exception
            android.content.Context r1 = r4.e     // Catch:{ all -> 0x0041 }
            com.umeng.commonsdk.proguard.e.a(r1, r0)     // Catch:{ all -> 0x0041 }
            monitor-exit(r4)
            return
        L_0x0041:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.g.a():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cc, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ce, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.umeng.commonsdk.proguard.i r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            java.lang.String r0 = "UMSysLocation"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "getSystemLocation"
            r4 = 0
            r2[r4] = r3     // Catch:{ all -> 0x00cf }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x00cf }
            if (r15 == 0) goto L_0x00cd
            android.content.Context r0 = r14.e     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x0016
            goto L_0x00cd
        L_0x0016:
            r14.g = r15     // Catch:{ all -> 0x00cf }
            android.content.Context r0 = r14.e     // Catch:{ all -> 0x00cf }
            java.lang.String r2 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r0, r2)     // Catch:{ all -> 0x00cf }
            r2 = 0
            if (r0 == 0) goto L_0x00c2
            android.content.Context r0 = r14.e     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.checkPermission(r0, r3)     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x002f
            goto L_0x00c2
        L_0x002f:
            r14.d = r1     // Catch:{ Throwable -> 0x0097 }
            android.location.LocationManager r0 = r14.f3766b     // Catch:{ Throwable -> 0x0097 }
            r5 = 10000(0x2710, double:4.9407E-320)
            if (r0 == 0) goto L_0x0067
            android.location.LocationManager r0 = r14.f3766b     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r3 = "network"
            boolean r0 = r0.isProviderEnabled(r3)     // Catch:{ Throwable -> 0x0097 }
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = "UMSysLocation"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r7 = "NETWORK_PROVIDER"
            r3[r4] = r7     // Catch:{ Throwable -> 0x0097 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Throwable -> 0x0097 }
            android.location.LocationManager r8 = r14.f3766b     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r9 = "network"
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            android.location.LocationListener r13 = r14.f     // Catch:{ Throwable -> 0x0097 }
            r8.requestLocationUpdates(r9, r10, r12, r13)     // Catch:{ Throwable -> 0x0097 }
            java.util.Timer r0 = new java.util.Timer     // Catch:{ Throwable -> 0x0097 }
            r0.<init>()     // Catch:{ Throwable -> 0x0097 }
            com.umeng.commonsdk.proguard.g$2 r3 = new com.umeng.commonsdk.proguard.g$2     // Catch:{ Throwable -> 0x0097 }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0097 }
            r0.schedule(r3, r5)     // Catch:{ Throwable -> 0x0097 }
            monitor-exit(r14)
            return
        L_0x0067:
            android.location.LocationManager r0 = r14.f3766b     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r3 = "gps"
            boolean r0 = r0.isProviderEnabled(r3)     // Catch:{ Throwable -> 0x0097 }
            if (r0 == 0) goto L_0x0095
            java.lang.String r0 = "UMSysLocation"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r7 = "GPS_PROVIDER"
            r3[r4] = r7     // Catch:{ Throwable -> 0x0097 }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r0, (java.lang.Object[]) r3)     // Catch:{ Throwable -> 0x0097 }
            android.location.LocationManager r8 = r14.f3766b     // Catch:{ Throwable -> 0x0097 }
            java.lang.String r9 = "gps"
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            android.location.LocationListener r13 = r14.f     // Catch:{ Throwable -> 0x0097 }
            r8.requestLocationUpdates(r9, r10, r12, r13)     // Catch:{ Throwable -> 0x0097 }
            java.util.Timer r0 = new java.util.Timer     // Catch:{ Throwable -> 0x0097 }
            r0.<init>()     // Catch:{ Throwable -> 0x0097 }
            com.umeng.commonsdk.proguard.g$3 r3 = new com.umeng.commonsdk.proguard.g$3     // Catch:{ Throwable -> 0x0097 }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0097 }
            r0.schedule(r3, r5)     // Catch:{ Throwable -> 0x0097 }
        L_0x0095:
            monitor-exit(r14)
            return
        L_0x0097:
            r0 = move-exception
            java.lang.String r3 = "UMSysLocation"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00cf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = "e is "
            r5.<init>(r6)     // Catch:{ all -> 0x00cf }
            r5.append(r0)     // Catch:{ all -> 0x00cf }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00cf }
            r1[r4] = r5     // Catch:{ all -> 0x00cf }
            com.umeng.commonsdk.statistics.common.e.a((java.lang.String) r3, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00cf }
            if (r15 == 0) goto L_0x00bb
            r15.a(r2)     // Catch:{ Throwable -> 0x00b5 }
            goto L_0x00bb
        L_0x00b5:
            r15 = move-exception
            android.content.Context r1 = r14.e     // Catch:{ all -> 0x00cf }
            com.umeng.commonsdk.proguard.e.a(r1, r15)     // Catch:{ all -> 0x00cf }
        L_0x00bb:
            android.content.Context r15 = r14.e     // Catch:{ all -> 0x00cf }
            com.umeng.commonsdk.proguard.e.a(r15, r0)     // Catch:{ all -> 0x00cf }
            monitor-exit(r14)
            return
        L_0x00c2:
            com.umeng.commonsdk.proguard.i r15 = r14.g     // Catch:{ all -> 0x00cf }
            if (r15 == 0) goto L_0x00cb
            com.umeng.commonsdk.proguard.i r15 = r14.g     // Catch:{ all -> 0x00cf }
            r15.a(r2)     // Catch:{ all -> 0x00cf }
        L_0x00cb:
            monitor-exit(r14)
            return
        L_0x00cd:
            monitor-exit(r14)
            return
        L_0x00cf:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.g.a(com.umeng.commonsdk.proguard.i):void");
    }
}
