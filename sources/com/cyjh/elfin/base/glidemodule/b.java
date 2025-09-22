package com.cyjh.elfin.base.glidemodule;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.l;
import com.bumptech.glide.load.d.a.n;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.m;
import com.bumptech.glide.request.g;

public final class b extends g implements Cloneable {
    private static b A;
    private static b B;
    private static b C;
    private static b x;
    private static b y;
    private static b z;

    @CheckResult
    @NonNull
    private static b B() {
        if (x == null) {
            x = (b) super.o();
        }
        return x;
    }

    @CheckResult
    @NonNull
    private static b C() {
        if (y == null) {
            y = (b) super.o();
        }
        return y;
    }

    @CheckResult
    @NonNull
    private static b D() {
        if (z == null) {
            z = (b) super.o();
        }
        return z;
    }

    @CheckResult
    @NonNull
    private static b E() {
        if (A == null) {
            A = (b) super.o();
        }
        return A;
    }

    @CheckResult
    @NonNull
    private static b F() {
        if (B == null) {
            B = (b) super.o();
        }
        return B;
    }

    @CheckResult
    @NonNull
    private static b G() {
        if (C == null) {
            C = (b) super.o();
        }
        return C;
    }

    @CheckResult
    private b H() {
        return (b) super.clone();
    }

    @NonNull
    private b I() {
        return (b) super.n();
    }

    @NonNull
    private b J() {
        return (b) super.o();
    }

    @CheckResult
    @NonNull
    private static b c(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return new b().a(f);
    }

    @CheckResult
    @NonNull
    private static b c(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        return new b().a(i, i2);
    }

    @CheckResult
    @NonNull
    private static b c(@IntRange(from = 0) long j) {
        return new b().a(j);
    }

    @CheckResult
    @NonNull
    private static b c(@NonNull Bitmap.CompressFormat compressFormat) {
        return new b().a(compressFormat);
    }

    @CheckResult
    @NonNull
    private static b c(@NonNull l lVar) {
        return new b().a(lVar);
    }

    @CheckResult
    @NonNull
    private static b c(@NonNull com.bumptech.glide.load.b bVar) {
        return new b().a(bVar);
    }

    @CheckResult
    @NonNull
    private static b c(@NonNull n nVar) {
        return new b().a(nVar);
    }

    @CheckResult
    @NonNull
    private static <T> b c(@NonNull i<T> iVar, @NonNull T t) {
        return new b().a(iVar, t);
    }

    @CheckResult
    @NonNull
    private static b d(@NonNull com.bumptech.glide.load.b.i iVar) {
        return new b().b(iVar);
    }

    @CheckResult
    @NonNull
    private static b d(@NonNull com.bumptech.glide.load.g gVar) {
        return new b().b(gVar);
    }

    @CheckResult
    @NonNull
    private static b d(@NonNull Class<?> cls) {
        return new b().b(cls);
    }

    @CheckResult
    @NonNull
    private static b e(@NonNull m<Bitmap> mVar) {
        return new b().a(mVar);
    }

    @CheckResult
    @NonNull
    private static b g(@Nullable Drawable drawable) {
        return new b().a(drawable);
    }

    @CheckResult
    @NonNull
    private static b h(@Nullable Drawable drawable) {
        return new b().c(drawable);
    }

    @CheckResult
    @NonNull
    private static b i(boolean z2) {
        return new b().d(z2);
    }

    @CheckResult
    @NonNull
    private static b n(@DrawableRes int i) {
        return new b().a(i);
    }

    @CheckResult
    @NonNull
    private static b o(@DrawableRes int i) {
        return new b().c(i);
    }

    @CheckResult
    @NonNull
    private static b p(@IntRange(from = 0) int i) {
        return new b().d(i);
    }

    @CheckResult
    @NonNull
    private static b q(@IntRange(from = 0) int i) {
        return new b().f(i);
    }

    @CheckResult
    @NonNull
    private static b r(@IntRange(from = 0, to = 100) int i) {
        return new b().e(i);
    }

    @CheckResult
    @NonNull
    public final b A() {
        return (b) super.m();
    }

