package com.cyjh.mq.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import com.cyjh.event.Injector;
import com.cyjh.mobileanjian.ipc.d;
import com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback;
import com.cyjh.mobileanjian.ipc.rpc.AndroidHelper;
import com.cyjh.mobileanjian.ipc.utils.FileUtils;
import com.cyjh.mobileanjian.ipc.utils.RomUtils;
import com.cyjh.mobileanjian.ipc.utils.r;
import com.cyjh.mobileanjian.screencap.ScreenShoterV3;
import com.cyjh.mq.a.a;
import com.cyjh.mq.c.c;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mq.sdk.MqRunnerLite;
import com.cyjh.mqsdk.R;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.UUID;

public class IpcService extends Service {
    private static final String f = "mqm_engine";
    private static final String g = "ipc_server_port";
    private static final String h = "/system/bin/app_process32";
    private static final String i = "elfinject";
    private static final String j = "model";
    private static final String k = "code_cache";
    private static final String l = "secondary-dexes";
    private static final String m = "mycache";
    private static final String n = "dalvik-cache";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f2797a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2798b;

    /* renamed from: c  reason: collision with root package name */
    private String f2799c = "";
    private String d = "";
    /* access modifiers changed from: private */
    public c e;

    private void a() {
        String absolutePath = getApplicationContext().getFilesDir().getAbsolutePath();
        new File(absolutePath).setExecutable(true, false);
        this.f2797a = UUID.randomUUID().toString();
        this.f2798b = g();
        String str = getFilesDir().getAbsolutePath() + File.separator + a.e;
        String makeAbsolutePath = FileUtils.makeAbsolutePath(getApplicationInfo().dataDir, "lib", a.f);
        String str2 = "app_process";
        if (new File(h).exists()) {
            str2 = h;
        }
        File file = new File(FileUtils.makeAbsolutePath(getApplicationInfo().dataDir, m, n));
        file.mkdirs();
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, false);
        file.getParentFile().setReadable(true, false);
        file.getParentFile().setWritable(true, false);
        file.getParentFile().setExecutable(true, false);
        this.f2799c = "export CLASSPATH=" + str + "\n" + String.format("exec %s %s %s %s %s %s &\n", new Object[]{str2, absolutePath, a.d, this.f2797a, makeAbsolutePath, Integer.valueOf(this.f2798b)});
        if (RomUtils.isOppoR9S()) {
            this.f2799c = "export CLASSPATH=" + str + "\n" + String.format("exec %s -Xnodex2oat %s %s %s %s %s &\n", new Object[]{str2, absolutePath, a.d, this.f2797a, makeAbsolutePath, Integer.valueOf(this.f2798b)});
        }
        this.d = "export ANDROID_DATA=" + file.getParent() + "\n" + this.f2799c + "\necho Okay";
    }

    private void b() {
        File dir = getDir(j, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            for (String str : getResources().getAssets().list(j)) {
                File file = new File(dir, str);
                FileUtils.copyAssetsFile(this, new File(j, str).getPath(), file.getAbsolutePath());
                if (file.exists()) {
                    file.setReadable(true, false);
                }
            }
            File file2 = new File(getFilesDir(), a.e);
            FileUtils.copyAssetsFile(this, a.e, file2.getAbsolutePath());
            file2.setReadable(true, false);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        FileUtils.copyRawFile(this, r.b(this) ? R.raw.elfinject_x86 : R.raw.elfinject_arm, getFilesDir().getAbsolutePath() + File.separator + i);
    }

    private void d() {
        File externalFilesDir;
        File filesDir = getFilesDir();
        File file = new File(filesDir, a.f2746a);
        FileUtils.writeStringToFile(file, this.d);
        file.setReadable(true, false);
        file.setExecutable(true, false);
        new StringBuilder("execute command mRootScriptContent: ").append(this.f2799c);
        FileUtils.writeStringToFile(new File(filesDir, a.f2747b), this.f2799c);
        a.a().setExecutable(true, false);
        if (Build.VERSION.SDK_INT >= 23 && (externalFilesDir = getExternalFilesDir((String) null)) != null && externalFilesDir.exists()) {
            FileUtils.writeStringToFile(new File(externalFilesDir, a.f2746a), this.d);
        }
    }

    static /* synthetic */ void d(IpcService ipcService) {
        File dir = ipcService.getDir(j, 0);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            for (String str : ipcService.getResources().getAssets().list(j)) {
                File file = new File(dir, str);
                FileUtils.copyAssetsFile(ipcService, new File(j, str).getPath(), file.getAbsolutePath());
                if (file.exists()) {
                    file.setReadable(true, false);
                }
            }
            File file2 = new File(ipcService.getFilesDir(), a.e);
            FileUtils.copyAssetsFile(ipcService, a.e, file2.getAbsolutePath());
            file2.setReadable(true, false);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        new HandlerThread("ipcserver_thread") {
            /* access modifiers changed from: protected */
            public final void onLooperPrepared() {
                super.onLooperPrepared();
                c unused = IpcService.this.e = new c(IpcService.this);
                c a2 = IpcService.this.e;
                a2.f2765a.add(MqRunner.getInstance());
                IpcService.this.e.a(IpcService.this.f2797a, IpcService.this.f2798b);
            }
        }.start();
    }

    static /* synthetic */ void e(IpcService ipcService) {
        FileUtils.copyRawFile(ipcService, r.b(ipcService) ? R.raw.elfinject_x86 : R.raw.elfinject_arm, ipcService.getFilesDir().getAbsolutePath() + File.separator + i);
    }

    private void f() {
        new Thread("startRootRequest") {
            public final void run() {
                super.run();
                IpcService.d(IpcService.this);
                IpcService.e(IpcService.this);
                IpcService.f(IpcService.this);
                d.a().a((OnRootApplyCallback) MqRunner.getInstance());
            }
        }.start();
    }

    static /* synthetic */ void f(IpcService ipcService) {
        File externalFilesDir;
        File filesDir = ipcService.getFilesDir();
        File file = new File(filesDir, a.f2746a);
        FileUtils.writeStringToFile(file, ipcService.d);
        file.setReadable(true, false);
        file.setExecutable(true, false);
        new StringBuilder("execute command mRootScriptContent: ").append(ipcService.f2799c);
        FileUtils.writeStringToFile(new File(filesDir, a.f2747b), ipcService.f2799c);
        a.a().setExecutable(true, false);
        if (Build.VERSION.SDK_INT >= 23 && (externalFilesDir = ipcService.getExternalFilesDir((String) null)) != null && externalFilesDir.exists()) {
            FileUtils.writeStringToFile(new File(externalFilesDir, a.f2746a), ipcService.d);
        }
    }

    private static int g() {
        int i2 = com.cyjh.mqsdk.a.i;
        int i3 = 0;
        while (i3 < 9) {
            try {
                new ServerSocket(i2).close();
                return i2;
            } catch (UnknownHostException e2) {
                i2++;
                e2.printStackTrace();
            } catch (IOException e3) {
                i2++;
                e3.printStackTrace();
            }
        }
        return i2;
        i3++;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MqRunner.getInstance().notifyRotationStatus();
        MqRunnerLite.getInstance().notifyRotationStatus();
        ScreenShoterV3.getInstance().updateScreenSize();
    }

    public void onCreate() {
        super.onCreate();
        AndroidHelper.init(getApplicationContext());
        Injector.init(getApplicationContext());
        String absolutePath = getApplicationContext().getFilesDir().getAbsolutePath();
        new File(absolutePath).setExecutable(true, false);
        this.f2797a = UUID.randomUUID().toString();
        this.f2798b = g();
        String str = getFilesDir().getAbsolutePath() + File.separator + a.e;
        String makeAbsolutePath = FileUtils.makeAbsolutePath(getApplicationInfo().dataDir, "lib", a.f);
        String str2 = "app_process";
        if (new File(h).exists()) {
            str2 = h;
        }
        File file = new File(FileUtils.makeAbsolutePath(getApplicationInfo().dataDir, m, n));
        file.mkdirs();
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, false);
        file.getParentFile().setReadable(true, false);
        file.getParentFile().setWritable(true, false);
        file.getParentFile().setExecutable(true, false);
        this.f2799c = "export CLASSPATH=" + str + "\n" + String.format("exec %s %s %s %s %s %s &\n", new Object[]{str2, absolutePath, a.d, this.f2797a, makeAbsolutePath, Integer.valueOf(this.f2798b)});
        if (RomUtils.isOppoR9S()) {
            this.f2799c = "export CLASSPATH=" + str + "\n" + String.format("exec %s -Xnodex2oat %s %s %s %s %s &\n", new Object[]{str2, absolutePath, a.d, this.f2797a, makeAbsolutePath, Integer.valueOf(this.f2798b)});
        }
        this.d = "export ANDROID_DATA=" + file.getParent() + "\n" + this.f2799c + "\necho Okay";
        new HandlerThread("ipcserver_thread") {
            /* access modifiers changed from: protected */
            public final void onLooperPrepared() {
                super.onLooperPrepared();
                c unused = IpcService.this.e = new c(IpcService.this);
                c a2 = IpcService.this.e;
                a2.f2765a.add(MqRunner.getInstance());
                IpcService.this.e.a(IpcService.this.f2797a, IpcService.this.f2798b);
            }
        }.start();
        new Thread("startRootRequest") {
            public final void run() {
                super.run();
                IpcService.d(IpcService.this);
                IpcService.e(IpcService.this);
                IpcService.f(IpcService.this);
                d.a().a((OnRootApplyCallback) MqRunner.getInstance());
            }
        }.start();
        Log.i("VERSION", "build info: build on 2023-05-17 13:36:07");
    }

    public void onDestroy() {
        this.e.onAppQuit();
        super.onDestroy();
        d a2 = d.a();
        if (a2.d) {
            a2.a("exit");
            if (a2.f2556c.isAlive()) {
                a2.f2556c.interrupt();
            }
            try {
                a2.e.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        d.f2554a = null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }
}
