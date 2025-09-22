package junit.b;

import java.util.Iterator;
import java.util.List;
import org.junit.b.c.a;
import org.junit.runner.a.b;
import org.junit.runner.a.d;
import org.junit.runner.c;
import org.junit.runner.k;

public final class e implements i, b, d, org.junit.runner.b {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f4026a;

    /* renamed from: b  reason: collision with root package name */
    private final k f4027b;

    /* renamed from: c  reason: collision with root package name */
    private final f f4028c;

    private e(Class<?> cls) {
        this(cls, f.getDefault());
    }

    private e(Class<?> cls, f fVar) {
        this.f4028c = fVar;
        this.f4026a = cls;
        this.f4027b = new a(cls, false).a();
    }

    private c a(c cVar) {
        if (cVar.getAnnotation(org.junit.k.class) != null) {
            return c.EMPTY;
        }
        c childlessCopy = cVar.childlessCopy();
        Iterator<c> it = cVar.getChildren().iterator();
        while (it.hasNext()) {
            c a2 = a(it.next());
            if (!a2.isEmpty()) {
                childlessCopy.addChild(a2);
            }
        }
        return childlessCopy;
    }

    private static boolean b(c cVar) {
        return cVar.getAnnotation(org.junit.k.class) != null;
    }

    private List<i> c() {
        return this.f4028c.asTestList(b());
    }

    private Class<?> d() {
        return this.f4026a;
    }

    public final int a() {
        return this.f4027b.b().testCount();
    }

    public final void a(m mVar) {
        this.f4027b.a(this.f4028c.getNotifier(mVar, this));
    }

    public final void a(org.junit.runner.a.a aVar) throws org.junit.runner.a.c {
        aVar.a((Object) this.f4027b);
    }

    public final void a(org.junit.runner.a.e eVar) {
        eVar.a(this.f4027b);
    }

    public final c b() {
        return a(this.f4027b.b());
    }

    public final String toString() {
        return this.f4026a.getName();
    }
}
