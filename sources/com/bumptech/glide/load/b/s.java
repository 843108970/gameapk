package com.bumptech.glide.load.b;

import android.support.annotation.NonNull;
import android.support.v4.util.Pools;
import com.bumptech.glide.load.a.e;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class s<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f1172a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f1173b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends h<Data, ResourceType, Transcode>> f1174c;
    private final String d;

    public s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f1172a = cls;
        this.f1173b = pool;
        this.f1174c = (List) i.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private u<Transcode> a(e<Data> eVar, @NonNull j jVar, int i, int i2, h.a<ResourceType> aVar, List<Throwable> list) throws p {
        int size = this.f1174c.size();
        u<Transcode> uVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            h hVar = (h) this.f1174c.get(i3);
            try {
                uVar = hVar.f1140a.a(aVar.a(hVar.a(eVar, i, i2, jVar)), jVar);
            } catch (p e) {
                list.add(e);
            }
            if (uVar != null) {
                break;
            }
        }
        if (uVar != null) {
            return uVar;
        }
        throw new p(this.d, (List<Throwable>) new ArrayList(list));
    }

    private Class<Data> a() {
        return this.f1172a;
    }

    public final u<Transcode> a(e<Data> eVar, @NonNull j jVar, int i, int i2, h.a<ResourceType> aVar) throws p {
        List list = (List) i.a(this.f1173b.acquire(), "Argument must not be null");
        try {
            return a(eVar, jVar, i, i2, aVar, list);
        } finally {
            this.f1173b.release(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f1174c.toArray()) + '}';
    }
}
