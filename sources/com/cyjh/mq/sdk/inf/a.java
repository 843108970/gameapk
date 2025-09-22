package com.cyjh.mq.sdk.inf;

import com.cyjh.mobileanjian.ipc.interfaces.OnMqScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;

public interface a {
    void a(int i, int i2);

    void a(OnMqScriptCallback onMqScriptCallback);

    void a(OnScreenShotCallback onScreenShotCallback);

    void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback);

    void a(String str);

    void a(String str, String str2, String str3, OnElfCallback onElfCallback);

    void b(String str);
}
