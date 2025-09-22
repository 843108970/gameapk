package com.umeng.commonsdk.proguard;

import java.io.ByteArrayOutputStream;

public class ac extends ByteArrayOutputStream {
    public ac() {
    }

    public ac(int i) {
        super(i);
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
