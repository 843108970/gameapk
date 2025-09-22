package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType = null;
    private static final long serialVersionUID = 1;

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        protected Builder() {
        }

        public BuilderType clear() {
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return codedInputStream.skipField(i);
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();
        private boolean extensionsIsMutable;

        protected ExtendableBuilder() {
        }

        /* access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(generatedExtension.descriptor, type);
            return this;
        }

        public BuilderType clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (ExtendableBuilder) super.clear();
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(generatedExtension.descriptor);
            return this;
        }

        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type field = this.extensions.getField(generatedExtension.descriptor);
            return field == null ? generatedExtension.defaultValue : field;
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        /* access modifiers changed from: protected */
        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(messagetype.extensions);
        }

        /* access modifiers changed from: protected */
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            ensureExtensionsIsMutable();
            return GeneratedMessageLite.parseUnknownField(this.extensions, (ExtendableMessage) getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(generatedExtension.descriptor, i, type);
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(generatedExtension.descriptor, type);
            return this;
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        /* access modifiers changed from: private */
        public final FieldSet<ExtensionDescriptor> extensions;

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

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
                    ExtensionDescriptor key = this.next.getKey();
                    if (!this.messageSetWireFormat || key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated()) {
                        FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                    } else {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                    }
                    this.next = this.iter.hasNext() ? this.iter.next() : null;
                }
            }
        }

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
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

        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type field = this.extensions.getField(generatedExtension.descriptor);
            return field == null ? generatedExtension.defaultValue : field;
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
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
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
        }
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    private static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        private final Internal.EnumLiteMap<?> enumTypeMap;
        private final boolean isPacked;
        /* access modifiers changed from: private */
        public final boolean isRepeated;
        private final int number;
        /* access modifiers changed from: private */
        public final WireFormat.FieldType type;

        private ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        /* synthetic */ ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2, ExtensionDescriptor extensionDescriptor) {
            this(enumLiteMap, i, fieldType, z, z2);
        }

        public final int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }

        public final Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        public final WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        public final WireFormat.FieldType getLiteType() {
            return this.type;
        }

        public final int getNumber() {
            return this.number;
        }

        public final MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        public final boolean isPacked() {
            return this.isPacked;
        }

        public final boolean isRepeated() {
            return this.isRepeated;
        }
    }

    public static final class GeneratedExtension<ContainingType extends MessageLite, Type> {
        private final ContainingType containingTypeDefaultInstance;
        /* access modifiers changed from: private */
        public final Type defaultValue;
        /* access modifiers changed from: private */
        public final ExtensionDescriptor descriptor;
        /* access modifiers changed from: private */
        public final MessageLite messageDefaultInstance;

        private GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
            }
        }

        /* synthetic */ GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor, GeneratedExtension generatedExtension) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public final ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public final MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public final int getNumber() {
            return this.descriptor.getNumber();
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        /* access modifiers changed from: protected */
        public final Object readResolve() throws ObjectStreamException {
            try {
                MessageLite.Builder builder = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke((Object) null, new Object[0]);
                builder.mergeFrom(this.asBytes);
                return builder.buildPartial();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to find proto buffer class", e);
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException("Unable to find newBuilder method", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call newBuilder method", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Error calling newBuilder", e4.getCause());
            } catch (InvalidProtocolBufferException e5) {
                throw new RuntimeException("Unable to understand proto buffer", e5);
            }
        }
    }

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
    static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType() {
        /*
            int[] r0 = $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            com.google.protobuf.WireFormat$JavaType[] r0 = com.google.protobuf.WireFormat.JavaType.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0015 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0015 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
        L_0x0015:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.BYTE_STRING     // Catch:{ NoSuchFieldError -> 0x001e }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001e }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001e }
        L_0x001e:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0027 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.ENUM     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.FLOAT     // Catch:{ NoSuchFieldError -> 0x003a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003a }
        L_0x003a:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.INT     // Catch:{ NoSuchFieldError -> 0x0043 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
        L_0x0043:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.LONG     // Catch:{ NoSuchFieldError -> 0x004c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
        L_0x004c:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0056 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 9
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            com.google.protobuf.WireFormat$JavaType r1 = com.google.protobuf.WireFormat.JavaType.STRING     // Catch:{ NoSuchFieldError -> 0x005f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
        L_0x005f:
            $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.$SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType():int[]");
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder builder) {
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z) {
        return new GeneratedExtension(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z, (ExtensionDescriptor) null), (GeneratedExtension) null);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType) {
        return new GeneratedExtension(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false, (ExtensionDescriptor) null), (GeneratedExtension) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <MessageType extends com.google.protobuf.MessageLite> boolean parseUnknownField(com.google.protobuf.FieldSet<com.google.protobuf.GeneratedMessageLite.ExtensionDescriptor> r4, MessageType r5, com.google.protobuf.CodedInputStream r6, com.google.protobuf.ExtensionRegistryLite r7, int r8) throws java.io.IOException {
        /*
            int r0 = com.google.protobuf.WireFormat.getTagWireType(r8)
            int r1 = com.google.protobuf.WireFormat.getTagFieldNumber(r8)
            com.google.protobuf.GeneratedMessageLite$GeneratedExtension r5 = r7.findLiteExtensionByNumber(r5, r1)
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L_0x0048
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
            int r3 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r3, r1)
            if (r0 != r3) goto L_0x0020
            r0 = 0
            goto L_0x004a
        L_0x0020:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r5.descriptor
            boolean r3 = r3.isRepeated
            if (r3 == 0) goto L_0x0048
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r3 = r3.type
            boolean r3 = r3.isPackable()
            if (r3 == 0) goto L_0x0048
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r3 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r3 = r3.getLiteType()
            int r3 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r3, r2)
            if (r0 != r3) goto L_0x0048
            r0 = 1
            goto L_0x004a
        L_0x0048:
            r0 = 0
            r1 = 1
        L_0x004a:
            if (r1 == 0) goto L_0x0051
            boolean r4 = r6.skipField(r8)
            return r4
        L_0x0051:
            if (r0 == 0) goto L_0x00a7
            int r7 = r6.readRawVarint32()
            int r8 = r6.pushLimit(r7)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
            com.google.protobuf.WireFormat$FieldType r0 = com.google.protobuf.WireFormat.FieldType.ENUM
            if (r7 != r0) goto L_0x0089
        L_0x0067:
            int r7 = r6.getBytesUntilLimit()
            if (r7 > 0) goto L_0x006e
            goto L_0x008f
        L_0x006e:
            int r7 = r6.readEnum()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            com.google.protobuf.Internal$EnumLiteMap r0 = r0.getEnumType()
            com.google.protobuf.Internal$EnumLite r7 = r0.findValueByNumber(r7)
            if (r7 != 0) goto L_0x0081
            return r2
        L_0x0081:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            r4.addRepeatedField(r0, r7)
            goto L_0x0067
        L_0x0089:
            int r7 = r6.getBytesUntilLimit()
            if (r7 > 0) goto L_0x0093
        L_0x008f:
            r6.popLimit(r8)
            return r2
        L_0x0093:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
            java.lang.Object r7 = com.google.protobuf.FieldSet.readPrimitiveField(r6, r7)
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            r4.addRepeatedField(r0, r7)
            goto L_0x0089
        L_0x00a7:
            int[] r8 = $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            com.google.protobuf.WireFormat$JavaType r0 = r0.getLiteJavaType()
            int r0 = r0.ordinal()
            r8 = r8[r0]
            switch(r8) {
                case 8: goto L_0x010a;
                case 9: goto L_0x00c9;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r7 = r7.getLiteType()
            java.lang.Object r6 = com.google.protobuf.FieldSet.readPrimitiveField(r6, r7)
            goto L_0x011d
        L_0x00c9:
            r8 = 0
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            boolean r0 = r0.isRepeated()
            if (r0 != 0) goto L_0x00e4
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            java.lang.Object r0 = r4.getField(r0)
            com.google.protobuf.MessageLite r0 = (com.google.protobuf.MessageLite) r0
            if (r0 == 0) goto L_0x00e4
            com.google.protobuf.MessageLite$Builder r8 = r0.toBuilder()
        L_0x00e4:
            if (r8 != 0) goto L_0x00ee
            com.google.protobuf.MessageLite r8 = r5.messageDefaultInstance
            com.google.protobuf.MessageLite$Builder r8 = r8.newBuilderForType()
        L_0x00ee:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r0 = r5.descriptor
            com.google.protobuf.WireFormat$FieldType r0 = r0.getLiteType()
            com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.GROUP
            if (r0 != r1) goto L_0x0102
            int r0 = r5.getNumber()
            r6.readGroup((int) r0, (com.google.protobuf.MessageLite.Builder) r8, (com.google.protobuf.ExtensionRegistryLite) r7)
            goto L_0x0105
        L_0x0102:
            r6.readMessage((com.google.protobuf.MessageLite.Builder) r8, (com.google.protobuf.ExtensionRegistryLite) r7)
        L_0x0105:
            com.google.protobuf.MessageLite r6 = r8.build()
            goto L_0x011d
        L_0x010a:
            int r6 = r6.readEnum()
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r5.descriptor
            com.google.protobuf.Internal$EnumLiteMap r7 = r7.getEnumType()
            com.google.protobuf.Internal$EnumLite r6 = r7.findValueByNumber(r6)
            if (r6 != 0) goto L_0x011d
            return r2
        L_0x011d:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r7 = r5.descriptor
            boolean r7 = r7.isRepeated()
            if (r7 == 0) goto L_0x012f
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r5.descriptor
            r4.addRepeatedField(r5, r6)
            return r2
        L_0x012f:
            com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor r5 = r5.descriptor
            r4.setField(r5, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.GeneratedMessageLite.parseUnknownField(com.google.protobuf.FieldSet, com.google.protobuf.MessageLite, com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite, int):boolean");
    }

    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* access modifiers changed from: protected */
    public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return codedInputStream.skipField(i);
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }
}
