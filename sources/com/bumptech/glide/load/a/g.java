package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final int f992a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f993b = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: c  reason: collision with root package name */
    private static final int f994c = 29;
    private static final int d = 31;
    private final byte e;
    private int f;

    public g(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.e = (byte) i;
    }

    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        int read = (this.f < 2 || this.f > d) ? super.read() : this.f == d ? this.e : f993b[this.f - 2] & 255;
        if (read != -1) {
            this.f++;
        }
        return read;
    }

    public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.f > d) {
            i3 = super.read(bArr, i, i2);
        } else if (this.f == d) {
            bArr[i] = this.e;
            i3 = 1;
        } else if (this.f < 2) {
            i3 = super.read(bArr, i, 2 - this.f);
        } else {
            int min = Math.min(d - this.f, i2);
            System.arraycopy(f993b, this.f - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.f += i3;
        }
        return i3;
    }

    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public final long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.f = (int) (((long) this.f) + skip);
        }
        return skip;
    }
}
