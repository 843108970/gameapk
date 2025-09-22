package com.cyjh.mq.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.cyjh.event.Injector;
import com.cyjh.mobileanjian.ipc.interfaces.OnEngineStartCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnKeyEventListener;
import com.cyjh.mobileanjian.ipc.interfaces.RootProgressListener;
import com.cyjh.mobileanjian.ipc.rpc.AndroidHelper;
import com.cyjh.mq.service.IpcService;
import java.io.File;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2746a = "start_eventsrv";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2747b = "start_eventsrvR";

    /* renamed from: c  reason: collision with root package name */
    public static final String f2748c = ".event.localserver";
    public static final String d = "com.cyjh.mobileanjian.ipc.ClientService";
    public static final String e = "DaemonClient.zip";
    public static final String f = "libmqm.so";
    public static Application g;
    public static OnKeyEventListener h;
    public static RootProgressListener i;
    public static OnEngineStartCallback j;

    public static File a() {
        return new File(g.getFilesDir(), f2747b);
    }

    private static void a(Application application, OnKeyEventListener onKeyEventListener, RootProgressListener rootProgressListener, OnEngineStartCallback onEngineStartCallback) {
        if (g == null) {
            g = application;
            h = onKeyEventListener;
            i = rootProgressListener;
            j = onEngineStartCallback;
            Injector.init(application.getApplicationContext());
            AndroidHelper.init(application);
            application.startService(new Intent(application, IpcService.class));
        }
    }

    private static void b() {
        if (g != null) {
            g.stopService(new Intent(g, IpcService.class));
        }
    }

    private static Application c() {
        return g;
    }

    private static Context d() {
        return g.getApplicationContext();
    }

    private static File e() {
        return new File(g.getFilesDir(), f2746a);
    }

    private static OnKeyEventListener f() {
        return h;
    }

    private static RootProgressListener g() {
        return i;
    }

    private static OnEngineStartCallback h() {
        return j;
    }
}
