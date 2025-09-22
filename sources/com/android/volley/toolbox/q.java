package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class q extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final int f557a = 256;

    /* renamed from: b  reason: collision with root package name */
    private final d f558b;

    private q(d dVar) {
        this(dVar, 256);
    }

    public q(d dVar, int i) {
        this.f558b = dVar;
        this.buf = this.f558b.a(Math.max(i, 256));
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a2 = this.f558b.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f558b.a(this.buf);
            this.buf = a2;
        }
    }

    public final void close() throws IOException {
        this.f558b.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f558b.a(this.buf);
    }

    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }
}
