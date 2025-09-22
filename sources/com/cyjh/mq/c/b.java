package com.cyjh.mq.c;

import android.content.Context;
import android.net.LocalSocket;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.cyjh.mobileanjian.ipc.interfaces.BasicScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.EngineStateObserver;
import com.cyjh.mobileanjian.ipc.interfaces.OnMqScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnRecordScriptCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnRequestCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnRpcCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptListener;
import com.cyjh.mobileanjian.ipc.interfaces.OnScriptMessageCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnSpecialMqCmdCallback;
import com.cyjh.mobileanjian.ipc.interfaces.OnUiElementCallback;
import com.cyjh.mobileanjian.ipc.interfaces.ScriptStateObserver;
import com.cyjh.mobileanjian.ipc.share.proto.Ipc;
import com.cyjh.mobileanjian.ipc.view.ExToast;
import com.cyjh.mq.b.a;
import com.cyjh.mq.sdk.MqRunner;
import com.cyjh.mq.sdk.inf.OnElfCallback;
import com.cyjh.mqsdk.R;
import com.google.protobuf.InvalidProtocolBufferException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;

public final class b extends a {
    private static final int t = 4096;
    private static final int u = 1024;
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f2758a = true;

    /* renamed from: b  reason: collision with root package name */
    boolean f2759b = false;
    /* access modifiers changed from: package-private */

