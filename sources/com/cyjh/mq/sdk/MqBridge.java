package com.cyjh.mq.sdk;

import android.app.Application;
import android.content.Intent;
import com.cyjh.event.Injector;
import com.cyjh.mobileanjian.ipc.interfaces.OnEngineStartCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnKeyEventListener;
import com.cyjh.mobileanjian.ipc.interfaces.RootProgressListener;
import com.cyjh.mobileanjian.ipc.log.b;
import com.cyjh.mobileanjian.ipc.rpc.AndroidHelper;
import com.cyjh.mq.a.a;
import com.cyjh.mq.service.IpcService;

public class MqBridge {
    public static void exit() {
        if (a.g != null) {
            a.g.stopService(new Intent(a.g, IpcService.class));
        }
    }

    public static void init(Application application, String str, String str2, OnKeyEventListener onKeyEventListener, RootProgressListener rootProgressListener, OnEngineStartCallback onEngineStartCallback) {
        if (a.g == null) {
            a.g = application;
            a.h = onKeyEventListener;
            a.i = rootProgressListener;
            a.j = onEngineStartCallback;
            Injector.init(application.getApplicationContext());
            AndroidHelper.init(application);
            application.startService(new Intent(application, IpcService.class));
        }
        b.a(application, str, str2);
    }
}
