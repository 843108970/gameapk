package com.cyjh.mobileanjian.ipc.log;

import android.content.Context;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f2563a = "http://api4.mobileanjian.com/api";

    /* renamed from: b  reason: collision with root package name */
    protected Context f2564b;

    /* renamed from: c  reason: collision with root package name */
    protected String f2565c;

    public a(Context context) {
        this.f2564b = context;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public abstract String b();

    public void commit() {
        a();
        HttpUtils httpUtils = new HttpUtils();
        RequestParams requestParams = new RequestParams();
        requestParams.addQueryStringParameter("Data", b());
        httpUtils.send(HttpRequest.HttpMethod.GET, this.f2565c, requestParams, (RequestCallBack) null);
    }
}
