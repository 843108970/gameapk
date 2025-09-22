package com.elfin.engin;

import android.util.Log;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mq.sdk.inf.IRunner;
import com.cyjh.mq.sdk.inf.OnElfCallback;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2894a = "ScriptRunnerManager";

    private void a(OnScriptListener onScriptListener) {
        a().setOnScriptListener(onScriptListener);
    }

    private boolean b() {
        return a().isScriptStarted();
    }

    private void c() {
        a().start();
    }

    private void d() {
        a().stop();
    }

    private void e() {
        a().pause();
    }

    private void f() {
        a().resume();
    }

    public abstract IRunner a();

    public abstract void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback);

    public final void a(Script4Run script4Run) {
        Log.i("EnginSdk", "EnginRunnerApi -> EnginSdk -> " + script4Run);
        a().setScript(script4Run);
    }

    public abstract void a(String str);

    public abstract void a(String str, String str2, String str3, OnElfCallback onElfCallback);

    public abstract void a(boolean z, int i, int i2, int i3, int i4);
}
