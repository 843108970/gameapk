package com.cyjh.mobileanjian.ipc.share.proto;

import com.cyjh.mobileanjian.ipc.share.proto.Ipc;

public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private Ipc.IpcMessage f2583a = null;

    public b(Ipc.IpcMessage ipcMessage) {
        this.f2583a = ipcMessage;
    }

    public static final Ipc.IpcMessage a(int i) {
        return Ipc.IpcMessage.newBuilder().setCmd(i).build();
    }

    public final byte[] a() {
        if (this.f2583a == null) {
            return null;
        }
        return this.f2583a.toByteArray();
    }
}
