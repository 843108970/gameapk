package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FilenameUtils;

public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    private int memoizedSize = -1;

    public static abstract class Builder<BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> implements Message.Builder {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(38:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|(2:38|39)|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0061 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type() {
            /*
                int[] r0 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type
                if (r0 == 0) goto L_0x0005
                return r0
            L_0x0005:
                com.google.protobuf.Descriptors$FieldDescriptor$Type[] r0 = com.google.protobuf.Descriptors.FieldDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BOOL     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES     // Catch:{ NoSuchFieldError -> 0x0020 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0020 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0020 }
            L_0x0020:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.ENUM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED32     // Catch:{ NoSuchFieldError -> 0x003c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FIXED64     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT32     // Catch:{ NoSuchFieldError -> 0x0061 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0061 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0061 }
            L_0x0061:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.INT64     // Catch:{ NoSuchFieldError -> 0x006a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED32     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT32     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.SINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT32     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                com.google.protobuf.Descriptors$FieldDescriptor$Type r1 = com.google.protobuf.Descriptors.FieldDescriptor.Type.UINT64     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractMessage.Builder.$SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type():int[]");
        }

        private static void addRepeatedField(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (builder != null) {
                builder.addRepeatedField(fieldDescriptor, obj);
            } else {
                fieldSet.addRepeatedField(fieldDescriptor, obj);
            }
        }

        private static void eagerlyMergeMessageSetExtension(CodedInputStream codedInputStream, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
            Message message;
            Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
            if (hasOriginalMessage(builder, fieldSet, fieldDescriptor)) {
                Message.Builder builder2 = getOriginalMessage(builder, fieldSet, fieldDescriptor).toBuilder();
                codedInputStream.readMessage((MessageLite.Builder) builder2, extensionRegistryLite);
                message = builder2.buildPartial();
            } else {
                message = (Message) codedInputStream.readMessage(extensionInfo.defaultInstance.getParserForType(), extensionRegistryLite);
            }
            if (builder != null) {
                builder.setField(fieldDescriptor, message);
            } else {
                fieldSet.setField(fieldDescriptor, message);
            }
        }

        /* access modifiers changed from: private */
        public static List<String> findMissingFields(MessageOrBuilder messageOrBuilder) {
            ArrayList arrayList = new ArrayList();
            findMissingFields(messageOrBuilder, "", arrayList);
            return arrayList;
        }

        private static void findMissingFields(MessageOrBuilder messageOrBuilder, String str, List<String> list) {
            for (Descriptors.FieldDescriptor next : messageOrBuilder.getDescriptorForType().getFields()) {
                if (next.isRequired() && !messageOrBuilder.hasField(next)) {
                    list.add(String.valueOf(str) + next.getName());
                }
            }
            for (Map.Entry next2 : messageOrBuilder.getAllFields().entrySet()) {
                Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next2.getKey();
                Object value = next2.getValue();
                if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (fieldDescriptor.isRepeated()) {
                        int i = 0;
                        for (MessageOrBuilder findMissingFields : (List) value) {
                            findMissingFields(findMissingFields, subMessagePrefix(str, fieldDescriptor, i), list);
                            i++;
                        }
                    } else if (messageOrBuilder.hasField(fieldDescriptor)) {
                        findMissingFields((MessageOrBuilder) value, subMessagePrefix(str, fieldDescriptor, -1), list);
                    }
                }
            }
        }

        private static Message getOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor fieldDescriptor) {
            return (Message) (builder != null ? builder.getField(fieldDescriptor) : fieldSet.getField(fieldDescriptor));
        }

        private static boolean hasOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor fieldDescriptor) {
            return builder != null ? builder.hasField(fieldDescriptor) : fieldSet.hasField(fieldDescriptor);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static boolean mergeFieldFrom(com.google.protobuf.CodedInputStream r7, com.google.protobuf.UnknownFieldSet.Builder r8, com.google.protobuf.ExtensionRegistryLite r9, com.google.protobuf.Descriptors.Descriptor r10, com.google.protobuf.Message.Builder r11, com.google.protobuf.FieldSet<com.google.protobuf.Descriptors.FieldDescriptor> r12, int r13) throws java.io.IOException {
            /*
                com.google.protobuf.DescriptorProtos$MessageOptions r0 = r10.getOptions()
                boolean r0 = r0.getMessageSetWireFormat()
                r1 = 1
                if (r0 == 0) goto L_0x0013
                int r0 = com.google.protobuf.WireFormat.MESSAGE_SET_ITEM_TAG
                if (r13 != r0) goto L_0x0013
                mergeMessageSetExtensionFromCodedStream(r7, r8, r9, r10, r11, r12)
                return r1
            L_0x0013:
                int r0 = com.google.protobuf.WireFormat.getTagWireType(r13)
                int r2 = com.google.protobuf.WireFormat.getTagFieldNumber(r13)
                boolean r3 = r10.isExtensionNumber(r2)
                r4 = 0
                if (r3 == 0) goto L_0x0057
                boolean r3 = r9 instanceof com.google.protobuf.ExtensionRegistry
                if (r3 == 0) goto L_0x0055
                r3 = r9
                com.google.protobuf.ExtensionRegistry r3 = (com.google.protobuf.ExtensionRegistry) r3
                com.google.protobuf.ExtensionRegistry$ExtensionInfo r10 = r3.findExtensionByNumber(r10, r2)
                if (r10 == 0) goto L_0x0055
                com.google.protobuf.Descriptors$FieldDescriptor r4 = r10.descriptor
                com.google.protobuf.Message r10 = r10.defaultInstance
                if (r10 != 0) goto L_0x0060
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r3 = r4.getJavaType()
                com.google.protobuf.Descriptors$FieldDescriptor$JavaType r5 = com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE
                if (r3 != r5) goto L_0x0060
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r9 = "Message-typed extension lacked default instance: "
                r8.<init>(r9)
                java.lang.String r9 = r4.getFullName()
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r7.<init>(r8)
                throw r7
            L_0x0055:
                r10 = r4
                goto L_0x0060
            L_0x0057:
                if (r11 == 0) goto L_0x0055
                com.google.protobuf.Descriptors$FieldDescriptor r10 = r10.findFieldByNumber(r2)
                r6 = r4
                r4 = r10
                r10 = r6
            L_0x0060:
                r3 = 0
                if (r4 == 0) goto L_0x0081
                com.google.protobuf.WireFormat$FieldType r5 = r4.getLiteType()
                int r5 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r5, r3)
                if (r0 != r5) goto L_0x006f
                r0 = 0
                goto L_0x0083
            L_0x006f:
                boolean r5 = r4.isPackable()
                if (r5 == 0) goto L_0x0081
                com.google.protobuf.WireFormat$FieldType r5 = r4.getLiteType()
                int r5 = com.google.protobuf.FieldSet.getWireFormatForFieldType(r5, r1)
                if (r0 != r5) goto L_0x0081
                r0 = 1
                goto L_0x0083
            L_0x0081:
                r0 = 0
                r3 = 1
            L_0x0083:
                if (r3 == 0) goto L_0x008a
                boolean r7 = r8.mergeFieldFrom(r13, r7)
                return r7
            L_0x008a:
                if (r0 == 0) goto L_0x00cc
                int r8 = r7.readRawVarint32()
                int r13 = r7.pushLimit(r8)
                com.google.protobuf.WireFormat$FieldType r8 = r4.getLiteType()
                com.google.protobuf.WireFormat$FieldType r9 = com.google.protobuf.WireFormat.FieldType.ENUM
                if (r8 != r9) goto L_0x00b6
            L_0x009c:
                int r8 = r7.getBytesUntilLimit()
                if (r8 > 0) goto L_0x00a3
                goto L_0x00bc
            L_0x00a3:
                int r8 = r7.readEnum()
                com.google.protobuf.Descriptors$EnumDescriptor r9 = r4.getEnumType()
                com.google.protobuf.Descriptors$EnumValueDescriptor r8 = r9.findValueByNumber((int) r8)
                if (r8 != 0) goto L_0x00b2
                return r1
            L_0x00b2:
                addRepeatedField(r11, r12, r4, r8)
                goto L_0x009c
            L_0x00b6:
                int r8 = r7.getBytesUntilLimit()
                if (r8 > 0) goto L_0x00c0
            L_0x00bc:
                r7.popLimit(r13)
                return r1
            L_0x00c0:
                com.google.protobuf.WireFormat$FieldType r8 = r4.getLiteType()
                java.lang.Object r8 = com.google.protobuf.FieldSet.readPrimitiveField(r7, r8)
                addRepeatedField(r11, r12, r4, r8)
                goto L_0x00b6
            L_0x00cc:
                int[] r13 = $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type()
                com.google.protobuf.Descriptors$FieldDescriptor$Type r0 = r4.getType()
                int r0 = r0.ordinal()
                r13 = r13[r0]
                r0 = 14
                if (r13 == r0) goto L_0x0122
                switch(r13) {
                    case 10: goto L_0x0102;
                    case 11: goto L_0x00ea;
                    default: goto L_0x00e1;
                }
            L_0x00e1:
                com.google.protobuf.WireFormat$FieldType r8 = r4.getLiteType()
                java.lang.Object r7 = com.google.protobuf.FieldSet.readPrimitiveField(r7, r8)
                goto L_0x0135
            L_0x00ea:
                if (r10 == 0) goto L_0x00f1
                com.google.protobuf.Message$Builder r8 = r10.newBuilderForType()
                goto L_0x00f5
            L_0x00f1:
                com.google.protobuf.Message$Builder r8 = r11.newBuilderForField(r4)
            L_0x00f5:
                boolean r10 = r4.isRepeated()
                if (r10 != 0) goto L_0x00fe
                mergeOriginalMessage(r11, r12, r4, r8)
            L_0x00fe:
                r7.readMessage((com.google.protobuf.MessageLite.Builder) r8, (com.google.protobuf.ExtensionRegistryLite) r9)
                goto L_0x011d
            L_0x0102:
                if (r10 == 0) goto L_0x0109
                com.google.protobuf.Message$Builder r8 = r10.newBuilderForType()
                goto L_0x010d
            L_0x0109:
                com.google.protobuf.Message$Builder r8 = r11.newBuilderForField(r4)
            L_0x010d:
                boolean r10 = r4.isRepeated()
                if (r10 != 0) goto L_0x0116
                mergeOriginalMessage(r11, r12, r4, r8)
            L_0x0116:
                int r10 = r4.getNumber()
                r7.readGroup((int) r10, (com.google.protobuf.MessageLite.Builder) r8, (com.google.protobuf.ExtensionRegistryLite) r9)
            L_0x011d:
                com.google.protobuf.Message r7 = r8.buildPartial()
                goto L_0x0135
            L_0x0122:
                int r7 = r7.readEnum()
                com.google.protobuf.Descriptors$EnumDescriptor r9 = r4.getEnumType()
                com.google.protobuf.Descriptors$EnumValueDescriptor r9 = r9.findValueByNumber((int) r7)
                if (r9 != 0) goto L_0x0134
                r8.mergeVarintField(r2, r7)
                return r1
            L_0x0134:
                r7 = r9
            L_0x0135:
                boolean r8 = r4.isRepeated()
                if (r8 == 0) goto L_0x013f
                addRepeatedField(r11, r12, r4, r7)
                return r1
            L_0x013f:
                setField(r11, r12, r4, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractMessage.Builder.mergeFieldFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.UnknownFieldSet$Builder, com.google.protobuf.ExtensionRegistryLite, com.google.protobuf.Descriptors$Descriptor, com.google.protobuf.Message$Builder, com.google.protobuf.FieldSet, int):boolean");
        }

        private static void mergeMessageSetExtensionFromBytes(ByteString byteString, ExtensionRegistry.ExtensionInfo extensionInfo, ExtensionRegistryLite extensionRegistryLite, Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
            Message message;
            Descriptors.FieldDescriptor fieldDescriptor = extensionInfo.descriptor;
            boolean hasOriginalMessage = hasOriginalMessage(builder, fieldSet, fieldDescriptor);
            if (hasOriginalMessage || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                if (hasOriginalMessage) {
                    Message.Builder builder2 = getOriginalMessage(builder, fieldSet, fieldDescriptor).toBuilder();
                    builder2.mergeFrom(byteString, extensionRegistryLite);
                    message = builder2.buildPartial();
                } else {
                    message = (Message) extensionInfo.defaultInstance.getParserForType().parsePartialFrom(byteString, extensionRegistryLite);
                }
                setField(builder, fieldSet, fieldDescriptor, message);
                return;
            }
            LazyField lazyField = new LazyField(extensionInfo.defaultInstance, extensionRegistryLite, byteString);
            if (builder == null) {
                fieldSet.setField(fieldDescriptor, lazyField);
            } else if (builder instanceof GeneratedMessage.ExtendableBuilder) {
                builder.setField(fieldDescriptor, lazyField);
            } else {
                builder.setField(fieldDescriptor, lazyField.getValue());
            }
        }

        private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, Descriptors.Descriptor descriptor, Message.Builder builder2, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
            int i = 0;
            ByteString byteString = null;
            ExtensionRegistry.ExtensionInfo extensionInfo = null;
            while (true) {
                int readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                } else if (readTag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    i = codedInputStream.readUInt32();
                    if (i != 0 && (extensionRegistryLite instanceof ExtensionRegistry)) {
                        extensionInfo = ((ExtensionRegistry) extensionRegistryLite).findExtensionByNumber(descriptor, i);
                    }
                } else if (readTag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (i == 0 || extensionInfo == null || !ExtensionRegistryLite.isEagerlyParseMessageSets()) {
                        byteString = codedInputStream.readBytes();
                    } else {
                        eagerlyMergeMessageSetExtension(codedInputStream, extensionInfo, extensionRegistryLite, builder2, fieldSet);
                        byteString = null;
                    }
                } else if (!codedInputStream.skipField(readTag)) {
                    break;
                }
            }
            codedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (byteString != null && i != 0) {
                if (extensionInfo != null) {
                    mergeMessageSetExtensionFromBytes(byteString, extensionInfo, extensionRegistryLite, builder2, fieldSet);
                } else {
                    builder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build());
                }
            }
        }

        private static void mergeOriginalMessage(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor fieldDescriptor, Message.Builder builder2) {
            Message originalMessage = getOriginalMessage(builder, fieldSet, fieldDescriptor);
            if (originalMessage != null) {
                builder2.mergeFrom(originalMessage);
            }
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message) {
            return new UninitializedMessageException(findMissingFields(message));
        }

        private static void setField(Message.Builder builder, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (builder != null) {
                builder.setField(fieldDescriptor, obj);
            } else {
                fieldSet.setField(fieldDescriptor, obj);
            }
        }

        private static String subMessagePrefix(String str, Descriptors.FieldDescriptor fieldDescriptor, int i) {
            StringBuilder sb = new StringBuilder(str);
            if (fieldDescriptor.isExtension()) {
                sb.append('(');
                sb.append(fieldDescriptor.getFullName());
                sb.append(')');
            } else {
                sb.append(fieldDescriptor.getName());
            }
            if (i != -1) {
                sb.append('[');
                sb.append(i);
                sb.append(']');
            }
            sb.append(FilenameUtils.EXTENSION_SEPARATOR);
            return sb.toString();
        }

        public BuilderType clear() {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> key : getAllFields().entrySet()) {
                clearField((Descriptors.FieldDescriptor) key.getKey());
            }
            return this;
        }

        public abstract BuilderType clone();

        public List<String> findInitializationErrors() {
            return findMissingFields(this);
        }

        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor fieldDescriptor) {
            throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
        }

        public String getInitializationErrorString() {
            return AbstractMessage.delimitWithCommas(findInitializationErrors());
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(byteString);
        }

        public BuilderType mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(byteString, extensionRegistryLite);
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, (ExtensionRegistryLite) ExtensionRegistry.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readTag;
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder(getUnknownFields());
            do {
                readTag = codedInputStream.readTag();
                if (readTag == 0) {
                    break;
                }
            } while (mergeFieldFrom(codedInputStream, newBuilder, extensionRegistryLite, getDescriptorForType(), this, (FieldSet<Descriptors.FieldDescriptor>) null, readTag));
            setUnknownFields(newBuilder.build());
            return this;
        }

        public BuilderType mergeFrom(Message message) {
            Object obj;
            if (message.getDescriptorForType() != getDescriptorForType()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Map.Entry next : message.getAllFields().entrySet()) {
                Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
                if (fieldDescriptor.isRepeated()) {
                    for (Object addRepeatedField : (List) next.getValue()) {
                        addRepeatedField(fieldDescriptor, addRepeatedField);
                    }
                } else {
                    if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        Message message2 = (Message) getField(fieldDescriptor);
                        if (message2 != message2.getDefaultInstanceForType()) {
                            obj = message2.newBuilderForType().mergeFrom(message2).mergeFrom((Message) next.getValue()).build();
                            setField(fieldDescriptor, obj);
                        }
                    }
                    obj = next.getValue();
                    setField(fieldDescriptor, obj);
                }
            }
            mergeUnknownFields(message.getUnknownFields());
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            return (Builder) super.mergeFrom(inputStream);
        }

        public BuilderType mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Builder) super.mergeFrom(inputStream, extensionRegistryLite);
        }

        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr);
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, i, i2);
        }

        public BuilderType mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        public BuilderType mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mergeFrom(bArr, extensionRegistryLite);
        }

        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFieldSet).build());
            return this;
        }
    }

    /* access modifiers changed from: private */
    public static String delimitWithCommas(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(next);
        }
        return sb.toString();
    }

    protected static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    protected static int hashEnum(Internal.EnumLite enumLite) {
        return enumLite.getNumber();
    }

    protected static int hashEnumList(List<? extends Internal.EnumLite> list) {
        int i = 1;
        for (Internal.EnumLite hashEnum : list) {
            i = (i * 31) + hashEnum(hashEnum);
        }
        return i;
    }

    protected static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return getDescriptorForType() == message.getDescriptorForType() && getAllFields().equals(message.getAllFields()) && getUnknownFields().equals(message.getUnknownFields());
    }

    public List<String> findInitializationErrors() {
        return Builder.findMissingFields(this);
    }

    public String getInitializationErrorString() {
        return delimitWithCommas(findInitializationErrors());
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        boolean messageSetWireFormat = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry next : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
            Object value = next.getValue();
            i2 += (!messageSetWireFormat || !fieldDescriptor.isExtension() || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || fieldDescriptor.isRepeated()) ? FieldSet.computeFieldSize(fieldDescriptor, value) : CodedOutputStream.computeMessageSetExtensionSize(fieldDescriptor.getNumber(), (Message) value);
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        int serializedSizeAsMessageSet = i2 + (messageSetWireFormat ? unknownFields.getSerializedSizeAsMessageSet() : unknownFields.getSerializedSize());
        this.memoizedSize = serializedSizeAsMessageSet;
        return serializedSizeAsMessageSet;
    }

    public int hashCode() {
        return (hashFields(getDescriptorForType().hashCode() + 779, getAllFields()) * 29) + getUnknownFields().hashCode();
    }

    /* access modifiers changed from: protected */
    public int hashFields(int i, Map<Descriptors.FieldDescriptor, Object> map) {
        int i2;
        int hashEnum;
        for (Map.Entry next : map.entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
            Object value = next.getValue();
            int number = (i * 37) + fieldDescriptor.getNumber();
            if (fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                i2 = number * 53;
                hashEnum = value.hashCode();
            } else if (fieldDescriptor.isRepeated()) {
                i2 = number * 53;
                hashEnum = hashEnumList((List) value);
            } else {
                i2 = number * 53;
                hashEnum = hashEnum((Internal.EnumLite) value);
            }
            i = i2 + hashEnum;
        }
        return i;
    }

    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor next : getDescriptorForType().getFields()) {
            if (next.isRequired() && !hasField(next)) {
                return false;
            }
        }
        for (Map.Entry next2 : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next2.getKey();
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.isRepeated()) {
                    for (Message isInitialized : (List) next2.getValue()) {
                        if (!isInitialized.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (!((Message) next2.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return Builder.newUninitializedMessageException(this);
    }

    public final String toString() {
        return TextFormat.printToString((MessageOrBuilder) this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        boolean messageSetWireFormat = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry next : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) next.getKey();
            Object value = next.getValue();
            if (!messageSetWireFormat || !fieldDescriptor.isExtension() || fieldDescriptor.getType() != Descriptors.FieldDescriptor.Type.MESSAGE || fieldDescriptor.isRepeated()) {
                FieldSet.writeField(fieldDescriptor, value, codedOutputStream);
            } else {
                codedOutputStream.writeMessageSetExtension(fieldDescriptor.getNumber(), (Message) value);
            }
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        if (messageSetWireFormat) {
            unknownFields.writeAsMessageSetTo(codedOutputStream);
        } else {
            unknownFields.writeTo(codedOutputStream);
        }
    }
}
