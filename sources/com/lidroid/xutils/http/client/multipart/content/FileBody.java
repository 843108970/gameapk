package com.lidroid.xutils.http.client.multipart.content;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

public class FileBody extends AbstractContentBody {
    private final String charset;
    private final File file;
    private final String filename;

    public FileBody(File file2) {
        this(file2, (String) null, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, (String) null);
    }

    public FileBody(File file2, String str) {
        this(file2, (String) null, str, (String) null);
    }

    public FileBody(File file2, String str, String str2) {
        this(file2, (String) null, str, str2);
    }

    public FileBody(File file2, String str, String str2, String str3) {
        super(str2);
        if (file2 == null) {
            throw new IllegalArgumentException("File may not be null");
        }
        this.file = file2;
        if (str != null) {
            this.filename = str;
        } else {
            this.filename = file2.getName();
        }
        this.charset = str3;
    }

    public String getCharset() {
        return this.charset;
    }

    public long getContentLength() {
        return this.file.length();
    }

    public File getFile() {
        return this.file;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file));
            try {
                byte[] bArr = new byte[4096];
                do {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        IOUtils.closeQuietly((Closeable) bufferedInputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    this.callBackInfo.pos += (long) read;
                } while (this.callBackInfo.doCallBack(false));
                throw new InterruptedIOException("cancel");
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            IOUtils.closeQuietly((Closeable) bufferedInputStream);
            throw th;
        }
    }
}
