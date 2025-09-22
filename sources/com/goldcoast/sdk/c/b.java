package com.goldcoast.sdk.c;

import java.io.File;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2935a = false;

    public static String a() {
        byte[] a2;
        byte[] a3;
        if (a("ro.product.cpu.abilist64", "").length() > 0 || b()) {
            return "64";
        }
        File file = new File("/system/lib/libc.so");
        boolean z = true;
        if (!file.exists() || (a3 = a(file)) == null || a3[4] != 2) {
            File file2 = new File("/system/lib64/libc.so");
            if (!file2.exists() || (a2 = a(file2)) == null || a2[4] != 2) {
                z = false;
            }
        }
        return z ? "64" : "32";
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, ""});
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[SYNTHETIC, Splitter:B:21:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0036 A[SYNTHETIC, Splitter:B:30:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(java.io.File r4) {
        /*
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 == 0) goto L_0x003e
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0033, all -> 0x0026 }
            r0.<init>(r4)     // Catch:{ Throwable -> 0x0033, all -> 0x0026 }
            r4 = 16
            byte[] r2 = new byte[r4]     // Catch:{ Throwable -> 0x0034, all -> 0x0024 }
            r3 = 0
            int r3 = r0.read(r2, r3, r4)     // Catch:{ Throwable -> 0x0034, all -> 0x0024 }
            if (r3 != r4) goto L_0x0020
            r0.close()     // Catch:{ Exception -> 0x001b }
            return r2
        L_0x001b:
            r4 = move-exception
            r4.printStackTrace()
            return r2
        L_0x0020:
            r0.close()     // Catch:{ Exception -> 0x003a }
            return r1
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ Exception -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0032:
            throw r4
        L_0x0033:
            r0 = r1
        L_0x0034:
            if (r0 == 0) goto L_0x003e
            r0.close()     // Catch:{ Exception -> 0x003a }
            return r1
        L_0x003a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goldcoast.sdk.c.b.a(java.io.File):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A[SYNTHETIC, Splitter:B:36:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e A[SYNTHETIC, Splitter:B:41:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007a A[SYNTHETIC, Splitter:B:50:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0084 A[SYNTHETIC, Splitter:B:55:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/cpuinfo"
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x008c
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0077, all -> 0x0060 }
            r2.<init>(r0)     // Catch:{ Throwable -> 0x0077, all -> 0x0060 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x0078, all -> 0x005e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x0078, all -> 0x005e }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x0078, all -> 0x005e }
            r4 = 512(0x200, float:7.175E-43)
            r0.<init>(r3, r4)     // Catch:{ Throwable -> 0x0078, all -> 0x005e }
            java.lang.String r1 = r0.readLine()     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            if (r1 == 0) goto L_0x004b
            int r3 = r1.length()     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            if (r3 <= 0) goto L_0x004b
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            java.lang.String r1 = r1.toLowerCase(r3)     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            java.lang.String r3 = "arch64"
            boolean r1 = r1.contains(r3)     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            if (r1 == 0) goto L_0x004b
            r0.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0041:
            r2.close()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0049:
            r0 = 1
            return r0
        L_0x004b:
            r0.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            r2.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008c
        L_0x0057:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0062
        L_0x005c:
            r1 = r0
            goto L_0x0078
        L_0x005e:
            r0 = move-exception
            goto L_0x0062
        L_0x0060:
            r0 = move-exception
            r2 = r1
        L_0x0062:
            if (r1 == 0) goto L_0x006c
            r1.close()     // Catch:{ Exception -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r1 = move-exception
            r1.printStackTrace()
        L_0x006c:
            if (r2 == 0) goto L_0x0076
            r2.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0076:
            throw r0
        L_0x0077:
            r2 = r1
        L_0x0078:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0082:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r0 = move-exception
            r0.printStackTrace()
        L_0x008c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.goldcoast.sdk.c.b.b():boolean");
    }
}
