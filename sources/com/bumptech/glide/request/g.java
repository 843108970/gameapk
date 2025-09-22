package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.f.b;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.d.a.ac;
import com.bumptech.glide.load.d.a.e;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.q;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.load.d.e.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.m;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.k;
import java.util.Map;

public class g implements Cloneable {
    private static final int A = 8;
    private static final int B = 16;
    private static final int C = 32;
    private static final int D = 64;
    private static final int E = 128;
    private static final int F = 256;
    private static final int G = 512;
    private static final int H = 1024;
    private static final int I = 2048;
    private static final int J = 4096;
    private static final int K = 8192;
    private static final int L = 16384;
    private static final int M = 32768;
    private static final int N = 65536;
    private static final int O = 131072;
    private static final int P = 262144;
    private static final int Q = 524288;
    private static final int R = 1048576;
    @Nullable
    private static g S = null;
    @Nullable
    private static g T = null;
    @Nullable
    private static g U = null;
    @Nullable
    private static g V = null;
    @Nullable
    private static g W = null;
    @Nullable
    private static g X = null;
    @Nullable
    private static g Y = null;
    @Nullable
    private static g Z = null;
    private static final int x = -1;
    private static final int y = 2;
    private static final int z = 4;

    /* renamed from: a  reason: collision with root package name */
    float f1462a = 1.0f;
    private int aa;
    private boolean ab;
    private boolean ac;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    i f1463b = i.e;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public l f1464c = l.NORMAL;
    @Nullable
    Drawable d;
    int e;
    @Nullable
    Drawable f;
    int g;
    public boolean h = true;
    public int i = -1;
    public int j = -1;
    @NonNull
    com.bumptech.glide.load.g k = b.a();
    boolean l;
    public boolean m = true;
    @Nullable
    Drawable n;
    int o;
    @NonNull
    public j p = new j();
    @NonNull
    Map<Class<?>, m<?>> q = new CachedHashCodeArrayMap();
    @NonNull
    Class<?> r = Object.class;
    @Nullable
    Resources.Theme s;
    boolean t;
    boolean u;
    boolean v = true;
    boolean w;

    private boolean A() {
        return this.ac;
    }

    private boolean B() {
        return g(4);
    }

    private boolean C() {
        return g(256);
    }

    @NonNull
    private Map<Class<?>, m<?>> D() {
        return this.q;
    }

    private boolean E() {
        return this.l;
    }

    @NonNull
    private j F() {
        return this.p;
    }

    @NonNull
    private Class<?> G() {
        return this.r;
    }

    @NonNull
    private i H() {
        return this.f1463b;
    }

    @Nullable
    private Drawable I() {
        return this.d;
    }

    private int J() {
        return this.e;
    }

    private int K() {
        return this.g;
    }

    @Nullable
    private Drawable L() {
        return this.f;
    }

    private int M() {
        return this.o;
    }

    @Nullable
    private Drawable N() {
        return this.n;
    }

    @Nullable
    private Resources.Theme O() {
        return this.s;
    }

    private boolean P() {
        return this.h;
    }

    @NonNull
    private com.bumptech.glide.load.g Q() {
        return this.k;
    }

    private boolean R() {
        return g(8);
    }

    @NonNull
    private l S() {
        return this.f1464c;
    }

    private int T() {
        return this.j;
    }

    private int U() {
        return this.i;
    }

    private float V() {
        return this.f1462a;
    }

    private boolean W() {
        return this.v;
    }

    private boolean X() {
        return this.t;
    }

    private boolean Y() {
        return this.w;
    }

    private boolean Z() {
        return this.u;
    }

    @CheckResult
    @NonNull
    public static g a() {
        if (S == null) {
            S = new g().d(true).o();
        }
        return S;
    }

    @CheckResult
    @NonNull
    public static g a(@NonNull i iVar) {
        return new g().b(iVar);
    }

    @NonNull
    private g a(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        g gVar = this;
        while (gVar.ac) {
            gVar = gVar.clone();
        }
        gVar.a(nVar);
        return gVar.a(mVar, false);
    }

    @NonNull
    private g a(@NonNull n nVar, @NonNull m<Bitmap> mVar, boolean z2) {
        g b2 = z2 ? b(nVar, mVar) : a(nVar, mVar);
        b2.v = true;
        return b2;
    }

