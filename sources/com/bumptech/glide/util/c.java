package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class c extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private static final Queue<c> f1494b = k.a(0);

    /* renamed from: a  reason: collision with root package name */
    public IOException f1495a;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f1496c;

    c() {
    }

    @NonNull
    public static c a(@NonNull InputStream inputStream) {
        c poll;
        synchronized (f1494b) {
            poll = f1494b.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.f1496c = inputStream;
        return poll;
    }

    private static void b() {
        while (!f1494b.isEmpty()) {
            f1494b.remove();
        }
    }

    private void b(@NonNull InputStream inputStream) {
        this.f1496c = inputStream;
    }

    @Nullable
    private IOException c() {
        return this.f1495a;
    }

    public final void a() {
        this.f1495a = null;
        this.f1496c = null;
        synchronized (f1494b) {
            f1494b.offer(this);
        }
    }

    public final int available() throws IOException {
        return this.f1496c.available();
    }

    public final void close() throws IOException {
        this.f1496c.close();
    }

    public final void mark(int i) {
        this.f1496c.mark(i);
    }

    public final boolean markSupported() {
        return this.f1496c.markSupported();
    }

    public final int read() {
        try {
            return this.f1496c.read();
        } catch (IOException e) {
            this.f1495a = e;
            return -1;
        }
    }

    public final int read(byte[] bArr) {
        try {
            return this.f1496c.read(bArr);
        } catch (IOException e) {
            this.f1495a = e;
            return -1;
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        try {
            return this.f1496c.read(bArr, i, i2);
        } catch (IOException e) {
            this.f1495a = e;
            return -1;
        }
    }

    public final synchronized void reset() throws IOException {
        this.f1496c.reset();
    }

    public final long skip(long j) {
        try {
            return this.f1496c.skip(j);
        } catch (IOException e) {
            this.f1495a = e;
            return 0;
        }
    }
}
