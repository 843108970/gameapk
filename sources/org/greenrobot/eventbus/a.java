package org.greenrobot.eventbus;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final i f4289a = new i();

    /* renamed from: b  reason: collision with root package name */
    final c f4290b;

    a(c cVar) {
        this.f4290b = cVar;
    }

    private void a(n nVar, Object obj) {
        this.f4289a.a(h.a(nVar, obj));
        this.f4290b.f4303c.execute(this);
    }

    public final void run() {
        h a2 = this.f4289a.a();
        if (a2 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f4290b.a(a2);
    }
}
