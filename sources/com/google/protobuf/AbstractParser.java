package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    private MessageType checkMessageInitialized(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw newUninitializedMessageException(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType messagetype) {
        return messagetype instanceof AbstractMessageLite ? ((AbstractMessageLite) messagetype).newUninitializedMessageException() : new UninitializedMessageException((MessageLite) messagetype);
    }

    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
    }

    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parseFrom(byteString, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(byteString, extensionRegistryLite));
    }

    public MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return parseFrom(codedInputStream, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized((MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite));
    }

    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(inputStream, extensionRegistryLite));
    }

    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parseFrom(bArr, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parseFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(bArr, i, i2, extensionRegistryLite));
    }

    public MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parseFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parsePartialFrom(byteString, EMPTY_REGISTRY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        throw new java.lang.RuntimeException("Reading from a ByteString threw an IOException (should never happen).", r2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[ExcHandler: IOException (r2v2 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageType parsePartialFrom(com.google.protobuf.ByteString r2, com.google.protobuf.ExtensionRegistryLite r3) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r1 = this;
            com.google.protobuf.CodedInputStream r2 = r2.newCodedInput()     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            java.lang.Object r3 = r1.parsePartialFrom((com.google.protobuf.CodedInputStream) r2, (com.google.protobuf.ExtensionRegistryLite) r3)     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            com.google.protobuf.MessageLite r3 = (com.google.protobuf.MessageLite) r3     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            r0 = 0
            r2.checkLastTagWas(r0)     // Catch:{ InvalidProtocolBufferException -> 0x000f, IOException -> 0x0015 }
            return r3
        L_0x000f:
            r2 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r2 = r2.setUnfinishedMessage(r3)     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            throw r2     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
        L_0x0015:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r0 = "Reading from a ByteString threw an IOException (should never happen)."
            r3.<init>(r0, r2)
            throw r3
        L_0x001e:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractParser.parsePartialFrom(com.google.protobuf.ByteString, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite");
    }

    public MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (MessageLite) parsePartialFrom(codedInputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
        MessageType messagetype = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
        try {
            newInstance.checkLastTagWas(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, i, i2, EMPTY_REGISTRY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        throw new java.lang.RuntimeException("Reading from a byte array threw an IOException (should never happen).", r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[ExcHandler: IOException (r1v2 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MessageType parsePartialFrom(byte[] r1, int r2, int r3, com.google.protobuf.ExtensionRegistryLite r4) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r0 = this;
            com.google.protobuf.CodedInputStream r1 = com.google.protobuf.CodedInputStream.newInstance(r1, r2, r3)     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            java.lang.Object r2 = r0.parsePartialFrom((com.google.protobuf.CodedInputStream) r1, (com.google.protobuf.ExtensionRegistryLite) r4)     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            com.google.protobuf.MessageLite r2 = (com.google.protobuf.MessageLite) r2     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            r3 = 0
            r1.checkLastTagWas(r3)     // Catch:{ InvalidProtocolBufferException -> 0x000f, IOException -> 0x0015 }
            return r2
        L_0x000f:
            r1 = move-exception
            com.google.protobuf.InvalidProtocolBufferException r1 = r1.setUnfinishedMessage(r2)     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
            throw r1     // Catch:{ InvalidProtocolBufferException -> 0x001e, IOException -> 0x0015 }
        L_0x0015:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Reading from a byte array threw an IOException (should never happen)."
            r2.<init>(r3, r1)
            throw r2
        L_0x001e:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractParser.parsePartialFrom(byte[], int, int, com.google.protobuf.ExtensionRegistryLite):com.google.protobuf.MessageLite");
    }

    public MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite);
    }
}
