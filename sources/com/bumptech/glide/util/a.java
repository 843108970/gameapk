package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1472a = 16384;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReference<byte[]> f1473b = new AtomicReference<>();

    /* renamed from: com.bumptech.glide.util.a$a  reason: collision with other inner class name */
    private static class C0022a extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private static final int f1474a = -1;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final ByteBuffer f1475b;

        /* renamed from: c  reason: collision with root package name */
        private int f1476c = -1;

        C0022a(@NonNull ByteBuffer byteBuffer) {
            this.f1475b = byteBuffer;
        }

        public final int available() {
            return this.f1475b.remaining();
        }

        public final synchronized void mark(int i) {
            this.f1476c = this.f1475b.position();
        }

        public final boolean markSupported() {
            return true;
        }

        public final int read() {
            if (!this.f1475b.hasRemaining()) {
                return -1;
            }
            return this.f1475b.get();
        }

        public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            if (!this.f1475b.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.f1475b.get(bArr, i, min);
            return min;
        }

        public final synchronized void reset() throws IOException {
            if (this.f1476c == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f1475b.position(this.f1476c);
        }

        public final long skip(long j) throws IOException {
            if (!this.f1475b.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j, (long) available());
            this.f1475b.position((int) (((long) this.f1475b.position()) + min));
            return min;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final int f1483a;

        /* renamed from: b  reason: collision with root package name */
        final int f1484b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f1485c;

        b(@NonNull byte[] bArr, int i, int i2) {
            this.f1485c = bArr;
            this.f1483a = i;
            this.f1484b = i2;
        }
    }

    private a() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|(2:16|17)|18|19|20) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[SYNTHETIC, Splitter:B:28:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A[SYNTHETIC, Splitter:B:32:0x0053] */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer a(@android.support.annotation.NonNull java.io.File r9) throws java.io.IOException {
        /*
            r0 = 0
            long r5 = r9.length()     // Catch:{ all -> 0x004a }
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0014
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "File too large to map into memory"
            r9.<init>(r1)     // Catch:{ all -> 0x004a }
            throw r9     // Catch:{ all -> 0x004a }
        L_0x0014:
            r1 = 0
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0022
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "File unsuitable for memory mapping"
            r9.<init>(r1)     // Catch:{ all -> 0x004a }
            throw r9     // Catch:{ all -> 0x004a }
        L_0x0022:
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x004a }
            java.lang.String r1 = "r"
            r7.<init>(r9, r1)     // Catch:{ all -> 0x004a }
            java.nio.channels.FileChannel r9 = r7.getChannel()     // Catch:{ all -> 0x0048 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0043 }
            r3 = 0
            r1 = r9
            java.nio.MappedByteBuffer r0 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0043 }
            java.nio.MappedByteBuffer r0 = r0.load()     // Catch:{ all -> 0x0043 }
            if (r9 == 0) goto L_0x003f
            r9.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            r7.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            return r0
        L_0x0043:
            r0 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x004c
        L_0x0048:
            r9 = move-exception
            goto L_0x004c
        L_0x004a:
            r9 = move-exception
            r7 = r0
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            if (r7 == 0) goto L_0x0056
            r7.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.a.a(java.io.File):java.nio.ByteBuffer");
    }

    @NonNull
    private static ByteBuffer a(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = f1473b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f1473b.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|(2:8|9)|10|11|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0021 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC, Splitter:B:19:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(@android.support.annotation.NonNull java.nio.ByteBuffer r4, @android.support.annotation.NonNull java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
            r4.position(r0)
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x002a }
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x002a }
            java.nio.channels.FileChannel r5 = r2.getChannel()     // Catch:{ all -> 0x0027 }
            r5.write(r4)     // Catch:{ all -> 0x0025 }
            r5.force(r0)     // Catch:{ all -> 0x0025 }
            r5.close()     // Catch:{ all -> 0x0025 }
            r2.close()     // Catch:{ all -> 0x0025 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x0021 }
        L_0x0021:
            r2.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x002d
        L_0x0027:
            r4 = move-exception
            r5 = r1
            goto L_0x002d
        L_0x002a:
            r4 = move-exception
            r5 = r1
            r2 = r5
        L_0x002d:
            if (r5 == 0) goto L_0x0032
            r5.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            if (r2 == 0) goto L_0x0037
            r2.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.a.a(java.nio.ByteBuffer, java.io.File):void");
    }

    private static void a(@NonNull ByteBuffer byteBuffer, @NonNull OutputStream outputStream) throws IOException {
        b c2 = c(byteBuffer);
        if (c2 != null) {
            outputStream.write(c2.f1485c, c2.f1483a, c2.f1483a + c2.f1484b);
            return;
        }
        byte[] andSet = f1473b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (byteBuffer.remaining() > 0) {
            int min = Math.min(byteBuffer.remaining(), andSet.length);
            byteBuffer.get(andSet, 0, min);
            outputStream.write(andSet, 0, min);
        }
        f1473b.set(andSet);
    }

    @NonNull
    public static byte[] a(@NonNull ByteBuffer byteBuffer) {
        b c2 = c(byteBuffer);
        if (c2 != null && c2.f1483a == 0 && c2.f1484b == c2.f1485c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    public static InputStream b(@NonNull ByteBuffer byteBuffer) {
        return new C0022a(byteBuffer);
    }

    @Nullable
    private static b c(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
