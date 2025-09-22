package com.b.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f867a = Logger.getLogger(n.class.getName());

    private n() {
    }

    public static g a(w wVar) {
        return new r(wVar);
    }

    public static h a(x xVar) {
        return new s(xVar);
    }

    public static w a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a c2 = c(socket);
        OutputStream outputStream = socket.getOutputStream();
        if (outputStream != null) {
            return new b(c2, new o(c2, outputStream));
        }
        throw new IllegalArgumentException("out == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static x b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        a c2 = c(socket);
        InputStream inputStream = socket.getInputStream();
        if (inputStream != null) {
            return new c(c2, new p(c2, inputStream));
        }
        throw new IllegalArgumentException("in == null");
    }

    private static a c(Socket socket) {
        return new q(socket);
    }
}
