package mobi.oneway.export.g;

import android.location.Location;
import android.location.LocationManager;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import mobi.oneway.export.a.b;

public class l {

    private enum a {
        lat,
        lon
    }

    public static String a() {
        return a(a.lat);
    }

    private static String a(a aVar) {
        try {
            LocationManager locationManager = (LocationManager) b.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            if (!locationManager.isProviderEnabled("gps")) {
                return b(aVar);
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                return b(aVar);
            }
            switch (aVar) {
                case lat:
                    return String.valueOf(lastKnownLocation.getLatitude());
                case lon:
                    return String.valueOf(lastKnownLocation.getLongitude());
                default:
                    return "";
            }
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        return a(a.lon);
    }

    private static String b(a aVar) {
        double latitude;
        Location lastKnownLocation = ((LocationManager) b.a().getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).getLastKnownLocation("network");
        if (lastKnownLocation == null) {
            return "";
        }
        switch (aVar) {
            case lat:
                latitude = lastKnownLocation.getLatitude();
                break;
            case lon:
                latitude = lastKnownLocation.getLongitude();
                break;
            default:
                return "";
        }
        return String.valueOf(latitude);
    }
}
