package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.util.k;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1182a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1183b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        static final int f1184a = 1;

        a() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((u) message.obj).d();
            return true;
        }
    }

    x() {
    }

    /* access modifiers changed from: package-private */
    public final void a(u<?> uVar) {
        k.a();
        if (this.f1182a) {
            this.f1183b.obtainMessage(1, uVar).sendToTarget();
            return;
        }
        this.f1182a = true;
        uVar.d();
        this.f1182a = false;
    }
}
