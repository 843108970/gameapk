package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import android.util.Log;
import com.bumptech.glide.load.d.f.e;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.k;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h<DataType, ResourceType, Transcode> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f1139b = "DecodePath";

    /* renamed from: a  reason: collision with root package name */
    final e<ResourceType, Transcode> f1140a;

    /* renamed from: c  reason: collision with root package name */
    private final Class<DataType> f1141c;
    private final List<? extends k<DataType, ResourceType>> d;
    private final Pools.Pool<List<Throwable>> e;
    private final String f;

    interface a<ResourceType> {
        @NonNull
        u<ResourceType> a(@NonNull u<ResourceType> uVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends k<DataType, ResourceType>> list, e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f1141c = cls;
        this.d = list;
        this.f1140a = eVar;
        this.e = pool;
        this.f = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull j jVar, a<ResourceType> aVar) throws p {
        return this.f1140a.a(aVar.a(a(eVar, i, i2, jVar)), jVar);
    }

    @NonNull
    private u<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull j jVar, List<Throwable> list) throws p {
        int size = this.d.size();
        u<ResourceType> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            k kVar = (k) this.d.get(i3);
            try {
                if (kVar.a(eVar.a(), jVar)) {
                    uVar = kVar.a(eVar.a(), i, i2, jVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable(f1139b, 2)) {
                    Log.v(f1139b, "Failed to decode data for " + kVar, e2);
                }
                list.add(e2);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.f, (List<Throwable>) new ArrayList(list));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final u<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i, int i2, @NonNull j jVar) throws p {
        List list = (List) i.a(this.e.acquire(), "Argument must not be null");
        try {
            return a(eVar, i, i2, jVar, (List<Throwable>) list);
        } finally {
            this.e.release(list);
        }
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f1141c + ", decoders=" + this.d + ", transcoder=" + this.f1140a + '}';
    }
}
