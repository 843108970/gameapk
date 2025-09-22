package com.bumptech.glide.load.a.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.a.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f971a = "MediaStoreThumbFetcher";

    /* renamed from: b  reason: collision with root package name */
    private final Uri f972b;

    /* renamed from: c  reason: collision with root package name */
    private final e f973c;
    private InputStream d;

    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f974b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f975c = "kind = 1 AND image_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f976a;

        public a(ContentResolver contentResolver) {
            this.f976a = contentResolver;
        }

        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f976a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f974b, f975c, new String[]{lastPathSegment}, (String) null);
        }
    }

    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f977b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f978c = "kind = 1 AND video_id = ?";

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f979a;

        public b(ContentResolver contentResolver) {
            this.f979a = contentResolver;
        }

        public final Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f979a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f977b, f978c, new String[]{lastPathSegment}, (String) null);
        }
    }

    @VisibleForTesting
    private c(Uri uri, e eVar) {
        this.f972b = uri;
        this.f973c = eVar;
    }

    private static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(f.b(context).f950c.a(), dVar, f.b(context).d, context.getContentResolver()));
    }

    private static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream e() throws FileNotFoundException {
        InputStream b2 = this.f973c.b(this.f972b);
        int a2 = b2 != null ? this.f973c.a(this.f972b) : -1;
        return a2 != -1 ? new g(b2, a2) : b2;
    }

    @NonNull
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final void a(@NonNull l lVar, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream b2 = this.f973c.b(this.f972b);
            int a2 = b2 != null ? this.f973c.a(this.f972b) : -1;
            if (a2 != -1) {
                b2 = new g(b2, a2);
            }
            this.d = b2;
            aVar.a(this.d);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(f971a, 3)) {
                Log.d(f971a, "Failed to find thumbnail file", e);
            }
            aVar.a((Exception) e);
        }
    }

    public final void b() {
        if (this.d != null) {
            try {
                this.d.close();
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
