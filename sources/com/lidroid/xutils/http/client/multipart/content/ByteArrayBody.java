package com.lidroid.xutils.http.client.multipart.content;

import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, str);
    }

    public ByteArrayBody(byte[] bArr, String str, String str2) {
        super(str);
        if (bArr == null) {
            throw new IllegalArgumentException("byte[] may not be null");
        }
        this.data = bArr;
        this.filename = str2;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return (long) this.data.length;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
        this.callBackInfo.pos += (long) this.data.length;
        this.callBackInfo.doCallBack(false);
    }
}
