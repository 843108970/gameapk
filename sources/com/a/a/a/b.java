package com.a.a.a;

import android.support.annotation.NonNull;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f459a = {"echo -BOC-", "id"};

    public static a a(@NonNull String str, @NonNull String... strArr) {
        return b(str, strArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x007c, code lost:
        if (r10.getMessage().contains("EPIPE") == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007e, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        r10 = -4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0092, code lost:
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0071, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0086 */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[ExcHandler: InterruptedException (unused java.lang.InterruptedException), SYNTHETIC, Splitter:B:1:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.a.a.a.a b(@android.support.annotation.NonNull java.lang.String r9, @android.support.annotation.NonNull java.lang.String[] r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = java.util.Collections.synchronizedList(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = java.util.Collections.synchronizedList(r1)
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r3 = 0
            java.lang.Process r9 = r2.exec(r9, r3)     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            java.io.OutputStream r3 = r9.getOutputStream()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r2.<init>(r3)     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            com.a.a.a.c r3 = new com.a.a.a.c     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            java.io.InputStream r4 = r9.getInputStream()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r3.<init>(r4, r0)     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            com.a.a.a.c r4 = new com.a.a.a.c     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            java.io.InputStream r5 = r9.getErrorStream()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r4.<init>(r5, r1)     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r3.start()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r4.start()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            int r5 = r10.length     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r6 = 0
        L_0x003e:
            if (r6 >= r5) goto L_0x0062
            r7 = r10[r6]     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r8.<init>()     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r8.append(r7)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            java.lang.String r7 = "\n"
            r8.append(r7)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            java.lang.String r7 = r8.toString()     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            java.lang.String r8 = "UTF-8"
            byte[] r7 = r7.getBytes(r8)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r2.write(r7)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r2.flush()     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            int r6 = r6 + 1
            goto L_0x003e
        L_0x0062:
            java.lang.String r10 = "exit\n"
            java.lang.String r5 = "UTF-8"
            byte[] r10 = r10.getBytes(r5)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r2.write(r10)     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            r2.flush()     // Catch:{ IOException -> 0x0071, InterruptedException -> 0x0092 }
            goto L_0x007f
        L_0x0071:
            r10 = move-exception
            java.lang.String r5 = r10.getMessage()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            java.lang.String r6 = "EPIPE"
            boolean r5 = r5.contains(r6)     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            if (r5 != 0) goto L_0x007f
            throw r10     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
        L_0x007f:
            int r10 = r9.waitFor()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r2.close()     // Catch:{ IOException -> 0x0086, InterruptedException -> 0x0092 }
        L_0x0086:
            r3.join()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r4.join()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            r9.destroy()     // Catch:{ InterruptedException -> 0x0092, IOException -> 0x0090 }
            goto L_0x0093
        L_0x0090:
            r10 = -4
            goto L_0x0093
        L_0x0092:
            r10 = -1
        L_0x0093:
            com.a.a.a.a r9 = new com.a.a.a.a
            r9.<init>(r0, r1, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.b.b(java.lang.String, java.lang.String[]):com.a.a.a.a");
    }
}
