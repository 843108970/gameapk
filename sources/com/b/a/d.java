package com.b.a;

import com.b.a.a.a.f;
import com.b.a.a.a.i;
import java.io.Closeable;
import java.io.Flushable;

public final class d implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    final i f800a;

    /* renamed from: b  reason: collision with root package name */
    final f f801b;

    public final void close() {
        this.f801b.close();
    }

    public final void flush() {
        this.f801b.flush();
    }
}
