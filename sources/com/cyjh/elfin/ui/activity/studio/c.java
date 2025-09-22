package com.cyjh.elfin.ui.activity.studio;

import com.cyjh.common.util.ag;
import com.cyjh.elfin.ui.activity.studio.StudioBindClearActivity;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final StudioBindClearActivity.AnonymousClass1 f2236a;

    c(StudioBindClearActivity.AnonymousClass1 r1) {
        this.f2236a = r1;
    }

    public final void run() {
        ag.a(StudioBindClearActivity.this.getApplicationContext(), "解绑成功！");
    }
}
