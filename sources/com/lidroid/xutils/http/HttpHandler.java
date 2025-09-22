package com.lidroid.xutils.http;

import android.os.SystemClock;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.task.PriorityAsyncTask;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class HttpHandler<T> extends PriorityAsyncTask<Object, Object, Void> implements RequestCallBackHandler {
    private static final int UPDATE_FAILURE = 3;
    private static final int UPDATE_LOADING = 2;
    private static final int UPDATE_START = 1;
    private static final int UPDATE_SUCCESS = 4;
    private static final NotUseApacheRedirectHandler notUseApacheRedirectHandler = new NotUseApacheRedirectHandler((NotUseApacheRedirectHandler) null);
    private boolean autoRename = false;
    private boolean autoResume = false;
    private RequestCallBack<T> callback;
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private long expiry = HttpCache.getDefaultExpiryTime();
    private String fileSavePath = null;
    private HttpRedirectHandler httpRedirectHandler;
    private boolean isDownloadingFile = false;
    private boolean isUploading = true;
    private long lastUpdateTime;
    private HttpRequestBase request;
    private String requestMethod;
    private String requestUrl;
    private int retriedCount = 0;
    private State state = State.WAITING;

    private static final class NotUseApacheRedirectHandler implements RedirectHandler {
        private NotUseApacheRedirectHandler() {
        }

        /* synthetic */ NotUseApacheRedirectHandler(NotUseApacheRedirectHandler notUseApacheRedirectHandler) {
            this();
        }

        public final URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
            return null;
        }

        public final boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return false;
        }
    }

    public enum State {
        WAITING(0),
        STARTED(1),
        LOADING(2),
        FAILURE(3),
        CANCELLED(4),
        SUCCESS(5);
        
        private int value;

        private State(int i) {
            this.value = 0;
            this.value = i;
        }

        public static State valueOf(int i) {
            switch (i) {
                case 0:
                    return WAITING;
                case 1:
                    return STARTED;
                case 2:
                    return LOADING;
                case 3:
                    return FAILURE;
                case 4:
                    return CANCELLED;
                case 5:
                    return SUCCESS;
                default:
                    return FAILURE;
            }
        }

        public final int value() {
            return this.value;
        }
    }

    public HttpHandler(AbstractHttpClient abstractHttpClient, HttpContext httpContext, String str, RequestCallBack<T> requestCallBack) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.callback = requestCallBack;
        this.charset = str;
        this.client.setRedirectHandler(notUseApacheRedirectHandler);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.lidroid.xutils.http.ResponseInfo<T> handleResponse(org.apache.http.HttpResponse r11) throws com.lidroid.xutils.exception.HttpException, java.io.IOException {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x000a
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = "response is null"
            r11.<init>((java.lang.String) r0)
            throw r11
        L_0x000a:
            boolean r0 = r10.isCancelled()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            return r1
        L_0x0012:
            org.apache.http.StatusLine r0 = r11.getStatusLine()
            int r2 = r0.getStatusCode()
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 >= r3) goto L_0x0079
            org.apache.http.HttpEntity r5 = r11.getEntity()
            r0 = 0
            if (r5 == 0) goto L_0x0073
            r10.isUploading = r0
            boolean r2 = r10.isDownloadingFile
            if (r2 == 0) goto L_0x0052
            boolean r2 = r10.autoResume
            if (r2 == 0) goto L_0x0037
            boolean r2 = com.lidroid.xutils.util.OtherUtils.isSupportRange(r11)
            if (r2 == 0) goto L_0x0037
            r2 = 1
            goto L_0x0038
        L_0x0037:
            r2 = 0
        L_0x0038:
            r10.autoResume = r2
            boolean r2 = r10.autoRename
            if (r2 == 0) goto L_0x0042
            java.lang.String r1 = com.lidroid.xutils.util.OtherUtils.getFileNameFromHttpResponse(r11)
        L_0x0042:
            r9 = r1
            com.lidroid.xutils.http.callback.FileDownloadHandler r4 = new com.lidroid.xutils.http.callback.FileDownloadHandler
            r4.<init>()
            java.lang.String r7 = r10.fileSavePath
            boolean r8 = r10.autoResume
            r6 = r10
            java.io.File r1 = r4.handleEntity(r5, r6, r7, r8, r9)
            goto L_0x0073
        L_0x0052:
            com.lidroid.xutils.http.callback.StringDownloadHandler r1 = new com.lidroid.xutils.http.callback.StringDownloadHandler
            r1.<init>()
            java.lang.String r2 = r10.charset
            java.lang.String r1 = r1.handleEntity(r5, r10, r2)
            com.lidroid.xutils.http.HttpCache r2 = com.lidroid.xutils.HttpUtils.sHttpCache
            java.lang.String r3 = r10.requestMethod
            boolean r2 = r2.isEnabled((java.lang.String) r3)
            if (r2 == 0) goto L_0x0073
            com.lidroid.xutils.http.HttpCache r2 = com.lidroid.xutils.HttpUtils.sHttpCache
            java.lang.String r3 = r10.requestUrl
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            long r5 = r10.expiry
            r2.put(r3, r4, r5)
        L_0x0073:
            com.lidroid.xutils.http.ResponseInfo r2 = new com.lidroid.xutils.http.ResponseInfo
            r2.<init>(r11, r1, r0)
            return r2
        L_0x0079:
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0098
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 != r3) goto L_0x0082
            goto L_0x0098
        L_0x0082:
            r11 = 416(0x1a0, float:5.83E-43)
            if (r2 != r11) goto L_0x008e
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = "maybe the file has downloaded completely"
            r11.<init>((int) r2, (java.lang.String) r0)
            throw r11
        L_0x008e:
            com.lidroid.xutils.exception.HttpException r11 = new com.lidroid.xutils.exception.HttpException
            java.lang.String r0 = r0.getReasonPhrase()
            r11.<init>((int) r2, (java.lang.String) r0)
            throw r11
        L_0x0098:
            com.lidroid.xutils.http.callback.HttpRedirectHandler r0 = r10.httpRedirectHandler
            if (r0 != 0) goto L_0x00a3
            com.lidroid.xutils.http.callback.DefaultHttpRedirectHandler r0 = new com.lidroid.xutils.http.callback.DefaultHttpRedirectHandler
            r0.<init>()
            r10.httpRedirectHandler = r0
        L_0x00a3:
            com.lidroid.xutils.http.callback.HttpRedirectHandler r0 = r10.httpRedirectHandler
            org.apache.http.client.methods.HttpRequestBase r11 = r0.getDirectRequest(r11)
            if (r11 == 0) goto L_0x00b0
            com.lidroid.xutils.http.ResponseInfo r11 = r10.sendRequest(r11)
            return r11
        L_0x00b0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.HttpHandler.handleResponse(org.apache.http.HttpResponse):com.lidroid.xutils.http.ResponseInfo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.lidroid.xutils.http.ResponseInfo<T> sendRequest(org.apache.http.client.methods.HttpRequestBase r7) throws com.lidroid.xutils.exception.HttpException {
        /*
            r6 = this;
            org.apache.http.impl.client.AbstractHttpClient r0 = r6.client
            org.apache.http.client.HttpRequestRetryHandler r0 = r0.getHttpRequestRetryHandler()
        L_0x0006:
            boolean r1 = r6.autoResume
            if (r1 == 0) goto L_0x0045
            boolean r1 = r6.isDownloadingFile
            if (r1 == 0) goto L_0x0045
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r6.fileSavePath
            r1.<init>(r2)
            boolean r2 = r1.isFile()
            r3 = 0
            if (r2 == 0) goto L_0x0028
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x0028
            long r1 = r1.length()
            goto L_0x0029
        L_0x0028:
            r1 = r3
        L_0x0029:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0045
            java.lang.String r3 = "RANGE"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "bytes="
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = "-"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r7.setHeader(r3, r1)
        L_0x0045:
            r1 = 1
            java.lang.String r2 = r7.getMethod()     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            r6.requestMethod = r2     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            com.lidroid.xutils.http.HttpCache r2 = com.lidroid.xutils.HttpUtils.sHttpCache     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            java.lang.String r3 = r6.requestMethod     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            boolean r2 = r2.isEnabled((java.lang.String) r3)     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            r3 = 0
            if (r2 == 0) goto L_0x0067
            com.lidroid.xutils.http.HttpCache r2 = com.lidroid.xutils.HttpUtils.sHttpCache     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            java.lang.String r4 = r6.requestUrl     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            java.lang.String r2 = r2.get(r4)     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            if (r2 == 0) goto L_0x0067
            com.lidroid.xutils.http.ResponseInfo r4 = new com.lidroid.xutils.http.ResponseInfo     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            r4.<init>(r3, r2, r1)     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            return r4
        L_0x0067:
            boolean r2 = r6.isCancelled()     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            if (r2 != 0) goto L_0x0079
            org.apache.http.impl.client.AbstractHttpClient r2 = r6.client     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            org.apache.http.protocol.HttpContext r3 = r6.context     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            org.apache.http.HttpResponse r2 = r2.execute(r7, r3)     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
            com.lidroid.xutils.http.ResponseInfo r3 = r6.handleResponse(r2)     // Catch:{ IOException | UnknownHostException -> 0x0095, NullPointerException -> 0x0087, HttpException -> 0x0085, Throwable -> 0x007a }
        L_0x0079:
            return r3
        L_0x007a:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = r2.getMessage()
            r3.<init>(r4)
            goto L_0x0091
        L_0x0085:
            r7 = move-exception
            throw r7
        L_0x0087:
            r2 = move-exception
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = r2.getMessage()
            r3.<init>(r4)
        L_0x0091:
            r3.initCause(r2)
            goto L_0x0097
        L_0x0095:
            r2 = move-exception
            r3 = r2
        L_0x0097:
            int r2 = r6.retriedCount
            int r2 = r2 + r1
            r6.retriedCount = r2
            org.apache.http.protocol.HttpContext r1 = r6.context
            boolean r1 = r0.retryRequest(r3, r2, r1)
            if (r1 != 0) goto L_0x0006
            com.lidroid.xutils.exception.HttpException r7 = new com.lidroid.xutils.exception.HttpException
            r7.<init>((java.lang.Throwable) r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.http.HttpHandler.sendRequest(org.apache.http.client.methods.HttpRequestBase):com.lidroid.xutils.http.ResponseInfo");
    }

    public void cancel() {
        this.state = State.CANCELLED;
        if (this.request != null && !this.request.isAborted()) {
            try {
                this.request.abort();
            } catch (Throwable unused) {
            }
        }
        if (!isCancelled()) {
            try {
                cancel(true);
            } catch (Throwable unused2) {
            }
        }
        if (this.callback != null) {
            this.callback.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public Void doInBackground(Object... objArr) {
        if (this.state == State.CANCELLED || objArr == null || objArr.length == 0) {
            return null;
        }
        if (objArr.length > 3) {
            this.fileSavePath = String.valueOf(objArr[1]);
            this.isDownloadingFile = this.fileSavePath != null;
            this.autoResume = objArr[2].booleanValue();
            this.autoRename = objArr[3].booleanValue();
        }
        try {
            if (this.state == State.CANCELLED) {
                return null;
            }
            this.request = objArr[0];
            this.requestUrl = this.request.getURI().toString();
            if (this.callback != null) {
                this.callback.setRequestUrl(this.requestUrl);
            }
            publishProgress(1);
            this.lastUpdateTime = SystemClock.uptimeMillis();
            ResponseInfo sendRequest = sendRequest(this.request);
            if (sendRequest != null) {
                publishProgress(4, sendRequest);
                return null;
            }
            return null;
        } catch (HttpException e) {
            publishProgress(3, e, e.getMessage());
        }
    }

    public RequestCallBack<T> getRequestCallBack() {
        return this.callback;
    }

    public State getState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Object... objArr) {
        if (this.state != State.CANCELLED && objArr != null && objArr.length != 0 && this.callback != null) {
            switch (objArr[0].intValue()) {
                case 1:
                    this.state = State.STARTED;
                    this.callback.onStart();
                    return;
                case 2:
                    if (objArr.length == 3) {
                        this.state = State.LOADING;
                        this.callback.onLoading(Long.valueOf(String.valueOf(objArr[1])).longValue(), Long.valueOf(String.valueOf(objArr[2])).longValue(), this.isUploading);
                        return;
                    }
                    return;
                case 3:
                    if (objArr.length == 3) {
                        this.state = State.FAILURE;
                        this.callback.onFailure(objArr[1], objArr[2]);
                        return;
                    }
                    return;
                case 4:
                    if (objArr.length == 2) {
                        this.state = State.SUCCESS;
                        this.callback.onSuccess(objArr[1]);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setExpiry(long j) {
        this.expiry = j;
    }

    public void setHttpRedirectHandler(HttpRedirectHandler httpRedirectHandler2) {
        if (httpRedirectHandler2 != null) {
            this.httpRedirectHandler = httpRedirectHandler2;
        }
    }

    public void setRequestCallBack(RequestCallBack<T> requestCallBack) {
        this.callback = requestCallBack;
    }

    public boolean updateProgress(long j, long j2, boolean z) {
        Object[] objArr;
        if (!(this.callback == null || this.state == State.CANCELLED)) {
            if (z) {
                objArr = new Object[]{2, Long.valueOf(j), Long.valueOf(j2)};
            } else {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.lastUpdateTime >= ((long) this.callback.getRate())) {
                    this.lastUpdateTime = uptimeMillis;
                    objArr = new Object[]{2, Long.valueOf(j), Long.valueOf(j2)};
                }
            }
            publishProgress(objArr);
        }
        return this.state != State.CANCELLED;
    }
}
