package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.m;
import com.bumptech.glide.n;
import com.bumptech.glide.o;
import com.bumptech.glide.request.a.f;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

final class g {

    /* renamed from: a  reason: collision with root package name */
    final com.bumptech.glide.c.b f1359a;

    /* renamed from: b  reason: collision with root package name */
    final List<b> f1360b;

    /* renamed from: c  reason: collision with root package name */
    final o f1361c;
    boolean d;
    boolean e;
    a f;
    boolean g;
    a h;
    Bitmap i;
    m<Bitmap> j;
    a k;
    private final Handler l;
    private final e m;
    private boolean n;
    private n<Bitmap> o;
    @Nullable
    private d p;

    @VisibleForTesting
    static class a extends SimpleTarget<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        final int f1362a;

        /* renamed from: b  reason: collision with root package name */
        Bitmap f1363b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f1364c;
        private final long d;

        a(Handler handler, int i, long j) {
            this.f1364c = handler;
            this.f1362a = i;
            this.d = j;
        }

        private Bitmap a() {
            return this.f1363b;
        }

        private void a(@NonNull Bitmap bitmap) {
            this.f1363b = bitmap;
            this.f1364c.sendMessageAtTime(this.f1364c.obtainMessage(1, this), this.d);
        }

        public final /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable f fVar) {
            this.f1363b = (Bitmap) obj;
            this.f1364c.sendMessageAtTime(this.f1364c.obtainMessage(1, this), this.d);
        }
    }

    public interface b {
        void c();
    }

    private class c implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        static final int f1365a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f1366b = 2;

        c() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                g.this.a((a) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                g.this.f1361c.a((Target<?>) (a) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    interface d {
        void a();
    }

    g(com.bumptech.glide.f fVar, com.bumptech.glide.c.b bVar, int i2, int i3, m<Bitmap> mVar, Bitmap bitmap) {
        this(fVar.f948a, com.bumptech.glide.f.c(fVar.f949b.getBaseContext()), bVar, com.bumptech.glide.f.c(fVar.f949b.getBaseContext()).a().a(com.bumptech.glide.request.g.a(i.f1143b).b(true).d(true).a(i2, i3)), mVar, bitmap);
    }

    private g(e eVar, o oVar, com.bumptech.glide.c.b bVar, n<Bitmap> nVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f1360b = new ArrayList();
        this.f1361c = oVar;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.m = eVar;
        this.l = handler;
        this.o = nVar;
        this.f1359a = bVar;
        a(mVar, bitmap);
    }

    private static n<Bitmap> a(o oVar, int i2, int i3) {
        return oVar.a().a(com.bumptech.glide.request.g.a(i.f1143b).b(true).d(true).a(i2, i3));
    }

    private void a(b bVar) {
        if (this.g) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (this.f1360b.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        } else {
            boolean isEmpty = this.f1360b.isEmpty();
            this.f1360b.add(bVar);
            if (isEmpty && !this.d) {
                this.d = true;
                this.g = false;
                c();
            }
        }
    }

    @VisibleForTesting
    private void a(@Nullable d dVar) {
        this.p = dVar;
    }

    private void b(b bVar) {
        this.f1360b.remove(bVar);
        if (this.f1360b.isEmpty()) {
            this.d = false;
        }
    }

    private m<Bitmap> e() {
        return this.j;
    }

    private Bitmap f() {
        return this.i;
    }

    private int g() {
        return b().getWidth();
    }

    private int h() {
        return b().getHeight();
    }

    private int i() {
        return this.f1359a.m() + k.a(b().getWidth(), b().getHeight(), b().getConfig());
    }

    private int j() {
        if (this.f != null) {
            return this.f.f1362a;
        }
        return -1;
    }

    private int k() {
        return k.a(b().getWidth(), b().getHeight(), b().getConfig());
    }

    private ByteBuffer l() {
        return this.f1359a.c().asReadOnlyBuffer();
    }

    private int m() {
        return this.f1359a.l();
    }

    private void n() {
        if (!this.d) {
            this.d = true;
            this.g = false;
            c();
        }
    }

    private void o() {
        this.d = false;
    }

    private void p() {
        this.f1360b.clear();
        d();
        this.d = false;
        if (this.f != null) {
            this.f1361c.a((Target<?>) this.f);
            this.f = null;
        }
        if (this.h != null) {
            this.f1361c.a((Target<?>) this.h);
            this.h = null;
        }
        if (this.k != null) {
            this.f1361c.a((Target<?>) this.k);
            this.k = null;
        }
        this.f1359a.o();
        this.g = true;
    }

    private void q() {
        com.bumptech.glide.util.i.a(!this.d, "Can't restart a running animation");
        this.e = true;
        if (this.k != null) {
            this.f1361c.a((Target<?>) this.k);
            this.k = null;
        }
    }

    private static com.bumptech.glide.load.g r() {
        return new com.bumptech.glide.f.d(Double.valueOf(Math.random()));
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f1359a.g();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(a aVar) {
        this.n = false;
        if (this.g) {
            this.l.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.d) {
            this.k = aVar;
        } else {
            if (aVar.f1363b != null) {
                d();
                a aVar2 = this.f;
                this.f = aVar;
                for (int size = this.f1360b.size() - 1; size >= 0; size--) {
                    this.f1360b.get(size).c();
                }
                if (aVar2 != null) {
                    this.l.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            c();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.m, com.bumptech.glide.load.m<android.graphics.Bitmap>, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.m<android.graphics.Bitmap> r2, android.graphics.Bitmap r3) {
        /*
            r1 = this;
            java.lang.String r0 = "Argument must not be null"
            java.lang.Object r0 = com.bumptech.glide.util.i.a(r2, (java.lang.String) r0)
            com.bumptech.glide.load.m r0 = (com.bumptech.glide.load.m) r0
            r1.j = r0
            java.lang.String r0 = "Argument must not be null"
            java.lang.Object r3 = com.bumptech.glide.util.i.a(r3, (java.lang.String) r0)
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3
            r1.i = r3
            com.bumptech.glide.n<android.graphics.Bitmap> r3 = r1.o
            com.bumptech.glide.request.g r0 = new com.bumptech.glide.request.g
            r0.<init>()
            com.bumptech.glide.request.g r2 = r0.a((com.bumptech.glide.load.m<android.graphics.Bitmap>) r2)
            com.bumptech.glide.n r2 = r3.a((com.bumptech.glide.request.g) r2)
            r1.o = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.e.g.a(com.bumptech.glide.load.m, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public final Bitmap b() {
        return this.f != null ? this.f.f1363b : this.i;
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.d && !this.n) {
            if (this.e) {
                com.bumptech.glide.util.i.a(this.k == null, "Pending target must be null when starting from the first frame");
                this.f1359a.i();
                this.e = false;
            }
            if (this.k != null) {
                a aVar = this.k;
                this.k = null;
                a(aVar);
                return;
            }
            this.n = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f1359a.f());
            this.f1359a.e();
            this.h = new a(this.l, this.f1359a.h(), uptimeMillis);
            this.o.a(com.bumptech.glide.request.g.a((com.bumptech.glide.load.g) new com.bumptech.glide.f.d(Double.valueOf(Math.random())))).a((Object) this.f1359a).a(this.h);
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        if (this.i != null) {
            this.m.a(this.i);
            this.i = null;
        }
    }
}
