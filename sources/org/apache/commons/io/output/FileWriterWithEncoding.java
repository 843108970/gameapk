package org.apache.commons.io.output;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class FileWriterWithEncoding extends Writer {
    private final Writer out;

    public FileWriterWithEncoding(File file, String str) throws IOException {
        this(file, str, false);
    }

    public FileWriterWithEncoding(File file, String str, boolean z) throws IOException {
        this.out = initWriter(file, str, z);
    }

    public FileWriterWithEncoding(File file, Charset charset) throws IOException {
        this(file, charset, false);
    }

    public FileWriterWithEncoding(File file, Charset charset, boolean z) throws IOException {
        this.out = initWriter(file, charset, z);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder) throws IOException {
        this(file, charsetEncoder, false);
    }

    public FileWriterWithEncoding(File file, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this.out = initWriter(file, charsetEncoder, z);
    }

    public FileWriterWithEncoding(String str, String str2) throws IOException {
        this(new File(str), str2, false);
    }

    public FileWriterWithEncoding(String str, String str2, boolean z) throws IOException {
        this(new File(str), str2, z);
    }

    public FileWriterWithEncoding(String str, Charset charset) throws IOException {
        this(new File(str), charset, false);
    }

    public FileWriterWithEncoding(String str, Charset charset, boolean z) throws IOException {
        this(new File(str), charset, z);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder) throws IOException {
        this(new File(str), charsetEncoder, false);
    }

    public FileWriterWithEncoding(String str, CharsetEncoder charsetEncoder, boolean z) throws IOException {
        this(new File(str), charsetEncoder, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.Writer initWriter(java.io.File r3, java.lang.Object r4, boolean r5) throws java.io.IOException {
        /*
            if (r3 != 0) goto L_0x000a
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "File is missing"
            r3.<init>(r4)
            throw r3
        L_0x000a:
            if (r4 != 0) goto L_0x0014
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "Encoding is missing"
            r3.<init>(r4)
            throw r3
        L_0x0014:
            boolean r0 = r3.exists()
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0050, RuntimeException -> 0x0042 }
            r2.<init>(r3, r5)     // Catch:{ IOException -> 0x0050, RuntimeException -> 0x0042 }
            boolean r5 = r4 instanceof java.nio.charset.Charset     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            if (r5 == 0) goto L_0x002a
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            java.nio.charset.Charset r4 = (java.nio.charset.Charset) r4     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            r5.<init>(r2, r4)     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            return r5
        L_0x002a:
            boolean r5 = r4 instanceof java.nio.charset.CharsetEncoder     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            if (r5 == 0) goto L_0x0036
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            java.nio.charset.CharsetEncoder r4 = (java.nio.charset.CharsetEncoder) r4     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            r5.<init>(r2, r4)     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            return r5
        L_0x0036:
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            r5.<init>(r2, r4)     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x003e }
            return r5
        L_0x003e:
            r4 = move-exception
            goto L_0x0044
        L_0x0040:
            r4 = move-exception
            goto L_0x0052
        L_0x0042:
            r4 = move-exception
            r2 = r1
        L_0x0044:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Writer) r1)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r2)
            if (r0 != 0) goto L_0x004f
            org.apache.commons.io.FileUtils.deleteQuietly(r3)
        L_0x004f:
            throw r4
        L_0x0050:
            r4 = move-exception
            r2 = r1
        L_0x0052:
            org.apache.commons.io.IOUtils.closeQuietly((java.io.Writer) r1)
            org.apache.commons.io.IOUtils.closeQuietly((java.io.OutputStream) r2)
            if (r0 != 0) goto L_0x005d
            org.apache.commons.io.FileUtils.deleteQuietly(r3)
        L_0x005d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.output.FileWriterWithEncoding.initWriter(java.io.File, java.lang.Object, boolean):java.io.Writer");
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(String str) throws IOException {
        this.out.write(str);
    }

    public void write(String str, int i, int i2) throws IOException {
        this.out.write(str, i, i2);
    }

    public void write(char[] cArr) throws IOException {
        this.out.write(cArr);
    }

    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
    }
}
