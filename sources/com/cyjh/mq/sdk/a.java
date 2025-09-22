package com.cyjh.mq.sdk;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.cyjh.mobileanjian.ipc.d;
import com.cyjh.mobileanjian.ipc.interfaces.EngineStateObserver;
import com.cyjh.mobileanjian.ipc.interfaces.OnRootApplyCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import com.cyjh.mobileanjian.ipc.utils.RootUtil;
import com.cyjh.mq.c.b;
import com.cyjh.mq.d.e;
import com.cyjh.mq.sdk.entity.Script4Run;
import com.cyjh.mq.sdk.inf.IRunner;
import com.cyjh.mqsdk.R;
import com.google.protobuf.ByteString;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public abstract class a implements EngineStateObserver, OnRootApplyCallback, IRunner {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f2792a = 256;

    /* renamed from: b  reason: collision with root package name */
    protected b f2793b = null;

    /* renamed from: c  reason: collision with root package name */
    protected Script4Run f2794c;
    protected Handler d = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 256 && com.cyjh.mq.a.a.i != null) {
                if (message.what == 4) {
                    Toast.makeText(com.cyjh.mq.a.a.g.getApplicationContext(), com.cyjh.mq.a.a.g.getString(R.string.toast_failed_got_root, new Object[]{e.a(com.cyjh.mq.a.a.g.getApplicationContext())}), 1).show();
                }
                com.cyjh.mq.a.a.i.onRootProgress((String) message.obj, message.what);
            }
        }
    };
    protected boolean e = false;
    protected boolean f = false;
    private OnScriptListener g;
    private boolean h = false;

    /* renamed from: com.cyjh.mq.sdk.a$a  reason: collision with other inner class name */
    private class C0046a extends AsyncTask<Script4Run, Void, Script4Run> {
        private C0046a() {
        }

        /* synthetic */ C0046a(a aVar, byte b2) {
            this();
        }

        private static Script4Run a(Script4Run... script4RunArr) {
            Script4Run script4Run = script4RunArr[0];
            try {
                File file = new File(com.cyjh.mq.a.a.g.getApplicationContext().getFilesDir(), "script");
                if (!file.exists()) {
                    file.mkdirs();
                    file.setReadable(true, false);
                    file.setExecutable(true, false);
                } else {
                    FileUtils.deleteDirectory(file);
                }
                File[] fileArr = {new File(script4Run.getLcPath()), new File(script4Run.getAtcPath()), new File(script4Run.getConfigPath())};
                File file2 = new File(file, FilenameUtils.getName(script4Run.getLcPath()));
                File file3 = new File(file, FilenameUtils.getName(script4Run.getAtcPath()));
                File file4 = new File(file, FilenameUtils.getName(script4Run.getConfigPath()));
                File[] fileArr2 = {file2, file3, file4};
                for (int i = 0; i < 3; i++) {
                    if (fileArr[i].exists()) {
                        FileUtils.copyFile(fileArr[i], fileArr2[i]);
                        fileArr2[i].setReadable(true, false);
                    } else {
                        fileArr2[i] = fileArr[i];
                    }
                }
                Script4Run clone = script4Run.clone();
                clone.setLcPath(file2.getAbsolutePath()).setAtcPath(file3.getAbsolutePath()).setConfigPath(file4.getAbsolutePath());
                return clone;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(Script4Run script4Run) {
            if (script4Run != null) {
                a.this.a(script4Run.toMessage(7));
                a.this.a(script4Run.toMessage(1));
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a((Script4Run[]) objArr);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Script4Run script4Run = (Script4Run) obj;
            if (script4Run != null) {
                a.this.a(script4Run.toMessage(7));
                a.this.a(script4Run.toMessage(1));
            }
        }
    }

    private void a(Script4Run script4Run) {
        new C0046a(this, (byte) 0).execute(new Script4Run[]{script4Run});
    }

    /* access modifiers changed from: protected */
    public final void a(Ipc.IpcMessage ipcMessage) {
        if (this.e) {
            this.f2793b.a(ipcMessage);
        }
    }

    public final void a(ByteString byteString) {
        a(Ipc.IpcMessage.newBuilder().setCmd(64).setFileData(byteString).build());
    }

    public final void b(ByteString byteString) {
        a(Ipc.IpcMessage.newBuilder().setCmd(65).setFileData(byteString).build());
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!this.h) {
            this.h = true;
            File a2 = com.cyjh.mq.a.a.a();
            d.a().a("setenforce 0");
            d.a().a("chmod 677 /dev/input/*");
            d.a().a(a2.getAbsolutePath());
            this.d.sendEmptyMessageDelayed(256, 6000);
        }
    }

    public final void c(ByteString byteString) {
        a(Ipc.IpcMessage.newBuilder().setCmd(com.cyjh.mobileanjian.ipc.share.proto.a.aL).setFileData(byteString).build());
    }

    public final void c(String str) {
        a(Ipc.IpcMessage.newBuilder().setCmd(com.cyjh.mobileanjian.ipc.share.proto.a.aM).addArg2(str).build());
    }

    public boolean isScriptStarted() {
        if (this.f2793b == null) {
            return false;
        }
        return this.f2793b.e;
    }

    public void notifyRotationStatus() {
        a(Ipc.IpcMessage.newBuilder().setCmd(15).addArg1(((WindowManager) com.cyjh.mq.a.a.g.getSystemService("window")).getDefaultDisplay().getRotation()).build());
    }

    public void onConnected(b bVar) {
        this.d.removeMessages(256);
        this.e = true;
        this.f2793b = bVar;
        this.h = false;
        setOnScriptListener(this.g);
    }

    public void onObtained() {
        Log.d("JAVA_RUNNER", "onObtained()1");
        if (RootUtil.isRoot()) {
            this.d.obtainMessage(6, "ROOT SUCCESS").sendToTarget();
        }
        c();
        this.f = false;
    }

    public void onRefused() {
        if (RootUtil.isRoot()) {
            this.d.obtainMessage(4, "User refused root.").sendToTarget();
        }
        this.f = false;
    }

    public void pause() {
        a(com.cyjh.mobileanjian.ipc.share.proto.b.a(2));
    }

    public void resume() {
        a(com.cyjh.mobileanjian.ipc.share.proto.b.a(9));
    }

    public IRunner setOnScriptListener(OnScriptListener onScriptListener) {
        this.g = onScriptListener;
        if (this.f2793b != null) {
            this.f2793b.l = this.g;
        }
        return this;
    }

    public IRunner setScript(Script4Run script4Run) {
        this.f2794c = script4Run;
        a(script4Run.toMessage(7));
        return this;
    }

    public void stop() {
        Log.d("JAVA_RUNNER", "GeneralMqRunner stop");
        a(com.cyjh.mobileanjian.ipc.share.proto.b.a(3));
    }
}
