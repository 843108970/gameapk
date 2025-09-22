package b.a.a;

import b.a.h.e;
import c.p;
import c.x;
import c.y;
import com.cyjh.common.util.s;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.apache.commons.io.FilenameUtils;

public final class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    static final String f21a = "journal";

    /* renamed from: b  reason: collision with root package name */
    static final String f22b = "journal.tmp";

    /* renamed from: c  reason: collision with root package name */
    static final String f23c = "journal.bkp";
    static final String d = "libcore.io.DiskLruCache";
    static final String e = "1";
    static final long f = -1;
    static final Pattern g = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean s = true;
    private static final String t = "CLEAN";
    private static final String u = "DIRTY";
    private static final String v = "REMOVE";
    private static final String w = "READ";
    private final int A;
    private long B;
    private long C = 0;
    private long D = 0;
    private final Executor E;
    private final Runnable F = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r4.f24a.r = true;
            r4.f24a.k = c.p.a(c.p.a());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0018 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r4 = this;
                b.a.a.d r0 = b.a.a.d.this
                monitor-enter(r0)
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ all -> 0x0041 }
                boolean r1 = r1.o     // Catch:{ all -> 0x0041 }
                r2 = 1
                r1 = r1 ^ r2
                b.a.a.d r3 = b.a.a.d.this     // Catch:{ all -> 0x0041 }
                boolean r3 = r3.p     // Catch:{ all -> 0x0041 }
                r1 = r1 | r3
                if (r1 == 0) goto L_0x0012
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x0012:
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ IOException -> 0x0018 }
                r1.g()     // Catch:{ IOException -> 0x0018 }
                goto L_0x001c
            L_0x0018:
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ all -> 0x0041 }
                r1.q = r2     // Catch:{ all -> 0x0041 }
            L_0x001c:
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ IOException -> 0x002f }
                boolean r1 = r1.e()     // Catch:{ IOException -> 0x002f }
                if (r1 == 0) goto L_0x003f
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ IOException -> 0x002f }
                r1.b()     // Catch:{ IOException -> 0x002f }
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ IOException -> 0x002f }
                r3 = 0
                r1.m = r3     // Catch:{ IOException -> 0x002f }
                goto L_0x003f
            L_0x002f:
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ all -> 0x0041 }
                r1.r = r2     // Catch:{ all -> 0x0041 }
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ all -> 0x0041 }
                c.x r2 = c.p.a()     // Catch:{ all -> 0x0041 }
                c.d r2 = c.p.a((c.x) r2)     // Catch:{ all -> 0x0041 }
                r1.k = r2     // Catch:{ all -> 0x0041 }
            L_0x003f:
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                return
            L_0x0041:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0041 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.AnonymousClass1.run():void");
        }
    };
    final b.a.g.a h;
    public final File i;
    final int j;
    c.d k;
    final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    int m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    private final File x;
    private final File y;
    private final File z;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        final b f30a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f31b;
        private boolean d;

        a(b bVar) {
            this.f30a = bVar;
            this.f31b = bVar.e ? null : new boolean[d.this.j];
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private c.y b(int r5) {
            /*
                r4 = this;
                b.a.a.d r0 = b.a.a.d.this
                monitor-enter(r0)
                boolean r1 = r4.d     // Catch:{ all -> 0x002f }
                if (r1 == 0) goto L_0x000d
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
                r5.<init>()     // Catch:{ all -> 0x002f }
                throw r5     // Catch:{ all -> 0x002f }
            L_0x000d:
                b.a.a.d$b r1 = r4.f30a     // Catch:{ all -> 0x002f }
                boolean r1 = r1.e     // Catch:{ all -> 0x002f }
                r2 = 0
                if (r1 == 0) goto L_0x002d
                b.a.a.d$b r1 = r4.f30a     // Catch:{ all -> 0x002f }
                b.a.a.d$a r1 = r1.f     // Catch:{ all -> 0x002f }
                if (r1 == r4) goto L_0x001b
                goto L_0x002d
            L_0x001b:
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ FileNotFoundException -> 0x002b }
                b.a.g.a r1 = r1.h     // Catch:{ FileNotFoundException -> 0x002b }
                b.a.a.d$b r3 = r4.f30a     // Catch:{ FileNotFoundException -> 0x002b }
                java.io.File[] r3 = r3.f36c     // Catch:{ FileNotFoundException -> 0x002b }
                r5 = r3[r5]     // Catch:{ FileNotFoundException -> 0x002b }
                c.y r5 = r1.a(r5)     // Catch:{ FileNotFoundException -> 0x002b }
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r5
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r2
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r2
            L_0x002f:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.a.b(int):c.y");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void d() {
            /*
                r3 = this;
                b.a.a.d r0 = b.a.a.d.this
                monitor-enter(r0)
                boolean r1 = r3.d     // Catch:{ all -> 0x0015 }
                if (r1 != 0) goto L_0x0013
                b.a.a.d$b r1 = r3.f30a     // Catch:{ all -> 0x0015 }
                b.a.a.d$a r1 = r1.f     // Catch:{ all -> 0x0015 }
                if (r1 != r3) goto L_0x0013
                b.a.a.d r1 = b.a.a.d.this     // Catch:{ IOException -> 0x0013 }
                r2 = 0
                r1.a((b.a.a.d.a) r3, (boolean) r2)     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.a.d():void");
        }

        public final x a(int i) {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                } else if (this.f30a.f != this) {
                    x a2 = p.a();
                    return a2;
                } else {
                    if (!this.f30a.e) {
                        this.f31b[i] = true;
                    }
                    try {
                        AnonymousClass1 r1 = new e(d.this.h.b(this.f30a.d[i])) {
                            /* access modifiers changed from: protected */
                            public final void a() {
                                synchronized (d.this) {
                                    a.this.a();
                                }
                            }
                        };
                        return r1;
                    } catch (FileNotFoundException unused) {
                        return p.a();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (this.f30a.f == this) {
                for (int i = 0; i < d.this.j; i++) {
                    try {
                        d.this.h.d(this.f30a.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f30a.f = null;
            }
        }

        public final void b() throws IOException {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f30a.f == this) {
                    d.this.a(this, true);
                }
                this.d = true;
            }
        }

        public final void c() throws IOException {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f30a.f == this) {
                    d.this.a(this, false);
                }
                this.d = true;
            }
        }
    }

    private final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f34a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f35b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f36c;
        final File[] d;
        boolean e;
        a f;
        long g;

        b(String str) {
            this.f34a = str;
            this.f35b = new long[d.this.j];
            this.f36c = new File[d.this.j];
            this.d = new File[d.this.j];
            StringBuilder sb = new StringBuilder(str);
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i = 0; i < d.this.j; i++) {
                sb.append(i);
                this.f36c[i] = new File(d.this.i, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(d.this.i, sb.toString());
                sb.setLength(length);
            }
        }

        private static IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public final c a() {
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            y[] yVarArr = new y[d.this.j];
            long[] jArr = (long[]) this.f35b.clone();
            int i = 0;
            int i2 = 0;
            while (i2 < d.this.j) {
                try {
                    yVarArr[i2] = d.this.h.a(this.f36c[i2]);
                    i2++;
                } catch (FileNotFoundException unused) {
                    while (i < d.this.j && yVarArr[i] != null) {
                        b.a.c.a((Closeable) yVarArr[i]);
                        i++;
                    }
                    try {
                        d.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return new c(this.f34a, this.g, yVarArr, jArr);
        }

        /* access modifiers changed from: package-private */
        public final void a(c.d dVar) throws IOException {
            for (long n : this.f35b) {
                dVar.l(32).n(n);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(String[] strArr) throws IOException {
            if (strArr.length != d.this.j) {
                throw b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f35b[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }
    }

    public final class c implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final String f37a;

        /* renamed from: b  reason: collision with root package name */
        public final long f38b;

        /* renamed from: c  reason: collision with root package name */
        public final y[] f39c;
        private final long[] e;

        c(String str, long j, y[] yVarArr, long[] jArr) {
            this.f37a = str;
            this.f38b = j;
            this.f39c = yVarArr;
            this.e = jArr;
        }

        private y a(int i) {
            return this.f39c[i];
        }

        private String a() {
            return this.f37a;
        }

        private long b(int i) {
            return this.e[i];
        }

        @Nullable
        private a b() throws IOException {
            return d.this.a(this.f37a, this.f38b);
        }

        public final void close() {
            for (y a2 : this.f39c) {
                b.a.c.a((Closeable) a2);
            }
        }
    }

    private d(b.a.g.a aVar, File file, long j2, Executor executor) {
        this.h = aVar;
        this.i = file;
        this.A = 201105;
        this.x = new File(file, f21a);
        this.y = new File(file, f22b);
        this.z = new File(file, f23c);
        this.j = 2;
        this.B = j2;
        this.E = executor;
    }

    public static d a(b.a.g.a aVar, File file, long j2) {
        if (j2 > 0) {
            return new d(aVar, file, j2, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a.c.a("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private synchronized void a(long j2) {
        this.B = j2;
        if (this.o) {
            this.E.execute(this.F);
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
            if (indexOf == 6 && str.startsWith(v)) {
                this.l.remove(str2);
                return;
            }
        } else {
            str2 = str.substring(i2, indexOf2);
        }
        b bVar = this.l.get(str2);
        if (bVar == null) {
            bVar = new b(str2);
            this.l.put(str2, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(t)) {
            String[] split = str.substring(indexOf2 + 1).split(s.a.f1696a);
            bVar.e = true;
            bVar.f = null;
            bVar.a(split);
        } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(u)) {
            bVar.f = new a(bVar);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(w)) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    @Nullable
    private a d(String str) throws IOException {
        return a(str, -1);
    }

    private static void e(String str) {
        if (!g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:49|50|(1:52)(1:53)|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r9.m = r1 - r9.l.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0113, code lost:
        if (r0.d() == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0115, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0119, code lost:
        r9.k = l();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0122, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0106 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0053=Splitter:B:13:0x0053, B:56:0x0123=Splitter:B:56:0x0123} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k() throws java.io.IOException {
        /*
            r9 = this;
            b.a.g.a r0 = r9.h
            java.io.File r1 = r9.x
            c.y r0 = r0.a(r1)
            c.e r0 = c.p.a((c.y) r0)
            java.lang.String r1 = r0.s()     // Catch:{ all -> 0x0154 }
            java.lang.String r2 = r0.s()     // Catch:{ all -> 0x0154 }
            java.lang.String r3 = r0.s()     // Catch:{ all -> 0x0154 }
            java.lang.String r4 = r0.s()     // Catch:{ all -> 0x0154 }
            java.lang.String r5 = r0.s()     // Catch:{ all -> 0x0154 }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0154 }
            if (r6 == 0) goto L_0x0123
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0154 }
            if (r6 == 0) goto L_0x0123
            int r6 = r9.A     // Catch:{ all -> 0x0154 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0154 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0154 }
            if (r3 == 0) goto L_0x0123
            int r3 = r9.j     // Catch:{ all -> 0x0154 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0154 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0154 }
            if (r3 == 0) goto L_0x0123
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0154 }
            if (r3 != 0) goto L_0x0052
            goto L_0x0123
        L_0x0052:
            r1 = 0
        L_0x0053:
            java.lang.String r2 = r0.s()     // Catch:{ EOFException -> 0x0106 }
            r3 = 32
            int r4 = r2.indexOf(r3)     // Catch:{ EOFException -> 0x0106 }
            r5 = -1
            if (r4 != r5) goto L_0x0074
            java.io.IOException r3 = new java.io.IOException     // Catch:{ EOFException -> 0x0106 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0106 }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x0106 }
            r4.append(r2)     // Catch:{ EOFException -> 0x0106 }
            java.lang.String r2 = r4.toString()     // Catch:{ EOFException -> 0x0106 }
            r3.<init>(r2)     // Catch:{ EOFException -> 0x0106 }
            throw r3     // Catch:{ EOFException -> 0x0106 }
        L_0x0074:
            int r6 = r4 + 1
            int r3 = r2.indexOf(r3, r6)     // Catch:{ EOFException -> 0x0106 }
            if (r3 != r5) goto L_0x0091
            java.lang.String r6 = r2.substring(r6)     // Catch:{ EOFException -> 0x0106 }
            r7 = 6
            if (r4 != r7) goto L_0x0095
            java.lang.String r7 = "REMOVE"
            boolean r7 = r2.startsWith(r7)     // Catch:{ EOFException -> 0x0106 }
            if (r7 == 0) goto L_0x0095
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r2 = r9.l     // Catch:{ EOFException -> 0x0106 }
            r2.remove(r6)     // Catch:{ EOFException -> 0x0106 }
            goto L_0x00ee
        L_0x0091:
            java.lang.String r6 = r2.substring(r6, r3)     // Catch:{ EOFException -> 0x0106 }
        L_0x0095:
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r7 = r9.l     // Catch:{ EOFException -> 0x0106 }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ EOFException -> 0x0106 }
            b.a.a.d$b r7 = (b.a.a.d.b) r7     // Catch:{ EOFException -> 0x0106 }
            if (r7 != 0) goto L_0x00a9
            b.a.a.d$b r7 = new b.a.a.d$b     // Catch:{ EOFException -> 0x0106 }
            r7.<init>(r6)     // Catch:{ EOFException -> 0x0106 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r8 = r9.l     // Catch:{ EOFException -> 0x0106 }
            r8.put(r6, r7)     // Catch:{ EOFException -> 0x0106 }
        L_0x00a9:
            r6 = 5
            if (r3 == r5) goto L_0x00cc
            if (r4 != r6) goto L_0x00cc
            java.lang.String r8 = "CLEAN"
            boolean r8 = r2.startsWith(r8)     // Catch:{ EOFException -> 0x0106 }
            if (r8 == 0) goto L_0x00cc
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)     // Catch:{ EOFException -> 0x0106 }
            java.lang.String r3 = " "
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ EOFException -> 0x0106 }
            r3 = 1
            r7.e = r3     // Catch:{ EOFException -> 0x0106 }
            r3 = 0
            r7.f = r3     // Catch:{ EOFException -> 0x0106 }
            r7.a((java.lang.String[]) r2)     // Catch:{ EOFException -> 0x0106 }
            goto L_0x00ee
        L_0x00cc:
            if (r3 != r5) goto L_0x00e0
            if (r4 != r6) goto L_0x00e0
            java.lang.String r6 = "DIRTY"
            boolean r6 = r2.startsWith(r6)     // Catch:{ EOFException -> 0x0106 }
            if (r6 == 0) goto L_0x00e0
            b.a.a.d$a r2 = new b.a.a.d$a     // Catch:{ EOFException -> 0x0106 }
            r2.<init>(r7)     // Catch:{ EOFException -> 0x0106 }
            r7.f = r2     // Catch:{ EOFException -> 0x0106 }
            goto L_0x00ee
        L_0x00e0:
            if (r3 != r5) goto L_0x00f2
            r3 = 4
            if (r4 != r3) goto L_0x00f2
            java.lang.String r3 = "READ"
            boolean r3 = r2.startsWith(r3)     // Catch:{ EOFException -> 0x0106 }
            if (r3 != 0) goto L_0x00ee
            goto L_0x00f2
        L_0x00ee:
            int r1 = r1 + 1
            goto L_0x0053
        L_0x00f2:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ EOFException -> 0x0106 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0106 }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x0106 }
            r4.append(r2)     // Catch:{ EOFException -> 0x0106 }
            java.lang.String r2 = r4.toString()     // Catch:{ EOFException -> 0x0106 }
            r3.<init>(r2)     // Catch:{ EOFException -> 0x0106 }
            throw r3     // Catch:{ EOFException -> 0x0106 }
        L_0x0106:
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r2 = r9.l     // Catch:{ all -> 0x0154 }
            int r2 = r2.size()     // Catch:{ all -> 0x0154 }
            int r1 = r1 - r2
            r9.m = r1     // Catch:{ all -> 0x0154 }
            boolean r1 = r0.d()     // Catch:{ all -> 0x0154 }
            if (r1 != 0) goto L_0x0119
            r9.b()     // Catch:{ all -> 0x0154 }
            goto L_0x011f
        L_0x0119:
            c.d r1 = r9.l()     // Catch:{ all -> 0x0154 }
            r9.k = r1     // Catch:{ all -> 0x0154 }
        L_0x011f:
            b.a.c.a((java.io.Closeable) r0)
            return
        L_0x0123:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0154 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0154 }
            java.lang.String r7 = "unexpected journal header: ["
            r6.<init>(r7)     // Catch:{ all -> 0x0154 }
            r6.append(r1)     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0154 }
            r6.append(r2)     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0154 }
            r6.append(r4)     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0154 }
            r6.append(r5)     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = "]"
            r6.append(r1)     // Catch:{ all -> 0x0154 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0154 }
            r3.<init>(r1)     // Catch:{ all -> 0x0154 }
            throw r3     // Catch:{ all -> 0x0154 }
        L_0x0154:
            r1 = move-exception
            b.a.c.a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.k():void");
    }

    private c.d l() throws FileNotFoundException {
        return p.a((x) new e(this.h.c(this.x)) {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f25a = true;

            static {
                Class<d> cls = d.class;
            }

            /* access modifiers changed from: protected */
            public final void a() {
                if (f25a || Thread.holdsLock(d.this)) {
                    d.this.n = true;
                    return;
                }
                throw new AssertionError();
            }
        });
    }

    private void m() throws IOException {
        this.h.d(this.y);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.f == null) {
                while (i2 < this.j) {
                    this.C += next.f35b[i2];
                    i2++;
                }
            } else {
                next.f = null;
                while (i2 < this.j) {
                    this.h.d(next.f36c[i2]);
                    this.h.d(next.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    private File n() {
        return this.i;
    }

    private synchronized void o() {
        if (f()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized b.a.a.d.a a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.a()     // Catch:{ all -> 0x0074 }
            r5.o()     // Catch:{ all -> 0x0074 }
            e(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r0 = r5.l     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            b.a.a.d$b r0 = (b.a.a.d.b) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r1 = 0
            if (r3 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r2 = r0.g     // Catch:{ all -> 0x0074 }
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r5)
            return r1
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            b.a.a.d$a r7 = r0.f     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r1
        L_0x002b:
            boolean r7 = r5.q     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.r     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            c.d r7 = r5.k     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            c.d r7 = r7.b(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            c.d r7 = r7.l(r8)     // Catch:{ all -> 0x0074 }
            c.d r7 = r7.b(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.l(r8)     // Catch:{ all -> 0x0074 }
            c.d r7 = r5.k     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.n     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r1
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            b.a.a.d$b r0 = new b.a.a.d$b     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r7 = r5.l     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            b.a.a.d$a r6 = new b.a.a.d$a     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.f = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.E     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.F     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r1
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.a(java.lang.String, long):b.a.a.d$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized b.a.a.d.c a(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.a()     // Catch:{ all -> 0x0050 }
            r3.o()     // Catch:{ all -> 0x0050 }
            e(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r0 = r3.l     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            b.a.a.d$b r0 = (b.a.a.d.b) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.e     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            b.a.a.d$c r0 = r0.a()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.m     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.m = r1     // Catch:{ all -> 0x0050 }
            c.d r1 = r3.k     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            c.d r1 = r1.b(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            c.d r1 = r1.l(r2)     // Catch:{ all -> 0x0050 }
            c.d r4 = r1.b(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.l(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.e()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.E     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.F     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.a(java.lang.String):b.a.a.d$c");
    }

    public final synchronized void a() throws IOException {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.o) {
            if (this.h.e(this.z)) {
                if (this.h.e(this.x)) {
                    this.h.d(this.z);
                } else {
                    this.h.a(this.z, this.x);
                }
            }
            if (this.h.e(this.x)) {
                try {
                    k();
                    m();
                    this.o = true;
                    return;
                } catch (IOException e2) {
                    e b2 = e.b();
                    b2.a(5, "DiskLruCache " + this.i + " is corrupt: " + e2.getMessage() + ", removing", (Throwable) e2);
                    h();
                    this.p = false;
                } catch (Throwable th) {
                    this.p = false;
                    throw th;
                }
            }
            b();
            this.o = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(b.a.a.d.a r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            b.a.a.d$b r0 = r12.f30a     // Catch:{ all -> 0x00fc }
            b.a.a.d$a r1 = r0.f     // Catch:{ all -> 0x00fc }
            if (r1 == r12) goto L_0x000d
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fc }
            r12.<init>()     // Catch:{ all -> 0x00fc }
            throw r12     // Catch:{ all -> 0x00fc }
        L_0x000d:
            r1 = 0
            if (r13 == 0) goto L_0x004a
            boolean r2 = r0.e     // Catch:{ all -> 0x00fc }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x0015:
            int r3 = r11.j     // Catch:{ all -> 0x00fc }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r12.f31b     // Catch:{ all -> 0x00fc }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fc }
            if (r3 != 0) goto L_0x0036
            r12.c()     // Catch:{ all -> 0x00fc }
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fc }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r13.<init>(r0)     // Catch:{ all -> 0x00fc }
            r13.append(r2)     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00fc }
            r12.<init>(r13)     // Catch:{ all -> 0x00fc }
            throw r12     // Catch:{ all -> 0x00fc }
        L_0x0036:
            b.a.g.a r3 = r11.h     // Catch:{ all -> 0x00fc }
            java.io.File[] r4 = r0.d     // Catch:{ all -> 0x00fc }
            r4 = r4[r2]     // Catch:{ all -> 0x00fc }
            boolean r3 = r3.e(r4)     // Catch:{ all -> 0x00fc }
            if (r3 != 0) goto L_0x0047
            r12.c()     // Catch:{ all -> 0x00fc }
            monitor-exit(r11)
            return
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x004a:
            int r12 = r11.j     // Catch:{ all -> 0x00fc }
            if (r1 >= r12) goto L_0x0085
            java.io.File[] r12 = r0.d     // Catch:{ all -> 0x00fc }
            r12 = r12[r1]     // Catch:{ all -> 0x00fc }
            if (r13 == 0) goto L_0x007d
            b.a.g.a r2 = r11.h     // Catch:{ all -> 0x00fc }
            boolean r2 = r2.e(r12)     // Catch:{ all -> 0x00fc }
            if (r2 == 0) goto L_0x0082
            java.io.File[] r2 = r0.f36c     // Catch:{ all -> 0x00fc }
            r2 = r2[r1]     // Catch:{ all -> 0x00fc }
            b.a.g.a r3 = r11.h     // Catch:{ all -> 0x00fc }
            r3.a(r12, r2)     // Catch:{ all -> 0x00fc }
            long[] r12 = r0.f35b     // Catch:{ all -> 0x00fc }
            r3 = r12[r1]     // Catch:{ all -> 0x00fc }
            b.a.g.a r12 = r11.h     // Catch:{ all -> 0x00fc }
            long r5 = r12.f(r2)     // Catch:{ all -> 0x00fc }
            long[] r12 = r0.f35b     // Catch:{ all -> 0x00fc }
            r12[r1] = r5     // Catch:{ all -> 0x00fc }
            long r7 = r11.C     // Catch:{ all -> 0x00fc }
            r12 = 0
            long r9 = r7 - r3
            long r2 = r9 + r5
            r11.C = r2     // Catch:{ all -> 0x00fc }
            goto L_0x0082
        L_0x007d:
            b.a.g.a r2 = r11.h     // Catch:{ all -> 0x00fc }
            r2.d(r12)     // Catch:{ all -> 0x00fc }
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0085:
            int r12 = r11.m     // Catch:{ all -> 0x00fc }
            r1 = 1
            int r12 = r12 + r1
            r11.m = r12     // Catch:{ all -> 0x00fc }
            r12 = 0
            r0.f = r12     // Catch:{ all -> 0x00fc }
            boolean r12 = r0.e     // Catch:{ all -> 0x00fc }
            r12 = r12 | r13
            r2 = 10
            r3 = 32
            if (r12 == 0) goto L_0x00c2
            r0.e = r1     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = "CLEAN"
            c.d r12 = r12.b(r1)     // Catch:{ all -> 0x00fc }
            r12.l(r3)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            java.lang.String r1 = r0.f34a     // Catch:{ all -> 0x00fc }
            r12.b(r1)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            r0.a((c.d) r12)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            r12.l(r2)     // Catch:{ all -> 0x00fc }
            if (r13 == 0) goto L_0x00e0
            long r12 = r11.D     // Catch:{ all -> 0x00fc }
            r1 = 1
            long r3 = r12 + r1
            r11.D = r3     // Catch:{ all -> 0x00fc }
            r0.g = r12     // Catch:{ all -> 0x00fc }
            goto L_0x00e0
        L_0x00c2:
            java.util.LinkedHashMap<java.lang.String, b.a.a.d$b> r12 = r11.l     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = r0.f34a     // Catch:{ all -> 0x00fc }
            r12.remove(r13)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = "REMOVE"
            c.d r12 = r12.b(r13)     // Catch:{ all -> 0x00fc }
            r12.l(r3)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            java.lang.String r13 = r0.f34a     // Catch:{ all -> 0x00fc }
            r12.b(r13)     // Catch:{ all -> 0x00fc }
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            r12.l(r2)     // Catch:{ all -> 0x00fc }
        L_0x00e0:
            c.d r12 = r11.k     // Catch:{ all -> 0x00fc }
            r12.flush()     // Catch:{ all -> 0x00fc }
            long r12 = r11.C     // Catch:{ all -> 0x00fc }
            long r0 = r11.B     // Catch:{ all -> 0x00fc }
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f3
            boolean r12 = r11.e()     // Catch:{ all -> 0x00fc }
            if (r12 == 0) goto L_0x00fa
        L_0x00f3:
            java.util.concurrent.Executor r12 = r11.E     // Catch:{ all -> 0x00fc }
            java.lang.Runnable r13 = r11.F     // Catch:{ all -> 0x00fc }
            r12.execute(r13)     // Catch:{ all -> 0x00fc }
        L_0x00fa:
            monitor-exit(r11)
            return
        L_0x00fc:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.d.a(b.a.a.d$a, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(b bVar) throws IOException {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i2 = 0; i2 < this.j; i2++) {
            this.h.d(bVar.f36c[i2]);
            this.C -= bVar.f35b[i2];
            bVar.f35b[i2] = 0;
        }
        this.m++;
        this.k.b(v).l(32).b(bVar.f34a).l(10);
        this.l.remove(bVar.f34a);
        if (e()) {
            this.E.execute(this.F);
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final synchronized void b() throws IOException {
        if (this.k != null) {
            this.k.close();
        }
        c.d a2 = p.a(this.h.b(this.y));
        try {
            a2.b(d).l(10);
            a2.b("1").l(10);
            a2.n((long) this.A).l(10);
            a2.n((long) this.j).l(10);
            a2.l(10);
            for (b next : this.l.values()) {
                if (next.f != null) {
                    a2.b(u).l(32);
                    a2.b(next.f34a);
                } else {
                    a2.b(t).l(32);
                    a2.b(next.f34a);
                    next.a(a2);
                }
                a2.l(10);
            }
            a2.close();
            if (this.h.e(this.x)) {
                this.h.a(this.x, this.z);
            }
            this.h.a(this.y, this.x);
            this.h.d(this.z);
            this.k = l();
            this.n = false;
            this.r = false;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    public final synchronized boolean b(String str) throws IOException {
        a();
        o();
        e(str);
        b bVar = this.l.get(str);
        if (bVar == null) {
            return false;
        }
        a(bVar);
        if (this.C <= this.B) {
            this.q = false;
        }
        return true;
    }

    public final synchronized long c() {
        return this.B;
    }

    public final synchronized void close() throws IOException {
        if (this.o) {
            if (!this.p) {
                for (b bVar : (b[]) this.l.values().toArray(new b[this.l.size()])) {
                    if (bVar.f != null) {
                        bVar.f.c();
                    }
                }
                g();
                this.k.close();
                this.k = null;
                this.p = true;
                return;
            }
        }
        this.p = true;
    }

    public final synchronized long d() throws IOException {
        a();
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return this.m >= 2000 && this.m >= this.l.size();
    }

    public final synchronized boolean f() {
        return this.p;
    }

    public final synchronized void flush() throws IOException {
        if (this.o) {
            o();
            g();
            this.k.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public final void g() throws IOException {
        while (this.C > this.B) {
            a(this.l.values().iterator().next());
        }
        this.q = false;
    }

    public final void h() throws IOException {
        close();
        this.h.g(this.i);
    }

    public final synchronized void i() throws IOException {
        a();
        for (b a2 : (b[]) this.l.values().toArray(new b[this.l.size()])) {
            a(a2);
        }
        this.q = false;
    }

    public final synchronized Iterator<c> j() throws IOException {
        a();
        return new Iterator<c>() {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<b> f27a = new ArrayList(d.this.l.values()).iterator();

            /* renamed from: b  reason: collision with root package name */
            c f28b;

            /* renamed from: c  reason: collision with root package name */
            c f29c;

            private c a() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f29c = this.f28b;
                this.f28b = null;
                return this.f29c;
            }

            public final boolean hasNext() {
                if (this.f28b != null) {
                    return true;
                }
                synchronized (d.this) {
                    if (d.this.p) {
                        return false;
                    }
                    while (this.f27a.hasNext()) {
                        c a2 = this.f27a.next().a();
                        if (a2 != null) {
                            this.f28b = a2;
                            return true;
                        }
                    }
                    return false;
                }
            }

            public final /* synthetic */ Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f29c = this.f28b;
                this.f28b = null;
                return this.f29c;
            }

            public final void remove() {
                if (this.f29c == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    d.this.b(this.f29c.f37a);
                } catch (IOException unused) {
                } finally {
                    this.f29c = null;
                }
            }
        };
    }
}
