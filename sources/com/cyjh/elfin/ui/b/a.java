package com.cyjh.elfin.ui.b;

import android.app.AlertDialog;
import android.view.View;

public abstract class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public AlertDialog f2248b;

    /* renamed from: c  reason: collision with root package name */
    public int f2249c;

    private void a(int i) {
        this.f2249c = i;
    }

    private void a(AlertDialog alertDialog) {
        this.f2248b = alertDialog;
    }

    public abstract void a();

    public abstract void b();

    public void onClick(View view) {
        if (this.f2249c == 0) {
            b();
        } else {
            a();
        }
        this.f2248b.dismiss();
    }
}
