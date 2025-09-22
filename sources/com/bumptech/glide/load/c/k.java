package com.bumptech.glide.load.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1235a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1236a;

        public a(Context context) {
            this.f1236a = context;
        }

        @NonNull
        public final n<Uri, File> a(r rVar) {
            return new k(this.f1236a);
        }

        public final void a() {
        }
    }

    private static class b implements d<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f1237a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f1238b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f1239c;

        b(Context context, Uri uri) {
            this.f1238b = context;
            this.f1239c = uri;
        }

        @NonNull
        public final Class<File> a() {
            return File.class;
        }

        public final void a(@NonNull l lVar, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f1238b.getContentResolver().query(this.f1239c, f1237a, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f1239c));
                return;
            }
            aVar.a(new File(str));
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

    public k(Context context) {
        this.f1235a = context;
    }

    private n.a<File> a(@NonNull Uri uri) {
        return new n.a<>(new com.bumptech.glide.f.d(uri), new b(this.f1235a, uri));
    }

    private static boolean b(@NonNull Uri uri) {
        return com.bumptech.glide.load.a.a.b.a(uri);
    }

    public final /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri uri = (Uri) obj;
        return new n.a(new com.bumptech.glide.f.d(uri), new b(this.f1235a, uri));
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return com.bumptech.glide.load.a.a.b.a((Uri) obj);
    }
}
