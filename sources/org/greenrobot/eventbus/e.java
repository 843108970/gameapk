package org.greenrobot.eventbus;

public final class e extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public e(String str) {
        super(str);
    }

    public e(String str, Throwable th) {
        super(str, th);
    }

    public e(Throwable th) {
        super(th);
    }
}
