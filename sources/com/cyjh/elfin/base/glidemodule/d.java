package com.cyjh.elfin.base.glidemodule;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.bumptech.glide.f;
import com.bumptech.glide.load.d.e.c;
import com.bumptech.glide.manager.h;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.n;
import com.bumptech.glide.o;
import com.bumptech.glide.request.g;
import java.io.File;
import java.net.URL;

public final class d extends o {
    public d(@NonNull f fVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
        super(fVar, hVar, lVar, context);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable Bitmap bitmap) {
        return (c) super.a(bitmap);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable Drawable drawable) {
        return (c) super.a(drawable);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable Uri uri) {
        return (c) super.a(uri);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable File file) {
        return (c) super.a(file);
    }

    @CheckResult
    @NonNull
    private <ResourceType> c<ResourceType> c(@NonNull Class<ResourceType> cls) {
        return new c<>(this.f1427a, this, cls, this.f1428b);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable @RawRes @DrawableRes Integer num) {
        return (c) super.a(num);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable String str) {
        return (c) super.a(str);
    }

    /* access modifiers changed from: private */
    @Deprecated
    @CheckResult
    /* renamed from: c */
    public c<Drawable> b(@Nullable URL url) {
        return (c) super.a(url);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: c */
    public c<Drawable> b(@Nullable byte[] bArr) {
        return (c) super.a(bArr);
    }

    /* access modifiers changed from: private */
    @CheckResult
    @NonNull
    /* renamed from: d */
    public c<Drawable> b(@Nullable Object obj) {
        return (c) super.a(obj);
    }

    @NonNull
    private d d(@NonNull g gVar) {
        return (d) super.b(gVar);
    }

    @CheckResult
    @NonNull
    private c<File> e(@Nullable Object obj) {
        return (c) super.c(obj);
    }

    @NonNull
    private d e(@NonNull g gVar) {
        return (d) super.c(gVar);
    }

    @CheckResult
    @NonNull
    private c<Bitmap> f() {
        return (c) super.a();
    }

    @CheckResult
    @NonNull
    private c<c> g() {
        return (c) super.b();
    }

    @CheckResult
    @NonNull
    private c<Drawable> h() {
        return (c) super.c();
    }

    @CheckResult
    @NonNull
    private c<File> i() {
        return (c) super.d();
    }

    @CheckResult
    @NonNull
    private c<File> j() {
        return (c) super.e();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n a() {
        return (c) super.a();
    }

    @CheckResult
    @NonNull
    public final /* synthetic */ n a(@NonNull Class cls) {
        return new c(this.f1427a, this, cls, this.f1428b);
    }

    /* access modifiers changed from: protected */
    public final void a(@NonNull g gVar) {
        if (gVar instanceof b) {
            super.a(gVar);
        } else {
            super.a((g) new b().a(gVar));
        }
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n b() {
        return (c) super.b();
    }

    @NonNull
    public final /* bridge */ /* synthetic */ o b(@NonNull g gVar) {
        return (d) super.b(gVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n c() {
        return (c) super.c();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n c(@Nullable Object obj) {
        return (c) super.c(obj);
    }

    @NonNull
    public final /* bridge */ /* synthetic */ o c(@NonNull g gVar) {
        return (d) super.c(gVar);
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n d() {
        return (c) super.d();
    }

    @CheckResult
    @NonNull
    public final /* bridge */ /* synthetic */ n e() {
        return (c) super.e();
    }
}
