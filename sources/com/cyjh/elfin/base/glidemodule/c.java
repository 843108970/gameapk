package com.cyjh.elfin.base.glidemodule;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.bumptech.glide.f;
import com.bumptech.glide.l;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.m;
import com.bumptech.glide.n;
import com.bumptech.glide.o;
import com.bumptech.glide.p;
import java.io.File;
import java.net.URL;

public final class c<TranscodeType> extends n<TranscodeType> implements Cloneable {
    c(@NonNull f fVar, @NonNull o oVar, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(fVar, oVar, cls, context);
    }

    private c(@NonNull Class<TranscodeType> cls, @NonNull n<?> nVar) {
        super(cls, nVar);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@DrawableRes int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(i);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(int i, int i2) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(i, i2);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@IntRange(from = 0) long j) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(j);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@Nullable Resources.Theme theme) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(theme);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull Bitmap.CompressFormat compressFormat) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(compressFormat);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull l lVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(lVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull i iVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(iVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull b bVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(bVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull com.bumptech.glide.load.d.a.n nVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(nVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull g gVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(gVar);
        return this;
    }

    @CheckResult
    @NonNull
    private <T> c<TranscodeType> a(@NonNull com.bumptech.glide.load.i<T> iVar, @NonNull T t) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(iVar, t);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull m<Bitmap> mVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(mVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull Class<?> cls) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(cls);
        return this;
    }

    @CheckResult
    @NonNull
    private <T> c<TranscodeType> a(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(cls, mVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(boolean z) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(z);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> a(@NonNull m<Bitmap>... mVarArr) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(mVarArr);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> b(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(f);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> b(@DrawableRes int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(i);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> b(@NonNull m<Bitmap> mVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(mVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> b(@NonNull p<?, ? super TranscodeType> pVar) {
        return (c) super.a(pVar);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: b */
    public c<TranscodeType> a(@NonNull com.bumptech.glide.request.g gVar) {
        return (c) super.a(gVar);
    }

    @CheckResult
    @NonNull
    private <T> c<TranscodeType> b(@NonNull Class<T> cls, @NonNull m<T> mVar) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(cls, mVar);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> b(boolean z) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(z);
        return this;
    }

    @SafeVarargs
    @CheckResult
    @NonNull
    private c<TranscodeType> b(@Nullable n<TranscodeType>... nVarArr) {
        return (c) super.a(nVarArr);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> c(float f) {
        return (c) super.a(f);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> c(@DrawableRes int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).c(i);
        return this;
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable Bitmap bitmap) {
        return (c) super.a(bitmap);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> c(@Nullable Drawable drawable) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).a(drawable);
        return this;
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable Uri uri) {
        return (c) super.a(uri);
    }

    @NonNull
    private c<TranscodeType> c(@Nullable n<TranscodeType> nVar) {
        return (c) super.a(nVar);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> c(@Nullable com.bumptech.glide.request.f<TranscodeType> fVar) {
        return (c) super.a(fVar);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable File file) {
        return (c) super.a(file);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable @RawRes @DrawableRes Integer num) {
        return (c) super.a(num);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable Object obj) {
        return (c) super.a(obj);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable String str) {
        return (c) super.a(str);
    }

    /* access modifiers changed from: private */
    @Deprecated
    @CheckResult
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable URL url) {
        return (c) super.a(url);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> c(boolean z) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).c(z);
        return this;
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<TranscodeType> b(@Nullable byte[] bArr) {
        return (c) super.a(bArr);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> d(int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).d(i);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> d(@Nullable Drawable drawable) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).b(drawable);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> d(@Nullable n<TranscodeType> nVar) {
        return (c) super.b(nVar);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> d(@Nullable com.bumptech.glide.request.f<TranscodeType> fVar) {
        return (c) super.b(fVar);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> d(boolean z) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).d(z);
        return this;
    }

    @CheckResult
    @NonNull
    private c<File> e() {
        return new c(File.class, this).a(f1420a);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> e(@IntRange(from = 0, to = 100) int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).e(i);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> e(@Nullable Drawable drawable) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).c(drawable);
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> f() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).q();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> f(@IntRange(from = 0) int i) {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).f(i);
        return this;
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: f */
    public c<TranscodeType> b(@Nullable Drawable drawable) {
        return (c) super.a(drawable);
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> g() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).r();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> h() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).s();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> i() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).t();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> j() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).u();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> k() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).v();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> l() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).w();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> m() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).x();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> n() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).y();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> o() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).z();
        return this;
    }

    @CheckResult
    @NonNull
    private c<TranscodeType> p() {
        this.f1421b = (a() instanceof b ? (b) a() : new b().a(this.f1421b)).A();
        return this;
    }

    @CheckResult
    private c<TranscodeType> q() {
        return (c) super.clone();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n a(float f) {
        return (c) super.a(f);
    }

    @NonNull
    public final /* bridge */ /* synthetic */ n a(@Nullable n nVar) {
        return (c) super.a(nVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n a(@NonNull p pVar) {
        return (c) super.a(pVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n a(@Nullable com.bumptech.glide.request.f fVar) {
        return (c) super.a(fVar);
    }

    @SafeVarargs
    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n a(@Nullable n[] nVarArr) {
        return (c) super.a((n<TranscodeType>[]) nVarArr);
    }

    @CheckResult
    public final /* bridge */ /* synthetic */ n b() {
        return (c) super.clone();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n b(@Nullable n nVar) {
        return (c) super.b(nVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n b(@Nullable com.bumptech.glide.request.f fVar) {
        return (c) super.b(fVar);
    }

    @CheckResult
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (c) super.clone();
    }

    /* access modifiers changed from: protected */
    @CheckResult
    @NonNull
    public final /* synthetic */ n d() {
        return new c(File.class, this).a(f1420a);
    }
}
