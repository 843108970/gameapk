package com.bumptech.glide.load.c;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.j;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public final class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1264a = "ResourceLoader";

    /* renamed from: b  reason: collision with root package name */
    private final n<Uri, Data> f1265b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1266c;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1267a;

        public a(Resources resources) {
            this.f1267a = resources;
        }

        public final n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f1267a, rVar.b(Uri.class, AssetFileDescriptor.class));
        }

        public final void a() {
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1268a;

        public b(Resources resources) {
            this.f1268a = resources;
        }

        @NonNull
        public final n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f1268a, rVar.b(Uri.class, ParcelFileDescriptor.class));
        }

        public final void a() {
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1269a;

        public c(Resources resources) {
            this.f1269a = resources;
        }

        @NonNull
        public final n<Integer, InputStream> a(r rVar) {
            return new s(this.f1269a, rVar.b(Uri.class, InputStream.class));
        }

        public final void a() {
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f1270a;

        public d(Resources resources) {
            this.f1270a = resources;
        }

        @NonNull
        public final n<Integer, Uri> a(r rVar) {
            return new s(this.f1270a, v.a());
        }

        public final void a() {
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f1266c = resources;
        this.f1265b = nVar;
    }

    @Nullable
    private Uri a(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f1266c.getResourcePackageName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.f1266c.getResourceTypeName(num.intValue()) + IOUtils.DIR_SEPARATOR_UNIX + this.f1266c.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (!Log.isLoggable(f1264a, 5)) {
                return null;
            }
            Log.w(f1264a, "Received invalid resource id: " + num, e);
            return null;
        }
    }

    private n.a<Data> a(@NonNull Integer num, int i, int i2, @NonNull j jVar) {
        Uri a2 = a(num);
        if (a2 == null) {
            return null;
        }
        return this.f1265b.a(a2, i, i2, jVar);
    }

    private static boolean a() {
        return true;
    }

    public final /* bridge */ /* synthetic */ n.a a(@NonNull Object obj, int i, int i2, @NonNull j jVar) {
        Uri a2 = a((Integer) obj);
        if (a2 == null) {
            return null;
        }
        return this.f1265b.a(a2, i, i2, jVar);
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj) {
        return true;
    }
}
