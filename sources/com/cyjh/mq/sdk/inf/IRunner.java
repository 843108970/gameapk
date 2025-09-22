package com.cyjh.mq.sdk.inf;

import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mq.sdk.entity.Script4Run;

public interface IRunner extends c {
    public static final int START_ENIGINE_TIME_OUT_MILLIS = 6000;

    boolean isScriptStarted();

    void notifyRotationStatus();

    void pause();

    void resume();

    IRunner setOnScriptListener(OnScriptListener onScriptListener);

    IRunner setScript(Script4Run script4Run);

    void start();

    void stop();
}
