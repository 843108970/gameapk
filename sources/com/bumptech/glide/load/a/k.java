package com.bumptech.glide.load.a;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d.a.v;
import java.io.IOException;
import java.io.InputStream;

public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f998a = 5242880;

    /* renamed from: b  reason: collision with root package name */
    private final v f999b;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f1000a;

        public a(b bVar) {
            this.f1000a = bVar;
        }

        @NonNull
        private e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f1000a);
        }

        @NonNull
        public final /* synthetic */ e a(Object obj) {
            return new k((InputStream) obj, this.f1000a);
        }

        @NonNull
        public final Class<InputStream> a() {
            return InputStream.class;
        }
    }

    k(InputStream inputStream, b bVar) {
        this.f999b = new v(inputStream, bVar);
        this.f999b.mark(f998a);
    }

    @NonNull
    private InputStream c() throws IOException {
        this.f999b.reset();
        return this.f999b;
    }

    @NonNull
    public final /* synthetic */ Object a() throws IOException {
        this.f999b.reset();
        return this.f999b;
    }

    public final void b() {
        this.f999b.b();
    }
}
