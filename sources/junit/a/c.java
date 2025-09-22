package junit.a;

import junit.b.a;
import junit.b.i;
import junit.b.m;

public class c extends a implements i {

    /* renamed from: a  reason: collision with root package name */
    protected i f4020a;

    public c(i iVar) {
        this.f4020a = iVar;
    }

    public int a() {
        return this.f4020a.a();
    }

    public void a(m mVar) {
        b(mVar);
    }

    public final i b() {
        return this.f4020a;
    }

    public final void b(m mVar) {
        this.f4020a.a(mVar);
    }

    public String toString() {
        return this.f4020a.toString();
    }
}
