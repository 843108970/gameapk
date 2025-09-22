package net.grandcentrix.tray.core;

public class TrayRuntimeException extends RuntimeException {
    public TrayRuntimeException() {
    }

    public TrayRuntimeException(String str) {
        super(str);
    }

    public TrayRuntimeException(String str, Throwable th) {
        super(str, th);
    }

    public TrayRuntimeException(String str, Object... objArr) {
        super(String.format(str, objArr));
    }

    public TrayRuntimeException(Throwable th) {
        super(th);
    }
}
