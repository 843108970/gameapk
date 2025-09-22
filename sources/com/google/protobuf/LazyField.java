package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

class LazyField {
    private ByteString bytes;
    private final MessageLite defaultInstance;
    private final ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty = false;
    private volatile MessageLite value;

    static class LazyEntry<K> implements Map.Entry<K, Object> {
        private Map.Entry<K, LazyField> entry;

        private LazyEntry(Map.Entry<K, LazyField> entry2) {
            this.entry = entry2;
        }

        /* synthetic */ LazyEntry(Map.Entry entry2, LazyEntry lazyEntry) {
            this(entry2);
        }

        public LazyField getField() {
            return this.entry.getValue();
        }

        public K getKey() {
            return this.entry.getKey();
        }

        public Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.entry.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        private Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.iterator = it;
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.iterator.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next, (LazyEntry) null) : next;
        }

        public void remove() {
            this.iterator.remove();
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        this.defaultInstance = messageLite;
        this.extensionRegistry = extensionRegistryLite;
        this.bytes = byteString;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(1:12)|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ensureInitialized() {
        /*
            r3 = this;
            com.google.protobuf.MessageLite r0 = r3.value
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.MessageLite r0 = r3.value     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x000c:
            com.google.protobuf.ByteString r0 = r3.bytes     // Catch:{ IOException -> 0x0022 }
            if (r0 == 0) goto L_0x0022
            com.google.protobuf.MessageLite r0 = r3.defaultInstance     // Catch:{ IOException -> 0x0022 }
            com.google.protobuf.Parser r0 = r0.getParserForType()     // Catch:{ IOException -> 0x0022 }
            com.google.protobuf.ByteString r1 = r3.bytes     // Catch:{ IOException -> 0x0022 }
            com.google.protobuf.ExtensionRegistryLite r2 = r3.extensionRegistry     // Catch:{ IOException -> 0x0022 }
            java.lang.Object r0 = r0.parseFrom((com.google.protobuf.ByteString) r1, (com.google.protobuf.ExtensionRegistryLite) r2)     // Catch:{ IOException -> 0x0022 }
            com.google.protobuf.MessageLite r0 = (com.google.protobuf.MessageLite) r0     // Catch:{ IOException -> 0x0022 }
            r3.value = r0     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyField.ensureInitialized():void");
    }

    public boolean equals(Object obj) {
        ensureInitialized();
        return this.value.equals(obj);
    }

    public int getSerializedSize() {
        return this.isDirty ? this.value.getSerializedSize() : this.bytes.size();
    }

    public MessageLite getValue() {
        ensureInitialized();
        return this.value;
    }

    public int hashCode() {
        ensureInitialized();
        return this.value.hashCode();
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (!this.isDirty) {
            return this.bytes;
        }
        synchronized (this) {
            if (!this.isDirty) {
                ByteString byteString = this.bytes;
                return byteString;
            }
            this.bytes = this.value.toByteString();
            this.isDirty = false;
            ByteString byteString2 = this.bytes;
            return byteString2;
        }
    }

    public String toString() {
        ensureInitialized();
        return this.value.toString();
    }
}
