package com.cyjh.mobileanjian.ipc.rpc;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.cyjh.common.util.s;
import com.hlzn.socketclient.b.a;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;

public class AndroidHelper {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2569a = null;

    /* renamed from: b  reason: collision with root package name */
    private static ClipboardManager f2570b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static int f2571c = 100;
    /* access modifiers changed from: private */
    public static boolean d;

    public static String batteryLevel() {
        d = false;
        f2569a.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                context.unregisterReceiver(this);
                int intExtra = intent.getIntExtra("level", -1);
                int intExtra2 = intent.getIntExtra("scale", -1);
                if (intExtra >= 0 && intExtra2 > 0) {
                    int unused = AndroidHelper.f2571c = (intExtra * 100) / intExtra2;
                }
                boolean unused2 = AndroidHelper.d = true;
            }
        }, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        while (!d) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(f2571c);
    }

    public static String getAppDataPath(String str) {
        try {
            return f2569a.getPackageManager().getApplicationInfo(str, 0).dataDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppVersionName() {
        try {
            return f2569a.getPackageManager().getPackageInfo(f2569a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getBacklightLevel() {
        int i = 0;
        try {
            int i2 = Settings.System.getInt(f2569a.getContentResolver(), "screen_brightness");
            try {
                return String.valueOf((int) (((double) (i2 * 100)) / 255.0d));
            } catch (Settings.SettingNotFoundException e) {
                int i3 = i2;
                e = e;
                i = i3;
                e.printStackTrace();
                return String.valueOf(i);
            }
        } catch (Settings.SettingNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            return String.valueOf(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r1 = (r1 = f2570b.getPrimaryClip()).getItemAt(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getClipboardText() {
        /*
            java.lang.String r0 = ""
            android.content.ClipboardManager r1 = f2570b
            boolean r1 = r1.hasPrimaryClip()
            if (r1 == 0) goto L_0x0021
            android.content.ClipboardManager r1 = f2570b
            android.content.ClipData r1 = r1.getPrimaryClip()
            if (r1 == 0) goto L_0x0021
            r2 = 0
            android.content.ClipData$Item r1 = r1.getItemAt(r2)
            if (r1 == 0) goto L_0x0021
            java.lang.CharSequence r0 = r1.getText()
            java.lang.String r0 = r0.toString()
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.rpc.AndroidHelper.getClipboardText():java.lang.String");
    }

    public static String getForegroundPackage() {
        if (Build.VERSION.SDK_INT < 21) {
            return ((ActivityManager) f2569a.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<UsageStats> queryUsageStats = ((UsageStatsManager) f2569a.getSystemService("usagestats")).queryUsageStats(4, currentTimeMillis - 2000, currentTimeMillis);
        UsageStats usageStats = null;
        if (queryUsageStats == null || queryUsageStats.isEmpty()) {
            return null;
        }
        for (UsageStats next : queryUsageStats) {
            if (usageStats == null || usageStats.getLastTimeUsed() < next.getLastTimeUsed()) {
                usageStats = next;
            }
        }
        return usageStats.getPackageName();
    }

    public static String getIccid() {
        return ((TelephonyManager) f2569a.getSystemService("phone")).getSimSerialNumber();
    }

    public static String getImsi() {
        return ((TelephonyManager) f2569a.getSystemService("phone")).getSubscriberId();
    }

    public static String getIp() {
        if (((ConnectivityManager) f2569a.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
            WifiManager wifiManager = (WifiManager) f2569a.getSystemService("wifi");
            if (wifiManager.isWifiEnabled()) {
                int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(ipAddress & 255);
                stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                int i = ipAddress >>> 8;
                stringBuffer.append(i & 255);
                stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                int i2 = i >>> 8;
                stringBuffer.append(i2 & 255);
                stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                stringBuffer.append((i2 >>> 8) & 255);
                return stringBuffer.toString();
            }
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getModel() {
        return Build.BRAND + s.a.f1696a + Build.MODEL;
    }

    public static String getNetworkTime() {
        try {
            URLConnection openConnection = new URL("http://www.baidu.com").openConnection();
            openConnection.setReadTimeout(a.t);
            openConnection.setConnectTimeout(a.t);
            openConnection.connect();
            Date date = new Date(openConnection.getDate());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Log.e("tag", "getNetworkTime: by baidu url:" + simpleDateFormat.format(date));
            return simpleDateFormat.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            try {
                URLConnection openConnection2 = new URL("http://www.taobao.com").openConnection();
                openConnection2.setReadTimeout(a.t);
                openConnection2.setConnectTimeout(a.t);
                openConnection2.connect();
                Date date2 = new Date(openConnection2.getDate());
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                Log.e("tag", "getNetworkTime: by a li url:" + simpleDateFormat2.format(date2));
                return simpleDateFormat2.format(date2);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                return null;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            URLConnection openConnection22 = new URL("http://www.taobao.com").openConnection();
            openConnection22.setReadTimeout(a.t);
            openConnection22.setConnectTimeout(a.t);
            openConnection22.connect();
            Date date22 = new Date(openConnection22.getDate());
            SimpleDateFormat simpleDateFormat22 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Log.e("tag", "getNetworkTime: by a li url:" + simpleDateFormat22.format(date22));
            return simpleDateFormat22.format(date22);
        }
    }

    public static void init(Context context) {
        new StringBuilder("AndroidHelper -> init--1 -> ").append(Thread.currentThread().getName());
        new StringBuilder("AndroidHelper -> init--2 -> ").append(Thread.currentThread().getName());
        f2569a = context;
        new StringBuilder("AndroidHelper -> init--3 -> ").append(Thread.currentThread().getName());
        Telephony.init(context);
        f2570b = (ClipboardManager) f2569a.getSystemService("clipboard");
        new StringBuilder("AndroidHelper -> init--4 -> ").append(Thread.currentThread().getName());
    }

    public static boolean isAppForeground(String str) {
        return str.equals(getForegroundPackage());
    }

    public static String isScreenOn() {
        return ((PowerManager) f2569a.getSystemService("power")).isScreenOn() ? "true" : "false";
    }

    public static void setClipboardText(String str) {
        new StringBuilder("AndroidHelper -> setClipboardText --1 -> ").append(Thread.currentThread().getName());
        f2570b.setPrimaryClip(ClipData.newPlainText("", str));
    }
}
