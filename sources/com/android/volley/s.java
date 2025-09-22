package com.android.volley;

public class s extends Exception {
    public final i networkResponse;
    private long networkTimeMs;

    public s() {
        this.networkResponse = null;
    }

    public s(i iVar) {
        this.networkResponse = iVar;
    }

    public s(String str) {
        super(str);
        this.networkResponse = null;
    }

    public s(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public s(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    /* access modifiers changed from: package-private */
    public void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }
}
