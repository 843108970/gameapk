package b;

import b.a.c;
import c.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class af implements Closeable {
    private Reader reader;

    static final class a extends Reader {

        /* renamed from: a  reason: collision with root package name */
        private final e f269a;

        /* renamed from: b  reason: collision with root package name */
        private final Charset f270b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f271c;
        private Reader d;

        a(e eVar, Charset charset) {
            this.f269a = eVar;
            this.f270b = charset;
        }

        public final void close() throws IOException {
            this.f271c = true;
            if (this.d != null) {
                this.d.close();
            } else {
                this.f269a.close();
            }
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            if (this.f271c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f269a.e(), c.a(this.f269a, this.f270b));
                this.d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }
    }

    private Charset charset() {
        x contentType = contentType();
        return contentType != null ? contentType.a(c.e) : c.e;
    }

    public static af create(@Nullable final x xVar, final long j, final e eVar) {
        if (eVar != null) {
            return new af() {
                public final long contentLength() {
                    return j;
                }

                @Nullable
                public final x contentType() {
                    return x.this;
                }

                public final e source() {
                    return eVar;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    public static af create(@Nullable x xVar, String str) {
        Charset charset = c.e;
        if (xVar != null && (charset = xVar.a((Charset) null)) == null) {
            charset = c.e;
            xVar = x.a(xVar + "; charset=utf-8");
        }
        c.c a2 = new c.c().b(str, charset);
        return create(xVar, a2.f387c, a2);
    }

    public static af create(@Nullable x xVar, byte[] bArr) {
        return create(xVar, (long) bArr.length, new c.c().d(bArr));
    }

    public final InputStream byteStream() {
        return source().e();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        e source = source();
        try {
            byte[] v = source.v();
            c.a((Closeable) source);
            if (contentLength == -1 || contentLength == ((long) v.length)) {
                return v;
            }
            throw new IOException("Content-Length (" + contentLength + ") and stream length (" + v.length + ") disagree");
        } catch (Throwable th) {
            c.a((Closeable) source);
            throw th;
        }
    }

    public final Reader charStream() {
        Reader reader2 = this.reader;
        if (reader2 != null) {
            return reader2;
        }
        a aVar = new a(source(), charset());
        this.reader = aVar;
        return aVar;
    }

    public void close() {
        c.a((Closeable) source());
    }

    public abstract long contentLength();

    @Nullable
    public abstract x contentType();

    public abstract e source();

    public final String string() throws IOException {
        e source = source();
        try {
            return source.a(c.a(source, charset()));
        } finally {
            c.a((Closeable) source);
        }
    }
}
