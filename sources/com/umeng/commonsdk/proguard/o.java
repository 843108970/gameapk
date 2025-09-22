package com.umeng.commonsdk.proguard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3802a = "\n";

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f3803b = "\nexit\n".getBytes();

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f3804c = new byte[32];

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v44, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v45, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v48, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r9 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        c(r9);
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00cf, code lost:
        if (r9 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00e0, code lost:
        if (r9 != null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00e4, code lost:
        if (r7 != 0) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00e6, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x00eb, code lost:
        return r7.toString();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00f2  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:73:0x00c9=Splitter:B:73:0x00c9, B:84:0x00da=Splitter:B:84:0x00da} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String... r9) {
        /*
            r0 = 0
            java.lang.ProcessBuilder r1 = new java.lang.ProcessBuilder     // Catch:{ IOException -> 0x00d2, Exception -> 0x00c1, all -> 0x00b8 }
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ IOException -> 0x00d2, Exception -> 0x00c1, all -> 0x00b8 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x00d2, Exception -> 0x00c1, all -> 0x00b8 }
            java.lang.ProcessBuilder r9 = r1.command(r9)     // Catch:{ IOException -> 0x00d2, Exception -> 0x00c1, all -> 0x00b8 }
            java.lang.Process r9 = r9.start()     // Catch:{ IOException -> 0x00d2, Exception -> 0x00c1, all -> 0x00b8 }
            java.io.OutputStream r1 = r9.getOutputStream()     // Catch:{ IOException -> 0x00b5, Exception -> 0x00b2, all -> 0x00aa }
            java.io.InputStream r2 = r9.getInputStream()     // Catch:{ IOException -> 0x00a7, Exception -> 0x00a4, all -> 0x009c }
            java.io.InputStream r3 = r9.getErrorStream()     // Catch:{ IOException -> 0x0098, Exception -> 0x0095, all -> 0x008e }
            byte[] r4 = f3803b     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            r1.write(r4)     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            r1.flush()     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            r9.waitFor()     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            r4.<init>(r2)     // Catch:{ IOException -> 0x008a, Exception -> 0x0086, all -> 0x0080 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x007c, Exception -> 0x0078, all -> 0x0072 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x007c, Exception -> 0x0078, all -> 0x0072 }
            java.lang.String r6 = r5.readLine()     // Catch:{ IOException -> 0x006e, Exception -> 0x006a }
            if (r6 == 0) goto L_0x0051
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006e, Exception -> 0x006a }
            r7.<init>()     // Catch:{ IOException -> 0x006e, Exception -> 0x006a }
            r7.append(r6)     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            java.lang.String r6 = f3802a     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
        L_0x0042:
            r7.append(r6)     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            java.lang.String r6 = r5.readLine()     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0052
            r7.append(r6)     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            java.lang.String r6 = f3802a     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            goto L_0x0042
        L_0x0051:
            r7 = r0
        L_0x0052:
            byte[] r6 = f3804c     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            int r6 = r3.read(r6)     // Catch:{ IOException -> 0x0067, Exception -> 0x0064 }
            if (r6 > 0) goto L_0x0052
            a(r1, r3, r2, r4, r5)
            if (r9 == 0) goto L_0x00e4
        L_0x005f:
            c(r9)
            goto L_0x00e4
        L_0x0064:
            r6 = move-exception
            goto L_0x00c9
        L_0x0067:
            r6 = move-exception
            goto L_0x00da
        L_0x006a:
            r6 = move-exception
            r7 = r0
            goto L_0x00c9
        L_0x006e:
            r6 = move-exception
            r7 = r0
            goto L_0x00da
        L_0x0072:
            r5 = move-exception
            r8 = r5
            r5 = r0
            r0 = r8
            goto L_0x00ed
        L_0x0078:
            r6 = move-exception
            r5 = r0
            goto L_0x00c8
        L_0x007c:
            r6 = move-exception
            r5 = r0
            goto L_0x00d9
        L_0x0080:
            r4 = move-exception
            r5 = r0
            r0 = r4
            r4 = r5
            goto L_0x00ed
        L_0x0086:
            r6 = move-exception
            r4 = r0
            goto L_0x00c7
        L_0x008a:
            r6 = move-exception
            r4 = r0
            goto L_0x00d8
        L_0x008e:
            r3 = move-exception
            r4 = r0
            r5 = r4
            r0 = r3
            r3 = r5
            goto L_0x00ed
        L_0x0095:
            r6 = move-exception
            r3 = r0
            goto L_0x00c6
        L_0x0098:
            r6 = move-exception
            r3 = r0
            goto L_0x00d7
        L_0x009c:
            r2 = move-exception
            r3 = r0
            r4 = r3
            r5 = r4
            r0 = r2
            r2 = r5
            goto L_0x00ed
        L_0x00a4:
            r6 = move-exception
            r2 = r0
            goto L_0x00c5
        L_0x00a7:
            r6 = move-exception
            r2 = r0
            goto L_0x00d6
        L_0x00aa:
            r1 = move-exception
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
            r0 = r1
            r1 = r5
            goto L_0x00ed
        L_0x00b2:
            r6 = move-exception
            r1 = r0
            goto L_0x00c4
        L_0x00b5:
            r6 = move-exception
            r1 = r0
            goto L_0x00d5
        L_0x00b8:
            r9 = move-exception
            r1 = r0
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r0 = r9
            r9 = r5
            goto L_0x00ed
        L_0x00c1:
            r6 = move-exception
            r9 = r0
            r1 = r9
        L_0x00c4:
            r2 = r1
        L_0x00c5:
            r3 = r2
        L_0x00c6:
            r4 = r3
        L_0x00c7:
            r5 = r4
        L_0x00c8:
            r7 = r5
        L_0x00c9:
            r6.printStackTrace()     // Catch:{ all -> 0x00ec }
            a(r1, r3, r2, r4, r5)
            if (r9 == 0) goto L_0x00e4
            goto L_0x005f
        L_0x00d2:
            r6 = move-exception
            r9 = r0
            r1 = r9
        L_0x00d5:
            r2 = r1
        L_0x00d6:
            r3 = r2
        L_0x00d7:
            r4 = r3
        L_0x00d8:
            r5 = r4
        L_0x00d9:
            r7 = r5
        L_0x00da:
            r6.printStackTrace()     // Catch:{ all -> 0x00ec }
            a(r1, r3, r2, r4, r5)
            if (r9 == 0) goto L_0x00e4
            goto L_0x005f
        L_0x00e4:
            if (r7 != 0) goto L_0x00e7
            return r0
        L_0x00e7:
            java.lang.String r9 = r7.toString()
            return r9
        L_0x00ec:
            r0 = move-exception
        L_0x00ed:
            a(r1, r3, r2, r4, r5)
            if (r9 == 0) goto L_0x00f5
            c(r9)
        L_0x00f5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.o.a(java.lang.String[]):java.lang.String");
    }

    private static void a(OutputStream outputStream, InputStream inputStream, InputStream inputStream2, InputStreamReader inputStreamReader, BufferedReader bufferedReader) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:5|6|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.Process r1) {
        /*
            int r0 = b(r1)
            if (r0 == 0) goto L_0x000d
            android.os.Process.killProcess(r0)     // Catch:{ Exception -> 0x000a }
            return
        L_0x000a:
            r1.destroy()     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.proguard.o.a(java.lang.Process):void");
    }

    private static int b(Process process) {
        String obj = process.toString();
        try {
            return Integer.parseInt(obj.substring(obj.indexOf("=") + 1, obj.indexOf("]")));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static void c(Process process) {
        if (process != null) {
            try {
                if (process.exitValue() != 0) {
                    a(process);
                }
            } catch (IllegalThreadStateException unused) {
                a(process);
            }
        }
    }
}
