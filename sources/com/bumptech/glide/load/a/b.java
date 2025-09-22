package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.bumptech.glide.l;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.a.d;
import java.io.IOException;

public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f983a = "AssetPathFetcher";

    /* renamed from: b  reason: collision with root package name */
    private final String f984b;

    /* renamed from: c  reason: collision with root package name */
    private final AssetManager f985c;
    private T d;

    public b(AssetManager assetManager, String str) {
        this.f985c = assetManager;
        this.f984b = str;
    }

    /* access modifiers changed from: protected */
    public abstract T a(AssetManager assetManager, String str) throws IOException;

    public final void a(@NonNull l lVar, @NonNull d.a<? super T> aVar) {
        try {
            this.d = a(this.f985c, this.f984b);
            aVar.a(this.d);
        } catch (IOException e) {
            if (Log.isLoggable(f983a, 3)) {
                Log.d(f983a, "Failed to load data from asset manager", e);
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
