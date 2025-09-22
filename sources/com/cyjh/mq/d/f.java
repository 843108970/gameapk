package com.cyjh.mq.d;

import java.util.List;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2779a = "su";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2780b = "sh";

    /* renamed from: c  reason: collision with root package name */
    public static final String f2781c = "exit\n";
    public static final String d = "\n";
    /* access modifiers changed from: private */
    public static boolean e = false;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2782a;

        /* renamed from: b  reason: collision with root package name */
        public String f2783b;

        /* renamed from: c  reason: collision with root package name */
        public String f2784c;

        private a(int i) {
            this.f2782a = i;
        }

        public a(int i, String str, String str2) {
            this.f2782a = i;
            this.f2783b = str;
            this.f2784c = str2;
        }
    }

    private static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Process f2785a;

        /* renamed from: b  reason: collision with root package name */
        private int f2786b;

        public b(Process process, int i) {
            this.f2785a = process;
            this.f2786b = i;
        }

        public final void run() {
            try {
                sleep((long) (this.f2786b * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!f.e) {
                this.f2785a.destroy();
            }
        }
    }

    private f() {
        throw new AssertionError();
    }

    public static a a(String str) {
        return a(new String[]{str}, false, true, 100);
    }

    public static a a(List<String> list) {
        return a((String[]) list.toArray(new String[0]), true, true, 0);
    }

    private static a a(List<String> list, boolean z, boolean z2, int i) {
        return a(list == null ? null : (String[]) list.toArray(new String[0]), z, z2, i);
    }

    private static a a(String[] strArr, boolean z, int i) {
        return a(strArr, z, true, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.DataOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v42, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v43, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v45, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v48, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v58, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v59, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: java.lang.StringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v50 */
    /* JADX WARNING: type inference failed for: r2v53 */
    /* JADX WARNING: type inference failed for: r2v56 */
    /* JADX WARNING: type inference failed for: r2v57 */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x017d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0181, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0186, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x018a, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x018d, code lost:
        if (r8 == null) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x018f, code lost:
        r8.destroy();
        r10 = r10;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01a4, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01a8, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01ad, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01b1, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01b4, code lost:
        if (r8 == null) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x01c8, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x01cc, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x01d1, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x01d5, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x01d8, code lost:
        if (r8 == null) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x01f8, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x01fc, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0201, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0205, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x020a, code lost:
        r8.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ca, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cb, code lost:
        r4 = r10;
        r2 = null;
        r10 = r9;
        r9 = r7;
        r7 = r0;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d4, code lost:
        r4 = r10;
        r2 = null;
        r10 = r9;
        r9 = r7;
        r7 = r0;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00dd, code lost:
        r4 = r10;
        r2 = null;
        r10 = r9;
        r9 = r7;
        r7 = r0;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e5, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e6, code lost:
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f0, code lost:
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f9, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fa, code lost:
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0123, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0124, code lost:
        r10 = null;
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x012d, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x012e, code lost:
        r10 = null;
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0137, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0138, code lost:
        r10 = null;
        r0 = null;
        r2 = null;
        r4 = null;
        r6 = r9;
        r9 = r7;
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0141, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0142, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0179 A[SYNTHETIC, Splitter:B:115:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0181 A[Catch:{ IOException -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0186 A[Catch:{ IOException -> 0x017d }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01a0 A[SYNTHETIC, Splitter:B:133:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a8 A[Catch:{ IOException -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01ad A[Catch:{ IOException -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01c4 A[SYNTHETIC, Splitter:B:150:0x01c4] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01cc A[Catch:{ IOException -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01d1 A[Catch:{ IOException -> 0x01c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x01f4 A[SYNTHETIC, Splitter:B:171:0x01f4] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x01fc A[Catch:{ IOException -> 0x01f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0201 A[Catch:{ IOException -> 0x01f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010c A[Catch:{ IOException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0111 A[Catch:{ IOException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0024] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:112:0x0174=Splitter:B:112:0x0174, B:130:0x019b=Splitter:B:130:0x019b, B:147:0x01bf=Splitter:B:147:0x01bf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.cyjh.mq.d.f.a a(java.lang.String[] r7, boolean r8, boolean r9, int r10) {
        /*
            r0 = -1
            r1 = 0
            if (r7 == 0) goto L_0x020e
            int r2 = r7.length
            if (r2 != 0) goto L_0x0009
            goto L_0x020e
        L_0x0009:
            r2 = 0
            e = r2
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x01b7, Exception -> 0x0193, Throwable -> 0x016c, all -> 0x0166 }
            if (r8 == 0) goto L_0x0015
            java.lang.String r8 = "su"
            goto L_0x0017
        L_0x0015:
            java.lang.String r8 = "sh"
        L_0x0017:
            java.lang.Process r8 = r3.exec(r8)     // Catch:{ IOException -> 0x01b7, Exception -> 0x0193, Throwable -> 0x016c, all -> 0x0166 }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0162, Exception -> 0x015f, Throwable -> 0x015c, all -> 0x0159 }
            java.io.OutputStream r4 = r8.getOutputStream()     // Catch:{ IOException -> 0x0162, Exception -> 0x015f, Throwable -> 0x015c, all -> 0x0159 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0162, Exception -> 0x015f, Throwable -> 0x015c, all -> 0x0159 }
            int r4 = r7.length     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
        L_0x0025:
            if (r2 >= r4) goto L_0x003d
            r5 = r7[r2]     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            if (r5 == 0) goto L_0x003a
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            r3.write(r5)     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            java.lang.String r5 = "\n"
            r3.writeBytes(r5)     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            r3.flush()     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.String r7 = "exit\n"
            r3.writeBytes(r7)     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            r3.flush()     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            if (r10 <= 0) goto L_0x004f
            com.cyjh.mq.d.f$b r7 = new com.cyjh.mq.d.f$b     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            r7.<init>(r8, r10)     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            r7.start()     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
        L_0x004f:
            int r7 = r8.waitFor()     // Catch:{ IOException -> 0x0152, Exception -> 0x014b, Throwable -> 0x0145, all -> 0x0141 }
            java.lang.String r10 = "SYS"
            java.lang.String r0 = "command finished."
            android.util.Log.i(r10, r0)     // Catch:{ IOException -> 0x0137, Exception -> 0x012d, Throwable -> 0x0123, all -> 0x0141 }
            r10 = 1
            e = r10     // Catch:{ IOException -> 0x0137, Exception -> 0x012d, Throwable -> 0x0123, all -> 0x0141 }
            if (r9 == 0) goto L_0x0103
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0137, Exception -> 0x012d, Throwable -> 0x0123, all -> 0x0141 }
            r9.<init>()     // Catch:{ IOException -> 0x0137, Exception -> 0x012d, Throwable -> 0x0123, all -> 0x0141 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f9, Exception -> 0x00ef, Throwable -> 0x00e5, all -> 0x0141 }
            r10.<init>()     // Catch:{ IOException -> 0x00f9, Exception -> 0x00ef, Throwable -> 0x00e5, all -> 0x0141 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00dc, Exception -> 0x00d3, Throwable -> 0x00ca, all -> 0x0141 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00dc, Exception -> 0x00d3, Throwable -> 0x00ca, all -> 0x0141 }
            java.io.InputStream r4 = r8.getInputStream()     // Catch:{ IOException -> 0x00dc, Exception -> 0x00d3, Throwable -> 0x00ca, all -> 0x0141 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00dc, Exception -> 0x00d3, Throwable -> 0x00ca, all -> 0x0141 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x00dc, Exception -> 0x00d3, Throwable -> 0x00ca, all -> 0x0141 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c2, Exception -> 0x00ba, Throwable -> 0x00b2, all -> 0x00ae }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c2, Exception -> 0x00ba, Throwable -> 0x00b2, all -> 0x00ae }
            java.io.InputStream r5 = r8.getErrorStream()     // Catch:{ IOException -> 0x00c2, Exception -> 0x00ba, Throwable -> 0x00b2, all -> 0x00ae }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00c2, Exception -> 0x00ba, Throwable -> 0x00b2, all -> 0x00ae }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00c2, Exception -> 0x00ba, Throwable -> 0x00b2, all -> 0x00ae }
        L_0x0085:
            java.lang.String r4 = r0.readLine()     // Catch:{ IOException -> 0x00a7, Exception -> 0x00a0, Throwable -> 0x0099 }
            if (r4 == 0) goto L_0x008f
            r9.append(r4)     // Catch:{ IOException -> 0x00a7, Exception -> 0x00a0, Throwable -> 0x0099 }
            goto L_0x0085
        L_0x008f:
            java.lang.String r4 = r2.readLine()     // Catch:{ IOException -> 0x00a7, Exception -> 0x00a0, Throwable -> 0x0099 }
            if (r4 == 0) goto L_0x0107
            r10.append(r4)     // Catch:{ IOException -> 0x00a7, Exception -> 0x00a0, Throwable -> 0x0099 }
            goto L_0x008f
        L_0x0099:
            r4 = move-exception
            r6 = r9
            r9 = r7
            r7 = r4
            r4 = r10
            goto L_0x00ec
        L_0x00a0:
            r4 = move-exception
            r6 = r9
            r9 = r7
            r7 = r4
            r4 = r10
            goto L_0x00f6
        L_0x00a7:
            r4 = move-exception
            r6 = r9
            r9 = r7
            r7 = r4
            r4 = r10
            goto L_0x0100
        L_0x00ae:
            r7 = move-exception
            r2 = r1
            goto L_0x01f1
        L_0x00b2:
            r2 = move-exception
            r4 = r10
            r10 = r9
            r9 = r7
            r7 = r2
            r2 = r1
            goto L_0x0174
        L_0x00ba:
            r2 = move-exception
            r4 = r10
            r10 = r9
            r9 = r7
            r7 = r2
            r2 = r1
            goto L_0x019b
        L_0x00c2:
            r2 = move-exception
            r4 = r10
            r10 = r9
            r9 = r7
            r7 = r2
            r2 = r1
            goto L_0x01bf
        L_0x00ca:
            r0 = move-exception
            r4 = r10
            r2 = r1
            r10 = r9
            r9 = r7
            r7 = r0
            r0 = r2
            goto L_0x0174
        L_0x00d3:
            r0 = move-exception
            r4 = r10
            r2 = r1
            r10 = r9
            r9 = r7
            r7 = r0
            r0 = r2
            goto L_0x019b
        L_0x00dc:
            r0 = move-exception
            r4 = r10
            r2 = r1
            r10 = r9
            r9 = r7
            r7 = r0
            r0 = r2
            goto L_0x01bf
        L_0x00e5:
            r10 = move-exception
            r0 = r1
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r10
        L_0x00ec:
            r10 = r6
            goto L_0x0174
        L_0x00ef:
            r10 = move-exception
            r0 = r1
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r10
        L_0x00f6:
            r10 = r6
            goto L_0x019b
        L_0x00f9:
            r10 = move-exception
            r0 = r1
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r10
        L_0x0100:
            r10 = r6
            goto L_0x01bf
        L_0x0103:
            r9 = r1
            r10 = r9
            r0 = r10
            r2 = r0
        L_0x0107:
            r3.close()     // Catch:{ IOException -> 0x0115 }
            if (r0 == 0) goto L_0x010f
            r0.close()     // Catch:{ IOException -> 0x0115 }
        L_0x010f:
            if (r2 == 0) goto L_0x0119
            r2.close()     // Catch:{ IOException -> 0x0115 }
            goto L_0x0119
        L_0x0115:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0119:
            if (r8 == 0) goto L_0x011e
            r8.destroy()
        L_0x011e:
            r4 = r10
            r10 = r9
            r9 = r7
            goto L_0x01db
        L_0x0123:
            r9 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r6
            goto L_0x0174
        L_0x012d:
            r9 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r6
            goto L_0x019b
        L_0x0137:
            r9 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            r6 = r9
            r9 = r7
            r7 = r6
            goto L_0x01bf
        L_0x0141:
            r7 = move-exception
            r2 = r1
            goto L_0x01f2
        L_0x0145:
            r7 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            goto L_0x0173
        L_0x014b:
            r7 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            goto L_0x019a
        L_0x0152:
            r7 = move-exception
            r10 = r1
            r0 = r10
            r2 = r0
            r4 = r2
            goto L_0x01be
        L_0x0159:
            r7 = move-exception
            r2 = r1
            goto L_0x0169
        L_0x015c:
            r7 = move-exception
            r10 = r1
            goto L_0x016f
        L_0x015f:
            r7 = move-exception
            r10 = r1
            goto L_0x0196
        L_0x0162:
            r7 = move-exception
            r10 = r1
            goto L_0x01ba
        L_0x0166:
            r7 = move-exception
            r8 = r1
            r2 = r8
        L_0x0169:
            r3 = r2
            goto L_0x01f2
        L_0x016c:
            r7 = move-exception
            r8 = r1
            r10 = r8
        L_0x016f:
            r0 = r10
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x0173:
            r9 = -1
        L_0x0174:
            r7.printStackTrace()     // Catch:{ all -> 0x01f0 }
            if (r3 == 0) goto L_0x017f
            r3.close()     // Catch:{ IOException -> 0x017d }
            goto L_0x017f
        L_0x017d:
            r7 = move-exception
            goto L_0x018a
        L_0x017f:
            if (r0 == 0) goto L_0x0184
            r0.close()     // Catch:{ IOException -> 0x017d }
        L_0x0184:
            if (r2 == 0) goto L_0x018d
            r2.close()     // Catch:{ IOException -> 0x017d }
            goto L_0x018d
        L_0x018a:
            r7.printStackTrace()
        L_0x018d:
            if (r8 == 0) goto L_0x01db
        L_0x018f:
            r8.destroy()
            goto L_0x01db
        L_0x0193:
            r7 = move-exception
            r8 = r1
            r10 = r8
        L_0x0196:
            r0 = r10
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x019a:
            r9 = -1
        L_0x019b:
            r7.printStackTrace()     // Catch:{ all -> 0x01f0 }
            if (r3 == 0) goto L_0x01a6
            r3.close()     // Catch:{ IOException -> 0x01a4 }
            goto L_0x01a6
        L_0x01a4:
            r7 = move-exception
            goto L_0x01b1
        L_0x01a6:
            if (r0 == 0) goto L_0x01ab
            r0.close()     // Catch:{ IOException -> 0x01a4 }
        L_0x01ab:
            if (r2 == 0) goto L_0x01b4
            r2.close()     // Catch:{ IOException -> 0x01a4 }
            goto L_0x01b4
        L_0x01b1:
            r7.printStackTrace()
        L_0x01b4:
            if (r8 == 0) goto L_0x01db
            goto L_0x018f
        L_0x01b7:
            r7 = move-exception
            r8 = r1
            r10 = r8
        L_0x01ba:
            r0 = r10
            r2 = r0
            r3 = r2
            r4 = r3
        L_0x01be:
            r9 = -1
        L_0x01bf:
            r7.printStackTrace()     // Catch:{ all -> 0x01f0 }
            if (r3 == 0) goto L_0x01ca
            r3.close()     // Catch:{ IOException -> 0x01c8 }
            goto L_0x01ca
        L_0x01c8:
            r7 = move-exception
            goto L_0x01d5
        L_0x01ca:
            if (r0 == 0) goto L_0x01cf
            r0.close()     // Catch:{ IOException -> 0x01c8 }
        L_0x01cf:
            if (r2 == 0) goto L_0x01d8
            r2.close()     // Catch:{ IOException -> 0x01c8 }
            goto L_0x01d8
        L_0x01d5:
            r7.printStackTrace()
        L_0x01d8:
            if (r8 == 0) goto L_0x01db
            goto L_0x018f
        L_0x01db:
            com.cyjh.mq.d.f$a r7 = new com.cyjh.mq.d.f$a
            if (r10 != 0) goto L_0x01e1
            r8 = r1
            goto L_0x01e5
        L_0x01e1:
            java.lang.String r8 = r10.toString()
        L_0x01e5:
            if (r4 != 0) goto L_0x01e8
            goto L_0x01ec
        L_0x01e8:
            java.lang.String r1 = r4.toString()
        L_0x01ec:
            r7.<init>(r9, r8, r1)
            return r7
        L_0x01f0:
            r7 = move-exception
        L_0x01f1:
            r1 = r0
        L_0x01f2:
            if (r3 == 0) goto L_0x01fa
            r3.close()     // Catch:{ IOException -> 0x01f8 }
            goto L_0x01fa
        L_0x01f8:
            r9 = move-exception
            goto L_0x0205
        L_0x01fa:
            if (r1 == 0) goto L_0x01ff
            r1.close()     // Catch:{ IOException -> 0x01f8 }
        L_0x01ff:
            if (r2 == 0) goto L_0x0208
            r2.close()     // Catch:{ IOException -> 0x01f8 }
            goto L_0x0208
        L_0x0205:
            r9.printStackTrace()
        L_0x0208:
            if (r8 == 0) goto L_0x020d
            r8.destroy()
        L_0x020d:
            throw r7
        L_0x020e:
            com.cyjh.mq.d.f$a r7 = new com.cyjh.mq.d.f$a
            r7.<init>(r0, r1, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mq.d.f.a(java.lang.String[], boolean, boolean, int):com.cyjh.mq.d.f$a");
    }

    private static a b(String str) {
        return a(new String[]{str}, true, false, 0);
    }

    private static boolean b() {
        return a(new String[]{"echo root"}, true, false, 0).f2782a == 0;
    }
}
