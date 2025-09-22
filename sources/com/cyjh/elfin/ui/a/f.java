package com.cyjh.elfin.ui.a;

import android.content.DialogInterface;

final /* synthetic */ class f implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    private final e f2116a;

    f(e eVar) {
        this.f2116a = eVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        e eVar = this.f2116a;
        if (eVar.f2115a != null) {
            eVar.f2115a.a(101);
        }
    }
}
