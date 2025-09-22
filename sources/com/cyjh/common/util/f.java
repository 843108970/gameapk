package com.cyjh.common.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.umeng.commonsdk.proguard.v;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static String a() {
        try {
            Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
            }
        } catch (IOException unused) {
            return "";
        }
    }

    private static String a(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        if (packageArchiveInfo != null) {
            return packageArchiveInfo.packageName;
        }
        return null;
    }

    public static boolean a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse("tel:123456"));
            intent.setAction("android.intent.action.DIAL");
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            java.lang.String r3 = "ls -l "
            r2.<init>(r3)     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            r2.append(r5)     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ IOException -> 0x0050, all -> 0x004b }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049 }
            java.io.InputStream r2 = r5.getInputStream()     // Catch:{ IOException -> 0x0049 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0049 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0049 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0049 }
            if (r0 == 0) goto L_0x0046
            int r1 = r0.length()     // Catch:{ IOException -> 0x0049 }
            r2 = 4
            if (r1 < r2) goto L_0x0046
            r1 = 3
            char r0 = r0.charAt(r1)     // Catch:{ IOException -> 0x0049 }
            r1 = 115(0x73, float:1.61E-43)
            if (r0 == r1) goto L_0x003f
            r1 = 120(0x78, float:1.68E-43)
            if (r0 != r1) goto L_0x0046
        L_0x003f:
            if (r5 == 0) goto L_0x0044
            r5.destroy()
        L_0x0044:
            r5 = 1
            return r5
        L_0x0046:
            if (r5 == 0) goto L_0x005c
            goto L_0x0059
        L_0x0049:
            r0 = move-exception
            goto L_0x0054
        L_0x004b:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L_0x005f
        L_0x0050:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L_0x0054:
            r0.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005c
        L_0x0059:
            r5.destroy()
        L_0x005c:
            r5 = 0
            return r5
        L_0x005e:
            r0 = move-exception
        L_0x005f:
            if (r5 == 0) goto L_0x0064
            r5.destroy()
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.f.a(java.lang.String):boolean");
    }

    private static boolean a(String str, boolean z) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath(), "elfinParams.txt");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, z);
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b() {
        String str;
        Exception e;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://pv.sohu.com/cityjson?ie=utf-8").openConnection();
            if (httpURLConnection.getResponseCode() != 200) {
                return "0.0.0.0";
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                try {
                    sb.append(str + "\n");
                    String str2 = str;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            inputStream.close();
            String substring = sb.substring(sb.indexOf("{"), sb.indexOf("}") + 1);
            if (substring != null) {
                try {
                    return new JSONObject(substring).optString("cip");
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return str;
        } catch (Exception e4) {
            str = "0.0.0.0";
            e = e4;
            e.printStackTrace();
            return str;
        }
    }

    public static String b(Context context) {
        try {
            return Build.VERSION.SDK_INT < 19 ? new WebView(context).getSettings().getUserAgentString() : WebSettings.getDefaultUserAgent(context);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean c() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null || TextUtils.isEmpty(defaultAdapter.getName());
    }

    private static boolean c(Context context) {
        boolean a2 = a(context);
        String a3 = a();
        return !a2 || (a3.contains("intel") || a3.contains("amd"));
    }

    private static Boolean d(Context context) {
        return Boolean.valueOf(((SensorManager) context.getSystemService(v.W)).getDefaultSensor(5) == null);
    }

    private static boolean d() {
        String a2 = a();
        return a2.contains("intel") || a2.contains("amd");
    }

    private static boolean e() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.MODEL.contains("google_sdk") || Build.MODEL.toLowerCase().contains("droid4x") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk_x86") || Build.PRODUCT.equals("vbox86p") || Build.BOARD.toLowerCase().contains("nox") || Build.BOOTLOADER.toLowerCase().contains("nox") || Build.HARDWARE.toLowerCase().contains("nox") || Build.PRODUCT.toLowerCase().contains("nox") || Build.SERIAL.toLowerCase().contains("nox")) {
            return true;
        }
        if ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || false) {
            return true;
        }
        return "google_sdk".equals(Build.PRODUCT) | false;
    }

    private static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0056 A[SYNTHETIC, Splitter:B:37:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006b A[SYNTHETIC, Splitter:B:51:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean g() {
        /*
            java.lang.Class<com.cyjh.common.util.f> r0 = com.cyjh.common.util.f.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.lang.String r4 = "su"
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0045, all -> 0x0043 }
            java.lang.String r2 = "exit\n"
            r4.writeBytes(r2)     // Catch:{ Exception -> 0x0041 }
            r4.flush()     // Catch:{ Exception -> 0x0041 }
            int r2 = r3.waitFor()     // Catch:{ Exception -> 0x0041 }
            if (r2 != 0) goto L_0x0034
            r4.close()     // Catch:{ Exception -> 0x002d }
            r3.destroy()     // Catch:{ Exception -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0031:
            r1 = 1
            monitor-exit(r0)
            return r1
        L_0x0034:
            r4.close()     // Catch:{ Exception -> 0x003b }
            r3.destroy()     // Catch:{ Exception -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x003f:
            monitor-exit(r0)
            return r1
        L_0x0041:
            r2 = move-exception
            goto L_0x0051
        L_0x0043:
            r1 = move-exception
            goto L_0x0069
        L_0x0045:
            r4 = move-exception
            r6 = r4
            r4 = r2
            r2 = r6
            goto L_0x0051
        L_0x004a:
            r1 = move-exception
            r3 = r2
            goto L_0x0069
        L_0x004d:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
        L_0x0051:
            r2.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r4 == 0) goto L_0x005e
            r4.close()     // Catch:{ Exception -> 0x005c }
            goto L_0x005e
        L_0x005a:
            r1 = move-exception
            goto L_0x0079
        L_0x005c:
            r2 = move-exception
            goto L_0x0062
        L_0x005e:
            r3.destroy()     // Catch:{ Exception -> 0x005c }
            goto L_0x0065
        L_0x0062:
            r2.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0065:
            monitor-exit(r0)
            return r1
        L_0x0067:
            r1 = move-exception
            r2 = r4
        L_0x0069:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0071
        L_0x006f:
            r2 = move-exception
            goto L_0x0075
        L_0x0071:
            r3.destroy()     // Catch:{ Exception -> 0x006f }
            goto L_0x0078
        L_0x0075:
            r2.printStackTrace()     // Catch:{ all -> 0x005a }
        L_0x0078:
            throw r1     // Catch:{ all -> 0x005a }
        L_0x0079:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.f.g():boolean");
    }

    private static boolean h() {
        if (!new File("/system/bin/su").exists() || !a("/system/bin/su")) {
            return new File("/system/xbin/su").exists() && a("/system/xbin/su");
        }
        return true;
    }
}