    /* renamed from: c  reason: collision with root package name */
    public Context f2760c = null;
    public boolean d = false;
    public boolean e = false;
    /* access modifiers changed from: package-private */
    public a f;
    /* access modifiers changed from: package-private */
    public List<EngineStateObserver> g = new ArrayList();
    OnRecordScriptCallback h = null;
    public OnScreenShotCallback i = null;
    OnScriptMessageCallback j = null;
    BasicScriptListener k = null;
    public OnScriptListener l = null;
    OnRequestCallback m;
    public OnMqScriptCallback n;
    public OnElfCallback o;
    OnUiElementCallback p;
    public OnSpecialMqCmdCallback q;
    /* access modifiers changed from: package-private */
    public ArrayBlockingQueue<Ipc.IpcMessage> r = new ArrayBlockingQueue<>(1024);
    OnRpcCallback s = null;
    private d v = null;
    private Vector<ScriptStateObserver> w = new Vector<>();
    private Thread x = new Thread("send_thread") {
        public final void run() {
            super.run();
            while (b.this.f2758a) {
                try {
                    com.cyjh.mobileanjian.ipc.share.proto.b bVar = new com.cyjh.mobileanjian.ipc.share.proto.b(b.this.r.take());
                    b bVar2 = b.this;
                    int length = bVar.a().length;
                    ByteBuffer wrap = ByteBuffer.wrap(new byte[(length + 4)]);
                    wrap.putInt(length);
                    wrap.put(bVar.a());
                    wrap.flip();
                    bVar2.a(wrap);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public b(Context context, LocalSocket localSocket) {
        super(localSocket);
        this.f2760c = context;
        this.v = new d(context, this);
    }

    public b(Context context, Socket socket) {
        super(socket);
        this.f2760c = context;
        this.v = new d(context, this);
    }

    private void a(BasicScriptListener basicScriptListener) {
        this.k = basicScriptListener;
    }

    private void a(OnMqScriptCallback onMqScriptCallback) {
        this.n = onMqScriptCallback;
    }

    private void a(OnRecordScriptCallback onRecordScriptCallback) {
        this.h = onRecordScriptCallback;
    }

    private void a(OnRequestCallback onRequestCallback) {
        this.m = onRequestCallback;
    }

    private void a(OnRpcCallback onRpcCallback) {
        this.s = onRpcCallback;
    }

    private void a(OnScreenShotCallback onScreenShotCallback) {
        this.i = onScreenShotCallback;
    }

    private void a(OnScriptListener onScriptListener) {
        this.l = onScriptListener;
    }

    private void a(OnScriptMessageCallback onScriptMessageCallback) {
        this.j = onScriptMessageCallback;
    }

    private void a(OnSpecialMqCmdCallback onSpecialMqCmdCallback) {
        this.q = onSpecialMqCmdCallback;
    }

    private void a(OnUiElementCallback onUiElementCallback) {
        this.p = onUiElementCallback;
    }

    private void a(ScriptStateObserver scriptStateObserver) {
        this.w.add(scriptStateObserver);
    }

    private void a(a aVar) {
        this.f = aVar;
    }

    private void a(OnElfCallback onElfCallback) {
        this.o = onElfCallback;
    }

    private void a(List<EngineStateObserver> list) {
        this.g = list;
    }

    private void a(boolean z) {
        this.e = z;
    }

    private void b(boolean z) {
        this.d = z;
    }

    private boolean d() {
        return this.f2759b;
    }

    private int e() {
        byte[] bArr = new byte[4];
        if (a(bArr) < 0) {
            return -1;
        }
        return ByteBuffer.wrap(bArr).getInt();
    }

    private Ipc.IpcMessage f() {
        byte[] bArr = new byte[4];
        int i2 = a(bArr) < 0 ? -1 : ByteBuffer.wrap(bArr).getInt();
        if (i2 >= 0) {
            byte[] bArr2 = new byte[i2];
            if (a(bArr2) >= 0) {
                try {
                    return Ipc.IpcMessage.parseFrom(bArr2);
                } catch (InvalidProtocolBufferException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        a();
        v();
        return null;
    }

    private OnRpcCallback g() {
        return this.s;
    }

    private a h() {
        return this.f;
    }

    private boolean i() {
        return this.e;
    }

    private boolean j() {
        return this.d;
    }

    private Vector<ScriptStateObserver> k() {
        return this.w;
    }

    private BasicScriptListener l() {
        return this.k;
    }

    private OnScriptListener m() {
        return this.l;
    }

    private OnRecordScriptCallback n() {
        return this.h;
    }

    private OnScreenShotCallback o() {
        return this.i;
    }

    private OnScriptMessageCallback p() {
        return this.j;
    }

    private OnRequestCallback q() {
        return this.m;
    }

    private OnMqScriptCallback r() {
        return this.n;
    }

    private OnElfCallback s() {
        return this.o;
    }

    private OnUiElementCallback t() {
        return this.p;
    }

    private void u() {
        new Thread() {
            public final void run() {
                for (EngineStateObserver onConnected : b.this.g) {
                    onConnected.onConnected(b.this);
                }
                if (com.cyjh.mq.a.a.j != null) {
                    com.cyjh.mq.a.a.j.onEngineStart(b.this.f.f2749a);
                }
            }
        }.start();
    }

    private void v() {
        com.cyjh.mobileanjian.ipc.b bVar = new com.cyjh.mobileanjian.ipc.b();
        bVar.f2545a = MqRunner.getInstance().isScriptStarted();
        if (MqRunner.getInstance().isScriptStarted()) {
            this.v.e.sendEmptyMessage(10);
            if (this.k != null) {
                Log.d("JAVA_RUNNER", "ScriptRunnerLite WHAT_STOP root进程异常终止");
                this.k.onStopScript(1002, "root进程异常终止");
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    if (b.this.l != null) {
                        Log.d("JAVA_RUNNER", "ScriptRunnerLite WHAT_STOP root进程异常终止 2");
                        b.this.l.onStopScript(1002, "root进程异常终止");
                    }
                    ExToast.makeText(b.this.f2760c, R.string.toast_engine_crash_then_restart, 2000).show();
                }
            });
        }
        if (this.d && this.i != null) {
            this.d = false;
            this.i.onScreenShotFailed(1002);
        }
        for (EngineStateObserver onCrash : this.g) {
            onCrash.onCrash(bVar);
        }
    }

    private OnSpecialMqCmdCallback w() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        super.a();
        this.f2758a = false;
        a(com.cyjh.mobileanjian.ipc.share.proto.b.a(3));
    }

    public final synchronized void a(Ipc.IpcMessage ipcMessage) {
        this.r.add(ipcMessage);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x048a, code lost:
        r1 = r2.obtainMessage(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0502, code lost:
        r1 = r3.obtainMessage(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x059a, code lost:
        r1.sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0603, code lost:
        r1.sendEmptyMessage(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0081, code lost:
        r1 = r3.obtainMessage(r4, r1.getArg1(0), 0, r1.getArg2(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ec, code lost:
        com.cyjh.event.Injector.sendTextAB(r1.getArg2(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0284, code lost:
        r1 = r2.setCmd(r4).addArg2(r1).build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0290, code lost:
        r3.f2770c.a(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r11 = this;
            r0 = 1
            r11.f2759b = r0
            java.lang.Thread r1 = r11.x
            r1.start()
        L_0x0008:
            boolean r1 = r11.f2758a
            r2 = 0
            if (r1 == 0) goto L_0x0618
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage r1 = r11.f()
            com.cyjh.mq.c.d r3 = r11.v
            if (r1 == 0) goto L_0x0008
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "handMessage msg.getCmd() -> "
            r4.<init>(r5)
            int r5 = r1.getCmd()
            r4.append(r5)
            com.cyjh.mq.c.b r4 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnRecordScriptCallback r4 = r4.h
            int r5 = r1.getCmd()
            r6 = 3
            r7 = 2
            switch(r5) {
                case 4: goto L_0x0608;
                case 5: goto L_0x0600;
                case 6: goto L_0x05da;
                default: goto L_0x0030;
            }
        L_0x0030:
            r8 = 16
            switch(r5) {
                case 27: goto L_0x05cb;
                case 28: goto L_0x05ae;
                default: goto L_0x0035;
            }
        L_0x0035:
            switch(r5) {
                case 32: goto L_0x059f;
                case 33: goto L_0x0594;
                case 34: goto L_0x0589;
                case 35: goto L_0x0580;
                case 36: goto L_0x0575;
                case 37: goto L_0x056a;
                case 38: goto L_0x0542;
                case 39: goto L_0x0537;
                case 40: goto L_0x051b;
                case 41: goto L_0x0514;
                case 42: goto L_0x050e;
                case 43: goto L_0x0508;
                case 44: goto L_0x04f6;
                default: goto L_0x0038;
            }
        L_0x0038:
            switch(r5) {
                case 50: goto L_0x04e9;
                case 51: goto L_0x04e4;
                case 52: goto L_0x04d1;
                case 53: goto L_0x04c6;
                case 54: goto L_0x04bf;
                case 55: goto L_0x04b8;
                case 56: goto L_0x04b1;
                case 57: goto L_0x04a6;
                case 58: goto L_0x049b;
                case 59: goto L_0x0490;
                default: goto L_0x003b;
            }
        L_0x003b:
            switch(r5) {
                case 64: goto L_0x0482;
                case 65: goto L_0x0008;
                case 66: goto L_0x047e;
                case 67: goto L_0x047a;
                default: goto L_0x003e;
            }
        L_0x003e:
            r9 = 19
            r10 = 0
            switch(r5) {
                case 98: goto L_0x0470;
                case 99: goto L_0x046a;
                case 100: goto L_0x039b;
                case 101: goto L_0x031a;
                case 102: goto L_0x02eb;
                case 103: goto L_0x02d5;
                case 104: goto L_0x02be;
                case 105: goto L_0x0297;
                case 106: goto L_0x0278;
                case 107: goto L_0x0267;
                case 108: goto L_0x025a;
                case 109: goto L_0x022c;
                case 110: goto L_0x0226;
                case 111: goto L_0x021c;
                case 112: goto L_0x020b;
                case 113: goto L_0x01fe;
                default: goto L_0x0044;
            }
        L_0x0044:
            switch(r5) {
                case 272: goto L_0x01f5;
                case 273: goto L_0x01e5;
                case 274: goto L_0x01ec;
                case 275: goto L_0x01cc;
                case 276: goto L_0x01bb;
                default: goto L_0x0047;
            }
        L_0x0047:
            switch(r5) {
                case 14: goto L_0x018a;
                case 19: goto L_0x0183;
                case 21: goto L_0x0178;
                case 23: goto L_0x016d;
                case 25: goto L_0x0146;
                case 48: goto L_0x008f;
                case 81: goto L_0x007d;
                case 96: goto L_0x006d;
                case 129: goto L_0x005f;
                case 257: goto L_0x0051;
                case 65535: goto L_0x004b;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0008
        L_0x004b:
            com.cyjh.mq.c.b r1 = r3.f2770c
            r1.c()
            goto L_0x0008
        L_0x0051:
            com.cyjh.mq.c.b r2 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnScriptMessageCallback r2 = r2.j
            if (r2 == 0) goto L_0x0008
            com.google.protobuf.ByteString r1 = r1.getFileData()
            r2.onDebugMessage(r1)
            goto L_0x0008
        L_0x005f:
            android.os.Handler r3 = r3.e
            r4 = 17
            int r1 = r1.getArg1(r2)
            android.os.Message r1 = r3.obtainMessage(r4, r1, r2)
            goto L_0x059a
        L_0x006d:
            android.os.Handler r3 = r3.e
            int r4 = r1.getArg1(r2)
            java.lang.String r1 = r1.getArg2(r2)
            android.os.Message r1 = r3.obtainMessage(r9, r4, r2, r1)
            goto L_0x059a
        L_0x007d:
            android.os.Handler r3 = r3.e
            r4 = 21
        L_0x0081:
            int r5 = r1.getArg1(r2)
            java.lang.String r1 = r1.getArg2(r2)
            android.os.Message r1 = r3.obtainMessage(r4, r5, r2, r1)
            goto L_0x059a
        L_0x008f:
            java.lang.String r4 = r1.getPkgName()
            java.lang.String r5 = r1.getClassName()
            java.lang.String r6 = r1.getMethodName()
            java.util.List r7 = r1.getTypesList()
            java.util.List r8 = r1.getParamsList()
            r9 = 0
            java.lang.Object r2 = com.cyjh.mobileanjian.ipc.rpc.Invocator.invoke(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "retObj = "
            r4.<init>(r5)
            r4.append(r2)
            boolean r4 = r1.getIsSyncCall()
            if (r4 == 0) goto L_0x0008
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r4 = r1.getRetValue()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$FundType r4 = r4.getType()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue$Builder r5 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.ReturnValue.newBuilder()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue$Builder r5 = r5.setType(r4)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r6 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.newBuilder()
            int r7 = r1.getCmd()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r6 = r6.setCmd(r7)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r6 = r6.setIsSyncCall(r0)
            int r1 = r1.getWaitId()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r1 = r6.setWaitId(r1)
            int[] r6 = com.cyjh.mq.c.d.AnonymousClass2.f2775a     // Catch:{ Throwable -> 0x0129 }
            int r7 = r4.ordinal()     // Catch:{ Throwable -> 0x0129 }
            r6 = r6[r7]     // Catch:{ Throwable -> 0x0129 }
            switch(r6) {
                case 1: goto L_0x011f;
                case 2: goto L_0x0115;
                case 3: goto L_0x010b;
                case 4: goto L_0x0101;
                case 5: goto L_0x00f7;
                case 6: goto L_0x00ec;
                default: goto L_0x00eb;
            }     // Catch:{ Throwable -> 0x0129 }
        L_0x00eb:
            goto L_0x012d
        L_0x00ec:
            if (r2 != 0) goto L_0x00f1
            java.lang.String r2 = ""
            goto L_0x00f3
        L_0x00f1:
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0129 }
        L_0x00f3:
            r5.setValString(r2)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x00f7:
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ Throwable -> 0x0129 }
            double r6 = r2.doubleValue()     // Catch:{ Throwable -> 0x0129 }
            r5.setValDouble(r6)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x0101:
            java.lang.Float r2 = (java.lang.Float) r2     // Catch:{ Throwable -> 0x0129 }
            float r2 = r2.floatValue()     // Catch:{ Throwable -> 0x0129 }
            r5.setValFloat(r2)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x010b:
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ Throwable -> 0x0129 }
            long r6 = r2.longValue()     // Catch:{ Throwable -> 0x0129 }
            r5.setValLong(r6)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x0115:
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Throwable -> 0x0129 }
            int r2 = r2.intValue()     // Catch:{ Throwable -> 0x0129 }
            r5.setValInt(r2)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x011f:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Throwable -> 0x0129 }
            boolean r2 = r2.booleanValue()     // Catch:{ Throwable -> 0x0129 }
            r5.setValBoolean(r2)     // Catch:{ Throwable -> 0x0129 }
            goto L_0x012d
        L_0x0129:
            r2 = move-exception
            r2.printStackTrace()
        L_0x012d:
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$FundType r2 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.FundType.VOID
            if (r4 == r2) goto L_0x0138
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r2 = r5.build()
            r1.setRetValue((com.cyjh.mobileanjian.ipc.share.proto.Ipc.ReturnValue) r2)
        L_0x0138:
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage r1 = r1.build()     // Catch:{ UninitializedMessageException -> 0x013d }
            goto L_0x0142
        L_0x013d:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r10
        L_0x0142:
            if (r1 == 0) goto L_0x0008
            goto L_0x0290
        L_0x0146:
            int r4 = r1.getArg1(r2)
            int r5 = r1.getArg1(r0)
            int r6 = r1.getArg1(r7)
            int r4 = r4 << r8
            r4 = r4 | r5
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.cyjh.mq.c.b r5 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnScreenShotCallback r5 = r5.i
            if (r6 != 0) goto L_0x0162
            com.cyjh.mq.c.b r3 = r3.f2770c
            r3.d = r2
        L_0x0162:
            if (r5 == 0) goto L_0x0008
            com.google.protobuf.ByteString r1 = r1.getFileData()
            r5.onScreenShotDone(r4, r1)
            goto L_0x0008
        L_0x016d:
            java.lang.String r1 = r1.getArg2(r2)
            if (r4 == 0) goto L_0x0008
            r4.onFinishRecord(r1)
            goto L_0x0008
        L_0x0178:
            int r1 = r1.getArg1(r2)
            if (r4 == 0) goto L_0x0008
            r4.onStartRecord(r1)
            goto L_0x0008
        L_0x0183:
            if (r4 == 0) goto L_0x0008
            r4.onOpenRecord()
            goto L_0x0008
        L_0x018a:
            com.cyjh.mq.b.a$a r4 = new com.cyjh.mq.b.a$a
            r4.<init>()
            int r5 = r1.getArg1(r2)
            r4.f2752a = r5
            int r5 = r1.getArg1(r0)
            r4.f2753b = r5
            int r1 = r1.getArg1(r7)
            if (r1 == 0) goto L_0x01a3
            r1 = 1
            goto L_0x01a4
        L_0x01a3:
            r1 = 0
        L_0x01a4:
            r4.f2754c = r1
            com.cyjh.mq.b.a r1 = new com.cyjh.mq.b.a
            r1.<init>(r4, r2)
            com.cyjh.mq.c.b r2 = r3.f2770c
            r2.f = r1
            com.cyjh.mq.c.b r1 = r3.f2770c
            com.cyjh.mq.c.b$2 r2 = new com.cyjh.mq.c.b$2
            r2.<init>()
            r2.start()
            goto L_0x0008
        L_0x01bb:
            float r3 = r1.getArg3(r2)
            float r4 = r1.getArg3(r0)
            int r1 = r1.getArg1(r2)
            com.cyjh.event.Injector.TapAB(r3, r4, r1)
            goto L_0x0008
        L_0x01cc:
            float r3 = r1.getArg3(r2)
            float r4 = r1.getArg3(r0)
            float r5 = r1.getArg3(r7)
            float r6 = r1.getArg3(r6)
            int r1 = r1.getArg1(r2)
            com.cyjh.event.Injector.SwipeAB(r3, r4, r5, r6, r1)
            goto L_0x0008
        L_0x01e5:
            java.lang.String r3 = r1.getArg2(r2)
            com.cyjh.event.Injector.dispatchGestureMoveAB(r3)
        L_0x01ec:
            java.lang.String r1 = r1.getArg2(r2)
            com.cyjh.event.Injector.sendTextAB(r1)
            goto L_0x0008
        L_0x01f5:
            int r1 = r1.getArg1(r2)
            com.cyjh.event.Injector.KeyPressAB(r1)
            goto L_0x0008
        L_0x01fe:
            int r1 = r1.getArg1(r2)
            if (r1 != r0) goto L_0x0008
            android.content.Context r1 = r3.f2768a
            com.cyjh.mq.d.c.a(r1)
            goto L_0x0008
        L_0x020b:
            java.lang.String r3 = r1.getArg2(r2)
            java.lang.String r4 = r1.getArg2(r0)
            int r1 = r1.getArg1(r2)
            com.cyjh.mq.c.d.a(r3, r4, r1)
            goto L_0x0008
        L_0x021c:
            r1.getArg1(r2)
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            r1.k()
            goto L_0x0008
        L_0x0226:
            android.os.Handler r2 = r3.e
            r3 = 23
            goto L_0x048a
        L_0x022c:
            com.google.protobuf.ByteString r4 = r1.getArg2Bytes(r2)
            int r2 = r1.getArg1(r2)
            int r5 = r1.getArg1(r0)
            int r1 = r1.getArg1(r7)
            java.lang.String r1 = r3.a(r4, r2, r5, r1)
            java.lang.String r2 = "GET_OCR_TEXT"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "strOrcText:"
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r2, r4)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r2 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.newBuilder()
            r4 = 109(0x6d, float:1.53E-43)
            goto L_0x0284
        L_0x025a:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            java.lang.String r1 = r1.j()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r2 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.newBuilder()
            r4 = 108(0x6c, float:1.51E-43)
            goto L_0x0284
        L_0x0267:
            com.cyjh.mobileanjian.ipc.a r4 = r3.f2769b
            java.lang.String r1 = r1.getArg2(r2)
            java.lang.String r1 = r4.d((java.lang.String) r1)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r2 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.newBuilder()
            r4 = 107(0x6b, float:1.5E-43)
            goto L_0x0284
        L_0x0278:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            java.lang.String r1 = r1.i()
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r2 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.newBuilder()
            r4 = 106(0x6a, float:1.49E-43)
        L_0x0284:
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r2 = r2.setCmd(r4)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage$Builder r1 = r2.addArg2(r1)
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage r1 = r1.build()
        L_0x0290:
            com.cyjh.mq.c.b r2 = r3.f2770c
            r2.a((com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage) r1)
            goto L_0x0008
        L_0x0297:
            int r1 = r1.getArg1(r2)
            if (r1 != r0) goto L_0x029e
            r2 = 1
        L_0x029e:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            android.content.Context r3 = r1.f2534a
            android.content.ContentResolver r3 = r3.getContentResolver()
            java.lang.String r4 = "airplane_mode_on"
            android.provider.Settings.System.putInt(r3, r4, r2)
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.AIRPLANE_MODE"
            r3.<init>(r4)
            java.lang.String r4 = "state"
            r3.putExtra(r4, r2)
            android.content.Context r1 = r1.f2534a
            r1.sendBroadcast(r3)
            goto L_0x0008
        L_0x02be:
            int r1 = r1.getArg1(r2)
            if (r1 != r0) goto L_0x02c5
            r2 = 1
        L_0x02c5:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            r2 = r2 ^ r0
            android.content.Context r1 = r1.f2534a
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r3 = "accelerometer_rotation"
            android.provider.Settings.System.putInt(r1, r3, r2)
            goto L_0x0008
        L_0x02d5:
            int r1 = r1.getArg1(r2)
            if (r1 != r0) goto L_0x02dc
            r2 = 1
        L_0x02dc:
            android.content.Context r1 = r3.f2768a
            java.lang.String r3 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r3)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            r1.setWifiEnabled(r2)
            goto L_0x0008
        L_0x02eb:
            java.lang.String r1 = r1.getArg2(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "_data like \""
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r1 = "%\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.content.Context r2 = r3.f2768a
            android.content.ContentResolver r2 = r2.getContentResolver()
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            r2.delete(r4, r1, r10)
            android.content.Context r2 = r3.f2768a
            android.content.ContentResolver r2 = r2.getContentResolver()
            android.net.Uri r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            r2.delete(r3, r1, r10)
            goto L_0x0008
        L_0x031a:
            java.lang.String r2 = r1.getArg2(r2)
            r1.getArg2(r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            android.content.Context r2 = r3.f2768a
            android.content.ContentResolver r2 = r2.getContentResolver()
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.String r5 = "title"
            java.lang.String r6 = r1.getName()
            r4.put(r5, r6)
            java.lang.String r5 = "_display_name"
            java.lang.String r6 = r1.getName()
            r4.put(r5, r6)
            java.lang.String r5 = "mime_type"
            java.lang.String r6 = "video/3gp"
            r4.put(r5, r6)
            java.lang.String r5 = "datetaken"
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r4.put(r5, r6)
            java.lang.String r5 = "date_modified"
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r4.put(r5, r6)
            java.lang.String r5 = "date_added"
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r4.put(r5, r6)
            java.lang.String r5 = "_data"
            java.lang.String r6 = r1.getAbsolutePath()
            r4.put(r5, r6)
            java.lang.String r5 = "_size"
            long r6 = r1.length()
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r4.put(r5, r1)
            android.net.Uri r1 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r1 = r2.insert(r1, r4)
            android.content.Context r2 = r3.f2768a
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r3.<init>(r4, r1)
            r2.sendBroadcast(r3)
            goto L_0x0008
        L_0x039b:
            java.lang.String r4 = r1.getArg2(r2)
            java.lang.String r1 = r1.getArg2(r0)
            java.lang.String r5 = "InsertImageToGallery"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "InsertImageToGallery:"
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r7 = "|"
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r5, r6)
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            if (r6 >= r7) goto L_0x03e0
            android.content.Context r1 = r3.f2768a     // Catch:{ FileNotFoundException -> 0x03db }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x03db }
            java.lang.String r4 = r5.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x03db }
            java.lang.String r6 = r5.getName()     // Catch:{ FileNotFoundException -> 0x03db }
            android.provider.MediaStore.Images.Media.insertImage(r1, r4, r6, r10)     // Catch:{ FileNotFoundException -> 0x03db }
            goto L_0x0442
        L_0x03db:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0442
        L_0x03e0:
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "_display_name"
            r6.put(r7, r1)
            java.lang.String r7 = "mime_type"
            java.lang.String r8 = "image/jpeg"
            r6.put(r7, r8)
            java.lang.String r7 = "relative_path"
            java.lang.String r8 = android.os.Environment.DIRECTORY_DCIM
            r6.put(r7, r8)
            android.content.Context r7 = r3.f2768a
            android.content.ContentResolver r7 = r7.getContentResolver()
            android.net.Uri r8 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r6 = r7.insert(r8, r6)
            if (r6 != 0) goto L_0x0423
            java.lang.String r2 = "InsertImageToGallery"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "图片保存失败:"
            r3.<init>(r5)
            r3.append(r4)
            java.lang.String r4 = "|"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.e(r2, r1)
            goto L_0x0008
        L_0x0423:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x043e }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x043e }
            r4.<init>(r5)     // Catch:{ IOException -> 0x043e }
            r1.<init>(r4)     // Catch:{ IOException -> 0x043e }
            java.io.OutputStream r4 = r7.openOutputStream(r6)     // Catch:{ IOException -> 0x043e }
            android.os.FileUtils.copy(r1, r4)     // Catch:{ IOException -> 0x043e }
            r1.close()     // Catch:{ IOException -> 0x043e }
            r4.close()     // Catch:{ IOException -> 0x043e }
            r5.delete()     // Catch:{ IOException -> 0x043e }
            goto L_0x0442
        L_0x043e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0442:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r9) goto L_0x0455
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r4 = r5.getAbsolutePath()
            r1[r2] = r4
            android.content.Context r2 = r3.f2768a
            android.media.MediaScannerConnection.scanFile(r2, r1, r10, r10)
            goto L_0x0008
        L_0x0455:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
            r1.<init>(r2)
            android.net.Uri r2 = android.net.Uri.fromFile(r5)
            r1.setData(r2)
            android.content.Context r2 = r3.f2768a
            r2.sendBroadcast(r1)
            goto L_0x0008
        L_0x046a:
            android.os.Handler r3 = r3.e
            r4 = 22
            goto L_0x0081
        L_0x0470:
            android.os.Handler r3 = r3.e
            r4 = 20
            java.lang.String r1 = r1.getArg2(r2)
            goto L_0x0502
        L_0x047a:
            android.os.Handler r2 = r3.e
            r3 = 7
            goto L_0x048a
        L_0x047e:
            android.os.Handler r2 = r3.e
            r3 = 6
            goto L_0x048a
        L_0x0482:
            android.os.Handler r2 = r3.e
            r3 = 18
            com.google.protobuf.ByteString r1 = r1.getFileData()
        L_0x048a:
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            goto L_0x059a
        L_0x0490:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            int r1 = r1.getArg1(r2)
            r3.e((int) r1)
            goto L_0x0008
        L_0x049b:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            int r1 = r1.getArg1(r2)
            r3.d((int) r1)
            goto L_0x0008
        L_0x04a6:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            int r1 = r1.getArg1(r2)
            r3.c((int) r1)
            goto L_0x0008
        L_0x04b1:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            r1.h()
            goto L_0x0008
        L_0x04b8:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            r1.g()
            goto L_0x0008
        L_0x04bf:
            android.content.Context r1 = r3.f2768a
            com.cyjh.mobileanjian.ipc.utils.d.a(r1)
            goto L_0x0008
        L_0x04c6:
            android.content.Context r3 = r3.f2768a
            java.lang.String r1 = r1.getArg2(r2)
            com.cyjh.mobileanjian.ipc.utils.d.a(r3, r1)
            goto L_0x0008
        L_0x04d1:
            android.content.Context r3 = r3.f2768a
            java.lang.String r2 = r1.getArg2(r2)
            java.lang.String r4 = r1.getArg2(r0)
            java.lang.String r1 = r1.getArg2(r7)
            com.cyjh.mobileanjian.ipc.utils.d.a(r3, r2, r4, r1)
            goto L_0x0008
        L_0x04e4:
            com.cyjh.mobileanjian.ipc.a.f()
            goto L_0x0008
        L_0x04e9:
            com.cyjh.mq.c.b r3 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnRpcCallback r3 = r3.s
            java.lang.String r1 = r1.getArg2(r2)
            r3.onRpcReturn(r1)
            goto L_0x0008
        L_0x04f6:
            android.os.Handler r3 = r3.e
            r4 = 24
            int r1 = r1.getArg1(r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0502:
            android.os.Message r1 = r3.obtainMessage(r4, r1)
            goto L_0x059a
        L_0x0508:
            android.os.Handler r1 = r3.e
            r2 = 9
            goto L_0x0603
        L_0x050e:
            android.os.Handler r1 = r3.e
            r2 = 8
            goto L_0x0603
        L_0x0514:
            com.cyjh.mobileanjian.ipc.a r1 = r3.f2769b
            r1.e()
            goto L_0x0008
        L_0x051b:
            android.os.Handler r3 = r3.e
            r4 = 1120403456(0x42c80000, float:100.0)
            float r5 = r1.getArg3(r2)
            float r5 = r5 * r4
            int r4 = (int) r5
            int r2 = r1.getArg1(r2)
            int r1 = r1.getArg1(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            android.os.Message r1 = r3.obtainMessage(r8, r4, r2, r1)
            goto L_0x059a
        L_0x0537:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            java.lang.String r1 = r1.getArg2(r2)
            r3.b((java.lang.String) r1)
            goto L_0x0008
        L_0x0542:
            com.cyjh.mobileanjian.ipc.a r4 = r3.f2769b
            java.lang.String r1 = r1.getArg2(r2)
            com.ime.input.a r2 = r4.f2535b
            android.inputmethodservice.InputMethodService r4 = r2.f3525a
            if (r4 == 0) goto L_0x055d
            android.inputmethodservice.InputMethodService r2 = r2.f3525a
            android.view.inputmethod.InputConnection r2 = r2.getCurrentInputConnection()
            if (r2 == 0) goto L_0x055d
            int r4 = r1.length()
            r2.commitText(r1, r4)
        L_0x055d:
            com.cyjh.mq.c.b r1 = r3.f2770c
            r2 = 38
            com.cyjh.mobileanjian.ipc.share.proto.Ipc$IpcMessage r2 = com.cyjh.mobileanjian.ipc.share.proto.b.a(r2)
            r1.a((com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage) r2)
            goto L_0x0008
        L_0x056a:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            int r1 = r1.getArg1(r2)
            r3.b((int) r1)
            goto L_0x0008
        L_0x0575:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            java.lang.String r1 = r1.getArg2(r2)
            r3.a((java.lang.String) r1)
            goto L_0x0008
        L_0x0580:
            java.lang.String r1 = r1.getArg2(r2)
            com.cyjh.mobileanjian.ipc.a.c((java.lang.String) r1)
            goto L_0x0008
        L_0x0589:
            com.cyjh.mobileanjian.ipc.a r3 = r3.f2769b
            int r1 = r1.getArg1(r2)
            r3.a((int) r1)
            goto L_0x0008
        L_0x0594:
            android.os.Handler r2 = r3.e
            android.os.Message r1 = r2.obtainMessage(r0, r1)
        L_0x059a:
            r1.sendToTarget()
            goto L_0x0008
        L_0x059f:
            com.cyjh.mq.c.b r3 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnScriptMessageCallback r3 = r3.j
            if (r3 == 0) goto L_0x0008
            java.lang.String r1 = r1.getArg2(r2)
            r3.onTracePrint(r1)
            goto L_0x0008
        L_0x05ae:
            int r2 = r1.getArg1(r2)
            int r4 = r1.getArg1(r0)
            int r2 = r2 << r8
            r2 = r2 | r4
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.cyjh.mq.c.b r3 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnUiElementCallback r3 = r3.p
            if (r3 == 0) goto L_0x0008
            com.google.protobuf.ByteString r1 = r1.getFileData()
            r3.onScreenShotDone(r2, r1)
            goto L_0x0008
        L_0x05cb:
            com.cyjh.mq.c.b r3 = r3.f2770c
            com.cyjh.mobileanjian.ipc.interfaces.OnUiElementCallback r3 = r3.p
            if (r3 == 0) goto L_0x0008
            java.lang.String r1 = r1.getArg2(r2)
            r3.onUiElementback(r1)
            goto L_0x0008
        L_0x05da:
            com.cyjh.mobileanjian.ipc.a r4 = r3.f2769b
            r4.a()
            com.cyjh.mobileanjian.ipc.a.f()
            int r4 = r1.getArg1(r2)
            com.cyjh.mq.c.b r5 = r3.f2770c
            r5.e = r2
            r5 = 105(0x69, float:1.47E-43)
            if (r4 == r5) goto L_0x05f0
            if (r4 != 0) goto L_0x05f5
        L_0x05f0:
            int r5 = com.cyjh.mqsdk.R.string.toast_on_stop_script
            r3.a((int) r5)
        L_0x05f5:
            android.os.Handler r3 = r3.e
            java.lang.String r1 = r1.getArg2(r2)
            android.os.Message r1 = r3.obtainMessage(r6, r4, r2, r1)
            goto L_0x059a
        L_0x0600:
            android.os.Handler r1 = r3.e
            r2 = 4
        L_0x0603:
            r1.sendEmptyMessage(r2)
            goto L_0x0008
        L_0x0608:
            com.cyjh.mq.c.b r1 = r3.f2770c
            r1.e = r0
            int r1 = com.cyjh.mqsdk.R.string.toast_on_start_script
            r3.a((int) r1)
            android.os.Handler r1 = r3.e
            r1.sendEmptyMessage(r7)
            goto L_0x0008
        L_0x0618:
            r11.f2759b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mq.c.b.b():void");
    }

    public final void c() {
        for (EngineStateObserver onExit : this.g) {
            onExit.onExit();
        }
    }
}
