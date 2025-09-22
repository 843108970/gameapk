package com.c.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class f extends a<Location, f> {
    private int A = 0;
    private boolean B = false;
    private boolean C = false;
    private a D;
    private a E;
    private long F;
    /* access modifiers changed from: private */
    public LocationManager u;
    private long v = 30000;
    private long w = 1000;
    private float x = 10.0f;
    private float y = 1000.0f;
    private int z = 3;

    private class a extends TimerTask implements LocationListener {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        public final void onLocationChanged(Location location) {
            com.c.d.a.b((Object) "changed", (Object) location);
            f.a(f.this, location);
        }

        public final void onProviderDisabled(String str) {
            com.c.d.a.a((Object) "onProviderDisabled");
        }

        public final void onProviderEnabled(String str) {
            com.c.d.a.a((Object) "onProviderEnabled");
            f.a(f.this, f.this.g());
            f.this.u.removeUpdates(this);
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            com.c.d.a.a((Object) "onStatusChanged");
        }

        public final void run() {
            f.c(f.this);
        }
    }

    public f() {
        this.f1538b = Location.class;
        this.f1539c = "device";
    }

    private static float a(double d, double d2, double d3, double d4) {
        double radians = Math.toRadians(d3 - d);
        double d5 = radians / 2.0d;
        double radians2 = Math.toRadians(d4 - d2) / 2.0d;
        double sin = (Math.sin(d5) * Math.sin(d5)) + (Math.cos(Math.toRadians(d)) * Math.cos(Math.toRadians(d3)) * Math.sin(radians2) * Math.sin(radians2));
        return ((float) (Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 3958.75d)) * 1609.0f;
    }

    private f a(float f) {
        this.y = f;
        return this;
    }

    private f a(int i) {
        this.z = i;
        return this;
    }

    private f a(long j) {
        this.v = j;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011a, code lost:
        if (r2 != false) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.location.Location r18) {
        /*
            r17 = this;
            r0 = r17
            if (r18 == 0) goto L_0x0120
            java.lang.Object r1 = r0.i
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r0.i
            android.location.Location r1 = (android.location.Location) r1
            long r4 = r1.getTime()
            long r6 = r0.F
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x003b
            java.lang.Object r1 = r0.i
            android.location.Location r1 = (android.location.Location) r1
            java.lang.String r1 = r1.getProvider()
            java.lang.String r4 = "gps"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r18.getProvider()
            java.lang.String r4 = "network"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = "inferior location"
            com.c.d.a.a((java.lang.Object) r1)
            r1 = 0
            goto L_0x003c
        L_0x003b:
            r1 = 1
        L_0x003c:
            if (r1 == 0) goto L_0x0120
            int r1 = r0.A
            int r1 = r1 + r3
            r0.A = r1
            int r1 = r0.A
            int r4 = r0.z
            if (r1 < r4) goto L_0x004b
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            float r4 = r18.getAccuracy()
            float r5 = r0.y
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0058
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            java.lang.Object r5 = r0.i
            if (r5 == 0) goto L_0x00d8
            java.lang.Object r5 = r0.i
            android.location.Location r5 = (android.location.Location) r5
            double r5 = r5.getLatitude()
            java.lang.Object r7 = r0.i
            android.location.Location r7 = (android.location.Location) r7
            double r7 = r7.getLongitude()
            double r9 = r18.getLatitude()
            double r11 = r18.getLongitude()
            double r13 = r9 - r5
            double r13 = java.lang.Math.toRadians(r13)
            double r11 = r11 - r7
            double r7 = java.lang.Math.toRadians(r11)
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r13 = r13 / r11
            double r15 = java.lang.Math.sin(r13)
            double r13 = java.lang.Math.sin(r13)
            double r15 = r15 * r13
            double r5 = java.lang.Math.toRadians(r5)
            double r5 = java.lang.Math.cos(r5)
            double r9 = java.lang.Math.toRadians(r9)
            double r9 = java.lang.Math.cos(r9)
            double r5 = r5 * r9
            double r7 = r7 / r11
            double r9 = java.lang.Math.sin(r7)
            double r5 = r5 * r9
            double r7 = java.lang.Math.sin(r7)
            double r5 = r5 * r7
            double r5 = r5 + r15
            double r7 = java.lang.Math.sqrt(r5)
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r9 = r9 - r5
            double r5 = java.lang.Math.sqrt(r9)
            double r5 = java.lang.Math.atan2(r7, r5)
            double r5 = r5 * r11
            r7 = 4660923798386638848(0x40aeed8000000000, double:3958.75)
            double r5 = r5 * r7
            float r5 = (float) r5
            r6 = 1154031616(0x44c92000, float:1609.0)
            float r5 = r5 * r6
            float r6 = r0.x
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00d8
            java.lang.String r5 = "duplicate location"
            com.c.d.a.a((java.lang.Object) r5)
            r5 = 0
            goto L_0x00d9
        L_0x00d8:
            r5 = 1
        L_0x00d9:
            boolean r6 = r0.C
            if (r6 == 0) goto L_0x00ea
            java.lang.String r6 = "gps"
            java.lang.String r7 = r18.getProvider()
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00ea
            goto L_0x00eb
        L_0x00ea:
            r2 = 1
        L_0x00eb:
            int r3 = r0.A
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r6 = r0.z
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            java.lang.String r3 = "acc"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            java.lang.String r3 = "best"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0120
            if (r1 == 0) goto L_0x0118
            if (r4 == 0) goto L_0x0120
            if (r2 == 0) goto L_0x0120
        L_0x0114:
            r17.e()
            goto L_0x011d
        L_0x0118:
            if (r4 == 0) goto L_0x011d
            if (r2 == 0) goto L_0x011d
            goto L_0x0114
        L_0x011d:
            r17.b((android.location.Location) r18)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.f.a(android.location.Location):void");
    }

    private void a(Location location, int i) {
        if (this.m == null) {
            this.m = new c();
        }
        if (location != null) {
            this.m.n = new Date(location.getTime());
        }
        c cVar = this.m;
        cVar.i = i;
        cVar.a().r = 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011a, code lost:
        if (r2 != false) goto L_0x0114;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.c.b.f r17, android.location.Location r18) {
        /*
            r0 = r17
            if (r18 == 0) goto L_0x0120
            java.lang.Object r1 = r0.i
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r0.i
            android.location.Location r1 = (android.location.Location) r1
            long r4 = r1.getTime()
            long r6 = r0.F
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x003b
            java.lang.Object r1 = r0.i
            android.location.Location r1 = (android.location.Location) r1
            java.lang.String r1 = r1.getProvider()
            java.lang.String r4 = "gps"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r18.getProvider()
            java.lang.String r4 = "network"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = "inferior location"
            com.c.d.a.a((java.lang.Object) r1)
            r1 = 0
            goto L_0x003c
        L_0x003b:
            r1 = 1
        L_0x003c:
            if (r1 == 0) goto L_0x0120
            int r1 = r0.A
            int r1 = r1 + r3
            r0.A = r1
            int r1 = r0.A
            int r4 = r0.z
            if (r1 < r4) goto L_0x004b
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            float r4 = r18.getAccuracy()
            float r5 = r0.y
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0058
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            java.lang.Object r5 = r0.i
            if (r5 == 0) goto L_0x00d8
            java.lang.Object r5 = r0.i
            android.location.Location r5 = (android.location.Location) r5
            double r5 = r5.getLatitude()
            java.lang.Object r7 = r0.i
            android.location.Location r7 = (android.location.Location) r7
            double r7 = r7.getLongitude()
            double r9 = r18.getLatitude()
            double r11 = r18.getLongitude()
            double r13 = r9 - r5
            double r13 = java.lang.Math.toRadians(r13)
            double r11 = r11 - r7
            double r7 = java.lang.Math.toRadians(r11)
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r13 = r13 / r11
            double r15 = java.lang.Math.sin(r13)
            double r13 = java.lang.Math.sin(r13)
            double r15 = r15 * r13
            double r5 = java.lang.Math.toRadians(r5)
            double r5 = java.lang.Math.cos(r5)
            double r9 = java.lang.Math.toRadians(r9)
            double r9 = java.lang.Math.cos(r9)
            double r5 = r5 * r9
            double r7 = r7 / r11
            double r9 = java.lang.Math.sin(r7)
            double r5 = r5 * r9
            double r7 = java.lang.Math.sin(r7)
            double r5 = r5 * r7
            double r5 = r5 + r15
            double r7 = java.lang.Math.sqrt(r5)
            r9 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r9 = r9 - r5
            double r5 = java.lang.Math.sqrt(r9)
            double r5 = java.lang.Math.atan2(r7, r5)
            double r5 = r5 * r11
            r7 = 4660923798386638848(0x40aeed8000000000, double:3958.75)
            double r5 = r5 * r7
            float r5 = (float) r5
            r6 = 1154031616(0x44c92000, float:1609.0)
            float r5 = r5 * r6
            float r6 = r0.x
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x00d8
            java.lang.String r5 = "duplicate location"
            com.c.d.a.a((java.lang.Object) r5)
            r5 = 0
            goto L_0x00d9
        L_0x00d8:
            r5 = 1
        L_0x00d9:
            boolean r6 = r0.C
            if (r6 == 0) goto L_0x00ea
            java.lang.String r6 = "gps"
            java.lang.String r7 = r18.getProvider()
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00ea
            goto L_0x00eb
        L_0x00ea:
            r2 = 1
        L_0x00eb:
            int r3 = r0.A
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r6 = r0.z
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            java.lang.String r3 = "acc"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            java.lang.String r3 = "best"
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
            com.c.d.a.b((java.lang.Object) r3, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x0120
            if (r1 == 0) goto L_0x0118
            if (r4 == 0) goto L_0x0120
            if (r2 == 0) goto L_0x0120
        L_0x0114:
            r17.e()
            goto L_0x011d
        L_0x0118:
            if (r4 == 0) goto L_0x011d
            if (r2 == 0) goto L_0x011d
            goto L_0x0114
        L_0x011d:
            r17.b((android.location.Location) r18)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.b.f.a(com.c.b.f, android.location.Location):void");
    }

    private f b(float f) {
        this.x = f;
        return this;
    }

    private void b(Location location) {
        this.i = location;
        a(location, 200);
        a();
    }

    static /* synthetic */ void c(f fVar) {
        if (fVar.E != null || fVar.D != null) {
            com.c.d.a.a((Object) "fail");
            fVar.i = null;
            fVar.a((Location) null, (int) c.h);
            fVar.e();
            fVar.a();
        }
    }

    private boolean c(Location location) {
        return location.getAccuracy() < this.y;
    }

    private void d() {
        if (this.E != null || this.D != null) {
            com.c.d.a.a((Object) "fail");
            this.i = null;
            a((Location) null, (int) c.h);
            e();
            a();
        }
    }

    private boolean d(Location location) {
        if (this.i == null) {
            return true;
        }
        double latitude = ((Location) this.i).getLatitude();
        double longitude = ((Location) this.i).getLongitude();
        double latitude2 = location.getLatitude();
        double longitude2 = location.getLongitude();
        double radians = Math.toRadians(latitude2 - latitude);
        double d = radians / 2.0d;
        double radians2 = Math.toRadians(longitude2 - longitude) / 2.0d;
        double sin = (Math.sin(d) * Math.sin(d)) + (Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(latitude2)) * Math.sin(radians2) * Math.sin(radians2));
        if (((float) (Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 3958.75d)) * 1609.0f >= this.x) {
            return true;
        }
        com.c.d.a.a((Object) "duplicate location");
        return false;
    }

    private void e() {
        com.c.d.a.a((Object) "stop");
        a aVar = this.E;
        if (aVar != null) {
            this.u.removeUpdates(aVar);
            aVar.cancel();
        }
        a aVar2 = this.D;
        if (aVar2 != null) {
            this.u.removeUpdates(aVar2);
            aVar2.cancel();
        }
        this.E = null;
        this.D = null;
    }

    private boolean e(Location location) {
        if (this.i == null || ((Location) this.i).getTime() <= this.F || !((Location) this.i).getProvider().equals("gps") || !location.getProvider().equals("network")) {
            return true;
        }
        com.c.d.a.a((Object) "inferior location");
        return false;
    }

    private void f() {
        Location g = g();
        Timer timer = new Timer(false);
        if (this.B) {
            com.c.d.a.a((Object) "register net");
            this.D = new a(this, (byte) 0);
            this.u.requestLocationUpdates("network", this.w, 0.0f, this.D, Looper.getMainLooper());
            timer.schedule(this.D, this.v);
        }
        if (this.C) {
            com.c.d.a.a((Object) "register gps");
            this.E = new a(this, (byte) 0);
            this.u.requestLocationUpdates("gps", this.w, 0.0f, this.E, Looper.getMainLooper());
            timer.schedule(this.E, this.v);
        }
        if (this.z > 1 && g != null) {
            this.A++;
            b(g);
        }
        this.F = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public Location g() {
        Location lastKnownLocation = this.u.getLastKnownLocation("gps");
        Location lastKnownLocation2 = this.u.getLastKnownLocation("network");
        return lastKnownLocation2 == null ? lastKnownLocation : (lastKnownLocation != null && lastKnownLocation.getTime() > lastKnownLocation2.getTime()) ? lastKnownLocation : lastKnownLocation2;
    }

    public final void a(Context context) {
        this.u = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        this.C = this.u.isProviderEnabled("gps");
        this.B = this.u.isProviderEnabled("network");
        Location g = g();
        Timer timer = new Timer(false);
        if (this.B) {
            com.c.d.a.a((Object) "register net");
            this.D = new a(this, (byte) 0);
            this.u.requestLocationUpdates("network", this.w, 0.0f, this.D, Looper.getMainLooper());
            timer.schedule(this.D, this.v);
        }
        if (this.C) {
            com.c.d.a.a((Object) "register gps");
            this.E = new a(this, (byte) 0);
            this.u.requestLocationUpdates("gps", this.w, 0.0f, this.E, Looper.getMainLooper());
            timer.schedule(this.E, this.v);
        }
        if (this.z > 1 && g != null) {
            this.A++;
            b(g);
        }
        this.F = System.currentTimeMillis();
    }
}
