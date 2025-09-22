package com.google.a;

public final class h extends q {
    private static final h INSTANCE;

    static {
        h hVar = new h();
        INSTANCE = hVar;
        hVar.setStackTrace(NO_TRACE);
    }

    private h() {
    }

    private h(Throwable th) {
        super(th);
    }

    public static h getFormatInstance() {
        return isStackTrace ? new h() : INSTANCE;
    }

    public static h getFormatInstance(Throwable th) {
        return isStackTrace ? new h(th) : INSTANCE;
    }
}
