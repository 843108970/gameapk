package com.cyjh.mobileanjian.ipc.interfaces;

public interface BasicScriptListener {
    void onPause();

    void onResume();

    void onScriptIsRunning();

    void onStartScript();

    void onStopScript(int i, String str);
}
