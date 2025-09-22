package com.lidroid.xutils.http.client.entity;

import android.support.v4.media.session.PlaybackStateCompat;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public class InputStreamUploadEntity extends AbstractHttpEntity implements UploadEntity {
    private static final int BUFFER_SIZE = 2048;
    private RequestCallBackHandler callBackHandler = null;
    private final InputStream content;
    private final long length;
    private long uploadedSize = 0;

    public InputStreamUploadEntity(InputStream inputStream, long j) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Source input stream may not be null");
        }
        this.content = inputStream;
        this.length = j;
    }

    public void consumeContent() throws IOException {
        this.content.close();
    }

    public InputStream getContent() throws IOException {
        return this.content;
    }

    public long getContentLength() {
        return this.length;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        OutputStream outputStream2 = outputStream;
        if (outputStream2 == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream inputStream = this.content;
        try {
            byte[] bArr = new byte[2048];
            int i = -1;
            int i2 = 0;
            if (this.length >= 0) {
                long j = this.length;
                while (true) {
                    if (j > 0) {
                        int read = inputStream.read(bArr, i2, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, j));
                        if (read == i) {
                            break;
                        }
                        outputStream2.write(bArr, i2, read);
                        long j2 = (long) read;
                        long j3 = j - j2;
                        this.uploadedSize += j2;
                        if (this.callBackHandler != null) {
                            if (!this.callBackHandler.updateProgress(this.length, this.uploadedSize, false)) {
                                throw new InterruptedIOException("cancel");
                            }
                        }
                        j = j3;
                        i = -1;
                        i2 = 0;
                    } else {
                        break;
                    }
                }
            } else {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    outputStream2.write(bArr, 0, read2);
                    this.uploadedSize += (long) read2;
                    if (this.callBackHandler != null) {
                        if (!this.callBackHandler.updateProgress(this.uploadedSize + 1, this.uploadedSize, false)) {
                            throw new InterruptedIOException("cancel");
                        }
                    }
                }
            }
            outputStream.flush();
            if (this.callBackHandler != null) {
                this.callBackHandler.updateProgress(this.length, this.uploadedSize, true);
            }
            IOUtils.closeQuietly((Closeable) inputStream);
        } catch (Throwable th) {
            Throwable th2 = th;
            IOUtils.closeQuietly((Closeable) inputStream);
            throw th2;
        }
    }
}
