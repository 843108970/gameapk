package javax.mail.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import javax.mail.internet.SharedInputStream;

public class SharedFileInputStream extends BufferedInputStream implements SharedInputStream {
    private static int defaultBufferSize = 2048;
    protected long bufpos;
    protected int bufsize;
    protected long datalen;
    protected RandomAccessFile in;
    private boolean master;
    private SharedFile sf;
    protected long start;

    static class SharedFile {
        private int cnt;
        private RandomAccessFile in;

        SharedFile(File file) throws IOException {
            this.in = new RandomAccessFile(file, "r");
        }

        SharedFile(String str) throws IOException {
            this.in = new RandomAccessFile(str, "r");
        }

        public synchronized void close() throws IOException {
            if (this.cnt > 0) {
                int i = this.cnt - 1;
                this.cnt = i;
                if (i <= 0) {
                    this.in.close();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            super.finalize();
            this.in.close();
        }

        public synchronized void forceClose() throws IOException {
            if (this.cnt > 0) {
                this.cnt = 0;
                this.in.close();
                return;
            }
            try {
                this.in.close();
            } catch (IOException unused) {
            }
        }

        public RandomAccessFile open() {
            this.cnt++;
            return this.in;
        }
    }

    public SharedFileInputStream(File file) throws IOException {
        this(file, defaultBufferSize);
    }

    public SharedFileInputStream(File file, int i) throws IOException {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        init(new SharedFile(file), i);
    }

    public SharedFileInputStream(String str) throws IOException {
        this(str, defaultBufferSize);
    }

    public SharedFileInputStream(String str, int i) throws IOException {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        init(new SharedFile(str), i);
    }

    private SharedFileInputStream(SharedFile sharedFile, long j, long j2, int i) {
        super((InputStream) null);
        this.start = 0;
        this.master = true;
        this.master = false;
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = j;
        this.bufpos = j;
        this.datalen = j2;
        this.bufsize = i;
        this.buf = new byte[i];
    }

    private void ensureOpen() throws IOException {
        if (this.in == null) {
            throw new IOException("Stream closed");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fill() throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.markpos
            r1 = 0
            if (r0 >= 0) goto L_0x0011
        L_0x0005:
            r8.pos = r1
            long r0 = r8.bufpos
            int r2 = r8.count
            long r2 = (long) r2
            long r4 = r0 + r2
            r8.bufpos = r4
            goto L_0x0058
        L_0x0011:
            int r0 = r8.pos
            byte[] r2 = r8.buf
            int r2 = r2.length
            if (r0 < r2) goto L_0x0058
            int r0 = r8.markpos
            if (r0 <= 0) goto L_0x0038
            int r0 = r8.pos
            int r2 = r8.markpos
            int r0 = r0 - r2
            byte[] r2 = r8.buf
            int r3 = r8.markpos
            byte[] r4 = r8.buf
            java.lang.System.arraycopy(r2, r3, r4, r1, r0)
            r8.pos = r0
            long r2 = r8.bufpos
            int r0 = r8.markpos
            long r4 = (long) r0
            long r6 = r2 + r4
            r8.bufpos = r6
            r8.markpos = r1
            goto L_0x0058
        L_0x0038:
            byte[] r0 = r8.buf
            int r0 = r0.length
            int r2 = r8.marklimit
            if (r0 < r2) goto L_0x0043
            r0 = -1
            r8.markpos = r0
            goto L_0x0005
        L_0x0043:
            int r0 = r8.pos
            int r0 = r0 * 2
            int r2 = r8.marklimit
            if (r0 <= r2) goto L_0x004d
            int r0 = r8.marklimit
        L_0x004d:
            byte[] r0 = new byte[r0]
            byte[] r2 = r8.buf
            int r3 = r8.pos
            java.lang.System.arraycopy(r2, r1, r0, r1, r3)
            r8.buf = r0
        L_0x0058:
            int r0 = r8.pos
            r8.count = r0
            java.io.RandomAccessFile r0 = r8.in
            long r1 = r8.bufpos
            int r3 = r8.pos
            long r3 = (long) r3
            long r5 = r1 + r3
            r0.seek(r5)
            byte[] r0 = r8.buf
            int r0 = r0.length
            int r1 = r8.pos
            int r0 = r0 - r1
            long r1 = r8.bufpos
            long r3 = r8.start
            long r5 = r1 - r3
            int r1 = r8.pos
            long r1 = (long) r1
            long r3 = r5 + r1
            long r1 = (long) r0
            long r5 = r3 + r1
            long r1 = r8.datalen
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0092
            long r0 = r8.datalen
            long r2 = r8.bufpos
            long r4 = r8.start
            long r6 = r2 - r4
            int r2 = r8.pos
            long r2 = (long) r2
            long r4 = r6 + r2
            long r2 = r0 - r4
            int r0 = (int) r2
        L_0x0092:
            java.io.RandomAccessFile r1 = r8.in
            byte[] r2 = r8.buf
            int r3 = r8.pos
            int r0 = r1.read(r2, r3, r0)
            if (r0 <= 0) goto L_0x00a3
            int r1 = r8.pos
            int r0 = r0 + r1
            r8.count = r0
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.util.SharedFileInputStream.fill():void");
    }

    private int in_available() throws IOException {
        return (int) ((this.start + this.datalen) - (this.bufpos + ((long) this.count)));
    }

    private void init(SharedFile sharedFile, int i) throws IOException {
        this.sf = sharedFile;
        this.in = sharedFile.open();
        this.start = 0;
        this.datalen = this.in.length();
        this.bufsize = i;
        this.buf = new byte[i];
    }

    private int read1(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.count - this.pos;
        if (i3 <= 0) {
            fill();
            i3 = this.count - this.pos;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.buf, this.pos, bArr, i, i2);
        this.pos += i2;
        return i2;
    }

    public synchronized int available() throws IOException {
        ensureOpen();
        return (this.count - this.pos) + in_available();
    }

    public void close() throws IOException {
        if (this.in != null) {
            try {
                if (this.master) {
                    this.sf.forceClose();
                } else {
                    this.sf.close();
                }
            } finally {
                this.sf = null;
                this.in = null;
                this.buf = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public long getPosition() {
        if (this.in != null) {
            return (this.bufpos + ((long) this.pos)) - this.start;
        }
        throw new RuntimeException("Stream closed");
    }

    public synchronized void mark(int i) {
        this.marklimit = i;
        this.markpos = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public InputStream newStream(long j, long j2) {
        if (this.in == null) {
            throw new RuntimeException("Stream closed");
        } else if (j < 0) {
            throw new IllegalArgumentException("start < 0");
        } else {
            if (j2 == -1) {
                j2 = this.datalen;
            }
            return new SharedFileInputStream(this.sf, this.start + ((long) ((int) j)), (long) ((int) (j2 - j)), this.bufsize);
        }
    }

    public synchronized int read() throws IOException {
        byte b2;
        ensureOpen();
        if (this.pos >= this.count) {
            fill();
            if (this.pos >= this.count) {
                b2 = -1;
            }
        }
        byte[] bArr = this.buf;
        int i = this.pos;
        this.pos = i + 1;
        b2 = bArr[i] & 255;
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r4, int r5, int r6) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.ensureOpen()     // Catch:{ all -> 0x0032 }
            r0 = r5 | r6
            int r1 = r5 + r6
            r0 = r0 | r1
            int r2 = r4.length     // Catch:{ all -> 0x0032 }
            int r2 = r2 - r1
            r0 = r0 | r2
            if (r0 >= 0) goto L_0x0014
            java.lang.IndexOutOfBoundsException r4 = new java.lang.IndexOutOfBoundsException     // Catch:{ all -> 0x0032 }
            r4.<init>()     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0014:
            if (r6 != 0) goto L_0x0019
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x0019:
            int r0 = r3.read1(r4, r5, r6)     // Catch:{ all -> 0x0032 }
            if (r0 > 0) goto L_0x0021
            monitor-exit(r3)
            return r0
        L_0x0021:
            if (r0 < r6) goto L_0x0024
            goto L_0x0030
        L_0x0024:
            int r1 = r5 + r0
            int r2 = r6 - r0
            int r1 = r3.read1(r4, r1, r2)     // Catch:{ all -> 0x0032 }
            if (r1 <= 0) goto L_0x0030
            int r0 = r0 + r1
            goto L_0x0021
        L_0x0030:
            monitor-exit(r3)
            return r0
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.util.SharedFileInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        ensureOpen();
        if (this.markpos < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this.pos = this.markpos;
    }

    public synchronized long skip(long j) throws IOException {
        ensureOpen();
        if (j <= 0) {
            return 0;
        }
        long j2 = (long) (this.count - this.pos);
        if (j2 <= 0) {
            fill();
            j2 = (long) (this.count - this.pos);
            if (j2 <= 0) {
                return 0;
            }
        }
        if (j2 < j) {
            j = j2;
        }
        this.pos = (int) (((long) this.pos) + j);
        return j;
    }
}
