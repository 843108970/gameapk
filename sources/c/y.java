package c;

import java.io.Closeable;
import java.io.IOException;

public interface y extends Closeable {
    void close() throws IOException;

    long read(c cVar, long j) throws IOException;

    z timeout();
}
