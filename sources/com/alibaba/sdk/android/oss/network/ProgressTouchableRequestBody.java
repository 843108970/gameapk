package com.alibaba.sdk.android.oss.network;

import android.support.v4.media.session.PlaybackStateCompat;
import b.ad;
import b.x;
import c.d;
import c.p;
import c.y;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.io.IOException;
import java.io.InputStream;

public class ProgressTouchableRequestBody<T extends OSSRequest> extends ad {
    private static final int SEGMENT_SIZE = 2048;
    private OSSProgressCallback callback;
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private T request;

    public ProgressTouchableRequestBody(InputStream inputStream2, long j, String str, ExecutionContext executionContext) {
        this.inputStream = inputStream2;
        this.contentType = str;
        this.contentLength = j;
        this.callback = executionContext.getProgressCallback();
        this.request = executionContext.getRequest();
    }

    public long contentLength() throws IOException {
        return this.contentLength;
    }

    public x contentType() {
        return x.a(this.contentType);
    }

    public void writeTo(d dVar) throws IOException {
        y a2 = p.a(this.inputStream);
        long j = 0;
        while (j < this.contentLength) {
            long read = a2.read(dVar.a(), Math.min(this.contentLength - j, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH));
            if (read == -1) {
                break;
            }
            long j2 = j + read;
            dVar.flush();
            if (!(this.callback == null || j2 == 0)) {
                this.callback.onProgress(this.request, j2, this.contentLength);
            }
            j = j2;
        }
        if (a2 != null) {
            a2.close();
        }
    }
}
