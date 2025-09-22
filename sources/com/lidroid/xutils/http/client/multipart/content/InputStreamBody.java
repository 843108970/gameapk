package com.lidroid.xutils.http.client.multipart.content;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;

public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;
    private long length;

    public InputStreamBody(InputStream inputStream, long j) {
        this(inputStream, j, "no_name", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    }

    public InputStreamBody(InputStream inputStream, long j, String str) {
        this(inputStream, j, str, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
    }

    public InputStreamBody(InputStream inputStream, long j, String str, String str2) {
        super(str2);
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        }
        this.in = inputStream;
        this.filename = str;
        this.length = j;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return this.length;
    }

    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            byte[] bArr = new byte[4096];
            do {
                int read = this.in.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, read);
                this.callBackInfo.pos += (long) read;
            } while (this.callBackInfo.doCallBack(false));
            throw new InterruptedIOException("cancel");
        } finally {
            IOUtils.closeQuietly((Closeable) this.in);
        }
    }
}
