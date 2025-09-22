package com.umeng.commonsdk.proguard;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.e;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3778a;

        /* renamed from: b  reason: collision with root package name */
        public String f3779b;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3780a = null;

        /* renamed from: b  reason: collision with root package name */
        public int f3781b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f3782c = null;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f3783a;

        /* renamed from: b  reason: collision with root package name */
        public String f3784b;

        /* renamed from: c  reason: collision with root package name */
        public String f3785c;
        public int d;
        public int e;
        public int f;
        public int g;
        public String h;
        public int i;
        public int j;
        public int k;
        public long l;
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e) {
            e.e("getFontSize:" + e.getMessage());
            return 0.0f;
        }
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.a(context, e);
            e.e("getAppFirstInstallTime" + e.getMessage());
            return 0;
        }
    }

    private static String a(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null) {
            return null;
        }
        Class<?> cls = bluetoothAdapter.getClass();
        try {
            Class<?> cls2 = Class.forName("android.bluetooth.IBluetooth");
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Method method = cls2.getMethod("getAddress", new Class[0]);
            method.setAccessible(true);
            return (String) method.invoke(declaredField.get(bluetoothAdapter), new Object[0]);
        } catch (Exception unused) {
            return bluetoothAdapter.getAddress();
        }
    }

    public static boolean a() {
        return new p().a();
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.a(context, e);
            e.e("getAppLastUpdateTime:" + e.getMessage());
            return 0;
        }
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static List<ScanResult> b(Context context) {
        WifiManager wifiManager;
        List<ScanResult> list = null;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return null;
        }
        if (!DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (list = wifiManager.getScanResults()) == null || list.size() == 0) {
        }
        return list;
    }

    public static long c() {
        if (!h() || Build.VERSION.SDK_INT < 9) {
            return 0;
        }
        return Environment.getExternalStorageDirectory().getFreeSpace();
    }

    public static WifiInfo c(Context context) {
        WifiManager wifiManager;
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            e.a(context, e);
            e.e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    public static int d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.a(context, e);
            e.e("getAppUid:" + e.getMessage());
            return 0;
        }
    }

    public static long d() {
        if (!h() || Build.VERSION.SDK_INT < 9) {
            return 0;
        }
        return Environment.getExternalStorageDirectory().getTotalSpace();
    }

    public static void d(Context context) {
        if (context != null) {
            UMWorkDispatch.sendEvent(context, a.j, b.a(context).a(), (Object) null);
        }
    }

    public static String e() {
        return o.a("df");
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
        } catch (Exception e) {
            e.e("getLabel:" + e.getMessage());
        }
        return null;
    }

    public static JSONArray e(Context context) {
        if (context == null) {
            return null;
        }
        return n.b(context);
    }

    public static long f() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static void f(Context context) {
        if (context != null) {
            n.c(context);
        }
    }

    public static int g(Context context) {
        WifiManager wifiManager;
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return -1;
        }
        return wifiManager.getWifiState();
    }

    public static String g() {
        String str = null;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke((Object) null, new Object[]{"net.hostname"}).toString();
            if (obj != null) {
                try {
                    if (!obj.endsWith("")) {
                        return HelperUtils.getUmengMD5(obj);
                    }
                } catch (Exception e) {
                    String str2 = obj;
                    e = e;
                    str = str2;
                    e.e("getHostName:" + e.getMessage());
                    return str;
                }
            }
            return obj;
        } catch (Exception e2) {
            e = e2;
            e.e("getHostName:" + e.getMessage());
            return str;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.cyjh.elfin.a.b.f1842b));
    }

    private static boolean h() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", com.cyjh.elfin.a.b.f1842b));
    }

    public static DisplayMetrics j(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static String k(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || !DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE") || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return null;
        }
        return telephonyManager.getSubscriberId();
    }

    public static String l(Context context) {
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!DeviceConfig.checkPermission(context, "android.permission.READ_PHONE_STATE") || telephonyManager == null) {
            return null;
        }
        return Build.VERSION.SDK_INT < 26 ? telephonyManager.getDeviceId() : t(context);
    }

    public static List<InputMethodInfo> m(Context context) {
        if (context == null) {
            return null;
        }
        return ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
    }

    public static void n(Context context) {
        if (context != null) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                b bVar = new b();
                if (DeviceConfig.checkPermission(context, "android.permission.BLUETOOTH") && defaultAdapter.isEnabled()) {
                    bVar.f3781b = defaultAdapter.getState();
                    bVar.f3780a = Build.VERSION.SDK_INT < 23 ? defaultAdapter.getAddress() : a(defaultAdapter);
                    bVar.f3782c = defaultAdapter.getName();
                    UMWorkDispatch.sendEvent(context, a.i, b.a(context).a(), bVar);
                }
            } catch (Exception e) {
                e.e("startBluethInfo:" + e.getMessage());
            }
        }
    }

    public static JSONObject o(Context context) {
        if (context == null) {
            return null;
        }
        return n.a(context);
    }

    public static List<a> p(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        a aVar = new a();
                        aVar.f3778a = str;
                        aVar.f3779b = e(context, str);
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (Exception e) {
            e.e("getAppList:" + e.getMessage());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo q(Context context) {
        if (context == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String r(Context context) {
        StringBuilder sb;
        String str = null;
        if (context == null) {
            return null;
        }
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
            try {
                String property = System.getProperty("http.agent");
                if (Build.VERSION.SDK_INT >= 17) {
                    sb = new StringBuilder();
                    new WebView(context).getSettings();
                    sb.append(WebSettings.getDefaultUserAgent(context));
                    sb.append("__");
                    sb.append(property);
                } else {
                    sb = new StringBuilder();
                    sb.append(new WebView(context).getSettings().getUserAgentString());
                    sb.append("__");
                    sb.append(property);
                }
                str = sb.toString();
            } catch (Exception e) {
                e.e("getUA:" + e.getMessage());
            }
            UMWorkDispatch.sendEvent(context, a.k, b.a(context).a(), str);
        }
        return str;
    }

    public static String s(Context context) {
        if (context == null) {
            return null;
        }
        return n.d(context);
    }

    private static String t(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke((Object) null, new Object[0]);
            if (invoke != null && (invoke instanceof String)) {
                return (String) invoke;
            }
        } catch (Exception e) {
            e.e("meid:" + e.getMessage());
        }
        return null;
    }
}
