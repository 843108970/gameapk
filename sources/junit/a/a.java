package junit.a;

import junit.b.i;
import junit.b.j;
import junit.b.m;
import junit.b.n;

public final class a extends n {

    /* renamed from: c  reason: collision with root package name */
    private volatile int f4015c;

    public a() {
    }

    private a(Class<? extends j> cls) {
        super((Class<?>) cls);
    }

    private a(Class<? extends j> cls, String str) {
        super(cls, str);
    }

    private a(String str) {
        super(str);
    }

    private synchronized void b() {
        while (this.f4015c < this.f4041b.size()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void a(final i iVar, final m mVar) {
        new Thread() {
            public final void run() {
                try {
                    iVar.a(mVar);
                } finally {
                    a.this.i_();
                }
            }
        }.start();
    }

    public final void a(m mVar) {
        this.f4015c = 0;
        super.a(mVar);
        b();
    }

    public final synchronized void i_() {
        this.f4015c++;
        notifyAll();
    }
}
