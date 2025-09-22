package com.cyjh.mobileanjian.ipc.interfaces;

import com.cyjh.mq.c.b;

public interface EngineStateObserver {
    void onConnected(b bVar);

    void onCrash(com.cyjh.mobileanjian.ipc.b bVar);

    void onExit();
}
