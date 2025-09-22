package org.junit.e.a;

import java.util.concurrent.TimeUnit;

public final class l extends Exception {
    private static final long serialVersionUID = 31935685163547539L;
    private final TimeUnit timeUnit;
    private final long timeout;

    public l(long j, TimeUnit timeUnit2) {
        super(String.format("test timed out after %d %s", new Object[]{Long.valueOf(j), timeUnit2.name().toLowerCase()}));
        this.timeUnit = timeUnit2;
        this.timeout = j;
    }

    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public final long getTimeout() {
        return this.timeout;
    }
}
