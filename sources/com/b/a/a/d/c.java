package com.b.a.a.d;

import com.b.b.f;
import com.b.b.k;
import com.b.b.w;
import com.b.b.y;
import org.apache.commons.io.IOUtils;

final class c implements w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f631a;

    /* renamed from: b  reason: collision with root package name */
    private final k f632b = new k(this.f631a.d.a());

    /* renamed from: c  reason: collision with root package name */
    private boolean f633c;

    c(a aVar) {
        this.f631a = aVar;
    }

    public final y a() {
        return this.f632b;
    }

    public final void a_(f fVar, long j) {
        if (this.f633c) {
            throw new IllegalStateException("closed");
        } else if (j != 0) {
            this.f631a.d.i(j);
            this.f631a.d.b(IOUtils.LINE_SEPARATOR_WINDOWS);
            this.f631a.d.a_(fVar, j);
            this.f631a.d.b(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
    }

    public final synchronized void close() {
        if (!this.f633c) {
            this.f633c = true;
            this.f631a.d.b("0\r\n\r\n");
            a.a(this.f632b);
            this.f631a.e = 3;
        }
    }

    public final synchronized void flush() {
        if (!this.f633c) {
            this.f631a.d.flush();
        }
    }
}
