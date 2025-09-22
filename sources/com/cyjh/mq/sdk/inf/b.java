package com.cyjh.mq.sdk.inf;

import com.cyjh.mobileanjian.ipc.interfaces.OnMqScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;

public interface b extends IRunner {
    boolean c();

    OnScriptListener d();

    OnSpecialMqCmdCallback e();

    OnMqScriptCallback f();
}
