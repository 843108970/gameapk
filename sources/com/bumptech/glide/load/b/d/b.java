package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.b.j;
import com.bumptech.glide.load.b.d.d;
import com.bumptech.glide.util.k;
import java.util.HashMap;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final j f1110a;

    /* renamed from: b  reason: collision with root package name */
    public final e f1111b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bumptech.glide.load.b f1112c;
    public final Handler d = new Handler(Looper.getMainLooper());
    public a e;

    public b(j jVar, e eVar, com.bumptech.glide.load.b bVar) {
        this.f1110a = jVar;
        this.f1111b = eVar;
        this.f1112c = bVar;
    }

    private static int a(d dVar) {
        return k.a(dVar.f1117b, dVar.f1118c, dVar.d);
    }

    @VisibleForTesting
    private c a(d... dVarArr) {
        long b2 = (this.f1110a.b() - this.f1110a.a()) + this.f1111b.a();
        int i = 0;
        for (d dVar : dVarArr) {
            i += dVar.e;
        }
        float f = ((float) b2) / ((float) i);
        HashMap hashMap = new HashMap();
        for (d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(((float) dVar2.e) * f) / k.a(dVar2.f1117b, dVar2.f1118c, dVar2.d)));
        }
        return new c(hashMap);
    }

    private void a(d.a... aVarArr) {
        if (this.e != null) {
            this.e.f = true;
        }
        d[] dVarArr = new d[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            d.a aVar = aVarArr[i];
            if (aVar.f1121c == null) {
                aVar.f1121c = this.f1112c == com.bumptech.glide.load.b.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            }
            dVarArr[i] = new d(aVar.f1119a, aVar.f1120b, aVar.f1121c, aVar.d);
        }
        long b2 = (this.f1110a.b() - this.f1110a.a()) + this.f1111b.a();
        int i2 = 0;
        for (d dVar : dVarArr) {
            i2 += dVar.e;
        }
        float f = ((float) b2) / ((float) i2);
        HashMap hashMap = new HashMap();
        for (d dVar2 : dVarArr) {
            hashMap.put(dVar2, Integer.valueOf(Math.round(((float) dVar2.e) * f) / k.a(dVar2.f1117b, dVar2.f1118c, dVar2.d)));
        }
        this.e = new a(this.f1111b, this.f1110a, new c(hashMap));
        this.d.post(this.e);
    }
}
