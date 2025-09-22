package b.a.c;

import b.ag;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ag> f65a = new LinkedHashSet();

    public final synchronized void a(ag agVar) {
        this.f65a.add(agVar);
    }

    public final synchronized void b(ag agVar) {
        this.f65a.remove(agVar);
    }

    public final synchronized boolean c(ag agVar) {
        return this.f65a.contains(agVar);
    }
}
