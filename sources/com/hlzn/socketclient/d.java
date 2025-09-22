package com.hlzn.socketclient;

import com.hlzn.socketclient.service.SocketService;
import java.util.Timer;
import java.util.TimerTask;

public class d extends Timer {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3437a = "d";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f3438b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f3439c;
    private a d = new a(this, (byte) 0);
    /* access modifiers changed from: private */
    public SocketService e;

    private class a extends TimerTask {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void run() {
            SocketService a2 = d.this.e;
            if (!(a2.f3460b == null || !a2.f3460b.isConnected())) {
                d.c(d.this);
                String str = d.f3437a;
                com.hlzn.socketclient.f.d.b(str, "MsgTimeoutTask run --> currentResendCount =" + d.this.f3439c);
                int d = d.this.f3439c;
                SocketService unused = d.this.e;
                if (d > SocketService.b()) {
                    try {
                        d.this.e.k.a(String.valueOf(d.this.f3438b));
                    } finally {
                        d.this.e.c();
                        int unused2 = d.this.f3439c = 0;
                    }
                }
            } else if (d.this.e.k != null) {
                d.this.e.k.a(d.this.f3438b);
            }
        }
    }

    public d(SocketService socketService, String str) {
        this.e = socketService;
        this.f3438b = str;
        schedule(this.d, 1000, 5000);
    }

    static /* synthetic */ int c(d dVar) {
        int i = dVar.f3439c;
        dVar.f3439c = i + 1;
        return i;
    }
}
