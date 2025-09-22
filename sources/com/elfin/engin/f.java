package com.elfin.engin;

import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mq.sdk.inf.IRunner;
import com.cyjh.mq.sdk.inf.OnElfCallback;

public final class f extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2914a = "MqRunnerApi";

    private static void a(String str, String str2, String str3) {
        MqRunner.getInstance().a(str, str2, str3, (OnElfCallback) null);
    }

    private static void b(String str) {
        MqRunner.getInstance().a(str);
    }

    public final IRunner a() {
        return MqRunner.getInstance();
    }

    public final void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback) {
        MqRunner.getInstance().a(onSpecialMqCmdCallback);
    }

    public final void a(String str) {
        MqRunner.getInstance().b(str);
    }

    public final void a(String str, String str2, String str3, OnElfCallback onElfCallback) {
        MqRunner.getInstance().a(str, str2, str3, onElfCallback);
    }

    public final void a(boolean z, int i, int i2, int i3, int i4) {
    }
}
