package com.cyjh.mobileanjian.ipc.utils;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import com.cyjh.common.util.s;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static String f2724a = "";

    private static String a() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.startsWith("Serial")) {
                    String substring = readLine.substring(readLine.indexOf(":") + 1);
                    try {
                        str = substring.trim();
                    } catch (IOException unused) {
                        str = substring;
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException unused2) {
        }
        if (str == null) {
            str = "";
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return i == str.length() ? "" : str;
    }

    public static String a(Context context) {
        String d = d(context);
        return (d.endsWith("null") || d.endsWith(EnvironmentCompat.MEDIA_UNKNOWN)) ? f(context) : d;
    }

    private static String a(Context context, boolean z) {
        String str;
        String c2 = c(context);
        String a2 = a();
        String b2 = b();
        if (!z || c2 == null || c2 == "") {
            if (!(c2 == null || c2 == "")) {
                a2 = c2;
            }
            str = (a2 == null || a2 == "") ? b2 : a2;
        } else if (b2 == null || b2 == "") {
            str = c2;
        } else {
            str = c2 + "-" + b2;
        }
        StringBuilder sb = c2 == "" ? new StringBuilder("imei:none-") : new StringBuilder("imei:");
        sb.append(str);
        return sb.toString();
    }

    private static String b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", "cyjhuser"});
        } catch (ClassNotFoundException unused) {
            return "";
        } catch (NoSuchMethodException unused2) {
            return "";
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return "";
        }
    }

    public static boolean b(Context context) {
        String d = d(context);
        return d.endsWith("null") || d.endsWith(EnvironmentCompat.MEDIA_UNKNOWN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.lang.String r2 = "phone"
            java.lang.Object r2 = r6.getSystemService(r2)     // Catch:{ Exception -> 0x0014 }
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x0014 }
            int r3 = r2.getPhoneType()     // Catch:{ Exception -> 0x0014 }
            java.lang.String r2 = r2.getDeviceId()     // Catch:{ Exception -> 0x0015 }
            goto L_0x0017
        L_0x0014:
            r3 = 0
        L_0x0015:
            java.lang.String r2 = ""
        L_0x0017:
            java.lang.String r4 = "phone"
            java.lang.Object r6 = r6.getSystemService(r4)     // Catch:{ Exception -> 0x0028 }
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch:{ Exception -> 0x0028 }
            int r4 = r6.getPhoneType()     // Catch:{ Exception -> 0x0028 }
            java.lang.String r6 = r6.getDeviceId()     // Catch:{ Exception -> 0x0029 }
            goto L_0x002b
        L_0x0028:
            r4 = 0
        L_0x0029:
            java.lang.String r6 = ""
        L_0x002b:
            r1 = 1
            r5 = 2
            if (r3 != r1) goto L_0x0046
            if (r4 != r5) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r1 = "|"
            r0.append(r1)
            r0.append(r6)
        L_0x0041:
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0046:
            if (r4 != r1) goto L_0x005d
            if (r3 != r5) goto L_0x005b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "|"
            r0.append(r6)
            r0.append(r2)
            goto L_0x0041
        L_0x005b:
            r0 = r6
            return r0
        L_0x005d:
            if (r3 != r5) goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.r.c(android.content.Context):java.lang.String");
    }

    private static String d(Context context) {
        String str;
        String a2 = a(context, false);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
                    if (str.startsWith("Hardware")) {
                        str = str.split(":")[1].trim().replaceAll(s.a.f1696a, "_");
                        break;
                    }
                } else {
                    break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException | IOException | Exception unused) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return a2 + "[arm]@_@" + str;
    }

    private static String e(Context context) {
        String a2 = a(context, true);
        return a2 + "[x86]@_@" + "model";
    }

    private static String f(Context context) {
        String str;
        String a2 = a(context, true);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo")));
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
                    if (str.startsWith("model name")) {
                        str = str.split(":")[1].trim().replaceAll(s.a.f1696a, "_");
                        break;
                    }
                } else {
                    break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException | IOException | Exception unused) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return a2 + "[x86]@_@" + str;
    }

    private static String g(Context context) {
        if (f2724a != "") {
            return f2724a;
        }
        String d = d(context);
        if (d.endsWith("null") || d.endsWith(EnvironmentCompat.MEDIA_UNKNOWN)) {
            d = a(context, true) + "[x86]@_@" + "model";
        }
        f2724a = d;
        return d;
    }
}
