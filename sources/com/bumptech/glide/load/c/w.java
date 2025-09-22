package com.bumptech.glide.load.c;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.a.i;
import com.bumptech.glide.load.a.n;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f1277a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", com.umeng.analytics.pro.b.W})));

    /* renamed from: b  reason: collision with root package name */
    private final c<Data> f1278b;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1279a;

        public a(ContentResolver contentResolver) {
            this.f1279a = contentResolver;
        }

        public final com.bumptech.glide.load.a.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.a.a(this.f1279a, uri);
        }

        public final n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public final void a() {
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1280a;

        public b(ContentResolver contentResolver) {
            this.f1280a = contentResolver;
        }

        public final com.bumptech.glide.load.a.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f1280a, uri);
        }

        @NonNull
        public final n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public final void a() {
        }
    }

    public interface c<Data> {
        com.bumptech.glide.load.a.d<Data> a(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f1281a;

        public d(ContentResolver contentResolver) {
            this.f1281a = contentResolver;
        }

        public final com.bumptech.glide.load.a.d<InputStream> a(Uri uri) {
            return new n(this.f1281a, uri);
        }

        @NonNull
        public final n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }

        public final void a() {
        }
    }

    public w(c<Data> cVar) {
        this.f1278b = cVar;
    }

    private n.a<Data> a(@NonNull Uri uri) {
        return new n.a<>(new com.bumptech.glide.f.d(uri), this.f1278b.a(uri));
    }

    private static boolean b(@NonNull Uri uri) {
        return f1277a.contains(uri.getScheme());
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), this.f1278b.a(uri));
    }

    public final /* synthetic */ boolean a(@NonNull Object obj) {
        return f1277a.contains(((Uri) obj).getScheme());
    }
}
