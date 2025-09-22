package com.alibaba.sdk.android.oss.network;

import b.e;

public class CancellationHandler {
    private volatile e call;
    private volatile boolean isCancelled;

    public void cancel() {
        if (this.call != null) {
            this.call.c();
        }
        this.isCancelled = true;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCall(e eVar) {
        this.call = eVar;
    }
}
