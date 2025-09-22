package com.lidroid.xutils.http.client.entity;

import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.apache.http.entity.FileEntity;

public class FileUploadEntity extends FileEntity implements UploadEntity {
    private RequestCallBackHandler callBackHandler = null;
    private long fileSize;
    private long uploadedSize = 0;

    public FileUploadEntity(File file, String str) {
        super(file, str);
        this.fileSize = file.length();
    }

    public void setCallBackHandler(RequestCallBackHandler requestCallBackHandler) {
        this.callBackHandler = requestCallBackHandler;
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
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        outputStream.flush();
                        if (this.callBackHandler != null) {
                            this.callBackHandler.updateProgress(this.fileSize, this.uploadedSize, true);
                        }
                        IOUtils.closeQuietly((Closeable) bufferedInputStream);
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                    this.uploadedSize += (long) read;
                    if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.fileSize, this.uploadedSize, false)) {
                        throw new InterruptedIOException("cancel");
                    }
                }
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
