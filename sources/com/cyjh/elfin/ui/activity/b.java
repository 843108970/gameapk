package com.cyjh.elfin.ui.activity;

import com.cyjh.common.util.ag;
import com.cyjh.elfin.ui.activity.SettingActivity;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SettingActivity.AnonymousClass1 f2206a;

    /* renamed from: b  reason: collision with root package name */
    private final com.cyjh.common.d.b f2207b;

    b(SettingActivity.AnonymousClass1 r1, com.cyjh.common.d.b bVar) {
        this.f2206a = r1;
        this.f2207b = bVar;
    }

    public final void run() {
        SettingActivity.AnonymousClass1 r0 = this.f2206a;
        this.f2207b.dismiss();
        ag.a(SettingActivity.this.getApplicationContext(), "文字识别库下载失败！");
        SettingActivity.this.k.setClickable(true);
        SettingActivity.this.k.setChecked(false);
    }
}
