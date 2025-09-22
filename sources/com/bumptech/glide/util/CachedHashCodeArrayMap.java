package com.bumptech.glide.util;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;

public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private int f1471a;

    public final void clear() {
        this.f1471a = 0;
        super.clear();
    }

    public final int hashCode() {
        if (this.f1471a == 0) {
            this.f1471a = super.hashCode();
        }
        return this.f1471a;
    }

    public final V put(K k, V v) {
        this.f1471a = 0;
        return super.put(k, v);
    }

    public final void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f1471a = 0;
        super.putAll(simpleArrayMap);
    }

    public final V removeAt(int i) {
        this.f1471a = 0;
        return super.removeAt(i);
    }

    public final V setValueAt(int i, V v) {
        this.f1471a = 0;
        return super.setValueAt(i, v);
    }
}
