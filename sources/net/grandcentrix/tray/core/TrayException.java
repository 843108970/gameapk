package net.grandcentrix.tray.core;

public class TrayException extends Exception {
    public TrayException() {
    }

    public TrayException(String str) {
        super(str);
    }

    public TrayException(String str, Throwable th) {
        super(str, th);
    }

    public TrayException(String str, Object... objArr) {
        super(String.format(str, objArr));
    }

    public TrayException(Throwable th) {
        super(th);
    }
}
