package com.bumptech.glide.load.b.b;

import android.content.Context;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.d;
import java.io.File;

public final class g extends d {
    private g(Context context) {
        this(context, a.C0012a.f1055b, 262144000);
    }

    private g(Context context, long j) {
        this(context, a.C0012a.f1055b, j);
    }

    private g(final Context context, final String str, long j) {
        super((d.a) new d.a() {
            @Nullable
            private File b() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            public final File a() {
                File externalCacheDir;
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    cacheDir = null;
                } else if (str != null) {
                    cacheDir = new File(cacheDir, str);
                }
                return ((cacheDir == null || !cacheDir.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? str != null ? new File(externalCacheDir, str) : externalCacheDir : cacheDir;
            }
        }, j);
    }
}
