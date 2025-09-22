package b.a.a;

import c.c;
import c.h;
import c.x;
import java.io.IOException;

class e extends h {

    /* renamed from: a  reason: collision with root package name */
    private boolean f40a;

    e(x xVar) {
        super(xVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public final void a(c cVar, long j) throws IOException {
        if (this.f40a) {
            cVar.h(j);
            return;
        }
        try {
            super.a(cVar, j);
        } catch (IOException unused) {
            this.f40a = true;
            a();
        }
    }

    public void close() throws IOException {
        if (!this.f40a) {
            try {
                super.close();
            } catch (IOException unused) {
                this.f40a = true;
                a();
            }
        }
    }

    public void flush() throws IOException {
        if (!this.f40a) {
            try {
                super.flush();
            } catch (IOException unused) {
                this.f40a = true;
                a();
            }
        }
    }
}
