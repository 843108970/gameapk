package com.bumptech.glide.e;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f934a = new ArrayList();

    @NonNull
    public final synchronized List<ImageHeaderParser> a() {
        return this.f934a;
    }

    public final synchronized void a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f934a.add(imageHeaderParser);
    }
}
