package com.bumptech.glide.load.d.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.util.List;

public final class e implements k<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1344a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1345b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1346c = 1;
    private static final int d = 1;
    private static final int e = 0;
    private final Context f;

    public e(Context context) {
        this.f = context.getApplicationContext();
    }

    @NonNull
    private Context a(Uri uri, String str) {
        try {
            return this.f.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private static boolean b(@NonNull Uri uri) {
        return uri.getScheme().equals("android.resource");
    }

    @DrawableRes
    private int c(Uri uri) {
        Integer num;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            num = Integer.valueOf(this.f.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    num = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            num = null;
        }
        if (num == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        } else if (num.intValue() != 0) {
            return num.intValue();
        } else {
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        }
    }

    @Nullable
    public final u<Drawable> a(@NonNull Uri uri) {
        int c2 = c(uri);
        String authority = uri.getAuthority();
        return d.a(a.a(this.f, authority.equals(this.f.getPackageName()) ? this.f : a(uri, authority), c2));
    }

    @Nullable
    public final /* bridge */ /* synthetic */ u a(@NonNull Object obj, int i, int i2, @NonNull j jVar) throws IOException {
        return a((Uri) obj);
    }

    public final /* synthetic */ boolean a(@NonNull Object obj, @NonNull j jVar) throws IOException {
        return ((Uri) obj).getScheme().equals("android.resource");
    }
}
