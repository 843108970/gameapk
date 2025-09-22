package com.cyjh.elfin.floatingwindowprocess.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.cyjh.elfin.entity.ElfinFloatViewEvent;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.c;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2062c = "ServerAppService";
    private static final a e = new a();

    /* renamed from: a  reason: collision with root package name */
    Messenger f2063a = new Messenger(this.d);

    /* renamed from: b  reason: collision with root package name */
    public Messenger f2064b;
    private C0029a d = new C0029a((byte) 0);

    /* renamed from: com.cyjh.elfin.floatingwindowprocess.service.a$a  reason: collision with other inner class name */
    private static class C0029a extends Handler {
        private C0029a() {
        }

        /* synthetic */ C0029a(byte b2) {
            this();
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.getData().getInt(com.cyjh.elfin.e.b.a.f1890a);
            Log.i(a.f2062c, "收到来自客户端的消息:" + i);
            a.a().f2064b = message.replyTo;
            if (i == 2) {
                c.a().c((Object) new ElfinFloatViewEvent(10101));
            } else if (i == 3) {
                c.a().c((Object) new ElfinFloatViewEvent(10103));
            } else if (i == 4) {
                c.a().c((Object) new ElfinFloatViewEvent(4));
            } else if (i == 7) {
                new com.cyjh.elfin.e.b.c().executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
            }
        }
    }

    public static a a() {
        return e;
    }

    private void a(Messenger messenger) {
        this.f2063a = messenger;
    }

    private void a(C0029a aVar) {
        this.d = aVar;
    }

    private C0029a b() {
        return this.d;
    }

    private void b(Messenger messenger) {
        this.f2064b = messenger;
    }

    private Messenger c() {
        return this.f2063a;
    }

    private Messenger d() {
        return this.f2064b;
    }

    private void e() {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(com.cyjh.elfin.e.b.a.f1892c, com.cyjh.elfin.e.b.a.n);
        obtain.setData(bundle);
        try {
            this.f2064b.send(obtain);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(com.cyjh.elfin.e.b.a.f1890a, i);
        obtain.setData(bundle);
        try {
            this.f2064b.send(obtain);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(int i, int i2, String str) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(com.cyjh.elfin.e.b.a.f1890a, i);
        bundle.putString(com.cyjh.elfin.e.b.a.f1891b, str);
        bundle.putInt(com.cyjh.elfin.e.b.a.f1892c, i2);
        obtain.setData(bundle);
        try {
            this.f2064b.send(obtain);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
