package org.junit.b;

import org.a.g;
import org.a.k;
import org.a.m;
import org.a.n;

public class b extends RuntimeException implements m {
    private static final long serialVersionUID = 2;
    private final String fAssumption;
    private final k<?> fMatcher;
    private final Object fValue;
    private final boolean fValueMatcher;

    @Deprecated
    public b(Object obj, k<?> kVar) {
        this((String) null, true, obj, kVar);
    }

    @Deprecated
    public b(String str) {
        this(str, false, (Object) null, (k<?>) null);
    }

    @Deprecated
    public b(String str, Object obj, k<?> kVar) {
        this(str, true, obj, kVar);
    }

    @Deprecated
    public b(String str, Throwable th) {
        this(str, false, (Object) null, (k<?>) null);
        initCause(th);
    }

    @Deprecated
    public b(String str, boolean z, Object obj, k<?> kVar) {
        this.fAssumption = str;
        this.fValue = obj;
        this.fMatcher = kVar;
        this.fValueMatcher = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    public void describeTo(g gVar) {
        if (this.fAssumption != null) {
            gVar.a(this.fAssumption);
        }
        if (this.fValueMatcher) {
            if (this.fAssumption != null) {
                gVar.a(": ");
            }
            gVar.a("got: ");
            gVar.a(this.fValue);
            if (this.fMatcher != null) {
                gVar.a(", expected: ");
                gVar.a((m) this.fMatcher);
            }
        }
    }

    public String getMessage() {
        return n.c(this);
    }
}
