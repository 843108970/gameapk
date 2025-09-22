package com.hlzn.socketclient.a;

import com.hlzn.socketclient.f.d;
import com.hlzn.socketclient.pbmsg.MessageProtobuf;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f3422b;

    /* renamed from: a  reason: collision with root package name */
    public final String f3423a = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private DataOutputStream f3424c;
    private DataInputStream d;

    public static a a() {
        if (f3422b == null) {
            synchronized (a.class) {
                if (f3422b == null) {
                    f3422b = new a();
                }
            }
        }
        return f3422b;
    }

    private void a(Socket socket, MessageProtobuf.CmdRenameDeviceNameResult cmdRenameDeviceNameResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10114);
        byte[] byteArray = cmdRenameDeviceNameResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdRenameDeviceNameResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdScreenCaptureResult cmdScreenCaptureResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10110);
        byte[] byteArray = cmdScreenCaptureResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdScreenCaptureResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdScriptSettingsResult cmdScriptSettingsResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10108);
        byte[] byteArray = cmdScriptSettingsResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdScriptSettingsResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdScriptStartResult cmdScriptStartResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10102);
        byte[] byteArray = cmdScriptStartResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdScriptStartResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdScriptStopResult cmdScriptStopResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10104);
        byte[] byteArray = cmdScriptStopResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdScriptStopResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdScriptUpgradeResult cmdScriptUpgradeResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10106);
        byte[] byteArray = cmdScriptUpgradeResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdScriptUpgradeResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(Socket socket, MessageProtobuf.CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10112);
        byte[] byteArray = cmdUnBindStudioProjectResult.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        String str = this.f3423a;
        d.b(str, "cmdUnBindStudioProjectResult --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Socket socket, MessageProtobuf.Login login) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10001);
        byte[] byteArray = login.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        d.b("SocketService", "sendLogin --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Socket socket, MessageProtobuf.ScriptStart scriptStart) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10005);
        byte[] byteArray = scriptStart.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        d.b("SocketService", "scriptStart --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Socket socket, MessageProtobuf.ScriptStop scriptStop) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10006);
        byte[] byteArray = scriptStop.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        d.b("SocketService", "scriptStop --> binary value = " + b2[1] + b2[0]);
        if (socket != null && socket.isConnected()) {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(a2);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(Socket socket, MessageProtobuf.Heartbeat heartbeat) {
        byte[] b2 = com.hlzn.socketclient.f.a.b(10003);
        byte[] byteArray = heartbeat.toByteArray();
        byte[] a2 = com.hlzn.socketclient.f.a.a(b2, com.hlzn.socketclient.f.a.a(byteArray.length), byteArray);
        d.b("SocketService", "sendHeart --> binary value = " + b2[1] + b2[0]);
        if (socket == null || !socket.isConnected()) {
            return false;
        }
        try {
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(a2);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final DataInputStream a(Socket socket) {
        if (socket == null || socket.isClosed() || !socket.isConnected()) {
            return null;
        }
        try {
            this.d = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            if (this.d != null) {
                try {
                    this.d.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.d;
    }

    public final void b(Socket socket) {
        try {
            if (this.f3424c != null) {
                this.f3424c.close();
            }
            if (this.d != null) {
                this.d.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
