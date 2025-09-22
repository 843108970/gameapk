package com.cyjh.elfin.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static a f1857a = new a();

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f1858b;

    /* renamed from: c  reason: collision with root package name */
    private AppContext f1859c;

    private a() {
    }

    public static a a() {
        return f1857a;
    }

    private void a(PrintWriter printWriter) throws PackageManager.NameNotFoundException {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f1859c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        PackageInfo packageInfo = this.f1859c.getPackageManager().getPackageInfo(this.f1859c.getPackageName(), 0);
        printWriter.println("---------------手机硬件信息-------------------");
        printWriter.println("BOARD : " + Build.BOARD);
        printWriter.println("BOOTLOADER : " + Build.BOOTLOADER);
        printWriter.println("BRAND : " + Build.BRAND);
        printWriter.println("CPU_ABI1: " + Build.CPU_ABI);
        printWriter.println("CPU_ABI2: " + Build.CPU_ABI2);
        printWriter.println("DEVICE : " + Build.DEVICE);
        printWriter.println("DISPLAY : " + Build.DISPLAY);
        printWriter.println("FINGERPRINT : " + Build.FINGERPRINT);
        printWriter.println("HARDWARE : " + Build.HARDWARE);
        printWriter.println("HOST : " + Build.HOST);
        printWriter.println("ID : " + Build.ID);
        printWriter.println("MANUFACTURER  : " + Build.MANUFACTURER);
        printWriter.println("MODEL: " + Build.MODEL);
        printWriter.println("PRODUCT : " + Build.PRODUCT);
        printWriter.println("getRadioVersion : " + Build.getRadioVersion());
        printWriter.println("SERIAL : " + Build.SERIAL);
        printWriter.println("TAGS : " + Build.TAGS);
        printWriter.println("TIME : " + Build.TIME);
        printWriter.println("TYPE : " + Build.TYPE);
        printWriter.println("UNKNOWN : unknown");
        printWriter.println("VERSION.CODENAME : " + Build.VERSION.CODENAME);
        printWriter.println("VERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL);
        printWriter.println("VERSION.RELEASE : " + Build.VERSION.RELEASE);
        printWriter.println("System.getProperty()" + System.getProperty("ro.miui.ui.version.name"));
        printWriter.println("------------------------------------");
        printWriter.println("ScreenSize: " + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
        StringBuilder sb = new StringBuilder("versionName: ");
        sb.append(packageInfo.versionName);
        printWriter.println(sb.toString());
        printWriter.println("versionCode:" + packageInfo.versionCode);
        printWriter.println("OS Version: " + Build.VERSION.RELEASE);
        printWriter.println("API Level: " + Build.VERSION.SDK_INT);
        printWriter.println("Vendor: " + Build.MANUFACTURER);
    }

    private void a(Throwable th) throws IOException {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + this.f1859c.getPackageName() + File.separator + "crashlog");
            if (!file.exists()) {
                file.mkdirs();
            }
            String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            try {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(file, format + ".crashlog"))));
                printWriter.println(format);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) this.f1859c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                PackageInfo packageInfo = this.f1859c.getPackageManager().getPackageInfo(this.f1859c.getPackageName(), 0);
                printWriter.println("---------------手机硬件信息-------------------");
                printWriter.println("BOARD : " + Build.BOARD);
                printWriter.println("BOOTLOADER : " + Build.BOOTLOADER);
                printWriter.println("BRAND : " + Build.BRAND);
                printWriter.println("CPU_ABI1: " + Build.CPU_ABI);
                printWriter.println("CPU_ABI2: " + Build.CPU_ABI2);
                printWriter.println("DEVICE : " + Build.DEVICE);
                printWriter.println("DISPLAY : " + Build.DISPLAY);
                printWriter.println("FINGERPRINT : " + Build.FINGERPRINT);
                printWriter.println("HARDWARE : " + Build.HARDWARE);
                printWriter.println("HOST : " + Build.HOST);
                printWriter.println("ID : " + Build.ID);
                printWriter.println("MANUFACTURER  : " + Build.MANUFACTURER);
                printWriter.println("MODEL: " + Build.MODEL);
                printWriter.println("PRODUCT : " + Build.PRODUCT);
                printWriter.println("getRadioVersion : " + Build.getRadioVersion());
                printWriter.println("SERIAL : " + Build.SERIAL);
                printWriter.println("TAGS : " + Build.TAGS);
                printWriter.println("TIME : " + Build.TIME);
                printWriter.println("TYPE : " + Build.TYPE);
                printWriter.println("UNKNOWN : unknown");
                printWriter.println("VERSION.CODENAME : " + Build.VERSION.CODENAME);
                printWriter.println("VERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL);
                printWriter.println("VERSION.RELEASE : " + Build.VERSION.RELEASE);
                printWriter.println("System.getProperty()" + System.getProperty("ro.miui.ui.version.name"));
                printWriter.println("------------------------------------");
                printWriter.println("ScreenSize: " + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
                StringBuilder sb = new StringBuilder("versionName: ");
                sb.append(packageInfo.versionName);
                printWriter.println(sb.toString());
                printWriter.println("versionCode:" + packageInfo.versionCode);
                printWriter.println("OS Version: " + Build.VERSION.RELEASE);
                printWriter.println("API Level: " + Build.VERSION.SDK_INT);
                printWriter.println("Vendor: " + Build.MANUFACTURER);
                printWriter.println();
                th.printStackTrace(printWriter);
                printWriter.close();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(AppContext appContext) {
        this.f1859c = appContext;
        this.f1858b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + File.separator + this.f1859c.getPackageName() + File.separator + "crashlog");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                try {
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(file, format + ".crashlog"))));
                    printWriter.println(format);
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) this.f1859c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    PackageInfo packageInfo = this.f1859c.getPackageManager().getPackageInfo(this.f1859c.getPackageName(), 0);
                    printWriter.println("---------------手机硬件信息-------------------");
                    printWriter.println("BOARD : " + Build.BOARD);
                    printWriter.println("BOOTLOADER : " + Build.BOOTLOADER);
                    printWriter.println("BRAND : " + Build.BRAND);
                    printWriter.println("CPU_ABI1: " + Build.CPU_ABI);
                    printWriter.println("CPU_ABI2: " + Build.CPU_ABI2);
                    printWriter.println("DEVICE : " + Build.DEVICE);
                    printWriter.println("DISPLAY : " + Build.DISPLAY);
                    printWriter.println("FINGERPRINT : " + Build.FINGERPRINT);
                    printWriter.println("HARDWARE : " + Build.HARDWARE);
                    printWriter.println("HOST : " + Build.HOST);
                    printWriter.println("ID : " + Build.ID);
                    printWriter.println("MANUFACTURER  : " + Build.MANUFACTURER);
                    printWriter.println("MODEL: " + Build.MODEL);
                    printWriter.println("PRODUCT : " + Build.PRODUCT);
                    printWriter.println("getRadioVersion : " + Build.getRadioVersion());
                    printWriter.println("SERIAL : " + Build.SERIAL);
                    printWriter.println("TAGS : " + Build.TAGS);
                    printWriter.println("TIME : " + Build.TIME);
                    printWriter.println("TYPE : " + Build.TYPE);
                    printWriter.println("UNKNOWN : unknown");
                    printWriter.println("VERSION.CODENAME : " + Build.VERSION.CODENAME);
                    printWriter.println("VERSION.INCREMENTAL : " + Build.VERSION.INCREMENTAL);
                    printWriter.println("VERSION.RELEASE : " + Build.VERSION.RELEASE);
                    printWriter.println("System.getProperty()" + System.getProperty("ro.miui.ui.version.name"));
                    printWriter.println("------------------------------------");
                    printWriter.println("ScreenSize: " + displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
                    StringBuilder sb = new StringBuilder("versionName: ");
                    sb.append(packageInfo.versionName);
                    printWriter.println(sb.toString());
                    printWriter.println("versionCode:" + packageInfo.versionCode);
                    printWriter.println("OS Version: " + Build.VERSION.RELEASE);
                    printWriter.println("API Level: " + Build.VERSION.SDK_INT);
                    printWriter.println("Vendor: " + Build.MANUFACTURER);
                    printWriter.println();
                    th.printStackTrace(printWriter);
                    printWriter.close();
                } catch (Exception unused) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        th.printStackTrace();
        if (this.f1858b != null) {
            this.f1858b.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
        }
    }
}
