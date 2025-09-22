package org.greenrobot.eventbus;

import android.util.Log;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final i f4298a = new i();

    /* renamed from: b  reason: collision with root package name */
    final c f4299b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f4300c;

    b(c cVar) {
        this.f4299b = cVar;
    }

    private void a(n nVar, Object obj) {
        h a2 = h.a(nVar, obj);
        synchronized (this) {
            this.f4298a.a(a2);
            if (!this.f4300c) {
                this.f4300c = true;
                this.f4299b.f4303c.execute(this);
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                h b2 = this.f4298a.b();
                if (b2 == null) {
                    synchronized (this) {
                        b2 = this.f4298a.a();
                        if (b2 == null) {
                            this.f4300c = false;
                            this.f4300c = false;
                            return;
                        }
                    }
                }
                this.f4299b.a(b2);
            } catch (InterruptedException e) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f4300c = false;
                }
            }
        }
    }
}
