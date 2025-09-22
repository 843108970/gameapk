package com.cyjh.mobileanjian.ipc.a;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.cyjh.event.Injector;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.log.NativeLog;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mqm.MQLanguageStub;
import com.cyjh.mqsdk.R;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

public final class b implements a {
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private static final int k = 25;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f2536a = false;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f2537b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2538c = false;
    public c d;
    public Script4Run e;
    public OnScriptListener f;
    public ArrayBlockingQueue<a> g = new ArrayBlockingQueue<>(4);
    private MQLanguageStub l;
    private Handler m = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (b.this.f != null) {
                        b.this.f.onStartScript();
                        return;
                    }
                    return;
                case 2:
                    if (b.this.f != null) {
                        b.this.f.onStopScript(message.arg1, (String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    Toast.makeText(com.cyjh.mq.a.a.g.getApplicationContext(), (String) message.obj, 1).show();
                    return;
                default:
                    return;
            }
        }
    };
    private MQLanguageStub.MQAuxiliary n = null;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f2540a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f2541b = 1;

        /* renamed from: c  reason: collision with root package name */
        public static final int f2542c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 16;
        public int g;
        public String h;
        public String i;
        public String j;
        public String k;
        public int l;
        public int m;
        public String n;

        public a(int i2, String str, String str2, String str3, String str4, int i3, int i4, String str5) {
            this.g = i2;
            this.h = str;
            this.i = str2;
            this.j = str3;
            this.k = str4;
            this.l = i3;
            this.m = i4;
            this.n = str5;
        }

        public final String toString() {
            return "";
        }
    }

    /* renamed from: com.cyjh.mobileanjian.ipc.a.b$b  reason: collision with other inner class name */
    private class C0042b extends Thread {
        private C0042b() {
        }

        public /* synthetic */ C0042b(b bVar, byte b2) {
            this();
        }

        public final void run() {
            if (b.this.e != null) {
                Looper.prepare();
                b.a(b.this);
                Looper.myLooper().quit();
                Looper.loop();
            }
        }
    }

    private class c extends Thread {
        public c(String str) {
            super(str);
        }

        public final void run() {
            Looper.prepare();
            b.this.f2538c = true;
            while (com.cyjh.mq.a.a.g != null) {
                try {
                    a take = b.this.g.take();
                    new StringBuilder("Take Request:\n").append(take);
                    switch (take.g) {
                        case 0:
                            b.a(b.this);
                            break;
                        case 1:
                            b.this.e();
                            MQLanguageStub.InitHost(take.h);
                            b.this.f2537b = true;
                            break;
                        case 2:
                            b.this.e();
                            MQLanguageStub.InitElf(com.cyjh.mq.a.a.g, take.i, take.j, take.k);
                            break;
                        case 3:
                            b.this.e();
                            MQLanguageStub.SetHeartBeatTime(take.l, take.m);
                            break;
                        case 4:
                            b.this.e();
                            MQLanguageStub.SetRegCode(take.n);
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Looper.myLooper().quit();
            Looper.loop();
            b.this.f2538c = false;
        }
    }

    private void a(int i2, int i3) {
        try {
            this.g.put(new a(3, "", "", "", "", i2, i3, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ void a(b bVar) {
        if (bVar.e != null) {
            bVar.f2536a = true;
            bVar.m.obtainMessage(1).sendToTarget();
            bVar.c(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_on_start_script));
            bVar.g();
            int Run = bVar.e().Run(bVar.e.getLcPath(), bVar.e.getAtcPath(), bVar.e.getConfigPath(), bVar.e.getAppId(), bVar.e.getScriptEncryptKey(), bVar.e.getTrialTime(), bVar.e.getEncryptKey());
            if (Run == 102) {
                bVar.c(String.format(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_run_failed), new Object[]{Integer.valueOf(Run)}));
            }
            if (bVar.m != null) {
                Message obtainMessage = bVar.m.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = Run;
                obtainMessage.obj = NativeLog.getExtraLog();
                bVar.m.sendMessage(obtainMessage);
            }
            bVar.c(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_on_stop_script));
            com.cyjh.event.c.c();
            Injector.release();
            NativeLog.reset();
            bVar.f2536a = false;
        }
    }

    private void a(OnScriptListener onScriptListener) {
        if (onScriptListener != null) {
            this.f = onScriptListener;
        }
    }

    private void a(Script4Run script4Run) {
        if (script4Run != null) {
            this.e = script4Run;
        }
    }

    private void a(String str) {
        try {
            if (!this.f2538c) {
                this.d = new c("ScriptRunnerLite_Request");
                this.d.start();
            }
            this.g.put(new a(1, str, "", "", "", 0, 0, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str, String str2, String str3) {
        try {
            this.g.put(new a(2, "", str, str2, str3, 0, 0, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
        f().SetImageCrop(z, i2, i3, i4, i5);
    }

    private void b(String str) {
        try {
            this.g.put(new a(4, "", "", "", "", 0, 0, str));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private void c(String str) {
        this.m.obtainMessage(3, str).sendToTarget();
    }

    private void i() {
        if (this.e != null) {
            this.f2536a = true;
            this.m.obtainMessage(1).sendToTarget();
            c(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_on_start_script));
            g();
            int Run = e().Run(this.e.getLcPath(), this.e.getAtcPath(), this.e.getConfigPath(), this.e.getAppId(), this.e.getScriptEncryptKey(), this.e.getTrialTime(), this.e.getEncryptKey());
            if (Run == 102) {
                c(String.format(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_run_failed), new Object[]{Integer.valueOf(Run)}));
            }
            if (this.m != null) {
                Message obtainMessage = this.m.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = Run;
                obtainMessage.obj = NativeLog.getExtraLog();
                this.m.sendMessage(obtainMessage);
            }
            c(com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_on_stop_script));
            com.cyjh.event.c.c();
            Injector.release();
            NativeLog.reset();
            this.f2536a = false;
        }
    }

    public final void a() {
        if (!this.f2536a) {
            new C0042b(this, (byte) 0).start();
        } else if (this.f != null) {
            this.f.onScriptIsRunning();
        }
    }

    public final void b() {
        e().Resume();
    }

    public final void c() {
        e().Pause();
    }

    public final void d() {
        new StringBuilder("stop: ").append(getClass().getSimpleName());
        e().Stop();
    }

    public final MQLanguageStub e() {
        if (this.l == null) {
            this.l = new MQLanguageStub();
            new StringBuilder("Application: ").append(com.cyjh.mq.a.a.g);
            File file = new File(Environment.getExternalStorageDirectory(), com.cyjh.mq.a.a.g.getPackageName());
            if (!file.exists()) {
                file.mkdir();
            }
            this.l.SetLocalDir(Environment.getExternalStorageDirectory().getAbsolutePath(), file.getAbsolutePath(), new File(com.cyjh.mq.a.a.g.getApplicationContext().getFilesDir().getParent(), "lib").getAbsolutePath());
            this.l.SetWriteLog2File(true);
        }
        return this.l;
    }

    public final MQLanguageStub.MQAuxiliary f() {
        if (this.n == null) {
            MQLanguageStub e2 = e();
            e2.getClass();
            this.n = new MQLanguageStub.MQAuxiliary();
        }
        return this.n;
    }

    public final void g() {
        f().SetScreenRotation(((WindowManager) com.cyjh.mq.a.a.g.getSystemService("window")).getDefaultDisplay().getRotation());
    }

    public final synchronized boolean h() {
        return this.f2536a;
    }
}
