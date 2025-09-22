package com.cyjh.elfin.ui.activity;

import android.arch.lifecycle.Observer;
import com.cyjh.elfin.ui.activity.guide.RecognitionGuideActivity;
import com.cyjh.http.bean.response.PhoneConfig;

final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    private final SplashActivity f2209a;

    d(SplashActivity splashActivity) {
        this.f2209a = splashActivity;
    }

    public final void onChanged(Object obj) {
        SplashActivity splashActivity = this.f2209a;
        PhoneConfig phoneConfig = (PhoneConfig) obj;
        if (phoneConfig != null) {
            RecognitionGuideActivity.a(splashActivity, phoneConfig);
            splashActivity.finish();
        }
    }
}
