package org.junit.e.a;

import java.util.Arrays;
import java.util.List;

public final class e extends Exception {
    private static final long serialVersionUID = 1;
    private final List<Throwable> fErrors;

    public e(String str) {
        this((Throwable) new Exception(str));
    }

    public e(Throwable th) {
        this((List<Throwable>) Arrays.asList(new Throwable[]{th}));
    }

    public e(List<Throwable> list) {
        this.fErrors = list;
    }

    public final List<Throwable> getCauses() {
        return this.fErrors;
    }
}
