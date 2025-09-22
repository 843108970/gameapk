package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.j;
import java.io.File;

final class d<DataType> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.d<DataType> f1104a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f1105b;

    /* renamed from: c  reason: collision with root package name */
    private final j f1106c;

    d(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, j jVar) {
        this.f1104a = dVar;
        this.f1105b = datatype;
        this.f1106c = jVar;
    }

    public final boolean a(@NonNull File file) {
        return this.f1104a.a(this.f1105b, file, this.f1106c);
    }
}
