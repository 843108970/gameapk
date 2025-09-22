package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

public final class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    private static void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    private static InputStream b(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    @NonNull
    public final Class<InputStream> a() {
        return InputStream.class;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }
}
