package com.zbar.a.b;

import android.app.Activity;
import android.content.DialogInterface;

public final class d implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f4007a;

    public d(Activity activity) {
        this.f4007a = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public final void run() {
        this.f4007a.finish();
    }
}
