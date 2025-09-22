package com.lidroid.xutils.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruMemoryCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private KeyExpiryMap<K, Long> keyExpiryMap;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
        this.keyExpiryMap = new KeyExpiryMap<>(0, 0.75f);
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf > 0) {
            return sizeOf;
        }
        this.size = 0;
        for (Map.Entry next : this.map.entrySet()) {
            this.size += sizeOf(next.getKey(), next.getValue());
        }
        return sizeOf;
    }

    private void trimToSize(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.size > i) {
                    if (this.map.isEmpty()) {
                        break;
                    }
                    Map.Entry next = this.map.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.map.remove(key);
                    this.keyExpiryMap.remove(key);
                    this.size -= safeSizeOf(key, value);
                    this.evictionCount++;
                }
            }
            entryRemoved(true, key, value, (Object) null);
        }
    }

    public final boolean containsKey(K k) {
        return this.map.containsKey(k);
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
        this.keyExpiryMap.clear();
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        r0 = create(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r0 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.createCount++;
        r1 = r4.map.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (r1 == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
        r4.map.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r4.size += safeSizeOf(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r1 == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        entryRemoved(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        trimToSize(r4.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0062, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000a
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r0 = "key == null"
            r5.<init>(r0)
            throw r5
        L_0x000a:
            monitor-enter(r4)
            com.lidroid.xutils.cache.KeyExpiryMap<K, java.lang.Long> r0 = r4.keyExpiryMap     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ all -> 0x0066 }
            r1 = 0
            if (r0 != 0) goto L_0x0019
            r4.remove(r5)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return r1
        L_0x0019:
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0029
            int r5 = r4.hitCount     // Catch:{ all -> 0x0066 }
            int r5 = r5 + 1
            r4.hitCount = r5     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return r0
        L_0x0029:
            int r0 = r4.missCount     // Catch:{ all -> 0x0066 }
            int r0 = r0 + 1
            r4.missCount = r0     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            java.lang.Object r0 = r4.create(r5)
            if (r0 != 0) goto L_0x0037
            return r1
        L_0x0037:
            monitor-enter(r4)
            int r1 = r4.createCount     // Catch:{ all -> 0x0063 }
            int r1 = r1 + 1
            r4.createCount = r1     // Catch:{ all -> 0x0063 }
            java.util.LinkedHashMap<K, V> r1 = r4.map     // Catch:{ all -> 0x0063 }
            java.lang.Object r1 = r1.put(r5, r0)     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x004c
            java.util.LinkedHashMap<K, V> r2 = r4.map     // Catch:{ all -> 0x0063 }
            r2.put(r5, r1)     // Catch:{ all -> 0x0063 }
            goto L_0x0055
        L_0x004c:
            int r2 = r4.size     // Catch:{ all -> 0x0063 }
            int r3 = r4.safeSizeOf(r5, r0)     // Catch:{ all -> 0x0063 }
            int r2 = r2 + r3
            r4.size = r2     // Catch:{ all -> 0x0063 }
        L_0x0055:
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            if (r1 == 0) goto L_0x005d
            r2 = 0
            r4.entryRemoved(r2, r5, r0, r1)
            return r1
        L_0x005d:
            int r5 = r4.maxSize
            r4.trimToSize(r5)
            return r0
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0063 }
            throw r5
        L_0x0066:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lidroid.xutils.cache.LruMemoryCache.get(java.lang.Object):java.lang.Object");
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final V put(K k, V v) {
        return put(k, v, Long.MAX_VALUE);
    }

    public final V put(K k, V v, long j) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            this.keyExpiryMap.put(k, Long.valueOf(j));
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final V remove(K k) {
        V remove;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.map.remove(k);
            this.keyExpiryMap.remove((Object) k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, (V) null);
        }
        return remove;
    }

    public void setMaxSize(int i) {
        this.maxSize = i;
        trimToSize(i);
    }

    public final synchronized int size() {
        return this.size;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i != 0 ? (this.hitCount * 100) / i : 0)});
    }
}
