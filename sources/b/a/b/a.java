package b.a.b;

import android.support.v4.media.session.PlaybackStateCompat;
import c.c;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f42a = 8192;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f43b = new byte[8192];

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f44c = ByteBuffer.wrap(this.f43b);
    private final FileChannel d;

    a(FileChannel fileChannel) {
        this.d = fileChannel;
    }

    /* JADX INFO: finally extract failed */
    public final void a(long j, c cVar, long j2) throws IOException {
        long write;
        if (j2 < 0 || j2 > cVar.f387c) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            try {
                int min = (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2);
                cVar.a(this.f43b, 0, min);
                this.f44c.limit(min);
                while (true) {
                    write = j + ((long) this.d.write(this.f44c, j));
                    if (!this.f44c.hasRemaining()) {
                        break;
                    }
                    j = write;
                }
                this.f44c.clear();
                j2 -= (long) min;
                j = write;
            } catch (Throwable th) {
                this.f44c.clear();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void b(long j, c cVar, long j2) throws IOException {
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            try {
                this.f44c.limit((int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_URI, j2));
                if (this.d.read(this.f44c, j) == -1) {
                    throw new EOFException();
                }
                int position = this.f44c.position();
                cVar.c(this.f43b, 0, position);
                long j3 = (long) position;
                long j4 = j + j3;
                this.f44c.clear();
                j2 -= j3;
                j = j4;
            } catch (Throwable th) {
                this.f44c.clear();
                throw th;
            }
        }
    }
}
