package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1221a = "FileLoader";

    /* renamed from: b  reason: collision with root package name */
    private final d<Data> f1222b;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f1223a;

        public a(d<Data> dVar) {
            this.f1223a = dVar;
        }

        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.f1223a);
        }

        public final void a() {
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                private static void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                private static ParcelFileDescriptor b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                public final Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                public final /* synthetic */ Object a(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }

                public final /* synthetic */ void a(Object obj) throws IOException {
                    ((ParcelFileDescriptor) obj).close();
                }
            });
        }
    }

    private static final class c<Data> implements com.bumptech.glide.load.a.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f1224a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f1225b;

        /* renamed from: c  reason: collision with root package name */
        private Data f1226c;

        c(File file, d<Data> dVar) {
            this.f1224a = file;
            this.f1225b = dVar;
        }

        @NonNull
        public final Class<Data> a() {
            return this.f1225b.a();
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super Data> aVar) {
            try {
                this.f1226c = this.f1225b.a(this.f1224a);
                aVar.a(this.f1226c);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(f.f1221a, 3)) {
                    Log.d(f.f1221a, "Failed to open file", e);
                }
                aVar.a((Exception) e);
            }
        }

        public final void b() {
            if (this.f1226c != null) {
                try {
                    this.f1225b.a(this.f1226c);
                } catch (IOException unused) {
                }
            }
        }

        public final void c() {
        }

        @NonNull
        public final com.bumptech.glide.load.a d() {
            return com.bumptech.glide.load.a.LOCAL;
        }
    }

    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                private static void a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                private static InputStream b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                public final Class<InputStream> a() {
                    return InputStream.class;
                }

                public final /* synthetic */ Object a(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                public final /* synthetic */ void a(Object obj) throws IOException {
                    ((InputStream) obj).close();
                }
            });
        }
    }

    public f(d<Data> dVar) {
        this.f1222b = dVar;
    }

    private n.a<Data> a(@NonNull File file) {
        return new n.a<>(new com.bumptech.glide.f.d(file), new c(file, this.f1222b));
    }

    private static boolean a() {
        return true;
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        File file = (File) obj;
        return new n.a(new com.bumptech.glide.f.d(file), new c(file, this.f1222b));
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}
