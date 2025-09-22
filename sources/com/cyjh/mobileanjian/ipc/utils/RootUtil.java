package com.cyjh.mobileanjian.ipc.utils;

import java.io.File;
import java.util.ArrayList;

public class RootUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2704a = "ROOT_UTIL";

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r1 != null) goto L_0x0085;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[Catch:{ IOException -> 0x007f, InterruptedException -> 0x0078, all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> a(java.lang.String r5, java.util.ArrayList<java.lang.String> r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x007f, InterruptedException -> 0x0078 }
            java.lang.Process r5 = r2.exec(r5)     // Catch:{ IOException -> 0x007f, InterruptedException -> 0x0078 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.io.OutputStream r2 = r5.getOutputStream()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.io.InputStream r4 = r5.getInputStream()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
        L_0x0029:
            boolean r3 = r6.hasNext()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            if (r3 == 0) goto L_0x004e
            java.lang.Object r3 = r6.next()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r4.<init>()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r4.append(r3)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.lang.String r3 = " 2>&1\n"
            r4.append(r3)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            byte[] r3 = r3.getBytes()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r1.write(r3)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            goto L_0x0029
        L_0x004e:
            java.lang.String r6 = "exit\n"
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r1.write(r6)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            r1.flush()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
        L_0x005a:
            java.lang.String r6 = r2.readLine()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            if (r6 == 0) goto L_0x0064
            r0.add(r6)     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            goto L_0x005a
        L_0x0064:
            r5.waitFor()     // Catch:{ IOException -> 0x0072, InterruptedException -> 0x006f, all -> 0x006d }
            if (r5 == 0) goto L_0x0088
            r5.destroy()
            return r0
        L_0x006d:
            r6 = move-exception
            goto L_0x0089
        L_0x006f:
            r6 = move-exception
            r1 = r5
            goto L_0x0079
        L_0x0072:
            r6 = move-exception
            r1 = r5
            goto L_0x0080
        L_0x0075:
            r6 = move-exception
            r5 = r1
            goto L_0x0089
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            r6.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0088
            goto L_0x0085
        L_0x007f:
            r6 = move-exception
        L_0x0080:
            r6.printStackTrace()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0088
        L_0x0085:
            r1.destroy()
        L_0x0088:
            return r0
        L_0x0089:
            if (r5 == 0) goto L_0x008e
            r5.destroy()
        L_0x008e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.RootUtil.a(java.lang.String, java.util.ArrayList):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x003d, all -> 0x0030 }
            java.lang.String r2 = "su"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ Exception -> 0x003d, all -> 0x0030 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x003e, all -> 0x002b }
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch:{ Exception -> 0x003e, all -> 0x002b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003e, all -> 0x002b }
            java.lang.String r0 = "exit\n"
            r2.writeBytes(r0)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.flush()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r0 = 1
            r1.waitFor()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.close()     // Catch:{ Exception -> 0x0048 }
            r1.destroy()     // Catch:{ Exception -> 0x0048 }
            return r0
        L_0x0027:
            r0 = move-exception
            goto L_0x0034
        L_0x0029:
            r0 = r2
            goto L_0x003e
        L_0x002b:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x0034
        L_0x0030:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0034:
            if (r2 == 0) goto L_0x0039
            r2.close()     // Catch:{ Exception -> 0x003c }
        L_0x0039:
            r1.destroy()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            throw r0
        L_0x003d:
            r1 = r0
        L_0x003e:
            r2 = 0
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ Exception -> 0x0047 }
        L_0x0044:
            r1.destroy()     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            r0 = 0
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.utils.RootUtil.a():boolean");
    }

    public static boolean isRoot() {
        String str = System.getenv("PATH");
        new ArrayList();
        for (String file : str.split(":")) {
            File file2 = new File(file, "su");
            if (file2.exists() && file2.canExecute()) {
                return true;
            }
        }
        return false;
    }
}
