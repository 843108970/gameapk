package com.lidroid.xutils.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DoubleKeyValueMap<K1, K2, V> {
    private ConcurrentHashMap<K1, ConcurrentHashMap<K2, V>> k1_k2V_map = new ConcurrentHashMap<>();

    public void clear() {
        if (this.k1_k2V_map.size() > 0) {
            for (ConcurrentHashMap<K2, V> clear : this.k1_k2V_map.values()) {
                clear.clear();
            }
            this.k1_k2V_map.clear();
        }
    }

    public boolean containsKey(K1 k1) {
        return this.k1_k2V_map.containsKey(k1);
    }

    public boolean containsKey(K1 k1, K2 k2) {
        if (this.k1_k2V_map.containsKey(k1)) {
            return this.k1_k2V_map.get(k1).containsKey(k2);
        }
        return false;
    }

    public V get(K1 k1, K2 k2) {
        ConcurrentHashMap concurrentHashMap = this.k1_k2V_map.get(k1);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(k2);
    }

    public ConcurrentHashMap<K2, V> get(K1 k1) {
        return this.k1_k2V_map.get(k1);
    }

    public Collection<V> getAllValues() {
        Set<K1> keySet = this.k1_k2V_map.keySet();
        if (keySet == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (K1 k1 : keySet) {
            Collection values = this.k1_k2V_map.get(k1).values();
            if (values != null) {
                arrayList.addAll(values);
            }
        }
        return arrayList;
    }

    public Collection<V> getAllValues(K1 k1) {
        ConcurrentHashMap concurrentHashMap = this.k1_k2V_map.get(k1);
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.values();
    }

    public Set<K1> getFirstKeys() {
        return this.k1_k2V_map.keySet();
    }

    public void put(K1 k1, K2 k2, V v) {
        ConcurrentHashMap concurrentHashMap;
        if (k1 != null && k2 != null && v != null) {
            if (this.k1_k2V_map.containsKey(k1)) {
                ConcurrentHashMap concurrentHashMap2 = this.k1_k2V_map.get(k1);
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.put(k2, v);
                    return;
                }
                concurrentHashMap = new ConcurrentHashMap();
            } else {
                concurrentHashMap = new ConcurrentHashMap();
            }
            concurrentHashMap.put(k2, v);
            this.k1_k2V_map.put(k1, concurrentHashMap);
        }
    }

    public void remove(K1 k1) {
        this.k1_k2V_map.remove(k1);
    }

    public void remove(K1 k1, K2 k2) {
        ConcurrentHashMap concurrentHashMap = this.k1_k2V_map.get(k1);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(k2);
        }
    }

    public int size() {
        int i = 0;
        if (this.k1_k2V_map.size() == 0) {
            return 0;
        }
        for (ConcurrentHashMap<K2, V> size : this.k1_k2V_map.values()) {
            i += size.size();
        }
        return i;
    }
}
