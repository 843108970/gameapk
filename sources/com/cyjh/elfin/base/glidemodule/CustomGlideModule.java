package com.cyjh.elfin.base.glidemodule;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.d.a;
import com.bumptech.glide.g;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.b.i;

public class CustomGlideModule extends a {
    public final void a(@NonNull Context context, @NonNull g gVar) {
        gVar.e = new i(20971520);
        gVar.h = new h(context, (byte) 0);
    }

    public final boolean d() {
        return false;
    }
}
