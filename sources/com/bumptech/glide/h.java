package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Map;

public final class h extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final p<?, ?> f959a = new e();

    /* renamed from: b  reason: collision with root package name */
    final Handler f960b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final b f961c;
    public final m d;
    final ImageViewTargetFactory e;
    final g f;
    final Map<Class<?>, p<?, ?>> g;
    final j h;
    public final int i;

    public h(@NonNull Context context, @NonNull b bVar, @NonNull m mVar, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull g gVar, @NonNull Map<Class<?>, p<?, ?>> map, @NonNull j jVar, int i2) {
        super(context.getApplicationContext());
        this.f961c = bVar;
        this.d = mVar;
        this.e = imageViewTargetFactory;
        this.f = gVar;
        this.g = map;
        this.h = jVar;
        this.i = i2;
    }

    @NonNull
    private <T> p<?, T> a(@NonNull Class<T> cls) {
        p<?, T> pVar = this.g.get(cls);
        if (pVar == null) {
            for (Map.Entry next : this.g.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    pVar = (p) next.getValue();
                }
            }
        }
        return pVar == null ? f959a : pVar;
    }

    private g a() {
        return this.f;
    }

    @NonNull
    private <X> ViewTarget<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.e.buildTarget(imageView, cls);
    }

    @NonNull
    private Handler b() {
        return this.f960b;
    }

    @NonNull
    private j c() {
        return this.h;
    }

    @NonNull
    private m d() {
        return this.d;
    }

    private int e() {
        return this.i;
    }

    @NonNull
    private b f() {
        return this.f961c;
    }
}
