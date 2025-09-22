package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.File;
import java.io.InputStream;

public final class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f1273a;

    public static final class a implements o<String, AssetFileDescriptor> {
        public final n<String, AssetFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.b(Uri.class, AssetFileDescriptor.class));
        }

        public final void a() {
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @NonNull
        public final n<String, ParcelFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.b(Uri.class, ParcelFileDescriptor.class));
        }

        public final void a() {
        }
    }

    public static class c implements o<String, InputStream> {
        @NonNull
        public final n<String, InputStream> a(@NonNull r rVar) {
            return new u(rVar.b(Uri.class, InputStream.class));
        }

        public final void a() {
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f1273a = nVar;
    }

    @Nullable
    private static Uri a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null) {
                return parse;
            }
        }
        return b(str);
    }

    private n.a<Data> a(@NonNull String str, int i, int i2, @NonNull j jVar) {
        Uri uri;
        if (TextUtils.isEmpty(str)) {
            uri = null;
        } else {
            if (str.charAt(0) != '/') {
                Uri parse = Uri.parse(str);
                if (parse.getScheme() != null) {
                    uri = parse;
                }
            }
            uri = b(str);
        }
        if (uri == null || !this.f1273a.a(uri)) {
            return null;
        }
        return this.f1273a.a(uri, i, i2, jVar);
    }

    private static boolean a() {
        return true;
    }

    private static Uri b(String str) {
        return Uri.fromFile(new File(str));
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri;
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            uri = null;
        } else {
            if (str.charAt(0) != '/') {
                Uri parse = Uri.parse(str);
                if (parse.getScheme() != null) {
                    uri = parse;
                }
            }
            uri = b(str);
        }
        if (uri == null || !this.f1273a.a(uri)) {
            return null;
        }
        return this.f1273a.a(uri, i, i2, jVar);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}
