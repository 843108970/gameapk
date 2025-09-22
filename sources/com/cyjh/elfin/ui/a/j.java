package com.cyjh.elfin.ui.a;

import android.view.View;
import java.io.File;

final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final h f2127a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2128b;

    j(h hVar, File file) {
        this.f2127a = hVar;
        this.f2128b = file;
    }

    public final void onClick(View view) {
        this.f2127a.d(this.f2128b);
    }
}
