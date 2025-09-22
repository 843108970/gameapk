package com.cyjh.elfin.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.List;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1919a = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};

    /* renamed from: c  reason: collision with root package name */
    private static i f1920c;

    /* renamed from: b  reason: collision with root package name */
    public LocationListener f1921b = new LocationListener() {
        public final void onLocationChanged(Location location) {
            if (i.this.f != null) {
                a unused = i.this.f;
            }
        }

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };
    private Context d;
    private LocationManager e;
    /* access modifiers changed from: private */
    public a f;

    public interface a {
        void a();

        void b();
    }

    private i(Context context) {
        this.d = context;
    }

    private static i a(Context context) {
        if (f1920c == null) {
            f1920c = new i(context);
        }
        return f1920c;
    }

    @SuppressLint({"MissingPermission"})
    private String[] a() {
        String str;
        String[] strArr = {"0.0", "0.0"};
        this.e = (LocationManager) this.d.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
        List<String> providers = this.e.getProviders(true);
        if (providers.contains("gps")) {
            str = "gps";
        } else {
            if (providers.contains("network")) {
                str = "network";
            }
            return strArr;
        }
        String str2 = str;
        Location lastKnownLocation = this.e.getLastKnownLocation(str2);
        if (lastKnownLocation != null) {
            strArr[0] = String.valueOf(lastKnownLocation.getLongitude());
            strArr[1] = String.valueOf(lastKnownLocation.getLatitude());
        }
        this.e.requestLocationUpdates(str2, 3000, 1.0f, this.f1921b);
        return strArr;
    }

    private String[] a(a aVar) {
        this.f = aVar;
        String[] strArr = {"0.0", "0.0"};
        if (Build.VERSION.SDK_INT < 23) {
            return a();
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= f1919a.length) {
                break;
            } else if (this.d.checkCallingOrSelfPermission(f1919a[i]) == -1) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        return z ? strArr : a();
    }

    private boolean b() {
        for (String checkCallingOrSelfPermission : f1919a) {
            if (this.d.checkCallingOrSelfPermission(checkCallingOrSelfPermission) == -1) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        this.e.removeUpdates(this.f1921b);
    }
}
