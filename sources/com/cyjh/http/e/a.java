package com.cyjh.http.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.cyjh.common.util.aa;
import com.cyjh.common.util.e;
import com.cyjh.common.util.s;
import com.cyjh.common.util.u;
import com.cyjh.http.bean.LocalApplication;
import com.cyjh.http.bean.request.DeviceInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2522a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2523b = "yyyy-MM-dd";

    /* renamed from: com.cyjh.http.e.a$a  reason: collision with other inner class name */
    class C0041a implements FileFilter {
        C0041a() {
        }

        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    final class b {
        b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00af, code lost:
            r11 = ((com.cyjh.common.util.s.a) r3.get(0)).g.substring(0, 1).toUpperCase();
            r0 = r11.charAt(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String a(java.lang.String r11) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r11)
                if (r0 == 0) goto L_0x0009
                java.lang.String r11 = "#"
                return r11
            L_0x0009:
                java.lang.String r0 = r11.toLowerCase()
                r1 = 0
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isDigit(r0)
                if (r0 == 0) goto L_0x001b
                java.lang.String r11 = "#"
                return r11
            L_0x001b:
                com.cyjh.common.util.s r0 = com.cyjh.common.util.s.a()
                r2 = 1
                java.lang.String r11 = r11.substring(r1, r2)
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                boolean r0 = r0.f1695c
                if (r0 == 0) goto L_0x009b
                boolean r0 = android.text.TextUtils.isEmpty(r11)
                if (r0 != 0) goto L_0x009b
                int r0 = r11.length()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r5 = 0
                r6 = 1
            L_0x003e:
                if (r5 >= r0) goto L_0x0092
                char r7 = r11.charAt(r5)
                r8 = 32
                r9 = 2
                if (r7 != r8) goto L_0x0053
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x008f
                com.cyjh.common.util.s.a(r4, r3, r6)
                goto L_0x008f
            L_0x0053:
                r8 = 256(0x100, float:3.59E-43)
                if (r7 >= r8) goto L_0x0067
                if (r6 == r2) goto L_0x0062
                int r8 = r4.length()
                if (r8 <= 0) goto L_0x0062
                com.cyjh.common.util.s.a(r4, r3, r6)
            L_0x0062:
                r4.append(r7)
                r6 = 1
                goto L_0x008f
            L_0x0067:
                com.cyjh.common.util.s$a r8 = com.cyjh.common.util.s.a((char) r7)
                int r10 = r8.e
                if (r10 != r9) goto L_0x007d
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x0078
                com.cyjh.common.util.s.a(r4, r3, r6)
            L_0x0078:
                r3.add(r8)
                r6 = 2
                goto L_0x008f
            L_0x007d:
                int r9 = r8.e
                if (r6 == r9) goto L_0x008a
                int r9 = r4.length()
                if (r9 <= 0) goto L_0x008a
                com.cyjh.common.util.s.a(r4, r3, r6)
            L_0x008a:
                int r6 = r8.e
                r4.append(r7)
            L_0x008f:
                int r5 = r5 + 1
                goto L_0x003e
            L_0x0092:
                int r11 = r4.length()
                if (r11 <= 0) goto L_0x009b
                com.cyjh.common.util.s.a(r4, r3, r6)
            L_0x009b:
                int r11 = r3.size()
                if (r11 <= 0) goto L_0x00d0
                java.lang.Object r11 = r3.get(r1)
                com.cyjh.common.util.s$a r11 = (com.cyjh.common.util.s.a) r11
                java.lang.String r11 = r11.g
                int r11 = r11.length()
                if (r11 <= 0) goto L_0x00d0
                java.lang.Object r11 = r3.get(r1)
                com.cyjh.common.util.s$a r11 = (com.cyjh.common.util.s.a) r11
                java.lang.String r11 = r11.g
                java.lang.String r11 = r11.substring(r1, r2)
                java.lang.String r11 = r11.toUpperCase()
                char r0 = r11.charAt(r1)
                r1 = 65
                if (r0 < r1) goto L_0x00cd
                r1 = 90
                if (r0 <= r1) goto L_0x00cc
                goto L_0x00cd
            L_0x00cc:
                return r11
            L_0x00cd:
                java.lang.String r11 = "#"
                return r11
            L_0x00d0:
                java.lang.String r11 = "#"
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.a.b.a(java.lang.String):java.lang.String");
        }
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static long a() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 2048);
            String readLine = bufferedReader.readLine();
            String substring = readLine.substring(readLine.indexOf("MemTotal:"));
            bufferedReader.close();
            return ((long) Integer.parseInt(substring.replaceAll("\\D+", ""))) * 1024;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat(f2523b, Locale.getDefault()).parse(str);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            instance.set(instance.get(1), instance.get(2), instance.get(5) + 1, 0, 0);
            return instance.getTimeInMillis();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static File a(Context context) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String a(long j, String str) {
        if (str.isEmpty()) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j * 1000));
    }

    public static String a(String str, Context context) {
        File file = new File(a(context), str);
        return !file.exists() ? "" : b(file.getAbsolutePath());
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

    public static void a(Context context, String str, String str2) {
        try {
            File file = new File(a(context), str);
            if (!file.exists()) {
                file.createNewFile();
            }
            b(file, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d8, code lost:
        if (r1 <= 'Z') goto L_0x00dc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.cyjh.http.bean.LocalApplication r12) {
        /*
            java.lang.String r0 = "#"
            java.lang.String r1 = r12.getApplicationName()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00e0
            com.cyjh.http.e.a$b r0 = new com.cyjh.http.e.a$b
            r0.<init>()
            java.lang.String r0 = r12.getApplicationName()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x00da
            java.lang.String r1 = r0.toLowerCase()
            r2 = 0
            char r1 = r1.charAt(r2)
            boolean r1 = java.lang.Character.isDigit(r1)
            if (r1 != 0) goto L_0x00da
            com.cyjh.common.util.s r1 = com.cyjh.common.util.s.a()
            r3 = 1
            java.lang.String r0 = r0.substring(r2, r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r1 = r1.f1695c
            if (r1 == 0) goto L_0x00aa
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x00aa
            int r1 = r0.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 0
            r7 = 1
        L_0x004d:
            if (r6 >= r1) goto L_0x00a1
            char r8 = r0.charAt(r6)
            r9 = 32
            r10 = 2
            if (r8 != r9) goto L_0x0062
            int r8 = r5.length()
            if (r8 <= 0) goto L_0x009e
            com.cyjh.common.util.s.a(r5, r4, r7)
            goto L_0x009e
        L_0x0062:
            r9 = 256(0x100, float:3.59E-43)
            if (r8 >= r9) goto L_0x0076
            if (r7 == r3) goto L_0x0071
            int r9 = r5.length()
            if (r9 <= 0) goto L_0x0071
            com.cyjh.common.util.s.a(r5, r4, r7)
        L_0x0071:
            r5.append(r8)
            r7 = 1
            goto L_0x009e
        L_0x0076:
            com.cyjh.common.util.s$a r9 = com.cyjh.common.util.s.a((char) r8)
            int r11 = r9.e
            if (r11 != r10) goto L_0x008c
            int r8 = r5.length()
            if (r8 <= 0) goto L_0x0087
            com.cyjh.common.util.s.a(r5, r4, r7)
        L_0x0087:
            r4.add(r9)
            r7 = 2
            goto L_0x009e
        L_0x008c:
            int r10 = r9.e
            if (r7 == r10) goto L_0x0099
            int r10 = r5.length()
            if (r10 <= 0) goto L_0x0099
            com.cyjh.common.util.s.a(r5, r4, r7)
        L_0x0099:
            int r7 = r9.e
            r5.append(r8)
        L_0x009e:
            int r6 = r6 + 1
            goto L_0x004d
        L_0x00a1:
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x00aa
            com.cyjh.common.util.s.a(r5, r4, r7)
        L_0x00aa:
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x00da
            java.lang.Object r0 = r4.get(r2)
            com.cyjh.common.util.s$a r0 = (com.cyjh.common.util.s.a) r0
            java.lang.String r0 = r0.g
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00da
            java.lang.Object r0 = r4.get(r2)
            com.cyjh.common.util.s$a r0 = (com.cyjh.common.util.s.a) r0
            java.lang.String r0 = r0.g
            java.lang.String r0 = r0.substring(r2, r3)
            java.lang.String r0 = r0.toUpperCase()
            char r1 = r0.charAt(r2)
            r2 = 65
            if (r1 < r2) goto L_0x00da
            r2 = 90
            if (r1 <= r2) goto L_0x00dc
        L_0x00da:
            java.lang.String r0 = "#"
        L_0x00dc:
            r12.setInitialLetter(r0)
            return
        L_0x00e0:
            r12.setInitialLetter(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.http.e.a.a(com.cyjh.http.bean.LocalApplication):void");
    }

    public static void a(File file, String str) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, Context context, String str2) {
        try {
            File file = new File(a(context), str);
            if (!file.exists()) {
                file.createNewFile();
            }
            b(file, str2);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("zzz", "AppUtils--writeDateToFile:" + e.getMessage());
        }
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (str == null) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Point b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String b() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            String str = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    bufferedReader.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            fileInputStream.close();
            if (str != "") {
                try {
                    String substring = str.substring(str.indexOf("version ") + 8);
                    return substring.substring(0, substring.indexOf(s.a.f1696a));
                } catch (IndexOutOfBoundsException e4) {
                    e4.printStackTrace();
                }
            }
            return "";
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    private static String b(long j, String str) {
        if (str == null || str.isEmpty()) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        return simpleDateFormat.format(gregorianCalendar.getTime());
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        try {
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                sb.append(new String(bArr, 0, read, "utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    private static void b(File file, String str) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void b(String str, Context context) {
        File file = new File(a(context), str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static void b(String str, Context context, String str2) {
        try {
            File file = new File(a(context), str);
            if (!file.exists()) {
                file.createNewFile();
            }
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(str2);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    public static DeviceInfo c(Context context) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n\n\n");
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            sb.append(deviceId);
            sb2.append("devicesId=" + deviceId);
            sb2.append(",");
        }
        String serial = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        if (!TextUtils.isEmpty(serial)) {
            sb.append(serial);
            sb2.append("serial=" + serial);
            sb2.append(",");
        }
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.DeviceCode = sb.toString();
        String str = "02:00:00:00:00:00";
        if (Build.VERSION.SDK_INT < 23) {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        } else if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 24) {
            str = g();
        } else if (Build.VERSION.SDK_INT >= 24) {
            str = h();
            if ("02:00:00:00:00:00".equals(str)) {
                str = a("busybox ifconfig", "HWaddr");
                if (str == null) {
                    str = "网络异常";
                } else if (str.length() > 0 && str.contains("HWaddr")) {
                    str = str.substring(str.indexOf("HWaddr") + 6, str.length() - 1);
                }
            }
            if ("02:00:00:00:00:00".equals(str)) {
                str = j();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb2.append("macAddress=" + str);
            sb2.append(",");
        }
        String str2 = null;
        File a2 = e.a(com.cyjh.common.b.a.aF, com.cyjh.common.b.a.aM);
        if (a2 != null) {
            str2 = b(a2.getAbsolutePath());
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = Settings.Secure.getString(context.getContentResolver(), com.cyjh.common.b.a.aM);
            b(a2, str2);
        }
        sb.append(str2);
        sb2.append("androidId=" + str2);
        sb2.append(",");
        File a3 = e.a(com.cyjh.common.b.a.aF, com.cyjh.common.b.a.aG);
        String str3 = "";
        if (a3 != null) {
            str3 = b(a3.getAbsolutePath());
        }
        if (TextUtils.isEmpty(str3) || a3 == null) {
            str3 = UUID.randomUUID().toString();
            if (a3 == null) {
                a3 = e.a(com.cyjh.common.b.a.aF, com.cyjh.common.b.a.aG);
            }
            b(a3, str3);
        }
        sb.append(str3);
        sb2.append("uuid=" + str3);
        sb2.append("\n\n\n");
        deviceInfo.DeviceId = u.a(sb.toString());
        return deviceInfo;
    }

    private static String c() {
        return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
    }

    private static boolean c(String str, Context context) {
        String a2 = a(str, context);
        return !TextUtils.isEmpty(a2) && a2.compareTo(a(System.currentTimeMillis() / 1000, f2523b)) >= 0;
    }

    private static int d() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0041a());
            Log.e("TAG", "CPU Count=" + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            Log.e("TAG", "CPU Count: Failed.");
            e.printStackTrace();
            return 1;
        }
    }

    private static String d(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + context.getPackageName();
    }

    private static int e(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private static String e() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                strArr[0] = strArr[0] + split[i] + s.a.f1696a;
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr[0];
    }

    private static String f() {
        String a2 = aa.a("ro.miui.ui.version.name");
        aa.h = a2;
        if (!TextUtils.isEmpty(a2)) {
            return aa.f1643a;
        }
        String a3 = aa.a("ro.build.version.emui");
        aa.h = a3;
        if (!TextUtils.isEmpty(a3)) {
            return aa.f1644b;
        }
        String a4 = aa.a("ro.build.version.opporom");
        aa.h = a4;
        if (!TextUtils.isEmpty(a4)) {
            return aa.d;
        }
        String a5 = aa.a("ro.vivo.os.version");
        aa.h = a5;
        if (!TextUtils.isEmpty(a5)) {
            return aa.f;
        }
        String a6 = aa.a("ro.smartisan.version");
        aa.h = a6;
        if (!TextUtils.isEmpty(a6)) {
            return aa.e;
        }
        String str = Build.DISPLAY;
        aa.h = str;
        if (str.toUpperCase().contains(aa.f1645c)) {
            return aa.f1645c;
        }
        aa.h = EnvironmentCompat.MEDIA_UNKNOWN;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        return TextUtils.isEmpty(upperCase) ? "0" : upperCase;
    }

    private static String f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    private static String g() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    private static String g(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 24) {
            return g();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return "02:00:00:00:00:00";
        }
        String h = h();
        if ("02:00:00:00:00:00".equals(h)) {
            h = a("busybox ifconfig", "HWaddr");
            if (h == null) {
                h = "网络异常";
            } else if (h.length() > 0 && h.contains("HWaddr")) {
                h = h.substring(h.indexOf("HWaddr") + 6, h.length() - 1);
            }
        }
        String str = h;
        return "02:00:00:00:00:00".equals(str) ? j() : str;
    }

    private static String h() {
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

    private static String h(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    private static String i() {
        String a2 = a("busybox ifconfig", "HWaddr");
        return a2 == null ? "网络异常" : (a2.length() <= 0 || !a2.contains("HWaddr")) ? a2 : a2.substring(a2.indexOf("HWaddr") + 6, a2.length() - 1);
    }

    private static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String j() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(k()).getHardwareAddress();
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

    private static String j(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), com.cyjh.common.b.a.aM);
    }

    private static InetAddress k() {
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

    private static List<LocalApplication> k(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        try {
            for (PackageInfo next : packageManager.getInstalledPackages(0)) {
                if ((next.applicationInfo.flags & 1) == 0) {
                    LocalApplication localApplication = new LocalApplication();
                    localApplication.setApplicationName((String) next.applicationInfo.loadLabel(packageManager));
                    localApplication.setApplicationIcon(next.applicationInfo.loadIcon(packageManager));
                    localApplication.setApplicationPackageName(next.applicationInfo.packageName);
                    localApplication.setApplicationVersionName(next.versionName);
                    a(localApplication);
                    arrayList.add(localApplication);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String l() {
        return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
    }
}