    @CheckResult
    @NonNull
    public static g a(@NonNull com.bumptech.glide.load.g gVar) {
        return new g().b(gVar);
    }

    @NonNull
    private g a(@NonNull m<Bitmap> mVar, boolean z2) {
        g gVar = this;
        while (gVar.ac) {
            gVar = gVar.clone();
        }
        q qVar = new q(mVar, z2);
        gVar.a(Bitmap.class, mVar, z2);
        gVar.a(Drawable.class, qVar, z2);
        gVar.a(BitmapDrawable.class, qVar, z2);
        gVar.a(c.class, new f(mVar), z2);
        return gVar.z();
    }

    @CheckResult
    @NonNull
    public static g a(@NonNull Class<?> cls) {
        return new g().b(cls);
    }

    @NonNull
    private <T> g a(@NonNull Class<T> cls, @NonNull m<T> mVar, boolean z2) {
        g gVar = this;
        while (gVar.ac) {
            gVar = gVar.clone();
        }
        com.bumptech.glide.util.i.a(cls, "Argument must not be null");
        com.bumptech.glide.util.i.a(mVar, "Argument must not be null");
        gVar.q.put(cls, mVar);
        gVar.aa |= 2048;
        gVar.m = true;
        gVar.aa |= 65536;
        gVar.v = false;
        if (z2) {
            gVar.aa |= 131072;
            gVar.l = true;
        }
        return gVar.z();
    }

    @CheckResult
    @NonNull
    private static g b(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return new g().a(f2);
    }

    @CheckResult
    @NonNull
    private static g b(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return new g().a(i2, i3);
    }

    @CheckResult
    @NonNull
    private static g b(@IntRange(from = 0) long j2) {
        return new g().a(j2);
    }

    @CheckResult
    @NonNull
    private static g b(@NonNull Bitmap.CompressFormat compressFormat) {
        return new g().a(compressFormat);
    }

    @CheckResult
    @NonNull
    private static g b(@NonNull l lVar) {
        return new g().a(lVar);
    }

    @CheckResult
    @NonNull
    private static g b(@NonNull com.bumptech.glide.load.b bVar) {
        return new g().a(bVar);
    }

    @CheckResult
    @NonNull
    private static g b(@NonNull n nVar) {
        return new g().a(nVar);
    }

    @CheckResult
    @NonNull
    private g b(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        g gVar = this;
        while (gVar.ac) {
            gVar = gVar.clone();
        }
        gVar.a(nVar);
        return gVar.a(mVar);
    }

    @CheckResult
    @NonNull
    private static <T> g b(@NonNull com.bumptech.glide.load.i<T> iVar, @NonNull T t2) {
        return new g().a(iVar, t2);
    }

    @NonNull
    private g c(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        return a(nVar, mVar, true);
    }

    @CheckResult
    @NonNull
    private static g c(@NonNull m<Bitmap> mVar) {
        return new g().a(mVar);
    }

