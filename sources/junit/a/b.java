package junit.a;

import junit.b.i;
import junit.b.m;

public final class b extends c {

    /* renamed from: b  reason: collision with root package name */
    private int f4019b;

    private b(i iVar, int i) {
        super(iVar);
        if (i < 0) {
            throw new IllegalArgumentException("Repetition count must be >= 0");
        }
        this.f4019b = i;
    }

    public final int a() {
        return super.a() * this.f4019b;
    }

    public final void a(m mVar) {
        for (int i = 0; i < this.f4019b && !mVar.f(); i++) {
            super.a(mVar);
        }
    }

    public final String toString() {
        return super.toString() + "(repeated)";
    }
}
