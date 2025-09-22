package com.cyjh.http.a;

import android.os.Message;
import com.cyjh.common.util.ad;
import java.util.Timer;
import java.util.TimerTask;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f2457a = "b";
    public static final int e = 1000;
    public static final int f = 180000;
    public static final int g = 7200000;
    private static b h;

    /* renamed from: b  reason: collision with root package name */
    public a f2458b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f2459c;
    public C0038b d;

    public interface a {
        void a(Message message);
    }

    /* renamed from: com.cyjh.http.a.b$b  reason: collision with other inner class name */
    private class C0038b extends TimerTask {
        private C0038b() {
        }

        public /* synthetic */ C0038b(b bVar, byte b2) {
            this();
        }

        public final void run() {
            Message message = new Message();
            message.what = 1000;
            if (b.this.f2458b != null) {
                b.this.f2458b.a(message);
            }
        }
    }

    private b() {
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    private b a(a aVar) {
        this.f2458b = aVar;
        return this;
    }

    private void c() {
        ad.a(f2457a, "startTimer --> ");
        if (this.f2459c == null) {
            this.f2459c = new Timer();
            this.d = new C0038b(this, (byte) 0);
        }
        this.f2459c.schedule(this.d, 180000, 7200000);
    }

    public final void b() {
        ad.a(f2457a, "stopTimer --> ");
        if (this.f2459c != null) {
            this.f2459c.cancel();
            this.f2459c = null;
        }
    }
}
