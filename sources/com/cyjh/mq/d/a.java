package com.cyjh.mq.d;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f2776a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2777b = "IPC_ANDROID";

    private static String a(String str) {
        String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + "rootAbort" + File.separator;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis())) + ":" + str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str2 + "save.log", true);
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.close();
            return "save.log";
        } catch (Exception unused) {
            return str2;
        }
    }

    private static boolean a() {
        return false;
    }

    private static String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(a.class.getName())) {
                i++;
            } else {
                return "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
            }
        }
        return null;
    }

    private static void c() {
    }

    private static void d() {
    }

    private static void e() {
    }

    private static void f() {
    }

    private static void g() {
    }

    private static void h() {
    }

    private static void i() {
    }

    private static void j() {
    }

    private static void k() {
    }

    private static void l() {
    }
}
