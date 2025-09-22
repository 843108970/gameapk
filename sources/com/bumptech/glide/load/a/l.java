package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1001a = "LocalUriFetcher";

    /* renamed from: b  reason: collision with root package name */
    private final Uri f1002b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f1003c;
    private T d;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f1003c = contentResolver;
        this.f1002b = uri;
    }

    /* access modifiers changed from: protected */
    public abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void a(@NonNull com.bumptech.glide.l lVar, @NonNull d.a<? super T> aVar) {
        try {
            this.d = a(this.f1002b, this.f1003c);
            aVar.a(this.d);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable(f1001a, 3)) {
                Log.d(f1001a, "Failed to open Uri", e);
            }
            aVar.a((Exception) e);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t) throws IOException;

    public final void b() {
        if (this.d != null) {
            try {
                a(this.d);
            } catch (IOException unused) {
            }
        }
    }

    public final void c() {
    }

    @NonNull
    public final a d() {
        return a.LOCAL;
    }
}
