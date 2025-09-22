package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.util.c;
import com.bumptech.glide.util.g;
import java.io.IOException;
import java.io.InputStream;

public final class y implements k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final o f1332a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1333b;

    static class a implements o.a {

        /* renamed from: a  reason: collision with root package name */
        private final v f1334a;

        /* renamed from: b  reason: collision with root package name */
        private final c f1335b;

        a(v vVar, c cVar) {
            this.f1334a = vVar;
            this.f1335b = cVar;
        }

        public final void a() {
            this.f1334a.a();
        }

        public final void a(e eVar, Bitmap bitmap) throws IOException {
            IOException iOException = this.f1335b.f1495a;
            if (iOException != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw iOException;
            }
        }
    }

    public y(o oVar, b bVar) {
        this.f1332a = oVar;
        this.f1333b = bVar;
    }

    /* access modifiers changed from: private */
    public u<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull j jVar) throws IOException {
        v vVar;
        boolean z;
        if (inputStream instanceof v) {
            vVar = (v) inputStream;
            z = false;
        } else {
            vVar = new v(inputStream, this.f1333b);
            z = true;
        }
        c a2 = c.a(vVar);
        try {
            return this.f1332a.a((InputStream) new g(a2), i, i2, jVar, (o.a) new a(vVar, a2));
        } finally {
            a2.a();
            if (z) {
                vVar.b();
            }
        }
    }

    private static boolean a() {
        return o.a();
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return o.a();
    }
}
