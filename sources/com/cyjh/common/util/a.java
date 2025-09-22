package com.cyjh.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.cyjh.elfin.a.b;
import com.cyjh.elfin.ui.activity.ElfinFreeActivity;
import com.ywfzjbcy.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final long f1639a = 1000;

    /* renamed from: b  reason: collision with root package name */
    private static final long[] f1640b = {500, 200, 500, 200};

    /* renamed from: c  reason: collision with root package name */
    private static final int f1641c = -1;

    private static int a(Context context, float f) {
        return (int) (((double) (f / context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static Point a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    private static String a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    private static String a(String str, String str2) {
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.contains(str2)) {
                    return readLine;
                }
                str3 = str3 + readLine;
            }
        } catch (Exception e) {
            String str4 = str3;
            e.printStackTrace();
            return str4;
        }
    }

    private static String a(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            String hostAddress = nextElement2.getHostAddress();
                            boolean z2 = hostAddress.indexOf(58) < 0;
                            if (z) {
                                if (z2) {
                                    return hostAddress;
                                }
                            } else if (!z2) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02X:", new Object[]{Byte.valueOf(bArr[i])}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @TargetApi(26)
    public static void a(final Context context, File file) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (!(context == null ? false : context.getPackageManager().canRequestPackageInstalls())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("安装权限");
                builder.setMessage("需要打开允许来自此来源，请去设置中开启此权限");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.j(context);
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
                return;
            }
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getString(R.string.pay_appid), file), "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.parse("file://" + file.toString()), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static void a(Context context, Class cls, int i) {
        Intent intent = new Intent();
        intent.putExtra(ElfinFreeActivity.f2145c, i);
        intent.setClass(context, cls);
        intent.addFlags(2097152);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private static void a(Context context, long[] jArr) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(jArr, -1);
        }
    }

    private static boolean a(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                arrayList.add(installedPackages.get(i).packageName);
            }
        }
        return arrayList.contains(str);
    }

    private static String b() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String b(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0 ? "" : ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    private static boolean b(Context context, File file) {
        try {
            Log.e("xys", "mainfile:" + file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("xys", "var4:" + e.getMessage());
            return true;
        }
    }

    private static boolean b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String c() {
        try {
            for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        if (str == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static int d(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", b.f1842b);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static String d() {
        String a2 = a("busybox ifconfig", "HWaddr");
        return a2 == null ? "网络异常" : (a2.length() <= 0 || !a2.contains("HWaddr")) ? a2 : a2.substring(a2.indexOf("HWaddr") + 6, a2.length() - 1);
    }

    private static boolean d(Context context, String str) {
        Log.e("xys", "installApplicationNormal:" + context + ",path:" + str);
        return b(context, new File(str));
    }

    public static int e(Context context) {
        return (int) (((double) (context.getResources().getDisplayMetrics().density * 8.0f)) + 0.5d);
    }

    private static String e() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(f()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String f(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static InetAddress f() {
        InetAddress inetAddress;
        SocketException e;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                try {
                    if (networkInterfaces.hasMoreElements()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                        while (true) {
                            if (!inetAddresses.hasMoreElements()) {
                                break;
                            }
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                                    inetAddress = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress = null;
                            } catch (SocketException e2) {
                                e = e2;
                                inetAddress = nextElement;
                                e.printStackTrace();
                                return inetAddress;
                            }
                        }
                    } else {
                        return inetAddress;
                    }
                } catch (SocketException e3) {
                    e = e3;
                    e.printStackTrace();
                    return inetAddress;
                }
            } while (inetAddress == null);
            return inetAddress;
        } catch (SocketException e4) {
            inetAddress = null;
            e = e4;
            e.printStackTrace();
            return inetAddress;
        }
    }

    private static String g() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            Log.e("Wifi IpAddress", e.toString());
            return null;
        }
    }

    public static String g(Context context) {
        return Settings.System.getString(context.getContentResolver(), com.cyjh.common.b.a.aM);
    }

    private static String h() {
        return Build.BRAND;
    }

    public static String h(Context context) {
        String subscriberId;
        return (ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 && (subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId()) != null) ? (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) ? "1" : (subscriberId.startsWith("46001") || subscriberId.startsWith("46006")) ? "2" : subscriberId.startsWith("46003") ? "3" : "0" : "0";
    }

    public static String i(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            Log.e("=====", "6.0以下");
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } else if (Build.VERSION.SDK_INT < 24 && Build.VERSION.SDK_INT >= 23) {
            Log.e("=====", "6.0以上7.0以下");
            return n(context);
        } else if (Build.VERSION.SDK_INT < 24) {
            return "02:00:00:00:00:00";
        } else {
            Log.e("=====", "7.0以上");
            if (!TextUtils.isEmpty(n(context))) {
                Log.e("=====", "7.0以上1");
                return n(context);
            } else if (!TextUtils.isEmpty(j())) {
                Log.e("=====", "7.0以上2");
                return j();
            } else {
                Log.e("=====", "7.0以上3");
                return d();
            }
        }
    }

    private static boolean i() {
        return Build.CPU_ABI.equalsIgnoreCase("x86");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String j() {
        /*
            r0 = 0
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ SocketException -> 0x0006 }
            goto L_0x000b
        L_0x0006:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L_0x000b:
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r2 = r0
        L_0x000f:
            boolean r3 = r1.hasMoreElements()
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r1.nextElement()
            java.net.NetworkInterface r3 = (java.net.NetworkInterface) r3
            byte[] r3 = r3.getHardwareAddress()     // Catch:{ SocketException -> 0x005e }
            if (r3 == 0) goto L_0x005a
            int r4 = r3.length     // Catch:{ SocketException -> 0x005e }
            if (r4 != 0) goto L_0x0025
            goto L_0x005a
        L_0x0025:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x005e }
            r4.<init>()     // Catch:{ SocketException -> 0x005e }
            int r5 = r3.length     // Catch:{ SocketException -> 0x005e }
            r6 = 0
            r7 = 0
        L_0x002d:
            r8 = 1
            if (r7 >= r5) goto L_0x0046
            byte r9 = r3[r7]     // Catch:{ SocketException -> 0x005e }
            java.lang.String r10 = "%02X:"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ SocketException -> 0x005e }
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)     // Catch:{ SocketException -> 0x005e }
            r8[r6] = r9     // Catch:{ SocketException -> 0x005e }
            java.lang.String r8 = java.lang.String.format(r10, r8)     // Catch:{ SocketException -> 0x005e }
            r4.append(r8)     // Catch:{ SocketException -> 0x005e }
            int r7 = r7 + 1
            goto L_0x002d
        L_0x0046:
            int r3 = r4.length()     // Catch:{ SocketException -> 0x005e }
            if (r3 <= 0) goto L_0x0054
            int r3 = r4.length()     // Catch:{ SocketException -> 0x005e }
            int r3 = r3 - r8
            r4.deleteCharAt(r3)     // Catch:{ SocketException -> 0x005e }
        L_0x0054:
            java.lang.String r3 = r4.toString()     // Catch:{ SocketException -> 0x005e }
            r2 = r3
            goto L_0x005b
        L_0x005a:
            r2 = r0
        L_0x005b:
            if (r2 == 0) goto L_0x000f
            return r2
        L_0x005e:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x000f
        L_0x0063:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.a.j():java.lang.String");
    }

    static /* synthetic */ void j(Context context) {
        if (context != null) {
            ((Activity) context).startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())), b.ak);
        }
    }

    private static void k(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(f1639a);
        }
    }

    private static void l(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(f1639a);
        }
    }

    private static void m(Context context) {
        long[] jArr = f1640b;
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(jArr, -1);
        }
    }

    private static String n(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 24) {
            return b();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return "02:00:00:00:00:00";
        }
        String c2 = c();
        if ("02:00:00:00:00:00".equals(c2)) {
            c2 = d();
        }
        String str = c2;
        return "02:00:00:00:00:00".equals(str) ? e() : str;
    }

    private static String o(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    @RequiresApi(api = 26)
    private static void p(Context context) {
        if (context != null) {
            ((Activity) context).startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())), b.ak);
        }
    }

    @RequiresApi(api = 26)
    private static boolean q(Context context) {
        if (context == null) {
            return false;
        }
        return context.getPackageManager().canRequestPackageInstalls();
    }

    private static String r(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
        return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
    }

    private static String s(Context context) {
        return ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") != 0 ? "" : ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    private static String t(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    private static int u(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private static String v(Context context) {
        String str = b(context) + n(context);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = o.a(context, "deviceid");
        Log.e("zzz", "AppDevicesUtils-- acquireDevicesId2:" + a2);
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String uuid = UUID.randomUUID().toString();
        Log.e("zzz", "AppDevicesUtils-- acquireDevicesId3:" + uuid);
        o.a(context, "deviceid", uuid);
        return uuid;
    }

    private static String w(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String x(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }
}
