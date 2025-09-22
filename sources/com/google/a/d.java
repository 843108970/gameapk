package com.google.a;

public final class d extends q {
    private static final d INSTANCE;

    static {
        d dVar = new d();
        INSTANCE = dVar;
        dVar.setStackTrace(NO_TRACE);
    }

    private d() {
    }

    private d(Throwable th) {
        super(th);
    }

    public static d getChecksumInstance() {
        return isStackTrace ? new d() : INSTANCE;
    }

    public static d getChecksumInstance(Throwable th) {
        return isStackTrace ? new d(th) : INSTANCE;
    }
}
