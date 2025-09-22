package com.cyjh.mobileanjian.ipc.share.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Ipc {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Descriptors.Descriptor f2574a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static GeneratedMessage.FieldAccessorTable f2575b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Descriptors.Descriptor f2576c;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable d;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor e;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable f;
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor g;

    public static final class Device extends GeneratedMessage implements DeviceOrBuilder {
        public static final int IMEI_FIELD_NUMBER = 1;
        public static final int MAC_FIELD_NUMBER = 2;
        public static Parser<Device> PARSER = new AbstractParser<Device>() {
            public final Device parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Device(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Device defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public Object imei_;
        /* access modifiers changed from: private */
        public Object mac_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DeviceOrBuilder {
            private int bitField0_;
            private Object imei_;
            private Object mac_;

            private Builder() {
                this.imei_ = "";
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.imei_ = "";
                this.mac_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Ipc.f2574a;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Device.alwaysUseFieldBuilders;
            }

            public final Device build() {
                Device buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final Device buildPartial() {
                Device device = new Device((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                Object unused = device.imei_ = this.imei_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = device.mac_ = this.mac_;
                int unused3 = device.bitField0_ = i2;
                onBuilt();
                return device;
            }

            public final Builder clear() {
                super.clear();
                this.imei_ = "";
                this.bitField0_ &= -2;
                this.mac_ = "";
                this.bitField0_ &= -3;
                return this;
            }

            public final Builder clearImei() {
                this.bitField0_ &= -2;
                this.imei_ = Device.getDefaultInstance().getImei();
                onChanged();
                return this;
            }

            public final Builder clearMac() {
                this.bitField0_ &= -3;
                this.mac_ = Device.getDefaultInstance().getMac();
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final Device getDefaultInstanceForType() {
                return Device.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return Ipc.f2574a;
            }

            public final String getImei() {
                Object obj = this.imei_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.imei_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getImeiBytes() {
                Object obj = this.imei_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.imei_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final String getMac() {
                Object obj = this.mac_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.mac_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMacBytes() {
                Object obj = this.mac_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.mac_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final boolean hasImei() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasMac() {
                return (this.bitField0_ & 2) == 2;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Ipc.f2575b.ensureFieldAccessorsInitialized(Device.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public final Builder mergeFrom(Device device) {
                if (device == Device.getDefaultInstance()) {
                    return this;
                }
                if (device.hasImei()) {
                    this.bitField0_ |= 1;
                    this.imei_ = device.imei_;
                    onChanged();
                }
                if (device.hasMac()) {
                    this.bitField0_ |= 2;
                    this.mac_ = device.mac_;
                    onChanged();
                }
                mergeUnknownFields(device.getUnknownFields());
                return this;
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Device device;
                Device device2 = null;
                try {
                    Device parsePartialFrom = Device.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    device = (Device) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    device2 = device;
                }
                if (device2 != null) {
                    mergeFrom(device2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof Device) {
                    return mergeFrom((Device) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder setImei(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.imei_ = str;
                onChanged();
                return this;
            }

            public final Builder setImeiBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.imei_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setMac(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.mac_ = str;
                onChanged();
                return this;
            }

            public final Builder setMacBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.mac_ = byteString;
                onChanged();
                return this;
            }
        }

        static {
            Device device = new Device(true);
            defaultInstance = device;
            device.initFields();
        }

        private Device(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.bitField0_ |= 1;
                            this.imei_ = codedInputStream.readBytes();
                        } else if (readTag == 18) {
                            this.bitField0_ |= 2;
                            this.mac_ = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Device(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Device(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Device getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Ipc.f2574a;
        }

        private void initFields() {
            this.imei_ = "";
            this.mac_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Device device) {
            return newBuilder().mergeFrom(device);
        }

        public static Device parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Device parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Device parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Device parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Device parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Device parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Device parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Device parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Device parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Device parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final Device getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final String getImei() {
            Object obj = this.imei_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.imei_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getImeiBytes() {
            Object obj = this.imei_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.imei_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final String getMac() {
            Object obj = this.mac_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.mac_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMacBytes() {
            Object obj = this.mac_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.mac_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<Device> getParserForType() {
            return PARSER;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, getImeiBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeBytesSize(2, getMacBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasImei() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasMac() {
            return (this.bitField0_ & 2) == 2;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Ipc.f2575b.ensureFieldAccessorsInitialized(Device.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public final Builder toBuilder() {
            return newBuilder(this);
        }

        /* access modifiers changed from: protected */
        public final Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeBytes(1, getImeiBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(2, getMacBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface DeviceOrBuilder extends MessageOrBuilder {
        String getImei();

        ByteString getImeiBytes();

        String getMac();

        ByteString getMacBytes();

        boolean hasImei();

        boolean hasMac();
    }

    public enum FundType implements ProtocolMessageEnum {
        VOID(0, 1),
        BOOLEAN(1, 2),
        INT(2, 3),
        LONG(3, 4),
        FLOAT(4, 5),
        DOUBLE(5, 6),
        STRING(6, 7);
        
        public static final int BOOLEAN_VALUE = 2;
        public static final int DOUBLE_VALUE = 6;
        public static final int FLOAT_VALUE = 5;
        public static final int INT_VALUE = 3;
        public static final int LONG_VALUE = 4;
        public static final int STRING_VALUE = 7;
        private static final FundType[] VALUES = null;
        public static final int VOID_VALUE = 1;
        private static Internal.EnumLiteMap<FundType> internalValueMap;
        private final int index;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<FundType>() {
                public final FundType findValueByNumber(int i) {
                    return FundType.valueOf(i);
                }
            };
            VALUES = values();
        }

        private FundType(int i, int i2) {
            this.index = i;
            this.value = i2;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return Ipc.a().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<FundType> internalGetValueMap() {
            return internalValueMap;
        }

        public static FundType valueOf(int i) {
            switch (i) {
                case 1:
                    return VOID;
                case 2:
                    return BOOLEAN;
                case 3:
                    return INT;
                case 4:
                    return LONG;
                case 5:
                    return FLOAT;
                case 6:
                    return DOUBLE;
                case 7:
                    return STRING;
                default:
                    return null;
            }
        }

        public static FundType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            return this.value;
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            return getDescriptor().getValues().get(this.index);
        }
    }

    public static final class IpcMessage extends GeneratedMessage implements IpcMessageOrBuilder {
        public static final int ARG1_FIELD_NUMBER = 2;
        public static final int ARG2_FIELD_NUMBER = 3;
        public static final int ARG3_FIELD_NUMBER = 4;
        public static final int ARG4_FIELD_NUMBER = 6;
        public static final int CLASSNAME_FIELD_NUMBER = 8;
        public static final int CMD_FIELD_NUMBER = 1;
        public static final int ENCRYPT_FIELD_NUMBER = 15;
        public static final int FILEDATA_FIELD_NUMBER = 5;
        public static final int ISDEBUG_FIELD_NUMBER = 16;
        public static final int ISSYNCCALL_FIELD_NUMBER = 12;
        public static final int METHODNAME_FIELD_NUMBER = 9;
        public static final int PARAMS_FIELD_NUMBER = 11;
        public static Parser<IpcMessage> PARSER = new AbstractParser<IpcMessage>() {
            public final IpcMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new IpcMessage(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int PKGNAME_FIELD_NUMBER = 7;
        public static final int RETVALUE_FIELD_NUMBER = 14;
        public static final int TYPES_FIELD_NUMBER = 10;
        public static final int WAITID_FIELD_NUMBER = 13;
        private static final IpcMessage defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public List<Integer> arg1_;
        /* access modifiers changed from: private */
        public LazyStringList arg2_;
        /* access modifiers changed from: private */
        public List<Float> arg3_;
        /* access modifiers changed from: private */
        public List<Long> arg4_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public Object className_;
        /* access modifiers changed from: private */
        public int cmd_;
        /* access modifiers changed from: private */
        public boolean encrypt_;
        /* access modifiers changed from: private */
        public ByteString fileData_;
        /* access modifiers changed from: private */
        public boolean isDebug_;
        /* access modifiers changed from: private */
        public boolean isSyncCall_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object methodName_;
        /* access modifiers changed from: private */
        public LazyStringList params_;
        /* access modifiers changed from: private */
        public Object pkgName_;
        /* access modifiers changed from: private */
        public ReturnValue retValue_;
        /* access modifiers changed from: private */
        public LazyStringList types_;
        private final UnknownFieldSet unknownFields;
        /* access modifiers changed from: private */
        public int waitId_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements IpcMessageOrBuilder {
            private List<Integer> arg1_;
            private LazyStringList arg2_;
            private List<Float> arg3_;
            private List<Long> arg4_;
            private int bitField0_;
            private Object className_;
            private int cmd_;
            private boolean encrypt_;
            private ByteString fileData_;
            private boolean isDebug_;
            private boolean isSyncCall_;
            private Object methodName_;
            private LazyStringList params_;
            private Object pkgName_;
            private SingleFieldBuilder<ReturnValue, ReturnValue.Builder, ReturnValueOrBuilder> retValueBuilder_;
            private ReturnValue retValue_;
            private LazyStringList types_;
            private int waitId_;

            private Builder() {
                this.arg1_ = Collections.emptyList();
                this.arg2_ = LazyStringArrayList.EMPTY;
                this.arg3_ = Collections.emptyList();
                this.fileData_ = ByteString.EMPTY;
                this.arg4_ = Collections.emptyList();
                this.pkgName_ = "";
                this.className_ = "";
                this.methodName_ = "";
                this.types_ = LazyStringArrayList.EMPTY;
                this.params_ = LazyStringArrayList.EMPTY;
                this.retValue_ = ReturnValue.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.arg1_ = Collections.emptyList();
                this.arg2_ = LazyStringArrayList.EMPTY;
                this.arg3_ = Collections.emptyList();
                this.fileData_ = ByteString.EMPTY;
                this.arg4_ = Collections.emptyList();
                this.pkgName_ = "";
                this.className_ = "";
                this.methodName_ = "";
                this.types_ = LazyStringArrayList.EMPTY;
                this.params_ = LazyStringArrayList.EMPTY;
                this.retValue_ = ReturnValue.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            private void ensureArg1IsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.arg1_ = new ArrayList(this.arg1_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureArg2IsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.arg2_ = new LazyStringArrayList(this.arg2_);
                    this.bitField0_ |= 4;
                }
            }

            private void ensureArg3IsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.arg3_ = new ArrayList(this.arg3_);
                    this.bitField0_ |= 8;
                }
            }

            private void ensureArg4IsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.arg4_ = new ArrayList(this.arg4_);
                    this.bitField0_ |= 32;
                }
            }

            private void ensureParamsIsMutable() {
                if ((this.bitField0_ & 1024) != 1024) {
                    this.params_ = new LazyStringArrayList(this.params_);
                    this.bitField0_ |= 1024;
                }
            }

            private void ensureTypesIsMutable() {
                if ((this.bitField0_ & 512) != 512) {
                    this.types_ = new LazyStringArrayList(this.types_);
                    this.bitField0_ |= 512;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Ipc.e;
            }

            private SingleFieldBuilder<ReturnValue, ReturnValue.Builder, ReturnValueOrBuilder> getRetValueFieldBuilder() {
                if (this.retValueBuilder_ == null) {
                    this.retValueBuilder_ = new SingleFieldBuilder<>(this.retValue_, getParentForChildren(), isClean());
                    this.retValue_ = null;
                }
                return this.retValueBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (IpcMessage.alwaysUseFieldBuilders) {
                    getRetValueFieldBuilder();
                }
            }

            public final Builder addAllArg1(Iterable<? extends Integer> iterable) {
                ensureArg1IsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.arg1_);
                onChanged();
                return this;
            }

            public final Builder addAllArg2(Iterable<String> iterable) {
                ensureArg2IsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.arg2_);
                onChanged();
                return this;
            }

            public final Builder addAllArg3(Iterable<? extends Float> iterable) {
                ensureArg3IsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.arg3_);
                onChanged();
                return this;
            }

            public final Builder addAllArg4(Iterable<? extends Long> iterable) {
                ensureArg4IsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.arg4_);
                onChanged();
                return this;
            }

            public final Builder addAllParams(Iterable<String> iterable) {
                ensureParamsIsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.params_);
                onChanged();
                return this;
            }

            public final Builder addAllTypes(Iterable<String> iterable) {
                ensureTypesIsMutable();
                GeneratedMessage.Builder.addAll(iterable, this.types_);
                onChanged();
                return this;
            }

            public final Builder addArg1(int i) {
                ensureArg1IsMutable();
                this.arg1_.add(Integer.valueOf(i));
                onChanged();
                return this;
            }

            public final Builder addArg2(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureArg2IsMutable();
                this.arg2_.add(str);
                onChanged();
                return this;
            }

            public final Builder addArg2Bytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureArg2IsMutable();
                this.arg2_.add(byteString);
                onChanged();
                return this;
            }

            public final Builder addArg3(float f) {
                ensureArg3IsMutable();
                this.arg3_.add(Float.valueOf(f));
                onChanged();
                return this;
            }

            public final Builder addArg4(long j) {
                ensureArg4IsMutable();
                this.arg4_.add(Long.valueOf(j));
                onChanged();
                return this;
            }

            public final Builder addParams(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureParamsIsMutable();
                this.params_.add(str);
                onChanged();
                return this;
            }

            public final Builder addParamsBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureParamsIsMutable();
                this.params_.add(byteString);
                onChanged();
                return this;
            }

            public final Builder addTypes(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureTypesIsMutable();
                this.types_.add(str);
                onChanged();
                return this;
            }

            public final Builder addTypesBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                ensureTypesIsMutable();
                this.types_.add(byteString);
                onChanged();
                return this;
            }

            public final IpcMessage build() {
                IpcMessage buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final IpcMessage buildPartial() {
                IpcMessage ipcMessage = new IpcMessage((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                int unused = ipcMessage.cmd_ = this.cmd_;
                if ((this.bitField0_ & 2) == 2) {
                    this.arg1_ = Collections.unmodifiableList(this.arg1_);
                    this.bitField0_ &= -3;
                }
                List unused2 = ipcMessage.arg1_ = this.arg1_;
                if ((this.bitField0_ & 4) == 4) {
                    this.arg2_ = new UnmodifiableLazyStringList(this.arg2_);
                    this.bitField0_ &= -5;
                }
                LazyStringList unused3 = ipcMessage.arg2_ = this.arg2_;
                if ((this.bitField0_ & 8) == 8) {
                    this.arg3_ = Collections.unmodifiableList(this.arg3_);
                    this.bitField0_ &= -9;
                }
                List unused4 = ipcMessage.arg3_ = this.arg3_;
                if ((i & 16) == 16) {
                    i2 |= 2;
                }
                ByteString unused5 = ipcMessage.fileData_ = this.fileData_;
                if ((this.bitField0_ & 32) == 32) {
                    this.arg4_ = Collections.unmodifiableList(this.arg4_);
                    this.bitField0_ &= -33;
                }
                List unused6 = ipcMessage.arg4_ = this.arg4_;
                if ((i & 64) == 64) {
                    i2 |= 4;
                }
                Object unused7 = ipcMessage.pkgName_ = this.pkgName_;
                if ((i & 128) == 128) {
                    i2 |= 8;
                }
                Object unused8 = ipcMessage.className_ = this.className_;
                if ((i & 256) == 256) {
                    i2 |= 16;
                }
                Object unused9 = ipcMessage.methodName_ = this.methodName_;
                if ((this.bitField0_ & 512) == 512) {
                    this.types_ = new UnmodifiableLazyStringList(this.types_);
                    this.bitField0_ &= -513;
                }
                LazyStringList unused10 = ipcMessage.types_ = this.types_;
                if ((this.bitField0_ & 1024) == 1024) {
                    this.params_ = new UnmodifiableLazyStringList(this.params_);
                    this.bitField0_ &= -1025;
                }
                LazyStringList unused11 = ipcMessage.params_ = this.params_;
                if ((i & 2048) == 2048) {
                    i2 |= 32;
                }
                boolean unused12 = ipcMessage.isSyncCall_ = this.isSyncCall_;
                if ((i & 4096) == 4096) {
                    i2 |= 64;
                }
                int unused13 = ipcMessage.waitId_ = this.waitId_;
                if ((i & 8192) == 8192) {
                    i2 |= 128;
                }
                ReturnValue unused14 = ipcMessage.retValue_ = this.retValueBuilder_ == null ? this.retValue_ : this.retValueBuilder_.build();
                if ((i & 16384) == 16384) {
                    i2 |= 256;
                }
                boolean unused15 = ipcMessage.encrypt_ = this.encrypt_;
                if ((i & 32768) == 32768) {
                    i2 |= 512;
                }
                boolean unused16 = ipcMessage.isDebug_ = this.isDebug_;
                int unused17 = ipcMessage.bitField0_ = i2;
                onBuilt();
                return ipcMessage;
            }

            public final Builder clear() {
                super.clear();
                this.cmd_ = 0;
                this.bitField0_ &= -2;
                this.arg1_ = Collections.emptyList();
                this.bitField0_ &= -3;
                this.arg2_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                this.arg3_ = Collections.emptyList();
                this.bitField0_ &= -9;
                this.fileData_ = ByteString.EMPTY;
                this.bitField0_ &= -17;
                this.arg4_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.pkgName_ = "";
                this.bitField0_ &= -65;
                this.className_ = "";
                this.bitField0_ &= -129;
                this.methodName_ = "";
                this.bitField0_ &= -257;
                this.types_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -513;
                this.params_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -1025;
                this.isSyncCall_ = false;
                this.bitField0_ &= -2049;
                this.waitId_ = 0;
                this.bitField0_ &= -4097;
                if (this.retValueBuilder_ == null) {
                    this.retValue_ = ReturnValue.getDefaultInstance();
                } else {
                    this.retValueBuilder_.clear();
                }
                this.bitField0_ &= -8193;
                this.encrypt_ = false;
                this.bitField0_ &= -16385;
                this.isDebug_ = false;
                this.bitField0_ &= -32769;
                return this;
            }

            public final Builder clearArg1() {
                this.arg1_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public final Builder clearArg2() {
                this.arg2_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            public final Builder clearArg3() {
                this.arg3_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            public final Builder clearArg4() {
                this.arg4_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            public final Builder clearClassName() {
                this.bitField0_ &= -129;
                this.className_ = IpcMessage.getDefaultInstance().getClassName();
                onChanged();
                return this;
            }

            public final Builder clearCmd() {
                this.bitField0_ &= -2;
                this.cmd_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearEncrypt() {
                this.bitField0_ &= -16385;
                this.encrypt_ = false;
                onChanged();
                return this;
            }

            public final Builder clearFileData() {
                this.bitField0_ &= -17;
                this.fileData_ = IpcMessage.getDefaultInstance().getFileData();
                onChanged();
                return this;
            }

            public final Builder clearIsDebug() {
                this.bitField0_ &= -32769;
                this.isDebug_ = false;
                onChanged();
                return this;
            }

            public final Builder clearIsSyncCall() {
                this.bitField0_ &= -2049;
                this.isSyncCall_ = false;
                onChanged();
                return this;
            }

            public final Builder clearMethodName() {
                this.bitField0_ &= -257;
                this.methodName_ = IpcMessage.getDefaultInstance().getMethodName();
                onChanged();
                return this;
            }

            public final Builder clearParams() {
                this.params_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -1025;
                onChanged();
                return this;
            }

            public final Builder clearPkgName() {
                this.bitField0_ &= -65;
                this.pkgName_ = IpcMessage.getDefaultInstance().getPkgName();
                onChanged();
                return this;
            }

            public final Builder clearRetValue() {
                if (this.retValueBuilder_ == null) {
                    this.retValue_ = ReturnValue.getDefaultInstance();
                    onChanged();
                } else {
                    this.retValueBuilder_.clear();
                }
                this.bitField0_ &= -8193;
                return this;
            }

            public final Builder clearTypes() {
                this.types_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -513;
                onChanged();
                return this;
            }

            public final Builder clearWaitId() {
                this.bitField0_ &= -4097;
                this.waitId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final int getArg1(int i) {
                return this.arg1_.get(i).intValue();
            }

            public final int getArg1Count() {
                return this.arg1_.size();
            }

            public final List<Integer> getArg1List() {
                return Collections.unmodifiableList(this.arg1_);
            }

            public final String getArg2(int i) {
                return (String) this.arg2_.get(i);
            }

            public final ByteString getArg2Bytes(int i) {
                return this.arg2_.getByteString(i);
            }

            public final int getArg2Count() {
                return this.arg2_.size();
            }

            public final List<String> getArg2List() {
                return Collections.unmodifiableList(this.arg2_);
            }

            public final float getArg3(int i) {
                return this.arg3_.get(i).floatValue();
            }

            public final int getArg3Count() {
                return this.arg3_.size();
            }

            public final List<Float> getArg3List() {
                return Collections.unmodifiableList(this.arg3_);
            }

            public final long getArg4(int i) {
                return this.arg4_.get(i).longValue();
            }

            public final int getArg4Count() {
                return this.arg4_.size();
            }

            public final List<Long> getArg4List() {
                return Collections.unmodifiableList(this.arg4_);
            }

            public final String getClassName() {
                Object obj = this.className_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.className_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getClassNameBytes() {
                Object obj = this.className_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.className_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final int getCmd() {
                return this.cmd_;
            }

            public final IpcMessage getDefaultInstanceForType() {
                return IpcMessage.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return Ipc.e;
            }

            public final boolean getEncrypt() {
                return this.encrypt_;
            }

            public final ByteString getFileData() {
                return this.fileData_;
            }

            public final boolean getIsDebug() {
                return this.isDebug_;
            }

            public final boolean getIsSyncCall() {
                return this.isSyncCall_;
            }

            public final String getMethodName() {
                Object obj = this.methodName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.methodName_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMethodNameBytes() {
                Object obj = this.methodName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.methodName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final String getParams(int i) {
                return (String) this.params_.get(i);
            }

            public final ByteString getParamsBytes(int i) {
                return this.params_.getByteString(i);
            }

            public final int getParamsCount() {
                return this.params_.size();
            }

            public final List<String> getParamsList() {
                return Collections.unmodifiableList(this.params_);
            }

            public final String getPkgName() {
                Object obj = this.pkgName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.pkgName_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getPkgNameBytes() {
                Object obj = this.pkgName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pkgName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final ReturnValue getRetValue() {
                return this.retValueBuilder_ == null ? this.retValue_ : this.retValueBuilder_.getMessage();
            }

            public final ReturnValue.Builder getRetValueBuilder() {
                this.bitField0_ |= 8192;
                onChanged();
                return getRetValueFieldBuilder().getBuilder();
            }

            public final ReturnValueOrBuilder getRetValueOrBuilder() {
                return this.retValueBuilder_ != null ? this.retValueBuilder_.getMessageOrBuilder() : this.retValue_;
            }

            public final String getTypes(int i) {
                return (String) this.types_.get(i);
            }

            public final ByteString getTypesBytes(int i) {
                return this.types_.getByteString(i);
            }

            public final int getTypesCount() {
                return this.types_.size();
            }

            public final List<String> getTypesList() {
                return Collections.unmodifiableList(this.types_);
            }

            public final int getWaitId() {
                return this.waitId_;
            }

            public final boolean hasClassName() {
                return (this.bitField0_ & 128) == 128;
            }

            public final boolean hasCmd() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasEncrypt() {
                return (this.bitField0_ & 16384) == 16384;
            }

            public final boolean hasFileData() {
                return (this.bitField0_ & 16) == 16;
            }

            public final boolean hasIsDebug() {
                return (this.bitField0_ & 32768) == 32768;
            }

            public final boolean hasIsSyncCall() {
                return (this.bitField0_ & 2048) == 2048;
            }

            public final boolean hasMethodName() {
                return (this.bitField0_ & 256) == 256;
            }

            public final boolean hasPkgName() {
                return (this.bitField0_ & 64) == 64;
            }

            public final boolean hasRetValue() {
                return (this.bitField0_ & 8192) == 8192;
            }

            public final boolean hasWaitId() {
                return (this.bitField0_ & 4096) == 4096;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Ipc.f.ensureFieldAccessorsInitialized(IpcMessage.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public final Builder mergeFrom(IpcMessage ipcMessage) {
                if (ipcMessage == IpcMessage.getDefaultInstance()) {
                    return this;
                }
                if (ipcMessage.hasCmd()) {
                    setCmd(ipcMessage.getCmd());
                }
                if (!ipcMessage.arg1_.isEmpty()) {
                    if (this.arg1_.isEmpty()) {
                        this.arg1_ = ipcMessage.arg1_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureArg1IsMutable();
                        this.arg1_.addAll(ipcMessage.arg1_);
                    }
                    onChanged();
                }
                if (!ipcMessage.arg2_.isEmpty()) {
                    if (this.arg2_.isEmpty()) {
                        this.arg2_ = ipcMessage.arg2_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureArg2IsMutable();
                        this.arg2_.addAll(ipcMessage.arg2_);
                    }
                    onChanged();
                }
                if (!ipcMessage.arg3_.isEmpty()) {
                    if (this.arg3_.isEmpty()) {
                        this.arg3_ = ipcMessage.arg3_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureArg3IsMutable();
                        this.arg3_.addAll(ipcMessage.arg3_);
                    }
                    onChanged();
                }
                if (ipcMessage.hasFileData()) {
                    setFileData(ipcMessage.getFileData());
                }
                if (!ipcMessage.arg4_.isEmpty()) {
                    if (this.arg4_.isEmpty()) {
                        this.arg4_ = ipcMessage.arg4_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureArg4IsMutable();
                        this.arg4_.addAll(ipcMessage.arg4_);
                    }
                    onChanged();
                }
                if (ipcMessage.hasPkgName()) {
                    this.bitField0_ |= 64;
                    this.pkgName_ = ipcMessage.pkgName_;
                    onChanged();
                }
                if (ipcMessage.hasClassName()) {
                    this.bitField0_ |= 128;
                    this.className_ = ipcMessage.className_;
                    onChanged();
                }
                if (ipcMessage.hasMethodName()) {
                    this.bitField0_ |= 256;
                    this.methodName_ = ipcMessage.methodName_;
                    onChanged();
                }
                if (!ipcMessage.types_.isEmpty()) {
                    if (this.types_.isEmpty()) {
                        this.types_ = ipcMessage.types_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureTypesIsMutable();
                        this.types_.addAll(ipcMessage.types_);
                    }
                    onChanged();
                }
                if (!ipcMessage.params_.isEmpty()) {
                    if (this.params_.isEmpty()) {
                        this.params_ = ipcMessage.params_;
                        this.bitField0_ &= -1025;
                    } else {
                        ensureParamsIsMutable();
                        this.params_.addAll(ipcMessage.params_);
                    }
                    onChanged();
                }
                if (ipcMessage.hasIsSyncCall()) {
                    setIsSyncCall(ipcMessage.getIsSyncCall());
                }
                if (ipcMessage.hasWaitId()) {
                    setWaitId(ipcMessage.getWaitId());
                }
                if (ipcMessage.hasRetValue()) {
                    mergeRetValue(ipcMessage.getRetValue());
                }
                if (ipcMessage.hasEncrypt()) {
                    setEncrypt(ipcMessage.getEncrypt());
                }
                if (ipcMessage.hasIsDebug()) {
                    setIsDebug(ipcMessage.getIsDebug());
                }
                mergeUnknownFields(ipcMessage.getUnknownFields());
                return this;
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                IpcMessage ipcMessage;
                IpcMessage ipcMessage2 = null;
                try {
                    IpcMessage parsePartialFrom = IpcMessage.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ipcMessage = (IpcMessage) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    ipcMessage2 = ipcMessage;
                }
                if (ipcMessage2 != null) {
                    mergeFrom(ipcMessage2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof IpcMessage) {
                    return mergeFrom((IpcMessage) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeRetValue(ReturnValue returnValue) {
                if (this.retValueBuilder_ == null) {
                    if ((this.bitField0_ & 8192) == 8192 && this.retValue_ != ReturnValue.getDefaultInstance()) {
                        returnValue = ReturnValue.newBuilder(this.retValue_).mergeFrom(returnValue).buildPartial();
                    }
                    this.retValue_ = returnValue;
                    onChanged();
                } else {
                    this.retValueBuilder_.mergeFrom(returnValue);
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public final Builder setArg1(int i, int i2) {
                ensureArg1IsMutable();
                this.arg1_.set(i, Integer.valueOf(i2));
                onChanged();
                return this;
            }

            public final Builder setArg2(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureArg2IsMutable();
                this.arg2_.set(i, str);
                onChanged();
                return this;
            }

            public final Builder setArg3(int i, float f) {
                ensureArg3IsMutable();
                this.arg3_.set(i, Float.valueOf(f));
                onChanged();
                return this;
            }

            public final Builder setArg4(int i, long j) {
                ensureArg4IsMutable();
                this.arg4_.set(i, Long.valueOf(j));
                onChanged();
                return this;
            }

            public final Builder setClassName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.className_ = str;
                onChanged();
                return this;
            }

            public final Builder setClassNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.className_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setCmd(int i) {
                this.bitField0_ |= 1;
                this.cmd_ = i;
                onChanged();
                return this;
            }

            public final Builder setEncrypt(boolean z) {
                this.bitField0_ |= 16384;
                this.encrypt_ = z;
                onChanged();
                return this;
            }

            public final Builder setFileData(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.fileData_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setIsDebug(boolean z) {
                this.bitField0_ |= 32768;
                this.isDebug_ = z;
                onChanged();
                return this;
            }

            public final Builder setIsSyncCall(boolean z) {
                this.bitField0_ |= 2048;
                this.isSyncCall_ = z;
                onChanged();
                return this;
            }

            public final Builder setMethodName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.methodName_ = str;
                onChanged();
                return this;
            }

            public final Builder setMethodNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.methodName_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setParams(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureParamsIsMutable();
                this.params_.set(i, str);
                onChanged();
                return this;
            }

            public final Builder setPkgName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.pkgName_ = str;
                onChanged();
                return this;
            }

            public final Builder setPkgNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.pkgName_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRetValue(ReturnValue.Builder builder) {
                if (this.retValueBuilder_ == null) {
                    this.retValue_ = builder.build();
                    onChanged();
                } else {
                    this.retValueBuilder_.setMessage(builder.build());
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public final Builder setRetValue(ReturnValue returnValue) {
                if (this.retValueBuilder_ != null) {
                    this.retValueBuilder_.setMessage(returnValue);
                } else if (returnValue == null) {
                    throw new NullPointerException();
                } else {
                    this.retValue_ = returnValue;
                    onChanged();
                }
                this.bitField0_ |= 8192;
                return this;
            }

            public final Builder setTypes(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                ensureTypesIsMutable();
                this.types_.set(i, str);
                onChanged();
                return this;
            }

            public final Builder setWaitId(int i) {
                this.bitField0_ |= 4096;
                this.waitId_ = i;
                onChanged();
                return this;
            }
        }

        static {
            IpcMessage ipcMessage = new IpcMessage(true);
            defaultInstance = ipcMessage;
            ipcMessage.initFields();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
            r6.add(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0118, code lost:
            r2.popLimit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0135, code lost:
            r6.add(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0201, code lost:
            r5 = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private IpcMessage(com.google.protobuf.CodedInputStream r18, com.google.protobuf.ExtensionRegistryLite r19) throws com.google.protobuf.InvalidProtocolBufferException {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                r3 = r19
                r17.<init>()
                r4 = -1
                r1.memoizedIsInitialized = r4
                r1.memoizedSerializedSize = r4
                r17.initFields()
                com.google.protobuf.UnknownFieldSet$Builder r4 = com.google.protobuf.UnknownFieldSet.newBuilder()
                r5 = 0
                r7 = 0
            L_0x0017:
                r8 = 1024(0x400, float:1.435E-42)
                r9 = 4
                r10 = 512(0x200, float:7.175E-43)
                r11 = 2
                r12 = 8
                r13 = 32
                if (r5 != 0) goto L_0x0279
                int r14 = r18.readTag()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                switch(r14) {
                    case 0: goto L_0x0200;
                    case 8: goto L_0x01f2;
                    case 16: goto L_0x01d8;
                    case 18: goto L_0x01a9;
                    case 26: goto L_0x018f;
                    case 34: goto L_0x0160;
                    case 37: goto L_0x0147;
                    case 42: goto L_0x013a;
                    case 48: goto L_0x011d;
                    case 50: goto L_0x00e6;
                    case 58: goto L_0x00d9;
                    case 66: goto L_0x00cc;
                    case 74: goto L_0x00be;
                    case 82: goto L_0x00a9;
                    case 90: goto L_0x0090;
                    case 96: goto L_0x0084;
                    case 104: goto L_0x0077;
                    case 114: goto L_0x004b;
                    case 120: goto L_0x003e;
                    case 128: goto L_0x0031;
                    default: goto L_0x002a;
                }     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
            L_0x002a:
                r8 = 1
                boolean r6 = r1.parseUnknownField(r2, r4, r3, r14)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0204
            L_0x0031:
                int r14 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14 = r14 | r10
                r1.bitField0_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                boolean r14 = r18.readBool()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.isDebug_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
            L_0x003c:
                r8 = 1
                goto L_0x0017
            L_0x003e:
                int r14 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14 = r14 | 256(0x100, float:3.59E-43)
                r1.bitField0_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                boolean r14 = r18.readBool()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.encrypt_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x004b:
                int r15 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14 = 128(0x80, float:1.794E-43)
                r15 = r15 & r14
                if (r15 != r14) goto L_0x0059
                com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r15 = r1.retValue_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue$Builder r15 = r15.toBuilder()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x005a
            L_0x0059:
                r15 = 0
            L_0x005a:
                com.google.protobuf.Parser<com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue> r6 = com.cyjh.mobileanjian.ipc.share.proto.Ipc.ReturnValue.PARSER     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.MessageLite r6 = r2.readMessage(r6, (com.google.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r6 = (com.cyjh.mobileanjian.ipc.share.proto.Ipc.ReturnValue) r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.retValue_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r15 == 0) goto L_0x0071
                com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r6 = r1.retValue_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r15.mergeFrom((com.cyjh.mobileanjian.ipc.share.proto.Ipc.ReturnValue) r6)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.cyjh.mobileanjian.ipc.share.proto.Ipc$ReturnValue r6 = r15.buildPartial()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.retValue_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
            L_0x0071:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | r14
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x0077:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | 64
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r6 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.waitId_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x0084:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | r13
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                boolean r6 = r18.readBool()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.isSyncCall_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x0090:
                r6 = r7 & 1024(0x400, float:1.435E-42)
                if (r6 == r8) goto L_0x009e
                com.google.protobuf.LazyStringArrayList r6 = new com.google.protobuf.LazyStringArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.params_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 1024(0x400, float:1.435E-42)
                r7 = r6
            L_0x009e:
                com.google.protobuf.LazyStringList r6 = r1.params_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r14 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
            L_0x00a4:
                r6.add(r14)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0017
            L_0x00a9:
                r6 = r7 & 512(0x200, float:7.175E-43)
                if (r6 == r10) goto L_0x00b7
                com.google.protobuf.LazyStringArrayList r6 = new com.google.protobuf.LazyStringArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.types_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 512(0x200, float:7.175E-43)
                r7 = r6
            L_0x00b7:
                com.google.protobuf.LazyStringList r6 = r1.types_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r14 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x00a4
            L_0x00be:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | 16
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r6 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.methodName_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x00cc:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | r12
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r6 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.className_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x00d9:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | r9
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r6 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.pkgName_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x00e6:
                int r6 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r6 = r2.pushLimit(r6)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14 = r7 & 32
                if (r14 == r13) goto L_0x0101
                int r14 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r14 <= 0) goto L_0x0101
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg4_ = r14     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r7 = r7 | 32
            L_0x0101:
                int r14 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r14 <= 0) goto L_0x0118
                java.util.List<java.lang.Long> r14 = r1.arg4_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                long r8 = r18.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r14.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8 = 1024(0x400, float:1.435E-42)
                r9 = 4
                goto L_0x0101
            L_0x0118:
                r2.popLimit(r6)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0017
            L_0x011d:
                r6 = r7 & 32
                if (r6 == r13) goto L_0x012b
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg4_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 32
                r7 = r6
            L_0x012b:
                java.util.List<java.lang.Long> r6 = r1.arg4_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                long r8 = r18.readInt64()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
            L_0x0135:
                r6.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0017
            L_0x013a:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r6 | r11
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r6 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.fileData_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x003c
            L_0x0147:
                r6 = r7 & 8
                if (r6 == r12) goto L_0x0155
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg3_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 8
                r7 = r6
            L_0x0155:
                java.util.List<java.lang.Float> r6 = r1.arg3_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                float r8 = r18.readFloat()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0135
            L_0x0160:
                int r6 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r6 = r2.pushLimit(r6)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8 = r7 & 8
                if (r8 == r12) goto L_0x017b
                int r8 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r8 <= 0) goto L_0x017b
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg3_ = r8     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r7 = r7 | 8
            L_0x017b:
                int r8 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r8 <= 0) goto L_0x0118
                java.util.List<java.lang.Float> r8 = r1.arg3_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                float r9 = r18.readFloat()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Float r9 = java.lang.Float.valueOf(r9)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8.add(r9)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x017b
            L_0x018f:
                r6 = r7 & 4
                r8 = 4
                if (r6 == r8) goto L_0x019e
                com.google.protobuf.LazyStringArrayList r6 = new com.google.protobuf.LazyStringArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg2_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 4
                r7 = r6
            L_0x019e:
                com.google.protobuf.LazyStringList r6 = r1.arg2_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                com.google.protobuf.ByteString r8 = r18.readBytes()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.add(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0017
            L_0x01a9:
                int r6 = r18.readRawVarint32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r6 = r2.pushLimit(r6)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8 = r7 & 2
                if (r8 == r11) goto L_0x01c4
                int r8 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r8 <= 0) goto L_0x01c4
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg1_ = r8     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r7 = r7 | 2
            L_0x01c4:
                int r8 = r18.getBytesUntilLimit()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                if (r8 <= 0) goto L_0x0118
                java.util.List<java.lang.Integer> r8 = r1.arg1_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r9 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8.add(r9)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x01c4
            L_0x01d8:
                r6 = r7 & 2
                if (r6 == r11) goto L_0x01e6
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6.<init>()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.arg1_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r6 = r7 | 2
                r7 = r6
            L_0x01e6:
                java.util.List<java.lang.Integer> r6 = r1.arg1_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r8 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0135
            L_0x01f2:
                int r6 = r1.bitField0_     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r8 = 1
                r6 = r6 | r8
                r1.bitField0_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                int r6 = r18.readInt32()     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                r1.cmd_ = r6     // Catch:{ InvalidProtocolBufferException -> 0x021a, IOException -> 0x020a }
                goto L_0x0017
            L_0x0200:
                r8 = 1
            L_0x0201:
                r5 = 1
                goto L_0x0017
            L_0x0204:
                if (r6 != 0) goto L_0x0017
                goto L_0x0201
            L_0x0207:
                r0 = move-exception
                r2 = r0
                goto L_0x0221
            L_0x020a:
                r0 = move-exception
                r2 = r0
                com.google.protobuf.InvalidProtocolBufferException r3 = new com.google.protobuf.InvalidProtocolBufferException     // Catch:{ all -> 0x0207 }
                java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0207 }
                r3.<init>(r2)     // Catch:{ all -> 0x0207 }
                com.google.protobuf.InvalidProtocolBufferException r2 = r3.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0207 }
                throw r2     // Catch:{ all -> 0x0207 }
            L_0x021a:
                r0 = move-exception
                r2 = r0
                com.google.protobuf.InvalidProtocolBufferException r2 = r2.setUnfinishedMessage(r1)     // Catch:{ all -> 0x0207 }
                throw r2     // Catch:{ all -> 0x0207 }
            L_0x0221:
                r3 = r7 & 2
                if (r3 != r11) goto L_0x022d
                java.util.List<java.lang.Integer> r3 = r1.arg1_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.arg1_ = r3
            L_0x022d:
                r3 = r7 & 4
                r5 = 4
                if (r3 != r5) goto L_0x023b
                com.google.protobuf.UnmodifiableLazyStringList r3 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r5 = r1.arg2_
                r3.<init>(r5)
                r1.arg2_ = r3
            L_0x023b:
                r3 = r7 & 8
                if (r3 != r12) goto L_0x0247
                java.util.List<java.lang.Float> r3 = r1.arg3_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.arg3_ = r3
            L_0x0247:
                r3 = r7 & 32
                if (r3 != r13) goto L_0x0253
                java.util.List<java.lang.Long> r3 = r1.arg4_
                java.util.List r3 = java.util.Collections.unmodifiableList(r3)
                r1.arg4_ = r3
            L_0x0253:
                r3 = r7 & 512(0x200, float:7.175E-43)
                if (r3 != r10) goto L_0x0260
                com.google.protobuf.UnmodifiableLazyStringList r3 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r5 = r1.types_
                r3.<init>(r5)
                r1.types_ = r3
            L_0x0260:
                r3 = 1024(0x400, float:1.435E-42)
                r5 = r7 & 1024(0x400, float:1.435E-42)
                if (r5 != r3) goto L_0x026f
                com.google.protobuf.UnmodifiableLazyStringList r3 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r5 = r1.params_
                r3.<init>(r5)
                r1.params_ = r3
            L_0x026f:
                com.google.protobuf.UnknownFieldSet r3 = r4.build()
                r1.unknownFields = r3
                r17.makeExtensionsImmutable()
                throw r2
            L_0x0279:
                r2 = r7 & 2
                if (r2 != r11) goto L_0x0285
                java.util.List<java.lang.Integer> r2 = r1.arg1_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.arg1_ = r2
            L_0x0285:
                r2 = r7 & 4
                r3 = 4
                if (r2 != r3) goto L_0x0293
                com.google.protobuf.UnmodifiableLazyStringList r2 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r3 = r1.arg2_
                r2.<init>(r3)
                r1.arg2_ = r2
            L_0x0293:
                r2 = r7 & 8
                if (r2 != r12) goto L_0x029f
                java.util.List<java.lang.Float> r2 = r1.arg3_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.arg3_ = r2
            L_0x029f:
                r2 = r7 & 32
                if (r2 != r13) goto L_0x02ab
                java.util.List<java.lang.Long> r2 = r1.arg4_
                java.util.List r2 = java.util.Collections.unmodifiableList(r2)
                r1.arg4_ = r2
            L_0x02ab:
                r2 = r7 & 512(0x200, float:7.175E-43)
                if (r2 != r10) goto L_0x02b8
                com.google.protobuf.UnmodifiableLazyStringList r2 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r3 = r1.types_
                r2.<init>(r3)
                r1.types_ = r2
            L_0x02b8:
                r2 = 1024(0x400, float:1.435E-42)
                r3 = r7 & 1024(0x400, float:1.435E-42)
                if (r3 != r2) goto L_0x02c7
                com.google.protobuf.UnmodifiableLazyStringList r2 = new com.google.protobuf.UnmodifiableLazyStringList
                com.google.protobuf.LazyStringList r3 = r1.params_
                r2.<init>(r3)
                r1.params_ = r2
            L_0x02c7:
                com.google.protobuf.UnknownFieldSet r2 = r4.build()
                r1.unknownFields = r2
                r17.makeExtensionsImmutable()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cyjh.mobileanjian.ipc.share.proto.Ipc.IpcMessage.<init>(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):void");
        }

        private IpcMessage(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private IpcMessage(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static IpcMessage getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Ipc.e;
        }

        private void initFields() {
            this.cmd_ = 0;
            this.arg1_ = Collections.emptyList();
            this.arg2_ = LazyStringArrayList.EMPTY;
            this.arg3_ = Collections.emptyList();
            this.fileData_ = ByteString.EMPTY;
            this.arg4_ = Collections.emptyList();
            this.pkgName_ = "";
            this.className_ = "";
            this.methodName_ = "";
            this.types_ = LazyStringArrayList.EMPTY;
            this.params_ = LazyStringArrayList.EMPTY;
            this.isSyncCall_ = false;
            this.waitId_ = 0;
            this.retValue_ = ReturnValue.getDefaultInstance();
            this.encrypt_ = false;
            this.isDebug_ = false;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(IpcMessage ipcMessage) {
            return newBuilder().mergeFrom(ipcMessage);
        }

        public static IpcMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static IpcMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static IpcMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static IpcMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static IpcMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static IpcMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static IpcMessage parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static IpcMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static IpcMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static IpcMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final int getArg1(int i) {
            return this.arg1_.get(i).intValue();
        }

        public final int getArg1Count() {
            return this.arg1_.size();
        }

        public final List<Integer> getArg1List() {
            return this.arg1_;
        }

        public final String getArg2(int i) {
            return (String) this.arg2_.get(i);
        }

        public final ByteString getArg2Bytes(int i) {
            return this.arg2_.getByteString(i);
        }

        public final int getArg2Count() {
            return this.arg2_.size();
        }

        public final List<String> getArg2List() {
            return this.arg2_;
        }

        public final float getArg3(int i) {
            return this.arg3_.get(i).floatValue();
        }

        public final int getArg3Count() {
            return this.arg3_.size();
        }

        public final List<Float> getArg3List() {
            return this.arg3_;
        }

        public final long getArg4(int i) {
            return this.arg4_.get(i).longValue();
        }

        public final int getArg4Count() {
            return this.arg4_.size();
        }

        public final List<Long> getArg4List() {
            return this.arg4_;
        }

        public final String getClassName() {
            Object obj = this.className_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.className_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getClassNameBytes() {
            Object obj = this.className_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.className_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final int getCmd() {
            return this.cmd_;
        }

        public final IpcMessage getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final boolean getEncrypt() {
            return this.encrypt_;
        }

        public final ByteString getFileData() {
            return this.fileData_;
        }

        public final boolean getIsDebug() {
            return this.isDebug_;
        }

        public final boolean getIsSyncCall() {
            return this.isSyncCall_;
        }

        public final String getMethodName() {
            Object obj = this.methodName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.methodName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMethodNameBytes() {
            Object obj = this.methodName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.methodName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final String getParams(int i) {
            return (String) this.params_.get(i);
        }

        public final ByteString getParamsBytes(int i) {
            return this.params_.getByteString(i);
        }

        public final int getParamsCount() {
            return this.params_.size();
        }

        public final List<String> getParamsList() {
            return this.params_;
        }

        public final Parser<IpcMessage> getParserForType() {
            return PARSER;
        }

        public final String getPkgName() {
            Object obj = this.pkgName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.pkgName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getPkgNameBytes() {
            Object obj = this.pkgName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pkgName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final ReturnValue getRetValue() {
            return this.retValue_;
        }

        public final ReturnValueOrBuilder getRetValueOrBuilder() {
            return this.retValue_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.cmd_) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.arg1_.size(); i3++) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(this.arg1_.get(i3).intValue());
            }
            int size = computeInt32Size + i2 + (getArg1List().size() * 1);
            int i4 = 0;
            for (int i5 = 0; i5 < this.arg2_.size(); i5++) {
                i4 += CodedOutputStream.computeBytesSizeNoTag(this.arg2_.getByteString(i5));
            }
            int size2 = size + i4 + (getArg2List().size() * 1) + (getArg3List().size() * 4) + (getArg3List().size() * 1);
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBytesSize(5, this.fileData_);
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.arg4_.size(); i7++) {
                i6 += CodedOutputStream.computeInt64SizeNoTag(this.arg4_.get(i7).longValue());
            }
            int size3 = size2 + i6 + (getArg4List().size() * 1);
            if ((this.bitField0_ & 4) == 4) {
                size3 += CodedOutputStream.computeBytesSize(7, getPkgNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                size3 += CodedOutputStream.computeBytesSize(8, getClassNameBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                size3 += CodedOutputStream.computeBytesSize(9, getMethodNameBytes());
            }
            int i8 = 0;
            for (int i9 = 0; i9 < this.types_.size(); i9++) {
                i8 += CodedOutputStream.computeBytesSizeNoTag(this.types_.getByteString(i9));
            }
            int size4 = size3 + i8 + (getTypesList().size() * 1);
            int i10 = 0;
            for (int i11 = 0; i11 < this.params_.size(); i11++) {
                i10 += CodedOutputStream.computeBytesSizeNoTag(this.params_.getByteString(i11));
            }
            int size5 = size4 + i10 + (getParamsList().size() * 1);
            if ((this.bitField0_ & 32) == 32) {
                size5 += CodedOutputStream.computeBoolSize(12, this.isSyncCall_);
            }
            if ((this.bitField0_ & 64) == 64) {
                size5 += CodedOutputStream.computeInt32Size(13, this.waitId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                size5 += CodedOutputStream.computeMessageSize(14, this.retValue_);
            }
            if ((this.bitField0_ & 256) == 256) {
                size5 += CodedOutputStream.computeBoolSize(15, this.encrypt_);
            }
            if ((this.bitField0_ & 512) == 512) {
                size5 += CodedOutputStream.computeBoolSize(16, this.isDebug_);
            }
            int serializedSize = size5 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final String getTypes(int i) {
            return (String) this.types_.get(i);
        }

        public final ByteString getTypesBytes(int i) {
            return this.types_.getByteString(i);
        }

        public final int getTypesCount() {
            return this.types_.size();
        }

        public final List<String> getTypesList() {
            return this.types_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final int getWaitId() {
            return this.waitId_;
        }

        public final boolean hasClassName() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean hasCmd() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasEncrypt() {
            return (this.bitField0_ & 256) == 256;
        }

        public final boolean hasFileData() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasIsDebug() {
            return (this.bitField0_ & 512) == 512;
        }

        public final boolean hasIsSyncCall() {
            return (this.bitField0_ & 32) == 32;
        }

        public final boolean hasMethodName() {
            return (this.bitField0_ & 16) == 16;
        }

        public final boolean hasPkgName() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRetValue() {
            return (this.bitField0_ & 128) == 128;
        }

        public final boolean hasWaitId() {
            return (this.bitField0_ & 64) == 64;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Ipc.f.ensureFieldAccessorsInitialized(IpcMessage.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public final Builder toBuilder() {
            return newBuilder(this);
        }

        /* access modifiers changed from: protected */
        public final Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.cmd_);
            }
            for (int i = 0; i < this.arg1_.size(); i++) {
                codedOutputStream.writeInt32(2, this.arg1_.get(i).intValue());
            }
            for (int i2 = 0; i2 < this.arg2_.size(); i2++) {
                codedOutputStream.writeBytes(3, this.arg2_.getByteString(i2));
            }
            for (int i3 = 0; i3 < this.arg3_.size(); i3++) {
                codedOutputStream.writeFloat(4, this.arg3_.get(i3).floatValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(5, this.fileData_);
            }
            for (int i4 = 0; i4 < this.arg4_.size(); i4++) {
                codedOutputStream.writeInt64(6, this.arg4_.get(i4).longValue());
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(7, getPkgNameBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(8, getClassNameBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(9, getMethodNameBytes());
            }
            for (int i5 = 0; i5 < this.types_.size(); i5++) {
                codedOutputStream.writeBytes(10, this.types_.getByteString(i5));
            }
            for (int i6 = 0; i6 < this.params_.size(); i6++) {
                codedOutputStream.writeBytes(11, this.params_.getByteString(i6));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(12, this.isSyncCall_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeInt32(13, this.waitId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.writeMessage(14, this.retValue_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.writeBool(15, this.encrypt_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.writeBool(16, this.isDebug_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface IpcMessageOrBuilder extends MessageOrBuilder {
        int getArg1(int i);

        int getArg1Count();

        List<Integer> getArg1List();

        String getArg2(int i);

        ByteString getArg2Bytes(int i);

        int getArg2Count();

        List<String> getArg2List();

        float getArg3(int i);

        int getArg3Count();

        List<Float> getArg3List();

        long getArg4(int i);

        int getArg4Count();

        List<Long> getArg4List();

        String getClassName();

        ByteString getClassNameBytes();

        int getCmd();

        boolean getEncrypt();

        ByteString getFileData();

        boolean getIsDebug();

        boolean getIsSyncCall();

        String getMethodName();

        ByteString getMethodNameBytes();

        String getParams(int i);

        ByteString getParamsBytes(int i);

        int getParamsCount();

        List<String> getParamsList();

        String getPkgName();

        ByteString getPkgNameBytes();

        ReturnValue getRetValue();

        ReturnValueOrBuilder getRetValueOrBuilder();

        String getTypes(int i);

        ByteString getTypesBytes(int i);

        int getTypesCount();

        List<String> getTypesList();

        int getWaitId();

        boolean hasClassName();

        boolean hasCmd();

        boolean hasEncrypt();

        boolean hasFileData();

        boolean hasIsDebug();

        boolean hasIsSyncCall();

        boolean hasMethodName();

        boolean hasPkgName();

        boolean hasRetValue();

        boolean hasWaitId();
    }

    public static final class ReturnValue extends GeneratedMessage implements ReturnValueOrBuilder {
        public static Parser<ReturnValue> PARSER = new AbstractParser<ReturnValue>() {
            public final ReturnValue parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReturnValue(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALBOOLEAN_FIELD_NUMBER = 2;
        public static final int VALDOUBLE_FIELD_NUMBER = 6;
        public static final int VALFLOAT_FIELD_NUMBER = 5;
        public static final int VALINT_FIELD_NUMBER = 3;
        public static final int VALLONG_FIELD_NUMBER = 4;
        public static final int VALSTRING_FIELD_NUMBER = 7;
        private static final ReturnValue defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public FundType type_;
        private final UnknownFieldSet unknownFields;
        /* access modifiers changed from: private */
        public boolean valBoolean_;
        /* access modifiers changed from: private */
        public double valDouble_;
        /* access modifiers changed from: private */
        public float valFloat_;
        /* access modifiers changed from: private */
        public int valInt_;
        /* access modifiers changed from: private */
        public long valLong_;
        /* access modifiers changed from: private */
        public Object valString_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ReturnValueOrBuilder {
            private int bitField0_;
            private FundType type_;
            private boolean valBoolean_;
            private double valDouble_;
            private float valFloat_;
            private int valInt_;
            private long valLong_;
            private Object valString_;

            private Builder() {
                this.type_ = FundType.VOID;
                this.valString_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = FundType.VOID;
                this.valString_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Ipc.f2576c;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ReturnValue.alwaysUseFieldBuilders;
            }

            public final ReturnValue build() {
                ReturnValue buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final ReturnValue buildPartial() {
                ReturnValue returnValue = new ReturnValue((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                FundType unused = returnValue.type_ = this.type_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                boolean unused2 = returnValue.valBoolean_ = this.valBoolean_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                int unused3 = returnValue.valInt_ = this.valInt_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                long unused4 = returnValue.valLong_ = this.valLong_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                float unused5 = returnValue.valFloat_ = this.valFloat_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                double unused6 = returnValue.valDouble_ = this.valDouble_;
                if ((i & 64) == 64) {
                    i2 |= 64;
                }
                Object unused7 = returnValue.valString_ = this.valString_;
                int unused8 = returnValue.bitField0_ = i2;
                onBuilt();
                return returnValue;
            }

            public final Builder clear() {
                super.clear();
                this.type_ = FundType.VOID;
                this.bitField0_ &= -2;
                this.valBoolean_ = false;
                this.bitField0_ &= -3;
                this.valInt_ = 0;
                this.bitField0_ &= -5;
                this.valLong_ = 0;
                this.bitField0_ &= -9;
                this.valFloat_ = 0.0f;
                this.bitField0_ &= -17;
                this.valDouble_ = 0.0d;
                this.bitField0_ &= -33;
                this.valString_ = "";
                this.bitField0_ &= -65;
                return this;
            }

            public final Builder clearType() {
                this.bitField0_ &= -2;
                this.type_ = FundType.VOID;
                onChanged();
                return this;
            }

            public final Builder clearValBoolean() {
                this.bitField0_ &= -3;
                this.valBoolean_ = false;
                onChanged();
                return this;
            }

            public final Builder clearValDouble() {
                this.bitField0_ &= -33;
                this.valDouble_ = 0.0d;
                onChanged();
                return this;
            }

            public final Builder clearValFloat() {
                this.bitField0_ &= -17;
                this.valFloat_ = 0.0f;
                onChanged();
                return this;
            }

            public final Builder clearValInt() {
                this.bitField0_ &= -5;
                this.valInt_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearValLong() {
                this.bitField0_ &= -9;
                this.valLong_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearValString() {
                this.bitField0_ &= -65;
                this.valString_ = ReturnValue.getDefaultInstance().getValString();
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final ReturnValue getDefaultInstanceForType() {
                return ReturnValue.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return Ipc.f2576c;
            }

            public final FundType getType() {
                return this.type_;
            }

            public final boolean getValBoolean() {
                return this.valBoolean_;
            }

            public final double getValDouble() {
                return this.valDouble_;
            }

            public final float getValFloat() {
                return this.valFloat_;
            }

            public final int getValInt() {
                return this.valInt_;
            }

            public final long getValLong() {
                return this.valLong_;
            }

            public final String getValString() {
                Object obj = this.valString_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.valString_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getValStringBytes() {
                Object obj = this.valString_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.valString_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final boolean hasType() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasValBoolean() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasValDouble() {
                return (this.bitField0_ & 32) == 32;
            }

            public final boolean hasValFloat() {
                return (this.bitField0_ & 16) == 16;
            }

            public final boolean hasValInt() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasValLong() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean hasValString() {
                return (this.bitField0_ & 64) == 64;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return Ipc.d.ensureFieldAccessorsInitialized(ReturnValue.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public final Builder mergeFrom(ReturnValue returnValue) {
                if (returnValue == ReturnValue.getDefaultInstance()) {
                    return this;
                }
                if (returnValue.hasType()) {
                    setType(returnValue.getType());
                }
                if (returnValue.hasValBoolean()) {
                    setValBoolean(returnValue.getValBoolean());
                }
                if (returnValue.hasValInt()) {
                    setValInt(returnValue.getValInt());
                }
                if (returnValue.hasValLong()) {
                    setValLong(returnValue.getValLong());
                }
                if (returnValue.hasValFloat()) {
                    setValFloat(returnValue.getValFloat());
                }
                if (returnValue.hasValDouble()) {
                    setValDouble(returnValue.getValDouble());
                }
                if (returnValue.hasValString()) {
                    this.bitField0_ |= 64;
                    this.valString_ = returnValue.valString_;
                    onChanged();
                }
                mergeUnknownFields(returnValue.getUnknownFields());
                return this;
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ReturnValue returnValue;
                ReturnValue returnValue2 = null;
                try {
                    ReturnValue parsePartialFrom = ReturnValue.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    returnValue = (ReturnValue) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    returnValue2 = returnValue;
                }
                if (returnValue2 != null) {
                    mergeFrom(returnValue2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof ReturnValue) {
                    return mergeFrom((ReturnValue) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder setType(FundType fundType) {
                if (fundType == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.type_ = fundType;
                onChanged();
                return this;
            }

            public final Builder setValBoolean(boolean z) {
                this.bitField0_ |= 2;
                this.valBoolean_ = z;
                onChanged();
                return this;
            }

            public final Builder setValDouble(double d) {
                this.bitField0_ |= 32;
                this.valDouble_ = d;
                onChanged();
                return this;
            }

            public final Builder setValFloat(float f) {
                this.bitField0_ |= 16;
                this.valFloat_ = f;
                onChanged();
                return this;
            }

            public final Builder setValInt(int i) {
                this.bitField0_ |= 4;
                this.valInt_ = i;
                onChanged();
                return this;
            }

            public final Builder setValLong(long j) {
                this.bitField0_ |= 8;
                this.valLong_ = j;
                onChanged();
                return this;
            }

            public final Builder setValString(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.valString_ = str;
                onChanged();
                return this;
            }

            public final Builder setValStringBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.valString_ = byteString;
                onChanged();
                return this;
            }
        }

        static {
            ReturnValue returnValue = new ReturnValue(true);
            defaultInstance = returnValue;
            returnValue.initFields();
        }

        private ReturnValue(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            int readEnum = codedInputStream.readEnum();
                            FundType valueOf = FundType.valueOf(readEnum);
                            if (valueOf == null) {
                                newBuilder.mergeVarintField(1, readEnum);
                            } else {
                                this.bitField0_ |= 1;
                                this.type_ = valueOf;
                            }
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.valBoolean_ = codedInputStream.readBool();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.valInt_ = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.valLong_ = codedInputStream.readInt64();
                        } else if (readTag == 45) {
                            this.bitField0_ |= 16;
                            this.valFloat_ = codedInputStream.readFloat();
                        } else if (readTag == 49) {
                            this.bitField0_ |= 32;
                            this.valDouble_ = codedInputStream.readDouble();
                        } else if (readTag == 58) {
                            this.bitField0_ |= 64;
                            this.valString_ = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                } catch (Throwable th) {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private ReturnValue(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ReturnValue(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ReturnValue getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Ipc.f2576c;
        }

        private void initFields() {
            this.type_ = FundType.VOID;
            this.valBoolean_ = false;
            this.valInt_ = 0;
            this.valLong_ = 0;
            this.valFloat_ = 0.0f;
            this.valDouble_ = 0.0d;
            this.valString_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ReturnValue returnValue) {
            return newBuilder().mergeFrom(returnValue);
        }

        public static ReturnValue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ReturnValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ReturnValue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ReturnValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ReturnValue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ReturnValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ReturnValue parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ReturnValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ReturnValue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ReturnValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final ReturnValue getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<ReturnValue> getParserForType() {
            return PARSER;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeBoolSize(2, this.valBoolean_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeInt32Size(3, this.valInt_);
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeInt64Size(4, this.valLong_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeFloatSize(5, this.valFloat_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeDoubleSize(6, this.valDouble_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i2 += CodedOutputStream.computeBytesSize(7, getValStringBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final FundType getType() {
            return this.type_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean getValBoolean() {
            return this.valBoolean_;
        }

        public final double getValDouble() {
            return this.valDouble_;
        }

        public final float getValFloat() {
            return this.valFloat_;
        }

        public final int getValInt() {
            return this.valInt_;
        }

        public final long getValLong() {
            return this.valLong_;
        }

        public final String getValString() {
            Object obj = this.valString_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.valString_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getValStringBytes() {
            Object obj = this.valString_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.valString_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean hasType() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasValBoolean() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasValDouble() {
            return (this.bitField0_ & 32) == 32;
        }

        public final boolean hasValFloat() {
            return (this.bitField0_ & 16) == 16;
        }

        public final boolean hasValInt() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasValLong() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean hasValString() {
            return (this.bitField0_ & 64) == 64;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Ipc.d.ensureFieldAccessorsInitialized(ReturnValue.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public final Builder newBuilderForType() {
            return newBuilder();
        }

        /* access modifiers changed from: protected */
        public final Builder newBuilderForType(GeneratedMessage.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public final Builder toBuilder() {
            return newBuilder(this);
        }

        /* access modifiers changed from: protected */
        public final Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.type_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(2, this.valBoolean_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.valInt_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeInt64(4, this.valLong_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeFloat(5, this.valFloat_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeDouble(6, this.valDouble_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.writeBytes(7, getValStringBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface ReturnValueOrBuilder extends MessageOrBuilder {
        FundType getType();

        boolean getValBoolean();

        double getValDouble();

        float getValFloat();

        int getValInt();

        long getValLong();

        String getValString();

        ByteString getValStringBytes();

        boolean hasType();

        boolean hasValBoolean();

        boolean hasValDouble();

        boolean hasValFloat();

        boolean hasValInt();

        boolean hasValLong();

        boolean hasValString();
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\tipc.proto\u0012\tJCPattern\"#\n\u0006Device\u0012\f\n\u0004imei\u0018\u0001 \u0001(\t\u0012\u000b\n\u0003mac\u0018\u0002 \u0001(\t\"£\u0001\n\u000bReturnValue\u0012'\n\u0004type\u0018\u0001 \u0001(\u000e2\u0013.JCPattern.FundType:\u0004VOID\u0012\u0012\n\nvalBoolean\u0018\u0002 \u0001(\b\u0012\u000e\n\u0006valInt\u0018\u0003 \u0001(\u0005\u0012\u000f\n\u0007valLong\u0018\u0004 \u0001(\u0003\u0012\u0010\n\bvalFloat\u0018\u0005 \u0001(\u0002\u0012\u0011\n\tvalDouble\u0018\u0006 \u0001(\u0001\u0012\u0011\n\tvalString\u0018\u0007 \u0001(\t\"Å\u0002\n\nIpcMessage\u0012\u000e\n\u0003cmd\u0018\u0001 \u0001(\u0005:\u00010\u0012\f\n\u0004arg1\u0018\u0002 \u0003(\u0005\u0012\f\n\u0004arg2\u0018\u0003 \u0003(\t\u0012\f\n\u0004arg3\u0018\u0004 \u0003(\u0002\u0012\u0010\n\bfileData\u0018\u0005 \u0001(\f\u0012\f\n\u0004arg4\u0018\u0006 \u0003(\u0003\u0012\u000f\n\u0007pkgName\u0018\u0007 \u0001(\t\u0012\u0011\n\tclassName\u0018\b \u0001(\t\u0012\u0012\n\nmethodName\u0018\t \u0001(\t\u0012\r\n\u0005types\u0018\n \u0003(", "\t\u0012\u000e\n\u0006params\u0018\u000b \u0003(\t\u0012\u0019\n\nisSyncCall\u0018\f \u0001(\b:\u0005false\u0012\u0011\n\u0006waitId\u0018\r \u0001(\u0005:\u00010\u0012(\n\bretValue\u0018\u000e \u0001(\u000b2\u0016.JCPattern.ReturnValue\u0012\u0016\n\u0007encrypt\u0018\u000f \u0001(\b:\u0005false\u0012\u0016\n\u0007isDebug\u0018\u0010 \u0001(\b:\u0005false*W\n\bFundType\u0012\b\n\u0004VOID\u0010\u0001\u0012\u000b\n\u0007BOOLEAN\u0010\u0002\u0012\u0007\n\u0003INT\u0010\u0003\u0012\b\n\u0004LONG\u0010\u0004\u0012\t\n\u0005FLOAT\u0010\u0005\u0012\n\n\u0006DOUBLE\u0010\u0006\u0012\n\n\u0006STRING\u0010\u0007B&\n\u001fcom.cyjh.mobileanjian.ipc.protoB\u0003Ipc"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public final ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = Ipc.g = fileDescriptor;
                Descriptors.Descriptor unused2 = Ipc.f2574a = Ipc.a().getMessageTypes().get(0);
                GeneratedMessage.FieldAccessorTable unused3 = Ipc.f2575b = new GeneratedMessage.FieldAccessorTable(Ipc.f2574a, new String[]{"Imei", "Mac"});
                Descriptors.Descriptor unused4 = Ipc.f2576c = Ipc.a().getMessageTypes().get(1);
                GeneratedMessage.FieldAccessorTable unused5 = Ipc.d = new GeneratedMessage.FieldAccessorTable(Ipc.f2576c, new String[]{"Type", "ValBoolean", "ValInt", "ValLong", "ValFloat", "ValDouble", "ValString"});
                Descriptors.Descriptor unused6 = Ipc.e = Ipc.a().getMessageTypes().get(2);
                GeneratedMessage.FieldAccessorTable unused7 = Ipc.f = new GeneratedMessage.FieldAccessorTable(Ipc.e, new String[]{"Cmd", "Arg1", "Arg2", "Arg3", "FileData", "Arg4", "PkgName", "ClassName", "MethodName", "Types", "Params", "IsSyncCall", "WaitId", "RetValue", "Encrypt", "IsDebug"});
                return null;
            }
        });
    }

    private Ipc() {
    }

    public static Descriptors.FileDescriptor a() {
        return g;
    }

    private static void h() {
    }
}
