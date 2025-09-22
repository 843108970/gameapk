package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.a.b;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends OutputStream {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f986a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f987b;

    /* renamed from: c  reason: collision with root package name */
    private b f988c;
    private int d;

    public c(@NonNull OutputStream outputStream, @NonNull b bVar) {
        this(outputStream, bVar, (byte) 0);
    }

    @VisibleForTesting
    private c(@NonNull OutputStream outputStream, b bVar, byte b2) {
        this.f986a = outputStream;
        this.f988c = bVar;
        this.f987b = (byte[]) bVar.a(65536, byte[].class);
    }

    private void a() throws IOException {
        if (this.d > 0) {
            this.f986a.write(this.f987b, 0, this.d);
            this.d = 0;
        }
    }

    private void b() throws IOException {
        if (this.d == this.f987b.length) {
            a();
        }
    }

    private void c() {
        if (this.f987b != null) {
            this.f988c.b(this.f987b);
            this.f987b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void close() throws IOException {
        try {
            flush();
            this.f986a.close();
            if (this.f987b != null) {
                this.f988c.b(this.f987b);
                this.f987b = null;
            }
        } catch (Throwable th) {
            this.f986a.close();
            throw th;
        }
    }

    public final void flush() throws IOException {
        a();
        this.f986a.flush();
    }

    public final void write(int i) throws IOException {
        byte[] bArr = this.f987b;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    public final void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.d != 0 || i4 < this.f987b.length) {
                int min = Math.min(i4, this.f987b.length - this.d);
                System.arraycopy(bArr, i5, this.f987b, this.d, min);
                this.d += min;
                i3 += min;
                b();
            } else {
                this.f986a.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
