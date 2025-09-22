package com.lidroid.xutils.http.client.entity;

import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

abstract class DecompressingEntity extends HttpEntityWrapper implements UploadEntity {
    private RequestCallBackHandler callBackHandler = null;
    private InputStream content;
    private long uncompressedLength;
    private long uploadedSize = 0;

    public DecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
        this.uncompressedLength = httpEntity.getContentLength();
    }

    private InputStream getDecompressingStream() throws IOException {
        InputStream inputStream = null;
        try {
            InputStream content2 = this.wrappedEntity.getContent();
            try {
                return decorate(content2);
            } catch (IOException e) {
                InputStream inputStream2 = content2;
                e = e;
                inputStream = inputStream2;
                IOUtils.closeQuietly((Closeable) inputStream);
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            IOUtils.closeQuietly((Closeable) inputStream);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract InputStream decorate(InputStream inputStream) throws IOException;

    public InputStream getContent() throws IOException {
        if (!this.wrappedEntity.isStreaming()) {
            return getDecompressingStream();
        }
        if (this.content == null) {
            this.content = getDecompressingStream();
        }
        return this.content;
    }

    public long getContentLength() {
        return -1;
    }

    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        InputStream inputStream;
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        try {
            inputStream = getContent();
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        if (this.callBackHandler != null) {
                            this.callBackHandler.updateProgress(this.uncompressedLength, this.uploadedSize, true);
                        }
                        IOUtils.closeQuietly((Closeable) inputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    this.uploadedSize += (long) read;
                    if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.uncompressedLength, this.uploadedSize, false)) {
                        throw new InterruptedIOException("cancel");
                    }
                }
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly((Closeable) inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            IOUtils.closeQuietly((Closeable) inputStream);
            throw th;
        }
    }
}
