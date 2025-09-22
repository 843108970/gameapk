package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.manager.k;
import com.cyjh.elfin.base.glidemodule.CustomGlideModule;
import java.util.Collections;
import java.util.Set;

final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final CustomGlideModule f912a = new CustomGlideModule();

    c() {
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Discovered AppGlideModule from annotation: com.cyjh.elfin.base.glidemodule.CustomGlideModule");
        }
    }

    @NonNull
    private static d e() {
        return new d();
    }

    @NonNull
    public final Set<Class<?>> a() {
        return Collections.emptySet();
    }

    public final void a(@NonNull Context context, @NonNull g gVar) {
        this.f912a.a(context, gVar);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final /* synthetic */ k.a b() {
        return new d();
    }

    public final void c() {
    }

    public final boolean d() {
        return false;
    }
}
