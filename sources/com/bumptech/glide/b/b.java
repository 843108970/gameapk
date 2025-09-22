package com.bumptech.glide.b;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

final class b implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte f906c = 13;
    private static final byte d = 10;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final Charset f907a;

    /* renamed from: b  reason: collision with root package name */
    int f908b;
    private final InputStream e;
    private byte[] f;
    private int g;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private b(InputStream inputStream, Charset charset, byte b2) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (!charset.equals(c.f910a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        } else {
            this.e = inputStream;
            this.f907a = charset;
            this.f = new byte[8192];
        }
    }

    private boolean b() {
        return this.f908b == -1;
    }

    private void c() throws IOException {
        int read = this.e.read(this.f, 0, this.f.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.g = 0;
        this.f908b = read;
    }

    public final String a() throws IOException {
        int i;
        int i2;
        synchronized (this.e) {
            if (this.f == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.g >= this.f908b) {
                c();
            }
            for (int i3 = this.g; i3 != this.f908b; i3++) {
                if (this.f[i3] == 10) {
                    if (i3 != this.g) {
                        i2 = i3 - 1;
                        if (this.f[i2] == 13) {
                            String str = new String(this.f, this.g, i2 - this.g, this.f907a.name());
                            this.g = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.f, this.g, i2 - this.g, this.f907a.name());
                    this.g = i3 + 1;
                    return str2;
                }
            }
            AnonymousClass1 r1 = new ByteArrayOutputStream((this.f908b - this.g) + 80) {
                public final String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, b.this.f907a.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                r1.write(this.f, this.g, this.f908b - this.g);
                this.f908b = -1;
                c();
                i = this.g;
                while (true) {
                    if (i != this.f908b) {
                        if (this.f[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
            }
            if (i != this.g) {
                r1.write(this.f, this.g, i - this.g);
            }
            this.g = i + 1;
            String byteArrayOutputStream = r1.toString();
            return byteArrayOutputStream;
        }
    }

    public final void close() throws IOException {
        synchronized (this.e) {
            if (this.f != null) {
                this.f = null;
                this.e.close();
            }
        }
    }
}
