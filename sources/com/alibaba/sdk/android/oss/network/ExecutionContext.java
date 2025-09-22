package com.alibaba.sdk.android.oss.network;

import android.content.Context;
import b.z;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ExecutionContext<T extends OSSRequest> {
    private Context applicationContext;
    private CancellationHandler cancellationHandler;
    private z client;
    private OSSCompletedCallback completedCallback;
    private OSSProgressCallback progressCallback;
    private T request;
    private OSSRetryCallback retryCallback;

    public ExecutionContext(z zVar, T t) {
        this(zVar, t, (Context) null);
    }

    public ExecutionContext(z zVar, T t, Context context) {
        this.cancellationHandler = new CancellationHandler();
        setClient(zVar);
        setRequest(t);
        this.applicationContext = context;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public z getClient() {
        return this.client;
    }

    public OSSCompletedCallback getCompletedCallback() {
        return this.completedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public T getRequest() {
        return this.request;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setClient(z zVar) {
        this.client = zVar;
    }

    public void setCompletedCallback(OSSCompletedCallback oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRequest(T t) {
        this.request = t;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }
}
