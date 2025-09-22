package com.alibaba.sdk.android.oss.network;

import b.ae;
import b.af;
import b.w;
import b.z;
import java.io.IOException;
import java.io.InputStream;

public class NetworkProgressHelper {
    public static ProgressTouchableRequestBody addProgressRequestBody(InputStream inputStream, long j, String str, ExecutionContext executionContext) {
        return new ProgressTouchableRequestBody(inputStream, j, str, executionContext);
    }

    public static z addProgressResponseListener(z zVar, final ExecutionContext executionContext) {
        return zVar.a().a((w) new w() {
            public final ae intercept(w.a aVar) throws IOException {
                ae a2 = aVar.a(aVar.a());
                return a2.e().a((af) new ProgressTouchableResponseBody(a2.d(), executionContext)).a();
            }
        }).e();
    }
}
