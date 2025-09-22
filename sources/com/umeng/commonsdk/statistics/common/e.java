package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import android.util.Log;
import java.util.Formatter;
import java.util.Locale;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3885a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f3886b = "ULog";

    /* renamed from: c  reason: collision with root package name */
    private static final int f3887c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 5;
    private static int h = 2000;

    private e() {
    }

    private static void a(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = h;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 < 100) {
                    if (length <= i2) {
                        switch (i) {
                            case 1:
                                Log.v(str, str2.substring(i4, length));
                                break;
                            case 2:
                                Log.d(str, str2.substring(i4, length));
                                break;
                            case 3:
                                Log.i(str, str2.substring(i4, length));
                                break;
                            case 4:
                                Log.w(str, str2.substring(i4, length));
                                break;
                            case 5:
                                Log.e(str, str2.substring(i4, length));
                                break;
                        }
                    } else {
                        switch (i) {
                            case 1:
                                Log.v(str, str2.substring(i4, i2));
                                break;
                            case 2:
                                Log.d(str, str2.substring(i4, i2));
                                break;
                            case 3:
                                Log.i(str, str2.substring(i4, i2));
                                break;
                            case 4:
                                Log.w(str, str2.substring(i4, i2));
                                break;
                            case 5:
                                Log.e(str, str2.substring(i4, i2));
                                break;
                        }
                        i3++;
                        i4 = i2;
                        i2 = h + i2;
                    }
                }
            }
        }
        if (th != null) {
            String f2 = f(th);
            if (!TextUtils.isEmpty(f2)) {
                switch (i) {
                    case 1:
                        Log.v(str, f2);
                        return;
                    case 2:
                        Log.d(str, f2);
                        return;
                    case 3:
                        Log.i(str, f2);
                        return;
                    case 4:
                        Log.w(str, f2);
                        return;
                    case 5:
                        Log.e(str, f2);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void a(String str) {
        a(f3886b, str, (Throwable) null);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f3885a) {
            a(1, str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        c(f3886b, str, th);
    }

    public static void a(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                c(f3886b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            c(str, str2, (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void a(Throwable th) {
        c(f3886b, (String) null, th);
    }

    public static void a(Locale locale, String str, Object... objArr) {
        try {
            c(f3886b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void b(String str) {
        b(f3886b, str, (Throwable) null);
    }

    public static void b(String str, String str2, Throwable th) {
        if (f3885a) {
            a(2, str, str2, th);
        }
    }

    public static void b(String str, Throwable th) {
        a(f3886b, str, th);
    }

    public static void b(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                b(f3886b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            b(str, str2, (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void b(Throwable th) {
        a(f3886b, (String) null, th);
    }

    public static void b(Locale locale, String str, Object... objArr) {
        try {
            b(f3886b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void c(String str) {
        c(f3886b, str, (Throwable) null);
    }

    public static void c(String str, String str2, Throwable th) {
        if (f3885a) {
            a(3, str, str2, th);
        }
    }

    public static void c(String str, Throwable th) {
        d(f3886b, str, th);
    }

    public static void c(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                e(f3886b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            e(str, str2, (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void c(Throwable th) {
        d(f3886b, (String) null, th);
    }

    public static void c(Locale locale, String str, Object... objArr) {
        try {
            e(f3886b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(String str) {
        d(f3886b, str, (Throwable) null);
    }

    public static void d(String str, String str2, Throwable th) {
        if (f3885a) {
            a(4, str, str2, th);
        }
    }

    public static void d(String str, Throwable th) {
        b(f3886b, str, th);
    }

    public static void d(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                a(f3886b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            a(str, str2, (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(Throwable th) {
        b(f3886b, (String) null, th);
    }

    public static void d(Locale locale, String str, Object... objArr) {
        try {
            a(f3886b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(String str) {
        e(f3886b, str, (Throwable) null);
    }

    public static void e(String str, String str2, Throwable th) {
        if (f3885a) {
            a(5, str, str2, th);
        }
    }

    public static void e(String str, Throwable th) {
        e(f3886b, str, th);
    }

    public static void e(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                d(f3886b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = objArr[0];
            }
            d(str, str2, (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(Throwable th) {
        e(f3886b, (String) null, th);
    }

    public static void e(Locale locale, String str, Object... objArr) {
        try {
            d(f3886b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A[SYNTHETIC, Splitter:B:20:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0038 A[SYNTHETIC, Splitter:B:30:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(java.lang.Throwable r4) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ Throwable -> 0x0035, all -> 0x0028 }
            r2.<init>()     // Catch:{ Throwable -> 0x0035, all -> 0x0028 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x0036, all -> 0x0026 }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x0036, all -> 0x0026 }
            r4.printStackTrace(r3)     // Catch:{ Throwable -> 0x0024, all -> 0x0021 }
            r3.flush()     // Catch:{ Throwable -> 0x0024, all -> 0x0021 }
            r2.flush()     // Catch:{ Throwable -> 0x0024, all -> 0x0021 }
            java.lang.String r4 = r2.toString()     // Catch:{ Throwable -> 0x0024, all -> 0x0021 }
            r2.close()     // Catch:{ Throwable -> 0x001d }
        L_0x001d:
            r3.close()
            return r4
        L_0x0021:
            r4 = move-exception
            r1 = r3
            goto L_0x002a
        L_0x0024:
            r1 = r3
            goto L_0x0036
        L_0x0026:
            r4 = move-exception
            goto L_0x002a
        L_0x0028:
            r4 = move-exception
            r2 = r1
        L_0x002a:
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Throwable -> 0x002f }
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            throw r4
        L_0x0035:
            r2 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ Throwable -> 0x003b }
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            r4 = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.e.f(java.lang.Throwable):java.lang.String");
    }
}
