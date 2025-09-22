package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1502a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1503b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f1504c = Integer.MIN_VALUE;

    public g(@NonNull InputStream inputStream) {
        super(inputStream);
    }

    private long a(long j) {
        if (this.f1504c == 0) {
            return -1;
        }
        return (this.f1504c == Integer.MIN_VALUE || j <= ((long) this.f1504c)) ? j : (long) this.f1504c;
    }

    private void b(long j) {
        if (this.f1504c != Integer.MIN_VALUE && j != -1) {
            this.f1504c = (int) (((long) this.f1504c) - j);
        }
    }

    public final int available() throws IOException {
        return this.f1504c == Integer.MIN_VALUE ? super.available() : Math.min(this.f1504c, super.available());
    }

    public final synchronized void mark(int i) {
        super.mark(i);
        this.f1504c = i;
    }

    public final int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int a2 = (int) a((long) i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b((long) read);
        return read;
    }

    public final synchronized void reset() throws IOException {
        super.reset();
        this.f1504c = Integer.MIN_VALUE;
    }

    public final long skip(long j) throws IOException {
        long a2 = a(j);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }
}
