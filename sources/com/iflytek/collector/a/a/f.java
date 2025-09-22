package com.iflytek.collector.a.a;

import com.iflytek.voiceads.config.SDKLogger;

public class f {
    private static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] a(byte[] bArr) {
        try {
            byte[] encoded = a.a().getEncoded();
            byte[] a2 = bArr != null ? a.a(b(bArr), encoded) : null;
            byte[] a3 = h.a(encoded, h.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt8H0BF3SquJmk6xIo2bTldgvtazLIeSbR4cle\np7zeUAtI/mC7UgFl8xXFCTemVambyQFnM5GsZOI1BpAMJO7N/YHRX7hvCZG6D0rEXQEdKXhKFIBQ\nmOYRYZP042vWRcKZ6iQLdLYmyg6tIzjYVfH0f6YX8OLIU7fy0TA/c88rzwIDAQAB"));
            if (a3 == null || a2 == null) {
                return null;
            }
            int length = a3.length;
            int length2 = a2.length;
            byte[] bArr2 = new byte[(length + length2 + 10)];
            bArr2[0] = 1;
            System.arraycopy(a(length), 0, bArr2, 1, 4);
            System.arraycopy(a3, 0, bArr2, 5, length);
            int i = length + 5;
            bArr2[i] = 3;
            int i2 = i + 1;
            System.arraycopy(a(length2), 0, bArr2, i2, 4);
            System.arraycopy(a2, 0, bArr2, i2 + 4, length2);
            return bArr2;
        } catch (Exception unused) {
            SDKLogger.e("Collector", "encrypt error");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0039 A[SYNTHETIC, Splitter:B:25:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004b A[SYNTHETIC, Splitter:B:35:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(byte[] r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0032, all -> 0x002f }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0032, all -> 0x002f }
            r2.write(r4)     // Catch:{ IOException -> 0x002d }
            r2.finish()     // Catch:{ IOException -> 0x002d }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x002d }
            r3 = 19
            if (r4 >= r3) goto L_0x001d
            r2.flush()     // Catch:{ IOException -> 0x002d }
        L_0x001d:
            byte[] r4 = r1.toByteArray()     // Catch:{ IOException -> 0x002d }
            r2.close()     // Catch:{ IOException -> 0x0028 }
            r1.close()     // Catch:{ IOException -> 0x0028 }
            return r4
        L_0x0028:
            r0 = move-exception
            r0.printStackTrace()
            return r4
        L_0x002d:
            r4 = move-exception
            goto L_0x0034
        L_0x002f:
            r4 = move-exception
            r2 = r0
            goto L_0x0049
        L_0x0032:
            r4 = move-exception
            r2 = r0
        L_0x0034:
            r4.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x003f
            r2.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r4 = move-exception
            goto L_0x0043
        L_0x003f:
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0046
        L_0x0043:
            r4.printStackTrace()
        L_0x0046:
            r4 = r0
            return r4
        L_0x0048:
            r4 = move-exception
        L_0x0049:
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0051
        L_0x004f:
            r0 = move-exception
            goto L_0x0055
        L_0x0051:
            r1.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0058
        L_0x0055:
            r0.printStackTrace()
        L_0x0058:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.collector.a.a.f.b(byte[]):byte[]");
    }
}
