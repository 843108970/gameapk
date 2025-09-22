package com.lidroid.xutils.http;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.callback.DefaultHttpRedirectHandler;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncHttpHandler {
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private long expiry = HttpCache.getDefaultExpiryTime();
    private HttpRedirectHandler httpRedirectHandler;
    private String requestMethod;
    private String requestUrl;
    private int retriedTimes = 0;

    public SyncHttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.charset = str;
    }

    private ResponseStream handleResponse(HttpResponse httpResponse) throws HttpException, IOException {
        if (httpResponse == null) {
            throw new HttpException("response is null");
        }
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode < 300) {
            ResponseStream responseStream = new ResponseStream(httpResponse, this.charset, this.requestUrl, this.expiry);
            responseStream.setRequestMethod(this.requestMethod);
            return responseStream;
        } else if (statusCode == 301 || statusCode == 302) {
            if (this.httpRedirectHandler == null) {
                this.httpRedirectHandler = new DefaultHttpRedirectHandler();
            }
            HttpRequestBase directRequest = this.httpRedirectHandler.getDirectRequest(httpResponse);
            if (directRequest != null) {
                return sendRequest(directRequest);
            }
            return null;
        } else if (statusCode == 416) {
            throw new HttpException(statusCode, "maybe the file has downloaded completely");
        } else {
            throw new HttpException(statusCode, statusLine.getReasonPhrase());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r1 = com.lidroid.xutils.HttpUtils.sHttpCache.get(r4.requestUrl);
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lidroid.xutils.http.ResponseStream sendRequest(org.apache.http.client.methods.HttpRequestBase r5) throws com.lidroid.xutils.exception.HttpException {
        /*
            r4 = this;
            org.apache.http.impl.client.AbstractHttpClient r0 = r4.client
            org.apache.http.client.HttpRequestRetryHandler r0 = r0.getHttpRequestRetryHandler()
        L_0x0006:
            java.net.URI r1 = r5.getURI()     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            r4.requestUrl = r1     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            java.lang.String r1 = r5.getMethod()     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            r4.requestMethod = r1     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            com.lidroid.xutils.http.HttpCache r1 = com.lidroid.xutils.HttpUtils.sHttpCache     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            java.lang.String r2 = r4.requestMethod     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            boolean r1 = r1.isEnabled((java.lang.String) r2)     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            if (r1 == 0) goto L_0x0030
            com.lidroid.xutils.http.HttpCache r1 = com.lidroid.xutils.HttpUtils.sHttpCache     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            java.lang.String r2 = r4.requestUrl     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            java.lang.String r1 = r1.get(r2)     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            if (r1 == 0) goto L_0x0030
            com.lidroid.xutils.http.ResponseStream r2 = new com.lidroid.xutils.http.ResponseStream     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            r2.<init>(r1)     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            return r2
        L_0x0030:
            org.apache.http.impl.client.AbstractHttpClient r1 = r4.client     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            org.apache.http.protocol.HttpContext r2 = r4.context     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            org.apache.http.HttpResponse r1 = r1.execute(r5, r2)     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            com.lidroid.xutils.http.ResponseStream r1 = r4.handleResponse(r1)     // Catch:{ IOException | UnknownHostException -> 0x0058, NullPointerException -> 0x004a, HttpException -> 0x0048, Throwable -> 0x003d }
            return r1
        L_0x003d:
            r1 = move-exception
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = r1.getMessage()
            r2.<init>(r3)
            goto L_0x0054
        L_0x0048:
            r5 = move-exception
            throw r5
        L_0x004a:
            r1 = move-exception
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = r1.getMessage()
            r2.<init>(r3)
        L_0x0054:
            r2.initCause(r1)
            goto L_0x005a
        L_0x0058:
            r1 = move-exception
            r2 = r1
        L_0x005a:
            int r1 = r4.retriedTimes
            int r1 = r1 + 1
            r4.retriedTimes = r1
            org.apache.http.protocol.HttpContext r3 = r4.context
            boolean r1 = r0.retryRequest(r2, r1, r3)
            if (r1 != 0) goto L_0x0006
            com.lidroid.xutils.exception.HttpException r5 = new com.lidroid.xutils.exception.HttpException
            r5.<init>((java.lang.Throwable) r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.SyncHttpHandler.sendRequest(org.apache.http.client.methods.HttpRequestBase):com.lidroid.xutils.http.ResponseStream");
    }

    public void setExpiry(long j) {
        this.expiry = j;
    }

    public void setHttpRedirectHandler(HttpRedirectHandler httpRedirectHandler2) {
        this.httpRedirectHandler = httpRedirectHandler2;
    }
}
