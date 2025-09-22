package com.cyjh.elfin.ui.a;

import com.cyjh.common.util.a;
import java.io.File;

final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f2129a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2130b;

    k(h hVar, File file) {
        this.f2129a = hVar;
        this.f2130b = file;
    }

    public final void run() {
        h hVar = this.f2129a;
        File file = this.f2130b;
        try {
            hVar.dismiss();
            a.a(hVar.g, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
