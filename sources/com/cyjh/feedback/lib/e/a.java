package com.cyjh.feedback.lib.e;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.cyjh.common.util.s;
import com.cyjh.elfin.a.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2410a = "ro.miui.ui.version.code";

    /* renamed from: b  reason: collision with root package name */
    private static final String f2411b = "ro.miui.ui.version.name";

    /* renamed from: c  reason: collision with root package name */
    private static final String f2412c = "ro.miui.internal.storage";

    /* renamed from: com.cyjh.feedback.lib.e.a$a  reason: collision with other inner class name */
    class C0036a implements FileFilter {
        C0036a() {
        }

        public final boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C0036a()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", b.f1842b);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static void a(Context context, long j) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }

    private static void a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private static boolean a(Context context, String str) {
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

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[1][34587]\\d{9}");
    }

    private static Point b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static String b() {
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

    private static boolean b(String str) {
        return str == null || "".equalsIgnoreCase(str.trim()) || "null".equalsIgnoreCase(str.trim());
    }

    private static int c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    private static long c() {
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

    private static boolean c(String str) {
        return str.toLowerCase().endsWith(".jpg") || str.toLowerCase().endsWith(".jpeg") || str.toLowerCase().endsWith(".png");
    }

    private static String d() {
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

    private static String e() {
        return Build.SERIAL;
    }

    private static String f() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object newInstance = cls.newInstance();
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(newInstance, new Object[]{"gsm.version.baseband", "no message"});
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean g() {
        try {
            return Build.class.getMethod("hasSmartBar", new Class[0]) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean h() {
        try {
            b bVar = new b();
            return (bVar.a(f2410a) == null && bVar.a(f2411b) == null && bVar.a(f2412c) == null) ? false : true;
        } catch (IOException unused) {
            return false;
        }
    }
}
