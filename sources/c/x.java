package c;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface x extends Closeable, Flushable {
    void a(c cVar, long j) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    z timeout();
}
