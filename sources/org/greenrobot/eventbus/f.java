package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final i f4312a = new i();

    /* renamed from: b  reason: collision with root package name */
    boolean f4313b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4314c = 10;
    private final c d;

    f(c cVar, Looper looper) {
        super(looper);
        this.d = cVar;
    }

    private void a(n nVar, Object obj) {
        h a2 = h.a(nVar, obj);
        synchronized (this) {
            this.f4312a.a(a2);
            if (!this.f4313b) {
                this.f4313b = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h a2 = this.f4312a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f4312a.a();
                        if (a2 == null) {
                            this.f4313b = false;
                            this.f4313b = false;
                            return;
                        }
                    }
                }
                this.d.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f4314c));
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f4313b = true;
        } catch (Throwable th) {
            this.f4313b = false;
            throw th;
        }
    }
}
