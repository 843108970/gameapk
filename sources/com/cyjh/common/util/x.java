package com.cyjh.common.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1788a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f1789b = 4;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1790c = 3;
    public static final int d = 2;
    public static final int e = 5;
    public static final int f = -1;
    private static ConnectivityManager g = null;
    private static final int h = 16;
    private static final int i = 17;
    private static final int j = 18;
    private static final int k = 1;

    private x() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean a(Context context) {
        NetworkInfo d2 = d(context);
        return d2 != null && d2.isAvailable();
    }

    public static int b(Context context) {
        NetworkInfo d2 = d(context);
        if (d2 == null || !d2.isAvailable()) {
            return -1;
        }
        if (d2.getType() == 1) {
            return 1;
        }
        if (d2.getType() != 0) {
            return 5;
        }
        switch (d2.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
                return 4;
            default:
                String subtypeName = d2.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
        }
    }

    private static void c(Context context) {
        context.startActivity(Build.VERSION.SDK_INT > 10 ? new Intent("android.settings.SETTINGS") : new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    private static NetworkInfo d(Context context) {
        if (g == null) {
            g = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return g.getActiveNetworkInfo();
    }

    private static boolean e(Context context) {
        NetworkInfo d2 = d(context);
        return d2 != null && d2.isConnected();
    }

    private static boolean f(Context context) {
        NetworkInfo d2 = d(context);
        return d2 != null && d2.isAvailable() && d2.getSubtype() == 13;
    }

    private static boolean g(Context context) {
        NetworkInfo d2 = d(context);
        return d2 != null && d2.getType() == 1;
    }

    private static String h(Context context) {
        TelephonyManager i2 = i(context);
        if (i2 != null) {
            return i2.getNetworkOperatorName();
        }
        return null;
    }

    private static TelephonyManager i(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static int j(Context context) {
        TelephonyManager i2 = i(context);
        if (i2 != null) {
            return i2.getPhoneType();
        }
        return -1;
    }

    private static String k(Context context) {
        int b2 = b(context);
        if (b2 == -1) {
            return "ethernet";
        }
        switch (b2) {
            case 1:
                return "wf";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "unknow";
        }
    }

    private static boolean l(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    private static int m(Context context) {
        int b2 = b(context);
        if (b2 == -1) {
            return 5;
        }
        switch (b2) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 0;
        }
    }
}
