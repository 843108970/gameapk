package org.litepal.b.a;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f4685a;

    private void a(Runnable runnable) {
        this.f4685a = runnable;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f4685a != null) {
            new Thread(this.f4685a).start();
        }
    }
}
