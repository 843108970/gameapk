package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.b;
import com.android.volley.t;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class f implements com.android.volley.b {
    private static final int e = 5242880;
    private static final float f = 0.9f;
    private static final int g = 538248467;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f527a;

    /* renamed from: b  reason: collision with root package name */
    private long f528b;

    /* renamed from: c  reason: collision with root package name */
    private final File f529c;
    private final int d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f530a;

        /* renamed from: b  reason: collision with root package name */
        public String f531b;

        /* renamed from: c  reason: collision with root package name */
        public String f532c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h;

        private a() {
        }

        public a(String str, b.a aVar) {
            this.f531b = str;
            this.f530a = (long) aVar.f463a.length;
            this.f532c = aVar.f464b;
            this.d = aVar.f465c;
            this.e = aVar.d;
            this.f = aVar.e;
            this.g = aVar.f;
            this.h = aVar.g;
        }

        private b.a a(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f463a = bArr;
            aVar.f464b = this.f532c;
            aVar.f465c = this.d;
            aVar.d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            aVar.g = this.h;
            return aVar;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (f.a(inputStream) != f.g) {
                throw new IOException();
            }
            aVar.f531b = f.c(inputStream);
            aVar.f532c = f.c(inputStream);
            if (aVar.f532c.equals("")) {
                aVar.f532c = null;
            }
            aVar.d = f.b(inputStream);
            aVar.e = f.b(inputStream);
            aVar.f = f.b(inputStream);
            aVar.g = f.b(inputStream);
            aVar.h = f.d(inputStream);
            return aVar;
        }

        public final boolean a(OutputStream outputStream) {
            try {
                f.a(outputStream, (int) f.g);
                f.a(outputStream, this.f531b);
                f.a(outputStream, this.f532c == null ? "" : this.f532c);
                f.a(outputStream, this.d);
                f.a(outputStream, this.e);
                f.a(outputStream, this.f);
                f.a(outputStream, this.g);
                Map<String, String> map = this.h;
                if (map != null) {
                    f.a(outputStream, map.size());
                    for (Map.Entry next : map.entrySet()) {
                        f.a(outputStream, (String) next.getKey());
                        f.a(outputStream, (String) next.getValue());
                    }
                } else {
                    f.a(outputStream, 0);
                }
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                t.b("%s", e2.toString());
                return false;
            }
        }
    }

    private static class b extends FilterInputStream {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f533a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.f533a = 0;
        }

        /* synthetic */ b(InputStream inputStream, byte b2) {
            this(inputStream);
        }

        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f533a++;
            }
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f533a += read;
            }
            return read;
        }
    }

    private f(File file) {
        this.f527a = new LinkedHashMap(16, 0.75f, true);
        this.f528b = 0;
        this.f529c = file;
        this.d = e;
    }

    public f(File file, byte b2) {
        this(file);
    }

    static int a(InputStream inputStream) throws IOException {
        return (e(inputStream) << 24) | (e(inputStream) << 0) | 0 | (e(inputStream) << 8) | (e(inputStream) << 16);
    }

    private void a(int i) {
        long j;
        long j2;
        long j3 = (long) i;
        if (this.f528b + j3 >= ((long) this.d)) {
            if (t.f504b) {
                t.a("Pruning old cache entries.", new Object[0]);
            }
            long j4 = this.f528b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, a>> it = this.f527a.entrySet().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    j = elapsedRealtime;
                    break;
                }
                a aVar = (a) it.next().getValue();
                if (d(aVar.f531b).delete()) {
                    j2 = j3;
                    j = elapsedRealtime;
                    this.f528b -= aVar.f530a;
                } else {
                    j2 = j3;
                    j = elapsedRealtime;
                    t.b("Could not delete cache entry for key=%s, filename=%s", aVar.f531b, c(aVar.f531b));
                }
                it.remove();
                i2++;
                if (((float) (this.f528b + j2)) < ((float) this.d) * f) {
                    break;
                }
                j3 = j2;
                elapsedRealtime = j;
            }
            if (t.f504b) {
                t.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f528b - j4), Long.valueOf(SystemClock.elapsedRealtime() - j));
            }
        }
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void a(String str, a aVar) {
        if (!this.f527a.containsKey(str)) {
            this.f528b += aVar.f530a;
        } else {
            this.f528b += aVar.f530a - this.f527a.get(str).f530a;
        }
        this.f527a.put(str, aVar);
    }

    private static void a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            a(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                a(outputStream, (String) next.getKey());
                a(outputStream, (String) next.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static long b(InputStream inputStream) throws IOException {
        return ((((long) e(inputStream)) & 255) << 0) | 0 | ((((long) e(inputStream)) & 255) << 8) | ((((long) e(inputStream)) & 255) << 16) | ((((long) e(inputStream)) & 255) << 24) | ((((long) e(inputStream)) & 255) << 32) | ((((long) e(inputStream)) & 255) << 40) | ((((long) e(inputStream)) & 255) << 48) | ((((long) e(inputStream)) & 255) << 56);
    }

    static String c(InputStream inputStream) throws IOException {
        return new String(a(inputStream, (int) b(inputStream)), "UTF-8");
    }

    private static String c(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private File d(String str) {
        return new File(this.f529c, c(str));
    }

    static Map<String, String> d(InputStream inputStream) throws IOException {
        int a2 = a(inputStream);
        Map<String, String> emptyMap = a2 == 0 ? Collections.emptyMap() : new HashMap<>(a2);
        for (int i = 0; i < a2; i++) {
            emptyMap.put(c(inputStream).intern(), c(inputStream).intern());
        }
        return emptyMap;
    }

    private static int e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private void e(String str) {
        a aVar = this.f527a.get(str);
        if (aVar != null) {
            this.f528b -= aVar.f530a;
            this.f527a.remove(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x007c A[SYNTHETIC, Splitter:B:30:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0087 A[SYNTHETIC, Splitter:B:39:0x0087] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.android.volley.b.a a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.Map<java.lang.String, com.android.volley.toolbox.f$a> r0 = r11.f527a     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x008e }
            com.android.volley.toolbox.f$a r0 = (com.android.volley.toolbox.f.a) r0     // Catch:{ all -> 0x008e }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r11)
            return r1
        L_0x000e:
            java.io.File r2 = r11.d((java.lang.String) r12)     // Catch:{ all -> 0x008e }
            r3 = 0
            com.android.volley.toolbox.f$b r4 = new com.android.volley.toolbox.f$b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            r4.<init>(r5, r3)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            com.android.volley.toolbox.f.a.a((java.io.InputStream) r4)     // Catch:{ IOException -> 0x005b }
            long r5 = r2.length()     // Catch:{ IOException -> 0x005b }
            int r7 = r4.f533a     // Catch:{ IOException -> 0x005b }
            long r7 = (long) r7     // Catch:{ IOException -> 0x005b }
            long r9 = r5 - r7
            int r5 = (int) r9     // Catch:{ IOException -> 0x005b }
            byte[] r5 = a((java.io.InputStream) r4, (int) r5)     // Catch:{ IOException -> 0x005b }
            com.android.volley.b$a r6 = new com.android.volley.b$a     // Catch:{ IOException -> 0x005b }
            r6.<init>()     // Catch:{ IOException -> 0x005b }
            r6.f463a = r5     // Catch:{ IOException -> 0x005b }
            java.lang.String r5 = r0.f532c     // Catch:{ IOException -> 0x005b }
            r6.f464b = r5     // Catch:{ IOException -> 0x005b }
            long r7 = r0.d     // Catch:{ IOException -> 0x005b }
            r6.f465c = r7     // Catch:{ IOException -> 0x005b }
            long r7 = r0.e     // Catch:{ IOException -> 0x005b }
            r6.d = r7     // Catch:{ IOException -> 0x005b }
            long r7 = r0.f     // Catch:{ IOException -> 0x005b }
            r6.e = r7     // Catch:{ IOException -> 0x005b }
            long r7 = r0.g     // Catch:{ IOException -> 0x005b }
            r6.f = r7     // Catch:{ IOException -> 0x005b }
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.h     // Catch:{ IOException -> 0x005b }
            r6.g = r0     // Catch:{ IOException -> 0x005b }
            r4.close()     // Catch:{ IOException -> 0x0059 }
            monitor-exit(r11)
            return r6
        L_0x0059:
            monitor-exit(r11)
            return r1
        L_0x005b:
            r0 = move-exception
            goto L_0x0062
        L_0x005d:
            r12 = move-exception
            r4 = r1
            goto L_0x0085
        L_0x0060:
            r0 = move-exception
            r4 = r1
        L_0x0062:
            java.lang.String r5 = "%s: %s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0084 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0084 }
            r6[r3] = r2     // Catch:{ all -> 0x0084 }
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0084 }
            r6[r2] = r0     // Catch:{ all -> 0x0084 }
            com.android.volley.t.b(r5, r6)     // Catch:{ all -> 0x0084 }
            r11.b((java.lang.String) r12)     // Catch:{ all -> 0x0084 }
            if (r4 == 0) goto L_0x0082
            r4.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0082
        L_0x0080:
            monitor-exit(r11)
            return r1
        L_0x0082:
            monitor-exit(r11)
            return r1
        L_0x0084:
            r12 = move-exception
        L_0x0085:
            if (r4 == 0) goto L_0x008d
            r4.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008d
        L_0x008b:
            monitor-exit(r11)
            return r1
        L_0x008d:
            throw r12     // Catch:{ all -> 0x008e }
        L_0x008e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.f.a(java.lang.String):com.android.volley.b$a");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:25|26|(2:35|36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0063 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a A[SYNTHETIC, Splitter:B:32:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066 A[SYNTHETIC, Splitter:B:40:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.File r0 = r8.f529c     // Catch:{ all -> 0x006e }
            boolean r0 = r0.exists()     // Catch:{ all -> 0x006e }
            r1 = 0
            if (r0 != 0) goto L_0x0024
            java.io.File r0 = r8.f529c     // Catch:{ all -> 0x006e }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x0022
            java.lang.String r0 = "Unable to create cache dir %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x006e }
            java.io.File r3 = r8.f529c     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006e }
            r2[r1] = r3     // Catch:{ all -> 0x006e }
            com.android.volley.t.c(r0, r2)     // Catch:{ all -> 0x006e }
        L_0x0022:
            monitor-exit(r8)
            return
        L_0x0024:
            java.io.File r0 = r8.f529c     // Catch:{ all -> 0x006e }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x002e
            monitor-exit(r8)
            return
        L_0x002e:
            int r2 = r0.length     // Catch:{ all -> 0x006e }
        L_0x002f:
            if (r1 >= r2) goto L_0x006c
            r3 = r0[r1]     // Catch:{ all -> 0x006e }
            r4 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0058 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0058 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0058 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0058 }
            com.android.volley.toolbox.f$a r4 = com.android.volley.toolbox.f.a.a((java.io.InputStream) r5)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            long r6 = r3.length()     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r4.f530a = r6     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            java.lang.String r6 = r4.f531b     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r8.a((java.lang.String) r6, (com.android.volley.toolbox.f.a) r4)     // Catch:{ IOException -> 0x0054, all -> 0x0051 }
            r5.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0069
        L_0x0051:
            r0 = move-exception
            r4 = r5
            goto L_0x005e
        L_0x0054:
            r4 = r5
            goto L_0x0058
        L_0x0056:
            r0 = move-exception
            goto L_0x005e
        L_0x0058:
            if (r3 == 0) goto L_0x0064
            r3.delete()     // Catch:{ all -> 0x0056 }
            goto L_0x0064
        L_0x005e:
            if (r4 == 0) goto L_0x0063
            r4.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            throw r0     // Catch:{ all -> 0x006e }
        L_0x0064:
            if (r4 == 0) goto L_0x0069
            r4.close()     // Catch:{ IOException -> 0x0069 }
        L_0x0069:
            int r1 = r1 + 1
            goto L_0x002f
        L_0x006c:
            monitor-exit(r8)
            return
        L_0x006e:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.f.a():void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:33|34|(1:36)|37|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010d, code lost:
        if (r3.delete() == false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010f, code lost:
        com.android.volley.t.b("Could not clean up file %s", r3.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011f, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0109 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r20, com.android.volley.b.a r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            monitor-enter(r19)
            byte[] r4 = r3.f463a     // Catch:{ all -> 0x0120 }
            int r4 = r4.length     // Catch:{ all -> 0x0120 }
            long r5 = r1.f528b     // Catch:{ all -> 0x0120 }
            long r7 = (long) r4     // Catch:{ all -> 0x0120 }
            long r9 = r5 + r7
            int r4 = r1.d     // Catch:{ all -> 0x0120 }
            long r4 = (long) r4     // Catch:{ all -> 0x0120 }
            int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            r5 = 0
            if (r6 < 0) goto L_0x00c9
            boolean r6 = com.android.volley.t.f504b     // Catch:{ all -> 0x0120 }
            if (r6 == 0) goto L_0x0022
            java.lang.String r6 = "Pruning old cache entries."
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ all -> 0x0120 }
            com.android.volley.t.a(r6, r9)     // Catch:{ all -> 0x0120 }
        L_0x0022:
            long r9 = r1.f528b     // Catch:{ all -> 0x0120 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0120 }
            java.util.Map<java.lang.String, com.android.volley.toolbox.f$a> r6 = r1.f527a     // Catch:{ all -> 0x0120 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0120 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0120 }
            r13 = 0
        L_0x0033:
            boolean r14 = r6.hasNext()     // Catch:{ all -> 0x0120 }
            r15 = 2
            if (r14 == 0) goto L_0x009b
            java.lang.Object r14 = r6.next()     // Catch:{ all -> 0x0120 }
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14     // Catch:{ all -> 0x0120 }
            java.lang.Object r14 = r14.getValue()     // Catch:{ all -> 0x0120 }
            com.android.volley.toolbox.f$a r14 = (com.android.volley.toolbox.f.a) r14     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = r14.f531b     // Catch:{ all -> 0x0120 }
            java.io.File r4 = r1.d((java.lang.String) r4)     // Catch:{ all -> 0x0120 }
            boolean r4 = r4.delete()     // Catch:{ all -> 0x0120 }
            if (r4 == 0) goto L_0x0062
            r16 = r6
            long r5 = r1.f528b     // Catch:{ all -> 0x0120 }
            long r3 = r14.f530a     // Catch:{ all -> 0x0120 }
            r14 = 0
            r17 = r11
            long r11 = r5 - r3
            r1.f528b = r11     // Catch:{ all -> 0x0120 }
        L_0x005f:
            r3 = r16
            goto L_0x007c
        L_0x0062:
            r16 = r6
            r17 = r11
            java.lang.String r3 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.Object[] r4 = new java.lang.Object[r15]     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r14.f531b     // Catch:{ all -> 0x0120 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = r14.f531b     // Catch:{ all -> 0x0120 }
            java.lang.String r5 = c((java.lang.String) r5)     // Catch:{ all -> 0x0120 }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x0120 }
            com.android.volley.t.b(r3, r4)     // Catch:{ all -> 0x0120 }
            goto L_0x005f
        L_0x007c:
            r3.remove()     // Catch:{ all -> 0x0120 }
            int r13 = r13 + 1
            long r4 = r1.f528b     // Catch:{ all -> 0x0120 }
            r6 = 0
            long r11 = r4 + r7
            float r4 = (float) r11     // Catch:{ all -> 0x0120 }
            int r5 = r1.d     // Catch:{ all -> 0x0120 }
            float r5 = (float) r5     // Catch:{ all -> 0x0120 }
            r6 = 1063675494(0x3f666666, float:0.9)
            float r5 = r5 * r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0094
            goto L_0x009d
        L_0x0094:
            r6 = r3
            r11 = r17
            r3 = r21
            r5 = 0
            goto L_0x0033
        L_0x009b:
            r17 = r11
        L_0x009d:
            boolean r3 = com.android.volley.t.f504b     // Catch:{ all -> 0x0120 }
            if (r3 == 0) goto L_0x00c9
            java.lang.String r3 = "pruned %d files, %d bytes, %d ms"
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0120 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0120 }
            r6 = 0
            r4[r6] = r5     // Catch:{ all -> 0x0120 }
            long r5 = r1.f528b     // Catch:{ all -> 0x0120 }
            r7 = 0
            long r7 = r5 - r9
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0120 }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x0120 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0120 }
            r7 = 0
            long r7 = r5 - r17
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0120 }
            r4[r15] = r5     // Catch:{ all -> 0x0120 }
            com.android.volley.t.a(r3, r4)     // Catch:{ all -> 0x0120 }
        L_0x00c9:
            java.io.File r3 = r19.d((java.lang.String) r20)     // Catch:{ all -> 0x0120 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0109 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0109 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0109 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0109 }
            com.android.volley.toolbox.f$a r5 = new com.android.volley.toolbox.f$a     // Catch:{ IOException -> 0x0109 }
            r6 = r21
            r5.<init>(r2, r6)     // Catch:{ IOException -> 0x0109 }
            boolean r7 = r5.a((java.io.OutputStream) r4)     // Catch:{ IOException -> 0x0109 }
            if (r7 != 0) goto L_0x00fc
            r4.close()     // Catch:{ IOException -> 0x0109 }
            java.lang.String r2 = "Failed to write header for %s"
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x0109 }
            java.lang.String r4 = r3.getAbsolutePath()     // Catch:{ IOException -> 0x0109 }
            r6 = 0
            r5[r6] = r4     // Catch:{ IOException -> 0x0109 }
            com.android.volley.t.b(r2, r5)     // Catch:{ IOException -> 0x0109 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0109 }
            r2.<init>()     // Catch:{ IOException -> 0x0109 }
            throw r2     // Catch:{ IOException -> 0x0109 }
        L_0x00fc:
            byte[] r6 = r6.f463a     // Catch:{ IOException -> 0x0109 }
            r4.write(r6)     // Catch:{ IOException -> 0x0109 }
            r4.close()     // Catch:{ IOException -> 0x0109 }
            r1.a((java.lang.String) r2, (com.android.volley.toolbox.f.a) r5)     // Catch:{ IOException -> 0x0109 }
            monitor-exit(r19)
            return
        L_0x0109:
            boolean r2 = r3.delete()     // Catch:{ all -> 0x0120 }
            if (r2 != 0) goto L_0x011e
            java.lang.String r2 = "Could not clean up file %s"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0120 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0120 }
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x0120 }
            com.android.volley.t.b(r2, r4)     // Catch:{ all -> 0x0120 }
        L_0x011e:
            monitor-exit(r19)
            return
        L_0x0120:
            r0 = move-exception
            r2 = r0
            monitor-exit(r19)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.f.a(java.lang.String, com.android.volley.b$a):void");
    }

    public final synchronized void a(String str, boolean z) {
        b.a a2 = a(str);
        if (a2 != null) {
            a2.f = 0;
            if (z) {
                a2.e = 0;
            }
            a(str, a2);
        }
    }

    public final synchronized void b() {
        File[] listFiles = this.f529c.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        this.f527a.clear();
        this.f528b = 0;
        t.b("Cache cleared.", new Object[0]);
    }

    public final synchronized void b(String str) {
        boolean delete = d(str).delete();
        a aVar = this.f527a.get(str);
        if (aVar != null) {
            this.f528b -= aVar.f530a;
            this.f527a.remove(str);
        }
        if (!delete) {
            t.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }
}
