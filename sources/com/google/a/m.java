package com.google.a;

public final class m extends q {
    private static final m INSTANCE;

    static {
        m mVar = new m();
        INSTANCE = mVar;
        mVar.setStackTrace(NO_TRACE);
    }

    private m() {
    }

    public static m getNotFoundInstance() {
        return INSTANCE;
    }
}
