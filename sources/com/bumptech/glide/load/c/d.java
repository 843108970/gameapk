package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d implements n<File, ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1211a = "ByteBufferFileLoader";

    private static final class a implements com.bumptech.glide.load.a.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f1212a;

        a(File file) {
            this.f1212a = file;
        }

        @NonNull
        public final Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.bumptech.glide.util.a.a(this.f1212a));
            } catch (IOException e) {
                if (Log.isLoggable(d.f1211a, 3)) {
                    Log.d(d.f1211a, "Failed to obtain ByteBuffer for file", e);
                }
                aVar.a((Exception) e);
            }
        }

        public final void b() {
        }

        public final void c() {
        }

        @NonNull
        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static class b implements o<File, ByteBuffer> {
        @NonNull
        public final n<File, ByteBuffer> a(@NonNull r rVar) {
            return new d();
        }

        public final void a() {
        }
    }

    private static n.a<ByteBuffer> a(@NonNull File file) {
        return new n.a<>(new com.bumptech.glide.f.d(file), new a(file));
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        File file = (File) obj;
        return new n.a(new com.bumptech.glide.f.d(file), new a(file));
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}
