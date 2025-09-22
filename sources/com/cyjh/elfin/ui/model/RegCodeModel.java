package com.cyjh.elfin.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.cyjh.common.util.ad;
import com.cyjh.common.util.r;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.d.c;
import com.cyjh.elfin.e.c.k;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.http.bean.response.BaseResponseInfo;
import com.cyjh.http.bean.response.BindRegCodeResponse;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.cyjh.http.bean.response.RegCodeStatusInfo;
import com.cyjh.http.c.c.e;
import com.cyjh.http.c.c.n;
import com.cyjh.http.c.d.b;
import com.cyjh.http.c.d.g;
import com.cyjh.http.e.a;
import com.elfin.engin.d;

public class RegCodeModel extends AndroidViewModel implements b, g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f2279c = "RegCodeModel";

    /* renamed from: a  reason: collision with root package name */
    public MutableLiveData<BaseResponseInfo> f2280a = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    public MutableLiveData<RegCodeInfoResponse> f2281b = new MutableLiveData<>();
    private e d;
    private n e;
    /* access modifiers changed from: private */
    public String f;

    public RegCodeModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<BaseResponseInfo> a() {
        return this.f2280a;
    }

    private MutableLiveData<RegCodeInfoResponse> b() {
        return this.f2281b;
    }

    public final void a(BaseResponseInfo baseResponseInfo) {
        c.a().f1865b = 0;
        this.f = "";
        this.f2280a.postValue(baseResponseInfo);
    }

    public final void a(BindRegCodeResponse bindRegCodeResponse) {
        if (200 == bindRegCodeResponse.Code) {
            BindRegCodeResponse.RegCodeTimeInfo regCodeTimeInfo = bindRegCodeResponse.Data;
            long j = regCodeTimeInfo.ExpireTime;
            long j2 = regCodeTimeInfo.ServerTimestamp;
            c.a().f1865b = j;
            ad.c(f2279c, "onBindSuc --> expireTime=" + j + ",serverTimestamp=" + j2 + ",dueTime=" + ((j - j2) / 60));
            com.cyjh.feedback.lib.d.b.a().a(new Runnable() {
                public final void run() {
                    RegCodeStatusInfo regCodeStatusInfo = new RegCodeStatusInfo();
                    regCodeStatusInfo.status = 1;
                    regCodeStatusInfo.regCode = RegCodeModel.this.f;
                    String a2 = r.a((Object) regCodeStatusInfo);
                    Application application = RegCodeModel.this.getApplication();
                    a.a((Context) application, com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), a2);
                    k.a(201);
                }
            });
            c.a().f1864a = this.f;
            org.greenrobot.eventbus.c.a().c((Object) new MsgItem.BindRegCodeBus(j));
            this.f2280a.postValue(new BaseResponseInfo(bindRegCodeResponse.Code, bindRegCodeResponse.Message));
            return;
        }
        a(new BaseResponseInfo(bindRegCodeResponse.Code, bindRegCodeResponse.Message));
        if (bindRegCodeResponse.Code == 1401 && TextUtils.equals(this.f, c.a().b())) {
            Log.e("zzz", "RegisterCodeActivationFragment:onBindSuc注册码过期，清空注册码");
            this.f = "";
            c.a().f1864a = "";
            d.a(c.a().b());
            a.b(com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), (Context) AppContext.a());
        }
    }

    public final void a(RegCodeInfoResponse regCodeInfoResponse) {
        this.f2281b.postValue(regCodeInfoResponse);
    }

    public final void a(String str) {
        if (this.e == null) {
            this.e = new n(this);
        }
        this.e.a(str, c.a().b(), getApplication());
    }

    public final void a(String str, int i) {
        if (this.d == null) {
            this.d = new e(this);
        }
        this.f = str;
        this.d.a(str, getApplication(), i, c.a().b());
    }

    public final void b(String str) {
        this.f2281b.postValue(new RegCodeInfoResponse(0, str));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        if (this.d != null) {
            com.cyjh.http.d.b.c.a().a((Object) this.d.getClass().getCanonicalName());
        }
        if (this.e != null) {
            com.cyjh.http.d.b.c.a().a((Object) this.e.getClass().getCanonicalName());
        }
    }
}
