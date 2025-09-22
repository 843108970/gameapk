package com.cyjh.mq.sdk;

import com.cyjh.mobileanjian.ipc.a.b;
import com.cyjh.mobileanjian.ipc.interfaces.OnMqScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnRequestCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mq.sdk.inf.IRunner;
import com.cyjh.mq.sdk.inf.OnElfCallback;
import com.cyjh.mq.sdk.inf.b;
import com.google.protobuf.ByteString;

public class MqRunnerLite implements com.cyjh.mq.sdk.inf.a, b {

    /* renamed from: a  reason: collision with root package name */
    public OnScriptListener f2788a;

    /* renamed from: b  reason: collision with root package name */
    public OnElfCallback f2789b;

    /* renamed from: c  reason: collision with root package name */
    public OnRequestCallback f2790c;
    public boolean d;
    public OnSpecialMqCmdCallback e;
    public OnMqScriptCallback f;
    private Script4Run g;
    private com.cyjh.mobileanjian.ipc.a.b h;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final MqRunnerLite f2791a = new MqRunnerLite((byte) 0);

        private a() {
        }
    }

    private MqRunnerLite() {
        this.f2789b = null;
        this.f2790c = null;
        this.d = true;
        this.h = new com.cyjh.mobileanjian.ipc.a.b();
    }

    /* synthetic */ MqRunnerLite(byte b2) {
        this();
    }

    public static synchronized MqRunnerLite getInstance() {
        MqRunnerLite a2;
        synchronized (MqRunnerLite.class) {
            a2 = a.f2791a;
        }
        return a2;
    }

    public final OnRequestCallback a() {
        return this.f2790c;
    }

    public final void a(int i, int i2) {
        com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
        try {
            bVar.g.put(new b.a(3, "", "", "", "", i, i2, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(OnMqScriptCallback onMqScriptCallback) {
        this.f = onMqScriptCallback;
    }

    public final void a(OnScreenShotCallback onScreenShotCallback) {
    }

    public final void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback) {
        this.e = onSpecialMqCmdCallback;
    }

    public final void a(ByteString byteString) {
    }

    public final void a(String str) {
        com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
        try {
            if (!bVar.f2538c) {
                bVar.d = new b.c("ScriptRunnerLite_Request");
                bVar.d.start();
            }
            bVar.g.put(new b.a(1, str, "", "", "", 0, 0, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, String str2, String str3, OnElfCallback onElfCallback) {
        this.f2789b = onElfCallback;
        com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
        try {
            bVar.g.put(new b.a(2, "", str, str2, str3, 0, 0, ""));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final OnElfCallback b() {
        return this.f2789b;
    }

    public final void b(ByteString byteString) {
    }

    public final void b(String str) {
        com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
        try {
            bVar.g.put(new b.a(4, "", "", "", "", 0, 0, str));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public final void c(ByteString byteString) {
    }

    public final void c(String str) {
    }

    public final boolean c() {
        return this.d;
    }

    public final OnScriptListener d() {
        return this.f2788a;
    }

    public final OnSpecialMqCmdCallback e() {
        return this.e;
    }

    public final OnMqScriptCallback f() {
        return this.f;
    }

    public boolean isScriptStarted() {
        if (this.h == null) {
            return false;
        }
        return this.h.h();
    }

    public void notifyRotationStatus() {
        this.h.g();
    }

    public void pause() {
        if (this.h != null) {
            this.h.e().Pause();
        }
    }

    public void resume() {
        if (this.h != null) {
            this.h.e().Resume();
        }
    }

    public void setImageCrop(boolean z, int i, int i2, int i3, int i4) {
        this.h.f().SetImageCrop(z, i, i2, i3, i4);
    }

    public IRunner setOnScriptListener(OnScriptListener onScriptListener) {
        this.f2788a = onScriptListener;
        if (this.h != null) {
            com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
            if (onScriptListener != null) {
                bVar.f = onScriptListener;
            }
        }
        return this;
    }

    public IRunner setScript(Script4Run script4Run) {
        this.g = script4Run;
        if (this.h != null) {
            com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
            if (script4Run != null) {
                bVar.e = script4Run;
            }
        }
        return this;
    }

    public void start() {
        if (this.h != null) {
            com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
            if (!bVar.f2536a) {
                new b.C0042b(bVar, (byte) 0).start();
            } else if (bVar.f != null) {
                bVar.f.onScriptIsRunning();
            }
        }
    }

    public void stop() {
        if (this.h != null) {
            com.cyjh.mobileanjian.ipc.a.b bVar = this.h;
            new StringBuilder("stop: ").append(bVar.getClass().getSimpleName());
            bVar.e().Stop();
        }
    }
}
