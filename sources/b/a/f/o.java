package b.a.f;

import java.io.IOException;

public final class o extends IOException {
    public final b errorCode;

    public o(b bVar) {
        super("stream was reset: " + bVar);
        this.errorCode = bVar;
    }
}
