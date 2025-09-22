package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1213a = "data:image";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1214b = ";base64";

    /* renamed from: c  reason: collision with root package name */
    private final a<Data> f1215c;

    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    private static final class b<Data> implements d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f1216a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f1217b;

        /* renamed from: c  reason: collision with root package name */
        private Data f1218c;

        b(String str, a<Data> aVar) {
            this.f1216a = str;
            this.f1217b = aVar;
        }

        @NonNull
        public final Class<Data> a() {
            return this.f1217b.a();
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f1218c = this.f1217b.a(this.f1216a);
                aVar.a(this.f1218c);
            } catch (IllegalArgumentException e) {
                aVar.a((Exception) e);
            }
        }

        public final void b() {
            try {
                this.f1217b.a(this.f1218c);
            } catch (IOException unused) {
            }
        }

        public final void c() {
        }

        @NonNull
        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f1219a = new a<InputStream>() {
            private static void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            private static InputStream b(String str) {
                if (!str.startsWith(e.f1213a)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                } else if (str.substring(0, indexOf).endsWith(e.f1214b)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                } else {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
            }

            public final Class<InputStream> a() {
                return InputStream.class;
            }

            public final /* synthetic */ Object a(String str) throws IllegalArgumentException {
                if (!str.startsWith(e.f1213a)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int indexOf = str.indexOf(44);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                } else if (str.substring(0, indexOf).endsWith(e.f1214b)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                } else {
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
            }

            public final /* synthetic */ void a(Object obj) throws IOException {
                ((InputStream) obj).close();
            }
        };

        @NonNull
        public final n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.f1219a);
        }

        public final void a() {
        }
    }

    public e(a<Data> aVar) {
        this.f1215c = aVar;
    }

    public final n.a<Data> a(@NonNull Model model, int i, int i2, @NonNull j jVar) {
        return new n.a<>(new com.bumptech.glide.f.d(model), new b(model.toString(), this.f1215c));
    }

    public final boolean a(@NonNull Model model) {
        return model.toString().startsWith(f1213a);
    }
}
