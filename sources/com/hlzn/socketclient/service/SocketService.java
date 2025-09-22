package com.hlzn.socketclient.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.NetworkOnMainThreadException;
import android.text.TextUtils;
import com.google.a.c.l;
import com.hlzn.socketclient.bean.ServiceParam;
import com.hlzn.socketclient.e;
import com.hlzn.socketclient.e.b;
import com.hlzn.socketclient.f;
import com.hlzn.socketclient.f.c;
import com.hlzn.socketclient.f.d;
import com.hlzn.socketclient.f.g;
import com.hlzn.socketclient.pbmsg.MessageProtobuf;
import com.lidroid.xutils.util.CharsetUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

public class SocketService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static Object f3459a = new Object();
    public static final int l = 1;
    /* access modifiers changed from: private */
    public static final String m = "SocketService";
    /* access modifiers changed from: private */
    public Queue<Long> A;
    private File B;

    /* renamed from: b  reason: collision with root package name */
    public Socket f3460b;

    /* renamed from: c  reason: collision with root package name */
    Thread f3461c;
    Thread d;
    Thread e;
    boolean f = false;
    boolean g = false;
    boolean h = false;
    a i = new a(this);
    boolean j = false;
    public e k;
    /* access modifiers changed from: private */
    public Long n;
    /* access modifiers changed from: private */
    public String o;
    /* access modifiers changed from: private */
    public String p;
    /* access modifiers changed from: private */
    public String q;
    private ServiceParam r;
    private Thread s;
    /* access modifiers changed from: private */
    public InetSocketAddress t;
    /* access modifiers changed from: private */
    public Queue<Long> u;
    /* access modifiers changed from: private */
    public Queue<Long> v;
    /* access modifiers changed from: private */
    public Queue<Long> w;
    /* access modifiers changed from: private */
    public Queue<Long> x;
    /* access modifiers changed from: private */
    public Queue<Long> y;
    /* access modifiers changed from: private */
    public Queue<Long> z;

    public class a extends Binder {

        /* renamed from: a  reason: collision with root package name */
        public b f3489a;

        /* renamed from: c  reason: collision with root package name */
        private SocketService f3491c;

        public a(SocketService socketService) {
            this.f3491c = socketService;
        }

        public final void sendMethod(Object obj) {
            SocketService.a();
        }

        public final void setOnServiceCallBack(b bVar) {
            this.f3489a = bVar;
        }
    }

    private static String a(String str) {
        try {
            if (str.equals(new String(str.getBytes(l.f3087b), l.f3087b))) {
                return l.f3087b;
            }
        } catch (Exception unused) {
        }
        try {
            if (str.equals(new String(str.getBytes(CharsetUtils.DEFAULT_ENCODING_CHARSET), CharsetUtils.DEFAULT_ENCODING_CHARSET))) {
                return CharsetUtils.DEFAULT_ENCODING_CHARSET;
            }
        } catch (Exception unused2) {
        }
        try {
            if (str.equals(new String(str.getBytes("UTF-8"), "UTF-8"))) {
                return "UTF-8";
            }
        } catch (Exception unused3) {
        }
        try {
            return str.equals(new String(str.getBytes("GBK"), "GBK")) ? "GBK" : "";
        } catch (Exception unused4) {
            return "";
        }
    }

    public static void a() {
    }

    private void a(final int i2, final String str) {
        if (!this.u.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    MessageProtobuf.CmdScriptStartResult.Builder newBuilder = MessageProtobuf.CmdScriptStartResult.newBuilder();
                    newBuilder.setRpcId(((Long) SocketService.this.u.poll()).longValue()).setError(r0).setMessage(r1);
                    String d = SocketService.m;
                    d.b(d, "cmdScriptStartSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                    com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                    Socket b2 = SocketService.this.f3460b;
                    MessageProtobuf.CmdScriptStartResult build = newBuilder.build();
                    byte[] b3 = com.hlzn.socketclient.f.a.b(10102);
                    byte[] byteArray = build.toByteArray();
                    byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                    String str = a2.f3423a;
                    d.b(str, "cmdScriptStartResult --> binary value = " + b3[1] + b3[0]);
                    if (b2 != null && b2.isConnected()) {
                        try {
                            OutputStream outputStream = b2.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void a(Intent intent) {
        this.r = (ServiceParam) intent.getParcelableExtra(com.hlzn.socketclient.b.a.o);
        if (this.r != null) {
            if (!TextUtils.isEmpty(this.r.f3432c)) {
                this.n = Long.valueOf(Long.parseLong(this.r.f3432c));
            }
            if (!TextUtils.isEmpty(this.r.d)) {
                this.o = this.r.d;
            }
            if (!TextUtils.isEmpty(this.r.e)) {
                this.p = this.r.e;
            }
            if (!TextUtils.isEmpty(this.r.f)) {
                this.q = this.r.f;
            }
        }
    }

    public static int b() {
        return 1;
    }

    private void b(final int i2, final String str) {
        if (!this.v.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    MessageProtobuf.CmdScriptStopResult.Builder newBuilder = MessageProtobuf.CmdScriptStopResult.newBuilder();
                    newBuilder.setRpcId(((Long) SocketService.this.v.poll()).longValue()).setError(r0).setMessage(r1);
                    String d = SocketService.m;
                    d.b(d, "cmdScriptStopSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                    com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                    Socket b2 = SocketService.this.f3460b;
                    MessageProtobuf.CmdScriptStopResult build = newBuilder.build();
                    byte[] b3 = com.hlzn.socketclient.f.a.b(10104);
                    byte[] byteArray = build.toByteArray();
                    byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                    String str = a2.f3423a;
                    d.b(str, "cmdScriptStopResult --> binary value = " + b3[1] + b3[0]);
                    if (b2 != null && b2.isConnected()) {
                        try {
                            OutputStream outputStream = b2.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void c(final int i2, final String str) {
        if (!this.w.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    MessageProtobuf.CmdScriptUpgradeResult.Builder newBuilder = MessageProtobuf.CmdScriptUpgradeResult.newBuilder();
                    newBuilder.setRpcId(((Long) SocketService.this.w.poll()).longValue()).setError(r0).setMessage(r1);
                    String d = SocketService.m;
                    d.b(d, "cmdScriptUpgradeSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                    com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                    Socket b2 = SocketService.this.f3460b;
                    MessageProtobuf.CmdScriptUpgradeResult build = newBuilder.build();
                    byte[] b3 = com.hlzn.socketclient.f.a.b(10106);
                    byte[] byteArray = build.toByteArray();
                    byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                    String str = a2.f3423a;
                    d.b(str, "cmdScriptUpgradeResult --> binary value = " + b3[1] + b3[0]);
                    if (b2 != null && b2.isConnected()) {
                        try {
                            OutputStream outputStream = b2.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void d(final int i2, final String str) {
        if (!this.x.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    if (SocketService.this.x.size() > 0) {
                        MessageProtobuf.CmdScriptSettingsResult.Builder newBuilder = MessageProtobuf.CmdScriptSettingsResult.newBuilder();
                        newBuilder.setRpcId(((Long) SocketService.this.x.poll()).longValue()).setError(r0).setMessage(r1);
                        String d = SocketService.m;
                        d.b(d, "cmdScriptSettingsSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                        com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                        Socket b2 = SocketService.this.f3460b;
                        MessageProtobuf.CmdScriptSettingsResult build = newBuilder.build();
                        byte[] b3 = com.hlzn.socketclient.f.a.b(10108);
                        byte[] byteArray = build.toByteArray();
                        byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                        String str = a2.f3423a;
                        d.b(str, "cmdScriptSettingsResult --> binary value = " + b3[1] + b3[0]);
                        if (b2 != null && b2.isConnected()) {
                            try {
                                OutputStream outputStream = b2.getOutputStream();
                                outputStream.write(a3);
                                outputStream.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }.start();
        }
    }

    private void e() {
        this.u = new LinkedList();
        this.v = new LinkedList();
        this.w = new LinkedList();
        this.x = new LinkedList();
        this.y = new LinkedList();
        this.z = new LinkedList();
        this.A = new LinkedList();
        if (this.k != null) {
            this.k.a();
        }
        this.k = new e(this);
    }

    private void e(final int i2, final String str) {
        if (!this.y.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    try {
                        MessageProtobuf.CmdScreenCaptureResult.Builder newBuilder = MessageProtobuf.CmdScreenCaptureResult.newBuilder();
                        newBuilder.setRpcId(((Long) SocketService.this.y.poll()).longValue()).setError(r0).setMessage(r1);
                        String d = SocketService.m;
                        d.b(d, "cmdScreenCaptureSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                        com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                        Socket b2 = SocketService.this.f3460b;
                        MessageProtobuf.CmdScreenCaptureResult build = newBuilder.build();
                        byte[] b3 = com.hlzn.socketclient.f.a.b(10110);
                        byte[] byteArray = build.toByteArray();
                        byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                        String str = a2.f3423a;
                        d.b(str, "cmdScreenCaptureResult --> binary value = " + b3[1] + b3[0]);
                        if (b2 != null && b2.isConnected()) {
                            try {
                                OutputStream outputStream = b2.getOutputStream();
                                outputStream.write(a3);
                                outputStream.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }.start();
        }
    }

    private void f() {
        String str = m;
        d.b(str, "createConnection --> IP=" + com.hlzn.socketclient.b.a.p + ",Port=" + com.hlzn.socketclient.b.a.q);
        this.s = new Thread(new Runnable() {
            public final void run() {
                String d;
                StringBuilder sb;
                String message;
                try {
                    Socket unused = SocketService.this.f3460b = new Socket();
                    InetSocketAddress unused2 = SocketService.this.t = new InetSocketAddress(com.hlzn.socketclient.b.a.p, com.hlzn.socketclient.b.a.q);
                    SocketService.this.f3460b.connect(SocketService.this.t, com.hlzn.socketclient.b.a.r);
                    SocketService.this.f3460b.setTcpNoDelay(true);
                    SocketService.this.f3460b.setSendBufferSize(10240);
                    SocketService.this.f3460b.setKeepAlive(true);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                    d = SocketService.m;
                    sb = new StringBuilder("createConnection --> exception=");
                    message = e.getMessage();
                    sb.append(message);
                    d.a(d, sb.toString());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    d = SocketService.m;
                    sb = new StringBuilder("createConnection --> exception=");
                    message = e2.getMessage();
                    sb.append(message);
                    d.a(d, sb.toString());
                } catch (NetworkOnMainThreadException e3) {
                    e3.printStackTrace();
                    d = SocketService.m;
                    sb = new StringBuilder("createConnection --> exception=");
                    message = e3.getMessage();
                    sb.append(message);
                    d.a(d, sb.toString());
                }
            }
        });
        this.s.start();
    }

    private void f(final int i2, final String str) {
        if (!this.z.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    MessageProtobuf.CmdUnBindStudioProjectResult.Builder newBuilder = MessageProtobuf.CmdUnBindStudioProjectResult.newBuilder();
                    newBuilder.setRpcId(((Long) SocketService.this.z.poll()).longValue()).setError(r0).setMessage(r1);
                    String d = SocketService.m;
                    d.b(d, "cmdUnBindStudioProjectSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                    com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                    Socket b2 = SocketService.this.f3460b;
                    MessageProtobuf.CmdUnBindStudioProjectResult build = newBuilder.build();
                    byte[] b3 = com.hlzn.socketclient.f.a.b(10112);
                    byte[] byteArray = build.toByteArray();
                    byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                    String str = a2.f3423a;
                    d.b(str, "cmdUnBindStudioProjectResult --> binary value = " + b3[1] + b3[0]);
                    if (b2 != null && b2.isConnected()) {
                        try {
                            OutputStream outputStream = b2.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void g() {
        String str = m;
        d.b(str, "receiveMsg --> isReceive=" + this.g);
        this.d = new Thread(new Runnable() {
            public final void run() {
                SocketService socketService;
                ServiceParam serviceParam;
                Context context;
                String str;
                while (SocketService.this.g) {
                    try {
                        if (SocketService.this.f3460b == null || !SocketService.this.f3460b.isConnected()) {
                            d.b(SocketService.m, "重连……");
                            socketService = SocketService.this;
                        } else {
                            DataInputStream a2 = com.hlzn.socketclient.a.a.a().a(SocketService.this.f3460b);
                            new ByteArrayOutputStream();
                            if (a2 != null) {
                                byte[] bArr = new byte[2];
                                byte[] bArr2 = new byte[4];
                                int read = a2.read(bArr, 0, 2);
                                d.b(SocketService.m, "receiveMsg --> 1 cmd_length=" + read + ",content=" + bArr[1] + bArr[0]);
                                if (read == 2) {
                                    String a3 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr));
                                    int a4 = com.hlzn.socketclient.f.a.a(a3);
                                    d.b(SocketService.m, "receiveMsg --> 2 hexStr=" + a3 + ",cmd=" + a4);
                                    if (a4 != 10002) {
                                        if (a4 == 10004) {
                                            d.b(SocketService.m, "心跳返回 --> 1");
                                            a2.read(bArr2, 0, 4);
                                            int a5 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                            byte[] bArr3 = new byte[a5];
                                            a2.read(bArr3, 0, a5);
                                            d.b(SocketService.m, "心跳返回 --> 2 heartDataArrayLen = " + a5);
                                            MessageProtobuf.HeartbeatResult parseFrom = MessageProtobuf.HeartbeatResult.parseFrom(bArr3);
                                            d.b(SocketService.m, "心跳返回 --> 3 disabled =" + parseFrom.getDisabled());
                                            new com.hlzn.socketclient.c.a(10004, "心跳响应", (byte) 0).h = parseFrom.getDisabled();
                                            f.a();
                                            SocketService.this.k.a("-1");
                                            com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "心跳返回 -->  disabled=" + parseFrom.getDisabled());
                                        } else if (a4 == 10101) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a6 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a7 = g.a(a2, a6);
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 2 cmScriptStartDataArrayLen = " + a6);
                                                MessageProtobuf.CmdScriptStart parseFrom2 = MessageProtobuf.CmdScriptStart.parseFrom(a7);
                                                SocketService.this.u.offer(Long.valueOf(parseFrom2.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 3 RpcId = " + parseFrom2.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10101, "服务端命令:脚本启动", (byte) 0);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                f a8 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.h = -1;
                                                serviceParam.i = "服务端命令:脚本启动失败:" + e.getMessage();
                                                context = a8.f3445a;
                                                str = com.hlzn.socketclient.b.a.e;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10103) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a9 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a10 = g.a(a2, a9);
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 2 cmScriptStopDataArrayLen = " + a9);
                                                MessageProtobuf.CmdScriptStop parseFrom3 = MessageProtobuf.CmdScriptStop.parseFrom(a10);
                                                SocketService.this.v.offer(Long.valueOf(parseFrom3.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 3 RpcId = " + parseFrom3.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10103, "服务端命令:脚本停止", (byte) 0);
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                f a11 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.j = -1;
                                                serviceParam.k = "服务端命令:脚本停止失败:" + e2.getMessage();
                                                context = a11.f3445a;
                                                str = com.hlzn.socketclient.b.a.f;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10105) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a12 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a13 = g.a(a2, a12);
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 2 cmScriptUpgradeDataArrayLen = " + a12);
                                                MessageProtobuf.CmdScriptUpgrade parseFrom4 = MessageProtobuf.CmdScriptUpgrade.parseFrom(a13);
                                                SocketService.this.w.offer(Long.valueOf(parseFrom4.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 3 RpcId=" + parseFrom4.getRpcId() + ",ScriptVersion = " + parseFrom4.getScriptVersion() + ",ScriptFileUrl=" + parseFrom4.getScriptFileUrl());
                                                f.a();
                                                new com.hlzn.socketclient.c.a("服务端命令:脚本更新", parseFrom4.getScriptVersion(), parseFrom4.getScriptFileUrl());
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                f a14 = f.a();
                                                String str2 = "服务端命令:脚本更新失败:" + e3.getMessage();
                                                serviceParam = new ServiceParam();
                                                serviceParam.d = str2;
                                                serviceParam.l = -1;
                                                serviceParam.m = str2;
                                                context = a14.f3445a;
                                                str = com.hlzn.socketclient.b.a.g;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10107) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                String a15 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2));
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> cmScriptSettingsBufferHexStr=" + a15);
                                                int a16 = com.hlzn.socketclient.f.a.a(a15);
                                                byte[] a17 = g.a(a2, a16);
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 2 cmScriptSettingsDataArrayLen = " + a16);
                                                MessageProtobuf.CmdScriptSettings parseFrom5 = MessageProtobuf.CmdScriptSettings.parseFrom(a17);
                                                SocketService.this.x.offer(Long.valueOf(parseFrom5.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 3 RpcId=" + parseFrom5.getRpcId() + ",scriptSettings = " + parseFrom5.getScriptSettings());
                                                f.a();
                                                new com.hlzn.socketclient.c.a("服务端命令:脚本设置更新", parseFrom5.getScriptSettings());
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                f a18 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.n = -1;
                                                serviceParam.o = "脚本设置更新失败:" + e4.getMessage();
                                                context = a18.f3445a;
                                                str = com.hlzn.socketclient.b.a.h;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10109) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a19 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a20 = g.a(a2, a19);
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 2 cmScreenCaptureDataArrayLen = " + a19);
                                                MessageProtobuf.CmdScreenCapture parseFrom6 = MessageProtobuf.CmdScreenCapture.parseFrom(a20);
                                                SocketService.this.y.offer(Long.valueOf(parseFrom6.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 3 RpcId = " + parseFrom6.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10109, "服务端命令:上传截屏", (byte) 0);
                                            } catch (Exception e5) {
                                                e5.printStackTrace();
                                                f a21 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.p = -1;
                                                serviceParam.q = "服务端命令:上传截屏失败:" + e5.getMessage();
                                                context = a21.f3445a;
                                                str = com.hlzn.socketclient.b.a.i;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10111) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a22 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a23 = g.a(a2, a22);
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 2 cmdUnBindStudioProjectDataArrayLen = " + a22);
                                                MessageProtobuf.CmdUnBindStudioProject parseFrom7 = MessageProtobuf.CmdUnBindStudioProject.parseFrom(a23);
                                                SocketService.this.z.offer(Long.valueOf(parseFrom7.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 3 RpcId = " + parseFrom7.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10111, "服务端命令:解绑工作室项目", (byte) 0);
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                                f a24 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.r = -1;
                                                serviceParam.s = "服务端命令:解绑工作室项目失败:" + e6.getMessage();
                                                context = a24.f3445a;
                                                str = com.hlzn.socketclient.b.a.j;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10113) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a25 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a26 = g.a(a2, a25);
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 2 cmdRenameDeviceNameDataArrayLen = " + a25);
                                                MessageProtobuf.CmdRenameDeviceName parseFrom8 = MessageProtobuf.CmdRenameDeviceName.parseFrom(a26);
                                                SocketService.this.A.offer(Long.valueOf(parseFrom8.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 3 RpcId = " + parseFrom8.getRpcId());
                                                new com.hlzn.socketclient.c.a(10113, "服务端命令:修改设备名", (byte) 0).g = parseFrom8.getNewDeviceName();
                                                f.a();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                                f a27 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.t = -1;
                                                serviceParam.u = "服务端命令:修改设备名失败:" + e7.getMessage();
                                                context = a27.f3445a;
                                                str = com.hlzn.socketclient.b.a.k;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        }
                                        Thread.sleep(50);
                                    } else {
                                        try {
                                            d.b(SocketService.m, "登陆响应 --> 1");
                                            a2.read(bArr2, 0, 4);
                                            int a28 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                            byte[] a29 = g.a(a2, a28);
                                            d.b(SocketService.m, "登陆响应 --> 2 dataArrayLen = " + a28);
                                            MessageProtobuf.LoginResult parseFrom9 = MessageProtobuf.LoginResult.parseFrom(a29);
                                            d.b(SocketService.m, "登陆响应 --> 3 code=" + parseFrom9.getError() + ",message = " + parseFrom9.getMessage());
                                            new com.hlzn.socketclient.c.a(parseFrom9.getError(), parseFrom9.getMessage());
                                            f.a();
                                            SocketService.this.k.a("-1");
                                            com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "登陆响应 -->  code=" + parseFrom9.getError() + ",message=" + parseFrom9.getMessage());
                                        } catch (Exception e8) {
                                            e8.printStackTrace();
                                        }
                                        Thread.sleep(50);
                                    }
                                } else {
                                    d.b(SocketService.m, "服务器重启……");
                                    socketService = SocketService.this;
                                }
                            } else {
                                d.b(SocketService.m, "出错重连……");
                                socketService = SocketService.this;
                            }
                        }
                        SocketService.k(socketService);
                    } catch (IOException e9) {
                        com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "ex=" + e9.getMessage());
                        SocketService.k(SocketService.this);
                        e9.printStackTrace();
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        });
        this.d.start();
    }

    private void g(final int i2, final String str) {
        if (!this.A.isEmpty()) {
            new Thread() {
                public final void run() {
                    super.run();
                    MessageProtobuf.CmdRenameDeviceNameResult.Builder newBuilder = MessageProtobuf.CmdRenameDeviceNameResult.newBuilder();
                    newBuilder.setRpcId(((Long) SocketService.this.A.poll()).longValue()).setError(r0).setMessage(r1);
                    String d = SocketService.m;
                    d.b(d, "cmdRenameDeviceNameSuccessOperate --> rpcId =" + newBuilder.getRpcId() + ",code=" + r0 + ",msg=" + r1);
                    com.hlzn.socketclient.a.a a2 = com.hlzn.socketclient.a.a.a();
                    Socket b2 = SocketService.this.f3460b;
                    MessageProtobuf.CmdRenameDeviceNameResult build = newBuilder.build();
                    byte[] b3 = com.hlzn.socketclient.f.a.b(10114);
                    byte[] byteArray = build.toByteArray();
                    byte[] a3 = com.hlzn.socketclient.f.a.a(b3, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
                    String str = a2.f3423a;
                    d.b(str, "cmdRenameDeviceNameResult --> binary value = " + b3[1] + b3[0]);
                    if (b2 != null && b2.isConnected()) {
                        try {
                            OutputStream outputStream = b2.getOutputStream();
                            outputStream.write(a3);
                            outputStream.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }

    private void h() {
        this.f3461c = new Thread(new Runnable() {
            public final void run() {
                while (SocketService.this.f) {
                    MessageProtobuf.Heartbeat.Builder newBuilder = MessageProtobuf.Heartbeat.newBuilder();
                    newBuilder.setRpcId(com.hlzn.socketclient.f.b.a()).setScriptRunning(SocketService.this.j);
                    MessageProtobuf.Heartbeat build = newBuilder.build();
                    com.hlzn.socketclient.a.a.a();
                    com.hlzn.socketclient.a.a.a(SocketService.this.f3460b, build);
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.f3461c.start();
    }

    private void i() {
        d.b(m, "login --> ");
        File a2 = com.hlzn.socketclient.f.e.a((Context) this);
        com.hlzn.socketclient.f.e.a(a2, "login --> mIMToken=" + this.q);
        com.hlzn.socketclient.b.a.u = false;
        if (!TextUtils.isEmpty(this.q)) {
            this.e = new Thread(new Runnable() {
                public final void run() {
                    MessageProtobuf.Login.Builder newBuilder = MessageProtobuf.Login.newBuilder();
                    newBuilder.setRpcId(com.hlzn.socketclient.f.b.a()).setAppId(SocketService.this.n.longValue()).setScriptId(SocketService.this.o).setDeviceId(SocketService.this.p).setIMToken(SocketService.this.q).setScriptRunning(SocketService.this.j);
                    MessageProtobuf.Login build = newBuilder.build();
                    com.hlzn.socketclient.a.a.a();
                    com.hlzn.socketclient.a.a.a(SocketService.this.f3460b, build);
                }
            });
            this.e.start();
        }
    }

    private void j() {
        if (this.f3460b != null) {
            com.hlzn.socketclient.a.a.a().b(this.f3460b);
        }
    }

    private void k() {
        d.b(m, "scriptStart");
        new Thread() {
            public final void run() {
                super.run();
                MessageProtobuf.ScriptStart.Builder newBuilder = MessageProtobuf.ScriptStart.newBuilder();
                com.hlzn.socketclient.a.a.a();
                com.hlzn.socketclient.a.a.a(SocketService.this.f3460b, newBuilder.build());
            }
        }.start();
    }

    static /* synthetic */ void k(SocketService socketService) {
        d.b(m, "proxyCreateConnection --> 1 ");
        if (socketService.k != null) {
            d.b(m, "proxyCreateConnection --> 2 ");
            e eVar = socketService.k;
            if (!eVar.f3442b.containsKey("-1")) {
                eVar.f3442b.put("-1", new com.hlzn.socketclient.d(eVar.f3443c, "-1"));
            }
            String str = eVar.f3441a;
            d.b(str, "add --> 添加消息到发送超时管理器 rpcId=" + "-1");
        }
    }

    private void l() {
        new Thread() {
            public final void run() {
                super.run();
                MessageProtobuf.ScriptStop.Builder newBuilder = MessageProtobuf.ScriptStop.newBuilder();
                com.hlzn.socketclient.a.a.a();
                com.hlzn.socketclient.a.a.a(SocketService.this.f3460b, newBuilder.build());
            }
        }.start();
    }

    private void m() {
        if (this.f3460b != null) {
            com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) this), "stopService --> ");
            e();
            com.hlzn.socketclient.a.a.a().b(this.f3460b);
            stopSelf();
            this.f3460b = null;
            this.f3461c = null;
            this.d = null;
            this.s = null;
            this.f = false;
            this.g = false;
        }
    }

    private e n() {
        return this.k;
    }

    private boolean o() {
        return this.f3460b == null || !this.f3460b.isConnected();
    }

    private void p() {
        d.b(m, "proxyCreateConnection --> 1 ");
        if (this.k != null) {
            d.b(m, "proxyCreateConnection --> 2 ");
            e eVar = this.k;
            if (!eVar.f3442b.containsKey("-1")) {
                eVar.f3442b.put("-1", new com.hlzn.socketclient.d(eVar.f3443c, "-1"));
            }
            String str = eVar.f3441a;
            d.b(str, "add --> 添加消息到发送超时管理器 rpcId=" + "-1");
        }
    }

    public final void c() {
        d.b(m, "resetConnect -->");
        if (!com.hlzn.socketclient.b.a.u) {
            com.hlzn.socketclient.b.a.u = true;
            File a2 = com.hlzn.socketclient.f.e.a((Context) this);
            com.hlzn.socketclient.f.e.a(a2, "resetConnect --> IMConfig.IS_RECONNECT=" + com.hlzn.socketclient.b.a.u);
            this.g = false;
            if (this.f3460b != null) {
                com.hlzn.socketclient.a.a.a().b(this.f3460b);
            }
            this.k.a();
            f.a();
            new com.hlzn.socketclient.c.a(-1, "重连", (byte) 0);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.i;
    }

    public void onCreate() {
        super.onCreate();
        File a2 = com.hlzn.socketclient.f.e.a((Context) this);
        if (com.hlzn.socketclient.f.e.a(a2)) {
            com.hlzn.socketclient.f.e.a(a2, "", (String) null, false);
        }
        d.b(m, "onCreate --> ");
        f();
        String str = m;
        d.b(str, "receiveMsg --> isReceive=" + this.g);
        this.d = new Thread(new Runnable() {
            public final void run() {
                SocketService socketService;
                ServiceParam serviceParam;
                Context context;
                String str;
                while (SocketService.this.g) {
                    try {
                        if (SocketService.this.f3460b == null || !SocketService.this.f3460b.isConnected()) {
                            d.b(SocketService.m, "重连……");
                            socketService = SocketService.this;
                        } else {
                            DataInputStream a2 = com.hlzn.socketclient.a.a.a().a(SocketService.this.f3460b);
                            new ByteArrayOutputStream();
                            if (a2 != null) {
                                byte[] bArr = new byte[2];
                                byte[] bArr2 = new byte[4];
                                int read = a2.read(bArr, 0, 2);
                                d.b(SocketService.m, "receiveMsg --> 1 cmd_length=" + read + ",content=" + bArr[1] + bArr[0]);
                                if (read == 2) {
                                    String a3 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr));
                                    int a4 = com.hlzn.socketclient.f.a.a(a3);
                                    d.b(SocketService.m, "receiveMsg --> 2 hexStr=" + a3 + ",cmd=" + a4);
                                    if (a4 != 10002) {
                                        if (a4 == 10004) {
                                            d.b(SocketService.m, "心跳返回 --> 1");
                                            a2.read(bArr2, 0, 4);
                                            int a5 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                            byte[] bArr3 = new byte[a5];
                                            a2.read(bArr3, 0, a5);
                                            d.b(SocketService.m, "心跳返回 --> 2 heartDataArrayLen = " + a5);
                                            MessageProtobuf.HeartbeatResult parseFrom = MessageProtobuf.HeartbeatResult.parseFrom(bArr3);
                                            d.b(SocketService.m, "心跳返回 --> 3 disabled =" + parseFrom.getDisabled());
                                            new com.hlzn.socketclient.c.a(10004, "心跳响应", (byte) 0).h = parseFrom.getDisabled();
                                            f.a();
                                            SocketService.this.k.a("-1");
                                            com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "心跳返回 -->  disabled=" + parseFrom.getDisabled());
                                        } else if (a4 == 10101) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a6 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a7 = g.a(a2, a6);
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 2 cmScriptStartDataArrayLen = " + a6);
                                                MessageProtobuf.CmdScriptStart parseFrom2 = MessageProtobuf.CmdScriptStart.parseFrom(a7);
                                                SocketService.this.u.offer(Long.valueOf(parseFrom2.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本启动 --> 3 RpcId = " + parseFrom2.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10101, "服务端命令:脚本启动", (byte) 0);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                f a8 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.h = -1;
                                                serviceParam.i = "服务端命令:脚本启动失败:" + e.getMessage();
                                                context = a8.f3445a;
                                                str = com.hlzn.socketclient.b.a.e;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10103) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a9 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a10 = g.a(a2, a9);
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 2 cmScriptStopDataArrayLen = " + a9);
                                                MessageProtobuf.CmdScriptStop parseFrom3 = MessageProtobuf.CmdScriptStop.parseFrom(a10);
                                                SocketService.this.v.offer(Long.valueOf(parseFrom3.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本停止 --> 3 RpcId = " + parseFrom3.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10103, "服务端命令:脚本停止", (byte) 0);
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                f a11 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.j = -1;
                                                serviceParam.k = "服务端命令:脚本停止失败:" + e2.getMessage();
                                                context = a11.f3445a;
                                                str = com.hlzn.socketclient.b.a.f;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10105) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a12 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a13 = g.a(a2, a12);
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 2 cmScriptUpgradeDataArrayLen = " + a12);
                                                MessageProtobuf.CmdScriptUpgrade parseFrom4 = MessageProtobuf.CmdScriptUpgrade.parseFrom(a13);
                                                SocketService.this.w.offer(Long.valueOf(parseFrom4.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本更新 --> 3 RpcId=" + parseFrom4.getRpcId() + ",ScriptVersion = " + parseFrom4.getScriptVersion() + ",ScriptFileUrl=" + parseFrom4.getScriptFileUrl());
                                                f.a();
                                                new com.hlzn.socketclient.c.a("服务端命令:脚本更新", parseFrom4.getScriptVersion(), parseFrom4.getScriptFileUrl());
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                f a14 = f.a();
                                                String str2 = "服务端命令:脚本更新失败:" + e3.getMessage();
                                                serviceParam = new ServiceParam();
                                                serviceParam.d = str2;
                                                serviceParam.l = -1;
                                                serviceParam.m = str2;
                                                context = a14.f3445a;
                                                str = com.hlzn.socketclient.b.a.g;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10107) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                String a15 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2));
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> cmScriptSettingsBufferHexStr=" + a15);
                                                int a16 = com.hlzn.socketclient.f.a.a(a15);
                                                byte[] a17 = g.a(a2, a16);
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 2 cmScriptSettingsDataArrayLen = " + a16);
                                                MessageProtobuf.CmdScriptSettings parseFrom5 = MessageProtobuf.CmdScriptSettings.parseFrom(a17);
                                                SocketService.this.x.offer(Long.valueOf(parseFrom5.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:脚本设置更新 --> 3 RpcId=" + parseFrom5.getRpcId() + ",scriptSettings = " + parseFrom5.getScriptSettings());
                                                f.a();
                                                new com.hlzn.socketclient.c.a("服务端命令:脚本设置更新", parseFrom5.getScriptSettings());
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                f a18 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.n = -1;
                                                serviceParam.o = "脚本设置更新失败:" + e4.getMessage();
                                                context = a18.f3445a;
                                                str = com.hlzn.socketclient.b.a.h;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10109) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a19 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a20 = g.a(a2, a19);
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 2 cmScreenCaptureDataArrayLen = " + a19);
                                                MessageProtobuf.CmdScreenCapture parseFrom6 = MessageProtobuf.CmdScreenCapture.parseFrom(a20);
                                                SocketService.this.y.offer(Long.valueOf(parseFrom6.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:上传截屏 --> 3 RpcId = " + parseFrom6.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10109, "服务端命令:上传截屏", (byte) 0);
                                            } catch (Exception e5) {
                                                e5.printStackTrace();
                                                f a21 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.p = -1;
                                                serviceParam.q = "服务端命令:上传截屏失败:" + e5.getMessage();
                                                context = a21.f3445a;
                                                str = com.hlzn.socketclient.b.a.i;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10111) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a22 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a23 = g.a(a2, a22);
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 2 cmdUnBindStudioProjectDataArrayLen = " + a22);
                                                MessageProtobuf.CmdUnBindStudioProject parseFrom7 = MessageProtobuf.CmdUnBindStudioProject.parseFrom(a23);
                                                SocketService.this.z.offer(Long.valueOf(parseFrom7.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:解绑工作室项目  --> 3 RpcId = " + parseFrom7.getRpcId());
                                                f.a();
                                                new com.hlzn.socketclient.c.a(10111, "服务端命令:解绑工作室项目", (byte) 0);
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                                f a24 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.r = -1;
                                                serviceParam.s = "服务端命令:解绑工作室项目失败:" + e6.getMessage();
                                                context = a24.f3445a;
                                                str = com.hlzn.socketclient.b.a.j;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        } else if (a4 == 10113) {
                                            try {
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 1");
                                                a2.read(bArr2, 0, 4);
                                                int a25 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                                byte[] a26 = g.a(a2, a25);
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 2 cmdRenameDeviceNameDataArrayLen = " + a25);
                                                MessageProtobuf.CmdRenameDeviceName parseFrom8 = MessageProtobuf.CmdRenameDeviceName.parseFrom(a26);
                                                SocketService.this.A.offer(Long.valueOf(parseFrom8.getRpcId()));
                                                d.b(SocketService.m, "服务端命令:修改设备名 --> 3 RpcId = " + parseFrom8.getRpcId());
                                                new com.hlzn.socketclient.c.a(10113, "服务端命令:修改设备名", (byte) 0).g = parseFrom8.getNewDeviceName();
                                                f.a();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                                f a27 = f.a();
                                                serviceParam = new ServiceParam();
                                                serviceParam.t = -1;
                                                serviceParam.u = "服务端命令:修改设备名失败:" + e7.getMessage();
                                                context = a27.f3445a;
                                                str = com.hlzn.socketclient.b.a.k;
                                                c.a(context, str, serviceParam);
                                                Thread.sleep(50);
                                            }
                                        }
                                        Thread.sleep(50);
                                    } else {
                                        try {
                                            d.b(SocketService.m, "登陆响应 --> 1");
                                            a2.read(bArr2, 0, 4);
                                            int a28 = com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.a(com.hlzn.socketclient.f.a.b(bArr2)));
                                            byte[] a29 = g.a(a2, a28);
                                            d.b(SocketService.m, "登陆响应 --> 2 dataArrayLen = " + a28);
                                            MessageProtobuf.LoginResult parseFrom9 = MessageProtobuf.LoginResult.parseFrom(a29);
                                            d.b(SocketService.m, "登陆响应 --> 3 code=" + parseFrom9.getError() + ",message = " + parseFrom9.getMessage());
                                            new com.hlzn.socketclient.c.a(parseFrom9.getError(), parseFrom9.getMessage());
                                            f.a();
                                            SocketService.this.k.a("-1");
                                            com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "登陆响应 -->  code=" + parseFrom9.getError() + ",message=" + parseFrom9.getMessage());
                                        } catch (Exception e8) {
                                            e8.printStackTrace();
                                        }
                                        Thread.sleep(50);
                                    }
                                } else {
                                    d.b(SocketService.m, "服务器重启……");
                                    socketService = SocketService.this;
                                }
                            } else {
                                d.b(SocketService.m, "出错重连……");
                                socketService = SocketService.this;
                            }
                        }
                        SocketService.k(socketService);
                    } catch (IOException e9) {
                        com.hlzn.socketclient.f.e.a(com.hlzn.socketclient.f.e.a((Context) SocketService.this), "ex=" + e9.getMessage());
                        SocketService.k(SocketService.this);
                        e9.printStackTrace();
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        });
        this.d.start();
        this.f = true;
        this.g = true;
        this.h = false;
        e();
        com.hlzn.socketclient.b.a.v = true;
    }

    public void onDestroy() {
        super.onDestroy();
        d.b(m, "onDestroy --> ");
        this.k.a();
        if (this.f3460b != null) {
            com.hlzn.socketclient.a.a.a().b(this.f3460b);
            stopSelf();
            this.f3461c = null;
            this.d = null;
            this.s = null;
            this.f = false;
            this.g = false;
        }
        com.hlzn.socketclient.b.a.v = false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r6, int r7, int r8) {
        /*
            r5 = this;
            java.lang.String r0 = m
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onStartCommand --> flags="
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r2 = ",startId="
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ",isScriptRunning="
            r1.append(r2)
            boolean r2 = r5.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hlzn.socketclient.f.d.b(r0, r1)
            if (r6 == 0) goto L_0x02d7
            java.lang.String r0 = "service_tag"
            java.lang.String r0 = r6.getStringExtra(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02d7
            java.lang.String r0 = "service_tag"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r1 = "service_param"
            android.os.Parcelable r1 = r6.getParcelableExtra(r1)
            com.hlzn.socketclient.bean.ServiceParam r1 = (com.hlzn.socketclient.bean.ServiceParam) r1
            r5.r = r1
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            if (r1 == 0) goto L_0x008f
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.f3432c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x005f
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.f3432c
            long r1 = java.lang.Long.parseLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r5.n = r1
        L_0x005f:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.d
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x006f
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.d
            r5.o = r1
        L_0x006f:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.e
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x007f
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.e
            r5.p = r1
        L_0x007f:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.f
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x008f
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.f
            r5.q = r1
        L_0x008f:
            r1 = -1
            int r2 = r0.hashCode()
            r3 = 1
            r4 = 0
            switch(r2) {
                case -2042651263: goto L_0x011a;
                case -1976316396: goto L_0x0110;
                case -1298630879: goto L_0x0105;
                case -1295722957: goto L_0x00fb;
                case -860257962: goto L_0x00f0;
                case -743327780: goto L_0x00e6;
                case -520010627: goto L_0x00db;
                case -83357381: goto L_0x00d1;
                case -75881701: goto L_0x00c6;
                case 6425533: goto L_0x00bc;
                case 102704814: goto L_0x00b1;
                case 249479253: goto L_0x00a6;
                case 1193287802: goto L_0x009b;
                default: goto L_0x0099;
            }
        L_0x0099:
            goto L_0x0124
        L_0x009b:
            java.lang.String r2 = "cmd_script_stop_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 7
            goto L_0x0124
        L_0x00a6:
            java.lang.String r2 = "shut_down_connection_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 1
            goto L_0x0124
        L_0x00b1:
            java.lang.String r2 = "login_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 2
            goto L_0x0124
        L_0x00bc:
            java.lang.String r2 = "stop_service_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 0
            goto L_0x0124
        L_0x00c6:
            java.lang.String r2 = "cmd_script_settings_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 9
            goto L_0x0124
        L_0x00d1:
            java.lang.String r2 = "script_stop_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 5
            goto L_0x0124
        L_0x00db:
            java.lang.String r2 = "cmd_unbind_studio_project_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 11
            goto L_0x0124
        L_0x00e6:
            java.lang.String r2 = "cmd_script_start_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 6
            goto L_0x0124
        L_0x00f0:
            java.lang.String r2 = "cmd_script_upgrade_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 8
            goto L_0x0124
        L_0x00fb:
            java.lang.String r2 = "script_start_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 4
            goto L_0x0124
        L_0x0105:
            java.lang.String r2 = "cmd_screen_capture_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 10
            goto L_0x0124
        L_0x0110:
            java.lang.String r2 = "send_heart_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 3
            goto L_0x0124
        L_0x011a:
            java.lang.String r2 = "cmd_rename_device_name_success_operate"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0124
            r1 = 12
        L_0x0124:
            switch(r1) {
                case 0: goto L_0x02ae;
                case 1: goto L_0x0278;
                case 2: goto L_0x023f;
                case 3: goto L_0x022c;
                case 4: goto L_0x0202;
                case 5: goto L_0x01df;
                case 6: goto L_0x01c5;
                case 7: goto L_0x01ab;
                case 8: goto L_0x0191;
                case 9: goto L_0x0177;
                case 10: goto L_0x015d;
                case 11: goto L_0x0143;
                case 12: goto L_0x0129;
                default: goto L_0x0127;
            }
        L_0x0127:
            goto L_0x02d7
        L_0x0129:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.t
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.u
            java.util.Queue<java.lang.Long> r2 = r5.A
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$5 r2 = new com.hlzn.socketclient.service.SocketService$5
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x0143:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.r
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.s
            java.util.Queue<java.lang.Long> r2 = r5.z
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$4 r2 = new com.hlzn.socketclient.service.SocketService$4
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x015d:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.p
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.q
            java.util.Queue<java.lang.Long> r2 = r5.y
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$3 r2 = new com.hlzn.socketclient.service.SocketService$3
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x0177:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.n
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.o
            java.util.Queue<java.lang.Long> r2 = r5.x
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$2 r2 = new com.hlzn.socketclient.service.SocketService$2
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x0191:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.l
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.m
            java.util.Queue<java.lang.Long> r2 = r5.w
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$13 r2 = new com.hlzn.socketclient.service.SocketService$13
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x01ab:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.j
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.k
            java.util.Queue<java.lang.Long> r2 = r5.v
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$12 r2 = new com.hlzn.socketclient.service.SocketService$12
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x01c5:
            com.hlzn.socketclient.bean.ServiceParam r0 = r5.r
            int r0 = r0.h
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            java.lang.String r1 = r1.i
            java.util.Queue<java.lang.Long> r2 = r5.u
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02d7
            com.hlzn.socketclient.service.SocketService$11 r2 = new com.hlzn.socketclient.service.SocketService$11
            r2.<init>(r0, r1)
            r2.start()
            goto L_0x02d7
        L_0x01df:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            boolean r1 = r1.g
            r5.j = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "mIsScriptRunning:"
            r1.<init>(r2)
            boolean r2 = r5.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hlzn.socketclient.f.d.b(r0, r1)
            com.hlzn.socketclient.service.SocketService$10 r0 = new com.hlzn.socketclient.service.SocketService$10
            r0.<init>()
            r0.start()
            goto L_0x02d7
        L_0x0202:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            boolean r1 = r1.g
            r5.j = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "mIsScriptRunning:"
            r1.<init>(r2)
            boolean r2 = r5.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hlzn.socketclient.f.d.b(r0, r1)
            java.lang.String r0 = m
            java.lang.String r1 = "scriptStart"
            com.hlzn.socketclient.f.d.b(r0, r1)
            com.hlzn.socketclient.service.SocketService$9 r0 = new com.hlzn.socketclient.service.SocketService$9
            r0.<init>()
            r0.start()
            goto L_0x02d7
        L_0x022c:
            java.lang.Thread r0 = new java.lang.Thread
            com.hlzn.socketclient.service.SocketService$7 r1 = new com.hlzn.socketclient.service.SocketService$7
            r1.<init>()
            r0.<init>(r1)
            r5.f3461c = r0
            java.lang.Thread r0 = r5.f3461c
        L_0x023a:
            r0.start()
            goto L_0x02d7
        L_0x023f:
            r5.g = r3
            java.lang.String r0 = m
            java.lang.String r1 = "login --> "
            com.hlzn.socketclient.f.d.b(r0, r1)
            java.io.File r0 = com.hlzn.socketclient.f.e.a((android.content.Context) r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "login --> mIMToken="
            r1.<init>(r2)
            java.lang.String r2 = r5.q
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hlzn.socketclient.f.e.a(r0, r1)
            com.hlzn.socketclient.b.a.u = r4
            java.lang.String r0 = r5.q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x02d7
            java.lang.Thread r0 = new java.lang.Thread
            com.hlzn.socketclient.service.SocketService$8 r1 = new com.hlzn.socketclient.service.SocketService$8
            r1.<init>()
            r0.<init>(r1)
            r5.e = r0
            java.lang.Thread r0 = r5.e
            goto L_0x023a
        L_0x0278:
            com.hlzn.socketclient.bean.ServiceParam r1 = r5.r
            boolean r1 = r1.g
            r5.j = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "mIsScriptRunning:"
            r1.<init>(r2)
            boolean r2 = r5.j
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.hlzn.socketclient.f.d.b(r0, r1)
            java.net.Socket r0 = r5.f3460b
            if (r0 == 0) goto L_0x02d7
            java.io.File r0 = com.hlzn.socketclient.f.e.a((android.content.Context) r5)
            java.lang.String r1 = "SHUT_DOWN_CONNECTION_OPERATE 关闭连接操作 ---> "
            com.hlzn.socketclient.f.e.a(r0, r1)
            com.hlzn.socketclient.a.a r0 = com.hlzn.socketclient.a.a.a()
            java.net.Socket r1 = r5.f3460b
            r0.b(r1)
            r5.e()
            r5.f()
            goto L_0x02d7
        L_0x02ae:
            java.net.Socket r0 = r5.f3460b
            if (r0 == 0) goto L_0x02d7
            java.io.File r0 = com.hlzn.socketclient.f.e.a((android.content.Context) r5)
            java.lang.String r1 = "stopService --> "
            com.hlzn.socketclient.f.e.a(r0, r1)
            r5.e()
            com.hlzn.socketclient.a.a r0 = com.hlzn.socketclient.a.a.a()
            java.net.Socket r1 = r5.f3460b
            r0.b(r1)
            r5.stopSelf()
            r0 = 0
            r5.f3460b = r0
            r5.f3461c = r0
            r5.d = r0
            r5.s = r0
            r5.f = r4
            r5.g = r4
        L_0x02d7:
            int r6 = super.onStartCommand(r6, r7, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hlzn.socketclient.service.SocketService.onStartCommand(android.content.Intent, int, int):int");
    }
}
