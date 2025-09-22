package com.cyjh.mobileanjian.ipc.interfaces;

public interface ScriptStateObserver {
    void onScriptIsRunning();

    void onStartScript();

    void onStopScript(int i, String str);
}
