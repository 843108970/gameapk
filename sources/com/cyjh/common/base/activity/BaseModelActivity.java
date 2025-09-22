package com.cyjh.common.base.activity;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseModelActivity<T extends AndroidViewModel> extends BaseActivity {

    /* renamed from: b  reason: collision with root package name */
    protected T f1628b;

    public abstract Class<T> b();

    public abstract void c();

    public abstract void d();

    public abstract int e();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e());
        d();
        this.f1628b = (AndroidViewModel) ViewModelProviders.of((FragmentActivity) this).get(b());
        c();
    }
}
