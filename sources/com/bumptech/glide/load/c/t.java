package com.bumptech.glide.load.c;

import android.support.annotation.NonNull;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.j;
import java.io.File;
import java.io.InputStream;

public final class t implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1271a = "StreamEncoder";

    /* renamed from: b  reason: collision with root package name */
    private final b f1272b;

    public t(b bVar) {
        this.f1272b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041 A[SYNTHETIC, Splitter:B:23:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[SYNTHETIC, Splitter:B:29:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(@android.support.annotation.NonNull java.io.InputStream r5, @android.support.annotation.NonNull java.io.File r6) {
        /*
            r4 = this;
            com.bumptech.glide.load.b.a.b r0 = r4.f1272b
            java.lang.Class<byte[]> r1 = byte[].class
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Object r0 = r0.a(r2, r1)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002e }
            r3.<init>(r6)     // Catch:{ IOException -> 0x002e }
        L_0x0013:
            int r6 = r5.read(r0)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r2 = -1
            if (r6 == r2) goto L_0x001e
            r3.write(r0, r1, r6)     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            goto L_0x0013
        L_0x001e:
            r3.close()     // Catch:{ IOException -> 0x0029, all -> 0x0026 }
            r1 = 1
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0044
        L_0x0026:
            r5 = move-exception
            r2 = r3
            goto L_0x004a
        L_0x0029:
            r5 = move-exception
            r2 = r3
            goto L_0x002f
        L_0x002c:
            r5 = move-exception
            goto L_0x004a
        L_0x002e:
            r5 = move-exception
        L_0x002f:
            java.lang.String r6 = "StreamEncoder"
            r3 = 3
            boolean r6 = android.util.Log.isLoggable(r6, r3)     // Catch:{ all -> 0x002c }
            if (r6 == 0) goto L_0x003f
            java.lang.String r6 = "StreamEncoder"
            java.lang.String r3 = "Failed to encode data onto the OutputStream"
            android.util.Log.d(r6, r3, r5)     // Catch:{ all -> 0x002c }
        L_0x003f:
            if (r2 == 0) goto L_0x0044
            r2.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            com.bumptech.glide.load.b.a.b r5 = r4.f1272b
            r5.b(r0)
            return r1
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            com.bumptech.glide.load.b.a.b r6 = r4.f1272b
            r6.b(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.c.t.a(java.io.InputStream, java.io.File):boolean");
    }

    public final /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull File file, @NonNull j jVar) {
        return a((InputStream) obj, file);
    }
}
