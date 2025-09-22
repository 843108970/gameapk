package com.alibaba.sdk.android.oss.internal;

import b.ae;
import b.u;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractResponseParser<T extends OSSResult> implements ResponseParser {
    private Map<String, String> parseResponseHeader(ae aeVar) {
        HashMap hashMap = new HashMap();
        u c2 = aeVar.c();
        for (int i = 0; i < c2.a(); i++) {
            hashMap.put(c2.a(i), c2.b(i));
        }
        return hashMap;
    }

    public static void safeCloseResponse(ae aeVar) {
        try {
            aeVar.d().close();
        } catch (Exception unused) {
        }
    }

    public boolean needCloseResponse() {
        return true;
    }

    public T parse(ae aeVar) throws IOException {
        try {
            T t = (OSSResult) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            if (t != null) {
                t.setRequestId(aeVar.a(OSSHeaders.OSS_HEADER_REQUEST_ID));
                t.setStatusCode(aeVar.a());
                t.setResponseHeader(parseResponseHeader(aeVar));
                t = parseData(aeVar, t);
            }
            if (needCloseResponse()) {
                safeCloseResponse(aeVar);
            }
            return t;
        } catch (Exception e) {
            IOException iOException = new IOException(e.getMessage(), e);
            e.printStackTrace();
            OSSLog.logThrowable2Local(e);
            throw iOException;
        } catch (Throwable th) {
            if (needCloseResponse()) {
                safeCloseResponse(aeVar);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T parseData(ae aeVar, T t) throws Exception;
}
