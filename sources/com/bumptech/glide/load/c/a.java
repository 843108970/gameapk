package com.bumptech.glide.load.c;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.h;
import com.bumptech.glide.load.a.m;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.InputStream;

public final class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1188a = "android_asset";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1189b = "file:///android_asset/";

    /* renamed from: c  reason: collision with root package name */
    private static final int f1190c = 22;
    private final AssetManager d;
    private final C0016a<Data> e;

    /* renamed from: com.bumptech.glide.load.c.a$a  reason: collision with other inner class name */
    public interface C0016a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements C0016a<ParcelFileDescriptor>, o<Uri, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f1193a;

        public b(AssetManager assetManager) {
            this.f1193a = assetManager;
        }

        public final d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        @NonNull
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f1193a, this);
        }

        public final void a() {
        }
    }

    public static class c implements C0016a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f1197a;

        public c(AssetManager assetManager) {
            this.f1197a = assetManager;
        }

        public final d<InputStream> a(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        @NonNull
        public final n<Uri, InputStream> a(r rVar) {
            return new a(this.f1197a, this);
        }

        public final void a() {
        }
    }

    public a(AssetManager assetManager, C0016a<Data> aVar) {
        this.d = assetManager;
        this.e = aVar;
    }

    private n.a<Data> a(@NonNull Uri uri) {
        return new n.a<>(new com.bumptech.glide.f.d(uri), this.e.a(this.d, uri.toString().substring(f1190c)));
    }

    private static boolean b(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f1188a.equals(uri.getPathSegments().get(0));
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), this.e.a(this.d, uri.toString().substring(f1190c)));
    }

    public final /* synthetic */ boolean a(@NonNull Object obj) {
        Uri uri = (Uri) obj;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f1188a.equals(uri.getPathSegments().get(0));
    }
}
