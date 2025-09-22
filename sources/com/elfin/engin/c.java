package com.elfin.engin;

import android.app.Application;
import android.util.Log;
import com.cyjh.common.util.aj;
import com.cyjh.mobileanjian.ipc.interfaces.OnEngineStartCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnKeyEventListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mobileanjian.ipc.interfaces.RootProgressListener;
import com.cyjh.mq.sdk.MqBridge;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mq.sdk.inf.OnElfCallback;
import com.goldcoast.sdk.domain.AnalyseResult;
import com.goldcoast.sdk.domain.EntryPoint;

public final class c {
    private static final String l = "EnginRunnerManager";
    private static final c o = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f2901a = false;

    /* renamed from: b  reason: collision with root package name */
    public b f2902b;

    /* renamed from: c  reason: collision with root package name */
    public int f2903c;
    public f d;
    public g e;
    public e f;
    public OnKeyEventListener g = new OnKeyEventListener() {
        public final void onKeyEvent(int i) {
            if (c.this.f != null) {
                c.this.f.b(i);
            }
        }
    };
    public OnEngineStartCallback h = new OnEngineStartCallback() {
        public final void onEngineStart(int i) {
            boolean unused = c.this.f2901a = true;
            if (c.this.f != null) {
                c.this.f.a();
            }
        }
    };
    public OnScriptListener i = new OnScriptListener() {
        public final void onPause() {
            if (c.this.f != null) {
                c.this.f.c();
            }
        }

        public final void onResume() {
            if (c.this.f != null) {
                c.this.f.d();
            }
        }

        public final void onScriptIsRunning() {
            if (c.this.f != null) {
                c.this.f.e();
            }
        }

        public final void onSetControlBarVisiable(int i) {
            if (c.this.f != null) {
                c.this.f.a(i);
            }
        }

        public final void onStartScript() {
            if (c.this.f != null) {
                c.this.f.b();
            }
        }

        public final void onStopScript(int i, String str) {
            if (c.this.f != null) {
                c.this.f.b(i, str);
            }
        }

        public final void onUpdateControlBarPos(float f, int i, int i2) {
            if (c.this.f != null) {
                c.this.f.a(f, i, i2);
            }
        }
    };
    public OnElfCallback j = new OnElfCallback() {
        public final void callback(int i, String str) {
            if (c.this.f != null) {
                c.this.f.a(i, str);
            }
        }
    };
    public OnSpecialMqCmdCallback k = new OnSpecialMqCmdCallback() {
        public final void doSpecialFuction(int i, String str) {
            if (c.this.f != null) {
                c.this.f.d(str);
            }
        }

        public final String getForegroundPackage() {
            if (c.this.f != null) {
                return c.this.f.f();
            }
            return null;
        }

        public final String getRunningPackages() {
            if (c.this.f != null) {
                return c.this.f.g();
            }
            return null;
        }

        public final void inputText(String str) {
            if (c.this.f != null) {
                c.this.f.c(str);
            }
        }

        public final void keyPress(int i) {
            if (c.this.f != null) {
                c.this.f.c(i);
            }
        }

        public final void killApp(String str) {
            if (c.this.f != null) {
                c.this.f.b(str);
            }
        }

        public final void launchApp(String str) {
            if (c.this.f != null) {
                c.this.f.a(str);
            }
        }
    };
    private boolean m;
    private RootProgressListener n = new RootProgressListener() {
        public final void onRootProgress(String str, int i) {
            e unused = c.this.f;
        }
    };

    public static c a() {
        return o;
    }

    private void a(int i2) {
        b bVar;
        this.f2903c = i2;
        if (this.f2903c == 0) {
            if (this.d == null) {
                this.d = new f();
            }
            bVar = this.d;
        } else {
            if (this.e == null) {
                this.e = new g();
            }
            bVar = this.e;
        }
        this.f2902b = bVar;
    }

    private void a(Application application) {
        EntryPoint.init(application, "", (AnalyseResult) null, 10, (byte) 0);
        this.d = new f();
        this.f2902b = this.d;
    }

    private void a(final Application application, String str, String str2, e eVar) {
        this.f = eVar;
        MqBridge.init(application, str, str2, this.g, new RootProgressListener() {
            public final void onRootProgress(String str, int i) {
                if (i == 6) {
                    aj.INSTANCE.copyWebInjectFile(application);
                }
            }
        }, this.h);
        this.f2902b.a(this.k);
        b bVar = this.f2902b;
        bVar.a().setOnScriptListener(this.i);
    }

    private void a(String str) {
        if (this.f2902b != null) {
            this.f2902b.a(str);
        }
    }

    private void a(String str, String str2, String str3) {
        this.f2902b.a(str, str2, str3, this.j);
    }

    private void a(String str, String str2, String str3, int i2, long j2, String str4, String str5, String str6) {
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        script4Run.trialTime = i2;
        script4Run.encryptKey = j2;
        Log.e("zzz", "runScript--script4Run.scripyEncryptKey:" + script4Run.getScriptEncryptKey());
        script4Run.appId = str5;
        script4Run.username = str6;
        script4Run.encrypt = true;
        if (this.f2902b != null) {
            this.f2902b.a(script4Run);
        }
    }

    private void a(String str, String str2, String str3, String str4) {
        Script4Run script4Run = new Script4Run();
        script4Run.setLcPath(str);
        script4Run.setAtcPath(str2);
        script4Run.setConfigPath(str3);
        script4Run.setScriptEncryptKey(str4);
        if (this.f2902b != null) {
            this.f2902b.a(script4Run);
        }
    }

    private void a(boolean z) {
        this.f2901a = z;
    }

    private void a(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f2902b != null) {
            this.f2902b.a(z, i2, i3, i4, i5);
        }
    }

    private boolean b() {
        return this.f2901a;
    }

    private void c() {
        if (this.f2902b != null) {
            this.f2902b.a(this.k);
            this.f2902b.a().start();
        }
    }

    private void d() {
        if (this.f2902b != null) {
            this.f2902b.a().pause();
        }
    }

    private void e() {
        if (this.f2902b != null) {
            this.f2902b.a().resume();
        }
    }

    private void f() {
        if (this.f2902b != null) {
            this.f2902b.a().stop();
        }
    }

    private boolean g() {
        if (this.f2902b != null) {
            return this.f2902b.a().isScriptStarted();
        }
        return false;
    }
}
