package com.lidroid.xutils;

import android.content.Context;
import android.text.TextUtils;
import com.lidroid.xutils.http.HttpCache;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.SyncHttpHandler;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.DefaultSSLSocketFactory;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.http.client.RetryHandler;
import com.lidroid.xutils.http.client.entity.GZipDecompressingEntity;
import com.lidroid.xutils.task.PriorityExecutor;
import com.lidroid.xutils.util.OtherUtils;
import java.io.File;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpUtils {
    private static final int DEFAULT_CONN_TIMEOUT = 15000;
    private static final int DEFAULT_POOL_SIZE = 3;
    private static final int DEFAULT_RETRY_TIMES = 3;
    private static final String ENCODING_GZIP = "gzip";
    private static final PriorityExecutor EXECUTOR = new PriorityExecutor(3);
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final HttpCache sHttpCache = new HttpCache();
    private long currentRequestExpiry;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private HttpRedirectHandler httpRedirectHandler;
    private String responseTextCharset;

    public HttpUtils() {
        this(DEFAULT_CONN_TIMEOUT, (String) null);
    }

    public HttpUtils(int i) {
        this(i, (String) null);
    }

    public HttpUtils(int i, String str) {
        this.httpContext = new BasicHttpContext();
        this.responseTextCharset = "UTF-8";
        this.currentRequestExpiry = HttpCache.getDefaultExpiryTime();
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpProtocolParams.setUserAgent(basicHttpParams, TextUtils.isEmpty(str) ? OtherUtils.getUserAgent((Context) null) : str);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", DefaultSSLSocketFactory.getSocketFactory(), 443));
        this.httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(3));
        this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
            }
        });
        this.httpClient.addResponseInterceptor(new HttpResponseInterceptor() {
            public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase("gzip")) {
                            httpResponse.setEntity(new GZipDecompressingEntity(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        });
    }

    public HttpUtils(String str) {
        this(DEFAULT_CONN_TIMEOUT, str);
    }

    private <T> HttpHandler<T> sendRequest(com.lidroid.xutils.http.client.HttpRequest httpRequest, RequestParams requestParams, RequestCallBack<T> requestCallBack) {
        HttpHandler<T> httpHandler = new HttpHandler<>(this.httpClient, this.httpContext, this.responseTextCharset, requestCallBack);
        httpHandler.setExpiry(this.currentRequestExpiry);
        httpHandler.setHttpRedirectHandler(this.httpRedirectHandler);
        httpRequest.setRequestParams(requestParams, httpHandler);
        if (requestParams != null) {
            httpHandler.setPriority(requestParams.getPriority());
        }
        httpHandler.executeOnExecutor(EXECUTOR, httpRequest);
        return httpHandler;
    }

    private ResponseStream sendSyncRequest(com.lidroid.xutils.http.client.HttpRequest httpRequest, RequestParams requestParams) throws com.lidroid.xutils.exception.HttpException {
        SyncHttpHandler syncHttpHandler = new SyncHttpHandler(this.httpClient, this.httpContext, this.responseTextCharset);
        syncHttpHandler.setExpiry(this.currentRequestExpiry);
        syncHttpHandler.setHttpRedirectHandler(this.httpRedirectHandler);
        httpRequest.setRequestParams(requestParams);
        return syncHttpHandler.sendRequest(httpRequest);
    }

    public HttpUtils configCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
        return this;
    }

    public HttpUtils configCurrentHttpCacheExpiry(long j) {
        this.currentRequestExpiry = j;
        return this;
    }

    public HttpUtils configDefaultHttpCacheExpiry(long j) {
        HttpCache.setDefaultExpiryTime(j);
        this.currentRequestExpiry = HttpCache.getDefaultExpiryTime();
        return this;
    }

    public HttpUtils configHttpCacheSize(int i) {
        sHttpCache.setCacheSize(i);
        return this;
    }

    public HttpUtils configHttpRedirectHandler(HttpRedirectHandler httpRedirectHandler2) {
        this.httpRedirectHandler = httpRedirectHandler2;
        return this;
    }

    public HttpUtils configRegisterScheme(Scheme scheme) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(scheme);
        return this;
    }

    public HttpUtils configRequestRetryCount(int i) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(i));
        return this;
    }

    public HttpUtils configRequestThreadPoolSize(int i) {
        EXECUTOR.setPoolSize(i);
        return this;
    }

    public HttpUtils configResponseTextCharset(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.responseTextCharset = str;
        }
        return this;
    }

    public HttpUtils configSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sSLSocketFactory, 443));
        return this;
    }

    public HttpUtils configSoTimeout(int i) {
        HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), i);
        return this;
    }

    public HttpUtils configTimeout(int i) {
        HttpParams params = this.httpClient.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setConnectionTimeout(params, i);
        return this;
    }

    public HttpUtils configUserAgent(String str) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), str);
        return this;
    }

    public HttpHandler<File> download(HttpRequest.HttpMethod httpMethod, String str, String str2, RequestParams requestParams, RequestCallBack<File> requestCallBack) {
        return download(httpMethod, str, str2, requestParams, false, false, requestCallBack);
    }

    public HttpHandler<File> download(HttpRequest.HttpMethod httpMethod, String str, String str2, RequestParams requestParams, boolean z, RequestCallBack<File> requestCallBack) {
        return download(httpMethod, str, str2, requestParams, z, false, requestCallBack);
    }

    public HttpHandler<File> download(HttpRequest.HttpMethod httpMethod, String str, String str2, RequestParams requestParams, boolean z, boolean z2, RequestCallBack<File> requestCallBack) {
        if (str == null) {
            throw new IllegalArgumentException("url may not be null");
        } else if (str2 == null) {
            throw new IllegalArgumentException("target may not be null");
        } else {
            com.lidroid.xutils.http.client.HttpRequest httpRequest = new com.lidroid.xutils.http.client.HttpRequest(httpMethod, str);
            HttpHandler<File> httpHandler = new HttpHandler<>(this.httpClient, this.httpContext, this.responseTextCharset, requestCallBack);
            httpHandler.setExpiry(this.currentRequestExpiry);
            httpHandler.setHttpRedirectHandler(this.httpRedirectHandler);
            if (requestParams != null) {
                httpRequest.setRequestParams(requestParams, httpHandler);
                httpHandler.setPriority(requestParams.getPriority());
            }
            httpHandler.executeOnExecutor(EXECUTOR, httpRequest, str2, Boolean.valueOf(z), Boolean.valueOf(z2));
            return httpHandler;
        }
    }

    public HttpHandler<File> download(String str, String str2, RequestParams requestParams, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, requestParams, false, false, requestCallBack);
    }

    public HttpHandler<File> download(String str, String str2, RequestParams requestParams, boolean z, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, requestParams, z, false, requestCallBack);
    }

    public HttpHandler<File> download(String str, String str2, RequestParams requestParams, boolean z, boolean z2, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, requestParams, z, z2, requestCallBack);
    }

    public HttpHandler<File> download(String str, String str2, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, (RequestParams) null, false, false, requestCallBack);
    }

    public HttpHandler<File> download(String str, String str2, boolean z, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, (RequestParams) null, z, false, requestCallBack);
    }

    public HttpHandler<File> download(String str, String str2, boolean z, boolean z2, RequestCallBack<File> requestCallBack) {
        return download(HttpRequest.HttpMethod.GET, str, str2, (RequestParams) null, z, z2, requestCallBack);
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public <T> HttpHandler<T> send(HttpRequest.HttpMethod httpMethod, String str, RequestParams requestParams, RequestCallBack<T> requestCallBack) {
        if (str != null) {
            return sendRequest(new com.lidroid.xutils.http.client.HttpRequest(httpMethod, str), requestParams, requestCallBack);
        }
        throw new IllegalArgumentException("url may not be null");
    }

    public <T> HttpHandler<T> send(HttpRequest.HttpMethod httpMethod, String str, RequestCallBack<T> requestCallBack) {
        return send(httpMethod, str, (RequestParams) null, requestCallBack);
    }

    public ResponseStream sendSync(HttpRequest.HttpMethod httpMethod, String str) throws com.lidroid.xutils.exception.HttpException {
        return sendSync(httpMethod, str, (RequestParams) null);
    }

    public ResponseStream sendSync(HttpRequest.HttpMethod httpMethod, String str, RequestParams requestParams) throws com.lidroid.xutils.exception.HttpException {
        if (str != null) {
            return sendSyncRequest(new com.lidroid.xutils.http.client.HttpRequest(httpMethod, str), requestParams);
        }
        throw new IllegalArgumentException("url may not be null");
    }
}
