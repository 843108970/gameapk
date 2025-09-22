package com.bumptech.glide.load.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.a.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class v extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f1326a;

    /* renamed from: b  reason: collision with root package name */
    private int f1327b;

    /* renamed from: c  reason: collision with root package name */
    private int f1328c;
    private int d;
    private int e;
    private final b f;

    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public v(@NonNull InputStream inputStream, @NonNull b bVar) {
        this(inputStream, bVar, (byte) 0);
    }

    @VisibleForTesting
    private v(@NonNull InputStream inputStream, @NonNull b bVar, byte b2) {
        super(inputStream);
        this.d = -1;
        this.f = bVar;
        this.f1326a = (byte[]) bVar.a(65536, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        if (this.d == -1 || this.e - this.d >= this.f1328c) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.d = -1;
                this.e = 0;
                this.f1327b = read;
            }
            return read;
        }
        if (this.d == 0 && this.f1328c > bArr.length && this.f1327b == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.f1328c) {
                length = this.f1328c;
            }
            byte[] bArr2 = (byte[]) this.f.a(length, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f1326a = bArr2;
            this.f.b(bArr);
            bArr = bArr2;
        } else if (this.d > 0) {
            System.arraycopy(bArr, this.d, bArr, 0, bArr.length - this.d);
        }
        this.e -= this.d;
        this.d = 0;
        this.f1327b = 0;
        int read2 = inputStream.read(bArr, this.e, bArr.length - this.e);
        this.f1327b = read2 <= 0 ? this.e : this.e + read2;
        return read2;
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final synchronized void a() {
        this.f1328c = this.f1326a.length;
    }

    public final synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f1326a != null) {
            if (inputStream != null) {
            }
        }
        throw c();
        return (this.f1327b - this.e) + inputStream.available();
    }

    public final synchronized void b() {
        if (this.f1326a != null) {
            this.f.b(this.f1326a);
            this.f1326a = null;
        }
    }

    public final void close() throws IOException {
        if (this.f1326a != null) {
            this.f.b(this.f1326a);
            this.f1326a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final synchronized void mark(int i) {
        this.f1328c = Math.max(this.f1328c, i);
        this.d = this.e;
    }

    public final boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0019=Splitter:B:12:0x0019, B:27:0x003b=Splitter:B:27:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f1326a     // Catch:{ all -> 0x0040 }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x003b
            if (r1 != 0) goto L_0x000a
            goto L_0x003b
        L_0x000a:
            int r2 = r5.e     // Catch:{ all -> 0x0040 }
            int r3 = r5.f1327b     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r2 < r3) goto L_0x0019
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x0040 }
            if (r1 != r4) goto L_0x0019
            monitor-exit(r5)
            return r4
        L_0x0019:
            byte[] r1 = r5.f1326a     // Catch:{ all -> 0x0040 }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.f1326a     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x0026
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0026:
            int r1 = r5.f1327b     // Catch:{ all -> 0x0040 }
            int r2 = r5.e     // Catch:{ all -> 0x0040 }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r5.e     // Catch:{ all -> 0x0040 }
            int r2 = r1 + 1
            r5.e = r2     // Catch:{ all -> 0x0040 }
            byte r0 = r0[r1]     // Catch:{ all -> 0x0040 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0039:
            monitor-exit(r5)
            return r4
        L_0x003b:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.v.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        return r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x008f A[SYNTHETIC, Splitter:B:64:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x008d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read(@android.support.annotation.NonNull byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f1326a     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x000a
            java.io.IOException r6 = c()     // Catch:{ all -> 0x0098 }
            throw r6     // Catch:{ all -> 0x0098 }
        L_0x000a:
            if (r8 != 0) goto L_0x000f
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x000f:
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0098 }
            if (r1 != 0) goto L_0x0018
            java.io.IOException r6 = c()     // Catch:{ all -> 0x0098 }
            throw r6     // Catch:{ all -> 0x0098 }
        L_0x0018:
            int r2 = r5.e     // Catch:{ all -> 0x0098 }
            int r3 = r5.f1327b     // Catch:{ all -> 0x0098 }
            if (r2 >= r3) goto L_0x0045
            int r2 = r5.f1327b     // Catch:{ all -> 0x0098 }
            int r3 = r5.e     // Catch:{ all -> 0x0098 }
            int r2 = r2 - r3
            if (r2 < r8) goto L_0x0027
            r2 = r8
            goto L_0x002c
        L_0x0027:
            int r2 = r5.f1327b     // Catch:{ all -> 0x0098 }
            int r3 = r5.e     // Catch:{ all -> 0x0098 }
            int r2 = r2 - r3
        L_0x002c:
            int r3 = r5.e     // Catch:{ all -> 0x0098 }
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ all -> 0x0098 }
            int r3 = r5.e     // Catch:{ all -> 0x0098 }
            int r3 = r3 + r2
            r5.e = r3     // Catch:{ all -> 0x0098 }
            if (r2 == r8) goto L_0x0043
            int r3 = r1.available()     // Catch:{ all -> 0x0098 }
            if (r3 != 0) goto L_0x003f
            goto L_0x0043
        L_0x003f:
            int r7 = r7 + r2
            int r2 = r8 - r2
            goto L_0x0046
        L_0x0043:
            monitor-exit(r5)
            return r2
        L_0x0045:
            r2 = r8
        L_0x0046:
            int r3 = r5.d     // Catch:{ all -> 0x0098 }
            r4 = -1
            if (r3 != r4) goto L_0x005b
            int r3 = r0.length     // Catch:{ all -> 0x0098 }
            if (r2 < r3) goto L_0x005b
            int r3 = r1.read(r6, r7, r2)     // Catch:{ all -> 0x0098 }
            if (r3 != r4) goto L_0x008a
            if (r2 != r8) goto L_0x0058
            monitor-exit(r5)
            return r4
        L_0x0058:
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x005b:
            int r3 = r5.a(r1, r0)     // Catch:{ all -> 0x0098 }
            if (r3 != r4) goto L_0x0065
            if (r2 != r8) goto L_0x0058
            monitor-exit(r5)
            return r4
        L_0x0065:
            byte[] r3 = r5.f1326a     // Catch:{ all -> 0x0098 }
            if (r0 == r3) goto L_0x0072
            byte[] r0 = r5.f1326a     // Catch:{ all -> 0x0098 }
            if (r0 != 0) goto L_0x0072
            java.io.IOException r6 = c()     // Catch:{ all -> 0x0098 }
            throw r6     // Catch:{ all -> 0x0098 }
        L_0x0072:
            int r3 = r5.f1327b     // Catch:{ all -> 0x0098 }
            int r4 = r5.e     // Catch:{ all -> 0x0098 }
            int r3 = r3 - r4
            if (r3 < r2) goto L_0x007b
            r3 = r2
            goto L_0x0080
        L_0x007b:
            int r3 = r5.f1327b     // Catch:{ all -> 0x0098 }
            int r4 = r5.e     // Catch:{ all -> 0x0098 }
            int r3 = r3 - r4
        L_0x0080:
            int r4 = r5.e     // Catch:{ all -> 0x0098 }
            java.lang.System.arraycopy(r0, r4, r6, r7, r3)     // Catch:{ all -> 0x0098 }
            int r4 = r5.e     // Catch:{ all -> 0x0098 }
            int r4 = r4 + r3
            r5.e = r4     // Catch:{ all -> 0x0098 }
        L_0x008a:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x008f
            monitor-exit(r5)
            return r8
        L_0x008f:
            int r4 = r1.available()     // Catch:{ all -> 0x0098 }
            if (r4 != 0) goto L_0x0096
            goto L_0x0058
        L_0x0096:
            int r7 = r7 + r3
            goto L_0x0046
        L_0x0098:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.v.read(byte[], int, int):int");
    }

    public final synchronized void reset() throws IOException {
        if (this.f1326a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.d) {
            throw new a("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.f1328c);
        } else {
            this.e = this.d;
        }
    }

    public final synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f1326a;
        if (bArr == null) {
            throw c();
        }
        InputStream inputStream = this.in;
        if (inputStream == null) {
            throw c();
        } else if (((long) (this.f1327b - this.e)) >= j) {
            this.e = (int) (((long) this.e) + j);
            return j;
        } else {
            long j2 = ((long) this.f1327b) - ((long) this.e);
            this.e = this.f1327b;
            if (this.d == -1 || j > ((long) this.f1328c)) {
                return j2 + inputStream.skip(j - j2);
            } else if (a(inputStream, bArr) == -1) {
                return j2;
            } else {
                if (((long) (this.f1327b - this.e)) >= j - j2) {
                    this.e = (int) ((((long) this.e) + j) - j2);
                    return j;
                }
                long j3 = (j2 + ((long) this.f1327b)) - ((long) this.e);
                this.e = this.f1327b;
                return j3;
            }
        }
    }
}
