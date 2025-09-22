package com.lidroid.xutils.cache;

import com.cyjh.common.util.s;
import com.lidroid.xutils.util.IOUtils;
import com.lidroid.xutils.util.LogUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class LruDiskCache implements Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final char CLEAN = 'C';
    private static final char DELETE = 'D';
    private static final char EXPIRY_PREFIX = 't';
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final String MAGIC = "libcore.io.DiskLruCache";
    /* access modifiers changed from: private */
    public static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };
    private static final char READ = 'R';
    private static final char UPDATE = 'U';
    static final String VERSION = "1";
    private final int appVersion;
    private final Callable<Void> cleanupCallable = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.lidroid.xutils.cache.LruDiskCache r0 = com.lidroid.xutils.cache.LruDiskCache.this
                monitor-enter(r0)
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.journalWriter     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0028 }
                r1.trimToSize()     // Catch:{ all -> 0x0028 }
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0028 }
                r1.rebuildJournal()     // Catch:{ all -> 0x0028 }
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                r1.redundantOpCount = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.AnonymousClass1.call():java.lang.Void");
        }
    };
    /* access modifiers changed from: private */
    public final File directory;
    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private FileNameGenerator fileNameGenerator = new MD5FileNameGenerator();
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    /* access modifiers changed from: private */
    public Writer journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    private long nextSequenceNumber = 0;
    /* access modifiers changed from: private */
    public int redundantOpCount;
    private long size = 0;
    /* access modifiers changed from: private */
    public final int valueCount;

    public final class Editor {
        private boolean committed;
        /* access modifiers changed from: private */
        public final Entry entry;
        /* access modifiers changed from: private */
        public boolean hasErrors;
        /* access modifiers changed from: private */
        public final boolean[] written;

        private class FaultHidingOutputStream extends FilterOutputStream {
            private FaultHidingOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            /* synthetic */ FaultHidingOutputStream(Editor editor, OutputStream outputStream, FaultHidingOutputStream faultHidingOutputStream) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (Throwable unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (Throwable unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (Throwable unused) {
                    Editor.this.hasErrors = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                    this.out.flush();
                } catch (Throwable unused) {
                    Editor.this.hasErrors = true;
                }
            }
        }

        private Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[LruDiskCache.this.valueCount];
        }

        /* synthetic */ Editor(LruDiskCache lruDiskCache, Entry entry2, Editor editor) {
            this(entry2);
        }

        public final void abort() throws IOException {
            LruDiskCache.this.completeEdit(this, false);
        }

        public final void abortUnlessCommitted() {
            if (!this.committed) {
                try {
                    abort();
                } catch (Throwable unused) {
                }
            }
        }

        public final void commit() throws IOException {
            if (this.hasErrors) {
                LruDiskCache.this.completeEdit(this, false);
                boolean unused = LruDiskCache.this.removeByDiskKey(this.entry.diskKey);
            } else {
                LruDiskCache.this.completeEdit(this, true);
            }
            this.committed = true;
        }

        public final String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return LruDiskCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public final InputStream newInputStream(int i) throws IOException {
            synchronized (LruDiskCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new IllegalStateException();
                } else if (!this.entry.readable) {
                    return null;
                } else {
                    try {
                        FileInputStream fileInputStream = new FileInputStream(this.entry.getCleanFile(i));
                        return fileInputStream;
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.OutputStream newOutputStream(int r4) throws java.io.IOException {
            /*
                r3 = this;
                com.lidroid.xutils.cache.LruDiskCache r0 = com.lidroid.xutils.cache.LruDiskCache.this
                monitor-enter(r0)
                com.lidroid.xutils.cache.LruDiskCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
                com.lidroid.xutils.cache.LruDiskCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0046 }
                if (r1 == r3) goto L_0x0011
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0046 }
                r4.<init>()     // Catch:{ all -> 0x0046 }
                throw r4     // Catch:{ all -> 0x0046 }
            L_0x0011:
                com.lidroid.xutils.cache.LruDiskCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.readable     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x001e
                boolean[] r1 = r3.written     // Catch:{ all -> 0x0046 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0046 }
            L_0x001e:
                com.lidroid.xutils.cache.LruDiskCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0046 }
                java.io.File r4 = r1.getDirtyFile(r4)     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002a }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002a }
                goto L_0x0038
            L_0x002a:
                com.lidroid.xutils.cache.LruDiskCache r1 = com.lidroid.xutils.cache.LruDiskCache.this     // Catch:{ all -> 0x0046 }
                java.io.File r1 = r1.directory     // Catch:{ all -> 0x0046 }
                r1.mkdirs()     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0040 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0040 }
            L_0x0038:
                com.lidroid.xutils.cache.LruDiskCache$Editor$FaultHidingOutputStream r4 = new com.lidroid.xutils.cache.LruDiskCache$Editor$FaultHidingOutputStream     // Catch:{ all -> 0x0046 }
                r2 = 0
                r4.<init>(r3, r1, r2)     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x0040:
                java.io.OutputStream r4 = com.lidroid.xutils.cache.LruDiskCache.NULL_OUTPUT_STREAM     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x0046:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.Editor.newOutputStream(int):java.io.OutputStream");
        }

        public final void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i), "UTF-8");
                try {
                    outputStreamWriter2.write(str);
                    IOUtils.closeQuietly((Closeable) outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    IOUtils.closeQuietly((Closeable) outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Closeable) outputStreamWriter);
                throw th;
            }
        }

        public final void setEntryExpiryTimestamp(long j) {
            this.entry.expiryTimestamp = j;
        }
    }

    private final class Entry {
        /* access modifiers changed from: private */
        public Editor currentEditor;
        /* access modifiers changed from: private */
        public final String diskKey;
        /* access modifiers changed from: private */
        public long expiryTimestamp;
        /* access modifiers changed from: private */
        public final long[] lengths;
        /* access modifiers changed from: private */
        public boolean readable;
        /* access modifiers changed from: private */
        public long sequenceNumber;

        private Entry(String str) {
            this.expiryTimestamp = Long.MAX_VALUE;
            this.diskKey = str;
            this.lengths = new long[LruDiskCache.this.valueCount];
        }

        /* synthetic */ Entry(LruDiskCache lruDiskCache, String str, Entry entry) {
            this(str);
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: private */
        public void setLengths(String[] strArr, int i) throws IOException {
            if (strArr.length - i != LruDiskCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            int i2 = 0;
            while (i2 < LruDiskCache.this.valueCount) {
                try {
                    this.lengths[i2] = Long.parseLong(strArr[i2 + i]);
                    i2++;
                } catch (NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        public final File getCleanFile(int i) {
            File access$8 = LruDiskCache.this.directory;
            return new File(access$8, String.valueOf(this.diskKey) + "." + i);
        }

        public final File getDirtyFile(int i) {
            File access$8 = LruDiskCache.this.directory;
            return new File(access$8, String.valueOf(this.diskKey) + "." + i + ".tmp");
        }

        public final String getLengths() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.lengths) {
                sb.append(s.a.f1696a);
                sb.append(append);
            }
            return sb.toString();
        }
    }

    public final class Snapshot implements Closeable {
        private final String diskKey;
        private final FileInputStream[] ins;
        private final long[] lengths;
        private final long sequenceNumber;

        private Snapshot(String str, long j, FileInputStream[] fileInputStreamArr, long[] jArr) {
            this.diskKey = str;
            this.sequenceNumber = j;
            this.ins = fileInputStreamArr;
            this.lengths = jArr;
        }

        /* synthetic */ Snapshot(LruDiskCache lruDiskCache, String str, long j, FileInputStream[] fileInputStreamArr, long[] jArr, Snapshot snapshot) {
            this(str, j, fileInputStreamArr, jArr);
        }

        public final void close() {
            for (FileInputStream closeQuietly : this.ins) {
                IOUtils.closeQuietly((Closeable) closeQuietly);
            }
        }

        public final Editor edit() throws IOException {
            return LruDiskCache.this.editByDiskKey(this.diskKey, this.sequenceNumber);
        }

        public final FileInputStream getInputStream(int i) {
            return this.ins[i];
        }

        public final long getLength(int i) {
            return this.lengths[i];
        }

        public final String getString(int i) throws IOException {
            return LruDiskCache.inputStreamToString(getInputStream(i));
        }
    }

    private class StrictLineReader implements Closeable {
        private static final byte CR = 13;
        private static final byte LF = 10;
        private byte[] buf;
        /* access modifiers changed from: private */
        public final Charset charset;
        private int end;
        private final InputStream in;
        private int pos;

        public StrictLineReader(LruDiskCache lruDiskCache, InputStream inputStream) {
            this(inputStream, 8192);
        }

        public StrictLineReader(InputStream inputStream, int i) {
            this.charset = Charset.forName("US-ASCII");
            if (inputStream == null) {
                throw new NullPointerException();
            } else if (i < 0) {
                throw new IllegalArgumentException("capacity <= 0");
            } else {
                this.in = inputStream;
                this.buf = new byte[i];
            }
        }

        private void fillBuf() throws IOException {
            int read = this.in.read(this.buf, 0, this.buf.length);
            if (read == -1) {
                throw new EOFException();
            }
            this.pos = 0;
            this.end = read;
        }

        public void close() throws IOException {
            synchronized (this.in) {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            }
        }

        public String readLine() throws IOException {
            int i;
            int i2;
            synchronized (this.in) {
                if (this.buf == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i3 = this.pos; i3 != this.end; i3++) {
                    if (this.buf[i3] == 10) {
                        if (i3 != this.pos) {
                            i2 = i3 - 1;
                            if (this.buf[i2] == 13) {
                                String str = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                                this.pos = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.buf, this.pos, i2 - this.pos, this.charset.name());
                        this.pos = i3 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r1 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.buf, this.pos, this.end - this.pos);
                    this.end = -1;
                    fillBuf();
                    i = this.pos;
                    while (i != this.end) {
                        if (this.buf[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.pos) {
                    r1.write(this.buf, this.pos, i - this.pos);
                }
                r1.flush();
                this.pos = i + 1;
                String byteArrayOutputStream = r1.toString();
                return byteArrayOutputStream;
            }
        }
    }

    private LruDiskCache(File file, int i, int i2, long j) {
        File file2 = file;
        this.directory = file2;
        this.appVersion = i;
        this.journalFile = new File(file2, JOURNAL_FILE);
        this.journalFileTmp = new File(file2, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file2, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(com.lidroid.xutils.cache.LruDiskCache.Editor r12, boolean r13) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            com.lidroid.xutils.cache.LruDiskCache$Entry r0 = r12.entry     // Catch:{ all -> 0x0119 }
            com.lidroid.xutils.cache.LruDiskCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x0119 }
            if (r1 == r12) goto L_0x0011
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0119 }
            r12.<init>()     // Catch:{ all -> 0x0119 }
            throw r12     // Catch:{ all -> 0x0119 }
        L_0x0011:
            r1 = 0
            if (r13 == 0) goto L_0x0051
            boolean r2 = r0.readable     // Catch:{ all -> 0x0119 }
            if (r2 != 0) goto L_0x0051
            r2 = 0
        L_0x001b:
            int r3 = r11.valueCount     // Catch:{ all -> 0x0119 }
            if (r2 < r3) goto L_0x0020
            goto L_0x0051
        L_0x0020:
            boolean[] r3 = r12.written     // Catch:{ all -> 0x0119 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0119 }
            if (r3 != 0) goto L_0x003f
            r12.abort()     // Catch:{ all -> 0x0119 }
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r13.<init>(r0)     // Catch:{ all -> 0x0119 }
            r13.append(r2)     // Catch:{ all -> 0x0119 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0119 }
            r12.<init>(r13)     // Catch:{ all -> 0x0119 }
            throw r12     // Catch:{ all -> 0x0119 }
        L_0x003f:
            java.io.File r3 = r0.getDirtyFile(r2)     // Catch:{ all -> 0x0119 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0119 }
            if (r3 != 0) goto L_0x004e
            r12.abort()     // Catch:{ all -> 0x0119 }
            monitor-exit(r11)
            return
        L_0x004e:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0051:
            int r12 = r11.valueCount     // Catch:{ all -> 0x0119 }
            if (r1 < r12) goto L_0x00e5
            int r12 = r11.redundantOpCount     // Catch:{ all -> 0x0119 }
            r1 = 1
            int r12 = r12 + r1
            r11.redundantOpCount = r12     // Catch:{ all -> 0x0119 }
            r12 = 0
            r0.currentEditor = r12     // Catch:{ all -> 0x0119 }
            boolean r12 = r0.readable     // Catch:{ all -> 0x0119 }
            r12 = r12 | r13
            r2 = 10
            if (r12 == 0) goto L_0x00a6
            r0.readable = r1     // Catch:{ all -> 0x0119 }
            java.io.Writer r12 = r11.journalWriter     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "C "
            r1.<init>(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r0.diskKey     // Catch:{ all -> 0x0119 }
            r1.append(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = " t"
            r1.append(r3)     // Catch:{ all -> 0x0119 }
            long r3 = r0.expiryTimestamp     // Catch:{ all -> 0x0119 }
            r1.append(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r0.getLengths()     // Catch:{ all -> 0x0119 }
            r1.append(r3)     // Catch:{ all -> 0x0119 }
            r1.append(r2)     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0119 }
            r12.write(r1)     // Catch:{ all -> 0x0119 }
            if (r13 == 0) goto L_0x00c9
            long r12 = r11.nextSequenceNumber     // Catch:{ all -> 0x0119 }
            r1 = 1
            long r3 = r12 + r1
            r11.nextSequenceNumber = r3     // Catch:{ all -> 0x0119 }
            r0.sequenceNumber = r12     // Catch:{ all -> 0x0119 }
            goto L_0x00c9
        L_0x00a6:
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r12 = r11.lruEntries     // Catch:{ all -> 0x0119 }
            java.lang.String r13 = r0.diskKey     // Catch:{ all -> 0x0119 }
            r12.remove(r13)     // Catch:{ all -> 0x0119 }
            java.io.Writer r12 = r11.journalWriter     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = "D "
            r13.<init>(r1)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = r0.diskKey     // Catch:{ all -> 0x0119 }
            r13.append(r0)     // Catch:{ all -> 0x0119 }
            r13.append(r2)     // Catch:{ all -> 0x0119 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0119 }
            r12.write(r13)     // Catch:{ all -> 0x0119 }
        L_0x00c9:
            java.io.Writer r12 = r11.journalWriter     // Catch:{ all -> 0x0119 }
            r12.flush()     // Catch:{ all -> 0x0119 }
            long r12 = r11.size     // Catch:{ all -> 0x0119 }
            long r0 = r11.maxSize     // Catch:{ all -> 0x0119 }
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00dc
            boolean r12 = r11.journalRebuildRequired()     // Catch:{ all -> 0x0119 }
            if (r12 == 0) goto L_0x00e3
        L_0x00dc:
            java.util.concurrent.ThreadPoolExecutor r12 = r11.executorService     // Catch:{ all -> 0x0119 }
            java.util.concurrent.Callable<java.lang.Void> r13 = r11.cleanupCallable     // Catch:{ all -> 0x0119 }
            r12.submit(r13)     // Catch:{ all -> 0x0119 }
        L_0x00e3:
            monitor-exit(r11)
            return
        L_0x00e5:
            java.io.File r12 = r0.getDirtyFile(r1)     // Catch:{ all -> 0x0119 }
            if (r13 == 0) goto L_0x0112
            boolean r2 = r12.exists()     // Catch:{ all -> 0x0119 }
            if (r2 == 0) goto L_0x0115
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x0119 }
            r12.renameTo(r2)     // Catch:{ all -> 0x0119 }
            long[] r12 = r0.lengths     // Catch:{ all -> 0x0119 }
            r3 = r12[r1]     // Catch:{ all -> 0x0119 }
            long r5 = r2.length()     // Catch:{ all -> 0x0119 }
            long[] r12 = r0.lengths     // Catch:{ all -> 0x0119 }
            r12[r1] = r5     // Catch:{ all -> 0x0119 }
            long r7 = r11.size     // Catch:{ all -> 0x0119 }
            r12 = 0
            long r9 = r7 - r3
            long r2 = r9 + r5
            r11.size = r2     // Catch:{ all -> 0x0119 }
            goto L_0x0115
        L_0x0112:
            deleteIfExists(r12)     // Catch:{ all -> 0x0119 }
        L_0x0115:
            int r1 = r1 + 1
            goto L_0x0051
        L_0x0119:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.completeEdit(com.lidroid.xutils.cache.LruDiskCache$Editor, boolean):void");
    }

    private static void deleteContents(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            if (!file2.exists() || file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    private static void deleteIfExists(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.lidroid.xutils.cache.LruDiskCache.Editor editByDiskKey(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.checkNotClosed()     // Catch:{ all -> 0x005b }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r0 = r5.lruEntries     // Catch:{ all -> 0x005b }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005b }
            com.lidroid.xutils.cache.LruDiskCache$Entry r0 = (com.lidroid.xutils.cache.LruDiskCache.Entry) r0     // Catch:{ all -> 0x005b }
            r1 = -1
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r1 = 0
            if (r3 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r2 = r0.sequenceNumber     // Catch:{ all -> 0x005b }
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r1
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            com.lidroid.xutils.cache.LruDiskCache$Entry r0 = new com.lidroid.xutils.cache.LruDiskCache$Entry     // Catch:{ all -> 0x005b }
            r0.<init>(r5, r6, r1)     // Catch:{ all -> 0x005b }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r7 = r5.lruEntries     // Catch:{ all -> 0x005b }
            r7.put(r6, r0)     // Catch:{ all -> 0x005b }
            goto L_0x0034
        L_0x002c:
            com.lidroid.xutils.cache.LruDiskCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x005b }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r1
        L_0x0034:
            com.lidroid.xutils.cache.LruDiskCache$Editor r7 = new com.lidroid.xutils.cache.LruDiskCache$Editor     // Catch:{ all -> 0x005b }
            r7.<init>(r5, r0, r1)     // Catch:{ all -> 0x005b }
            r0.currentEditor = r7     // Catch:{ all -> 0x005b }
            java.io.Writer r8 = r5.journalWriter     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "U "
            r0.<init>(r1)     // Catch:{ all -> 0x005b }
            r0.append(r6)     // Catch:{ all -> 0x005b }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x005b }
            r8.write(r6)     // Catch:{ all -> 0x005b }
            java.io.Writer r6 = r5.journalWriter     // Catch:{ all -> 0x005b }
            r6.flush()     // Catch:{ all -> 0x005b }
            monitor-exit(r5)
            return r7
        L_0x005b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.editByDiskKey(java.lang.String, long):com.lidroid.xutils.cache.LruDiskCache$Editor");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|46|(2:63|48)(2:49|(2:51|52)(1:62))) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r13.redundantOpCount++;
        r13.journalWriter.append("R " + r14 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c1, code lost:
        if (journalRebuildRequired() == false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c3, code lost:
        r13.executorService.submit(r13.cleanupCallable);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dc, code lost:
        return new com.lidroid.xutils.cache.LruDiskCache.Snapshot(r13, r14, com.lidroid.xutils.cache.LruDiskCache.Entry.access$10(r0), r10, com.lidroid.xutils.cache.LruDiskCache.Entry.access$8(r0), (com.lidroid.xutils.cache.LruDiskCache.Snapshot) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ed, code lost:
        if (r3 >= r13.valueCount) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f2, code lost:
        if (r10[r3] != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
        com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r10[r3]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f9, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fd, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00eb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.lidroid.xutils.cache.LruDiskCache.Snapshot getByDiskKey(java.lang.String r14) throws java.io.IOException {
        /*
            r13 = this;
            monitor-enter(r13)
            r13.checkNotClosed()     // Catch:{ all -> 0x00fe }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r0 = r13.lruEntries     // Catch:{ all -> 0x00fe }
            java.lang.Object r0 = r0.get(r14)     // Catch:{ all -> 0x00fe }
            com.lidroid.xutils.cache.LruDiskCache$Entry r0 = (com.lidroid.xutils.cache.LruDiskCache.Entry) r0     // Catch:{ all -> 0x00fe }
            r1 = 0
            if (r0 != 0) goto L_0x0011
            monitor-exit(r13)
            return r1
        L_0x0011:
            boolean r2 = r0.readable     // Catch:{ all -> 0x00fe }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r13)
            return r1
        L_0x0019:
            long r2 = r0.expiryTimestamp     // Catch:{ all -> 0x00fe }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00fe }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r2 = 10
            r3 = 0
            if (r6 >= 0) goto L_0x0098
        L_0x0028:
            int r4 = r13.valueCount     // Catch:{ all -> 0x00fe }
            if (r3 < r4) goto L_0x005c
            int r0 = r13.redundantOpCount     // Catch:{ all -> 0x00fe }
            int r0 = r0 + 1
            r13.redundantOpCount = r0     // Catch:{ all -> 0x00fe }
            java.io.Writer r0 = r13.journalWriter     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "D "
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            r3.append(r14)     // Catch:{ all -> 0x00fe }
            r3.append(r2)     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00fe }
            r0.append(r2)     // Catch:{ all -> 0x00fe }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r0 = r13.lruEntries     // Catch:{ all -> 0x00fe }
            r0.remove(r14)     // Catch:{ all -> 0x00fe }
            boolean r14 = r13.journalRebuildRequired()     // Catch:{ all -> 0x00fe }
            if (r14 == 0) goto L_0x005a
            java.util.concurrent.ThreadPoolExecutor r14 = r13.executorService     // Catch:{ all -> 0x00fe }
            java.util.concurrent.Callable<java.lang.Void> r0 = r13.cleanupCallable     // Catch:{ all -> 0x00fe }
            r14.submit(r0)     // Catch:{ all -> 0x00fe }
        L_0x005a:
            monitor-exit(r13)
            return r1
        L_0x005c:
            java.io.File r4 = r0.getCleanFile(r3)     // Catch:{ all -> 0x00fe }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x00fe }
            if (r5 == 0) goto L_0x0080
            boolean r5 = r4.delete()     // Catch:{ all -> 0x00fe }
            if (r5 != 0) goto L_0x0080
            java.io.IOException r14 = new java.io.IOException     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x00fe }
            r0.append(r4)     // Catch:{ all -> 0x00fe }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fe }
            r14.<init>(r0)     // Catch:{ all -> 0x00fe }
            throw r14     // Catch:{ all -> 0x00fe }
        L_0x0080:
            long r4 = r13.size     // Catch:{ all -> 0x00fe }
            long[] r6 = r0.lengths     // Catch:{ all -> 0x00fe }
            r7 = r6[r3]     // Catch:{ all -> 0x00fe }
            r6 = 0
            long r9 = r4 - r7
            r13.size = r9     // Catch:{ all -> 0x00fe }
            long[] r4 = r0.lengths     // Catch:{ all -> 0x00fe }
            r5 = 0
            r4[r3] = r5     // Catch:{ all -> 0x00fe }
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0098:
            int r4 = r13.valueCount     // Catch:{ all -> 0x00fe }
            java.io.FileInputStream[] r10 = new java.io.FileInputStream[r4]     // Catch:{ all -> 0x00fe }
            r4 = 0
        L_0x009d:
            int r5 = r13.valueCount     // Catch:{ FileNotFoundException -> 0x00eb }
            if (r4 < r5) goto L_0x00dd
            int r1 = r13.redundantOpCount     // Catch:{ all -> 0x00fe }
            int r1 = r1 + 1
            r13.redundantOpCount = r1     // Catch:{ all -> 0x00fe }
            java.io.Writer r1 = r13.journalWriter     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = "R "
            r3.<init>(r4)     // Catch:{ all -> 0x00fe }
            r3.append(r14)     // Catch:{ all -> 0x00fe }
            r3.append(r2)     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00fe }
            r1.append(r2)     // Catch:{ all -> 0x00fe }
            boolean r1 = r13.journalRebuildRequired()     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x00ca
            java.util.concurrent.ThreadPoolExecutor r1 = r13.executorService     // Catch:{ all -> 0x00fe }
            java.util.concurrent.Callable<java.lang.Void> r2 = r13.cleanupCallable     // Catch:{ all -> 0x00fe }
            r1.submit(r2)     // Catch:{ all -> 0x00fe }
        L_0x00ca:
            com.lidroid.xutils.cache.LruDiskCache$Snapshot r1 = new com.lidroid.xutils.cache.LruDiskCache$Snapshot     // Catch:{ all -> 0x00fe }
            long r8 = r0.sequenceNumber     // Catch:{ all -> 0x00fe }
            long[] r11 = r0.lengths     // Catch:{ all -> 0x00fe }
            r12 = 0
            r5 = r1
            r6 = r13
            r7 = r14
            r5.<init>(r6, r7, r8, r10, r11, r12)     // Catch:{ all -> 0x00fe }
            monitor-exit(r13)
            return r1
        L_0x00dd:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00eb }
            java.io.File r6 = r0.getCleanFile(r4)     // Catch:{ FileNotFoundException -> 0x00eb }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00eb }
            r10[r4] = r5     // Catch:{ FileNotFoundException -> 0x00eb }
            int r4 = r4 + 1
            goto L_0x009d
        L_0x00eb:
            int r14 = r13.valueCount     // Catch:{ all -> 0x00fe }
            if (r3 < r14) goto L_0x00f0
            goto L_0x00fc
        L_0x00f0:
            r14 = r10[r3]     // Catch:{ all -> 0x00fe }
            if (r14 == 0) goto L_0x00fc
            r14 = r10[r3]     // Catch:{ all -> 0x00fe }
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r14)     // Catch:{ all -> 0x00fe }
            int r3 = r3 + 1
            goto L_0x00eb
        L_0x00fc:
            monitor-exit(r13)
            return r1
        L_0x00fe:
            r14 = move-exception
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.getByDiskKey(java.lang.String):com.lidroid.xutils.cache.LruDiskCache$Snapshot");
    }

    /* access modifiers changed from: private */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        return readFully(new InputStreamReader(inputStream, "UTF-8"));
    }

    /* access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public static LruDiskCache open(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    renameTo(file2, file3, false);
                }
            }
            LruDiskCache lruDiskCache = new LruDiskCache(file, i, i2, j);
            if (lruDiskCache.journalFile.exists()) {
                try {
                    lruDiskCache.readJournal();
                    lruDiskCache.processJournal();
                    lruDiskCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(lruDiskCache.journalFile, true), "US-ASCII"));
                    return lruDiskCache;
                } catch (Throwable th) {
                    LogUtils.e("DiskLruCache " + file + " is corrupt: " + th.getMessage() + ", removing", th);
                    lruDiskCache.delete();
                }
            }
            if (!file.exists() && !file.mkdirs()) {
                return lruDiskCache;
            }
            LruDiskCache lruDiskCache2 = new LruDiskCache(file, i, i2, j);
            lruDiskCache2.rebuildJournal();
            return lruDiskCache2;
        }
    }

    private void processJournal() throws IOException {
        deleteIfExists(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i));
                    deleteIfExists(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private static String readFully(Reader reader) throws IOException {
        StringWriter stringWriter;
        Throwable th;
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        String stringWriter2 = stringWriter.toString();
                        IOUtils.closeQuietly((Closeable) reader);
                        IOUtils.closeQuietly((Closeable) stringWriter);
                        return stringWriter2;
                    }
                    stringWriter.write(cArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            stringWriter = null;
            th = th4;
            IOUtils.closeQuietly((Closeable) reader);
            IOUtils.closeQuietly((Closeable) stringWriter);
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x006a=Splitter:B:22:0x006a, B:18:0x005d=Splitter:B:18:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            r0 = 0
            com.lidroid.xutils.cache.LruDiskCache$StrictLineReader r1 = new com.lidroid.xutils.cache.LruDiskCache$StrictLineReader     // Catch:{ all -> 0x009d }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x009d }
            java.io.File r3 = r9.journalFile     // Catch:{ all -> 0x009d }
            r2.<init>(r3)     // Catch:{ all -> 0x009d }
            r1.<init>(r9, r2)     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r1.readLine()     // Catch:{ all -> 0x009b }
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x009b }
            java.lang.String r3 = r1.readLine()     // Catch:{ all -> 0x009b }
            java.lang.String r4 = r1.readLine()     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x009b }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x009b }
            if (r6 == 0) goto L_0x006a
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x009b }
            if (r6 == 0) goto L_0x006a
            int r6 = r9.appVersion     // Catch:{ all -> 0x009b }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x009b }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x006a
            int r3 = r9.valueCount     // Catch:{ all -> 0x009b }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x009b }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x006a
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x0052
            goto L_0x006a
        L_0x0052:
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readLine()     // Catch:{ EOFException -> 0x005d }
            r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r2 = r9.lruEntries     // Catch:{ all -> 0x009b }
            int r2 = r2.size()     // Catch:{ all -> 0x009b }
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch:{ all -> 0x009b }
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r1)
            return
        L_0x006a:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x009b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            java.lang.String r7 = "unexpected journal header: ["
            r6.<init>(r7)     // Catch:{ all -> 0x009b }
            r6.append(r0)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = ", "
            r6.append(r0)     // Catch:{ all -> 0x009b }
            r6.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = ", "
            r6.append(r0)     // Catch:{ all -> 0x009b }
            r6.append(r4)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = ", "
            r6.append(r0)     // Catch:{ all -> 0x009b }
            r6.append(r5)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x009b }
            r3.<init>(r0)     // Catch:{ all -> 0x009b }
            throw r3     // Catch:{ all -> 0x009b }
        L_0x009b:
            r0 = move-exception
            goto L_0x00a1
        L_0x009d:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x00a1:
            com.lidroid.xutils.util.IOUtils.closeQuietly((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.readJournal():void");
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf == 1) {
            char charAt = str.charAt(0);
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (charAt == 'D') {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.lruEntries.get(str2);
            if (entry == null) {
                entry = new Entry(this, str2, (Entry) null);
                this.lruEntries.put(str2, entry);
            }
            if (charAt == 'C') {
                entry.readable = true;
                entry.currentEditor = null;
                String[] split = str.substring(indexOf2 + 1).split(s.a.f1696a);
                if (split.length > 0) {
                    try {
                        if (split[0].charAt(0) == 't') {
                            entry.expiryTimestamp = Long.valueOf(split[0].substring(1)).longValue();
                            entry.setLengths(split, 1);
                            return;
                        }
                        entry.expiryTimestamp = Long.MAX_VALUE;
                        entry.setLengths(split, 0);
                    } catch (Throwable unused) {
                        throw new IOException("unexpected journal line: " + str);
                    }
                }
            } else if (charAt == 'R') {
            } else {
                if (charAt != 'U') {
                    throw new IOException("unexpected journal line: " + str);
                }
                entry.currentEditor = new Editor(this, entry, (Editor) null);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void rebuildJournal() throws IOException {
        BufferedWriter bufferedWriter;
        Throwable th;
        String str;
        if (this.journalWriter != null) {
            IOUtils.closeQuietly((Closeable) this.journalWriter);
        }
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), "US-ASCII"));
            try {
                bufferedWriter.write(MAGIC);
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry next : this.lruEntries.values()) {
                    if (next.currentEditor != null) {
                        str = "U " + next.diskKey + 10;
                    } else {
                        str = "C " + next.diskKey + " t" + next.expiryTimestamp + next.getLengths() + 10;
                    }
                    bufferedWriter.write(str);
                }
                IOUtils.closeQuietly((Closeable) bufferedWriter);
                if (this.journalFile.exists()) {
                    renameTo(this.journalFile, this.journalFileBackup, true);
                }
                renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), "US-ASCII"));
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly((Closeable) bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedWriter = null;
            th = th4;
            IOUtils.closeQuietly((Closeable) bufferedWriter);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean removeByDiskKey(java.lang.String r10) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            r9.checkNotClosed()     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x008a }
            com.lidroid.xutils.cache.LruDiskCache$Entry r0 = (com.lidroid.xutils.cache.LruDiskCache.Entry) r0     // Catch:{ all -> 0x008a }
            r1 = 0
            if (r0 == 0) goto L_0x0088
            com.lidroid.xutils.cache.LruDiskCache$Editor r2 = r0.currentEditor     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0016
            goto L_0x0088
        L_0x0016:
            int r2 = r9.valueCount     // Catch:{ all -> 0x008a }
            if (r1 < r2) goto L_0x004c
            int r0 = r9.redundantOpCount     // Catch:{ all -> 0x008a }
            r1 = 1
            int r0 = r0 + r1
            r9.redundantOpCount = r0     // Catch:{ all -> 0x008a }
            java.io.Writer r0 = r9.journalWriter     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            java.lang.String r3 = "D "
            r2.<init>(r3)     // Catch:{ all -> 0x008a }
            r2.append(r10)     // Catch:{ all -> 0x008a }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            java.util.LinkedHashMap<java.lang.String, com.lidroid.xutils.cache.LruDiskCache$Entry> r0 = r9.lruEntries     // Catch:{ all -> 0x008a }
            r0.remove(r10)     // Catch:{ all -> 0x008a }
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x008a }
            if (r10 == 0) goto L_0x004a
            java.util.concurrent.ThreadPoolExecutor r10 = r9.executorService     // Catch:{ all -> 0x008a }
            java.util.concurrent.Callable<java.lang.Void> r0 = r9.cleanupCallable     // Catch:{ all -> 0x008a }
            r10.submit(r0)     // Catch:{ all -> 0x008a }
        L_0x004a:
            monitor-exit(r9)
            return r1
        L_0x004c:
            java.io.File r2 = r0.getCleanFile(r1)     // Catch:{ all -> 0x008a }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0070
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008a }
            if (r3 != 0) goto L_0x0070
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008a }
            r10.<init>(r0)     // Catch:{ all -> 0x008a }
            throw r10     // Catch:{ all -> 0x008a }
        L_0x0070:
            long r2 = r9.size     // Catch:{ all -> 0x008a }
            long[] r4 = r0.lengths     // Catch:{ all -> 0x008a }
            r5 = r4[r1]     // Catch:{ all -> 0x008a }
            r4 = 0
            long r7 = r2 - r5
            r9.size = r7     // Catch:{ all -> 0x008a }
            long[] r2 = r0.lengths     // Catch:{ all -> 0x008a }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008a }
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0088:
            monitor-exit(r9)
            return r1
        L_0x008a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruDiskCache.removeByDiskKey(java.lang.String):boolean");
    }

    private static void renameTo(File file, File file2, boolean z) throws IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* access modifiers changed from: private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeByDiskKey((String) this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    public final synchronized void close() throws IOException {
        if (this.journalWriter != null) {
            Iterator it = new ArrayList(this.lruEntries.values()).iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry.currentEditor != null) {
                    entry.currentEditor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
        }
    }

    public final void delete() throws IOException {
        IOUtils.closeQuietly((Closeable) this);
        deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        return editByDiskKey(this.fileNameGenerator.generate(str), -1);
    }

    public final synchronized void flush() throws IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public final Snapshot get(String str) throws IOException {
        return getByDiskKey(this.fileNameGenerator.generate(str));
    }

    public final File getCacheFile(String str, int i) {
        String generate = this.fileNameGenerator.generate(str);
        File file = this.directory;
        File file2 = new File(file, String.valueOf(generate) + "." + i);
        if (file2.exists()) {
            return file2;
        }
        try {
            remove(str);
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final synchronized long getExpiryTimestamp(String str) throws IOException {
        String generate = this.fileNameGenerator.generate(str);
        checkNotClosed();
        Entry entry = this.lruEntries.get(generate);
        if (entry == null) {
            return 0;
        }
        return entry.expiryTimestamp;
    }

    public final FileNameGenerator getFileNameGenerator() {
        return this.fileNameGenerator;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    public final boolean remove(String str) throws IOException {
        return removeByDiskKey(this.fileNameGenerator.generate(str));
    }

    public final void setFileNameGenerator(FileNameGenerator fileNameGenerator2) {
        if (fileNameGenerator2 != null) {
            this.fileNameGenerator = fileNameGenerator2;
        }
    }

    public final synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public final synchronized long size() {
        return this.size;
    }
}
