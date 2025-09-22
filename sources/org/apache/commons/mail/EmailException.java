package org.apache.commons.mail;

import java.io.PrintStream;
import java.io.PrintWriter;

public class EmailException extends Exception {
    private static final long serialVersionUID = 5550674499282474616L;

    public EmailException() {
    }

    public EmailException(String str) {
        super(str);
    }

    public EmailException(String str, Throwable th) {
        super(str, th);
    }

    public EmailException(Throwable th) {
        super(th);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter(printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        synchronized (printWriter) {
            super.printStackTrace(printWriter);
        }
    }
}
