package junit.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.b.a;
import org.junit.runner.b.b;
import org.junit.runner.c;

public final class f extends HashMap<c, i> {
    private static final f fInstance = new f();
    private static final long serialVersionUID = 1;

    public static f getDefault() {
        return fInstance;
    }

    public final i asTest(c cVar) {
        if (cVar.isSuite()) {
            return createTest(cVar);
        }
        if (!containsKey(cVar)) {
            put(cVar, createTest(cVar));
        }
        return (i) get(cVar);
    }

    public final List<i> asTestList(c cVar) {
        if (cVar.isTest()) {
            return Arrays.asList(new i[]{asTest(cVar)});
        }
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = cVar.getChildren().iterator();
        while (it.hasNext()) {
            arrayList.add(asTest(it.next()));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final i createTest(c cVar) {
        if (cVar.isTest()) {
            return new g(cVar);
        }
        n nVar = new n(cVar.getDisplayName());
        Iterator<c> it = cVar.getChildren().iterator();
        while (it.hasNext()) {
            nVar.a(asTest(it.next()));
        }
        return nVar;
    }

    public final org.junit.runner.b.c getNotifier(final m mVar, e eVar) {
        org.junit.runner.b.c cVar = new org.junit.runner.b.c();
        cVar.a((b) new b() {
            public final void a(a aVar) throws Exception {
                mVar.a(f.this.asTest(aVar.getDescription()), aVar.getException());
            }

            public final void a(c cVar) throws Exception {
                mVar.a(f.this.asTest(cVar));
            }

            public final void b(c cVar) throws Exception {
                mVar.b(f.this.asTest(cVar));
            }
        });
        return cVar;
    }
}
