package org.junit.b;

import java.io.PrintStream;

public final class i implements g {
    public final PrintStream a() {
        return System.out;
    }

    @Deprecated
    public final void a(int i) {
        System.exit(i);
    }
}
