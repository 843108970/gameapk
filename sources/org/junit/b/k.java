package org.junit.b;

public final class k {
    private k() {
    }

    private static Exception a(Throwable th) throws Exception {
        throw th;
    }

    private static <T extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }
}
