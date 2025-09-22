package com.bumptech.glide.load.b.b;

import android.content.Context;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.d;
import java.io.File;

public final class h extends d {
    public h(Context context) {
        this(context, a.C0012a.f1055b, 262144000);
    }

    public h(Context context, byte b2) {
        this(context, a.C0012a.f1055b, 104857600);
    }

    private h(final Context context, final String str, long j) {
        super((d.a) new d.a() {
            public final File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j);
    }
}