    @CheckResult
    public final /* bridge */ /* synthetic */ g b() {
        return (b) super.clone();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (b) super.a(f);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(int i, int i2) {
        return (b) super.a(i, i2);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@IntRange(from = 0) long j) {
        return (b) super.a(j);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@Nullable Resources.Theme theme) {
        return (b) super.a(theme);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull Bitmap.CompressFormat compressFormat) {
        return (b) super.a(compressFormat);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull l lVar) {
        return (b) super.a(lVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull com.bumptech.glide.load.b bVar) {
        return (b) super.a(bVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull n nVar) {
        return (b) super.a(nVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final <T> b a(@NonNull i<T> iVar, @NonNull T t) {
        return (b) super.a(iVar, t);
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull g gVar) {
        return (b) super.a(gVar);
    }

    @SafeVarargs
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final b a(@NonNull m<Bitmap>... mVarArr) {
        return (b) super.a(mVarArr);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g c() {
        return (b) super.c();
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final b b(@NonNull com.bumptech.glide.load.b.i iVar) {
        return (b) super.b(iVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final b b(@NonNull com.bumptech.glide.load.g gVar) {
        return (b) super.b(gVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final b a(@NonNull m<Bitmap> mVar) {
        return (b) super.a(mVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final b b(@NonNull Class<?> cls) {
        return (b) super.b(cls);
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final <T> b a(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        return (b) super.a(cls, mVar);
    }

    @CheckResult
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g d() {
        return (b) super.d();
    }

    @CheckResult
    @NonNull
    /* renamed from: d */
    public final b a(@Nullable Drawable drawable) {
        return (b) super.a(drawable);
    }

    @CheckResult
    @NonNull
    /* renamed from: d */
    public final b b(@NonNull m<Bitmap> mVar) {
        return (b) super.b(mVar);
    }

    @CheckResult
    @NonNull
    /* renamed from: d */
    public final <T> b b(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        return (b) super.b(cls, mVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g e() {
        return (b) super.e();
    }

    @CheckResult
    @NonNull
    /* renamed from: e */
    public final b b(@Nullable Drawable drawable) {
        return (b) super.b(drawable);
    }

    @CheckResult
    @NonNull
    /* renamed from: e */
    public final b a(boolean z2) {
        return (b) super.a(z2);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g f() {
        return (b) super.f();
    }

    @CheckResult
    @NonNull
    /* renamed from: f */
    public final b c(@Nullable Drawable drawable) {
        return (b) super.c(drawable);
    }

    @CheckResult
    @NonNull
    /* renamed from: f */
    public final b b(boolean z2) {
        return (b) super.b(z2);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g g() {
        return (b) super.g();
    }

    @CheckResult
    @NonNull
    /* renamed from: g */
    public final b c(boolean z2) {
        return (b) super.c(z2);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g h() {
        return (b) super.h();
    }

    @CheckResult
    @NonNull
    /* renamed from: h */
    public final b a(@DrawableRes int i) {
        return (b) super.a(i);
    }

    @CheckResult
    @NonNull
    /* renamed from: h */
    public final b d(boolean z2) {
        return (b) super.d(z2);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g i() {
        return (b) super.i();
    }

    @CheckResult
    @NonNull
    /* renamed from: i */
    public final b b(@DrawableRes int i) {
        return (b) super.b(i);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g j() {
        return (b) super.j();
    }

    @CheckResult
    @NonNull
    /* renamed from: j */
    public final b c(@DrawableRes int i) {
        return (b) super.c(i);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g k() {
        return (b) super.k();
    }

    @CheckResult
    @NonNull
    /* renamed from: k */
    public final b d(int i) {
        return (b) super.d(i);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g l() {
        return (b) super.l();
    }

    @CheckResult
    @NonNull
    /* renamed from: l */
    public final b e(@IntRange(from = 0, to = 100) int i) {
        return (b) super.e(i);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ g m() {
        return (b) super.m();
    }

    @CheckResult
    @NonNull
    /* renamed from: m */
    public final b f(@IntRange(from = 0) int i) {
        return (b) super.f(i);
    }

    @NonNull
    public final /* bridge */ /* synthetic */ g n() {
        return (b) super.n();
    }

    @NonNull
    public final /* bridge */ /* synthetic */ g o() {
        return (b) super.o();
    }

    @CheckResult
    @NonNull
    public final b q() {
        return (b) super.c();
    }

    @CheckResult
    @NonNull
    public final b r() {
        return (b) super.d();
    }

    @CheckResult
    @NonNull
    public final b s() {
        return (b) super.e();
    }

    @CheckResult
    @NonNull
    public final b t() {
        return (b) super.f();
    }

    @CheckResult
    @NonNull
    public final b u() {
        return (b) super.g();
    }

    @CheckResult
    @NonNull
    public final b v() {
        return (b) super.h();
    }

    @CheckResult
    @NonNull
    public final b w() {
        return (b) super.i();
    }

    @CheckResult
    @NonNull
    public final b x() {
        return (b) super.j();
    }

    @CheckResult
    @NonNull
    public final b y() {
        return (b) super.k();
    }

    @CheckResult
    @NonNull
    public final b z() {
        return (b) super.l();
    }
}
