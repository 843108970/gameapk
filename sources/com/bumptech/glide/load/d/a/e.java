package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.l;

public final class e implements l<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final i<Integer> f1297a = i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b  reason: collision with root package name */
    public static final i<Bitmap.CompressFormat> f1298b = i.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c  reason: collision with root package name */
    private static final String f1299c = "BitmapEncoder";
    @Nullable
    private final b d;

    @Deprecated
    public e() {
        this.d = null;
    }

    public e(@NonNull b bVar) {
        this.d = bVar;
    }

    private static Bitmap.CompressFormat a(Bitmap bitmap, j jVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jVar.a(f1298b);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:27|(2:43|44)|45|46) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        if (r5 == null) goto L_0x0076;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ca */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[Catch:{ all -> 0x0060 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c7 A[SYNTHETIC, Splitter:B:43:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(@android.support.annotation.NonNull com.bumptech.glide.load.b.u<android.graphics.Bitmap> r8, @android.support.annotation.NonNull java.io.File r9, @android.support.annotation.NonNull com.bumptech.glide.load.j r10) {
        /*
            r7 = this;
            java.lang.Object r8 = r8.b()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            com.bumptech.glide.load.i<android.graphics.Bitmap$CompressFormat> r0 = f1298b
            java.lang.Object r0 = r10.a(r0)
            android.graphics.Bitmap$CompressFormat r0 = (android.graphics.Bitmap.CompressFormat) r0
            if (r0 == 0) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            boolean r0 = r8.hasAlpha()
            if (r0 == 0) goto L_0x001a
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG
            goto L_0x001c
        L_0x001a:
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
        L_0x001c:
            int r1 = r8.getWidth()
            java.lang.Integer.valueOf(r1)
            int r1 = r8.getHeight()
            java.lang.Integer.valueOf(r1)
            long r1 = com.bumptech.glide.util.e.a()     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.i<java.lang.Integer> r3 = f1297a     // Catch:{ all -> 0x00cb }
            java.lang.Object r3 = r10.a(r3)     // Catch:{ all -> 0x00cb }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00cb }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00cb }
            r4 = 0
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0062 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0062 }
            com.bumptech.glide.load.b.a.b r9 = r7.d     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            if (r9 == 0) goto L_0x004e
            com.bumptech.glide.load.a.c r9 = new com.bumptech.glide.load.a.c     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            com.bumptech.glide.load.b.a.b r5 = r7.d     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r9.<init>(r6, r5)     // Catch:{ IOException -> 0x005d, all -> 0x005a }
            r5 = r9
            goto L_0x004f
        L_0x004e:
            r5 = r6
        L_0x004f:
            r8.compress(r0, r3, r5)     // Catch:{ IOException -> 0x0062 }
            r5.close()     // Catch:{ IOException -> 0x0062 }
            r4 = 1
        L_0x0056:
            r5.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x0076
        L_0x005a:
            r8 = move-exception
            r5 = r6
            goto L_0x00c5
        L_0x005d:
            r9 = move-exception
            r5 = r6
            goto L_0x0063
        L_0x0060:
            r8 = move-exception
            goto L_0x00c5
        L_0x0062:
            r9 = move-exception
        L_0x0063:
            java.lang.String r3 = "BitmapEncoder"
            r6 = 3
            boolean r3 = android.util.Log.isLoggable(r3, r6)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = "BitmapEncoder"
            java.lang.String r6 = "Failed to encode Bitmap"
            android.util.Log.d(r3, r6, r9)     // Catch:{ all -> 0x0060 }
        L_0x0073:
            if (r5 == 0) goto L_0x0076
            goto L_0x0056
        L_0x0076:
            java.lang.String r9 = "BitmapEncoder"
            r3 = 2
            boolean r9 = android.util.Log.isLoggable(r9, r3)     // Catch:{ all -> 0x00cb }
            if (r9 == 0) goto L_0x00c4
            java.lang.String r9 = "BitmapEncoder"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "Compressed with type: "
            r3.<init>(r5)     // Catch:{ all -> 0x00cb }
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = " of size "
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            int r0 = com.bumptech.glide.util.k.a((android.graphics.Bitmap) r8)     // Catch:{ all -> 0x00cb }
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = " in "
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            double r0 = com.bumptech.glide.util.e.a(r1)     // Catch:{ all -> 0x00cb }
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = ", options format: "
            r3.append(r0)     // Catch:{ all -> 0x00cb }
            com.bumptech.glide.load.i<android.graphics.Bitmap$CompressFormat> r0 = f1298b     // Catch:{ all -> 0x00cb }
            java.lang.Object r10 = r10.a(r0)     // Catch:{ all -> 0x00cb }
            r3.append(r10)     // Catch:{ all -> 0x00cb }
            java.lang.String r10 = ", hasAlpha: "
            r3.append(r10)     // Catch:{ all -> 0x00cb }
            boolean r8 = r8.hasAlpha()     // Catch:{ all -> 0x00cb }
            r3.append(r8)     // Catch:{ all -> 0x00cb }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x00cb }
            android.util.Log.v(r9, r8)     // Catch:{ all -> 0x00cb }
        L_0x00c4:
            return r4
        L_0x00c5:
            if (r5 == 0) goto L_0x00ca
            r5.close()     // Catch:{ IOException -> 0x00ca }
        L_0x00ca:
            throw r8     // Catch:{ all -> 0x00cb }
        L_0x00cb:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.e.a(com.bumptech.glide.load.b.u, java.io.File, com.bumptech.glide.load.j):boolean");
    }

    @NonNull
    public final c a(@NonNull j jVar) {
        return c.TRANSFORMED;
    }
}
