package org.apache.commons.mail;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataSource;

@Deprecated
public class ByteArrayDataSource implements DataSource {
    public static final int BUFFER_SIZE = 512;
    private ByteArrayOutputStream baos;
    private String name = "";
    private final String type;

    public ByteArrayDataSource(InputStream inputStream, String str) throws IOException {
        this.type = str;
        byteArrayDataSource(inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        if (r1.baos != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        r1.baos.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        throw new java.io.IOException("The Character Encoding is not supported.");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ByteArrayDataSource(java.lang.String r2, java.lang.String r3) throws java.io.IOException {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = ""
            r1.name = r0
            r1.type = r3
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            r3.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            r1.baos = r3     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            java.io.ByteArrayOutputStream r3 = r1.baos     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            java.lang.String r0 = "iso-8859-1"
            byte[] r2 = r2.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            r3.write(r2)     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            java.io.ByteArrayOutputStream r2 = r1.baos     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            r2.flush()     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            java.io.ByteArrayOutputStream r2 = r1.baos     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            r2.close()     // Catch:{ UnsupportedEncodingException -> 0x0031 }
            java.io.ByteArrayOutputStream r2 = r1.baos
            if (r2 == 0) goto L_0x002e
            java.io.ByteArrayOutputStream r2 = r1.baos
            r2.close()
        L_0x002e:
            return
        L_0x002f:
            r2 = move-exception
            goto L_0x0039
        L_0x0031:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x002f }
            java.lang.String r3 = "The Character Encoding is not supported."
            r2.<init>(r3)     // Catch:{ all -> 0x002f }
            throw r2     // Catch:{ all -> 0x002f }
        L_0x0039:
            java.io.ByteArrayOutputStream r3 = r1.baos
            if (r3 == 0) goto L_0x0042
            java.io.ByteArrayOutputStream r3 = r1.baos
            r3.close()
        L_0x0042:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.ByteArrayDataSource.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ByteArrayDataSource(byte[] r2, java.lang.String r3) throws java.io.IOException {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = ""
            r1.name = r0
            r1.type = r3
            r3 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0019 }
            r0.<init>(r2)     // Catch:{ all -> 0x0019 }
            r1.byteArrayDataSource(r0)     // Catch:{ all -> 0x0016 }
            r0.close()
            return
        L_0x0016:
            r2 = move-exception
            r3 = r0
            goto L_0x001a
        L_0x0019:
            r2 = move-exception
        L_0x001a:
            if (r3 == 0) goto L_0x001f
            r3.close()
        L_0x001f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.ByteArrayDataSource.<init>(byte[], java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void byteArrayDataSource(java.io.InputStream r5) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 512(0x200, float:7.175E-43)
            r1 = 0
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x003f }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003d }
            r5.<init>()     // Catch:{ all -> 0x003d }
            r4.baos = r5     // Catch:{ all -> 0x003d }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x003d }
            java.io.ByteArrayOutputStream r3 = r4.baos     // Catch:{ all -> 0x003d }
            r5.<init>(r3)     // Catch:{ all -> 0x003d }
        L_0x0018:
            int r1 = r2.read(r0)     // Catch:{ all -> 0x003a }
            r3 = -1
            if (r1 == r3) goto L_0x0024
            r3 = 0
            r5.write(r0, r3, r1)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0024:
            r5.flush()     // Catch:{ all -> 0x003a }
            r5.close()     // Catch:{ all -> 0x003a }
            r2.close()
            java.io.ByteArrayOutputStream r0 = r4.baos
            if (r0 == 0) goto L_0x0036
            java.io.ByteArrayOutputStream r0 = r4.baos
            r0.close()
        L_0x0036:
            r5.close()
            return
        L_0x003a:
            r0 = move-exception
            r1 = r5
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
            goto L_0x0041
        L_0x003f:
            r0 = move-exception
            r2 = r1
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            java.io.ByteArrayOutputStream r5 = r4.baos
            if (r5 == 0) goto L_0x004f
            java.io.ByteArrayOutputStream r5 = r4.baos
            r5.close()
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.mail.ByteArrayDataSource.byteArrayDataSource(java.io.InputStream):void");
    }

    public String getContentType() {
        return this.type == null ? OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : this.type;
    }

    public InputStream getInputStream() throws IOException {
        if (this.baos != null) {
            return new ByteArrayInputStream(this.baos.toByteArray());
        }
        throw new IOException("no data");
    }

    public String getName() {
        return this.name;
    }

    public OutputStream getOutputStream() {
        this.baos = new ByteArrayOutputStream();
        return this.baos;
    }

    public void setName(String str) {
        this.name = str;
    }
}
