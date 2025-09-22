package com.bumptech.glide.b;

import com.cyjh.common.util.s;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;

public final class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final String f893a = "journal";

    /* renamed from: b  reason: collision with root package name */
    static final String f894b = "journal.tmp";

    /* renamed from: c  reason: collision with root package name */
    static final String f895c = "journal.bkp";
    static final String d = "libcore.io.DiskLruCache";
    static final String e = "1";
    static final long f = -1;
    private static final String h = "CLEAN";
    private static final String i = "DIRTY";
    private static final String j = "REMOVE";
    private static final String k = "READ";
    final ThreadPoolExecutor g = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C0008a((byte) 0));
    /* access modifiers changed from: private */
    public final File l;
    private final File m;
    private final File n;
    private final File o;
    private final int p;
    private long q;
    /* access modifiers changed from: private */
    public final int r;
    private long s = 0;
    /* access modifiers changed from: private */
    public Writer t;
    private final LinkedHashMap<String, c> u = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int v;
    private long w = 0;
    private final Callable<Void> x = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r3 = this;
                com.bumptech.glide.b.a r0 = com.bumptech.glide.b.a.this
                monitor-enter(r0)
                com.bumptech.glide.b.a r1 = com.bumptech.glide.b.a.this     // Catch:{ all -> 0x0027 }
                java.io.Writer r1 = r1.t     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000e:
                com.bumptech.glide.b.a r1 = com.bumptech.glide.b.a.this     // Catch:{ all -> 0x0027 }
                r1.l()     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.b.a r1 = com.bumptech.glide.b.a.this     // Catch:{ all -> 0x0027 }
                boolean r1 = r1.h()     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0025
                com.bumptech.glide.b.a r1 = com.bumptech.glide.b.a.this     // Catch:{ all -> 0x0027 }
                r1.d()     // Catch:{ all -> 0x0027 }
                com.bumptech.glide.b.a r1 = com.bumptech.glide.b.a.this     // Catch:{ all -> 0x0027 }
                int unused = r1.v = 0     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a.AnonymousClass1.call():java.lang.Void");
        }
    };

    /* renamed from: com.bumptech.glide.b.a$a  reason: collision with other inner class name */
    private static final class C0008a implements ThreadFactory {
        private C0008a() {
        }

        /* synthetic */ C0008a(byte b2) {
            this();
        }

        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class b {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public final c f897a;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f898b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f899c;

        private b(c cVar) {
            this.f897a = cVar;
            this.f898b = cVar.e ? null : new boolean[a.this.r];
        }

        /* synthetic */ b(a aVar, c cVar, byte b2) {
            this(cVar);
        }

        private void a(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(a(i)), c.f911b);
                try {
                    outputStreamWriter2.write(str);
                    c.a((Closeable) outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    c.a((Closeable) outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                c.a((Closeable) outputStreamWriter);
                throw th;
            }
        }

        private InputStream b(int i) throws IOException {
            synchronized (a.this) {
                if (this.f897a.f != this) {
                    throw new IllegalStateException();
                } else if (!this.f897a.e) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.f897a.f902c[i]);
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        private String c(int i) throws IOException {
            InputStream b2 = b(i);
            if (b2 != null) {
                return c.a((Reader) new InputStreamReader(b2, c.f911b));
            }
            return null;
        }

        private void c() throws IOException {
            a.this.a(this, true);
            this.f899c = true;
        }

        public final File a(int i) throws IOException {
            File file;
            synchronized (a.this) {
                if (this.f897a.f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f897a.e) {
                    this.f898b[i] = true;
                }
                file = this.f897a.d[i];
                if (!a.this.l.exists()) {
                    a.this.l.mkdirs();
                }
            }
            return file;
        }

        public final void a() throws IOException {
            a.this.a(this, false);
        }

        public final void b() {
            if (!this.f899c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }
    }

    private final class c {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public final String f900a;
        /* access modifiers changed from: package-private */

        /* renamed from: b  reason: collision with root package name */
        public final long[] f901b;

        /* renamed from: c  reason: collision with root package name */
        File[] f902c;
        File[] d;
        /* access modifiers changed from: package-private */
        public boolean e;
        /* access modifiers changed from: package-private */
        public b f;
        /* access modifiers changed from: package-private */
        public long g;

        private c(String str) {
            this.f900a = str;
            this.f901b = new long[a.this.r];
            this.f902c = new File[a.this.r];
            this.d = new File[a.this.r];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i = 0; i < a.this.r; i++) {
                sb.append(i);
                this.f902c[i] = new File(a.this.l, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(a.this.l, sb.toString());
                sb.setLength(length);
            }
        }

        /* synthetic */ c(a aVar, String str, byte b2) {
            this(str);
        }

        private File a(int i) {
            return this.f902c[i];
        }

        private static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length != a.this.r) {
                throw b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    cVar.f901b[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private File b(int i) {
            return this.d[i];
        }

        private static IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f901b) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public final void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.r) {
                throw b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f901b[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }
    }

    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final File[] f903a;

        /* renamed from: c  reason: collision with root package name */
        private final String f905c;
        private final long d;
        private final long[] e;

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f905c = str;
            this.d = j;
            this.f903a = fileArr;
            this.e = jArr;
        }

        /* synthetic */ d(a aVar, String str, long j, File[] fileArr, long[] jArr, byte b2) {
            this(str, j, fileArr, jArr);
        }

        private b a() throws IOException {
            return a.this.a(this.f905c, this.d);
        }

        private String a(int i) throws IOException {
            return c.a((Reader) new InputStreamReader(new FileInputStream(this.f903a[i]), c.f911b));
        }

        private long b(int i) {
            return this.e[i];
        }

        private File b() {
            return this.f903a[0];
        }
    }

    private a(File file, long j2) {
        File file2 = file;
        this.l = file2;
        this.p = 1;
        this.m = new File(file2, f893a);
        this.n = new File(file2, f894b);
        this.o = new File(file2, f895c);
        this.r = 1;
        this.q = j2;
    }

    public static a a(File file, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, f895c);
        if (file2.exists()) {
            File file3 = new File(file, f893a);
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, j2);
        if (aVar.m.exists()) {
            try {
                aVar.b();
                aVar.c();
                return aVar;
            } catch (IOException e2) {
                PrintStream printStream = System.out;
                printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                aVar.a();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, j2);
        aVar2.d();
        return aVar2;
    }

    private synchronized void a(long j2) {
        this.q = j2;
        this.g.submit(this.x);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bumptech.glide.b.a.b r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            com.bumptech.glide.b.a$c r0 = r12.f897a     // Catch:{ all -> 0x00f8 }
            com.bumptech.glide.b.a$b r1 = r0.f     // Catch:{ all -> 0x00f8 }
            if (r1 == r12) goto L_0x000d
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f8 }
            r12.<init>()     // Catch:{ all -> 0x00f8 }
            throw r12     // Catch:{ all -> 0x00f8 }
        L_0x000d:
            r1 = 0
            if (r13 == 0) goto L_0x0048
            boolean r2 = r0.e     // Catch:{ all -> 0x00f8 }
            if (r2 != 0) goto L_0x0048
            r2 = 0
        L_0x0015:
            int r3 = r11.r     // Catch:{ all -> 0x00f8 }
            if (r2 >= r3) goto L_0x0048
            boolean[] r3 = r12.f898b     // Catch:{ all -> 0x00f8 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00f8 }
            if (r3 != 0) goto L_0x0036
            r12.a()     // Catch:{ all -> 0x00f8 }
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r13.<init>(r0)     // Catch:{ all -> 0x00f8 }
            r13.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00f8 }
            r12.<init>(r13)     // Catch:{ all -> 0x00f8 }
            throw r12     // Catch:{ all -> 0x00f8 }
        L_0x0036:
            java.io.File[] r3 = r0.d     // Catch:{ all -> 0x00f8 }
            r3 = r3[r2]     // Catch:{ all -> 0x00f8 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x00f8 }
            if (r3 != 0) goto L_0x0045
            r12.a()     // Catch:{ all -> 0x00f8 }
            monitor-exit(r11)
            return
        L_0x0045:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0048:
            int r12 = r11.r     // Catch:{ all -> 0x00f8 }
            if (r1 >= r12) goto L_0x007b
            java.io.File[] r12 = r0.d     // Catch:{ all -> 0x00f8 }
            r12 = r12[r1]     // Catch:{ all -> 0x00f8 }
            if (r13 == 0) goto L_0x0075
            boolean r2 = r12.exists()     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x0078
            java.io.File[] r2 = r0.f902c     // Catch:{ all -> 0x00f8 }
            r2 = r2[r1]     // Catch:{ all -> 0x00f8 }
            r12.renameTo(r2)     // Catch:{ all -> 0x00f8 }
            long[] r12 = r0.f901b     // Catch:{ all -> 0x00f8 }
            r3 = r12[r1]     // Catch:{ all -> 0x00f8 }
            long r5 = r2.length()     // Catch:{ all -> 0x00f8 }
            long[] r12 = r0.f901b     // Catch:{ all -> 0x00f8 }
            r12[r1] = r5     // Catch:{ all -> 0x00f8 }
            long r7 = r11.s     // Catch:{ all -> 0x00f8 }
            r12 = 0
            long r9 = r7 - r3
            long r2 = r9 + r5
            r11.s = r2     // Catch:{ all -> 0x00f8 }
            goto L_0x0078
        L_0x0075:
            a((java.io.File) r12)     // Catch:{ all -> 0x00f8 }
        L_0x0078:
            int r1 = r1 + 1
            goto L_0x0048
        L_0x007b:
            int r12 = r11.v     // Catch:{ all -> 0x00f8 }
            r1 = 1
            int r12 = r12 + r1
            r11.v = r12     // Catch:{ all -> 0x00f8 }
            r12 = 0
            r0.f = r12     // Catch:{ all -> 0x00f8 }
            boolean r12 = r0.e     // Catch:{ all -> 0x00f8 }
            r12 = r12 | r13
            r2 = 10
            r3 = 32
            if (r12 == 0) goto L_0x00bd
            r0.e = r1     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = "CLEAN"
            r12.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            r12.append(r3)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = r0.f900a     // Catch:{ all -> 0x00f8 }
            r12.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x00f8 }
            r12.append(r1)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            r12.append(r2)     // Catch:{ all -> 0x00f8 }
            if (r13 == 0) goto L_0x00dc
            long r12 = r11.w     // Catch:{ all -> 0x00f8 }
            r1 = 1
            long r3 = r12 + r1
            r11.w = r3     // Catch:{ all -> 0x00f8 }
            r0.g = r12     // Catch:{ all -> 0x00f8 }
            goto L_0x00dc
        L_0x00bd:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r12 = r11.u     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = r0.f900a     // Catch:{ all -> 0x00f8 }
            r12.remove(r13)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = "REMOVE"
            r12.append(r13)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            r12.append(r3)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = r0.f900a     // Catch:{ all -> 0x00f8 }
            r12.append(r13)     // Catch:{ all -> 0x00f8 }
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            r12.append(r2)     // Catch:{ all -> 0x00f8 }
        L_0x00dc:
            java.io.Writer r12 = r11.t     // Catch:{ all -> 0x00f8 }
            r12.flush()     // Catch:{ all -> 0x00f8 }
            long r12 = r11.s     // Catch:{ all -> 0x00f8 }
            long r0 = r11.q     // Catch:{ all -> 0x00f8 }
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ef
            boolean r12 = r11.h()     // Catch:{ all -> 0x00f8 }
            if (r12 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.ThreadPoolExecutor r12 = r11.g     // Catch:{ all -> 0x00f8 }
            java.util.concurrent.Callable<java.lang.Void> r13 = r11.x     // Catch:{ all -> 0x00f8 }
            r12.submit(r13)     // Catch:{ all -> 0x00f8 }
        L_0x00f6:
            monitor-exit(r11)
            return
        L_0x00f8:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a.a(com.bumptech.glide.b.a$b, boolean):void");
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private static String b(InputStream inputStream) throws IOException {
        return c.a((Reader) new InputStreamReader(inputStream, c.f911b));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:50|51|(1:53)|(1:55)(1:56)|57|58) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r11.v = r2 - r11.u.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0114, code lost:
        if (r0.f908b == -1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0116, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0117, code lost:
        if (r1 != false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0119, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011d, code lost:
        r11.t = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r11.m, true), com.bumptech.glide.b.c.f910a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0109 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:59:0x0136=Splitter:B:59:0x0136, B:14:0x0058=Splitter:B:14:0x0058} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() throws java.io.IOException {
        /*
            r11 = this;
            com.bumptech.glide.b.b r0 = new com.bumptech.glide.b.b
            java.io.FileInputStream r1 = new java.io.FileInputStream
            java.io.File r2 = r11.m
            r1.<init>(r2)
            java.nio.charset.Charset r2 = com.bumptech.glide.b.c.f910a
            r0.<init>(r1, r2)
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x0167 }
            java.lang.String r2 = r0.a()     // Catch:{ all -> 0x0167 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = r0.a()     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r0.a()     // Catch:{ all -> 0x0167 }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0167 }
            if (r6 == 0) goto L_0x0136
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0167 }
            if (r6 == 0) goto L_0x0136
            int r6 = r11.p     // Catch:{ all -> 0x0167 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0167 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x0136
            int r3 = r11.r     // Catch:{ all -> 0x0167 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0167 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x0136
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0167 }
            if (r3 != 0) goto L_0x0054
            goto L_0x0136
        L_0x0054:
            r1 = 0
            r2 = 0
        L_0x0056:
            r3 = 1
            r4 = -1
            java.lang.String r5 = r0.a()     // Catch:{ EOFException -> 0x0109 }
            r6 = 32
            int r7 = r5.indexOf(r6)     // Catch:{ EOFException -> 0x0109 }
            if (r7 != r4) goto L_0x0078
            java.io.IOException r6 = new java.io.IOException     // Catch:{ EOFException -> 0x0109 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0109 }
            java.lang.String r8 = "unexpected journal line: "
            r7.<init>(r8)     // Catch:{ EOFException -> 0x0109 }
            r7.append(r5)     // Catch:{ EOFException -> 0x0109 }
            java.lang.String r5 = r7.toString()     // Catch:{ EOFException -> 0x0109 }
            r6.<init>(r5)     // Catch:{ EOFException -> 0x0109 }
            throw r6     // Catch:{ EOFException -> 0x0109 }
        L_0x0078:
            int r8 = r7 + 1
            int r6 = r5.indexOf(r6, r8)     // Catch:{ EOFException -> 0x0109 }
            if (r6 != r4) goto L_0x0095
            java.lang.String r8 = r5.substring(r8)     // Catch:{ EOFException -> 0x0109 }
            r9 = 6
            if (r7 != r9) goto L_0x0099
            java.lang.String r9 = "REMOVE"
            boolean r9 = r5.startsWith(r9)     // Catch:{ EOFException -> 0x0109 }
            if (r9 == 0) goto L_0x0099
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r5 = r11.u     // Catch:{ EOFException -> 0x0109 }
            r5.remove(r8)     // Catch:{ EOFException -> 0x0109 }
            goto L_0x00f1
        L_0x0095:
            java.lang.String r8 = r5.substring(r8, r6)     // Catch:{ EOFException -> 0x0109 }
        L_0x0099:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r9 = r11.u     // Catch:{ EOFException -> 0x0109 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ EOFException -> 0x0109 }
            com.bumptech.glide.b.a$c r9 = (com.bumptech.glide.b.a.c) r9     // Catch:{ EOFException -> 0x0109 }
            if (r9 != 0) goto L_0x00ad
            com.bumptech.glide.b.a$c r9 = new com.bumptech.glide.b.a$c     // Catch:{ EOFException -> 0x0109 }
            r9.<init>(r11, r8, r1)     // Catch:{ EOFException -> 0x0109 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r10 = r11.u     // Catch:{ EOFException -> 0x0109 }
            r10.put(r8, r9)     // Catch:{ EOFException -> 0x0109 }
        L_0x00ad:
            r8 = 5
            if (r6 == r4) goto L_0x00cf
            if (r7 != r8) goto L_0x00cf
            java.lang.String r10 = "CLEAN"
            boolean r10 = r5.startsWith(r10)     // Catch:{ EOFException -> 0x0109 }
            if (r10 == 0) goto L_0x00cf
            int r6 = r6 + 1
            java.lang.String r5 = r5.substring(r6)     // Catch:{ EOFException -> 0x0109 }
            java.lang.String r6 = " "
            java.lang.String[] r5 = r5.split(r6)     // Catch:{ EOFException -> 0x0109 }
            r9.e = r3     // Catch:{ EOFException -> 0x0109 }
            r6 = 0
            r9.f = r6     // Catch:{ EOFException -> 0x0109 }
            r9.a((java.lang.String[]) r5)     // Catch:{ EOFException -> 0x0109 }
            goto L_0x00f1
        L_0x00cf:
            if (r6 != r4) goto L_0x00e3
            if (r7 != r8) goto L_0x00e3
            java.lang.String r8 = "DIRTY"
            boolean r8 = r5.startsWith(r8)     // Catch:{ EOFException -> 0x0109 }
            if (r8 == 0) goto L_0x00e3
            com.bumptech.glide.b.a$b r5 = new com.bumptech.glide.b.a$b     // Catch:{ EOFException -> 0x0109 }
            r5.<init>(r11, r9, r1)     // Catch:{ EOFException -> 0x0109 }
            r9.f = r5     // Catch:{ EOFException -> 0x0109 }
            goto L_0x00f1
        L_0x00e3:
            if (r6 != r4) goto L_0x00f5
            r6 = 4
            if (r7 != r6) goto L_0x00f5
            java.lang.String r6 = "READ"
            boolean r6 = r5.startsWith(r6)     // Catch:{ EOFException -> 0x0109 }
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f5
        L_0x00f1:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x00f5:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ EOFException -> 0x0109 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0109 }
            java.lang.String r8 = "unexpected journal line: "
            r7.<init>(r8)     // Catch:{ EOFException -> 0x0109 }
            r7.append(r5)     // Catch:{ EOFException -> 0x0109 }
            java.lang.String r5 = r7.toString()     // Catch:{ EOFException -> 0x0109 }
            r6.<init>(r5)     // Catch:{ EOFException -> 0x0109 }
            throw r6     // Catch:{ EOFException -> 0x0109 }
        L_0x0109:
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r5 = r11.u     // Catch:{ all -> 0x0167 }
            int r5 = r5.size()     // Catch:{ all -> 0x0167 }
            int r2 = r2 - r5
            r11.v = r2     // Catch:{ all -> 0x0167 }
            int r2 = r0.f908b     // Catch:{ all -> 0x0167 }
            if (r2 != r4) goto L_0x0117
            r1 = 1
        L_0x0117:
            if (r1 == 0) goto L_0x011d
            r11.d()     // Catch:{ all -> 0x0167 }
            goto L_0x0132
        L_0x011d:
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x0167 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0167 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0167 }
            java.io.File r5 = r11.m     // Catch:{ all -> 0x0167 }
            r4.<init>(r5, r3)     // Catch:{ all -> 0x0167 }
            java.nio.charset.Charset r3 = com.bumptech.glide.b.c.f910a     // Catch:{ all -> 0x0167 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0167 }
            r1.<init>(r2)     // Catch:{ all -> 0x0167 }
            r11.t = r1     // Catch:{ all -> 0x0167 }
        L_0x0132:
            com.bumptech.glide.b.c.a((java.io.Closeable) r0)
            return
        L_0x0136:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0167 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0167 }
            java.lang.String r7 = "unexpected journal header: ["
            r6.<init>(r7)     // Catch:{ all -> 0x0167 }
            r6.append(r1)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0167 }
            r6.append(r2)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0167 }
            r6.append(r4)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0167 }
            r6.append(r5)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = "]"
            r6.append(r1)     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0167 }
            r3.<init>(r1)     // Catch:{ all -> 0x0167 }
            throw r3     // Catch:{ all -> 0x0167 }
        L_0x0167:
            r1 = move-exception
            com.bumptech.glide.b.c.a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a.b():void");
    }

    private void c() throws IOException {
        a(this.n);
        Iterator<c> it = this.u.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.r) {
                    this.s += next.f901b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.r) {
                    a(next.f902c[i2]);
                    a(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    private void c(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i2 = indexOf + 1;
        int indexOf2 = str.indexOf(32, i2);
        if (indexOf2 == -1) {
            str2 = str.substring(i2);
            if (indexOf == 6 && str.startsWith(j)) {
                this.u.remove(str2);
                return;
            }
        } else {
            str2 = str.substring(i2, indexOf2);
        }
        c cVar = this.u.get(str2);
        if (cVar == null) {
            cVar = new c(this, str2, (byte) 0);
            this.u.put(str2, cVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(h)) {
            String[] split = str.substring(indexOf2 + 1).split(s.a.f1696a);
            cVar.e = true;
            cVar.f = null;
            cVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(i)) {
            cVar.f = new b(this, cVar, (byte) 0);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(k)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private b d(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void d() throws IOException {
        String str;
        if (this.t != null) {
            this.t.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n), c.f910a));
        try {
            bufferedWriter.write(d);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.p));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.r));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c next : this.u.values()) {
                if (next.f != null) {
                    str = "DIRTY " + next.f900a + 10;
                } else {
                    str = "CLEAN " + next.f900a + next.a() + 10;
                }
                bufferedWriter.write(str);
            }
            bufferedWriter.close();
            if (this.m.exists()) {
                a(this.m, this.o, true);
            }
            a(this.n, this.m, false);
            this.o.delete();
            this.t = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.m, true), c.f910a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private File e() {
        return this.l;
    }

    private synchronized long f() {
        return this.q;
    }

    private synchronized long g() {
        return this.s;
    }

    /* access modifiers changed from: private */
    public boolean h() {
        return this.v >= 2000 && this.v >= this.u.size();
    }

    private synchronized boolean i() {
        return this.t == null;
    }

    private void j() {
        if (this.t == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized void k() throws IOException {
        j();
        l();
        this.t.flush();
    }

    /* access modifiers changed from: private */
    public void l() throws IOException {
        while (this.s > this.q) {
            b((String) this.u.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bumptech.glide.b.a.b a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.j()     // Catch:{ all -> 0x0059 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r0 = r5.u     // Catch:{ all -> 0x0059 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0059 }
            com.bumptech.glide.b.a$c r0 = (com.bumptech.glide.b.a.c) r0     // Catch:{ all -> 0x0059 }
            r1 = -1
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r1 = 0
            if (r3 == 0) goto L_0x001d
            if (r0 == 0) goto L_0x001b
            long r2 = r0.g     // Catch:{ all -> 0x0059 }
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001d
        L_0x001b:
            monitor-exit(r5)
            return r1
        L_0x001d:
            r7 = 0
            if (r0 != 0) goto L_0x002b
            com.bumptech.glide.b.a$c r0 = new com.bumptech.glide.b.a$c     // Catch:{ all -> 0x0059 }
            r0.<init>(r5, r6, r7)     // Catch:{ all -> 0x0059 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r8 = r5.u     // Catch:{ all -> 0x0059 }
            r8.put(r6, r0)     // Catch:{ all -> 0x0059 }
            goto L_0x0031
        L_0x002b:
            com.bumptech.glide.b.a$b r8 = r0.f     // Catch:{ all -> 0x0059 }
            if (r8 == 0) goto L_0x0031
            monitor-exit(r5)
            return r1
        L_0x0031:
            com.bumptech.glide.b.a$b r8 = new com.bumptech.glide.b.a$b     // Catch:{ all -> 0x0059 }
            r8.<init>(r5, r0, r7)     // Catch:{ all -> 0x0059 }
            r0.f = r8     // Catch:{ all -> 0x0059 }
            java.io.Writer r7 = r5.t     // Catch:{ all -> 0x0059 }
            java.lang.String r0 = "DIRTY"
            r7.append(r0)     // Catch:{ all -> 0x0059 }
            java.io.Writer r7 = r5.t     // Catch:{ all -> 0x0059 }
            r0 = 32
            r7.append(r0)     // Catch:{ all -> 0x0059 }
            java.io.Writer r7 = r5.t     // Catch:{ all -> 0x0059 }
            r7.append(r6)     // Catch:{ all -> 0x0059 }
            java.io.Writer r6 = r5.t     // Catch:{ all -> 0x0059 }
            r7 = 10
            r6.append(r7)     // Catch:{ all -> 0x0059 }
            java.io.Writer r6 = r5.t     // Catch:{ all -> 0x0059 }
            r6.flush()     // Catch:{ all -> 0x0059 }
            monitor-exit(r5)
            return r8
        L_0x0059:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a.a(java.lang.String, long):com.bumptech.glide.b.a$b");
    }

    public final synchronized d a(String str) throws IOException {
        j();
        c cVar = this.u.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.e) {
            return null;
        }
        for (File exists : cVar.f902c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.v++;
        this.t.append(k);
        this.t.append(' ');
        this.t.append(str);
        this.t.append(10);
        if (h()) {
            this.g.submit(this.x);
        }
        return new d(this, str, cVar.g, cVar.f902c, cVar.f901b, (byte) 0);
    }

    public final void a() throws IOException {
        close();
        c.a(this.l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0083, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            r9.j()     // Catch:{ all -> 0x0086 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r0 = r9.u     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x0086 }
            com.bumptech.glide.b.a$c r0 = (com.bumptech.glide.b.a.c) r0     // Catch:{ all -> 0x0086 }
            r1 = 0
            if (r0 == 0) goto L_0x0084
            com.bumptech.glide.b.a$b r2 = r0.f     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x0014
            goto L_0x0084
        L_0x0014:
            int r2 = r9.r     // Catch:{ all -> 0x0086 }
            if (r1 >= r2) goto L_0x0050
            java.io.File[] r2 = r0.f902c     // Catch:{ all -> 0x0086 }
            r2 = r2[r1]     // Catch:{ all -> 0x0086 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0086 }
            if (r3 == 0) goto L_0x003c
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0086 }
            if (r3 != 0) goto L_0x003c
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x0086 }
            r0.append(r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0086 }
            r10.<init>(r0)     // Catch:{ all -> 0x0086 }
            throw r10     // Catch:{ all -> 0x0086 }
        L_0x003c:
            long r2 = r9.s     // Catch:{ all -> 0x0086 }
            long[] r4 = r0.f901b     // Catch:{ all -> 0x0086 }
            r5 = r4[r1]     // Catch:{ all -> 0x0086 }
            r4 = 0
            long r7 = r2 - r5
            r9.s = r7     // Catch:{ all -> 0x0086 }
            long[] r2 = r0.f901b     // Catch:{ all -> 0x0086 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0086 }
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0050:
            int r0 = r9.v     // Catch:{ all -> 0x0086 }
            r1 = 1
            int r0 = r0 + r1
            r9.v = r0     // Catch:{ all -> 0x0086 }
            java.io.Writer r0 = r9.t     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x0086 }
            java.io.Writer r0 = r9.t     // Catch:{ all -> 0x0086 }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x0086 }
            java.io.Writer r0 = r9.t     // Catch:{ all -> 0x0086 }
            r0.append(r10)     // Catch:{ all -> 0x0086 }
            java.io.Writer r0 = r9.t     // Catch:{ all -> 0x0086 }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x0086 }
            java.util.LinkedHashMap<java.lang.String, com.bumptech.glide.b.a$c> r0 = r9.u     // Catch:{ all -> 0x0086 }
            r0.remove(r10)     // Catch:{ all -> 0x0086 }
            boolean r10 = r9.h()     // Catch:{ all -> 0x0086 }
            if (r10 == 0) goto L_0x0082
            java.util.concurrent.ThreadPoolExecutor r10 = r9.g     // Catch:{ all -> 0x0086 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r9.x     // Catch:{ all -> 0x0086 }
            r10.submit(r0)     // Catch:{ all -> 0x0086 }
        L_0x0082:
            monitor-exit(r9)
            return r1
        L_0x0084:
            monitor-exit(r9)
            return r1
        L_0x0086:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.a.b(java.lang.String):boolean");
    }

    public final synchronized void close() throws IOException {
        if (this.t != null) {
            Iterator it = new ArrayList(this.u.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.f != null) {
                    cVar.f.a();
                }
            }
            l();
            this.t.close();
            this.t = null;
        }
    }
}
