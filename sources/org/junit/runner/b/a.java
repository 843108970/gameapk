package org.junit.runner.b;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.junit.runner.c;

public final class a implements Serializable {
    private static final long serialVersionUID = 1;
    private final c fDescription;
    private final Throwable fThrownException;

    public a(c cVar, Throwable th) {
        this.fThrownException = th;
        this.fDescription = cVar;
    }

    public final c getDescription() {
        return this.fDescription;
    }

    public final Throwable getException() {
        return this.fThrownException;
    }

    public final String getMessage() {
        return getException().getMessage();
    }

    public final String getTestHeader() {
        return this.fDescription.getDisplayName();
    }

    public final String getTrace() {
        StringWriter stringWriter = new StringWriter();
        getException().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final String toString() {
        return getTestHeader() + ": " + this.fThrownException.getMessage();
    }
}
