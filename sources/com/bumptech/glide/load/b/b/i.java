package com.bumptech.glide.load.b.b;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.b.j;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.f;

public final class i extends f<g, u<?>> implements j {

    /* renamed from: a  reason: collision with root package name */
    private j.a f1075a;

    public i(long j) {
        super(j);
    }

    private void a(@Nullable u<?> uVar) {
        if (this.f1075a != null && uVar != null) {
            this.f1075a.b(uVar);
        }
    }

    private int b(@Nullable u<?> uVar) {
        return uVar == null ? super.a(null) : uVar.c();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ int a(@Nullable Object obj) {
        u uVar = (u) obj;
        return uVar == null ? super.a(null) : uVar.c();
    }

    @Nullable
    public final /* synthetic */ u a(@NonNull g gVar) {
        return (u) super.c(gVar);
    }

    @Nullable
    public final /* synthetic */ u a(@NonNull g gVar, @Nullable u uVar) {
        return (u) super.b(gVar, uVar);
    }

    @SuppressLint({"InlinedApi"})
    public final void a(int i) {
        if (i >= 40) {
            c();
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }

    public final void a(@NonNull j.a aVar) {
        this.f1075a = aVar;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(@NonNull Object obj, @Nullable Object obj2) {
        u uVar = (u) obj2;
        if (this.f1075a != null && uVar != null) {
            this.f1075a.b(uVar);
        }
    }
}
