package b;

import b.a.c;
import c.d;
import c.f;
import c.p;
import c.y;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class ad {
    public static ad create(@Nullable final x xVar, final f fVar) {
        return new ad() {
            public final long contentLength() throws IOException {
                return (long) fVar.size();
            }

            @Nullable
            public final x contentType() {
                return x.this;
            }

            public final void writeTo(d dVar) throws IOException {
                dVar.e(fVar);
            }
        };
    }

    public static ad create(@Nullable final x xVar, final File file) {
        if (file != null) {
            return new ad() {
                public final long contentLength() {
                    return file.length();
                }

                @Nullable
                public final x contentType() {
                    return x.this;
                }

                public final void writeTo(d dVar) throws IOException {
                    y yVar = null;
                    try {
                        y a2 = p.a(file);
                        try {
                            dVar.a(a2);
                            c.a((Closeable) a2);
                        } catch (Throwable th) {
                            th = th;
                            yVar = a2;
                            c.a((Closeable) yVar);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c.a((Closeable) yVar);
                        throw th;
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static ad create(@Nullable x xVar, String str) {
        Charset charset = c.e;
        if (xVar != null && (charset = xVar.a((Charset) null)) == null) {
            charset = c.e;
            xVar = x.a(xVar + "; charset=utf-8");
        }
        return create(xVar, str.getBytes(charset));
    }

    public static ad create(@Nullable x xVar, byte[] bArr) {
        return create(xVar, bArr, 0, bArr.length);
    }

    public static ad create(@Nullable final x xVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        c.a((long) bArr.length, (long) i, (long) i2);
        return new ad() {
            public final long contentLength() {
                return (long) i2;
            }

            @Nullable
            public final x contentType() {
                return x.this;
            }

            public final void writeTo(d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }
        };
    }

    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract x contentType();

    public abstract void writeTo(d dVar) throws IOException;
}
