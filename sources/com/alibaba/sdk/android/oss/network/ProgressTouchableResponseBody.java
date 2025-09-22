package com.alibaba.sdk.android.oss.network;

import b.af;
import b.x;
import c.c;
import c.e;
import c.i;
import c.p;
import c.y;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.io.IOException;

public class ProgressTouchableResponseBody<T extends OSSRequest> extends af {
    private e mBufferedSource;
    /* access modifiers changed from: private */
    public OSSProgressCallback mProgressListener;
    /* access modifiers changed from: private */
    public final af mResponseBody;
    /* access modifiers changed from: private */
    public T request;

    public ProgressTouchableResponseBody(af afVar, ExecutionContext executionContext) {
        this.mResponseBody = afVar;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = executionContext.getRequest();
    }

    private y source(y yVar) {
        return new i(yVar) {
            private long totalBytesRead = 0;

            public long read(c cVar, long j) throws IOException {
                long read = super.read(cVar, j);
                this.totalBytesRead += read != -1 ? read : 0;
                if (!(ProgressTouchableResponseBody.this.mProgressListener == null || this.totalBytesRead == -1 || this.totalBytesRead == 0)) {
                    ProgressTouchableResponseBody.this.mProgressListener.onProgress(ProgressTouchableResponseBody.this.request, this.totalBytesRead, ProgressTouchableResponseBody.this.mResponseBody.contentLength());
                }
                return read;
            }
        };
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public x contentType() {
        return this.mResponseBody.contentType();
    }

    public e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = p.a(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }
}
