package org.litepal.c;

public class a extends RuntimeException {
    private static final long serialVersionUID = 1;

    public a(String str) {
        super(str);
    }

    public a(String str, Throwable th) {
        super(str, th);
    }
}
