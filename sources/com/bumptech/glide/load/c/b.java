package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0017b<Data> f1205a;

    public static class a implements o<byte[], ByteBuffer> {
        @NonNull
        public final n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new C0017b<ByteBuffer>() {
                private static ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                public final Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                public final /* synthetic */ Object a(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }

        public final void a() {
        }
    }

    /* renamed from: com.bumptech.glide.load.c.b$b  reason: collision with other inner class name */
    public interface C0017b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    private static class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f1207a;

        /* renamed from: b  reason: collision with root package name */
        private final C0017b<Data> f1208b;

        c(byte[] bArr, C0017b<Data> bVar) {
            this.f1207a = bArr;
            this.f1208b = bVar;
        }

        @NonNull
        public final Class<Data> a() {
            return this.f1208b.a();
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super Data> aVar) {
            aVar.a(this.f1208b.a(this.f1207a));
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

    public static class d implements o<byte[], InputStream> {
        @NonNull
        public final n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new C0017b<InputStream>() {
                private static InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                public final Class<InputStream> a() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object a(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }

        public final void a() {
        }
    }

    public b(C0017b<Data> bVar) {
        this.f1205a = bVar;
    }

    private n.a<Data> a(@NonNull byte[] bArr) {
        return new n.a<>(new com.bumptech.glide.f.d(bArr), new c(bArr, this.f1205a));
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        byte[] bArr = (byte[]) obj;
        return new n.a(new com.bumptech.glide.f.d(bArr), new c(bArr, this.f1205a));
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}
