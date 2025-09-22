package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;

public class Tailer implements Runnable {
    private static final int DEFAULT_BUFSIZE = 4096;
    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();
    private static final int DEFAULT_DELAY_MILLIS = 1000;
    private static final String RAF_MODE = "r";
    private final Charset cset;
    private final long delayMillis;
    private final boolean end;
    private final File file;
    private final byte[] inbuf;
    private final TailerListener listener;
    private final boolean reOpen;
    private volatile boolean run;

    public Tailer(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this.run = true;
        this.file = file2;
        this.delayMillis = j;
        this.end = z;
        this.inbuf = new byte[i];
        this.listener = tailerListener;
        tailerListener.init(this);
        this.reOpen = z2;
        this.cset = charset;
    }

    public Tailer(File file2, TailerListener tailerListener) {
        this(file2, tailerListener, 1000);
    }

    public Tailer(File file2, TailerListener tailerListener, long j) {
        this(file2, tailerListener, j, false);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z) {
        this(file2, tailerListener, j, z, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        this(file2, tailerListener, j, z, false, i);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        this(file2, tailerListener, j, z, z2, 4096);
    }

    public Tailer(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        this(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    public static Tailer create(File file2, Charset charset, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        Tailer tailer = new Tailer(file2, charset, tailerListener, j, z, z2, i);
        Thread thread = new Thread(tailer);
        thread.setDaemon(true);
        thread.start();
        return tailer;
    }

    public static Tailer create(File file2, TailerListener tailerListener) {
        return create(file2, tailerListener, 1000, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j) {
        return create(file2, tailerListener, j, false);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z) {
        return create(file2, tailerListener, j, z, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, int i) {
        return create(file2, tailerListener, j, z, false, i);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2) {
        return create(file2, tailerListener, j, z, z2, 4096);
    }

    public static Tailer create(File file2, TailerListener tailerListener, long j, boolean z, boolean z2, int i) {
        return create(file2, DEFAULT_CHARSET, tailerListener, j, z, z2, i);
    }

    private long readLines(RandomAccessFile randomAccessFile) throws IOException {
        int read;
        RandomAccessFile randomAccessFile2 = randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        long filePointer = randomAccessFile.getFilePointer();
        long j = filePointer;
        boolean z = false;
        while (getRun() && (read = randomAccessFile2.read(this.inbuf)) != -1) {
            long j2 = filePointer;
            for (int i = 0; i < read; i++) {
                byte b2 = this.inbuf[i];
                if (b2 == 10) {
                    this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                    byteArrayOutputStream.reset();
                    j2 = j + ((long) i) + 1;
                    z = false;
                } else if (b2 != 13) {
                    if (z) {
                        this.listener.handle(new String(byteArrayOutputStream.toByteArray(), this.cset));
                        byteArrayOutputStream.reset();
                        j2 = j + ((long) i) + 1;
                        z = false;
                    }
                    byteArrayOutputStream.write(b2);
                } else {
                    if (z) {
                        byteArrayOutputStream.write(13);
                    }
                    z = true;
                }
            }
            j = randomAccessFile.getFilePointer();
            filePointer = j2;
        }
        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
        randomAccessFile2.seek(filePointer);
        if (this.listener instanceof TailerListenerAdapter) {
            ((TailerListenerAdapter) this.listener).endOfFileReached();
        }
        return filePointer;
    }

    private void stop(Exception exc) {
        this.listener.handle(exc);
        stop();
    }

    public long getDelay() {
        return this.delayMillis;
    }

    public File getFile() {
        return this.file;
    }

    /* access modifiers changed from: protected */
    public boolean getRun() {
        return this.run;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r13.listener.fileNotFound();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0018 */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a6 A[Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x00d4=Splitter:B:70:0x00d4, B:65:0x00cc=Splitter:B:65:0x00cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r13 = this;
            r0 = 0
            r2 = 0
            r3 = r0
            r5 = r3
        L_0x0005:
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r7 == 0) goto L_0x003c
            if (r2 != 0) goto L_0x003c
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0018 }
            java.io.File r8 = r13.file     // Catch:{ FileNotFoundException -> 0x0018 }
            java.lang.String r9 = "r"
            r7.<init>(r8, r9)     // Catch:{ FileNotFoundException -> 0x0018 }
            r2 = r7
            goto L_0x001d
        L_0x0018:
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r7.fileNotFound()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
        L_0x001d:
            if (r2 != 0) goto L_0x0025
            long r7 = r13.delayMillis     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            goto L_0x0005
        L_0x0025:
            boolean r3 = r13.end     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r3 == 0) goto L_0x0031
            java.io.File r3 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            long r3 = r3.length()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r5 = r3
            goto L_0x0032
        L_0x0031:
            r5 = r0
        L_0x0032:
            java.io.File r3 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            long r3 = r3.lastModified()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r2.seek(r5)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            goto L_0x0005
        L_0x003c:
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r7 == 0) goto L_0x00c5
            java.io.File r7 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            boolean r7 = org.apache.commons.io.FileUtils.isFileNewer((java.io.File) r7, (long) r3)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.io.File r8 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            long r8 = r8.length()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x0084
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r7.fileRotated()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x007e }
            java.io.File r8 = r13.file     // Catch:{ FileNotFoundException -> 0x007e }
            java.lang.String r9 = "r"
            r7.<init>(r8, r9)     // Catch:{ FileNotFoundException -> 0x007e }
            r13.readLines(r2)     // Catch:{ IOException -> 0x0070 }
            goto L_0x0076
        L_0x0064:
            r0 = move-exception
            r2 = r7
            goto L_0x00e2
        L_0x0068:
            r0 = move-exception
            r2 = r7
            goto L_0x00cc
        L_0x006c:
            r0 = move-exception
            r2 = r7
            goto L_0x00d4
        L_0x0070:
            r8 = move-exception
            org.apache.commons.io.input.TailerListener r9 = r13.listener     // Catch:{ FileNotFoundException -> 0x007d }
            r9.handle((java.lang.Exception) r8)     // Catch:{ FileNotFoundException -> 0x007d }
        L_0x0076:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ FileNotFoundException -> 0x007c }
            r5 = r0
        L_0x007a:
            r2 = r7
            goto L_0x003c
        L_0x007c:
            r5 = r0
        L_0x007d:
            r2 = r7
        L_0x007e:
            org.apache.commons.io.input.TailerListener r7 = r13.listener     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r7.fileNotFound()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            goto L_0x003c
        L_0x0084:
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x0096
            long r3 = r13.readLines(r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.io.File r5 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
        L_0x008e:
            long r5 = r5.lastModified()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r11 = r3
            r3 = r5
            r5 = r11
            goto L_0x00a2
        L_0x0096:
            if (r7 == 0) goto L_0x00a2
            r2.seek(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            long r3 = r13.readLines(r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.io.File r5 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            goto L_0x008e
        L_0x00a2:
            boolean r7 = r13.reOpen     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r7 == 0) goto L_0x00a9
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
        L_0x00a9:
            long r7 = r13.delayMillis     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            boolean r7 = r13.getRun()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r7 == 0) goto L_0x003c
            boolean r7 = r13.reOpen     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            if (r7 == 0) goto L_0x003c
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.io.File r8 = r13.file     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            java.lang.String r9 = "r"
            r7.<init>(r8, r9)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00cb }
            r7.seek(r5)     // Catch:{ InterruptedException -> 0x006c, Exception -> 0x0068, all -> 0x0064 }
            goto L_0x007a
        L_0x00c5:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)
            return
        L_0x00c9:
            r0 = move-exception
            goto L_0x00e2
        L_0x00cb:
            r0 = move-exception
        L_0x00cc:
            r13.stop(r0)     // Catch:{ all -> 0x00c9 }
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)
            return
        L_0x00d3:
            r0 = move-exception
        L_0x00d4:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00c9 }
            r1.interrupt()     // Catch:{ all -> 0x00c9 }
            r13.stop(r0)     // Catch:{ all -> 0x00c9 }
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)
            return
        L_0x00e2:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Closeable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.Tailer.run():void");
    }

    public void stop() {
        this.run = false;
    }
}
