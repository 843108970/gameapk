package com.bumptech.glide.load.d.e;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;
import com.bumptech.glide.util.a;
import java.io.File;
import java.io.IOException;

public final class d implements l<c> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1357a = "GifEncoder";

    private static boolean a(@NonNull u<c> uVar, @NonNull File file) {
        try {
            a.a(uVar.b().b(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable(f1357a, 5)) {
                return false;
            }
            Log.w(f1357a, "Failed to encode GIF drawable data", e);
            return false;
        }
    }

    @NonNull
    public final c a(@NonNull j jVar) {
        return c.SOURCE;
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull File file, @NonNull j jVar) {
        return a((u) obj, file);
    }
}
