package com.cyjh.feedback.lib.e;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2430a = "ROOT_UTIL";

    private static ArrayList<String> a(String str, ArrayList<String> arrayList) {
        Process process;
        ArrayList<String> arrayList2 = new ArrayList<>();
        Process process2 = null;
        try {
            process = Runtime.getRuntime().exec(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    bufferedOutputStream.write((it.next() + " 2>&1\n").getBytes());
                }
                bufferedOutputStream.write("exit\n".getBytes());
                bufferedOutputStream.flush();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        arrayList2.add(readLine);
                    } else {
                        process.waitFor();
                        process.destroy();
                        return arrayList2;
                    }
                }
            } catch (IOException e) {
                e = e;
                process2 = process;
                e.printStackTrace();
                process2.destroy();
                return arrayList2;
            } catch (InterruptedException e2) {
                e = e2;
                process2 = process;
                e.printStackTrace();
                process2.destroy();
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                process.destroy();
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            process2.destroy();
            return arrayList2;
        } catch (InterruptedException e4) {
            e = e4;
            e.printStackTrace();
            process2.destroy();
            return arrayList2;
        } catch (Throwable th2) {
            th = th2;
            process = process2;
            process.destroy();
            throw th;
        }
    }

    public static boolean a() {
        String str = System.getenv("PATH");
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            String str2 = split[i] + File.separator + "su";
            if (new File(str2).exists()) {
                arrayList.add("ls -l " + str2);
            }
        }
        ArrayList<String> a2 = a("/system/bin/sh", arrayList);
        String str3 = "";
        for (int i2 = 0; i2 < a2.size(); i2++) {
            str3 = str3 + a2.get(i2);
        }
        if (str3.contains("-rws")) {
            return true;
        }
        return c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Process} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.DataOutputStream} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00d1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bb A[SYNTHETIC, Splitter:B:48:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cb A[SYNTHETIC, Splitter:B:60:0x00cb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean b() {
        /*
            java.lang.Class<com.cyjh.feedback.lib.e.e> r0 = com.cyjh.feedback.lib.e.e.class
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            java.lang.String r3 = "ROOT_UTIL"
            java.lang.String r4 = "try it"
            android.util.Log.i(r3, r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            java.lang.String r4 = "su"
            java.lang.Process r3 = r3.exec(r4)     // Catch:{ Exception -> 0x00b4, all -> 0x00b1 }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00af }
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ Exception -> 0x00af }
            r4.<init>(r5)     // Catch:{ Exception -> 0x00af }
            java.lang.String r2 = "touch /data/roottest.txt"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r5.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r5.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.lang.String r2 = "\n"
            r5.append(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r4.writeBytes(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.lang.String r2 = "exit\n"
            r4.writeBytes(r2)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r4.flush()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            r3.waitFor()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.lang.String r5 = "/data/roottest.txt"
            r2.<init>(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            if (r2 != 0) goto L_0x0055
            r4.close()     // Catch:{ Exception -> 0x0053 }
            r3.destroy()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            monitor-exit(r0)
            return r1
        L_0x0055:
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.lang.String r5 = "su"
            java.lang.Process r2 = r2.exec(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a8 }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.io.OutputStream r5 = r2.getOutputStream()     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x00a2, all -> 0x00a0 }
            java.lang.String r4 = "ROOT_UTIL"
            java.lang.String r5 = "try delete"
            android.util.Log.i(r4, r5)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = "rm -r /data/roottest.txt"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r5.<init>()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r5.append(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = "\n"
            r5.append(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.writeBytes(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r4 = "exit\n"
            r3.writeBytes(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.flush()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r2.waitFor()     // Catch:{ Exception -> 0x009c, all -> 0x0099 }
            r3.close()     // Catch:{ Exception -> 0x0096 }
            r2.destroy()     // Catch:{ Exception -> 0x0096 }
        L_0x0096:
            r1 = 1
            monitor-exit(r0)
            return r1
        L_0x0099:
            r1 = move-exception
            r4 = r3
            goto L_0x00c9
        L_0x009c:
            r4 = move-exception
            r6 = r3
            r3 = r2
            goto L_0x00ad
        L_0x00a0:
            r1 = move-exception
            goto L_0x00c9
        L_0x00a2:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r4
            r4 = r6
            goto L_0x00b6
        L_0x00a8:
            r1 = move-exception
            goto L_0x00c8
        L_0x00aa:
            r2 = move-exception
            r6 = r4
            r4 = r2
        L_0x00ad:
            r2 = r6
            goto L_0x00b6
        L_0x00af:
            r4 = move-exception
            goto L_0x00b6
        L_0x00b1:
            r1 = move-exception
            r4 = r2
            goto L_0x00c9
        L_0x00b4:
            r4 = move-exception
            r3 = r2
        L_0x00b6:
            r4.printStackTrace()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x00c1
            r2.close()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c1
        L_0x00bf:
            r1 = move-exception
            goto L_0x00d2
        L_0x00c1:
            r3.destroy()     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            monitor-exit(r0)
            return r1
        L_0x00c6:
            r1 = move-exception
            r4 = r2
        L_0x00c8:
            r2 = r3
        L_0x00c9:
            if (r4 == 0) goto L_0x00ce
            r4.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00ce:
            r2.destroy()     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            throw r1     // Catch:{ all -> 0x00bf }
        L_0x00d2:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.feedback.lib.e.e.b():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036 A[SYNTHETIC, Splitter:B:19:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0041 A[SYNTHETIC, Splitter:B:29:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean c() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.feedback.lib.e.e.c():boolean");
    }

    private static boolean d() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
