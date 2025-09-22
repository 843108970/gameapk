package com.cyjh.common.util;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1643a = "MIUI";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1644b = "EMUI";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1645c = "FLYME";
    public static final String d = "OPPO";
    public static final String e = "SMARTISAN";
    public static final String f = "VIVO";
    public static final String g = "QIKU";
    public static String h = null;
    private static final String i = "Rom";
    private static final String j = "ro.miui.ui.version.name";
    private static final String k = "ro.build.version.emui";
    private static final String l = "ro.build.version.opporom";
    private static final String m = "ro.smartisan.version";
    private static final String n = "ro.vivo.os.version";
    private static String o;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052 A[SYNTHETIC, Splitter:B:19:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[SYNTHETIC, Splitter:B:28:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.String r3 = "getprop "
            r2.<init>(r3)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            r2.append(r6)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x003b, all -> 0x0039 }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0037 }
            r2.close()     // Catch:{ IOException -> 0x0037 }
            r2.close()     // Catch:{ IOException -> 0x0032 }
            return r1
        L_0x0032:
            r6 = move-exception
            r6.printStackTrace()
            return r1
        L_0x0037:
            r1 = move-exception
            goto L_0x003d
        L_0x0039:
            r6 = move-exception
            goto L_0x005d
        L_0x003b:
            r1 = move-exception
            r2 = r0
        L_0x003d:
            java.lang.String r3 = "Rom"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            java.lang.String r5 = "Unable to read prop "
            r4.<init>(r5)     // Catch:{ all -> 0x005b }
            r4.append(r6)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x005b }
            android.util.Log.e(r3, r6, r1)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ IOException -> 0x0056 }
            return r0
        L_0x0056:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005a:
            return r0
        L_0x005b:
            r6 = move-exception
            r0 = r2
        L_0x005d:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0067:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.aa.a(java.lang.String):java.lang.String");
    }

    private static boolean a() {
        return b(f1644b);
    }

    private static boolean b() {
        return b(f1643a);
    }

    private static boolean b(String str) {
        String upperCase;
        if (o == null) {
            String a2 = a(j);
            h = a2;
            if (!TextUtils.isEmpty(a2)) {
                upperCase = f1643a;
            } else {
                String a3 = a(k);
                h = a3;
                if (!TextUtils.isEmpty(a3)) {
                    upperCase = f1644b;
                } else {
                    String a4 = a(l);
                    h = a4;
                    if (!TextUtils.isEmpty(a4)) {
                        upperCase = d;
                    } else {
                        String a5 = a(n);
                        h = a5;
                        if (!TextUtils.isEmpty(a5)) {
                            upperCase = f;
                        } else {
                            String a6 = a(m);
                            h = a6;
                            if (!TextUtils.isEmpty(a6)) {
                                upperCase = e;
                            } else {
                                String str2 = Build.DISPLAY;
                                h = str2;
                                if (str2.toUpperCase().contains(f1645c)) {
                                    upperCase = f1645c;
                                } else {
                                    h = EnvironmentCompat.MEDIA_UNKNOWN;
                                    upperCase = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
            o = upperCase;
        }
        return o.equals(str);
    }

    private static boolean c() {
        return b(f);
    }

    private static boolean d() {
        return b(d);
    }

    private static boolean e() {
        return b(f1645c);
    }

    private static boolean f() {
        return b(g) || b("360");
    }

    private static boolean g() {
        return b(e);
    }

    private static String h() {
        if (o == null) {
            b("");
        }
        return o;
    }

    private static String i() {
        if (h == null) {
            b("");
        }
        return h;
    }

    private static String j() {
        String a2 = a(j);
        h = a2;
        if (!TextUtils.isEmpty(a2)) {
            return f1643a;
        }
        String a3 = a(k);
        h = a3;
        if (!TextUtils.isEmpty(a3)) {
            return f1644b;
        }
        String a4 = a(l);
        h = a4;
        if (!TextUtils.isEmpty(a4)) {
            return d;
        }
        String a5 = a(n);
        h = a5;
        if (!TextUtils.isEmpty(a5)) {
            return f;
        }
        String a6 = a(m);
        h = a6;
        if (!TextUtils.isEmpty(a6)) {
            return e;
        }
        String str = Build.DISPLAY;
        h = str;
        if (str.toUpperCase().contains(f1645c)) {
            return f1645c;
        }
        h = EnvironmentCompat.MEDIA_UNKNOWN;
        String upperCase = Build.MANUFACTURER.toUpperCase();
        return TextUtils.isEmpty(upperCase) ? "0" : upperCase;
    }
}
