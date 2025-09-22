package org.junit.b.d;

import java.util.Arrays;
import java.util.List;

@Deprecated
public final class d extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public d(String str) {
        this(new Exception(str));
    }

    public d(List<Throwable> list) {
        this.fErrors = list;
    }

    public d(Throwable... thArr) {
        this((List<Throwable>) Arrays.asList(thArr));
    }

    public final List<Throwable> getCauses() {
        return this.fErrors;
    }
}