    private static boolean c(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @CheckResult
    @NonNull
    private static g d(@Nullable Drawable drawable) {
        return new g().a(drawable);
    }

    @NonNull
    private g d(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        return a(nVar, mVar, false);
    }

    @CheckResult
    @NonNull
    private static g e(@Nullable Drawable drawable) {
        return new g().c(drawable);
    }

    @CheckResult
    @NonNull
    private static g h(@DrawableRes int i2) {
        return new g().a(i2);
    }

    @CheckResult
    @NonNull
    private static g i(@DrawableRes int i2) {
        return new g().c(i2);
    }

    @CheckResult
    @NonNull
    private static g j(@IntRange(from = 0) int i2) {
        return new g().a(i2, i2);
    }

    @CheckResult
    @NonNull
    private static g k(@IntRange(from = 0) int i2) {
        return new g().f(i2);
    }

    @CheckResult
    @NonNull
    private static g l(@IntRange(from = 0, to = 100) int i2) {
        return new g().e(i2);
    }

    @CheckResult
    @NonNull
    private static g q() {
        if (U == null) {
            U = new g().g().o();
        }
        return U;
    }

    @CheckResult
    @NonNull
    private static g r() {
        if (V == null) {
            V = new g().i().o();
        }
        return V;
    }

    @CheckResult
    @NonNull
    private static g s() {
        if (W == null) {
            W = new g().e().o();
        }
        return W;
    }

    @CheckResult
    @NonNull
    private static g t() {
        if (X == null) {
            X = new g().k().o();
        }
        return X;
    }

    @CheckResult
    @NonNull
    private static g u() {
        if (Y == null) {
            Y = new g().l().o();
        }
        return Y;
    }

    @CheckResult
    @NonNull
    private static g v() {
        if (Z == null) {
            Z = new g().m().o();
        }
        return Z;
    }

    private boolean w() {
        return this.m;
    }

    private boolean x() {
        return g(2048);
    }

    private boolean y() {
        return this.ab;
    }

    @NonNull
    private g z() {
        if (!this.ab) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    @CheckResult
    @NonNull
    public g a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.ac) {
            return clone().a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f1462a = f2;
        this.aa |= 2;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@DrawableRes int i2) {
        if (this.ac) {
            return clone().a(i2);
        }
        this.g = i2;
        this.aa |= 128;
        this.f = null;
        this.aa &= -65;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(int i2, int i3) {
        if (this.ac) {
            return clone().a(i2, i3);
        }
        this.j = i2;
        this.i = i3;
        this.aa |= 512;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@IntRange(from = 0) long j2) {
        return a(ac.f1290c, Long.valueOf(j2));
    }

    @CheckResult
    @NonNull
    public g a(@Nullable Resources.Theme theme) {
        if (this.ac) {
            return clone().a(theme);
        }
        this.s = theme;
        this.aa |= 32768;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@NonNull Bitmap.CompressFormat compressFormat) {
        return a(e.f1298b, com.bumptech.glide.util.i.a(compressFormat, "Argument must not be null"));
    }

    @CheckResult
    @NonNull
    public g a(@Nullable Drawable drawable) {
        if (this.ac) {
            return clone().a(drawable);
        }
        this.f = drawable;
        this.aa |= 64;
        this.g = 0;
        this.aa &= -129;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@NonNull l lVar) {
        if (this.ac) {
            return clone().a(lVar);
        }
        this.f1464c = (l) com.bumptech.glide.util.i.a(lVar, "Argument must not be null");
        this.aa |= 8;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@NonNull com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.util.i.a(bVar, "Argument must not be null");
        return a(o.f1315b, bVar).a(com.bumptech.glide.load.d.e.i.f1369a, bVar);
    }

    @CheckResult
    @NonNull
    public g a(@NonNull n nVar) {
        return a(n.h, com.bumptech.glide.util.i.a(nVar, "Argument must not be null"));
    }

    @CheckResult
    @NonNull
    public <T> g a(@NonNull com.bumptech.glide.load.i<T> iVar, @NonNull T t2) {
        if (this.ac) {
            return clone().a(iVar, t2);
        }
        com.bumptech.glide.util.i.a(iVar, "Argument must not be null");
        com.bumptech.glide.util.i.a(t2, "Argument must not be null");
        this.p.a(iVar, t2);
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@NonNull m<Bitmap> mVar) {
        return a(mVar, true);
    }

    @CheckResult
    @NonNull
    public g a(@NonNull g gVar) {
        if (this.ac) {
            return clone().a(gVar);
        }
        if (c(gVar.aa, 2)) {
            this.f1462a = gVar.f1462a;
        }
        if (c(gVar.aa, 262144)) {
            this.t = gVar.t;
        }
        if (c(gVar.aa, 1048576)) {
            this.w = gVar.w;
        }
        if (c(gVar.aa, 4)) {
            this.f1463b = gVar.f1463b;
        }
        if (c(gVar.aa, 8)) {
            this.f1464c = gVar.f1464c;
        }
        if (c(gVar.aa, 16)) {
            this.d = gVar.d;
            this.e = 0;
            this.aa &= -33;
        }
        if (c(gVar.aa, 32)) {
            this.e = gVar.e;
            this.d = null;
            this.aa &= -17;
        }
        if (c(gVar.aa, 64)) {
            this.f = gVar.f;
            this.g = 0;
            this.aa &= -129;
        }
        if (c(gVar.aa, 128)) {
            this.g = gVar.g;
            this.f = null;
            this.aa &= -65;
        }
        if (c(gVar.aa, 256)) {
            this.h = gVar.h;
        }
        if (c(gVar.aa, 512)) {
            this.j = gVar.j;
            this.i = gVar.i;
        }
        if (c(gVar.aa, 1024)) {
            this.k = gVar.k;
        }
        if (c(gVar.aa, 4096)) {
            this.r = gVar.r;
        }
        if (c(gVar.aa, 8192)) {
            this.n = gVar.n;
            this.o = 0;
            this.aa &= -16385;
        }
        if (c(gVar.aa, 16384)) {
            this.o = gVar.o;
            this.n = null;
            this.aa &= -8193;
        }
        if (c(gVar.aa, 32768)) {
            this.s = gVar.s;
        }
        if (c(gVar.aa, 65536)) {
            this.m = gVar.m;
        }
        if (c(gVar.aa, 131072)) {
            this.l = gVar.l;
        }
        if (c(gVar.aa, 2048)) {
            this.q.putAll(gVar.q);
            this.v = gVar.v;
        }
        if (c(gVar.aa, 524288)) {
            this.u = gVar.u;
        }
        if (!this.m) {
            this.q.clear();
            this.aa &= -2049;
            this.l = false;
            this.aa &= -131073;
            this.v = true;
        }
        this.aa |= gVar.aa;
        this.p.a(gVar.p);
        return z();
    }

    @CheckResult
    @NonNull
    public <T> g a(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        return a(cls, mVar, false);
    }

    @CheckResult
    @NonNull
    public g a(boolean z2) {
        if (this.ac) {
            return clone().a(z2);
        }
        this.t = z2;
        this.aa |= 262144;
        return z();
    }

    @CheckResult
    @NonNull
    public g a(@NonNull m<Bitmap>... mVarArr) {
        return a((m<Bitmap>) new h((m<T>[]) mVarArr), true);
    }

    @CheckResult
    /* renamed from: b */
    public g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.p = new j();
            gVar.p.a(this.p);
            gVar.q = new CachedHashCodeArrayMap();
            gVar.q.putAll(this.q);
            gVar.ab = false;
            gVar.ac = false;
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @CheckResult
    @NonNull
    public g b(@DrawableRes int i2) {
        if (this.ac) {
            return clone().b(i2);
        }
        this.o = i2;
        this.aa |= 16384;
        this.n = null;
        this.aa &= -8193;
        return z();
    }

    @CheckResult
    @NonNull
    public g b(@Nullable Drawable drawable) {
        if (this.ac) {
            return clone().b(drawable);
        }
        this.n = drawable;
        this.aa |= 8192;
        this.o = 0;
        this.aa &= -16385;
        return z();
    }

    @CheckResult
    @NonNull
    public g b(@NonNull i iVar) {
        if (this.ac) {
            return clone().b(iVar);
        }
        this.f1463b = (i) com.bumptech.glide.util.i.a(iVar, "Argument must not be null");
        this.aa |= 4;
        return z();
    }

    @CheckResult
    @NonNull
    public g b(@NonNull com.bumptech.glide.load.g gVar) {
        if (this.ac) {
            return clone().b(gVar);
        }
        this.k = (com.bumptech.glide.load.g) com.bumptech.glide.util.i.a(gVar, "Argument must not be null");
        this.aa |= 1024;
        return z();
    }

    @CheckResult
    @NonNull
    public g b(@NonNull m<Bitmap> mVar) {
        return a(mVar, false);
    }

    @CheckResult
    @NonNull
    public g b(@NonNull Class<?> cls) {
        if (this.ac) {
            return clone().b(cls);
        }
        this.r = (Class) com.bumptech.glide.util.i.a(cls, "Argument must not be null");
        this.aa |= 4096;
        return z();
    }

    @CheckResult
    @NonNull
    public <T> g b(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        return a(cls, mVar, true);
    }

    @CheckResult
    @NonNull
    public g b(boolean z2) {
        if (this.ac) {
            return clone().b(z2);
        }
        this.w = z2;
        this.aa |= 1048576;
        return z();
    }

    @CheckResult
    @NonNull
    public g c() {
        return a(o.e, false);
    }

    @CheckResult
    @NonNull
    public g c(@DrawableRes int i2) {
        if (this.ac) {
            return clone().c(i2);
        }
        this.e = i2;
        this.aa |= 32;
        this.d = null;
        this.aa &= -17;
        return z();
    }

    @CheckResult
    @NonNull
    public g c(@Nullable Drawable drawable) {
        if (this.ac) {
            return clone().c(drawable);
        }
        this.d = drawable;
        this.aa |= 16;
        this.e = 0;
        this.aa &= -33;
        return z();
    }

    @CheckResult
    @NonNull
    public g c(boolean z2) {
        if (this.ac) {
            return clone().c(z2);
        }
        this.u = z2;
        this.aa |= 524288;
        return z();
    }

    @CheckResult
    @NonNull
    public g d() {
        return a(n.f1312b, (m<Bitmap>) new com.bumptech.glide.load.d.a.j());
    }

    @CheckResult
    @NonNull
    public g d(int i2) {
        return a(i2, i2);
    }

    @CheckResult
    @NonNull
    public g d(boolean z2) {
        if (this.ac) {
            return clone().d(true);
        }
        this.h = !z2;
        this.aa |= 256;
        return z();
    }

    @CheckResult
    @NonNull
    public g e() {
        return b(n.f1312b, (m<Bitmap>) new com.bumptech.glide.load.d.a.j());
    }

    @CheckResult
    @NonNull
    public g e(@IntRange(from = 0, to = 100) int i2) {
        return a(e.f1297a, Integer.valueOf(i2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            return Float.compare(gVar.f1462a, this.f1462a) == 0 && this.e == gVar.e && k.a((Object) this.d, (Object) gVar.d) && this.g == gVar.g && k.a((Object) this.f, (Object) gVar.f) && this.o == gVar.o && k.a((Object) this.n, (Object) gVar.n) && this.h == gVar.h && this.i == gVar.i && this.j == gVar.j && this.l == gVar.l && this.m == gVar.m && this.t == gVar.t && this.u == gVar.u && this.f1463b.equals(gVar.f1463b) && this.f1464c == gVar.f1464c && this.p.equals(gVar.p) && this.q.equals(gVar.q) && this.r.equals(gVar.r) && k.a((Object) this.k, (Object) gVar.k) && k.a((Object) this.s, (Object) gVar.s);
        }
    }

    @CheckResult
    @NonNull
    public g f() {
        return a(n.f1311a, (m<Bitmap>) new s(), false);
    }

    @CheckResult
    @NonNull
    public g f(@IntRange(from = 0) int i2) {
        return a(com.bumptech.glide.load.c.a.b.f1194a, Integer.valueOf(i2));
    }

    @CheckResult
    @NonNull
    public g g() {
        return a(n.f1311a, (m<Bitmap>) new s(), true);
    }

    public final boolean g(int i2) {
        return c(this.aa, i2);
    }

    @CheckResult
    @NonNull
    public g h() {
        return a(n.e, (m<Bitmap>) new com.bumptech.glide.load.d.a.k(), false);
    }

    public int hashCode() {
        return k.a((Object) this.s, k.a((Object) this.k, k.a((Object) this.r, k.a((Object) this.q, k.a((Object) this.p, k.a((Object) this.f1464c, k.a((Object) this.f1463b, k.a(this.u, k.a(this.t, k.a(this.m, k.a(this.l, k.b(this.j, k.b(this.i, k.a(this.h, k.a((Object) this.n, k.b(this.o, k.a((Object) this.f, k.b(this.g, k.a((Object) this.d, k.b(this.e, k.a(this.f1462a)))))))))))))))))))));
    }

    @CheckResult
    @NonNull
    public g i() {
        return a(n.e, (m<Bitmap>) new com.bumptech.glide.load.d.a.k(), true);
    }

    @CheckResult
    @NonNull
    public g j() {
        return a(n.f1312b, (m<Bitmap>) new com.bumptech.glide.load.d.a.l());
    }

    @CheckResult
    @NonNull
    public g k() {
        return b(n.e, (m<Bitmap>) new com.bumptech.glide.load.d.a.l());
    }

    @CheckResult
    @NonNull
    public g l() {
        if (this.ac) {
            return clone().l();
        }
        this.q.clear();
        this.aa &= -2049;
        this.l = false;
        this.aa &= -131073;
        this.m = false;
        this.aa |= 65536;
        this.v = true;
        return z();
    }

    @CheckResult
    @NonNull
    public g m() {
        return a(com.bumptech.glide.load.d.e.i.f1370b, true);
    }

    @NonNull
    public g n() {
        this.ab = true;
        return this;
    }

    @NonNull
    public g o() {
        if (!this.ab || this.ac) {
            this.ac = true;
            return n();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public final boolean p() {
        return k.a(this.j, this.i);
    }
}
