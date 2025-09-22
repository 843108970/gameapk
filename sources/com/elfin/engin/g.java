package com.elfin.engin;

import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mq.sdk.MqRunnerLite;
import com.cyjh.mq.sdk.inf.IRunner;
import com.cyjh.mq.sdk.inf.OnElfCallback;

public final class g extends b {
    private static void b(String str) {
        MqRunnerLite.getInstance().a(str);
    }

    public final IRunner a() {
        return MqRunnerLite.getInstance();
    }

    public final void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback) {
        MqRunnerLite.getInstance().a(onSpecialMqCmdCallback);
    }

    public final void a(String str) {
    }

    public final void a(String str, String str2, String str3, OnElfCallback onElfCallback) {
        MqRunner.getInstance().a(str, str2, str3, onElfCallback);
        MqRunnerLite.getInstance().a(str, str2, str3, onElfCallback);
    }

    public final void a(boolean z, int i, int i2, int i3, int i4) {
        MqRunnerLite.getInstance().setImageCrop(z, i, i2, i3, i4);
    }
}
