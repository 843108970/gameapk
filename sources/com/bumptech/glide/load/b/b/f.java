package com.bumptech.glide.load.b.b;

import android.content.Context;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.d;
import java.io.File;

@Deprecated
public final class f extends d {
    private f(Context context) {
        this(context, a.C0012a.f1055b, a.C0012a.f1054a);
    }

    private f(Context context, int i) {
        this(context, a.C0012a.f1055b, i);
    }

    private f(final Context context, final String str, int i) {
        super((d.a) new d.a() {
            public final File a() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, (long) i);
    }
}
