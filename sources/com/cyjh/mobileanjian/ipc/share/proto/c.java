package com.cyjh.mobileanjian.ipc.share.proto;

import java.nio.ByteBuffer;

public abstract class c {
    private ByteBuffer b() {
        int length = a().length;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(length + 4)]);
        wrap.putInt(length);
        wrap.put(a());
        wrap.flip();
        return wrap;
    }

    public abstract byte[] a();
}
