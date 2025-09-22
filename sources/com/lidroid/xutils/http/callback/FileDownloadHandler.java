package com.lidroid.xutils.http.callback;

public class FileDownloadHandler {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r19.updateProgress(r11, r9, true) == false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File handleEntity(org.apache.http.HttpEntity r18, com.lidroid.xutils.http.callback.RequestCallBackHandler r19, java.lang.String r20, boolean r21, java.lang.String r22) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r20
            r7 = r22
            r2 = 0
            if (r18 == 0) goto L_0x00fc
            boolean r4 = android.text.TextUtils.isEmpty(r20)
            if (r4 == 0) goto L_0x000e
            return r2
        L_0x000e:
            java.io.File r8 = new java.io.File
            r8.<init>(r1)
            boolean r4 = r8.exists()
            if (r4 != 0) goto L_0x002c
            java.io.File r4 = r8.getParentFile()
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x0029
            boolean r4 = r4.mkdirs()
            if (r4 == 0) goto L_0x002c
        L_0x0029:
            r8.createNewFile()
        L_0x002c:
            r4 = 0
            if (r21 == 0) goto L_0x0040
            long r4 = r8.length()     // Catch:{ all -> 0x003b }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x003b }
            r9 = 1
            r6.<init>(r1, r9)     // Catch:{ all -> 0x003b }
            goto L_0x0045
        L_0x003b:
            r0 = move-exception
            r1 = r0
            r13 = r2
            goto L_0x00f5
        L_0x0040:
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x003b }
            r6.<init>(r1)     // Catch:{ all -> 0x003b }
        L_0x0045:
            r9 = r4
            long r4 = r18.getContentLength()     // Catch:{ all -> 0x003b }
            r1 = 0
            long r11 = r4 + r9
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ all -> 0x003b }
            java.io.InputStream r1 = r18.getContent()     // Catch:{ all -> 0x003b }
            r13.<init>(r1)     // Catch:{ all -> 0x003b }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f3 }
            r14.<init>(r6)     // Catch:{ all -> 0x00f3 }
            if (r19 == 0) goto L_0x0074
            r6 = 1
            r1 = r19
            r2 = r11
            r4 = r9
            boolean r1 = r1.updateProgress(r2, r4, r6)     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x0074
        L_0x0068:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r13)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r14)
            return r8
        L_0x006f:
            r0 = move-exception
            r1 = r0
            r2 = r14
            goto L_0x00f5
        L_0x0074:
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r1]     // Catch:{ all -> 0x006f }
            r4 = r9
        L_0x0079:
            int r1 = r13.read(r6)     // Catch:{ all -> 0x006f }
            r2 = -1
            if (r1 != r2) goto L_0x00d4
            r14.flush()     // Catch:{ all -> 0x006f }
            if (r19 == 0) goto L_0x008c
            r6 = 1
            r1 = r19
            r2 = r11
            r1.updateProgress(r2, r4, r6)     // Catch:{ all -> 0x006f }
        L_0x008c:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r13)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r14)
            boolean r1 = r8.exists()
            if (r1 == 0) goto L_0x00d3
            boolean r1 = android.text.TextUtils.isEmpty(r22)
            if (r1 != 0) goto L_0x00d3
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r8.getParent()
            r1.<init>(r2, r7)
        L_0x00a7:
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x00b5
            boolean r2 = r8.renameTo(r1)
            if (r2 == 0) goto L_0x00b4
            return r1
        L_0x00b4:
            return r8
        L_0x00b5:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r8.getParent()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            goto L_0x00a7
        L_0x00d3:
            return r8
        L_0x00d4:
            r2 = 0
            r14.write(r6, r2, r1)     // Catch:{ all -> 0x006f }
            long r1 = (long) r1     // Catch:{ all -> 0x006f }
            long r9 = r4 + r1
            if (r19 == 0) goto L_0x00ed
            r15 = 0
            r1 = r19
            r2 = r11
            r4 = r9
            r16 = r6
            r6 = r15
            boolean r1 = r1.updateProgress(r2, r4, r6)     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x00ef
            goto L_0x0068
        L_0x00ed:
            r16 = r6
        L_0x00ef:
            r4 = r9
            r6 = r16
            goto L_0x0079
        L_0x00f3:
            r0 = move-exception
            r1 = r0
        L_0x00f5:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r13)
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            throw r1
        L_0x00fc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.callback.FileDownloadHandler.handleEntity(org.apache.http.HttpEntity, com.lidroid.xutils.http.callback.RequestCallBackHandler, java.lang.String, boolean, java.lang.String):java.io.File");
    }
}
