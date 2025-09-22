package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import java.io.IOException;

public final class h extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    private static void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    private static ParcelFileDescriptor b(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    @NonNull
    public final Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }
}
