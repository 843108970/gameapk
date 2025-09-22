package com.cyjh.mq.sdk;

import android.widget.Toast;
import com.cyjh.mobileanjian.ipc.interfaces.OnMqScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnRequestCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import com.cyjh.mq.c.b;
import com.cyjh.mq.sdk.inf.OnElfCallback;
import com.cyjh.mqm.MQLanguageStub;
import com.cyjh.mqsdk.R;

public class MqRunner extends a implements com.cyjh.mq.sdk.inf.a {
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private OnElfCallback k;
    private OnMqScriptCallback l;
    private boolean m = false;
    private int n;
    private int o;
    private int p;
    private int q;
    private OnScreenShotCallback r;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final MqRunner f2787a = new MqRunner();

        private a() {
        }
    }

    public static synchronized MqRunner getInstance() {
        MqRunner a2;
        synchronized (MqRunner.class) {
            a2 = a.f2787a;
        }
        return a2;
    }

    public final OnRequestCallback a() {
        return null;
    }

    public final void a(int i2, int i3) {
        this.n = i2;
        this.o = i3;
        if (this.e) {
            a(Ipc.IpcMessage.newBuilder().setCmd(84).addArg1(i2).addArg1(i3).build());
        }
    }

    public final void a(OnMqScriptCallback onMqScriptCallback) {
        this.l = onMqScriptCallback;
        if (this.f2793b != null) {
            this.f2793b.n = onMqScriptCallback;
        }
    }

    public final void a(OnScreenShotCallback onScreenShotCallback) {
        if (this.f2793b == null) {
            this.p = 1;
            this.q = 3000;
            this.r = onScreenShotCallback;
            return;
        }
        this.f2793b.d = true;
        this.f2793b.i = onScreenShotCallback;
        this.f2793b.a(Ipc.IpcMessage.newBuilder().setCmd(24).addArg1(1).build());
    }

    public final void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback) {
        if (this.e) {
            this.f2793b.q = onSpecialMqCmdCallback;
        }
    }

    public final void a(String str) {
        MQLanguageStub.InitHost(str);
        if (this.e) {
            a(Ipc.IpcMessage.newBuilder().setCmd(83).addArg2(str).build());
        } else {
            this.g = str;
        }
    }

    public final void a(String str, String str2, String str3, OnElfCallback onElfCallback) {
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = onElfCallback;
        MQLanguageStub.InitElf(com.cyjh.mq.a.a.g, str, str2, str3);
        if (this.e) {
            this.f2793b.o = onElfCallback;
            a(Ipc.IpcMessage.newBuilder().setCmd(80).addArg2(str).addArg2(str2).addArg2(str3).build());
        }
    }

    public final OnElfCallback b() {
        return null;
    }

    public final void b(String str) {
        a(Ipc.IpcMessage.newBuilder().setCmd(82).addArg2(str).build());
    }

    public void onConnected(b bVar) {
        super.onConnected(bVar);
        bVar.o = this.k;
        OnMqScriptCallback onMqScriptCallback = this.l;
        this.l = onMqScriptCallback;
        if (this.f2793b != null) {
            this.f2793b.n = onMqScriptCallback;
        }
        a(Ipc.IpcMessage.newBuilder().setCmd(80).addArg2(this.h).addArg2(this.i).addArg2(this.j).build());
        int i2 = this.n;
        int i3 = this.o;
        this.n = i2;
        this.o = i3;
        if (this.e) {
            a(Ipc.IpcMessage.newBuilder().setCmd(84).addArg1(i2).addArg1(i3).build());
        }
    }

    public void onCrash(com.cyjh.mobileanjian.ipc.b bVar) {
        this.e = false;
        c();
    }

    public void onExit() {
        this.e = false;
    }

    public void start() {
        if (!this.e) {
            Toast.makeText(com.cyjh.mq.a.a.g.getApplicationContext(), com.cyjh.mq.a.a.g.getApplicationContext().getString(R.string.toast_script_engine_failed_start), 1).show();
            return;
        }
        notifyRotationStatus();
        a(com.cyjh.mobileanjian.ipc.share.proto.b.a(1));
    }
}
