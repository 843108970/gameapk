package com.c.d;

import java.io.ByteArrayOutputStream;

public final class e extends ByteArrayOutputStream {
    public e(int i) {
        super(i);
    }

    public final byte[] toByteArray() {
        return this.count == this.buf.length ? this.buf : super.toByteArray();
    }
}
