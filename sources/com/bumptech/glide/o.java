package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.i;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.m;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.k;
import java.io.File;
import java.net.URL;
import java.util.Map;

public class o implements k<n<Drawable>>, i {
    private static final g g = g.a((Class<?>) Bitmap.class).n();
    private static final g h = g.a((Class<?>) c.class).n();
    private static final g i = g.a(com.bumptech.glide.load.b.i.f1144c).a(l.LOW).d(true);

    /* renamed from: a  reason: collision with root package name */
    protected final f f1427a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1428b;

    /* renamed from: c  reason: collision with root package name */
    final h f1429c;
    final m d;
    final n e;
    g f;
    private final l j;
    private final Runnable k;
    private final Handler l;
    private final com.bumptech.glide.manager.c m;

    private static class a extends ViewTarget<View, Object> {
        a(@NonNull View view) {
            super(view);
        }

        public final void onResourceReady(@NonNull Object obj, @Nullable f<? super Object> fVar) {
        }
    }

    private static class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final m f1433a;

        b(@NonNull m mVar) {
            this.f1433a = mVar;
        }

        public final void a(boolean z) {
            if (z) {
                m mVar = this.f1433a;
                for (T t : k.a(mVar.f1416a)) {
                    if (!t.d() && !t.f()) {
                        t.b();
                        if (!mVar.f1418c) {
                            t.a();
                        } else {
                            mVar.f1417b.add(t);
                        }
                    }
                }
            }
        }
    }

    public o(@NonNull f fVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
        this(fVar, hVar, lVar, new m(), fVar.f, context);
    }

    private o(f fVar, h hVar, l lVar, m mVar, d dVar, Context context) {
        this.e = new n();
        this.k = new Runnable() {
            public final void run() {
                o.this.f1429c.a(o.this);
            }
        };
        this.l = new Handler(Looper.getMainLooper());
        this.f1427a = fVar;
        this.f1429c = hVar;
        this.j = lVar;
        this.d = mVar;
        this.f1428b = context;
        this.m = dVar.a(context.getApplicationContext(), new b(mVar));
        if (k.d()) {
            this.l.post(this.k);
        } else {
            hVar.a(this);
        }
        hVar.a(this.m);
        a(fVar.f949b.f);
        synchronized (fVar.g) {
            if (fVar.g.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            fVar.g.add(this);
        }
    }

    private void a(@NonNull View view) {
        a((Target<?>) new a(view));
    }

    private void a(@NonNull Target<?> target, @NonNull com.bumptech.glide.request.c cVar) {
        this.e.f1419a.add(target);
        m mVar = this.d;
        mVar.f1416a.add(cVar);
        if (!mVar.f1418c) {
            cVar.a();
            return;
        }
        cVar.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        mVar.f1417b.add(cVar);
    }

    private void c(@NonNull Target<?> target) {
        if (!b(target) && !this.f1427a.a(target) && target.getRequest() != null) {
            com.bumptech.glide.request.c request = target.getRequest();
            target.setRequest((com.bumptech.glide.request.c) null);
            request.b();
        }
    }

    private void d(@NonNull g gVar) {
        this.f = this.f.a(gVar);
    }

    private boolean f() {
        k.a();
        return this.d.f1418c;
    }

    private void g() {
        k.a();
        m mVar = this.d;
        mVar.f1418c = true;
        for (T t : k.a(mVar.f1416a)) {
            if (t.c()) {
                t.b();
                mVar.f1417b.add(t);
            }
        }
    }

    private void h() {
        k.a();
        m mVar = this.d;
        mVar.f1418c = true;
        for (T t : k.a(mVar.f1416a)) {
            if (t.c() || t.d()) {
                t.b();
                mVar.f1417b.add(t);
            }
        }
    }

    private void i() {
        k.a();
        g();
        for (o g2 : this.j.a()) {
            g2.g();
        }
    }

    private void j() {
        k.a();
        m mVar = this.d;
        mVar.f1418c = false;
        for (T t : k.a(mVar.f1416a)) {
            if (!t.d() && !t.c()) {
                t.a();
            }
        }
        mVar.f1417b.clear();
    }

    private void k() {
        k.a();
        j();
        for (o j2 : this.j.a()) {
            j2.j();
        }
    }

    private g l() {
        return this.f;
    }

    @CheckResult
    @NonNull
    public n<Bitmap> a() {
        return a(Bitmap.class).a(g);
    }

    @CheckResult
    @NonNull
    public <ResourceType> n<ResourceType> a(@NonNull Class<ResourceType> cls) {
        return new n<>(this.f1427a, this, cls, this.f1428b);
    }

    /* access modifiers changed from: protected */
    public void a(@NonNull g gVar) {
        this.f = gVar.clone().o();
    }

    public final void a(@Nullable final Target<?> target) {
        if (target != null) {
            if (!k.c()) {
                this.l.post(new Runnable() {
                    public final void run() {
                        o.this.a((Target<?>) target);
                    }
                });
            } else if (!b(target) && !this.f1427a.a(target) && target.getRequest() != null) {
                com.bumptech.glide.request.c request = target.getRequest();
                target.setRequest((com.bumptech.glide.request.c) null);
                request.b();
            }
        }
    }

    @CheckResult
    @NonNull
    public n<com.bumptech.glide.load.d.e.c> b() {
        return a(com.bumptech.glide.load.d.e.c.class).a(h);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable Bitmap bitmap) {
        return c().a(bitmap);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable Drawable drawable) {
        return c().a(drawable);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable Uri uri) {
        return c().a(uri);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable File file) {
        return c().a(file);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable @RawRes @DrawableRes Integer num) {
        return c().a(num);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable Object obj) {
        return c().a(obj);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable String str) {
        return c().a(str);
    }

    @Deprecated
    @CheckResult
    /* renamed from: b */
    public n<Drawable> a(@Nullable URL url) {
        return c().a(url);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public n<Drawable> a(@Nullable byte[] bArr) {
        return c().a(bArr);
    }

    @NonNull
    public o b(@NonNull g gVar) {
        this.f = this.f.a(gVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final <T> p<?, T> b(Class<T> cls) {
        h hVar = this.f1427a.f949b;
        p<?, T> pVar = hVar.g.get(cls);
        if (pVar == null) {
            for (Map.Entry next : hVar.g.entrySet()) {
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    pVar = (p) next.getValue();
                }
            }
        }
        return pVar == null ? h.f959a : pVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(@NonNull Target<?> target) {
        com.bumptech.glide.request.c request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.d.a(request, true)) {
            return false;
        }
        this.e.f1419a.remove(target);
        target.setRequest((com.bumptech.glide.request.c) null);
        return true;
    }

    @CheckResult
    @NonNull
    public n<Drawable> c() {
        return a(Drawable.class);
    }

    @CheckResult
    @NonNull
    public n<File> c(@Nullable Object obj) {
        return d().a(obj);
    }

    @NonNull
    public o c(@NonNull g gVar) {
        a(gVar);
        return this;
    }

    @CheckResult
    @NonNull
    public n<File> d() {
        return a(File.class).a(i);
    }

    @CheckResult
    @NonNull
    public n<File> e() {
        return a(File.class).a(g.a());
    }

    public void onDestroy() {
        this.e.onDestroy();
        for (T a2 : k.a(this.e.f1419a)) {
            a((Target<?>) a2);
        }
        this.e.f1419a.clear();
        m mVar = this.d;
        for (T a3 : k.a(mVar.f1416a)) {
            mVar.a(a3, false);
        }
        mVar.f1417b.clear();
        this.f1429c.b(this);
        this.f1429c.b(this.m);
        this.l.removeCallbacks(this.k);
        f fVar = this.f1427a;
        synchronized (fVar.g) {
            if (!fVar.g.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            fVar.g.remove(this);
        }
    }

    public void onStart() {
        j();
        this.e.onStart();
    }

    public void onStop() {
        g();
        this.e.onStop();
    }

    public String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.j + "}";
    }
}
