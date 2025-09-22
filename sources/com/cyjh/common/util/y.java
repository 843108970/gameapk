package com.cyjh.common.util;

import android.os.Environment;
import java.io.File;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1791a = "MobileAnJian";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1792b = "Script";

    /* renamed from: c  reason: collision with root package name */
    private static final String f1793c = "CSTemp";
    private static final String d = "MQTemp";
    private static final String e = "UIConfig";

    private static String a() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private static String a(String str) {
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file.getAbsolutePath();
    }

    private static String a(String str, String str2) {
        StringBuilder sb;
        if (str.endsWith(File.separator)) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str = File.separator;
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    private static String b() {
        return a(Environment.getExternalStorageDirectory().getAbsolutePath(), f1791a);
    }

    private static String c() {
        return a(b(), "Script");
    }

    private static String d() {
        return a(a(b(), f1793c));
    }

    private static String e() {
        return a(a(b(), d));
    }

    private static String f() {
        return a(a(b(), e));
    }
}
