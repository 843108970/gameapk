package com.b.a;

import com.b.a.a.c;
import com.b.b.f;
import com.b.b.h;
import java.io.Closeable;

public abstract class au implements Closeable {
    public static au a(byte[] bArr) {
        f a2 = new f().b(bArr);
        long length = (long) bArr.length;
        if (a2 != null) {
            return new av(length, a2);
        }
        throw new NullPointerException("source == null");
    }

    public abstract ah a();

    public abstract long b();

    public abstract h c();

    public void close() {
        c.a((Closeable) c());
    }

    public final String d() {
        h c2 = c();
        try {
            ah a2 = a();
            return c2.a(c.a(c2, a2 != null ? a2.a(c.e) : c.e));
        } finally {
            c.a((Closeable) c2);
        }
    }
}
