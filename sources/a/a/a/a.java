package a.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class a {
    private static String a(String str) throws RuntimeException {
        try {
            return new String(a(str.getBytes()), "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII is not supported!", e);
        }
    }

    private static String a(String str, String str2) throws RuntimeException {
        try {
            try {
                return new String(a(str.getBytes(str2)), "ASCII");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("ASCII is not supported!", e);
            }
        } catch (UnsupportedEncodingException e2) {
            StringBuffer stringBuffer = new StringBuffer("Unsupported charset: ");
            stringBuffer.append(str2);
            throw new RuntimeException(stringBuffer.toString(), e2);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x001f A[SYNTHETIC, Splitter:B:19:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0024 A[SYNTHETIC, Splitter:B:23:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.File r2, java.io.File r3) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x001b }
            r1.<init>(r2)     // Catch:{ all -> 0x001b }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0019 }
            r2.<init>(r3)     // Catch:{ all -> 0x0019 }
            r3 = 0
            a((java.io.InputStream) r1, (java.io.OutputStream) r2, (int) r3)     // Catch:{ all -> 0x0016 }
            r2.close()     // Catch:{ Throwable -> 0x0012 }
        L_0x0012:
            r1.close()     // Catch:{ Throwable -> 0x0015 }
        L_0x0015:
            return
        L_0x0016:
            r3 = move-exception
            r0 = r2
            goto L_0x001d
        L_0x0019:
            r3 = move-exception
            goto L_0x001d
        L_0x001b:
            r3 = move-exception
            r1 = r0
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.close()     // Catch:{ Throwable -> 0x0022 }
        L_0x0022:
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ Throwable -> 0x0027 }
        L_0x0027:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a(java.io.File, java.io.File):void");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001e A[SYNTHETIC, Splitter:B:18:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0023 A[SYNTHETIC, Splitter:B:22:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.File r2, java.io.File r3, int r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x001a }
            r1.<init>(r2)     // Catch:{ all -> 0x001a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0018 }
            r2.<init>(r3)     // Catch:{ all -> 0x0018 }
            a((java.io.InputStream) r1, (java.io.OutputStream) r2, (int) r4)     // Catch:{ all -> 0x0015 }
            r2.close()     // Catch:{ Throwable -> 0x0011 }
        L_0x0011:
            r1.close()     // Catch:{ Throwable -> 0x0014 }
        L_0x0014:
            return
        L_0x0015:
            r3 = move-exception
            r0 = r2
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            r1 = r0
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Throwable -> 0x0021 }
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a(java.io.File, java.io.File, int):void");
    }

    private static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        a(inputStream, outputStream, 0);
    }

    private static void a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        c cVar = new c(outputStream, i);
        c(inputStream, cVar);
        cVar.a();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r4) throws java.lang.RuntimeException {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r4)
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            r1 = 0
            a((java.io.InputStream) r0, (java.io.OutputStream) r4, (int) r1)     // Catch:{ IOException -> 0x001b }
            r0.close()     // Catch:{ Throwable -> 0x0011 }
        L_0x0011:
            r4.close()     // Catch:{ Throwable -> 0x0014 }
        L_0x0014:
            byte[] r4 = r4.toByteArray()
            return r4
        L_0x0019:
            r1 = move-exception
            goto L_0x0024
        L_0x001b:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = "Unexpected I/O error"
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0019 }
            throw r2     // Catch:{ all -> 0x0019 }
        L_0x0024:
            r0.close()     // Catch:{ Throwable -> 0x0027 }
        L_0x0027:
            r4.close()     // Catch:{ Throwable -> 0x002a }
        L_0x002a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.a(byte[]):byte[]");
    }

    private static String b(String str) throws RuntimeException {
        try {
            return new String(b(str.getBytes("ASCII")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII is not supported!", e);
        }
    }

    private static String b(String str, String str2) throws RuntimeException {
        try {
            try {
                return new String(b(str.getBytes("ASCII")), str2);
            } catch (UnsupportedEncodingException e) {
                StringBuffer stringBuffer = new StringBuffer("Unsupported charset: ");
                stringBuffer.append(str2);
                throw new RuntimeException(stringBuffer.toString(), e);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII is not supported!", e2);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001e A[SYNTHETIC, Splitter:B:18:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0023 A[SYNTHETIC, Splitter:B:22:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(java.io.File r2, java.io.File r3) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x001a }
            r1.<init>(r2)     // Catch:{ all -> 0x001a }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0018 }
            r2.<init>(r3)     // Catch:{ all -> 0x0018 }
            b((java.io.InputStream) r1, (java.io.OutputStream) r2)     // Catch:{ all -> 0x0015 }
            r2.close()     // Catch:{ Throwable -> 0x0011 }
        L_0x0011:
            r1.close()     // Catch:{ Throwable -> 0x0014 }
        L_0x0014:
            return
        L_0x0015:
            r3 = move-exception
            r0 = r2
            goto L_0x001c
        L_0x0018:
            r3 = move-exception
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            r1 = r0
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Throwable -> 0x0021 }
        L_0x0021:
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b(java.io.File, java.io.File):void");
    }

    private static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        c(new b(inputStream), outputStream);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0026 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r4) throws java.lang.RuntimeException {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r4)
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            b((java.io.InputStream) r0, (java.io.OutputStream) r4)     // Catch:{ IOException -> 0x001a }
            r0.close()     // Catch:{ Throwable -> 0x0010 }
        L_0x0010:
            r4.close()     // Catch:{ Throwable -> 0x0013 }
        L_0x0013:
            byte[] r4 = r4.toByteArray()
            return r4
        L_0x0018:
            r1 = move-exception
            goto L_0x0023
        L_0x001a:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = "Unexpected I/O error"
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0018 }
            throw r2     // Catch:{ all -> 0x0018 }
        L_0x0023:
            r0.close()     // Catch:{ Throwable -> 0x0026 }
        L_0x0026:
            r4.close()     // Catch:{ Throwable -> 0x0029 }
        L_0x0029:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b(byte[]):byte[]");
    }

    private static void c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static byte[] c(byte[] bArr) throws RuntimeException {
        return a(bArr);
    }
}
