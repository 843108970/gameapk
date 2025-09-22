package com.b.a.a.e;

import android.support.v7.widget.ActivityChooserView;
import com.b.b.f;
import com.b.b.h;
import com.b.b.x;
import com.b.b.y;
import java.util.logging.Level;

final class z implements x {

    /* renamed from: a  reason: collision with root package name */
    int f714a;

    /* renamed from: b  reason: collision with root package name */
    byte f715b;

    /* renamed from: c  reason: collision with root package name */
    int f716c;
    int d;
    short e;
    private final h f;

    public z(h hVar) {
        this.f = hVar;
    }

    public final long a(f fVar, long j) {
        while (this.d == 0) {
            this.f.f((long) this.e);
            this.e = 0;
            if ((this.f715b & 4) != 0) {
                return -1;
            }
            int i = this.f716c;
            int a2 = y.a(this.f);
            this.d = a2;
            this.f714a = a2;
            byte e2 = (byte) (this.f.e() & 255);
            this.f715b = (byte) (this.f.e() & 255);
            if (y.f711a.isLoggable(Level.FINE)) {
                y.f711a.fine(g.a(true, this.f716c, this.f714a, e2, this.f715b));
            }
            this.f716c = this.f.g() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            if (e2 != 9) {
                throw g.b("%s != TYPE_CONTINUATION", Byte.valueOf(e2));
            } else if (this.f716c != i) {
                throw g.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
        long a3 = this.f.a(fVar, Math.min(j, (long) this.d));
        if (a3 == -1) {
            return -1;
        }
        this.d = (int) (((long) this.d) - a3);
        return a3;
    }

    public final y a() {
        return this.f.a();
    }

    public final void close() {
    }
}
