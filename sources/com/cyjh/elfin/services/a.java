package com.cyjh.elfin.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.e.b.d;
import com.cyjh.elfin.e.c.o;
import com.cyjh.elfin.entity.Script;
import com.cyjh.elfin.floatingwindowprocess.service.FloatingWindowService;
import com.cyjh.http.c.c.r;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.c;

public final class a {
    private static final String e = "ClientAppService";
    private static final a f = new a();

    /* renamed from: a  reason: collision with root package name */
    public Messenger f2081a;

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f2082b = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(a.e, "与服务端连接成功");
            Messenger unused = a.this.f2081a = new Messenger(iBinder);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putInt(com.cyjh.elfin.e.b.a.f1890a, 30000);
            obtain.setData(bundle);
            obtain.replyTo = a.this.d;
            try {
                a.this.f2081a.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public C0030a f2083c = new C0030a();
    public Messenger d = new Messenger(this.f2083c);

    /* renamed from: com.cyjh.elfin.services.a$a  reason: collision with other inner class name */
    public static class C0030a extends Handler {
        public final void handleMessage(Message message) {
            Script script;
            super.handleMessage(message);
            Bundle data = message.getData();
            int i = data.getInt(com.cyjh.elfin.e.b.a.f1890a);
            int i2 = data.getInt(com.cyjh.elfin.e.b.a.f1892c);
            Log.i(a.e, "收到来自服务端的消息：" + i);
            String string = data.getString(com.cyjh.elfin.e.b.a.f1891b);
            if (i2 != 1002 && i2 != 1001) {
                if (i2 == 1003) {
                    new d().executeOnExecutor(Executors.newCachedThreadPool(), new String[]{string});
                } else if (i2 == 1101) {
                    ad.c(a.e, "CMD_ACTION_VOLUME_SCRIPT_START");
                    c.a().c((Object) new com.elf.studio.a.a(10101));
                } else if (i2 == 1004 && o.a() && (script = com.cyjh.elfin.floatingwindowprocess.c.c.f().f2011a) != null) {
                    r.a().a(AppContext.a(), script.getId(), string, new r.a() {
                        public final void a() {
                            ad.c(a.e, "doSpecialFuction --> uploadInstanceData onSuccess");
                        }

                        public final void a(String str) {
                            ad.c(a.e, "doSpecialFuction --> uploadInstanceData onFailure message=" + str);
                        }
                    });
                }
            }
        }
    }

    public static a a() {
        return f;
    }

    private void a(Context context) {
        Intent intent = new Intent(context, FloatingWindowService.class);
        if (this.f2082b != null) {
            context.bindService(intent, this.f2082b, 1);
        }
    }

    private void b(Context context) {
        context.unbindService(this.f2082b);
        this.f2083c = null;
        this.d = null;
        this.f2081a = null;
    }

    public final void a(int i) {
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt(com.cyjh.elfin.e.b.a.f1890a, i);
        obtain.setData(bundle);
        obtain.replyTo = this.d;
        try {
            this.f2081a.send(obtain);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
