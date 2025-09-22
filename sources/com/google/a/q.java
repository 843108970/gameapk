package com.google.a;

public abstract class q extends Exception {
    protected static final StackTraceElement[] NO_TRACE = new StackTraceElement[0];
    protected static final boolean isStackTrace = (System.getProperty("surefire.test.class.path") != null);

    q() {
    }

    q(Throwable th) {
        super(th);
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
