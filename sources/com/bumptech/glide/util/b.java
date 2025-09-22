package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1491a = "ContentLengthStream";

    /* renamed from: b  reason: collision with root package name */
    private static final int f1492b = -1;

    /* renamed from: c  reason: collision with root package name */
    private final long f1493c;
    private int d;

    private b(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f1493c = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.d += i;
            return i;
        } else if (this.f1493c - ((long) this.d) <= 0) {
            return i;
        } else {
            throw new IOException("Failed to read all expected data, expected: " + this.f1493c + ", but read: " + this.d);
        }
    }

    private static int a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!Log.isLoggable(f1491a, 3)) {
                return -1;
            }
            Log.d(f1491a, "failed to parse content length header: " + str, e);
            return -1;
        }
    }

    @NonNull
    public static InputStream a(@NonNull InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    @NonNull
    private static InputStream a(@NonNull InputStream inputStream, @Nullable String str) {
        return a(inputStream, (long) a(str));
    }

    public final synchronized int available() throws IOException {
        return (int) Math.max(this.f1493c - ((long) this.d), (long) this.in.available());
    }

    public final synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }
}
