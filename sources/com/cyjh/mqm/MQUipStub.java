package com.cyjh.mqm;

public class MQUipStub {
    static {
        System.loadLibrary("mqm");
    }

    public native void SetLocalDir(String str, String str2, String str3);

    public native int StartLoop(String str, long j, String str2);

    public native int StartLoop(byte[] bArr, long j);

    public native boolean StopLoop();
}
