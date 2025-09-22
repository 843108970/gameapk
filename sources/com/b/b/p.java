package com.b.b;

import java.io.IOException;
import java.io.InputStream;

final class p implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f870a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ InputStream f871b;

    p(y yVar, InputStream inputStream) {
        this.f870a = yVar;
        this.f871b = inputStream;
    }

    public final long a(f fVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            try {
                this.f870a.f_();
                t e = fVar.e(1);
                int read = this.f871b.read(e.f879a, e.f881c, (int) Math.min(j, (long) (8192 - e.f881c)));
                if (read == -1) {
                    return -1;
                }
                e.f881c += read;
                long j2 = (long) read;
                fVar.f855b += j2;
                return j2;
            } catch (AssertionError e2) {
                if (n.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public final y a() {
        return this.f870a;
    }

    public final void close() {
        this.f871b.close();
    }

    public final String toString() {
        return "source(" + this.f871b + ")";
    }
}
