package com.hlzn.socketclient.pbmsg;

import com.cyjh.elfin.a.b;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;

public final class MessageProtobuf {
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor A;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable B;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor C;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable D;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor E;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable F;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor G;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable H;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor I;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable J;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor K;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable L;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor M;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable N;
    /* access modifiers changed from: private */
    public static Descriptors.FileDescriptor O;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Descriptors.Descriptor f3456a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static GeneratedMessage.FieldAccessorTable f3457b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Descriptors.Descriptor f3458c;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable d;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor e;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable f;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor g;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable h;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor i;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable j;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor k;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable l;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor m;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable n;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor o;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable p;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor q;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable r;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor s;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable t;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor u;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable v;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor w;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable x;
    /* access modifiers changed from: private */
    public static Descriptors.Descriptor y;
    /* access modifiers changed from: private */
    public static GeneratedMessage.FieldAccessorTable z;

    public static final class CmdRenameDeviceName extends GeneratedMessage implements CmdRenameDeviceNameOrBuilder {
        public static final int NEWDEVICENAME_FIELD_NUMBER = 1;
        public static Parser<CmdRenameDeviceName> PARSER = new AbstractParser<CmdRenameDeviceName>() {
            public final CmdRenameDeviceName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdRenameDeviceName(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdRenameDeviceName defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object newDeviceName_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdRenameDeviceNameOrBuilder {
            private int bitField0_;
            private Object newDeviceName_;
            private long rpcId_;

            private Builder() {
                this.newDeviceName_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.newDeviceName_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.K;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdRenameDeviceName.alwaysUseFieldBuilders;
            }

            public final CmdRenameDeviceName build() {
                CmdRenameDeviceName buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdRenameDeviceName buildPartial() {
                CmdRenameDeviceName cmdRenameDeviceName = new CmdRenameDeviceName((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdRenameDeviceName.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = cmdRenameDeviceName.newDeviceName_ = this.newDeviceName_;
                int unused3 = cmdRenameDeviceName.bitField0_ = i2;
                onBuilt();
                return cmdRenameDeviceName;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.newDeviceName_ = "";
                this.bitField0_ &= -3;
                return this;
            }

            public final Builder clearNewDeviceName() {
                this.bitField0_ &= -3;
                this.newDeviceName_ = CmdRenameDeviceName.getDefaultInstance().getNewDeviceName();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdRenameDeviceName getDefaultInstanceForType() {
                return CmdRenameDeviceName.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.K;
            }

            public final String getNewDeviceName() {
                Object obj = this.newDeviceName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.newDeviceName_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getNewDeviceNameBytes() {
                Object obj = this.newDeviceName_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.newDeviceName_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasNewDeviceName() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.L.ensureFieldAccessorsInitialized(CmdRenameDeviceName.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasNewDeviceName();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdRenameDeviceName cmdRenameDeviceName;
                CmdRenameDeviceName cmdRenameDeviceName2 = null;
                try {
                    CmdRenameDeviceName parsePartialFrom = CmdRenameDeviceName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdRenameDeviceName = (CmdRenameDeviceName) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdRenameDeviceName2 = cmdRenameDeviceName;
                }
                if (cmdRenameDeviceName2 != null) {
                    mergeFrom(cmdRenameDeviceName2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdRenameDeviceName) {
                    return mergeFrom((CmdRenameDeviceName) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdRenameDeviceName cmdRenameDeviceName) {
                if (cmdRenameDeviceName == CmdRenameDeviceName.getDefaultInstance()) {
                    return this;
                }
                if (cmdRenameDeviceName.hasRpcId()) {
                    setRpcId(cmdRenameDeviceName.getRpcId());
                }
                if (cmdRenameDeviceName.hasNewDeviceName()) {
                    this.bitField0_ |= 2;
                    this.newDeviceName_ = cmdRenameDeviceName.newDeviceName_;
                    onChanged();
                }
                mergeUnknownFields(cmdRenameDeviceName.getUnknownFields());
                return this;
            }

            public final Builder setNewDeviceName(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.newDeviceName_ = str;
                onChanged();
                return this;
            }

            public final Builder setNewDeviceNameBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.newDeviceName_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdRenameDeviceName cmdRenameDeviceName = new CmdRenameDeviceName(true);
            defaultInstance = cmdRenameDeviceName;
            cmdRenameDeviceName.initFields();
        }

        private CmdRenameDeviceName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 2;
                            this.newDeviceName_ = codedInputStream.readBytes();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdRenameDeviceName(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdRenameDeviceName(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdRenameDeviceName getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.K;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.newDeviceName_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdRenameDeviceName cmdRenameDeviceName) {
            return newBuilder().mergeFrom(cmdRenameDeviceName);
        }

        public static CmdRenameDeviceName parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdRenameDeviceName parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceName parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdRenameDeviceName parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdRenameDeviceName parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdRenameDeviceName parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceName parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdRenameDeviceName parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceName parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdRenameDeviceName parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdRenameDeviceName getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final String getNewDeviceName() {
            Object obj = this.newDeviceName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.newDeviceName_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getNewDeviceNameBytes() {
            Object obj = this.newDeviceName_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.newDeviceName_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdRenameDeviceName> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, getNewDeviceNameBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasNewDeviceName() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.L.ensureFieldAccessorsInitialized(CmdRenameDeviceName.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasNewDeviceName()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(1, getNewDeviceNameBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdRenameDeviceNameOrBuilder extends MessageOrBuilder {
        String getNewDeviceName();

        ByteString getNewDeviceNameBytes();

        long getRpcId();

        boolean hasNewDeviceName();

        boolean hasRpcId();
    }

    public static final class CmdRenameDeviceNameResult extends GeneratedMessage implements CmdRenameDeviceNameResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdRenameDeviceNameResult> PARSER = new AbstractParser<CmdRenameDeviceNameResult>() {
            public final CmdRenameDeviceNameResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdRenameDeviceNameResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdRenameDeviceNameResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdRenameDeviceNameResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.M;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdRenameDeviceNameResult.alwaysUseFieldBuilders;
            }

            public final CmdRenameDeviceNameResult build() {
                CmdRenameDeviceNameResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdRenameDeviceNameResult buildPartial() {
                CmdRenameDeviceNameResult cmdRenameDeviceNameResult = new CmdRenameDeviceNameResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdRenameDeviceNameResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdRenameDeviceNameResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdRenameDeviceNameResult.message_ = this.message_;
                int unused4 = cmdRenameDeviceNameResult.bitField0_ = i2;
                onBuilt();
                return cmdRenameDeviceNameResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdRenameDeviceNameResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdRenameDeviceNameResult getDefaultInstanceForType() {
                return CmdRenameDeviceNameResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.M;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.N.ensureFieldAccessorsInitialized(CmdRenameDeviceNameResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdRenameDeviceNameResult cmdRenameDeviceNameResult;
                CmdRenameDeviceNameResult cmdRenameDeviceNameResult2 = null;
                try {
                    CmdRenameDeviceNameResult parsePartialFrom = CmdRenameDeviceNameResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdRenameDeviceNameResult = (CmdRenameDeviceNameResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdRenameDeviceNameResult2 = cmdRenameDeviceNameResult;
                }
                if (cmdRenameDeviceNameResult2 != null) {
                    mergeFrom(cmdRenameDeviceNameResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdRenameDeviceNameResult) {
                    return mergeFrom((CmdRenameDeviceNameResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdRenameDeviceNameResult cmdRenameDeviceNameResult) {
                if (cmdRenameDeviceNameResult == CmdRenameDeviceNameResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdRenameDeviceNameResult.hasRpcId()) {
                    setRpcId(cmdRenameDeviceNameResult.getRpcId());
                }
                if (cmdRenameDeviceNameResult.hasError()) {
                    setError(cmdRenameDeviceNameResult.getError());
                }
                if (cmdRenameDeviceNameResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdRenameDeviceNameResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdRenameDeviceNameResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdRenameDeviceNameResult cmdRenameDeviceNameResult = new CmdRenameDeviceNameResult(true);
            defaultInstance = cmdRenameDeviceNameResult;
            cmdRenameDeviceNameResult.initFields();
        }

        private CmdRenameDeviceNameResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdRenameDeviceNameResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdRenameDeviceNameResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdRenameDeviceNameResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.M;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdRenameDeviceNameResult cmdRenameDeviceNameResult) {
            return newBuilder().mergeFrom(cmdRenameDeviceNameResult);
        }

        public static CmdRenameDeviceNameResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdRenameDeviceNameResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceNameResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdRenameDeviceNameResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdRenameDeviceNameResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdRenameDeviceNameResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceNameResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdRenameDeviceNameResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdRenameDeviceNameResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdRenameDeviceNameResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdRenameDeviceNameResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdRenameDeviceNameResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.N.ensureFieldAccessorsInitialized(CmdRenameDeviceNameResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdRenameDeviceNameResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdScreenCapture extends GeneratedMessage implements CmdScreenCaptureOrBuilder {
        public static Parser<CmdScreenCapture> PARSER = new AbstractParser<CmdScreenCapture>() {
            public final CmdScreenCapture parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScreenCapture(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScreenCapture defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScreenCaptureOrBuilder {
            private int bitField0_;
            private long rpcId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.C;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScreenCapture.alwaysUseFieldBuilders;
            }

            public final CmdScreenCapture build() {
                CmdScreenCapture buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScreenCapture buildPartial() {
                CmdScreenCapture cmdScreenCapture = new CmdScreenCapture((GeneratedMessage.Builder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                long unused = cmdScreenCapture.rpcId_ = this.rpcId_;
                int unused2 = cmdScreenCapture.bitField0_ = i;
                onBuilt();
                return cmdScreenCapture;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScreenCapture getDefaultInstanceForType() {
                return CmdScreenCapture.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.C;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.D.ensureFieldAccessorsInitialized(CmdScreenCapture.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScreenCapture cmdScreenCapture;
                CmdScreenCapture cmdScreenCapture2 = null;
                try {
                    CmdScreenCapture parsePartialFrom = CmdScreenCapture.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScreenCapture = (CmdScreenCapture) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScreenCapture2 = cmdScreenCapture;
                }
                if (cmdScreenCapture2 != null) {
                    mergeFrom(cmdScreenCapture2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScreenCapture) {
                    return mergeFrom((CmdScreenCapture) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScreenCapture cmdScreenCapture) {
                if (cmdScreenCapture == CmdScreenCapture.getDefaultInstance()) {
                    return this;
                }
                if (cmdScreenCapture.hasRpcId()) {
                    setRpcId(cmdScreenCapture.getRpcId());
                }
                mergeUnknownFields(cmdScreenCapture.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScreenCapture cmdScreenCapture = new CmdScreenCapture(true);
            defaultInstance = cmdScreenCapture;
            cmdScreenCapture.initFields();
        }

        private CmdScreenCapture(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdScreenCapture(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScreenCapture(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScreenCapture getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.C;
        }

        private void initFields() {
            this.rpcId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScreenCapture cmdScreenCapture) {
            return newBuilder().mergeFrom(cmdScreenCapture);
        }

        public static CmdScreenCapture parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScreenCapture parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScreenCapture parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScreenCapture parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScreenCapture parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScreenCapture parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScreenCapture parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScreenCapture parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScreenCapture parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScreenCapture parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScreenCapture getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdScreenCapture> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.D.ensureFieldAccessorsInitialized(CmdScreenCapture.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScreenCaptureOrBuilder extends MessageOrBuilder {
        long getRpcId();

        boolean hasRpcId();
    }

    public static final class CmdScreenCaptureResult extends GeneratedMessage implements CmdScreenCaptureResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdScreenCaptureResult> PARSER = new AbstractParser<CmdScreenCaptureResult>() {
            public final CmdScreenCaptureResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScreenCaptureResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScreenCaptureResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScreenCaptureResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.E;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScreenCaptureResult.alwaysUseFieldBuilders;
            }

            public final CmdScreenCaptureResult build() {
                CmdScreenCaptureResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScreenCaptureResult buildPartial() {
                CmdScreenCaptureResult cmdScreenCaptureResult = new CmdScreenCaptureResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScreenCaptureResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdScreenCaptureResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScreenCaptureResult.message_ = this.message_;
                int unused4 = cmdScreenCaptureResult.bitField0_ = i2;
                onBuilt();
                return cmdScreenCaptureResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdScreenCaptureResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScreenCaptureResult getDefaultInstanceForType() {
                return CmdScreenCaptureResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.E;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.F.ensureFieldAccessorsInitialized(CmdScreenCaptureResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScreenCaptureResult cmdScreenCaptureResult;
                CmdScreenCaptureResult cmdScreenCaptureResult2 = null;
                try {
                    CmdScreenCaptureResult parsePartialFrom = CmdScreenCaptureResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScreenCaptureResult = (CmdScreenCaptureResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScreenCaptureResult2 = cmdScreenCaptureResult;
                }
                if (cmdScreenCaptureResult2 != null) {
                    mergeFrom(cmdScreenCaptureResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScreenCaptureResult) {
                    return mergeFrom((CmdScreenCaptureResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScreenCaptureResult cmdScreenCaptureResult) {
                if (cmdScreenCaptureResult == CmdScreenCaptureResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdScreenCaptureResult.hasRpcId()) {
                    setRpcId(cmdScreenCaptureResult.getRpcId());
                }
                if (cmdScreenCaptureResult.hasError()) {
                    setError(cmdScreenCaptureResult.getError());
                }
                if (cmdScreenCaptureResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdScreenCaptureResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdScreenCaptureResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScreenCaptureResult cmdScreenCaptureResult = new CmdScreenCaptureResult(true);
            defaultInstance = cmdScreenCaptureResult;
            cmdScreenCaptureResult.initFields();
        }

        private CmdScreenCaptureResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdScreenCaptureResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScreenCaptureResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScreenCaptureResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.E;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScreenCaptureResult cmdScreenCaptureResult) {
            return newBuilder().mergeFrom(cmdScreenCaptureResult);
        }

        public static CmdScreenCaptureResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScreenCaptureResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScreenCaptureResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScreenCaptureResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScreenCaptureResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScreenCaptureResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScreenCaptureResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScreenCaptureResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScreenCaptureResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScreenCaptureResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScreenCaptureResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdScreenCaptureResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.F.ensureFieldAccessorsInitialized(CmdScreenCaptureResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScreenCaptureResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdScriptSettings extends GeneratedMessage implements CmdScriptSettingsOrBuilder {
        public static Parser<CmdScriptSettings> PARSER = new AbstractParser<CmdScriptSettings>() {
            public final CmdScriptSettings parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptSettings(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        public static final int SCRIPTSETTINGS_FIELD_NUMBER = 1;
        private static final CmdScriptSettings defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        /* access modifiers changed from: private */
        public Object scriptSettings_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptSettingsOrBuilder {
            private int bitField0_;
            private long rpcId_;
            private Object scriptSettings_;

            private Builder() {
                this.scriptSettings_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.scriptSettings_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.y;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptSettings.alwaysUseFieldBuilders;
            }

            public final CmdScriptSettings build() {
                CmdScriptSettings buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptSettings buildPartial() {
                CmdScriptSettings cmdScriptSettings = new CmdScriptSettings((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptSettings.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                Object unused2 = cmdScriptSettings.scriptSettings_ = this.scriptSettings_;
                int unused3 = cmdScriptSettings.bitField0_ = i2;
                onBuilt();
                return cmdScriptSettings;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.scriptSettings_ = "";
                this.bitField0_ &= -3;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearScriptSettings() {
                this.bitField0_ &= -3;
                this.scriptSettings_ = CmdScriptSettings.getDefaultInstance().getScriptSettings();
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptSettings getDefaultInstanceForType() {
                return CmdScriptSettings.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.y;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final String getScriptSettings() {
                Object obj = this.scriptSettings_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.scriptSettings_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getScriptSettingsBytes() {
                Object obj = this.scriptSettings_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scriptSettings_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasScriptSettings() {
                return (this.bitField0_ & 2) == 2;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.z.ensureFieldAccessorsInitialized(CmdScriptSettings.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasScriptSettings();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptSettings cmdScriptSettings;
                CmdScriptSettings cmdScriptSettings2 = null;
                try {
                    CmdScriptSettings parsePartialFrom = CmdScriptSettings.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptSettings = (CmdScriptSettings) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptSettings2 = cmdScriptSettings;
                }
                if (cmdScriptSettings2 != null) {
                    mergeFrom(cmdScriptSettings2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptSettings) {
                    return mergeFrom((CmdScriptSettings) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptSettings cmdScriptSettings) {
                if (cmdScriptSettings == CmdScriptSettings.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptSettings.hasRpcId()) {
                    setRpcId(cmdScriptSettings.getRpcId());
                }
                if (cmdScriptSettings.hasScriptSettings()) {
                    this.bitField0_ |= 2;
                    this.scriptSettings_ = cmdScriptSettings.scriptSettings_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptSettings.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }

            public final Builder setScriptSettings(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.scriptSettings_ = str;
                onChanged();
                return this;
            }

            public final Builder setScriptSettingsBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.scriptSettings_ = byteString;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptSettings cmdScriptSettings = new CmdScriptSettings(true);
            defaultInstance = cmdScriptSettings;
            cmdScriptSettings.initFields();
        }

        private CmdScriptSettings(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 2;
                            this.scriptSettings_ = codedInputStream.readBytes();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdScriptSettings(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptSettings(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptSettings getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.y;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.scriptSettings_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptSettings cmdScriptSettings) {
            return newBuilder().mergeFrom(cmdScriptSettings);
        }

        public static CmdScriptSettings parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptSettings parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptSettings parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptSettings parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptSettings parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptSettings getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdScriptSettings> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final String getScriptSettings() {
            Object obj = this.scriptSettings_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.scriptSettings_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getScriptSettingsBytes() {
            Object obj = this.scriptSettings_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.scriptSettings_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 = 0 + CodedOutputStream.computeBytesSize(1, getScriptSettingsBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasScriptSettings() {
            return (this.bitField0_ & 2) == 2;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.z.ensureFieldAccessorsInitialized(CmdScriptSettings.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptSettings()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBytes(1, getScriptSettingsBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptSettingsOrBuilder extends MessageOrBuilder {
        long getRpcId();

        String getScriptSettings();

        ByteString getScriptSettingsBytes();

        boolean hasRpcId();

        boolean hasScriptSettings();
    }

    public static final class CmdScriptSettingsResult extends GeneratedMessage implements CmdScriptSettingsResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdScriptSettingsResult> PARSER = new AbstractParser<CmdScriptSettingsResult>() {
            public final CmdScriptSettingsResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptSettingsResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptSettingsResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptSettingsResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.A;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptSettingsResult.alwaysUseFieldBuilders;
            }

            public final CmdScriptSettingsResult build() {
                CmdScriptSettingsResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptSettingsResult buildPartial() {
                CmdScriptSettingsResult cmdScriptSettingsResult = new CmdScriptSettingsResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptSettingsResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdScriptSettingsResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScriptSettingsResult.message_ = this.message_;
                int unused4 = cmdScriptSettingsResult.bitField0_ = i2;
                onBuilt();
                return cmdScriptSettingsResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdScriptSettingsResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptSettingsResult getDefaultInstanceForType() {
                return CmdScriptSettingsResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.A;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.B.ensureFieldAccessorsInitialized(CmdScriptSettingsResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptSettingsResult cmdScriptSettingsResult;
                CmdScriptSettingsResult cmdScriptSettingsResult2 = null;
                try {
                    CmdScriptSettingsResult parsePartialFrom = CmdScriptSettingsResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptSettingsResult = (CmdScriptSettingsResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptSettingsResult2 = cmdScriptSettingsResult;
                }
                if (cmdScriptSettingsResult2 != null) {
                    mergeFrom(cmdScriptSettingsResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptSettingsResult) {
                    return mergeFrom((CmdScriptSettingsResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptSettingsResult cmdScriptSettingsResult) {
                if (cmdScriptSettingsResult == CmdScriptSettingsResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptSettingsResult.hasRpcId()) {
                    setRpcId(cmdScriptSettingsResult.getRpcId());
                }
                if (cmdScriptSettingsResult.hasError()) {
                    setError(cmdScriptSettingsResult.getError());
                }
                if (cmdScriptSettingsResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdScriptSettingsResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptSettingsResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptSettingsResult cmdScriptSettingsResult = new CmdScriptSettingsResult(true);
            defaultInstance = cmdScriptSettingsResult;
            cmdScriptSettingsResult.initFields();
        }

        private CmdScriptSettingsResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdScriptSettingsResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptSettingsResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptSettingsResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.A;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptSettingsResult cmdScriptSettingsResult) {
            return newBuilder().mergeFrom(cmdScriptSettingsResult);
        }

        public static CmdScriptSettingsResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptSettingsResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptSettingsResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptSettingsResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptSettingsResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptSettingsResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptSettingsResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptSettingsResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptSettingsResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptSettingsResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptSettingsResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdScriptSettingsResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.B.ensureFieldAccessorsInitialized(CmdScriptSettingsResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptSettingsResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdScriptStart extends GeneratedMessage implements CmdScriptStartOrBuilder {
        public static Parser<CmdScriptStart> PARSER = new AbstractParser<CmdScriptStart>() {
            public final CmdScriptStart parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptStart(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptStart defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptStartOrBuilder {
            private int bitField0_;
            private long rpcId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.m;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptStart.alwaysUseFieldBuilders;
            }

            public final CmdScriptStart build() {
                CmdScriptStart buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptStart buildPartial() {
                CmdScriptStart cmdScriptStart = new CmdScriptStart((GeneratedMessage.Builder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                long unused = cmdScriptStart.rpcId_ = this.rpcId_;
                int unused2 = cmdScriptStart.bitField0_ = i;
                onBuilt();
                return cmdScriptStart;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptStart getDefaultInstanceForType() {
                return CmdScriptStart.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.m;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.n.ensureFieldAccessorsInitialized(CmdScriptStart.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptStart cmdScriptStart;
                CmdScriptStart cmdScriptStart2 = null;
                try {
                    CmdScriptStart parsePartialFrom = CmdScriptStart.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptStart = (CmdScriptStart) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptStart2 = cmdScriptStart;
                }
                if (cmdScriptStart2 != null) {
                    mergeFrom(cmdScriptStart2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptStart) {
                    return mergeFrom((CmdScriptStart) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptStart cmdScriptStart) {
                if (cmdScriptStart == CmdScriptStart.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptStart.hasRpcId()) {
                    setRpcId(cmdScriptStart.getRpcId());
                }
                mergeUnknownFields(cmdScriptStart.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptStart cmdScriptStart = new CmdScriptStart(true);
            defaultInstance = cmdScriptStart;
            cmdScriptStart.initFields();
        }

        private CmdScriptStart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdScriptStart(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptStart(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptStart getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.m;
        }

        private void initFields() {
            this.rpcId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptStart cmdScriptStart) {
            return newBuilder().mergeFrom(cmdScriptStart);
        }

        public static CmdScriptStart parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptStart parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptStart parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptStart getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdScriptStart> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.n.ensureFieldAccessorsInitialized(CmdScriptStart.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptStartOrBuilder extends MessageOrBuilder {
        long getRpcId();

        boolean hasRpcId();
    }

    public static final class CmdScriptStartResult extends GeneratedMessage implements CmdScriptStartResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdScriptStartResult> PARSER = new AbstractParser<CmdScriptStartResult>() {
            public final CmdScriptStartResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptStartResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptStartResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptStartResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.o;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptStartResult.alwaysUseFieldBuilders;
            }

            public final CmdScriptStartResult build() {
                CmdScriptStartResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptStartResult buildPartial() {
                CmdScriptStartResult cmdScriptStartResult = new CmdScriptStartResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptStartResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdScriptStartResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScriptStartResult.message_ = this.message_;
                int unused4 = cmdScriptStartResult.bitField0_ = i2;
                onBuilt();
                return cmdScriptStartResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdScriptStartResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptStartResult getDefaultInstanceForType() {
                return CmdScriptStartResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.o;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.p.ensureFieldAccessorsInitialized(CmdScriptStartResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptStartResult cmdScriptStartResult;
                CmdScriptStartResult cmdScriptStartResult2 = null;
                try {
                    CmdScriptStartResult parsePartialFrom = CmdScriptStartResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptStartResult = (CmdScriptStartResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptStartResult2 = cmdScriptStartResult;
                }
                if (cmdScriptStartResult2 != null) {
                    mergeFrom(cmdScriptStartResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptStartResult) {
                    return mergeFrom((CmdScriptStartResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptStartResult cmdScriptStartResult) {
                if (cmdScriptStartResult == CmdScriptStartResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptStartResult.hasRpcId()) {
                    setRpcId(cmdScriptStartResult.getRpcId());
                }
                if (cmdScriptStartResult.hasError()) {
                    setError(cmdScriptStartResult.getError());
                }
                if (cmdScriptStartResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdScriptStartResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptStartResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptStartResult cmdScriptStartResult = new CmdScriptStartResult(true);
            defaultInstance = cmdScriptStartResult;
            cmdScriptStartResult.initFields();
        }

        private CmdScriptStartResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdScriptStartResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptStartResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptStartResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.o;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptStartResult cmdScriptStartResult) {
            return newBuilder().mergeFrom(cmdScriptStartResult);
        }

        public static CmdScriptStartResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptStartResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStartResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptStartResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptStartResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptStartResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptStartResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptStartResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStartResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptStartResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptStartResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdScriptStartResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.p.ensureFieldAccessorsInitialized(CmdScriptStartResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptStartResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdScriptStop extends GeneratedMessage implements CmdScriptStopOrBuilder {
        public static Parser<CmdScriptStop> PARSER = new AbstractParser<CmdScriptStop>() {
            public final CmdScriptStop parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptStop(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptStop defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptStopOrBuilder {
            private int bitField0_;
            private long rpcId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.q;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptStop.alwaysUseFieldBuilders;
            }

            public final CmdScriptStop build() {
                CmdScriptStop buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptStop buildPartial() {
                CmdScriptStop cmdScriptStop = new CmdScriptStop((GeneratedMessage.Builder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                long unused = cmdScriptStop.rpcId_ = this.rpcId_;
                int unused2 = cmdScriptStop.bitField0_ = i;
                onBuilt();
                return cmdScriptStop;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptStop getDefaultInstanceForType() {
                return CmdScriptStop.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.q;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.r.ensureFieldAccessorsInitialized(CmdScriptStop.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptStop cmdScriptStop;
                CmdScriptStop cmdScriptStop2 = null;
                try {
                    CmdScriptStop parsePartialFrom = CmdScriptStop.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptStop = (CmdScriptStop) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptStop2 = cmdScriptStop;
                }
                if (cmdScriptStop2 != null) {
                    mergeFrom(cmdScriptStop2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptStop) {
                    return mergeFrom((CmdScriptStop) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptStop cmdScriptStop) {
                if (cmdScriptStop == CmdScriptStop.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptStop.hasRpcId()) {
                    setRpcId(cmdScriptStop.getRpcId());
                }
                mergeUnknownFields(cmdScriptStop.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptStop cmdScriptStop = new CmdScriptStop(true);
            defaultInstance = cmdScriptStop;
            cmdScriptStop.initFields();
        }

        private CmdScriptStop(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdScriptStop(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptStop(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptStop getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.q;
        }

        private void initFields() {
            this.rpcId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptStop cmdScriptStop) {
            return newBuilder().mergeFrom(cmdScriptStop);
        }

        public static CmdScriptStop parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptStop parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStop parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptStop parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptStop parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptStop parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptStop parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptStop parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStop parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptStop parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptStop getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdScriptStop> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.r.ensureFieldAccessorsInitialized(CmdScriptStop.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptStopOrBuilder extends MessageOrBuilder {
        long getRpcId();

        boolean hasRpcId();
    }

    public static final class CmdScriptStopResult extends GeneratedMessage implements CmdScriptStopResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdScriptStopResult> PARSER = new AbstractParser<CmdScriptStopResult>() {
            public final CmdScriptStopResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptStopResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptStopResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptStopResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.s;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptStopResult.alwaysUseFieldBuilders;
            }

            public final CmdScriptStopResult build() {
                CmdScriptStopResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptStopResult buildPartial() {
                CmdScriptStopResult cmdScriptStopResult = new CmdScriptStopResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptStopResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdScriptStopResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScriptStopResult.message_ = this.message_;
                int unused4 = cmdScriptStopResult.bitField0_ = i2;
                onBuilt();
                return cmdScriptStopResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdScriptStopResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptStopResult getDefaultInstanceForType() {
                return CmdScriptStopResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.s;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.t.ensureFieldAccessorsInitialized(CmdScriptStopResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptStopResult cmdScriptStopResult;
                CmdScriptStopResult cmdScriptStopResult2 = null;
                try {
                    CmdScriptStopResult parsePartialFrom = CmdScriptStopResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptStopResult = (CmdScriptStopResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptStopResult2 = cmdScriptStopResult;
                }
                if (cmdScriptStopResult2 != null) {
                    mergeFrom(cmdScriptStopResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptStopResult) {
                    return mergeFrom((CmdScriptStopResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptStopResult cmdScriptStopResult) {
                if (cmdScriptStopResult == CmdScriptStopResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptStopResult.hasRpcId()) {
                    setRpcId(cmdScriptStopResult.getRpcId());
                }
                if (cmdScriptStopResult.hasError()) {
                    setError(cmdScriptStopResult.getError());
                }
                if (cmdScriptStopResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdScriptStopResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptStopResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptStopResult cmdScriptStopResult = new CmdScriptStopResult(true);
            defaultInstance = cmdScriptStopResult;
            cmdScriptStopResult.initFields();
        }

        private CmdScriptStopResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdScriptStopResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptStopResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptStopResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.s;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptStopResult cmdScriptStopResult) {
            return newBuilder().mergeFrom(cmdScriptStopResult);
        }

        public static CmdScriptStopResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptStopResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStopResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptStopResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptStopResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptStopResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptStopResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptStopResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptStopResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptStopResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptStopResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdScriptStopResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.t.ensureFieldAccessorsInitialized(CmdScriptStopResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptStopResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdScriptUpgrade extends GeneratedMessage implements CmdScriptUpgradeOrBuilder {
        public static Parser<CmdScriptUpgrade> PARSER = new AbstractParser<CmdScriptUpgrade>() {
            public final CmdScriptUpgrade parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptUpgrade(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        public static final int SCRIPTFILEURL_FIELD_NUMBER = 2;
        public static final int SCRIPTVERSION_FIELD_NUMBER = 1;
        private static final CmdScriptUpgrade defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        /* access modifiers changed from: private */
        public Object scriptFileUrl_;
        /* access modifiers changed from: private */
        public long scriptVersion_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptUpgradeOrBuilder {
            private int bitField0_;
            private long rpcId_;
            private Object scriptFileUrl_;
            private long scriptVersion_;

            private Builder() {
                this.scriptFileUrl_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.scriptFileUrl_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.u;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptUpgrade.alwaysUseFieldBuilders;
            }

            public final CmdScriptUpgrade build() {
                CmdScriptUpgrade buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptUpgrade buildPartial() {
                CmdScriptUpgrade cmdScriptUpgrade = new CmdScriptUpgrade((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptUpgrade.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                long unused2 = cmdScriptUpgrade.scriptVersion_ = this.scriptVersion_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScriptUpgrade.scriptFileUrl_ = this.scriptFileUrl_;
                int unused4 = cmdScriptUpgrade.bitField0_ = i2;
                onBuilt();
                return cmdScriptUpgrade;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.scriptVersion_ = 0;
                this.bitField0_ &= -3;
                this.scriptFileUrl_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearScriptFileUrl() {
                this.bitField0_ &= -5;
                this.scriptFileUrl_ = CmdScriptUpgrade.getDefaultInstance().getScriptFileUrl();
                onChanged();
                return this;
            }

            public final Builder clearScriptVersion() {
                this.bitField0_ &= -3;
                this.scriptVersion_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptUpgrade getDefaultInstanceForType() {
                return CmdScriptUpgrade.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.u;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final String getScriptFileUrl() {
                Object obj = this.scriptFileUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.scriptFileUrl_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getScriptFileUrlBytes() {
                Object obj = this.scriptFileUrl_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scriptFileUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getScriptVersion() {
                return this.scriptVersion_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasScriptFileUrl() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasScriptVersion() {
                return (this.bitField0_ & 2) == 2;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.v.ensureFieldAccessorsInitialized(CmdScriptUpgrade.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasScriptVersion() && hasScriptFileUrl();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptUpgrade cmdScriptUpgrade;
                CmdScriptUpgrade cmdScriptUpgrade2 = null;
                try {
                    CmdScriptUpgrade parsePartialFrom = CmdScriptUpgrade.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptUpgrade = (CmdScriptUpgrade) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptUpgrade2 = cmdScriptUpgrade;
                }
                if (cmdScriptUpgrade2 != null) {
                    mergeFrom(cmdScriptUpgrade2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptUpgrade) {
                    return mergeFrom((CmdScriptUpgrade) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptUpgrade cmdScriptUpgrade) {
                if (cmdScriptUpgrade == CmdScriptUpgrade.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptUpgrade.hasRpcId()) {
                    setRpcId(cmdScriptUpgrade.getRpcId());
                }
                if (cmdScriptUpgrade.hasScriptVersion()) {
                    setScriptVersion(cmdScriptUpgrade.getScriptVersion());
                }
                if (cmdScriptUpgrade.hasScriptFileUrl()) {
                    this.bitField0_ |= 4;
                    this.scriptFileUrl_ = cmdScriptUpgrade.scriptFileUrl_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptUpgrade.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }

            public final Builder setScriptFileUrl(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.scriptFileUrl_ = str;
                onChanged();
                return this;
            }

            public final Builder setScriptFileUrlBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.scriptFileUrl_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setScriptVersion(long j) {
                this.bitField0_ |= 2;
                this.scriptVersion_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptUpgrade cmdScriptUpgrade = new CmdScriptUpgrade(true);
            defaultInstance = cmdScriptUpgrade;
            cmdScriptUpgrade.initFields();
        }

        private CmdScriptUpgrade(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 2;
                            this.scriptVersion_ = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0_ |= 4;
                            this.scriptFileUrl_ = codedInputStream.readBytes();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdScriptUpgrade(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptUpgrade(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptUpgrade getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.u;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.scriptVersion_ = 0;
            this.scriptFileUrl_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptUpgrade cmdScriptUpgrade) {
            return newBuilder().mergeFrom(cmdScriptUpgrade);
        }

        public static CmdScriptUpgrade parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptUpgrade parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgrade parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptUpgrade parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptUpgrade parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptUpgrade parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgrade parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptUpgrade parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgrade parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptUpgrade parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptUpgrade getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdScriptUpgrade> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final String getScriptFileUrl() {
            Object obj = this.scriptFileUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.scriptFileUrl_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getScriptFileUrlBytes() {
            Object obj = this.scriptFileUrl_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.scriptFileUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final long getScriptVersion() {
            return this.scriptVersion_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 = 0 + CodedOutputStream.computeInt64Size(1, this.scriptVersion_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(2, getScriptFileUrlBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasScriptFileUrl() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasScriptVersion() {
            return (this.bitField0_ & 2) == 2;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.v.ensureFieldAccessorsInitialized(CmdScriptUpgrade.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptVersion()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptFileUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(1, this.scriptVersion_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(2, getScriptFileUrlBytes());
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptUpgradeOrBuilder extends MessageOrBuilder {
        long getRpcId();

        String getScriptFileUrl();

        ByteString getScriptFileUrlBytes();

        long getScriptVersion();

        boolean hasRpcId();

        boolean hasScriptFileUrl();

        boolean hasScriptVersion();
    }

    public static final class CmdScriptUpgradeResult extends GeneratedMessage implements CmdScriptUpgradeResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdScriptUpgradeResult> PARSER = new AbstractParser<CmdScriptUpgradeResult>() {
            public final CmdScriptUpgradeResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdScriptUpgradeResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdScriptUpgradeResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdScriptUpgradeResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.w;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdScriptUpgradeResult.alwaysUseFieldBuilders;
            }

            public final CmdScriptUpgradeResult build() {
                CmdScriptUpgradeResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdScriptUpgradeResult buildPartial() {
                CmdScriptUpgradeResult cmdScriptUpgradeResult = new CmdScriptUpgradeResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdScriptUpgradeResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdScriptUpgradeResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdScriptUpgradeResult.message_ = this.message_;
                int unused4 = cmdScriptUpgradeResult.bitField0_ = i2;
                onBuilt();
                return cmdScriptUpgradeResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdScriptUpgradeResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdScriptUpgradeResult getDefaultInstanceForType() {
                return CmdScriptUpgradeResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.w;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.x.ensureFieldAccessorsInitialized(CmdScriptUpgradeResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdScriptUpgradeResult cmdScriptUpgradeResult;
                CmdScriptUpgradeResult cmdScriptUpgradeResult2 = null;
                try {
                    CmdScriptUpgradeResult parsePartialFrom = CmdScriptUpgradeResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdScriptUpgradeResult = (CmdScriptUpgradeResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdScriptUpgradeResult2 = cmdScriptUpgradeResult;
                }
                if (cmdScriptUpgradeResult2 != null) {
                    mergeFrom(cmdScriptUpgradeResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdScriptUpgradeResult) {
                    return mergeFrom((CmdScriptUpgradeResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdScriptUpgradeResult cmdScriptUpgradeResult) {
                if (cmdScriptUpgradeResult == CmdScriptUpgradeResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdScriptUpgradeResult.hasRpcId()) {
                    setRpcId(cmdScriptUpgradeResult.getRpcId());
                }
                if (cmdScriptUpgradeResult.hasError()) {
                    setError(cmdScriptUpgradeResult.getError());
                }
                if (cmdScriptUpgradeResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdScriptUpgradeResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdScriptUpgradeResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdScriptUpgradeResult cmdScriptUpgradeResult = new CmdScriptUpgradeResult(true);
            defaultInstance = cmdScriptUpgradeResult;
            cmdScriptUpgradeResult.initFields();
        }

        private CmdScriptUpgradeResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdScriptUpgradeResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdScriptUpgradeResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdScriptUpgradeResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.w;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdScriptUpgradeResult cmdScriptUpgradeResult) {
            return newBuilder().mergeFrom(cmdScriptUpgradeResult);
        }

        public static CmdScriptUpgradeResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdScriptUpgradeResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgradeResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdScriptUpgradeResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdScriptUpgradeResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdScriptUpgradeResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgradeResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdScriptUpgradeResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdScriptUpgradeResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdScriptUpgradeResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdScriptUpgradeResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdScriptUpgradeResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.x.ensureFieldAccessorsInitialized(CmdScriptUpgradeResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdScriptUpgradeResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class CmdUnBindStudioProject extends GeneratedMessage implements CmdUnBindStudioProjectOrBuilder {
        public static Parser<CmdUnBindStudioProject> PARSER = new AbstractParser<CmdUnBindStudioProject>() {
            public final CmdUnBindStudioProject parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdUnBindStudioProject(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdUnBindStudioProject defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdUnBindStudioProjectOrBuilder {
            private int bitField0_;
            private long rpcId_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.G;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdUnBindStudioProject.alwaysUseFieldBuilders;
            }

            public final CmdUnBindStudioProject build() {
                CmdUnBindStudioProject buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdUnBindStudioProject buildPartial() {
                CmdUnBindStudioProject cmdUnBindStudioProject = new CmdUnBindStudioProject((GeneratedMessage.Builder) this);
                int i = 1;
                if ((this.bitField0_ & 1) != 1) {
                    i = 0;
                }
                long unused = cmdUnBindStudioProject.rpcId_ = this.rpcId_;
                int unused2 = cmdUnBindStudioProject.bitField0_ = i;
                onBuilt();
                return cmdUnBindStudioProject;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdUnBindStudioProject getDefaultInstanceForType() {
                return CmdUnBindStudioProject.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.G;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.H.ensureFieldAccessorsInitialized(CmdUnBindStudioProject.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdUnBindStudioProject cmdUnBindStudioProject;
                CmdUnBindStudioProject cmdUnBindStudioProject2 = null;
                try {
                    CmdUnBindStudioProject parsePartialFrom = CmdUnBindStudioProject.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdUnBindStudioProject = (CmdUnBindStudioProject) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdUnBindStudioProject2 = cmdUnBindStudioProject;
                }
                if (cmdUnBindStudioProject2 != null) {
                    mergeFrom(cmdUnBindStudioProject2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdUnBindStudioProject) {
                    return mergeFrom((CmdUnBindStudioProject) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdUnBindStudioProject cmdUnBindStudioProject) {
                if (cmdUnBindStudioProject == CmdUnBindStudioProject.getDefaultInstance()) {
                    return this;
                }
                if (cmdUnBindStudioProject.hasRpcId()) {
                    setRpcId(cmdUnBindStudioProject.getRpcId());
                }
                mergeUnknownFields(cmdUnBindStudioProject.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdUnBindStudioProject cmdUnBindStudioProject = new CmdUnBindStudioProject(true);
            defaultInstance = cmdUnBindStudioProject;
            cmdUnBindStudioProject.initFields();
        }

        private CmdUnBindStudioProject(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private CmdUnBindStudioProject(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdUnBindStudioProject(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdUnBindStudioProject getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.G;
        }

        private void initFields() {
            this.rpcId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdUnBindStudioProject cmdUnBindStudioProject) {
            return newBuilder().mergeFrom(cmdUnBindStudioProject);
        }

        public static CmdUnBindStudioProject parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdUnBindStudioProject parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProject parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdUnBindStudioProject parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdUnBindStudioProject parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdUnBindStudioProject parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProject parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdUnBindStudioProject parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProject parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdUnBindStudioProject parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdUnBindStudioProject getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<CmdUnBindStudioProject> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.H.ensureFieldAccessorsInitialized(CmdUnBindStudioProject.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdUnBindStudioProjectOrBuilder extends MessageOrBuilder {
        long getRpcId();

        boolean hasRpcId();
    }

    public static final class CmdUnBindStudioProjectResult extends GeneratedMessage implements CmdUnBindStudioProjectResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<CmdUnBindStudioProjectResult> PARSER = new AbstractParser<CmdUnBindStudioProjectResult>() {
            public final CmdUnBindStudioProjectResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CmdUnBindStudioProjectResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final CmdUnBindStudioProjectResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CmdUnBindStudioProjectResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.I;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CmdUnBindStudioProjectResult.alwaysUseFieldBuilders;
            }

            public final CmdUnBindStudioProjectResult build() {
                CmdUnBindStudioProjectResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final CmdUnBindStudioProjectResult buildPartial() {
                CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult = new CmdUnBindStudioProjectResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = cmdUnBindStudioProjectResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = cmdUnBindStudioProjectResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = cmdUnBindStudioProjectResult.message_ = this.message_;
                int unused4 = cmdUnBindStudioProjectResult.bitField0_ = i2;
                onBuilt();
                return cmdUnBindStudioProjectResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = CmdUnBindStudioProjectResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final CmdUnBindStudioProjectResult getDefaultInstanceForType() {
                return CmdUnBindStudioProjectResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.I;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.J.ensureFieldAccessorsInitialized(CmdUnBindStudioProjectResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult;
                CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult2 = null;
                try {
                    CmdUnBindStudioProjectResult parsePartialFrom = CmdUnBindStudioProjectResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    cmdUnBindStudioProjectResult = (CmdUnBindStudioProjectResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    cmdUnBindStudioProjectResult2 = cmdUnBindStudioProjectResult;
                }
                if (cmdUnBindStudioProjectResult2 != null) {
                    mergeFrom(cmdUnBindStudioProjectResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof CmdUnBindStudioProjectResult) {
                    return mergeFrom((CmdUnBindStudioProjectResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult) {
                if (cmdUnBindStudioProjectResult == CmdUnBindStudioProjectResult.getDefaultInstance()) {
                    return this;
                }
                if (cmdUnBindStudioProjectResult.hasRpcId()) {
                    setRpcId(cmdUnBindStudioProjectResult.getRpcId());
                }
                if (cmdUnBindStudioProjectResult.hasError()) {
                    setError(cmdUnBindStudioProjectResult.getError());
                }
                if (cmdUnBindStudioProjectResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = cmdUnBindStudioProjectResult.message_;
                    onChanged();
                }
                mergeUnknownFields(cmdUnBindStudioProjectResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult = new CmdUnBindStudioProjectResult(true);
            defaultInstance = cmdUnBindStudioProjectResult;
            cmdUnBindStudioProjectResult.initFields();
        }

        private CmdUnBindStudioProjectResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private CmdUnBindStudioProjectResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private CmdUnBindStudioProjectResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static CmdUnBindStudioProjectResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.I;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(CmdUnBindStudioProjectResult cmdUnBindStudioProjectResult) {
            return newBuilder().mergeFrom(cmdUnBindStudioProjectResult);
        }

        public static CmdUnBindStudioProjectResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static CmdUnBindStudioProjectResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProjectResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CmdUnBindStudioProjectResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CmdUnBindStudioProjectResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static CmdUnBindStudioProjectResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProjectResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static CmdUnBindStudioProjectResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static CmdUnBindStudioProjectResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CmdUnBindStudioProjectResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final CmdUnBindStudioProjectResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<CmdUnBindStudioProjectResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.J.ensureFieldAccessorsInitialized(CmdUnBindStudioProjectResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface CmdUnBindStudioProjectResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class Heartbeat extends GeneratedMessage implements HeartbeatOrBuilder {
        public static Parser<Heartbeat> PARSER = new AbstractParser<Heartbeat>() {
            public final Heartbeat parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Heartbeat(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        public static final int SCRIPTRUNNING_FIELD_NUMBER = 1;
        private static final Heartbeat defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        /* access modifiers changed from: private */
        public boolean scriptRunning_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements HeartbeatOrBuilder {
            private int bitField0_;
            private long rpcId_;
            private boolean scriptRunning_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.e;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Heartbeat.alwaysUseFieldBuilders;
            }

            public final Heartbeat build() {
                Heartbeat buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final Heartbeat buildPartial() {
                Heartbeat heartbeat = new Heartbeat((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = heartbeat.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                boolean unused2 = heartbeat.scriptRunning_ = this.scriptRunning_;
                int unused3 = heartbeat.bitField0_ = i2;
                onBuilt();
                return heartbeat;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.scriptRunning_ = false;
                this.bitField0_ &= -3;
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearScriptRunning() {
                this.bitField0_ &= -3;
                this.scriptRunning_ = false;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final Heartbeat getDefaultInstanceForType() {
                return Heartbeat.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.e;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean getScriptRunning() {
                return this.scriptRunning_;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasScriptRunning() {
                return (this.bitField0_ & 2) == 2;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.f.ensureFieldAccessorsInitialized(Heartbeat.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasScriptRunning();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Heartbeat heartbeat;
                Heartbeat heartbeat2 = null;
                try {
                    Heartbeat parsePartialFrom = Heartbeat.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    heartbeat = (Heartbeat) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    heartbeat2 = heartbeat;
                }
                if (heartbeat2 != null) {
                    mergeFrom(heartbeat2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof Heartbeat) {
                    return mergeFrom((Heartbeat) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(Heartbeat heartbeat) {
                if (heartbeat == Heartbeat.getDefaultInstance()) {
                    return this;
                }
                if (heartbeat.hasRpcId()) {
                    setRpcId(heartbeat.getRpcId());
                }
                if (heartbeat.hasScriptRunning()) {
                    setScriptRunning(heartbeat.getScriptRunning());
                }
                mergeUnknownFields(heartbeat.getUnknownFields());
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }

            public final Builder setScriptRunning(boolean z) {
                this.bitField0_ |= 2;
                this.scriptRunning_ = z;
                onChanged();
                return this;
            }
        }

        static {
            Heartbeat heartbeat = new Heartbeat(true);
            defaultInstance = heartbeat;
            heartbeat.initFields();
        }

        private Heartbeat(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 2;
                            this.scriptRunning_ = codedInputStream.readBool();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private Heartbeat(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Heartbeat(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Heartbeat getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.e;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.scriptRunning_ = false;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Heartbeat heartbeat) {
            return newBuilder().mergeFrom(heartbeat);
        }

        public static Heartbeat parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Heartbeat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Heartbeat parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Heartbeat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Heartbeat parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Heartbeat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Heartbeat parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Heartbeat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Heartbeat parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Heartbeat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final Heartbeat getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<Heartbeat> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final boolean getScriptRunning() {
            return this.scriptRunning_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 = 0 + CodedOutputStream.computeBoolSize(1, this.scriptRunning_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasScriptRunning() {
            return (this.bitField0_ & 2) == 2;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.f.ensureFieldAccessorsInitialized(Heartbeat.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptRunning()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeBool(1, this.scriptRunning_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface HeartbeatOrBuilder extends MessageOrBuilder {
        long getRpcId();

        boolean getScriptRunning();

        boolean hasRpcId();

        boolean hasScriptRunning();
    }

    public static final class HeartbeatResult extends GeneratedMessage implements HeartbeatResultOrBuilder {
        public static final int DISABLED_FIELD_NUMBER = 1;
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<HeartbeatResult> PARSER = new AbstractParser<HeartbeatResult>() {
            public final HeartbeatResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new HeartbeatResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final HeartbeatResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public boolean disabled_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements HeartbeatResultOrBuilder {
            private int bitField0_;
            private boolean disabled_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.g;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = HeartbeatResult.alwaysUseFieldBuilders;
            }

            public final HeartbeatResult build() {
                HeartbeatResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final HeartbeatResult buildPartial() {
                HeartbeatResult heartbeatResult = new HeartbeatResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = heartbeatResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = heartbeatResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = heartbeatResult.message_ = this.message_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                boolean unused4 = heartbeatResult.disabled_ = this.disabled_;
                int unused5 = heartbeatResult.bitField0_ = i2;
                onBuilt();
                return heartbeatResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                this.disabled_ = false;
                this.bitField0_ &= -9;
                return this;
            }

            public final Builder clearDisabled() {
                this.bitField0_ &= -9;
                this.disabled_ = false;
                onChanged();
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = HeartbeatResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final HeartbeatResult getDefaultInstanceForType() {
                return HeartbeatResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.g;
            }

            public final boolean getDisabled() {
                return this.disabled_;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasDisabled() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.h.ensureFieldAccessorsInitialized(HeartbeatResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError() && hasDisabled();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                HeartbeatResult heartbeatResult;
                HeartbeatResult heartbeatResult2 = null;
                try {
                    HeartbeatResult parsePartialFrom = HeartbeatResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    heartbeatResult = (HeartbeatResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    heartbeatResult2 = heartbeatResult;
                }
                if (heartbeatResult2 != null) {
                    mergeFrom(heartbeatResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof HeartbeatResult) {
                    return mergeFrom((HeartbeatResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(HeartbeatResult heartbeatResult) {
                if (heartbeatResult == HeartbeatResult.getDefaultInstance()) {
                    return this;
                }
                if (heartbeatResult.hasRpcId()) {
                    setRpcId(heartbeatResult.getRpcId());
                }
                if (heartbeatResult.hasError()) {
                    setError(heartbeatResult.getError());
                }
                if (heartbeatResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = heartbeatResult.message_;
                    onChanged();
                }
                if (heartbeatResult.hasDisabled()) {
                    setDisabled(heartbeatResult.getDisabled());
                }
                mergeUnknownFields(heartbeatResult.getUnknownFields());
                return this;
            }

            public final Builder setDisabled(boolean z) {
                this.bitField0_ |= 8;
                this.disabled_ = z;
                onChanged();
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            HeartbeatResult heartbeatResult = new HeartbeatResult(true);
            defaultInstance = heartbeatResult;
            heartbeatResult.initFields();
        }

        private HeartbeatResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 8;
                            this.disabled_ = codedInputStream.readBool();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private HeartbeatResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private HeartbeatResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static HeartbeatResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.g;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
            this.disabled_ = false;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(HeartbeatResult heartbeatResult) {
            return newBuilder().mergeFrom(heartbeatResult);
        }

        public static HeartbeatResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static HeartbeatResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static HeartbeatResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static HeartbeatResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static HeartbeatResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static HeartbeatResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static HeartbeatResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static HeartbeatResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static HeartbeatResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static HeartbeatResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final HeartbeatResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final boolean getDisabled() {
            return this.disabled_;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<HeartbeatResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 8) == 8) {
                i2 = 0 + CodedOutputStream.computeBoolSize(1, this.disabled_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasDisabled() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.h.ensureFieldAccessorsInitialized(HeartbeatResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasDisabled()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBool(1, this.disabled_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface HeartbeatResultOrBuilder extends MessageOrBuilder {
        boolean getDisabled();

        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasDisabled();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class Login extends GeneratedMessage implements LoginOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        public static final int DEVICEID_FIELD_NUMBER = 3;
        public static final int IMTOKEN_FIELD_NUMBER = 4;
        public static Parser<Login> PARSER = new AbstractParser<Login>() {
            public final Login parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Login(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        public static final int SCRIPTID_FIELD_NUMBER = 2;
        public static final int SCRIPTRUNNING_FIELD_NUMBER = 5;
        private static final Login defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public long appId_;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public Object deviceId_;
        /* access modifiers changed from: private */
        public Object iMToken_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public long rpcId_;
        /* access modifiers changed from: private */
        public Object scriptId_;
        /* access modifiers changed from: private */
        public boolean scriptRunning_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LoginOrBuilder {
            private long appId_;
            private int bitField0_;
            private Object deviceId_;
            private Object iMToken_;
            private long rpcId_;
            private Object scriptId_;
            private boolean scriptRunning_;

            private Builder() {
                this.scriptId_ = "";
                this.deviceId_ = "";
                this.iMToken_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.scriptId_ = "";
                this.deviceId_ = "";
                this.iMToken_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.f3456a;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Login.alwaysUseFieldBuilders;
            }

            public final Login build() {
                Login buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final Login buildPartial() {
                Login login = new Login((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = login.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                long unused2 = login.appId_ = this.appId_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = login.scriptId_ = this.scriptId_;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                Object unused4 = login.deviceId_ = this.deviceId_;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                Object unused5 = login.iMToken_ = this.iMToken_;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                boolean unused6 = login.scriptRunning_ = this.scriptRunning_;
                int unused7 = login.bitField0_ = i2;
                onBuilt();
                return login;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.appId_ = 0;
                this.bitField0_ &= -3;
                this.scriptId_ = "";
                this.bitField0_ &= -5;
                this.deviceId_ = "";
                this.bitField0_ &= -9;
                this.iMToken_ = "";
                this.bitField0_ &= -17;
                this.scriptRunning_ = false;
                this.bitField0_ &= -33;
                return this;
            }

            public final Builder clearAppId() {
                this.bitField0_ &= -3;
                this.appId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearDeviceId() {
                this.bitField0_ &= -9;
                this.deviceId_ = Login.getDefaultInstance().getDeviceId();
                onChanged();
                return this;
            }

            public final Builder clearIMToken() {
                this.bitField0_ &= -17;
                this.iMToken_ = Login.getDefaultInstance().getIMToken();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearScriptId() {
                this.bitField0_ &= -5;
                this.scriptId_ = Login.getDefaultInstance().getScriptId();
                onChanged();
                return this;
            }

            public final Builder clearScriptRunning() {
                this.bitField0_ &= -33;
                this.scriptRunning_ = false;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final long getAppId() {
                return this.appId_;
            }

            public final Login getDefaultInstanceForType() {
                return Login.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.f3456a;
            }

            public final String getDeviceId() {
                Object obj = this.deviceId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deviceId_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getDeviceIdBytes() {
                Object obj = this.deviceId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deviceId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final String getIMToken() {
                Object obj = this.iMToken_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.iMToken_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getIMTokenBytes() {
                Object obj = this.iMToken_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.iMToken_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final String getScriptId() {
                Object obj = this.scriptId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.scriptId_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getScriptIdBytes() {
                Object obj = this.scriptId_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scriptId_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final boolean getScriptRunning() {
                return this.scriptRunning_;
            }

            public final boolean hasAppId() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasDeviceId() {
                return (this.bitField0_ & 8) == 8;
            }

            public final boolean hasIMToken() {
                return (this.bitField0_ & 16) == 16;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            public final boolean hasScriptId() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasScriptRunning() {
                return (this.bitField0_ & 32) == 32;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.f3457b.ensureFieldAccessorsInitialized(Login.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasAppId() && hasScriptId() && hasDeviceId() && hasIMToken() && hasScriptRunning();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Login login;
                Login login2 = null;
                try {
                    Login parsePartialFrom = Login.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    login = (Login) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    login2 = login;
                }
                if (login2 != null) {
                    mergeFrom(login2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof Login) {
                    return mergeFrom((Login) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(Login login) {
                if (login == Login.getDefaultInstance()) {
                    return this;
                }
                if (login.hasRpcId()) {
                    setRpcId(login.getRpcId());
                }
                if (login.hasAppId()) {
                    setAppId(login.getAppId());
                }
                if (login.hasScriptId()) {
                    this.bitField0_ |= 4;
                    this.scriptId_ = login.scriptId_;
                    onChanged();
                }
                if (login.hasDeviceId()) {
                    this.bitField0_ |= 8;
                    this.deviceId_ = login.deviceId_;
                    onChanged();
                }
                if (login.hasIMToken()) {
                    this.bitField0_ |= 16;
                    this.iMToken_ = login.iMToken_;
                    onChanged();
                }
                if (login.hasScriptRunning()) {
                    setScriptRunning(login.getScriptRunning());
                }
                mergeUnknownFields(login.getUnknownFields());
                return this;
            }

            public final Builder setAppId(long j) {
                this.bitField0_ |= 2;
                this.appId_ = j;
                onChanged();
                return this;
            }

            public final Builder setDeviceId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.deviceId_ = str;
                onChanged();
                return this;
            }

            public final Builder setDeviceIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.deviceId_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setIMToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.iMToken_ = str;
                onChanged();
                return this;
            }

            public final Builder setIMTokenBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.iMToken_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }

            public final Builder setScriptId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.scriptId_ = str;
                onChanged();
                return this;
            }

            public final Builder setScriptIdBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.scriptId_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setScriptRunning(boolean z) {
                this.bitField0_ |= 32;
                this.scriptRunning_ = z;
                onChanged();
                return this;
            }
        }

        static {
            Login login = new Login(true);
            defaultInstance = login;
            login.initFields();
        }

        private Login(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.bitField0_ |= 2;
                            this.appId_ = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0_ |= 4;
                            this.scriptId_ = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            this.bitField0_ |= 8;
                            this.deviceId_ = codedInputStream.readBytes();
                        } else if (readTag == 34) {
                            this.bitField0_ |= 16;
                            this.iMToken_ = codedInputStream.readBytes();
                        } else if (readTag == 40) {
                            this.bitField0_ |= 32;
                            this.scriptRunning_ = codedInputStream.readBool();
                        } else if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
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

        private Login(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Login(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Login getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.f3456a;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.appId_ = 0;
            this.scriptId_ = "";
            this.deviceId_ = "";
            this.iMToken_ = "";
            this.scriptRunning_ = false;
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Login login) {
            return newBuilder().mergeFrom(login);
        }

        public static Login parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static Login parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static Login parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Login parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Login parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static Login parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static Login parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static Login parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static Login parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Login parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final long getAppId() {
            return this.appId_;
        }

        public final Login getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final String getDeviceId() {
            Object obj = this.deviceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.deviceId_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getDeviceIdBytes() {
            Object obj = this.deviceId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.deviceId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final String getIMToken() {
            Object obj = this.iMToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.iMToken_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getIMTokenBytes() {
            Object obj = this.iMToken_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.iMToken_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<Login> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final String getScriptId() {
            Object obj = this.scriptId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.scriptId_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getScriptIdBytes() {
            Object obj = this.scriptId_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.scriptId_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final boolean getScriptRunning() {
            return this.scriptRunning_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 2) == 2) {
                i2 = 0 + CodedOutputStream.computeInt64Size(1, this.appId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(2, getScriptIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                i2 += CodedOutputStream.computeBytesSize(3, getDeviceIdBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                i2 += CodedOutputStream.computeBytesSize(4, getIMTokenBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                i2 += CodedOutputStream.computeBoolSize(5, this.scriptRunning_);
            }
            if ((this.bitField0_ & 1) == 1) {
                i2 += CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasAppId() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasDeviceId() {
            return (this.bitField0_ & 8) == 8;
        }

        public final boolean hasIMToken() {
            return (this.bitField0_ & 16) == 16;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        public final boolean hasScriptId() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasScriptRunning() {
            return (this.bitField0_ & 32) == 32;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.f3457b.ensureFieldAccessorsInitialized(Login.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasAppId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasDeviceId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasIMToken()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasScriptRunning()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt64(1, this.appId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(2, getScriptIdBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeBytes(3, getDeviceIdBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.writeBytes(4, getIMTokenBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.writeBool(5, this.scriptRunning_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface LoginOrBuilder extends MessageOrBuilder {
        long getAppId();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getIMToken();

        ByteString getIMTokenBytes();

        long getRpcId();

        String getScriptId();

        ByteString getScriptIdBytes();

        boolean getScriptRunning();

        boolean hasAppId();

        boolean hasDeviceId();

        boolean hasIMToken();

        boolean hasRpcId();

        boolean hasScriptId();

        boolean hasScriptRunning();
    }

    public static final class LoginResult extends GeneratedMessage implements LoginResultOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 91;
        public static final int MESSAGE_FIELD_NUMBER = 92;
        public static Parser<LoginResult> PARSER = new AbstractParser<LoginResult>() {
            public final LoginResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LoginResult(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int RPCID_FIELD_NUMBER = 90;
        private static final LoginResult defaultInstance;
        private static final long serialVersionUID = 0;
        /* access modifiers changed from: private */
        public int bitField0_;
        /* access modifiers changed from: private */
        public int error_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        /* access modifiers changed from: private */
        public Object message_;
        /* access modifiers changed from: private */
        public long rpcId_;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements LoginResultOrBuilder {
            private int bitField0_;
            private int error_;
            private Object message_;
            private long rpcId_;

            private Builder() {
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                this.message_ = "";
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.f3458c;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LoginResult.alwaysUseFieldBuilders;
            }

            public final LoginResult build() {
                LoginResult buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final LoginResult buildPartial() {
                LoginResult loginResult = new LoginResult((GeneratedMessage.Builder) this);
                int i = this.bitField0_;
                int i2 = 1;
                if ((i & 1) != 1) {
                    i2 = 0;
                }
                long unused = loginResult.rpcId_ = this.rpcId_;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                int unused2 = loginResult.error_ = this.error_;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                Object unused3 = loginResult.message_ = this.message_;
                int unused4 = loginResult.bitField0_ = i2;
                onBuilt();
                return loginResult;
            }

            public final Builder clear() {
                super.clear();
                this.rpcId_ = 0;
                this.bitField0_ &= -2;
                this.error_ = 0;
                this.bitField0_ &= -3;
                this.message_ = "";
                this.bitField0_ &= -5;
                return this;
            }

            public final Builder clearError() {
                this.bitField0_ &= -3;
                this.error_ = 0;
                onChanged();
                return this;
            }

            public final Builder clearMessage() {
                this.bitField0_ &= -5;
                this.message_ = LoginResult.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public final Builder clearRpcId() {
                this.bitField0_ &= -2;
                this.rpcId_ = 0;
                onChanged();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final LoginResult getDefaultInstanceForType() {
                return LoginResult.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.f3458c;
            }

            public final int getError() {
                return this.error_;
            }

            public final String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            public final ByteString getMessageBytes() {
                Object obj = this.message_;
                if (!(obj instanceof String)) {
                    return (ByteString) obj;
                }
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }

            public final long getRpcId() {
                return this.rpcId_;
            }

            public final boolean hasError() {
                return (this.bitField0_ & 2) == 2;
            }

            public final boolean hasMessage() {
                return (this.bitField0_ & 4) == 4;
            }

            public final boolean hasRpcId() {
                return (this.bitField0_ & 1) == 1;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.d.ensureFieldAccessorsInitialized(LoginResult.class, Builder.class);
            }

            public final boolean isInitialized() {
                return hasRpcId() && hasError();
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LoginResult loginResult;
                LoginResult loginResult2 = null;
                try {
                    LoginResult parsePartialFrom = LoginResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    loginResult = (LoginResult) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    loginResult2 = loginResult;
                }
                if (loginResult2 != null) {
                    mergeFrom(loginResult2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof LoginResult) {
                    return mergeFrom((LoginResult) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(LoginResult loginResult) {
                if (loginResult == LoginResult.getDefaultInstance()) {
                    return this;
                }
                if (loginResult.hasRpcId()) {
                    setRpcId(loginResult.getRpcId());
                }
                if (loginResult.hasError()) {
                    setError(loginResult.getError());
                }
                if (loginResult.hasMessage()) {
                    this.bitField0_ |= 4;
                    this.message_ = loginResult.message_;
                    onChanged();
                }
                mergeUnknownFields(loginResult.getUnknownFields());
                return this;
            }

            public final Builder setError(int i) {
                this.bitField0_ |= 2;
                this.error_ = i;
                onChanged();
                return this;
            }

            public final Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = str;
                onChanged();
                return this;
            }

            public final Builder setMessageBytes(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.message_ = byteString;
                onChanged();
                return this;
            }

            public final Builder setRpcId(long j) {
                this.bitField0_ |= 1;
                this.rpcId_ = j;
                onChanged();
                return this;
            }
        }

        static {
            LoginResult loginResult = new LoginResult(true);
            defaultInstance = loginResult;
            loginResult.initFields();
        }

        private LoginResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 720) {
                            this.bitField0_ |= 1;
                            this.rpcId_ = codedInputStream.readInt64();
                        } else if (readTag == 728) {
                            this.bitField0_ |= 2;
                            this.error_ = codedInputStream.readInt32();
                        } else if (readTag == 738) {
                            this.bitField0_ |= 4;
                            this.message_ = codedInputStream.readBytes();
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

        private LoginResult(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private LoginResult(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LoginResult getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.f3458c;
        }

        private void initFields() {
            this.rpcId_ = 0;
            this.error_ = 0;
            this.message_ = "";
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(LoginResult loginResult) {
            return newBuilder().mergeFrom(loginResult);
        }

        public static LoginResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LoginResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static LoginResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LoginResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LoginResult parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LoginResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static LoginResult parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LoginResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LoginResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LoginResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final LoginResult getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final int getError() {
            return this.error_;
        }

        public final String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.message_ = stringUtf8;
            }
            return stringUtf8;
        }

        public final ByteString getMessageBytes() {
            Object obj = this.message_;
            if (!(obj instanceof String)) {
                return (ByteString) obj;
            }
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.message_ = copyFromUtf8;
            return copyFromUtf8;
        }

        public final Parser<LoginResult> getParserForType() {
            return PARSER;
        }

        public final long getRpcId() {
            return this.rpcId_;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.bitField0_ & 1) == 1) {
                i2 = 0 + CodedOutputStream.computeInt64Size(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i2 += CodedOutputStream.computeInt32Size(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i2 += CodedOutputStream.computeBytesSize(92, getMessageBytes());
            }
            int serializedSize = i2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public final boolean hasError() {
            return (this.bitField0_ & 2) == 2;
        }

        public final boolean hasMessage() {
            return (this.bitField0_ & 4) == 4;
        }

        public final boolean hasRpcId() {
            return (this.bitField0_ & 1) == 1;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.d.ensureFieldAccessorsInitialized(LoginResult.class, Builder.class);
        }

        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 != -1) {
                return b2 == 1;
            }
            if (!hasRpcId()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else if (!hasError()) {
                this.memoizedIsInitialized = 0;
                return false;
            } else {
                this.memoizedIsInitialized = 1;
                return true;
            }
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
                codedOutputStream.writeInt64(90, this.rpcId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(91, this.error_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeBytes(92, getMessageBytes());
            }
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface LoginResultOrBuilder extends MessageOrBuilder {
        int getError();

        String getMessage();

        ByteString getMessageBytes();

        long getRpcId();

        boolean hasError();

        boolean hasMessage();

        boolean hasRpcId();
    }

    public static final class ScriptStart extends GeneratedMessage implements ScriptStartOrBuilder {
        public static Parser<ScriptStart> PARSER = new AbstractParser<ScriptStart>() {
            public final ScriptStart parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ScriptStart(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ScriptStart defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ScriptStartOrBuilder {
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.i;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ScriptStart.alwaysUseFieldBuilders;
            }

            public final ScriptStart build() {
                ScriptStart buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final ScriptStart buildPartial() {
                ScriptStart scriptStart = new ScriptStart((GeneratedMessage.Builder) this);
                onBuilt();
                return scriptStart;
            }

            public final Builder clear() {
                super.clear();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final ScriptStart getDefaultInstanceForType() {
                return ScriptStart.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.i;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.j.ensureFieldAccessorsInitialized(ScriptStart.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ScriptStart scriptStart;
                ScriptStart scriptStart2 = null;
                try {
                    ScriptStart parsePartialFrom = ScriptStart.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    scriptStart = (ScriptStart) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    scriptStart2 = scriptStart;
                }
                if (scriptStart2 != null) {
                    mergeFrom(scriptStart2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof ScriptStart) {
                    return mergeFrom((ScriptStart) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(ScriptStart scriptStart) {
                if (scriptStart == ScriptStart.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(scriptStart.getUnknownFields());
                return this;
            }
        }

        static {
            ScriptStart scriptStart = new ScriptStart(true);
            defaultInstance = scriptStart;
            scriptStart.initFields();
        }

        private ScriptStart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag == 0 || !parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        z = true;
                    }
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

        private ScriptStart(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ScriptStart(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ScriptStart getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.i;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ScriptStart scriptStart) {
            return newBuilder().mergeFrom(scriptStart);
        }

        public static ScriptStart parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ScriptStart parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ScriptStart parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ScriptStart parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ScriptStart parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ScriptStart parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ScriptStart parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ScriptStart parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ScriptStart parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ScriptStart parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final ScriptStart getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<ScriptStart> getParserForType() {
            return PARSER;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int serializedSize = getUnknownFields().getSerializedSize() + 0;
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.j.ensureFieldAccessorsInitialized(ScriptStart.class, Builder.class);
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
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface ScriptStartOrBuilder extends MessageOrBuilder {
    }

    public static final class ScriptStop extends GeneratedMessage implements ScriptStopOrBuilder {
        public static Parser<ScriptStop> PARSER = new AbstractParser<ScriptStop>() {
            public final ScriptStop parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ScriptStop(codedInputStream, extensionRegistryLite);
            }
        };
        private static final ScriptStop defaultInstance;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final UnknownFieldSet unknownFields;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ScriptStopOrBuilder {
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            /* access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MessageProtobuf.k;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ScriptStop.alwaysUseFieldBuilders;
            }

            public final ScriptStop build() {
                ScriptStop buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException(buildPartial);
            }

            public final ScriptStop buildPartial() {
                ScriptStop scriptStop = new ScriptStop((GeneratedMessage.Builder) this);
                onBuilt();
                return scriptStop;
            }

            public final Builder clear() {
                super.clear();
                return this;
            }

            public final Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public final ScriptStop getDefaultInstanceForType() {
                return ScriptStop.getDefaultInstance();
            }

            public final Descriptors.Descriptor getDescriptorForType() {
                return MessageProtobuf.k;
            }

            /* access modifiers changed from: protected */
            public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return MessageProtobuf.l.ensureFieldAccessorsInitialized(ScriptStop.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public final Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ScriptStop scriptStop;
                ScriptStop scriptStop2 = null;
                try {
                    ScriptStop parsePartialFrom = ScriptStop.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    scriptStop = (ScriptStop) e.getUnfinishedMessage();
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    scriptStop2 = scriptStop;
                }
                if (scriptStop2 != null) {
                    mergeFrom(scriptStop2);
                }
                throw th;
            }

            public final Builder mergeFrom(Message message) {
                if (message instanceof ScriptStop) {
                    return mergeFrom((ScriptStop) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public final Builder mergeFrom(ScriptStop scriptStop) {
                if (scriptStop == ScriptStop.getDefaultInstance()) {
                    return this;
                }
                mergeUnknownFields(scriptStop.getUnknownFields());
                return this;
            }
        }

        static {
            ScriptStop scriptStop = new ScriptStop(true);
            defaultInstance = scriptStop;
            scriptStop.initFields();
        }

        private ScriptStop(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag == 0 || !parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        z = true;
                    }
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

        private ScriptStop(GeneratedMessage.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private ScriptStop(boolean z) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ScriptStop getDefaultInstance() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MessageProtobuf.k;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ScriptStop scriptStop) {
            return newBuilder().mergeFrom(scriptStop);
        }

        public static ScriptStop parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static ScriptStop parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static ScriptStop parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ScriptStop parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ScriptStop parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static ScriptStop parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static ScriptStop parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static ScriptStop parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static ScriptStop parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ScriptStop parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public final ScriptStop getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final Parser<ScriptStop> getParserForType() {
            return PARSER;
        }

        public final int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int serializedSize = getUnknownFields().getSerializedSize() + 0;
            this.memoizedSerializedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* access modifiers changed from: protected */
        public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return MessageProtobuf.l.ensureFieldAccessorsInitialized(ScriptStop.class, Builder.class);
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
            getUnknownFields().writeTo(codedOutputStream);
        }
    }

    public interface ScriptStopOrBuilder extends MessageOrBuilder {
    }

    static {
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015MessageProtobuf.proto\u0012\u001bcom.hlzn.socketclient.pbmsg\"q\n\u0005Login\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005AppId\u0018\u0001 \u0002(\u0003\u0012\u0010\n\bScriptId\u0018\u0002 \u0002(\t\u0012\u0010\n\bDeviceId\u0018\u0003 \u0002(\t\u0012\u000f\n\u0007IMToken\u0018\u0004 \u0002(\t\u0012\u0015\n\rScriptRunning\u0018\u0005 \u0002(\b\"<\n\u000bLoginResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\"1\n\tHeartbeat\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\u0015\n\rScriptRunning\u0018\u0001 \u0002(\b\"R\n\u000fHeartbeatResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\u0012\u0010\n\bDisabled\u0018\u0001 \u0002(\b\"\r\n\u000bScriptStart\"\f\n\nScriptStop\"\u001f\n\u000eCmd", "ScriptStart\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\"E\n\u0014CmdScriptStartResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\"\u001e\n\rCmdScriptStop\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\"D\n\u0013CmdScriptStopResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\"O\n\u0010CmdScriptUpgrade\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\u0015\n\rScriptVersion\u0018\u0001 \u0002(\u0003\u0012\u0015\n\rScriptFileUrl\u0018\u0002 \u0002(\t\"G\n\u0016CmdScriptUpgradeResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\":\n\u0011CmdScriptSettings\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\u0016\n\u000eScriptS", "ettings\u0018\u0001 \u0002(\t\"H\n\u0017CmdScriptSettingsResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\"!\n\u0010CmdScreenCapture\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\"G\n\u0016CmdScreenCaptureResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\"'\n\u0016CmdUnBindStudioProject\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\"M\n\u001cCmdUnBindStudioProjectResult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t\";\n\u0013CmdRenameDeviceName\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\u0015\n\rNewDeviceName\u0018\u0001 \u0002(\t\"J\n\u0019CmdRenameDeviceNameR", "esult\u0012\r\n\u0005RpcId\u0018Z \u0002(\u0003\u0012\r\n\u0005Error\u0018[ \u0002(\u0005\u0012\u000f\n\u0007Message\u0018\\ \u0001(\t"}, new Descriptors.FileDescriptor[0], new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public final ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor fileDescriptor) {
                Descriptors.FileDescriptor unused = MessageProtobuf.O = fileDescriptor;
                Descriptors.Descriptor unused2 = MessageProtobuf.f3456a = MessageProtobuf.a().getMessageTypes().get(0);
                GeneratedMessage.FieldAccessorTable unused3 = MessageProtobuf.f3457b = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.f3456a, new String[]{"RpcId", "AppId", "ScriptId", "DeviceId", "IMToken", "ScriptRunning"});
                Descriptors.Descriptor unused4 = MessageProtobuf.f3458c = MessageProtobuf.a().getMessageTypes().get(1);
                GeneratedMessage.FieldAccessorTable unused5 = MessageProtobuf.d = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.f3458c, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused6 = MessageProtobuf.e = MessageProtobuf.a().getMessageTypes().get(2);
                GeneratedMessage.FieldAccessorTable unused7 = MessageProtobuf.f = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.e, new String[]{"RpcId", "ScriptRunning"});
                Descriptors.Descriptor unused8 = MessageProtobuf.g = MessageProtobuf.a().getMessageTypes().get(3);
                GeneratedMessage.FieldAccessorTable unused9 = MessageProtobuf.h = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.g, new String[]{"RpcId", "Error", b.d, "Disabled"});
                Descriptors.Descriptor unused10 = MessageProtobuf.i = MessageProtobuf.a().getMessageTypes().get(4);
                GeneratedMessage.FieldAccessorTable unused11 = MessageProtobuf.j = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.i, new String[0]);
                Descriptors.Descriptor unused12 = MessageProtobuf.k = MessageProtobuf.a().getMessageTypes().get(5);
                GeneratedMessage.FieldAccessorTable unused13 = MessageProtobuf.l = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.k, new String[0]);
                Descriptors.Descriptor unused14 = MessageProtobuf.m = MessageProtobuf.a().getMessageTypes().get(6);
                GeneratedMessage.FieldAccessorTable unused15 = MessageProtobuf.n = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.m, new String[]{"RpcId"});
                Descriptors.Descriptor unused16 = MessageProtobuf.o = MessageProtobuf.a().getMessageTypes().get(7);
                GeneratedMessage.FieldAccessorTable unused17 = MessageProtobuf.p = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.o, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused18 = MessageProtobuf.q = MessageProtobuf.a().getMessageTypes().get(8);
                GeneratedMessage.FieldAccessorTable unused19 = MessageProtobuf.r = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.q, new String[]{"RpcId"});
                Descriptors.Descriptor unused20 = MessageProtobuf.s = MessageProtobuf.a().getMessageTypes().get(9);
                GeneratedMessage.FieldAccessorTable unused21 = MessageProtobuf.t = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.s, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused22 = MessageProtobuf.u = MessageProtobuf.a().getMessageTypes().get(10);
                GeneratedMessage.FieldAccessorTable unused23 = MessageProtobuf.v = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.u, new String[]{"RpcId", "ScriptVersion", "ScriptFileUrl"});
                Descriptors.Descriptor unused24 = MessageProtobuf.w = MessageProtobuf.a().getMessageTypes().get(11);
                GeneratedMessage.FieldAccessorTable unused25 = MessageProtobuf.x = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.w, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused26 = MessageProtobuf.y = MessageProtobuf.a().getMessageTypes().get(12);
                GeneratedMessage.FieldAccessorTable unused27 = MessageProtobuf.z = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.y, new String[]{"RpcId", "ScriptSettings"});
                Descriptors.Descriptor unused28 = MessageProtobuf.A = MessageProtobuf.a().getMessageTypes().get(13);
                GeneratedMessage.FieldAccessorTable unused29 = MessageProtobuf.B = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.A, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused30 = MessageProtobuf.C = MessageProtobuf.a().getMessageTypes().get(14);
                GeneratedMessage.FieldAccessorTable unused31 = MessageProtobuf.D = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.C, new String[]{"RpcId"});
                Descriptors.Descriptor unused32 = MessageProtobuf.E = MessageProtobuf.a().getMessageTypes().get(15);
                GeneratedMessage.FieldAccessorTable unused33 = MessageProtobuf.F = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.E, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused34 = MessageProtobuf.G = MessageProtobuf.a().getMessageTypes().get(16);
                GeneratedMessage.FieldAccessorTable unused35 = MessageProtobuf.H = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.G, new String[]{"RpcId"});
                Descriptors.Descriptor unused36 = MessageProtobuf.I = MessageProtobuf.a().getMessageTypes().get(17);
                GeneratedMessage.FieldAccessorTable unused37 = MessageProtobuf.J = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.I, new String[]{"RpcId", "Error", b.d});
                Descriptors.Descriptor unused38 = MessageProtobuf.K = MessageProtobuf.a().getMessageTypes().get(18);
                GeneratedMessage.FieldAccessorTable unused39 = MessageProtobuf.L = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.K, new String[]{"RpcId", "NewDeviceName"});
                Descriptors.Descriptor unused40 = MessageProtobuf.M = MessageProtobuf.a().getMessageTypes().get(19);
                GeneratedMessage.FieldAccessorTable unused41 = MessageProtobuf.N = new GeneratedMessage.FieldAccessorTable(MessageProtobuf.M, new String[]{"RpcId", "Error", b.d});
                return null;
            }
        });
    }

    private MessageProtobuf() {
    }

    private static void P() {
    }

    public static Descriptors.FileDescriptor a() {
        return O;
    }
}
