package com.cyjh.mq.c;

import android.content.Context;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.HandlerThread;
import com.cyjh.mobileanjian.ipc.interfaces.AppQuitListener;
import com.cyjh.mobileanjian.ipc.interfaces.EngineStateObserver;
import com.cyjh.mobileanjian.ipc.share.proto.b;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public final class c implements AppQuitListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f2764b = 10092;

    /* renamed from: a  reason: collision with root package name */
    public List<EngineStateObserver> f2765a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ServerSocket f2766c = null;
    private LocalServerSocket d = null;
    /* access modifiers changed from: private */
    public b e = null;
    /* access modifiers changed from: private */
    public Context f = null;
    /* access modifiers changed from: private */
    public boolean g = false;

    public c(Context context) {
        this.f = context;
    }

    private void a(EngineStateObserver engineStateObserver) {
        this.f2765a.add(engineStateObserver);
    }

    private void b(EngineStateObserver engineStateObserver) {
        this.f2765a.remove(engineStateObserver);
    }

    public final void a(String str, int i) {
        while (this.f2766c == null) {
            try {
                this.f2766c = new ServerSocket(i);
            } catch (IOException e2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                e2.printStackTrace();
            }
        }
        try {
            new HandlerThread("server socket thread") {
                /* access modifiers changed from: protected */
                public final void onLooperPrepared() {
                    super.onLooperPrepared();
                    while (!c.this.g) {
                        try {
                            Socket accept = c.this.f2766c.accept();
                            if (c.this.e == null || !c.this.e.f2759b) {
                                b unused = c.this.e = new b(c.this.f, accept);
                                c.this.e.g = c.this.f2765a;
                                c.this.e.b();
                            } else {
                                accept.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    c.this.f2766c.close();
                }
            }.start();
            this.d = new LocalServerSocket(str);
            while (!this.g) {
                LocalSocket accept = this.d.accept();
                if (this.e == null || !this.e.f2759b) {
                    this.e = new b(this.f, accept);
                    this.e.g = this.f2765a;
                    this.e.b();
                } else {
                    this.e.a();
                }
            }
            this.d.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public final void onAppQuit() {
        if (!this.g) {
            this.g = true;
            try {
                if (this.e != null) {
                    this.e.a(b.a(65535));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
