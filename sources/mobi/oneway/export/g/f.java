package mobi.oneway.export.g;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import mobi.oneway.export.a.b;

public class f {

    private enum a {
        MAC,
        SSID,
        BSSID
    }

    @SuppressLint({"MissingPermission"})
    public static String a() {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) b.a().getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 26) {
                str = TextUtils.isEmpty(telephonyManager.getImei()) ? "" : telephonyManager.getImei();
            } else {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getImei", new Class[0]);
                declaredMethod.setAccessible(true);
                str = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            }
            return TextUtils.isEmpty(str) ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str) {
        return str == null ? "" : (!str.startsWith("\"") || !str.endsWith("\"")) ? str : str.substring(1, str.length() - 1);
    }

    private static String a(a aVar) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) b.a().getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        switch (aVar) {
            case MAC:
                return connectionInfo.getMacAddress();
            case SSID:
                return a(connectionInfo.getSSID());
            case BSSID:
                return connectionInfo.getBSSID();
            default:
                return "";
        }
    }

    public static String b() {
        try {
            return b.a().getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c() {
        try {
            return b.a().getPackageManager().getPackageInfo(b(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d() {
        String str = System.getProperty("http.agent") + " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Mobile Safari/537.36 ";
        return TextUtils.isEmpty(str) ? "Mozilla/5.0 (Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Mobile Safari/537.36 OneWaySDK" : str;
    }

    public static String e() {
        try {
            return Settings.Secure.getString(b.a().getContentResolver(), com.cyjh.common.b.a.aM);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        switch (activeNetworkInfo.getType()) {
            case 0:
                return "moblie";
            case 1:
                return "wifi";
            default:
                return "none";
        }
    }

    public static int g() {
        try {
            if (f().equals("wifi")) {
                return 99;
            }
            return ((TelephonyManager) b.a().getSystemService("phone")).getNetworkType();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String h() {
        return a(a.SSID);
    }

    public static String i() {
        return a(a.BSSID);
    }

    public static String j() {
        try {
            return ((TelephonyManager) b.a().getSystemService("phone")).getSimOperator();
        } catch (Exception e) {
            e.printStackTrace();
            return "none";
        }
    }

    public static String k() {
        try {
            return ((TelephonyManager) b.a().getApplicationContext().getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            e.printStackTrace();
            return "none";
        }
    }
}
