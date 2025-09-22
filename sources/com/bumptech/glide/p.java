package com.bumptech.glide;

import android.support.annotation.NonNull;
import com.bumptech.glide.p;
import com.bumptech.glide.request.a.e;
import com.bumptech.glide.request.a.g;
import com.bumptech.glide.request.a.h;
import com.bumptech.glide.request.a.i;
import com.bumptech.glide.request.a.j;

public abstract class p<CHILD extends p<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    g<? super TranscodeType> f1434a = e.a();

    @NonNull
    private CHILD a(int i) {
        return a(new h(i));
    }

    @NonNull
    private CHILD a(@NonNull j.a aVar) {
        return a(new i(aVar));
    }

    @NonNull
    private CHILD b() {
        return a(e.a());
    }

    private g<? super TranscodeType> c() {
        return this.f1434a;
    }

    private CHILD d() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (p) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final CHILD a(@NonNull g<? super TranscodeType> gVar) {
        this.f1434a = (g) com.bumptech.glide.util.i.a(gVar, "Argument must not be null");
        return this;
    }
}
