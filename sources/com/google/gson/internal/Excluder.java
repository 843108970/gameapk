package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private boolean serializeInnerClasses = true;
    private double version = IGNORE_VERSIONS;

    private boolean isAnonymousOrLocal(Class<?> cls) {
        if (!Enum.class.isAssignableFrom(cls)) {
            return cls.isAnonymousClass() || cls.isLocalClass();
        }
        return false;
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    /* access modifiers changed from: protected */
    public final Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (!excludeClass && !excludeClass2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {
            private TypeAdapter<T> delegate;

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> delegateAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                this.delegate = delegateAdapter;
                return delegateAdapter;
            }

            public T read(JsonReader jsonReader) throws IOException {
                if (!excludeClass2) {
                    return delegate().read(jsonReader);
                }
                jsonReader.skipValue();
                return null;
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (excludeClass) {
                    jsonWriter.nullValue();
                } else {
                    delegate().write(jsonWriter, t);
                }
            }
        };
    }

    public final Excluder disableInnerClassSerialization() {
        Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public final boolean excludeClass(Class<?> cls, boolean z) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        for (ExclusionStrategy shouldSkipClass : z ? this.serializationStrategies : this.deserializationStrategies) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r0.deserialize() == false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean excludeField(java.lang.reflect.Field r7, boolean r8) {
        /*
            r6 = this;
            int r0 = r6.modifiers
            int r1 = r7.getModifiers()
            r0 = r0 & r1
            r1 = 1
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            double r2 = r6.version
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x002a
            java.lang.Class<com.google.gson.annotations.Since> r0 = com.google.gson.annotations.Since.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            com.google.gson.annotations.Since r0 = (com.google.gson.annotations.Since) r0
            java.lang.Class<com.google.gson.annotations.Until> r2 = com.google.gson.annotations.Until.class
            java.lang.annotation.Annotation r2 = r7.getAnnotation(r2)
            com.google.gson.annotations.Until r2 = (com.google.gson.annotations.Until) r2
            boolean r0 = r6.isValidVersion(r0, r2)
            if (r0 != 0) goto L_0x002a
            return r1
        L_0x002a:
            boolean r0 = r7.isSynthetic()
            if (r0 == 0) goto L_0x0031
            return r1
        L_0x0031:
            boolean r0 = r6.requireExpose
            if (r0 == 0) goto L_0x004f
            java.lang.Class<com.google.gson.annotations.Expose> r0 = com.google.gson.annotations.Expose.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            com.google.gson.annotations.Expose r0 = (com.google.gson.annotations.Expose) r0
            if (r0 == 0) goto L_0x004e
            if (r8 == 0) goto L_0x0048
            boolean r0 = r0.serialize()
            if (r0 != 0) goto L_0x004f
            return r1
        L_0x0048:
            boolean r0 = r0.deserialize()
            if (r0 != 0) goto L_0x004f
        L_0x004e:
            return r1
        L_0x004f:
            boolean r0 = r6.serializeInnerClasses
            if (r0 != 0) goto L_0x005e
            java.lang.Class r0 = r7.getType()
            boolean r0 = r6.isInnerClass(r0)
            if (r0 == 0) goto L_0x005e
            return r1
        L_0x005e:
            java.lang.Class r0 = r7.getType()
            boolean r0 = r6.isAnonymousOrLocal(r0)
            if (r0 == 0) goto L_0x0069
            return r1
        L_0x0069:
            if (r8 == 0) goto L_0x006e
            java.util.List<com.google.gson.ExclusionStrategy> r8 = r6.serializationStrategies
            goto L_0x0070
        L_0x006e:
            java.util.List<com.google.gson.ExclusionStrategy> r8 = r6.deserializationStrategies
        L_0x0070:
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0092
            com.google.gson.FieldAttributes r0 = new com.google.gson.FieldAttributes
            r0.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L_0x007f:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0092
            java.lang.Object r8 = r7.next()
            com.google.gson.ExclusionStrategy r8 = (com.google.gson.ExclusionStrategy) r8
            boolean r8 = r8.shouldSkipField(r0)
            if (r8 == 0) goto L_0x007f
            return r1
        L_0x0092:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.Excluder.excludeField(java.lang.reflect.Field, boolean):boolean");
    }

    public final Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    public final Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            clone.serializationStrategies = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies.add(exclusionStrategy);
        }
        if (z2) {
            clone.deserializationStrategies = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies.add(exclusionStrategy);
        }
        return clone;
    }

    public final Excluder withModifiers(int... iArr) {
        Excluder clone = clone();
        clone.modifiers = 0;
        for (int i : iArr) {
            clone.modifiers = i | clone.modifiers;
        }
        return clone;
    }

    public final Excluder withVersion(double d) {
        Excluder clone = clone();
        clone.version = d;
        return clone;
    }
}
