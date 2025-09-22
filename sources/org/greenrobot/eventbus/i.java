package org.greenrobot.eventbus;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private h f4320a;

    /* renamed from: b  reason: collision with root package name */
    private h f4321b;

    i() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized h a() {
        h hVar;
        hVar = this.f4320a;
        if (this.f4320a != null) {
            this.f4320a = this.f4320a.f4319c;
            if (this.f4320a == null) {
                this.f4321b = null;
            }
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(h hVar) {
        if (hVar == null) {
            try {
                throw new NullPointerException("null cannot be enqueued");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            if (this.f4321b != null) {
                this.f4321b.f4319c = hVar;
                this.f4321b = hVar;
            } else if (this.f4320a == null) {
                this.f4321b = hVar;
                this.f4320a = hVar;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized h b() throws InterruptedException {
        if (this.f4320a == null) {
            wait(1000);
        }
        return a();
    }
}
