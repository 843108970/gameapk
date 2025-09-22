package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b.e;
import com.bumptech.glide.load.b.j;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.request.a.g;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.a.a;
import com.bumptech.glide.util.a.c;
import java.util.ArrayList;
import java.util.List;

public final class i<R> implements c, h, SizeReadyCallback, a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1465a = "Request";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1466b = "Glide";

    /* renamed from: c  reason: collision with root package name */
    private static final Pools.Pool<i<?>> f1467c = com.bumptech.glide.util.a.a.a(new a.C0023a<i<?>>() {
        private static i<?> b() {
            return new i<>();
        }

        public final /* synthetic */ Object a() {
            return new i();
        }
    });
    private static final boolean e = Log.isLoggable(f1465a, 2);
    private Drawable A;
    private Drawable B;
    private int C;
    private int D;
    private boolean d;
    @Nullable
    private final String f;
    private final c g;
    @Nullable
    private f<R> h;
    private d i;
    private Context j;
    private h k;
    @Nullable
    private Object l;
    private Class<R> m;
    private g n;
    private int o;
    private int p;
    private l q;
    private Target<R> r;
    @Nullable
    private List<f<R>> s;
    private j t;
    private g<? super R> u;
    private u<R> v;
    private j.d w;
    private long x;
    private int y;
    private Drawable z;

    private enum a {
        ;
        
        public static final int CLEARED$613311b9 = 6;
        public static final int COMPLETE$613311b9 = 4;
        public static final int FAILED$613311b9 = 5;
        public static final int PENDING$613311b9 = 1;
        public static final int RUNNING$613311b9 = 2;
        public static final int WAITING_FOR_SIZE$613311b9 = 3;

        static {
            $VALUES$48811ebe = new int[]{PENDING$613311b9, RUNNING$613311b9, WAITING_FOR_SIZE$613311b9, COMPLETE$613311b9, FAILED$613311b9, CLEARED$613311b9};
        }

        public static int[] values$43a1017f() {
            return (int[]) $VALUES$48811ebe.clone();
        }
    }

    i() {
        this.f = e ? String.valueOf(super.hashCode()) : null;
        this.g = new c.b();
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private Drawable a(@DrawableRes int i2) {
        return com.bumptech.glide.load.d.c.a.a((Context) this.k, i2, this.n.s != null ? this.n.s : this.j.getTheme());
    }

    public static <R> i<R> a(Context context, h hVar, Object obj, Class<R> cls, g gVar, int i2, int i3, l lVar, Target<R> target, f<R> fVar, @Nullable List<f<R>> list, d dVar, j jVar, g<? super R> gVar2) {
        i<R> acquire = f1467c.acquire();
        if (acquire == null) {
            acquire = new i<>();
        }
        acquire.j = context;
        acquire.k = hVar;
        acquire.l = obj;
        acquire.m = cls;
        acquire.n = gVar;
        acquire.o = i2;
        acquire.p = i3;
        acquire.q = lVar;
        acquire.r = target;
        acquire.h = fVar;
        acquire.s = list;
        acquire.i = dVar;
        acquire.t = jVar;
        acquire.u = gVar2;
        acquire.y = a.PENDING$613311b9;
        return acquire;
    }

    /* JADX INFO: finally extract failed */
    private void a(p pVar, int i2) {
        boolean z2;
        this.g.a();
        int i3 = this.k.i;
        if (i3 <= i2) {
            Log.w(f1466b, "Load failed for " + this.l + " with size [" + this.C + "x" + this.D + "]", pVar);
            if (i3 <= 4) {
                pVar.logRootCauses(f1466b);
            }
        }
        Drawable drawable = null;
        this.w = null;
        this.y = a.FAILED$613311b9;
        boolean z3 = true;
        this.d = true;
        try {
            if (this.s != null) {
                z2 = false;
                for (f<R> a2 : this.s) {
                    z2 |= a2.a(pVar, this.l, this.r, r());
                }
            } else {
                z2 = false;
            }
            if (this.h == null || !this.h.a(pVar, this.l, this.r, r())) {
                z3 = false;
            }
            if ((!z2 && !z3) && q()) {
                if (this.l == null) {
                    drawable = m();
                }
                if (drawable == null) {
                    if (this.z == null) {
                        this.z = this.n.d;
                        if (this.z == null && this.n.e > 0) {
                            this.z = a(this.n.e);
                        }
                    }
                    drawable = this.z;
                }
                if (drawable == null) {
                    drawable = l();
                }
                this.r.onLoadFailed(drawable);
            }
            this.d = false;
            if (this.i != null) {
                this.i.f(this);
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    private void a(u<?> uVar) {
        j.a(uVar);
        this.v = null;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a6 A[Catch:{ all -> 0x00bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bumptech.glide.load.b.u<R> r11, R r12, com.bumptech.glide.load.a r13) {
        /*
            r10 = this;
            boolean r6 = r10.r()
            int r0 = com.bumptech.glide.request.i.a.COMPLETE$613311b9
            r10.y = r0
            r10.v = r11
            com.bumptech.glide.h r11 = r10.k
            int r11 = r11.i
            r0 = 3
            if (r11 > r0) goto L_0x0065
            java.lang.String r11 = "Glide"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Finished loading "
            r0.<init>(r1)
            java.lang.Class r1 = r12.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            java.lang.String r1 = " from "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.Object r1 = r10.l
            r0.append(r1)
            java.lang.String r1 = " with size ["
            r0.append(r1)
            int r1 = r10.C
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            int r1 = r10.D
            r0.append(r1)
            java.lang.String r1 = "] in "
            r0.append(r1)
            long r1 = r10.x
            double r1 = com.bumptech.glide.util.e.a(r1)
            r0.append(r1)
            java.lang.String r1 = " ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r11, r0)
        L_0x0065:
            r11 = 1
            r10.d = r11
            r7 = 0
            java.util.List<com.bumptech.glide.request.f<R>> r0 = r10.s     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x008d
            java.util.List<com.bumptech.glide.request.f<R>> r0 = r10.s     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00bd }
            r9 = 0
        L_0x0074:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x008e
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.f r0 = (com.bumptech.glide.request.f) r0     // Catch:{ all -> 0x00bd }
            java.lang.Object r2 = r10.l     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.target.Target<R> r3 = r10.r     // Catch:{ all -> 0x00bd }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bd }
            r9 = r9 | r0
            goto L_0x0074
        L_0x008d:
            r9 = 0
        L_0x008e:
            com.bumptech.glide.request.f<R> r0 = r10.h     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x00a2
            com.bumptech.glide.request.f<R> r0 = r10.h     // Catch:{ all -> 0x00bd }
            java.lang.Object r2 = r10.l     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.target.Target<R> r3 = r10.r     // Catch:{ all -> 0x00bd }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.a(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00b1
            com.bumptech.glide.request.a.g<? super R> r11 = r10.u     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.a.f r11 = r11.a(r13, r6)     // Catch:{ all -> 0x00bd }
            com.bumptech.glide.request.target.Target<R> r13 = r10.r     // Catch:{ all -> 0x00bd }
            r13.onResourceReady(r12, r11)     // Catch:{ all -> 0x00bd }
        L_0x00b1:
            r10.d = r7
            com.bumptech.glide.request.d r11 = r10.i
            if (r11 == 0) goto L_0x00bc
            com.bumptech.glide.request.d r11 = r10.i
            r11.e(r10)
        L_0x00bc:
            return
        L_0x00bd:
            r11 = move-exception
            r10.d = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.i.a(com.bumptech.glide.load.b.u, java.lang.Object, com.bumptech.glide.load.a):void");
    }

    private void a(String str) {
        Log.v(f1465a, str + " this: " + this.f);
    }

    private static boolean a(i<?> iVar, i<?> iVar2) {
        return (iVar.s == null ? 0 : iVar.s.size()) == (iVar2.s == null ? 0 : iVar2.s.size());
    }

    private void b(Context context, h hVar, Object obj, Class<R> cls, g gVar, int i2, int i3, l lVar, Target<R> target, f<R> fVar, @Nullable List<f<R>> list, d dVar, j jVar, g<? super R> gVar2) {
        this.j = context;
        this.k = hVar;
        this.l = obj;
        this.m = cls;
        this.n = gVar;
        this.o = i2;
        this.p = i3;
        this.q = lVar;
        this.r = target;
        this.h = fVar;
        this.s = list;
        this.i = dVar;
        this.t = jVar;
        this.u = gVar2;
        this.y = a.PENDING$613311b9;
    }

    private void i() {
        j();
        this.g.a();
        this.r.removeCallback(this);
        if (this.w != null) {
            j.d dVar = this.w;
            k<?> kVar = dVar.f1158a;
            h hVar = dVar.f1159b;
            com.bumptech.glide.util.k.a();
            kVar.f1161b.a();
            if (kVar.l || kVar.m) {
                if (kVar.n == null) {
                    kVar.n = new ArrayList(2);
                }
                if (!kVar.n.contains(hVar)) {
                    kVar.n.add(hVar);
                }
            } else {
                kVar.f1160a.remove(hVar);
                if (kVar.f1160a.isEmpty() && !kVar.m && !kVar.l && !kVar.q) {
                    kVar.q = true;
                    com.bumptech.glide.load.b.g<R> gVar = kVar.p;
                    gVar.t = true;
                    e eVar = gVar.s;
                    if (eVar != null) {
                        eVar.b();
                    }
                    kVar.f1162c.a(kVar, kVar.e);
                }
            }
            this.w = null;
        }
    }

    private void j() {
        if (this.d) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private Drawable k() {
        if (this.z == null) {
            this.z = this.n.d;
            if (this.z == null && this.n.e > 0) {
                this.z = a(this.n.e);
            }
        }
        return this.z;
    }

    private Drawable l() {
        if (this.A == null) {
            this.A = this.n.f;
            if (this.A == null && this.n.g > 0) {
                this.A = a(this.n.g);
            }
        }
        return this.A;
    }

    private Drawable m() {
        if (this.B == null) {
            this.B = this.n.n;
            if (this.B == null && this.n.o > 0) {
                this.B = a(this.n.o);
            }
        }
        return this.B;
    }

    private void n() {
        if (q()) {
            Drawable drawable = null;
            if (this.l == null) {
                drawable = m();
            }
            if (drawable == null) {
                if (this.z == null) {
                    this.z = this.n.d;
                    if (this.z == null && this.n.e > 0) {
                        this.z = a(this.n.e);
                    }
                }
                drawable = this.z;
            }
            if (drawable == null) {
                drawable = l();
            }
            this.r.onLoadFailed(drawable);
        }
    }

    private boolean o() {
        return this.i == null || this.i.b(this);
    }

    private boolean p() {
        return this.i == null || this.i.d(this);
    }

    private boolean q() {
        return this.i == null || this.i.c(this);
    }

    private boolean r() {
        return this.i == null || !this.i.i();
    }

    private void s() {
        if (this.i != null) {
            this.i.e(this);
        }
    }

    private void t() {
        if (this.i != null) {
            this.i.f(this);
        }
    }

    public final void a() {
        j();
        this.g.a();
        this.x = com.bumptech.glide.util.e.a();
        if (this.l == null) {
            if (com.bumptech.glide.util.k.a(this.o, this.p)) {
                this.C = this.o;
                this.D = this.p;
            }
            a(new p("Received null model"), m() == null ? 5 : 3);
        } else if (this.y == a.RUNNING$613311b9) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.y == a.COMPLETE$613311b9) {
            a((u<?>) this.v, com.bumptech.glide.load.a.MEMORY_CACHE);
        } else {
            this.y = a.WAITING_FOR_SIZE$613311b9;
            if (com.bumptech.glide.util.k.a(this.o, this.p)) {
                onSizeReady(this.o, this.p);
            } else {
                this.r.getSize(this);
            }
            if ((this.y == a.RUNNING$613311b9 || this.y == a.WAITING_FOR_SIZE$613311b9) && q()) {
                this.r.onLoadStarted(l());
            }
            if (e) {
                a("finished run method in " + com.bumptech.glide.util.e.a(this.x));
            }
        }
    }

    public final void a(p pVar) {
        a(pVar, 5);
    }

    public final void a(u<?> uVar, com.bumptech.glide.load.a aVar) {
        this.g.a();
        this.w = null;
        if (uVar == null) {
            a(new p("Expected to receive a Resource<R> with an object of " + this.m + " inside, but instead got null."));
            return;
        }
        Object b2 = uVar.b();
        if (b2 == null || !this.m.isAssignableFrom(b2.getClass())) {
            a(uVar);
            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
            sb.append(this.m);
            sb.append(" but instead got ");
            sb.append(b2 != null ? b2.getClass() : "");
            sb.append("{");
            sb.append(b2);
            sb.append("} inside Resource{");
            sb.append(uVar);
            sb.append("}.");
            sb.append(b2 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
            a(new p(sb.toString()));
            return;
        }
        if (!(this.i == null || this.i.b(this))) {
            a(uVar);
            this.y = a.COMPLETE$613311b9;
            return;
        }
        a(uVar, b2, aVar);
    }

    public final boolean a(c cVar) {
        if (cVar instanceof i) {
            i iVar = (i) cVar;
            if (this.o == iVar.o && this.p == iVar.p && com.bumptech.glide.util.k.b(this.l, iVar.l) && this.m.equals(iVar.m) && this.n.equals(iVar.n) && this.q == iVar.q) {
                if ((this.s == null ? 0 : this.s.size()) == (iVar.s == null ? 0 : iVar.s.size())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b() {
        com.bumptech.glide.util.k.a();
        j();
        this.g.a();
        if (this.y != a.CLEARED$613311b9) {
            j();
            this.g.a();
            this.r.removeCallback(this);
            boolean z2 = true;
            if (this.w != null) {
                j.d dVar = this.w;
                k<?> kVar = dVar.f1158a;
                h hVar = dVar.f1159b;
                com.bumptech.glide.util.k.a();
                kVar.f1161b.a();
                if (kVar.l || kVar.m) {
                    if (kVar.n == null) {
                        kVar.n = new ArrayList(2);
                    }
                    if (!kVar.n.contains(hVar)) {
                        kVar.n.add(hVar);
                    }
                } else {
                    kVar.f1160a.remove(hVar);
                    if (kVar.f1160a.isEmpty() && !kVar.m && !kVar.l && !kVar.q) {
                        kVar.q = true;
                        com.bumptech.glide.load.b.g<R> gVar = kVar.p;
                        gVar.t = true;
                        e eVar = gVar.s;
                        if (eVar != null) {
                            eVar.b();
                        }
                        kVar.f1162c.a(kVar, kVar.e);
                    }
                }
                this.w = null;
            }
            if (this.v != null) {
                a((u<?>) this.v);
            }
            if (this.i != null && !this.i.d(this)) {
                z2 = false;
            }
            if (z2) {
                this.r.onLoadCleared(l());
            }
            this.y = a.CLEARED$613311b9;
        }
    }

    public final boolean c() {
        return this.y == a.RUNNING$613311b9 || this.y == a.WAITING_FOR_SIZE$613311b9;
    }

    public final boolean d() {
        return this.y == a.COMPLETE$613311b9;
    }

    public final boolean e() {
        return d();
    }

    public final boolean f() {
        return this.y == a.CLEARED$613311b9;
    }

    public final boolean g() {
        return this.y == a.FAILED$613311b9;
    }

    @NonNull
    public final c g_() {
        return this.g;
    }

    public final void h() {
        j();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = -1;
        this.p = -1;
        this.r = null;
        this.s = null;
        this.h = null;
        this.i = null;
        this.u = null;
        this.w = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = -1;
        this.D = -1;
        f1467c.release(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSizeReady(int r40, int r41) {
        /*
            r39 = this;
            r0 = r39
            com.bumptech.glide.util.a.c r1 = r0.g
            r1.a()
            boolean r1 = e
            if (r1 == 0) goto L_0x0022
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Got onSizeReady in "
            r1.<init>(r2)
            long r2 = r0.x
            double r2 = com.bumptech.glide.util.e.a(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.a((java.lang.String) r1)
        L_0x0022:
            int r1 = r0.y
            int r2 = com.bumptech.glide.request.i.a.WAITING_FOR_SIZE$613311b9
            if (r1 == r2) goto L_0x0029
            return
        L_0x0029:
            int r1 = com.bumptech.glide.request.i.a.RUNNING$613311b9
            r0.y = r1
            com.bumptech.glide.request.g r1 = r0.n
            float r1 = r1.f1462a
            r2 = r40
            int r2 = a((int) r2, (float) r1)
            r0.C = r2
            r2 = r41
            int r1 = a((int) r2, (float) r1)
            r0.D = r1
            boolean r1 = e
            if (r1 == 0) goto L_0x005c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "finished setup for calling load in "
            r1.<init>(r2)
            long r2 = r0.x
            double r2 = com.bumptech.glide.util.e.a(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.a((java.lang.String) r1)
        L_0x005c:
            com.bumptech.glide.load.b.j r1 = r0.t
            com.bumptech.glide.h r2 = r0.k
            java.lang.Object r12 = r0.l
            com.bumptech.glide.request.g r3 = r0.n
            com.bumptech.glide.load.g r13 = r3.k
            int r14 = r0.C
            int r15 = r0.D
            com.bumptech.glide.request.g r3 = r0.n
            java.lang.Class<?> r11 = r3.r
            java.lang.Class<R> r10 = r0.m
            com.bumptech.glide.l r9 = r0.q
            com.bumptech.glide.request.g r3 = r0.n
            com.bumptech.glide.load.b.i r8 = r3.f1463b
            com.bumptech.glide.request.g r3 = r0.n
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.m<?>> r7 = r3.q
            com.bumptech.glide.request.g r3 = r0.n
            boolean r6 = r3.l
            com.bumptech.glide.request.g r3 = r0.n
            boolean r5 = r3.v
            com.bumptech.glide.request.g r3 = r0.n
            com.bumptech.glide.load.j r4 = r3.p
            com.bumptech.glide.request.g r3 = r0.n
            boolean r3 = r3.h
            r16 = r3
            com.bumptech.glide.request.g r3 = r0.n
            boolean r3 = r3.t
            r17 = r3
            com.bumptech.glide.request.g r3 = r0.n
            boolean r3 = r3.w
            r18 = r3
            com.bumptech.glide.request.g r3 = r0.n
            boolean r3 = r3.u
            com.bumptech.glide.util.k.a()
            boolean r19 = com.bumptech.glide.load.b.j.f1145a
            if (r19 == 0) goto L_0x00ac
            long r19 = com.bumptech.glide.util.e.a()
        L_0x00a7:
            r23 = r2
            r21 = r19
            goto L_0x00af
        L_0x00ac:
            r19 = 0
            goto L_0x00a7
        L_0x00af:
            com.bumptech.glide.load.b.m r2 = new com.bumptech.glide.load.b.m
            r26 = r3
            r0 = r16
            r24 = r17
            r25 = r18
            r3 = r2
            r27 = r4
            r4 = r12
            r28 = r5
            r5 = r13
            r29 = r6
            r6 = r14
            r30 = r7
            r7 = r15
            r31 = r8
            r8 = r30
            r32 = r9
            r9 = r11
            r33 = r10
            r34 = r11
            r11 = r27
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r0 != 0) goto L_0x00da
            r6 = 0
            goto L_0x00f8
        L_0x00da:
            com.bumptech.glide.load.b.a r4 = r1.g
            java.util.Map<com.bumptech.glide.load.g, com.bumptech.glide.load.b.a$b> r5 = r4.f1008b
            java.lang.Object r5 = r5.get(r2)
            com.bumptech.glide.load.b.a$b r5 = (com.bumptech.glide.load.b.a.b) r5
            if (r5 != 0) goto L_0x00e8
            r6 = 0
            goto L_0x00f3
        L_0x00e8:
            java.lang.Object r6 = r5.get()
            com.bumptech.glide.load.b.o r6 = (com.bumptech.glide.load.b.o) r6
            if (r6 != 0) goto L_0x00f3
            r4.a((com.bumptech.glide.load.b.a.b) r5)
        L_0x00f3:
            if (r6 == 0) goto L_0x00f8
            r6.e()
        L_0x00f8:
            if (r6 == 0) goto L_0x0110
            com.bumptech.glide.load.a r0 = com.bumptech.glide.load.a.MEMORY_CACHE
            r4 = r39
            r4.a(r6, r0)
            boolean r0 = com.bumptech.glide.load.b.j.f1145a
            if (r0 == 0) goto L_0x010c
            java.lang.String r0 = "Loaded resource from active resources"
            r5 = r21
        L_0x0109:
            com.bumptech.glide.load.b.j.a((java.lang.String) r0, (long) r5, (com.bumptech.glide.load.g) r2)
        L_0x010c:
            r0 = r4
            r3 = 0
            goto L_0x0238
        L_0x0110:
            r5 = r21
            r4 = r39
            r7 = 1
            if (r0 != 0) goto L_0x0119
            r8 = 0
            goto L_0x013a
        L_0x0119:
            com.bumptech.glide.load.b.b.j r8 = r1.f1147c
            com.bumptech.glide.load.b.u r8 = r8.a((com.bumptech.glide.load.g) r2)
            if (r8 != 0) goto L_0x0123
            r8 = 0
            goto L_0x0130
        L_0x0123:
            boolean r9 = r8 instanceof com.bumptech.glide.load.b.o
            if (r9 == 0) goto L_0x012a
            com.bumptech.glide.load.b.o r8 = (com.bumptech.glide.load.b.o) r8
            goto L_0x0130
        L_0x012a:
            com.bumptech.glide.load.b.o r9 = new com.bumptech.glide.load.b.o
            r9.<init>(r8, r7, r7)
            r8 = r9
        L_0x0130:
            if (r8 == 0) goto L_0x013a
            r8.e()
            com.bumptech.glide.load.b.a r9 = r1.g
            r9.a(r2, r8)
        L_0x013a:
            if (r8 == 0) goto L_0x0148
            com.bumptech.glide.load.a r0 = com.bumptech.glide.load.a.MEMORY_CACHE
            r4.a(r8, r0)
            boolean r0 = com.bumptech.glide.load.b.j.f1145a
            if (r0 == 0) goto L_0x010c
            java.lang.String r0 = "Loaded resource from cache"
            goto L_0x0109
        L_0x0148:
            com.bumptech.glide.load.b.r r8 = r1.f1146b
            r9 = r26
            java.util.Map r8 = r8.a(r9)
            java.lang.Object r8 = r8.get(r2)
            com.bumptech.glide.load.b.k r8 = (com.bumptech.glide.load.b.k) r8
            if (r8 == 0) goto L_0x016d
            r8.a((com.bumptech.glide.request.h) r4)
            boolean r0 = com.bumptech.glide.load.b.j.f1145a
            if (r0 == 0) goto L_0x0164
            java.lang.String r0 = "Added to existing load"
            com.bumptech.glide.load.b.j.a((java.lang.String) r0, (long) r5, (com.bumptech.glide.load.g) r2)
        L_0x0164:
            com.bumptech.glide.load.b.j$d r0 = new com.bumptech.glide.load.b.j$d
            r0.<init>(r4, r8)
            r3 = r0
            r0 = r4
            goto L_0x0238
        L_0x016d:
            com.bumptech.glide.load.b.j$b r8 = r1.d
            android.support.v4.util.Pools$Pool<com.bumptech.glide.load.b.k<?>> r8 = r8.f
            java.lang.Object r8 = r8.acquire()
            com.bumptech.glide.load.b.k r8 = (com.bumptech.glide.load.b.k) r8
            java.lang.String r10 = "Argument must not be null"
            java.lang.Object r8 = com.bumptech.glide.util.i.a(r8, (java.lang.String) r10)
            com.bumptech.glide.load.b.k r8 = (com.bumptech.glide.load.b.k) r8
            r8.e = r2
            r8.f = r0
            r0 = r24
            r8.g = r0
            r0 = r25
            r8.h = r0
            r8.i = r9
            com.bumptech.glide.load.b.j$a r0 = r1.f
            android.support.v4.util.Pools$Pool<com.bumptech.glide.load.b.g<?>> r10 = r0.f1149b
            java.lang.Object r10 = r10.acquire()
            com.bumptech.glide.load.b.g r10 = (com.bumptech.glide.load.b.g) r10
            java.lang.String r11 = "Argument must not be null"
            java.lang.Object r10 = com.bumptech.glide.util.i.a(r10, (java.lang.String) r11)
            com.bumptech.glide.load.b.g r10 = (com.bumptech.glide.load.b.g) r10
            int r11 = r0.f1150c
            int r7 = r11 + 1
            r0.f1150c = r7
            com.bumptech.glide.load.b.f<R> r0 = r10.f1125a
            com.bumptech.glide.load.b.g$d r7 = r10.f1126b
            r3 = r23
            r0.f1124c = r3
            r0.d = r12
            r0.n = r13
            r0.e = r14
            r0.f = r15
            r36 = r5
            r5 = r31
            r0.p = r5
            r6 = r34
            r0.g = r6
            r0.h = r7
            r6 = r33
            r0.k = r6
            r6 = r32
            r0.o = r6
            r7 = r27
            r0.i = r7
            r4 = r30
            r0.j = r4
            r4 = r29
            r0.q = r4
            r4 = r28
            r0.r = r4
            r10.e = r3
            r10.f = r13
            r10.g = r6
            r10.h = r2
            r10.i = r14
            r10.j = r15
            r10.k = r5
            r10.p = r9
            r10.l = r7
            r10.m = r8
            r10.n = r11
            com.bumptech.glide.load.b.g$f r0 = com.bumptech.glide.load.b.g.f.INITIALIZE
            r10.o = r0
            r10.q = r12
            com.bumptech.glide.load.b.r r0 = r1.f1146b
            boolean r1 = r8.i
            java.util.Map r0 = r0.a(r1)
            r0.put(r2, r8)
            r0 = r39
            r8.a((com.bumptech.glide.request.h) r0)
            r8.p = r10
            com.bumptech.glide.load.b.g$g r1 = com.bumptech.glide.load.b.g.C0015g.INITIALIZE
            com.bumptech.glide.load.b.g$g r1 = r10.a((com.bumptech.glide.load.b.g.C0015g) r1)
            com.bumptech.glide.load.b.g$g r3 = com.bumptech.glide.load.b.g.C0015g.RESOURCE_CACHE
            if (r1 == r3) goto L_0x021a
            com.bumptech.glide.load.b.g$g r3 = com.bumptech.glide.load.b.g.C0015g.DATA_CACHE
            if (r1 != r3) goto L_0x0216
            goto L_0x021a
        L_0x0216:
            r7 = 0
            r35 = 0
            goto L_0x021c
        L_0x021a:
            r35 = 1
        L_0x021c:
            if (r35 == 0) goto L_0x0221
            com.bumptech.glide.load.b.c.a r1 = r8.d
            goto L_0x0225
        L_0x0221:
            com.bumptech.glide.load.b.c.a r1 = r8.a()
        L_0x0225:
            r1.execute(r10)
            boolean r1 = com.bumptech.glide.load.b.j.f1145a
            if (r1 == 0) goto L_0x0233
            java.lang.String r1 = "Started new load"
            r3 = r36
            com.bumptech.glide.load.b.j.a((java.lang.String) r1, (long) r3, (com.bumptech.glide.load.g) r2)
        L_0x0233:
            com.bumptech.glide.load.b.j$d r3 = new com.bumptech.glide.load.b.j$d
            r3.<init>(r0, r8)
        L_0x0238:
            r0.w = r3
            int r1 = r0.y
            int r2 = com.bumptech.glide.request.i.a.RUNNING$613311b9
            if (r1 == r2) goto L_0x0243
            r1 = 0
            r0.w = r1
        L_0x0243:
            boolean r1 = e
            if (r1 == 0) goto L_0x025e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "finished onSizeReady in "
            r1.<init>(r2)
            long r2 = r0.x
            double r2 = com.bumptech.glide.util.e.a(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.a((java.lang.String) r1)
        L_0x025e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.i.onSizeReady(int, int):void");
    }
}
