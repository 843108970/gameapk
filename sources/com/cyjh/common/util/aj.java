package com.cyjh.common.util;

public enum aj {
    INSTANCE;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void copyWebInjectFile(android.content.Context r8) {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/system/lib/libc.so"
            r0.<init>(r1)
            r1 = 20
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 1
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0022 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0022 }
            int r0 = r4.read(r1)     // Catch:{ Exception -> 0x0022 }
            r4 = -1
            if (r0 == r4) goto L_0x0026
            r0 = 18
            byte r0 = r1[r0]     // Catch:{ Exception -> 0x0022 }
            r1 = 3
            if (r0 != r1) goto L_0x0026
            r0 = 0
            goto L_0x0027
        L_0x0022:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0026:
            r0 = 1
        L_0x0027:
            boolean r1 = com.cyjh.common.util.ac.a()
            java.lang.String r4 = "xygtest"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "isRoot="
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5)
            if (r0 == 0) goto L_0x01ce
            java.lang.String r0 = "getprop phone.id"
            r4 = 100
            com.cyjh.common.util.ac$a r0 = com.cyjh.common.util.ac.a(r0, r3, r4)
            java.lang.String r4 = r0.f1653b
            if (r4 == 0) goto L_0x0138
            java.lang.String r0 = r0.f1653b
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0138
            if (r1 == 0) goto L_0x01cd
            java.lang.String r0 = "mkdir -p /sdcard/data/local/tmp/"
            com.cyjh.common.util.ac$a r0 = com.cyjh.common.util.ac.a(r0, r3, r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "xygtest"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            java.lang.String r5 = "result="
            r4.<init>(r5)     // Catch:{ Exception -> 0x0133 }
            int r0 = r0.f1652a     // Catch:{ Exception -> 0x0133 }
            r4.append(r0)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0133 }
            android.util.Log.e(r1, r0)     // Catch:{ Exception -> 0x0133 }
            com.cyjh.common.util.t r0 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "injectDDY/test.apk"
            java.lang.String r4 = "data/local/tmp/test.apk"
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0133 }
            com.cyjh.common.util.t r0 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "injectDDY/ddyinject.apk"
            java.lang.String r4 = "data/local/tmp/ddyinject.apk"
            r0.a(r1, r4)     // Catch:{ Exception -> 0x0133 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "/sdcard/com.cyjh.mrpa/script/.config"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0133 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0133 }
            if (r0 != 0) goto L_0x00af
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "/sdcard/com.cyjh.mrpa/script/"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0133 }
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x0133 }
            if (r1 != 0) goto L_0x00a4
            r0.mkdirs()     // Catch:{ Exception -> 0x0133 }
        L_0x00a4:
            com.cyjh.common.util.t r8 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = "injectDDY/config.txt"
            java.lang.String r1 = "com.cyjh.mrpa/script/.config"
            r8.a(r0, r1)     // Catch:{ Exception -> 0x0133 }
        L_0x00af:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = "/data/local/tmp/ddyinject.apk"
            r8.<init>(r0)     // Catch:{ Exception -> 0x0133 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "/data/local/tmp/test.apk"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0133 }
            boolean r1 = r8.exists()     // Catch:{ Exception -> 0x0133 }
            if (r1 == 0) goto L_0x00fc
            java.lang.String r8 = com.cyjh.common.util.n.d((java.io.File) r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x0133 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r4 = "/sdcard/data/local/tmp/ddyinject.apk"
            r1.<init>(r4)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = com.cyjh.common.util.n.d((java.io.File) r1)     // Catch:{ Exception -> 0x0133 }
            boolean r8 = r8.equals(r1)     // Catch:{ Exception -> 0x0133 }
            if (r8 == 0) goto L_0x00fc
            boolean r8 = r0.exists()     // Catch:{ Exception -> 0x0133 }
            if (r8 == 0) goto L_0x00fc
            java.lang.String r8 = com.cyjh.common.util.n.d((java.io.File) r0)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r8 = r8.trim()     // Catch:{ Exception -> 0x0133 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0133 }
            java.lang.String r1 = "/sdcard/data/local/tmp/test.apk"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = com.cyjh.common.util.n.d((java.io.File) r0)     // Catch:{ Exception -> 0x0133 }
            boolean r8 = r8.equals(r0)     // Catch:{ Exception -> 0x0133 }
            if (r8 == 0) goto L_0x00fc
            return
        L_0x00fc:
            java.lang.String r8 = "cp /sdcard/data/local/tmp/* /data/local/tmp/"
            com.cyjh.common.util.ac$a r8 = com.cyjh.common.util.ac.a(r8, r3, r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = "xygtest"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            java.lang.String r4 = "cp result="
            r1.<init>(r4)     // Catch:{ Exception -> 0x0133 }
            int r8 = r8.f1652a     // Catch:{ Exception -> 0x0133 }
            r1.append(r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0133 }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r8 = "chmod 777 /data/local/tmp/*"
            com.cyjh.common.util.ac$a r8 = com.cyjh.common.util.ac.a(r8, r3, r2)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r0 = "xygtest"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133 }
            java.lang.String r2 = "chmod result="
            r1.<init>(r2)     // Catch:{ Exception -> 0x0133 }
            int r8 = r8.f1652a     // Catch:{ Exception -> 0x0133 }
            r1.append(r8)     // Catch:{ Exception -> 0x0133 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0133 }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x0133 }
            return
        L_0x0133:
            r8 = move-exception
            r8.printStackTrace()
            return
        L_0x0138:
            if (r1 == 0) goto L_0x01cd
            java.lang.String r0 = "mkdir -p /sdcard/data/local/tmp/"
            com.cyjh.common.util.ac.a(r0, r3, r2)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r0 = "mkdir -p /data/local/tmp/"
            com.cyjh.common.util.ac.a(r0, r3, r2)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r0 = "mkdir -p /sdcard/com.cyjh.mrpa/script/"
            com.cyjh.common.util.ac.a(r0, r3, r2)     // Catch:{ Exception -> 0x01c9 }
            com.cyjh.common.util.t r0 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r1 = "inject/armeabi-v7a/Inject"
            java.lang.String r4 = "data/local/tmp/a"
            r0.a(r1, r4)     // Catch:{ Exception -> 0x01c9 }
            com.cyjh.common.util.t r0 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r1 = "inject/armeabi-v7a/libnullso2.so"
            java.lang.String r4 = "data/local/tmp/c"
            r0.a(r1, r4)     // Catch:{ Exception -> 0x01c9 }
            com.cyjh.common.util.t r0 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r1 = "inject/test.apk"
            java.lang.String r4 = "test.apk"
            r0.a(r1, r4)     // Catch:{ Exception -> 0x01c9 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r1 = "/sdcard/com.cyjh.mrpa/script/.config"
            r0.<init>(r1)     // Catch:{ Exception -> 0x01c9 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x01c9 }
            if (r0 != 0) goto L_0x0192
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r1 = "/sdcard/com.cyjh.mrpa/script/"
            r0.<init>(r1)     // Catch:{ Exception -> 0x01c9 }
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x01c9 }
            if (r1 != 0) goto L_0x0187
            r0.mkdirs()     // Catch:{ Exception -> 0x01c9 }
        L_0x0187:
            com.cyjh.common.util.t r8 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r0 = "inject/config.txt"
            java.lang.String r1 = "com.cyjh.mrpa/script/.config"
            r8.a(r0, r1)     // Catch:{ Exception -> 0x01c9 }
        L_0x0192:
            java.lang.String r8 = "cp /sdcard/data/local/tmp/* /data/local/tmp/"
            com.cyjh.common.util.ac$a r8 = com.cyjh.common.util.ac.a(r8, r3, r2)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r0 = "xygtest"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r4 = "result="
            r1.<init>(r4)     // Catch:{ Exception -> 0x01c9 }
            int r8 = r8.f1652a     // Catch:{ Exception -> 0x01c9 }
            r1.append(r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x01c9 }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r8 = "chmod 777 /data/local/tmp/*"
            com.cyjh.common.util.ac$a r8 = com.cyjh.common.util.ac.a(r8, r3, r2)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r0 = "xygtest"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r2 = "result="
            r1.<init>(r2)     // Catch:{ Exception -> 0x01c9 }
            int r8 = r8.f1652a     // Catch:{ Exception -> 0x01c9 }
            r1.append(r8)     // Catch:{ Exception -> 0x01c9 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x01c9 }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x01c9 }
            return
        L_0x01c9:
            r8 = move-exception
            r8.printStackTrace()
        L_0x01cd:
            return
        L_0x01ce:
            if (r1 == 0) goto L_0x0256
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0256 }
            r0.<init>()     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "mkdir -p /sdcard/data/local/tmp/"
            r0.add(r1)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "mkdir -p /data/local/tmp/"
            r0.add(r1)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "mkdir -p /sdcard/com.cyjh.mrpa/script/"
            r0.add(r1)     // Catch:{ Exception -> 0x0256 }
            com.cyjh.common.util.ac.a((java.util.List<java.lang.String>) r0)     // Catch:{ Exception -> 0x0256 }
            com.cyjh.common.util.t r1 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "inject/x86/Inject"
            java.lang.String r3 = "data/local/tmp/a"
            r1.a(r2, r3)     // Catch:{ Exception -> 0x0256 }
            com.cyjh.common.util.t r1 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "inject/x86/libnullso2.so"
            java.lang.String r3 = "data/local/tmp/c"
            r1.a(r2, r3)     // Catch:{ Exception -> 0x0256 }
            com.cyjh.common.util.t r1 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "inject/test.apk"
            java.lang.String r3 = "test.apk"
            r1.a(r2, r3)     // Catch:{ Exception -> 0x0256 }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "/sdcard/com.cyjh.mrpa/script/.config"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0256 }
            boolean r1 = r1.exists()     // Catch:{ Exception -> 0x0256 }
            if (r1 != 0) goto L_0x0230
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "/sdcard/com.cyjh.mrpa/script/"
            r1.<init>(r2)     // Catch:{ Exception -> 0x0256 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0256 }
            if (r2 != 0) goto L_0x0225
            r1.mkdirs()     // Catch:{ Exception -> 0x0256 }
        L_0x0225:
            com.cyjh.common.util.t r8 = com.cyjh.common.util.t.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r1 = "inject/config.txt"
            java.lang.String r2 = "com.cyjh.mrpa/script/.config"
            r8.a(r1, r2)     // Catch:{ Exception -> 0x0256 }
        L_0x0230:
            r0.clear()     // Catch:{ Exception -> 0x0256 }
            java.lang.String r8 = "cp /sdcard/data/local/tmp/* /data/local/tmp/"
            r0.add(r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r8 = "chmod 777 /data/local/tmp/*"
            r0.add(r8)     // Catch:{ Exception -> 0x0256 }
            com.cyjh.common.util.ac$a r8 = com.cyjh.common.util.ac.a((java.util.List<java.lang.String>) r0)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r0 = "xygtest"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0256 }
            java.lang.String r2 = "result="
            r1.<init>(r2)     // Catch:{ Exception -> 0x0256 }
            int r8 = r8.f1652a     // Catch:{ Exception -> 0x0256 }
            r1.append(r8)     // Catch:{ Exception -> 0x0256 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0256 }
            android.util.Log.e(r0, r8)     // Catch:{ Exception -> 0x0256 }
        L_0x0256:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.common.util.aj.copyWebInjectFile(android.content.Context):void");
    }
}
