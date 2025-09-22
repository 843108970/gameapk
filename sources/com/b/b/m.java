package com.b.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class m implements x {

    /* renamed from: a  reason: collision with root package name */
    private final h f864a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f865b;

    /* renamed from: c  reason: collision with root package name */
    private int f866c;
    private boolean d;

    m(h hVar, Inflater inflater) {
        if (hVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f864a = hVar;
            this.f865b = inflater;
        }
    }

    private void b() {
        if (this.f866c != 0) {
            int remaining = this.f866c - this.f865b.getRemaining();
            this.f866c -= remaining;
            this.f864a.f((long) remaining);
        }
    }

    public final long a(f fVar, long j) {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            do {
                z = false;
                if (this.f865b.needsInput()) {
                    b();
                    if (this.f865b.getRemaining() != 0) {
                        throw new IllegalStateException("?");
                    } else if (this.f864a.d()) {
                        z = true;
                    } else {
                        t tVar = this.f864a.c().f854a;
                        this.f866c = tVar.f881c - tVar.f880b;
                        this.f865b.setInput(tVar.f879a, tVar.f880b, this.f866c);
                    }
                }
                try {
                    t e = fVar.e(1);
                    int inflate = this.f865b.inflate(e.f879a, e.f881c, 8192 - e.f881c);
                    if (inflate > 0) {
                        e.f881c += inflate;
                        long j2 = (long) inflate;
                        fVar.f855b += j2;
                        return j2;
                    }
                    if (!this.f865b.finished()) {
                        if (this.f865b.needsDictionary()) {
                        }
                    }
                    b();
                    if (e.f880b != e.f881c) {
                        return -1;
                    }
                    fVar.f854a = e.a();
                    u.a(e);
                    return -1;
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            } while (!z);
            throw new EOFException("source exhausted prematurely");
        }
    }

    public final y a() {
        return this.f864a.a();
    }

    public final void close() {
        if (!this.d) {
            this.f865b.end();
            this.d = true;
            this.f864a.close();
        }
    }
}
