package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class UnknownFieldSet implements MessageLite {
    private static final Parser PARSER = new Parser();
    private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
    /* access modifiers changed from: private */
    public Map<Integer, Field> fields;

    public static final class Builder implements MessageLite.Builder {
        private Map<Integer, Field> fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private Builder() {
        }

        /* access modifiers changed from: private */
        public static Builder create() {
            Builder builder = new Builder();
            builder.reinitialize();
            return builder;
        }

        private Field.Builder getFieldBuilder(int i) {
            if (this.lastField != null) {
                if (i == this.lastFieldNumber) {
                    return this.lastField;
                }
                addField(this.lastFieldNumber, this.lastField.build());
            }
            if (i == 0) {
                return null;
            }
            Field field = this.fields.get(Integer.valueOf(i));
            this.lastFieldNumber = i;
            this.lastField = Field.newBuilder();
            if (field != null) {
                this.lastField.mergeFrom(field);
            }
            return this.lastField;
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        public final Builder addField(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (this.lastField != null && this.lastFieldNumber == i) {
                this.lastField = null;
                this.lastFieldNumber = 0;
            }
            if (this.fields.isEmpty()) {
                this.fields = new TreeMap();
            }
            this.fields.put(Integer.valueOf(i), field);
            return this;
        }

        public final Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        public final UnknownFieldSet build() {
            getFieldBuilder(0);
            UnknownFieldSet defaultInstance = this.fields.isEmpty() ? UnknownFieldSet.getDefaultInstance() : new UnknownFieldSet(Collections.unmodifiableMap(this.fields), (UnknownFieldSet) null);
            this.fields = null;
            return defaultInstance;
        }

        public final UnknownFieldSet buildPartial() {
            return build();
        }

        public final Builder clear() {
            reinitialize();
            return this;
        }

        public final Builder clone() {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, (UnknownFieldSet) null));
        }

        public final UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public final boolean hasField(int i) {
            if (i != 0) {
                return i == this.lastFieldNumber || this.fields.containsKey(Integer.valueOf(i));
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public final boolean isInitialized() {
            return true;
        }

        public final boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
            return true;
        }

        public final boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeDelimitedFrom(inputStream);
        }

        public final Builder mergeField(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            } else if (hasField(i)) {
                getFieldBuilder(i).mergeFrom(field);
                return this;
            } else {
                addField(i, field);
                return this;
            }
        }

        public final boolean mergeFieldFrom(int i, CodedInputStream codedInputStream) throws IOException {
            int tagFieldNumber = WireFormat.getTagFieldNumber(i);
            switch (WireFormat.getTagWireType(i)) {
                case 0:
                    getFieldBuilder(tagFieldNumber).addVarint(codedInputStream.readInt64());
                    return true;
                case 1:
                    getFieldBuilder(tagFieldNumber).addFixed64(codedInputStream.readFixed64());
                    return true;
                case 2:
                    getFieldBuilder(tagFieldNumber).addLengthDelimited(codedInputStream.readBytes());
                    return true;
                case 3:
                    Builder newBuilder = UnknownFieldSet.newBuilder();
                    codedInputStream.readGroup(tagFieldNumber, (MessageLite.Builder) newBuilder, (ExtensionRegistryLite) ExtensionRegistry.getEmptyRegistry());
                    getFieldBuilder(tagFieldNumber).addGroup(newBuilder.build());
                    return true;
                case 4:
                    return false;
                case 5:
                    getFieldBuilder(tagFieldNumber).addFixed32(codedInputStream.readFixed32());
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        public final Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(byteString);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final com.google.protobuf.UnknownFieldSet.Builder mergeFrom(com.google.protobuf.CodedInputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r2.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.mergeFieldFrom(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.UnknownFieldSet.Builder.mergeFrom(com.google.protobuf.CodedInputStream):com.google.protobuf.UnknownFieldSet$Builder");
        }

        public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(codedInputStream);
        }

        public final Builder mergeFrom(UnknownFieldSet unknownFieldSet) {
            if (unknownFieldSet == UnknownFieldSet.getDefaultInstance()) {
                return this;
            }
            for (Map.Entry entry : unknownFieldSet.fields.entrySet()) {
                mergeField(((Integer) entry.getKey()).intValue(), (Field) entry.getValue());
            }
            return this;
        }

        public final Builder mergeFrom(InputStream inputStream) throws IOException {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        }

        public final Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return mergeFrom(inputStream);
        }

        public final Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        public final Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        public final Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, i, i2);
        }

        public final Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr);
        }

        public final Builder mergeVarintField(int i, int i2) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            getFieldBuilder(i).addVarint((long) i2);
            return this;
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = newBuilder().build();
        /* access modifiers changed from: private */
        public List<Integer> fixed32;
        /* access modifiers changed from: private */
        public List<Long> fixed64;
        /* access modifiers changed from: private */
        public List<UnknownFieldSet> group;
        /* access modifiers changed from: private */
        public List<ByteString> lengthDelimited;
        /* access modifiers changed from: private */
        public List<Long> varint;

        public static final class Builder {
            private Field result;

            private Builder() {
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new Field((Field) null);
                return builder;
            }

            public final Builder addFixed32(int i) {
                if (this.result.fixed32 == null) {
                    this.result.fixed32 = new ArrayList();
                }
                this.result.fixed32.add(Integer.valueOf(i));
                return this;
            }

            public final Builder addFixed64(long j) {
                if (this.result.fixed64 == null) {
                    this.result.fixed64 = new ArrayList();
                }
                this.result.fixed64.add(Long.valueOf(j));
                return this;
            }

            public final Builder addGroup(UnknownFieldSet unknownFieldSet) {
                if (this.result.group == null) {
                    this.result.group = new ArrayList();
                }
                this.result.group.add(unknownFieldSet);
                return this;
            }

            public final Builder addLengthDelimited(ByteString byteString) {
                if (this.result.lengthDelimited == null) {
                    this.result.lengthDelimited = new ArrayList();
                }
                this.result.lengthDelimited.add(byteString);
                return this;
            }

            public final Builder addVarint(long j) {
                if (this.result.varint == null) {
                    this.result.varint = new ArrayList();
                }
                this.result.varint.add(Long.valueOf(j));
                return this;
            }

            public final Field build() {
                Field field;
                List unmodifiableList;
                Field field2;
                List unmodifiableList2;
                Field field3;
                List unmodifiableList3;
                Field field4;
                List unmodifiableList4;
                Field field5;
                List unmodifiableList5;
                if (this.result.varint == null) {
                    field = this.result;
                    unmodifiableList = Collections.emptyList();
                } else {
                    field = this.result;
                    unmodifiableList = Collections.unmodifiableList(this.result.varint);
                }
                field.varint = unmodifiableList;
                if (this.result.fixed32 == null) {
                    field2 = this.result;
                    unmodifiableList2 = Collections.emptyList();
                } else {
                    field2 = this.result;
                    unmodifiableList2 = Collections.unmodifiableList(this.result.fixed32);
                }
                field2.fixed32 = unmodifiableList2;
                if (this.result.fixed64 == null) {
                    field3 = this.result;
                    unmodifiableList3 = Collections.emptyList();
                } else {
                    field3 = this.result;
                    unmodifiableList3 = Collections.unmodifiableList(this.result.fixed64);
                }
                field3.fixed64 = unmodifiableList3;
                if (this.result.lengthDelimited == null) {
                    field4 = this.result;
                    unmodifiableList4 = Collections.emptyList();
                } else {
                    field4 = this.result;
                    unmodifiableList4 = Collections.unmodifiableList(this.result.lengthDelimited);
                }
                field4.lengthDelimited = unmodifiableList4;
                if (this.result.group == null) {
                    field5 = this.result;
                    unmodifiableList5 = Collections.emptyList();
                } else {
                    field5 = this.result;
                    unmodifiableList5 = Collections.unmodifiableList(this.result.group);
                }
                field5.group = unmodifiableList5;
                Field field6 = this.result;
                this.result = null;
                return field6;
            }

            public final Builder clear() {
                this.result = new Field((Field) null);
                return this;
            }

            public final Builder mergeFrom(Field field) {
                if (!field.varint.isEmpty()) {
                    if (this.result.varint == null) {
                        this.result.varint = new ArrayList();
                    }
                    this.result.varint.addAll(field.varint);
                }
                if (!field.fixed32.isEmpty()) {
                    if (this.result.fixed32 == null) {
                        this.result.fixed32 = new ArrayList();
                    }
                    this.result.fixed32.addAll(field.fixed32);
                }
                if (!field.fixed64.isEmpty()) {
                    if (this.result.fixed64 == null) {
                        this.result.fixed64 = new ArrayList();
                    }
                    this.result.fixed64.addAll(field.fixed64);
                }
                if (!field.lengthDelimited.isEmpty()) {
                    if (this.result.lengthDelimited == null) {
                        this.result.lengthDelimited = new ArrayList();
                    }
                    this.result.lengthDelimited.addAll(field.lengthDelimited);
                }
                if (!field.group.isEmpty()) {
                    if (this.result.group == null) {
                        this.result.group = new ArrayList();
                    }
                    this.result.group.addAll(field.group);
                }
                return this;
            }
        }

        private Field() {
        }

        /* synthetic */ Field(Field field) {
            this();
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Field field) {
            return newBuilder().mergeFrom(field);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            return Arrays.equals(getIdentityArray(), ((Field) obj).getIdentityArray());
        }

        public final List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public final List<Long> getFixed64List() {
            return this.fixed64;
        }

        public final List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public final List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public final int getSerializedSize(int i) {
            int i2 = 0;
            for (Long longValue : this.varint) {
                i2 += CodedOutputStream.computeUInt64Size(i, longValue.longValue());
            }
            for (Integer intValue : this.fixed32) {
                i2 += CodedOutputStream.computeFixed32Size(i, intValue.intValue());
            }
            for (Long longValue2 : this.fixed64) {
                i2 += CodedOutputStream.computeFixed64Size(i, longValue2.longValue());
            }
            for (ByteString computeBytesSize : this.lengthDelimited) {
                i2 += CodedOutputStream.computeBytesSize(i, computeBytesSize);
            }
            for (UnknownFieldSet computeGroupSize : this.group) {
                i2 += CodedOutputStream.computeGroupSize(i, computeGroupSize);
            }
            return i2;
        }

        public final int getSerializedSizeAsMessageSetExtension(int i) {
            int i2 = 0;
            for (ByteString computeRawMessageSetExtensionSize : this.lengthDelimited) {
                i2 += CodedOutputStream.computeRawMessageSetExtensionSize(i, computeRawMessageSetExtensionSize);
            }
            return i2;
        }

        public final List<Long> getVarintList() {
            return this.varint;
        }

        public final int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public final void writeAsMessageSetExtensionTo(int i, CodedOutputStream codedOutputStream) throws IOException {
            for (ByteString writeRawMessageSetExtension : this.lengthDelimited) {
                codedOutputStream.writeRawMessageSetExtension(i, writeRawMessageSetExtension);
            }
        }

        public final void writeTo(int i, CodedOutputStream codedOutputStream) throws IOException {
            for (Long longValue : this.varint) {
                codedOutputStream.writeUInt64(i, longValue.longValue());
            }
            for (Integer intValue : this.fixed32) {
                codedOutputStream.writeFixed32(i, intValue.intValue());
            }
            for (Long longValue2 : this.fixed64) {
                codedOutputStream.writeFixed64(i, longValue2.longValue());
            }
            for (ByteString writeBytes : this.lengthDelimited) {
                codedOutputStream.writeBytes(i, writeBytes);
            }
            for (UnknownFieldSet writeGroup : this.group) {
                codedOutputStream.writeGroup(i, writeGroup);
            }
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public final UnknownFieldSet parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder newBuilder = UnknownFieldSet.newBuilder();
            try {
                newBuilder.mergeFrom(codedInputStream);
                return newBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(newBuilder.buildPartial());
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(newBuilder.buildPartial());
            }
        }
    }

    private UnknownFieldSet() {
    }

    private UnknownFieldSet(Map<Integer, Field> map) {
        this.fields = map;
    }

    /* synthetic */ UnknownFieldSet(Map map, UnknownFieldSet unknownFieldSet) {
        this(map);
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static Builder newBuilder(UnknownFieldSet unknownFieldSet) {
        return newBuilder().mergeFrom(unknownFieldSet);
    }

    public static UnknownFieldSet parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(byteString).build();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream codedInputStream) throws IOException {
        return newBuilder().mergeFrom(codedInputStream).build();
    }

    public static UnknownFieldSet parseFrom(InputStream inputStream) throws IOException {
        return newBuilder().mergeFrom(inputStream).build();
    }

    public static UnknownFieldSet parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(bArr).build();
    }

    public final Map<Integer, Field> asMap() {
        return this.fields;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnknownFieldSet) && this.fields.equals(((UnknownFieldSet) obj).fields);
    }

    public final UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    public final Field getField(int i) {
        Field field = this.fields.get(Integer.valueOf(i));
        return field == null ? Field.getDefaultInstance() : field;
    }

    public final Parser getParserForType() {
        return PARSER;
    }

    public final int getSerializedSize() {
        int i = 0;
        for (Map.Entry next : this.fields.entrySet()) {
            i += ((Field) next.getValue()).getSerializedSize(((Integer) next.getKey()).intValue());
        }
        return i;
    }

    public final int getSerializedSizeAsMessageSet() {
        int i = 0;
        for (Map.Entry next : this.fields.entrySet()) {
            i += ((Field) next.getValue()).getSerializedSizeAsMessageSetExtension(((Integer) next.getKey()).intValue());
        }
        return i;
    }

    public final boolean hasField(int i) {
        return this.fields.containsKey(Integer.valueOf(i));
    }

    public final int hashCode() {
        return this.fields.hashCode();
    }

    public final boolean isInitialized() {
        return true;
    }

    public final Builder newBuilderForType() {
        return newBuilder();
    }

    public final Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public final ByteString toByteString() {
        try {
            ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(newCodedBuilder.getCodedOutput());
            return newCodedBuilder.build();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final String toString() {
        return TextFormat.printToString(this);
    }

    public final void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry next : this.fields.entrySet()) {
            ((Field) next.getValue()).writeAsMessageSetExtensionTo(((Integer) next.getKey()).intValue(), codedOutputStream);
        }
    }

    public final void writeDelimitedTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        newInstance.writeRawVarint32(getSerializedSize());
        writeTo(newInstance);
        newInstance.flush();
    }

    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry next : this.fields.entrySet()) {
            ((Field) next.getValue()).writeTo(((Integer) next.getKey()).intValue(), codedOutputStream);
        }
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream);
        writeTo(newInstance);
        newInstance.flush();
    }
}
