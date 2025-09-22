package com.bumptech.glide.load.b.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final Map<d, Integer> f1113a;

    /* renamed from: b  reason: collision with root package name */
    final List<d> f1114b;

    /* renamed from: c  reason: collision with root package name */
    int f1115c;
    int d;

    public c(Map<d, Integer> map) {
        this.f1113a = map;
        this.f1114b = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.f1115c += intValue.intValue();
        }
    }

    private d b() {
        d dVar = this.f1114b.get(this.d);
        Integer num = this.f1113a.get(dVar);
        if (num.intValue() == 1) {
            this.f1113a.remove(dVar);
            this.f1114b.remove(this.d);
        } else {
            this.f1113a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f1115c--;
        this.d = this.f1114b.isEmpty() ? 0 : (this.d + 1) % this.f1114b.size();
        return dVar;
    }

    private int c() {
        return this.f1115c;
    }

    public final boolean a() {
        return this.f1115c == 0;
    }
}
