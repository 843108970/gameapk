package com.cyjh.elfin.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.cyjh.common.util.r;
import com.cyjh.elfin.base.AppContext;
import com.cyjh.elfin.d.c;
import com.cyjh.elfin.entity.MsgItem;
import com.cyjh.http.bean.response.RegCodeInfoResponse;
import com.cyjh.http.bean.response.RegCodeStatusInfo;
import com.cyjh.http.c.c.p;
import com.cyjh.http.c.d.i;
import com.cyjh.http.e.a;

public class UnRegCodeModel extends AndroidViewModel implements i {

    /* renamed from: a  reason: collision with root package name */
    public p f2305a;

    /* renamed from: b  reason: collision with root package name */
    public String f2306b;

    /* renamed from: c  reason: collision with root package name */
    public MutableLiveData<RegCodeInfoResponse> f2307c = new MutableLiveData<>();

    public UnRegCodeModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<RegCodeInfoResponse> a() {
        return this.f2307c;
    }

    private void b(String str) {
        if (this.f2305a == null) {
            this.f2305a = new p(this);
        }
        this.f2306b = str;
        this.f2305a.a(str, AppContext.a());
    }

    public final void a(RegCodeInfoResponse regCodeInfoResponse) {
        if (regCodeInfoResponse.Code == 200) {
            String b2 = c.a().b();
            if (!TextUtils.isEmpty(b2) && TextUtils.equals(b2, this.f2306b)) {
                org.greenrobot.eventbus.c.a().c((Object) new MsgItem.BindRegCodeBus(-1));
                RegCodeStatusInfo regCodeStatusInfo = new RegCodeStatusInfo();
                regCodeStatusInfo.status = 2;
                regCodeStatusInfo.regCode = this.f2306b;
                String a2 = r.a((Object) regCodeStatusInfo);
                AppContext a3 = AppContext.a();
                a.a((Context) a3, com.cyjh.common.b.a.ay + com.cyjh.common.a.a.c(), a2);
            }
        }
        this.f2307c.postValue(regCodeInfoResponse);
    }

    public final void a(String str) {
        this.f2307c.postValue(new RegCodeInfoResponse(-1, str));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        if (this.f2305a != null) {
            com.cyjh.http.d.b.c.a().a((Object) this.f2305a.getClass().getCanonicalName());
        }
    }
}
