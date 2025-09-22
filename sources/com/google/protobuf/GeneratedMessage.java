package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    /* access modifiers changed from: protected */
    public static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;

    public static abstract class Builder<BuilderType extends Builder> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        private class BuilderParentImpl implements BuilderParent {
            private BuilderParentImpl() {
            }

            /* synthetic */ BuilderParentImpl(Builder builder, BuilderParentImpl builderParentImpl) {
                this();
            }

            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        protected Builder() {
            this((BuilderParent) null);
        }

        protected Builder(BuilderParent builderParent2) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent2;
        }

        /* access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            List list;
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor next : internalGetFieldAccessorTable().descriptor.getFields()) {
                if (next.isRepeated()) {
                    List list2 = (List) getField(next);
                    boolean isEmpty = list2.isEmpty();
                    list = list2;
                    if (isEmpty) {
                    }
                } else if (hasField(next)) {
                    list = getField(next);
                }
                treeMap.put(next, list);
            }
            return treeMap;
        }

        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).addRepeated(this, obj);
            return this;
        }

        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).clear(this);
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* access modifiers changed from: package-private */
        public void dispose() {
            this.builderParent = null;
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            Object obj = internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
            return fieldDescriptor.isRepeated() ? Collections.unmodifiableList((List) obj) : obj;
        }

        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getBuilder(this);
        }

        /* access modifiers changed from: protected */
        public BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl(this, (BuilderParentImpl) null);
            }
            return this.meAsParent;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
        }

        /* access modifiers changed from: protected */
        public abstract FieldAccessorTable internalGetFieldAccessorTable();

        /* access modifiers changed from: protected */
        public boolean isClean() {
            return this.isClean;
        }

        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor next : getDescriptorForType().getFields()) {
                if (next.isRequired() && !hasField(next)) {
                    return false;
                }
                if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (next.isRepeated()) {
                        for (Message isInitialized : (List) getField(next)) {
                            if (!isInitialized.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(next) && !((Message) getField(next)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public void markClean() {
            this.isClean = true;
        }

        public final BuilderType mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFieldSet).build();
            onChanged();
            return this;
        }

        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor) {
            return internalGetFieldAccessorTable().getField(fieldDescriptor).newBuilder();
        }

        /* access modifiers changed from: protected */
        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* access modifiers changed from: protected */
        public final void onChanged() {
            if (this.isClean && this.builderParent != null) {
                this.builderParent.markDirty();
                this.isClean = false;
            }
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return builder.mergeFieldFrom(i, codedInputStream);
        }

        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).set(this, obj);
            return this;
        }

        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            internalGetFieldAccessorTable().getField(fieldDescriptor).setRepeated(this, i, obj);
            return this;
        }

        public final BuilderType setUnknownFields(UnknownFieldSet unknownFieldSet) {
            this.unknownFields = unknownFieldSet;
            onChanged();
            return this;
        }
    }

    protected interface BuilderParent {
        void markDirty();
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.emptySet();

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(BuilderParent builderParent) {
            super(builderParent);
        }

        /* access modifiers changed from: private */
        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + generatedExtension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(generatedExtension.getDescriptor(), generatedExtension.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public BuilderType addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.addRepeatedField(fieldDescriptor, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (ExtendableBuilder) super.clear();
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(generatedExtension.getDescriptor());
            onChanged();
            return this;
        }

        public BuilderType clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.clearField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.clearField(fieldDescriptor);
            onChanged();
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map access$13 = getAllFieldsMutable();
            access$13.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(access$13);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Descriptors.FieldDescriptor descriptor = generatedExtension.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            return field == null ? descriptor.isRepeated() ? Collections.emptyList() : descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? generatedExtension.getMessageDefaultInstance() : generatedExtension.fromReflectionType(descriptor.getDefaultValue()) : generatedExtension.fromReflectionType(field);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.singularFromReflectionType(this.extensions.getRepeatedField(generatedExtension.getDescriptor(), i));
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.getDescriptor());
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            Object field = this.extensions.getField(fieldDescriptor);
            return field == null ? fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()) : fieldDescriptor.getDefaultValue() : field;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedField(fieldDescriptor, i);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedFieldCount(fieldDescriptor);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.getDescriptor());
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.hasField(fieldDescriptor);
        }

        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(ExtendableMessage extendableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(extendableMessage.extensions);
            onChanged();
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return AbstractMessage.Builder.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), this, (FieldSet<Descriptors.FieldDescriptor>) null, i);
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(generatedExtension.getDescriptor(), i, generatedExtension.singularToReflectionType(type));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(generatedExtension.getDescriptor(), generatedExtension.toReflectionType(type));
            onChanged();
            return this;
        }

        public BuilderType setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.setField(fieldDescriptor, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.setField(fieldDescriptor, obj);
            onChanged();
            return this;
        }

        public BuilderType setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            if (!fieldDescriptor.isExtension()) {
                return (ExtendableBuilder) super.setRepeatedField(fieldDescriptor, i, obj);
            }
            verifyContainingType(fieldDescriptor);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(fieldDescriptor, i, obj);
            onChanged();
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        /* access modifiers changed from: private */
        public final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, ExtensionWriter extensionWriter) {
                this(z);
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (this.next != null && this.next.getKey().getNumber() < i) {
                    Descriptors.FieldDescriptor key = this.next.getKey();
                    if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                        FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                    } else if (this.next instanceof LazyField.LazyEntry) {
                        codedOutputStream.writeRawMessageSetExtension(key.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                    } else {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (Message) this.next.getValue());
                    }
                    this.next = this.iter.hasNext() ? this.iter.next() : null;
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super(extendableBuilder);
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + generatedExtension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        /* access modifiers changed from: protected */
        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map access$0 = getAllFieldsMutable();
            access$0.putAll(getExtensionFields());
            return Collections.unmodifiableMap(access$0);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Descriptors.FieldDescriptor descriptor = generatedExtension.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            return field == null ? descriptor.isRepeated() ? Collections.emptyList() : descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? generatedExtension.getMessageDefaultInstance() : generatedExtension.fromReflectionType(descriptor.getDefaultValue()) : generatedExtension.fromReflectionType(field);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return generatedExtension.singularFromReflectionType(this.extensions.getRepeatedField(generatedExtension.getDescriptor(), i));
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.getDescriptor());
        }

        /* access modifiers changed from: protected */
        public Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            Object field = this.extensions.getField(fieldDescriptor);
            return field == null ? fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE ? DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()) : fieldDescriptor.getDefaultValue() : field;
        }

        public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getRepeatedField(fieldDescriptor, i);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedField(fieldDescriptor, i);
        }

        public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.getRepeatedFieldCount(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.getRepeatedFieldCount(fieldDescriptor);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.getDescriptor());
        }

        public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (!fieldDescriptor.isExtension()) {
                return GeneratedMessage.super.hasField(fieldDescriptor);
            }
            verifyContainingType(fieldDescriptor);
            return this.extensions.hasField(fieldDescriptor);
        }

        public boolean isInitialized() {
            return GeneratedMessage.super.isInitialized() && extensionsAreInitialized();
        }

        /* access modifiers changed from: protected */
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, (ExtensionWriter) null);
        }

        /* access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, (ExtensionWriter) null);
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return AbstractMessage.Builder.mergeFieldFrom(codedInputStream, builder, extensionRegistryLite, getDescriptorForType(), (Message.Builder) null, this.extensions, i);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    private interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    public static final class FieldAccessorTable {
        private String[] camelCaseNames;
        /* access modifiers changed from: private */
        public final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private volatile boolean initialized;

        private interface FieldAccessor {
            void addRepeated(Builder builder, Object obj);

            void clear(Builder builder);

            Object get(Builder builder);

            Object get(GeneratedMessage generatedMessage);

            Message.Builder getBuilder(Builder builder);

            Object getRepeated(Builder builder, int i);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            int getRepeatedCount(Builder builder);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            boolean has(Builder builder);

            boolean has(GeneratedMessage generatedMessage);

            Message.Builder newBuilder();

            void set(Builder builder, Object obj);

            void setRepeated(Builder builder, int i, Object obj);
        }

        private static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private final Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private final Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
            }

            public final void addRepeated(Builder builder, Object obj) {
                super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, (Object) null, obj));
            }

            public final Object get(Builder builder) {
                ArrayList arrayList = new ArrayList();
                for (Object access$2 : (List) super.get(builder)) {
                    arrayList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, access$2, new Object[0]));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final Object get(GeneratedMessage generatedMessage) {
                ArrayList arrayList = new ArrayList();
                for (Object access$2 : (List) super.get(generatedMessage)) {
                    arrayList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, access$2, new Object[0]));
                }
                return Collections.unmodifiableList(arrayList);
            }

            public final Object getRepeated(Builder builder, int i) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, i), new Object[0]);
            }

            public final Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(generatedMessage, i), new Object[0]);
            }

            public final void setRepeated(Builder builder, int i, Object obj) {
                super.setRepeated(builder, i, GeneratedMessage.invokeOrDie(this.valueOfMethod, (Object) null, obj));
            }
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final Method addRepeatedMethod;
            protected final Method clearMethod;
            protected final Method getCountMethod;
            protected final Method getCountMethodBuilder;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method getRepeatedMethod;
            protected final Method getRepeatedMethodBuilder;
            protected final Method setRepeatedMethod;
            protected final Class type = this.getRepeatedMethod.getReturnType();

            RepeatedFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.getMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "List", new Class[0]);
                StringBuilder sb = new StringBuilder("get");
                sb.append(str);
                this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(cls, sb.toString(), Integer.TYPE);
                this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str, Integer.TYPE);
                this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, "set" + str, Integer.TYPE, this.type);
                this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(cls2, "add" + str, this.type);
                this.getCountMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Count", new Class[0]);
                StringBuilder sb2 = new StringBuilder("clear");
                sb2.append(str);
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, sb2.toString(), new Class[0]);
            }

            public void addRepeated(Builder builder, Object obj) {
                Object unused = GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, obj);
            }

            public void clear(Builder builder) {
                Object unused = GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            public Object get(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
            }

            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            public Object getRepeated(Builder builder, int i) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(i));
            }

            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, generatedMessage, Integer.valueOf(i));
            }

            public int getRepeatedCount(Builder builder) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
            }

            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, generatedMessage, new Object[0])).intValue();
            }

            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public boolean has(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            public void set(Builder builder, Object obj) {
                clear(builder);
                for (Object addRepeated : (List) obj) {
                    addRepeated(builder, addRepeated);
                }
            }

            public void setRepeated(Builder builder, int i, Object obj) {
                Object unused = GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(i), obj);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
            }

            private Object coerceType(Object obj) {
                return this.type.isInstance(obj) ? obj : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, (Object) null, new Object[0])).mergeFrom((Message) obj).build();
            }

            public final void addRepeated(Builder builder, Object obj) {
                super.addRepeated(builder, coerceType(obj));
            }

            public final Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, (Object) null, new Object[0]);
            }

            public final void setRepeated(Builder builder, int i, Object obj) {
                super.setRepeated(builder, i, coerceType(obj));
            }
        }

        private static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
            }

            public final Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new Object[0]);
            }

            public final Object get(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(generatedMessage), new Object[0]);
            }

            public final void set(Builder builder, Object obj) {
                super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, (Object) null, obj));
            }
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Method clearMethod;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method hasMethod;
            protected final Method hasMethodBuilder;
            protected final Method setMethod;
            protected final Class<?> type = this.getMethod.getReturnType();

            SingularFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                this.getMethod = GeneratedMessage.getMethodOrDie(cls, "get" + str, new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str, new Class[0]);
                this.setMethod = GeneratedMessage.getMethodOrDie(cls2, "set" + str, this.type);
                this.hasMethod = GeneratedMessage.getMethodOrDie(cls, "has" + str, new Class[0]);
                this.hasMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "has" + str, new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(cls2, "clear" + str, new Class[0]);
            }

            public void addRepeated(Builder builder, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            public void clear(Builder builder) {
                Object unused = GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            public Object get(GeneratedMessage generatedMessage) {
                return GeneratedMessage.invokeOrDie(this.getMethod, generatedMessage, new Object[0]);
            }

            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            public Object getRepeated(Builder builder, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            public Object getRepeated(GeneratedMessage generatedMessage, int i) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            public int getRepeatedCount(Builder builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            public int getRepeatedCount(GeneratedMessage generatedMessage) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            public boolean has(Builder builder) {
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
            }

            public boolean has(GeneratedMessage generatedMessage) {
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, generatedMessage, new Object[0])).booleanValue();
            }

            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            public void set(Builder builder, Object obj) {
                Object unused = GeneratedMessage.invokeOrDie(this.setMethod, builder, obj);
            }

            public void setRepeated(Builder builder, int i, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method getBuilderMethodBuilder;
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object coerceType(Object obj) {
                return this.type.isInstance(obj) ? obj : ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, (Object) null, new Object[0])).mergeFrom((Message) obj).buildPartial();
            }

            public final Message.Builder getBuilder(Builder builder) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new Object[0]);
            }

            public final Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, (Object) null, new Object[0]);
            }

            public final void set(Builder builder, Object obj) {
                super.set(builder, coerceType(obj));
            }
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor2, String[] strArr) {
            this.descriptor = descriptor2;
            this.camelCaseNames = strArr;
            this.fields = new FieldAccessor[descriptor2.getFields().size()];
            this.initialized = false;
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor2, String[] strArr, Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
            this(descriptor2, strArr);
            ensureFieldAccessorsInitialized(cls, cls2);
        }

        /* access modifiers changed from: private */
        public FieldAccessor getField(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!fieldDescriptor.isExtension()) {
                return this.fields[fieldDescriptor.getIndex()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        public final FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> cls, Class<? extends Builder> cls2) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                if (this.initialized) {
                    return this;
                }
                for (int i = 0; i < this.fields.length; i++) {
                    Descriptors.FieldDescriptor fieldDescriptor = this.descriptor.getFields().get(i);
                    if (fieldDescriptor.isRepeated()) {
                        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            this.fields[i] = new RepeatedMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                        } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i] = new RepeatedEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                        } else {
                            this.fields[i] = new RepeatedFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                        }
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new SingularMessageFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                    } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new SingularEnumFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                    } else {
                        this.fields[i] = new SingularFieldAccessor(fieldDescriptor, this.camelCaseNames[i], cls, cls2);
                    }
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }
    }

    public static final class GeneratedExtension<ContainingType extends Message, Type> {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType;
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final Method enumGetValueDescriptor;
        private final Method enumValueOf;
        private final Message messageDefaultInstance;
        private final Class singularType;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0031 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType() {
            /*
                int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0015 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x001e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
            L_0x001e:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x003a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003a }
            L_0x003a:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r1 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessage.GeneratedExtension.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType():int[]");
        }

        private GeneratedExtension(ExtensionDescriptorRetriever extensionDescriptorRetriever, Class cls, Message message) {
            Method method;
            if (!Message.class.isAssignableFrom(cls) || cls.isInstance(message)) {
                this.descriptorRetriever = extensionDescriptorRetriever;
                this.singularType = cls;
                this.messageDefaultInstance = message;
                if (ProtocolMessageEnum.class.isAssignableFrom(cls)) {
                    this.enumValueOf = GeneratedMessage.getMethodOrDie(cls, "valueOf", Descriptors.EnumValueDescriptor.class);
                    method = GeneratedMessage.getMethodOrDie(cls, "getValueDescriptor", new Class[0]);
                } else {
                    method = null;
                    this.enumValueOf = null;
                }
                this.enumGetValueDescriptor = method;
                return;
            }
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + cls.getName());
        }

        /* synthetic */ GeneratedExtension(ExtensionDescriptorRetriever extensionDescriptorRetriever, Class cls, Message message, GeneratedExtension generatedExtension) {
            this(extensionDescriptorRetriever, cls, message);
        }

        /* access modifiers changed from: private */
        public Object fromReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularFromReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularFromReflectionType : (List) obj) {
                arrayList.add(singularFromReflectionType(singularFromReflectionType));
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public Object singularFromReflectionType(Object obj) {
            switch ($SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType()[getDescriptor().getJavaType().ordinal()]) {
                case 8:
                    return GeneratedMessage.invokeOrDie(this.enumValueOf, (Object) null, (Descriptors.EnumValueDescriptor) obj);
                case 9:
                    return this.singularType.isInstance(obj) ? obj : this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) obj).build();
                default:
                    return obj;
            }
        }

        /* access modifiers changed from: private */
        public Object singularToReflectionType(Object obj) {
            return $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType()[getDescriptor().getJavaType().ordinal()] != 8 ? obj : GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, obj, new Object[0]);
        }

        /* access modifiers changed from: private */
        public Object toReflectionType(Object obj) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularToReflectionType(obj);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            for (Object singularToReflectionType : (List) obj) {
                arrayList.add(singularToReflectionType(singularToReflectionType));
            }
            return arrayList;
        }

        public final Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptorRetriever != null) {
                return this.descriptorRetriever.getDescriptor();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        public final Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public final void internalInit(final Descriptors.FieldDescriptor fieldDescriptor) {
            if (this.descriptorRetriever != null) {
                throw new IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new ExtensionDescriptorRetriever() {
                public Descriptors.FieldDescriptor getDescriptor() {
                    return fieldDescriptor;
                }
            };
        }
    }

    protected GeneratedMessage() {
    }

    protected GeneratedMessage(Builder<?> builder) {
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    /* access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
        List list;
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor next : internalGetFieldAccessorTable().descriptor.getFields()) {
            if (next.isRepeated()) {
                List list2 = (List) getField(next);
                boolean isEmpty = list2.isEmpty();
                list = list2;
                if (isEmpty) {
                }
            } else if (hasField(next)) {
                list = getField(next);
            }
            treeMap.put(next, list);
        }
        return treeMap;
    }

    /* access modifiers changed from: private */
    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    /* access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, Message message) {
        return new GeneratedExtension<>((ExtensionDescriptorRetriever) null, cls, message, (GeneratedExtension) null);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message message, final int i, Class cls, Message message2) {
        return new GeneratedExtension<>(new ExtensionDescriptorRetriever() {
            public Descriptors.FieldDescriptor getDescriptor() {
                return Message.this.getDescriptorForType().getExtensions().get(i);
            }
        }, cls, message2, (GeneratedExtension) null);
    }

    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable());
    }

    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    public Object getField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).get(this);
    }

    public Parser<? extends Message> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object getRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeated(this, i);
    }

    public int getRepeatedFieldCount(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).getRepeatedCount(this);
    }

    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public boolean hasField(Descriptors.FieldDescriptor fieldDescriptor) {
        return internalGetFieldAccessorTable().getField(fieldDescriptor).has(this);
    }

    /* access modifiers changed from: protected */
    public abstract FieldAccessorTable internalGetFieldAccessorTable();

    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor next : getDescriptorForType().getFields()) {
            if (next.isRequired() && !hasField(next)) {
                return false;
            }
            if (next.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (next.isRepeated()) {
                    for (Message isInitialized : (List) getField(next)) {
                        if (!isInitialized.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(next) && !((Message) getField(next)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* access modifiers changed from: protected */
    public abstract Message.Builder newBuilderForType(BuilderParent builderParent);

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return builder.mergeFieldFrom(i, codedInputStream);
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }
}
